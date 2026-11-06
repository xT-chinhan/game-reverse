package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnvelopeManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static String a = null;
    private static final String c = "EnvelopeManager";
    private static final String d = "debug.umeng.umTaskId";
    private static final String e = "debug.umeng.umCaseId";
    private static final String f = "empty";
    private static boolean l;
    private int k = 0;
    private static String g = "";
    private static String h = "";
    private static String i = null;
    public static String b = "";
    private static Map<String, String> j = new HashMap();

    static {
        j.put("header", "#h");
        j.put(an.u, "#sdt");
        j.put(an.Q, "#ac");
        j.put("device_model", "#dm");
        j.put(an.g, "#umid");
        j.put("os", "os");
        j.put("language", "#lang");
        j.put(an.ai, "#dt");
        j.put(an.z, "#rl");
        j.put(an.H, "#dmf");
        j.put(an.J, "#dn");
        j.put("platform_version", "#pv");
        j.put("font_size_setting", "#fss");
        j.put(an.y, "#ov");
        j.put(an.I, "#did");
        j.put("platform_sdk_version", "#psv");
        j.put(an.F, "#db");
        j.put("appkey", "#ak");
        j.put(an.Y, "#itr");
        j.put("id_type", "#it");
        j.put("uuid", "#ud");
        j.put("device_id", "#dd");
        j.put(an.X, "#imp");
        j.put("sdk_version", "#sv");
        j.put("st", "#st");
        j.put("analytics", "#a");
        j.put("package_name", "#pkg");
        j.put(an.p, "#sig");
        j.put(an.q, "#sis1");
        j.put(an.r, "#sis");
        j.put("app_version", "#av");
        j.put("version_code", "#vc");
        j.put(an.v, "#imd");
        j.put(an.B, "#mnc");
        j.put(an.E, "#boa");
        j.put(an.G, "#mant");
        j.put(an.M, "#tz");
        j.put(an.O, "#ct");
        j.put(an.P, "#car");
        j.put(an.s, "#disn");
        j.put("network_type", "#nt");
        j.put(an.b, "#cv");
        j.put(an.d, "#mv");
        j.put(an.c, "#cot");
        j.put(an.e, "#mod");
        j.put(an.aj, "#al");
        j.put("session_id", "#sid");
        j.put(an.S, "#ip");
        j.put(an.U, "#sre");
        j.put(an.V, "#fre");
        j.put(an.W, "#ret");
        j.put("channel", "#chn");
        j.put("wrapper_type", "#wt");
        j.put("wrapper_version", "#wv");
        j.put(an.aV, "#tsv");
        j.put(an.aW, "#rps");
        j.put(an.aZ, "#mov");
        j.put(d.i, "#vt");
        j.put("secret", "#sec");
        j.put(d.ah, "#prv");
        j.put(d.l, "#$prv");
        j.put(d.m, "#uda");
        j.put(an.a, "#tok");
        j.put(an.aN, "#iv");
        j.put(an.R, "#ast");
        j.put("backstate", "#bst");
        j.put("zdata_ver", "#zv");
        j.put("zdata_req_ts", "#zrt");
        j.put("app_b_v", "#bv");
        j.put("zdata", "#zta");
        j.put(an.ap, "#mt");
        j.put(an.am, "#zsv");
        j.put("others_OS", "#oos");
    }

    public static String a(String str) {
        if (j.containsKey(str)) {
            return j.get(str);
        }
        return str;
    }

    public static void a() {
        if (i != null) {
            i = null;
            e.a();
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
            } catch (Exception e2) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception e3) {
        }
        return jSONObject2;
    }

    private static boolean b() {
        g = UMUtils.getSystemProperty(d, "");
        h = UMUtils.getSystemProperty(e, "");
        return (!TextUtils.isEmpty(g) && !f.equals(g)) && (!TextUtils.isEmpty(h) && !f.equals(h));
    }

    /* JADX WARN: Code duplicated, block: B:129:0x023d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x023f A[Catch: Exception -> 0x022e, TRY_ENTER, TryCatch #0 {Exception -> 0x022e, blocks: (B:118:0x0228, B:130:0x023f, B:132:0x0247, B:133:0x024b, B:135:0x0251, B:137:0x0257, B:139:0x025b, B:141:0x025f), top: B:153:0x0228 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0247 A[Catch: Exception -> 0x022e, TryCatch #0 {Exception -> 0x022e, blocks: (B:118:0x0228, B:130:0x023f, B:132:0x0247, B:133:0x024b, B:135:0x0251, B:137:0x0257, B:139:0x025b, B:141:0x025f), top: B:153:0x0228 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0251 A[Catch: Exception -> 0x022e, TryCatch #0 {Exception -> 0x022e, blocks: (B:118:0x0228, B:130:0x023f, B:132:0x0247, B:133:0x024b, B:135:0x0251, B:137:0x0257, B:139:0x025b, B:141:0x025f), top: B:153:0x0228 }] */
    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        Iterator<String> itKeys;
        String next;
        String str4;
        String strSubstring;
        Envelope envelope;
        String str5;
        JSONObject jSONObjectOptJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        JSONObject jSONObject3 = null;
        if (context == null || jSONObject2 == null) {
            return a(110, (JSONObject) null);
        }
        try {
            JSONObject jSONObjectA = a(context, str2, jSONObject2.has("analytics") && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.has(d.n));
            if (jSONObjectA != null && jSONObject != null) {
                jSONObjectA = a(jSONObjectA, jSONObject);
            }
            if (jSONObjectA != null && jSONObject2 != null) {
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (next2 != null && (next2 instanceof String) && (str5 = next2) != null && jSONObject2.opt(str5) != null) {
                        try {
                            jSONObjectA.put(a(str5), jSONObject2.opt(str5));
                        } catch (Exception e2) {
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = an.aH;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "1.0.0";
            }
            if (jSONObjectA != null) {
                strSubstring = str2 + "==" + str3 + "&=";
                if (TextUtils.isEmpty(strSubstring)) {
                    return a(101, jSONObjectA);
                }
                if (strSubstring.endsWith("&=")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                }
            } else {
                strSubstring = null;
            }
            if (jSONObjectA != null) {
                try {
                    e eVarA = e.a(context);
                    if (eVarA != null) {
                        eVarA.b();
                        String strEncodeToString = Base64.encodeToString(new bf().a(eVarA.c()), 0);
                        if (!TextUtils.isEmpty(strEncodeToString)) {
                            JSONObject jSONObject4 = jSONObjectA.getJSONObject(a("header"));
                            jSONObject4.put(a(an.Y), strEncodeToString);
                            jSONObjectA.put(a("header"), jSONObject4);
                        }
                    }
                } catch (Exception e3) {
                }
            }
            if (jSONObjectA != null && DataHelper.largeThanMaxSize(jSONObjectA.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObjectA);
            }
            if (jSONObjectA != null) {
                Envelope envelopeA = a(context, jSONObjectA.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObjectA);
                }
                envelope = envelopeA;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObjectA);
            }
            int iA = a(context, envelope, strSubstring, jSONObjectA != null ? jSONObjectA.optJSONObject(a("header")).optString(a("app_version")) : null, str);
            if (iA != 0) {
                return a(iA, jSONObjectA);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObjectA.toString().getBytes().length);
            }
            if (!strSubstring.startsWith(an.aD) && !strSubstring.startsWith(an.aC) && !strSubstring.startsWith(an.aI) && !strSubstring.startsWith(an.av) && !com.umeng.commonsdk.stateless.b.a()) {
                new com.umeng.commonsdk.stateless.b(context);
                com.umeng.commonsdk.stateless.b.b();
            }
            return jSONObjectA;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("header", jSONObject);
                    } catch (JSONException e4) {
                    } catch (Exception e5) {
                        e = e5;
                        jSONObject3 = jSONObject5;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                    jSONObject3 = jSONObject5;
                    if (jSONObject2 != null) {
                        if (jSONObject3 == null) {
                            jSONObject3 = new JSONObject();
                        }
                        if (jSONObject2 != null) {
                            itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                next = itKeys.next();
                                if (next == null && (next instanceof String) && (str4 = next) != null && jSONObject2.opt(str4) != null) {
                                    try {
                                        jSONObject3.put(str4, jSONObject2.opt(str4));
                                    } catch (Exception e6) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                }
            } else if (jSONObject2 != null) {
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                if (jSONObject2 != null) {
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
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject3 != null && jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception e2) {
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
            Envelope envelopeA = null;
            if (jSONObject3 != null && (envelopeA = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
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
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable th) {
            }
            if (jSONObject3 != null && jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception e2) {
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
            Envelope envelopeA = null;
            if (jSONObject3 != null && (envelopeA = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
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
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
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
        } catch (Throwable th) {
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x042c A[Catch: Throwable -> 0x0465, TryCatch #4 {Throwable -> 0x0465, blocks: (B:103:0x0426, B:105:0x042c, B:107:0x0432, B:108:0x043f, B:110:0x0445, B:111:0x045b), top: B:188:0x0426 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0445 A[Catch: Throwable -> 0x0465, LOOP:0: B:108:0x043f->B:110:0x0445, LOOP_END, TryCatch #4 {Throwable -> 0x0465, blocks: (B:103:0x0426, B:105:0x042c, B:107:0x0432, B:108:0x043f, B:110:0x0445, B:111:0x045b), top: B:188:0x0426 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0470 A[Catch: Throwable -> 0x047a, TRY_LEAVE, TryCatch #0 {Throwable -> 0x047a, blocks: (B:114:0x0466, B:116:0x0470), top: B:180:0x0466 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0493 A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:124:0x04a6 A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:127:0x04b9 A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:130:0x04cc A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:133:0x04df A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:136:0x04f2 A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0505 A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0518 A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:145:0x052b A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:148:0x053e A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0551 A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0564 A[Catch: Throwable -> 0x0579, TryCatch #14 {Throwable -> 0x0579, blocks: (B:119:0x047b, B:121:0x0493, B:122:0x049e, B:124:0x04a6, B:125:0x04b1, B:127:0x04b9, B:128:0x04c4, B:130:0x04cc, B:131:0x04d7, B:133:0x04df, B:134:0x04ea, B:136:0x04f2, B:137:0x04fd, B:139:0x0505, B:140:0x0510, B:142:0x0518, B:143:0x0523, B:145:0x052b, B:146:0x0536, B:148:0x053e, B:149:0x0549, B:151:0x0551, B:152:0x055c, B:154:0x0564, B:155:0x056f), top: B:207:0x047b }] */
    /* JADX WARN: Code duplicated, block: B:160:0x0584 A[Catch: Throwable -> 0x058e, TRY_LEAVE, TryCatch #9 {Throwable -> 0x058e, blocks: (B:158:0x057a, B:160:0x0584), top: B:197:0x057a }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0599 A[Catch: Throwable -> 0x05c7, TRY_LEAVE, TryCatch #5 {Throwable -> 0x05c7, blocks: (B:3:0x0001, B:6:0x0010, B:57:0x02d4, B:60:0x02e3, B:62:0x031a, B:63:0x0323, B:65:0x032b, B:68:0x0338, B:69:0x0352, B:71:0x035c, B:75:0x036a, B:77:0x0376, B:81:0x0384, B:95:0x03e0, B:97:0x03e8, B:163:0x058f, B:165:0x0599, B:167:0x059c, B:170:0x05ab, B:172:0x05b0, B:174:0x05b6, B:80:0x0381, B:74:0x0367, B:10:0x001d, B:12:0x008e, B:14:0x00a5, B:16:0x00ad, B:18:0x00b7, B:19:0x00c0, B:21:0x00ca, B:22:0x00d3, B:24:0x00dd, B:25:0x00e6, B:27:0x0174, B:28:0x0195, B:30:0x01f1, B:35:0x021e, B:37:0x0228, B:38:0x0233, B:40:0x0239, B:42:0x0250, B:44:0x0286, B:45:0x0291, B:47:0x02a4, B:54:0x02cb, B:41:0x0245, B:31:0x01fd, B:33:0x0207, B:34:0x0213, B:13:0x009a), top: B:190:0x0001, inners: #7, #12, #13 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x05ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:172:0x05b0 A[Catch: Throwable -> 0x05c7, TryCatch #5 {Throwable -> 0x05c7, blocks: (B:3:0x0001, B:6:0x0010, B:57:0x02d4, B:60:0x02e3, B:62:0x031a, B:63:0x0323, B:65:0x032b, B:68:0x0338, B:69:0x0352, B:71:0x035c, B:75:0x036a, B:77:0x0376, B:81:0x0384, B:95:0x03e0, B:97:0x03e8, B:163:0x058f, B:165:0x0599, B:167:0x059c, B:170:0x05ab, B:172:0x05b0, B:174:0x05b6, B:80:0x0381, B:74:0x0367, B:10:0x001d, B:12:0x008e, B:14:0x00a5, B:16:0x00ad, B:18:0x00b7, B:19:0x00c0, B:21:0x00ca, B:22:0x00d3, B:24:0x00dd, B:25:0x00e6, B:27:0x0174, B:28:0x0195, B:30:0x01f1, B:35:0x021e, B:37:0x0228, B:38:0x0233, B:40:0x0239, B:42:0x0250, B:44:0x0286, B:45:0x0291, B:47:0x02a4, B:54:0x02cb, B:41:0x0245, B:31:0x01fd, B:33:0x0207, B:34:0x0213, B:13:0x009a), top: B:190:0x0001, inners: #7, #12, #13 }] */
    /* JADX WARN: Code duplicated, block: B:199:0x0384 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0376 A[Catch: Exception -> 0x0380, Throwable -> 0x05c7, TRY_LEAVE, TryCatch #7 {Exception -> 0x0380, blocks: (B:75:0x036a, B:77:0x0376), top: B:193:0x036a, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x03b1 A[Catch: Throwable -> 0x03c9, TryCatch #6 {Throwable -> 0x03c9, blocks: (B:84:0x039c, B:86:0x03b1, B:87:0x03bd), top: B:192:0x039c }] */
    /* JADX WARN: Code duplicated, block: B:87:0x03bd A[Catch: Throwable -> 0x03c9, TRY_LEAVE, TryCatch #6 {Throwable -> 0x03c9, blocks: (B:84:0x039c, B:86:0x03b1, B:87:0x03bd), top: B:192:0x039c }] */
    /* JADX WARN: Code duplicated, block: B:92:0x03d0 A[Catch: Throwable -> 0x03df, TRY_LEAVE, TryCatch #1 {Throwable -> 0x03df, blocks: (B:90:0x03ca, B:92:0x03d0), top: B:182:0x03ca }] */
    /* JADX WARN: Code duplicated, block: B:97:0x03e8 A[Catch: Throwable -> 0x05c7, TRY_LEAVE, TryCatch #5 {Throwable -> 0x05c7, blocks: (B:3:0x0001, B:6:0x0010, B:57:0x02d4, B:60:0x02e3, B:62:0x031a, B:63:0x0323, B:65:0x032b, B:68:0x0338, B:69:0x0352, B:71:0x035c, B:75:0x036a, B:77:0x0376, B:81:0x0384, B:95:0x03e0, B:97:0x03e8, B:163:0x058f, B:165:0x0599, B:167:0x059c, B:170:0x05ab, B:172:0x05b0, B:174:0x05b6, B:80:0x0381, B:74:0x0367, B:10:0x001d, B:12:0x008e, B:14:0x00a5, B:16:0x00ad, B:18:0x00b7, B:19:0x00c0, B:21:0x00ca, B:22:0x00d3, B:24:0x00dd, B:25:0x00e6, B:27:0x0174, B:28:0x0195, B:30:0x01f1, B:35:0x021e, B:37:0x0228, B:38:0x0233, B:40:0x0239, B:42:0x0250, B:44:0x0286, B:45:0x0291, B:47:0x02a4, B:54:0x02cb, B:41:0x0245, B:31:0x01fd, B:33:0x0207, B:34:0x0213, B:13:0x009a), top: B:190:0x0001, inners: #7, #12, #13 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x03f0 A[ADDED_TO_REGION] */
    private static JSONObject a(Context context, String str, boolean z) {
        JSONObject jSONObject;
        byte[] bArrA;
        String apmFlag;
        JSONObject jSONObject2;
        String realTimeDebugKey;
        Map<String, String> moduleTags;
        JSONObject jSONObject3;
        boolean zCheckPermission;
        String strImprintProperty;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(i)) {
                try {
                    jSONObject = new JSONObject(i);
                } catch (Exception e2) {
                    jSONObject = null;
                }
            } else {
                UMUtils.saveSDKComponent();
                jSONObject = new JSONObject();
                jSONObject.put(a(an.p), DeviceConfig.getAppMD5Signature(context));
                jSONObject.put(a(an.q), DeviceConfig.getAppSHA1Key(context));
                jSONObject.put(a(an.r), DeviceConfig.getAppHashKey(context));
                jSONObject.put(a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject.put(a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject.put(a(an.v), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject.put(a("cpu"), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject.put(a(an.B), mccmnc);
                    b = mccmnc;
                } else {
                    jSONObject.put(a(an.B), "");
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject.put(a(an.K), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject.put(a(an.L), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject.put(a(an.ai), deviceType);
                }
                jSONObject.put(a("package_name"), DeviceConfig.getPackageName(context));
                jSONObject.put(a(an.u), "Android");
                jSONObject.put(a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject.put(a("device_model"), Build.MODEL);
                jSONObject.put(a(an.E), Build.BOARD);
                jSONObject.put(a(an.F), Build.BRAND);
                jSONObject.put(a(an.G), Build.TIME);
                jSONObject.put(a(an.H), Build.MANUFACTURER);
                jSONObject.put(a(an.I), Build.ID);
                jSONObject.put(a(an.J), Build.DEVICE);
                jSONObject.put(a(an.y), Build.VERSION.RELEASE);
                jSONObject.put(a("os"), "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject.put(a(an.z), resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject.put(a(an.A), DeviceConfig.getMac(context));
                jSONObject.put(a(an.M), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject.put(a(an.O), localeInfo[0]);
                jSONObject.put(a("language"), localeInfo[1]);
                jSONObject.put(a(an.P), DeviceConfig.getNetworkOperatorName(context));
                jSONObject.put(a(an.s), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject.put(a(an.Q), NetworkUtil.NETWORK_TYPE_WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject.put(a(an.Q), "2G/3G");
                } else {
                    jSONObject.put(a(an.Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject.put(a(an.R), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject.put(a("others_OS"), "harmony");
                } else {
                    jSONObject.put(a("others_OS"), "Android");
                }
                jSONObject.put(a("network_type"), DeviceConfig.getNetworkType(context));
                jSONObject.put(a(an.b), "9.5.3");
                jSONObject.put(a(an.c), SdkVersion.SDK_TYPE);
                jSONObject.put(a(an.d), "1");
                if (!TextUtils.isEmpty(a)) {
                    jSONObject.put(a(an.e), a);
                }
                jSONObject.put(a(an.aj), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject.put(a(an.af), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject.put(a("session_id"), uUIDForZid);
                } catch (Throwable th) {
                }
                i = jSONObject.toString();
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(a(an.ak), UMUtils.getOaidRequiredTime(context));
            } catch (Exception e3) {
            }
            try {
                jSONObject.put(a(an.U), sharedPreferences.getInt("successful_request", 0));
                jSONObject.put(a(an.V), sharedPreferences.getInt(an.V, 0));
                jSONObject.put(a(an.W), sharedPreferences.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(a(an.al), zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(a(an.am), UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception e4) {
            }
            jSONObject.put(a("channel"), UMUtils.getChannel(context));
            jSONObject.put(a("appkey"), UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (TextUtils.isEmpty(deviceToken)) {
                    strImprintProperty = UMEnvelopeBuild.imprintProperty(context, an.g, null);
                    if (!TextUtils.isEmpty(strImprintProperty)) {
                        jSONObject.put(a(an.g), strImprintProperty);
                        jSONObject.put(a("wrapper_type"), a.a);
                        jSONObject.put(a("wrapper_version"), a.b);
                        int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                        zCheckPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                        jSONObject.put(a(an.aV), targetSdkVersion);
                        if (zCheckPermission) {
                            jSONObject.put(a(an.aW), "yes");
                        } else {
                            jSONObject.put(a(an.aW), "no");
                        }
                        if (b()) {
                            jSONObject.put("umTaskId", g);
                            jSONObject.put("umCaseId", h);
                        }
                        if (!an.aI.equals(str)) {
                            int[] iArrB = b(context);
                            jSONObject.put(a(an.bp), String.valueOf(iArrB[0]) + String.valueOf(iArrB[1]) + String.valueOf(iArrB[2]));
                        } else {
                            int[] iArrB2 = b(context);
                            jSONObject.put(a(an.bp), String.valueOf(iArrB2[0]) + String.valueOf(iArrB2[1]) + String.valueOf(iArrB2[2]));
                        }
                        moduleTags = TagHelper.getModuleTags();
                        if (moduleTags != null) {
                            jSONObject3 = new JSONObject();
                            for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                                jSONObject3.put(entry.getKey(), entry.getValue());
                            }
                            jSONObject.put(a(an.ap), jSONObject3);
                        }
                        realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                        if (!TextUtils.isEmpty(realTimeDebugKey)) {
                            jSONObject.put(a(an.bo), realTimeDebugKey);
                        }
                        jSONObject2 = new JSONObject();
                        jSONObject2.put(a(an.ba), com.umeng.commonsdk.internal.a.e);
                        if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                            jSONObject2.put(a(an.bb), UMUtils.VALUE_ANALYTICS_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                            jSONObject2.put(a(an.bc), UMUtils.VALUE_GAME_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                            jSONObject2.put(a(an.bd), UMUtils.VALUE_PUSH_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                            jSONObject2.put(a(an.be), UMUtils.VALUE_SHARE_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                            jSONObject2.put(a(an.bf), UMUtils.VALUE_APM_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                            jSONObject2.put(a(an.bg), UMUtils.VALUE_VERIFY_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                            jSONObject2.put(a(an.bh), UMUtils.VALUE_SMS_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                            jSONObject2.put(a(an.bi), UMUtils.VALUE_REC_VERSION_NAME);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                            jSONObject2.put(a(an.bj), UMUtils.VALUE_VISUAL_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                            jSONObject2.put(a(an.bk), UMUtils.VALUE_ASMS_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                            jSONObject2.put(a(an.bl), UMUtils.VALUE_LINK_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                            jSONObject2.put(a(an.bm), UMUtils.VALUE_ABTEST_VERSION);
                        }
                        jSONObject.put(a(an.aZ), jSONObject2);
                        apmFlag = UMUtils.getApmFlag();
                        if (!TextUtils.isEmpty(apmFlag)) {
                            jSONObject.put(a(an.bn), apmFlag);
                        }
                        bArrA = ImprintHandler.getImprintService(context).a();
                        if (bArrA == null) {
                            if (jSONObject != null) {
                                return new JSONObject().put(a("header"), jSONObject);
                            }
                        } else if (jSONObject != null) {
                            return new JSONObject().put(a("header"), jSONObject);
                        }
                    } else {
                        jSONObject.put(a("wrapper_type"), a.a);
                        jSONObject.put(a("wrapper_version"), a.b);
                        int targetSdkVersion2 = UMUtils.getTargetSdkVersion(context);
                        zCheckPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                        jSONObject.put(a(an.aV), targetSdkVersion2);
                        if (zCheckPermission) {
                            jSONObject.put(a(an.aW), "yes");
                        } else {
                            jSONObject.put(a(an.aW), "no");
                        }
                        if (b()) {
                            jSONObject.put("umTaskId", g);
                            jSONObject.put("umCaseId", h);
                        }
                        if (!an.aI.equals(str)) {
                            int[] iArrB3 = b(context);
                            jSONObject.put(a(an.bp), String.valueOf(iArrB3[0]) + String.valueOf(iArrB3[1]) + String.valueOf(iArrB3[2]));
                        } else {
                            int[] iArrB4 = b(context);
                            jSONObject.put(a(an.bp), String.valueOf(iArrB4[0]) + String.valueOf(iArrB4[1]) + String.valueOf(iArrB4[2]));
                        }
                        moduleTags = TagHelper.getModuleTags();
                        if (moduleTags != null) {
                            jSONObject3 = new JSONObject();
                            while (r10.hasNext()) {
                                jSONObject3.put(entry.getKey(), entry.getValue());
                            }
                            jSONObject.put(a(an.ap), jSONObject3);
                        }
                        realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                        if (!TextUtils.isEmpty(realTimeDebugKey)) {
                            jSONObject.put(a(an.bo), realTimeDebugKey);
                        }
                        jSONObject2 = new JSONObject();
                        jSONObject2.put(a(an.ba), com.umeng.commonsdk.internal.a.e);
                        if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                            jSONObject2.put(a(an.bb), UMUtils.VALUE_ANALYTICS_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                            jSONObject2.put(a(an.bc), UMUtils.VALUE_GAME_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                            jSONObject2.put(a(an.bd), UMUtils.VALUE_PUSH_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                            jSONObject2.put(a(an.be), UMUtils.VALUE_SHARE_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                            jSONObject2.put(a(an.bf), UMUtils.VALUE_APM_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                            jSONObject2.put(a(an.bg), UMUtils.VALUE_VERIFY_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                            jSONObject2.put(a(an.bh), UMUtils.VALUE_SMS_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                            jSONObject2.put(a(an.bi), UMUtils.VALUE_REC_VERSION_NAME);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                            jSONObject2.put(a(an.bj), UMUtils.VALUE_VISUAL_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                            jSONObject2.put(a(an.bk), UMUtils.VALUE_ASMS_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                            jSONObject2.put(a(an.bl), UMUtils.VALUE_LINK_VERSION);
                        }
                        if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                            jSONObject2.put(a(an.bm), UMUtils.VALUE_ABTEST_VERSION);
                        }
                        jSONObject.put(a(an.aZ), jSONObject2);
                        apmFlag = UMUtils.getApmFlag();
                        if (!TextUtils.isEmpty(apmFlag)) {
                            jSONObject.put(a(an.bn), apmFlag);
                        }
                        bArrA = ImprintHandler.getImprintService(context).a();
                        if (bArrA == null) {
                            if (jSONObject != null) {
                                return new JSONObject().put(a("header"), jSONObject);
                            }
                        } else if (jSONObject != null) {
                            return new JSONObject().put(a("header"), jSONObject);
                        }
                    }
                } else {
                    jSONObject.put(a(an.a), deviceToken);
                    try {
                        strImprintProperty = UMEnvelopeBuild.imprintProperty(context, an.g, null);
                        if (!TextUtils.isEmpty(strImprintProperty)) {
                            jSONObject.put(a(an.g), strImprintProperty);
                            try {
                                jSONObject.put(a("wrapper_type"), a.a);
                                jSONObject.put(a("wrapper_version"), a.b);
                            } catch (Exception e5) {
                            }
                            try {
                                int targetSdkVersion3 = UMUtils.getTargetSdkVersion(context);
                                zCheckPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                                jSONObject.put(a(an.aV), targetSdkVersion3);
                                if (zCheckPermission) {
                                    jSONObject.put(a(an.aW), "yes");
                                } else {
                                    jSONObject.put(a(an.aW), "no");
                                }
                            } catch (Throwable th2) {
                            }
                            try {
                                if (b()) {
                                    jSONObject.put("umTaskId", g);
                                    jSONObject.put("umCaseId", h);
                                }
                            } catch (Throwable th3) {
                            }
                            if ((!an.aI.equals(str) || an.av.equals(str)) && z) {
                                try {
                                    int[] iArrB5 = b(context);
                                    jSONObject.put(a(an.bp), String.valueOf(iArrB5[0]) + String.valueOf(iArrB5[1]) + String.valueOf(iArrB5[2]));
                                } catch (Throwable th4) {
                                }
                            }
                            try {
                                moduleTags = TagHelper.getModuleTags();
                                if (moduleTags != null && moduleTags.size() > 0) {
                                    jSONObject3 = new JSONObject();
                                    while (r10.hasNext()) {
                                        jSONObject3.put(entry.getKey(), entry.getValue());
                                    }
                                    jSONObject.put(a(an.ap), jSONObject3);
                                }
                            } catch (Throwable th5) {
                            }
                            try {
                                realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                                    jSONObject.put(a(an.bo), realTimeDebugKey);
                                }
                            } catch (Throwable th6) {
                            }
                            try {
                                jSONObject2 = new JSONObject();
                                jSONObject2.put(a(an.ba), com.umeng.commonsdk.internal.a.e);
                                if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                                    jSONObject2.put(a(an.bb), UMUtils.VALUE_ANALYTICS_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                                    jSONObject2.put(a(an.bc), UMUtils.VALUE_GAME_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                                    jSONObject2.put(a(an.bd), UMUtils.VALUE_PUSH_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                                    jSONObject2.put(a(an.be), UMUtils.VALUE_SHARE_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                                    jSONObject2.put(a(an.bf), UMUtils.VALUE_APM_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                                    jSONObject2.put(a(an.bg), UMUtils.VALUE_VERIFY_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                                    jSONObject2.put(a(an.bh), UMUtils.VALUE_SMS_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                                    jSONObject2.put(a(an.bi), UMUtils.VALUE_REC_VERSION_NAME);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                                    jSONObject2.put(a(an.bj), UMUtils.VALUE_VISUAL_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                                    jSONObject2.put(a(an.bk), UMUtils.VALUE_ASMS_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                                    jSONObject2.put(a(an.bl), UMUtils.VALUE_LINK_VERSION);
                                }
                                if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                                    jSONObject2.put(a(an.bm), UMUtils.VALUE_ABTEST_VERSION);
                                }
                                jSONObject.put(a(an.aZ), jSONObject2);
                            } catch (Throwable th7) {
                            }
                            try {
                                apmFlag = UMUtils.getApmFlag();
                                if (!TextUtils.isEmpty(apmFlag)) {
                                    jSONObject.put(a(an.bn), apmFlag);
                                }
                            } catch (Throwable th8) {
                            }
                            bArrA = ImprintHandler.getImprintService(context).a();
                            if (bArrA == null && bArrA.length > 0) {
                                try {
                                    jSONObject.put(a(an.X), Base64.encodeToString(bArrA, 0));
                                } catch (JSONException e6) {
                                    UMCrashManager.reportCrash(context, e6);
                                }
                                if (jSONObject != null) {
                                    return new JSONObject().put(a("header"), jSONObject);
                                }
                            } else if (jSONObject != null && jSONObject.length() > 0) {
                                return new JSONObject().put(a("header"), jSONObject);
                            }
                        } else {
                            jSONObject.put(a("wrapper_type"), a.a);
                            jSONObject.put(a("wrapper_version"), a.b);
                            int targetSdkVersion4 = UMUtils.getTargetSdkVersion(context);
                            zCheckPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                            jSONObject.put(a(an.aV), targetSdkVersion4);
                            if (zCheckPermission) {
                                jSONObject.put(a(an.aW), "yes");
                            } else {
                                jSONObject.put(a(an.aW), "no");
                            }
                            if (b()) {
                                jSONObject.put("umTaskId", g);
                                jSONObject.put("umCaseId", h);
                            }
                            if (!an.aI.equals(str)) {
                                int[] iArrB6 = b(context);
                                jSONObject.put(a(an.bp), String.valueOf(iArrB6[0]) + String.valueOf(iArrB6[1]) + String.valueOf(iArrB6[2]));
                            } else {
                                int[] iArrB7 = b(context);
                                jSONObject.put(a(an.bp), String.valueOf(iArrB7[0]) + String.valueOf(iArrB7[1]) + String.valueOf(iArrB7[2]));
                            }
                            moduleTags = TagHelper.getModuleTags();
                            if (moduleTags != null) {
                                jSONObject3 = new JSONObject();
                                while (r10.hasNext()) {
                                    jSONObject3.put(entry.getKey(), entry.getValue());
                                }
                                jSONObject.put(a(an.ap), jSONObject3);
                            }
                            realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                            if (!TextUtils.isEmpty(realTimeDebugKey)) {
                                jSONObject.put(a(an.bo), realTimeDebugKey);
                            }
                            jSONObject2 = new JSONObject();
                            jSONObject2.put(a(an.ba), com.umeng.commonsdk.internal.a.e);
                            if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                                jSONObject2.put(a(an.bb), UMUtils.VALUE_ANALYTICS_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                                jSONObject2.put(a(an.bc), UMUtils.VALUE_GAME_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                                jSONObject2.put(a(an.bd), UMUtils.VALUE_PUSH_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                                jSONObject2.put(a(an.be), UMUtils.VALUE_SHARE_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                                jSONObject2.put(a(an.bf), UMUtils.VALUE_APM_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                                jSONObject2.put(a(an.bg), UMUtils.VALUE_VERIFY_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                                jSONObject2.put(a(an.bh), UMUtils.VALUE_SMS_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                                jSONObject2.put(a(an.bi), UMUtils.VALUE_REC_VERSION_NAME);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                                jSONObject2.put(a(an.bj), UMUtils.VALUE_VISUAL_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                                jSONObject2.put(a(an.bk), UMUtils.VALUE_ASMS_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                                jSONObject2.put(a(an.bl), UMUtils.VALUE_LINK_VERSION);
                            }
                            if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                                jSONObject2.put(a(an.bm), UMUtils.VALUE_ABTEST_VERSION);
                            }
                            jSONObject.put(a(an.aZ), jSONObject2);
                            apmFlag = UMUtils.getApmFlag();
                            if (!TextUtils.isEmpty(apmFlag)) {
                                jSONObject.put(a(an.bn), apmFlag);
                            }
                            bArrA = ImprintHandler.getImprintService(context).a();
                            if (bArrA == null) {
                                if (jSONObject != null) {
                                    return new JSONObject().put(a("header"), jSONObject);
                                }
                            } else if (jSONObject != null) {
                                return new JSONObject().put(a("header"), jSONObject);
                            }
                        }
                    } catch (Exception e7) {
                        UMCrashManager.reportCrash(context, e7);
                    }
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(context, e8);
            }
        } catch (Throwable th9) {
            UMCrashManager.reportCrash(context, th9);
        }
        return null;
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
                        if (str.equals(a(d.i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.k = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception e2) {
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
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(strB);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith(an.aG)) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith(an.aG)) {
            return 122;
        }
        if (str.startsWith(an.aD) || str.startsWith(an.aC) || str.startsWith(an.av) || str.startsWith(an.aI)) {
            return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
        }
        return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f, sb.toString(), binary);
    }

    public static void a(boolean z) {
        l = z;
    }
}
