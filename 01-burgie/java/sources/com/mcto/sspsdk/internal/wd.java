package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class wd implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ yd c;

    public wd(yd ydVar, int i, String str) {
        this.c = ydVar;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.onError(this.a, this.b);
    }
}
