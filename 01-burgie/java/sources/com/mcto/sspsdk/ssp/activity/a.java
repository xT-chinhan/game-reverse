package com.mcto.sspsdk.ssp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ QyDetailPageActivityNew a;

    public a(QyDetailPageActivityNew qyDetailPageActivityNew) {
        this.a = qyDetailPageActivityNew;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a.b.h())));
    }
}
