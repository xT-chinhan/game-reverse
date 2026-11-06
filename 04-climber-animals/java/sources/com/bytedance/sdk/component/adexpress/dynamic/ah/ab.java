package com.bytedance.sdk.component.adexpress.dynamic.ah;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.sdk.component.adexpress.dynamic.d.hi;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    private String ab;
    public String ah;
    private ka c;
    public JSONObject d;
    private c ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f758ms;
    public String xr;

    public ab(ka kaVar) {
        this.c = kaVar;
        this.f758ms = kaVar.ms();
        this.xr = kaVar.xr();
        this.ah = kaVar.ah();
        this.d = kaVar.ka().sk();
        this.ab = kaVar.d();
        if (com.bytedance.sdk.component.adexpress.d.xr() == 1) {
            this.ka = kaVar.ab();
        } else {
            this.ka = kaVar.ka();
        }
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            this.ka = kaVar.ka();
        }
    }

    public int ms() {
        return (int) this.ka.u();
    }

    public int xr() {
        return (int) this.ka.h();
    }

    public int ah() {
        return (int) this.ka.ub();
    }

    public int d() {
        return (int) this.ka.ao();
    }

    public float ka() {
        return this.ka.qv();
    }

    public String c() {
        if (this.f758ms != 0) {
            return "";
        }
        if (!TextUtils.isEmpty(this.xr)) {
            return this.xr;
        }
        return this.d.optString(com.bytedance.sdk.component.adexpress.d.x.d(com.bytedance.sdk.component.adexpress.d.getContext()));
    }

    public int ab() {
        return ms(this.ka.b());
    }

    public int x() {
        String strNw = this.ka.nw();
        if ("left".equals(strNw)) {
            return 17;
        }
        if ("center".equals(strNw)) {
            return 4;
        }
        return "right".equals(strNw) ? 3 : 2;
    }

    public int ny() {
        int iX = x();
        if (iX == 4) {
            return 17;
        }
        return iX == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String ch() {
        int i = this.f758ms;
        return (i == 2 || i == 13) ? this.xr : "";
    }

    public String hi() {
        int i = this.f758ms;
        return (i == 1 || i == 29) ? this.xr : "";
    }

    public String sl() {
        return this.ab;
    }

    public double zb() {
        if (this.f758ms == 11) {
            try {
                double d = Double.parseDouble(this.xr);
                return !com.bytedance.sdk.component.adexpress.d.ms() ? (int) d : d;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double u() {
        return this.ka.y();
    }

    public float ub() {
        return this.ka.hi();
    }

    public int ao() {
        return ms(this.ka.yu());
    }

    public float h() {
        return this.ka.sl();
    }

    public int qv() {
        return this.ka.si();
    }

    public int y() {
        return this.ka.di();
    }

    public boolean t() {
        return this.ka.pl();
    }

    public String nw() {
        return this.ka.i();
    }

    public void ms(float f) {
        this.ka.ms(f);
    }

    public boolean b() {
        return this.ka.k();
    }

    public int re() {
        return this.ka.eg();
    }

    public String i() {
        return this.ka.az();
    }

    public String w() {
        return this.ka.vx();
    }

    public long yu() {
        return this.ka.nq();
    }

    public int op() {
        String strAz = this.ka.az();
        if ("skip-with-time-skip-btn".equals(this.c.getType()) || "skip".equals(this.c.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.c.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.c.getType()) && !"skip-with-time".equals(this.c.getType())) {
            if (this.f758ms == 10 && TextUtils.equals(this.ka.m(), "click")) {
                return 5;
            }
            if (zd() && z()) {
                return 0;
            }
            if (zd()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.c.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strAz) && !strAz.equals("none")) {
                if (strAz.equals("video") || (this.c.ms() == 7 && TextUtils.equals(strAz, PrerollVideoResponse.NORMAL))) {
                    return (com.bytedance.sdk.component.adexpress.d.ms() && this.c.ka() != null && this.c.ka().mh()) ? 11 : 4;
                }
                if (strAz.equals(PrerollVideoResponse.NORMAL)) {
                    return 1;
                }
                return (strAz.equals("creative") || "slide".equals(this.ka.m())) ? 2 : 0;
            }
        }
        return 0;
    }

    private boolean zd() {
        return (com.bytedance.sdk.component.adexpress.d.ms() && (this.c.getType().contains("logo-union") || this.c.getType().contains("logounion") || this.c.getType().contains("logoad"))) || "logo-union".equals(this.c.getType()) || "logounion".equals(this.c.getType()) || "logoad".equals(this.c.getType());
    }

    public int le() {
        return ms(this.ka.re());
    }

    public double cv() {
        return this.ka.x();
    }

    public int g() {
        return this.ka.ah();
    }

    public int of() {
        return this.ka.xr();
    }

    public int p() {
        return this.ka.ka();
    }

    public int pc() {
        return this.ka.d();
    }

    public int jw() {
        return this.ka.ny();
    }

    public String f() {
        return this.ka.ch();
    }

    public String ul() {
        return this.ka.m();
    }

    private boolean z() {
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.xr) && this.xr.contains("adx:")) || hi.xr();
    }

    public static int ms(String str) {
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

    public static float[] xr(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public boolean ms(int i) {
        ka kaVar = this.c;
        if (kaVar == null) {
            return false;
        }
        if (i == 1) {
            this.ka = kaVar.ab();
        } else {
            this.ka = kaVar.ka();
        }
        return this.ka != null;
    }

    public boolean az() {
        return this.ka.vl();
    }

    public int m() {
        return this.ka.ce();
    }

    public int lm() {
        return this.ka.qr();
    }

    public String e() {
        return this.ka.ul();
    }

    public boolean k() {
        return this.ka.vf();
    }

    public int eg() {
        return this.ka.ab();
    }

    public int fm() {
        return this.ka.wq();
    }

    public int xn() {
        return this.ka.wp();
    }

    public int il() {
        return this.ka.kl();
    }

    public int qf() {
        return this.ka.z();
    }

    public boolean l() {
        return this.ka.gs();
    }

    public String am() {
        return this.ka.cv();
    }

    public String sa() {
        return this.ka.r();
    }

    public String tz() {
        return this.ka.kk();
    }

    public boolean ti() {
        return this.ka.zb();
    }

    public boolean s() {
        return this.ka.of();
    }

    public String v() {
        return this.ka.g();
    }

    public int qk() {
        return this.ka.p();
    }

    public int vm() {
        return this.ka.pc();
    }

    public double zf() {
        return this.ka.jw();
    }

    public double rt() {
        return this.ka.f();
    }

    public int vy() {
        return this.ka.nl();
    }

    public String sk() {
        return this.ka.dv();
    }

    public String gy() {
        return this.ka.tk();
    }

    public boolean vl() {
        return this.ka.nn();
    }

    public int qr() {
        return this.ka.ec();
    }

    public int ce() {
        return this.ka.n();
    }

    public int jm() {
        return this.ka.o();
    }

    public boolean bz() {
        return this.ka.gs();
    }

    public String jy() {
        return this.ka.w();
    }

    public String j() {
        return this.f758ms == 29 ? this.ah : "";
    }

    public List<String> ih() {
        return this.ka.qd();
    }

    public boolean oh() {
        return this.ka.ir();
    }
}
