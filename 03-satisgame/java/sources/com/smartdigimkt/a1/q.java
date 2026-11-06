package com.smartdigimkt.a1;

import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {
    public final /* synthetic */ Surface a;
    public final /* synthetic */ s b;

    public q(s sVar, Surface surface) {
        this.b = sVar;
        this.a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b.a(this.a);
    }
}
