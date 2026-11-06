package com.smartdigimkt.w1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ SecondEndCardView a;

    public r(SecondEndCardView secondEndCardView) {
        this.a = secondEndCardView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.i2.k kVar = this.a.g;
        if (kVar != null) {
            kVar.a(15, 38);
        }
    }
}
