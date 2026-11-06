package com.byazt.lh;

import com.anythink.core.common.f.e;
import com.anythink.core.common.l.f;
import com.anythink.core.common.r.a.c;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1475, 13})
public class w {
    public String a;
    public boolean ae;
    public String an;
    public boolean b;
    public double bb;
    public int bz;
    public boolean c;
    public String ca;
    public String cd;
    public int ci;
    public double cp;
    public String ct;
    public int cx;
    public String cy;
    public double d;
    public int df;
    public int dg;
    public String dh;
    public String di;
    public int dm;
    public int dn;
    public int dw;
    public List<String> dz;
    public String e;
    public JSONObject ei;
    public String el;
    public int eq;
    public int f;
    public int fi;
    public int fl;
    public float fs;
    public int g;
    public int h;
    public int ha;
    public String hd;
    public String he;
    public int hf;
    public boolean hu;
    public int i;
    public int ic;
    public int il;
    public String iz;
    public String j;
    public int jh;
    public int ju;
    public String k;
    public int kc;
    public boolean l;
    public int la;
    public int lg;
    public String lh;
    public String ln;
    public boolean lq;
    public String m;
    public double mz;
    public float n;
    public boolean nf;
    public JSONObject nk;
    public int np;
    public boolean o;
    public String oa;
    public String of;
    public int oj;
    public String ou;
    public boolean ox;
    public boolean pe;
    public int pk;
    public String py;
    public float q;
    public float qg;
    public String qh;
    public int qn;
    public boolean r;
    public int rf;
    public boolean ri;
    public float rv;
    public int ry;
    public float s;
    public int sh;
    public JSONObject sq;
    public List<n> su;
    public String sz;
    public int t;
    public boolean ta;
    public boolean ti;
    public float tj;
    public long tr = -1;
    public double u;
    public String um;
    public double ur;
    public String v;
    public boolean vb;
    public String vo;
    public float w;
    public String wm;
    public boolean wo;
    public boolean wv;
    public float x;
    public int xb;
    public String xd;
    public boolean xi;
    public boolean y;
    public JSONObject yw;
    public int z;
    public int ze;

    public static w n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        w wVar = new w();
        wVar.qg(jSONObject.optString("adType", "embeded"));
        wVar.k(jSONObject.optString("clickArea", "creative"));
        wVar.cy(jSONObject.optString("clickTigger", "click"));
        wVar.s(jSONObject.optString("fontFamily", "PingFangSC"));
        wVar.q(jSONObject.optString("textAlign", "left"));
        wVar.l(jSONObject.optString("color", "#999999"));
        wVar.w(jSONObject.optString("bgColor", "transparent"));
        wVar.x(jSONObject.optString("bgImgUrl", ""));
        wVar.ur(jSONObject.optString("bgImgData", ""));
        wVar.fs(jSONObject.optString("borderColor", "#000000"));
        wVar.rv(jSONObject.optString("borderStyle", "solid"));
        wVar.tj(jSONObject.optString("heightMode", "auto"));
        wVar.cp(jSONObject.optString("widthMode", "fixed"));
        wVar.d(jSONObject.optString("interactText", ""));
        wVar.s(jSONObject.optBoolean("isShowBgControl", false));
        wVar.oa(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            wVar.x(jSONObjectOptJSONObject.optInt("translateY", 0));
            wVar.fs(jSONObjectOptJSONObject.optInt("translateX", 0));
            wVar.q(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            wVar.l(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        wVar.sz(jSONObject.optString("interactType", ""));
        wVar.l(jSONObject.optInt("interactSlideDirection", -1));
        wVar.hd(jSONObject.optString("justifyHorizontal", "space-around"));
        wVar.cd(jSONObject.optString("justifyVertical", "flex-start"));
        wVar.qg(jSONObject.optDouble("timingStart"));
        wVar.s(jSONObject.optDouble("timingEnd"));
        wVar.q((float) jSONObject.optDouble("width", 0.0d));
        wVar.s((float) jSONObject.optDouble("height", 0.0d));
        wVar.n((float) jSONObject.optDouble("borderRadius", 0.0d));
        wVar.qg((float) jSONObject.optDouble("borderSize", 0.0d));
        wVar.qg(jSONObject.optBoolean("interactValidate", false));
        wVar.rv((float) jSONObject.optDouble("fontSize", 0.0d));
        wVar.l((float) jSONObject.optDouble("paddingBottom", 0.0d));
        wVar.w((float) jSONObject.optDouble("paddingLeft", 0.0d));
        wVar.x((float) jSONObject.optDouble("paddingRight", 0.0d));
        wVar.fs((float) jSONObject.optDouble("paddingTop", 0.0d));
        wVar.q(jSONObject.optBoolean("lineFeed", false));
        wVar.rv(jSONObject.optInt("lineCount", 0));
        wVar.w(jSONObject.optDouble("lineHeight", 1.2d));
        wVar.sz(jSONObject.optInt("letterSpacing", 0));
        wVar.l(jSONObject.optBoolean("isDataFixed", false));
        wVar.k(jSONObject.optInt("fontWeight"));
        wVar.w(jSONObject.optBoolean("lineLimit"));
        wVar.cy(jSONObject.optInt("position"));
        wVar.um(jSONObject.optString("align"));
        wVar.x(jSONObject.optBoolean("useLeft"));
        wVar.fs(jSONObject.optBoolean("useRight"));
        wVar.rv(jSONObject.optBoolean("useTop"));
        wVar.tj(jSONObject.optBoolean("useBottom"));
        wVar.a(jSONObject.optString(f.R));
        wVar.qg(jSONObject.optJSONObject("i18n"));
        wVar.d(jSONObject.optInt("marginLeft"));
        wVar.oa(jSONObject.optInt("marginRight"));
        wVar.tj(jSONObject.optInt("marginTop"));
        wVar.cp(jSONObject.optInt("marginBottom"));
        wVar.hd(jSONObject.optInt("tagMaxCount"));
        wVar.cp(jSONObject.optBoolean("allowTextFlow"));
        wVar.cd(jSONObject.optInt("textFlowType"));
        wVar.um(jSONObject.optInt("textFlowDuration"));
        wVar.a(jSONObject.optInt("left"));
        wVar.py(jSONObject.optInt("right"));
        wVar.ou(jSONObject.optInt("top"));
        wVar.wm(jSONObject.optInt("bottom"));
        wVar.py(jSONObject.optString("alignItems", "flex-start"));
        wVar.ou(jSONObject.optString("direction", ""));
        wVar.n(jSONObject.optBoolean("loop", false));
        wVar.m(jSONObject.optInt("zIndex"));
        wVar.bb(jSONObject.optInt("interactVisibleTime"));
        wVar.hu(jSONObject.optInt("interactHiddenTime"));
        wVar.oa(jSONObject.optBoolean("interactEnableMask"));
        wVar.sz(jSONObject.optBoolean("interactWontHide"));
        wVar.n(jSONObject.optString("bgGradient"));
        wVar.lh(jSONObject.optInt("areaType"));
        wVar.v(jSONObject.optInt("interactSlideThreshold", 0));
        wVar.ae(jSONObject.optInt("interactBottomDistance", com.byazt.twc.q.n() ? 0 : 120));
        wVar.cd(jSONObject.optBoolean("openPlayableLandingPage", false));
        wVar.s(jSONObject.optJSONObject(MediaFormat.KEY_VIDEO));
        wVar.q(jSONObject.optJSONObject("image"));
        wVar.j(jSONObject.optInt("borderShadowExtent"));
        wVar.k(jSONObject.optBoolean("bgGauseBlur"));
        wVar.an(jSONObject.optInt("bgGauseBlurRadius"));
        wVar.cy(jSONObject.optBoolean("showTimeProgress", false));
        wVar.hd(jSONObject.optBoolean("showPlayButton", false));
        wVar.n(jSONObject.optDouble("bgColorCg", 0.0d));
        wVar.w(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        wVar.qg(jSONObject.optInt("borderTopLeftRadius", 0));
        wVar.n(jSONObject.optInt("borderTopRightRadius", 0));
        wVar.q(jSONObject.optInt("borderBottomLeftRadius", 0));
        wVar.s(jSONObject.optInt("borderBottomRightRadius", 0));
        wVar.l(jSONObject.optJSONObject("interactI18n"));
        wVar.m(jSONObject.optString("imageObjectFit"));
        wVar.hu(jSONObject.optString("interactTitle"));
        wVar.ln(jSONObject.optInt("interactTextPositionTop"));
        wVar.wm(jSONObject.optString("imageLottieTosPath"));
        wVar.d(jSONObject.optBoolean("animationsLoop"));
        wVar.h(jSONObject.optInt("lottieAppNameMaxLength"));
        wVar.ur(jSONObject.optInt("lottieAdDescMaxLength"));
        wVar.t(jSONObject.optInt("lottieAdTitleMaxLength"));
        wVar.t(jSONObject.optString("imageFlipSlideType"));
        wVar.um(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filterColor");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
                wVar.qg(arrayList);
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    n nVar = new n();
                    nVar.s(jSONObject2.optString("animationType"));
                    nVar.n(jSONObject2.optDouble("animationDuration"));
                    nVar.qg(jSONObject2.optDouble("animationScaleX"));
                    nVar.s(jSONObject2.optDouble("animationScaleY"));
                    nVar.q(jSONObject2.optString("animationTimeFunction"));
                    nVar.q(jSONObject2.optDouble("animationDelay"));
                    nVar.w(jSONObject2.optInt("animationIterationCount"));
                    nVar.l(jSONObject2.optString("animationDirection"));
                    nVar.l(jSONObject2.optDouble("animationInterval"));
                    nVar.n(jSONObject2.optInt("animationBorderWidth"));
                    nVar.n(jSONObject2.optLong(e.a.b));
                    nVar.qg(jSONObject2.optInt("animationEffectWidth"));
                    nVar.s(jSONObject2.optInt("animationSwing", 1));
                    nVar.q(jSONObject2.optInt("animationTranslateX"));
                    nVar.l(jSONObject2.optInt("animationTranslateY"));
                    nVar.qg(jSONObject2.optString("animationRippleBackgroundColor"));
                    nVar.n(jSONObject2.optString("animationScaleDirection"));
                    nVar.x(jSONObject2.optInt("animationFadeStart"));
                    nVar.fs(jSONObject2.optInt("animationFadeEnd"));
                    nVar.w(jSONObject2.optString("animationFillMode"));
                    nVar.rv(jSONObject2.optInt("animationBounceHeight"));
                    if (wVar.um() > 0.0d) {
                        nVar.q(nVar.sz() + wVar.um());
                    }
                    arrayList2.add(nVar);
                }
                wVar.n(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                wVar.h(jSONObject.optString("triggerSlideDirection", "0"));
                wVar.n(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return wVar;
    }

    public boolean n() {
        return this.vb;
    }

    public void n(boolean z) {
        this.vb = z;
    }

    public int qg() {
        return this.qn;
    }

    public void n(int i) {
        this.qn = i;
    }

    public int s() {
        return this.bz;
    }

    public void qg(int i) {
        this.bz = i;
    }

    public int q() {
        return this.il;
    }

    public void s(int i) {
        this.il = i;
    }

    public int l() {
        return this.la;
    }

    public void q(int i) {
        this.la = i;
    }

    public JSONObject w() {
        return this.nk;
    }

    public int x() {
        return this.dm;
    }

    public void l(int i) {
        this.dm = i;
    }

    public double fs() {
        return this.mz;
    }

    public void n(double d) {
        this.mz = d;
    }

    public int rv() {
        return this.ze;
    }

    public void w(int i) {
        this.ze = i;
    }

    public String tj() {
        return this.di;
    }

    public void n(String str) {
        this.di = str;
    }

    public float cp() {
        return this.n;
    }

    public void n(float f) {
        this.n = f;
    }

    public float d() {
        return this.qg;
    }

    public void qg(float f) {
        this.qg = f;
    }

    public void s(float f) {
        this.s = f;
    }

    public void q(float f) {
        this.q = f;
    }

    public boolean oa() {
        return this.l;
    }

    public void qg(boolean z) {
        this.l = z;
    }

    public float sz() {
        return this.w;
    }

    public void l(float f) {
        this.w = f;
    }

    public float k() {
        return this.x;
    }

    public void w(float f) {
        this.x = f;
    }

    public float cy() {
        return this.fs;
    }

    public void x(float f) {
        this.fs = f;
    }

    public float hd() {
        return this.rv;
    }

    public void fs(float f) {
        this.rv = f;
    }

    public float cd() {
        return this.tj;
    }

    public void rv(float f) {
        this.tj = f;
    }

    public double um() {
        return this.cp;
    }

    public void qg(double d) {
        this.cp = d;
    }

    public double a() {
        return this.d;
    }

    public void s(double d) {
        this.d = d;
    }

    public void qg(String str) {
        this.oa = str;
    }

    public void s(String str) {
        this.sz = str;
    }

    public String py() {
        return this.k;
    }

    public void q(String str) {
        this.k = str;
    }

    public String ou() {
        return this.cy;
    }

    public void l(String str) {
        this.cy = str;
    }

    public String wm() {
        return this.hd;
    }

    public void w(String str) {
        this.hd = str;
    }

    public void x(String str) {
        this.cd = str;
    }

    public String m() {
        return this.cd;
    }

    private void ur(String str) {
        this.iz = str;
    }

    public String hu() {
        return this.iz;
    }

    public String h() {
        return this.um;
    }

    public void fs(String str) {
        this.um = str;
    }

    public void rv(String str) {
        this.a = str;
    }

    public String t() {
        return this.py;
    }

    public void tj(String str) {
        this.py = str;
    }

    public String ur() {
        return this.ou;
    }

    public void cp(String str) {
        this.ou = str;
    }

    public String bb() {
        return this.wm;
    }

    public void d(String str) {
        this.wm = str;
    }

    public String ln() {
        return this.m;
    }

    public void oa(String str) {
        this.m = str;
    }

    public boolean lh() {
        return this.hu;
    }

    public void s(boolean z) {
        this.hu = z;
    }

    public int v() {
        return this.h;
    }

    public void x(int i) {
        this.h = i;
    }

    public int j() {
        return this.t;
    }

    public void fs(int i) {
        this.t = i;
    }

    public double an() {
        return this.ur;
    }

    public void q(double d) {
        this.ur = d;
    }

    public double ae() {
        return this.bb;
    }

    public void l(double d) {
        this.bb = d;
    }

    public String f() {
        return this.ln;
    }

    public void sz(String str) {
        this.ln = str;
    }

    public String fi() {
        return this.lh;
    }

    public void k(String str) {
        this.lh = str;
    }

    public String df() {
        return this.v;
    }

    public void cy(String str) {
        this.v = str;
    }

    public String oj() {
        return this.j;
    }

    public void hd(String str) {
        this.j = str;
    }

    public String dg() {
        return this.an;
    }

    public void cd(String str) {
        this.an = str;
    }

    public boolean u() {
        return this.ae;
    }

    public void q(boolean z) {
        this.ae = z;
    }

    public void rv(int i) {
        this.f = i;
    }

    public int pk() {
        return this.f;
    }

    public int wo() {
        return this.fi;
    }

    public void tj(int i) {
        this.fi = i;
    }

    public int sh() {
        return this.df;
    }

    public void cp(int i) {
        this.df = i;
    }

    public int y() {
        return this.oj;
    }

    public void d(int i) {
        this.oj = i;
    }

    public int rf() {
        return this.dg;
    }

    public void oa(int i) {
        this.dg = i;
    }

    public double dh() {
        return this.u;
    }

    public void w(double d) {
        this.u = d;
    }

    public int b() {
        return this.pk;
    }

    public void sz(int i) {
        this.pk = i;
    }

    public boolean ri() {
        return this.wo;
    }

    public void l(boolean z) {
        this.wo = z;
    }

    public int nf() {
        return this.sh;
    }

    public void k(int i) {
        this.sh = i;
    }

    public boolean pe() {
        return this.y;
    }

    public void w(boolean z) {
        this.y = z;
    }

    public int e() {
        return this.rf;
    }

    public void cy(int i) {
        this.rf = i;
    }

    public String yw() {
        return this.dh;
    }

    public void um(String str) {
        this.dh = str;
    }

    public boolean cx() {
        return this.b;
    }

    public void x(boolean z) {
        this.b = z;
    }

    public boolean lq() {
        return this.ri;
    }

    public void fs(boolean z) {
        this.ri = z;
    }

    public boolean ic() {
        return this.nf;
    }

    public void rv(boolean z) {
        this.nf = z;
    }

    public boolean ci() {
        return this.pe;
    }

    public void tj(boolean z) {
        this.pe = z;
    }

    public String hf() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public void qg(JSONObject jSONObject) {
        this.yw = jSONObject;
    }

    public JSONObject kc() {
        return this.yw;
    }

    public int z() {
        return this.cx;
    }

    public void hd(int i) {
        this.cx = i;
    }

    public boolean dn() {
        return this.lq;
    }

    public void cp(boolean z) {
        this.lq = z;
    }

    public int he() {
        return this.ic;
    }

    public void cd(int i) {
        this.ic = i;
    }

    public int el() {
        return this.ci;
    }

    public void um(int i) {
        this.ci = i;
    }

    public int vb() {
        return this.hf;
    }

    public void a(int i) {
        this.hf = i;
    }

    public int fl() {
        return this.kc;
    }

    public void py(int i) {
        this.kc = i;
    }

    public int i() {
        return this.z;
    }

    public void ou(int i) {
        this.z = i;
    }

    public int dw() {
        return this.dn;
    }

    public void wm(int i) {
        this.dn = i;
    }

    public String su() {
        return this.he;
    }

    public void py(String str) {
        this.he = str;
    }

    public String ha() {
        return this.el;
    }

    public void ou(String str) {
        this.el = str;
    }

    public int g() {
        return this.fl;
    }

    public void m(int i) {
        this.fl = i;
    }

    public int ry() {
        return this.i;
    }

    public void hu(int i) {
        this.i = i;
    }

    public String ju() {
        return this.xd;
    }

    public void wm(String str) {
        this.xd = str;
    }

    public boolean ta() {
        return this.ti;
    }

    public void d(boolean z) {
        this.ti = z;
    }

    public int wv() {
        return this.lg;
    }

    public void h(int i) {
        this.lg = i;
    }

    public int xi() {
        return this.jh;
    }

    public void t(int i) {
        this.jh = i;
    }

    public int np() {
        return this.xb;
    }

    public void ur(int i) {
        this.xb = i;
    }

    public boolean r() {
        return this.ox;
    }

    public void oa(boolean z) {
        this.ox = z;
    }

    public int mz() {
        return this.dw;
    }

    public void bb(int i) {
        this.dw = i;
    }

    public void sz(boolean z) {
        this.o = z;
    }

    public boolean sq() {
        return this.o;
    }

    public void m(String str) {
        this.qh = str;
    }

    public String ei() {
        return this.qh;
    }

    public void ln(int i) {
        this.eq = i;
    }

    public int dm() {
        return this.eq;
    }

    public List<n> vo() {
        return this.su;
    }

    public int o() {
        List<n> list = this.su;
        if (list == null) {
            return 0;
        }
        for (n nVar : list) {
            if ("translate".equals(nVar.rv()) && nVar.x() < 0) {
                return -nVar.x();
            }
        }
        return 0;
    }

    public void n(List<n> list) {
        this.su = list;
    }

    public int nk() {
        return this.ha;
    }

    public void lh(int i) {
        this.ha = i;
    }

    public int ze() {
        return this.g;
    }

    public void v(int i) {
        this.g = i;
    }

    public int qn() {
        return this.ry;
    }

    public void j(int i) {
        this.ry = i;
    }

    public boolean bz() {
        return this.ta;
    }

    public void k(boolean z) {
        this.ta = z;
    }

    public int il() {
        return this.ju;
    }

    public void an(int i) {
        this.ju = i;
    }

    public boolean la() {
        return this.wv;
    }

    public void cy(boolean z) {
        this.wv = z;
    }

    public boolean qh() {
        return this.xi;
    }

    public void hd(boolean z) {
        this.xi = z;
    }

    public int eq() {
        return this.np;
    }

    public void ae(int i) {
        this.np = i;
    }

    public String ox() {
        return this.vo;
    }

    public boolean xd() {
        return this.r;
    }

    public void cd(boolean z) {
        this.r = z;
    }

    public void s(JSONObject jSONObject) {
        this.sq = jSONObject;
    }

    public JSONObject ti() {
        return this.ei;
    }

    public void q(JSONObject jSONObject) {
        this.ei = jSONObject;
    }

    public void l(JSONObject jSONObject) {
        this.nk = jSONObject;
    }

    public String lg() {
        return this.ct;
    }

    public void hu(String str) {
        this.ct = str;
    }

    public void jh() {
        n(this, this.sq);
    }

    public void xb() {
        n(this, this.ei);
    }

    public String ct() {
        return this.ca;
    }

    public void h(String str) {
        this.ca = str;
    }

    public long ca() {
        return this.tr;
    }

    public void n(long j) {
        this.tr = j;
    }

    public String tr() {
        return ("flip".equals(this.of) || "slide".equals(this.of)) ? this.of : "slide";
    }

    public void t(String str) {
        this.of = str;
    }

    public List<String> iz() {
        return this.dz;
    }

    public void qg(List<String> list) {
        this.dz = list;
    }

    public void um(boolean z) {
        this.c = z;
    }

    public boolean of() {
        return this.c;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void n(w wVar, JSONObject jSONObject) {
        if (wVar == null || jSONObject == null) {
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
                        b = 13;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b = 14;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b = 15;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b = 16;
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
                    if (next.equals(f.R)) {
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
                        b = c.c;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b = c.b;
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
                    wVar.s(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    wVar.k(jSONObject.optString(next));
                    break;
                case 2:
                    wVar.h(jSONObject.optString(next));
                    break;
                case 3:
                    wVar.x(jSONObject.optString(next));
                    break;
                case 4:
                    wVar.rv(jSONObject.optInt(next));
                    break;
                case 5:
                    wVar.cd(jSONObject.optBoolean(next));
                    break;
                case 6:
                    wVar.w(jSONObject.optBoolean(next));
                    break;
                case 7:
                    wVar.oa(jSONObject.optString(next));
                    break;
                case 8:
                    wVar.w((float) jSONObject.optDouble(next));
                    break;
                case 9:
                    wVar.qg(jSONObject.optString(next));
                    break;
                case 10:
                    wVar.wm(jSONObject.optInt(next));
                    break;
                case 11:
                    wVar.s(jSONObject.optString(next));
                    break;
                case 12:
                    wVar.s((float) jSONObject.optDouble(next));
                    break;
                case 13:
                    wVar.q(jSONObject.optString(next));
                    break;
                case 14:
                    wVar.py(jSONObject.optString(next));
                    break;
                case 15:
                    wVar.qg(jSONObject.optBoolean(next));
                    break;
                case 16:
                    wVar.tj(jSONObject.optInt(next));
                    break;
                case 17:
                    wVar.tj(jSONObject.optBoolean(next));
                    break;
                case 18:
                    wVar.n(jSONObject.optLong(next));
                    break;
                case 19:
                    wVar.ou(jSONObject.optString(next));
                    break;
                case 20:
                    wVar.hd(jSONObject.optInt(next));
                    break;
                case 21:
                    wVar.hu(jSONObject.optInt(next));
                    break;
                case 22:
                    wVar.rv(jSONObject.optBoolean(next));
                    break;
                case 23:
                    wVar.k(jSONObject.optInt(next));
                    break;
                case 24:
                    wVar.m(jSONObject.optInt(next));
                    break;
                case 25:
                    wVar.qg(jSONObject.optDouble(next));
                    break;
                case 26:
                    wVar.w(jSONObject.optDouble(next));
                    break;
                case 27:
                    wVar.um(jSONObject.optInt(next));
                    break;
                case 28:
                    wVar.fs(jSONObject.optBoolean(next));
                    break;
                case 29:
                    wVar.cp(jSONObject.optInt(next));
                    break;
                case 30:
                    wVar.w(jSONObject.optString(next));
                    break;
                case 31:
                    wVar.sz(jSONObject.optBoolean(next));
                    break;
                case 32:
                    wVar.x(jSONObject.optBoolean(next));
                    break;
                case 33:
                    wVar.cp(jSONObject.optString(next));
                    break;
                case 34:
                    wVar.ou(jSONObject.optInt(next));
                    break;
                case 35:
                    wVar.a(jSONObject.optString(next));
                    break;
                case 36:
                    wVar.a(jSONObject.optInt(next));
                    break;
                case 37:
                    wVar.n(jSONObject.optBoolean(next));
                    break;
                case 38:
                    wVar.fs((float) jSONObject.optDouble(next));
                    break;
                case 39:
                    wVar.um(jSONObject.optString(next));
                    break;
                case 40:
                    wVar.l(jSONObject.optString(next));
                    break;
                case 41:
                    wVar.py(jSONObject.optInt(next));
                    break;
                case 42:
                    wVar.q((float) jSONObject.optDouble(next));
                    break;
                case 43:
                    wVar.s(jSONObject.optDouble(next));
                    break;
                case 44:
                    wVar.l((float) jSONObject.optDouble(next));
                    break;
                case 45:
                    wVar.cp(jSONObject.optBoolean(next));
                    break;
                case 46:
                    wVar.sz(jSONObject.optBoolean(next));
                    break;
                case 47:
                    wVar.rv((float) jSONObject.optDouble(next));
                    break;
                case 48:
                    wVar.cd(jSONObject.optString(next));
                    break;
                case 49:
                    wVar.bb(jSONObject.optInt(next));
                    break;
                case 50:
                    wVar.x((float) jSONObject.optDouble(next));
                    break;
                case 51:
                    wVar.fs(jSONObject.optString(next));
                    break;
                case 52:
                    wVar.rv(jSONObject.optString(next));
                    break;
                case 53:
                    wVar.cy(jSONObject.optInt(next));
                    break;
                case 54:
                    wVar.l(jSONObject.optBoolean(next));
                    break;
                case 55:
                    wVar.oa(jSONObject.optInt(next));
                    break;
                case 56:
                    wVar.hd(jSONObject.optString(next));
                    break;
                case 57:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        wVar.x(jSONObjectOptJSONObject.optInt("translateY", 0));
                        wVar.fs(jSONObjectOptJSONObject.optInt("translateX", 0));
                        wVar.q(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        wVar.l(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case 58:
                    wVar.q(jSONObject.optBoolean(next));
                    break;
                case 59:
                    wVar.d(jSONObject.optString(next));
                    break;
                case 60:
                    wVar.sz(jSONObject.optString(next));
                    break;
                case 61:
                    wVar.n((float) jSONObject.optDouble(next));
                    break;
                case 62:
                    wVar.cy(jSONObject.optString(next));
                    break;
                case 63:
                    wVar.tj(jSONObject.optString(next));
                    break;
                case 64:
                    wVar.cd(jSONObject.optInt(next));
                    break;
                case 65:
                    wVar.qg((float) jSONObject.optDouble(next));
                    break;
                case 66:
                    wVar.d(jSONObject.optInt(next));
                    break;
                case 67:
                    wVar.sz(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
