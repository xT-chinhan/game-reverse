package com.smartdigimkt.a4;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.smartdigimkt.a3.d;
import com.smartdigimkt.o4.e;
import com.smartdigimkt.q2.g;
import com.smartdigimkt.r3.c;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.i;
import com.smartdigimkt.r4.j;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.r4.z;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.api.SDMUserDeviceInfo;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.bridge.entity.AppInfoEntity;
import com.smartdigimkt.v2.p;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static int a = -1;
    public static int b = -1;
    public static volatile JSONObject c;
    public static volatile JSONObject d;

    public static JSONObject a(int i, com.smartdigimkt.h3.b bVar, String str) {
        String str2;
        boolean z;
        boolean z2;
        NetworkInfo networkInfo;
        String str3;
        String strValueOf;
        String str4;
        ConcurrentHashMap concurrentHashMap;
        com.smartdigimkt.p4.a aVarA;
        h.w(SDKContext.getInstance().d());
        Context contextD = SDKContext.getInstance().d();
        if (contextD == null) {
            contextD = c.a().j;
        }
        JSONObject jSONObjectA = c;
        if (jSONObjectA == null) {
            synchronized (a.class) {
                jSONObjectA = c;
                if (jSONObjectA == null) {
                    jSONObjectA = a(contextD);
                    if (contextD != null) {
                        c = jSONObjectA;
                    }
                }
            }
        }
        JSONObject jSONObjectB = b(jSONObjectA);
        try {
            int i2 = 2;
            if (h.z()) {
                AppInfoEntity appInfoEntity = h.X;
                jSONObjectB.put("sdk_ver", appInfoEntity != null ? appInfoEntity.getMediationVersion() : j.a());
                jSONObjectB.put("is_only_adx", 2);
            } else {
                jSONObjectB.put("sdk_ver", j.a());
                jSONObjectB.put("is_only_adx", 1);
            }
            jSONObjectB.put("network_type", h.o(contextD));
            jSONObjectB.put("mnc", h.a("mnc") ? com.smartdigimkt.y2.b.a(contextD != null ? contextD : SDKContext.getInstance().d()).b : "");
            jSONObjectB.put("mcc", h.a("mcc") ? com.smartdigimkt.y2.b.a(contextD != null ? contextD : SDKContext.getInstance().d()).a : "");
            jSONObjectB.put("orient", h.y(contextD));
            if (SDKContext.getInstance().e) {
                jSONObjectB.put("upid", SDKContext.getInstance().h());
                jSONObjectB.put("ps_id", SDKContext.getInstance().f());
                jSONObjectB.put(f.K, SDKContext.getInstance().m);
                jSONObjectB.put(f.L, SDKContext.getInstance().o);
                if (SDKContext.getInstance().t) {
                    SDKContext.getInstance().getClass();
                    str2 = "3";
                } else {
                    SDKContext.getInstance().getClass();
                    str2 = "4";
                }
                jSONObjectB.put(f.ae, str2);
                com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
                if (bVarE != null) {
                    bVarE.fillRequestDeviceData(jSONObjectB, i);
                }
                String strU = h.u();
                if (!TextUtils.isEmpty(strU)) {
                    jSONObjectB.put(f.af, Integer.parseInt(strU));
                }
                if ((i & 4) == 4 && (aVarA = e.c().a()) != null) {
                    try {
                        JSONObject jSONObject = aVarA.J;
                        if (jSONObject != null) {
                            jSONObjectB.put("a_c", jSONObject);
                        }
                    } catch (Exception unused) {
                    }
                }
                if ((i & 16) == 16 && (concurrentHashMap = p.c().d) != null && !concurrentHashMap.isEmpty()) {
                    for (Map.Entry entry : concurrentHashMap.entrySet()) {
                        String str5 = (String) entry.getKey();
                        String str6 = (String) entry.getValue();
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                            jSONObjectB.put(str5, str6);
                        }
                    }
                }
                int iMax = 0;
                if ((i & 64) == 64) {
                    jSONObjectB.put("isroot", h.t());
                    jSONObjectB.put("isagent", h.c("isagent") ? "" : com.smartdigimkt.r4.p.b(contextD));
                    jSONObjectB.put(f.aM, h.l(contextD));
                    jSONObjectB.put(f.aN, h.m(contextD));
                    if ((!(e.c().a().K == 1)) || h.c(f.aO)) {
                        str3 = "";
                    } else {
                        try {
                            ConnectivityManager connectivityManager = (ConnectivityManager) contextD.getSystemService("connectivity");
                            str3 = (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(17)) == null || !networkInfo.isConnected()) ? "2" : "1";
                        } catch (Exception unused2) {
                        }
                    }
                    jSONObjectB.put(f.aO, str3);
                    if (h.c(f.aP)) {
                        strValueOf = "";
                    } else {
                        try {
                            Intent intentRegisterReceiver = contextD.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                            boolean z3 = intExtra == 2 || intExtra == 5;
                            int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
                            boolean z4 = intExtra2 == 2;
                            boolean z5 = intExtra2 == 1;
                            if (z3 && (z4 || z5)) {
                                i2 = 1;
                            }
                        } catch (Throwable unused3) {
                        }
                        strValueOf = String.valueOf(i2);
                    }
                    jSONObjectB.put(f.aP, strValueOf);
                    jSONObjectB.put("battery", h.c("battery") ? "" : com.smartdigimkt.r4.p.a(contextD));
                    if (h.c(f.aR)) {
                        str4 = "";
                    } else {
                        if (h.F == null) {
                            h.F = k.b() ? "1" : "0";
                        }
                        str4 = h.F;
                    }
                    jSONObjectB.put(f.aR, str4);
                }
                if ((i & 128) == 128) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    JSONArray[] jSONArrayArrD = p.c().d();
                    JSONArray jSONArray = jSONArrayArrD[0];
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        z = false;
                    } else {
                        jSONObjectB.put(f.am, jSONArray);
                        iMax = Math.max(0, jSONArray.length());
                        z = true;
                    }
                    JSONArray jSONArray2 = jSONArrayArrD[1];
                    if (jSONArray2 == null || jSONArray2.length() <= 0) {
                        z2 = z;
                    } else {
                        jSONObjectB.put(f.bl, jSONArray2);
                        iMax = Math.max(iMax, jSONArray2.length());
                        z2 = true;
                    }
                    int i3 = iMax;
                    String str7 = i3 > 0 ? "available" : "empty";
                    if (bVar != null) {
                        try {
                            bVar.a(i3, SystemClock.elapsedRealtime() - jElapsedRealtime, str, str7, z2);
                        } catch (Throwable unused4) {
                        }
                    }
                }
                jSONObjectB.put(f.bf, i.c(h.d(contextD)));
                jSONObjectB.put(f.bg, i.c(h.c(contextD)));
            }
            jSONObjectB.put("app_id", SDKContext.getInstance().a());
            com.smartdigimkt.v3.f.a().b(SDKContext.getInstance().d(), jSONObjectB);
        } catch (Throwable unused5) {
        }
        return jSONObjectB;
    }

    public static JSONObject b(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            }
        } catch (Throwable unused) {
        }
        return jSONObject2;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    public static JSONObject a(int i, List list) {
        String str;
        boolean z;
        String strValueOf;
        String str2;
        Context contextD = SDKContext.getInstance().d();
        if (contextD == null) {
            contextD = c.a().j;
        }
        JSONObject jSONObject = d;
        if (jSONObject == null) {
            synchronized (a.class) {
                jSONObject = d;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("is_cn_sdk", "1");
                        String strS = h.s(contextD);
                        if (TextUtils.isEmpty(strS)) {
                            strS = "";
                        }
                        jSONObject.put("it_src", strS);
                        jSONObject.put(f.ad, 1);
                    } catch (Throwable unused) {
                    }
                    if (contextD != null) {
                        d = jSONObject;
                    }
                }
            }
        }
        JSONObject jSONObjectB = b(jSONObject);
        com.smartdigimkt.p4.a aVarA = e.c().a();
        if (aVarA != null) {
            try {
                str = aVarA.r;
            } catch (Throwable unused2) {
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            z = true;
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.isNull("a") || jSONObject2.optInt("a") == 1) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Exception unused3) {
            }
        }
        jSONObjectB.put("android_id", z ? h.b(contextD) : "");
        com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
        if (bVarE != null) {
            bVarE.fillRequestData(jSONObjectB, aVarA, i);
        }
        Location location = g.b;
        if (location != null) {
            jSONObjectB.put("lat", location.getLatitude());
            jSONObjectB.put(f.D, location.getLongitude());
        }
        try {
            strValueOf = String.valueOf(g.c);
        } catch (Throwable unused4) {
            strValueOf = null;
        }
        if (!TextUtils.isEmpty(strValueOf)) {
            jSONObjectB.put(f.E, Integer.parseInt(strValueOf));
        }
        a(contextD, jSONObjectB);
        SDMUserDeviceInfo sDMUserDeviceInfo = g.d;
        if (sDMUserDeviceInfo != null) {
            String devImei = sDMUserDeviceInfo.getDevImei();
            String devOaid = sDMUserDeviceInfo.getDevOaid();
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(devImei)) {
                jSONObject3.put("set_imei", devImei);
            }
            if (!TextUtils.isEmpty(devOaid)) {
                jSONObject3.put("set_oaid", devOaid);
            }
            if (jSONObject3.length() > 0) {
                jSONObjectB.put(f.H, jSONObject3);
            }
        }
        if ((i & 64) == 64) {
            String strK = h.k();
            if (!TextUtils.isEmpty(strK)) {
                jSONObjectB.put("bld_type", strK);
            }
            String strJ = h.j();
            if (!TextUtils.isEmpty(strJ)) {
                jSONObjectB.put("bld_tags", strJ);
            }
            String strL = h.l();
            if (!TextUtils.isEmpty(strL)) {
                jSONObjectB.put("bld_user", strL);
            }
            String strH = h.h();
            if (!TextUtils.isEmpty(strH)) {
                jSONObjectB.put("bld_radio", strH);
            }
            String strB = h.b();
            if (!TextUtils.isEmpty(strB)) {
                jSONObjectB.put("bld_bootloader", strB);
            }
            String strE = h.e();
            if (!TextUtils.isEmpty(strE)) {
                jSONObjectB.put("bld_hardware", strE);
            }
            String strF = h.f();
            if (!TextUtils.isEmpty(strF)) {
                jSONObjectB.put("bld_host", strF);
            }
            String strC = h.c();
            if (!TextUtils.isEmpty(strC)) {
                jSONObjectB.put("bld_codename", strC);
            }
            String strG = h.g();
            if (!TextUtils.isEmpty(strG)) {
                jSONObjectB.put("bld_incremental", strG);
            }
            String strI = h.i();
            if (!TextUtils.isEmpty(strI)) {
                jSONObjectB.put("bld_serial", strI);
            }
            String strD = h.d();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectB.put("bld_display", strD);
            }
            if (h.C()) {
                str2 = "";
            } else {
                if (h.R == null) {
                    try {
                        h.R = String.valueOf(1);
                    } catch (Throwable unused5) {
                        h.R = "";
                    }
                }
                str2 = h.R;
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObjectB.put("bld_version_codes", str2);
            }
            String strA = h.a();
            if (!TextUtils.isEmpty(strA)) {
                jSONObjectB.put("bld_board", strA);
            }
        }
        if (list != null && list.contains(com.anythink.core.common.d.i.ac.a)) {
            jSONObjectB.put("s_c", h.x(contextD));
            jSONObjectB.put("u_a", h.t(contextD));
            jSONObjectB.put(f.aB, h.f(contextD));
            jSONObjectB.put("d_s", h.i(contextD));
            try {
                jSONObjectB.put(f.aD, Integer.parseInt(h.l(contextD)));
                jSONObjectB.put(f.aE, Integer.parseInt(h.m(contextD)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String strO = h.o();
        if (!TextUtils.isEmpty(strO)) {
            jSONObjectB.put("ip_v4", strO);
        }
        String strP = h.p();
        if (!TextUtils.isEmpty(strP)) {
            jSONObjectB.put("ip_v6", strP);
        }
        com.smartdigimkt.v3.f.a().a(SDKContext.getInstance().d(), jSONObjectB);
        return jSONObjectB;
    }

    public static JSONObject a(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adx_sdk_ver", SDMSDK.getInstance().getSDKVersion());
            jSONObject.put("cpu", h.m());
            jSONObject.put("platform", 1);
            jSONObject.put("os_platform", 1);
            if (SDKContext.getInstance().a("os_vn")) {
                str = "";
            } else {
                if (TextUtils.isEmpty(h.i)) {
                    h.i = Build.VERSION.RELEASE;
                }
                str = h.i;
            }
            jSONObject.put("os_vn", str);
            jSONObject.put("os_vc", h.r());
            jSONObject.put("package_name", h.p(context));
            jSONObject.put("app_vn", h.v(context));
            jSONObject.put("app_vc", h.u(context));
            jSONObject.put("brand", h.s());
            jSONObject.put("model", h.q());
            jSONObject.put("screen", h.r(context));
            jSONObject.put("language", h.n(context));
            jSONObject.put("timezone", h.v());
            jSONObject.put("ua", h.n());
            jSONObject.put("system", 1);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    public static void a(Context context, JSONObject jSONObject) throws JSONException {
        ?? r1;
        int i = a;
        boolean z = false;
        if (i == -1) {
            int i2 = z.a().a(context) ? 2 : 0;
            if (i2 > 0) {
                jSONObject.put(f.G, i2);
            }
            a = i2;
        } else if (i > 0) {
            jSONObject.put(f.G, i);
        }
        int i3 = b;
        if (i3 != -1) {
            if (i3 == 1) {
                jSONObject.put(f.F, i3);
                return;
            }
            return;
        }
        z zVarA = z.a();
        synchronized (zVarA) {
            if (zVarA.a.indexOfKey(3) >= 0) {
                r1 = zVarA.a.get(3);
            } else {
                try {
                    Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                    z = true;
                } catch (Exception unused) {
                }
                zVarA.a.put(3, z);
                r1 = z;
            }
        }
        if (r1 == 1) {
            jSONObject.put(f.F, r1);
        }
        b = r1;
    }

    public static void a(JSONObject jSONObject) {
        try {
            d dVarW = h.w();
            JSONObject jSONObject2 = new JSONObject();
            int i = 1;
            if (dVarW.b != 1) {
                i = 0;
            }
            jSONObject2.put("has_sdk", i);
            jSONObject2.put("sdk_ver", String.valueOf(dVarW.c));
            jSONObject2.put("sdk_api_ver", String.valueOf(dVarW.d));
            jSONObject2.put("open_app_id", h.x());
            jSONObject.put(f.an, jSONObject2);
        } catch (Throwable unused) {
        }
    }
}
