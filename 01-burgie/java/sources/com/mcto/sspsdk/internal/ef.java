package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ef implements Runnable {
    public final /* synthetic */ ff a;

    public ef(ff ffVar) {
        this.a = ffVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gf gfVar = this.a.a;
        int i = gf.L;
        gfVar.getClass();
        try {
            if (gfVar.a == 3) {
                int currentPosition = gfVar.s.a.getCurrentPosition();
                p7 p7Var = gfVar.D;
                if (p7Var != null) {
                    p7Var.a(gfVar.B, gfVar.C, currentPosition);
                }
            }
        } catch (Exception e) {
        }
    }
}
