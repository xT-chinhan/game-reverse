package com.anythink.core.common.h;

import android.text.TextUtils;
import com.tapsdk.tapad.constants.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class bu {
    public static final String S = "ofm_tid_key";
    public static final int T = 1;
    public static final int U = 2;
    public static final int V = 3;
    public static final int W = 4;
    public static final int X = 5;
    public static final int Y = 6;
    public static final int Z = 7;
    public static final int aA = 5;
    public static final int aB = 8;
    public static final int aC = 5;
    public static final int aD = 6;
    public static final int aE = 7;
    public static final String aF = "0";
    public static final String aG = "1";
    public static final String aH = "2";
    public static final String aI = "3";
    public static final String aJ = "4";
    public static final String aK = "50";
    public static final int aa = 8;
    public static final int ab = 9;
    public static final int ac = 10;
    public static final int ad = 18;
    public static final int ae = 21;
    public static final int af = 25;
    public static final int ag = 26;
    public static final int ah = 27;
    public static final int ai = 28;
    public static final int aj = 29;
    public static final int ak = 30;
    public static final int al = 31;
    public static final int am = 32;
    public static final int an = 33;
    public static final int ao = 34;
    public static final int ap = 0;
    public static final int aq = 1;
    public static final int ar = 2;
    public static final int as = 8;
    public static final int at = 9;
    public static final int au = 10;
    public static final int av = 11;
    public static final int aw = 3;
    public static final int ax = 12;
    public static final int ay = 13;
    public static final int az = 4;
    private String a;
    protected String aL;
    protected String aM;
    protected String aN;
    protected String aO;
    public String aP;
    public int aQ;
    public int aR;
    protected String aS;
    protected int aT;
    protected int aU;
    protected int aV;
    protected int aW = -1;
    private String b;
    private int c;
    private JSONObject d;
    private int e;
    private Object f;
    private JSONObject g;
    private String h;
    private String i;

    public final JSONObject ax() {
        return this.g;
    }

    public final void a(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public final Object ay() {
        return this.f;
    }

    public final void a(Object obj) {
        this.f = obj;
    }

    public final void al(int i) {
        this.e = i;
    }

    private JSONObject a() {
        return this.d;
    }

    public final void b(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public final String az() {
        return this.h;
    }

    public final void D(String str) {
        this.h = str;
    }

    public final int aA() {
        return this.c;
    }

    public final void am(int i) {
        this.c = i;
    }

    public final void E(String str) {
        this.a = str;
    }

    public final void F(String str) {
        this.b = str;
    }

    public final String aB() {
        return this.a;
    }

    public final String aC() {
        return this.b;
    }

    public final void an(int i) {
        this.aV = i;
    }

    private int b() {
        return this.aV;
    }

    private int c() {
        return this.aT;
    }

    public final void aD() {
        this.aT = 1;
    }

    public final int aE() {
        return this.aU;
    }

    public final void ao(int i) {
        this.aU = i;
    }

    public final String aF() {
        return this.aS;
    }

    public final void G(String str) {
        this.aS = str;
    }

    private String d() {
        return this.aP;
    }

    private void a(String str) {
        this.aP = str;
    }

    private int e() {
        return this.aQ;
    }

    private void a(int i) {
        this.aQ = i;
    }

    private int f() {
        return this.aR;
    }

    private void b(int i) {
        this.aR = i;
    }

    public final int aG() {
        return this.aW;
    }

    public final void ap(int i) {
        this.aW = i;
    }

    public final String aH() {
        return this.aO;
    }

    public final void H(String str) {
        this.aO = str;
    }

    public final String aI() {
        return this.aL;
    }

    public final void I(String str) {
        this.aL = str;
    }

    public final String aJ() {
        return this.aM;
    }

    public final void J(String str) {
        this.aM = str;
    }

    public final String aK() {
        return this.aN;
    }

    public final String aL() {
        String str = this.aN;
        str.hashCode();
        switch (str) {
            case "0":
                return "native";
            case "1":
                return Constants.AdTypeName.REWARD;
            case "2":
                return "banner";
            case "3":
                return "inter";
            case "4":
                return "splash";
            case "50":
                return "media_video";
            default:
                return "none";
        }
    }

    public final void K(String str) {
        this.aN = str;
    }

    public JSONObject O(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i);
            jSONObject.put(com.anythink.core.common.m.e.bk, this.aL);
            jSONObject.put("req_id", this.aM);
            if (!TextUtils.isEmpty(this.aN)) {
                jSONObject.put("format", Integer.parseInt(this.aN));
            }
            jSONObject.put("ps_id", com.anythink.core.common.d.t.b().r());
            String strG = com.anythink.core.common.d.t.b().g(this.aL);
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("sessionid", strG);
            }
            int i2 = this.aW;
            if (i2 != -1) {
                jSONObject.put("traffic_group_id", i2);
            }
            if (this.aV == 1) {
                jSONObject.put("ofm_tid", this.aU);
                jSONObject.put("ofm_system", this.aT);
                jSONObject.put(com.anythink.core.common.m.e.N, this.aV);
            }
            jSONObject.put("asid", this.aO);
            jSONObject.put(com.anythink.core.d.l.a.T, this.a);
            jSONObject.put(com.anythink.core.common.m.e.ai, this.b);
            JSONObject jSONObject2 = this.d;
            if (jSONObject2 != null) {
                jSONObject.put(com.anythink.core.d.l.a.aa, jSONObject2);
            }
            int i3 = this.e;
            if (i3 > 0) {
                jSONObject.put("wf2_mode", i3);
            }
            JSONObject jSONObject3 = this.g;
            if (jSONObject3 != null) {
                jSONObject.put("adap_c", jSONObject3);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put("x_c", new JSONArray(this.h));
            }
            if (!TextUtils.isEmpty(aM())) {
                jSONObject.put("o_r", aM());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String aM() {
        if (TextUtils.isEmpty(this.i)) {
            return this.aM;
        }
        return this.i;
    }

    public final void L(String str) {
        this.i = str;
    }
}
