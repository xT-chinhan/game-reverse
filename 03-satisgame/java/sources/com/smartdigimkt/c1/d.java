package com.smartdigimkt.c1;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements TextWatcher {
    public final /* synthetic */ g a;

    public d(g gVar) {
        this.a = gVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        g gVar = this.a;
        if (TextUtils.isEmpty(gVar.q) && TextUtils.isEmpty(gVar.e.getText().toString())) {
            gVar.g.setEnabled(false);
        } else {
            gVar.g.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
