package com.anythink.core.common.res.image;

import com.anythink.core.common.d.s;
import com.anythink.core.common.res.d;
import com.anythink.core.common.res.e;
import com.anythink.core.common.u.n;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b {
    e a;
    InterfaceC0047a b;

    /* JADX INFO: renamed from: com.anythink.core.common.res.image.a$a, reason: collision with other inner class name */
    public interface InterfaceC0047a {
        void a(e eVar);

        void a(e eVar, String str);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    public a(e eVar) {
        super(eVar.h);
        this.a = eVar;
    }

    public final void a(InterfaceC0047a interfaceC0047a) {
        this.b = interfaceC0047a;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        return d.a(s.b().g()).a(this.a.g, n.a(this.a.h), inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bj, runnable));
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        InterfaceC0047a interfaceC0047a = this.b;
        if (interfaceC0047a != null) {
            interfaceC0047a.a(this.a);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str) {
        InterfaceC0047a interfaceC0047a = this.b;
        if (interfaceC0047a != null) {
            interfaceC0047a.a(this.a, str);
        }
    }
}
