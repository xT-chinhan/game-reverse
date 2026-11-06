package com.mcto.sspsdk.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* JADX INFO: renamed from: com.mcto.sspsdk.internal.if, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class Cif implements DialogInterface.OnClickListener {
    public final /* synthetic */ JsPromptResult a;

    public Cif(JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.cancel();
    }
}
