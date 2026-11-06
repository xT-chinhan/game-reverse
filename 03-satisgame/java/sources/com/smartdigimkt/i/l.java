package com.smartdigimkt.i;

import android.view.View;
import com.smartdigimkt.dlopt.activity.ApkConfirmDialogActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ ApkConfirmDialogActivity a;

    public l(ApkConfirmDialogActivity apkConfirmDialogActivity) {
        this.a = apkConfirmDialogActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.q3.f.a().c(new k());
        this.a.finish();
    }
}
