package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements View.OnClickListener {
    public final /* synthetic */ BaseScreenATView a;

    public v0(BaseScreenATView baseScreenATView) {
        this.a = baseScreenATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseScreenATView baseScreenATView = this.a;
        baseScreenATView.a(111);
        baseScreenATView.U = false;
        com.smartdigimkt.u1.d dVar = baseScreenATView.n;
        if (dVar != null) {
            dVar.b();
        }
        if (baseScreenATView.j0 == null) {
            baseScreenATView.j0 = new com.smartdigimkt.x.l();
        }
        baseScreenATView.j0.a(baseScreenATView.getContext(), baseScreenATView.c, baseScreenATView.b, new i1(baseScreenATView));
    }
}
