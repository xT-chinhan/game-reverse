package com.bytedance.sdk.component.widget.recycler;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class hi extends RecyclerView.c {
    boolean x = true;

    public abstract boolean ms(RecyclerView.re reVar);

    public abstract boolean ms(RecyclerView.re reVar, int i, int i2, int i3, int i4);

    public abstract boolean ms(RecyclerView.re reVar, RecyclerView.re reVar2, int i, int i2, int i3, int i4);

    public abstract boolean xr(RecyclerView.re reVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public boolean ab(RecyclerView.re reVar) {
        return !this.x || reVar.u();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public boolean ms(RecyclerView.re reVar, RecyclerView.c.xr xrVar, RecyclerView.c.xr xrVar2) {
        int i = xrVar.f1384ms;
        int i2 = xrVar.xr;
        View view = reVar.f1391ms;
        int left = xrVar2 == null ? view.getLeft() : xrVar2.f1384ms;
        int top = xrVar2 == null ? view.getTop() : xrVar2.xr;
        if (reVar.h() || (i == left && i2 == top)) {
            return ms(reVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return ms(reVar, i, i2, left, top);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public boolean xr(RecyclerView.re reVar, RecyclerView.c.xr xrVar, RecyclerView.c.xr xrVar2) {
        return (xrVar == null || (xrVar.f1384ms == xrVar2.f1384ms && xrVar.xr == xrVar2.xr)) ? xr(reVar) : ms(reVar, xrVar.f1384ms, xrVar.xr, xrVar2.f1384ms, xrVar2.xr);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public boolean ah(RecyclerView.re reVar, RecyclerView.c.xr xrVar, RecyclerView.c.xr xrVar2) {
        if (xrVar.f1384ms == xrVar2.f1384ms && xrVar.xr == xrVar2.xr) {
            ny(reVar);
            return false;
        }
        return ms(reVar, xrVar.f1384ms, xrVar.xr, xrVar2.f1384ms, xrVar2.xr);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public boolean ms(RecyclerView.re reVar, RecyclerView.re reVar2, RecyclerView.c.xr xrVar, RecyclerView.c.xr xrVar2) {
        int i;
        int i2;
        int i3 = xrVar.f1384ms;
        int i4 = xrVar.xr;
        if (reVar2.M_()) {
            int i5 = xrVar.f1384ms;
            i2 = xrVar.xr;
            i = i5;
        } else {
            i = xrVar2.f1384ms;
            i2 = xrVar2.xr;
        }
        return ms(reVar, reVar2, i3, i4, i, i2);
    }

    public final void x(RecyclerView.re reVar) {
        c(reVar);
    }

    public final void ny(RecyclerView.re reVar) {
        c(reVar);
    }

    public final void ch(RecyclerView.re reVar) {
        c(reVar);
    }

    public final void ms(RecyclerView.re reVar, boolean z) {
        c(reVar);
    }
}
