package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.mcto.sspsdk.QyRewardProperty;
import com.qq.e.comm.constants.Constants;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public HashMap A0;
    public String B;
    public String C;
    public Map C0;
    public String E;
    public JSONObject H0;
    public String I;
    public JSONObject I0;
    public int[] J;
    public HashMap J0;
    public String K0;
    public String N;
    public String O;
    public int R;
    public JSONObject R0;
    public int T;
    public final int T0;
    public int U;
    public final int a;
    public final boolean b;
    public final vh c;
    public int[] c0;
    public int e0;
    public String f0;
    public String g0;
    public String h0;
    public HashMap i0;
    public int j0;
    public String k0;
    public String l0;
    public String m0;
    public String n0;
    public int q0;
    public int r0;
    public String u0;
    public String v;
    public String v0;
    public String w;
    public String x;
    public String x0;
    public String y0;
    public int d = 0;
    public int S0 = 1;
    public boolean e = false;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = -1;
    public int j = 0;
    public int k = 5000;
    public int l = 0;
    public long m = 0;
    public int n = 0;
    public final AtomicInteger o = new AtomicInteger(0);
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public String y = "";
    public String z = "";
    public String A = "";
    public String D = "";
    public final HashMap F = new HashMap();
    public String G = "";
    public JSONObject H = null;
    public final ConcurrentHashMap K = new ConcurrentHashMap();
    public int L = 0;
    public int M = 0;
    public String P = "";
    public String Q = "";
    public String S = "";
    public int V = 0;
    public int W = 0;
    public int X = 0;
    public String Y = "";
    public String Z = "";
    public String a0 = "";
    public String b0 = "";
    public boolean d0 = !rd.a();
    public int o0 = 0;
    public int p0 = 0;
    public int s0 = 0;
    public int t0 = 0;
    public int w0 = 0;
    public String z0 = "";
    public String B0 = "";
    public boolean D0 = true;
    public long E0 = LongCompanionObject.MAX_VALUE;
    public int F0 = 0;
    public int G0 = 0;
    public final e L0 = new e();
    public Integer M0 = null;
    public int N0 = 1;
    public boolean O0 = false;
    public int P0 = 0;
    public int Q0 = -1;

    public p(int i, vh vhVar, boolean z, int[] iArr) {
        this.T0 = 1;
        this.a = i;
        this.c = vhVar;
        this.b = z;
        this.J = iArr;
        mh mhVar = vhVar.a;
        if (mhVar != null) {
            this.T0 = mhVar.a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x01ac  */
    public final void a(JSONObject jSONObject) {
        int i;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        int iOptInt;
        String strOptString;
        this.f = jSONObject.optInt("order");
        this.x = jSONObject.optString("timePosition");
        this.g = jSONObject.optInt("orderItemType");
        this.d = jSONObject.optInt("deliverType", 0);
        this.v = jSONObject.optString("creativeId", "");
        this.y = jSONObject.optString("templateType");
        this.B = jSONObject.optString("creativeType");
        this.w = jSONObject.optString("orderItemId", "");
        this.H = jSONObject.optJSONObject("creativeObject");
        jSONObject.optInt("guideShowDuration", 0);
        this.R = jSONObject.optInt("creativeOrientation", 1);
        this.x0 = jSONObject.optString("adnTokenKey");
        this.B0 = jSONObject.optString(IAction.PurchaseKey.Price, "");
        this.N0 = jSONObject.optInt("adnPriority", 1);
        this.P0 = jSONObject.optInt("iltst", this.P0);
        this.R0 = jSONObject.optJSONObject("taskConfig");
        this.Q0 = jSONObject.optInt("taskCountdown", this.Q0);
        JSONObject jSONObject2 = this.H;
        if (jSONObject2 != null) {
            boolean z = jSONObject2.optInt("videoSource") == 1;
            this.I = this.H.optString("renderType");
            String str = this.y;
            if (str != null && str.contains(MediationConstant.RIT_TYPE_INTERSTITIAL)) {
                if (TextUtils.equals("video", this.I)) {
                    strOptString = gj.a(this.H.optString("dynamicUrl"), z);
                    this.e = true;
                } else {
                    strOptString = TextUtils.equals(ImageViewManager.NAME, this.I) ? this.H.optString("portraitUrl") : "";
                }
                this.s0 = this.R == 2 ? 2 : 0;
            } else if ("mobile_flow_new".equals(this.y)) {
                this.I = ImageViewManager.NAME;
                strOptString = this.H.optString(BreakpointSQLiteKey.URL);
                this.s0 = this.R == 2 ? 2 : 0;
            } else if ("roll".equals(this.y)) {
                this.I = "video";
                String strA = gj.a(this.H.optString("m400Url"), z);
                this.y0 = gj.a(this.H.optString("gH265"), z);
                this.e = true;
                this.s0 = this.R == 2 ? 3 : 1;
                strOptString = strA;
            } else if ("common_pause".equals(this.y)) {
                String strOptString2 = this.H.optString(BreakpointSQLiteKey.URL);
                if (TextUtils.equals(ImageViewManager.NAME, this.I)) {
                    this.s0 = this.R == 2 ? 2 : 0;
                } else if (TextUtils.equals("video", this.I)) {
                    strOptString = gj.a(strOptString2, z);
                    this.e = true;
                    this.s0 = this.R == 2 ? 3 : 1;
                }
                strOptString = strOptString2;
            } else if ("banner_pic".equals(this.y)) {
                this.I = ImageViewManager.NAME;
                strOptString = this.H.optString(BreakpointSQLiteKey.URL);
                this.s0 = 5;
            } else {
                strOptString = "";
            }
            this.H.toString();
            if (!TextUtils.isEmpty(strOptString)) {
                this.G = gj.c(strOptString);
            } else if (!n()) {
                this.S = "no_url";
                return;
            }
        } else if (!n()) {
            this.S = "no_url";
            return;
        }
        this.A = jSONObject.optString("adPbCustomInfo");
        this.z = jSONObject.optString("lpSdkUrl", "");
        this.L = jSONObject.optInt("downloadToolType", 0);
        this.M = jSONObject.optInt("firstDownloadType", 0);
        this.N = jSONObject.optString("downloadPackageName");
        this.O = jSONObject.optString("downloadDeepLink");
        this.n = jSONObject.optInt("billingClickTimes");
        this.f0 = jSONObject.optString("autoOpenUrl");
        this.g0 = jSONObject.optString("dspName");
        this.h0 = jSONObject.optString("dspIcon");
        this.m = jSONObject.optLong("dspId");
        this.v0 = jSONObject.optString("adm");
        this.u0 = jSONObject.optString("adnCodeId");
        this.w0 = jSONObject.optInt("actionType");
        this.F0 = jSONObject.optInt("isMiniDrama", 0);
        this.E0 = (jSONObject.optLong("validTime", 600L) * 1000) + System.currentTimeMillis();
        this.i0 = gj.a(jSONObject.optJSONObject("transparentEventUrls"));
        this.q = jSONObject.optInt("needShowAppInfo", 0);
        this.r = jSONObject.optInt("downloadShowDialog", 0);
        this.T = Math.max(jSONObject.optInt("rewardTiming", 30), 0);
        this.U = jSONObject.optInt("clickRewardTiming", -1);
        this.V = jSONObject.optInt(QyRewardProperty.VERIFY_REWARD_AMOUNT, 0);
        this.W = jSONObject.optInt("extraRewardType", 0);
        int iOptInt2 = jSONObject.optInt("extraRewardCount", 0);
        this.X = iOptInt2;
        if (iOptInt2 <= 0) {
            this.W = 0;
        }
        this.Y = this.H.optString("exitDialogTitle", "");
        this.Z = this.H.optString("clickCountDownTitle");
        this.b0 = this.H.optString("rewardTitle");
        this.a0 = this.H.optString("rewardedCloseTitle", "");
        this.K0 = this.H.optString(QyRewardProperty.VERIFY_REWARD_MESSAGE);
        this.e0 = jSONObject.optInt("lastClickPoint", -1);
        this.j0 = jSONObject.optInt("priIndustryId");
        this.k0 = jSONObject.optString(QyRewardProperty.VERIFY_ALBUMID);
        this.l0 = jSONObject.optString("tvId");
        this.m0 = jSONObject.optString("playerLink");
        this.c0 = gj.a(jSONObject.optJSONArray("videoPlayerTimeOutConfig"));
        this.J = gj.a(jSONObject.optJSONArray("trackingTimeouts"));
        this.p0 = jSONObject.optInt("mWebViewDownloadInterceptor", 0);
        this.n0 = jSONObject.optString(QyRewardProperty.VERIFY_IMPRESSIONID, "");
        this.q0 = jSONObject.optInt("verifyByServer", 0);
        this.r0 = jSONObject.optInt("verifyAdvanceTime", DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS);
        this.z0 = jSONObject.optString("trackingExtInfo", "");
        this.G0 = jSONObject.optInt("fling", 0);
        this.I0 = jSONObject.optJSONObject("rsc");
        if (!TextUtils.isEmpty(this.z0) && !this.z0.endsWith(";")) {
            this.z0 += ";";
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("thirdHeader");
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject3 != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
            while (itKeys.hasNext()) {
                String strValueOf = String.valueOf(itKeys.next());
                map.put(strValueOf, jSONObjectOptJSONObject3.optString(strValueOf));
            }
        }
        this.J0 = map;
        String strOptString3 = this.H.optString("appName");
        this.P = strOptString3;
        if (lj.b(strOptString3)) {
            this.P = this.H.optString("account");
        }
        this.P = this.P;
        String strOptString4 = this.H.optString("appIcon");
        this.Q = strOptString4;
        if (lj.b(strOptString4)) {
            this.Q = this.H.optString("portrait");
        }
        this.Q = this.Q;
        String strOptString5 = jSONObject.optString("adConfigInfo", "");
        if (!TextUtils.isEmpty(strOptString5)) {
            try {
                this.o0 = new JSONObject(strOptString5).optInt("rewardPopStyle", 0);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("adExtras");
        w6 w6Var = null;
        if (jSONObjectOptJSONObject4 != null) {
            JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("appInfo");
            this.H0 = jSONObjectOptJSONObject5;
            if (jSONObjectOptJSONObject5 != null && jSONObjectOptJSONObject5.length() == 0) {
                this.H0 = null;
            }
            this.D = jSONObjectOptJSONObject4.toString();
        }
        this.E = jSONObject.optString("clickThroughUrl");
        String strOptString6 = jSONObject.optString("clickThroughType", "0");
        if ("0".equals(strOptString6) || "1".equals(strOptString6)) {
            i = 2;
        } else if ("11".equals(strOptString6)) {
            i = 3;
        } else if ("14".equals(strOptString6)) {
            i = 4;
        } else {
            i = "67".equals(strOptString6) ? 5 : 1;
        }
        this.S0 = i;
        if (2 == i && !n() && this.E.isEmpty() && !TextUtils.equals("html", this.I)) {
            this.S0 = 1;
        }
        this.h = jSONObject.optInt("duration", 0) * 1000;
        JSONObject jSONObject3 = this.H;
        if (jSONObject3 != null && (iOptInt = jSONObject3.optInt("duration", -1)) > 0) {
            this.h = iOptInt * 1000;
        }
        this.j = jSONObject.optInt("skipTime", 0) * 1000;
        String strOptString7 = jSONObject.optString("impressionTime");
        if (lj.b(strOptString7)) {
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("billingPoint");
            if (jSONObjectOptJSONObject6 != null) {
                this.k = jSONObjectOptJSONObject6.optInt("ap", 5) * 1000;
                this.l = jSONObjectOptJSONObject6.optInt("cp", 0) * 1000;
            }
        } else {
            try {
                if (strOptString7.contains("%")) {
                    int i2 = Integer.parseInt(strOptString7.replace("%", ""));
                    if (i2 >= 0) {
                        this.i = (this.h * i2) / 100;
                    }
                } else {
                    int i3 = Integer.parseInt(strOptString7);
                    if (i3 >= 0) {
                        this.i = i3 * 1000;
                    }
                }
            } catch (Exception e2) {
            }
        }
        this.F.put("thirdParty", new uj(jSONObject));
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("iqiyiTracking");
        if (jSONObjectOptJSONObject7 != null) {
            q4 q4VarA = bk.a("cupidTracking", jSONObjectOptJSONObject7);
            if (q4VarA != null) {
                this.F.put("cupidTracking", q4VarA);
            }
            q4 q4VarA2 = bk.a("adxTracking", jSONObjectOptJSONObject7);
            if (q4VarA2 != null) {
                this.F.put("adxTracking", q4VarA2);
            }
            q4 q4VarA3 = bk.a("qilinTracking", jSONObjectOptJSONObject7);
            if (q4VarA3 != null) {
                this.F.put("qilinTracking", q4VarA3);
            }
        }
        HashMap map2 = this.F;
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("gcp");
        if (jSONObjectOptJSONObject8 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject8.optJSONObject("param")) != null) {
            w6 w6Var2 = new w6();
            w6Var2.b = gj.a(jSONObjectOptJSONObject2);
            w6Var2.a = jSONObjectOptJSONObject8.optString(BreakpointSQLiteKey.URL, null);
            w6Var = w6Var2;
        }
        map2.put("rwp", w6Var);
        jSONObject.optInt("clickPromotion", 0);
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("liveData");
        if (jSONObjectOptJSONObject9 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject9.optJSONObject("coupon")) != null) {
            jSONObjectOptJSONObject.length();
        }
        try {
            if (jSONObject.has("actConfig")) {
                this.L0.a(jSONObject.optString("actConfig"));
            }
            if (jSONObject.has("uiConfig")) {
                this.L0.b(jSONObject.optString("uiConfig"));
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        if (this.T0 == 4) {
            p9.a.a(Integer.valueOf(this.a), "verify:", Integer.valueOf(this.q0), b(), jSONObject.optJSONObject("transparentEventUrls"), this.G);
        }
    }

    public final String b(int i) {
        StringBuilder sb = new StringBuilder();
        if (j.b(40, i)) {
            Object obj = this.K.get(v5.KEY_CLICK_AREA);
            z3 z3Var = (obj != null && (obj instanceof z3)) ? (z3) obj : null;
            if (z3Var != null) {
                sb.append("x:").append(z3Var.a).append(";");
            }
        } else if (j.b(46, i)) {
            sb.append("pg:").append(this.o).append(";");
        }
        if (th.a().b) {
            sb.append("devm:1;");
        }
        return sb.toString();
    }

    public final mh c() {
        vh vhVar = this.c;
        if (vhVar != null) {
            return vhVar.a;
        }
        return null;
    }

    public final synchronized boolean d(int i) {
        boolean z;
        char c;
        long j = this.s;
        z = true;
        switch (i) {
            case 1:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                c = 0;
                break;
            case 2:
                c = '(';
                break;
            case 3:
            case 70:
                c = 1;
                break;
            case 4:
            case 71:
                c = 2;
                break;
            case 5:
            case 72:
                c = 3;
                break;
            case 6:
            case 73:
                c = 4;
                break;
            case 7:
            case 74:
                c = 5;
                break;
            case 8:
            case 75:
                c = 6;
                break;
            case 9:
            case 76:
                c = 7;
                break;
            default:
                throw null;
        }
        long j2 = 1 << c;
        if ((j & j2) != 0) {
            z = false;
        }
        this.s = j | j2;
        return z;
    }

    public final synchronized boolean e(int i) {
        boolean z;
        int i2;
        long j = this.t;
        z = true;
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 8;
                break;
            case 5:
                i2 = 16;
                break;
            case 6:
                i2 = 32;
                break;
            case 7:
                i2 = 64;
                break;
            case 8:
                i2 = 128;
                break;
            case 9:
                i2 = 256;
                break;
            case 10:
                i2 = 512;
                break;
            case 11:
                i2 = 1024;
                break;
            case 12:
                i2 = 2048;
                break;
            case 13:
                i2 = 4096;
                break;
            case 14:
                i2 = 16384;
                break;
            case 15:
                i2 = 32768;
                break;
            default:
                throw null;
        }
        long j2 = i2;
        if ((j & j2) != 0) {
            z = false;
        }
        this.t = j | j2;
        return z;
    }

    public final float f() {
        Map map = this.C0;
        if (map == null) {
            return 0.0f;
        }
        Object obj = map.get(IAction.PurchaseKey.Price);
        AtomicInteger atomicInteger = gj.a;
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        try {
            return Float.parseFloat(String.valueOf(obj));
        } catch (Exception e) {
            return 0.0f;
        }
    }

    public final String g() {
        String strOptString;
        JSONObject jSONObject = this.H;
        if (jSONObject != null) {
            strOptString = jSONObject.optString("buttonTitle");
            if (j.b(4, this.S0) && e1.c(this.H.optString("apkName"))) {
                String strOptString2 = this.H.optString("dlButtonTitle");
                if (!TextUtils.isEmpty(strOptString2)) {
                    strOptString = strOptString2;
                } else if (!TextUtils.isEmpty(this.P)) {
                    strOptString = "去" + this.P;
                }
            }
        } else {
            strOptString = null;
        }
        if (lj.b(strOptString)) {
            return j.b(3, this.S0) ? "立即下载" : "了解详情";
        }
        return strOptString;
    }

    public final String h() {
        return this.e ? gj.c(this.H.optString("background")) : this.G;
    }

    public final JSONObject i() {
        JSONObject jSONObject = this.H;
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public final Map j() {
        if (this.A0 == null) {
            HashMap map = new HashMap();
            map.put(QyRewardProperty.VERIFY_IMPRESSIONID, this.n0);
            String strH = h();
            if (!TextUtils.isEmpty(strH)) {
                map.put("coverUrl", strH);
            }
            map.put(IAction.PurchaseKey.Price, this.B0);
            if (this.V > 0) {
                map.put(QyRewardProperty.VERIFY_REWARD_AMOUNT, "" + this.V);
            }
            if (!TextUtils.isEmpty(this.K0)) {
                map.put(QyRewardProperty.VERIFY_REWARD_MESSAGE, this.K0);
            }
            if (this.c.a.t > 0) {
                map.put("renderType", o() ? "VIDEO" : "IMAGE");
                map.put("creativeUrl", this.G);
                map.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, this.E);
                map.put("apkName", this.H.optString("apkName"));
                map.put(BundleKey.TITLE, this.H.optString(BundleKey.TITLE));
            }
            if (rd.a()) {
                map.put("canCache", this.g != 2 ? "1" : "0");
                map.put("adPbCustomInfo", b());
                map.put("orderItemType", "" + this.g);
                if (this.X > 0) {
                    map.put("extraRewardCount", "" + this.X);
                }
                String str = this.c.p;
                if (!TextUtils.isEmpty(str)) {
                    map.put("tunnel", str);
                }
                HashMap map2 = this.i0;
                Object obj = map2 != null ? map2.get(ak.a(5)) : null;
                if (obj != null) {
                    map.put("startUrl", String.valueOf(obj));
                }
                mh mhVarC = c();
                if (mhVarC != null) {
                    if (!TextUtils.isEmpty(mhVarC.q)) {
                        map.put("nextRequestAds", mhVarC.q);
                    }
                    if (!TextUtils.isEmpty(mhVarC.r)) {
                        map.put("firstAdIndex", mhVarC.r);
                    }
                    if (!TextUtils.isEmpty(mhVarC.s)) {
                        map.put("adInterval", mhVarC.s);
                    }
                }
                String strOptString = i().optString("futureTips");
                if (!TextUtils.isEmpty(strOptString)) {
                    map.put("futureTips", strOptString);
                }
                String strOptString2 = i().optString("futureTipsTitle");
                if (!TextUtils.isEmpty(strOptString2)) {
                    map.put("futureTipsTitle", strOptString2);
                }
                String strOptString3 = i().optString("futureTipsDuration");
                if (!TextUtils.isEmpty(strOptString3)) {
                    map.put("futureTipsDuration", strOptString3);
                }
            }
            this.A0 = map;
        }
        return this.A0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Double k() {
        double dDoubleValue;
        String str = this.B0;
        AtomicInteger atomicInteger = gj.a;
        if (str == 0) {
            dDoubleValue = 0.0d;
        } else if (str instanceof Double) {
            dDoubleValue = ((Double) str).doubleValue();
        } else {
            try {
                dDoubleValue = Double.parseDouble(str);
            } catch (Exception e) {
                dDoubleValue = 0.0d;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public final int l() {
        return Math.min(this.T, this.h / 1000);
    }

    public final synchronized boolean m() {
        return (this.t & ((long) 1)) != 0;
    }

    public final boolean n() {
        int i = this.g;
        return i == 4 || i == 8 || i == 7 || i == 5;
    }

    public final boolean o() {
        return this.e && !TextUtils.isEmpty(this.G);
    }

    public final boolean p() {
        JSONObject jSONObject;
        return this.q == 1 && (jSONObject = this.H0) != null && jSONObject.length() > 0;
    }

    public final String toString() {
        return "{i=" + this.a + ", order=" + this.f + ", cid='" + this.v + "'}";
    }

    public final synchronized Integer c(int i) {
        Integer num = this.M0;
        if (num != null) {
            return num;
        }
        e eVar = this.L0;
        if (eVar.a) {
            switch (i) {
                case 1:
                    this.M0 = Integer.valueOf(gj.b(eVar.e) ? 1 : 0);
                    break;
                case 2:
                    this.M0 = Integer.valueOf(gj.b(eVar.c) ? 1 : 0);
                    break;
                case 3:
                    this.M0 = Integer.valueOf(gj.b(eVar.k) ? 1 : 0);
                    break;
                case 4:
                    this.M0 = Integer.valueOf(gj.b(eVar.o) ? 1 : 0);
                    break;
            }
        }
        Integer num2 = this.M0;
        return Integer.valueOf(num2 == null ? -1 : num2.intValue());
    }

    public final String d() {
        String strA;
        if (!lj.b(this.C)) {
            return this.C;
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            if (!TextUtils.isEmpty(this.z0)) {
                jSONStringer.key("trackingExtInfo").value(this.z0);
            }
            int i = this.F0;
            if (i == 1 || i == 2) {
                jSONStringer.key("impression_id").value(this.n0);
                jSONStringer.key("album_id").value(this.F0 == 1 ? this.k0 : this.l0);
                jSONStringer.key("conversion").value(a(13));
            } else {
                jSONStringer.key("downloadToolType").value(this.L);
                jSONStringer.key("firstDownloadType").value(this.M);
                jSONStringer.key("downloadPackageName").value(this.N);
                jSONStringer.key("downloadDeepLink").value(this.O);
                jSONStringer.key("downloadStart").value(a(10));
                jSONStringer.key("downloaded").value(a(11));
                jSONStringer.key("installed").value(a(12));
                JSONStringer jSONStringerKey = jSONStringer.key("pingback");
                mh mhVarC = c();
                if (mhVarC == null) {
                    strA = "";
                } else {
                    ya yaVar = new ya(mhVarC);
                    yaVar.j = mhVarC.f;
                    yaVar.t = b();
                    yaVar.s = a();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(yaVar);
                    strA = za.a(arrayList);
                }
                jSONStringerKey.value(strA);
            }
            jSONStringer.endObject();
            String string = jSONStringer.toString();
            this.C = string;
            return string;
        } catch (Exception e) {
            r9.a("iad_ad", "getAdTunnelData(): ", e);
            return "";
        }
    }

    public final String e() {
        m0 m0Var;
        if (this.g == 7) {
            mh mhVarC = c();
            if (mhVarC != null) {
                String str = this.x0;
                ConcurrentHashMap concurrentHashMap = mhVarC.p;
                if (concurrentHashMap == null || (m0Var = (m0) concurrentHashMap.get(str)) == null) {
                    return null;
                }
                return m0Var.a;
            }
            return "";
        }
        return this.v0;
    }

    public final String b() {
        return "sspazId:" + this.c.i + ";sspadt:" + f0.b(this.T0) + ";" + this.A;
    }

    public final void b(Map map) {
        int iIndexOf;
        this.D0 = true;
        this.C0 = map;
        if (this.b || this.c.c == null) {
            return;
        }
        String strSubstring = this.x;
        AtomicInteger atomicInteger = gj.a;
        if (strSubstring != null && -1 != (iIndexOf = strSubstring.indexOf(","))) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        for (p pVar : this.c.c) {
            String str = pVar.x;
            if (str != null && str.contains(strSubstring)) {
                pVar.b(map);
            }
        }
    }

    public final String a() {
        return (this.c.g + "||" + this.m + "||" + this.w + "||" + this.v + "||") + (!lj.b(this.y) ? this.y : this.B);
    }

    public final String a(v5 v5Var) {
        Object obj = this.K.get(v5Var);
        if (obj == null) {
            return "";
        }
        if (obj instanceof z3) {
            return ((z3) obj).a;
        }
        return String.valueOf(obj);
    }

    public final synchronized void a(long j) {
        this.u = j;
    }

    public final JSONObject a(int i) throws JSONException {
        List listA;
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : this.F.entrySet()) {
            s7 s7Var = (s7) entry.getValue();
            if (s7Var != null && (listA = s7Var.a(i, this)) != null && !listA.isEmpty()) {
                String str = (String) entry.getKey();
                AtomicInteger atomicInteger = gj.a;
                try {
                    if (listA.isEmpty()) {
                        jSONArray = null;
                    } else {
                        jSONArray = new JSONArray();
                        Iterator it = listA.iterator();
                        while (it.hasNext()) {
                            jSONArray.put((String) it.next());
                        }
                    }
                } catch (Exception e) {
                    r9.a("ssp_sdk", "generateJsonArray(): ", e);
                }
                jSONObject.putOpt(str, jSONArray);
            }
        }
        return jSONObject;
    }

    public final void a(Map map) {
        int iIndexOf;
        this.D0 = false;
        this.C0 = map;
        if (this.b || this.c.c == null) {
            return;
        }
        String strSubstring = this.x;
        AtomicInteger atomicInteger = gj.a;
        if (strSubstring != null && -1 != (iIndexOf = strSubstring.indexOf(","))) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        for (p pVar : this.c.c) {
            String str = pVar.x;
            if (str != null && str.contains(strSubstring)) {
                pVar.a(map);
            }
        }
    }
}
