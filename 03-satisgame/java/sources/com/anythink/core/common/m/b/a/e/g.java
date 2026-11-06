package com.anythink.core.common.m.b.a.e;

import com.anythink.core.common.m.b.ab;
import com.anythink.core.common.m.b.ad;
import com.anythink.core.common.m.b.af;
import com.anythink.core.common.m.b.u;
import com.anythink.core.common.m.b.w;
import com.anythink.core.common.m.b.z;
import com.anythink.core.common.m.c.v;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class g implements com.anythink.core.common.m.b.a.c.c {
    private static final String c = "host";
    private final w.a l;
    private final com.anythink.core.common.m.b.a.b.e m;
    private final f n;
    private volatile i o;
    private final ab p;
    private volatile boolean q;
    private static final String b = "connection";
    private static final String d = "keep-alive";
    private static final String e = "proxy-connection";
    private static final String g = "te";
    private static final String f = "transfer-encoding";
    private static final String h = "encoding";
    private static final String i = "upgrade";
    private static final List<String> j = com.anythink.core.common.m.b.a.c.a(b, "host", d, e, g, f, h, i, ":method", ":path", ":scheme", ":authority");
    private static final List<String> k = com.anythink.core.common.m.b.a.c.a(b, "host", d, e, g, f, h, i);

    public g(z zVar, com.anythink.core.common.m.b.a.b.e eVar, w.a aVar, f fVar) {
        ab abVar;
        this.m = eVar;
        this.l = aVar;
        this.n = fVar;
        if (zVar.q().contains(ab.H2_PRIOR_KNOWLEDGE)) {
            abVar = ab.H2_PRIOR_KNOWLEDGE;
        } else {
            abVar = ab.HTTP_2;
        }
        this.p = abVar;
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final com.anythink.core.common.m.b.a.b.e a() {
        return this.m;
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final v a(ad adVar, long j2) {
        return this.o.f();
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final void a(ad adVar) throws IOException {
        if (this.o != null) {
            return;
        }
        boolean z = adVar.d() != null;
        u uVarC = adVar.c();
        ArrayList arrayList = new ArrayList(uVarC.a() + 4);
        arrayList.add(new c(c.h, adVar.b()));
        arrayList.add(new c(c.i, com.anythink.core.common.m.b.a.c.i.a(adVar.a())));
        String strA = adVar.a("Host");
        if (strA != null) {
            arrayList.add(new c(c.k, strA));
        }
        arrayList.add(new c(c.j, adVar.a().b()));
        int iA = uVarC.a();
        for (int i2 = 0; i2 < iA; i2++) {
            String lowerCase = uVarC.a(i2).toLowerCase(Locale.US);
            if (!j.contains(lowerCase) || (lowerCase.equals(g) && uVarC.b(i2).equals("trailers"))) {
                arrayList.add(new c(lowerCase, uVarC.b(i2)));
            }
        }
        this.o = this.n.a(arrayList, z);
        if (this.q) {
            this.o.a(b.CANCEL);
            throw new IOException("Canceled");
        }
        this.o.f.a(this.l.e(), TimeUnit.MILLISECONDS);
        this.o.g.a(this.l.f(), TimeUnit.MILLISECONDS);
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final void b() {
        this.n.r.b();
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final void c() {
        this.o.f().close();
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final af.a a(boolean z) throws ProtocolException {
        u uVarC = this.o.c();
        ab abVar = this.p;
        u.a aVar = new u.a();
        int iA = uVarC.a();
        com.anythink.core.common.m.b.a.c.k kVarA = null;
        for (int i2 = 0; i2 < iA; i2++) {
            String strA = uVarC.a(i2);
            String strB = uVarC.b(i2);
            if (strA.equals(":status")) {
                kVarA = com.anythink.core.common.m.b.a.c.k.a("HTTP/1.1 ".concat(String.valueOf(strB)));
            } else if (!k.contains(strA)) {
                com.anythink.core.common.m.b.a.a.a.a(aVar, strA, strB);
            }
        }
        if (kVarA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        af.a aVarA = new af.a().a(abVar).a(kVarA.e).a(kVarA.f).a(aVar.a());
        if (z && com.anythink.core.common.m.b.a.a.a.a(aVarA) == 100) {
            return null;
        }
        return aVarA;
    }

    private static List<c> b(ad adVar) {
        u uVarC = adVar.c();
        ArrayList arrayList = new ArrayList(uVarC.a() + 4);
        arrayList.add(new c(c.h, adVar.b()));
        arrayList.add(new c(c.i, com.anythink.core.common.m.b.a.c.i.a(adVar.a())));
        String strA = adVar.a("Host");
        if (strA != null) {
            arrayList.add(new c(c.k, strA));
        }
        arrayList.add(new c(c.j, adVar.a().b()));
        int iA = uVarC.a();
        for (int i2 = 0; i2 < iA; i2++) {
            String lowerCase = uVarC.a(i2).toLowerCase(Locale.US);
            if (!j.contains(lowerCase) || (lowerCase.equals(g) && uVarC.b(i2).equals("trailers"))) {
                arrayList.add(new c(lowerCase, uVarC.b(i2)));
            }
        }
        return arrayList;
    }

    private static af.a a(u uVar, ab abVar) throws ProtocolException {
        u.a aVar = new u.a();
        int iA = uVar.a();
        com.anythink.core.common.m.b.a.c.k kVarA = null;
        for (int i2 = 0; i2 < iA; i2++) {
            String strA = uVar.a(i2);
            String strB = uVar.b(i2);
            if (strA.equals(":status")) {
                kVarA = com.anythink.core.common.m.b.a.c.k.a("HTTP/1.1 ".concat(String.valueOf(strB)));
            } else if (!k.contains(strA)) {
                com.anythink.core.common.m.b.a.a.a.a(aVar, strA, strB);
            }
        }
        if (kVarA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new af.a().a(abVar).a(kVarA.e).a(kVarA.f).a(aVar.a());
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final long a(af afVar) {
        return com.anythink.core.common.m.b.a.c.e.a(afVar);
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final com.anythink.core.common.m.c.w b(af afVar) {
        return this.o.e();
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final u d() {
        return this.o.d();
    }

    @Override // com.anythink.core.common.m.b.a.c.c
    public final void e() {
        this.q = true;
        if (this.o != null) {
            this.o.a(b.CANCEL);
        }
    }
}
