package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyCustomMade;
import com.mcto.sspsdk.QyLocation;
import com.mcto.sspsdk.QySdk;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.DownloadTask;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements i7 {
    public static final HashMap k;
    public final QyAdSlot a;
    public final int b;
    public final boolean c;
    public final int d;
    public int[] e;
    public final String f;
    public final String g;
    public final f7 h;
    public String i;
    public int j = 0;

    static {
        HashMap map = new HashMap();
        k = map;
        map.put("from_impression_id", "iiae");
        map.put("vv_from", "vfs");
        map.put("tvToken", "tvtk");
        map.put("taskGuid", "tvtu");
        map.put("encryptedUid", "tveu");
        map.put("ivps", "ivps");
        map.put("ik_bookid", "bid");
        map.put("playerType", "plt");
        map.put("ipt", "ipt");
        map.put(AnalyticsConfig.RTD_START_TIME, "st");
        map.put("sequenceId", "si");
        map.put("tc", "tc");
        map.put("exts", "exts");
        map.put("isLogin", "iln");
        map.put("filterAd", "flt");
        map.put("goldCoinSwitch", "gcs");
    }

    public c0(b0 b0Var) {
        this.a = b0Var.a;
        this.h = b0Var.b;
        this.f = b0Var.c;
        this.b = b0Var.d;
        this.g = b0Var.e;
        this.e = b0Var.g;
        this.d = b0Var.f;
        this.c = b0Var.h;
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(String str, h7 h7Var) {
        int length = str.length();
        if (length > 2000) {
            int i = 0;
            while (i < length) {
                int i2 = i + DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
                str.substring(i, Math.min(i2, length));
                i = i2;
            }
        }
        a(str, h7Var, true);
        if (h4.i == 0) {
            return;
        }
        h4.i = 0;
        nh.a(jd.a).a("iad_dev", "dmec", "0");
    }

    public final void b() {
        String strA;
        JSONArray jSONArray;
        int length;
        QyAdSlot qyAdSlot = this.a;
        if (qyAdSlot == null || this.h == null || this.b == 0) {
            a((vh) null, 6, "QyAdSlot or callback is null ");
            return;
        }
        qyAdSlot.getCodeId();
        if (j.b(this.b, 7)) {
            this.a.b();
            this.a.a();
        }
        boolean z = rd.a;
        QyAdSlot qyAdSlot2 = this.a;
        HashMap map = new HashMap();
        try {
            String mediaExtra = qyAdSlot2.getMediaExtra();
            if (!TextUtils.isEmpty(mediaExtra)) {
                JSONObject jSONObject = new JSONObject(mediaExtra);
                for (Map.Entry entry : k.entrySet()) {
                    String strOptString = jSONObject.optString((String) entry.getKey());
                    if (!lj.b(strOptString)) {
                        map.put(entry.getValue(), strOptString);
                    }
                }
                String strOptString2 = jSONObject.optString("videoEventId");
                if (!lj.b(strOptString2)) {
                    qyAdSlot2.b(strOptString2);
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("tunnelAdP"));
                    map.put("exts", jSONObject2.optString("exts"));
                    map.putAll(gj.a(new JSONObject(jSONObject2.optString("mq"))));
                } catch (Exception e) {
                }
            }
        } catch (JSONException e2) {
        }
        this.j = gj.a(map.get("st"), 0);
        String strA2 = a(this.b, this.a, this.f, map, this.g, z, this.d);
        if (this.e == null) {
            int[] iArr = h4.h;
            if (iArr == null) {
                String strA3 = nh.a(jd.a).a("dmto");
                try {
                    if (!TextUtils.isEmpty(strA3) && (length = (jSONArray = new JSONArray(strA3)).length()) > 0) {
                        int[] iArr2 = new int[length];
                        for (int i = 0; i < length; i++) {
                            iArr2[i] = jSONArray.optInt(i);
                        }
                        h4.h = iArr2;
                    }
                } catch (JSONException e3) {
                    r9.a("ssp_sdk", "getTimeout: ", e3);
                    h4.h = null;
                }
                iArr = h4.h;
                if (iArr == null) {
                    iArr = new int[]{5000, 10000};
                    h4.h = iArr;
                }
            }
            this.e = iArr;
        }
        bg bgVar = new bg();
        bgVar.c = TapHttp.METHOD_GET;
        bgVar.g = this.e;
        if (strA2 != null) {
            bgVar.b = strA2;
        }
        bgVar.a = z;
        bgVar.d = this.f;
        bgVar.e = this;
        cg cgVar = new cg(bgVar);
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (lj.b(h4.g)) {
                strA = nh.a(jd.a).a("dck");
                h4.g = strA;
            } else {
                strA = h4.g;
            }
            if (!TextUtils.isEmpty(strA)) {
                jSONObject3.putOpt("ck", strA);
            }
            if (this.c) {
                Pair pairA = ik.a().a(a());
                this.i = (String) pairA.first;
                Object obj = pairA.second;
                if (obj != null) {
                    jSONObject3.putOpt("adnToken", obj);
                }
            }
            if (jSONObject3.length() > 0) {
                cgVar.l = lj.a(jSONObject3.toString());
                cgVar.i = "application/json; charset=UTF-8";
                cgVar.h = TapHttp.METHOD_POST;
            }
        } catch (JSONException e4) {
            r9.a("ssp_sdk", "request url.", e4);
        }
        c7 c7VarA = c7.a();
        c7VarA.getClass();
        ih.a.a(new b7(c7VarA, cgVar));
    }

    public final ArrayList a() {
        String codeId;
        ArrayList arrayList = new ArrayList(1);
        if (j.b(7, this.b)) {
            codeId = f0.a(this.b);
        } else {
            codeId = this.a.getCodeId();
        }
        e0 e0Var = new e0(codeId, this.a.getVideoAdOrientation() != 1 ? 0 : 1);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(this.a.getMediaExtra()).optJSONObject("adnCodeIdRule");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("adnAdDropNewUser")) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("adnAdDropNewUser");
                AtomicInteger atomicInteger = gj.a;
                HashMap map = new HashMap();
                if (jSONObjectOptJSONObject2 != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String strValueOf = String.valueOf(itKeys.next());
                        map.put(strValueOf, jSONObjectOptJSONObject2.optString(strValueOf));
                    }
                }
                e0Var.c = map;
            }
        } catch (Exception e) {
        }
        arrayList.add(e0Var);
        return arrayList;
    }

    public static String a(int i, QyAdSlot qyAdSlot, String str, HashMap map, String str2, boolean z, int i2) {
        String strReplace;
        String strA;
        String str3;
        String str4;
        String str5;
        int adCount;
        int i3;
        String str6;
        String userType;
        int appMode;
        String userType2;
        String strValueOf;
        String strValueOf2;
        QyLocation qyLocation;
        QyLocation qyLocation2;
        HashMap map2 = new HashMap(128);
        boolean zA = rd.a();
        y4 y4Var = y4.r;
        map2.put("n", y4Var.e());
        map2.put("e", y4Var.c());
        map2.put("nw", ha.a());
        map2.put("lag", Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry().toLowerCase());
        map2.put("cpu", y4.a());
        map2.put("imei", gj.d(y4Var.g()));
        map2.put("aid", y4Var.b());
        map2.put("mac", y4Var.h());
        map2.put(com.umeng.analytics.pro.z.t, Integer.valueOf(y4.d()));
        map2.put("m", Build.MODEL.toLowerCase());
        int i4 = y4Var.a;
        if (i4 == -1) {
            y4Var.l();
            i4 = y4Var.a;
        }
        map2.put("q", Integer.valueOf(i4));
        String str7 = y4Var.j;
        if (str7 == null) {
            y4Var.l();
            str7 = y4Var.j;
        }
        map2.put("res", str7);
        map2.put("os", Build.VERSION.RELEASE);
        map2.put("an", jd.a.getPackageName());
        if (!"1".equals(ha.a())) {
            strReplace = "";
        } else if (!TextUtils.isEmpty(y4Var.l)) {
            strReplace = y4Var.l;
        } else {
            QyCustomMade qyCustomMade = rd.d;
            if (qyCustomMade != null && !qyCustomMade.isCanUsePhoneWifiSSID()) {
                String wifiSSID = rd.d.getWifiSSID();
                y4Var.l = wifiSSID;
                strReplace = TextUtils.isEmpty(wifiSSID) ? "" : y4Var.l;
            } else {
                try {
                    WifiManager wifiManager = (WifiManager) jd.a.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
                    if (wifiManager != null) {
                        strReplace = wifiManager.getConnectionInfo().getSSID().replace("\"", "");
                        if ("<unknown ssid>".equals(strReplace)) {
                        }
                        y4Var.l = strReplace;
                    }
                    strReplace = "";
                } catch (Exception e) {
                    e.getMessage();
                    strReplace = "";
                }
                y4Var.l = strReplace;
            }
        }
        map2.put("wn", strReplace);
        y4 y4Var2 = y4.r;
        map2.put("cpmf", Build.BRAND.toLowerCase());
        if (TextUtils.isEmpty(y4Var2.k)) {
            y4Var2.k = nh.a(jd.a).a("dsua");
        }
        map2.put("sua", y4Var2.k);
        QyCustomMade qyCustomMade2 = rd.d;
        map2.put("oaid", qyCustomMade2 != null ? qyCustomMade2.getOaid() : null);
        if (!lj.b(h4.f)) {
            strA = h4.f;
        } else {
            strA = nh.a(jd.a).a("dims");
            h4.f = strA;
        }
        map2.put("ims", strA);
        QyCustomMade qyCustomMade3 = rd.d;
        if (qyCustomMade3 != null && (qyLocation2 = qyCustomMade3.getQyLocation()) != null) {
            str3 = "" + qyLocation2.mLongitude;
        } else {
            str3 = "";
        }
        map2.put("lgt", str3);
        QyCustomMade qyCustomMade4 = rd.d;
        if (qyCustomMade4 != null && (qyLocation = qyCustomMade4.getQyLocation()) != null) {
            str4 = "" + qyLocation.mLatitude;
        } else {
            str4 = "";
        }
        map2.put("ltt", str4);
        map2.put(an.aE, "0");
        map2.put("iiq", Integer.valueOf(e1.c("com.qiyi.video") ? 1 : 0));
        map2.put("r", QySdk.SDK_VERSION);
        map2.put(an.aC, "gphone");
        map2.put("dpi", Integer.valueOf(hk.a(jd.a)));
        map2.put("tt", rd.e ? "1" : null);
        map2.put("skt", 1);
        map2.put("otp", y4Var2.m);
        map2.put("hmv", y4Var2.n);
        map2.put("hmpm", Integer.valueOf(y4Var2.c));
        map2.put("nva", 1);
        map2.put("tck", 3);
        if (y4Var2.o == null) {
            try {
                PackageInfo packageInfoA = e1.a("com.huawei.appmarket");
                strValueOf2 = packageInfoA == null ? "" : String.valueOf(packageInfoA.versionCode);
            } catch (Exception e2) {
                strValueOf2 = "";
            }
            y4Var2.o = strValueOf2;
        }
        map2.put("agv", y4Var2.o);
        if (y4Var2.p == null) {
            try {
                PackageInfo packageInfoA2 = e1.a("com.huawei.hwid");
                strValueOf = packageInfoA2 == null ? "" : String.valueOf(packageInfoA2.versionCode);
            } catch (Exception e3) {
                strValueOf = "";
            }
            y4Var2.p = strValueOf;
        }
        map2.put("hmsv", y4Var2.p);
        map2.put("sevl", 1);
        if (j.b(3, i)) {
            map2.put("ipre", qyAdSlot.isSupportPreRequest() ? 1 : "");
            map2.put("oris", nh.a(jd.a).a.getSharedPreferences("iad_spa", 0).getString("csalio", ""));
            if (zA) {
                map2.put("bfs", Integer.valueOf(nh.a(jd.a).a() ? 1 : 0));
                str5 = "";
            } else {
                str5 = "";
            }
        } else if (j.b(2, i)) {
            if (i2 == 0) {
                adCount = 1;
            } else {
                adCount = qyAdSlot.getAdCount();
            }
            map2.put("lm", Integer.valueOf(adCount));
            map2.put("sk", Integer.valueOf(qyAdSlot.e()));
            qyAdSlot.a(adCount);
            if (zA) {
                map2.put("azt", qyAdSlot.getCodeId());
                str5 = "";
            } else {
                long channelId = qyAdSlot.getChannelId();
                if (channelId == Long.MIN_VALUE) {
                    str5 = "";
                } else {
                    map2.put("scid", Long.valueOf(channelId));
                    str5 = "";
                }
            }
        } else {
            if (!j.b(4, i)) {
                str5 = "";
                if (!j.b(5, i)) {
                    if (j.b(6, i) && zA) {
                        map2.put("lm", Integer.valueOf(qyAdSlot.getAdCount()));
                        map2.put("azt", qyAdSlot.getCodeId());
                    } else if (j.b(7, i)) {
                        map2.put("plt", Integer.valueOf(qyAdSlot.getVideoAdOrientation() == 1 ? 1 : 0));
                        map2.put("rix", Integer.valueOf(qyAdSlot.f()));
                        map2.put("pt", Integer.valueOf(qyAdSlot.e()));
                        map2.put("si", 0);
                        map2.put("rylh", "1");
                    } else if (j.b(8, i)) {
                        map2.put("lm", 1);
                        if (zA) {
                            map2.put("azt", qyAdSlot.getCodeId());
                        }
                    } else if (j.b(11, i)) {
                        map2.put("sk", Integer.valueOf(qyAdSlot.e()));
                        map2.put("azt", qyAdSlot.getCodeId());
                    }
                }
            } else {
                str5 = "";
            }
            map2.put("rm", qyAdSlot.i() ? "0" : str5);
            if (j.b(4, i)) {
                map2.put("lm", 1);
            }
            if (zA) {
                map2.put("azt", qyAdSlot.getCodeId());
                map2.put("rat", Integer.valueOf(qyAdSlot.getRewardAmount()));
            }
            map2.put("plt", Integer.valueOf(qyAdSlot.getVideoAdOrientation() == 1 ? 1 : 0));
        }
        if (zA) {
            map2.put("y", f0.a(i));
            map2.put("d", rd.f);
            QyCustomMade qyCustomMade5 = rd.d;
            map2.put("iqid", qyCustomMade5 != null ? qyCustomMade5.getIqid() : null);
            QyCustomMade qyCustomMade6 = rd.d;
            map2.put("dfp", qyCustomMade6 != null ? qyCustomMade6.getDeviceFingerprint() : null);
            QyCustomMade qyCustomMade7 = rd.d;
            map2.put("l", qyCustomMade7 != null ? qyCustomMade7.getChannelId() : null);
            map2.put("sei", qyAdSlot.g());
            QyCustomMade qyCustomMade8 = rd.d;
            if (qyCustomMade8 == null) {
                userType = null;
            } else {
                userType = qyCustomMade8.getUserType();
                if ("-1".equals(userType)) {
                    userType = null;
                }
            }
            if (!TextUtils.isEmpty(userType)) {
                QyCustomMade qyCustomMade9 = rd.d;
                if (qyCustomMade9 == null) {
                    userType2 = null;
                } else {
                    userType2 = qyCustomMade9.getUserType();
                    if ("-1".equals(userType2)) {
                        userType2 = null;
                    }
                }
                map2.put("vpts", userType2);
                map2.put(an.aE, 1);
                appMode = 0;
            } else {
                appMode = 0;
                map2.put(an.aE, 0);
            }
            QyCustomMade qyCustomMade10 = rd.d;
            map2.put("pi", qyCustomMade10 != null ? qyCustomMade10.getUserId() : null);
            QyCustomMade qyCustomMade11 = rd.d;
            map2.put("pc", qyCustomMade11 != null ? qyCustomMade11.getUserCookie() : null);
            map2.put("b", qyAdSlot.getVideoId());
            map2.put(an.aG, qyAdSlot.getAlbumId());
            QyCustomMade qyCustomMade12 = rd.d;
            if (qyCustomMade12 != null) {
                appMode = qyCustomMade12.getAppMode();
            }
            if (appMode >= 1) {
                map2.put("pm", Integer.valueOf(appMode));
            }
            long channelId2 = qyAdSlot.getChannelId();
            if (channelId2 != Long.MIN_VALUE) {
                map2.put("k", Long.valueOf(channelId2));
            }
            QyCustomMade qyCustomMade13 = rd.d;
            if (qyCustomMade13 != null) {
                map2.put("pas", qyCustomMade13.getPersonalAdSwitch() != null ? rd.d.getPersonalAdSwitch() : "0");
                map2.put("xas", rd.d.getAdxAdSwitch() != null ? rd.d.getAdxAdSwitch() : "1");
            }
            HashMap map3 = rd.h;
            map2.put("wxav", map3.get("wxav"));
            map2.put("wxov", map3.get("wxov"));
            map2.put("utg", map3.get("user_tag"));
            map2.put("nut", map3.get("new_user_type"));
            if (map != null) {
                map2.putAll(map);
            }
        } else {
            map2.put("y", Integer.valueOf(f0.b(i)));
            map2.put("azd", qyAdSlot.getCodeId());
            map2.put("sdp", qyAdSlot.isSupportDeepLink() ? 1 : str5);
            map2.put("apid", rd.f);
            map2.put("svid", qyAdSlot.getVideoId());
        }
        if (j.b(9, i)) {
            if (zA) {
                map2.put("azt", qyAdSlot.getCodeId());
            }
        } else if (j.b(10, i)) {
            if (zA) {
                map2.put("azt", qyAdSlot.getCodeId());
            } else {
                map2.put("apid", "1781259566941574");
            }
        }
        if (z) {
            String str8 = gj.a((Map) map2, "&", "=", true) + (lj.b(str2) ? str5 : "&" + str2);
            map2.clear();
            map2.put("ee", gj.b(20, str8, str));
            map2.put("ev", 1);
        }
        map2.put("ys", Integer.valueOf(f0.b(i) + i2));
        map2.put("enc", 1);
        map2.put("assd", "true");
        map2.put(an.av, y4Var2.i());
        map2.put("ea", 1);
        map2.put("o", qyAdSlot.h());
        map2.put("rid", str);
        if (!th.a().b) {
            i3 = 1;
        } else {
            i3 = 1;
            map2.put("devm", 1);
        }
        if (!zA) {
            map2.put("ql", Integer.valueOf(i3));
            try {
                Context context = jd.a;
                if (context != null) {
                    v4 v4VarA = v4.a(context);
                    map2.put("nrd", Integer.valueOf(v4VarA.b(qyAdSlot.getCodeId())));
                    map2.put("csc", Integer.valueOf(v4VarA.b()));
                }
            } catch (Throwable th) {
            }
        }
        if (!lj.b(h4.a)) {
            str6 = h4.a;
        } else {
            String strA2 = nh.a(jd.a).a("dmu");
            h4.a = strA2;
            if (!lj.b(strA2)) {
                str6 = h4.a;
            } else {
                str6 = "https://t7z.cupid.iqiyi.com/mixer";
                h4.a = "https://t7z.cupid.iqiyi.com/mixer";
            }
        }
        String strReplace2 = rd.b ? str6 : str6.replace("https://", "http://");
        if (!lj.b(null)) {
            try {
                Uri uri = Uri.parse(strReplace2);
                Uri.Builder builderBuildUpon = uri.buildUpon();
                if (uri.getPort() == -1) {
                    builderBuildUpon.authority(null);
                    strReplace2 = builderBuildUpon.build().toString();
                } else {
                    throw null;
                }
            } catch (Exception e4) {
                r9.a("ssp_AdProvider", "Failed to replace test host in URL: ", e4);
            }
        }
        if (z) {
            return strReplace2 + "?" + gj.a((Map) map2, "&", "=", true);
        }
        return strReplace2 + "?" + gj.a((Map) map2, "&", "=", true) + (lj.b(str2) ? str5 : "&" + str2);
    }

    public final void a(String str, h7 h7Var, boolean z) {
        String strA;
        vh vhVarA;
        ArrayList arrayList;
        mh mhVar = new mh((gj.a.addAndGet(1) % 524287) << 12, this.a.h(), this.f);
        mhVar.c = z;
        int i = this.b;
        mhVar.a = i;
        if (j.b(3, i)) {
            nh.a(jd.a).a("iad_spa", "csalio", "");
        }
        try {
            vhVarA = d0.a(str, mhVar);
            strA = "";
        } catch (Exception e) {
            r9.a("ssp_AdProvider", "onSuccess: ", e);
            strA = r9.a(e);
            vhVarA = null;
        }
        if (vhVarA == null) {
            a(vhVarA, 2, strA);
            a(30, strA, h7Var, null, mhVar, str);
            return;
        }
        vhVarA.n = this.j;
        this.a.a(mhVar.i);
        if (this.b == 11 && (arrayList = vhVarA.c) != null) {
            this.a.a(arrayList.size());
        }
        if (vhVarA.e != 0) {
            f7 f7Var = this.h;
            if (f7Var != null) {
                try {
                    f7Var.a(vhVarA);
                } catch (Exception e2) {
                    r9.a("ssp_AdProvider", "request Error: ", e2);
                }
            }
            a(27, "", h7Var, vhVarA, mhVar, str);
            return;
        }
        String strA2 = gj.a((Map) vhVarA.j, ";", ":", true);
        if (TextUtils.isEmpty(strA2) && vhVarA.c == null) {
            a(vhVarA, 3, mhVar.j);
            a(27, "no_slot", h7Var, vhVarA, mhVar, str);
        } else {
            if (!TextUtils.isEmpty(strA2)) {
                a(vhVarA, 4, strA2);
                a(27, "invalid_ad", h7Var, vhVarA, mhVar, str);
            } else {
                a(vhVarA, 5, strA2);
                a(27, "no_ad", h7Var, vhVarA, mhVar, str);
            }
            this.a.getClass();
            zj zjVarA = zj.a();
            zjVarA.getClass();
            ArrayList<p> arrayList2 = vhVarA.c;
            if (arrayList2 != null && vhVarA.l != 1) {
                for (p pVar : arrayList2) {
                    if (pVar.e(1)) {
                        zjVarA.a(1, pVar, "cupidTracking");
                    }
                }
            }
        }
        za.d().getClass();
        za.a(mhVar);
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0143  */
    /* JADX WARN: Code duplicated, block: B:64:0x0145  */
    /* JADX WARN: Code duplicated, block: B:67:0x014d  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:71:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:75:0x0201  */
    public final void a(int i, String str, h7 h7Var, vh vhVar, mh mhVar, String str2) {
        String string;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        String str3;
        String str4;
        String str5;
        int i2 = this.b;
        String codeId = this.a.getCodeId();
        HashMap map = new HashMap();
        if (vhVar != null) {
            map.put("ems", gj.a((Map) vhVar.j, ";", ":", true));
            map.put("rc", Integer.valueOf(vhVar.e));
            if (this.d == 100 && j.b(2, this.b)) {
                map.put("rqc", Integer.valueOf(this.a.getAdCount()));
            } else {
                map.put("rqc", 1);
            }
            map.put("rpc", Integer.valueOf(vhVar.k));
        }
        String str6 = this.i;
        if (vhVar != null) {
            ArrayList arrayList = vhVar.b;
            JSONObject jSONObject = vhVar.o;
            if ((arrayList != null && !arrayList.isEmpty()) || (jSONObject != null && jSONObject.length() != 0)) {
                JSONStringer jSONStringer = new JSONStringer();
                HashSet hashSet = new HashSet();
                try {
                    jSONStringer.array();
                    if (arrayList == null) {
                        str6 = str6;
                    } else {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            p pVar = (p) it.next();
                            Iterator it2 = it;
                            String str7 = pVar.x;
                            hashSet.add(str7);
                            jSONStringer.object();
                            str6 = str6;
                            try {
                                jSONStringer.key("ord").value(pVar.w);
                                jSONStringer.key(an.ax).value(pVar.k());
                                jSONStringer.key("w").value(str7);
                                if (jSONObject != null && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject(str7)) != null) {
                                    vh.a(jSONObjectOptJSONObject2, jSONStringer);
                                }
                                jSONStringer.endObject();
                                it = it2;
                                str6 = str6;
                            } catch (Exception e) {
                                e = e;
                                r9.a("ssp_sdk", "mergeAdDetailInfo error", e);
                                string = jSONStringer.toString();
                                str3 = "";
                                if (vhVar == null) {
                                    str4 = "";
                                } else {
                                    str4 = vhVar.i;
                                }
                                if (TextUtils.isEmpty(codeId)) {
                                    codeId = f0.a(i2);
                                }
                                za zaVarD = za.d();
                                zaVarD.getClass();
                                ya yaVar = new ya(mhVar);
                                yaVar.a = ab.b(i);
                                yaVar.q = ab.a(i);
                                yaVar.j = mhVar.f;
                                yaVar.r = gj.f(str) + "||" + gj.f(mhVar.j);
                                yaVar.n = h7Var.b;
                                yaVar.o = h7Var.a;
                                yaVar.z = gj.a((Map) map, ";", ":", true);
                                yaVar.t = "sspazId:" + codeId + ";sspadt:" + f0.b(i2) + ";y:" + codeId + ";stni:" + str6;
                                yaVar.A = string;
                                StringBuilder sbAppend = new StringBuilder("azId:").append(str4).append(";devm:");
                                if (th.a().b) {
                                    str5 = "1;";
                                } else {
                                    str5 = "0;";
                                }
                                StringBuilder sbAppend2 = sbAppend.append(str5);
                                if (!TextUtils.isEmpty(mhVar.k)) {
                                    str3 = mhVar.k;
                                }
                                yaVar.x = sbAppend2.append(str3).toString();
                                zaVarD.a(mhVar.d, "mixer", yaVar);
                                q9 q9Var = p9.a;
                                String str8 = mhVar.f;
                                q9Var.getClass();
                                eh.a.a(new k9(str8, str2));
                            }
                        }
                        str6 = str6;
                    }
                    if (jSONObject != null) {
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            if (!hashSet.contains(next) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(next)) != null && jSONObjectOptJSONObject.length() > 0) {
                                jSONStringer.object();
                                jSONStringer.key("w").value(next);
                                vh.a(jSONObjectOptJSONObject, jSONStringer);
                                jSONStringer.endObject();
                            }
                        }
                    }
                    jSONStringer.endArray();
                } catch (Exception e2) {
                    e = e2;
                    str6 = str6;
                }
                string = jSONStringer.toString();
            }
            str3 = "";
            if (vhVar == null) {
                str4 = "";
            } else {
                str4 = vhVar.i;
            }
            if (TextUtils.isEmpty(codeId)) {
                codeId = f0.a(i2);
            }
            za zaVarD2 = za.d();
            zaVarD2.getClass();
            ya yaVar2 = new ya(mhVar);
            yaVar2.a = ab.b(i);
            yaVar2.q = ab.a(i);
            yaVar2.j = mhVar.f;
            yaVar2.r = gj.f(str) + "||" + gj.f(mhVar.j);
            yaVar2.n = h7Var.b;
            yaVar2.o = h7Var.a;
            yaVar2.z = gj.a((Map) map, ";", ":", true);
            yaVar2.t = "sspazId:" + codeId + ";sspadt:" + f0.b(i2) + ";y:" + codeId + ";stni:" + str6;
            yaVar2.A = string;
            StringBuilder sbAppend3 = new StringBuilder("azId:").append(str4).append(";devm:");
            if (th.a().b) {
                str5 = "1;";
            } else {
                str5 = "0;";
            }
            StringBuilder sbAppend4 = sbAppend3.append(str5);
            if (!TextUtils.isEmpty(mhVar.k)) {
                str3 = mhVar.k;
            }
            yaVar2.x = sbAppend4.append(str3).toString();
            zaVarD2.a(mhVar.d, "mixer", yaVar2);
            q9 q9Var2 = p9.a;
            String str9 = mhVar.f;
            q9Var2.getClass();
            eh.a.a(new k9(str9, str2));
        }
        string = null;
        str3 = "";
        if (vhVar == null) {
            str4 = "";
        } else {
            str4 = vhVar.i;
        }
        if (TextUtils.isEmpty(codeId)) {
            codeId = f0.a(i2);
        }
        za zaVarD3 = za.d();
        zaVarD3.getClass();
        ya yaVar3 = new ya(mhVar);
        yaVar3.a = ab.b(i);
        yaVar3.q = ab.a(i);
        yaVar3.j = mhVar.f;
        yaVar3.r = gj.f(str) + "||" + gj.f(mhVar.j);
        yaVar3.n = h7Var.b;
        yaVar3.o = h7Var.a;
        yaVar3.z = gj.a((Map) map, ";", ":", true);
        yaVar3.t = "sspazId:" + codeId + ";sspadt:" + f0.b(i2) + ";y:" + codeId + ";stni:" + str6;
        yaVar3.A = string;
        StringBuilder sbAppend5 = new StringBuilder("azId:").append(str4).append(";devm:");
        if (th.a().b) {
            str5 = "1;";
        } else {
            str5 = "0;";
        }
        StringBuilder sbAppend6 = sbAppend5.append(str5);
        if (!TextUtils.isEmpty(mhVar.k)) {
            str3 = mhVar.k;
        }
        yaVar3.x = sbAppend6.append(str3).toString();
        zaVarD3.a(mhVar.d, "mixer", yaVar3);
        q9 q9Var3 = p9.a;
        String str10 = mhVar.f;
        q9Var3.getClass();
        eh.a.a(new k9(str10, str2));
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(h7 h7Var) {
        mh mhVar = new mh((gj.a.addAndGet(1) % 524287) << 12, this.a.h(), this.f);
        if (-4 == h7Var.c) {
            a((vh) null, 1, "http time out");
            a(29, "http_time_out_" + h7Var.c, h7Var, null, mhVar, "http_time_out null");
        } else {
            a((vh) null, 1, "http error");
            a(28, "http_error_" + h7Var.c, h7Var, null, mhVar, "http_error null");
        }
        int i = h4.i + 1;
        h4.i = i;
        if (i >= 20) {
            h4.i = 0;
            h4.a = "https://t7z.cupid.iqiyi.com/mixer";
            HashMap map = new HashMap(2);
            map.put("dmu", "https://t7z.cupid.iqiyi.com/mixer");
            map.put("dmec", "" + h4.i);
            nh.a(jd.a).a(map);
        }
    }

    public final void a(vh vhVar, int i, String str) {
        f7 f7Var = this.h;
        if (f7Var == null) {
            return;
        }
        try {
            f7Var.a(vhVar, i, str);
        } catch (Exception e) {
            r9.a("ssp_AdProvider", "request Error: ", e);
        }
    }
}
