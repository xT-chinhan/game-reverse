package com.mcto.sspsdk.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* JADX INFO: loaded from: classes2.dex */
public final class hf implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ JsPromptResult b;

    public hf(EditText editText, JsPromptResult jsPromptResult) {
        this.a = editText;
        this.b = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.b.confirm(this.a.getText().toString());
    }
}
