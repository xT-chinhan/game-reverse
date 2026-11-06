package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseMediaATView;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 implements View.OnClickListener {
    public final /* synthetic */ BaseMediaATView a;

    public r0(BaseMediaATView baseMediaATView) {
        this.a = baseMediaATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.j1.a aVar;
        com.smartdigimkt.h1.n nVar = this.a.d;
        if (nVar == null || (aVar = ((com.smartdigimkt.h1.m) nVar).b.e) == null) {
            return;
        }
        aVar.onAdClosed();
    }
}
