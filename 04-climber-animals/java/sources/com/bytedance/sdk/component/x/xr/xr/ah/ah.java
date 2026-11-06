package com.bytedance.sdk.component.x.xr.xr.ah;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends HandlerThread {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private d f1577ms;

    public ah() {
        super("csj_openlog");
    }

    public void ms(d dVar) {
        this.f1577ms = dVar;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        d dVar = this.f1577ms;
        if (dVar != null) {
            dVar.ah();
        }
    }
}
