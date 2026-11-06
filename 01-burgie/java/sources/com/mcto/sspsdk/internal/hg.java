package com.mcto.sspsdk.internal;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public final class hg implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ ig b;

    public hg(ig igVar, Activity activity) {
        this.b = igVar;
        this.a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.e.show(this.a);
    }
}
