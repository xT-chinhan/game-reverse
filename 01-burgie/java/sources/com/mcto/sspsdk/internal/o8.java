package com.mcto.sspsdk.internal;

import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class o8 extends ld {
    public final /* synthetic */ p8 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o8(p8 p8Var, long j) {
        super(j);
        this.f = p8Var;
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void a(long j) {
        p8 p8Var = this.f;
        y6 y6Var = p8Var.a;
        String strReplace = p8Var.h.replace("%dcd", (j / 1000) + "s后");
        TextView textView = y6Var.d;
        if (textView != null) {
            textView.setText(strReplace);
        }
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void b() {
        this.f.destroy();
    }
}
