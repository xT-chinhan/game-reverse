package com.smartdigimkt.d0;

import com.smartdigimkt.z.e0;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends com.smartdigimkt.k3.d {
    public final boolean k;

    public v(boolean z, com.smartdigimkt.b3.c cVar, String str) {
        super(str);
        this.k = z;
        cVar.getClass();
        cVar.e();
    }

    @Override // com.smartdigimkt.k3.d
    public final boolean a(InputStream inputStream) {
        e0 e0VarA = e0.a();
        String str = this.b;
        e0VarA.getClass();
        if (str == null || inputStream == null) {
            return false;
        }
        return com.smartdigimkt.i3.n.a().a(1, com.smartdigimkt.r4.i.b(str), inputStream);
    }

    @Override // com.smartdigimkt.k3.d
    public final Map b() {
        return null;
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(com.smartdigimkt.k3.c cVar) {
        if (this.k) {
            com.smartdigimkt.q3.f.a().a(cVar, 5);
        } else {
            com.smartdigimkt.q3.f.a().a(cVar, 4);
        }
    }

    @Override // com.smartdigimkt.k3.d
    public final void a() {
        u.a().a(100, this.b);
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(String str) {
        u.a().a(this.b, new com.smartdigimkt.h0.g(com.anythink.core.common.res.image.c.a, str));
    }
}
