package com.byazt.lh;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.byazt.hkc.cp;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1475, 21})
public class x {
    public w l;
    public int n;
    public JSONObject q;
    public String qg;
    public String s;
    public l w;
    public String x;

    public x(l lVar) {
        this.w = lVar;
        this.n = lVar.n();
        this.qg = lVar.qg();
        this.s = lVar.s();
        this.q = lVar.l().kc();
        this.x = lVar.q();
        if (com.byazt.twc.q.qg() == 1) {
            this.l = lVar.x();
        } else {
            this.l = lVar.l();
        }
        if (com.byazt.twc.q.n()) {
            this.l = lVar.l();
        }
    }

    public int n() {
        return (int) this.l.sz();
    }

    public int qg() {
        return (int) this.l.hd();
    }

    public int s() {
        return (int) this.l.k();
    }

    public int q() {
        return (int) this.l.cy();
    }

    public float l() {
        return this.l.cd();
    }

    public String w() {
        if (this.n != 0) {
            return "";
        }
        if (!TextUtils.isEmpty(this.qg)) {
            return this.qg;
        }
        return this.q.optString(com.byazt.cq.fs.q(com.byazt.twc.q.getContext()));
    }

    public int x() {
        return n(this.l.ou());
    }

    public int fs() {
        String strPy = this.l.py();
        if ("left".equals(strPy)) {
            return 17;
        }
        if ("center".equals(strPy)) {
            return 4;
        }
        return "right".equals(strPy) ? 3 : 2;
    }

    public int rv() {
        int iFs = fs();
        if (iFs == 4) {
            return 17;
        }
        return iFs == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String tj() {
        int i = this.n;
        return (i == 2 || i == 13) ? this.qg : "";
    }

    public String cp() {
        int i = this.n;
        return (i == 1 || i == 29) ? this.qg : "";
    }

    public String d() {
        return this.x;
    }

    public double oa() {
        if (this.n == 11) {
            try {
                double d = Double.parseDouble(this.qg);
                return !com.byazt.twc.q.n() ? (int) d : d;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double sz() {
        return this.l.um();
    }

    public float k() {
        return this.l.cp();
    }

    public int cy() {
        return n(this.l.h());
    }

    public float hd() {
        return this.l.d();
    }

    public int cd() {
        return this.l.qn();
    }

    public int um() {
        return this.l.il();
    }

    public boolean a() {
        return this.l.bz();
    }

    public String py() {
        return this.l.m();
    }

    public void n(float f) {
        this.l.n(f);
    }

    public boolean ou() {
        return this.l.u();
    }

    public int wm() {
        return this.l.pk();
    }

    public String m() {
        return this.l.fi();
    }

    public String hu() {
        return this.l.ct();
    }

    public long h() {
        return this.l.ca();
    }

    public int t() {
        String strFi = this.l.fi();
        if ("skip-with-time-skip-btn".equals(this.w.getType()) || "skip".equals(this.w.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.w.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.w.getType()) && !"skip-with-time".equals(this.w.getType())) {
            if (this.n == 10 && TextUtils.equals(this.l.df(), "click")) {
                return 5;
            }
            if (g() && ry()) {
                return 0;
            }
            if (g()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.w.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strFi) && !strFi.equals(LiveConfigKey.NONE)) {
                if (strFi.equals(MediaFormat.KEY_VIDEO) || (this.w.n() == 7 && TextUtils.equals(strFi, "normal"))) {
                    return (com.byazt.twc.q.n() && this.w.l() != null && this.w.l().qh()) ? 11 : 4;
                }
                if (strFi.equals("normal")) {
                    return 1;
                }
                return (strFi.equals("creative") || "slide".equals(this.l.df())) ? 2 : 0;
            }
        }
        return 0;
    }

    private boolean g() {
        return (com.byazt.twc.q.n() && (this.w.getType().contains("logo-union") || this.w.getType().contains("logounion") || this.w.getType().contains("logoad"))) || "logo-union".equals(this.w.getType()) || "logounion".equals(this.w.getType()) || "logoad".equals(this.w.getType());
    }

    public int ur() {
        return n(this.l.wm());
    }

    public double bb() {
        return this.l.fs();
    }

    public int ln() {
        return this.l.s();
    }

    public int lh() {
        return this.l.qg();
    }

    public int v() {
        return this.l.l();
    }

    public int j() {
        return this.l.q();
    }

    public int an() {
        return this.l.rv();
    }

    public String ae() {
        return this.l.tj();
    }

    public String f() {
        return this.l.df();
    }

    private boolean ry() {
        if (com.byazt.twc.q.n()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.qg) && this.qg.contains("adx:")) || cp.qg();
    }

    public static int n(String str) {
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
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    public static float[] qg(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public boolean n(int i) {
        l lVar = this.w;
        if (lVar == null) {
            return false;
        }
        if (i == 1) {
            this.l = lVar.x();
        } else {
            this.l = lVar.l();
        }
        return this.l != null;
    }

    public boolean fi() {
        return this.l.dn();
    }

    public int df() {
        return this.l.el();
    }

    public int oj() {
        return this.l.he();
    }

    public String dg() {
        return this.l.f();
    }

    public boolean u() {
        return this.l.r();
    }

    public int pk() {
        return this.l.x();
    }

    public int wo() {
        return this.l.ze();
    }

    public int sh() {
        return this.l.eq();
    }

    public int y() {
        return this.l.mz();
    }

    public int rf() {
        return this.l.ry();
    }

    public boolean dh() {
        return this.l.sq();
    }

    public String b() {
        return this.l.bb();
    }

    public String ri() {
        return this.l.ei();
    }

    public String nf() {
        return this.l.ox();
    }

    public boolean pe() {
        return this.l.oa();
    }

    public boolean e() {
        return this.l.lh();
    }

    public String yw() {
        return this.l.ln();
    }

    public int cx() {
        return this.l.v();
    }

    public int lq() {
        return this.l.j();
    }

    public double ic() {
        return this.l.an();
    }

    public double ci() {
        return this.l.ae();
    }

    public int hf() {
        return this.l.dm();
    }

    public String kc() {
        return this.l.lg();
    }

    public String z() {
        return this.l.ju();
    }

    public boolean dn() {
        return this.l.ta();
    }

    public int he() {
        return this.l.np();
    }

    public int el() {
        return this.l.xi();
    }

    public int vb() {
        return this.l.wv();
    }

    public boolean fl() {
        return this.l.sq();
    }

    public String i() {
        return this.l.hu();
    }

    public String dw() {
        return this.n == 29 ? this.s : "";
    }

    public List<String> su() {
        return this.l.iz();
    }

    public boolean ha() {
        return this.l.of();
    }
}
