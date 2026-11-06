package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;
import com.smartdigimkt.sdk.basead.ui.PanelView;

/* JADX INFO: loaded from: classes3.dex */
public final class x3 implements View.OnClickListener {
    public final /* synthetic */ PanelView a;

    public x3(PanelView panelView) {
        this.a = panelView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        d4 d4Var;
        PanelView panelView = this.a;
        com.smartdigimkt.b3.e eVar = panelView.j;
        if (eVar != null) {
            if (eVar.e == 1) {
                if (view != panelView.f || (d4Var = panelView.h) == null) {
                    return;
                }
                d4Var.a(1, 1);
                return;
            }
            d4 d4Var2 = panelView.h;
            if (d4Var2 != null) {
                if (view == panelView.f) {
                    d4Var2.a(1, 1);
                    return;
                }
                BaseShakeView baseShakeView = panelView.g;
                if (baseShakeView == null || view != baseShakeView) {
                    d4Var2.a(1, 2);
                } else {
                    d4Var2.a(1, 11);
                }
            }
        }
    }
}
