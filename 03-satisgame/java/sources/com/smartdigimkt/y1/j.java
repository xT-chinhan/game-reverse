package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FingerNewG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ FingerNewG2CV2View a;

    public j(FingerNewG2CV2View fingerNewG2CV2View) {
        this.a = fingerNewG2CV2View;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.b2.e eVar = this.a.e;
        if (eVar != null) {
            eVar.a(11, 47);
        }
    }
}
