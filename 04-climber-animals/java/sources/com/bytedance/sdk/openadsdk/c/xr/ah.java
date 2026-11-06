package com.bytedance.sdk.openadsdk.c.xr;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.component.utils.x;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Handler.Callback {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Handler f1860ms;

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public static final ah f1861ms = new ah();
    }

    public static ah ms() {
        return ms.f1861ms;
    }

    private ah() {
        this.f1860ms = new Handler(x.ms().getLooper(), this);
    }

    public void ms(Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = runnable;
        this.f1860ms.sendMessage(messageObtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    public void ms(Runnable runnable, long j) {
        this.f1860ms.postDelayed(runnable, j);
    }
}
