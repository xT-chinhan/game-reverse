package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements d4 {
    public final /* synthetic */ BaseScreenATView a;

    public s0(BaseScreenATView baseScreenATView) {
        this.a = baseScreenATView;
    }

    @Override // com.smartdigimkt.n1.d4
    public final void a(int i, int i2) {
        this.a.a(i, i2);
    }

    @Override // com.smartdigimkt.n1.d4
    public final boolean a() {
        com.smartdigimkt.c1.g gVar;
        BaseScreenATView baseScreenATView = this.a;
        com.smartdigimkt.x.l lVar = baseScreenATView.j0;
        if ((lVar != null && (gVar = lVar.a) != null && gVar.isShowing()) || !baseScreenATView.U || baseScreenATView.u0) {
            return false;
        }
        this.a.a(4, 5);
        return true;
    }
}
