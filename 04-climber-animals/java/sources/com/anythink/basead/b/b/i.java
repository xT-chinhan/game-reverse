package com.anythink.basead.b.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a {
    public i(a.C0008a c0008a) {
        super(c0008a);
    }

    @Override // com.anythink.basead.b.b.a, com.anythink.basead.b.b.m
    public final n a() {
        String strAr = this.c != null ? this.c.ar() : "";
        if (TextUtils.isEmpty(strAr)) {
            return n.a(false, "MarketUrlClickAction execute fail with empty url");
        }
        if (this.f != null) {
            this.f.b();
            this.f.a();
        }
        com.anythink.core.basead.a.d dVarB = com.anythink.core.basead.a.e.b(this.b, strAr, this.c, this.d);
        if (dVarB.a() == 0) {
            if (this.e != null) {
                this.e.b();
            }
            if (this.f != null) {
                this.f.c();
            }
            com.anythink.core.common.u.e.a(this.d, this.c, strAr, "1", 2, 0, dVarB.b());
            return n.a(true, "MarketUrlClickAction execute success");
        }
        com.anythink.core.common.u.e.a(this.d, this.c, strAr, "0", 2, 0, dVarB.b());
        return n.a(false, "MarketUrlClickAction execute fail");
    }
}
