package com.byazt.prf;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 113})
public abstract class d extends RecyclerView.w {
    public boolean fs = true;

    public abstract boolean n(RecyclerView.m mVar);

    public abstract boolean n(RecyclerView.m mVar, int i, int i2, int i3, int i4);

    public abstract boolean n(RecyclerView.m mVar, RecyclerView.m mVar2, int i, int i2, int i3, int i4);

    public abstract boolean qg(RecyclerView.m mVar);

    @Override // com.byazt.prf.RecyclerView.w
    public boolean x(RecyclerView.m mVar) {
        return !this.fs || mVar.sz();
    }

    @Override // com.byazt.prf.RecyclerView.w
    public boolean n(RecyclerView.m mVar, RecyclerView.w.qg qgVar, RecyclerView.w.qg qgVar2) {
        int i = qgVar.n;
        int i2 = qgVar.qg;
        View view = mVar.n;
        int left = qgVar2 == null ? view.getLeft() : qgVar2.n;
        int top = qgVar2 == null ? view.getTop() : qgVar2.qg;
        if (mVar.hd() || (i == left && i2 == top)) {
            return n(mVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return n(mVar, i, i2, left, top);
    }

    @Override // com.byazt.prf.RecyclerView.w
    public boolean qg(RecyclerView.m mVar, RecyclerView.w.qg qgVar, RecyclerView.w.qg qgVar2) {
        return (qgVar == null || (qgVar.n == qgVar2.n && qgVar.qg == qgVar2.qg)) ? qg(mVar) : n(mVar, qgVar.n, qgVar.qg, qgVar2.n, qgVar2.qg);
    }

    @Override // com.byazt.prf.RecyclerView.w
    public boolean s(RecyclerView.m mVar, RecyclerView.w.qg qgVar, RecyclerView.w.qg qgVar2) {
        if (qgVar.n == qgVar2.n && qgVar.qg == qgVar2.qg) {
            rv(mVar);
            return false;
        }
        return n(mVar, qgVar.n, qgVar.qg, qgVar2.n, qgVar2.qg);
    }

    @Override // com.byazt.prf.RecyclerView.w
    public boolean n(RecyclerView.m mVar, RecyclerView.m mVar2, RecyclerView.w.qg qgVar, RecyclerView.w.qg qgVar2) {
        int i;
        int i2;
        int i3 = qgVar.n;
        int i4 = qgVar.qg;
        if (mVar2.X_()) {
            int i5 = qgVar.n;
            i2 = qgVar.qg;
            i = i5;
        } else {
            i = qgVar2.n;
            i2 = qgVar2.qg;
        }
        return n(mVar, mVar2, i3, i4, i, i2);
    }

    public final void fs(RecyclerView.m mVar) {
        w(mVar);
    }

    public final void rv(RecyclerView.m mVar) {
        w(mVar);
    }

    public final void tj(RecyclerView.m mVar) {
        w(mVar);
    }

    public final void n(RecyclerView.m mVar, boolean z) {
        w(mVar);
    }
}
