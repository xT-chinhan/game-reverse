package com.anythink.basead.b.c;

import com.anythink.core.common.h.w;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class f extends com.anythink.core.common.res.image.b {
    private String a;
    private boolean b;
    private String c;
    private int k;
    private w l;

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    public f(String str, boolean z, w wVar, String str2) {
        super(str2);
        this.l = wVar;
        this.a = str;
        this.b = z;
        this.c = wVar.v();
        this.k = wVar.b();
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        com.anythink.basead.b.f.a();
        return com.anythink.basead.b.f.a(this.d, inputStream, 1);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.v.b.d dVar) {
        if (this.b) {
            com.anythink.core.common.v.b.b.a().a(dVar, 5);
        } else {
            com.anythink.core.common.v.b.b.a().a(dVar, 4);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        e.a().a(this.d, 100);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        e.a().a(this.d, com.anythink.basead.d.g.a(str, str2));
    }
}
