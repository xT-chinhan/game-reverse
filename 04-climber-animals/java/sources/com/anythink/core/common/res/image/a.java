package com.anythink.core.common.res.image;

import com.anythink.core.common.d.t;
import com.anythink.core.common.res.d;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.o;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b {
    e a;
    InterfaceC0099a b;

    /* JADX INFO: renamed from: com.anythink.core.common.res.image.a$a, reason: collision with other inner class name */
    public interface InterfaceC0099a {
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

    public final void a(InterfaceC0099a interfaceC0099a) {
        this.b = interfaceC0099a;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        return d.a(t.b().g()).a(this.a.g, o.a(this.a.h), inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.v.b.d dVar) {
        com.anythink.core.common.v.b.b.a().a(dVar, 4);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        InterfaceC0099a interfaceC0099a = this.b;
        if (interfaceC0099a != null) {
            interfaceC0099a.a(this.a);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        InterfaceC0099a interfaceC0099a = this.b;
        if (interfaceC0099a != null) {
            interfaceC0099a.a(this.a, str2);
        }
    }
}
