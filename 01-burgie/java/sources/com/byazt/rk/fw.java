package com.byazt.rk;

import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.byazt.uko.w;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1536, 62})
public class fw {
    public uc c;
    public String fw;
    public String hn;
    public String hw;
    public int pr;
    public c uc;
    public JSONObject x;

    public fw(c cVar) {
        this.uc = cVar;
        this.pr = cVar.pr();
        this.hw = cVar.hw();
        this.hn = cVar.hn();
        this.x = cVar.c().d();
        this.fw = cVar.x();
        if (com.byazt.dj.x.hw() == 1) {
            this.c = cVar.fw();
        } else {
            this.c = cVar.c();
        }
        if (com.byazt.dj.x.pr()) {
            this.c = cVar.c();
        }
    }

    public int pr() {
        return (int) this.c.g();
    }

    public int hw() {
        return (int) this.c.yb();
    }

    public int hn() {
        return (int) this.c.ho();
    }

    public int x() {
        return (int) this.c.nt();
    }

    public float c() {
        return this.c.lb();
    }

    public String uc() {
        if (this.pr == 0) {
            if (!TextUtils.isEmpty(this.hw)) {
                return this.hw;
            }
            return this.x.optString(com.byazt.js.zo.x(com.byazt.dj.x.getContext()));
        }
        return "";
    }

    public int fw() {
        return pr(this.c.ny());
    }

    public int zo() {
        String strCz = this.c.cz();
        if ("left".equals(strCz)) {
            return 17;
        }
        if ("center".equals(strCz)) {
            return 4;
        }
        if ("right".equals(strCz)) {
            return 3;
        }
        return 2;
    }

    public int aj() {
        int iZo = zo();
        if (iZo == 4) {
            return 17;
        }
        if (iZo == 3) {
            return GravityCompat.END;
        }
        return GravityCompat.START;
    }

    public String vk() {
        int i = this.pr;
        if (i == 2 || i == 13) {
            return this.hw;
        }
        return "";
    }

    public String w() {
        int i = this.pr;
        if (i == 1 || i == 29) {
            return this.hw;
        }
        return "";
    }

    public String k() {
        return this.fw;
    }

    public double m() {
        if (this.pr != 11) {
            return -1.0d;
        }
        try {
            double d = Double.parseDouble(this.hw);
            if (!com.byazt.dj.x.pr()) {
                return (int) d;
            }
            return d;
        } catch (NumberFormatException e) {
            return -1.0d;
        }
    }

    public double g() {
        return this.c.qa();
    }

    public float ho() {
        return this.c.w();
    }

    public int nt() {
        return pr(this.c.b());
    }

    public float yb() {
        return this.c.k();
    }

    public int lb() {
        return this.c.ku();
    }

    public int qa() {
        return this.c.fs();
    }

    public boolean a() {
        return this.c.xg();
    }

    public String cz() {
        return this.c.rc();
    }

    public void pr(float f) {
        this.c.pr(f);
    }

    public boolean ny() {
        return this.c.of();
    }

    public int fo() {
        return this.c.ii();
    }

    public String rc() {
        return this.c.er();
    }

    public String z() {
        return this.c.om();
    }

    public long b() {
        return this.c.wm();
    }

    public int iu() {
        String strEr = this.c.er();
        if ("skip-with-time-skip-btn".equals(this.uc.getType()) || "skip".equals(this.uc.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.uc.getType())) {
            return 6;
        }
        if ("skip-with-time-countdown".equals(this.uc.getType()) || "skip-with-time".equals(this.uc.getType())) {
            return 0;
        }
        if (this.pr == 10 && TextUtils.equals(this.c.v(), "click")) {
            return 5;
        }
        if (ey() && qv()) {
            return 0;
        }
        if (ey()) {
            return 7;
        }
        if ("feedback-dislike".equals(this.uc.getType())) {
            return 3;
        }
        if (TextUtils.isEmpty(strEr) || strEr.equals("none")) {
            return 0;
        }
        if (strEr.equals("video") || (this.uc.pr() == 7 && TextUtils.equals(strEr, "normal"))) {
            if (com.byazt.dj.x.pr() && this.uc.c() != null && this.uc.c().uk()) {
                return 11;
            }
            return 4;
        }
        if (strEr.equals("normal")) {
            return 1;
        }
        return (strEr.equals(ProviderInteractionViews.ROLE_CREATIVE) || "slide".equals(this.c.v())) ? 2 : 0;
    }

    private boolean ey() {
        return (com.byazt.dj.x.pr() && (this.uc.getType().contains("logo-union") || this.uc.getType().contains("logounion") || this.uc.getType().contains("logoad"))) || "logo-union".equals(this.uc.getType()) || "logounion".equals(this.uc.getType()) || "logoad".equals(this.uc.getType());
    }

    public int ve() {
        return pr(this.c.fo());
    }

    public double gz() {
        return this.c.zo();
    }

    public int nl() {
        return this.c.hn();
    }

    public int y() {
        return this.c.hw();
    }

    public int ww() {
        return this.c.c();
    }

    public int n() {
        return this.c.x();
    }

    public int e() {
        return this.c.aj();
    }

    public String s() {
        return this.c.vk();
    }

    public String ls() {
        return this.c.v();
    }

    private boolean qv() {
        if (com.byazt.dj.x.pr()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.hw) && this.hw.contains("adx:")) || w.hw();
    }

    public static int pr(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
                }
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    public static float[] hw(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (strArrSplit != null && strArrSplit.length == 4) {
            return new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
        }
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public boolean pr(int i) {
        c cVar = this.uc;
        if (cVar == null) {
            return false;
        }
        if (i == 1) {
            this.c = cVar.fw();
        } else {
            this.c = cVar.c();
        }
        return this.c != null;
    }

    public boolean er() {
        return this.c.jw();
    }

    public int v() {
        return this.c.aa();
    }

    public int qi() {
        return this.c.wt();
    }

    public String qn() {
        return this.c.ls();
    }

    public boolean of() {
        return this.c.mr();
    }

    public int ii() {
        return this.c.fw();
    }

    public int i() {
        return this.c.p();
    }

    public int r() {
        return this.c.oj();
    }

    public int hs() {
        return this.c.ag();
    }

    public int nw() {
        return this.c.qv();
    }

    public boolean ie() {
        return this.c.qx();
    }

    public String o() {
        return this.c.gz();
    }

    public String f() {
        return this.c.fe();
    }

    public String bm() {
        return this.c.lj();
    }

    public boolean jn() {
        return this.c.m();
    }

    public boolean l() {
        return this.c.y();
    }

    public String lv() {
        return this.c.nl();
    }

    public int od() {
        return this.c.ww();
    }

    public int vj() {
        return this.c.n();
    }

    public double mw() {
        return this.c.e();
    }

    public double sv() {
        return this.c.s();
    }

    public int gu() {
        return this.c.ks();
    }

    public String d() {
        return this.c.yj();
    }

    public String pq() {
        return this.c.u();
    }

    public boolean jw() {
        return this.c.np();
    }

    public int wt() {
        return this.c.rk();
    }

    public int aa() {
        return this.c.na();
    }

    public int iy() {
        return this.c.eh();
    }

    public boolean cr() {
        return this.c.qx();
    }

    public String j() {
        return this.c.z();
    }

    public String qo() {
        if (this.pr == 29) {
            return this.hn;
        }
        return "";
    }

    public List<String> bh() {
        return this.c.hg();
    }

    public boolean pj() {
        return this.c.su();
    }
}
