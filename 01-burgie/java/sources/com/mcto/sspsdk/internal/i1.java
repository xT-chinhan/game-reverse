package com.mcto.sspsdk.internal;

import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 extends ClickableSpan {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public i1(TextView textView, String str, String str2) {
        this.a = textView;
        this.b = str;
        this.c = str2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        try {
            TextView textView = this.a;
            db.a(textView, textView.getContext(), this.b, this.c);
        } catch (Exception e) {
            r9.a("ssp_sdk", "PopWindowWebview error", e);
        }
    }
}
