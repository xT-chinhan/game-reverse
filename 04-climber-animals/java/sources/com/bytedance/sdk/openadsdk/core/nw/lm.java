package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import com.anythink.core.common.e.a;
import com.anythink.network.tap.TapATInitManager;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.api.model.AdnName;
import com.tapsdk.tapad.constants.Constants;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.umeng.analytics.pro.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class lm {
    private JSONObject ad;
    private int ae;
    private com.bytedance.sdk.openadsdk.core.dislike.ah.xr ah;
    private ul am;
    private long ao;
    private b b;
    private int bk;
    private ub bn;
    private rt br;
    private String c;
    private JSONObject ca;
    private int cb;
    private long cc;
    private JSONObject ce;
    private JSONObject ch;
    private String cj;
    private long cv;
    private t cz;
    private int d;
    private String df;
    private int di;
    private int dm;
    private volatile JSONObject du;
    private long ec;
    private boolean eg;
    private String eh;
    private eg eu;
    private boolean f;
    private c fb;
    private int fg;
    private pc fl;
    private nw fm;
    private int fs;
    private int g;
    private boolean gs;
    private op gx;
    private String gz;
    private String h;
    private String ha;
    private int hg;
    private String ho;
    private w ht;
    private int i;
    private int ii;
    private ms il;
    private int ir;
    private ti it;
    private int jc;
    private int jj;
    private int jm;
    private com.bytedance.sdk.openadsdk.core.ugeno.c.ms js;
    private boolean jw;
    private g ka;
    private String kh;
    private String kl;
    private int kv;
    private p kz;
    private fm l;
    private JSONObject ld;
    private String le;
    private zf lx;
    private String mp;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public ce f3065ms;
    private yu nk;
    private String nl;
    private v nn;
    private re no;
    private ka nw;
    private JSONObject ny;
    private JSONObject od;
    private int of;
    private xn oi;
    private JSONObject op;
    private int or;
    private k oy;
    private qr p;
    private int pc;
    private String pl;
    private boolean pn;
    private boolean pq;
    private String pt;
    private vm qd;
    private s qe;
    private qf qf;
    private int qk;
    private String qo;
    private int qu;
    private String qv;
    private String r;
    private h re;
    private boolean rk;
    private com.bytedance.sdk.openadsdk.core.ugeno.ny.ms rm;
    private String rt;
    private int sh;
    private String si;
    private String sl;
    private int so;
    private sl ss;
    private int sz;
    private am tc;
    private long tf;
    private int tk;
    private String ub;
    private int uc;
    private int ue;
    private String us;
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr v;
    private String vf;
    private int vi;
    private JSONObject vl;
    private int vm;
    private String vt;
    private boolean vv;
    private f vx;
    private String w;
    private int we;
    private String wg;
    private String wp;
    private boolean wq;
    private String x;
    private String xf;
    private Map<String, Object> xn;
    public String xr;
    private int yl;
    private le yq;
    private String yu;
    private boolean yw;
    private az yy;
    private int z;
    private int zd;
    private qv ze;
    private JSONObject zg;
    private u zh;
    private of zj;
    private JSONObject zm;
    private int ab = -1;
    private List<g> hi = new ArrayList();
    private List<String> zb = new ArrayList();
    private List<String> u = new ArrayList();
    private String y = "0";
    private String t = "0";
    private int ul = -1;
    private long az = -1;
    private long m = -1;
    private long lm = System.currentTimeMillis();
    private String e = UUID.randomUUID().toString();
    private String k = "";
    private int sa = 2;
    private int tz = IOfflineCompo.Priority.HIGHEST;
    private int ti = 0;
    private ny s = new ny();
    private int zf = 1;
    private int vy = 0;
    private int sk = 0;
    private int gy = 0;
    private int qr = 1;
    private int bz = 0;
    private int jy = 0;
    private int j = 0;
    private int ih = 0;
    private int oh = 1;
    private int o = 1;
    private boolean n = false;
    private int a = 1;
    private float mh = 100.0f;
    private int kk = 0;
    private int ph = 2;
    private int zx = 0;
    private int dv = 100;
    private int nq = 2;
    private int jr = 2;
    private float fk = 0.07f;
    private float wc = 0.0f;
    private long wn = 0;
    private boolean ci = true;
    private int ou = -1;
    private int hy = 0;
    private int jl = 0;
    private long on = 0;
    private int ia = 0;

    public boolean ms() {
        return this.vv;
    }

    public void ms(boolean z) {
        this.vv = z;
    }

    public int xr() {
        return this.yl;
    }

    public void ms(int i) {
        this.yl = i;
    }

    public void xr(int i) {
        this.or = i;
    }

    public boolean ah() {
        return this.or == 1;
    }

    public boolean d() {
        return this.pq && hi();
    }

    public void xr(boolean z) {
        this.pq = z;
    }

    public void ah(int i) {
        this.hg = i;
    }

    public void d(int i) {
        if (this.dm == 0) {
            this.dm = i;
        }
    }

    public int ka() {
        return this.dm;
    }

    public int c() {
        return this.hg;
    }

    public boolean ab() {
        return c() == 1;
    }

    public void ka(int i) {
        this.cb = i;
    }

    public int x() {
        return this.cb;
    }

    public boolean ny() {
        return this.cb == 1;
    }

    public void c(int i) {
        this.sz = i;
    }

    public int ch() {
        return this.sz;
    }

    public boolean hi() {
        return ch() == 1;
    }

    public void ab(int i) {
        this.jc = i;
    }

    public int sl() {
        return this.jc;
    }

    public boolean zb() {
        return sl() == 1;
    }

    public void ms(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ze = new qv();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdk_template_info");
            if (jSONObjectOptJSONObject != null) {
                this.ze.ms(jSONObjectOptJSONObject.optString("lottie_tmp_url"));
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("aigc");
            if (jSONObjectOptJSONObject2 != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("bg_anim_img_android");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    this.ze.ms(arrayList);
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            g gVar = new g();
                            gVar.ms(jSONObjectOptJSONObject3.optInt("width"));
                            gVar.xr(jSONObjectOptJSONObject3.optInt("height"));
                            gVar.ms(jSONObjectOptJSONObject3.optString("url"));
                            arrayList.add(gVar);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("bg_videos");
                if (jSONArrayOptJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    this.ze.xr(arrayList2);
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject4 != null) {
                            com.bykv.vk.openvk.component.video.api.ah.ah ahVar = new com.bykv.vk.openvk.component.video.api.ah.ah();
                            ahVar.ka(jSONObjectOptJSONObject4.optString("file_hash"));
                            ahVar.ms(jSONObjectOptJSONObject4.optString(bv.z));
                            ahVar.ms(jSONObjectOptJSONObject4.optDouble("video_duration"));
                            ahVar.ah(jSONObjectOptJSONObject4.optString("video_url"));
                            arrayList2.add(ahVar);
                        }
                    }
                }
            }
        }
    }

    public qv u() {
        return this.ze;
    }

    public boolean ub() {
        return this.rk;
    }

    public void ah(boolean z) {
        this.rk = z;
    }

    public String ao() {
        return this.ha;
    }

    public void ms(String str) {
        this.ha = str;
    }

    public String h() {
        return this.xf;
    }

    public void xr(String str) {
        this.xf = str;
    }

    public int qv() {
        return this.sh;
    }

    public void x(int i) {
        this.sh = i;
    }

    public String y() {
        return this.gz;
    }

    public void ah(String str) {
        this.gz = str;
    }

    public String t() {
        return this.ho;
    }

    public void d(String str) {
        this.ho = str;
    }

    public void d(boolean z) {
        this.yw = z;
    }

    public boolean nw() {
        return this.yw;
    }

    public void xr(JSONObject jSONObject) {
        this.du = jSONObject;
    }

    public JSONObject b() {
        return this.du;
    }

    public static boolean ms(lm lmVar) {
        return lmVar != null && lmVar.e() == 1;
    }

    public static boolean xr(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        return lmVar.kz() == 5 || lmVar.kz() == 15 || lmVar.kz() == 166;
    }

    public static boolean ah(lm lmVar) {
        try {
            return lmVar.vt() != null && lmVar.vt().optInt("parent_type") == 1;
        } catch (Exception unused) {
        }
    }

    public long re() {
        return this.ec;
    }

    public void ms(long j) {
        this.ec = j;
    }

    public String i() {
        return this.vf;
    }

    public void ka(String str) {
        this.vf = str;
    }

    public void xr(long j) {
        this.tf = j;
    }

    public long w() {
        return this.tf;
    }

    public void ny(int i) {
        this.ae = i;
    }

    public int yu() {
        if (t.d(this)) {
            return 0;
        }
        return this.ae;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.c.ms op() {
        return this.js;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar) {
        this.js = msVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVar) {
        this.rm = msVar;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.ny.ms le() {
        return this.rm;
    }

    public String cv() {
        return this.kl;
    }

    public void c(String str) {
        this.kl = str;
    }

    public boolean g() {
        return this.gs;
    }

    public void ka(boolean z) {
        this.gs = z;
    }

    public String of() {
        return this.r;
    }

    public void ab(String str) {
        this.r = str;
    }

    public String p() {
        return this.cj;
    }

    public void x(String str) {
        this.cj = str;
    }

    public boolean pc() {
        return this.wq;
    }

    public void c(boolean z) {
        this.wq = z;
    }

    public void ah(long j) {
        this.cc = j;
    }

    public String jw() {
        return this.qo;
    }

    public void ny(String str) {
        this.qo = str;
    }

    public long f() {
        return this.cc;
    }

    public void ch(String str) {
        this.nl = str;
    }

    public void ch(int i) {
        this.fg = i;
    }

    public int ul() {
        return this.fg;
    }

    public int az() {
        return this.jr;
    }

    public void ms(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.jr = 2;
        } else {
            this.jr = (int) d;
        }
    }

    public int m() {
        return this.nq;
    }

    public void xr(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.nq = 2;
        } else {
            this.nq = (int) d;
        }
    }

    public int lm() {
        return this.of;
    }

    public void hi(int i) {
        this.of = i;
    }

    public int e() {
        return this.j;
    }

    public void sl(int i) {
        this.j = i;
    }

    public qf k() {
        return this.qf;
    }

    public void ms(qf qfVar) {
        this.qf = qfVar;
    }

    public of eg() {
        return this.zj;
    }

    public void ms(of ofVar) {
        this.zj = ofVar;
    }

    public int fm() {
        return this.sa;
    }

    public void zb(int i) {
        this.sa = i;
    }

    public int xn() {
        return this.vy;
    }

    public void u(int i) {
        this.vy = i;
    }

    public boolean il() {
        return this.vy == 1;
    }

    public eg qf() {
        return this.eu;
    }

    public void ms(eg egVar) {
        this.eu = egVar;
    }

    public String l() {
        return this.pt;
    }

    public void hi(String str) {
        this.pt = str;
    }

    public int am() {
        return this.qu;
    }

    public void ub(int i) {
        this.qu = i;
    }

    public t sa() {
        return this.cz;
    }

    public void ms(t tVar) {
        this.cz = tVar;
    }

    public ti tz() {
        return this.it;
    }

    public void ms(ti tiVar) {
        this.it = tiVar;
    }

    public int ti() {
        return this.gy;
    }

    public void ao(int i) {
        this.gy = i;
    }

    public int s() {
        return this.ou;
    }

    public void h(int i) {
        this.ou = i;
    }

    public int v() {
        return this.sk;
    }

    public void qv(int i) {
        this.sk = i;
    }

    public int qk() {
        return this.zf;
    }

    public void y(int i) {
        this.zf = i;
    }

    public int vm() {
        if (ld() != 100.0f || fm() == 2) {
            return 0;
        }
        return this.ti;
    }

    public void t(int i) {
        this.ti = i;
    }

    public ny zf() {
        return this.s;
    }

    public void ms(ny nyVar) {
        this.s = nyVar;
    }

    public com.bytedance.sdk.openadsdk.ao.xr.ah.xr rt() {
        return this.v;
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (xrVar == null) {
            if (this.v != null) {
                this.v = new ah(this.v);
                return;
            }
            return;
        }
        this.v = xrVar;
    }

    public int vy() {
        return this.qk;
    }

    public void nw(int i) {
        this.qk = i;
    }

    public int sk() {
        return this.vm;
    }

    public void b(int i) {
        this.vm = i;
    }

    public int gy() {
        return this.tz;
    }

    public void re(int i) {
        this.tz = i;
    }

    public int vl() {
        return this.qr;
    }

    public void i(int i) {
        this.qr = i;
    }

    public int qr() {
        return this.jm;
    }

    public void w(int i) {
        this.jm = i;
    }

    public void yu(int i) {
        this.o = i;
    }

    public int ce() {
        return this.o;
    }

    public int jm() {
        v vVar = this.nn;
        if (vVar == null) {
            return 1;
        }
        return vVar.ms();
    }

    public String bz() {
        v vVar = this.nn;
        return vVar == null ? "" : vVar.xr();
    }

    public boolean jy() {
        v vVar = this.nn;
        return vVar == null || vVar.ah();
    }

    public int j() {
        v vVar = this.nn;
        if (vVar == null) {
            return 50;
        }
        return vVar.d();
    }

    public int ih() {
        v vVar = this.nn;
        if (vVar == null) {
            return 236;
        }
        return vVar.ka();
    }

    public int oh() {
        v vVar = this.nn;
        if (vVar == null) {
            return 82;
        }
        return vVar.c();
    }

    public int zd() {
        v vVar = this.nn;
        if (vVar == null) {
            return 56;
        }
        return vVar.ab();
    }

    public int z() {
        v vVar = this.nn;
        if (vVar == null) {
            return 0;
        }
        return vVar.ny();
    }

    public String tk() {
        v vVar = this.nn;
        return vVar == null ? "#008DEA" : vVar.ch();
    }

    public String nn() {
        v vVar = this.nn;
        return vVar == null ? "点击查看" : vVar.hi();
    }

    public int o() {
        v vVar = this.nn;
        if (vVar == null) {
            return 0;
        }
        return vVar.x();
    }

    public int n() {
        return this.uc;
    }

    public void op(int i) {
        this.uc = i;
    }

    public int ec() {
        return this.we;
    }

    public void le(int i) {
        this.we = i;
    }

    public v.xr vf() {
        v vVar = this.nn;
        if (vVar != null) {
            return vVar.sl();
        }
        return null;
    }

    public v.xr kl() {
        v vVar = this.nn;
        if (vVar != null) {
            return vVar.zb();
        }
        return null;
    }

    public v.ms gs() {
        v vVar = this.nn;
        if (vVar != null) {
            return vVar.u();
        }
        return null;
    }

    private float al() {
        v vVar = this.nn;
        if (vVar == null) {
            return 5.0f;
        }
        return vVar.ub();
    }

    public int r() {
        vm vmVar = this.qd;
        if (vmVar == null) {
            return 2;
        }
        return vmVar.ms();
    }

    public int nl() {
        vm vmVar = this.qd;
        if (vmVar == null) {
            return 16;
        }
        return vmVar.xr();
    }

    public int qo() {
        vm vmVar = this.qd;
        if (vmVar == null) {
            return 30;
        }
        return vmVar.ah();
    }

    public int cc() {
        s sVar = this.qe;
        if (sVar == null) {
            return 0;
        }
        return sVar.ms();
    }

    public int cj() {
        s sVar = this.qe;
        if (sVar == null) {
            return 90;
        }
        return sVar.xr();
    }

    public int wq() {
        s sVar = this.qe;
        if (sVar == null) {
            return 90;
        }
        return sVar.ah();
    }

    public ms si() {
        return this.il;
    }

    public void ms(ms msVar) {
        this.il = msVar;
        com.bytedance.sdk.component.adexpress.ms.ah.d dVarA = a();
        if (dVarA != null && !na()) {
            com.bytedance.sdk.component.adexpress.ms.xr.xr.ms(dVarA);
        }
        if (msVar == null || TextUtils.isEmpty(msVar.ny())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(msVar);
    }

    public rt pl() {
        return this.br;
    }

    public void ms(rt rtVar) {
        this.br = rtVar;
    }

    public JSONObject di() {
        return this.zm;
    }

    public void ah(JSONObject jSONObject) {
        this.zm = jSONObject;
    }

    public com.bytedance.sdk.component.adexpress.ms.ah.d a() {
        if (si() == null) {
            return null;
        }
        String strXr = si().xr();
        String strD = si().d();
        String strAh = si().ah();
        String strKa = si().ka();
        return com.bytedance.sdk.component.adexpress.ms.ah.d.ms().ms(strXr).xr(strAh).ah(strD).d(strKa).ka(si().ms()).c(String.valueOf(com.bytedance.sdk.openadsdk.core.jw.f.ny(this)));
    }

    public nw mh() {
        return this.fm;
    }

    public void ms(nw nwVar) {
        this.fm = nwVar;
    }

    public JSONObject wp() {
        return this.ad;
    }

    public void d(JSONObject jSONObject) {
        this.ad = jSONObject;
    }

    public v kk() {
        return this.nn;
    }

    public void ms(v vVar) {
        this.nn = vVar;
    }

    public c ph() {
        return this.fb;
    }

    public void ms(c cVar) {
        this.fb = cVar;
    }

    public String zx() {
        return this.us;
    }

    public void sl(String str) {
        this.us = str;
    }

    public int dv() {
        return this.ii;
    }

    public void cv(int i) {
        this.ii = i;
    }

    public int oy() {
        return this.bk;
    }

    public void g(int i) {
        if (i != 1) {
            i = 0;
        }
        this.bk = i;
    }

    public void ms(qr qrVar) {
        this.p = qrVar;
    }

    public qr oi() {
        return this.p;
    }

    public int vx() {
        return this.pc;
    }

    public void of(int i) {
        this.pc = i;
    }

    public String nq() {
        return this.w;
    }

    public void zb(String str) {
        this.w = str;
    }

    public int jr() {
        return this.d;
    }

    public void p(int i) {
        this.d = i;
    }

    public g qd() {
        return this.ka;
    }

    public void ms(g gVar) {
        this.ka = gVar;
    }

    public String ir() {
        return this.c;
    }

    public void u(String str) {
        this.c = str;
    }

    public int jj() {
        return this.ab;
    }

    public void pc(int i) {
        this.ab = i;
    }

    public String so() {
        return this.x;
    }

    public void ub(String str) {
        this.x = str;
    }

    public JSONObject uc() {
        return this.ny;
    }

    public void ka(JSONObject jSONObject) {
        this.ny = jSONObject;
    }

    public JSONObject we() {
        return this.ch;
    }

    public void c(JSONObject jSONObject) {
        this.ch = jSONObject;
    }

    public List<g> fk() {
        return this.hi;
    }

    public void xr(g gVar) {
        this.hi.add(gVar);
    }

    public String wc() {
        return this.sl;
    }

    public void ao(String str) {
        this.sl = str;
    }

    public List<String> qe() {
        return this.zb;
    }

    public List<String> ue() {
        return this.u;
    }

    public String eh() {
        return this.ub;
    }

    public void h(String str) {
        this.ub = str;
    }

    public long vi() {
        return this.ao;
    }

    public void d(long j) {
        this.ao = j;
    }

    public String fs() {
        return this.h;
    }

    public void qv(String str) {
        this.h = str;
    }

    public String bn() {
        return this.qv;
    }

    public void y(String str) {
        this.qv = str;
    }

    public String df() {
        return this.y;
    }

    public void t(String str) {
        this.y = str;
    }

    public ka zh() {
        return this.nw;
    }

    public void ms(ka kaVar) {
        this.nw = kaVar;
    }

    public b yy() {
        return this.b;
    }

    public void ms(b bVar) {
        this.b = bVar;
    }

    public h tc() {
        return this.re;
    }

    public void ms(h hVar) {
        this.re = hVar;
    }

    public String lx() {
        return this.yu;
    }

    public void nw(String str) {
        this.yu = str;
    }

    public int tf() {
        return this.tk;
    }

    public void jw(int i) {
        this.tk = i;
    }

    public String eu() {
        return this.le;
    }

    public void b(String str) {
        this.le = str;
    }

    public String cz() {
        return this.t;
    }

    public void re(String str) {
        this.t = str;
    }

    public JSONObject it() {
        if (this.op == null) {
            try {
                if (!TextUtils.isEmpty(this.yu)) {
                    this.op = new JSONObject(this.yu);
                }
            } catch (JSONException unused) {
            }
        }
        return this.op;
    }

    public String fl() {
        try {
            return it().optString("convert_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int kz() {
        return this.i;
    }

    public void f(int i) {
        this.i = i;
    }

    public long no() {
        return this.cv;
    }

    public void ka(long j) {
        this.cv = j;
    }

    public int fb() {
        return this.g;
    }

    public void ul(int i) {
        this.g = i;
    }

    public boolean us() {
        return this.jw;
    }

    public void ab(boolean z) {
        this.jw = z;
    }

    public boolean ii() {
        return this.f;
    }

    public void x(boolean z) {
        this.f = z;
    }

    public long bk() {
        return this.lm;
    }

    public void c(long j) {
        this.lm = j;
    }

    public String wg() {
        return this.e;
    }

    public void i(String str) {
        this.e = str;
    }

    public void w(String str) {
        this.k = str;
    }

    public String wn() {
        return this.k;
    }

    public boolean fg() {
        return (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.jw.f.ch(this)) || TextUtils.isEmpty(this.k) || com.bytedance.sdk.openadsdk.core.jw.f.ch(this).contains(this.k)) ? false : true;
    }

    public int ss() {
        return this.ul;
    }

    public void az(int i) {
        this.ul = i;
    }

    public long ci() {
        return this.az;
    }

    public void ab(long j) {
        this.az = j;
    }

    public long ad() {
        return this.m;
    }

    public void x(long j) {
        this.m = j;
    }

    public boolean pn() {
        return this.eg;
    }

    public void ny(boolean z) {
        this.eg = z;
    }

    public Map<String, Object> ou() {
        return this.xn;
    }

    public void ms(Map<String, Object> map) {
        this.xn = map;
    }

    public JSONObject vt() {
        return this.vl;
    }

    public void ab(JSONObject jSONObject) {
        this.vl = jSONObject;
    }

    public JSONObject br() {
        return this.ce;
    }

    public void x(JSONObject jSONObject) {
        this.ce = jSONObject;
    }

    public String zm() {
        return this.rt;
    }

    public void yu(String str) {
        this.rt = str;
    }

    public int xf() {
        return this.bz;
    }

    public boolean sh() {
        return xf() == 1;
    }

    public void m(int i) {
        this.bz = i;
    }

    public boolean gz() {
        return ho() == 1;
    }

    public int ho() {
        return this.jy;
    }

    public void lm(int i) {
        this.jy = i;
    }

    public String yw() {
        return this.xr;
    }

    public void op(String str) {
        this.xr = str;
    }

    public int du() {
        return this.ih;
    }

    public void e(int i) {
        this.ih = i;
    }

    public int ha() {
        return this.oh;
    }

    public void k(int i) {
        this.oh = i;
    }

    public int ht() {
        return this.zd;
    }

    public void eg(int i) {
        this.zd = i;
    }

    public int nk() {
        return this.z;
    }

    public void fm(int i) {
        this.z = i;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        this.ah = xrVar;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.ah.xr ca() {
        com.bytedance.sdk.openadsdk.core.dislike.ms.ms();
        return this.ah;
    }

    public k hy() {
        return this.oy;
    }

    public void ms(k kVar) {
        this.oy = kVar;
    }

    public pc kh() {
        return this.fl;
    }

    public void ms(pc pcVar) {
        this.fl = pcVar;
    }

    public String pt() {
        return this.pl;
    }

    public void le(String str) {
        this.pl = str;
    }

    public boolean qu() {
        return kv() != 1;
    }

    public int kv() {
        return this.di;
    }

    public void xn(int i) {
        this.di = i;
    }

    public String zg() {
        return this.si;
    }

    public void cv(String str) {
        this.si = str;
    }

    public int od() {
        if (this.a != 2) {
            this.a = 1;
        }
        return this.a;
    }

    public void il(int i) {
        this.a = i;
    }

    public float ld() {
        if (this.mh <= 0.0f) {
            this.mh = 100.0f;
        }
        return (this.mh * 1000.0f) / 1000.0f;
    }

    public void g(String str) {
        this.wg = str;
    }

    public String yq() {
        return this.wg;
    }

    public void ny(long j) {
        if (j != 0) {
            this.wn = j;
        } else {
            this.wn = System.currentTimeMillis() / 1000;
        }
    }

    public long zj() {
        return this.wn;
    }

    public void ms(float f) {
        this.mh = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            lm lmVar = (lm) obj;
            if (this.y.equals(lmVar.y) && this.yu.equals(lmVar.yu)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.y.hashCode() * 31) + this.yu.hashCode();
    }

    public boolean jl() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this)) {
            return true;
        }
        if (this.hi.isEmpty()) {
            return false;
        }
        if (this.i == 4 && this.hi.size() < 3) {
            return false;
        }
        Iterator<g> it = this.hi.iterator();
        while (it.hasNext()) {
            if (!it.next().ka()) {
                return false;
            }
        }
        return true;
    }

    public boolean rk() {
        if (ca() != null) {
            return ca().ka();
        }
        return false;
    }

    public int on() {
        return this.ir;
    }

    public void qf(int i) {
        if (i < 12) {
            i = 12;
        }
        if (i > 20) {
            i = 20;
        }
        this.ir = i;
    }

    public int ia() {
        return this.jj;
    }

    public void l(int i) {
        if (i < 0 || i > 180) {
            this.jj = 50;
        } else {
            this.jj = i;
        }
    }

    public boolean gx() {
        int iU = com.bytedance.sdk.openadsdk.core.jw.f.u(this);
        return iU == 3 || iU == 6;
    }

    public String ze() {
        if (!TextUtils.isEmpty(this.wp)) {
            this.wp = this.wp.trim();
        }
        return this.wp;
    }

    public void of(String str) {
        this.wp = str;
    }

    public int hg() {
        return this.kk;
    }

    public void am(int i) {
        this.kk = i;
    }

    public int cb() {
        return this.dv;
    }

    public void sa(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.dv = i;
    }

    public JSONObject sz() {
        return this.ca;
    }

    public void ny(JSONObject jSONObject) {
        this.ca = jSONObject;
    }

    public w jc() {
        return this.ht;
    }

    public yu yl() {
        return this.nk;
    }

    public void ms(w wVar) {
        this.ht = wVar;
        if (wVar != null) {
            String strXr = wVar.xr();
            String strAh = this.ht.ah();
            if (TextUtils.isEmpty(strXr)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(strXr, strAh);
        }
    }

    public void ms(yu yuVar) {
        this.nk = yuVar;
    }

    public int vv() {
        return t.x(this);
    }

    public int pq() {
        JSONObject jSONObject = this.ny;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public xn or() {
        return this.oi;
    }

    public void ms(xn xnVar) {
        this.oi = xnVar;
    }

    public f dm() {
        return this.vx;
    }

    public void ms(f fVar) {
        this.vx = fVar;
    }

    public float mp() {
        float f = this.fk;
        if (f < 0.07f || f > 0.175f) {
            this.fk = 0.07f;
        }
        return this.fk;
    }

    public void xr(float f) {
        this.fk = f;
    }

    public float ae() {
        float f = this.wc;
        if (f < 0.0f || f > 50.0f) {
            this.wc = 0.0f;
        }
        return this.wc;
    }

    public void ah(float f) {
        this.wc = f;
    }

    public ce js() {
        return this.f3065ms;
    }

    public void ms(ce ceVar) {
        this.f3065ms = ceVar;
    }

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
    public JSONObject rm() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "position";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s_sig_ts", yq());
            jSONObject.put("ad_rec_stamp", zj());
            jSONObject.put("interaction_type", jr());
            jSONObject.put("target_url", ir());
            jSONObject.put("use_media_video_player", e());
            jSONObject.put("landing_scroll_percentage", jj());
            jSONObject.put("gecko_id", so());
            jSONObject.put("extension", uc());
            jSONObject.put("overlay", we());
            jSONObject.put("ad_id", df());
            jSONObject.put("source", nq());
            jSONObject.put("package_name", yw());
            jSONObject.put("screenshot", us());
            jSONObject.put("play_bar_style", vm());
            jSONObject.put("play_bar_show_time", gy());
            jSONObject.put("if_block_lp", xn());
            jSONObject.put("cache_sort", vl());
            jSONObject.put("if_sp_cache", qr());
            jSONObject.put("splash_timeout_stage", ce());
            jSONObject.put("render_control", fm());
            jSONObject.put("is_from_local_cache", ii());
            jSONObject.put("is_from_cache_type", ss());
            jSONObject.put("correct_action_code", ci());
            jSONObject.put("correct_result_code", ad());
            jSONObject.put("meta_hashcode", ka());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.anythink.basead.c.b.a.k, m());
            jSONObject2.put(AdnName.OTHER, az());
            jSONObject.put("set_click_type", jSONObject2);
            g gVarQd = qd();
            if (gVarQd != null && !TextUtils.isEmpty(gVarQd.ms())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", gVarQd.ms());
                jSONObject3.put("height", gVarQd.ah());
                jSONObject3.put("width", gVarQd.xr());
                jSONObject.put("icon", jSONObject3);
            }
            Object objVt = vt();
            if (objVt != null) {
                jSONObject.put("session_params", objVt);
            }
            Object objBr = br();
            if (objBr != null) {
                jSONObject.put("cache_control", objBr);
            }
            ny nyVarZf = zf();
            if (nyVarZf != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("click_upper_content_area", nyVarZf.f3071ms);
                jSONObject4.put("click_upper_non_content_area", nyVarZf.xr);
                jSONObject4.put("click_lower_content_area", nyVarZf.ah);
                jSONObject4.put("click_lower_non_content_area", nyVarZf.d);
                jSONObject4.put("click_button_area", nyVarZf.ka);
                jSONObject4.put("click_video_area", nyVarZf.c);
                jSONObject.put(com.anythink.basead.ui.improveclick.g.a.g, jSONObject4);
            }
            com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = rt();
            if (xrVarRt != null) {
                jSONObject.put("adslot", com.bytedance.sdk.openadsdk.core.jw.op.ms(xrVarRt));
            }
            List<g> listFk = fk();
            if (listFk != null) {
                JSONArray jSONArray = new JSONArray();
                for (g gVar : listFk) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", gVar.ms());
                    jSONObject5.put("height", gVar.ah());
                    jSONObject5.put("width", gVar.xr());
                    jSONObject5.put("image_preview", gVar.c());
                    jSONObject5.put("image_key", gVar.ab());
                    jSONArray.put(jSONObject5);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listQe = qe();
            if (listQe != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listQe.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listUe = ue();
            if (listUe != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listUe.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put(com.anythink.basead.c.b.a.p, jSONArray3);
            }
            jSONObject.put("phone_num", wc());
            jSONObject.put("title", eh());
            jSONObject.put("download_num", vi());
            jSONObject.put(BundleKey.DESCRIPTION, fs());
            jSONObject.put("ext", lx());
            jSONObject.put("req_id", eu());
            jSONObject.put("image_mode", kz());
            jSONObject.put("intercept_flag", vy());
            jSONObject.put("web_inspector", sk());
            jSONObject.put("button_text", bn());
            jSONObject.put("ad_logo", qk());
            jSONObject.put("video_adaptation", v());
            jSONObject.put("feed_video_opentype", ti());
            jSONObject.put("feed_reward_type", s());
            jSONObject.put(TapATInitManager.ORIENTATION_KEY, od());
            jSONObject.put("aspect_ratio", ld());
            jSONObject.put("aspect_margin", mp());
            jSONObject.put("corner_radius", ae());
            ka kaVarZh = zh();
            if (kaVarZh != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("app_name", kaVarZh.ah());
                jSONObject6.put("package_name", kaVarZh.d());
                jSONObject6.put("download_url", kaVarZh.xr());
                jSONObject6.put("score", kaVarZh.ka());
                jSONObject6.put("comment_num", kaVarZh.c());
                jSONObject6.put("quick_app_url", kaVarZh.ms());
                jSONObject6.put("app_size", kaVarZh.ab());
                jSONObject.put(a.C0080a.c, jSONObject6);
            }
            b bVarYy = yy();
            if (bVarYy != null) {
                jSONObject.put("download_sdk_conf", bVarYy.ah());
            }
            if (k() != null) {
                k().xr(jSONObject);
            }
            if (q() != null) {
                q().ms(jSONObject);
            }
            if (tc() != null) {
                tc().ms(jSONObject);
            }
            if (ca() != null) {
                ca().ms(jSONObject);
            }
            if (qf() != null) {
                qf().ms(jSONObject);
            }
            if (sa() != null) {
                sa().ms(jSONObject);
            }
            if (hy() != null) {
                hy().ms(jSONObject);
            }
            if (tz() != null) {
                tz().ms(jSONObject);
            }
            if (kh() != null) {
                kh().ms(jSONObject);
            }
            if (or() != null) {
                or().ms(jSONObject);
            }
            if (eg() != null) {
                eg().xr(jSONObject);
            }
            jSONObject.put("count_down", fb());
            jSONObject.put("expiration_time", no());
            jSONObject.put("_child_metas", sd());
            jSONObject.put("src_req_id", wn());
            jSONObject.put("player_type", pd());
            jSONObject.put("video_encode_type", vx());
            jSONObject.put("feed_video_finish_type", lm());
            if (oi() != null) {
                oi().ms(jSONObject);
            }
            if (mh() != null) {
                mh().ms(jSONObject);
            }
            jSONObject.put("if_both_open", xf());
            jSONObject.put("if_double_deeplink", ho());
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("splash_clickarea", jm());
            jSONObject7.put("splash_clicktext", bz());
            jSONObject7.put("area_height", j());
            jSONObject7.put("area_width", ih());
            jSONObject7.put("area_blank_height", oh());
            jSONObject7.put("half_blank_height", zd());
            jSONObject7.put("splash_style_id", z());
            jSONObject7.put("btn_background_dest_color", tk());
            jSONObject7.put("top_splash_clicktext", nn());
            jSONObject7.put("splash_load_time_optimization", o());
            jSONObject7.put("text_config", vf() != null ? vf().ms() : null);
            jSONObject7.put("top_text_config", kl() != null ? kl().ms() : null);
            jSONObject7.put("sliding_distance", al());
            jSONObject7.put("slide_area", gs() != null ? gs().ka() : null);
            jSONObject.put("splash_control", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("position", r());
            jSONObject8.put("left_or_right_margin", nl());
            jSONObject8.put("top_or_bottom_margin", qo());
            vm vmVar = this.qd;
            jSONObject8.put("skip_style", vmVar == null ? 1 : vmVar.d());
            vm vmVar2 = this.qd;
            jSONObject8.put("hide_native_skip_logo", vmVar2 == null ? 0 : vmVar2.ka());
            jSONObject.put("skip_control", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("show_type", cc());
            jSONObject9.put("blank", cj());
            jSONObject9.put("half_blank", wq());
            jSONObject.put("splash_compliance_bar", jSONObject9);
            if (ou() != null) {
                JSONObject jSONObject10 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = ou().entrySet();
                if (setEntrySet != null && !setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject10.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject10);
            }
            jSONObject.put("isDirectDownload", ub());
            ms msVarSi = si();
            if (msVarSi != null) {
                str = "height";
                try {
                    JSONObject jSONObject11 = new JSONObject();
                    str2 = "width";
                    try {
                        jSONObject11.put("id", msVarSi.xr());
                        jSONObject11.put("md5", msVarSi.ah());
                        jSONObject11.put("url", msVarSi.d());
                        str5 = "position";
                        try {
                            jSONObject11.put("data", msVarSi.ka());
                            jSONObject11.put("diff_data", msVarSi.c());
                            jSONObject11.put("version", msVarSi.ms());
                            jSONObject11.put("dynamic_creative", msVarSi.ab());
                            jSONObject11.put("material_type", msVarSi.x());
                            jSONObject11.put("ugen_url", msVarSi.ny());
                            jSONObject11.put("ugen_md5", msVarSi.ch());
                            jSONObject11.put("engine_version", msVarSi.hi());
                            jSONObject11.put("express_gesture_priority", msVarSi.sl());
                            jSONObject.put("tpl_info", jSONObject11);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        str5 = "position";
                    }
                } catch (Exception unused3) {
                    str2 = "width";
                }
            } else {
                str5 = "position";
                str = "height";
                str2 = "width";
            }
            jSONObject.put("dynamic_creative", di());
            rt rtVar = this.br;
            if (rtVar != null) {
                jSONObject.put("tpl_info_v3", rtVar.x());
            }
            jSONObject.put("page_render_type", yu());
            jSONObject.put("promotion_type", ul());
            jSONObject.put("if_lpua_package", this.kv);
            jSONObject.put("click_freq", this.jl);
            com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVarOp = op();
            if (msVarOp != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("id", msVarOp.ms());
                jSONObject12.put("md5", msVarOp.xr());
                jSONObject12.put("url", msVarOp.ah());
                jSONObject12.put(com.umeng.ccg.a.j, msVarOp.d());
                jSONObject.put("ugeno", jSONObject12);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVarLe = le();
            if (msVarLe != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("product_infos", msVarLe.ms());
                jSONObject13.put("coupon", msVarLe.xr());
                jSONObject13.put("render_config", msVarLe.ah());
                jSONObject13.put("live_room_data", msVarLe.d());
                jSONObject13.putOpt("ec_mall_conf", msVarLe.ka());
                jSONObject.put("dylite_info", jSONObject13);
            }
            jSONObject.put("native_lp_data", h());
            jSONObject.put("native_lp_tpl_id", qv());
            jSONObject.put("native_lp_ugen_url", y());
            jSONObject.put("native_lp_ugen_md5", t());
            jSONObject.put("download_url", ao());
            jSONObject.put("native_lp_is_preload", nw());
            if (nw()) {
                jSONObject.put("native_lp_content", b());
            }
            jSONObject.put("market_url", zm());
            jSONObject.put("close_on_dislike", qj());
            c cVarPh = ph();
            if (cVarPh != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("developer_name", cVarPh.ab());
                jSONObject14.put("app_version", cVarPh.ka());
                jSONObject14.put("permissions", cVarPh.sl());
                jSONObject14.put("privacy_policy_url", cVarPh.x());
                jSONObject14.put("package_name", cVarPh.zb());
                jSONObject14.put("app_name", cVarPh.u());
                jSONObject14.put("score", cVarPh.ah());
                jSONObject14.put("creative_tags", cVarPh.d());
                jSONObject14.put("permissions_url", cVarPh.xr());
                jSONObject14.put("desc_url", cVarPh.ny());
                jSONObject14.put("reg_number", cVarPh.ch());
                jSONObject14.put("reg_url", cVarPh.hi());
                jSONObject.put("app_manage", jSONObject14);
            }
            w wVarJc = jc();
            if (wVarJc != null) {
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("ugen_dialog_url", wVarJc.xr());
                jSONObject15.put("ugen_dialog_md5", wVarJc.ah());
                jSONObject15.put("dialog_style", wVarJc.ms());
                jSONObject.put("easy_dl_dialog", jSONObject15);
            }
            if (sz() != null) {
                jSONObject.put("easy_pl_material", sz());
            }
            jSONObject.put("app_manage_type", dv());
            jSONObject.put("lp_down_rule", oy() == 1 ? 1 : 0);
            JSONObject jSONObject16 = new JSONObject();
            jSONObject16.put("render_sequence", du());
            jSONObject16.put("backup_render_control", ha());
            jSONObject16.put("render_thread", ht());
            jSONObject16.put("reserve_time", nk());
            jSONObject.put("render", jSONObject16);
            jSONObject.put("auction_price", pt());
            jSONObject.put("price", jw());
            jSONObject.put(Constants.p.a, zg());
            jSONObject.put("adx_name", ze());
            jSONObject.put("no_default_ttdsp_price", kv());
            jSONObject.put("endcard_close_time", hg());
            jSONObject.put("proportion_watching", cb());
            jSONObject.put("video_skip_result", qw());
            jSONObject.put("shake_value", on());
            jSONObject.put("deep_shake_value", iw());
            jSONObject.put("rotation_angle", ia());
            jSONObject.put("calculation_method", n());
            jSONObject.put("calculation_method_twist", ec());
            jSONObject.put("show_poll_time", kf());
            jSONObject.put("dynamic_join_type", tf());
            jSONObject.put("cache_ext", i());
            jSONObject.put("cache_time", re());
            jSONObject.put("req_id", cv());
            jSONObject.put("is_cache", g());
            jSONObject.put("log_ext", of());
            jSONObject.put("material_key", p());
            jSONObject.put("need_get_materials", pc());
            jSONObject.put("s_send_ts", f());
            jSONObject.put("parse_material_ts", w());
            ce ceVar = this.f3065ms;
            if (ceVar != null) {
                jSONObject.put("wc_miniapp_info", ceVar.ny());
            }
            sl slVarVr = vr();
            if (slVarVr != null) {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("click_trigger_type", slVarVr.ms());
                jSONObject17.put("shake_start_time", slVarVr.xr());
                jSONObject17.put("shake_end_time", slVarVr.ah());
                jSONObject.put("click_trigger_config", jSONObject17);
            }
            jSONObject.put("web_monitor_rate", xr());
        } catch (Exception unused4) {
            str = "height";
        }
        if (ws() != null) {
            ws().ms(jSONObject);
        }
        try {
            jSONObject.put("live_room_id", eo());
            jSONObject.put("ad_type", cn());
            jSONObject.put("live_interaction_type", ku());
            jSONObject.put("ec_schema", l());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        try {
            jSONObject.put("ecom_live_params", cs());
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
        }
        p pVarMo = mo();
        if (pVarMo != null) {
            pVarMo.ms(jSONObject);
        }
        re reVarGo = go();
        if (reVarGo != null) {
            reVarGo.ms(jSONObject);
        }
        f fVarDm = dm();
        if (fVarDm != null) {
            try {
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("reward_live_deep_link_user_id", fVarDm.ms());
                jSONObject18.put("reward_live_deep_link_request_id", fVarDm.c());
                jSONObject18.put("reward_live_deep_link_room_id", fVarDm.xr());
                jSONObject18.put("reward_live_last_time", fVarDm.ka());
                jSONObject18.put("reawrd_live_short_touch_params", fVarDm.ah());
                jSONObject18.put("reawrd_live_extra_pangle_scheme_params", fVarDm.d());
                jSONObject.put("reward_live_deep_link_params", jSONObject18);
            } catch (Exception unused5) {
            }
        }
        ub ubVarId = id();
        if (ubVarId != null) {
            try {
                JSONObject jSONObject19 = new JSONObject();
                jSONObject19.put("style_type", ubVarId.ms());
                jSONObject19.put(com.anythink.basead.c.b.a.h, ubVarId.xr());
                jSONObject19.put(str5, ubVarId.ah());
                jSONObject19.put("image_height", ubVarId.d());
                jSONObject19.put("image_scale_rate", ubVarId.c());
                jSONObject19.put("image_gif_url", ubVarId.ka());
                jSONObject19.put("image_gif_aspect_ratio", ubVarId.ab());
                jSONObject.put("dynamic_join_coupon_style", jSONObject19);
            } catch (Exception unused6) {
            }
        }
        u uVarRn = rn();
        if (uVarRn != null) {
            try {
                jSONObject.put("coupon", uVarRn.ms());
            } catch (JSONException e3) {
                com.bytedance.sdk.component.utils.sl.ms(e3);
            }
        }
        az azVarMl = ml();
        if (azVarMl != null) {
            try {
                jSONObject.put("live_info", azVarMl.ms());
            } catch (JSONException unused7) {
            }
        }
        am amVarMg = mg();
        if (amVarMg != null) {
            try {
                jSONObject.put("saas_info", amVarMg.ms());
            } catch (JSONException unused8) {
            }
        }
        Object objWp = wp();
        if (objWp != null) {
            try {
                jSONObject.put(com.umeng.analytics.pro.g.K, objWp);
            } catch (Exception unused9) {
            }
        }
        zf zfVarM22do = m22do();
        if (zfVarM22do != null) {
            try {
                JSONObject jSONObject20 = new JSONObject();
                jSONObject20.put("video_adapter_type", zfVarM22do.ms());
                jSONObject20.put("video_mute_type", zfVarM22do.xr());
                jSONObject.put("video_config", jSONObject20);
            } catch (Exception unused10) {
            }
        }
        try {
            jSONObject.put("not_valid_download_url", kr());
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.sl.ms(e4);
        }
        try {
            jSONObject.put("dynamic_configs", li());
            String strHw = hw();
            if (!TextUtils.isEmpty(strHw)) {
                jSONObject.put("gnd_prefetch_cache_key", strHw);
                jSONObject.put("gnd_prefetch_timing", rl());
            }
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.sl.ms(e5);
        }
        try {
            jSONObject.put("twist_config", ax());
            jSONObject.put("shake_interact_conf", wr());
            jSONObject.put("twist_interact_conf", rg());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.sl.ms(e6);
        }
        try {
            le leVar = this.yq;
            if (leVar != null) {
                leVar.xr(jSONObject);
            }
        } catch (Throwable unused11) {
        }
        try {
            of ofVar = this.zj;
            if (ofVar != null) {
                ofVar.xr(jSONObject);
            }
        } catch (Throwable unused12) {
        }
        qv qvVarU = u();
        if (qvVarU != null) {
            try {
                JSONObject jSONObject21 = new JSONObject();
                jSONObject21.put("lottie_tmp_url", qvVarU.ah());
                JSONArray jSONArray4 = new JSONArray();
                List<g> listMs = qvVarU.ms();
                if (listMs != null) {
                    for (g gVar2 : listMs) {
                        if (gVar2 != null) {
                            JSONObject jSONObject22 = new JSONObject();
                            str4 = str2;
                            jSONObject22.put(str4, gVar2.xr());
                            str3 = str;
                            jSONObject22.put(str3, gVar2.ah());
                            jSONObject22.put("url", gVar2.ms());
                            jSONArray4.put(jSONObject22);
                        } else {
                            str3 = str;
                            str4 = str2;
                        }
                        str2 = str4;
                        str = str3;
                    }
                }
                JSONArray jSONArray5 = new JSONArray();
                List<com.bykv.vk.openvk.component.video.api.ah.ah> listXr = qvVarU.xr();
                if (listXr != null) {
                    for (com.bykv.vk.openvk.component.video.api.ah.ah ahVar : listXr) {
                        if (ahVar != null) {
                            JSONObject jSONObject23 = new JSONObject();
                            jSONObject23.put("file_hash", ahVar.ub());
                            jSONObject23.put(bv.z, ahVar.ny());
                            jSONObject23.put("video_duration", ahVar.c());
                            jSONObject23.put("video_url", ahVar.sl());
                            jSONArray5.put(jSONObject23);
                        }
                    }
                }
                JSONObject jSONObject24 = new JSONObject();
                jSONObject24.put("bg_anim_img_android", jSONArray4);
                jSONObject24.put("bg_videos", jSONArray5);
                JSONObject jSONObject25 = new JSONObject();
                jSONObject25.put("sdk_template_info", jSONObject21);
                jSONObject25.put("aigc", jSONObject24);
                jSONObject.put("sdk_derive_info", jSONObject25);
            } catch (JSONException unused13) {
            }
        }
        try {
            jSONObject.put("disable_video_join", c());
            jSONObject.put("disable_top_bar", ch());
            jSONObject.put("disable_rtn_button", sl());
            jSONObject.put("disable_safe_area", d());
            jSONObject.put("disable_slide_return", x());
        } catch (Throwable unused14) {
        }
        return jSONObject;
    }

    public void p(String str) {
        this.vt = str;
    }

    public String li() {
        return this.vt;
    }

    public void ch(boolean z) {
        this.pn = z;
    }

    public boolean kr() {
        return this.pn;
    }

    public int pd() {
        return this.zx;
    }

    public void tz(int i) {
        this.zx = i;
    }

    public vm jf() {
        return this.qd;
    }

    public void ms(vm vmVar) {
        this.qd = vmVar;
    }

    public s qp() {
        return this.qe;
    }

    public void ms(s sVar) {
        this.qe = sVar;
    }

    public int kf() {
        return this.ue;
    }

    public void ti(int i) {
        int i2 = 500;
        if (i == Integer.MIN_VALUE) {
            i = com.bytedance.sdk.openadsdk.core.jw.f.x(this) == 3 ? 500 : 1000;
        }
        if (i >= 500) {
            i2 = 3000;
            if (i <= 3000) {
                i2 = i;
            }
        }
        this.ue = i2;
    }

    public String eo() {
        return this.eh;
    }

    public void pc(String str) {
        this.eh = str;
    }

    public int cn() {
        return this.vi;
    }

    public void s(int i) {
        this.vi = i;
    }

    public int ku() {
        return this.fs;
    }

    public void v(int i) {
        this.fs = i;
    }

    public void ms(fm fmVar) {
        this.l = fmVar;
    }

    public String cs() {
        return this.df;
    }

    public void jw(String str) {
        this.df = str;
    }

    public u rn() {
        return this.zh;
    }

    public void ms(u uVar) {
        this.zh = uVar;
    }

    public az ml() {
        return this.yy;
    }

    public void ms(az azVar) {
        this.yy = azVar;
    }

    public am mg() {
        return this.tc;
    }

    public void ms(am amVar) {
        this.tc = amVar;
    }

    public boolean qj() {
        return this.n;
    }

    public void hi(boolean z) {
        this.n = z;
    }

    public int qw() {
        return this.ph;
    }

    public void qk(int i) {
        if (i <= 0 || i > 9) {
            this.ph = 3;
        } else {
            this.ph = i;
        }
    }

    public ub id() {
        return this.bn;
    }

    public void ms(ub ubVar) {
        this.bn = ubVar;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public zf m22do() {
        return this.lx;
    }

    public void ms(zf zfVar) {
        this.lx = zfVar;
    }

    public int iw() {
        if (this.d == 4 && TextUtils.isEmpty(this.rt)) {
            return this.so;
        }
        return 0;
    }

    public void vm(int i) {
        this.so = i;
    }

    public void f(String str) {
        this.mp = str;
    }

    public String sd() {
        return this.mp;
    }

    public fm q() {
        return this.l;
    }

    public sl vr() {
        return this.ss;
    }

    public void ms(sl slVar) {
        this.ss = slVar;
    }

    public void ms(ul ulVar) {
        this.am = ulVar;
    }

    public ul ws() {
        return this.am;
    }

    public void ms(com.bykv.vk.openvk.component.video.api.ah.ah ahVar) {
        if (this.p == null) {
            this.p = new qr();
        }
        this.p.ms(ahVar);
    }

    public void sl(boolean z) {
        this.ci = z;
    }

    public boolean kb() {
        return this.ci;
    }

    public void ms(p pVar) {
        this.kz = pVar;
    }

    public p mo() {
        return this.kz;
    }

    public void ms(re reVar) {
        this.no = reVar;
    }

    public re go() {
        return this.no;
    }

    public int rl() {
        return this.hy;
    }

    public void zf(int i) {
        this.hy = i;
    }

    public String hw() {
        return this.kh;
    }

    public void ul(String str) {
        this.kh = str;
    }

    public static boolean d(lm lmVar) {
        return lmVar != null && lmVar.kv == 1;
    }

    public void rt(int i) {
        this.jl = i;
    }

    public static boolean ka(lm lmVar) {
        if (lmVar == null || lmVar.on <= 0 || lmVar.jl <= 0) {
            return false;
        }
        boolean z = System.currentTimeMillis() - lmVar.on < ((long) lmVar.jl);
        if (z) {
            lmVar.ia++;
            com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.lm.1
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("count", lm.this.ia);
                    jSONObject.put("click_freq", lm.this.jl);
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("click_intercept").x(lm.this.lx()).xr(jSONObject.toString());
                }
            }, "click_intercept");
        }
        return z;
    }

    public static void c(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        lmVar.on = System.currentTimeMillis();
    }

    public void vy(int i) {
        this.kv = i;
    }

    public JSONObject ax() {
        return this.zg;
    }

    public void ch(JSONObject jSONObject) {
        this.zg = jSONObject;
    }

    public JSONObject wr() {
        return this.od;
    }

    public void hi(JSONObject jSONObject) {
        this.od = jSONObject;
    }

    public JSONObject rg() {
        return this.ld;
    }

    public void sl(JSONObject jSONObject) {
        this.ld = jSONObject;
    }

    public String xg() {
        return hashCode() + eu() + w();
    }

    public String da() {
        JSONObject jSONObject = this.vl;
        String strOptString = jSONObject != null ? jSONObject.optString("session_id") : "";
        return TextUtils.isEmpty(strOptString) ? xg() : strOptString;
    }

    public void ms(le leVar) {
        this.yq = leVar;
    }

    public le fi() {
        return this.yq;
    }

    public boolean na() {
        ms msVar = this.il;
        if (msVar != null) {
            return !TextUtils.isEmpty(msVar.ch);
        }
        int i = this.ih;
        return i == 9 || i == 10;
    }

    public void ms(op opVar) {
        this.gx = opVar;
    }

    public op gk() {
        return this.gx;
    }

    public static class ms {
        private String ab;
        private String ah;
        private String c;
        private String ch;
        private String d;
        private String hi;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f3067ms;
        private String ny;
        private String sl;
        private String x;
        private String xr;

        public String ms() {
            return this.c;
        }

        public void ms(String str) {
            this.c = str;
        }

        public String xr() {
            return this.f3067ms;
        }

        public void xr(String str) {
            this.f3067ms = str;
        }

        public String ah() {
            return this.xr;
        }

        public void ah(String str) {
            this.xr = str;
        }

        public String d() {
            return this.ah;
        }

        public void d(String str) {
            this.ah = str;
        }

        public String ka() {
            return this.d;
        }

        public void ka(String str) {
            this.d = str;
        }

        public String c() {
            return this.ka;
        }

        public void c(String str) {
            this.ka = str;
        }

        public String ab() {
            return this.ab;
        }

        public void ab(String str) {
            this.ab = str;
        }

        public String x() {
            return this.sl;
        }

        public void x(String str) {
            this.sl = str;
        }

        public String ny() {
            return this.x;
        }

        public void ny(String str) {
            this.x = str;
        }

        public String ch() {
            return this.ny;
        }

        public void ch(String str) {
            this.ny = str;
        }

        public String hi() {
            return this.ch;
        }

        public void hi(String str) {
            this.ch = str;
        }

        public String sl() {
            return this.hi;
        }

        public void sl(String str) {
            this.hi = str;
        }
    }
}
