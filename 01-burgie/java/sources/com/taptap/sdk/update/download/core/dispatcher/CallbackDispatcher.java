package com.taptap.sdk.update.download.core.dispatcher;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.taptap.sdk.update.download.DownloadListener;
import com.taptap.sdk.update.download.DownloadMonitor;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CallbackDispatcher {
    private static final String TAG = "CallbackDispatcher";
    private final DownloadListener transmit;
    private final Handler uiHandler;

    CallbackDispatcher(Handler handler, DownloadListener transmit) {
        this.uiHandler = handler;
        this.transmit = transmit;
    }

    public CallbackDispatcher() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.uiHandler = handler;
        this.transmit = new DefaultTransmitListener(handler);
    }

    public boolean isFetchProcessMoment(DownloadTask task) {
        long minInterval = task.getMinIntervalMillisCallbackProcess();
        long now = SystemClock.uptimeMillis();
        return minInterval <= 0 || now - DownloadTask.TaskHideWrapper.getLastCallbackProcessTs(task) >= minInterval;
    }

    public void endTasksWithError(final Collection<DownloadTask> errorCollection, final Exception realCause) {
        if (errorCollection.size() <= 0) {
            return;
        }
        Util.d(TAG, "endTasksWithError error[" + errorCollection.size() + "] realCause: " + realCause);
        Iterator<DownloadTask> iterator = errorCollection.iterator();
        while (iterator.hasNext()) {
            DownloadTask task = iterator.next();
            if (!task.isAutoCallbackToUIThread()) {
                task.getListener().taskEnd(task, EndCause.ERROR, realCause);
                iterator.remove();
            }
        }
        this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask task2 : errorCollection) {
                    task2.getListener().taskEnd(task2, EndCause.ERROR, realCause);
                }
            }
        });
    }

    public void endTasks(final Collection<DownloadTask> completedTaskCollection, final Collection<DownloadTask> sameTaskConflictCollection, final Collection<DownloadTask> fileBusyCollection) {
        if (completedTaskCollection.size() == 0 && sameTaskConflictCollection.size() == 0 && fileBusyCollection.size() == 0) {
            return;
        }
        Util.d(TAG, "endTasks completed[" + completedTaskCollection.size() + "] sameTask[" + sameTaskConflictCollection.size() + "] fileBusy[" + fileBusyCollection.size() + "]");
        if (completedTaskCollection.size() > 0) {
            Iterator<DownloadTask> iterator = completedTaskCollection.iterator();
            while (iterator.hasNext()) {
                DownloadTask task = iterator.next();
                if (!task.isAutoCallbackToUIThread()) {
                    task.getListener().taskEnd(task, EndCause.COMPLETED, null);
                    iterator.remove();
                }
            }
        }
        if (sameTaskConflictCollection.size() > 0) {
            Iterator<DownloadTask> iterator2 = sameTaskConflictCollection.iterator();
            while (iterator2.hasNext()) {
                DownloadTask task2 = iterator2.next();
                if (!task2.isAutoCallbackToUIThread()) {
                    task2.getListener().taskEnd(task2, EndCause.SAME_TASK_BUSY, null);
                    iterator2.remove();
                }
            }
        }
        if (fileBusyCollection.size() > 0) {
            Iterator<DownloadTask> iterator3 = fileBusyCollection.iterator();
            while (iterator3.hasNext()) {
                DownloadTask task3 = iterator3.next();
                if (!task3.isAutoCallbackToUIThread()) {
                    task3.getListener().taskEnd(task3, EndCause.FILE_BUSY, null);
                    iterator3.remove();
                }
            }
        }
        if (completedTaskCollection.size() == 0 && sameTaskConflictCollection.size() == 0 && fileBusyCollection.size() == 0) {
            return;
        }
        this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.2
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask task4 : completedTaskCollection) {
                    task4.getListener().taskEnd(task4, EndCause.COMPLETED, null);
                }
                for (DownloadTask task5 : sameTaskConflictCollection) {
                    task5.getListener().taskEnd(task5, EndCause.SAME_TASK_BUSY, null);
                }
                for (DownloadTask task6 : fileBusyCollection) {
                    task6.getListener().taskEnd(task6, EndCause.FILE_BUSY, null);
                }
            }
        });
    }

    public void endTasksWithCanceled(final Collection<DownloadTask> canceledCollection) {
        if (canceledCollection.size() <= 0) {
            return;
        }
        Util.d(TAG, "endTasksWithCanceled canceled[" + canceledCollection.size() + "]");
        Iterator<DownloadTask> iterator = canceledCollection.iterator();
        while (iterator.hasNext()) {
            DownloadTask task = iterator.next();
            if (!task.isAutoCallbackToUIThread()) {
                task.getListener().taskEnd(task, EndCause.CANCELED, null);
                iterator.remove();
            }
        }
        this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.3
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask task2 : canceledCollection) {
                    task2.getListener().taskEnd(task2, EndCause.CANCELED, null);
                }
            }
        });
    }

    public DownloadListener dispatch() {
        return this.transmit;
    }

    static class DefaultTransmitListener implements DownloadListener {
        private final Handler uiHandler;

        DefaultTransmitListener(Handler uiHandler) {
            this.uiHandler = uiHandler;
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void taskStart(final DownloadTask task) {
            Util.d(CallbackDispatcher.TAG, "taskStart: " + task.getId());
            inspectTaskStart(task);
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().taskStart(task);
                    }
                });
            } else {
                task.getListener().taskStart(task);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void connectTrialStart(final DownloadTask task, final Map<String, List<String>> headerFields) {
            Util.d(CallbackDispatcher.TAG, "-----> start trial task(" + task.getId() + ") " + headerFields);
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().connectTrialStart(task, headerFields);
                    }
                });
            } else {
                task.getListener().connectTrialStart(task, headerFields);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void connectTrialEnd(final DownloadTask task, final int responseCode, final Map<String, List<String>> headerFields) {
            Util.d(CallbackDispatcher.TAG, "<----- finish trial task(" + task.getId() + ") code[" + responseCode + "]" + headerFields);
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().connectTrialEnd(task, responseCode, headerFields);
                    }
                });
            } else {
                task.getListener().connectTrialEnd(task, responseCode, headerFields);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void downloadFromBeginning(final DownloadTask task, final BreakpointInfo info, final ResumeFailedCause cause) {
            Util.d(CallbackDispatcher.TAG, "downloadFromBeginning: " + task.getId());
            inspectDownloadFromBeginning(task, info, cause);
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().downloadFromBeginning(task, info, cause);
                    }
                });
            } else {
                task.getListener().downloadFromBeginning(task, info, cause);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void downloadFromBreakpoint(final DownloadTask task, final BreakpointInfo info) {
            Util.d(CallbackDispatcher.TAG, "downloadFromBreakpoint: " + task.getId());
            inspectDownloadFromBreakpoint(task, info);
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.5
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().downloadFromBreakpoint(task, info);
                    }
                });
            } else {
                task.getListener().downloadFromBreakpoint(task, info);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void connectStart(final DownloadTask task, final int blockIndex, final Map<String, List<String>> requestHeaderFields) {
            Util.d(CallbackDispatcher.TAG, "-----> start connection task(" + task.getId() + ") block(" + blockIndex + ") " + requestHeaderFields);
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.6
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().connectStart(task, blockIndex, requestHeaderFields);
                    }
                });
            } else {
                task.getListener().connectStart(task, blockIndex, requestHeaderFields);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void connectEnd(final DownloadTask task, final int blockIndex, final int responseCode, final Map<String, List<String>> requestHeaderFields) {
            Util.d(CallbackDispatcher.TAG, "<----- finish connection task(" + task.getId() + ") block(" + blockIndex + ") code[" + responseCode + "]" + requestHeaderFields);
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.7
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().connectEnd(task, blockIndex, responseCode, requestHeaderFields);
                    }
                });
            } else {
                task.getListener().connectEnd(task, blockIndex, responseCode, requestHeaderFields);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void fetchStart(final DownloadTask task, final int blockIndex, final long contentLength) {
            Util.d(CallbackDispatcher.TAG, "fetchStart: " + task.getId());
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.8
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().fetchStart(task, blockIndex, contentLength);
                    }
                });
            } else {
                task.getListener().fetchStart(task, blockIndex, contentLength);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void fetchProgress(final DownloadTask task, final int blockIndex, final long increaseBytes) {
            if (task.getMinIntervalMillisCallbackProcess() > 0) {
                DownloadTask.TaskHideWrapper.setLastCallbackProcessTs(task, SystemClock.uptimeMillis());
            }
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.9
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().fetchProgress(task, blockIndex, increaseBytes);
                    }
                });
            } else {
                task.getListener().fetchProgress(task, blockIndex, increaseBytes);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void fetchEnd(final DownloadTask task, final int blockIndex, final long contentLength) {
            Util.d(CallbackDispatcher.TAG, "fetchEnd: " + task.getId());
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.10
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().fetchEnd(task, blockIndex, contentLength);
                    }
                });
            } else {
                task.getListener().fetchEnd(task, blockIndex, contentLength);
            }
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void taskEnd(final DownloadTask task, final EndCause cause, final Exception realCause) {
            if (cause == EndCause.ERROR) {
                Util.d(CallbackDispatcher.TAG, "taskEnd: " + task.getId() + " " + cause + " " + realCause);
            }
            inspectTaskEnd(task, cause, realCause);
            if (task.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.11
                    @Override // java.lang.Runnable
                    public void run() {
                        task.getListener().taskEnd(task, cause, realCause);
                    }
                });
            } else {
                task.getListener().taskEnd(task, cause, realCause);
            }
        }

        void inspectDownloadFromBreakpoint(DownloadTask task, BreakpointInfo info) {
            DownloadMonitor monitor = OkDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskDownloadFromBreakpoint(task, info);
            }
        }

        void inspectDownloadFromBeginning(DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
            DownloadMonitor monitor = OkDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskDownloadFromBeginning(task, info, cause);
            }
        }

        void inspectTaskStart(DownloadTask task) {
            DownloadMonitor monitor = OkDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskStart(task);
            }
        }

        void inspectTaskEnd(DownloadTask task, EndCause cause, Exception realCause) {
            DownloadMonitor monitor = OkDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskEnd(task, cause, realCause);
            }
        }
    }
}
