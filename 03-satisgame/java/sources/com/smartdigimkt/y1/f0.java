package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.HintTextG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ HintTextG2CV2View a;

    public f0(HintTextG2CV2View hintTextG2CV2View) {
        this.a = hintTextG2CV2View;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.b2.e eVar = this.a.e;
        if (eVar != null) {
            eVar.a(11, 18);
        }
    }
}
