package com.smartdigimkt.s3;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.v2.p;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static String b;
    public static long c;
    public static final Object a = new Object();
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static final AtomicBoolean e = new AtomicBoolean(false);
    public static final AtomicBoolean f = new AtomicBoolean(false);
    public static final AtomicBoolean g = new AtomicBoolean(false);
    public static volatile String h = "";
    public static final String[] i = {"hw_ver", "hw_hms_ver", "vivo_ver", "oppo_ver", "xiaomi_ver", "honor_v2_ver"};
    public static final String[] j = {"mac", "imei", "oaid", "update_mark", "boot_mark"};

    public static boolean a(String str, long j2, long j3) {
        return str != null && str.length() > 0 && j2 > 0 && j3 - j2 < 3600000;
    }

    public static String b(String str) {
        return str != null ? str : "";
    }

    public static JSONObject b() {
        int i2;
        long j2;
        String string;
        String str = "";
        Context contextD = SDKContext.getInstance().d();
        if (contextD != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_s2s", 1);
                com.smartdigimkt.r4.h.w(contextD);
                jSONObject.put("upid", b(SDKContext.getInstance().h()));
                jSONObject.put("android_id", b(com.smartdigimkt.r4.h.b(contextD)));
                jSONObject.put("adx_sdk_ver", b(SDMSDK.getInstance().getSDKVersion()));
                String strU = com.smartdigimkt.r4.h.u();
                if (TextUtils.isEmpty(strU)) {
                    i2 = 0;
                } else {
                    try {
                        i2 = Integer.parseInt(strU);
                    } catch (NumberFormatException unused) {
                        i2 = 0;
                    }
                }
                jSONObject.put(com.anythink.core.common.l.f.af, i2);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = p.c().d()[0];
                if (jSONArray2 != null) {
                    jSONArray = jSONArray2;
                }
                jSONObject.put(com.anythink.core.common.l.f.am, jSONArray);
                c(jSONObject);
                try {
                    com.smartdigimkt.a4.a.a(jSONObject);
                } catch (Throwable unused2) {
                }
                a(jSONObject);
                b(jSONObject);
                jSONObject.put("os_vc", b(com.smartdigimkt.r4.h.r()));
                jSONObject.put("machine", b(com.smartdigimkt.r4.h.q()));
                jSONObject.put("model", b(com.smartdigimkt.r4.h.q()));
                long blockSizeLong = 0;
                try {
                    ActivityManager activityManager = (ActivityManager) contextD.getSystemService("activity");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    j2 = memoryInfo.totalMem;
                } catch (Throwable unused3) {
                    j2 = 0;
                }
                jSONObject.put("mem_total", j2);
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    blockSizeLong = statFs.getBlockSizeLong() * statFs.getBlockCountLong();
                } catch (Throwable unused4) {
                }
                jSONObject.put("disk_total", blockSizeLong);
                jSONObject.put("machine_new", b(Build.DEVICE));
                jSONObject.put("timezone", b(com.smartdigimkt.r4.h.v()));
                try {
                    string = Settings.Global.getString(contextD.getContentResolver(), "device_name");
                    if (string == null) {
                        string = "";
                    }
                } catch (Throwable unused5) {
                }
                jSONObject.put("device_name", string);
                jSONObject.put("mcc", b(!com.smartdigimkt.r4.h.a("mcc") ? "" : com.smartdigimkt.y2.b.a(contextD).a));
                if (com.smartdigimkt.r4.h.a("mnc")) {
                    str = com.smartdigimkt.y2.b.a(contextD).b;
                }
                jSONObject.put("mnc", b(str));
                return jSONObject;
            } catch (Throwable unused6) {
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    public static void c(JSONObject jSONObject) throws JSONException {
        String str;
        ConcurrentHashMap concurrentHashMap = p.c().d;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (String str2 : i) {
            linkedHashSet.add(str2);
        }
        if (concurrentHashMap != null) {
            linkedHashSet.addAll(concurrentHashMap.keySet());
        }
        for (String str3 : linkedHashSet) {
            if (!TextUtils.isEmpty(str3)) {
                if (concurrentHashMap != null) {
                    str = (String) concurrentHashMap.get(str3);
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                } else {
                    str = "";
                }
                jSONObject.put(str3, str);
            }
        }
    }

    public static boolean d(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("oaid", "")) || (jSONArrayOptJSONArray = jSONObject.optJSONArray(com.anythink.core.common.l.f.am)) == null || jSONArrayOptJSONArray.length() <= 0) ? false : true;
    }

    public static String a() {
        String strOptString;
        JSONArray jSONArray;
        com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
        if (bVarE == null) {
            strOptString = "";
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                bVarE.fillRequestData(jSONObject, com.smartdigimkt.o4.e.c().a(), -1);
                strOptString = jSONObject.optString("oaid", "");
            } catch (Throwable unused) {
                strOptString = "";
            }
        }
        if (TextUtils.isEmpty(strOptString) || (jSONArray = p.c().d()[0]) == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strOptString).append('|');
        sb.append(jSONArray.toString()).append('|');
        a(sb);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    public static void a(StringBuilder sb) {
        String str;
        ConcurrentHashMap concurrentHashMap = p.c().d;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (String str2 : i) {
            linkedHashSet.add(str2);
        }
        if (concurrentHashMap != null) {
            linkedHashSet.addAll(concurrentHashMap.keySet());
        }
        for (String str3 : linkedHashSet) {
            if (!TextUtils.isEmpty(str3)) {
                if (concurrentHashMap != null) {
                    str = (String) concurrentHashMap.get(str3);
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                } else {
                    str = "";
                }
                sb.append(str3).append('=').append(str).append(';');
            }
        }
    }

    public static void a(String str) {
        synchronized (a) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            b = str;
            c = jCurrentTimeMillis;
            Context contextD = SDKContext.getInstance().d();
            if (contextD == null) {
                return;
            }
            y.a(contextD, "sdm_adx_rp_sdk", "s2s_buyer_uid_cache", str);
            y.a(contextD, "sdm_adx_rp_sdk", "s2s_buyer_uid_cache_time", jCurrentTimeMillis);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    public static void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Object objOpt;
        if (jSONObject.has(com.anythink.core.common.l.f.an) && !jSONObject.isNull(com.anythink.core.common.l.f.an)) {
            try {
                jSONObject3 = jSONObject.getJSONObject(com.anythink.core.common.l.f.an);
            } catch (Throwable unused) {
                jSONObject2 = new JSONObject();
                jSONObject.put(com.anythink.core.common.l.f.an, jSONObject2);
                jSONObject3 = jSONObject2;
            }
            if (!jSONObject3.has("has_sdk")) {
                jSONObject3.put("has_sdk", 0);
            }
            if (!jSONObject3.has("sdk_ver")) {
                jSONObject3.put("sdk_ver", "0");
            }
            if (!jSONObject3.has("sdk_api_ver")) {
                jSONObject3.put("sdk_api_ver", "0");
            }
            if (!jSONObject3.has("open_app_id")) {
                jSONObject3.put("open_app_id", b(com.smartdigimkt.r4.h.x()));
                return;
            }
            objOpt = jSONObject3.opt("open_app_id");
            if (objOpt != null || objOpt == JSONObject.NULL) {
                jSONObject3.put("open_app_id", "");
            }
            return;
        }
        jSONObject2 = new JSONObject();
        jSONObject.put(com.anythink.core.common.l.f.an, jSONObject2);
        jSONObject3 = jSONObject2;
        if (!jSONObject3.has("has_sdk")) {
            jSONObject3.put("has_sdk", 0);
        }
        if (!jSONObject3.has("sdk_ver")) {
            jSONObject3.put("sdk_ver", "0");
        }
        if (!jSONObject3.has("sdk_api_ver")) {
            jSONObject3.put("sdk_api_ver", "0");
        }
        if (!jSONObject3.has("open_app_id")) {
            jSONObject3.put("open_app_id", b(com.smartdigimkt.r4.h.x()));
            return;
        }
        objOpt = jSONObject3.opt("open_app_id");
        if (objOpt != null) {
        }
        jSONObject3.put("open_app_id", "");
    }

    public static void b(JSONObject jSONObject) {
        com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
        if (bVarE != null) {
            try {
                com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
                JSONObject jSONObject2 = new JSONObject();
                bVarE.fillRequestData(jSONObject2, aVarA, -1);
                jSONObject.put("mac", jSONObject2.optString("mac"));
                jSONObject.put("imei", jSONObject2.optString("imei"));
                jSONObject.put("oaid", jSONObject2.optString("oaid"));
                JSONObject jSONObject3 = new JSONObject();
                bVarE.fillRequestDeviceData(jSONObject3, 3);
                jSONObject.put("update_mark", jSONObject3.optString("update_mark"));
                jSONObject.put("boot_mark", jSONObject3.optString("boot_mark"));
                for (String str : j) {
                    if (!jSONObject.has(str) || jSONObject.isNull(str)) {
                        jSONObject.put(str, "");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
