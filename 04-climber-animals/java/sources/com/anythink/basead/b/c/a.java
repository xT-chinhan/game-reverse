package com.anythink.basead.b.c;

import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends com.anythink.core.common.res.image.b {
    private final String a;

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    public a(String str) {
        super(str);
        this.a = getClass().getSimpleName();
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        com.anythink.basead.b.f.a();
        return com.anythink.basead.b.f.a(this.d, inputStream, 3);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.v.b.d dVar) {
        com.anythink.core.common.v.b.b.a().a(dVar, 5);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        String str = this.d;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        e.a().a(this.d, com.anythink.basead.d.g.a(str, str2));
    }
}
