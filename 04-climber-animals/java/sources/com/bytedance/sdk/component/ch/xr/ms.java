package com.bytedance.sdk.component.ch.xr;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.le;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private Handler ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final d<xr> f1229ms;
    private Handler xr;

    private ms() {
        this.f1229ms = d.ms(2);
    }

    public static ms ms() {
        return C0246ms.f1232ms;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ch.xr.ms$ms, reason: collision with other inner class name */
    private static class C0246ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final ms f1232ms = new ms();
    }

    public Handler xr() {
        if (this.xr == null) {
            synchronized (ms.class) {
                if (this.xr == null) {
                    this.xr = ms("csj_io_handler");
                }
            }
        }
        return this.xr;
    }

    public Handler ah() {
        if (this.ah == null) {
            synchronized (ms.class) {
                if (this.ah == null) {
                    this.ah = ms("csj_main_handler");
                }
            }
        }
        return this.ah;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final Handler handler, final Handler handler2) {
        if (handler.getLooper().getQueue().isIdle()) {
            handler.removeCallbacksAndMessages(null);
            handler.getLooper().quit();
        } else {
            handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.ch.xr.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.ms(handler, handler2);
                }
            }, 1000L);
        }
    }

    public le ms(le.ms msVar, final String str) {
        xr xrVar = (xr) this.f1229ms.ms();
        if (xrVar != null) {
            xrVar.ms(msVar);
            xrVar.post(new Runnable() { // from class: com.bytedance.sdk.component.ch.xr.ms.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return xrVar;
        }
        return xr(msVar, str);
    }

    public le ms(String str) {
        return ms((le.ms) null, str);
    }

    private xr xr(le.ms msVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new xr(handlerThread, msVar);
    }

    public boolean ms(le leVar) {
        if (!(leVar instanceof xr)) {
            return false;
        }
        xr xrVar = (xr) leVar;
        if (this.f1229ms.ms(xrVar)) {
            return true;
        }
        xrVar.xr();
        return true;
    }
}
