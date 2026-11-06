package com.taptap.sdk.update.download.core.download;

import android.os.SystemClock;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.NamedRunnable;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.breakpoint.DownloadStore;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import com.taptap.sdk.update.download.core.file.MultiPointOutputStream;
import com.taptap.sdk.update.download.core.file.ProcessFileStrategy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCall extends NamedRunnable implements Comparable<DownloadCall> {
    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload Block", false));
    static final int MAX_COUNT_RETRY_FOR_PRECONDITION_FAILED = 1;
    private static final String TAG = "DownloadCall";
    public final boolean asyncExecuted;
    final ArrayList<DownloadChain> blockChainList;
    volatile DownloadCache cache;
    volatile boolean canceled;
    volatile Thread currentThread;
    volatile boolean finishing;
    private final DownloadStore store;
    public final DownloadTask task;

    private DownloadCall(DownloadTask task, boolean asyncExecuted, DownloadStore store) {
        this(task, asyncExecuted, new ArrayList(), store);
    }

    DownloadCall(DownloadTask task, boolean asyncExecuted, ArrayList<DownloadChain> runningBlockList, DownloadStore store) {
        super("download call: " + task.getId());
        this.task = task;
        this.asyncExecuted = asyncExecuted;
        this.blockChainList = runningBlockList;
        this.store = store;
    }

    public static DownloadCall create(DownloadTask task, boolean asyncExecuted, DownloadStore store) {
        return new DownloadCall(task, asyncExecuted, store);
    }

    public boolean cancel() {
        synchronized (this) {
            if (this.canceled) {
                return false;
            }
            if (this.finishing) {
                return false;
            }
            this.canceled = true;
            long startCancelTime = SystemClock.uptimeMillis();
            OkDownload.with().downloadDispatcher().flyingCanceled(this);
            DownloadCache cache = this.cache;
            if (cache != null) {
                cache.setUserCanceled();
            }
            Object[] chains = this.blockChainList.toArray();
            if (chains != null && chains.length != 0) {
                for (Object chain : chains) {
                    if (chain instanceof DownloadChain) {
                        ((DownloadChain) chain).cancel();
                    }
                }
            } else if (this.currentThread != null) {
                Util.d(TAG, "interrupt thread with cancel operation because of chains are not running " + this.task.getId());
                this.currentThread.interrupt();
            }
            if (cache != null) {
                cache.getOutputStream().cancelAsync();
            }
            Util.d(TAG, "cancel task " + this.task.getId() + " consume: " + (SystemClock.uptimeMillis() - startCancelTime) + "ms");
            return true;
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isFinishing() {
        return this.finishing;
    }

    @Override // com.taptap.sdk.update.download.core.NamedRunnable
    public void execute() throws InterruptedException {
        EndCause cause;
        BreakpointInfo info;
        int retryCount;
        int retryCount2;
        this.currentThread = Thread.currentThread();
        int retryCount3 = 0;
        OkDownload okDownload = OkDownload.with();
        ProcessFileStrategy fileStrategy = okDownload.processFileStrategy();
        inspectTaskStart();
        while (true) {
            if (this.task.getUrl().length() <= 0) {
                this.cache = new DownloadCache.PreError(new IOException("unexpected url: " + this.task.getUrl()));
                break;
            }
            if (this.canceled) {
                break;
            }
            try {
                BreakpointInfo infoOnStore = this.store.get(this.task.getId());
                if (infoOnStore == null) {
                    info = this.store.createAndInsert(this.task);
                } else {
                    info = infoOnStore;
                }
                setInfoToTask(info);
                if (this.canceled) {
                    break;
                }
                DownloadCache cache = createCache(info);
                this.cache = cache;
                BreakpointRemoteCheck remoteCheck = createRemoteCheck(info);
                try {
                    remoteCheck.check();
                    cache.setRedirectLocation(this.task.getRedirectLocation());
                    fileStrategy.getFileLock().waitForRelease(this.task.getFile().getAbsolutePath());
                    OkDownload.with().downloadStrategy().inspectAnotherSameInfo(this.task, info, remoteCheck.getInstanceLength());
                    try {
                        if (remoteCheck.isResumable()) {
                            BreakpointLocalCheck localCheck = createLocalCheck(info, remoteCheck.getInstanceLength());
                            localCheck.check();
                            if (localCheck.isDirty()) {
                                Util.d(TAG, "breakpoint invalid: download from beginning because of local check is dirty " + this.task.getId() + " " + localCheck);
                                fileStrategy.discardProcess(this.task);
                                assembleBlockAndCallbackFromBeginning(info, remoteCheck, localCheck.getCauseOrThrow());
                            } else {
                                okDownload.callbackDispatcher().dispatch().downloadFromBreakpoint(this.task, info);
                            }
                        } else {
                            Util.d(TAG, "breakpoint invalid: download from beginning because of remote check not resumable " + this.task.getId() + " " + remoteCheck);
                            fileStrategy.discardProcess(this.task);
                            assembleBlockAndCallbackFromBeginning(info, remoteCheck, remoteCheck.getCauseOrThrow());
                        }
                        start(cache, info);
                        if (this.canceled) {
                            break;
                        }
                        if (cache.isPreconditionFailed()) {
                            retryCount = retryCount3 + 1;
                            if (retryCount3 >= 1) {
                                retryCount3 = retryCount;
                                retryCount = retryCount3;
                                retryCount2 = 0;
                            } else {
                                this.store.remove(this.task.getId());
                                retryCount2 = 1;
                            }
                        } else {
                            retryCount = retryCount3;
                            retryCount2 = 0;
                        }
                        if (retryCount2 == 0) {
                            break;
                        } else {
                            retryCount3 = retryCount;
                        }
                    } catch (IOException e) {
                        cache.setUnknownError(e);
                    }
                } catch (IOException e2) {
                    cache.catchException(e2);
                }
            } catch (IOException e3) {
                this.cache = new DownloadCache.PreError(e3);
            }
        }
        this.finishing = true;
        this.blockChainList.clear();
        DownloadCache cache2 = this.cache;
        if (this.canceled || cache2 == null) {
            return;
        }
        Exception realCause = null;
        if (cache2.isServerCanceled() || cache2.isUnknownError() || cache2.isPreconditionFailed()) {
            cause = EndCause.ERROR;
            realCause = cache2.getRealCause();
        } else if (cache2.isFileBusyAfterRun()) {
            cause = EndCause.FILE_BUSY;
        } else if (cache2.isPreAllocateFailed()) {
            cause = EndCause.PRE_ALLOCATE_FAILED;
            realCause = cache2.getRealCause();
        } else {
            cause = EndCause.COMPLETED;
        }
        inspectTaskEnd(cache2, cause, realCause);
    }

    private void inspectTaskStart() {
        this.store.onTaskStart(this.task.getId());
        OkDownload.with().callbackDispatcher().dispatch().taskStart(this.task);
    }

    private void inspectTaskEnd(DownloadCache cache, EndCause cause, Exception realCause) {
        if (cause == EndCause.CANCELED) {
            throw new IllegalAccessError("can't recognize cancelled on here");
        }
        synchronized (this) {
            if (this.canceled) {
                return;
            }
            this.finishing = true;
            this.store.onTaskEnd(this.task.getId(), cause, realCause);
            if (cause == EndCause.COMPLETED) {
                this.store.markFileClear(this.task.getId());
                OkDownload.with().processFileStrategy().completeProcessStream(cache.getOutputStream(), this.task);
            }
            OkDownload.with().callbackDispatcher().dispatch().taskEnd(this.task, cause, realCause);
        }
    }

    DownloadCache createCache(BreakpointInfo info) {
        MultiPointOutputStream outputStream = OkDownload.with().processFileStrategy().createProcessStream(this.task, info, this.store);
        return new DownloadCache(outputStream);
    }

    int getPriority() {
        return this.task.getPriority();
    }

    void start(DownloadCache cache, BreakpointInfo info) throws InterruptedException {
        int blockCount = info.getBlockCount();
        List<DownloadChain> blockChainList = new ArrayList<>(info.getBlockCount());
        List<Integer> blockIndexList = new ArrayList<>();
        for (int i = 0; i < blockCount; i++) {
            BlockInfo blockInfo = info.getBlock(i);
            if (!Util.isCorrectFull(blockInfo.getCurrentOffset(), blockInfo.getContentLength())) {
                Util.resetBlockIfDirty(blockInfo);
                DownloadChain chain = DownloadChain.createChain(i, this.task, info, cache, this.store);
                blockChainList.add(chain);
                blockIndexList.add(Integer.valueOf(chain.getBlockIndex()));
            }
        }
        if (this.canceled) {
            return;
        }
        cache.getOutputStream().setRequireStreamBlocks(blockIndexList);
        startBlocks(blockChainList);
    }

    @Override // com.taptap.sdk.update.download.core.NamedRunnable
    protected void interrupted(InterruptedException e) {
    }

    @Override // com.taptap.sdk.update.download.core.NamedRunnable
    protected void finished() {
        OkDownload.with().downloadDispatcher().finish(this);
        Util.d(TAG, "call is finished " + this.task.getId());
    }

    void startBlocks(List<DownloadChain> tasks) throws InterruptedException {
        ArrayList<Future> futures = new ArrayList<>(tasks.size());
        try {
            for (DownloadChain chain : tasks) {
                futures.add(submitChain(chain));
            }
            this.blockChainList.addAll(tasks);
            for (Future future : futures) {
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    }
                }
            }
            this.blockChainList.removeAll(tasks);
        } catch (Throwable t) {
            try {
                Iterator<Future> it = futures.iterator();
                while (it.hasNext()) {
                    it.next().cancel(true);
                }
                throw t;
            } catch (Throwable t2) {
                this.blockChainList.removeAll(tasks);
                throw t2;
            }
        }
    }

    BreakpointLocalCheck createLocalCheck(BreakpointInfo info, long responseInstanceLength) {
        return new BreakpointLocalCheck(this.task, info, responseInstanceLength);
    }

    BreakpointRemoteCheck createRemoteCheck(BreakpointInfo info) {
        return new BreakpointRemoteCheck(this.task, info);
    }

    void setInfoToTask(BreakpointInfo info) {
        DownloadTask.TaskHideWrapper.setBreakpointInfo(this.task, info);
    }

    void assembleBlockAndCallbackFromBeginning(BreakpointInfo info, BreakpointRemoteCheck remoteCheck, ResumeFailedCause failedCause) {
        Util.assembleBlock(this.task, info, remoteCheck.getInstanceLength(), remoteCheck.isAcceptRange());
        OkDownload.with().callbackDispatcher().dispatch().downloadFromBeginning(this.task, info, failedCause);
    }

    Future<?> submitChain(DownloadChain chain) {
        return EXECUTOR.submit(chain);
    }

    public boolean equalsTask(DownloadTask task) {
        return this.task.equals(task);
    }

    public File getFile() {
        return this.task.getFile();
    }

    @Override // java.lang.Comparable
    public int compareTo(DownloadCall o) {
        return o.getPriority() - getPriority();
    }
}
