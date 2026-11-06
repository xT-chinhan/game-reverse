package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.PanelView;

/* JADX INFO: loaded from: classes3.dex */
public final class w2 implements Runnable {
    public final /* synthetic */ x2 a;

    public w2(x2 x2Var) {
        this.a = x2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*com.smartdigimkt.sdk.basead.ui.BaseScreenATView*/.F();
        PanelView panelView = this.a.b.D0;
        if (panelView != null) {
            panelView.setVisibility(8);
        }
    }
}
