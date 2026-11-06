package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class l2 implements View.OnClickListener {
    public final /* synthetic */ BaseSplashATView a;

    public l2(BaseSplashATView baseSplashATView) {
        this.a = baseSplashATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseSplashATView baseSplashATView = this.a;
        baseSplashATView.a(111);
        if (baseSplashATView.R == null) {
            baseSplashATView.R = new com.smartdigimkt.x.l();
        }
        baseSplashATView.R.a(baseSplashATView.getContext(), baseSplashATView.c, baseSplashATView.b, new m2(baseSplashATView));
    }
}
