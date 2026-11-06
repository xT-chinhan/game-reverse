package com.mcto.sspsdk.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: classes2.dex */
public final class kf implements DialogInterface.OnClickListener {
    public final /* synthetic */ JsResult a;

    public kf(JsResult jsResult) {
        this.a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.confirm();
    }
}
