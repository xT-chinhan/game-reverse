package com.mcto.sspsdk.internal;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public final class h2 implements ViewTreeObserver.OnWindowFocusChangeListener {
    public final /* synthetic */ j2 a;

    public h2(j2 j2Var) {
        this.a = j2Var;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        if (!z || this.a.getWindowVisibility() != 0) {
            this.a.a();
            v3 v3Var = this.a.u;
            if (v3Var != null) {
                v3Var.a();
                return;
            }
            return;
        }
        j2 j2Var = this.a;
        if (j2Var.t.c == 11 || j2Var.a.a == 11) {
            j2Var.c();
            return;
        }
        if (j2Var.u == null) {
            j2Var.u = new v3(j2Var, 0.5f, 200L);
        }
        j2Var.u.a(j2Var.B);
    }
}
