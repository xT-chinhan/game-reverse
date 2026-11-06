package com.smartdigimkt.c1;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ g a;

    public c(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g gVar = this.a;
        gVar.getClass();
        com.smartdigimkt.q3.f.a().a(30L, new f(gVar));
    }
}
