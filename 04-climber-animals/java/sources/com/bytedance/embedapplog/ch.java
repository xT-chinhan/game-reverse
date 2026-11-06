package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
final class ch<SERVICE, RESULT> {
    private final xr<SERVICE, RESULT> ah;
    private final Context d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final CountDownLatch f481ms = new CountDownLatch(1);
    private final Intent xr;

    interface xr<T, RESULT> {
        T ms(IBinder iBinder);

        RESULT ms(T t);
    }

    ch(Context context, Intent intent, xr<SERVICE, RESULT> xrVar) {
        this.d = context;
        this.xr = intent;
        this.ah = xrVar;
    }

    RESULT ms() {
        ch<SERVICE, RESULT>.ms msVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            oh.ah("Don't do this in ui thread.", null);
            return null;
        }
        try {
            msVar = new ms(this.f481ms, this.ah);
            this.d.bindService(this.xr, msVar, 1);
            this.f481ms.await();
            try {
                RESULT resultMs = this.ah.ms(msVar.f482ms);
                ms(msVar);
                return resultMs;
            } catch (Throwable th) {
                th = th;
                try {
                    oh.ms(th);
                    return null;
                } finally {
                    ms(msVar);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            msVar = null;
        }
    }

    private void ms(ch<SERVICE, RESULT>.ms msVar) {
        if (msVar != null) {
            try {
                this.d.unbindService(msVar);
            } catch (Throwable th) {
                oh.ms(th);
            }
        }
    }

    class ms implements ServiceConnection {
        private final CountDownLatch ah;
        private final xr<SERVICE, RESULT> d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        SERVICE f482ms;

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        ms(CountDownLatch countDownLatch, xr<SERVICE, RESULT> xrVar) {
            this.ah = countDownLatch;
            this.d = xrVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            oh.ms("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                this.f482ms = this.d.ms(iBinder);
                try {
                    this.ah.countDown();
                } catch (Exception e) {
                    oh.ms(e);
                }
            } catch (Throwable th) {
                try {
                    oh.ah("ServiceBlockBinder#onServiceConnected", th);
                } finally {
                    try {
                        this.ah.countDown();
                    } catch (Exception e2) {
                        oh.ms(e2);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            oh.ms("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.ah.countDown();
            } catch (Exception e) {
                oh.ms(e);
            }
        }
    }
}
