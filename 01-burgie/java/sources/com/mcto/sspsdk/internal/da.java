package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.component.imageview.QYNiceImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class da implements w3 {
    public final /* synthetic */ QYNiceImageView a;
    public final /* synthetic */ k7 b;
    public final /* synthetic */ ea c;

    public da(ea eaVar, QYNiceImageView qYNiceImageView, k7 k7Var) {
        this.c = eaVar;
        this.a = qYNiceImageView;
        this.b = k7Var;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() != 1) {
            this.b.onError(9, "creative download error:" + num);
            return;
        }
        this.c.e = this.a.a();
        p pVar = this.c.b;
        this.b.a(Boolean.TRUE);
    }
}
