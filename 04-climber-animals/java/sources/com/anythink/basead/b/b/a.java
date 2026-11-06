package com.anythink.basead.b.b;

import android.content.Context;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements m {
    final String a = "d";
    Context b;
    w c;
    x d;
    k e;
    b f;
    public IOfferClickHandler g;

    /* JADX INFO: renamed from: com.anythink.basead.b.b.a$a, reason: collision with other inner class name */
    public static class C0008a {
        public Context a;
        public w b;
        public x c;
        public k d;
        public b e;
        public IOfferClickHandler f;
    }

    @Override // com.anythink.basead.b.b.m
    public void c() {
    }

    public a(C0008a c0008a) {
        if (c0008a != null) {
            this.b = c0008a.a;
            this.c = c0008a.b;
            this.d = c0008a.c;
            this.e = c0008a.d;
            this.f = c0008a.e;
            this.g = c0008a.f;
        }
    }

    @Override // com.anythink.basead.b.b.m
    public n a() {
        return n.a(false, "not support");
    }

    @Override // com.anythink.basead.b.b.m
    public n a(String str, e eVar) {
        return n.a(false, "not support");
    }

    protected final com.anythink.basead.d.e b() {
        if (this.c == null) {
            return null;
        }
        return com.anythink.basead.b.d.a().a(this.c.b(), this.c.v());
    }
}
