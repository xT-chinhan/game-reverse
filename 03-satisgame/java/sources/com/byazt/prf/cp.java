package com.byazt.prf;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 29})
public class cp {
    public static int n(RecyclerView.py pyVar, rv rvVar, View view, View view2, RecyclerView.rv rvVar2, boolean z, boolean z2) {
        if (rvVar2.py() == 0 || pyVar.l() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (pyVar.l() - Math.max(rvVar2.q(view), rvVar2.q(view2))) - 1) : Math.max(0, Math.min(rvVar2.q(view), rvVar2.q(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(rvVar.qg(view2) - rvVar.n(view)) / (Math.abs(rvVar2.q(view) - rvVar2.q(view2)) + 1))) + (rvVar.s() - rvVar.n(view)));
        }
        return iMax;
    }

    public static int n(RecyclerView.py pyVar, rv rvVar, View view, View view2, RecyclerView.rv rvVar2, boolean z) {
        if (rvVar2.py() == 0 || pyVar.l() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(rvVar2.q(view) - rvVar2.q(view2)) + 1;
        }
        return Math.min(rvVar.w(), rvVar.qg(view2) - rvVar.n(view));
    }

    public static int qg(RecyclerView.py pyVar, rv rvVar, View view, View view2, RecyclerView.rv rvVar2, boolean z) {
        if (rvVar2.py() == 0 || pyVar.l() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return pyVar.l();
        }
        return (int) (((rvVar.qg(view2) - rvVar.n(view)) / (Math.abs(rvVar2.q(view) - rvVar2.q(view2)) + 1)) * pyVar.l());
    }
}
