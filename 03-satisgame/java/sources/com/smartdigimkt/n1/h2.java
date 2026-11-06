package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 implements View.OnClickListener {
    public final /* synthetic */ BaseSplashATView a;

    public h2(BaseSplashATView baseSplashATView) {
        this.a = baseSplashATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseSplashATView baseSplashATView = this.a;
        View view2 = baseSplashATView.m;
        if (view2 == null || view2 != view) {
            baseSplashATView.a(1, 2);
        } else {
            baseSplashATView.a(1, 1);
        }
    }
}
