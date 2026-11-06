package com.byazt.hf;

import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.common.l.f;
import com.byazt.ho.BaseConstants;
import com.byazt.wa.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 5})
public final class q {
    public static final s[] n = {new s(s.w, ""), new s(s.s, TapHttp.METHOD_GET), new s(s.s, TapHttp.METHOD_POST), new s(s.q, "/"), new s(s.q, "/index.html"), new s(s.l, "http"), new s(s.l, BaseConstants.SCHEME_HTTPS), new s(s.qg, "200"), new s(s.qg, "204"), new s(s.qg, "206"), new s(s.qg, "304"), new s(s.qg, "400"), new s(s.qg, "404"), new s(s.qg, "500"), new s("accept-charset", ""), new s("accept-encoding", "gzip, deflate"), new s("accept-language", ""), new s("accept-ranges", ""), new s("accept", ""), new s("access-control-allow-origin", ""), new s(ATCustomRuleKeys.AGE, ""), new s("allow", ""), new s("authorization", ""), new s("cache-control", ""), new s("content-disposition", ""), new s("content-encoding", ""), new s("content-language", ""), new s("content-length", ""), new s("content-location", ""), new s("content-range", ""), new s("content-type", ""), new s("cookie", ""), new s("date", ""), new s("etag", ""), new s("expect", ""), new s("expires", ""), new s("from", ""), new s(f.bU, ""), new s("if-match", ""), new s("if-modified-since", ""), new s("if-none-match", ""), new s("if-range", ""), new s("if-unmodified-since", ""), new s("last-modified", ""), new s("link", ""), new s("location", ""), new s("max-forwards", ""), new s("proxy-authenticate", ""), new s("proxy-authorization", ""), new s("range", ""), new s("referer", ""), new s("refresh", ""), new s("retry-after", ""), new s("server", ""), new s("set-cookie", ""), new s("strict-transport-security", ""), new s("transfer-encoding", ""), new s("user-agent", ""), new s("vary", ""), new s("via", ""), new s("www-authenticate", "")};
    public static final Map<com.byazt.wa.w, Integer> qg = n();

    @com.byazt.cp.n(n = {0, 1, 938, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    static final class n {
        public int fs;
        public final List<s> l;
        public s[] n;
        public int q;
        public int qg;
        public int s;
        public final com.byazt.wa.l w;
        public final int x;

        public n(int i, um umVar) {
            this(i, i, umVar);
        }

        public n(int i, int i2, um umVar) {
            this.l = new ArrayList();
            s[] sVarArr = new s[8];
            this.n = sVarArr;
            this.qg = sVarArr.length - 1;
            this.s = 0;
            this.q = 0;
            this.x = i;
            this.fs = i2;
            this.w = com.byazt.wa.d.n(umVar);
        }

        private void q() {
            int i = this.fs;
            int i2 = this.q;
            if (i < i2) {
                if (i == 0) {
                    l();
                } else {
                    n(i2 - i);
                }
            }
        }

        private void l() {
            Arrays.fill(this.n, (Object) null);
            this.qg = this.n.length - 1;
            this.s = 0;
            this.q = 0;
        }

        private int n(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.n.length;
                while (true) {
                    length--;
                    i2 = this.qg;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.n[length].rv;
                    this.q -= this.n[length].rv;
                    this.s--;
                    i3++;
                }
                s[] sVarArr = this.n;
                System.arraycopy(sVarArr, i2 + 1, sVarArr, i2 + 1 + i3, this.s);
                this.qg += i3;
            }
            return i3;
        }

        public void n() throws IOException {
            while (!this.w.l()) {
                int iFs = this.w.fs() & UByte.MAX_VALUE;
                if (iFs == 128) {
                    throw new IOException("index == 0");
                }
                if ((iFs & 128) == 128) {
                    qg(n(iFs, WorkQueueKt.MASK) - 1);
                } else if (iFs == 64) {
                    x();
                } else if ((iFs & 64) == 64) {
                    l(n(iFs, 63) - 1);
                } else if ((iFs & 32) == 32) {
                    int iN = n(iFs, 31);
                    this.fs = iN;
                    if (iN < 0 || iN > this.x) {
                        throw new IOException("Invalid dynamic table size update " + this.fs);
                    }
                    q();
                } else if (iFs == 16 || iFs == 0) {
                    w();
                } else {
                    q(n(iFs, 15) - 1);
                }
            }
        }

        public List<s> qg() {
            ArrayList arrayList = new ArrayList(this.l);
            this.l.clear();
            return arrayList;
        }

        private void qg(int i) throws IOException {
            if (x(i)) {
                this.l.add(q.n[i]);
                return;
            }
            int iS = s(i - q.n.length);
            if (iS >= 0) {
                s[] sVarArr = this.n;
                if (iS <= sVarArr.length - 1) {
                    this.l.add(sVarArr[iS]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int s(int i) {
            return this.qg + 1 + i;
        }

        private void q(int i) throws IOException {
            this.l.add(new s(w(i), s()));
        }

        private void w() throws IOException {
            this.l.add(new s(q.n(s()), s()));
        }

        private void l(int i) throws IOException {
            n(-1, new s(w(i), s()));
        }

        private void x() throws IOException {
            n(-1, new s(q.n(s()), s()));
        }

        private com.byazt.wa.w w(int i) {
            if (x(i)) {
                return q.n[i].x;
            }
            return this.n[s(i - q.n.length)].x;
        }

        private boolean x(int i) {
            return i >= 0 && i <= q.n.length - 1;
        }

        private void n(int i, s sVar) {
            this.l.add(sVar);
            int i2 = sVar.rv;
            if (i != -1) {
                i2 -= this.n[s(i)].rv;
            }
            int i3 = this.fs;
            if (i2 > i3) {
                l();
                return;
            }
            int iN = n((this.q + i2) - i3);
            if (i == -1) {
                int i4 = this.s + 1;
                s[] sVarArr = this.n;
                if (i4 > sVarArr.length) {
                    s[] sVarArr2 = new s[sVarArr.length * 2];
                    System.arraycopy(sVarArr, 0, sVarArr2, sVarArr.length, sVarArr.length);
                    this.qg = this.n.length - 1;
                    this.n = sVarArr2;
                }
                int i5 = this.qg;
                this.qg = i5 - 1;
                this.n[i5] = sVar;
                this.s++;
            } else {
                this.n[i + s(i) + iN] = sVar;
            }
            this.q += i2;
        }

        private int fs() throws IOException {
            return this.w.fs() & UByte.MAX_VALUE;
        }

        public int n(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iFs = fs();
                if ((iFs & 128) == 0) {
                    return i2 + (iFs << i4);
                }
                i2 += (iFs & WorkQueueKt.MASK) << i4;
                i4 += 7;
            }
        }

        public com.byazt.wa.w s() throws IOException {
            int iFs = fs();
            boolean z = (iFs & 128) == 128;
            int iN = n(iFs, WorkQueueKt.MASK);
            if (z) {
                return com.byazt.wa.w.n(cp.n().n(this.w.x(iN)));
            }
            return this.w.s(iN);
        }
    }

    private static Map<com.byazt.wa.w, Integer> n() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(n.length);
        int i = 0;
        while (true) {
            s[] sVarArr = n;
            if (i < sVarArr.length) {
                if (!linkedHashMap.containsKey(sVarArr[i].x)) {
                    linkedHashMap.put(sVarArr[i].x, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 938, 524})
    static final class qg {
        public final boolean fs;
        public int l;
        public int n;
        public int q;
        public int qg;
        public int rv;
        public s[] s;
        public boolean tj;
        public int w;
        public final com.byazt.wa.s x;

        public qg(com.byazt.wa.s sVar) {
            this(4096, true, sVar);
        }

        public qg(int i, boolean z, com.byazt.wa.s sVar) {
            this.rv = Integer.MAX_VALUE;
            s[] sVarArr = new s[8];
            this.s = sVarArr;
            this.q = sVarArr.length - 1;
            this.l = 0;
            this.w = 0;
            this.n = i;
            this.qg = i;
            this.fs = z;
            this.x = sVar;
        }

        private void n() {
            Arrays.fill(this.s, (Object) null);
            this.q = this.s.length - 1;
            this.l = 0;
            this.w = 0;
        }

        private int qg(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.s.length;
                while (true) {
                    length--;
                    i2 = this.q;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.s[length].rv;
                    this.w -= this.s[length].rv;
                    this.l--;
                    i3++;
                }
                s[] sVarArr = this.s;
                System.arraycopy(sVarArr, i2 + 1, sVarArr, i2 + 1 + i3, this.l);
                s[] sVarArr2 = this.s;
                int i4 = this.q;
                Arrays.fill(sVarArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                this.q += i3;
            }
            return i3;
        }

        private void n(s sVar) {
            int i = sVar.rv;
            int i2 = this.qg;
            if (i > i2) {
                n();
                return;
            }
            qg((this.w + i) - i2);
            int i3 = this.l + 1;
            s[] sVarArr = this.s;
            if (i3 > sVarArr.length) {
                s[] sVarArr2 = new s[sVarArr.length * 2];
                System.arraycopy(sVarArr, 0, sVarArr2, sVarArr.length, sVarArr.length);
                this.q = this.s.length - 1;
                this.s = sVarArr2;
            }
            int i4 = this.q;
            this.q = i4 - 1;
            this.s[i4] = sVar;
            this.l++;
            this.w += i;
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
        public void n(List<s> list) throws IOException {
            int length;
            int length2;
            int i;
            int length3;
            if (this.tj) {
                int i2 = this.rv;
                if (i2 < this.qg) {
                    n(i2, 31, 32);
                }
                this.tj = false;
                this.rv = Integer.MAX_VALUE;
                n(this.qg, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                s sVar = list.get(i3);
                com.byazt.wa.w wVarW = sVar.x.w();
                com.byazt.wa.w wVar = sVar.fs;
                Integer num = q.qg.get(wVarW);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (length <= 1 || length >= 8) {
                        length2 = length;
                        length = -1;
                    } else if (!com.byazt.zho.s.n(q.n[length - 1].fs, wVar)) {
                        if (com.byazt.zho.s.n(q.n[length].fs, wVar)) {
                            length2 = length;
                            length++;
                        } else {
                            length2 = length;
                            length = -1;
                        }
                    }
                    if (length == -1) {
                        length3 = this.s.length;
                        for (i = this.q + 1; i < length3; i++) {
                            if (!com.byazt.zho.s.n(this.s[i].x, wVarW)) {
                                if (com.byazt.zho.s.n(this.s[i].fs, wVar)) {
                                    length = q.n.length + (i - this.q);
                                    break;
                                } else if (length2 == -1) {
                                    length2 = (i - this.q) + q.n.length;
                                }
                            }
                        }
                    }
                    if (length != -1) {
                        n(length, WorkQueueKt.MASK, 128);
                    } else if (length2 == -1) {
                        this.x.rv(64);
                        n(wVarW);
                        n(wVar);
                        n(sVar);
                    } else if (!wVarW.n(s.n) && !s.w.equals(wVarW)) {
                        n(length2, 15, 0);
                        n(wVar);
                    } else {
                        n(length2, 63, 64);
                        n(wVar);
                        n(sVar);
                    }
                } else {
                    length = -1;
                }
                length2 = length;
                if (length == -1) {
                    length3 = this.s.length;
                    while (i < length3) {
                        if (!com.byazt.zho.s.n(this.s[i].x, wVarW)) {
                            if (com.byazt.zho.s.n(this.s[i].fs, wVar)) {
                                length = q.n.length + (i - this.q);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i - this.q) + q.n.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    n(length, WorkQueueKt.MASK, 128);
                } else if (length2 == -1) {
                    this.x.rv(64);
                    n(wVarW);
                    n(wVar);
                    n(sVar);
                } else if (!wVarW.n(s.n)) {
                    n(length2, 63, 64);
                    n(wVar);
                    n(sVar);
                } else {
                    n(length2, 63, 64);
                    n(wVar);
                    n(sVar);
                }
            }
        }

        public void n(int i, int i2, int i3) {
            if (i < i2) {
                this.x.rv(i | i3);
                return;
            }
            this.x.rv(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.x.rv(128 | (i4 & WorkQueueKt.MASK));
                i4 >>>= 7;
            }
            this.x.rv(i4);
        }

        public void n(com.byazt.wa.w wVar) throws IOException {
            if (this.fs && cp.n().n(wVar) < wVar.x()) {
                com.byazt.wa.s sVar = new com.byazt.wa.s();
                cp.n().n(wVar, sVar);
                com.byazt.wa.w wVarSz = sVar.sz();
                n(wVarSz.x(), WorkQueueKt.MASK, 128);
                this.x.qg(wVarSz);
                return;
            }
            n(wVar.x(), WorkQueueKt.MASK, 0);
            this.x.qg(wVar);
        }

        public void n(int i) {
            this.n = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.qg;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.rv = Math.min(this.rv, iMin);
            }
            this.tj = true;
            this.qg = iMin;
            qg();
        }

        private void qg() {
            int i = this.qg;
            int i2 = this.w;
            if (i < i2) {
                if (i == 0) {
                    n();
                } else {
                    qg(i2 - i);
                }
            }
        }
    }

    public static com.byazt.wa.w n(com.byazt.wa.w wVar) throws IOException {
        int iX = wVar.x();
        for (int i = 0; i < iX; i++) {
            byte bN = wVar.n(i);
            if (bN >= 65 && bN <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + wVar.n());
            }
        }
        return wVar;
    }
}
