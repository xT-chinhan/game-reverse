package com.bytedance.sdk.component.adexpress.dynamic.ah;

import com.anythink.core.common.e.f;
import com.bytedance.sdk.component.utils.sl;
import com.umeng.analytics.pro.ek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private int a;
    private float ab;
    private float ah;
    private boolean am;
    private String ao;
    private int az;
    private String b;
    private int bz;
    private float c;
    private boolean cc;
    private String ce;
    private float ch;
    private JSONObject cj;
    private double cv;
    private float d;
    private int di;
    private int dv;
    private int e;
    private int ec;
    private int eg;
    private boolean f;
    private boolean fm;
    private String g;
    private JSONObject gs;
    private int gy;
    private String h;
    private double hi;
    private String i;
    private List<ms> ih;
    private boolean il;
    private String ir;
    private int j;
    private List<String> jj;
    private boolean jm;
    private long jr = -1;
    private String jw;
    private int jy;
    private double k;
    private boolean ka;
    private boolean kk;
    private double kl;
    private String l;
    private double le;
    private int lm;
    private int m;
    private String mh;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f760ms;
    private boolean n;
    private int nl;
    private boolean nn;
    private String nq;
    private String nw;
    private float ny;
    private boolean o;
    private String of;
    private int oh;
    private int oi;
    private int op;
    private int oy;
    private String p;
    private String pc;
    private String ph;
    private int pl;
    private String qd;
    private int qf;
    private int qk;
    private String qo;
    private String qr;
    private String qv;
    private JSONObject r;
    private String re;
    private int rt;
    private String s;
    private boolean sa;
    private int si;
    private int sk;
    private double sl;
    private boolean so;
    private String t;
    private boolean ti;
    private int tk;
    private boolean tz;
    private String u;
    private String ub;
    private String uc;
    private int ul;
    private JSONObject v;
    private boolean vf;
    private int vl;
    private boolean vm;
    private String vx;
    private int vy;
    private boolean w;
    private int wp;
    private int wq;
    private float x;
    private int xn;
    private float xr;
    private String y;
    private int yu;
    private int z;
    private String zb;
    private int zd;
    private int zf;
    private boolean zx;

    public static c ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.xr(jSONObject.optString("adType", "embeded"));
        cVar.ub(jSONObject.optString("clickArea", "creative"));
        cVar.ao(jSONObject.optString("clickTigger", "click"));
        cVar.ah(jSONObject.optString("fontFamily", "PingFangSC"));
        cVar.d(jSONObject.optString("textAlign", "left"));
        cVar.ka(jSONObject.optString("color", "#999999"));
        cVar.c(jSONObject.optString("bgColor", "transparent"));
        cVar.ab(jSONObject.optString("bgImgUrl", ""));
        cVar.le(jSONObject.optString("bgImgData", ""));
        cVar.x(jSONObject.optString("borderColor", "#000000"));
        cVar.ny(jSONObject.optString("borderStyle", "solid"));
        cVar.ch(jSONObject.optString("heightMode", "auto"));
        cVar.hi(jSONObject.optString("widthMode", "fixed"));
        cVar.sl(jSONObject.optString("interactText", ""));
        cVar.ah(jSONObject.optBoolean("isShowBgControl", false));
        cVar.zb(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            cVar.ab(jSONObjectOptJSONObject.optInt("translateY", 0));
            cVar.x(jSONObjectOptJSONObject.optInt("translateX", 0));
            cVar.d(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            cVar.ka(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        cVar.u(jSONObject.optString("interactType", ""));
        cVar.ka(jSONObject.optInt("interactSlideDirection", -1));
        cVar.h(jSONObject.optString("justifyHorizontal", "space-around"));
        cVar.qv(jSONObject.optString("justifyVertical", "flex-start"));
        cVar.xr(jSONObject.optDouble("timingStart"));
        cVar.ah(jSONObject.optDouble("timingEnd"));
        cVar.d((float) jSONObject.optDouble("width", 0.0d));
        cVar.ah((float) jSONObject.optDouble("height", 0.0d));
        cVar.ms((float) jSONObject.optDouble("borderRadius", 0.0d));
        cVar.xr((float) jSONObject.optDouble("borderSize", 0.0d));
        cVar.xr(jSONObject.optBoolean("interactValidate", false));
        cVar.ny((float) jSONObject.optDouble("fontSize", 0.0d));
        cVar.ka((float) jSONObject.optDouble("paddingBottom", 0.0d));
        cVar.c((float) jSONObject.optDouble("paddingLeft", 0.0d));
        cVar.ab((float) jSONObject.optDouble("paddingRight", 0.0d));
        cVar.x((float) jSONObject.optDouble("paddingTop", 0.0d));
        cVar.d(jSONObject.optBoolean("lineFeed", false));
        cVar.ny(jSONObject.optInt("lineCount", 0));
        cVar.c(jSONObject.optDouble("lineHeight", 1.2d));
        cVar.u(jSONObject.optInt("letterSpacing", 0));
        cVar.ka(jSONObject.optBoolean("isDataFixed", false));
        cVar.ub(jSONObject.optInt("fontWeight"));
        cVar.c(jSONObject.optBoolean("lineLimit"));
        cVar.ao(jSONObject.optInt("position"));
        cVar.y(jSONObject.optString("align"));
        cVar.ab(jSONObject.optBoolean("useLeft"));
        cVar.x(jSONObject.optBoolean("useRight"));
        cVar.ny(jSONObject.optBoolean("useTop"));
        cVar.ch(jSONObject.optBoolean("useBottom"));
        cVar.t(jSONObject.optString("data"));
        cVar.xr(jSONObject.optJSONObject("i18n"));
        cVar.sl(jSONObject.optInt("marginLeft"));
        cVar.zb(jSONObject.optInt("marginRight"));
        cVar.ch(jSONObject.optInt("marginTop"));
        cVar.hi(jSONObject.optInt("marginBottom"));
        cVar.h(jSONObject.optInt("tagMaxCount"));
        cVar.hi(jSONObject.optBoolean("allowTextFlow"));
        cVar.qv(jSONObject.optInt("textFlowType"));
        cVar.y(jSONObject.optInt("textFlowDuration"));
        cVar.t(jSONObject.optInt("left"));
        cVar.nw(jSONObject.optInt("right"));
        cVar.b(jSONObject.optInt("top"));
        cVar.re(jSONObject.optInt("bottom"));
        cVar.nw(jSONObject.optString("alignItems", "flex-start"));
        cVar.b(jSONObject.optString("direction", ""));
        cVar.ms(jSONObject.optBoolean("loop", false));
        cVar.i(jSONObject.optInt("zIndex"));
        cVar.cv(jSONObject.optInt("interactVisibleTime"));
        cVar.w(jSONObject.optInt("interactHiddenTime"));
        cVar.zb(jSONObject.optBoolean("interactEnableMask"));
        cVar.u(jSONObject.optBoolean("interactWontHide"));
        cVar.ms(jSONObject.optString("bgGradient"));
        cVar.of(jSONObject.optInt("areaType"));
        cVar.p(jSONObject.optInt("interactSlideThreshold", 0));
        cVar.f(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.d.ms() ? 0 : 120));
        cVar.qv(jSONObject.optBoolean("openPlayableLandingPage", false));
        cVar.ah(jSONObject.optJSONObject("video"));
        cVar.d(jSONObject.optJSONObject("image"));
        cVar.pc(jSONObject.optInt("borderShadowExtent"));
        cVar.ub(jSONObject.optBoolean("bgGauseBlur"));
        cVar.jw(jSONObject.optInt("bgGauseBlurRadius"));
        cVar.ao(jSONObject.optBoolean("showTimeProgress", false));
        cVar.h(jSONObject.optBoolean("showPlayButton", false));
        cVar.ms(jSONObject.optDouble("bgColorCg", 0.0d));
        cVar.c(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        cVar.xr(jSONObject.optInt("borderTopLeftRadius", 0));
        cVar.ms(jSONObject.optInt("borderTopRightRadius", 0));
        cVar.d(jSONObject.optInt("borderBottomLeftRadius", 0));
        cVar.ah(jSONObject.optInt("borderBottomRightRadius", 0));
        cVar.ka(jSONObject.optJSONObject("interactI18n"));
        cVar.i(jSONObject.optString("imageObjectFit"));
        cVar.w(jSONObject.optString("interactTitle"));
        cVar.g(jSONObject.optInt("interactTextPositionTop"));
        cVar.re(jSONObject.optString("imageLottieTosPath"));
        cVar.sl(jSONObject.optBoolean("animationsLoop"));
        cVar.yu(jSONObject.optInt("lottieAppNameMaxLength"));
        cVar.le(jSONObject.optInt("lottieAdDescMaxLength"));
        cVar.op(jSONObject.optInt("lottieAdTitleMaxLength"));
        cVar.op(jSONObject.optString("imageFlipSlideType"));
        cVar.y(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filterColor");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
                cVar.xr(arrayList);
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    ms msVar = new ms();
                    msVar.ah(jSONObject2.optString("animationType"));
                    msVar.ms(jSONObject2.optDouble("animationDuration"));
                    msVar.xr(jSONObject2.optDouble("animationScaleX"));
                    msVar.ah(jSONObject2.optDouble("animationScaleY"));
                    msVar.d(jSONObject2.optString("animationTimeFunction"));
                    msVar.d(jSONObject2.optDouble("animationDelay"));
                    msVar.c(jSONObject2.optInt("animationIterationCount"));
                    msVar.ka(jSONObject2.optString("animationDirection"));
                    msVar.ka(jSONObject2.optDouble("animationInterval"));
                    msVar.ms(jSONObject2.optInt("animationBorderWidth"));
                    msVar.ms(jSONObject2.optLong(f.a.b));
                    msVar.xr(jSONObject2.optInt("animationEffectWidth"));
                    msVar.ah(jSONObject2.optInt("animationSwing", 1));
                    msVar.d(jSONObject2.optInt("animationTranslateX"));
                    msVar.ka(jSONObject2.optInt("animationTranslateY"));
                    msVar.xr(jSONObject2.optString("animationRippleBackgroundColor"));
                    msVar.ms(jSONObject2.optString("animationScaleDirection"));
                    msVar.ab(jSONObject2.optInt("animationFadeStart"));
                    msVar.x(jSONObject2.optInt("animationFadeEnd"));
                    msVar.c(jSONObject2.optString("animationFillMode"));
                    msVar.ny(jSONObject2.optInt("animationBounceHeight"));
                    if (cVar.y() > 0.0d) {
                        msVar.d(msVar.u() + cVar.y());
                    }
                    arrayList2.add(msVar);
                }
                cVar.ms(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                cVar.yu(jSONObject.optString("triggerSlideDirection", "0"));
                cVar.ms(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception e) {
            sl.ms(e);
        }
        return cVar;
    }

    public boolean ms() {
        return this.jm;
    }

    public void ms(boolean z) {
        this.jm = z;
    }

    public int xr() {
        return this.si;
    }

    public void ms(int i) {
        this.si = i;
    }

    public int ah() {
        return this.pl;
    }

    public void xr(int i) {
        this.pl = i;
    }

    public int d() {
        return this.di;
    }

    public void ah(int i) {
        this.di = i;
    }

    public int ka() {
        return this.a;
    }

    public void d(int i) {
        this.a = i;
    }

    public JSONObject c() {
        return this.cj;
    }

    public int ab() {
        return this.nl;
    }

    public void ka(int i) {
        this.nl = i;
    }

    public double x() {
        return this.kl;
    }

    public void ms(double d) {
        this.kl = d;
    }

    public int ny() {
        return this.wq;
    }

    public void c(int i) {
        this.wq = i;
    }

    public String ch() {
        return this.uc;
    }

    public void ms(String str) {
        this.uc = str;
    }

    public float hi() {
        return this.f760ms;
    }

    public void ms(float f) {
        this.f760ms = f;
    }

    public float sl() {
        return this.xr;
    }

    public void xr(float f) {
        this.xr = f;
    }

    public void ah(float f) {
        this.ah = f;
    }

    public void d(float f) {
        this.d = f;
    }

    public boolean zb() {
        return this.ka;
    }

    public void xr(boolean z) {
        this.ka = z;
    }

    public float u() {
        return this.c;
    }

    public void ka(float f) {
        this.c = f;
    }

    public float ub() {
        return this.ab;
    }

    public void c(float f) {
        this.ab = f;
    }

    public float ao() {
        return this.x;
    }

    public void ab(float f) {
        this.x = f;
    }

    public float h() {
        return this.ny;
    }

    public void x(float f) {
        this.ny = f;
    }

    public float qv() {
        return this.ch;
    }

    public void ny(float f) {
        this.ch = f;
    }

    public double y() {
        return this.hi;
    }

    public void xr(double d) {
        this.hi = d;
    }

    public double t() {
        return this.sl;
    }

    public void ah(double d) {
        this.sl = d;
    }

    public void xr(String str) {
        this.zb = str;
    }

    public void ah(String str) {
        this.u = str;
    }

    public String nw() {
        return this.ub;
    }

    public void d(String str) {
        this.ub = str;
    }

    public String b() {
        return this.ao;
    }

    public void ka(String str) {
        this.ao = str;
    }

    public String re() {
        return this.h;
    }

    public void c(String str) {
        this.h = str;
    }

    public void ab(String str) {
        this.qv = str;
    }

    public String i() {
        return this.qv;
    }

    private void le(String str) {
        this.qd = str;
    }

    public String w() {
        return this.qd;
    }

    public String yu() {
        return this.y;
    }

    public void x(String str) {
        this.y = str;
    }

    public void ny(String str) {
        this.t = str;
    }

    public String op() {
        return this.nw;
    }

    public void ch(String str) {
        this.nw = str;
    }

    public String le() {
        return this.b;
    }

    public void hi(String str) {
        this.b = str;
    }

    public String cv() {
        return this.re;
    }

    public void sl(String str) {
        this.re = str;
    }

    public String g() {
        return this.i;
    }

    public void zb(String str) {
        this.i = str;
    }

    public boolean of() {
        return this.w;
    }

    public void ah(boolean z) {
        this.w = z;
    }

    public int p() {
        return this.yu;
    }

    public void ab(int i) {
        this.yu = i;
    }

    public int pc() {
        return this.op;
    }

    public void x(int i) {
        this.op = i;
    }

    public double jw() {
        return this.le;
    }

    public void d(double d) {
        this.le = d;
    }

    public double f() {
        return this.cv;
    }

    public void ka(double d) {
        this.cv = d;
    }

    public String ul() {
        return this.g;
    }

    public void u(String str) {
        this.g = str;
    }

    public String az() {
        return this.of;
    }

    public void ub(String str) {
        this.of = str;
    }

    public String m() {
        return this.p;
    }

    public void ao(String str) {
        this.p = str;
    }

    public String lm() {
        return this.pc;
    }

    public void h(String str) {
        this.pc = str;
    }

    public String e() {
        return this.jw;
    }

    public void qv(String str) {
        this.jw = str;
    }

    public boolean k() {
        return this.f;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public void ny(int i) {
        this.ul = i;
    }

    public int eg() {
        return this.ul;
    }

    public int fm() {
        return this.az;
    }

    public void ch(int i) {
        this.az = i;
    }

    public int xn() {
        return this.m;
    }

    public void hi(int i) {
        this.m = i;
    }

    public int il() {
        return this.lm;
    }

    public void sl(int i) {
        this.lm = i;
    }

    public int qf() {
        return this.e;
    }

    public void zb(int i) {
        this.e = i;
    }

    public double l() {
        return this.k;
    }

    public void c(double d) {
        this.k = d;
    }

    public int am() {
        return this.eg;
    }

    public void u(int i) {
        this.eg = i;
    }

    public boolean sa() {
        return this.fm;
    }

    public void ka(boolean z) {
        this.fm = z;
    }

    public int tz() {
        return this.xn;
    }

    public void ub(int i) {
        this.xn = i;
    }

    public boolean ti() {
        return this.il;
    }

    public void c(boolean z) {
        this.il = z;
    }

    public int s() {
        return this.qf;
    }

    public void ao(int i) {
        this.qf = i;
    }

    public String v() {
        return this.l;
    }

    public void y(String str) {
        this.l = str;
    }

    public boolean qk() {
        return this.am;
    }

    public void ab(boolean z) {
        this.am = z;
    }

    public boolean vm() {
        return this.sa;
    }

    public void x(boolean z) {
        this.sa = z;
    }

    public boolean zf() {
        return this.tz;
    }

    public void ny(boolean z) {
        this.tz = z;
    }

    public boolean rt() {
        return this.ti;
    }

    public void ch(boolean z) {
        this.ti = z;
    }

    public String vy() {
        return this.s;
    }

    public void t(String str) {
        this.s = str;
    }

    public void xr(JSONObject jSONObject) {
        this.v = jSONObject;
    }

    public JSONObject sk() {
        return this.v;
    }

    public int gy() {
        return this.qk;
    }

    public void h(int i) {
        this.qk = i;
    }

    public boolean vl() {
        return this.vm;
    }

    public void hi(boolean z) {
        this.vm = z;
    }

    public int qr() {
        return this.zf;
    }

    public void qv(int i) {
        this.zf = i;
    }

    public int ce() {
        return this.rt;
    }

    public void y(int i) {
        this.rt = i;
    }

    public int jm() {
        return this.vy;
    }

    public void t(int i) {
        this.vy = i;
    }

    public int bz() {
        return this.sk;
    }

    public void nw(int i) {
        this.sk = i;
    }

    public int jy() {
        return this.gy;
    }

    public void b(int i) {
        this.gy = i;
    }

    public int j() {
        return this.vl;
    }

    public void re(int i) {
        this.vl = i;
    }

    public String ih() {
        return this.qr;
    }

    public void nw(String str) {
        this.qr = str;
    }

    public String oh() {
        return this.ce;
    }

    public void b(String str) {
        this.ce = str;
    }

    public int zd() {
        return this.bz;
    }

    public void i(int i) {
        this.bz = i;
    }

    public int z() {
        return this.jy;
    }

    public void w(int i) {
        this.jy = i;
    }

    public String tk() {
        return this.ph;
    }

    public void re(String str) {
        this.ph = str;
    }

    public boolean nn() {
        return this.zx;
    }

    public void sl(boolean z) {
        this.zx = z;
    }

    public int o() {
        return this.dv;
    }

    public void yu(int i) {
        this.dv = i;
    }

    public int n() {
        return this.oy;
    }

    public void op(int i) {
        this.oy = i;
    }

    public int ec() {
        return this.oi;
    }

    public void le(int i) {
        this.oi = i;
    }

    public boolean vf() {
        return this.kk;
    }

    public void zb(boolean z) {
        this.kk = z;
    }

    public int kl() {
        return this.j;
    }

    public void cv(int i) {
        this.j = i;
    }

    public void u(boolean z) {
        this.cc = z;
    }

    public boolean gs() {
        return this.cc;
    }

    public void i(String str) {
        this.mh = str;
    }

    public String r() {
        return this.mh;
    }

    public void g(int i) {
        this.wp = i;
    }

    public int nl() {
        return this.wp;
    }

    public List<ms> qo() {
        return this.ih;
    }

    public int cc() {
        List<ms> list = this.ih;
        if (list == null) {
            return 0;
        }
        for (ms msVar : list) {
            if ("translate".equals(msVar.ny()) && msVar.ab() < 0) {
                return -msVar.ab();
            }
        }
        return 0;
    }

    public void ms(List<ms> list) {
        this.ih = list;
    }

    public int cj() {
        return this.oh;
    }

    public void of(int i) {
        this.oh = i;
    }

    public int wq() {
        return this.zd;
    }

    public void p(int i) {
        this.zd = i;
    }

    public int si() {
        return this.z;
    }

    public void pc(int i) {
        this.z = i;
    }

    public boolean pl() {
        return this.nn;
    }

    public void ub(boolean z) {
        this.nn = z;
    }

    public int di() {
        return this.tk;
    }

    public void jw(int i) {
        this.tk = i;
    }

    public boolean a() {
        return this.o;
    }

    public void ao(boolean z) {
        this.o = z;
    }

    public boolean mh() {
        return this.n;
    }

    public void h(boolean z) {
        this.n = z;
    }

    public int wp() {
        return this.ec;
    }

    public void f(int i) {
        this.ec = i;
    }

    public String kk() {
        return this.qo;
    }

    public boolean ph() {
        return this.vf;
    }

    public void qv(boolean z) {
        this.vf = z;
    }

    public void ah(JSONObject jSONObject) {
        this.gs = jSONObject;
    }

    public JSONObject zx() {
        return this.r;
    }

    public void d(JSONObject jSONObject) {
        this.r = jSONObject;
    }

    public void ka(JSONObject jSONObject) {
        this.cj = jSONObject;
    }

    public String dv() {
        return this.vx;
    }

    public void w(String str) {
        this.vx = str;
    }

    public void oy() {
        ms(this, this.gs);
    }

    public void oi() {
        ms(this, this.r);
    }

    public String vx() {
        return this.nq;
    }

    public void yu(String str) {
        this.nq = str;
    }

    public long nq() {
        return this.jr;
    }

    public void ms(long j) {
        this.jr = j;
    }

    public String jr() {
        return ("flip".equals(this.ir) || "slide".equals(this.ir)) ? this.ir : "slide";
    }

    public void op(String str) {
        this.ir = str;
    }

    public List<String> qd() {
        return this.jj;
    }

    public void xr(List<String> list) {
        this.jj = list;
    }

    public void y(boolean z) {
        this.so = z;
    }

    public boolean ir() {
        return this.so;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void ms(c cVar, JSONObject jSONObject) {
        if (cVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b = 0;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b = 1;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b = 2;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b = 3;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b = 4;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b = 5;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b = 6;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b = 7;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b = 8;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b = 9;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b = 10;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        b = 11;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        b = 12;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        b = ek.k;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b = ek.l;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b = ek.m;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b = ek.n;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b = 17;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b = 18;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        b = 19;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b = 20;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b = 21;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b = 22;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        b = 23;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b = 24;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b = 25;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b = 26;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b = 27;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b = 28;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b = 29;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b = 30;
                    }
                    break;
                case -191748762:
                    if (next.equals("isClickEventIntercept")) {
                        b = 31;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b = 32;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b = 33;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        b = 34;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b = 35;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        b = 36;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b = 37;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b = 38;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b = 39;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b = 40;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        b = 41;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        b = 42;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b = 43;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b = 44;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b = 45;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b = 46;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        b = 47;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b = 48;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b = 49;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b = 50;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b = 51;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b = 52;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        b = 53;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b = 54;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b = 55;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b = 56;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b = 57;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b = 58;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b = 59;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b = 60;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b = 61;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b = 62;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b = com.anythink.core.common.s.a.c.c;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b = com.anythink.core.common.s.a.c.b;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b = 65;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b = 66;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b = 67;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    cVar.ah(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    cVar.ub(jSONObject.optString(next));
                    break;
                case 2:
                    cVar.yu(jSONObject.optString(next));
                    break;
                case 3:
                    cVar.ab(jSONObject.optString(next));
                    break;
                case 4:
                    cVar.ny(jSONObject.optInt(next));
                    break;
                case 5:
                    cVar.qv(jSONObject.optBoolean(next));
                    break;
                case 6:
                    cVar.c(jSONObject.optBoolean(next));
                    break;
                case 7:
                    cVar.zb(jSONObject.optString(next));
                    break;
                case 8:
                    cVar.c((float) jSONObject.optDouble(next));
                    break;
                case 9:
                    cVar.xr(jSONObject.optString(next));
                    break;
                case 10:
                    cVar.re(jSONObject.optInt(next));
                    break;
                case 11:
                    cVar.ah(jSONObject.optString(next));
                    break;
                case 12:
                    cVar.ah((float) jSONObject.optDouble(next));
                    break;
                case 13:
                    cVar.d(jSONObject.optString(next));
                    break;
                case 14:
                    cVar.nw(jSONObject.optString(next));
                    break;
                case 15:
                    cVar.xr(jSONObject.optBoolean(next));
                    break;
                case 16:
                    cVar.ch(jSONObject.optInt(next));
                    break;
                case 17:
                    cVar.ch(jSONObject.optBoolean(next));
                    break;
                case 18:
                    cVar.ms(jSONObject.optLong(next));
                    break;
                case 19:
                    cVar.b(jSONObject.optString(next));
                    break;
                case 20:
                    cVar.h(jSONObject.optInt(next));
                    break;
                case 21:
                    cVar.w(jSONObject.optInt(next));
                    break;
                case 22:
                    cVar.ny(jSONObject.optBoolean(next));
                    break;
                case 23:
                    cVar.ub(jSONObject.optInt(next));
                    break;
                case 24:
                    cVar.i(jSONObject.optInt(next));
                    break;
                case 25:
                    cVar.xr(jSONObject.optDouble(next));
                    break;
                case 26:
                    cVar.c(jSONObject.optDouble(next));
                    break;
                case 27:
                    cVar.y(jSONObject.optInt(next));
                    break;
                case 28:
                    cVar.x(jSONObject.optBoolean(next));
                    break;
                case 29:
                    cVar.hi(jSONObject.optInt(next));
                    break;
                case 30:
                    cVar.c(jSONObject.optString(next));
                    break;
                case 31:
                    cVar.u(jSONObject.optBoolean(next));
                    break;
                case 32:
                    cVar.ab(jSONObject.optBoolean(next));
                    break;
                case 33:
                    cVar.hi(jSONObject.optString(next));
                    break;
                case 34:
                    cVar.b(jSONObject.optInt(next));
                    break;
                case 35:
                    cVar.t(jSONObject.optString(next));
                    break;
                case 36:
                    cVar.t(jSONObject.optInt(next));
                    break;
                case 37:
                    cVar.ms(jSONObject.optBoolean(next));
                    break;
                case 38:
                    cVar.x((float) jSONObject.optDouble(next));
                    break;
                case 39:
                    cVar.y(jSONObject.optString(next));
                    break;
                case 40:
                    cVar.ka(jSONObject.optString(next));
                    break;
                case 41:
                    cVar.nw(jSONObject.optInt(next));
                    break;
                case 42:
                    cVar.d((float) jSONObject.optDouble(next));
                    break;
                case 43:
                    cVar.ah(jSONObject.optDouble(next));
                    break;
                case 44:
                    cVar.ka((float) jSONObject.optDouble(next));
                    break;
                case 45:
                    cVar.hi(jSONObject.optBoolean(next));
                    break;
                case 46:
                    cVar.u(jSONObject.optBoolean(next));
                    break;
                case 47:
                    cVar.ny((float) jSONObject.optDouble(next));
                    break;
                case 48:
                    cVar.qv(jSONObject.optString(next));
                    break;
                case 49:
                    cVar.cv(jSONObject.optInt(next));
                    break;
                case 50:
                    cVar.ab((float) jSONObject.optDouble(next));
                    break;
                case 51:
                    cVar.x(jSONObject.optString(next));
                    break;
                case 52:
                    cVar.ny(jSONObject.optString(next));
                    break;
                case 53:
                    cVar.ao(jSONObject.optInt(next));
                    break;
                case 54:
                    cVar.ka(jSONObject.optBoolean(next));
                    break;
                case 55:
                    cVar.zb(jSONObject.optInt(next));
                    break;
                case 56:
                    cVar.h(jSONObject.optString(next));
                    break;
                case 57:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        cVar.ab(jSONObjectOptJSONObject.optInt("translateY", 0));
                        cVar.x(jSONObjectOptJSONObject.optInt("translateX", 0));
                        cVar.d(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        cVar.ka(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case 58:
                    cVar.d(jSONObject.optBoolean(next));
                    break;
                case 59:
                    cVar.sl(jSONObject.optString(next));
                    break;
                case 60:
                    cVar.u(jSONObject.optString(next));
                    break;
                case 61:
                    cVar.ms((float) jSONObject.optDouble(next));
                    break;
                case 62:
                    cVar.ao(jSONObject.optString(next));
                    break;
                case 63:
                    cVar.ch(jSONObject.optString(next));
                    break;
                case 64:
                    cVar.qv(jSONObject.optInt(next));
                    break;
                case 65:
                    cVar.xr((float) jSONObject.optDouble(next));
                    break;
                case 66:
                    cVar.sl(jSONObject.optInt(next));
                    break;
                case 67:
                    cVar.u(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
