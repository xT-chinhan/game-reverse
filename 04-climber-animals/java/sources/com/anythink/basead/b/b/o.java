package com.anythink.basead.b.b;

/* JADX INFO: loaded from: classes.dex */
public final class o extends a {
    public o(a.C0008a c0008a) {
        super(c0008a);
    }

    @Override // com.anythink.basead.b.b.a, com.anythink.basead.b.b.m
    public final n a() {
        if (this.f != null) {
            this.f.b();
            this.f.a();
        }
        if (com.anythink.core.basead.a.e.a(this.c, this.d)) {
            if (this.e != null) {
                this.e.b();
            }
            if (this.f != null) {
                this.f.c();
            }
            return n.a(true, "WXMiniClickAction execute success");
        }
        return n.a(false, "WXMiniClickAction execute fail");
    }
}
