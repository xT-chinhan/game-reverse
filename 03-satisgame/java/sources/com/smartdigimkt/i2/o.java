package com.smartdigimkt.i2;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ r a;

    public o(r rVar) {
        this.a = rVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.e2.a aVar = this.a.l;
        if (aVar != null) {
            aVar.a(10, 14);
        }
    }
}
