package com.efs.sdk.base.core.d;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends Handler {
    public ControllerCenter a;

    abstract void a();

    a() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
