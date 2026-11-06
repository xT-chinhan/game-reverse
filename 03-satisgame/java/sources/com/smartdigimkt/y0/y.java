package com.smartdigimkt.y0;

import com.smartdigimkt.v0.e0;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements Runnable {
    public final x a;

    public y(x xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.v0.i iVar = (com.smartdigimkt.v0.i) this.a;
        for (e0 e0Var : iVar.q) {
            e0Var.d();
        }
        com.smartdigimkt.v0.g gVar = iVar.j;
        if (gVar.c != null) {
            gVar.c = null;
        }
    }
}
