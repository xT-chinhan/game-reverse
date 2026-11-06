package com.bytedance.sdk.component.ah.xr.ms.ka;

import com.anythink.core.api.ATCustomRuleKeys;
import com.baidu.mobads.sdk.internal.cl;
import com.bytedance.sdk.component.ah.ms.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final ah[] f1090ms = {new ah(ah.c, ""), new ah(ah.ah, "GET"), new ah(ah.ah, "POST"), new ah(ah.d, "/"), new ah(ah.d, "/index.html"), new ah(ah.ka, "http"), new ah(ah.ka, "https"), new ah(ah.xr, "200"), new ah(ah.xr, "204"), new ah(ah.xr, "206"), new ah(ah.xr, "304"), new ah(ah.xr, "400"), new ah(ah.xr, cl.b), new ah(ah.xr, "500"), new ah("accept-charset", ""), new ah("accept-encoding", "gzip, deflate"), new ah("accept-language", ""), new ah("accept-ranges", ""), new ah("accept", ""), new ah("access-control-allow-origin", ""), new ah(ATCustomRuleKeys.AGE, ""), new ah("allow", ""), new ah("authorization", ""), new ah("cache-control", ""), new ah("content-disposition", ""), new ah("content-encoding", ""), new ah("content-language", ""), new ah("content-length", ""), new ah("content-location", ""), new ah("content-range", ""), new ah("content-type", ""), new ah("cookie", ""), new ah("date", ""), new ah("etag", ""), new ah("expect", ""), new ah("expires", ""), new ah("from", ""), new ah("host", ""), new ah("if-match", ""), new ah("if-modified-since", ""), new ah("if-none-match", ""), new ah("if-range", ""), new ah("if-unmodified-since", ""), new ah("last-modified", ""), new ah("link", ""), new ah("location", ""), new ah("max-forwards", ""), new ah("proxy-authenticate", ""), new ah("proxy-authorization", ""), new ah("range", ""), new ah("referer", ""), new ah("refresh", ""), new ah("retry-after", ""), new ah("server", ""), new ah("set-cookie", ""), new ah("strict-transport-security", ""), new ah("transfer-encoding", ""), new ah("user-agent", ""), new ah("vary", ""), new ah("via", ""), new ah("www-authenticate", "")};
    static final Map<com.bytedance.sdk.component.ah.ms.c, Integer> xr = ms();

    static final class ms {
        private final int ab;
        int ah;
        private final com.bytedance.sdk.component.ah.ms.ka c;
        int d;
        private final List<ah> ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        ah[] f1091ms;
        private int x;
        int xr;

        ms(int i, y yVar) {
            this(i, i, yVar);
        }

        ms(int i, int i2, y yVar) {
            this.ka = new ArrayList();
            ah[] ahVarArr = new ah[8];
            this.f1091ms = ahVarArr;
            this.xr = ahVarArr.length - 1;
            this.ah = 0;
            this.d = 0;
            this.ab = i;
            this.x = i2;
            this.c = com.bytedance.sdk.component.ah.ms.sl.ms(yVar);
        }

        private void d() {
            int i = this.x;
            int i2 = this.d;
            if (i < i2) {
                if (i == 0) {
                    ka();
                } else {
                    ms(i2 - i);
                }
            }
        }

        private void ka() {
            Arrays.fill(this.f1091ms, (Object) null);
            this.xr = this.f1091ms.length - 1;
            this.ah = 0;
            this.d = 0;
        }

        private int ms(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f1091ms.length;
                while (true) {
                    length--;
                    i2 = this.xr;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.f1091ms[length].ny;
                    this.d -= this.f1091ms[length].ny;
                    this.ah--;
                    i3++;
                }
                ah[] ahVarArr = this.f1091ms;
                System.arraycopy(ahVarArr, i2 + 1, ahVarArr, i2 + 1 + i3, this.ah);
                this.xr += i3;
            }
            return i3;
        }

        void ms() throws IOException {
            while (!this.c.ka()) {
                int iX = this.c.x() & UByte.MAX_VALUE;
                if (iX == 128) {
                    throw new IOException("index == 0");
                }
                if ((iX & 128) == 128) {
                    xr(ms(iX, 127) - 1);
                } else if (iX == 64) {
                    ab();
                } else if ((iX & 64) == 64) {
                    ka(ms(iX, 63) - 1);
                } else if ((iX & 32) == 32) {
                    int iMs = ms(iX, 31);
                    this.x = iMs;
                    if (iMs < 0 || iMs > this.ab) {
                        throw new IOException("Invalid dynamic table size update " + this.x);
                    }
                    d();
                } else if (iX == 16 || iX == 0) {
                    c();
                } else {
                    d(ms(iX, 15) - 1);
                }
            }
        }

        public List<ah> xr() {
            ArrayList arrayList = new ArrayList(this.ka);
            this.ka.clear();
            return arrayList;
        }

        private void xr(int i) throws IOException {
            if (ab(i)) {
                this.ka.add(d.f1090ms[i]);
                return;
            }
            int iAh = ah(i - d.f1090ms.length);
            if (iAh >= 0) {
                ah[] ahVarArr = this.f1091ms;
                if (iAh <= ahVarArr.length - 1) {
                    this.ka.add(ahVarArr[iAh]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int ah(int i) {
            return this.xr + 1 + i;
        }

        private void d(int i) throws IOException {
            this.ka.add(new ah(c(i), ah()));
        }

        private void c() throws IOException {
            this.ka.add(new ah(d.ms(ah()), ah()));
        }

        private void ka(int i) throws IOException {
            ms(-1, new ah(c(i), ah()));
        }

        private void ab() throws IOException {
            ms(-1, new ah(d.ms(ah()), ah()));
        }

        private com.bytedance.sdk.component.ah.ms.c c(int i) {
            if (ab(i)) {
                return d.f1090ms[i].ab;
            }
            return this.f1091ms[ah(i - d.f1090ms.length)].ab;
        }

        private boolean ab(int i) {
            return i >= 0 && i <= d.f1090ms.length - 1;
        }

        private void ms(int i, ah ahVar) {
            this.ka.add(ahVar);
            int i2 = ahVar.ny;
            if (i != -1) {
                i2 -= this.f1091ms[ah(i)].ny;
            }
            int i3 = this.x;
            if (i2 > i3) {
                ka();
                return;
            }
            int iMs = ms((this.d + i2) - i3);
            if (i == -1) {
                int i4 = this.ah + 1;
                ah[] ahVarArr = this.f1091ms;
                if (i4 > ahVarArr.length) {
                    ah[] ahVarArr2 = new ah[ahVarArr.length * 2];
                    System.arraycopy(ahVarArr, 0, ahVarArr2, ahVarArr.length, ahVarArr.length);
                    this.xr = this.f1091ms.length - 1;
                    this.f1091ms = ahVarArr2;
                }
                int i5 = this.xr;
                this.xr = i5 - 1;
                this.f1091ms[i5] = ahVar;
                this.ah++;
            } else {
                this.f1091ms[i + ah(i) + iMs] = ahVar;
            }
            this.d += i2;
        }

        private int x() throws IOException {
            return this.c.x() & UByte.MAX_VALUE;
        }

        int ms(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iX = x();
                if ((iX & 128) == 0) {
                    return i2 + (iX << i4);
                }
                i2 += (iX & 127) << i4;
                i4 += 7;
            }
        }

        com.bytedance.sdk.component.ah.ms.c ah() throws IOException {
            int iX = x();
            boolean z = (iX & 128) == 128;
            int iMs = ms(iX, 127);
            if (z) {
                return com.bytedance.sdk.component.ah.ms.c.ms(hi.ms().ms(this.c.ab(iMs)));
            }
            return this.c.ah(iMs);
        }
    }

    private static Map<com.bytedance.sdk.component.ah.ms.c, Integer> ms() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f1090ms.length);
        int i = 0;
        while (true) {
            ah[] ahVarArr = f1090ms;
            if (i < ahVarArr.length) {
                if (!linkedHashMap.containsKey(ahVarArr[i].ab)) {
                    linkedHashMap.put(ahVarArr[i].ab, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static final class xr {
        private final com.bytedance.sdk.component.ah.ms.ah ab;
        ah[] ah;
        int c;
        private boolean ch;
        int d;
        int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1092ms;
        private int ny;
        private final boolean x;
        int xr;

        xr(com.bytedance.sdk.component.ah.ms.ah ahVar) {
            this(4096, true, ahVar);
        }

        xr(int i, boolean z, com.bytedance.sdk.component.ah.ms.ah ahVar) {
            this.ny = Integer.MAX_VALUE;
            ah[] ahVarArr = new ah[8];
            this.ah = ahVarArr;
            this.d = ahVarArr.length - 1;
            this.ka = 0;
            this.c = 0;
            this.f1092ms = i;
            this.xr = i;
            this.x = z;
            this.ab = ahVar;
        }

        private void ms() {
            Arrays.fill(this.ah, (Object) null);
            this.d = this.ah.length - 1;
            this.ka = 0;
            this.c = 0;
        }

        private int xr(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.ah.length;
                while (true) {
                    length--;
                    i2 = this.d;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.ah[length].ny;
                    this.c -= this.ah[length].ny;
                    this.ka--;
                    i3++;
                }
                ah[] ahVarArr = this.ah;
                System.arraycopy(ahVarArr, i2 + 1, ahVarArr, i2 + 1 + i3, this.ka);
                ah[] ahVarArr2 = this.ah;
                int i4 = this.d;
                Arrays.fill(ahVarArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                this.d += i3;
            }
            return i3;
        }

        private void ms(ah ahVar) {
            int i = ahVar.ny;
            int i2 = this.xr;
            if (i > i2) {
                ms();
                return;
            }
            xr((this.c + i) - i2);
            int i3 = this.ka + 1;
            ah[] ahVarArr = this.ah;
            if (i3 > ahVarArr.length) {
                ah[] ahVarArr2 = new ah[ahVarArr.length * 2];
                System.arraycopy(ahVarArr, 0, ahVarArr2, ahVarArr.length, ahVarArr.length);
                this.d = this.ah.length - 1;
                this.ah = ahVarArr2;
            }
            int i4 = this.d;
            this.d = i4 - 1;
            this.ah[i4] = ahVar;
            this.ka++;
            this.c += i;
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
        void ms(List<ah> list) throws IOException {
            int length;
            int length2;
            int i;
            int length3;
            if (this.ch) {
                int i2 = this.ny;
                if (i2 < this.xr) {
                    ms(i2, 31, 32);
                }
                this.ch = false;
                this.ny = Integer.MAX_VALUE;
                ms(this.xr, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ah ahVar = list.get(i3);
                com.bytedance.sdk.component.ah.ms.c cVarC = ahVar.ab.c();
                com.bytedance.sdk.component.ah.ms.c cVar = ahVar.x;
                Integer num = d.xr.get(cVarC);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (length <= 1 || length >= 8) {
                        length2 = length;
                        length = -1;
                    } else if (!com.bytedance.sdk.component.ah.xr.ms.ah.ms(d.f1090ms[length - 1].x, cVar)) {
                        if (com.bytedance.sdk.component.ah.xr.ms.ah.ms(d.f1090ms[length].x, cVar)) {
                            length2 = length;
                            length++;
                        } else {
                            length2 = length;
                            length = -1;
                        }
                    }
                    if (length == -1) {
                        length3 = this.ah.length;
                        for (i = this.d + 1; i < length3; i++) {
                            if (!com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ah[i].ab, cVarC)) {
                                if (com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ah[i].x, cVar)) {
                                    length = d.f1090ms.length + (i - this.d);
                                    break;
                                } else if (length2 == -1) {
                                    length2 = (i - this.d) + d.f1090ms.length;
                                }
                            }
                        }
                    }
                    if (length != -1) {
                        ms(length, 127, 128);
                    } else if (length2 == -1) {
                        this.ab.ny(64);
                        ms(cVarC);
                        ms(cVar);
                        ms(ahVar);
                    } else if (!cVarC.ms(ah.f1086ms) && !ah.c.equals(cVarC)) {
                        ms(length2, 15, 0);
                        ms(cVar);
                    } else {
                        ms(length2, 63, 64);
                        ms(cVar);
                        ms(ahVar);
                    }
                } else {
                    length = -1;
                }
                length2 = length;
                if (length == -1) {
                    length3 = this.ah.length;
                    while (i < length3) {
                        if (!com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ah[i].ab, cVarC)) {
                            if (com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ah[i].x, cVar)) {
                                length = d.f1090ms.length + (i - this.d);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i - this.d) + d.f1090ms.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    ms(length, 127, 128);
                } else if (length2 == -1) {
                    this.ab.ny(64);
                    ms(cVarC);
                    ms(cVar);
                    ms(ahVar);
                } else if (!cVarC.ms(ah.f1086ms)) {
                    ms(length2, 63, 64);
                    ms(cVar);
                    ms(ahVar);
                } else {
                    ms(length2, 63, 64);
                    ms(cVar);
                    ms(ahVar);
                }
            }
        }

        void ms(int i, int i2, int i3) {
            if (i < i2) {
                this.ab.ny(i | i3);
                return;
            }
            this.ab.ny(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.ab.ny(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.ab.ny(i4);
        }

        void ms(com.bytedance.sdk.component.ah.ms.c cVar) throws IOException {
            if (this.x && hi.ms().ms(cVar) < cVar.ab()) {
                com.bytedance.sdk.component.ah.ms.ah ahVar = new com.bytedance.sdk.component.ah.ms.ah();
                hi.ms().ms(cVar, ahVar);
                com.bytedance.sdk.component.ah.ms.c cVarU = ahVar.u();
                ms(cVarU.ab(), 127, 128);
                this.ab.xr(cVarU);
                return;
            }
            ms(cVar.ab(), 127, 0);
            this.ab.xr(cVar);
        }

        void ms(int i) {
            this.f1092ms = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.xr;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.ny = Math.min(this.ny, iMin);
            }
            this.ch = true;
            this.xr = iMin;
            xr();
        }

        private void xr() {
            int i = this.xr;
            int i2 = this.c;
            if (i < i2) {
                if (i == 0) {
                    ms();
                } else {
                    xr(i2 - i);
                }
            }
        }
    }

    static com.bytedance.sdk.component.ah.ms.c ms(com.bytedance.sdk.component.ah.ms.c cVar) throws IOException {
        int iAb = cVar.ab();
        for (int i = 0; i < iAb; i++) {
            byte bMs = cVar.ms(i);
            if (bMs >= 65 && bMs <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + cVar.ms());
            }
        }
        return cVar;
    }
}
