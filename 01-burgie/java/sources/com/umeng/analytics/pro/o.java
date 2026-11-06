package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CoreProtocolImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {
    private static final String l = "first_activate_time";
    private static final String m = "ana_is_f";
    private static final String n = "thtstart";
    private static final String o = "dstk_last_time";
    private static final String p = "dstk_cnt";
    private static final String q = "gkvc";
    private static final String r = "ekvc";
    private static final String t = "-1";
    private static final String x = "com.umeng.umcrash.UMCrashUtils";
    private c b;
    private SharedPreferences c;
    private String d;
    private String e;
    private int f;
    private JSONArray g;
    private final int h;
    private int i;
    private int j;
    private long k;
    private final long s;
    private boolean u;
    private boolean v;
    private Object w;
    private static Context a = null;
    private static Class<?> y = null;
    private static Method z = null;

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class a {
        public static final int A = 8210;
        public static final int B = 8211;
        public static final int C = 8212;
        public static final int D = 8213;
        public static final int E = 8214;
        public static final int F = 8215;
        public static final int a = 4097;
        public static final int b = 4098;
        public static final int c = 4099;
        public static final int d = 4100;
        public static final int e = 4101;
        public static final int f = 4102;
        public static final int g = 4103;
        public static final int h = 4104;
        public static final int i = 4105;
        public static final int j = 4106;
        public static final int k = 4352;
        public static final int l = 4353;
        public static final int m = 4354;
        public static final int n = 4355;
        public static final int o = 4356;
        public static final int p = 4357;
        public static final int q = 8193;
        public static final int r = 8194;
        public static final int s = 8195;
        public static final int t = 8196;
        public static final int u = 8197;
        public static final int v = 8199;
        public static final int w = 8200;
        public static final int x = 8201;
        public static final int y = 8208;
        public static final int z = 8209;
    }

    static {
        h();
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName(x);
            if (cls != null) {
                y = cls;
                Method declaredMethod = y.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
                if (declaredMethod != null) {
                    z = declaredMethod;
                }
            }
        } catch (Throwable th) {
        }
    }

    private o() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 10;
        this.g = new JSONArray();
        this.h = 5000;
        this.i = 0;
        this.j = 0;
        this.k = 0L;
        this.s = 28800000L;
        this.u = false;
        this.v = false;
        this.w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            this.k = sharedPreferences.getLong(n, 0L);
            this.i = sharedPreferences.getInt(q, 0);
            this.j = sharedPreferences.getInt(r, 0);
            this.b = new c();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    private static class b {
        private static final o a = new o();

        private b() {
        }
    }

    public static o a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return b.a;
    }

    public void a() {
        if (a != null) {
            synchronized (this.w) {
                if (this.u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(a, a.l, CoreProtocol.getInstance(a), null);
                }
            }
            synchronized (this.w) {
                if (this.v) {
                    UMWorkDispatch.sendEvent(a, a.m, CoreProtocol.getInstance(a), null);
                }
            }
        }
    }

    public void b() {
    }

    public void c() throws Throwable {
        b(a);
        d();
        a(true);
    }

    private void a(String str, String str2) {
        if (y != null && z != null) {
            try {
                z.invoke(y, str, str2);
            } catch (Throwable th) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
            }
        }
    }

    public void a(Object obj, int i) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i == 4357) {
                try {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                    h.a(a);
                    com.umeng.commonsdk.utils.c.c(a);
                } catch (Throwable th) {
                }
            } else {
                return;
            }
        }
        if (!AnalyticsConfig.enable) {
            return;
        }
        switch (i) {
            case 4097:
                try {
                    if (UMUtils.isMainProgress(a)) {
                        if (obj != null) {
                            e(obj);
                        }
                        if (!t.equals(((JSONObject) obj).optString("__i"))) {
                            a(false);
                            return;
                        }
                        return;
                    }
                    UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                    return;
                } catch (Throwable th2) {
                    return;
                }
            case 4098:
                if (obj != null) {
                    try {
                        e(obj);
                    } catch (Throwable th3) {
                        return;
                    }
                }
                if (!t.equals(((JSONObject) obj).optString("__i"))) {
                    a(false);
                    return;
                }
                return;
            case 4099:
                v.a(a);
                return;
            case a.d /* 4100 */:
                l.c(a);
                return;
            case a.e /* 4101 */:
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                a((Object) null, true);
                g(obj);
                return;
            case a.f /* 4102 */:
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                a((Object) null, true);
                f(obj);
                return;
            case a.g /* 4103 */:
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                u.a().a(a, obj);
                synchronized (this.w) {
                    this.v = true;
                    break;
                }
                return;
            case a.h /* 4104 */:
                u.a().c(a, obj);
                return;
            case a.i /* 4105 */:
                d();
                return;
            case a.j /* 4106 */:
                h(obj);
                return;
            default:
                switch (i) {
                    case 4352:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                        u.a().b(a, obj);
                        synchronized (this.w) {
                            this.u = true;
                            break;
                        }
                        return;
                    case a.l /* 4353 */:
                        a(obj, true);
                        return;
                    case a.m /* 4354 */:
                        c();
                        return;
                    case a.n /* 4355 */:
                        try {
                            if (UMUtils.isMainProgress(a)) {
                                if (obj != null) {
                                    e(obj);
                                    d();
                                }
                            } else {
                                UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                            }
                            return;
                        } catch (Throwable th4) {
                            return;
                        }
                    case a.o /* 4356 */:
                        if (obj == null || y == null || z == null) {
                            return;
                        }
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                        try {
                            String string = "";
                            String string2 = "";
                            if (obj instanceof JSONObject) {
                                JSONObject jSONObject = (JSONObject) obj;
                                if (jSONObject.has("uid") && jSONObject.has("provider")) {
                                    string = jSONObject.getString("provider");
                                    string2 = jSONObject.getString("uid");
                                }
                                a(string2, string);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            return;
                        }
                    default:
                        switch (i) {
                            case a.s /* 8195 */:
                                com.umeng.analytics.b.a().a(obj);
                                return;
                            case a.t /* 8196 */:
                                com.umeng.analytics.b.a().m();
                                return;
                            case a.u /* 8197 */:
                                com.umeng.analytics.b.a().k();
                                return;
                            default:
                                switch (i) {
                                    case a.v /* 8199 */:
                                    case a.w /* 8200 */:
                                        com.umeng.analytics.b.a().b(obj);
                                        return;
                                    case a.x /* 8201 */:
                                        com.umeng.analytics.b.a().b((Object) null);
                                        return;
                                    default:
                                        switch (i) {
                                            case a.y /* 8208 */:
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                UMWorkDispatch.sendEvent(a, a.z, CoreProtocol.getInstance(a), null);
                                                UMWorkDispatch.sendEvent(a, a.m, CoreProtocol.getInstance(a), null);
                                                return;
                                            case a.z /* 8209 */:
                                                a(obj, false);
                                                return;
                                            case a.A /* 8210 */:
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                try {
                                                    if (!UMUtils.isMainProgress(a) || (this.b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                        return;
                                                    }
                                                    a(true);
                                                    return;
                                                } catch (Throwable th6) {
                                                    return;
                                                }
                                            default:
                                                switch (i) {
                                                    case a.D /* 8213 */:
                                                        if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                            if (DeviceConfig.getGlobleActivity(a) != null) {
                                                                u.b(a);
                                                            }
                                                            UMWorkDispatch.sendEventEx(a, a.D, CoreProtocol.getInstance(a), null, 5000L);
                                                            return;
                                                        }
                                                        return;
                                                    case a.E /* 8214 */:
                                                        if (obj != null && (obj instanceof JSONObject)) {
                                                            try {
                                                                String strOptString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                String strOptString2 = ((JSONObject) obj).optString(AnalyticsConfig.RTD_PERIOD);
                                                                String strOptString3 = ((JSONObject) obj).optString("debugkey");
                                                                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                                                                    com.umeng.common.b.a(a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME, strOptString);
                                                                    com.umeng.common.b.a(a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_PERIOD, strOptString2);
                                                                    com.umeng.common.b.a(a, AnalyticsConfig.RTD_SP_FILE, "debugkey", strOptString3);
                                                                    return;
                                                                }
                                                                return;
                                                            } catch (Throwable th7) {
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    case a.F /* 8215 */:
                                                        com.umeng.common.b.a(a, AnalyticsConfig.RTD_SP_FILE);
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public void a(boolean z2) throws Throwable {
        if (c(z2)) {
            if (this.b.c() instanceof ReportPolicy.ReportQuasiRealtime) {
                if (z2) {
                    if (UMEnvelopeBuild.isOnline(a)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                        j();
                        return;
                    }
                    return;
                }
                if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                j();
            }
        }
    }

    private void i() throws Throwable {
        JSONObject jSONObjectB = b(UMEnvelopeBuild.maxDataSpace(a));
        if (jSONObjectB == null || jSONObjectB.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectB.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectB.opt("content");
        if (a != null && jSONObject != null && jSONObject2 != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
            JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a, jSONObject, jSONObject2);
            if (jSONObjectBuildEnvelopeWithExtHeader != null) {
                try {
                    if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
                    }
                } catch (Throwable th) {
                }
                if (UMConfigure.isDebugLog()) {
                    e(jSONObjectBuildEnvelopeWithExtHeader);
                }
                b((Object) jSONObjectBuildEnvelopeWithExtHeader);
            }
        }
    }

    private void j() throws Throwable {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        JSONObject jSONObjectA = a(UMEnvelopeBuild.maxDataSpace(a));
        if (jSONObjectA == null || jSONObjectA.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectA.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectA.opt("content");
        if (a != null && jSONObject != null && jSONObject2 != null && (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a, jSONObject, jSONObject2)) != null) {
            try {
                if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable th) {
            }
            if (UMConfigure.isDebugLog()) {
                d(jSONObjectBuildEnvelopeWithExtHeader);
            }
            a((Object) jSONObjectBuildEnvelopeWithExtHeader);
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List listAsList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && listAsList.contains(jSONObjectOptJSONObject.optString("id"))) {
                    i++;
                }
            } catch (Throwable th) {
            }
        }
        return i >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ekv");
        int length = jSONArrayOptJSONArray.length();
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                        if (jSONArrayOptJSONArray2 != null && a(jSONArrayOptJSONArray2)) {
                            i++;
                        }
                    }
                } catch (Throwable th) {
                }
            }
            if (i >= length) {
                return true;
            }
        }
        return false;
    }

    public JSONObject a(long j) throws Throwable {
        if (TextUtils.isEmpty(y.a().d(a))) {
            return null;
        }
        JSONObject jSONObjectB = b(false);
        int iA = r.a().a(a);
        if (jSONObjectB.length() <= 0) {
            if (iA != 3) {
                return null;
            }
        } else {
            if (jSONObjectB.length() == 1) {
                if (jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && iA != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                    return null;
                }
            } else if (jSONObjectB.length() == 2 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && !TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                return null;
            }
            String strOptString = jSONObjectB.optString(com.umeng.analytics.pro.d.n);
            String strOptString2 = jSONObjectB.optString(com.umeng.analytics.pro.d.T);
            String strOptString3 = jSONObjectB.optString("ekv");
            if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && a(jSONObjectB)) {
                return null;
            }
        }
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            c(jSONObjectL);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (iA == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject2.put("analytics", jSONObjectB);
            }
            if (jSONObjectL != null && jSONObjectL.length() > 0) {
                jSONObject.put("header", jSONObjectL);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j);
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    private void b(JSONObject jSONObject) {
        JSONObject jSONObjectF;
        if (!i.a(UMGlobalContext.getAppContext(a)).c() && (jSONObjectF = i.a(UMGlobalContext.getAppContext(a)).f()) != null) {
            String strOptString = jSONObjectF.optString("__av");
            String strOptString2 = jSONObjectF.optString("__vc");
            try {
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(a));
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), strOptString);
                }
                if (TextUtils.isEmpty(strOptString2)) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(a));
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), strOptString2);
                }
            } catch (Throwable th) {
            }
        }
    }

    public JSONObject b(long j) throws Throwable {
        if (TextUtils.isEmpty(y.a().d(UMGlobalContext.getAppContext(a)))) {
            return null;
        }
        JSONObject jSONObjectB = i.a(UMGlobalContext.getAppContext(a)).b(false);
        String[] strArrA = com.umeng.analytics.c.a(a);
        if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", strArrA[0]);
                jSONObject.put(com.umeng.analytics.pro.d.N, strArrA[1]);
                if (jSONObject.length() > 0) {
                    jSONObjectB.put(com.umeng.analytics.pro.d.L, jSONObject);
                }
            } catch (Throwable th) {
            }
        }
        int iA = r.a().a(a);
        if (jSONObjectB.length() == 1 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && iA != 3) {
            return null;
        }
        r.a().b(jSONObjectB, a);
        if (jSONObjectB.length() <= 0 && iA != 3) {
            return null;
        }
        JSONObject jSONObjectK = k();
        if (jSONObjectK != null) {
            b(jSONObjectK);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (iA == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject3.put("analytics", jSONObjectB);
            }
            if (jSONObjectK != null && jSONObjectK.length() > 0) {
                jSONObject2.put("header", jSONObjectK);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j);
        } catch (Throwable th2) {
            return jSONObject2;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j) {
        try {
            if (q.a(jSONObject) > j) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("header");
                jSONObject2.put(com.umeng.analytics.pro.d.aB, q.a(jSONObject));
                jSONObject.put("header", jSONObject2);
                return q.a(a, j, jSONObject);
            }
            return jSONObject;
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    private JSONObject b(JSONObject jSONObject, long j) {
        try {
            if (q.a(jSONObject) > j) {
                jSONObject = null;
                i.a(a).a(true, false);
                i.a(a).b();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
                return null;
            }
            return jSONObject;
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    private JSONObject k() {
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            try {
                jSONObjectL.put("st", "1");
            } catch (Throwable th) {
            }
        }
        return jSONObjectL;
    }

    private void c(JSONObject jSONObject) throws Throwable {
        if (!i.a(a).e()) {
            JSONObject jSONObjectG = i.a(a).g();
            if (jSONObjectG != null) {
                String strOptString = jSONObjectG.optString("__av");
                String strOptString2 = jSONObjectG.optString("__vc");
                try {
                    if (TextUtils.isEmpty(strOptString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), strOptString);
                    }
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(a));
                        return;
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), strOptString2);
                        return;
                    }
                } catch (Throwable th) {
                    return;
                }
            }
            return;
        }
        try {
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(a));
        } catch (Throwable th2) {
        }
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.i), verticalType);
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(a);
                if (TextUtils.isEmpty(gameSdkVersion)) {
                    gameSdkVersion = "9.5.3";
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), gameSdkVersion);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.5.3");
            }
            String strMD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(a));
            if (!TextUtils.isEmpty(strMD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), strMD5);
            }
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(a, com.umeng.analytics.pro.d.an, "");
            if (!TextUtils.isEmpty(strImprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), strImprintProperty2);
                }
            }
            String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(a, com.umeng.analytics.pro.d.ao, "");
            if (!TextUtils.isEmpty(strImprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aq), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aq), strImprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ah), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aj), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(strImprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.m), sharedPreferences.getString("vers_date", str));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(a)).putString("pre_date", str).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject b(boolean z2) {
        try {
            JSONObject jSONObjectA = i.a(a).a(z2);
            try {
                if (jSONObjectA == null) {
                    jSONObjectA = new JSONObject();
                } else {
                    try {
                        boolean zHas = jSONObjectA.has(com.umeng.analytics.pro.d.n);
                        jSONObjectA = jSONObjectA;
                        if (zHas) {
                            JSONArray jSONArray = jSONObjectA.getJSONArray(com.umeng.analytics.pro.d.n);
                            JSONArray jSONArray2 = new JSONArray();
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.umeng.analytics.pro.d.t);
                                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(com.umeng.analytics.pro.d.u);
                                if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 != null) {
                                    jSONObject.put(com.umeng.analytics.pro.d.t, jSONArrayOptJSONArray2);
                                    jSONObject.remove(com.umeng.analytics.pro.d.u);
                                }
                                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                        arrayList.add((JSONObject) jSONArrayOptJSONArray.get(i2));
                                    }
                                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                        arrayList.add((JSONObject) jSONArrayOptJSONArray2.get(i3));
                                    }
                                    JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                    jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.d.x);
                                    Collections.sort(arrayList, jSONArraySortUtil);
                                    JSONArray jSONArray3 = new JSONArray();
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        jSONArray3.put((JSONObject) it.next());
                                    }
                                    jSONObject.put(com.umeng.analytics.pro.d.t, jSONArray3);
                                    jSONObject.remove(com.umeng.analytics.pro.d.u);
                                }
                                if (!jSONObject.has(com.umeng.analytics.pro.d.t)) {
                                    jSONObject.put(com.umeng.analytics.pro.d.z, 0);
                                } else {
                                    JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(com.umeng.analytics.pro.d.t);
                                    for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                                        JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i4);
                                        if (jSONObject2.has(com.umeng.analytics.pro.d.x)) {
                                            jSONObject2.put("ts", jSONObject2.getLong(com.umeng.analytics.pro.d.x));
                                            jSONObject2.remove(com.umeng.analytics.pro.d.x);
                                        }
                                    }
                                    jSONObject.put(com.umeng.analytics.pro.d.t, jSONArrayOptJSONArray3);
                                    jSONObject.put(com.umeng.analytics.pro.d.z, jSONArrayOptJSONArray3.length());
                                }
                                jSONArray2.put(jSONObject);
                            }
                            jSONObjectA.put(com.umeng.analytics.pro.d.n, jSONArray2);
                            jSONObjectA = jSONObjectA;
                        }
                    } catch (Exception e) {
                        MLog.e("merge pages error");
                        e.printStackTrace();
                        jSONObjectA = jSONObjectA;
                    }
                }
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString("userlevel", "");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObjectA.put("userlevel", string);
                    }
                }
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("provider", strArrA[0]);
                    jSONObject3.put(com.umeng.analytics.pro.d.N, strArrA[1]);
                    if (jSONObject3.length() > 0) {
                        jSONObjectA.put(com.umeng.analytics.pro.d.L, jSONObject3);
                    }
                }
                if (ABTest.getService(a).isInTest()) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(ABTest.getService(a).getTestName(), ABTest.getService(a).getGroupInfo());
                    jSONObjectA.put(com.umeng.analytics.pro.d.K, jSONObject4);
                }
                r.a().a(jSONObjectA, a);
                return jSONObjectA;
            } catch (Throwable th) {
                return jSONObjectA;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private String m() {
        String string = null;
        try {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            try {
                if (TextUtils.isEmpty(strImprintProperty)) {
                    if (!TextUtils.isEmpty(this.d)) {
                        return this.d;
                    }
                    if (this.c == null) {
                        this.c = PreferenceWrapper.getDefault(a);
                    }
                    string = this.c.getString("pre_version", "");
                    String appVersionName = DeviceConfig.getAppVersionName(a);
                    if (TextUtils.isEmpty(string)) {
                        this.c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                        string = "0";
                    } else {
                        String string2 = this.c.getString("cur_version", "");
                        if (!appVersionName.equals(string2)) {
                            this.c.edit().putString("pre_version", string2).putString("cur_version", appVersionName).commit();
                            string = string2;
                        }
                    }
                } else {
                    string = strImprintProperty;
                }
            } catch (Throwable th) {
                string = strImprintProperty;
            }
        } catch (Throwable th2) {
        }
        this.d = string;
        return string;
    }

    private String n() {
        String string = null;
        try {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "ud_da", null);
            try {
                if (TextUtils.isEmpty(strImprintProperty)) {
                    if (!TextUtils.isEmpty(this.e)) {
                        return this.e;
                    }
                    if (this.c == null) {
                        this.c = PreferenceWrapper.getDefault(a);
                    }
                    string = this.c.getString("pre_date", "");
                    if (TextUtils.isEmpty(string)) {
                        string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                        this.c.edit().putString("pre_date", string).commit();
                    } else {
                        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                        if (!string.equals(str)) {
                            this.c.edit().putString("pre_date", str).commit();
                            string = str;
                        }
                    }
                } else {
                    string = strImprintProperty;
                }
            } catch (Throwable th) {
                string = strImprintProperty;
            }
        } catch (Throwable th2) {
        }
        this.e = string;
        return string;
    }

    public void d() {
        try {
            if (this.g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                i.a(a).a(this.g);
                this.g = new JSONArray();
            }
            PreferenceWrapper.getDefault(a).edit().putLong(n, this.k).putInt(q, this.i).putInt(r, this.j).commit();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class d {
        private Map<String, Object> a;
        private String b;
        private String c;
        private long d;

        private d() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0L;
        }

        public d(String str, Map<String, Object> map, String str2, long j) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0L;
            this.a = map;
            this.b = str;
            this.d = j;
            this.c = str2;
        }

        public Map<String, Object> a() {
            return this.a;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.b;
        }

        public long d() {
            return this.d;
        }
    }

    private void e(Object obj) throws Throwable {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.i)) {
                    return;
                } else {
                    this.i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.j)) {
                    return;
                } else {
                    this.j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.g == null) {
                    this.g = new JSONArray();
                }
                this.g.put(jSONObject);
                i.a(a).a(this.g);
                this.g = new JSONArray();
                return;
            }
            if (this.g.length() >= this.f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                i.a(a).a(this.g);
                this.g = new JSONArray();
            }
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private boolean a(long j, int i) {
        if (j == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j <= 28800000) {
            return i < 5000;
        }
        o();
        return true;
    }

    private void o() {
        try {
            this.i = 0;
            this.j = 0;
            this.k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(a).edit().putLong(o, System.currentTimeMillis()).putInt(p, 0).commit();
        } catch (Throwable th) {
        }
    }

    private boolean c(boolean z2) throws Throwable {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.b == null) {
            this.b = new c();
        }
        this.b.a();
        ReportPolicy.ReportStrategy reportStrategyC = this.b.c();
        boolean zShouldSendMessage = reportStrategyC.shouldSendMessage(z2);
        if (zShouldSendMessage) {
            if (((reportStrategyC instanceof ReportPolicy.ReportByInterval) || (reportStrategyC instanceof ReportPolicy.DebugPolicy) || (reportStrategyC instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((reportStrategyC instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + reportStrategyC.getClass().getSimpleName());
            }
        }
        return zShouldSendMessage;
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(u.a().b())) {
                b(a);
            }
            if (this.g.length() <= 0) {
                return false;
            }
            for (int i = 0; i < this.g.length(); i++) {
                JSONObject jSONObjectOptJSONObject = this.g.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    String strOptString = jSONObjectOptJSONObject.optString("__i");
                    if (TextUtils.isEmpty(strOptString) || t.equals(strOptString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class c {
        private ReportPolicy.ReportStrategy a = null;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private ABTest f;

        public c() {
            this.f = null;
            this.f = ABTest.getService(o.a);
        }

        public void a() {
            try {
                int[] iArrA = a(-1, -1);
                this.b = iArrA[0];
                this.c = iArrA[1];
            } catch (Throwable th) {
            }
        }

        public int[] a(int i, int i2) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "report_policy", o.t)).intValue();
            int iIntValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "report_interval", o.t)).intValue();
            if (iIntValue == -1 || !ReportPolicy.isValid(iIntValue)) {
                return new int[]{i, i2};
            }
            if (6 == iIntValue) {
                int i3 = 90;
                if (iIntValue2 != -1 && iIntValue2 >= 90 && iIntValue2 <= 86400) {
                    i3 = iIntValue2;
                }
                return new int[]{iIntValue, i3 * 1000};
            }
            if (11 == iIntValue) {
                int i4 = 15;
                if (iIntValue2 != -1 && iIntValue2 >= 15 && iIntValue2 <= 3600) {
                    i4 = iIntValue2;
                }
                return new int[]{iIntValue, i4 * 1000};
            }
            return new int[]{i, i2};
        }

        public int a(int i) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "test_report_interval", o.t)).intValue();
            if (iIntValue == -1 || iIntValue < 90 || iIntValue > 86400) {
                return i;
            }
            return iIntValue * 1000;
        }

        protected void b() {
            int iA;
            Defcon service = Defcon.getService(o.a);
            if (service.isOpen()) {
                this.a = (this.a instanceof ReportPolicy.DefconPolicy) && this.a.isValid() ? this.a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(o.a), service);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "integrated_test", o.t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(j.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(o.a));
                } else if (this.f.isInTest() && "RPT".equals(this.f.getTestName())) {
                    if (this.f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "test_report_interval", o.t)).intValue() != -1) {
                            iA = a(90000);
                        } else if (this.c > 0) {
                            iA = this.c;
                        } else {
                            iA = this.e;
                        }
                    } else {
                        iA = 0;
                    }
                    this.a = b(this.f.getTestPolicy(), iA);
                } else {
                    int i = this.d;
                    int i2 = this.e;
                    if (this.b != -1) {
                        i = this.b;
                        i2 = this.c;
                    }
                    this.a = b(i, i2);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    if (this.a instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(j.I, 3, "", null, null);
                    } else if (this.a instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(j.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) this.a).getReportInterval() / 1000)});
                    } else if (this.a instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(j.L, 3, "", null, null);
                    } else if (this.a instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) this.a).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(j.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z2 = this.a instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable th) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.a;
        }

        private ReportPolicy.ReportStrategy b(int i, int i2) {
            switch (i) {
                case 0:
                    return this.a instanceof ReportPolicy.ReportRealtime ? this.a : new ReportPolicy.ReportRealtime();
                case 1:
                    return this.a instanceof ReportPolicy.ReportAtLaunch ? this.a : new ReportPolicy.ReportAtLaunch();
                case 2:
                case 3:
                case 7:
                case 9:
                case 10:
                default:
                    return this.a instanceof ReportPolicy.ReportAtLaunch ? this.a : new ReportPolicy.ReportAtLaunch();
                case 4:
                    return this.a instanceof ReportPolicy.ReportDaily ? this.a : new ReportPolicy.ReportDaily(StatTracer.getInstance(o.a));
                case 5:
                    return this.a instanceof ReportPolicy.ReportWifiOnly ? this.a : new ReportPolicy.ReportWifiOnly(o.a);
                case 6:
                    if (this.a instanceof ReportPolicy.ReportByInterval) {
                        ReportPolicy.ReportStrategy reportStrategy = this.a;
                        ((ReportPolicy.ReportByInterval) reportStrategy).setReportInterval(i2);
                        return reportStrategy;
                    }
                    return new ReportPolicy.ReportByInterval(StatTracer.getInstance(o.a), i2);
                case 8:
                    return this.a instanceof ReportPolicy.SmartPolicy ? this.a : new ReportPolicy.SmartPolicy(StatTracer.getInstance(o.a));
                case 11:
                    if (this.a instanceof ReportPolicy.ReportQuasiRealtime) {
                        ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                        ((ReportPolicy.ReportQuasiRealtime) reportStrategy2).setReportInterval(i2);
                        return reportStrategy2;
                    }
                    ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
                    reportQuasiRealtime.setReportInterval(i2);
                    return reportQuasiRealtime;
            }
        }
    }

    private void d(JSONObject jSONObject) throws Throwable {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.T)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.T, jSONObject4.getJSONArray(com.umeng.analytics.pro.d.T));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(com.umeng.analytics.pro.d.u)) {
                                jSONObject5.remove(com.umeng.analytics.pro.d.u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.I)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.I, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.I));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void e(JSONObject jSONObject) throws Throwable {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(com.umeng.analytics.pro.d.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    g(jSONObject);
                }
            } catch (Throwable th) {
            }
        }
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    f(jSONObject);
                }
            } catch (Throwable th) {
            }
        }
    }

    private void f(JSONObject jSONObject) throws Throwable {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                    if (jSONObject2.has(com.umeng.analytics.pro.d.n) && (jSONObjectOptJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.d.n).optJSONObject(0)) != null) {
                        String strOptString = jSONObjectOptJSONObject2.optString("id");
                        if (!TextUtils.isEmpty(strOptString)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                            i.a(a).b(strOptString);
                        }
                    }
                }
                i.a(a).b();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
                UMWorkDispatch.sendEvent(a, a.l, CoreProtocol.getInstance(a), null);
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && jSONObjectOptJSONObject.length() > 0 && jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.n)) {
                i.a(a).a(true, false);
            }
            i.a(a).b();
        } catch (Exception e) {
        }
    }

    private void g(JSONObject jSONObject) throws Throwable {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(com.umeng.analytics.pro.d.n)) {
                        i.a(a).i();
                        i.a(a).h();
                        i.a(a).b(true, false);
                        i.a(a).a();
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                    }
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && jSONObjectOptJSONObject.length() > 0) {
                if (jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.n)) {
                    i.a(a).b(true, false);
                }
                if (jSONObjectOptJSONObject.has("ekv") || jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.T)) {
                    i.a(a).h();
                }
                if (jSONObjectOptJSONObject.has("error")) {
                    i.a(a).i();
                }
            }
            i.a(a).a();
        } catch (Exception e) {
        }
    }

    public void c(Object obj) throws Throwable {
        b(a);
        d();
        if (d(false)) {
            j();
        }
    }

    public void b(Context context) {
        try {
            i.a(context).d();
            q();
        } catch (Throwable th) {
        }
    }

    public void e() throws Throwable {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) throws Throwable {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z2) {
        if (this.b == null) {
            this.b = new c();
        }
        ReportPolicy.ReportStrategy reportStrategyC = this.b.c();
        if (reportStrategyC instanceof ReportPolicy.DefconPolicy) {
            if (z2) {
                return ((ReportPolicy.DefconPolicy) reportStrategyC).shouldSendMessageByInstant();
            }
            return reportStrategyC.shouldSendMessage(false);
        }
        return true;
    }

    public void a(Object obj, boolean z2) throws Throwable {
        if (z2) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(a) && d(true)) {
            i();
        }
    }

    private void q() {
        if (this.g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.g.length(); i++) {
                try {
                    JSONObject jSONObject = this.g.getJSONObject(i);
                    if (jSONObject != null && jSONObject.length() > 0) {
                        String strOptString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(strOptString) || t.equals(strOptString)) {
                            String strB = u.a().b();
                            if (TextUtils.isEmpty(strB)) {
                                strB = t;
                            }
                            jSONObject.put("__i", strB);
                        }
                        jSONArray.put(jSONObject);
                    } else {
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable th) {
                }
            }
            this.g = jSONArray;
        }
    }

    private void r() {
        SharedPreferences sharedPreferences;
        try {
            if (s() && a != null && (sharedPreferences = PreferenceWrapper.getDefault(a)) != null && sharedPreferences.getLong(l, 0L) == 0) {
                sharedPreferences.edit().putLong(l, System.currentTimeMillis()).commit();
            }
        } catch (Throwable th) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long jCurrentTimeMillis = 0;
        try {
            if (a == null || (sharedPreferences = PreferenceWrapper.getDefault(a)) == null) {
                return 0L;
            }
            long j = sharedPreferences.getLong(l, 0L);
            if (j != 0) {
                return j;
            }
            try {
                jCurrentTimeMillis = System.currentTimeMillis();
                sharedPreferences.edit().putLong(l, jCurrentTimeMillis).commit();
                return jCurrentTimeMillis;
            } catch (Throwable th) {
                return j;
            }
        } catch (Throwable th2) {
            return jCurrentTimeMillis;
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            if (a != null && (sharedPreferences = PreferenceWrapper.getDefault(a)) != null && sharedPreferences.getLong(m, -1L) != 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private void f(Object obj) throws Throwable {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j = jSONObject.getLong("ts");
                b(a);
                d();
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
                    u.a().a(a, j);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + y.a().c(a));
                    boolean zB = u.a().b(a, j, false);
                    com.umeng.analytics.c.b(a);
                    u.a().a(a, j, true);
                    if (zB) {
                        u.a().b(a, j);
                    }
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private void g(Object obj) {
        try {
            b(a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString("provider");
                String string2 = jSONObject.getString("uid");
                long j = jSONObject.getLong("ts");
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA == null || !string.equals(strArrA[0]) || !string2.equals(strArrA[1])) {
                    u.a().a(a, j);
                    String strC = y.a().c(a);
                    boolean zB = u.a().b(a, j, false);
                    com.umeng.analytics.c.a(a, string, string2);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + strC);
                    u.a().a(a, j, true);
                    if (zB) {
                        u.a().b(a, j);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0 && jSONObject.has("__ii")) {
                String strOptString = jSONObject.optString("__ii");
                jSONObject.remove("__ii");
                if (!TextUtils.isEmpty(strOptString)) {
                    i.a(a).a(strOptString, obj.toString(), 2);
                }
            }
        } catch (Throwable th) {
        }
    }
}
