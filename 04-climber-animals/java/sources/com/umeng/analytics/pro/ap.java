package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.custommapping.UAPMCustomMapping;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModelHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class ap {
    private static JSONObject a;

    public static JSONObject a(Context context, JSONArray jSONArray, String str) {
        JSONObject jSONObject = a;
        if (jSONObject != null && jSONObject.length() > 0) {
            return a;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("os", "Android");
            jSONObject2.put(com.kuaishou.weapon.p0.t.v, Build.MODEL);
            jSONObject2.put("av", DeviceConfig.getAppVersionName(context));
            jSONObject2.put(bv.g, UMUtils.getUMId(context));
            jSONObject2.put("ov", Build.VERSION.RELEASE);
            jSONObject2.put("chn", UMUtils.getChannel(context));
            jSONObject2.put(bv.af, UMUtils.getZid(context));
            jSONObject2.put("sv", "9.9.6");
            jSONObject2.put("ak", UMUtils.getAppkey(context));
            String idfa = DeviceConfig.getIdfa(context);
            if (!TextUtils.isEmpty(idfa)) {
                jSONObject2.put("tk_idfa", idfa);
            }
            jSONObject2.put("db", Build.BRAND);
            jSONObject2.put("tk_aid", DeviceConfig.getAndroidId(context));
            String oaid = DeviceConfig.getOaid(context);
            if (!TextUtils.isEmpty(oaid)) {
                jSONObject2.put("tk_oaid", oaid);
            }
            String imeiNew = DeviceConfig.getImeiNew(context);
            if (!TextUtils.isEmpty(imeiNew)) {
                jSONObject2.put("tk_imei", imeiNew);
            }
            jSONObject2.put("boa", Build.BOARD);
            jSONObject2.put("mant", Build.TIME);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            jSONObject2.put("ct", localeInfo[0]);
            jSONObject2.put(com.anythink.basead.webtemplet.a.b.c.j, localeInfo[1]);
            jSONObject2.put("tz", DeviceConfig.getTimeZone(context));
            jSONObject2.put(com.anythink.basead.c.b.a.A, DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", NetworkUtil.NETWORK_TYPE_WIFI);
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "2G/3G");
            } else {
                jSONObject2.put("ac", "unknown");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put("ast", networkAccessMode[1]);
            }
            jSONObject2.put("nt", DeviceConfig.getNetworkType(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put(bv.a, deviceToken);
            }
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            if (resolutionArray != null) {
                jSONObject2.put("rl", resolutionArray[1] + "*" + resolutionArray[0]);
            }
            jSONObject2.put("car", DeviceConfig.getNetworkOperatorName(context));
            jSONObject2.put(bv.b, "9.9.6");
            if (DeviceConfig.isHarmony(context)) {
                jSONObject2.put("oos", "harmony");
            } else {
                jSONObject2.put("oos", "Android");
            }
            jSONObject2.put(com.umeng.ccg.a.u, str);
            jSONObject2.put("sdk", jSONArray);
            a = jSONObject2;
        } catch (Throwable unused) {
        }
        return a;
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("ekv", jSONArray);
                return jSONObject3;
            } catch (Throwable unused) {
                jSONObject2 = jSONObject3;
                return jSONObject2;
            }
        } catch (Throwable unused2) {
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("header", jSONObject);
            jSONObject3.put("analytics", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject3;
    }

    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject = null;
        try {
            ao aoVar = new ao();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            aoVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            aoVar.b(appkey);
            aoVar.c(UMUtils.getAppVersionName(context));
            aoVar.d("9.9.6");
            aoVar.e(UMUtils.getChannel(context));
            aoVar.f(Build.VERSION.SDK_INT + "");
            aoVar.g(Build.BRAND);
            aoVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            aoVar.i(localeInfo[1]);
            aoVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            aoVar.b(Integer.valueOf(resolutionArray[1]));
            aoVar.a(Integer.valueOf(resolutionArray[0]));
            aoVar.k(at.a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(ao.a, aoVar.a());
                    jSONObject2.put(ao.c, aoVar.c());
                    jSONObject2.put(ao.b, aoVar.b());
                    jSONObject2.put(ao.d, aoVar.d());
                    jSONObject2.put(ao.e, aoVar.e());
                    jSONObject2.put(ao.f, aoVar.f());
                    jSONObject2.put(ao.g, aoVar.g());
                    jSONObject2.put(ao.h, aoVar.h());
                    jSONObject2.put(ao.k, aoVar.k());
                    jSONObject2.put(ao.j, aoVar.j());
                    jSONObject2.put(ao.l, aoVar.l());
                    jSONObject2.put(ao.i, aoVar.i());
                    jSONObject2.put(ao.m, aoVar.m());
                    jSONObject2.put(bv.af, UMUtils.getZid(context));
                    jSONObject2.put("platform", "android");
                    jSONObject2.put("optional", new JSONObject(at.a()));
                    String[] strArrSplit = str.split("@");
                    if (strArrSplit.length == 4) {
                        try {
                            long j = Long.parseLong(strArrSplit[0]);
                            String str2 = strArrSplit[1];
                            jSONObject2.put(UAPMCustomMapping.STRING_PARAM_1, j);
                            jSONObject2.put(UAPMCustomMapping.STRING_PARAM_2, str2);
                        } catch (Throwable unused) {
                        }
                    }
                    try {
                        String strA = au.a(Build.BRAND);
                        String strB = au.b(Build.BRAND);
                        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                            jSONObject2.put(ao.n, strA);
                            jSONObject2.put(ao.o, strB);
                        } else {
                            jSONObject2.put(ao.n, "Android");
                            jSONObject2.put(ao.o, Build.VERSION.RELEASE);
                        }
                    } catch (Throwable unused2) {
                    }
                    return jSONObject2;
                } catch (JSONException e) {
                    e = e;
                    jSONObject = jSONObject2;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    jSONObject = jSONObject2;
                }
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
        return jSONObject;
    }

    public static JSONObject b(Context context, String str) {
        JSONObject jSONObject = null;
        try {
            ao aoVar = new ao();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            aoVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            aoVar.b(appkey);
            aoVar.c(UMUtils.getAppVersionName(context));
            aoVar.d("9.9.6");
            aoVar.e(UMUtils.getChannel(context));
            aoVar.f(Build.VERSION.SDK_INT + "");
            aoVar.g(Build.BRAND);
            aoVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            aoVar.i(localeInfo[1]);
            aoVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            aoVar.b(Integer.valueOf(resolutionArray[1]));
            aoVar.a(Integer.valueOf(resolutionArray[0]));
            aoVar.k(at.a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(ao.a, aoVar.a());
                    jSONObject2.put(ao.c, aoVar.c());
                    jSONObject2.put(ao.b, aoVar.b());
                    jSONObject2.put(ao.d, aoVar.d());
                    jSONObject2.put(ao.e, aoVar.e());
                    jSONObject2.put(ao.f, aoVar.f());
                    jSONObject2.put(ao.g, aoVar.g());
                    jSONObject2.put(ao.h, aoVar.h());
                    jSONObject2.put(ao.k, aoVar.k());
                    jSONObject2.put(ao.j, aoVar.j());
                    jSONObject2.put(ao.l, aoVar.l());
                    jSONObject2.put(ao.i, aoVar.i());
                    jSONObject2.put(ao.m, aoVar.m());
                    jSONObject2.put(bv.af, UMUtils.getZid(context));
                    jSONObject2.put("platform", "android");
                    jSONObject2.put("optional", new JSONObject(at.a()));
                    jSONObject2.put(UAPMCustomMapping.STRING_PARAM_1, str);
                    jSONObject2.put("oaid", DeviceConfig.getOaid(context));
                    try {
                        String strA = au.a(Build.BRAND);
                        String strB = au.b(Build.BRAND);
                        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                            jSONObject2.put(ao.n, strA);
                            jSONObject2.put(ao.o, strB);
                        } else {
                            jSONObject2.put(ao.n, "Android");
                            jSONObject2.put(ao.o, Build.VERSION.RELEASE);
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONObject2;
                } catch (JSONException e) {
                    e = e;
                    jSONObject = jSONObject2;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    jSONObject = jSONObject2;
                }
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
        return jSONObject;
    }

    public static JSONObject a(Context context, int i, JSONArray jSONArray, String str, boolean z) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String zid = UMUtils.getZid(context);
                if (TextUtils.isEmpty(zid)) {
                    return jSONObject2;
                }
                jSONObject2.put("atoken", zid);
                jSONObject2.put("oaid", DeviceConfig.getOaid(context));
                jSONObject2.put(bv.g, UMEnvelopeBuild.imprintProperty(context, bv.g, ""));
                jSONObject2.put(bv.F, Build.BRAND);
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject2.put("device_token", deviceToken);
                }
                jSONObject2.put("model", Build.MODEL);
                jSONObject2.put("os", "android");
                jSONObject2.put(bv.y, Build.VERSION.RELEASE);
                jSONObject2.put("appkey", UMConfigure.sAppkey);
                jSONObject2.put("app_version", DeviceConfig.getAppVersionName(context));
                jSONObject2.put("packagename", DeviceConfig.getPackageName(context));
                jSONObject2.put("app_display_name", DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(bv.Q, NetworkUtil.NETWORK_TYPE_WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(bv.Q, "2G/3G");
                } else {
                    jSONObject2.put(bv.Q, "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put("sub_access", networkAccessMode[1]);
                }
                jSONObject2.put("sdkType", "Android");
                jSONObject2.put("sdk_version", "9.9.6");
                jSONObject2.put("session_id", ab.a().d(context));
                jSONObject2.put(bv.an, DeviceConfig.getRingerMode(context));
                jSONObject2.put(com.umeng.ccg.a.u, str);
                jSONObject2.put("sdk", jSONArray);
                if (z) {
                    jSONObject2.put("am", DeviceConfig.isAirplaneModeOn(context));
                }
                jSONObject2.put("e", i);
                return jSONObject2;
            } catch (Throwable unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
    }
}
