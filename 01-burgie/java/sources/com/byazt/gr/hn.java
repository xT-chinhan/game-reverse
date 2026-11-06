package com.byazt.gr;

import com.byazt.jv.b;
import com.byazt.jv.gz;
import com.byazt.jv.lb;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 691, 20})
public final class hn {
    public final gz hw;
    public final b pr;

    public hn(b bVar, gz gzVar) {
        this.pr = bVar;
        this.hw = gzVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        if (r3.m().x() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean pr(com.byazt.jv.gz r3, com.byazt.jv.b r4) {
        /*
            int r0 = r3.x()
            r1 = 0
            switch(r0) {
                case 200: goto L31;
                case 203: goto L31;
                case 204: goto L31;
                case 300: goto L31;
                case 301: goto L31;
                case 302: goto L9;
                case 307: goto L9;
                case 308: goto L31;
                case 404: goto L31;
                case 405: goto L31;
                case 410: goto L31;
                case 414: goto L31;
                case 501: goto L31;
                default: goto L8;
            }
        L8:
            goto L49
        L9:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.hw(r0)
            if (r0 != 0) goto L32
            com.byazt.jv.x r0 = r3.m()
            int r0 = r0.hn()
            r2 = -1
            if (r0 != r2) goto L32
            com.byazt.jv.x r0 = r3.m()
            boolean r0 = r0.c()
            if (r0 != 0) goto L32
            com.byazt.jv.x r0 = r3.m()
            boolean r0 = r0.x()
            if (r0 != 0) goto L32
            goto L49
        L31:
        L32:
            com.byazt.jv.x r3 = r3.m()
            boolean r3 = r3.hw()
            if (r3 != 0) goto L48
            com.byazt.jv.x r3 = r4.fw()
            boolean r3 = r3.hw()
            if (r3 != 0) goto L48
            r3 = 1
            return r3
        L48:
            return r1
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.gr.hn.pr(com.byazt.jv.gz, com.byazt.jv.b):boolean");
    }

    @com.byazt.vzx.pr(pr = {0, 1, 691, 116})
    public static class pr {
        public long aj;
        public String c;
        public String fw;
        public final gz hn;
        public final b hw;
        public int k;
        public final long pr;
        public Date uc;
        public long vk;
        public String w;
        public Date x;
        public Date zo;

        public pr(long j, b bVar, gz gzVar) {
            this.k = -1;
            this.pr = j;
            this.hw = bVar;
            this.hn = gzVar;
            if (gzVar != null) {
                this.aj = gzVar.g();
                this.vk = gzVar.ho();
                lb lbVarZo = gzVar.zo();
                int iPr = lbVarZo.pr();
                for (int i = 0; i < iPr; i++) {
                    String strPr = lbVarZo.pr(i);
                    String strHw = lbVarZo.hw(i);
                    if ("Date".equalsIgnoreCase(strPr)) {
                        this.x = com.byazt.osx.x.pr(strHw);
                        this.c = strHw;
                    } else if ("Expires".equalsIgnoreCase(strPr)) {
                        this.zo = com.byazt.osx.x.pr(strHw);
                    } else if ("Last-Modified".equalsIgnoreCase(strPr)) {
                        this.uc = com.byazt.osx.x.pr(strHw);
                        this.fw = strHw;
                    } else if ("ETag".equalsIgnoreCase(strPr)) {
                        this.w = strHw;
                    } else if ("Age".equalsIgnoreCase(strPr)) {
                        this.k = com.byazt.osx.c.hw(strHw, -1);
                    }
                }
            }
        }

        public hn pr() {
            hn hnVarHw = hw();
            if (hnVarHw.pr != null && this.hw.fw().aj()) {
                return new hn(null, null);
            }
            return hnVarHw;
        }

        private hn hw() {
            long millis;
            if (this.hn == null) {
                return new hn(this.hw, null);
            }
            if (this.hw.zo() && this.hn.fw() == null) {
                return new hn(this.hw, null);
            }
            if (!hn.pr(this.hn, this.hw)) {
                return new hn(this.hw, null);
            }
            com.byazt.jv.x xVarFw = this.hw.fw();
            if (xVarFw.pr() || pr(this.hw)) {
                return new hn(this.hw, null);
            }
            com.byazt.jv.x xVarM = this.hn.m();
            if (xVarM.vk()) {
                return new hn(null, this.hn);
            }
            long jX = x();
            long jHn = hn();
            if (xVarFw.hn() != -1) {
                jHn = Math.min(jHn, TimeUnit.SECONDS.toMillis(xVarFw.hn()));
            }
            long millis2 = 0;
            if (xVarFw.zo() == -1) {
                millis = 0;
            } else {
                millis = TimeUnit.SECONDS.toMillis(xVarFw.zo());
            }
            if (!xVarM.uc() && xVarFw.fw() != -1) {
                millis2 = TimeUnit.SECONDS.toMillis(xVarFw.fw());
            }
            if (!xVarM.pr()) {
                long j = millis + jX;
                if (j < millis2 + jHn) {
                    gz.pr prVarVk = this.hn.vk();
                    if (j >= jHn) {
                        prVarVk.pr("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jX > 86400000 && c()) {
                        prVarVk.pr("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new hn(null, prVarVk.pr());
                }
            }
            String str = this.w;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.uc != null) {
                str = this.fw;
            } else if (this.x != null) {
                str = this.c;
            } else {
                return new hn(this.hw, null);
            }
            lb.pr prVarHw = this.hw.hn().hw();
            com.byazt.xx.pr.pr.pr(prVarHw, str2, str);
            return new hn(this.hw.uc().pr(prVarHw.pr()).pr(), this.hn);
        }

        private long hn() {
            com.byazt.jv.x xVarM = this.hn.m();
            if (xVarM.hn() != -1) {
                return TimeUnit.SECONDS.toMillis(xVarM.hn());
            }
            if (this.zo != null) {
                Date date = this.x;
                long time = this.zo.getTime() - (date != null ? date.getTime() : this.vk);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.uc == null || this.hn.hw().pr().query() != null) {
                return 0L;
            }
            Date date2 = this.x;
            long time2 = (date2 != null ? date2.getTime() : this.aj) - this.uc.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private long x() {
            Date date = this.x;
            long jMax = date != null ? Math.max(0L, this.vk - date.getTime()) : 0L;
            if (this.k != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.k));
            }
            long j = this.vk;
            return jMax + (j - this.aj) + (this.pr - j);
        }

        private boolean c() {
            return this.hn.m().hn() == -1 && this.zo == null;
        }

        private static boolean pr(b bVar) {
            return (bVar.pr("If-Modified-Since") == null && bVar.pr("If-None-Match") == null) ? false : true;
        }
    }
}
