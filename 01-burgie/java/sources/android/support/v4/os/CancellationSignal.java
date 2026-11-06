package android.support.v4.os;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
        void onCancel();
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0051 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cancel() throws java.lang.Throwable {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            boolean r1 = r6.mIsCanceled     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L8
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4d
            return
        L8:
            r1 = 1
            r6.mIsCanceled = r1     // Catch: java.lang.Throwable -> L4d
            r6.mCancelInProgress = r1     // Catch: java.lang.Throwable -> L4d
            android.support.v4.os.CancellationSignal$OnCancelListener r1 = r6.mOnCancelListener     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r0 = r6.mCancellationSignalObj     // Catch: java.lang.Throwable -> L47
            r2 = r0
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L42
            r0 = 0
            if (r1 == 0) goto L1c
            r1.onCancel()     // Catch: java.lang.Throwable -> L1a
            goto L1c
        L1a:
            r3 = move-exception
            goto L2b
        L1c:
            if (r2 == 0) goto L36
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1a
            r4 = 16
            if (r3 < r4) goto L36
            r3 = r2
            android.os.CancellationSignal r3 = (android.os.CancellationSignal) r3     // Catch: java.lang.Throwable -> L1a
            r3.cancel()     // Catch: java.lang.Throwable -> L1a
            goto L36
        L2b:
            monitor-enter(r6)
            r6.mCancelInProgress = r0     // Catch: java.lang.Throwable -> L33
            r6.notifyAll()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r3
        L33:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r0
        L36:
            monitor-enter(r6)
            r6.mCancelInProgress = r0     // Catch: java.lang.Throwable -> L3f
            r6.notifyAll()     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            return
        L3f:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            throw r0
        L42:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L4f
        L47:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r1
            r1 = r5
            goto L4f
        L4d:
            r1 = move-exception
            r2 = r0
        L4f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L51
            throw r1
        L51:
            r1 = move-exception
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.os.CancellationSignal.cancel():void");
    }

    public void setOnCancelListener(OnCancelListener listener) {
        synchronized (this) {
            waitForCancelFinishedLocked();
            if (this.mOnCancelListener == listener) {
                return;
            }
            this.mOnCancelListener = listener;
            if (this.mIsCanceled && listener != null) {
                listener.onCancel();
            }
        }
    }

    public Object getCancellationSignalObject() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.mCancellationSignalObj == null) {
                android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                this.mCancellationSignalObj = cancellationSignal;
                if (this.mIsCanceled) {
                    cancellationSignal.cancel();
                }
            }
            obj = this.mCancellationSignalObj;
        }
        return obj;
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
