package com.smartdigimkt.i;

import android.view.View;
import com.smartdigimkt.dlopt.activity.ApkConfirmDialogActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ com.smartdigimkt.b3.c a;
    public final /* synthetic */ ApkConfirmDialogActivity b;

    public i(ApkConfirmDialogActivity apkConfirmDialogActivity, com.smartdigimkt.b3.c cVar) {
        this.b = apkConfirmDialogActivity;
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.s4.e.a(this.b, this.a.t);
    }
}
