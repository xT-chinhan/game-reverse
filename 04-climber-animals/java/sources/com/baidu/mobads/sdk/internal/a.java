package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "none";
    public static final String b = "text";
    public static final String c = "static_image";
    public static final String d = "gif";
    public static final String e = "rich_media";
    public static final String f = "html";
    public static final String g = "hybrid";
    public static final String h = "video";
    private static final long i = 1750000;
    private String A;
    private String B;
    private String C;
    private String D;
    private int E;
    private String F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private String M;
    private List<String> O;
    private JSONObject P;
    private long Q;
    private long R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private JSONObject Z;
    private int aa;
    private int ab;
    private int ac;
    private List<String> ad;
    private String af;
    private String ag;
    private JSONObject ah;
    private JSONObject ai;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private long q;
    private int r;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private int s = 1;
    private String N = "none";
    private int ae = 0;

    public static boolean a(int i2) {
        return (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0145  */
    public static a a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.ai = jSONObject;
        aVar.P = jSONObject.optJSONObject("remoteParams");
        aVar.j = jSONObject.optString("tit");
        aVar.k = jSONObject.optString(com.anythink.basead.c.b.a.f);
        aVar.l = jSONObject.optString("icon");
        aVar.m = jSONObject.optString("w_picurl");
        aVar.n = jSONObject.optInt(IAdInterListener.AdReqParam.WIDTH);
        aVar.o = jSONObject.optInt("h");
        aVar.p = jSONObject.optString("appname");
        aVar.T = jSONObject.optString("adLogo");
        aVar.U = jSONObject.optString("baiduLogo");
        aVar.aa = jSONObject.optInt("region_click", 2);
        aVar.ab = jSONObject.optInt("dl_dialog", 2);
        aVar.Y = jSONObject.optString("btn");
        try {
            String strOptString = jSONObject.optString("control_flags");
            if (!TextUtils.isEmpty(strOptString)) {
                String strOptString2 = new JSONObject(strOptString).optString("innovate");
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString2);
                    aVar.V = jSONObject3.optString("gjico");
                    aVar.W = jSONObject3.optString("gjtxt");
                    aVar.X = jSONObject3.optString("gjurl");
                }
            }
            String strOptString3 = jSONObject.optString("cloud_control");
            if (!TextUtils.isEmpty(strOptString3)) {
                JSONObject jSONObject4 = new JSONObject(strOptString3);
                if (jSONObject4.has(com.anythink.basead.c.b.a.k) && jSONObject4.optInt(com.anythink.basead.c.b.a.k, 1) == 0) {
                    aVar.Y = "";
                }
                if (jSONObject4.has("marketing")) {
                    int iOptInt = jSONObject4.optInt("marketing", 0);
                    if (iOptInt == 1) {
                        JSONArray jSONArrayOptJSONArray = jSONObject4.optJSONArray("marketing_logo");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            int i2 = 0;
                            for (int i3 = 2; i2 < i3; i3 = 2) {
                                String strOptString4 = jSONArrayOptJSONArray.optString(i2);
                                if (!TextUtils.isEmpty(strOptString4)) {
                                    JSONObject jSONObject5 = new JSONObject(strOptString4);
                                    aVar.V = jSONObject5.optString("gjico", aVar.V);
                                    aVar.W = jSONObject5.optString("gjtxt", aVar.W);
                                    aVar.X = jSONObject5.optString("gjurl", aVar.X);
                                }
                                i2++;
                            }
                        }
                    } else if (iOptInt == 0) {
                        aVar.V = "";
                        aVar.W = "";
                        aVar.X = "";
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject4.optJSONArray("btn_style");
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                    jSONObject2 = null;
                } else {
                    String strOptString5 = jSONArrayOptJSONArray2.optString(0);
                    if (TextUtils.isEmpty(strOptString5)) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject(strOptString5);
                    }
                }
                if (jSONObject2 != null) {
                    aVar.ac = jSONObject2.optInt("type", 0);
                    JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("colors");
                    if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() == 4) {
                        aVar.ad = new ArrayList();
                        for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                            aVar.ad.add(jSONArrayOptJSONArray3.optString(i4));
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        aVar.Z = jSONObject.optJSONObject("monitors");
        aVar.q = jSONObject.optLong("sz");
        aVar.r = jSONObject.optInt("auto_play", 0);
        aVar.s = jSONObject.optInt("auto_play_non_wifi", 1);
        aVar.w = jSONObject.optString(com.umeng.analytics.pro.g.S);
        aVar.E = jSONObject.optInt("act");
        aVar.F = jSONObject.optString("apo", "");
        aVar.t = jSONObject.optString("bidlayer", "");
        aVar.u = jSONObject.optString("ads_bidlayer", "");
        aVar.v = jSONObject.optString("enc_bid_price", "");
        aVar.G = jSONObject.optInt("container_width");
        aVar.H = jSONObject.optInt("container_height");
        aVar.I = jSONObject.optInt("size_type");
        int iOptInt2 = jSONObject.optInt("style_type");
        aVar.J = iOptInt2;
        aVar.K = a(jSONObject, iOptInt2, 29);
        aVar.x = jSONObject.optString("vurl", "");
        aVar.L = jSONObject.optInt("duration", 0);
        aVar.M = jSONObject.optString("type");
        aVar.y = jSONObject.optString(f, null);
        aVar.A = jSONObject.optString("app_version", "");
        aVar.z = jSONObject.optString("publisher", "");
        aVar.D = jSONObject.optString("permission_link", "");
        aVar.B = jSONObject.optString("privacy_link", "");
        aVar.C = jSONObject.optString("function_link", "");
        aVar.ae = jSONObject.optInt("media_player_render", 0);
        aVar.af = jSONObject.optString("qk", "");
        aVar.ag = jSONObject.optString("buyer", "");
        try {
            String strOptString6 = jSONObject.optString("media_key");
            if (!TextUtils.isEmpty(strOptString6)) {
                aVar.ah = new JSONObject(strOptString6);
            }
        } catch (Throwable th2) {
            az.b(th2);
        }
        try {
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("morepics");
            if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                aVar.O = new ArrayList();
                for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                    aVar.O.add(jSONArrayOptJSONArray4.getString(i5));
                }
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(aVar.y)) {
            aVar.N = f;
        } else {
            String str = aVar.M;
            if (str != null) {
                if (str.equals("text")) {
                    aVar.M = "text";
                } else if (aVar.M.equals("image")) {
                    if (!TextUtils.isEmpty(aVar.m)) {
                        int iLastIndexOf = aVar.m.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                        if ((iLastIndexOf >= 0 ? aVar.m.toLowerCase(Locale.getDefault()).substring(iLastIndexOf) : "").contains(".gif")) {
                            aVar.N = "gif";
                        } else {
                            aVar.N = c;
                        }
                    }
                } else if (aVar.M.equals(com.kuaishou.weapon.p0.t.w)) {
                    aVar.N = e;
                } else if (aVar.M.equals("video")) {
                    aVar.N = "video";
                }
            }
        }
        JSONObject jSONObject6 = aVar.P;
        if (jSONObject6 != null) {
            aVar.Q = jSONObject6.optLong("createTime", 0L);
            aVar.R = aVar.P.optLong("expireTime", i);
            aVar.T = aVar.P.optString("adLogo", z.aM);
            aVar.U = aVar.P.optString("baiduLogo", z.aN);
            aVar.S = aVar.P.optString("uniqueId", "");
        }
        return aVar;
    }

    public String a(String str) {
        if (this.ah == null) {
            return null;
        }
        JSONObject jSONObject = this.ai;
        JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject("apo") : null;
        String strOptString = this.ah.optString(str);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        if (TextUtils.equals(strOptString, "fallback") && jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optString("fallback");
        }
        if (TextUtils.equals(strOptString, "page") && jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optString("page");
        }
        JSONObject jSONObject2 = this.ai;
        if (jSONObject2 != null) {
            return jSONObject2.optString(strOptString);
        }
        return null;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i2, int i3) {
        String[] strArrSplit;
        int i4 = 0;
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("st_op");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("opt_style_") && (strArrSplit = strOptString.substring(10).split("_")) != null && strArrSplit.length > 0) {
                        i4 = Integer.parseInt(strArrSplit[0]);
                    }
                }
            } catch (Throwable th) {
                bu.a().d(th.getMessage());
            }
        }
        if (a(i4)) {
            i2 = i4;
        } else if (!a(i2)) {
            i2 = i3;
        }
        if (i2 == 42) {
            return 41;
        }
        return i2;
    }

    public String a() {
        return this.j;
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.o;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.T;
    }

    public String i() {
        return this.U;
    }

    public long j() {
        return this.q;
    }

    public int k() {
        return this.r;
    }

    public int l() {
        return this.s;
    }

    public String m() {
        return this.w;
    }

    public String n() {
        return this.x;
    }

    public String o() {
        return this.y;
    }

    public int p() {
        return this.E;
    }

    public String q() {
        return this.F;
    }

    public int r() {
        return this.G;
    }

    public int s() {
        return this.H;
    }

    public int t() {
        return this.I;
    }

    public int u() {
        return this.J;
    }

    public int v() {
        return this.K;
    }

    public int w() {
        return this.L;
    }

    public String x() {
        return this.N;
    }

    public long y() {
        return this.Q;
    }

    public String z() {
        if (!TextUtils.isEmpty(this.u)) {
            return this.u;
        }
        return this.t;
    }

    public String A() {
        return this.v;
    }

    public String B() {
        return this.A;
    }

    public String C() {
        return this.z;
    }

    public String D() {
        return this.B;
    }

    public String E() {
        return this.C;
    }

    public String F() {
        return this.D;
    }

    public long G() {
        return this.R;
    }

    public List<String> H() {
        return this.O;
    }

    public String I() {
        return this.S;
    }

    public JSONObject J() {
        return this.P;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        return this.W;
    }

    public String M() {
        return this.X;
    }

    public String N() {
        String str = this.Y;
        return (str == null || str.length() <= 4) ? this.Y : "";
    }

    public int O() {
        return this.ac;
    }

    public List<String> P() {
        return this.ad;
    }

    public JSONObject Q() {
        return this.Z;
    }

    public int R() {
        return this.aa;
    }

    public int S() {
        return this.ab;
    }

    public int T() {
        return this.ae;
    }

    public JSONObject U() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.S);
            jSONObject.put("tit", this.j);
            jSONObject.put(com.anythink.basead.c.b.a.f, this.k);
            jSONObject.put(com.umeng.analytics.pro.g.S, this.w);
            jSONObject.put("appname", this.p);
            jSONObject.put("act", this.E);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String V() {
        return this.af;
    }

    public String W() {
        if (TextUtils.isEmpty(this.ag)) {
            return "";
        }
        try {
            long j = Long.parseLong(this.ag);
            int length = this.ag.length();
            return (j <= 100000 || length <= 5) ? "" : this.ag.substring(length - 4, length);
        } catch (Throwable th) {
            az.b(th);
            return "";
        }
    }
}
