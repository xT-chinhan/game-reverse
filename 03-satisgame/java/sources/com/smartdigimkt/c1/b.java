package com.smartdigimkt.c1;

import android.content.DialogInterface;
import com.smartdigimkt.x.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements DialogInterface.OnDismissListener {
    public final /* synthetic */ g a;

    public b(g gVar) {
        this.a = gVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        g gVar = this.a;
        k kVar = gVar.c;
        if (kVar != null) {
            kVar.a();
        }
        gVar.c = null;
        gVar.a = null;
        gVar.b = null;
    }
}
