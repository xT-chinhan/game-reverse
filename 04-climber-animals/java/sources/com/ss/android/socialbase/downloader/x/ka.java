package com.ss.android.socialbase.downloader.x;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class ka implements Handler.Callback {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile Handler f4799ms = new Handler(ms.f4800ms, this);

    public interface xr {
        long ms();
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final Looper f4800ms;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            f4800ms = handlerThread.getLooper();
        }
    }

    public static Looper ms() {
        return ms.f4800ms;
    }

    public void ms(xr xrVar, long j) {
        Handler handler = this.f4799ms;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = xrVar;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public void xr() {
        Handler handler = this.f4799ms;
        if (handler == null) {
            return;
        }
        this.f4799ms = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            xr xrVar = (xr) message.obj;
            long jMs = xrVar.ms();
            if (jMs <= 0) {
                return true;
            }
            ms(xrVar, jMs);
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            return true;
        }
    }
}
