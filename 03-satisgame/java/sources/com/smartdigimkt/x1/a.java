package com.smartdigimkt.x1;

import com.smartdigimkt.n1.j3;
import com.smartdigimkt.sdk.basead.ui.CountDownView;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.smartdigimkt.b2.e {
    public final /* synthetic */ d a;

    public a(d dVar) {
        this.a = dVar;
    }

    @Override // com.smartdigimkt.b2.e
    public final void a(int i, int i2) {
        CountDownView countDownView = this.a.n;
        if (countDownView != null) {
            countDownView.setClickViewAlpha(1.0d);
        }
        if (this.a.b() != null && (this.a.b() instanceof j3)) {
            this.a.b().setClickViewAlpha(1.0d);
        }
        com.smartdigimkt.b2.e eVar = this.a.d;
        if (eVar != null) {
            eVar.a(i, i2);
        }
    }
}
