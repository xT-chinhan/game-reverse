package com.anythink.core.common.n.b.a.e;

import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.common.n.c.w;
import com.baidu.mobads.sdk.internal.cl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
final class d {
    static final c[] a;
    static final Map<com.anythink.core.common.n.c.f, Integer> b;
    private static final int c = 15;
    private static final int d = 31;
    private static final int e = 63;
    private static final int f = 127;

    static {
        int i = 0;
        c[] cVarArr = {new c(c.k, ""), new c(c.h, "GET"), new c(c.h, "POST"), new c(c.i, "/"), new c(c.i, "/index.html"), new c(c.j, "http"), new c(c.j, "https"), new c(c.g, "200"), new c(c.g, "204"), new c(c.g, "206"), new c(c.g, "304"), new c(c.g, "400"), new c(c.g, cl.b), new c(c.g, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c(ATCustomRuleKeys.AGE, ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        a = cVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(cVarArr.length);
        while (true) {
            c[] cVarArr2 = a;
            if (i >= cVarArr2.length) {
                b = Collections.unmodifiableMap(linkedHashMap);
                return;
            } else {
                if (!linkedHashMap.containsKey(cVarArr2[i].l)) {
                    linkedHashMap.put(cVarArr2[i].l, Integer.valueOf(i));
                }
                i++;
            }
        }
    }

    private d() {
    }

    static final class a {
        c[] a;
        int b;
        int c;
        int d;
        private final List<c> e;
        private final com.anythink.core.common.n.c.e f;
        private final int g;
        private int h;

        a(w wVar, byte b) {
            this(wVar);
        }

        private a(w wVar) {
            this.e = new ArrayList();
            c[] cVarArr = new c[8];
            this.a = cVarArr;
            this.b = cVarArr.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = 4096;
            this.h = 4096;
            this.f = com.anythink.core.common.n.c.n.a(wVar);
        }

        private int c() {
            return this.h;
        }

        private void d() {
            int i = this.h;
            int i2 = this.d;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    a(i2 - i);
                }
            }
        }

        private void e() {
            Arrays.fill(this.a, (Object) null);
            this.b = this.a.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.a.length;
                while (true) {
                    length--;
                    i2 = this.b;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.a[length].n;
                    this.d -= this.a[length].n;
                    this.c--;
                    i3++;
                }
                c[] cVarArr = this.a;
                System.arraycopy(cVarArr, i2 + 1, cVarArr, i2 + 1 + i3, this.c);
                this.b += i3;
            }
            return i3;
        }

        final void a() throws IOException {
            while (!this.f.g()) {
                int iK = this.f.k() & UByte.MAX_VALUE;
                if (iK == 128) {
                    throw new IOException("index == 0");
                }
                if ((iK & 128) == 128) {
                    int iA = a(iK, 127) - 1;
                    if (g(iA)) {
                        this.e.add(d.a[iA]);
                    } else {
                        int iC = c(iA - d.a.length);
                        if (iC >= 0) {
                            c[] cVarArr = this.a;
                            if (iC < cVarArr.length) {
                                this.e.add(cVarArr[iC]);
                            }
                        }
                        throw new IOException("Header index too large " + (iA + 1));
                    }
                } else if (iK == 64) {
                    a(new c(d.a(i()), i()));
                } else if ((iK & 64) == 64) {
                    a(new c(f(a(iK, 63) - 1), i()));
                } else if ((iK & 32) == 32) {
                    int iA2 = a(iK, 31);
                    this.h = iA2;
                    if (iA2 < 0 || iA2 > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (iK == 16 || iK == 0) {
                    this.e.add(new c(d.a(i()), i()));
                } else {
                    this.e.add(new c(f(a(iK, 15) - 1), i()));
                }
            }
        }

        public final List<c> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.e.add(d.a[i]);
                return;
            }
            int iC = c(i - d.a.length);
            if (iC >= 0) {
                c[] cVarArr = this.a;
                if (iC < cVarArr.length) {
                    this.e.add(cVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int c(int i) {
            return this.b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new c(f(i), i()));
        }

        private void f() throws IOException {
            this.e.add(new c(d.a(i()), i()));
        }

        private void e(int i) {
            a(new c(f(i), i()));
        }

        private void g() {
            a(new c(d.a(i()), i()));
        }

        private com.anythink.core.common.n.c.f f(int i) throws IOException {
            if (g(i)) {
                return d.a[i].l;
            }
            int iC = c(i - d.a.length);
            if (iC >= 0) {
                c[] cVarArr = this.a;
                if (iC < cVarArr.length) {
                    return cVarArr[iC].l;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private static boolean g(int i) {
            return i >= 0 && i <= d.a.length - 1;
        }

        private void a(c cVar) {
            this.e.add(cVar);
            int i = cVar.n;
            int i2 = this.h;
            if (i > i2) {
                e();
                return;
            }
            a((this.d + i) - i2);
            int i3 = this.c + 1;
            c[] cVarArr = this.a;
            if (i3 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.b = this.a.length - 1;
                this.a = cVarArr2;
            }
            int i4 = this.b;
            this.b = i4 - 1;
            this.a[i4] = cVar;
            this.c++;
            this.d += i;
        }

        private int h() {
            return this.f.k() & UByte.MAX_VALUE;
        }

        private int a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iH = h();
                if ((iH & 128) == 0) {
                    return i2 + (iH << i4);
                }
                i2 += (iH & 127) << i4;
                i4 += 7;
            }
        }

        private com.anythink.core.common.n.c.f i() {
            int iH = h();
            boolean z = (iH & 128) == 128;
            int iA = a(iH, 127);
            if (z) {
                return com.anythink.core.common.n.c.f.a(k.a().a(this.f.h(iA)));
            }
            return this.f.d(iA);
        }
    }

    private static Map<com.anythink.core.common.n.c.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i = 0;
        while (true) {
            c[] cVarArr = a;
            if (i < cVarArr.length) {
                if (!linkedHashMap.containsKey(cVarArr[i].l)) {
                    linkedHashMap.put(cVarArr[i].l, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static final class b {
        private static final int g = 4096;
        private static final int h = 16384;
        int a;
        int b;
        c[] c;
        int d;
        int e;
        int f;
        private final com.anythink.core.common.n.c.c i;
        private final boolean j;
        private int k;
        private boolean l;

        b(com.anythink.core.common.n.c.c cVar) {
            this(cVar, (byte) 0);
        }

        private b(com.anythink.core.common.n.c.c cVar, byte b) {
            this.k = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.c = cVarArr;
            this.d = cVarArr.length - 1;
            this.e = 0;
            this.f = 0;
            this.a = 4096;
            this.b = 4096;
            this.j = true;
            this.i = cVar;
        }

        private void a() {
            Arrays.fill(this.c, (Object) null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    i2 = this.d;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.c[length].n;
                    this.f -= this.c[length].n;
                    this.e--;
                    i3++;
                }
                c[] cVarArr = this.c;
                System.arraycopy(cVarArr, i2 + 1, cVarArr, i2 + 1 + i3, this.e);
                c[] cVarArr2 = this.c;
                int i4 = this.d;
                Arrays.fill(cVarArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                this.d += i3;
            }
            return i3;
        }

        private void a(c cVar) {
            int i = cVar.n;
            int i2 = this.b;
            if (i > i2) {
                a();
                return;
            }
            b((this.f + i) - i2);
            int i3 = this.e + 1;
            c[] cVarArr = this.c;
            if (i3 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.d = this.c.length - 1;
                this.c = cVarArr2;
            }
            int i4 = this.d;
            this.d = i4 - 1;
            this.c[i4] = cVar;
            this.e++;
            this.f += i;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x006b  */
        /* JADX WARN: Code duplicated, block: B:26:0x0072  */
        /* JADX WARN: Code duplicated, block: B:28:0x007a  */
        /* JADX WARN: Code duplicated, block: B:30:0x0086  */
        /* JADX WARN: Code duplicated, block: B:33:0x009a A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:34:0x009c  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:46:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:55:0x0092 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00a4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a4 A[SYNTHETIC] */
        final void a(List<c> list) {
            int length;
            int length2;
            int i;
            int length3;
            if (this.l) {
                int i2 = this.k;
                if (i2 < this.b) {
                    a(i2, 31, 32);
                }
                this.l = false;
                this.k = Integer.MAX_VALUE;
                a(this.b, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = list.get(i3);
                com.anythink.core.common.n.c.f fVarH = cVar.l.h();
                com.anythink.core.common.n.c.f fVar = cVar.m;
                Integer num = d.b.get(fVarH);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (length <= 1 || length >= 8) {
                        length2 = length;
                        length = -1;
                    } else if (!Objects.equals(d.a[length - 1].m, fVar)) {
                        if (Objects.equals(d.a[length].m, fVar)) {
                            length2 = length;
                            length++;
                        } else {
                            length2 = length;
                            length = -1;
                        }
                    }
                    if (length == -1) {
                        length3 = this.c.length;
                        for (i = this.d + 1; i < length3; i++) {
                            if (!Objects.equals(this.c[i].l, fVarH)) {
                                if (Objects.equals(this.c[i].m, fVar)) {
                                    length = d.a.length + (i - this.d);
                                    break;
                                } else if (length2 == -1) {
                                    length2 = (i - this.d) + d.a.length;
                                }
                            }
                        }
                    }
                    if (length != -1) {
                        a(length, 127, 128);
                    } else if (length2 == -1) {
                        this.i.l(64);
                        a(fVarH);
                        a(fVar);
                        a(cVar);
                    } else if (!fVarH.c(c.a) && !c.k.equals(fVarH)) {
                        a(length2, 15, 0);
                        a(fVar);
                    } else {
                        a(length2, 63, 64);
                        a(fVar);
                        a(cVar);
                    }
                } else {
                    length = -1;
                }
                length2 = length;
                if (length == -1) {
                    length3 = this.c.length;
                    while (i < length3) {
                        if (!Objects.equals(this.c[i].l, fVarH)) {
                            if (Objects.equals(this.c[i].m, fVar)) {
                                length = d.a.length + (i - this.d);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i - this.d) + d.a.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    a(length, 127, 128);
                } else if (length2 == -1) {
                    this.i.l(64);
                    a(fVarH);
                    a(fVar);
                    a(cVar);
                } else if (!fVarH.c(c.a)) {
                    a(length2, 63, 64);
                    a(fVar);
                    a(cVar);
                } else {
                    a(length2, 63, 64);
                    a(fVar);
                    a(cVar);
                }
            }
        }

        private void a(int i, int i2, int i3) {
            if (i < i2) {
                this.i.l(i | i3);
                return;
            }
            this.i.l(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.i.l(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.i.l(i4);
        }

        private void a(com.anythink.core.common.n.c.f fVar) {
            if (this.j) {
                k.a();
                if (k.a(fVar) < fVar.j()) {
                    com.anythink.core.common.n.c.c cVar = new com.anythink.core.common.n.c.c();
                    k.a();
                    k.a(fVar, cVar);
                    com.anythink.core.common.n.c.f fVarT = cVar.t();
                    a(fVarT.j(), 127, 128);
                    this.i.d(fVarT);
                    return;
                }
            }
            a(fVar.j(), 127, 0);
            this.i.d(fVar);
        }

        final void a(int i) {
            this.a = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.b;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.k = Math.min(this.k, iMin);
            }
            this.l = true;
            this.b = iMin;
            int i3 = this.f;
            if (iMin < i3) {
                if (iMin == 0) {
                    a();
                } else {
                    b(i3 - iMin);
                }
            }
        }

        private void b() {
            int i = this.b;
            int i2 = this.f;
            if (i < i2) {
                if (i == 0) {
                    a();
                } else {
                    b(i2 - i);
                }
            }
        }
    }

    static com.anythink.core.common.n.c.f a(com.anythink.core.common.n.c.f fVar) throws IOException {
        int iJ = fVar.j();
        for (int i = 0; i < iJ; i++) {
            byte b2 = fVar.b(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }
}
