package com.byazt.tj;

import android.text.TextUtils;
import com.byazt.hg.cr;
import com.byazt.hg.ie;
import com.byazt.hg.iy;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1478, 37})
public final class pr {
    public final String aj;
    public final String c;
    public final String fw;
    public final String hn;
    public final int hw;
    public final String pr;
    public final String uc;
    public final String vk;
    public final String x;
    public final String zo;

    private pr(C0197pr c0197pr) {
        this.pr = pr(c0197pr.pr);
        this.hw = c0197pr.hw;
        this.hn = pr(c0197pr.hn);
        this.x = pr(c0197pr.x);
        this.c = pr(c0197pr.c);
        this.aj = pr(c0197pr.aj);
        this.vk = pr(c0197pr.vk);
        this.uc = pr(c0197pr.uc);
        this.fw = pr(c0197pr.fw);
        this.zo = pr(c0197pr.zo);
    }

    private static String pr(String str) {
        return str == null ? "" : str;
    }

    public static pr pr(com.byazt.ewt.pr prVar) {
        if (prVar == null || TextUtils.isEmpty(prVar.hw())) {
            return null;
        }
        return new C0197pr().pr(prVar.hw()).pr(prVar.ho).pr();
    }

    public String pr() {
        return this.pr;
    }

    public String hw() {
        return this.aj;
    }

    public String hn() {
        return this.vk;
    }

    public int x() {
        return this.hw;
    }

    public String c() {
        return this.hn;
    }

    public String uc() {
        return this.x;
    }

    public String fw() {
        return this.c;
    }

    public String zo() {
        return this.uc;
    }

    public String aj() {
        return this.fw;
    }

    public String vk() {
        return this.zo;
    }

    /* JADX INFO: renamed from: com.byazt.tj.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1478, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static final class C0197pr {
        public String aj;
        public String c;
        public String fw;
        public String hn;
        public int hw;
        public String pr;
        public String uc;
        public String vk;
        public String x;
        public String zo;

        public C0197pr pr(String str) {
            this.pr = str;
            return this;
        }

        public C0197pr pr(of ofVar) {
            if (ofVar == null) {
                return this;
            }
            this.x = ls.hn(ofVar, "");
            this.hn = ls.hw(ofVar, "");
            this.vk = ls.pr(ofVar, "");
            this.aj = ls.yb(ofVar);
            this.c = ofVar.B_();
            this.hw = ls.k(ofVar);
            this.uc = hw(ofVar);
            this.fw = hn(ofVar);
            this.zo = x(ofVar);
            return this;
        }

        public pr pr() {
            return new pr(this);
        }

        private static String hw(of ofVar) {
            try {
                String strAj = com.byazt.ja.pr.aj(ofVar);
                return strAj == null ? "" : strAj;
            } catch (Throwable th) {
                return "";
            }
        }

        private static String hn(of ofVar) {
            try {
                cr crVarZo = ie.zo(ofVar);
                if (crVarZo != null) {
                    return crVarZo.pr();
                }
                iy iyVarFw = ie.fw(ofVar);
                if (iyVarFw == null) {
                    return "";
                }
                return iyVarFw.hw();
            } catch (Throwable th) {
                return "";
            }
        }

        private static String x(of ofVar) {
            String strAj;
            try {
                iy iyVarFw = ie.fw(ofVar);
                return (iyVarFw == null || (strAj = iyVarFw.aj()) == null) ? "" : strAj;
            } catch (Throwable th) {
                return "";
            }
        }
    }
}
