package com.byazt.ym;

import com.byazt.pq.bb;
import com.byazt.pq.cd;
import com.byazt.pq.h;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1223, 8})
public final class s {
    public final h n;
    public final bb qg;

    public s(h hVar, bb bbVar) {
        this.n = hVar;
        this.qg = bbVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.oa().q() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean n(com.byazt.pq.bb r3, com.byazt.pq.h r4) {
        /*
            int r0 = r3.q()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L59
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L59
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L59
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L59
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L59
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L59
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L59
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L59
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L59
            switch(r0) {
                case 300: goto L59;
                case 301: goto L59;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L58
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.qg(r0)
            if (r0 != 0) goto L59
            com.byazt.pq.q r0 = r3.oa()
            int r0 = r0.s()
            r1 = -1
            if (r0 != r1) goto L59
            com.byazt.pq.q r0 = r3.oa()
            boolean r0 = r0.l()
            if (r0 != 0) goto L59
            com.byazt.pq.q r0 = r3.oa()
            boolean r0 = r0.q()
            if (r0 != 0) goto L59
        L58:
            return r2
        L59:
            com.byazt.pq.q r3 = r3.oa()
            boolean r3 = r3.qg()
            if (r3 != 0) goto L6f
            com.byazt.pq.q r3 = r4.fs()
            boolean r3 = r3.qg()
            if (r3 != 0) goto L6f
            r3 = 1
            return r3
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.ym.s.n(com.byazt.pq.bb, com.byazt.pq.h):boolean");
    }

    @com.byazt.cp.n(n = {0, 1, 1223, 546})
    public static class n {
        public String cp;
        public int d;
        public Date fs;
        public String l;
        public final long n;
        public Date q;
        public final h qg;
        public long rv;
        public final bb s;
        public long tj;
        public Date w;
        public String x;

        public n(long j, h hVar, bb bbVar) {
            this.d = -1;
            this.n = j;
            this.qg = hVar;
            this.s = bbVar;
            if (bbVar != null) {
                this.rv = bbVar.sz();
                this.tj = bbVar.k();
                cd cdVarFs = bbVar.fs();
                int iN = cdVarFs.n();
                for (int i = 0; i < iN; i++) {
                    String strN = cdVarFs.n(i);
                    String strQg = cdVarFs.qg(i);
                    if ("Date".equalsIgnoreCase(strN)) {
                        this.q = com.byazt.cri.q.n(strQg);
                        this.l = strQg;
                    } else if ("Expires".equalsIgnoreCase(strN)) {
                        this.fs = com.byazt.cri.q.n(strQg);
                    } else if ("Last-Modified".equalsIgnoreCase(strN)) {
                        this.w = com.byazt.cri.q.n(strQg);
                        this.x = strQg;
                    } else if ("ETag".equalsIgnoreCase(strN)) {
                        this.cp = strQg;
                    } else if ("Age".equalsIgnoreCase(strN)) {
                        this.d = com.byazt.cri.l.qg(strQg, -1);
                    }
                }
            }
        }

        public s n() {
            s sVarQg = qg();
            return (sVarQg.n == null || !this.qg.fs().rv()) ? sVarQg : new s(null, null);
        }

        private s qg() {
            String str;
            if (this.s == null) {
                return new s(this.qg, null);
            }
            if (this.qg.rv() && this.s.x() == null) {
                return new s(this.qg, null);
            }
            if (!s.n(this.s, this.qg)) {
                return new s(this.qg, null);
            }
            com.byazt.pq.q qVarFs = this.qg.fs();
            if (qVarFs.n() || n(this.qg)) {
                return new s(this.qg, null);
            }
            com.byazt.pq.q qVarOa = this.s.oa();
            if (qVarOa.tj()) {
                return new s(null, this.s);
            }
            long jQ = q();
            long jS = s();
            if (qVarFs.s() != -1) {
                jS = Math.min(jS, TimeUnit.SECONDS.toMillis(qVarFs.s()));
            }
            long millis = 0;
            long millis2 = qVarFs.fs() != -1 ? TimeUnit.SECONDS.toMillis(qVarFs.fs()) : 0L;
            if (!qVarOa.w() && qVarFs.x() != -1) {
                millis = TimeUnit.SECONDS.toMillis(qVarFs.x());
            }
            if (!qVarOa.n()) {
                long j = millis2 + jQ;
                if (j < millis + jS) {
                    bb.n nVarTj = this.s.tj();
                    if (j >= jS) {
                        nVarTj.n("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jQ > 86400000 && l()) {
                        nVarTj.n("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new s(null, nVarTj.n());
                }
            }
            String str2 = this.cp;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.w != null) {
                    str2 = this.x;
                } else if (this.q != null) {
                    str2 = this.l;
                } else {
                    return new s(this.qg, null);
                }
                str = "If-Modified-Since";
            }
            cd.n nVarQg = this.qg.s().qg();
            com.byazt.zho.n.n.n(nVarQg, str, str2);
            return new s(this.qg.x().n(nVarQg.n()).n(), this.s);
        }

        private long s() {
            com.byazt.pq.q qVarOa = this.s.oa();
            if (qVarOa.s() != -1) {
                return TimeUnit.SECONDS.toMillis(qVarOa.s());
            }
            if (this.fs != null) {
                Date date = this.q;
                long time = this.fs.getTime() - (date != null ? date.getTime() : this.tj);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.w != null && this.s.qg().n().query() == null) {
                Date date2 = this.q;
                long time2 = (date2 != null ? date2.getTime() : this.rv) - this.w.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private long q() {
            Date date = this.q;
            long jMax = date != null ? Math.max(0L, this.tj - date.getTime()) : 0L;
            if (this.d != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.d));
            }
            long j = this.tj;
            return jMax + (j - this.rv) + (this.n - j);
        }

        private boolean l() {
            return this.s.oa().s() == -1 && this.fs == null;
        }

        private static boolean n(h hVar) {
            return (hVar.n("If-Modified-Since") == null && hVar.n("If-None-Match") == null) ? false : true;
        }
    }
}
