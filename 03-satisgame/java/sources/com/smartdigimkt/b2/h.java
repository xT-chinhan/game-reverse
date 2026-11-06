package com.smartdigimkt.b2;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ i a;

    public h(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        e eVar = this.a.h;
        if (eVar != null) {
            eVar.a(1, 12);
        }
    }
}
