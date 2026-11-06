package com.anythink.basead.b.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class h extends a {
    public h(a.C0008a c0008a) {
        super(c0008a);
    }

    @Override // com.anythink.basead.b.b.a, com.anythink.basead.b.b.m
    public final n a() {
        if (this.e == null) {
            return n.a(false, "JumpUrlClickAction empty mOfferClickReportNotify");
        }
        com.anythink.basead.d.j jVarA = this.e.a();
        if (jVarA == null) {
            return n.a(false, "JumpUrlClickAction empty mOfferClickReportNotify");
        }
        jVarA.k = new com.anythink.basead.d.b();
        com.anythink.basead.d.e eVarB = b();
        jVarA.k.a = eVarB != null ? eVarB.c : "";
        if (!TextUtils.isEmpty(this.c.u())) {
            String strReplaceAll = this.c.u().replaceAll("\\{req_id\\}", this.d.d != null ? this.d.d : "");
            if (com.anythink.core.basead.a.e.a(this.b, strReplaceAll, this.c, this.d)) {
                if (jVarA.i != null) {
                    jVarA.i.i = true;
                }
                if (this.e != null) {
                    this.e.b();
                }
                com.anythink.core.common.u.e.a(this.d, this.c, strReplaceAll, "1", 1);
                if (this.f != null) {
                    this.f.b();
                    this.f.a();
                    this.f.a(true);
                    this.f.c();
                }
                return n.a(true, "JumpUrlClickAction execute success");
            }
            com.anythink.core.common.u.e.a(this.d, this.c, strReplaceAll, "0", 1);
        }
        return n.a(false, "JumpUrlClickAction execute fail");
    }
}
