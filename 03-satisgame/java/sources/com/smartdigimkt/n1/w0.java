package com.smartdigimkt.n1;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ y0 b;

    public w0(y0 y0Var, ArrayList arrayList) {
        this.b = y0Var;
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f1 f1Var = this.b.a;
        if (f1Var != null) {
            f1Var.a(this.a);
        }
    }
}
