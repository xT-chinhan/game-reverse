package com.anythink.basead.b.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class g extends a {
    public g(a.C0008a c0008a) {
        super(c0008a);
    }

    @Override // com.anythink.basead.b.b.a, com.anythink.basead.b.b.m
    public final n a() {
        String strAs = this.c != null ? this.c.as() : "";
        if (TextUtils.isEmpty(strAs)) {
            return n.a(false, "FastUrlClickAction execute fail with empty url");
        }
        if (this.f != null) {
            this.f.b();
            this.f.a();
        }
        if (com.anythink.core.basead.a.e.a(this.b, strAs, this.c, this.d)) {
            if (this.e != null) {
                this.e.b();
            }
            if (this.f != null) {
                this.f.c();
            }
            com.anythink.core.common.u.e.a(this.d, this.c, strAs, "1", 3);
            return n.a(true, "FastUrlClickAction execute success");
        }
        com.anythink.core.common.u.e.a(this.d, this.c, strAs, "0", 3);
        return n.a(false, "FastUrlClickAction execute fail");
    }
}
