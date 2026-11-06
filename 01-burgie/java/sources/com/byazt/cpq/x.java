package com.byazt.cpq;

import com.byazt.du.qa;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
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
@com.byazt.vzx.pr(pr = {0, 1, 405, 121})
public final class x {
    public static final hn[] pr = {new hn(hn.uc, ""), new hn(hn.hn, TapHttp.METHOD_GET), new hn(hn.hn, TapHttp.METHOD_POST), new hn(hn.x, "/"), new hn(hn.x, "/index.html"), new hn(hn.c, "http"), new hn(hn.c, BaseConstants.SCHEME_HTTPS), new hn(hn.hw, "200"), new hn(hn.hw, "204"), new hn(hn.hw, "206"), new hn(hn.hw, "304"), new hn(hn.hw, "400"), new hn(hn.hw, "404"), new hn(hn.hw, "500"), new hn("accept-charset", ""), new hn("accept-encoding", "gzip, deflate"), new hn("accept-language", ""), new hn("accept-ranges", ""), new hn("accept", ""), new hn("access-control-allow-origin", ""), new hn("age", ""), new hn("allow", ""), new hn("authorization", ""), new hn("cache-control", ""), new hn("content-disposition", ""), new hn("content-encoding", ""), new hn("content-language", ""), new hn("content-length", ""), new hn("content-location", ""), new hn("content-range", ""), new hn("content-type", ""), new hn("cookie", ""), new hn("date", ""), new hn(BreakpointSQLiteKey.ETAG, ""), new hn("expect", ""), new hn("expires", ""), new hn("from", ""), new hn("host", ""), new hn("if-match", ""), new hn("if-modified-since", ""), new hn("if-none-match", ""), new hn("if-range", ""), new hn("if-unmodified-since", ""), new hn("last-modified", ""), new hn("link", ""), new hn("location", ""), new hn("max-forwards", ""), new hn("proxy-authenticate", ""), new hn("proxy-authorization", ""), new hn("range", ""), new hn("referer", ""), new hn("refresh", ""), new hn("retry-after", ""), new hn("server", ""), new hn("set-cookie", ""), new hn("strict-transport-security", ""), new hn("transfer-encoding", ""), new hn("user-agent", ""), new hn("vary", ""), new hn("via", ""), new hn("www-authenticate", "")};
    public static final Map<com.byazt.du.uc, Integer> hw = pr();

    @com.byazt.vzx.pr(pr = {0, 1, 405, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    static final class pr {
        public final List<hn> c;
        public final int fw;
        public int hn;
        public int hw;
        public hn[] pr;
        public final com.byazt.du.c uc;
        public int x;
        public int zo;

        public pr(int i, qa qaVar) {
            this(i, i, qaVar);
        }

        public pr(int i, int i2, qa qaVar) {
            this.c = new ArrayList();
            hn[] hnVarArr = new hn[8];
            this.pr = hnVarArr;
            this.hw = hnVarArr.length - 1;
            this.hn = 0;
            this.x = 0;
            this.fw = i;
            this.zo = i2;
            this.uc = com.byazt.du.k.pr(qaVar);
        }

        private void x() {
            int i = this.zo;
            int i2 = this.x;
            if (i < i2) {
                if (i == 0) {
                    c();
                } else {
                    pr(i2 - i);
                }
            }
        }

        private void c() {
            Arrays.fill(this.pr, (Object) null);
            this.hw = this.pr.length - 1;
            this.hn = 0;
            this.x = 0;
        }

        private int pr(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.pr.length;
                while (true) {
                    length--;
                    i2 = this.hw;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.pr[length].aj;
                    this.x -= this.pr[length].aj;
                    this.hn--;
                    i3++;
                }
                hn[] hnVarArr = this.pr;
                System.arraycopy(hnVarArr, i2 + 1, hnVarArr, i2 + 1 + i3, this.hn);
                this.hw += i3;
            }
            return i3;
        }

        public void pr() throws IOException {
            while (!this.uc.c()) {
                int iZo = this.uc.zo() & UByte.MAX_VALUE;
                if (iZo != 128) {
                    if ((iZo & 128) == 128) {
                        hw(pr(iZo, WorkQueueKt.MASK) - 1);
                    } else if (iZo == 64) {
                        fw();
                    } else if ((iZo & 64) == 64) {
                        c(pr(iZo, 63) - 1);
                    } else if ((iZo & 32) == 32) {
                        int iPr = pr(iZo, 31);
                        this.zo = iPr;
                        if (iPr < 0 || iPr > this.fw) {
                            throw new IOException("Invalid dynamic table size update " + this.zo);
                        }
                        x();
                    } else if (iZo == 16 || iZo == 0) {
                        uc();
                    } else {
                        x(pr(iZo, 15) - 1);
                    }
                } else {
                    throw new IOException("index == 0");
                }
            }
        }

        public List<hn> hw() {
            ArrayList arrayList = new ArrayList(this.c);
            this.c.clear();
            return arrayList;
        }

        private void hw(int i) throws IOException {
            if (fw(i)) {
                this.c.add(x.pr[i]);
                return;
            }
            int iHn = hn(i - x.pr.length);
            if (iHn >= 0) {
                hn[] hnVarArr = this.pr;
                if (iHn <= hnVarArr.length - 1) {
                    this.c.add(hnVarArr[iHn]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int hn(int i) {
            return this.hw + 1 + i;
        }

        private void x(int i) throws IOException {
            this.c.add(new hn(uc(i), hn()));
        }

        private void uc() throws IOException {
            this.c.add(new hn(x.pr(hn()), hn()));
        }

        private void c(int i) throws IOException {
            pr(-1, new hn(uc(i), hn()));
        }

        private void fw() throws IOException {
            pr(-1, new hn(x.pr(hn()), hn()));
        }

        private com.byazt.du.uc uc(int i) {
            if (fw(i)) {
                return x.pr[i].fw;
            }
            return this.pr[hn(i - x.pr.length)].fw;
        }

        private boolean fw(int i) {
            return i >= 0 && i <= x.pr.length - 1;
        }

        private void pr(int i, hn hnVar) {
            this.c.add(hnVar);
            int i2 = hnVar.aj;
            if (i != -1) {
                i2 -= this.pr[hn(i)].aj;
            }
            int i3 = this.zo;
            if (i2 > i3) {
                c();
                return;
            }
            int iPr = pr((this.x + i2) - i3);
            if (i == -1) {
                int i4 = this.hn + 1;
                hn[] hnVarArr = this.pr;
                if (i4 > hnVarArr.length) {
                    hn[] hnVarArr2 = new hn[hnVarArr.length * 2];
                    System.arraycopy(hnVarArr, 0, hnVarArr2, hnVarArr.length, hnVarArr.length);
                    this.hw = this.pr.length - 1;
                    this.pr = hnVarArr2;
                }
                int i5 = this.hw;
                this.hw = i5 - 1;
                this.pr[i5] = hnVar;
                this.hn++;
            } else {
                this.pr[i + hn(i) + iPr] = hnVar;
            }
            this.x += i2;
        }

        private int zo() throws IOException {
            return this.uc.zo() & UByte.MAX_VALUE;
        }

        public int pr(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iZo = zo();
                if ((iZo & 128) != 0) {
                    i2 += (iZo & WorkQueueKt.MASK) << i4;
                    i4 += 7;
                } else {
                    return i2 + (iZo << i4);
                }
            }
        }

        public com.byazt.du.uc hn() throws IOException {
            int iZo = zo();
            boolean z = (iZo & 128) == 128;
            int iPr = pr(iZo, WorkQueueKt.MASK);
            if (z) {
                return com.byazt.du.uc.pr(w.pr().pr(this.uc.fw(iPr)));
            }
            return this.uc.hn(iPr);
        }
    }

    private static Map<com.byazt.du.uc, Integer> pr() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(pr.length);
        int i = 0;
        while (true) {
            hn[] hnVarArr = pr;
            if (i < hnVarArr.length) {
                if (!linkedHashMap.containsKey(hnVarArr[i].fw)) {
                    linkedHashMap.put(hnVarArr[i].fw, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, 759})
    static final class hw {
        public int aj;
        public int c;
        public final com.byazt.du.hn fw;
        public hn[] hn;
        public int hw;
        public int pr;
        public int uc;
        public boolean vk;
        public int x;
        public final boolean zo;

        public hw(com.byazt.du.hn hnVar) {
            this(4096, true, hnVar);
        }

        public hw(int i, boolean z, com.byazt.du.hn hnVar) {
            this.aj = Integer.MAX_VALUE;
            hn[] hnVarArr = new hn[8];
            this.hn = hnVarArr;
            this.x = hnVarArr.length - 1;
            this.c = 0;
            this.uc = 0;
            this.pr = i;
            this.hw = i;
            this.zo = z;
            this.fw = hnVar;
        }

        private void pr() {
            Arrays.fill(this.hn, (Object) null);
            this.x = this.hn.length - 1;
            this.c = 0;
            this.uc = 0;
        }

        private int hw(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.hn.length;
                while (true) {
                    length--;
                    i2 = this.x;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    i -= this.hn[length].aj;
                    this.uc -= this.hn[length].aj;
                    this.c--;
                    i3++;
                }
                hn[] hnVarArr = this.hn;
                System.arraycopy(hnVarArr, i2 + 1, hnVarArr, i2 + 1 + i3, this.c);
                hn[] hnVarArr2 = this.hn;
                int i4 = this.x;
                Arrays.fill(hnVarArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                this.x += i3;
            }
            return i3;
        }

        private void pr(hn hnVar) {
            int i = hnVar.aj;
            int i2 = this.hw;
            if (i > i2) {
                pr();
                return;
            }
            hw((this.uc + i) - i2);
            int i3 = this.c + 1;
            hn[] hnVarArr = this.hn;
            if (i3 > hnVarArr.length) {
                hn[] hnVarArr2 = new hn[hnVarArr.length * 2];
                System.arraycopy(hnVarArr, 0, hnVarArr2, hnVarArr.length, hnVarArr.length);
                this.x = this.hn.length - 1;
                this.hn = hnVarArr2;
            }
            int i4 = this.x;
            this.x = i4 - 1;
            this.hn[i4] = hnVar;
            this.c++;
            this.uc += i;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x006e  */
        public void pr(List<hn> list) throws IOException {
            int length;
            int length2;
            if (this.vk) {
                int i = this.aj;
                if (i < this.hw) {
                    pr(i, 31, 32);
                }
                this.vk = false;
                this.aj = Integer.MAX_VALUE;
                pr(this.hw, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                hn hnVar = list.get(i2);
                com.byazt.du.uc ucVarUc = hnVar.fw.uc();
                com.byazt.du.uc ucVar = hnVar.zo;
                Integer num = x.hw.get(ucVarUc);
                if (num == null) {
                    length = -1;
                    length2 = -1;
                } else {
                    length = num.intValue() + 1;
                    if (length > 1 && length < 8) {
                        if (com.byazt.xx.hn.pr(x.pr[length - 1].zo, ucVar)) {
                            length2 = length;
                        } else if (com.byazt.xx.hn.pr(x.pr[length].zo, ucVar)) {
                            length2 = length;
                            length++;
                        } else {
                            length2 = length;
                            length = -1;
                        }
                    } else {
                        length2 = length;
                        length = -1;
                    }
                }
                if (length == -1) {
                    int length3 = this.hn.length;
                    for (int i3 = this.x + 1; i3 < length3; i3++) {
                        if (com.byazt.xx.hn.pr(this.hn[i3].fw, ucVarUc)) {
                            if (com.byazt.xx.hn.pr(this.hn[i3].zo, ucVar)) {
                                length = x.pr.length + (i3 - this.x);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i3 - this.x) + x.pr.length;
                            }
                        }
                    }
                }
                if (length == -1) {
                    if (length2 == -1) {
                        this.fw.aj(64);
                        pr(ucVarUc);
                        pr(ucVar);
                        pr(hnVar);
                    } else if (!ucVarUc.pr(hn.pr) || hn.uc.equals(ucVarUc)) {
                        pr(length2, 63, 64);
                        pr(ucVar);
                        pr(hnVar);
                    } else {
                        pr(length2, 15, 0);
                        pr(ucVar);
                    }
                } else {
                    pr(length, WorkQueueKt.MASK, 128);
                }
            }
        }

        public void pr(int i, int i2, int i3) {
            if (i < i2) {
                this.fw.aj(i | i3);
                return;
            }
            this.fw.aj(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.fw.aj(128 | (i4 & WorkQueueKt.MASK));
                i4 >>>= 7;
            }
            this.fw.aj(i4);
        }

        public void pr(com.byazt.du.uc ucVar) throws IOException {
            if (this.zo && w.pr().pr(ucVar) < ucVar.fw()) {
                com.byazt.du.hn hnVar = new com.byazt.du.hn();
                w.pr().pr(ucVar, hnVar);
                com.byazt.du.uc ucVarG = hnVar.g();
                pr(ucVarG.fw(), WorkQueueKt.MASK, 128);
                this.fw.hw(ucVarG);
                return;
            }
            pr(ucVar.fw(), WorkQueueKt.MASK, 0);
            this.fw.hw(ucVar);
        }

        public void pr(int i) {
            this.pr = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.hw;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.aj = Math.min(this.aj, iMin);
            }
            this.vk = true;
            this.hw = iMin;
            hw();
        }

        private void hw() {
            int i = this.hw;
            int i2 = this.uc;
            if (i < i2) {
                if (i == 0) {
                    pr();
                } else {
                    hw(i2 - i);
                }
            }
        }
    }

    public static com.byazt.du.uc pr(com.byazt.du.uc ucVar) throws IOException {
        int iFw = ucVar.fw();
        for (int i = 0; i < iFw; i++) {
            byte bPr = ucVar.pr(i);
            if (bPr >= 65 && bPr <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + ucVar.pr());
            }
        }
        return ucVar;
    }
}
