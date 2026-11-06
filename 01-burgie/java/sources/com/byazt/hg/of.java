package com.byazt.hg;

import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND})
public class of implements com.byazt.af.aj, com.byazt.af.k, com.byazt.af.m, com.byazt.af.vk, com.byazt.af.w {
    public String a;
    public String aa;
    public JSONObject ab;
    public ww ae;
    public String aj;
    public qi ax;
    public yb b;
    public int bg;
    public boolean bm;
    public boolean bt;
    public int c;
    public int cb;
    public int cg;
    public d cl;
    public String cz;
    public com.byazt.qe.hw d;
    public iu da;
    public String de;
    public int df;
    public JSONObject dl;
    public String ds;
    public int e;
    public String ei;
    public volatile String ej;
    public int er;
    public volatile String eu;
    public int ey;
    public long fe;
    public String ff;
    public JSONObject fh;
    public int fj;
    public ho fl;
    public String fs;
    public vj fw;
    public ie gb;
    public z gd;
    public int gx;
    public String gz;
    public f hg;
    public String hn;
    public String ho;
    public String hp;
    public String hw;
    public ve ic;
    public g id;
    public String io;
    public cz iq;
    public int iu;
    public boolean ja;
    public String ji;
    public String jl;
    public qa jn;
    public nw jo;
    public int jr;
    public int jv;
    public int jw;
    public JSONObject k;
    public String ke;
    public r kp;
    public String ks;
    public String ku;
    public Map<String, Object> l;
    public String lb;
    public int lj;
    public int lp;
    public qv ls;
    public jn lv;
    public JSONObject m;
    public int mb;
    public JSONObject mj;
    public s mo;
    public pq mr;
    public v mw;
    public uc mx;
    public long n;
    public int na;
    public rc nb;
    public JSONObject nl;
    public gu ob;
    public int oc;
    public o od;
    public String oj;
    public int ok;
    public b oq;
    public com.byazt.qk.pr ov;
    public String p;
    public JSONObject pj;
    public int pp;
    public int pq;
    public u pr;
    public int q;
    public long qa;
    public JSONObject qh;
    public boolean qi;
    public JSONObject qo;
    public int qr;
    public int qz;
    public c rc;
    public volatile JSONObject ri;
    public int rk;
    public String rq;
    public lv rr;
    public int s;
    public int sd;
    public w se;
    public String sh;
    public String sr;
    public er su;
    public boolean sx;
    public String tc;
    public boolean tk;
    public int tm;
    public lb tn;
    public int to;
    public aa tp;
    public String tt;
    public boolean tz;
    public int uc;
    public boolean ug;
    public boolean uj;
    public String uk;
    public od ul;
    public com.byazt.ze.pr uv;
    public boolean v;
    public String ve;
    public String w;
    public hs wo;
    public long ww;
    public String wx;
    public boolean wz;
    public com.byazt.dw.hw x;
    public String xb;
    public long xg;
    public wt xi;
    public int xk;
    public JSONObject xn;
    public e xv;
    public int xy;
    public String y;
    public String yj;
    public boolean yn;
    public a z;
    public int zc;
    public long zj;
    public y zo;
    public ii zs;
    public JSONObject zz;
    public int vk = -1;
    public List<y> g = new ArrayList();
    public List<String> nt = new ArrayList();
    public List<String> yb = new ArrayList();
    public String ny = "0";
    public String fo = "0";
    public int qn = 100;
    public long of = -1;
    public long ii = -1;
    public long i = -1;
    public int r = -1;
    public int hs = 1;
    public long nw = System.currentTimeMillis();
    public String ie = UUID.randomUUID().toString();
    public int o = 1;
    public String f = "";
    public boolean vj = false;
    public int sv = -200;
    public int gu = 0;
    public int wt = 1;
    public int iy = 0;
    public int cr = 0;
    public int j = 0;
    public int bh = 1;
    public int qv = 0;
    public int u = 0;
    public int np = 0;
    public int eh = 0;
    public int ag = 1;
    public boolean qx = false;
    public int h = 1;
    public float t = 100.0f;
    public int vv = 0;
    public int tv = 2;
    public int om = 0;
    public int wm = 100;
    public int gg = 2;
    public int kl = 2;
    public float yc = 0.07f;
    public float ou = 0.0f;
    public long cu = 0;
    public boolean zx = true;
    public int jg = -1;
    public int vh = 0;
    public int jb = 0;
    public long td = 0;
    public int rf = 0;
    public List<nl> ig = new ArrayList();
    public int yl = -1;
    public int wn = 1;
    public int bo = AVMDLDataLoader.AVMDLErrorIsTheSameKeyTask;

    public String pr() {
        return this.ej;
    }

    public void pr(String str) {
        this.ej = str;
    }

    public void pr(nl nlVar) {
        if (nlVar == null) {
            return;
        }
        if (this.ig == null) {
            this.ig = new ArrayList();
        }
        this.ig.add(nlVar);
    }

    public nl hw(String str) {
        List<nl> list = this.ig;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < this.ig.size(); i++) {
            nl nlVar = this.ig.get(i);
            if (nlVar != null) {
                String strPr = nlVar.pr();
                if (!TextUtils.isEmpty(strPr) && strPr.equals(str)) {
                    return nlVar;
                }
            }
        }
        return null;
    }

    public synchronized String z() {
        if (TextUtils.isEmpty(this.eu)) {
            String strG = com.byazt.wt.ls.g(this);
            String strFo = fo();
            String strX = x();
            if (TextUtils.isEmpty(strG)) {
                strG = "0";
            }
            if (TextUtils.isEmpty(strX)) {
                strX = "0";
            }
            if (TextUtils.isEmpty(strFo)) {
                strFo = "0";
            }
            this.eu = strG + "_" + strFo + "_" + strX;
        }
        return this.eu;
    }

    @Override // com.byazt.af.m
    public boolean x_() {
        return this.bt;
    }

    public void pr(boolean z) {
        this.bt = z;
    }

    public boolean b() {
        return this.yl == 3;
    }

    public int iu() {
        return this.yl;
    }

    public void pr(int i) {
        this.yl = i;
    }

    public int ve() {
        return this.lp;
    }

    public void hw(int i) {
        this.lp = i;
    }

    public void hn(int i) {
        this.to = i;
    }

    @Override // com.byazt.af.vk
    public int fw() {
        return this.to;
    }

    public boolean gz() {
        return this.yn && ls();
    }

    public void hw(boolean z) {
        this.yn = z;
    }

    public void x(int i) {
        this.tm = i;
    }

    public void c(int i) {
        if (this.sd == 0) {
            this.sd = i;
        }
    }

    public int nl() {
        return this.sd;
    }

    public int y() {
        return this.tm;
    }

    public boolean ww() {
        return y() == 1;
    }

    public void uc(int i) {
        this.qz = i;
    }

    public int n() {
        return this.qz;
    }

    public boolean e() {
        return this.qz == 1;
    }

    public void fw(int i) {
        this.oc = i;
    }

    public int s() {
        return this.oc;
    }

    public boolean ls() {
        return s() == 1;
    }

    public void zo(int i) {
        this.jr = i;
    }

    public int er() {
        return this.jr;
    }

    public boolean v() {
        return er() == 1;
    }

    public String qi() {
        return this.io;
    }

    public void hn(String str) {
        this.io = str;
    }

    public void x(String str) {
        this.rq = str;
    }

    public String qn() {
        return this.rq;
    }

    public void pr(JSONObject jSONObject) {
        this.zz = jSONObject;
    }

    public JSONObject of() {
        return this.zz;
    }

    public boolean ii() {
        return this.ug;
    }

    public void hn(boolean z) {
        this.ug = z;
    }

    public boolean i() {
        return this.tk;
    }

    public void x(boolean z) {
        this.tk = z;
    }

    public boolean r() {
        return this.uj;
    }

    public void c(boolean z) {
        this.uj = z;
    }

    public String hs() {
        return this.tc;
    }

    public void c(String str) {
        this.tc = str;
    }

    public String nw() {
        return this.ke;
    }

    public void uc(String str) {
        this.ke = str;
    }

    public int ie() {
        return this.mb;
    }

    public void aj(int i) {
        this.mb = i;
    }

    public String o() {
        return this.ei;
    }

    public void fw(String str) {
        this.ei = str;
    }

    public String f() {
        return this.ji;
    }

    public void zo(String str) {
        this.ji = str;
    }

    public void uc(boolean z) {
        this.ja = z;
    }

    public boolean bm() {
        return this.ja;
    }

    public void hw(JSONObject jSONObject) {
        this.ri = jSONObject;
    }

    public JSONObject jn() {
        return this.ri;
    }

    public static boolean pr(of ofVar) {
        return ofVar != null && ofVar.pj() == 1;
    }

    public static boolean hw(of ofVar) {
        return ofVar != null && ofVar.ey() == 1;
    }

    public static boolean hn(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        if (ofVar.jg() != 5 && ofVar.jg() != 15 && ofVar.jg() != 166) {
            return false;
        }
        return true;
    }

    public static boolean x(of ofVar) {
        try {
            return ofVar.cg() != null && ofVar.cg().optInt("parent_type") == 1;
        } catch (Exception e) {
            return false;
        }
    }

    public long l() {
        return this.fe;
    }

    public void pr(long j) {
        this.fe = j;
    }

    public String lv() {
        return this.ks;
    }

    public void aj(String str) {
        this.ks = str;
    }

    public void hw(long j) {
        this.zj = j;
    }

    public long od() {
        return this.zj;
    }

    public void vk(int i) {
        this.qr = i;
    }

    public int vj() {
        if (lb.x(this)) {
            return 0;
        }
        return this.qr;
    }

    public com.byazt.qk.pr mw() {
        return this.ov;
    }

    public void pr(com.byazt.qk.pr prVar) {
        this.ov = prVar;
    }

    public void pr(com.byazt.ze.pr prVar) {
        this.uv = prVar;
    }

    public com.byazt.ze.pr sv() {
        return this.uv;
    }

    public String gu() {
        return this.sr;
    }

    public void vk(String str) {
        this.sr = str;
    }

    public boolean d() {
        return this.wz;
    }

    public void fw(boolean z) {
        this.wz = z;
    }

    public String pq() {
        return this.xb;
    }

    public void w(String str) {
        this.xb = str;
    }

    public String jw() {
        return this.fs;
    }

    public void k(String str) {
        this.fs = str;
    }

    public boolean wt() {
        return this.sx;
    }

    public void zo(boolean z) {
        this.sx = z;
    }

    public void hn(long j) {
        this.xg = j;
    }

    public String aa() {
        return this.ku;
    }

    public void m(String str) {
        this.ku = str;
    }

    public long iy() {
        return this.xg;
    }

    public void g(String str) {
        this.p = str;
    }

    public void w(int i) {
        this.jv = i;
    }

    public int cr() {
        return this.jv;
    }

    public int j() {
        return this.kl;
    }

    public void pr(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.kl = 2;
        } else {
            this.kl = (int) d;
        }
    }

    public int qo() {
        return this.gg;
    }

    public void hw(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.gg = 2;
        } else {
            this.gg = (int) d;
        }
    }

    public int bh() {
        return this.s;
    }

    public void k(int i) {
        this.s = i;
    }

    public int pj() {
        return this.eh;
    }

    public void m(int i) {
        this.eh = i;
    }

    public int ey() {
        return this.np;
    }

    public void g(int i) {
        this.np = i;
    }

    public jn qv() {
        return this.lv;
    }

    public void pr(jn jnVar) {
        this.lv = jnVar;
    }

    public ww u() {
        return this.ae;
    }

    public void pr(ww wwVar) {
        this.ae = wwVar;
    }

    public int np() {
        return this.iy;
    }

    public void ho(int i) {
        this.iy = i;
    }

    public boolean eh() {
        return this.iy == 1;
    }

    public nw na() {
        return this.jo;
    }

    public void pr(nw nwVar) {
        this.jo = nwVar;
    }

    public ie rk() {
        return this.gb;
    }

    public void pr(ie ieVar) {
        this.gb = ieVar;
    }

    @Override // com.byazt.af.w
    public String y_() {
        return this.sh;
    }

    public void ho(String str) {
        this.sh = str;
    }

    public int mr() {
        return this.zc;
    }

    public void nt(int i) {
        this.zc = i;
    }

    public lb ag() {
        return this.tn;
    }

    public void pr(lb lbVar) {
        this.tn = lbVar;
    }

    public gu qx() {
        return this.ob;
    }

    public void pr(gu guVar) {
        this.ob = guVar;
    }

    public int fe() {
        return this.j;
    }

    public void yb(int i) {
        this.j = i;
    }

    public int ks() {
        return this.jg;
    }

    public void lb(int i) {
        this.jg = i;
    }

    public int sr() {
        return this.cr;
    }

    public void qa(int i) {
        this.cr = i;
    }

    public int wz() {
        return this.wt;
    }

    public void a(int i) {
        this.wt = i;
    }

    public int xb() {
        if (oq() != 100.0f || ie.pr(this) == 2) {
            return 0;
        }
        return this.gu;
    }

    public void cz(int i) {
        this.gu = i;
    }

    public com.byazt.qe.hw p() {
        return this.d;
    }

    public void pr(com.byazt.qe.hw hwVar) {
        if (hwVar == null) {
            com.byazt.qe.hw hwVar2 = this.d;
            if (hwVar2 != null) {
                this.d = new hn(hwVar2);
                return;
            }
            return;
        }
        this.d = hwVar;
    }

    public int ku() {
        return this.pq;
    }

    public void ny(int i) {
        this.pq = i;
    }

    public int xg() {
        return this.jw;
    }

    public void fo(int i) {
        this.jw = i;
    }

    public int fs() {
        return this.sv;
    }

    public void rc(int i) {
        this.sv = i;
    }

    public int sx() {
        return this.bh;
    }

    public void z(int i) {
        this.bh = i;
    }

    public int uk() {
        return this.ey;
    }

    public void b(int i) {
        this.ey = i;
    }

    public void iu(int i) {
        this.ag = i;
    }

    public int oj() {
        return this.ag;
    }

    public int lj() {
        pq pqVar = this.mr;
        if (pqVar == null) {
            return 1;
        }
        return pqVar.pr();
    }

    public String h() {
        pq pqVar = this.mr;
        return pqVar == null ? "" : pqVar.hw();
    }

    public boolean t() {
        pq pqVar = this.mr;
        return pqVar == null || pqVar.hn();
    }

    public int yj() {
        pq pqVar = this.mr;
        if (pqVar == null) {
            return 50;
        }
        return pqVar.x();
    }

    public int vv() {
        pq pqVar = this.mr;
        if (pqVar == null) {
            return 236;
        }
        return pqVar.c();
    }

    public int tv() {
        pq pqVar = this.mr;
        if (pqVar == null) {
            return 82;
        }
        return pqVar.uc();
    }

    public int om() {
        pq pqVar = this.mr;
        if (pqVar == null) {
            return 56;
        }
        return pqVar.fw();
    }

    public int wm() {
        pq pqVar = this.mr;
        if (pqVar == null) {
            return 0;
        }
        return pqVar.aj();
    }

    public String wo() {
        pq pqVar = this.mr;
        return pqVar == null ? "#008DEA" : pqVar.vk();
    }

    public String hg() {
        pq pqVar = this.mr;
        return pqVar == null ? "点击查看" : pqVar.w();
    }

    public int su() {
        pq pqVar = this.mr;
        if (pqVar == null) {
            return 0;
        }
        return pqVar.zo();
    }

    public int gg() {
        return this.ok;
    }

    public void ve(int i) {
        this.ok = i;
    }

    public int kl() {
        return this.xk;
    }

    public void gz(int i) {
        this.xk = i;
    }

    public pq.hw xi() {
        pq pqVar = this.mr;
        if (pqVar != null) {
            return pqVar.k();
        }
        return null;
    }

    public pq.hw pp() {
        pq pqVar = this.mr;
        if (pqVar != null) {
            return pqVar.m();
        }
        return null;
    }

    public pq.pr q() {
        pq pqVar = this.mr;
        if (pqVar != null) {
            return pqVar.g();
        }
        return null;
    }

    private float iz() {
        pq pqVar = this.mr;
        if (pqVar == null) {
            return 5.0f;
        }
        return pqVar.ho();
    }

    public int bg() {
        wt wtVar = this.xi;
        if (wtVar == null) {
            return 2;
        }
        return wtVar.pr();
    }

    public int ok() {
        wt wtVar = this.xi;
        if (wtVar == null) {
            return 16;
        }
        return wtVar.hw();
    }

    public int xk() {
        wt wtVar = this.xi;
        if (wtVar == null) {
            return 30;
        }
        return wtVar.hn();
    }

    public int yc() {
        d dVar = this.cl;
        if (dVar == null) {
            return 0;
        }
        return dVar.pr();
    }

    public int ou() {
        d dVar = this.cl;
        if (dVar == null) {
            return 90;
        }
        return dVar.hw();
    }

    public int cl() {
        d dVar = this.cl;
        if (dVar == null) {
            return 90;
        }
        return dVar.hn();
    }

    @Override // com.byazt.af.aj
    public qa z_() {
        return this.jn;
    }

    public void pr(qa qaVar) {
        this.jn = qaVar;
    }

    public JSONObject fj() {
        return this.ab;
    }

    public void hn(JSONObject jSONObject) {
        this.ab = jSONObject;
    }

    public pq jl() {
        return this.mr;
    }

    public void pr(pq pqVar) {
        this.mr = pqVar;
    }

    @Override // com.byazt.af.aj
    public uc lb() {
        return this.mx;
    }

    public void pr(uc ucVar) {
        this.mx = ucVar;
    }

    public String xy() {
        return this.de;
    }

    public void nt(String str) {
        this.de = str;
    }

    public int cb() {
        return this.gx;
    }

    public void nl(int i) {
        this.gx = i;
    }

    public int fl() {
        return this.df;
    }

    public void y(int i) {
        if (i != 1) {
            i = 0;
        }
        this.df = i;
    }

    public void pr(qv qvVar) {
        this.ls = qvVar;
    }

    public qv wx() {
        return this.ls;
    }

    public int id() {
        return this.er;
    }

    public void ww(int i) {
        this.er = i;
    }

    public int ax() {
        int i = this.r;
        if (i == -1) {
            if (com.byazt.wt.ls.k(this) == 7) {
                return 0;
            }
            return (com.byazt.wt.ls.k(this) == 8 && oq() == 100.0f) ? 0 : 1;
        }
        return i;
    }

    public void n(int i) {
        this.r = i;
    }

    public boolean rr() {
        return this.hs == 1;
    }

    public int tp() {
        return this.hs;
    }

    public void e(int i) {
        this.hs = i;
    }

    public String zj() {
        return this.ve;
    }

    public void yb(String str) {
        this.ve = str;
    }

    @Override // com.byazt.af.vk
    public int aj() {
        return this.c;
    }

    public void s(int i) {
        this.c = i;
    }

    public int gb() {
        return this.uc;
    }

    public void ls(int i) {
        this.uc = i;
    }

    public vj jo() {
        return this.fw;
    }

    public int tn() {
        if (jo() != null) {
            return jo().hw();
        }
        return -1;
    }

    public boolean ob() {
        boolean z = jo() != null && jo().pr();
        if (z && gb() == 4) {
            return tn() >= 0;
        }
        return z;
    }

    public void pr(vj vjVar) {
        this.fw = vjVar;
    }

    public y mo() {
        return this.zo;
    }

    public void pr(y yVar) {
        this.zo = yVar;
    }

    @Override // com.byazt.af.vk
    public String hw() {
        if (mo() != null) {
            return mo().pr();
        }
        return "";
    }

    @Override // com.byazt.af.k
    public String zo() {
        return this.aj;
    }

    public void lb(String str) {
        this.aj = str;
    }

    public int xv() {
        return this.vk;
    }

    public void er(int i) {
        this.vk = i;
    }

    @Override // com.byazt.af.vk
    public String hn() {
        return this.w;
    }

    public void qa(String str) {
        this.w = str;
    }

    public JSONObject iq() {
        return this.k;
    }

    public void x(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    public JSONObject mx() {
        return this.m;
    }

    public void c(JSONObject jSONObject) {
        this.m = jSONObject;
    }

    public List<y> de() {
        return this.g;
    }

    public void hw(y yVar) {
        this.g.add(yVar);
    }

    public String gx() {
        return this.ho;
    }

    public void a(String str) {
        this.ho = str;
    }

    public List<String> df() {
        return this.nt;
    }

    public List<String> tt() {
        return this.yb;
    }

    @Override // com.byazt.af.vk
    public String A_() {
        return this.lb;
    }

    public void cz(String str) {
        this.lb = str;
    }

    public long cu() {
        return this.qa;
    }

    public void x(long j) {
        this.qa = j;
    }

    public String jv() {
        return this.a;
    }

    public void ny(String str) {
        this.a = str;
    }

    public String se() {
        return this.cz;
    }

    public void fo(String str) {
        this.cz = str;
    }

    @Override // com.byazt.af.aj
    public String x() {
        return this.ny;
    }

    public void rc(String str) {
        this.ny = str;
    }

    @Override // com.byazt.af.aj
    public c ho() {
        return this.rc;
    }

    public void pr(c cVar) {
        this.rc = cVar;
    }

    public a zx() {
        return this.z;
    }

    public void pr(a aVar) {
        this.z = aVar;
    }

    @Override // com.byazt.af.m
    public yb g() {
        return this.b;
    }

    public void pr(yb ybVar) {
        this.b = ybVar;
    }

    @Override // com.byazt.af.k
    public String B_() {
        return this.gz;
    }

    public void z(String str) {
        this.gz = str;
    }

    public int ab() {
        return this.na;
    }

    public void v(int i) {
        this.na = i;
    }

    public int io() {
        return this.rk;
    }

    public void qi(int i) {
        this.rk = Math.max(0, i);
    }

    @Override // com.byazt.af.aj
    public String ny() {
        return this.y;
    }

    public void b(String str) {
        this.y = str;
    }

    @Override // com.byazt.af.aj
    public String fo() {
        return this.fo;
    }

    public void iu(String str) {
        this.fo = str;
    }

    @Override // com.byazt.af.aj
    public JSONObject v_() {
        if (this.nl == null) {
            try {
                if (!TextUtils.isEmpty(this.gz)) {
                    this.nl = new JSONObject(this.gz);
                }
            } catch (JSONException e) {
            }
        }
        return this.nl;
    }

    public String tz() {
        try {
            return v_().optString("convert_id", null);
        } catch (Throwable th) {
            return null;
        }
    }

    public int jg() {
        return this.iu;
    }

    public void qn(int i) {
        this.iu = i;
    }

    public long hp() {
        return this.ww;
    }

    public void c(long j) {
        this.ww = j;
    }

    public long ke() {
        return this.n;
    }

    public void uc(long j) {
        this.n = j;
    }

    public int mb() {
        return this.e;
    }

    public void of(int i) {
        this.e = i;
    }

    public boolean ei() {
        return this.v;
    }

    public void aj(boolean z) {
        this.v = z;
    }

    public boolean ji() {
        return this.qi;
    }

    public void vk(boolean z) {
        this.qi = z;
    }

    public long ja() {
        return this.nw;
    }

    public void fw(long j) {
        this.nw = j;
    }

    public String ri() {
        return this.ie;
    }

    public void ve(String str) {
        this.ie = str;
    }

    public void ii(int i) {
        this.o = i;
    }

    public int tc() {
        return this.o;
    }

    public void gz(String str) {
        this.f = str;
    }

    public String nb() {
        return this.f;
    }

    public boolean gd() {
        return (TextUtils.isEmpty(com.byazt.wt.ls.g(this)) || TextUtils.isEmpty(this.f) || com.byazt.wt.ls.g(this).contains(this.f)) ? false : true;
    }

    public int w(boolean z) {
        if (this.qi || z) {
            return or();
        }
        return 102;
    }

    private int or() {
        return this.qn;
    }

    public void i(int i) {
        int i2 = this.qn;
        if (i2 == 100 || i2 == 102) {
            this.qn = i;
        }
    }

    public long mj() {
        return this.of;
    }

    public void zo(long j) {
        this.of = j;
    }

    public long vh() {
        return this.ii;
    }

    public void aj(long j) {
        this.ii = j;
    }

    public long ds() {
        return this.i;
    }

    public void vk(long j) {
        this.i = j;
    }

    public boolean sh() {
        return this.bm;
    }

    public void k(boolean z) {
        this.bm = z;
    }

    public Map<String, Object> zc() {
        return this.l;
    }

    public void pr(Map<String, Object> map) {
        this.l = map;
    }

    public JSONObject cg() {
        return this.qo;
    }

    public void uc(JSONObject jSONObject) {
        this.qo = jSONObject;
    }

    public JSONObject xn() {
        return this.pj;
    }

    public void fw(JSONObject jSONObject) {
        this.pj = jSONObject;
    }

    @Override // com.byazt.af.aj
    public String rc() {
        return this.aa;
    }

    public void nl(String str) {
        this.aa = str;
    }

    public int qh() {
        return this.qv;
    }

    @Override // com.byazt.af.aj
    public boolean C_() {
        return qh() == 1;
    }

    public void r(int i) {
        this.qv = i;
    }

    @Override // com.byazt.af.m
    public boolean yb() {
        return fh() == 1;
    }

    public int fh() {
        return this.u;
    }

    public void hs(int i) {
        this.u = i;
    }

    public String ic() {
        return this.hw;
    }

    public void y(String str) {
        this.hw = str;
    }

    public void pr(com.byazt.dw.hw hwVar) {
        this.x = hwVar;
    }

    public com.byazt.dw.hw ae() {
        com.byazt.pw.hw.pr();
        return this.x;
    }

    public hs zs() {
        return this.wo;
    }

    public void pr(hs hsVar) {
        this.wo = hsVar;
    }

    public s jb() {
        return this.mo;
    }

    public void pr(s sVar) {
        this.mo = sVar;
    }

    public String ug() {
        return this.oj;
    }

    public void ww(String str) {
        this.oj = str;
    }

    public boolean tk() {
        return uj() != 1;
    }

    public int uj() {
        return this.lj;
    }

    public void nw(int i) {
        this.lj = i;
    }

    public String td() {
        return this.uk;
    }

    public void n(String str) {
        this.uk = str;
    }

    public int rf() {
        if (this.h != 2) {
            this.h = 1;
        }
        return this.h;
    }

    public void ie(int i) {
        this.h = i;
    }

    public float oq() {
        if (this.t <= 0.0f) {
            this.t = 100.0f;
        }
        return (this.t * 1000.0f) / 1000.0f;
    }

    public void e(String str) {
        this.tt = str;
    }

    public String kp() {
        return this.tt;
    }

    public void w(long j) {
        if (j != 0) {
            this.cu = j;
        } else {
            this.cu = System.currentTimeMillis() / 1000;
        }
    }

    public long da() {
        return this.cu;
    }

    public void pr(float f) {
        this.t = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        of ofVar = (of) obj;
        if (this.ny.equals(ofVar.ny) && this.gz.equals(ofVar.gz)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.ny.hashCode() * 31) + this.gz.hashCode();
    }

    public boolean rq() {
        if (com.byazt.lpk.pr.pr(this)) {
            return true;
        }
        if (this.g.isEmpty()) {
            return false;
        }
        if (this.iu == 4 && this.g.size() < 3) {
            return false;
        }
        Iterator<y> it = this.g.iterator();
        while (it.hasNext()) {
            if (!it.next().c()) {
                return false;
            }
        }
        return true;
    }

    public boolean zz() {
        if (ae() != null) {
            return ae().uc();
        }
        return false;
    }

    public int tm() {
        return this.pp;
    }

    public void o(int i) {
        if (i < 12) {
            i = 12;
        }
        if (i > 20) {
            i = 20;
        }
        this.pp = i;
    }

    public int qz() {
        return this.q;
    }

    public void f(int i) {
        if (i < 0 || i > 180) {
            this.q = 50;
        } else {
            this.q = i;
        }
    }

    public boolean oc() {
        int iLb = com.byazt.wt.ls.lb(this);
        return iLb == 3 || iLb == 6;
    }

    public String jr() {
        if (!TextUtils.isEmpty(this.yj)) {
            this.yj = this.yj.trim();
        }
        return this.yj;
    }

    public void s(String str) {
        this.yj = str;
    }

    public int lp() {
        return this.vv;
    }

    public void bm(int i) {
        this.vv = i;
    }

    public int bt() {
        return this.wm;
    }

    public void jn(int i) {
        if (i >= 0 && i <= 100) {
            this.wm = i;
        }
    }

    public JSONObject ig() {
        return this.mj;
    }

    public void zo(JSONObject jSONObject) {
        this.mj = jSONObject;
    }

    public rc eu() {
        return this.nb;
    }

    public z yl() {
        return this.gd;
    }

    public void pr(rc rcVar) {
        this.nb = rcVar;
        if (rcVar != null) {
            String strHw = rcVar.hw();
            String strHn = this.nb.hn();
            if (!TextUtils.isEmpty(strHw)) {
                com.byazt.ea.w.pr(strHw, strHn, (com.byazt.ea.hn) null);
            }
        }
    }

    public void pr(z zVar) {
        this.gd = zVar;
    }

    public int ej() {
        return lb.vk(this);
    }

    public int dl() {
        JSONObject jSONObject = this.k;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public f wn() {
        return this.hg;
    }

    @Override // com.byazt.af.w
    public boolean D_() {
        return wn() != null;
    }

    public void pr(f fVar) {
        this.hg = fVar;
    }

    @Override // com.byazt.af.m
    public boolean E_() {
        f fVar = this.hg;
        return fVar != null && fVar.pr();
    }

    @Override // com.byazt.af.m
    public int uc() {
        if (z_() != null) {
            return z_().x();
        }
        return -1;
    }

    @Override // com.byazt.af.m
    public er a() {
        return this.su;
    }

    public void pr(er erVar) {
        this.su = erVar;
    }

    public float ul() {
        float f = this.yc;
        if (f < 0.07f || f > 0.175f) {
            this.yc = 0.07f;
        }
        return this.yc;
    }

    public void hw(float f) {
        this.yc = f;
    }

    public float bo() {
        float f = this.ou;
        if (f < 0.0f || f > 50.0f) {
            this.ou = 0.0f;
        }
        return this.ou;
    }

    public void hn(float f) {
        this.ou = f;
    }

    @Override // com.byazt.af.k
    public u F_() {
        return this.pr;
    }

    public void pr(u uVar) {
        this.pr = uVar;
    }

    public void ls(String str) {
        this.hn = str;
    }

    public String yn() {
        if (TextUtils.isEmpty(this.hn)) {
            return com.byazt.zb.pr.hn();
        }
        return this.hn;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:103:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:104:0x04fd A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:107:0x050a  */
    /* JADX WARN: Code duplicated, block: B:108:0x050c A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0543 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0562 A[Catch: Exception -> 0x0881, LOOP:3: B:116:0x055c->B:118:0x0562, LOOP_END, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:122:0x05aa A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:125:0x05dc A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:128:0x064b A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:131:0x066c A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:134:0x06e3 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:137:0x070e A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0732  */
    /* JADX WARN: Code duplicated, block: B:142:0x0734  */
    /* JADX WARN: Code duplicated, block: B:145:0x082b A[Catch: Exception -> 0x0884, TryCatch #20 {Exception -> 0x0884, blocks: (B:3:0x0012, B:6:0x0111, B:8:0x011b, B:9:0x013a, B:11:0x0140, B:12:0x0145, B:14:0x014b, B:15:0x0150, B:17:0x0156, B:18:0x015f, B:20:0x0165, B:21:0x016e, B:23:0x0174, B:143:0x0735, B:145:0x082b, B:146:0x0834, B:148:0x0838, B:149:0x083d, B:151:0x0843, B:152:0x086a, B:154:0x0879), top: B:298:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0838 A[Catch: Exception -> 0x0884, TryCatch #20 {Exception -> 0x0884, blocks: (B:3:0x0012, B:6:0x0111, B:8:0x011b, B:9:0x013a, B:11:0x0140, B:12:0x0145, B:14:0x014b, B:15:0x0150, B:17:0x0156, B:18:0x015f, B:20:0x0165, B:21:0x016e, B:23:0x0174, B:143:0x0735, B:145:0x082b, B:146:0x0834, B:148:0x0838, B:149:0x083d, B:151:0x0843, B:152:0x086a, B:154:0x0879), top: B:298:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0843 A[Catch: Exception -> 0x0884, TryCatch #20 {Exception -> 0x0884, blocks: (B:3:0x0012, B:6:0x0111, B:8:0x011b, B:9:0x013a, B:11:0x0140, B:12:0x0145, B:14:0x014b, B:15:0x0150, B:17:0x0156, B:18:0x015f, B:20:0x0165, B:21:0x016e, B:23:0x0174, B:143:0x0735, B:145:0x082b, B:146:0x0834, B:148:0x0838, B:149:0x083d, B:151:0x0843, B:152:0x086a, B:154:0x0879), top: B:298:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0879 A[Catch: Exception -> 0x0884, TRY_LEAVE, TryCatch #20 {Exception -> 0x0884, blocks: (B:3:0x0012, B:6:0x0111, B:8:0x011b, B:9:0x013a, B:11:0x0140, B:12:0x0145, B:14:0x014b, B:15:0x0150, B:17:0x0156, B:18:0x015f, B:20:0x0165, B:21:0x016e, B:23:0x0174, B:143:0x0735, B:145:0x082b, B:146:0x0834, B:148:0x0838, B:149:0x083d, B:151:0x0843, B:152:0x086a, B:154:0x0879), top: B:298:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x01ba A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:31:0x01c9 A[Catch: Exception -> 0x0881, LOOP:1: B:29:0x01c3->B:31:0x01c9, LOOP_END, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:35:0x01de A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:38:0x01ed A[Catch: Exception -> 0x0881, LOOP:2: B:36:0x01e7->B:38:0x01ed, LOOP_END, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:43:0x02ab A[Catch: Exception -> 0x0881, TRY_ENTER, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:46:0x02f2 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0301 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:52:0x030e A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:55:0x031b A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0328 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0335 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0342 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:67:0x034f A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:70:0x035c A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0369 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0376 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0383 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0390 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0404 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0411 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0491 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:92:0x049a  */
    /* JADX WARN: Code duplicated, block: B:95:0x04a6 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:96:0x04af  */
    /* JADX WARN: Code duplicated, block: B:99:0x04c5 A[Catch: Exception -> 0x0881, TryCatch #22 {Exception -> 0x0881, blocks: (B:24:0x017f, B:25:0x01af, B:26:0x01b4, B:28:0x01ba, B:29:0x01c3, B:31:0x01c9, B:32:0x01d3, B:33:0x01d8, B:35:0x01de, B:36:0x01e7, B:38:0x01ed, B:39:0x01f7, B:40:0x01fc, B:43:0x02ab, B:44:0x02ec, B:46:0x02f2, B:47:0x02fb, B:49:0x0301, B:50:0x0308, B:52:0x030e, B:53:0x0315, B:55:0x031b, B:56:0x0322, B:58:0x0328, B:59:0x032f, B:61:0x0335, B:62:0x033c, B:64:0x0342, B:65:0x0349, B:67:0x034f, B:68:0x0356, B:70:0x035c, B:71:0x0363, B:73:0x0369, B:74:0x0370, B:76:0x0376, B:77:0x037d, B:79:0x0383, B:80:0x038a, B:82:0x0390, B:83:0x0397, B:85:0x0404, B:86:0x040b, B:88:0x0411, B:89:0x0418, B:91:0x0491, B:93:0x049b, B:95:0x04a6, B:97:0x04b0, B:99:0x04c5, B:101:0x04cf, B:105:0x0501, B:109:0x0510, B:111:0x0543, B:113:0x0552, B:115:0x0558, B:116:0x055c, B:118:0x0562, B:119:0x0576, B:120:0x057b, B:122:0x05aa, B:123:0x05d6, B:125:0x05dc, B:126:0x0611, B:128:0x064b, B:129:0x0654, B:131:0x066c, B:132:0x06dd, B:134:0x06e3, B:135:0x0708, B:137:0x070e, B:138:0x0717, B:108:0x050c, B:104:0x04fd), top: B:302:0x017f }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject to() {
        List<String> listDf;
        List<String> listTt;
        c cVarHo;
        a aVarZx;
        JSONObject jSONObjectPr;
        JSONObject jSONObjectPr2;
        JSONObject jSONObjectC;
        wt wtVar;
        int iX;
        wt wtVar2;
        int iC;
        com.byazt.qk.pr prVarMw;
        com.byazt.ze.pr prVarSv;
        uc ucVarLb;
        rc rcVarEu;
        int i;
        u uVar;
        Object obj;
        w wVarRj;
        JSONObject jSONObject;
        Set<Map.Entry<String, Object>> setEntrySet;
        JSONArray jSONArray;
        Iterator<String> it;
        JSONArray jSONArray2;
        Iterator<String> it2;
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 1;
        try {
            jSONObject2.put("s_sig_ts", kp());
            jSONObject2.put("ad_rec_stamp", da());
            jSONObject2.put("interaction_type", aj());
            jSONObject2.put("target_url", zo());
            jSONObject2.put("use_sdk_player", ey());
            jSONObject2.put("use_media_video_player", pj());
            jSONObject2.put("landing_scroll_percentage", xv());
            jSONObject2.put("gecko_id", hn());
            jSONObject2.put("extension", iq());
            jSONObject2.put("overlay", mx());
            jSONObject2.put(MediationConstant.EXTRA_ADID, x());
            jSONObject2.put("source", zj());
            jSONObject2.put("package_name", ic());
            jSONObject2.put("screenshot", ei());
            jSONObject2.put("play_bar_style", xb());
            jSONObject2.put("play_bar_show_time", fs());
            jSONObject2.put("if_block_lp", np());
            jSONObject2.put("cache_sort", sx());
            jSONObject2.put("if_sp_cache", uk());
            jSONObject2.put("splash_timeout_stage", oj());
            jSONObject2.put("is_cache", ji());
            jSONObject2.put("cache_type", or());
            com.byazt.xe.hn.pr(this, jSONObject2, true);
            jSONObject2.putOpt("applist_info", ia());
            jSONObject2.put("meta_hashcode", nl());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cta", qo());
            jSONObject3.put("other", j());
            jSONObject2.put("set_click_type", jSONObject3);
            y yVarMo = mo();
            if (yVarMo != null && !TextUtils.isEmpty(yVarMo.pr())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(BreakpointSQLiteKey.URL, yVarMo.pr());
                jSONObject4.put("height", yVarMo.hn());
                jSONObject4.put("width", yVarMo.hw());
                jSONObject2.put("icon", jSONObject4);
            }
            Object objCg = cg();
            if (objCg != null) {
                jSONObject2.put("session_params", objCg);
            }
            Object objXn = xn();
            if (objXn != null) {
                jSONObject2.put("cache_control", objXn);
            }
            com.byazt.qe.hw hwVarP = p();
            if (hwVarP != null) {
                jSONObject2.put("adslot", com.byazt.wt.ve.pr(hwVarP));
            }
            List<y> listDe = de();
            if (listDe != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Iterator<y> it3 = listDe.iterator(); it3.hasNext(); it3 = it3) {
                    y next = it3.next();
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put(BreakpointSQLiteKey.URL, next.pr());
                        jSONObject5.put("height", next.hn());
                        jSONObject5.put("width", next.hw());
                        jSONObject5.put("image_preview", next.uc());
                        jSONObject5.put("image_key", next.fw());
                        jSONArray3.put(jSONObject5);
                    } catch (Exception e) {
                        i2 = 1;
                    }
                }
                jSONObject2.put(ImageViewManager.NAME, jSONArray3);
                listDf = df();
                if (listDf != null) {
                    jSONArray2 = new JSONArray();
                    it2 = listDf.iterator();
                    while (it2.hasNext()) {
                        jSONArray2.put(it2.next());
                    }
                    jSONObject2.put("show_url", jSONArray2);
                }
                listTt = tt();
                if (listTt != null) {
                    jSONArray = new JSONArray();
                    it = listTt.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject2.put("click_url", jSONArray);
                }
                jSONObject2.put("phone_num", gx());
                jSONObject2.put(BundleKey.TITLE, A_());
                jSONObject2.put("download_num", cu());
                jSONObject2.put(BundleKey.DESCRIPTION, jv());
                jSONObject2.put("ext", B_());
                jSONObject2.put("req_id", ny());
                jSONObject2.put("image_mode", jg());
                jSONObject2.put("intercept_flag", ku());
                jSONObject2.put("web_inspector", xg());
                jSONObject2.put("button_text", se());
                jSONObject2.put("ad_logo", wz());
                jSONObject2.put("video_adaptation", sr());
                jSONObject2.put("feed_video_opentype", fe());
                jSONObject2.put("feed_reward_type", ks());
                jSONObject2.put("orientation", rf());
                jSONObject2.put("aspect_ratio", oq());
                jSONObject2.put("aspect_margin", ul());
                jSONObject2.put("corner_radius", bo());
                cVarHo = ho();
                if (cVarHo != null) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, cVarHo.hn());
                    jSONObject6.put("package_name", cVarHo.x());
                    jSONObject6.put("download_url", cVarHo.hw());
                    jSONObject6.put("score", cVarHo.c());
                    jSONObject6.put("comment_num", cVarHo.uc());
                    jSONObject6.put("quick_app_url", cVarHo.pr());
                    jSONObject6.put("app_size", cVarHo.fw());
                    jSONObject2.put("app", jSONObject6);
                }
                aVarZx = zx();
                if (aVarZx != null) {
                    jSONObject2.put("download_sdk_conf", aVarZx.hn());
                }
                if (qv() != null) {
                    qv().hw(jSONObject2);
                }
                if (sw() != null) {
                    sw().pr(jSONObject2);
                }
                if (g() != null) {
                    g().pr(jSONObject2);
                }
                if (ae() != null) {
                    ae().pr(jSONObject2);
                }
                if (rk() != null) {
                    rk().hw(jSONObject2);
                }
                if (na() != null) {
                    na().pr(jSONObject2);
                }
                if (ag() != null) {
                    ag().pr(jSONObject2);
                }
                if (zs() != null) {
                    zs().pr(jSONObject2);
                }
                if (qx() != null) {
                    qx().pr(jSONObject2);
                }
                if (jb() != null) {
                    jb().pr(jSONObject2);
                }
                if (wn() != null) {
                    wn().pr(jSONObject2);
                }
                if (u() != null) {
                    u().hw(jSONObject2);
                }
                jSONObject2.put("count_down", mb());
                jSONObject2.put("expiration_time", hp());
                jSONObject2.put("client_expiration_time", hp());
                jSONObject2.put("_child_metas", kq());
                jSONObject2.put("_meta_life_record", xh().pr());
                jSONObject2.put("src_req_id", nb());
                jSONObject2.put("player_type", sd());
                jSONObject2.put("video_encode_type", id());
                jSONObject2.put("feed_video_finish_type", bh());
                jSONObject2.put("video_voice_control", ax());
                jSONObject2.put("if_show_win", tp());
                if (wx() != null) {
                    wx().pr(jSONObject2);
                }
                if (z_() != null) {
                    z_().pr(jSONObject2);
                }
                jSONObject2.put("if_both_open", qh());
                jSONObject2.put("if_double_deeplink", fh());
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("splash_clickarea", lj());
                jSONObject7.put("splash_clicktext", h());
                jSONObject7.put("area_height", yj());
                jSONObject7.put("area_width", vv());
                jSONObject7.put("area_blank_height", tv());
                jSONObject7.put("half_blank_height", om());
                jSONObject7.put("splash_style_id", wm());
                jSONObject7.put("btn_background_dest_color", wo());
                jSONObject7.put("top_splash_clicktext", hg());
                jSONObject7.put("splash_load_time_optimization", su());
                if (xi() != null) {
                    jSONObjectPr = xi().pr();
                } else {
                    jSONObjectPr = null;
                }
                jSONObject7.put("text_config", jSONObjectPr);
                if (pp() != null) {
                    jSONObjectPr2 = pp().pr();
                } else {
                    jSONObjectPr2 = null;
                }
                jSONObject7.put("top_text_config", jSONObjectPr2);
                jSONObject7.put("sliding_distance", iz());
                if (q() != null) {
                    jSONObjectC = q().c();
                } else {
                    jSONObjectC = null;
                }
                jSONObject7.put("slide_area", jSONObjectC);
                jSONObject2.put("splash_control", jSONObject7);
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("position", bg());
                jSONObject8.put("left_or_right_margin", ok());
                jSONObject8.put("top_or_bottom_margin", xk());
                wtVar = this.xi;
                if (wtVar == null) {
                    iX = 1;
                } else {
                    iX = wtVar.x();
                }
                jSONObject8.put("skip_style", iX);
                wtVar2 = this.xi;
                if (wtVar2 == null) {
                    iC = 0;
                } else {
                    iC = wtVar2.c();
                }
                jSONObject8.put("hide_native_skip_logo", iC);
                jSONObject2.put("skip_control", jSONObject8);
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("show_type", yc());
                jSONObject9.put("blank", ou());
                jSONObject9.put("half_blank", cl());
                jSONObject2.put("splash_compliance_bar", jSONObject9);
                if (zc() != null) {
                    jSONObject = new JSONObject();
                    setEntrySet = zc().entrySet();
                    if (setEntrySet != null && !setEntrySet.isEmpty()) {
                        for (Map.Entry<String, Object> entry : setEntrySet) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject2.put("media_ext", jSONObject);
                }
                jSONObject2.put("isDirectDownload", ii());
                jSONObject2.put("page_render_type", vj());
                jSONObject2.put("promotion_type", cr());
                jSONObject2.put("if_lpua_package", this.cg);
                jSONObject2.put("click_freq", this.jb);
                prVarMw = mw();
                if (prVarMw != null) {
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put("id", prVarMw.pr());
                    jSONObject10.put("md5", prVarMw.hw());
                    jSONObject10.put(BreakpointSQLiteKey.URL, prVarMw.hn());
                    jSONObject10.put("scene", prVarMw.x());
                    jSONObject2.put("ugeno", jSONObject10);
                }
                prVarSv = sv();
                if (prVarSv != null) {
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put("product_infos", prVarSv.pr());
                    jSONObject11.put("coupon", prVarSv.hw());
                    jSONObject11.put("render_config", prVarSv.hn());
                    jSONObject11.put("live_room_data", prVarSv.x());
                    jSONObject11.putOpt("ec_mall_conf", prVarSv.c());
                    jSONObject2.put("dylite_info", jSONObject11);
                }
                jSONObject2.put("native_lp_data", nw());
                jSONObject2.put("native_lp_tpl_id", ie());
                jSONObject2.put("native_lp_ugen_url", o());
                jSONObject2.put("native_lp_ugen_md5", f());
                jSONObject2.put("download_url", hs());
                jSONObject2.put("native_lp_is_preload", bm());
                if (bm()) {
                    jSONObject2.put("native_lp_content", jn());
                }
                jSONObject2.put("market_url", rc());
                jSONObject2.put("close_on_dislike", og());
                ucVarLb = lb();
                if (ucVarLb != null) {
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("developer_name", ucVarLb.fw());
                    jSONObject12.put("app_version", ucVarLb.c());
                    jSONObject12.put("permissions", ucVarLb.k());
                    jSONObject12.put("privacy_policy_url", ucVarLb.zo());
                    jSONObject12.put("package_name", ucVarLb.m());
                    jSONObject12.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, ucVarLb.g());
                    jSONObject12.put("score", ucVarLb.hn());
                    jSONObject12.put("creative_tags", ucVarLb.x());
                    jSONObject12.put("permissions_url", ucVarLb.hw());
                    jSONObject12.put("desc_url", ucVarLb.aj());
                    jSONObject12.put("reg_number", ucVarLb.vk());
                    jSONObject12.put("reg_url", ucVarLb.w());
                    jSONObject2.put("app_manage", jSONObject12);
                }
                rcVarEu = eu();
                if (rcVarEu != null) {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("ugen_dialog_url", rcVarEu.hw());
                    jSONObject13.put("ugen_dialog_md5", rcVarEu.hn());
                    jSONObject13.put("dialog_style", rcVarEu.pr());
                    jSONObject2.put("easy_dl_dialog", jSONObject13);
                }
                if (ig() != null) {
                    jSONObject2.put("easy_pl_material", ig());
                }
                jSONObject2.put("micro_app_type", iu());
                jSONObject2.put("app_manage_type", cb());
                i2 = 1;
                if (fl() == 1) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject2.put("lp_down_rule", i);
                jSONObject2.put("auction_price", ug());
                jSONObject2.put(IAction.PurchaseKey.Price, aa());
                jSONObject2.put("ad_info", td());
                jSONObject2.put("adx_name", jr());
                jSONObject2.put("no_default_ttdsp_price", uj());
                jSONObject2.put("endcard_close_time", lp());
                jSONObject2.put("proportion_watching", bt());
                jSONObject2.put("video_skip_result", sq());
                jSONObject2.put("shake_value", tm());
                jSONObject2.put("deep_shake_value", fu());
                jSONObject2.put("rotation_angle", qz());
                jSONObject2.put("calculation_method", gg());
                jSONObject2.put("calculation_method_twist", kl());
                jSONObject2.put("show_poll_time", ov());
                jSONObject2.put("dynamic_join_type", ab());
                jSONObject2.put("dynamic_join_duration", io());
                jSONObject2.put("is_web_meta", x_());
                jSONObject2.put("union_session_key", cz());
                jSONObject2.put("cache_ext", lv());
                jSONObject2.put("cache_time", l());
                jSONObject2.put("req_id", gu());
                jSONObject2.put("is_cache", d());
                jSONObject2.put("log_ext", pq());
                jSONObject2.put("material_key", jw());
                jSONObject2.put("need_get_materials", wt());
                jSONObject2.put("s_send_ts", iy());
                jSONObject2.put("parse_material_ts", od());
                uVar = this.pr;
                if (uVar != null) {
                    jSONObject2.put("wc_miniapp_info", uVar.aj());
                }
                obj = this.hn;
                if (obj != null) {
                    jSONObject2.put(PluginConstants.KEY_APP_ID, obj);
                }
                wVarRj = rj();
                if (wVarRj != null) {
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("click_trigger_type", wVarRj.pr());
                    jSONObject14.put("shake_start_time", wVarRj.hw());
                    jSONObject14.put("shake_end_time", wVarRj.hn());
                    jSONObject2.put("click_trigger_config", jSONObject14);
                }
                jSONObject2.put("web_monitor_rate", ve());
                if (jo() != null) {
                    jo().pr(jSONObject2);
                }
            } else {
                listDf = df();
                if (listDf != null) {
                    jSONArray2 = new JSONArray();
                    it2 = listDf.iterator();
                    while (it2.hasNext()) {
                        jSONArray2.put(it2.next());
                    }
                    jSONObject2.put("show_url", jSONArray2);
                }
                listTt = tt();
                if (listTt != null) {
                    jSONArray = new JSONArray();
                    it = listTt.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject2.put("click_url", jSONArray);
                }
                jSONObject2.put("phone_num", gx());
                jSONObject2.put(BundleKey.TITLE, A_());
                jSONObject2.put("download_num", cu());
                jSONObject2.put(BundleKey.DESCRIPTION, jv());
                jSONObject2.put("ext", B_());
                jSONObject2.put("req_id", ny());
                jSONObject2.put("image_mode", jg());
                jSONObject2.put("intercept_flag", ku());
                jSONObject2.put("web_inspector", xg());
                jSONObject2.put("button_text", se());
                jSONObject2.put("ad_logo", wz());
                jSONObject2.put("video_adaptation", sr());
                jSONObject2.put("feed_video_opentype", fe());
                jSONObject2.put("feed_reward_type", ks());
                jSONObject2.put("orientation", rf());
                jSONObject2.put("aspect_ratio", oq());
                jSONObject2.put("aspect_margin", ul());
                jSONObject2.put("corner_radius", bo());
                cVarHo = ho();
                if (cVarHo != null) {
                    JSONObject jSONObject15 = new JSONObject();
                    jSONObject15.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, cVarHo.hn());
                    jSONObject15.put("package_name", cVarHo.x());
                    jSONObject15.put("download_url", cVarHo.hw());
                    jSONObject15.put("score", cVarHo.c());
                    jSONObject15.put("comment_num", cVarHo.uc());
                    jSONObject15.put("quick_app_url", cVarHo.pr());
                    jSONObject15.put("app_size", cVarHo.fw());
                    jSONObject2.put("app", jSONObject15);
                }
                aVarZx = zx();
                if (aVarZx != null) {
                    jSONObject2.put("download_sdk_conf", aVarZx.hn());
                }
                if (qv() != null) {
                    qv().hw(jSONObject2);
                }
                if (sw() != null) {
                    sw().pr(jSONObject2);
                }
                if (g() != null) {
                    g().pr(jSONObject2);
                }
                if (ae() != null) {
                    ae().pr(jSONObject2);
                }
                if (rk() != null) {
                    rk().hw(jSONObject2);
                }
                if (na() != null) {
                    na().pr(jSONObject2);
                }
                if (ag() != null) {
                    ag().pr(jSONObject2);
                }
                if (zs() != null) {
                    zs().pr(jSONObject2);
                }
                if (qx() != null) {
                    qx().pr(jSONObject2);
                }
                if (jb() != null) {
                    jb().pr(jSONObject2);
                }
                if (wn() != null) {
                    wn().pr(jSONObject2);
                }
                if (u() != null) {
                    u().hw(jSONObject2);
                }
                jSONObject2.put("count_down", mb());
                jSONObject2.put("expiration_time", hp());
                jSONObject2.put("client_expiration_time", hp());
                jSONObject2.put("_child_metas", kq());
                jSONObject2.put("_meta_life_record", xh().pr());
                jSONObject2.put("src_req_id", nb());
                jSONObject2.put("player_type", sd());
                jSONObject2.put("video_encode_type", id());
                jSONObject2.put("feed_video_finish_type", bh());
                jSONObject2.put("video_voice_control", ax());
                jSONObject2.put("if_show_win", tp());
                if (wx() != null) {
                    wx().pr(jSONObject2);
                }
                if (z_() != null) {
                    z_().pr(jSONObject2);
                }
                jSONObject2.put("if_both_open", qh());
                jSONObject2.put("if_double_deeplink", fh());
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("splash_clickarea", lj());
                jSONObject16.put("splash_clicktext", h());
                jSONObject16.put("area_height", yj());
                jSONObject16.put("area_width", vv());
                jSONObject16.put("area_blank_height", tv());
                jSONObject16.put("half_blank_height", om());
                jSONObject16.put("splash_style_id", wm());
                jSONObject16.put("btn_background_dest_color", wo());
                jSONObject16.put("top_splash_clicktext", hg());
                jSONObject16.put("splash_load_time_optimization", su());
                if (xi() != null) {
                    jSONObjectPr = xi().pr();
                } else {
                    jSONObjectPr = null;
                }
                jSONObject16.put("text_config", jSONObjectPr);
                if (pp() != null) {
                    jSONObjectPr2 = pp().pr();
                } else {
                    jSONObjectPr2 = null;
                }
                jSONObject16.put("top_text_config", jSONObjectPr2);
                jSONObject16.put("sliding_distance", iz());
                if (q() != null) {
                    jSONObjectC = q().c();
                } else {
                    jSONObjectC = null;
                }
                jSONObject16.put("slide_area", jSONObjectC);
                jSONObject2.put("splash_control", jSONObject16);
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("position", bg());
                jSONObject17.put("left_or_right_margin", ok());
                jSONObject17.put("top_or_bottom_margin", xk());
                wtVar = this.xi;
                if (wtVar == null) {
                    iX = 1;
                } else {
                    iX = wtVar.x();
                }
                jSONObject17.put("skip_style", iX);
                wtVar2 = this.xi;
                if (wtVar2 == null) {
                    iC = 0;
                } else {
                    iC = wtVar2.c();
                }
                jSONObject17.put("hide_native_skip_logo", iC);
                jSONObject2.put("skip_control", jSONObject17);
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("show_type", yc());
                jSONObject18.put("blank", ou());
                jSONObject18.put("half_blank", cl());
                jSONObject2.put("splash_compliance_bar", jSONObject18);
                if (zc() != null) {
                    jSONObject = new JSONObject();
                    setEntrySet = zc().entrySet();
                    if (setEntrySet != null) {
                        while (r12.hasNext()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject2.put("media_ext", jSONObject);
                }
                jSONObject2.put("isDirectDownload", ii());
                jSONObject2.put("page_render_type", vj());
                jSONObject2.put("promotion_type", cr());
                jSONObject2.put("if_lpua_package", this.cg);
                jSONObject2.put("click_freq", this.jb);
                prVarMw = mw();
                if (prVarMw != null) {
                    JSONObject jSONObject19 = new JSONObject();
                    jSONObject19.put("id", prVarMw.pr());
                    jSONObject19.put("md5", prVarMw.hw());
                    jSONObject19.put(BreakpointSQLiteKey.URL, prVarMw.hn());
                    jSONObject19.put("scene", prVarMw.x());
                    jSONObject2.put("ugeno", jSONObject19);
                }
                prVarSv = sv();
                if (prVarSv != null) {
                    JSONObject jSONObject110 = new JSONObject();
                    jSONObject110.put("product_infos", prVarSv.pr());
                    jSONObject110.put("coupon", prVarSv.hw());
                    jSONObject110.put("render_config", prVarSv.hn());
                    jSONObject110.put("live_room_data", prVarSv.x());
                    jSONObject110.putOpt("ec_mall_conf", prVarSv.c());
                    jSONObject2.put("dylite_info", jSONObject110);
                }
                jSONObject2.put("native_lp_data", nw());
                jSONObject2.put("native_lp_tpl_id", ie());
                jSONObject2.put("native_lp_ugen_url", o());
                jSONObject2.put("native_lp_ugen_md5", f());
                jSONObject2.put("download_url", hs());
                jSONObject2.put("native_lp_is_preload", bm());
                if (bm()) {
                    jSONObject2.put("native_lp_content", jn());
                }
                jSONObject2.put("market_url", rc());
                jSONObject2.put("close_on_dislike", og());
                ucVarLb = lb();
                if (ucVarLb != null) {
                    JSONObject jSONObject111 = new JSONObject();
                    jSONObject111.put("developer_name", ucVarLb.fw());
                    jSONObject111.put("app_version", ucVarLb.c());
                    jSONObject111.put("permissions", ucVarLb.k());
                    jSONObject111.put("privacy_policy_url", ucVarLb.zo());
                    jSONObject111.put("package_name", ucVarLb.m());
                    jSONObject111.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, ucVarLb.g());
                    jSONObject111.put("score", ucVarLb.hn());
                    jSONObject111.put("creative_tags", ucVarLb.x());
                    jSONObject111.put("permissions_url", ucVarLb.hw());
                    jSONObject111.put("desc_url", ucVarLb.aj());
                    jSONObject111.put("reg_number", ucVarLb.vk());
                    jSONObject111.put("reg_url", ucVarLb.w());
                    jSONObject2.put("app_manage", jSONObject111);
                }
                rcVarEu = eu();
                if (rcVarEu != null) {
                    JSONObject jSONObject112 = new JSONObject();
                    jSONObject112.put("ugen_dialog_url", rcVarEu.hw());
                    jSONObject112.put("ugen_dialog_md5", rcVarEu.hn());
                    jSONObject112.put("dialog_style", rcVarEu.pr());
                    jSONObject2.put("easy_dl_dialog", jSONObject112);
                }
                if (ig() != null) {
                    jSONObject2.put("easy_pl_material", ig());
                }
                jSONObject2.put("micro_app_type", iu());
                jSONObject2.put("app_manage_type", cb());
                i2 = 1;
                if (fl() == 1) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject2.put("lp_down_rule", i);
                jSONObject2.put("auction_price", ug());
                jSONObject2.put(IAction.PurchaseKey.Price, aa());
                jSONObject2.put("ad_info", td());
                jSONObject2.put("adx_name", jr());
                jSONObject2.put("no_default_ttdsp_price", uj());
                jSONObject2.put("endcard_close_time", lp());
                jSONObject2.put("proportion_watching", bt());
                jSONObject2.put("video_skip_result", sq());
                jSONObject2.put("shake_value", tm());
                jSONObject2.put("deep_shake_value", fu());
                jSONObject2.put("rotation_angle", qz());
                jSONObject2.put("calculation_method", gg());
                jSONObject2.put("calculation_method_twist", kl());
                jSONObject2.put("show_poll_time", ov());
                jSONObject2.put("dynamic_join_type", ab());
                jSONObject2.put("dynamic_join_duration", io());
                jSONObject2.put("is_web_meta", x_());
                jSONObject2.put("union_session_key", cz());
                jSONObject2.put("cache_ext", lv());
                jSONObject2.put("cache_time", l());
                jSONObject2.put("req_id", gu());
                jSONObject2.put("is_cache", d());
                jSONObject2.put("log_ext", pq());
                jSONObject2.put("material_key", jw());
                jSONObject2.put("need_get_materials", wt());
                jSONObject2.put("s_send_ts", iy());
                jSONObject2.put("parse_material_ts", od());
                uVar = this.pr;
                if (uVar != null) {
                    jSONObject2.put("wc_miniapp_info", uVar.aj());
                }
                obj = this.hn;
                if (obj != null) {
                    jSONObject2.put(PluginConstants.KEY_APP_ID, obj);
                }
                wVarRj = rj();
                if (wVarRj != null) {
                    JSONObject jSONObject113 = new JSONObject();
                    jSONObject113.put("click_trigger_type", wVarRj.pr());
                    jSONObject113.put("shake_start_time", wVarRj.hw());
                    jSONObject113.put("shake_end_time", wVarRj.hn());
                    jSONObject2.put("click_trigger_config", jSONObject113);
                }
                jSONObject2.put("web_monitor_rate", ve());
                if (jo() != null) {
                    jo().pr(jSONObject2);
                }
            }
        } catch (Exception e2) {
        }
        if (sf() != null) {
            sf().pr(jSONObject2);
        }
        try {
            jSONObject2.put("is_ec_mall", kx() ? i2 : 0);
            jSONObject2.put("live_room_id", vk());
            jSONObject2.put("ad_type", uv());
            jSONObject2.put("live_interaction_type", c());
            jSONObject2.put("ec_schema", y_());
        } catch (JSONException e3) {
        }
        try {
            jSONObject2.put("ecom_live_params", k());
        } catch (JSONException e4) {
        }
        e eVarGp = gp();
        if (eVarGp != null) {
            eVarGp.pr(jSONObject2);
        }
        cz czVarM = m();
        if (czVarM != null) {
            czVarM.pr(jSONObject2);
        }
        er erVarA = a();
        if (erVarA != null) {
            try {
                JSONObject jSONObject20 = new JSONObject();
                jSONObject20.put("reward_live_deep_link_user_id", erVarA.pr());
                jSONObject20.put("reward_live_deep_link_request_id", erVarA.uc());
                jSONObject20.put("reward_live_deep_link_room_id", erVarA.hw());
                jSONObject20.put("reward_live_last_time", erVarA.c());
                jSONObject20.put("reawrd_live_short_touch_params", erVarA.hn());
                jSONObject20.put("reawrd_live_extra_pangle_scheme_params", erVarA.x());
                jSONObject2.put("reward_live_deep_link_params", jSONObject20);
            } catch (Exception e5) {
            }
        }
        ho hoVarEz = ez();
        if (hoVarEz != null) {
            try {
                JSONObject jSONObject21 = new JSONObject();
                jSONObject21.put("style_type", hoVarEz.pr());
                jSONObject21.put("image_url", hoVarEz.hw());
                jSONObject21.put("position", hoVarEz.hn());
                jSONObject21.put("image_height", hoVarEz.x());
                jSONObject21.put("image_scale_rate", hoVarEz.uc());
                jSONObject21.put("image_gif_url", hoVarEz.c());
                jSONObject21.put("image_gif_aspect_ratio", hoVarEz.fw());
                jSONObject2.put("dynamic_join_coupon_style", jSONObject21);
            } catch (Exception e6) {
            }
        }
        g gVarQa = qa();
        if (gVarQa != null) {
            try {
                jSONObject2.put("coupon", gVarQa.pr());
            } catch (JSONException e7) {
            }
        }
        qi qiVarW = w();
        if (qiVarW != null) {
            try {
                jSONObject2.put("live_info", qiVarW.pr());
            } catch (JSONException e8) {
            }
        }
        lv lvVarH_ = H_();
        if (lvVarH_ != null) {
            try {
                jSONObject2.put("saas_info", lvVarH_.pr());
            } catch (JSONException e9) {
            }
        }
        od odVarI_ = I_();
        if (odVarI_ != null) {
            try {
                jSONObject2.put("saas_on_click_material", odVarI_.pr());
            } catch (JSONException e10) {
            }
        }
        try {
            jSONObject2.put("live_sdk_status_while_first_click", this.bo);
        } catch (JSONException e11) {
        }
        Object objFj = fj();
        if (objFj != null) {
            try {
                jSONObject2.put(com.umeng.analytics.pro.d.K, objFj);
            } catch (Exception e12) {
            }
        }
        aa aaVarZn = zn();
        if (aaVarZn != null) {
            try {
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put("video_adapter_type", aaVarZn.pr());
                jSONObject22.put("video_mute_type", aaVarZn.hw());
                jSONObject2.put("video_config", jSONObject22);
            } catch (Exception e13) {
            }
        }
        try {
            jSONObject2.put("not_valid_download_url", G_());
        } catch (JSONException e14) {
        }
        try {
            jSONObject2.put("dynamic_configs", nt());
            String strBd = bd();
            if (!TextUtils.isEmpty(strBd)) {
                jSONObject2.put("gnd_prefetch_cache_key", strBd);
                jSONObject2.put("gnd_prefetch_timing", hh());
            }
        } catch (JSONException e15) {
        }
        try {
            jSONObject2.put("twist_config", gv());
            jSONObject2.put("shake_interact_conf", dj());
            jSONObject2.put("twist_interact_conf", yd());
        } catch (JSONException e16) {
        }
        try {
            ve veVar = this.ic;
            if (veVar != null) {
                veVar.hw(jSONObject2);
            }
        } catch (Throwable th) {
        }
        try {
            ww wwVar = this.ae;
            if (wwVar != null) {
                wwVar.hw(jSONObject2);
            }
        } catch (Throwable th2) {
        }
        try {
            jSONObject2.put("temp_extra_info", qn());
        } catch (JSONException e17) {
        }
        try {
            jSONObject2.put("sdk_derive_info", of());
        } catch (JSONException e18) {
        }
        try {
            jSONObject2.put("disable_video_join", y());
            jSONObject2.put("disable_top_bar", s());
            jSONObject2.put("disable_rtn_button", er());
            jSONObject2.put("disable_safe_area", gz());
            jSONObject2.put("disable_slide_return", n());
        } catch (Throwable th3) {
        }
        try {
            jSONObject2.put("_ad_index", tc());
        } catch (JSONException e19) {
        }
        try {
            jSONObject2.put("is_height_resize", sl());
        } catch (JSONException e20) {
        }
        return jSONObject2;
    }

    public void er(String str) {
        this.hp = str;
    }

    @Override // com.byazt.af.w
    public String nt() {
        return this.hp;
    }

    public void m(boolean z) {
        this.tz = z;
    }

    @Override // com.byazt.af.aj
    public boolean G_() {
        return this.tz;
    }

    public int sd() {
        return this.om;
    }

    public void l(int i) {
        this.om = i;
    }

    public wt ff() {
        return this.xi;
    }

    public void pr(wt wtVar) {
        this.xi = wtVar;
    }

    public d qr() {
        return this.cl;
    }

    public void pr(d dVar) {
        this.cl = dVar;
    }

    public int ov() {
        return this.fj;
    }

    public void lv(int i) {
        int i2 = 500;
        if (i == Integer.MIN_VALUE) {
            if (com.byazt.wt.ls.k(this) == 3) {
                i = 500;
            } else {
                i = 1000;
            }
        }
        if (i >= 500) {
            if (i <= 3000) {
                i2 = i;
            } else {
                i2 = 3000;
            }
        }
        this.fj = i2;
    }

    @Override // com.byazt.af.w
    public String vk() {
        return this.jl;
    }

    public void v(String str) {
        this.jl = str;
    }

    public int uv() {
        return this.xy;
    }

    public void od(int i) {
        this.xy = i;
    }

    @Override // com.byazt.af.m
    public int c() {
        return this.cb;
    }

    public void vj(int i) {
        this.cb = i;
    }

    public void pr(o oVar) {
        this.od = oVar;
    }

    @Override // com.byazt.af.w
    public String k() {
        return this.wx;
    }

    public void qi(String str) {
        this.wx = str;
    }

    @Override // com.byazt.af.w
    public g qa() {
        return this.id;
    }

    public void pr(g gVar) {
        this.id = gVar;
    }

    @Override // com.byazt.af.w
    public qi w() {
        return this.ax;
    }

    public void pr(qi qiVar) {
        this.ax = qiVar;
    }

    @Override // com.byazt.af.w
    public lv H_() {
        return this.rr;
    }

    public void pr(lv lvVar) {
        this.rr = lvVar;
    }

    public boolean og() {
        return this.qx;
    }

    public void g(boolean z) {
        this.qx = z;
    }

    public int sq() {
        return this.tv;
    }

    public void mw(int i) {
        if (i <= 0 || i > 9) {
            this.tv = 3;
        } else {
            this.tv = i;
        }
    }

    public ho ez() {
        return this.fl;
    }

    public void pr(ho hoVar) {
        this.fl = hoVar;
    }

    public aa zn() {
        return this.tp;
    }

    public void pr(aa aaVar) {
        this.tp = aaVar;
    }

    public int fu() {
        if (this.c == 4 && TextUtils.isEmpty(this.aa)) {
            return this.bg;
        }
        return 0;
    }

    public void sv(int i) {
        this.bg = i;
    }

    public void qn(String str) {
        this.ff = str;
    }

    public String kq() {
        return this.ff;
    }

    public o sw() {
        return this.od;
    }

    public w rj() {
        return this.se;
    }

    public void pr(w wVar) {
        this.se = wVar;
    }

    public void ho(boolean z) {
        this.vj = z;
    }

    public boolean kx() {
        return this.vj;
    }

    public void pr(v vVar) {
        this.mw = vVar;
    }

    public v sf() {
        return this.mw;
    }

    public void pr(com.byazt.n.x xVar) {
        if (this.ls == null) {
            this.ls = new qv();
        }
        this.ls.pr(xVar);
    }

    public void nt(boolean z) {
        this.zx = z;
    }

    public boolean hv() {
        return this.zx;
    }

    public void pr(e eVar) {
        this.xv = eVar;
    }

    public e gp() {
        return this.xv;
    }

    public void pr(cz czVar) {
        this.iq = czVar;
    }

    @Override // com.byazt.af.m
    public cz m() {
        return this.iq;
    }

    public int hh() {
        return this.vh;
    }

    public void gu(int i) {
        this.vh = i;
    }

    public String bd() {
        return this.ds;
    }

    public void of(String str) {
        this.ds = str;
    }

    public static boolean c(of ofVar) {
        return ofVar != null && ofVar.cg == 1;
    }

    public void d(int i) {
        this.jb = i;
    }

    public static boolean uc(of ofVar) {
        if (ofVar == null || ofVar.td <= 0 || ofVar.jb <= 0) {
            return false;
        }
        boolean z = System.currentTimeMillis() - ofVar.td < ((long) ofVar.jb);
        if (z) {
            ofVar.rf++;
            com.byazt.xk.hw.pr().pr("click_intercept", (String) null, ofVar.B_(), new com.byazt.ttf.pr() { // from class: com.byazt.hg.of.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("count", of.this.rf);
                    jSONObject2.put("click_freq", of.this.jb);
                    return jSONObject2;
                }
            });
        }
        return z;
    }

    public static void fw(of ofVar) {
        if (ofVar == null) {
            return;
        }
        ofVar.td = System.currentTimeMillis();
    }

    public void pq(int i) {
        this.cg = i;
    }

    public JSONObject gv() {
        return this.xn;
    }

    public void aj(JSONObject jSONObject) {
        this.xn = jSONObject;
    }

    public JSONObject dj() {
        return this.qh;
    }

    public void vk(JSONObject jSONObject) {
        this.qh = jSONObject;
    }

    public JSONObject yd() {
        return this.fh;
    }

    public void w(JSONObject jSONObject) {
        this.fh = jSONObject;
    }

    public String le() {
        return hashCode() + ny() + od();
    }

    @Override // com.byazt.af.aj
    public String cz() {
        String strOptString;
        JSONObject jSONObject = this.qo;
        if (jSONObject == null) {
            strOptString = "";
        } else {
            strOptString = jSONObject.optString("session_id");
        }
        if (TextUtils.isEmpty(strOptString)) {
            return le();
        }
        return strOptString;
    }

    public void pr(ve veVar) {
        this.ic = veVar;
    }

    public ve sb() {
        return this.ic;
    }

    public void pr(b bVar) {
        this.oq = bVar;
    }

    public b li() {
        return this.oq;
    }

    public void pr(r rVar) {
        this.kp = rVar;
    }

    public r ee() {
        return this.kp;
    }

    public void pr(iu iuVar) {
        this.da = iuVar;
    }

    public iu xd() {
        return this.da;
    }

    public ii xh() {
        if (this.zs == null) {
            this.zs = new ii(this);
        }
        return this.zs;
    }

    public void k(JSONObject jSONObject) {
        this.zs = new ii(this, jSONObject);
    }

    public JSONObject ia() {
        return this.dl;
    }

    public void m(JSONObject jSONObject) {
        this.dl = jSONObject;
    }

    @Override // com.byazt.af.w
    public od I_() {
        return this.ul;
    }

    public void pr(od odVar) {
        this.ul = odVar;
    }

    public int ll() {
        return this.bo;
    }

    public void jw(int i) {
        this.bo = i;
    }

    public int sl() {
        return this.wn;
    }

    public void wt(int i) {
        this.wn = i;
    }
}
