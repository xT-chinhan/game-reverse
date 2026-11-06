package com.mcto.sspsdk.internal;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;

/* JADX INFO: loaded from: classes2.dex */
public final class lf implements DialogInterface.OnClickListener {
    public final /* synthetic */ SslErrorHandler a;
    public final /* synthetic */ nf b;

    public lf(nf nfVar, SslErrorHandler sslErrorHandler) {
        this.b = nfVar;
        this.a = sslErrorHandler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.b.a = true;
        this.a.proceed();
    }
}
