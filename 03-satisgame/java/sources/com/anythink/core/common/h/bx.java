package com.anythink.core.common.h;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class bx {
    public static final String X = "ofm_tid_key";
    public static final int Y = 1;
    public static final int Z = 2;
    public static final int aA = 40;
    public static final int aB = 0;
    public static final int aC = 1;
    public static final int aD = 2;
    public static final int aE = 8;
    public static final int aF = 9;
    public static final int aG = 10;
    public static final int aH = 11;
    public static final int aI = 3;
    public static final int aJ = 12;
    public static final int aK = 13;
    public static final int aL = 4;
    public static final int aM = 5;
    public static final int aN = 8;
    public static final int aO = 5;
    public static final int aP = 6;
    public static final int aQ = 7;
    public static final String aR = "0";
    public static final String aS = "1";
    public static final String aT = "2";
    public static final String aU = "3";
    public static final String aV = "4";
    public static final String aW = "50";
    public static final int aa = 3;
    public static final int ab = 4;
    public static final int ac = 5;
    public static final int ad = 6;
    public static final int ae = 7;
    public static final int af = 8;
    public static final int ag = 9;
    public static final int ah = 10;
    public static final int ai = 11;
    public static final int aj = 18;
    public static final int ak = 21;
    public static final int al = 25;
    public static final int am = 26;
    public static final int an = 27;
    public static final int ao = 28;
    public static final int ap = 29;
    public static final int aq = 30;
    public static final int ar = 31;
    public static final int as = 32;
    public static final int at = 33;
    public static final int au = 34;
    public static final int av = 35;
    public static final int aw = 36;
    public static final int ax = 37;
    public static final int ay = 38;
    public static final int az = 39;
    private String a;
    protected String aX;
    protected String aY;
    protected String aZ;
    private String b;
    protected String ba;
    public String bb;
    public int bc;
    public int bd;
    protected String be;
    protected int bf;
    protected int bg;
    protected int bh;
    protected Map<Integer, Integer> bi = new ConcurrentHashMap();
    protected int bj = -1;
    private int c;
    private JSONObject d;
    private int e;
    private Object f;
    private JSONObject g;
    private String h;
    private String i;

    public final void b(int i, int i2) {
        Map<Integer, Integer> map = this.bi;
        if (map != null) {
            map.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public final JSONObject aF() {
        return this.g;
    }

    public final void a(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public final Object aG() {
        return this.f;
    }

    public final void a(Object obj) {
        this.f = obj;
    }

    public final void aq(int i) {
        this.e = i;
    }

    private JSONObject a() {
        return this.d;
    }

    public final void b(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public final String aH() {
        return this.h;
    }

    public final void D(String str) {
        this.h = str;
    }

    public final int aI() {
        return this.c;
    }

    public final void ar(int i) {
        this.c = i;
    }

    public final void E(String str) {
        this.a = str;
    }

    public final void F(String str) {
        this.b = str;
    }

    public final String aJ() {
        return this.a;
    }

    public final String aK() {
        return this.b;
    }

    public final void as(int i) {
        this.bh = i;
    }

    private int b() {
        return this.bh;
    }

    private int c() {
        return this.bf;
    }

    public final void aL() {
        this.bf = 1;
    }

    public final int aM() {
        return this.bg;
    }

    public final void at(int i) {
        this.bg = i;
    }

    public final String aN() {
        return this.be;
    }

    public final void G(String str) {
        this.be = str;
    }

    private String d() {
        return this.bb;
    }

    private void a(String str) {
        this.bb = str;
    }

    private int e() {
        return this.bc;
    }

    private void a(int i) {
        this.bc = i;
    }

    private int f() {
        return this.bd;
    }

    private void b(int i) {
        this.bd = i;
    }

    public final int aO() {
        return this.bj;
    }

    public final void au(int i) {
        this.bj = i;
    }

    public final String aP() {
        return this.ba;
    }

    public final void H(String str) {
        this.ba = str;
    }

    public final String aQ() {
        return this.aX;
    }

    public final void I(String str) {
        this.aX = str;
    }

    public final String aR() {
        return this.aY;
    }

    public final void J(String str) {
        this.aY = str;
    }

    public final String aS() {
        return this.aZ;
    }

    public final String aT() {
        String str = this.aZ;
        str.hashCode();
        switch (str) {
            case "0":
                return "native";
            case "1":
                return "reward";
            case "2":
                return MediationConstant.RIT_TYPE_BANNER;
            case "3":
                return "inter";
            case "4":
                return MediationConstant.RIT_TYPE_SPLASH;
            case "50":
                return "media_video";
            default:
                return LiveConfigKey.NONE;
        }
    }

    public final void K(String str) {
        this.aZ = str;
    }

    public JSONObject O(int i) {
        Integer num;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.core.common.l.f.br, new StringBuilder().append(System.currentTimeMillis()).toString());
            jSONObject.put("type", i);
            jSONObject.put(com.anythink.core.common.l.f.bn, this.aX);
            jSONObject.put("req_id", this.aY);
            if (!TextUtils.isEmpty(this.aZ)) {
                jSONObject.put(com.anythink.core.common.f.a.C0017a.d, Integer.parseInt(this.aZ));
            }
            jSONObject.put("ps_id", com.anythink.core.common.d.s.b().r());
            String strG = com.anythink.core.common.d.s.b().g(this.aX);
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("sessionid", strG);
            }
            int i2 = this.bj;
            if (i2 != -1) {
                jSONObject.put("traffic_group_id", i2);
            }
            if (this.bh == 1) {
                jSONObject.put("ofm_tid", this.bg);
                jSONObject.put("ofm_system", this.bf);
                jSONObject.put(com.anythink.core.common.l.f.N, this.bh);
            }
            jSONObject.put("asid", this.ba);
            jSONObject.put(com.anythink.core.e.l.a.T, this.a);
            jSONObject.put(com.anythink.core.common.l.f.aj, this.b);
            JSONObject jSONObject2 = this.d;
            if (jSONObject2 != null) {
                jSONObject.put(com.anythink.core.e.l.a.aa, jSONObject2);
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
            if (!TextUtils.isEmpty(aU())) {
                jSONObject.put("o_r", aU());
            }
            Map<Integer, Integer> map = this.bi;
            if (map != null && !map.isEmpty() && (num = this.bi.get(Integer.valueOf(i))) != null && num.intValue() > 0) {
                jSONObject.put("smp_rate", num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String aU() {
        if (TextUtils.isEmpty(this.i)) {
            return this.aY;
        }
        return this.i;
    }

    public final void L(String str) {
        this.i = str;
    }
}
