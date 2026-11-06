package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 implements View.OnClickListener {
    public final /* synthetic */ BaseSplashATView a;

    public i2(BaseSplashATView baseSplashATView) {
        this.a = baseSplashATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.b3.d dVar;
        BaseSplashATView baseSplashATView = this.a;
        com.smartdigimkt.b3.e eVar = baseSplashATView.b.s;
        if (eVar.k == 0 || baseSplashATView.c0) {
            int i = BaseSplashATView.e0;
            if (baseSplashATView.c != null && (dVar = eVar.R1) != null) {
                long j = dVar.a;
                if (com.smartdigimkt.b3.h.a(1, j) || com.smartdigimkt.b3.h.a(2, j)) {
                    com.smartdigimkt.n3.k.b(1, 59, baseSplashATView.b, baseSplashATView.c, null, false);
                }
            }
            this.a.a(1, true);
        }
    }
}
