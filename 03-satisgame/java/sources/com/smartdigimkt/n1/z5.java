package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.SplashEndCardView;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class z5 implements View.OnClickListener {
    public final /* synthetic */ SplashEndCardView a;

    public z5(SplashEndCardView splashEndCardView) {
        this.a = splashEndCardView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p0 p0Var;
        SplashEndCardView splashEndCardView = this.a;
        com.smartdigimkt.b3.e eVar = splashEndCardView.c;
        if (eVar != null) {
            if (eVar.e == 0) {
                p0 p0Var2 = splashEndCardView.mListener;
                if (p0Var2 != null) {
                    p0Var2.a(22);
                    return;
                }
                return;
            }
            CTAButtonLayout cTAButtonLayout = splashEndCardView.i;
            if (cTAButtonLayout == null || view != cTAButtonLayout || (p0Var = splashEndCardView.mListener) == null) {
                return;
            }
            p0Var.a(22);
        }
    }
}
