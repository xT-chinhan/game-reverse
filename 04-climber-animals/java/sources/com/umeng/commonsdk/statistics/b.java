package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.dn;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.f;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnvelopeManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static String a = null;
    public static String b = "";
    private static final String c = "EnvelopeManager";
    private static final String d = "debug.umeng.umTaskId";
    private static final String e = "debug.umeng.umCaseId";
    private static final String f = "empty";
    private static String g = "";
    private static String h = "";
    private static String i;
    private static Map<String, String> j;
    private static boolean l;
    private int k = 0;

    static {
        HashMap map = new HashMap();
        j = map;
        map.put("header", "#h");
        j.put(bv.u, "#sdt");
        j.put(bv.Q, "#ac");
        j.put("device_model", "#dm");
        j.put(bv.g, "#umid");
        j.put("os", "os");
        j.put("language", "#lang");
        j.put(bv.ac, "#dt");
        j.put(bv.z, "#rl");
        j.put(bv.H, "#dmf");
        j.put(bv.J, "#dn");
        j.put("platform_version", "#pv");
        j.put("font_size_setting", "#fss");
        j.put(bv.y, "#ov");
        j.put(bv.I, "#did");
        j.put("platform_sdk_version", "#psv");
        j.put(bv.F, "#db");
        j.put("appkey", "#ak");
        j.put(bv.Y, "#itr");
        j.put("id_type", "#it");
        j.put("uuid", "#ud");
        j.put("device_id", "#dd");
        j.put(bv.X, "#imp");
        j.put("sdk_version", "#sv");
        j.put("st", "#st");
        j.put("analytics", "#a");
        j.put("package_name", "#pkg");
        j.put(bv.p, "#sig");
        j.put(bv.q, "#sis1");
        j.put(bv.r, "#sis");
        j.put("app_version", "#av");
        j.put("version_code", "#vc");
        j.put(bv.v, "#imd");
        j.put(bv.B, "#mnc");
        j.put(bv.E, "#boa");
        j.put(bv.G, "#mant");
        j.put("timezone", "#tz");
        j.put(bv.O, "#ct");
        j.put(bv.P, "#car");
        j.put(bv.s, "#disn");
        j.put("network_type", "#nt");
        j.put(bv.b, "#cv");
        j.put(bv.d, "#mv");
        j.put(bv.c, "#cot");
        j.put(bv.e, "#mod");
        j.put(bv.ad, "#al");
        j.put("session_id", "#sid");
        j.put(bv.S, "#ip");
        j.put(bv.U, "#sre");
        j.put(bv.V, "#fre");
        j.put(bv.W, "#ret");
        j.put("channel", "#chn");
        j.put("wrapper_type", "#wt");
        j.put("wrapper_version", "#wv");
        j.put(bv.aV, "#tsv");
        j.put("rps_pr", "#rps");
        j.put(bv.aY, "#mov");
        j.put(g.i, "#vt");
        j.put("secret", "#sec");
        j.put(g.an, "#prv");
        j.put(g.l, "#$prv");
        j.put(g.m, "#uda");
        j.put(bv.a, "#tok");
        j.put(bv.aN, "#iv");
        j.put(bv.R, "#ast");
        j.put("backstate", "#bst");
        j.put("zdata_ver", "#zv");
        j.put("zdata_req_ts", "#zrt");
        j.put("app_b_v", "#bv");
        j.put("zdata", "#zta");
        j.put(bv.aj, "#mt");
        j.put(bv.ag, "#zsv");
        j.put("others_OS", "#oos");
    }

    public static String a(String str) {
        return j.containsKey(str) ? j.get(str) : str;
    }

    public static void a() {
        if (i != null) {
            i = null;
            f.a();
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(c, "free size is " + j2);
        }
        return j2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    private static boolean b() {
        g = UMUtils.getSystemProperty(d, "");
        h = UMUtils.getSystemProperty(e, "");
        return (!TextUtils.isEmpty(g) && !f.equals(g)) && (!TextUtils.isEmpty(h) && !f.equals(h));
    }

    /* JADX WARN: Code duplicated, block: B:123:0x023f A[Catch: Exception -> 0x023b, TryCatch #1 {Exception -> 0x023b, blocks: (B:119:0x0234, B:123:0x023f, B:124:0x0243, B:126:0x0249, B:128:0x024f, B:130:0x0253, B:132:0x0257), top: B:147:0x0234 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0249 A[Catch: Exception -> 0x023b, TryCatch #1 {Exception -> 0x023b, blocks: (B:119:0x0234, B:123:0x023f, B:124:0x0243, B:126:0x0249, B:128:0x024f, B:130:0x0253, B:132:0x0257), top: B:147:0x0234 }] */
    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        Iterator<String> itKeys;
        String next;
        String str4;
        String str5;
        Envelope envelope;
        String str6;
        JSONObject jSONObjectOptJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context == null || jSONObject2 == null) {
            return a(110, (JSONObject) null);
        }
        try {
            JSONObject jSONObjectA = a(context, str2, jSONObject2.has("analytics") && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.has(g.n));
            if (jSONObjectA != null && jSONObject != null) {
                jSONObjectA = a(jSONObjectA, jSONObject);
            }
            JSONObject jSONObject4 = jSONObjectA;
            if (jSONObject4 != null && jSONObject2 != null) {
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (next2 != null && (next2 instanceof String) && (str6 = next2) != null && jSONObject2.opt(str6) != null) {
                        try {
                            jSONObject4.put(a(str6), jSONObject2.opt(str6));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "u";
            }
            String str7 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
            if (jSONObject4 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2).append("==").append(str7).append("&=");
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return a(101, jSONObject4);
                }
                if (string.endsWith("&=")) {
                    string = string.substring(0, string.length() - 2);
                }
                str5 = string;
            } else {
                str5 = null;
            }
            if (jSONObject4 != null) {
                try {
                    f fVarA = f.a(context);
                    if (fVarA != null) {
                        fVarA.b();
                        String strEncodeToString = Base64.encodeToString(new dn().a(fVarA.c()), 0);
                        if (!TextUtils.isEmpty(strEncodeToString)) {
                            JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                            jSONObject5.put(a(bv.Y), strEncodeToString);
                            jSONObject4.put(a("header"), jSONObject5);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject4);
            }
            if (jSONObject4 != null) {
                Envelope envelopeA = a(context, jSONObject4.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject4);
                }
                envelope = envelopeA;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject4);
            }
            int iA = a(context, envelope, str5, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
            if (iA != 0) {
                return a(iA, jSONObject4);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
            }
            if (!str5.startsWith(bv.aD) && !str5.startsWith("i") && !str5.startsWith(bv.aI) && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                new com.umeng.commonsdk.stateless.b(context);
                com.umeng.commonsdk.stateless.b.b();
            }
            return jSONObject4;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject3 = jSONObject6;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                    jSONObject3 = jSONObject6;
                } catch (Exception e3) {
                    e = e3;
                    jSONObject3 = null;
                }
            } else {
                jSONObject3 = null;
            }
            if (jSONObject2 != null) {
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                        if (jSONObject2 != null) {
                            itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                next = itKeys.next();
                                if (next == null && (next instanceof String) && (str4 = next) != null && jSONObject2.opt(str4) != null) {
                                    try {
                                        jSONObject3.put(str4, jSONObject2.opt(str4));
                                    } catch (Exception unused4) {
                                    }
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                } else if (jSONObject2 != null) {
                    itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        next = itKeys.next();
                        if (next == null) {
                        }
                    }
                }
            }
            return a(110, jSONObject3);
        }
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelopeA;
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelopeA = a(context, jSONObject3.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelopeA = null;
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "h==1.2.0", "", str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelopeA;
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelopeA = a(context, jSONObject3.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelopeA = null;
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    private static JSONObject a(Context context, String str, boolean z) {
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(i)) {
                try {
                    jSONObject = new JSONObject(i);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(a(bv.p), DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put(a(bv.q), DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put(a(bv.r), DeviceConfig.getAppHashKey(context));
                jSONObject2.put(a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject2.put(a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put(a(bv.v), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put(a("cpu"), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put(a(bv.B), mccmnc);
                    b = mccmnc;
                } else {
                    jSONObject2.put(a(bv.B), "");
                }
                if (FieldManager.allow(d.I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject2.put(a(bv.K), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject2.put(a(bv.L), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put(a(bv.ac), deviceType);
                }
                jSONObject2.put(a("package_name"), DeviceConfig.getPackageName(context));
                jSONObject2.put(a(bv.u), "Android");
                jSONObject2.put(a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject2.put(a("device_model"), Build.MODEL);
                jSONObject2.put(a(bv.E), Build.BOARD);
                jSONObject2.put(a(bv.F), Build.BRAND);
                jSONObject2.put(a(bv.G), Build.TIME);
                jSONObject2.put(a(bv.H), Build.MANUFACTURER);
                jSONObject2.put(a(bv.I), Build.ID);
                jSONObject2.put(a(bv.J), Build.DEVICE);
                jSONObject2.put(a(bv.y), Build.VERSION.RELEASE);
                jSONObject2.put(a("os"), "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject2.put(a(bv.z), resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject2.put(a(bv.A), DeviceConfig.getMac(context));
                jSONObject2.put(a("timezone"), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject2.put(a(bv.O), localeInfo[0]);
                jSONObject2.put(a("language"), localeInfo[1]);
                jSONObject2.put(a(bv.P), DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put(a(bv.s), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(bv.Q), NetworkUtil.NETWORK_TYPE_WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(bv.Q), "2G/3G");
                } else {
                    jSONObject2.put(a(bv.Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put(a(bv.R), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject2.put(a("others_OS"), "harmony");
                } else {
                    jSONObject2.put(a("others_OS"), "Android");
                }
                jSONObject2.put(a("network_type"), DeviceConfig.getNetworkType(context));
                jSONObject2.put(a(bv.b), "9.9.6");
                jSONObject2.put(a(bv.c), SdkVersion.SDK_TYPE);
                jSONObject2.put(a(bv.d), "1");
                if (!TextUtils.isEmpty(a)) {
                    jSONObject2.put(a(bv.e), a);
                }
                jSONObject2.put(a(bv.ad), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(a(bv.Z), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put(a("session_id"), uUIDForZid);
                } catch (Throwable unused2) {
                }
                try {
                    if (DeviceConfig.isSystemApp(context)) {
                        jSONObject2.put(bv.ak, "1");
                    }
                } catch (Throwable unused3) {
                }
                if (DeviceConfig.isHonorDevice()) {
                    try {
                        if (bt.c()) {
                            jSONObject2.put(bv.al, 2);
                        }
                        if (bt.b()) {
                            jSONObject2.put(bv.al, 3);
                        }
                    } catch (Throwable unused4) {
                    }
                }
                try {
                    jSONObject2.put(bv.am, DeviceConfig.getNotificationStatus(context));
                } catch (Throwable unused5) {
                }
                try {
                    jSONObject2.put(bv.an, DeviceConfig.getRingerMode(context));
                } catch (Throwable unused6) {
                }
                try {
                    jSONObject2.put(bv.ao, com.umeng.commonsdk.statistics.common.d.a(context));
                } catch (Throwable unused7) {
                }
                try {
                    jSONObject2.put(bv.ap, com.umeng.commonsdk.statistics.common.d.a());
                } catch (Throwable unused8) {
                }
                i = jSONObject2.toString();
                jSONObject = jSONObject2;
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(a(bv.ae), UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused9) {
            }
            try {
                jSONObject.put(a(bv.U), sharedPreferences.getInt("successful_request", 0));
                jSONObject.put(a(bv.V), sharedPreferences.getInt(bv.V, 0));
                jSONObject.put(a(bv.W), sharedPreferences.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(a(bv.af), zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(a(bv.ag), UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception unused10) {
            }
            jSONObject.put(a("channel"), UMUtils.getChannel(context));
            jSONObject.put(a("appkey"), UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(a(bv.a), deviceToken);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
            try {
                String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, bv.g, null);
                if (!TextUtils.isEmpty(strImprintProperty)) {
                    jSONObject.put(a(bv.g), strImprintProperty);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(context, e3);
            }
            try {
                jSONObject.put(a("wrapper_type"), a.a);
                jSONObject.put(a("wrapper_version"), a.b);
            } catch (Exception unused11) {
            }
            try {
                jSONObject.put(a(bv.aV), UMUtils.getTargetSdkVersion(context));
            } catch (Throwable unused12) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused13) {
            }
            if ((bv.aI.equals(str) || "a".equals(str)) && z) {
                try {
                    int[] iArrB = b(context);
                    jSONObject.put(a(bv.bq), String.valueOf(iArrB[0]) + String.valueOf(iArrB[1]) + String.valueOf(iArrB[2]));
                } catch (Throwable unused14) {
                }
            }
            try {
                Map<String, String> moduleTags = TagHelper.getModuleTags();
                if (moduleTags != null && moduleTags.size() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put(a(bv.aj), jSONObject3);
                }
            } catch (Throwable unused15) {
            }
            try {
                String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(a(bv.bp), realTimeDebugKey);
                }
            } catch (Throwable unused16) {
            }
            try {
                JSONObject moduleVer = UMUtils.getModuleVer();
                if (moduleVer.length() > 0) {
                    jSONObject.put(a(bv.aY), moduleVer);
                }
            } catch (Throwable unused17) {
            }
            try {
                String apmFlag = UMUtils.getApmFlag();
                if (!TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(a(bv.bo), apmFlag);
                }
            } catch (Throwable unused18) {
            }
            try {
                String strA = au.a(Build.BRAND);
                String strB = au.b(Build.BRAND);
                jSONObject.put(bv.aW, strA);
                jSONObject.put(bv.aX, strB);
            } catch (Throwable unused19) {
            }
            byte[] bArrA = ImprintHandler.getImprintService(context).a();
            if (bArrA != null && bArrA.length > 0) {
                try {
                    jSONObject.put(a(bv.X), Base64.encodeToString(bArrA, 0));
                } catch (JSONException e4) {
                    UMCrashManager.reportCrash(context, e4);
                }
            }
            if (jSONObject == null || jSONObject.length() <= 0) {
                return null;
            }
            return new JSONObject().put(a("header"), jSONObject);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(a(g.i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.k = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int iIntValue = -1;
        try {
            if (!TextUtils.isEmpty(strImprintProperty)) {
                iIntValue = Integer.valueOf(strImprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (iIntValue == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (iIntValue == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String strB = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("&&").append(str2).append("_").append(System.currentTimeMillis()).append("_").append(strB).append(com.anythink.dlopt.common.a.a.g);
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith("h")) {
            return 122;
        }
        if (str.startsWith(bv.aD) || str.startsWith("i") || str.startsWith("a") || str.startsWith(bv.aI)) {
            return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
        }
        return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f, sb.toString(), binary);
    }

    public static void a(boolean z) {
        l = z;
    }
}
