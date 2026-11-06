package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class mg implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ng c;

    public mg(ng ngVar, int i, String str) {
        this.c = ngVar;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.onError(this.a, this.b);
    }
}
