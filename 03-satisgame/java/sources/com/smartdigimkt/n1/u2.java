package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.FullScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class u2 implements d4 {
    public final /* synthetic */ FullScreenATView a;

    public u2(FullScreenATView fullScreenATView) {
        this.a = fullScreenATView;
    }

    @Override // com.smartdigimkt.n1.d4
    public final void a(int i, int i2) {
        this.a.a(i, i2);
    }

    @Override // com.smartdigimkt.n1.d4
    public final boolean a() {
        com.smartdigimkt.c1.g gVar;
        FullScreenATView fullScreenATView = this.a;
        com.smartdigimkt.x.l lVar = fullScreenATView.j0;
        if ((lVar != null && (gVar = lVar.a) != null && gVar.isShowing()) || !fullScreenATView.U || fullScreenATView.u0) {
            return false;
        }
        this.a.a(4, 5);
        return true;
    }
}
