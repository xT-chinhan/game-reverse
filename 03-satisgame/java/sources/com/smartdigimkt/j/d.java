package com.smartdigimkt.j;

import android.content.DialogInterface;
import com.smartdigimkt.dlopt.api.ATApkDialogClickListener;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ ATApkDialogClickListener a;

    public d(ATApkDialogClickListener aTApkDialogClickListener) {
        this.a = aTApkDialogClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ATApkDialogClickListener aTApkDialogClickListener = this.a;
        if (aTApkDialogClickListener != null) {
            aTApkDialogClickListener.onButtonClick(2);
        }
        dialogInterface.dismiss();
    }
}
