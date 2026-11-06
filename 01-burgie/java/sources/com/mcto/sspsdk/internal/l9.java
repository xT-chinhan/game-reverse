package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class l9 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ cg c;

    public l9(int i, long j, cg cgVar) {
        this.a = i;
        this.b = j;
        this.c = cgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StringBuilder sbAppend = new StringBuilder("[iad network] [").append(gj.a()).append("]; code: ").append(this.a).append("; duration: ").append(this.b).append("; ").append(this.c);
        sbAppend.append("\n");
        i9.a.a(sbAppend.toString());
    }
}
