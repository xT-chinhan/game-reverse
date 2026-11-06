package com.taptap.sdk.update.download.core.file;

import com.taptap.sdk.update.download.core.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public class FileLock {
    private static final String TAG = "FileLock";
    private static final long WAIT_RELEASE_LOCK_NANO = TimeUnit.MILLISECONDS.toNanos(100);
    private final Map<String, AtomicInteger> fileLockCountMap;
    private final Map<String, Thread> waitThreadForFileLockMap;

    FileLock(Map<String, AtomicInteger> fileLockCountMap, Map<String, Thread> waitThreadForFileLockMap) {
        this.fileLockCountMap = fileLockCountMap;
        this.waitThreadForFileLockMap = waitThreadForFileLockMap;
    }

    FileLock() {
        this(new HashMap(), new HashMap());
    }

    public void increaseLock(String path) {
        AtomicInteger lockCount;
        synchronized (this.fileLockCountMap) {
            lockCount = this.fileLockCountMap.get(path);
        }
        if (lockCount == null) {
            AtomicInteger lockCount2 = new AtomicInteger(0);
            synchronized (this.fileLockCountMap) {
                this.fileLockCountMap.put(path, lockCount2);
            }
            lockCount = lockCount2;
        }
        Util.d(TAG, "increaseLock increase lock-count to " + lockCount.incrementAndGet() + path);
    }

    public void decreaseLock(String path) {
        AtomicInteger lockCount;
        Thread lockedThread;
        synchronized (this.fileLockCountMap) {
            lockCount = this.fileLockCountMap.get(path);
        }
        if (lockCount != null && lockCount.decrementAndGet() == 0) {
            Util.d(TAG, "decreaseLock decrease lock-count to 0 " + path);
            synchronized (this.waitThreadForFileLockMap) {
                lockedThread = this.waitThreadForFileLockMap.get(path);
                if (lockedThread != null) {
                    this.waitThreadForFileLockMap.remove(path);
                }
            }
            if (lockedThread != null) {
                Util.d(TAG, "decreaseLock " + path + " unpark locked thread " + lockCount);
                unpark(lockedThread);
            }
            synchronized (this.fileLockCountMap) {
                this.fileLockCountMap.remove(path);
            }
        }
    }

    public void waitForRelease(String filePath) {
        AtomicInteger lockCount;
        synchronized (this.fileLockCountMap) {
            lockCount = this.fileLockCountMap.get(filePath);
        }
        if (lockCount == null || lockCount.get() <= 0) {
            return;
        }
        synchronized (this.waitThreadForFileLockMap) {
            this.waitThreadForFileLockMap.put(filePath, Thread.currentThread());
        }
        Util.d(TAG, "waitForRelease start " + filePath);
        while (!isNotLocked(lockCount)) {
            park();
        }
        Util.d(TAG, "waitForRelease finish " + filePath);
    }

    boolean isNotLocked(AtomicInteger lockCount) {
        return lockCount.get() <= 0;
    }

    void park() {
        LockSupport.park(Long.valueOf(WAIT_RELEASE_LOCK_NANO));
    }

    void unpark(Thread lockedThread) {
        LockSupport.unpark(lockedThread);
    }
}
