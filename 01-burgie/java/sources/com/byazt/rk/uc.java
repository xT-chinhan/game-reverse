package com.byazt.rk;

import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.umeng.analytics.pro.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1536, 5})
public class uc {
    public String a;
    public String aa;
    public double ag;
    public float aj;
    public int b;
    public List<pr> bh;
    public boolean bm;
    public boolean c;
    public int cr;
    public String cz;
    public int d;
    public String e;
    public boolean eh;
    public int er;
    public int ey;
    public boolean f;
    public JSONObject fe;
    public String fo;
    public int fs;
    public float fw;
    public String g;
    public List<String> gg;
    public int gu;
    public double gz;
    public String h;
    public String hg;
    public float hn;
    public String ho;
    public boolean hs;
    public float hw;
    public boolean i;
    public String ie;
    public int ii;
    public int iu;
    public boolean iy;
    public int j;
    public boolean jn;
    public int jw;
    public double k;
    public boolean kl;
    public int ks;
    public int ku;
    public String l;
    public String lb;
    public boolean lj;
    public int ls;
    public JSONObject lv;
    public String m;
    public boolean mr;
    public int mw;
    public String n;
    public boolean na;
    public String nl;
    public boolean np;
    public String nt;
    public int nw;
    public String ny;
    public boolean o;
    public int od;
    public double of;
    public int oj;
    public String om;
    public int p;
    public int pj;
    public int pq;
    public float pr;
    public String qa;
    public int qi;
    public int qn;
    public int qo;
    public int qv;
    public JSONObject qx;
    public int r;
    public String rc;
    public int rk;
    public boolean s;
    public String sr;
    public String su;
    public int sv;
    public int sx;
    public boolean t;
    public int tv;
    public int u;
    public float uc;
    public String uk;
    public int v;
    public double ve;
    public boolean vj;
    public float vk;
    public int vv;
    public double w;
    public String wm;
    public long wo = -1;
    public String wt;
    public String ww;
    public boolean wz;
    public float x;
    public JSONObject xb;
    public int xg;
    public String xi;
    public String y;
    public String yb;
    public int yj;
    public boolean z;
    public float zo;

    public static uc pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        uc ucVar = new uc();
        ucVar.hw(jSONObject.optString("adType", "embeded"));
        ucVar.ho(jSONObject.optString("clickArea", ProviderInteractionViews.ROLE_CREATIVE));
        ucVar.nt(jSONObject.optString("clickTigger", "click"));
        ucVar.hn(jSONObject.optString("fontFamily", "PingFangSC"));
        ucVar.x(jSONObject.optString("textAlign", "left"));
        ucVar.c(jSONObject.optString("color", "#999999"));
        ucVar.uc(jSONObject.optString("bgColor", "transparent"));
        ucVar.fw(jSONObject.optString("bgImgUrl", ""));
        ucVar.ve(jSONObject.optString("bgImgData", ""));
        ucVar.zo(jSONObject.optString("borderColor", "#000000"));
        ucVar.aj(jSONObject.optString("borderStyle", "solid"));
        ucVar.vk(jSONObject.optString("heightMode", "auto"));
        ucVar.w(jSONObject.optString("widthMode", "fixed"));
        ucVar.k(jSONObject.optString("interactText", ""));
        ucVar.hn(jSONObject.optBoolean("isShowBgControl", false));
        ucVar.m(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            ucVar.fw(jSONObjectOptJSONObject.optInt("translateY", 0));
            ucVar.zo(jSONObjectOptJSONObject.optInt("translateX", 0));
            ucVar.x(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            ucVar.c(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        ucVar.g(jSONObject.optString("interactType", ""));
        ucVar.c(jSONObject.optInt("interactSlideDirection", -1));
        ucVar.yb(jSONObject.optString("justifyHorizontal", "space-around"));
        ucVar.lb(jSONObject.optString("justifyVertical", "flex-start"));
        ucVar.hw(jSONObject.optDouble("timingStart"));
        ucVar.hn(jSONObject.optDouble("timingEnd"));
        ucVar.x((float) jSONObject.optDouble("width", 0.0d));
        ucVar.hn((float) jSONObject.optDouble("height", 0.0d));
        ucVar.pr((float) jSONObject.optDouble("borderRadius", 0.0d));
        ucVar.hw((float) jSONObject.optDouble("borderSize", 0.0d));
        ucVar.hw(jSONObject.optBoolean("interactValidate", false));
        ucVar.aj((float) jSONObject.optDouble("fontSize", 0.0d));
        ucVar.c((float) jSONObject.optDouble("paddingBottom", 0.0d));
        ucVar.uc((float) jSONObject.optDouble("paddingLeft", 0.0d));
        ucVar.fw((float) jSONObject.optDouble("paddingRight", 0.0d));
        ucVar.zo((float) jSONObject.optDouble("paddingTop", 0.0d));
        ucVar.x(jSONObject.optBoolean("lineFeed", false));
        ucVar.aj(jSONObject.optInt("lineCount", 0));
        ucVar.uc(jSONObject.optDouble("lineHeight", 1.2d));
        ucVar.g(jSONObject.optInt("letterSpacing", 0));
        ucVar.c(jSONObject.optBoolean("isDataFixed", false));
        ucVar.ho(jSONObject.optInt("fontWeight"));
        ucVar.uc(jSONObject.optBoolean("lineLimit"));
        ucVar.nt(jSONObject.optInt("position"));
        ucVar.qa(jSONObject.optString("align"));
        ucVar.fw(jSONObject.optBoolean("useLeft"));
        ucVar.zo(jSONObject.optBoolean("useRight"));
        ucVar.aj(jSONObject.optBoolean("useTop"));
        ucVar.vk(jSONObject.optBoolean("useBottom"));
        ucVar.a(jSONObject.optString("data"));
        ucVar.hw(jSONObject.optJSONObject("i18n"));
        ucVar.k(jSONObject.optInt("marginLeft"));
        ucVar.m(jSONObject.optInt("marginRight"));
        ucVar.vk(jSONObject.optInt("marginTop"));
        ucVar.w(jSONObject.optInt("marginBottom"));
        ucVar.yb(jSONObject.optInt("tagMaxCount"));
        ucVar.w(jSONObject.optBoolean("allowTextFlow"));
        ucVar.lb(jSONObject.optInt("textFlowType"));
        ucVar.qa(jSONObject.optInt("textFlowDuration"));
        ucVar.a(jSONObject.optInt("left"));
        ucVar.cz(jSONObject.optInt("right"));
        ucVar.ny(jSONObject.optInt("top"));
        ucVar.fo(jSONObject.optInt("bottom"));
        ucVar.cz(jSONObject.optString("alignItems", "flex-start"));
        ucVar.ny(jSONObject.optString("direction", ""));
        ucVar.pr(jSONObject.optBoolean("loop", false));
        ucVar.rc(jSONObject.optInt("zIndex"));
        ucVar.gz(jSONObject.optInt("interactVisibleTime"));
        ucVar.z(jSONObject.optInt("interactHiddenTime"));
        ucVar.m(jSONObject.optBoolean("interactEnableMask"));
        ucVar.g(jSONObject.optBoolean("interactWontHide"));
        ucVar.pr(jSONObject.optString("bgGradient"));
        ucVar.y(jSONObject.optInt("areaType"));
        ucVar.ww(jSONObject.optInt("interactSlideThreshold", 0));
        ucVar.s(jSONObject.optInt("interactBottomDistance", com.byazt.dj.x.pr() ? 0 : 120));
        ucVar.lb(jSONObject.optBoolean("openPlayableLandingPage", false));
        ucVar.hn(jSONObject.optJSONObject("video"));
        ucVar.x(jSONObject.optJSONObject(ImageViewManager.NAME));
        ucVar.n(jSONObject.optInt("borderShadowExtent"));
        ucVar.ho(jSONObject.optBoolean("bgGauseBlur"));
        ucVar.e(jSONObject.optInt("bgGauseBlurRadius"));
        ucVar.nt(jSONObject.optBoolean("showTimeProgress", false));
        ucVar.yb(jSONObject.optBoolean("showPlayButton", false));
        ucVar.pr(jSONObject.optDouble("bgColorCg", 0.0d));
        ucVar.uc(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        ucVar.hw(jSONObject.optInt("borderTopLeftRadius", 0));
        ucVar.pr(jSONObject.optInt("borderTopRightRadius", 0));
        ucVar.x(jSONObject.optInt("borderBottomLeftRadius", 0));
        ucVar.hn(jSONObject.optInt("borderBottomRightRadius", 0));
        ucVar.c(jSONObject.optJSONObject("interactI18n"));
        ucVar.rc(jSONObject.optString("imageObjectFit"));
        ucVar.z(jSONObject.optString("interactTitle"));
        ucVar.nl(jSONObject.optInt("interactTextPositionTop"));
        ucVar.fo(jSONObject.optString("imageLottieTosPath"));
        ucVar.k(jSONObject.optBoolean("animationsLoop"));
        ucVar.b(jSONObject.optInt("lottieAppNameMaxLength"));
        ucVar.ve(jSONObject.optInt("lottieAdDescMaxLength"));
        ucVar.iu(jSONObject.optInt("lottieAdTitleMaxLength"));
        ucVar.iu(jSONObject.optString("imageFlipSlideType"));
        ucVar.qa(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filterColor");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
                ucVar.hw(arrayList);
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    pr prVar = new pr();
                    prVar.hn(jSONObject2.optString("animationType"));
                    prVar.pr(jSONObject2.optDouble("animationDuration"));
                    prVar.hw(jSONObject2.optDouble("animationScaleX"));
                    prVar.hn(jSONObject2.optDouble("animationScaleY"));
                    prVar.x(jSONObject2.optString("animationTimeFunction"));
                    prVar.x(jSONObject2.optDouble("animationDelay"));
                    prVar.uc(jSONObject2.optInt("animationIterationCount"));
                    prVar.c(jSONObject2.optString("animationDirection"));
                    prVar.c(jSONObject2.optDouble("animationInterval"));
                    prVar.pr(jSONObject2.optInt("animationBorderWidth"));
                    prVar.pr(jSONObject2.optLong("key"));
                    prVar.hw(jSONObject2.optInt("animationEffectWidth"));
                    prVar.hn(jSONObject2.optInt("animationSwing", 1));
                    prVar.x(jSONObject2.optInt("animationTranslateX"));
                    prVar.c(jSONObject2.optInt("animationTranslateY"));
                    prVar.hw(jSONObject2.optString("animationRippleBackgroundColor"));
                    prVar.pr(jSONObject2.optString("animationScaleDirection"));
                    prVar.fw(jSONObject2.optInt("animationFadeStart"));
                    prVar.zo(jSONObject2.optInt("animationFadeEnd"));
                    prVar.uc(jSONObject2.optString("animationFillMode"));
                    prVar.aj(jSONObject2.optInt("animationBounceHeight"));
                    if (ucVar.qa() > 0.0d) {
                        prVar.x(prVar.g() + ucVar.qa());
                    }
                    arrayList2.add(prVar);
                }
                ucVar.pr(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                ucVar.b(jSONObject.optString("triggerSlideDirection", "0"));
                ucVar.pr(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception e) {
        }
        return ucVar;
    }

    public boolean pr() {
        return this.iy;
    }

    public void pr(boolean z) {
        this.iy = z;
    }

    public int hw() {
        return this.ku;
    }

    public void pr(int i) {
        this.ku = i;
    }

    public int hn() {
        return this.xg;
    }

    public void hw(int i) {
        this.xg = i;
    }

    public int x() {
        return this.fs;
    }

    public void hn(int i) {
        this.fs = i;
    }

    public int c() {
        return this.sx;
    }

    public void x(int i) {
        this.sx = i;
    }

    public JSONObject uc() {
        return this.xb;
    }

    public int fw() {
        return this.ks;
    }

    public void c(int i) {
        this.ks = i;
    }

    public double zo() {
        return this.ag;
    }

    public void pr(double d) {
        this.ag = d;
    }

    public int aj() {
        return this.p;
    }

    public void uc(int i) {
        this.p = i;
    }

    public String vk() {
        return this.xi;
    }

    public void pr(String str) {
        this.xi = str;
    }

    public float w() {
        return this.pr;
    }

    public void pr(float f) {
        this.pr = f;
    }

    public float k() {
        return this.hw;
    }

    public void hw(float f) {
        this.hw = f;
    }

    public void hn(float f) {
        this.hn = f;
    }

    public void x(float f) {
        this.x = f;
    }

    public boolean m() {
        return this.c;
    }

    public void hw(boolean z) {
        this.c = z;
    }

    public float g() {
        return this.uc;
    }

    public void c(float f) {
        this.uc = f;
    }

    public float ho() {
        return this.fw;
    }

    public void uc(float f) {
        this.fw = f;
    }

    public float nt() {
        return this.zo;
    }

    public void fw(float f) {
        this.zo = f;
    }

    public float yb() {
        return this.aj;
    }

    public void zo(float f) {
        this.aj = f;
    }

    public float lb() {
        return this.vk;
    }

    public void aj(float f) {
        this.vk = f;
    }

    public double qa() {
        return this.w;
    }

    public void hw(double d) {
        this.w = d;
    }

    public double a() {
        return this.k;
    }

    public void hn(double d) {
        this.k = d;
    }

    public void hw(String str) {
        this.m = str;
    }

    public void hn(String str) {
        this.g = str;
    }

    public String cz() {
        return this.ho;
    }

    public void x(String str) {
        this.ho = str;
    }

    public String ny() {
        return this.nt;
    }

    public void c(String str) {
        this.nt = str;
    }

    public String fo() {
        return this.yb;
    }

    public void uc(String str) {
        this.yb = str;
    }

    public void fw(String str) {
        this.lb = str;
    }

    public String rc() {
        return this.lb;
    }

    private void ve(String str) {
        this.hg = str;
    }

    public String z() {
        return this.hg;
    }

    public String b() {
        return this.qa;
    }

    public void zo(String str) {
        this.qa = str;
    }

    public void aj(String str) {
        this.a = str;
    }

    public String iu() {
        return this.cz;
    }

    public void vk(String str) {
        this.cz = str;
    }

    public String ve() {
        return this.ny;
    }

    public void w(String str) {
        this.ny = str;
    }

    public String gz() {
        return this.fo;
    }

    public void k(String str) {
        this.fo = str;
    }

    public String nl() {
        return this.rc;
    }

    public void m(String str) {
        this.rc = str;
    }

    public boolean y() {
        return this.z;
    }

    public void hn(boolean z) {
        this.z = z;
    }

    public int ww() {
        return this.b;
    }

    public void fw(int i) {
        this.b = i;
    }

    public int n() {
        return this.iu;
    }

    public void zo(int i) {
        this.iu = i;
    }

    public double e() {
        return this.ve;
    }

    public void x(double d) {
        this.ve = d;
    }

    public double s() {
        return this.gz;
    }

    public void c(double d) {
        this.gz = d;
    }

    public String ls() {
        return this.nl;
    }

    public void g(String str) {
        this.nl = str;
    }

    public String er() {
        return this.y;
    }

    public void ho(String str) {
        this.y = str;
    }

    public String v() {
        return this.ww;
    }

    public void nt(String str) {
        this.ww = str;
    }

    public String qi() {
        return this.n;
    }

    public void yb(String str) {
        this.n = str;
    }

    public String qn() {
        return this.e;
    }

    public void lb(String str) {
        this.e = str;
    }

    public boolean of() {
        return this.s;
    }

    public void x(boolean z) {
        this.s = z;
    }

    public void aj(int i) {
        this.ls = i;
    }

    public int ii() {
        return this.ls;
    }

    public int i() {
        return this.er;
    }

    public void vk(int i) {
        this.er = i;
    }

    public int r() {
        return this.v;
    }

    public void w(int i) {
        this.v = i;
    }

    public int hs() {
        return this.qi;
    }

    public void k(int i) {
        this.qi = i;
    }

    public int nw() {
        return this.qn;
    }

    public void m(int i) {
        this.qn = i;
    }

    public double ie() {
        return this.of;
    }

    public void uc(double d) {
        this.of = d;
    }

    public int o() {
        return this.ii;
    }

    public void g(int i) {
        this.ii = i;
    }

    public boolean f() {
        return this.i;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public int bm() {
        return this.r;
    }

    public void ho(int i) {
        this.r = i;
    }

    public boolean jn() {
        return this.hs;
    }

    public void uc(boolean z) {
        this.hs = z;
    }

    public int l() {
        return this.nw;
    }

    public void nt(int i) {
        this.nw = i;
    }

    public String lv() {
        return this.ie;
    }

    public void qa(String str) {
        this.ie = str;
    }

    public boolean od() {
        return this.o;
    }

    public void fw(boolean z) {
        this.o = z;
    }

    public boolean vj() {
        return this.f;
    }

    public void zo(boolean z) {
        this.f = z;
    }

    public boolean mw() {
        return this.bm;
    }

    public void aj(boolean z) {
        this.bm = z;
    }

    public boolean sv() {
        return this.jn;
    }

    public void vk(boolean z) {
        this.jn = z;
    }

    public String gu() {
        return this.l;
    }

    public void a(String str) {
        this.l = str;
    }

    public void hw(JSONObject jSONObject) {
        this.lv = jSONObject;
    }

    public JSONObject d() {
        return this.lv;
    }

    public int pq() {
        return this.od;
    }

    public void yb(int i) {
        this.od = i;
    }

    public boolean jw() {
        return this.vj;
    }

    public void w(boolean z) {
        this.vj = z;
    }

    public int wt() {
        return this.mw;
    }

    public void lb(int i) {
        this.mw = i;
    }

    public int aa() {
        return this.sv;
    }

    public void qa(int i) {
        this.sv = i;
    }

    public int iy() {
        return this.gu;
    }

    public void a(int i) {
        this.gu = i;
    }

    public int cr() {
        return this.d;
    }

    public void cz(int i) {
        this.d = i;
    }

    public int j() {
        return this.pq;
    }

    public void ny(int i) {
        this.pq = i;
    }

    public int qo() {
        return this.jw;
    }

    public void fo(int i) {
        this.jw = i;
    }

    public String bh() {
        return this.wt;
    }

    public void cz(String str) {
        this.wt = str;
    }

    public String pj() {
        return this.aa;
    }

    public void ny(String str) {
        this.aa = str;
    }

    public int ey() {
        return this.cr;
    }

    public void rc(int i) {
        this.cr = i;
    }

    public int qv() {
        return this.j;
    }

    public void z(int i) {
        this.j = i;
    }

    public String u() {
        return this.h;
    }

    public void fo(String str) {
        this.h = str;
    }

    public boolean np() {
        return this.t;
    }

    public void k(boolean z) {
        this.t = z;
    }

    public int eh() {
        return this.yj;
    }

    public void b(int i) {
        this.yj = i;
    }

    public int na() {
        return this.vv;
    }

    public void iu(int i) {
        this.vv = i;
    }

    public int rk() {
        return this.tv;
    }

    public void ve(int i) {
        this.tv = i;
    }

    public boolean mr() {
        return this.lj;
    }

    public void m(boolean z) {
        this.lj = z;
    }

    public int ag() {
        return this.qo;
    }

    public void gz(int i) {
        this.qo = i;
    }

    public void g(boolean z) {
        this.wz = z;
    }

    public boolean qx() {
        return this.wz;
    }

    public void rc(String str) {
        this.uk = str;
    }

    public String fe() {
        return this.uk;
    }

    public void nl(int i) {
        this.oj = i;
    }

    public int ks() {
        return this.oj;
    }

    public List<pr> sr() {
        return this.bh;
    }

    public int wz() {
        List<pr> list = this.bh;
        if (list != null) {
            for (pr prVar : list) {
                if ("translate".equals(prVar.aj()) && prVar.fw() < 0) {
                    return -prVar.fw();
                }
            }
            return 0;
        }
        return 0;
    }

    public void pr(List<pr> list) {
        this.bh = list;
    }

    public int xb() {
        return this.pj;
    }

    public void y(int i) {
        this.pj = i;
    }

    public int p() {
        return this.ey;
    }

    public void ww(int i) {
        this.ey = i;
    }

    public int ku() {
        return this.qv;
    }

    public void n(int i) {
        this.qv = i;
    }

    public boolean xg() {
        return this.np;
    }

    public void ho(boolean z) {
        this.np = z;
    }

    public int fs() {
        return this.u;
    }

    public void e(int i) {
        this.u = i;
    }

    public boolean sx() {
        return this.eh;
    }

    public void nt(boolean z) {
        this.eh = z;
    }

    public boolean uk() {
        return this.na;
    }

    public void yb(boolean z) {
        this.na = z;
    }

    public int oj() {
        return this.rk;
    }

    public void s(int i) {
        this.rk = i;
    }

    public String lj() {
        return this.sr;
    }

    public boolean h() {
        return this.mr;
    }

    public void lb(boolean z) {
        this.mr = z;
    }

    public void hn(JSONObject jSONObject) {
        this.qx = jSONObject;
    }

    public JSONObject t() {
        return this.fe;
    }

    public void x(JSONObject jSONObject) {
        this.fe = jSONObject;
    }

    public void c(JSONObject jSONObject) {
        this.xb = jSONObject;
    }

    public String yj() {
        return this.om;
    }

    public void z(String str) {
        this.om = str;
    }

    public void vv() {
        pr(this, this.qx);
    }

    public void tv() {
        pr(this, this.fe);
    }

    public String om() {
        return this.wm;
    }

    public void b(String str) {
        this.wm = str;
    }

    public long wm() {
        return this.wo;
    }

    public void pr(long j) {
        this.wo = j;
    }

    public String wo() {
        return ("flip".equals(this.su) || "slide".equals(this.su)) ? this.su : "slide";
    }

    public void iu(String str) {
        this.su = str;
    }

    public List<String> hg() {
        return this.gg;
    }

    public void hw(List<String> list) {
        this.gg = list;
    }

    public void qa(boolean z) {
        this.kl = z;
    }

    public boolean su() {
        return this.kl;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void pr(uc ucVar, JSONObject jSONObject) {
        if (ucVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            byte b = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b = cc.l;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b = 2;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b = 64;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b = 8;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b = 33;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b = 0;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b = 38;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b = cc.m;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b = 29;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b = 1;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b = 57;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        b = 4;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        b = 23;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        b = 5;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b = 58;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b = 26;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b = 48;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b = 44;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b = 65;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        b = 59;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b = 50;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b = 63;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b = 43;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        b = 37;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b = 61;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b = 20;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b = 34;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b = 53;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b = 42;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b = 49;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b = 7;
                    }
                    break;
                case -191748762:
                    if (next.equals("isClickEventIntercept")) {
                        b = 67;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b = 41;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b = 12;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        b = 56;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b = 45;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        b = 54;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b = 60;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b = 31;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b = 40;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b = 6;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        b = 55;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        b = 22;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b = 21;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b = 28;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b = 51;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b = 66;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        b = 27;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b = 19;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b = 62;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b = 30;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b = 9;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b = 10;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        b = 39;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b = 36;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b = 47;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b = 18;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b = cc.n;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b = 32;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b = cc.k;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b = 17;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b = 24;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b = 3;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b = 11;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b = 52;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b = 25;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b = 46;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b = 35;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    ucVar.lb(jSONObject.optBoolean(next));
                    break;
                case 1:
                    ucVar.hw(jSONObject.optString(next));
                    break;
                case 2:
                    ucVar.ho(jSONObject.optString(next));
                    break;
                case 3:
                    ucVar.nt(jSONObject.optString(next));
                    break;
                case 4:
                    ucVar.hn(jSONObject.optString(next));
                    break;
                case 5:
                    ucVar.x(jSONObject.optString(next));
                    break;
                case 6:
                    ucVar.c(jSONObject.optString(next));
                    break;
                case 7:
                    ucVar.uc(jSONObject.optString(next));
                    break;
                case 8:
                    ucVar.fw(jSONObject.optString(next));
                    break;
                case 9:
                    ucVar.zo(jSONObject.optString(next));
                    break;
                case 10:
                    ucVar.aj(jSONObject.optString(next));
                    break;
                case 11:
                    ucVar.vk(jSONObject.optString(next));
                    break;
                case 12:
                    ucVar.w(jSONObject.optString(next));
                    break;
                case 13:
                    ucVar.k(jSONObject.optString(next));
                    break;
                case 14:
                    ucVar.hn(jSONObject.optBoolean(next, false));
                    break;
                case 15:
                    ucVar.m(jSONObject.optString(next));
                    break;
                case 16:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        ucVar.fw(jSONObjectOptJSONObject.optInt("translateY", 0));
                        ucVar.zo(jSONObjectOptJSONObject.optInt("translateX", 0));
                        ucVar.x(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        ucVar.c(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case 17:
                    ucVar.g(jSONObject.optString(next));
                    break;
                case 18:
                    ucVar.yb(jSONObject.optString(next));
                    break;
                case 19:
                    ucVar.lb(jSONObject.optString(next));
                    break;
                case 20:
                    ucVar.hw(jSONObject.optDouble(next));
                    break;
                case 21:
                    ucVar.hn(jSONObject.optDouble(next));
                    break;
                case 22:
                    ucVar.x((float) jSONObject.optDouble(next));
                    break;
                case 23:
                    ucVar.hn((float) jSONObject.optDouble(next));
                    break;
                case 24:
                    ucVar.pr((float) jSONObject.optDouble(next));
                    break;
                case 25:
                    ucVar.hw((float) jSONObject.optDouble(next));
                    break;
                case 26:
                    ucVar.hw(jSONObject.optBoolean(next));
                    break;
                case 27:
                    ucVar.aj((float) jSONObject.optDouble(next));
                    break;
                case 28:
                    ucVar.c((float) jSONObject.optDouble(next));
                    break;
                case 29:
                    ucVar.uc((float) jSONObject.optDouble(next));
                    break;
                case 30:
                    ucVar.fw((float) jSONObject.optDouble(next));
                    break;
                case 31:
                    ucVar.zo((float) jSONObject.optDouble(next));
                    break;
                case 32:
                    ucVar.x(jSONObject.optBoolean(next));
                    break;
                case 33:
                    ucVar.aj(jSONObject.optInt(next));
                    break;
                case 34:
                    ucVar.uc(jSONObject.optDouble(next));
                    break;
                case 35:
                    ucVar.g(jSONObject.optInt(next));
                    break;
                case 36:
                    ucVar.c(jSONObject.optBoolean(next));
                    break;
                case 37:
                    ucVar.ho(jSONObject.optInt(next));
                    break;
                case 38:
                    ucVar.uc(jSONObject.optBoolean(next));
                    break;
                case 39:
                    ucVar.nt(jSONObject.optInt(next));
                    break;
                case 40:
                    ucVar.qa(jSONObject.optString(next));
                    break;
                case 41:
                    ucVar.fw(jSONObject.optBoolean(next));
                    break;
                case 42:
                    ucVar.zo(jSONObject.optBoolean(next));
                    break;
                case 43:
                    ucVar.aj(jSONObject.optBoolean(next));
                    break;
                case 44:
                    ucVar.vk(jSONObject.optBoolean(next));
                    break;
                case 45:
                    ucVar.a(jSONObject.optString(next));
                    break;
                case 46:
                    ucVar.k(jSONObject.optInt(next));
                    break;
                case 47:
                    ucVar.m(jSONObject.optInt(next));
                    break;
                case 48:
                    ucVar.vk(jSONObject.optInt(next));
                    break;
                case 49:
                    ucVar.w(jSONObject.optInt(next));
                    break;
                case 50:
                    ucVar.yb(jSONObject.optInt(next));
                    break;
                case 51:
                    ucVar.w(jSONObject.optBoolean(next));
                    break;
                case 52:
                    ucVar.lb(jSONObject.optInt(next));
                    break;
                case 53:
                    ucVar.qa(jSONObject.optInt(next));
                    break;
                case 54:
                    ucVar.a(jSONObject.optInt(next));
                    break;
                case 55:
                    ucVar.cz(jSONObject.optInt(next));
                    break;
                case 56:
                    ucVar.ny(jSONObject.optInt(next));
                    break;
                case 57:
                    ucVar.fo(jSONObject.optInt(next));
                    break;
                case 58:
                    ucVar.cz(jSONObject.optString(next));
                    break;
                case 59:
                    ucVar.ny(jSONObject.optString(next));
                    break;
                case 60:
                    ucVar.pr(jSONObject.optBoolean(next));
                    break;
                case 61:
                    ucVar.rc(jSONObject.optInt(next));
                    break;
                case 62:
                    ucVar.gz(jSONObject.optInt(next));
                    break;
                case 63:
                    ucVar.z(jSONObject.optInt(next));
                    break;
                case 64:
                    ucVar.b(jSONObject.optString(next));
                    break;
                case 65:
                    ucVar.pr(jSONObject.optLong(next));
                    break;
                case 66:
                    ucVar.g(jSONObject.optBoolean(next));
                    break;
                case 67:
                    ucVar.g(jSONObject.optBoolean(next));
                    break;
            }
        }
    }
}
