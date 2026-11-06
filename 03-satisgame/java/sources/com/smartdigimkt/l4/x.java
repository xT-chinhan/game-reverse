package com.smartdigimkt.l4;

import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Runnable {
    public final /* synthetic */ y a;

    public x(y yVar) {
        this.a = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0 b0Var = this.a.a;
        Random random = b0.P;
        synchronized (b0Var) {
            b0Var.c();
            b0Var.m();
        }
    }
}
