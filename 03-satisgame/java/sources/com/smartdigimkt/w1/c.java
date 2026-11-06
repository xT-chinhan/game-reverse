package com.smartdigimkt.w1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RPSecondEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ RPSecondEndCardView a;

    public c(RPSecondEndCardView rPSecondEndCardView) {
        this.a = rPSecondEndCardView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.getClickListener() != null) {
            this.a.getClickListener().a(15, 35);
        }
    }
}
