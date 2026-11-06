package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FingerG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ FingerG2CV2View a;

    public i(FingerG2CV2View fingerG2CV2View) {
        this.a = fingerG2CV2View;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.b2.e eVar = this.a.e;
        if (eVar != null) {
            eVar.a(11, 20);
        }
    }
}
