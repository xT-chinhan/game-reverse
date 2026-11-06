package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class k1 implements View.OnClickListener {
    public final /* synthetic */ BaseSdkSplashATView a;

    public k1(BaseSdkSplashATView baseSdkSplashATView) {
        this.a = baseSdkSplashATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseSdkSplashATView baseSdkSplashATView = this.a;
        com.smartdigimkt.b3.e eVar = baseSdkSplashATView.b.s;
        if (eVar == null || eVar.e != 0) {
            return;
        }
        baseSdkSplashATView.a(1, 3);
    }
}
