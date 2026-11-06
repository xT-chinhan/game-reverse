package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.SplashEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class a6 implements View.OnClickListener {
    public final /* synthetic */ SplashEndCardView a;

    public a6(SplashEndCardView splashEndCardView) {
        this.a = splashEndCardView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p0 p0Var = this.a.mListener;
        if (p0Var instanceof l1) {
            ((l1) p0Var).a.a(1, true);
        }
    }
}
