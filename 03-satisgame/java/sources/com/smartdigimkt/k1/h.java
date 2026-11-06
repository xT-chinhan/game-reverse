package com.smartdigimkt.k1;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ l a;

    public h(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        l lVar = this.a;
        View view2 = lVar.n;
        if (view2 != null && view == view2) {
            lVar.a(1, 1, true);
            return;
        }
        View view3 = lVar.l;
        if (view3 == null || view != view3) {
            lVar.a(1, 2, true);
        } else {
            lVar.a(1, 3, true);
        }
    }
}
