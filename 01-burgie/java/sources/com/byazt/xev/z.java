package com.byazt.xev;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 110})
public final class z<Service, Result> {
    public final hw<Service, Result> hn;
    public final Intent hw;
    public final CountDownLatch pr = new CountDownLatch(1);
    public final Context x;

    interface hw<T, Result> {
        T hw(IBinder iBinder);

        Result pr(T t) throws Exception;
    }

    public z(Context context, Intent intent, hw<Service, Result> hwVar) {
        this.x = context;
        this.hw = intent;
        this.hn = hwVar;
    }

    public Result pr() {
        z<Service, Result>.pr prVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.ec.w.hn("Don't do this in ui thread.", null);
            return null;
        }
        try {
            prVar = new pr(this.pr, this.hn);
            this.x.bindService(this.hw, prVar, 1);
            this.pr.await();
            try {
                Result resultPr = this.hn.pr(prVar.pr);
                pr(prVar);
                return resultPr;
            } catch (Throwable th) {
                th = th;
                try {
                    com.byazt.ec.w.pr(th);
                    return null;
                } finally {
                    pr(prVar);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            prVar = null;
        }
    }

    private void pr(z<Service, Result>.pr prVar) {
        if (prVar != null) {
            try {
                this.x.unbindService(prVar);
            } catch (Throwable th) {
                com.byazt.ec.w.pr(th);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 75, 147})
    class pr implements ServiceConnection {
        public final CountDownLatch hn;
        public Service pr;
        public final hw<Service, Result> x;

        public pr(CountDownLatch countDownLatch, hw<Service, Result> hwVar) {
            this.hn = countDownLatch;
            this.x = hwVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.byazt.ec.w.pr("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                try {
                    this.pr = this.x.hw(iBinder);
                    this.hn.countDown();
                } catch (Throwable th) {
                    try {
                        com.byazt.ec.w.hn("ServiceBlockBinder#onServiceConnected", th);
                        this.hn.countDown();
                    } catch (Throwable th2) {
                        try {
                            this.hn.countDown();
                        } catch (Exception e) {
                            com.byazt.ec.w.pr(e);
                        }
                        throw th2;
                    }
                }
            } catch (Exception e2) {
                com.byazt.ec.w.pr(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.byazt.ec.w.pr("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.hn.countDown();
            } catch (Exception e) {
                com.byazt.ec.w.pr(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }
    }
}
