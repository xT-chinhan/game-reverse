package com.anythink.core.common.m.b;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final g a = new a().a();
    private final Set<b> b;
    private final com.anythink.core.common.m.b.a.j.c c;

    g(Set<b> set, com.anythink.core.common.m.b.a.j.c cVar) {
        this.b = set;
        this.c = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Objects.equals(this.c, gVar.c) && this.b.equals(gVar.b);
    }

    public final int hashCode() {
        return (Objects.hashCode(this.c) * 31) + this.b.hashCode();
    }

    private void a(String str, Certificate... certificateArr) {
        a(str, Arrays.asList(certificateArr));
    }

    private List<b> a(String str) {
        boolean zEquals;
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.b) {
            if (bVar.a.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                zEquals = true;
                if ((str.length() - iIndexOf) - 1 != bVar.b.length() || !str.regionMatches(false, iIndexOf + 1, bVar.b, 0, bVar.b.length())) {
                    zEquals = false;
                }
            } else {
                zEquals = str.equals(bVar.b);
            }
            if (zEquals) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    final g a(com.anythink.core.common.m.b.a.j.c cVar) {
        return Objects.equals(this.c, cVar) ? this : new g(this.b, cVar);
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + b((X509Certificate) certificate).b();
    }

    private static com.anythink.core.common.m.c.f a(X509Certificate x509Certificate) {
        return com.anythink.core.common.m.c.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    private static com.anythink.core.common.m.c.f b(X509Certificate x509Certificate) {
        return com.anythink.core.common.m.c.f.a(x509Certificate.getPublicKey().getEncoded()).e();
    }

    static final class b {
        private static final String e = "*.";
        final String a;
        final String b;
        final String c;
        final com.anythink.core.common.m.c.f d;

        b(String str, String str2) {
            String str3;
            this.a = str;
            if (str.startsWith(e)) {
                str3 = v.e("http://" + str.substring(2)).m;
            } else {
                str3 = v.e("http://".concat(String.valueOf(str))).m;
            }
            this.b = str3;
            if (str2.startsWith("sha1/")) {
                this.c = "sha1/";
                this.d = com.anythink.core.common.m.c.f.b(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.c = "sha256/";
                this.d = com.anythink.core.common.m.c.f.b(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(String.valueOf(str2)));
            }
            if (this.d == null) {
                throw new IllegalArgumentException("pins must be base64: ".concat(String.valueOf(str2)));
            }
        }

        private boolean a(String str) {
            if (this.a.startsWith(e)) {
                int iIndexOf = str.indexOf(46);
                if ((str.length() - iIndexOf) - 1 != this.b.length()) {
                    return false;
                }
                String str2 = this.b;
                return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
            }
            return str.equals(this.b);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.equals(bVar.a) && this.c.equals(bVar.c) && this.d.equals(bVar.d);
        }

        public final int hashCode() {
            return ((((this.a.hashCode() + 527) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return this.c + this.d.b();
        }
    }

    public static final class a {
        private final List<b> a = new ArrayList();

        private a a(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String str2 : strArr) {
                this.a.add(new b(str, str2));
            }
            return this;
        }

        public final g a() {
            return new g(new LinkedHashSet(this.a), null);
        }
    }

    public final void a(String str, List<Certificate> list) {
        int i;
        List listEmptyList = Collections.emptyList();
        Iterator<b> it = this.b.iterator();
        List arrayList = listEmptyList;
        while (true) {
            zEquals = false;
            boolean zEquals = false;
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next.a.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                if ((str.length() - iIndexOf) - 1 == next.b.length() && str.regionMatches(false, iIndexOf + 1, next.b, 0, next.b.length())) {
                    zEquals = true;
                }
            } else {
                zEquals = str.equals(next.b);
            }
            if (zEquals) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        com.anythink.core.common.m.b.a.j.c cVar = this.c;
        List<Certificate> listA = cVar != null ? cVar.a(list, str) : list;
        int size = listA.size();
        for (int i2 = 0; i2 < size; i2++) {
            X509Certificate x509Certificate = (X509Certificate) listA.get(i2);
            int size2 = arrayList.size();
            com.anythink.core.common.m.c.f fVarB = null;
            com.anythink.core.common.m.c.f fVarD = null;
            for (int i3 = 0; i3 < size2; i3++) {
                b bVar = (b) arrayList.get(i3);
                if (bVar.c.equals("sha256/")) {
                    if (fVarB == null) {
                        fVarB = b(x509Certificate);
                    }
                    if (bVar.d.equals(fVarB)) {
                        return;
                    }
                } else if (bVar.c.equals("sha1/")) {
                    if (fVarD == null) {
                        fVarD = com.anythink.core.common.m.c.f.a(x509Certificate.getPublicKey().getEncoded()).d();
                    }
                    if (bVar.d.equals(fVarD)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.c);
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = listA.size();
        for (int i4 = 0; i4 < size3; i4++) {
            X509Certificate x509Certificate2 = (X509Certificate) listA.get(i4);
            sb.append("\n    ").append(a((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ").append(str).append(":");
        int size4 = arrayList.size();
        for (i = 0; i < size4; i++) {
            sb.append("\n    ").append((b) arrayList.get(i));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }
}
