package com.smartdigimkt.p3;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ n a;

    public j(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        n nVar = this.a;
        if (!nVar.j) {
            nVar.j = true;
            nVar.i.postDelayed(nVar.h, nVar.a);
        }
        return true;
    }
}
