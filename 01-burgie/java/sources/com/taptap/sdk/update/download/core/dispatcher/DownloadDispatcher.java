package com.taptap.sdk.update.download.core.dispatcher;

import android.os.SystemClock;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.StatusUtil;
import com.taptap.sdk.update.download.core.IdentifiedTask;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.DownloadStore;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.download.DownloadCall;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadDispatcher {
    private static final String TAG = "DownloadDispatcher";
    private volatile ExecutorService executorService;
    private final List<DownloadCall> finishingCalls;
    private final AtomicInteger flyingCanceledAsyncCallCount;
    int maxParallelRunningCount;
    private final List<DownloadCall> readyAsyncCalls;
    private final List<DownloadCall> runningAsyncCalls;
    private final List<DownloadCall> runningSyncCalls;
    private final AtomicInteger skipProceedCallCount;
    private DownloadStore store;

    public DownloadDispatcher() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    DownloadDispatcher(List<DownloadCall> readyAsyncCalls, List<DownloadCall> runningAsyncCalls, List<DownloadCall> runningSyncCalls, List<DownloadCall> finishingCalls) {
        this.maxParallelRunningCount = 5;
        this.flyingCanceledAsyncCallCount = new AtomicInteger();
        this.skipProceedCallCount = new AtomicInteger();
        this.readyAsyncCalls = readyAsyncCalls;
        this.runningAsyncCalls = runningAsyncCalls;
        this.runningSyncCalls = runningSyncCalls;
        this.finishingCalls = finishingCalls;
    }

    public void setDownloadStore(DownloadStore store) {
        this.store = store;
    }

    synchronized ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload Download", false));
        }
        return this.executorService;
    }

    public void enqueue(DownloadTask[] tasks) {
        this.skipProceedCallCount.incrementAndGet();
        enqueueLocked(tasks);
        this.skipProceedCallCount.decrementAndGet();
    }

    public void enqueue(DownloadTask task) {
        this.skipProceedCallCount.incrementAndGet();
        enqueueLocked(task);
        this.skipProceedCallCount.decrementAndGet();
    }

    private synchronized void enqueueLocked(DownloadTask[] tasks) {
        long startTime = SystemClock.uptimeMillis();
        Util.d(TAG, "start enqueueLocked for bunch task: " + tasks.length);
        List<DownloadTask> taskList = new ArrayList<>();
        Collections.addAll(taskList, tasks);
        if (taskList.size() > 1) {
            Collections.sort(taskList);
        }
        int originReadyAsyncCallSize = this.readyAsyncCalls.size();
        try {
            OkDownload.with().downloadStrategy().inspectNetworkAvailable();
            Collection<DownloadTask> completedTaskList = new ArrayList<>();
            Collection<DownloadTask> sameTaskConflictList = new ArrayList<>();
            Collection<DownloadTask> fileBusyList = new ArrayList<>();
            for (DownloadTask task : taskList) {
                if (!inspectCompleted(task, completedTaskList) && !inspectForConflict(task, sameTaskConflictList, fileBusyList)) {
                    enqueueIgnorePriority(task);
                }
            }
            OkDownload.with().callbackDispatcher().endTasks(completedTaskList, sameTaskConflictList, fileBusyList);
        } catch (UnknownHostException e) {
            Collection<DownloadTask> errorList = new ArrayList<>(taskList);
            OkDownload.with().callbackDispatcher().endTasksWithError(errorList, e);
        }
        if (originReadyAsyncCallSize != this.readyAsyncCalls.size()) {
            Collections.sort(this.readyAsyncCalls);
        }
        Util.d(TAG, "end enqueueLocked for bunch task: " + tasks.length + " consume " + (SystemClock.uptimeMillis() - startTime) + "ms");
    }

    private synchronized void enqueueLocked(DownloadTask task) {
        Util.d(TAG, "enqueueLocked for single task: " + task);
        if (inspectCompleted(task)) {
            return;
        }
        if (inspectForConflict(task)) {
            return;
        }
        int originReadyAsyncCallSize = this.readyAsyncCalls.size();
        enqueueIgnorePriority(task);
        if (originReadyAsyncCallSize != this.readyAsyncCalls.size()) {
            Collections.sort(this.readyAsyncCalls);
        }
    }

    private synchronized void enqueueIgnorePriority(DownloadTask task) {
        DownloadCall call = DownloadCall.create(task, true, this.store);
        if (runningAsyncSize() < this.maxParallelRunningCount) {
            this.runningAsyncCalls.add(call);
            getExecutorService().execute(call);
        } else {
            this.readyAsyncCalls.add(call);
        }
    }

    public void execute(DownloadTask task) {
        Util.d(TAG, "execute: " + task);
        synchronized (this) {
            if (inspectCompleted(task)) {
                return;
            }
            if (inspectForConflict(task)) {
                return;
            }
            DownloadCall call = DownloadCall.create(task, false, this.store);
            this.runningSyncCalls.add(call);
            syncRunCall(call);
        }
    }

    public void cancelAll() {
        this.skipProceedCallCount.incrementAndGet();
        List<DownloadTask> taskList = new ArrayList<>();
        for (DownloadCall call : this.readyAsyncCalls) {
            taskList.add(call.task);
        }
        for (DownloadCall call2 : this.runningAsyncCalls) {
            taskList.add(call2.task);
        }
        for (DownloadCall call3 : this.runningSyncCalls) {
            taskList.add(call3.task);
        }
        if (!taskList.isEmpty()) {
            DownloadTask[] tasks = new DownloadTask[taskList.size()];
            cancelLocked((IdentifiedTask[]) taskList.toArray(tasks));
        }
        this.skipProceedCallCount.decrementAndGet();
    }

    public void cancel(IdentifiedTask[] tasks) {
        this.skipProceedCallCount.incrementAndGet();
        cancelLocked(tasks);
        this.skipProceedCallCount.decrementAndGet();
        processCalls();
    }

    public boolean cancel(IdentifiedTask task) {
        this.skipProceedCallCount.incrementAndGet();
        boolean result = cancelLocked(task);
        this.skipProceedCallCount.decrementAndGet();
        processCalls();
        return result;
    }

    public boolean cancel(int id) {
        this.skipProceedCallCount.incrementAndGet();
        boolean result = cancelLocked(DownloadTask.mockTaskForCompare(id));
        this.skipProceedCallCount.decrementAndGet();
        processCalls();
        return result;
    }

    private synchronized void cancelLocked(IdentifiedTask[] tasks) {
        long startCancelTime = SystemClock.uptimeMillis();
        Util.d(TAG, "start cancel bunch task manually: " + tasks.length);
        List<DownloadCall> needCallbackCalls = new ArrayList<>();
        List<DownloadCall> needCancelCalls = new ArrayList<>();
        try {
            for (IdentifiedTask task : tasks) {
                try {
                    filterCanceledCalls(task, needCallbackCalls, needCancelCalls);
                } catch (Throwable th) {
                    th = th;
                    handleCanceledCalls(needCallbackCalls, needCancelCalls);
                    Util.d(TAG, "finish cancel bunch task manually: " + tasks.length + " consume " + (SystemClock.uptimeMillis() - startCancelTime) + "ms");
                    throw th;
                }
            }
            handleCanceledCalls(needCallbackCalls, needCancelCalls);
            Util.d(TAG, "finish cancel bunch task manually: " + tasks.length + " consume " + (SystemClock.uptimeMillis() - startCancelTime) + "ms");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    synchronized boolean cancelLocked(IdentifiedTask task) {
        List<DownloadCall> needCallbackCalls;
        List<DownloadCall> needCancelCalls;
        Util.d(TAG, "cancel manually: " + task.getId());
        needCallbackCalls = new ArrayList<>();
        needCancelCalls = new ArrayList<>();
        try {
            filterCanceledCalls(task, needCallbackCalls, needCancelCalls);
            handleCanceledCalls(needCallbackCalls, needCancelCalls);
        } catch (Throwable th) {
            handleCanceledCalls(needCallbackCalls, needCancelCalls);
            throw th;
        }
        return needCallbackCalls.size() > 0 || needCancelCalls.size() > 0;
    }

    private synchronized void filterCanceledCalls(IdentifiedTask task, List<DownloadCall> needCallbackCalls, List<DownloadCall> needCancelCalls) {
        Iterator<DownloadCall> i = this.readyAsyncCalls.iterator();
        while (i.hasNext()) {
            DownloadCall call = i.next();
            if (call.task != task && call.task.getId() != task.getId()) {
            }
            if (!call.isCanceled() && !call.isFinishing()) {
                i.remove();
                needCallbackCalls.add(call);
                return;
            }
            return;
        }
        for (DownloadCall call2 : this.runningAsyncCalls) {
            if (call2.task != task && call2.task.getId() != task.getId()) {
            }
            needCallbackCalls.add(call2);
            needCancelCalls.add(call2);
            return;
        }
        for (DownloadCall call3 : this.runningSyncCalls) {
            if (call3.task != task && call3.task.getId() != task.getId()) {
            }
            needCallbackCalls.add(call3);
            needCancelCalls.add(call3);
            return;
        }
    }

    private synchronized void handleCanceledCalls(List<DownloadCall> needCallbackCalls, List<DownloadCall> needCancelCalls) {
        Util.d(TAG, "handle cancel calls, cancel calls: " + needCancelCalls.size());
        if (!needCancelCalls.isEmpty()) {
            for (DownloadCall call : needCancelCalls) {
                if (!call.cancel()) {
                    needCallbackCalls.remove(call);
                }
            }
        }
        Util.d(TAG, "handle cancel calls, callback cancel event: " + needCallbackCalls.size());
        if (!needCallbackCalls.isEmpty()) {
            if (needCallbackCalls.size() <= 1) {
                DownloadCall call2 = needCallbackCalls.get(0);
                OkDownload.with().callbackDispatcher().dispatch().taskEnd(call2.task, EndCause.CANCELED, null);
            } else {
                List<DownloadTask> callbackCanceledTasks = new ArrayList<>();
                for (DownloadCall call3 : needCallbackCalls) {
                    callbackCanceledTasks.add(call3.task);
                }
                OkDownload.with().callbackDispatcher().endTasksWithCanceled(callbackCanceledTasks);
            }
        }
    }

    public synchronized DownloadTask findSameTask(DownloadTask task) {
        Util.d(TAG, "findSameTask: " + task.getId());
        for (DownloadCall call : this.readyAsyncCalls) {
            if (!call.isCanceled() && call.equalsTask(task)) {
                return call.task;
            }
        }
        for (DownloadCall call2 : this.runningAsyncCalls) {
            if (!call2.isCanceled() && call2.equalsTask(task)) {
                return call2.task;
            }
        }
        for (DownloadCall call3 : this.runningSyncCalls) {
            if (!call3.isCanceled() && call3.equalsTask(task)) {
                return call3.task;
            }
        }
        return null;
    }

    public synchronized boolean isRunning(DownloadTask task) {
        Util.d(TAG, "isRunning: " + task.getId());
        for (DownloadCall call : this.runningSyncCalls) {
            if (!call.isCanceled() && call.equalsTask(task)) {
                return true;
            }
        }
        for (DownloadCall call2 : this.runningAsyncCalls) {
            if (!call2.isCanceled() && call2.equalsTask(task)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isPending(DownloadTask task) {
        Util.d(TAG, "isPending: " + task.getId());
        for (DownloadCall call : this.readyAsyncCalls) {
            if (!call.isCanceled() && call.equalsTask(task)) {
                return true;
            }
        }
        return false;
    }

    void syncRunCall(DownloadCall call) {
        call.run();
    }

    public synchronized void flyingCanceled(DownloadCall call) {
        Util.d(TAG, "flying canceled: " + call.task.getId());
        if (call.asyncExecuted) {
            this.flyingCanceledAsyncCallCount.incrementAndGet();
        }
    }

    public synchronized void finish(DownloadCall call) {
        Collection<DownloadCall> calls;
        boolean asyncExecuted = call.asyncExecuted;
        if (this.finishingCalls.contains(call)) {
            calls = this.finishingCalls;
        } else if (asyncExecuted) {
            calls = this.runningAsyncCalls;
        } else {
            calls = this.runningSyncCalls;
        }
        if (!calls.remove(call)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
        if (asyncExecuted && call.isCanceled()) {
            this.flyingCanceledAsyncCallCount.decrementAndGet();
        }
        if (asyncExecuted) {
            processCalls();
        }
    }

    public synchronized boolean isFileConflictAfterRun(DownloadTask task) {
        File otherFile;
        File otherFile2;
        Util.d(TAG, "is file conflict after run: " + task.getId());
        File file = task.getFile();
        if (file == null) {
            return false;
        }
        for (DownloadCall syncCall : this.runningSyncCalls) {
            if (!syncCall.isCanceled() && syncCall.task != task && (otherFile2 = syncCall.task.getFile()) != null && file.equals(otherFile2)) {
                return true;
            }
        }
        for (DownloadCall asyncCall : this.runningAsyncCalls) {
            if (!asyncCall.isCanceled() && asyncCall.task != task && (otherFile = asyncCall.task.getFile()) != null && file.equals(otherFile)) {
                return true;
            }
        }
        return false;
    }

    private boolean inspectForConflict(DownloadTask task) {
        return inspectForConflict(task, null, null);
    }

    private boolean inspectForConflict(DownloadTask task, Collection<DownloadTask> sameTaskList, Collection<DownloadTask> fileBusyList) {
        return inspectForConflict(task, this.readyAsyncCalls, sameTaskList, fileBusyList) || inspectForConflict(task, this.runningAsyncCalls, sameTaskList, fileBusyList) || inspectForConflict(task, this.runningSyncCalls, sameTaskList, fileBusyList);
    }

    boolean inspectCompleted(DownloadTask task) {
        return inspectCompleted(task, null);
    }

    boolean inspectCompleted(DownloadTask task, Collection<DownloadTask> completedCollection) {
        if (!task.isPassIfAlreadyCompleted() || !StatusUtil.isCompleted(task)) {
            return false;
        }
        if (task.getFilename() == null && !OkDownload.with().downloadStrategy().validFilenameFromStore(task)) {
            return false;
        }
        OkDownload.with().downloadStrategy().validInfoOnCompleted(task, this.store);
        if (completedCollection != null) {
            completedCollection.add(task);
            return true;
        }
        OkDownload.with().callbackDispatcher().dispatch().taskEnd(task, EndCause.COMPLETED, null);
        return true;
    }

    boolean inspectForConflict(DownloadTask task, Collection<DownloadCall> calls, Collection<DownloadTask> sameTaskList, Collection<DownloadTask> fileBusyList) {
        CallbackDispatcher callbackDispatcher = OkDownload.with().callbackDispatcher();
        Iterator<DownloadCall> iterator = calls.iterator();
        while (iterator.hasNext()) {
            DownloadCall call = iterator.next();
            if (!call.isCanceled()) {
                if (call.equalsTask(task)) {
                    if (call.isFinishing()) {
                        Util.d(TAG, "task: " + task.getId() + " is finishing, move it to finishing list");
                        this.finishingCalls.add(call);
                        iterator.remove();
                        return false;
                    }
                    if (sameTaskList != null) {
                        sameTaskList.add(task);
                    } else {
                        callbackDispatcher.dispatch().taskEnd(task, EndCause.SAME_TASK_BUSY, null);
                    }
                    return true;
                }
                File file = call.getFile();
                File taskFile = task.getFile();
                if (file != null && taskFile != null && file.equals(taskFile)) {
                    if (fileBusyList != null) {
                        fileBusyList.add(task);
                    } else {
                        callbackDispatcher.dispatch().taskEnd(task, EndCause.FILE_BUSY, null);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private synchronized void processCalls() {
        if (this.skipProceedCallCount.get() > 0) {
            return;
        }
        if (runningAsyncSize() >= this.maxParallelRunningCount) {
            return;
        }
        if (this.readyAsyncCalls.isEmpty()) {
            return;
        }
        Iterator<DownloadCall> i = this.readyAsyncCalls.iterator();
        while (i.hasNext()) {
            DownloadCall call = i.next();
            i.remove();
            DownloadTask task = call.task;
            if (isFileConflictAfterRun(task)) {
                OkDownload.with().callbackDispatcher().dispatch().taskEnd(task, EndCause.FILE_BUSY, null);
            } else {
                this.runningAsyncCalls.add(call);
                getExecutorService().execute(call);
                if (runningAsyncSize() >= this.maxParallelRunningCount) {
                    return;
                }
            }
        }
    }

    private int runningAsyncSize() {
        return this.runningAsyncCalls.size() - this.flyingCanceledAsyncCallCount.get();
    }

    public static void setMaxParallelRunningCount(int maxParallelRunningCount) {
        DownloadDispatcher dispatcher = OkDownload.with().downloadDispatcher();
        if (dispatcher.getClass() != DownloadDispatcher.class) {
            throw new IllegalStateException("The current dispatcher is " + dispatcher + " not DownloadDispatcher exactly!");
        }
        dispatcher.maxParallelRunningCount = Math.max(1, maxParallelRunningCount);
    }
}
