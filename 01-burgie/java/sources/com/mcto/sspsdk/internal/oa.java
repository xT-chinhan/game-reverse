package com.mcto.sspsdk.internal;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class oa extends TimerTask {
    public final /* synthetic */ pa a;

    public oa(pa paVar) {
        this.a = paVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.a.post(new na(this));
    }
}
