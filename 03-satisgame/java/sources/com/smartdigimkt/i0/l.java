package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ p b;

    public l(p pVar, e0 e0Var) {
        this.b = pVar;
        this.a = e0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            p pVar = this.b;
            e0 e0Var = this.a;
            pVar.getClass();
            p.a(e0Var);
        } catch (g e) {
            throw new RuntimeException(e);
        }
    }
}
