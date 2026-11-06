package com.mcto.sspsdk.internal;

import android.view.View;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.interaction.QySharkView;

/* JADX INFO: loaded from: classes2.dex */
public final class x2 extends td {
    public final boolean b;
    public final /* synthetic */ y2 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2(y2 y2Var, View view, boolean z) {
        super(view);
        this.c = y2Var;
        this.b = z;
    }

    @Override // com.mcto.sspsdk.internal.m7
    public final void a() {
        a4 a4Var = new a4();
        a4Var.b = this.b ? z3.SHAKE_TEMPLATE : z3.SHAKE;
        QySharkView qySharkView = (QySharkView) this.c.i;
        a4Var.a = qySharkView;
        a4Var.e = gj.a(qySharkView);
        b4 b4Var = new b4(a4Var);
        DownloadButtonView downloadButtonView = this.c.d;
        if (downloadButtonView != null) {
            b4Var.a(downloadButtonView.c());
            b4Var.k = this.c.d.a();
        }
        this.c.a(b4Var);
    }
}
