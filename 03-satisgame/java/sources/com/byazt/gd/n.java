package com.byazt.gd;

import android.text.TextUtils;
import com.byazt.gct.dw;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.su;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 916, 19})
public final class n {
    public final String fs;
    public final String l;
    public final String n;
    public final String q;
    public final int qg;
    public final String rv;
    public final String s;
    public final String tj;
    public final String w;
    public final String x;

    private static String n(String str) {
        return str == null ? "" : str;
    }

    private n(C0179n c0179n) {
        this.n = n(c0179n.n);
        this.qg = c0179n.qg;
        this.s = n(c0179n.s);
        this.q = n(c0179n.q);
        this.l = n(c0179n.l);
        this.rv = n(c0179n.rv);
        this.tj = n(c0179n.tj);
        this.w = n(c0179n.w);
        this.x = n(c0179n.x);
        this.fs = n(c0179n.fs);
    }

    public static n n(com.byazt.wea.n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.n())) {
            return null;
        }
        return new C0179n().n(nVar.n()).n(nVar.q).n();
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.rv;
    }

    public String s() {
        return this.tj;
    }

    public int q() {
        return this.qg;
    }

    public String l() {
        return this.s;
    }

    public String w() {
        return this.q;
    }

    public String x() {
        return this.l;
    }

    public String fs() {
        return this.w;
    }

    public String rv() {
        return this.x;
    }

    public String tj() {
        return this.fs;
    }

    /* JADX INFO: renamed from: com.byazt.gd.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 916, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static final class C0179n {
        public String fs;
        public String l;
        public String n;
        public String q;
        public int qg;
        public String rv;
        public String s;
        public String tj;
        public String w;
        public String x;

        public C0179n n(String str) {
            this.n = str;
            return this;
        }

        public C0179n n(pk pkVar) {
            if (pkVar == null) {
                return this;
            }
            this.q = w.s(pkVar, "");
            this.s = w.qg(pkVar, "");
            this.tj = w.n(pkVar, "");
            this.rv = w.a(pkVar);
            this.l = pkVar.F_();
            this.qg = w.d(pkVar);
            this.w = qg(pkVar);
            this.x = s(pkVar);
            this.fs = q(pkVar);
            return this;
        }

        public n n() {
            return new n(this);
        }

        private static String qg(pk pkVar) {
            try {
                String strRv = com.byazt.aci.n.rv(pkVar);
                return strRv == null ? "" : strRv;
            } catch (Throwable unused) {
                return "";
            }
        }

        private static String s(pk pkVar) {
            try {
                su suVarFs = nf.fs(pkVar);
                if (suVarFs != null) {
                    return suVarFs.n();
                }
                dw dwVarX = nf.x(pkVar);
                if (dwVarX != null) {
                    return dwVarX.qg();
                }
                return "";
            } catch (Throwable unused) {
            }
        }

        private static String q(pk pkVar) {
            String strRv;
            try {
                dw dwVarX = nf.x(pkVar);
                return (dwVarX == null || (strRv = dwVarX.rv()) == null) ? "" : strRv;
            } catch (Throwable unused) {
                return "";
            }
        }
    }
}
