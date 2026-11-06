package com.anythink.core.common.m.b;

import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable, Flushable {
    private static final int e = 201105;
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    final com.anythink.core.common.m.b.a.a.f a;
    final com.anythink.core.common.m.b.a.a.d b;
    int c;
    int d;
    private int i;
    private int j;
    private int k;

    private c(File file, long j) {
        this(file, j, com.anythink.core.common.m.b.a.f.a.a);
    }

    private c(File file, long j, com.anythink.core.common.m.b.a.f.a aVar) {
        this.a = new com.anythink.core.common.m.b.a.a.f() { // from class: com.anythink.core.common.m.b.c.1
            @Override // com.anythink.core.common.m.b.a.a.f
            public final af a(ad adVar) {
                return c.this.a(adVar);
            }

            @Override // com.anythink.core.common.m.b.a.a.f
            public final com.anythink.core.common.m.b.a.a.b a(af afVar) {
                return c.this.a(afVar);
            }

            @Override // com.anythink.core.common.m.b.a.a.f
            public final void b(ad adVar) {
                c.this.b(adVar);
            }

            @Override // com.anythink.core.common.m.b.a.a.f
            public final void a(af afVar, af afVar2) {
                c.a(afVar, afVar2);
            }

            @Override // com.anythink.core.common.m.b.a.a.f
            public final void a() {
                c.this.a();
            }

            @Override // com.anythink.core.common.m.b.a.a.f
            public final void a(com.anythink.core.common.m.b.a.a.c cVar) {
                c.this.a(cVar);
            }
        };
        this.b = com.anythink.core.common.m.b.a.a.d.a(aVar, file, j);
    }

    private static String a(v vVar) {
        return com.anythink.core.common.m.c.f.a(vVar.toString()).c().g();
    }

    final void b(ad adVar) {
        this.b.c(a(adVar.a));
    }

    static void a(af afVar, af afVar2) {
        com.anythink.core.common.m.b.a.a.d.a aVarA;
        C0038c c0038c = new C0038c(afVar2);
        try {
            aVarA = ((b) afVar.g).a.a();
            if (aVarA != null) {
                try {
                    c0038c.a(aVarA);
                    aVarA.b();
                } catch (IOException unused) {
                    a(aVarA);
                }
            }
        } catch (IOException unused2) {
            aVarA = null;
        }
    }

    private static void a(com.anythink.core.common.m.b.a.a.d.a aVar) {
        if (aVar != null) {
            try {
                aVar.c();
            } catch (IOException unused) {
            }
        }
    }

    private void b() {
        this.b.a();
    }

    private void c() {
        this.b.i();
    }

    private void d() {
        this.b.j();
    }

    private Iterator<String> e() {
        return new Iterator<String>() { // from class: com.anythink.core.common.m.b.c.2
            final Iterator<com.anythink.core.common.m.b.a.a.d.c> a;
            String b;
            boolean c;

            {
                this.a = c.this.b.k();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                if (this.b != null) {
                    return true;
                }
                this.c = false;
                while (this.a.hasNext()) {
                    try {
                        com.anythink.core.common.m.b.a.a.d.c next = this.a.next();
                        try {
                            continue;
                            this.b = com.anythink.core.common.m.c.n.a(next.a(0)).w();
                            if (next != null) {
                                next.close();
                            }
                            return true;
                        } catch (Throwable th) {
                            if (next != null) {
                                try {
                                    next.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused) {
                    }
                }
                return false;
            }

            private String a() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String str = this.b;
                this.b = null;
                this.c = true;
                return str;
            }

            @Override // java.util.Iterator
            public final void remove() {
                if (!this.c) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.a.remove();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String str = this.b;
                this.b = null;
                this.c = true;
                return str;
            }
        };
    }

    private synchronized int f() {
        return this.d;
    }

    private synchronized int g() {
        return this.c;
    }

    private long h() {
        return this.b.e();
    }

    private long i() {
        return this.b.d();
    }

    @Override // java.io.Flushable
    public final void flush() {
        this.b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    private File j() {
        return this.b.c();
    }

    private boolean k() {
        return this.b.g();
    }

    final synchronized void a(com.anythink.core.common.m.b.a.a.c cVar) {
        this.k++;
        if (cVar.a != null) {
            this.i++;
        } else {
            if (cVar.b != null) {
                this.j++;
            }
        }
    }

    final synchronized void a() {
        this.j++;
    }

    private synchronized int l() {
        return this.i;
    }

    private synchronized int m() {
        return this.j;
    }

    private synchronized int n() {
        return this.k;
    }

    private final class a implements com.anythink.core.common.m.b.a.a.b {
        boolean a;
        private final com.anythink.core.common.m.b.a.a.d.a c;
        private com.anythink.core.common.m.c.v d;
        private com.anythink.core.common.m.c.v e;

        a(final com.anythink.core.common.m.b.a.a.d.a aVar) {
            this.c = aVar;
            this.d = aVar.a(1);
            this.e = new com.anythink.core.common.m.c.h(this.d) { // from class: com.anythink.core.common.m.b.c.a.1
                @Override // com.anythink.core.common.m.c.h, com.anythink.core.common.m.c.v, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    synchronized (c.this) {
                        if (a.this.a) {
                            return;
                        }
                        a.this.a = true;
                        c.this.c++;
                        super.close();
                        aVar.b();
                    }
                }
            };
        }

        @Override // com.anythink.core.common.m.b.a.a.b
        public final void a() {
            synchronized (c.this) {
                if (this.a) {
                    return;
                }
                this.a = true;
                c.this.d++;
                com.anythink.core.common.m.b.a.c.a(this.d);
                try {
                    this.c.c();
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.anythink.core.common.m.b.a.a.b
        public final com.anythink.core.common.m.c.v b() {
            return this.e;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.m.b.c$c, reason: collision with other inner class name */
    private static final class C0038c {
        private static final String a;
        private static final String b;
        private final String c;
        private final u d;
        private final String e;
        private final ab f;
        private final int g;
        private final String h;
        private final u i;
        private final t j;
        private final long k;
        private final long l;

        static {
            StringBuilder sb = new StringBuilder();
            com.anythink.core.common.m.b.a.g.c.e();
            a = sb.append(com.anythink.core.common.m.b.a.g.c.f()).append("-Sent-Millis").toString();
            StringBuilder sb2 = new StringBuilder();
            com.anythink.core.common.m.b.a.g.c.e();
            b = sb2.append(com.anythink.core.common.m.b.a.g.c.f()).append("-Received-Millis").toString();
        }

        C0038c(com.anythink.core.common.m.c.w wVar) {
            ai aiVarA;
            try {
                com.anythink.core.common.m.c.e eVarA = com.anythink.core.common.m.c.n.a(wVar);
                this.c = eVarA.w();
                this.e = eVarA.w();
                u.a aVar = new u.a();
                int iA = c.a(eVarA);
                for (int i = 0; i < iA; i++) {
                    aVar.a(eVarA.w());
                }
                this.d = aVar.a();
                com.anythink.core.common.m.b.a.c.k kVarA = com.anythink.core.common.m.b.a.c.k.a(eVarA.w());
                this.f = kVarA.d;
                this.g = kVarA.e;
                this.h = kVarA.f;
                u.a aVar2 = new u.a();
                int iA2 = c.a(eVarA);
                for (int i2 = 0; i2 < iA2; i2++) {
                    aVar2.a(eVarA.w());
                }
                String str = a;
                String strC = aVar2.c(str);
                String str2 = b;
                String strC2 = aVar2.c(str2);
                aVar2.b(str);
                aVar2.b(str2);
                this.k = strC != null ? Long.parseLong(strC) : 0L;
                this.l = strC2 != null ? Long.parseLong(strC2) : 0L;
                this.i = aVar2.a();
                if (a()) {
                    String strW = eVarA.w();
                    if (strW.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strW + "\"");
                    }
                    i iVarA = i.a(eVarA.w());
                    List<Certificate> listA = a(eVarA);
                    List<Certificate> listA2 = a(eVarA);
                    if (!eVarA.g()) {
                        aiVarA = ai.a(eVarA.w());
                    } else {
                        aiVarA = ai.SSL_3_0;
                    }
                    this.j = t.a(aiVarA, iVarA, listA, listA2);
                } else {
                    this.j = null;
                }
                wVar.close();
            } catch (Throwable th) {
                wVar.close();
                throw th;
            }
        }

        C0038c(af afVar) {
            this.c = afVar.a.a.toString();
            this.d = com.anythink.core.common.m.b.a.c.e.c(afVar);
            this.e = afVar.a.b;
            this.f = afVar.b;
            this.g = afVar.c;
            this.h = afVar.d;
            this.i = afVar.f;
            this.j = afVar.e;
            this.k = afVar.k;
            this.l = afVar.l;
        }

        public final void a(com.anythink.core.common.m.b.a.a.d.a aVar) throws IOException {
            com.anythink.core.common.m.c.d dVarA = com.anythink.core.common.m.c.n.a(aVar.a(0));
            dVarA.b(this.c).l(10);
            dVarA.b(this.e).l(10);
            dVarA.o(this.d.a()).l(10);
            int iA = this.d.a();
            for (int i = 0; i < iA; i++) {
                dVarA.b(this.d.a(i)).b(": ").b(this.d.b(i)).l(10);
            }
            dVarA.b(new com.anythink.core.common.m.b.a.c.k(this.f, this.g, this.h).toString()).l(10);
            dVarA.o(this.i.a() + 2).l(10);
            int iA2 = this.i.a();
            for (int i2 = 0; i2 < iA2; i2++) {
                dVarA.b(this.i.a(i2)).b(": ").b(this.i.b(i2)).l(10);
            }
            dVarA.b(a).b(": ").o(this.k).l(10);
            dVarA.b(b).b(": ").o(this.l).l(10);
            if (a()) {
                dVarA.l(10);
                dVarA.b(this.j.b().bq).l(10);
                a(dVarA, this.j.c());
                a(dVarA, this.j.d());
                dVarA.b(this.j.a().f).l(10);
            }
            dVarA.close();
        }

        private boolean a() {
            return this.c.startsWith("https://");
        }

        private static List<Certificate> a(com.anythink.core.common.m.c.e eVar) throws IOException {
            int iA = c.a(eVar);
            if (iA == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iA);
                for (int i = 0; i < iA; i++) {
                    String strW = eVar.w();
                    com.anythink.core.common.m.c.c cVar = new com.anythink.core.common.m.c.c();
                    cVar.d(com.anythink.core.common.m.c.f.b(strW));
                    arrayList.add(certificateFactory.generateCertificate(cVar.i()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private static void a(com.anythink.core.common.m.c.d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.o(list.size()).l(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.b(com.anythink.core.common.m.c.f.a(list.get(i).getEncoded()).b()).l(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean a(ad adVar, af afVar) {
            return this.c.equals(adVar.a.toString()) && this.e.equals(adVar.b) && com.anythink.core.common.m.b.a.c.e.a(afVar, this.d, adVar);
        }

        public final af a(com.anythink.core.common.m.b.a.a.d.c cVar) {
            String strA = this.i.a(com.anythink.core.common.l.b.g);
            String strA2 = this.i.a("Content-Length");
            ad adVarB = new ad.a().a(this.c).a(this.e, (ae) null).a(this.d).b();
            af.a aVar = new af.a();
            aVar.a = adVarB;
            aVar.b = this.f;
            aVar.c = this.g;
            aVar.d = this.h;
            af.a aVarA = aVar.a(this.i);
            aVarA.g = new b(cVar, strA, strA2);
            aVarA.e = this.j;
            aVarA.k = this.k;
            aVarA.l = this.l;
            return aVarA.a();
        }
    }

    static int a(com.anythink.core.common.m.c.e eVar) throws IOException {
        try {
            long jR = eVar.r();
            String strW = eVar.w();
            if (jR < 0 || jR > 2147483647L || !strW.isEmpty()) {
                throw new IOException("expected an int but was \"" + jR + strW + "\"");
            }
            return (int) jR;
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private static class b extends ag {
        final com.anythink.core.common.m.b.a.a.d.c a;
        private final com.anythink.core.common.m.c.e b;
        private final String c;
        private final String d;

        b(final com.anythink.core.common.m.b.a.a.d.c cVar, String str, String str2) {
            this.a = cVar;
            this.c = str;
            this.d = str2;
            this.b = com.anythink.core.common.m.c.n.a(new com.anythink.core.common.m.c.i(cVar.a(1)) { // from class: com.anythink.core.common.m.b.c.b.1
                @Override // com.anythink.core.common.m.c.i, com.anythink.core.common.m.c.w, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    cVar.close();
                    super.close();
                }
            });
        }

        @Override // com.anythink.core.common.m.b.ag
        public final x a() {
            String str = this.c;
            if (str != null) {
                return x.b(str);
            }
            return null;
        }

        @Override // com.anythink.core.common.m.b.ag
        public final long b() {
            try {
                String str = this.d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.anythink.core.common.m.b.ag
        public final com.anythink.core.common.m.c.e c() {
            return this.b;
        }
    }

    final af a(ad adVar) {
        try {
            com.anythink.core.common.m.b.a.a.d.c cVarA = this.b.a(a(adVar.a));
            if (cVarA == null) {
                return null;
            }
            try {
                C0038c c0038c = new C0038c(cVarA.a(0));
                af afVarA = c0038c.a(cVarA);
                if (c0038c.a(adVar, afVarA)) {
                    return afVarA;
                }
                com.anythink.core.common.m.b.a.c.a(afVarA.g);
                return null;
            } catch (IOException unused) {
                com.anythink.core.common.m.b.a.c.a(cVarA);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    final com.anythink.core.common.m.b.a.a.b a(af afVar) {
        com.anythink.core.common.m.b.a.a.d.a aVarB;
        String str = afVar.a.b;
        if (com.anythink.core.common.m.b.a.c.f.a(afVar.a.b)) {
            try {
                b(afVar.a);
            } catch (IOException unused) {
            }
            return null;
        }
        if (!str.equals(TapHttp.METHOD_GET) || com.anythink.core.common.m.b.a.c.e.b(afVar)) {
            return null;
        }
        C0038c c0038c = new C0038c(afVar);
        try {
            aVarB = this.b.b(a(afVar.a.a));
            if (aVarB == null) {
                return null;
            }
            try {
                c0038c.a(aVarB);
                return new a(aVarB);
            } catch (IOException unused2) {
                a(aVarB);
                return null;
            }
        } catch (IOException unused3) {
            aVarB = null;
        }
    }
}
