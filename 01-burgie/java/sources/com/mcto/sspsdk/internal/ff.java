package com.mcto.sspsdk.internal;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class ff extends TimerTask {
    public final /* synthetic */ gf a;

    public ff(gf gfVar) {
        this.a = gfVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.a.post(new ef(this));
    }
}
