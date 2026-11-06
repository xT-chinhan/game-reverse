package com.mcto.sspsdk.internal;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public final class wf extends HandlerThread {
    public final /* synthetic */ xf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wf(xf xfVar) {
        super("qy_ssp_remind_thread");
        this.a = xfVar;
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        this.a.c = new vf(this, this.a.d.getLooper());
    }
}
