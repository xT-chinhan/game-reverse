package com.smartdigimkt.h0;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ Dialog a;
    public final /* synthetic */ j b;

    public h(j jVar, Dialog dialog) {
        this.b = jVar;
        this.a = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        j jVar = this.b;
        String str = jVar.c;
        com.smartdigimkt.b3.c cVar = jVar.a;
        com.smartdigimkt.n3.k.a(str, cVar.a, jVar.b, 7, (String) null, 0L, 0L, cVar, 0, 0L);
        try {
            this.a.dismiss();
        } catch (Throwable unused) {
        }
    }
}
