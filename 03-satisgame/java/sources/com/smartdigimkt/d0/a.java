package com.smartdigimkt.d0;

import com.smartdigimkt.z.e0;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.smartdigimkt.k3.d {
    public a(String str) {
        super(str);
    }

    @Override // com.smartdigimkt.k3.d
    public final void a() {
    }

    @Override // com.smartdigimkt.k3.d
    public final boolean a(InputStream inputStream) {
        e0 e0VarA = e0.a();
        String str = this.b;
        e0VarA.getClass();
        if (str == null || inputStream == null) {
            return false;
        }
        return com.smartdigimkt.i3.n.a().a(3, com.smartdigimkt.r4.i.b(str), inputStream);
    }

    @Override // com.smartdigimkt.k3.d
    public final Map b() {
        return null;
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(com.smartdigimkt.k3.c cVar) {
        com.smartdigimkt.q3.f.a().a(cVar, 5);
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(String str) {
        u.a().a(this.b, new com.smartdigimkt.h0.g(com.anythink.core.common.res.image.c.a, str));
    }
}
