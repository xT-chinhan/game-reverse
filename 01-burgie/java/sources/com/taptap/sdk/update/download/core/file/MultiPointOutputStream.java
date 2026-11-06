package com.taptap.sdk.update.download.core.file;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.breakpoint.DownloadStore;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.exception.PreAllocateException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public class MultiPointOutputStream {
    private static final ExecutorService FILE_IO_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload file io", false));
    private static final String TAG = "MultiPointOutputStream";
    final AtomicLong allNoSyncLength;
    boolean canceled;
    final StreamsState doneState;
    private volatile boolean firstOutputStream;
    private final int flushBufferSize;
    private final BreakpointInfo info;
    private final boolean isPreAllocateLength;
    final AtomicLong lastSyncTimestamp;
    ArrayList<Integer> noMoreStreamList;
    final SparseArray<AtomicLong> noSyncLengthMap;
    final SparseArray<DownloadOutputStream> outputStreamMap;
    final SparseArray<Thread> parkedRunBlockThreadMap;
    private String path;
    List<Integer> requireStreamBlocks;
    volatile Thread runSyncThread;
    StreamsState state;
    private final DownloadStore store;
    private final boolean supportSeek;
    private final int syncBufferIntervalMills;
    private final int syncBufferSize;
    IOException syncException;
    volatile Future syncFuture;
    private final Runnable syncRunnable;
    private final DownloadTask task;

    MultiPointOutputStream(DownloadTask task, BreakpointInfo info, DownloadStore store, Runnable syncRunnable) {
        this.outputStreamMap = new SparseArray<>();
        this.noSyncLengthMap = new SparseArray<>();
        this.allNoSyncLength = new AtomicLong();
        this.lastSyncTimestamp = new AtomicLong();
        this.canceled = false;
        this.parkedRunBlockThreadMap = new SparseArray<>();
        this.doneState = new StreamsState();
        this.state = new StreamsState();
        this.firstOutputStream = true;
        this.task = task;
        this.flushBufferSize = task.getFlushBufferSize();
        this.syncBufferSize = task.getSyncBufferSize();
        this.syncBufferIntervalMills = task.getSyncBufferIntervalMills();
        this.info = info;
        this.store = store;
        this.supportSeek = OkDownload.with().outputStreamFactory().supportSeek();
        this.isPreAllocateLength = OkDownload.with().processFileStrategy().isPreAllocateLength(task);
        this.noMoreStreamList = new ArrayList<>();
        if (syncRunnable == null) {
            this.syncRunnable = new Runnable() { // from class: com.taptap.sdk.update.download.core.file.MultiPointOutputStream.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiPointOutputStream.this.runSyncDelayException();
                }
            };
        } else {
            this.syncRunnable = syncRunnable;
        }
        File file = task.getFile();
        if (file != null) {
            this.path = file.getAbsolutePath();
        }
    }

    public MultiPointOutputStream(DownloadTask task, BreakpointInfo info, DownloadStore store) {
        this(task, info, store, null);
    }

    public synchronized void write(int blockIndex, byte[] bytes, int length) throws IOException {
        if (this.canceled) {
            return;
        }
        outputStream(blockIndex).write(bytes, 0, length);
        this.allNoSyncLength.addAndGet(length);
        this.noSyncLengthMap.get(blockIndex).addAndGet(length);
        inspectAndPersist();
    }

    public void cancelAsync() {
        FILE_IO_EXECUTOR.execute(new Runnable() { // from class: com.taptap.sdk.update.download.core.file.MultiPointOutputStream.2
            @Override // java.lang.Runnable
            public void run() {
                MultiPointOutputStream.this.cancel();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d4 A[Catch: all -> 0x0183, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:12:0x000e, B:17:0x0022, B:18:0x0028, B:20:0x002e, B:21:0x0034, B:24:0x003d, B:26:0x0070, B:40:0x00c8, B:41:0x00ce, B:43:0x00d4, B:44:0x00da, B:47:0x00e3, B:49:0x0116, B:53:0x0127, B:54:0x012d, B:56:0x0133, B:57:0x0139, B:60:0x0142, B:62:0x0175, B:63:0x0182, B:14:0x0016, B:29:0x007f, B:31:0x0083, B:33:0x008b, B:36:0x00a3, B:38:0x00b6, B:39:0x00c7), top: B:67:0x0001, inners: #2, #3, #4, #5 }] */
    public synchronized void cancel() {
        List<Integer> list = this.requireStreamBlocks;
        if (list == null) {
            return;
        }
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        this.noMoreStreamList.addAll(list);
        try {
            if (this.allNoSyncLength.get() > 0) {
                if (this.syncFuture != null && !this.syncFuture.isDone()) {
                    inspectValidPath();
                    OkDownload.with().processFileStrategy().getFileLock().increaseLock(this.path);
                    try {
                        ensureSync(true, -1);
                        OkDownload.with().processFileStrategy().getFileLock().decreaseLock(this.path);
                        while (r1.hasNext()) {
                            close(blockIndex.intValue());
                        }
                        this.store.onTaskEnd(this.task.getId(), EndCause.CANCELED, null);
                        return;
                    } catch (Throwable th) {
                        OkDownload.with().processFileStrategy().getFileLock().decreaseLock(this.path);
                        throw th;
                    }
                }
                for (Integer blockIndex : this.requireStreamBlocks) {
                    try {
                        close(blockIndex.intValue());
                    } catch (IOException e) {
                        Util.d(TAG, "OutputStream close failed task[" + this.task.getId() + "] block[" + blockIndex + "]" + e);
                    }
                }
                this.store.onTaskEnd(this.task.getId(), EndCause.CANCELED, null);
                return;
            }
            for (Integer blockIndex2 : this.requireStreamBlocks) {
                try {
                    close(blockIndex2.intValue());
                } catch (IOException e2) {
                    Util.d(TAG, "OutputStream close failed task[" + this.task.getId() + "] block[" + blockIndex2 + "]" + e2);
                }
            }
            this.store.onTaskEnd(this.task.getId(), EndCause.CANCELED, null);
            return;
        } catch (Throwable th2) {
            for (Integer blockIndex3 : this.requireStreamBlocks) {
                try {
                    close(blockIndex3.intValue());
                } catch (IOException e3) {
                    Util.d(TAG, "OutputStream close failed task[" + this.task.getId() + "] block[" + blockIndex3 + "]" + e3);
                }
            }
            this.store.onTaskEnd(this.task.getId(), EndCause.CANCELED, null);
            throw th2;
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003d A[Catch: all -> 0x00b5, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b5, blocks: (B:4:0x000a, B:6:0x000e, B:18:0x003d, B:22:0x0070, B:26:0x00b4), top: B:33:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0041 A[Catch: all -> 0x003b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003b, blocks: (B:8:0x0012, B:10:0x001a, B:12:0x0024, B:14:0x002e, B:20:0x0041), top: B:35:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0070 A[Catch: all -> 0x00b5, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b5, blocks: (B:4:0x000a, B:6:0x000e, B:18:0x003d, B:22:0x0070, B:26:0x00b4), top: B:33:0x000a }] */
    public synchronized void done(int blockIndex) throws IOException {
        this.noMoreStreamList.add(Integer.valueOf(blockIndex));
        try {
            IOException iOException = this.syncException;
            if (iOException != null) {
                throw iOException;
            }
            if (this.syncFuture == null) {
                if (this.syncFuture == null) {
                    Util.d(TAG, "OutputStream done but no need to ensure sync, because the sync job not run yet. task[" + this.task.getId() + "] block[" + blockIndex + "]");
                } else {
                    Util.d(TAG, "OutputStream done but no need to ensure sync, because the syncFuture.isDone[" + this.syncFuture.isDone() + "] task[" + this.task.getId() + "] block[" + blockIndex + "]");
                }
            } else {
                try {
                    if (!this.syncFuture.isDone()) {
                        AtomicLong noSyncLength = this.noSyncLengthMap.get(blockIndex);
                        if (noSyncLength != null && noSyncLength.get() > 0) {
                            inspectStreamState(this.doneState);
                            boolean isNoMoreStream = this.doneState.isNoMoreStream;
                            ensureSync(isNoMoreStream, blockIndex);
                        }
                    } else if (this.syncFuture == null) {
                        Util.d(TAG, "OutputStream done but no need to ensure sync, because the sync job not run yet. task[" + this.task.getId() + "] block[" + blockIndex + "]");
                    } else {
                        Util.d(TAG, "OutputStream done but no need to ensure sync, because the syncFuture.isDone[" + this.syncFuture.isDone() + "] task[" + this.task.getId() + "] block[" + blockIndex + "]");
                    }
                } catch (Throwable th) {
                    th = th;
                    close(blockIndex);
                    throw th;
                }
            }
            close(blockIndex);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    void ensureSync(boolean isNoMoreStream, int blockIndex) {
        if (this.syncFuture == null || this.syncFuture.isDone()) {
            return;
        }
        if (!isNoMoreStream) {
            this.parkedRunBlockThreadMap.put(blockIndex, Thread.currentThread());
        }
        if (this.runSyncThread != null) {
            unparkThread(this.runSyncThread);
        } else {
            while (!isRunSyncThreadValid()) {
                parkThread(25L);
            }
            unparkThread(this.runSyncThread);
        }
        if (isNoMoreStream) {
            unparkThread(this.runSyncThread);
            try {
                this.syncFuture.get();
                return;
            } catch (InterruptedException e) {
                return;
            } catch (ExecutionException e2) {
                return;
            }
        }
        parkThread();
    }

    boolean isRunSyncThreadValid() {
        return this.runSyncThread != null;
    }

    public void inspectComplete(int blockIndex) throws IOException {
        BlockInfo blockInfo = this.info.getBlock(blockIndex);
        if (!Util.isCorrectFull(blockInfo.getCurrentOffset(), blockInfo.getContentLength())) {
            throw new IOException("The current offset on block-info isn't update correct, " + blockInfo.getCurrentOffset() + " != " + blockInfo.getContentLength() + " on " + blockIndex);
        }
    }

    void inspectAndPersist() throws IOException {
        IOException iOException = this.syncException;
        if (iOException != null) {
            throw iOException;
        }
        if (this.syncFuture == null) {
            synchronized (this.syncRunnable) {
                if (this.syncFuture == null) {
                    this.syncFuture = executeSyncRunnableAsync();
                }
            }
        }
    }

    synchronized void close(int blockIndex) throws IOException {
        DownloadOutputStream outputStream = this.outputStreamMap.get(blockIndex);
        if (outputStream != null) {
            outputStream.close();
            synchronized (this.noSyncLengthMap) {
                this.outputStreamMap.remove(blockIndex);
                this.noSyncLengthMap.remove(blockIndex);
            }
            Util.d(TAG, "OutputStream close task[" + this.task.getId() + "] block[" + blockIndex + "]");
        }
    }

    void parkThread(long milliseconds) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(milliseconds));
    }

    void parkThread() {
        LockSupport.park();
    }

    void unparkThread(Thread thread) {
        LockSupport.unpark(thread);
    }

    Future executeSyncRunnableAsync() {
        return FILE_IO_EXECUTOR.submit(this.syncRunnable);
    }

    void inspectStreamState(StreamsState state) {
        state.newNoMoreStreamBlockList.clear();
        List<Integer> clonedList = (List) this.noMoreStreamList.clone();
        Set<Integer> uniqueBlockList = new HashSet<>(clonedList);
        int noMoreStreamBlockCount = uniqueBlockList.size();
        if (noMoreStreamBlockCount != this.requireStreamBlocks.size()) {
            Util.d(TAG, "task[" + this.task.getId() + "] current need fetching block count " + this.requireStreamBlocks.size() + " is not equal to no more stream block count " + noMoreStreamBlockCount);
            state.isNoMoreStream = false;
        } else {
            Util.d(TAG, "task[" + this.task.getId() + "] current need fetching block count " + this.requireStreamBlocks.size() + " is equal to no more stream block count " + noMoreStreamBlockCount);
            state.isNoMoreStream = true;
        }
        SparseArray<DownloadOutputStream> streamMap = this.outputStreamMap.clone();
        int size = streamMap.size();
        for (int i = 0; i < size; i++) {
            int blockIndex = streamMap.keyAt(i);
            if (this.noMoreStreamList.contains(Integer.valueOf(blockIndex)) && !state.noMoreStreamBlockList.contains(Integer.valueOf(blockIndex))) {
                state.noMoreStreamBlockList.add(Integer.valueOf(blockIndex));
                state.newNoMoreStreamBlockList.add(Integer.valueOf(blockIndex));
            }
        }
    }

    public void setRequireStreamBlocks(List<Integer> requireStreamBlocks) {
        this.requireStreamBlocks = requireStreamBlocks;
    }

    public void catchBlockConnectException(int blockIndex) {
        this.noMoreStreamList.add(Integer.valueOf(blockIndex));
    }

    static class StreamsState {
        boolean isNoMoreStream;
        List<Integer> noMoreStreamBlockList = new ArrayList();
        List<Integer> newNoMoreStreamBlockList = new ArrayList();

        StreamsState() {
        }

        boolean isStreamsEndOrChanged() {
            return this.isNoMoreStream || this.newNoMoreStreamBlockList.size() > 0;
        }
    }

    void runSyncDelayException() {
        try {
            runSync();
        } catch (IOException e) {
            this.syncException = e;
            Util.w(TAG, "Sync to breakpoint-store for task[" + this.task.getId() + "] failed with cause: " + e);
        }
    }

    void runSync() throws IOException {
        Util.d(TAG, "OutputStream start flush looper task[" + this.task.getId() + "] with syncBufferIntervalMills[" + this.syncBufferIntervalMills + "] syncBufferSize[" + this.syncBufferSize + "]");
        this.runSyncThread = Thread.currentThread();
        long nextParkMills = this.syncBufferIntervalMills;
        flushProcess();
        while (true) {
            parkThread(nextParkMills);
            inspectStreamState(this.state);
            if (this.state.isStreamsEndOrChanged()) {
                Util.d(TAG, "runSync state change isNoMoreStream[" + this.state.isNoMoreStream + "] newNoMoreStreamBlockList[" + this.state.newNoMoreStreamBlockList + "]");
                if (this.allNoSyncLength.get() > 0) {
                    flushProcess();
                }
                for (Integer blockIndex : this.state.newNoMoreStreamBlockList) {
                    Thread parkedThread = this.parkedRunBlockThreadMap.get(blockIndex.intValue());
                    this.parkedRunBlockThreadMap.remove(blockIndex.intValue());
                    if (parkedThread != null) {
                        unparkThread(parkedThread);
                    }
                }
                if (this.state.isNoMoreStream) {
                    break;
                }
            } else if (isNoNeedFlushForLength()) {
                nextParkMills = this.syncBufferIntervalMills;
            } else {
                nextParkMills = getNextParkMillisecond();
                if (nextParkMills <= 0) {
                    flushProcess();
                    nextParkMills = this.syncBufferIntervalMills;
                }
            }
        }
        int size = this.parkedRunBlockThreadMap.size();
        for (int i = 0; i < size; i++) {
            Thread parkedThread2 = this.parkedRunBlockThreadMap.valueAt(i);
            if (parkedThread2 != null) {
                unparkThread(parkedThread2);
            }
        }
        this.parkedRunBlockThreadMap.clear();
        Util.d(TAG, "OutputStream stop flush looper task[" + this.task.getId() + "]");
    }

    boolean isNoNeedFlushForLength() {
        return this.allNoSyncLength.get() < ((long) this.syncBufferSize);
    }

    long getNextParkMillisecond() {
        long farToLastSyncMills = now() - this.lastSyncTimestamp.get();
        return ((long) this.syncBufferIntervalMills) - farToLastSyncMills;
    }

    long now() {
        return SystemClock.uptimeMillis();
    }

    void flushProcess() throws IOException {
        int size;
        boolean success;
        synchronized (this.noSyncLengthMap) {
            size = this.noSyncLengthMap.size();
        }
        SparseArray<Long> increaseLengthMap = new SparseArray<>(size);
        for (int i = 0; i < size; i++) {
            try {
                int blockIndex = this.outputStreamMap.keyAt(i);
                long noSyncLength = this.noSyncLengthMap.get(blockIndex).get();
                if (noSyncLength > 0) {
                    increaseLengthMap.put(blockIndex, Long.valueOf(noSyncLength));
                    DownloadOutputStream outputStream = this.outputStreamMap.get(blockIndex);
                    outputStream.flushAndSync();
                }
            } catch (IOException ex) {
                Util.w(TAG, "OutputStream flush and sync data to filesystem failed " + ex);
                success = false;
            }
        }
        success = true;
        if (success) {
            int increaseLengthSize = increaseLengthMap.size();
            long allIncreaseLength = 0;
            for (int i2 = 0; i2 < increaseLengthSize; i2++) {
                int blockIndex2 = increaseLengthMap.keyAt(i2);
                long noSyncLength2 = increaseLengthMap.valueAt(i2).longValue();
                this.store.onSyncToFilesystemSuccess(this.info, blockIndex2, noSyncLength2);
                allIncreaseLength += noSyncLength2;
                this.noSyncLengthMap.get(blockIndex2).addAndGet(-noSyncLength2);
                Util.d(TAG, "OutputStream sync success (" + this.task.getId() + ") block(" + blockIndex2 + ")  syncLength(" + noSyncLength2 + ") currentOffset(" + this.info.getBlock(blockIndex2).getCurrentOffset() + ")");
            }
            this.allNoSyncLength.addAndGet(-allIncreaseLength);
            this.lastSyncTimestamp.set(SystemClock.uptimeMillis());
        }
    }

    synchronized DownloadOutputStream outputStream(int blockIndex) throws IOException {
        DownloadOutputStream outputStream;
        Uri uri;
        outputStream = this.outputStreamMap.get(blockIndex);
        if (outputStream == null) {
            boolean isFileScheme = Util.isUriFileScheme(this.task.getUri());
            if (isFileScheme) {
                File file = this.task.getFile();
                if (file == null) {
                    throw new FileNotFoundException("Filename is not ready!");
                }
                File parentFile = this.task.getParentFile();
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    throw new IOException("Create parent folder failed!");
                }
                if (file.createNewFile()) {
                    Util.d(TAG, "Create new file: " + file.getName());
                }
                uri = Uri.fromFile(file);
            } else {
                uri = this.task.getUri();
            }
            outputStream = OkDownload.with().outputStreamFactory().create(OkDownload.with().context(), uri, this.flushBufferSize);
            if (this.supportSeek) {
                long seekPoint = this.info.getBlock(blockIndex).getRangeLeft();
                if (seekPoint > 0) {
                    outputStream.seek(seekPoint);
                    Util.d(TAG, "Create output stream write from (" + this.task.getId() + ") block(" + blockIndex + ") " + seekPoint);
                }
            }
            if (this.firstOutputStream) {
                this.store.markFileDirty(this.task.getId());
            }
            if (!this.info.isChunked() && this.firstOutputStream && this.isPreAllocateLength) {
                long totalLength = this.info.getTotalLength();
                if (isFileScheme) {
                    File file2 = this.task.getFile();
                    long requireSpace = totalLength - file2.length();
                    if (requireSpace > 0) {
                        inspectFreeSpace(new StatFs(file2.getAbsolutePath()), requireSpace);
                        outputStream.setLength(totalLength);
                    }
                } else {
                    outputStream.setLength(totalLength);
                }
            }
            synchronized (this.noSyncLengthMap) {
                this.outputStreamMap.put(blockIndex, outputStream);
                this.noSyncLengthMap.put(blockIndex, new AtomicLong());
            }
            this.firstOutputStream = false;
        }
        return outputStream;
    }

    void inspectFreeSpace(StatFs statFs, long requireSpace) throws PreAllocateException {
        long freeSpace = Util.getFreeSpaceBytes(statFs);
        if (freeSpace < requireSpace) {
            throw new PreAllocateException(requireSpace, freeSpace);
        }
    }

    private void inspectValidPath() {
        if (this.path != null || this.task.getFile() == null) {
            return;
        }
        this.path = this.task.getFile().getAbsolutePath();
    }
}
