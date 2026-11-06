package com.mcto.sspsdk.internal;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;

/* JADX INFO: loaded from: classes2.dex */
public final class mf implements DialogInterface.OnClickListener {
    public final /* synthetic */ SslErrorHandler a;

    public mf(SslErrorHandler sslErrorHandler) {
        this.a = sslErrorHandler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.cancel();
    }
}
