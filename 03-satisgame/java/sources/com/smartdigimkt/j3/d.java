package com.smartdigimkt.j3;

import com.smartdigimkt.d0.n;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ n a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public d(n nVar, String str, int i, String str2) {
        this.a = nVar;
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.c, this.b, this.d);
    }
}
