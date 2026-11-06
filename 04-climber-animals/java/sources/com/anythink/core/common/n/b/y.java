package com.anythink.core.common.n.b;

import androidx.browser.trusted.sharing.ShareTarget;
import com.umeng.analytics.pro.ek;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class y extends ae {
    public static final x a = x.a("multipart/mixed");
    public static final x b = x.a("multipart/alternative");
    public static final x c = x.a("multipart/digest");
    public static final x d = x.a("multipart/parallel");
    public static final x e = x.a(ShareTarget.ENCODING_TYPE_MULTIPART);
    private static final byte[] f = {58, 32};
    private static final byte[] g = {ek.k, 10};
    private static final byte[] h = {45, 45};
    private final com.anythink.core.common.n.c.f i;
    private final x j;
    private final x k;
    private final List<b> l;
    private long m = -1;

    y(com.anythink.core.common.n.c.f fVar, x xVar, List<b> list) {
        this.i = fVar;
        this.j = xVar;
        this.k = x.a(xVar + "; boundary=" + fVar.a());
        this.l = com.anythink.core.common.n.b.a.c.a(list);
    }

    private x c() {
        return this.j;
    }

    private String d() {
        return this.i.a();
    }

    private int e() {
        return this.l.size();
    }

    private List<b> f() {
        return this.l;
    }

    private b a(int i) {
        return this.l.get(i);
    }

    @Override // com.anythink.core.common.n.b.ae
    public final x a() {
        return this.k;
    }

    @Override // com.anythink.core.common.n.b.ae
    public final long b() {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long jA = a((com.anythink.core.common.n.c.d) null, true);
        this.m = jA;
        return jA;
    }

    @Override // com.anythink.core.common.n.b.ae
    public final void a(com.anythink.core.common.n.c.d dVar) {
        a(dVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(com.anythink.core.common.n.c.d dVar, boolean z) {
        com.anythink.core.common.n.c.c cVar;
        if (z) {
            dVar = new com.anythink.core.common.n.c.c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.l.get(i);
            u uVar = bVar.a;
            ae aeVar = bVar.b;
            dVar.d(h);
            dVar.d(this.i);
            dVar.d(g);
            if (uVar != null) {
                int iA = uVar.a();
                for (int i2 = 0; i2 < iA; i2++) {
                    dVar.b(uVar.a(i2)).d(f).b(uVar.b(i2)).d(g);
                }
            }
            x xVarA = aeVar.a();
            if (xVarA != null) {
                dVar.b("Content-Type: ").b(xVarA.toString()).d(g);
            }
            long jB = aeVar.b();
            if (jB != -1) {
                dVar.b("Content-Length: ").o(jB).d(g);
            } else if (z) {
                cVar.z();
                return -1L;
            }
            byte[] bArr = g;
            dVar.d(bArr);
            if (z) {
                j += jB;
            } else {
                aeVar.a(dVar);
            }
            dVar.d(bArr);
        }
        byte[] bArr2 = h;
        dVar.d(bArr2);
        dVar.d(this.i);
        dVar.d(bArr2);
        dVar.d(g);
        if (!z) {
            return j;
        }
        long jB2 = j + cVar.b();
        cVar.z();
        return jB2;
    }

    static void a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\"');
    }

    public static final class b {
        final u a;
        final ae b;

        private static b a(ae aeVar) {
            return a((u) null, aeVar);
        }

        public static b a(u uVar, ae aeVar) {
            if (aeVar == null) {
                throw new NullPointerException("body == null");
            }
            if (uVar != null && uVar.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (uVar != null && uVar.a("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new b(uVar, aeVar);
        }

        public static b a(String str, String str2, ae aeVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            y.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                y.a(sb, str2);
            }
            return a(new u.a().b("Content-Disposition", sb.toString()).a(), aeVar);
        }

        private b(u uVar, ae aeVar) {
            this.a = uVar;
            this.b = aeVar;
        }

        private u a() {
            return this.a;
        }

        private ae b() {
            return this.b;
        }

        private static b a(String str, String str2) {
            return a(str, null, ae.a((x) null, str2.getBytes(StandardCharsets.UTF_8)));
        }
    }

    public static final class a {
        private final com.anythink.core.common.n.c.f a;
        private x b;
        private final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        private a(String str) {
            this.b = y.a;
            this.c = new ArrayList();
            this.a = com.anythink.core.common.n.c.f.a(str);
        }

        private a a(x xVar) {
            if (xVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!xVar.a().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(xVar)));
            }
            this.b = xVar;
            return this;
        }

        private a a(u uVar, ae aeVar) {
            return a(b.a(uVar, aeVar));
        }

        private a a(String str, String str2, ae aeVar) {
            return a(b.a(str, str2, aeVar));
        }

        private a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.c.add(bVar);
            return this;
        }

        private y a() {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new y(this.a, this.b, this.c);
        }

        private a a(ae aeVar) {
            return a(b.a((u) null, aeVar));
        }

        private a a(String str, String str2) {
            return a(b.a(str, null, ae.a((x) null, str2.getBytes(StandardCharsets.UTF_8))));
        }
    }
}
