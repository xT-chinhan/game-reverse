package com.smartdigimkt.j;

import android.content.DialogInterface;
import com.smartdigimkt.dlopt.api.ATApkDialogClickListener;
import com.smartdigimkt.k.b0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ ATApkDialogClickListener a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.smartdigimkt.k.r c;
    public final /* synthetic */ f d;

    public c(f fVar, ATApkDialogClickListener aTApkDialogClickListener, int i, com.smartdigimkt.k.r rVar) {
        this.d = fVar;
        this.a = aTApkDialogClickListener;
        this.b = i;
        this.c = rVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ATApkDialogClickListener aTApkDialogClickListener = this.a;
        if (aTApkDialogClickListener != null) {
            aTApkDialogClickListener.onButtonClick(1);
        }
        dialogInterface.dismiss();
        int i2 = this.b;
        if (i2 == 2) {
            ((u) this.d.a).b(this.c, 3);
        } else if (i2 == 1) {
            b0 b0Var = this.d.a;
            com.smartdigimkt.k.r rVar = this.c;
            com.smartdigimkt.k.p pVar = ((u) b0Var).q;
            if (pVar != null) {
                pVar.a(rVar, 5);
            }
        }
    }
}
