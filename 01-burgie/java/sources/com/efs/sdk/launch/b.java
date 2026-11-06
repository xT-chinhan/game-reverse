package com.efs.sdk.launch;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static long a;
    private static long b;
    private static long c;
    private static long d;
    private static long e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static long i;
    private static long j;
    private static int k;
    private static List<EfsJSONLog> l = new ArrayList();
    private static Map<String, Long[]> m = new HashMap();

    public static void a(Activity activity, String str, boolean z) {
        Context applicationContext;
        String name;
        int i2;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        Map<String, Long[]> map;
        long j10;
        long j11;
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_CREATE)) {
            if (z) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "onCreate");
                }
                d = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_RE_START)) {
            if (z && k == 0) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "onRestart");
                }
                e = System.currentTimeMillis();
                g = true;
                return;
            }
            return;
        }
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_START)) {
            if (z) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "onStart");
                }
                k++;
                h = true;
                return;
            }
            return;
        }
        if (!TextUtils.equals(str, LaunchManager.PAGE_ON_RESUME)) {
            if (TextUtils.equals(str, LaunchManager.PAGE_ON_STOP) && z) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "onStop");
                }
                k--;
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        if (LaunchManager.isDebug) {
            Log.i("LaunchTrace", "onResume");
        }
        if (f) {
            f = false;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j12 = jCurrentTimeMillis - c;
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "loadTime is ".concat(String.valueOf(j12)));
            }
            long j13 = jCurrentTimeMillis - a;
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "======>>>>>> coldTime is ".concat(String.valueOf(j13)));
            }
            int i3 = !c.d(activity.getApplicationContext()) ? 1 : 0;
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "type is ".concat(String.valueOf(i3)));
            }
            a(activity.getApplicationContext(), i3, activity.getClass().getName(), j13, a, b, i, c, j, jCurrentTimeMillis, j12, 0L, 0L, m);
        } else if (k == 1) {
            if (g) {
                g = false;
                long jCurrentTimeMillis2 = System.currentTimeMillis() - e;
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "======>>>>>> hotTime is ".concat(String.valueOf(jCurrentTimeMillis2)));
                }
                applicationContext = activity.getApplicationContext();
                name = activity.getClass().getName();
                i2 = 2;
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                j11 = 0;
                map = m;
                j10 = 0;
                j9 = jCurrentTimeMillis2;
            } else if (h) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - d;
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "======>>>>>> warmTime is ".concat(String.valueOf(jCurrentTimeMillis3)));
                }
                applicationContext = activity.getApplicationContext();
                name = activity.getClass().getName();
                i2 = 3;
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                j9 = 0;
                map = m;
                j10 = 0;
                j11 = jCurrentTimeMillis3;
            }
            a(applicationContext, i2, name, j2, j3, j10, j4, j5, j6, j7, j8, j9, j11, map);
        }
        h = false;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0376  */
    /* JADX WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    private static void a(Context context, int i2, String str, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Map<String, Long[]> map) {
        int i3;
        String str2;
        StringBuilder sb;
        EfsJSONLog efsJSONLog;
        String str3;
        Object objValueOf;
        if (!LaunchManager.isInit()) {
            if (i2 == 0) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "no init, local cache cold launch, type is 0 !");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("w_type", i2);
                    jSONObject.put("w_url", str);
                    jSONObject.put("l_version", "0.0.4.umeng");
                    jSONObject.put("wl_avgv", j2);
                    jSONObject.put("wd_init", j3);
                    jSONObject.put("wd_inittm", j4);
                    jSONObject.put("wl_init", j5);
                    jSONObject.put("wd_build", j4);
                    jSONObject.put("wd_buildtm", j6);
                    jSONObject.put("wl_build", j7);
                    jSONObject.put("wd_page", j6);
                    jSONObject.put("wd_pagetm", j8);
                    jSONObject.put("wl_page", j9);
                    if (map != null && !map.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry<String, Long[]> entry : map.entrySet()) {
                            String key = entry.getKey();
                            Long[] value = entry.getValue();
                            if (key != null && value != null) {
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(value[0]);
                                jSONArray.put(value[1]);
                                jSONObject2.put(key, jSONArray);
                            }
                        }
                        jSONObject.put("userExtra", jSONObject2);
                    }
                    c.a(context, jSONObject.toString());
                    if (LaunchManager.isDebug) {
                        Log.i("LaunchTrace", "no init, cache first launch, content is " + jSONObject.toString());
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "no init, cache launch, type is ".concat(String.valueOf(i2)));
            }
            EfsJSONLog efsJSONLog2 = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog2.put("w_type", Integer.valueOf(i2));
            efsJSONLog2.put("w_url", str);
            efsJSONLog2.put("l_version", "0.0.4.umeng");
            if (i2 == 1) {
                efsJSONLog2.put("wl_avgv", Long.valueOf(j2));
                efsJSONLog2.put("wd_init", Long.valueOf(j3));
                efsJSONLog2.put("wd_inittm", Long.valueOf(j4));
                efsJSONLog2.put("wl_init", Long.valueOf(j5));
                efsJSONLog2.put("wd_build", Long.valueOf(j4));
                efsJSONLog2.put("wd_buildtm", Long.valueOf(j6));
                efsJSONLog2.put("wl_build", Long.valueOf(j7));
                efsJSONLog2.put("wd_page", Long.valueOf(j6));
                efsJSONLog2.put("wd_pagetm", Long.valueOf(j8));
                efsJSONLog2.put("wl_page", Long.valueOf(j9));
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, Long[]> entry2 : map.entrySet()) {
                        String key2 = entry2.getKey();
                        Long[] value2 = entry2.getValue();
                        if (key2 != null && value2 != null) {
                            JSONArray jSONArray2 = new JSONArray();
                            jSONArray2.put(value2[0]);
                            jSONArray2.put(value2[1]);
                            jSONObject3.put(key2, jSONArray2);
                        }
                    }
                    efsJSONLog2.put("userExtra", jSONObject3);
                }
            } else {
                if (i2 == 2) {
                    efsJSONLog2.put("wl_avgv", Long.valueOf(j10));
                } else {
                    i3 = 3;
                    if (i2 == 3) {
                        efsJSONLog2.put("wl_avgv", Long.valueOf(j11));
                    }
                }
                if (l != null || l.size() >= i3) {
                    if (LaunchManager.isDebug) {
                        Log.i("LaunchTrace", "cache launch size over!");
                        return;
                    }
                    return;
                } else {
                    l.add(efsJSONLog2);
                    if (!LaunchManager.isDebug) {
                        return;
                    }
                    str2 = "LaunchTrace";
                    sb = new StringBuilder("cache launch report --->>> ");
                    efsJSONLog = efsJSONLog2;
                }
            }
            i3 = 3;
            if (l != null) {
            }
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "cache launch size over!");
                return;
            }
            return;
        }
        LaunchConfigManager launchConfigManager = LaunchManager.getLaunchConfigManager();
        if ((launchConfigManager == null || !launchConfigManager.enableTracer()) && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "launch --->>> config no init or enable is false");
                return;
            }
            return;
        }
        EfsJSONLog efsJSONLog3 = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
        efsJSONLog3.put("w_type", Integer.valueOf(i2));
        efsJSONLog3.put("w_url", str);
        efsJSONLog3.put("l_version", "0.0.4.umeng");
        if (i2 == 0 || i2 == 1) {
            efsJSONLog3.put("wl_avgv", Long.valueOf(j2));
            efsJSONLog3.put("wd_init", Long.valueOf(j3));
            efsJSONLog3.put("wd_inittm", Long.valueOf(j4));
            efsJSONLog3.put("wl_init", Long.valueOf(j5));
            efsJSONLog3.put("wd_build", Long.valueOf(j4));
            efsJSONLog3.put("wd_buildtm", Long.valueOf(j6));
            efsJSONLog3.put("wl_build", Long.valueOf(j7));
            efsJSONLog3.put("wd_page", Long.valueOf(j6));
            efsJSONLog3.put("wd_pagetm", Long.valueOf(j8));
            efsJSONLog3.put("wl_page", Long.valueOf(j9));
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, Long[]> entry3 : map.entrySet()) {
                    String key3 = entry3.getKey();
                    Long[] value3 = entry3.getValue();
                    if (key3 != null && value3 != null) {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(value3[0]);
                        jSONArray3.put(value3[1]);
                        jSONObject4.put(key3, jSONArray3);
                    }
                }
                efsJSONLog3.put("userExtra", jSONObject4);
            }
        } else {
            if (i2 == 2) {
                str3 = "wl_avgv";
                objValueOf = Long.valueOf(j10);
            } else if (i2 == 3) {
                str3 = "wl_avgv";
                objValueOf = Long.valueOf(j11);
            }
            efsJSONLog3.put(str3, objValueOf);
        }
        String strA = c.a(context);
        if (LaunchManager.isDebug) {
            Log.i("LaunchTrace", "umid is ".concat(String.valueOf(strA)));
        }
        if (strA != null && !TextUtils.isEmpty(strA)) {
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "send current launch report --->>> " + efsJSONLog3.generateString());
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog3);
                return;
            }
            return;
        }
        if (l == null || l.size() >= 3) {
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "cache launch size over!");
                return;
            }
            return;
        } else {
            l.add(efsJSONLog3);
            if (!LaunchManager.isDebug) {
                return;
            }
            str2 = "LaunchTrace";
            sb = new StringBuilder("cache launch report --->>> ");
            efsJSONLog = efsJSONLog3;
        }
        sb.append(efsJSONLog.generateString());
        Log.i(str2, sb.toString());
    }

    public static void a(Context context, String str) {
        if (LaunchManager.isDebug) {
            Log.i("LaunchTrace", "begin sendLaunchCache");
        }
        if (str == null || TextUtils.isEmpty(str)) {
            str = c.a(context);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap(1);
        map.put(UMCrash.KEY_HEADER_UMID, str);
        if (LaunchManager.getReporter() != null) {
            LaunchManager.getReporter().addPublicParams(map);
        }
        String strB = c.b(context);
        if (strB != null && !TextUtils.isEmpty(strB)) {
            try {
                JSONObject jSONObject = new JSONObject(strB);
                jSONObject.put(UMCrash.KEY_HEADER_UMID, str);
                if (a(jSONObject)) {
                    c.c(context);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (l == null || l.size() <= 0) {
            return;
        }
        for (EfsJSONLog efsJSONLog : l) {
            if (efsJSONLog != null) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "send cache launch report --->>> " + efsJSONLog.generateString());
                }
                EfsReporter reporter = LaunchManager.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            }
        }
        l.clear();
        l = null;
    }

    public static void a(String str, long j2) {
        if (m == null || m.containsKey(str) || m.size() >= 10) {
            if (LaunchManager.isDebug) {
                Log.e("LaunchTrace", "--->>> method name already exists or over quantity !");
            }
        } else {
            Long[] lArr = new Long[2];
            lArr[0] = Long.valueOf(j2);
            m.put(str, lArr);
        }
    }

    public static void a(String str, boolean z) {
        if (TextUtils.equals(str, LaunchManager.APP_CONSTRUCT)) {
            return;
        }
        if (!TextUtils.equals(str, LaunchManager.APP_ATTACH_BASE_CONTEXT)) {
            if (!TextUtils.equals(str, LaunchManager.APP_ON_CREATE) || z) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            c = jCurrentTimeMillis;
            j = jCurrentTimeMillis - b;
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "buildTime is " + j);
                return;
            }
            return;
        }
        if (z) {
            a = System.currentTimeMillis();
            f = true;
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        b = jCurrentTimeMillis2;
        i = jCurrentTimeMillis2 - a;
        if (LaunchManager.isDebug) {
            Log.i("LaunchTrace", "initTime is " + i);
        }
    }

    private static boolean a(JSONObject jSONObject) {
        try {
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", jSONObject.opt("w_type"));
            efsJSONLog.put("w_url", jSONObject.opt("w_url"));
            efsJSONLog.put("l_version", jSONObject.opt("l_version"));
            efsJSONLog.put("wl_avgv", jSONObject.opt("wl_avgv"));
            efsJSONLog.put("wd_init", jSONObject.opt("wd_init"));
            efsJSONLog.put("wd_inittm", jSONObject.opt("wd_inittm"));
            efsJSONLog.put("wl_init", jSONObject.opt("wl_init"));
            efsJSONLog.put("wd_build", jSONObject.opt("wd_build"));
            efsJSONLog.put("wd_buildtm", jSONObject.opt("wd_buildtm"));
            efsJSONLog.put("wl_build", jSONObject.opt("wl_build"));
            efsJSONLog.put("wd_page", jSONObject.opt("wd_page"));
            efsJSONLog.put("wd_pagetm", jSONObject.opt("wd_pagetm"));
            efsJSONLog.put("wl_page", jSONObject.opt("wl_page"));
            efsJSONLog.put("userExtra", jSONObject.opt("userExtra"));
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "send cache cold launch report --->>> " + efsJSONLog.generateString());
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter == null) {
                return false;
            }
            reporter.send(efsJSONLog);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(String str, long j2) {
        if (m == null || !m.containsKey(str)) {
            if (LaunchManager.isDebug) {
                Log.e("LaunchTrace", "--->>> method name non-existent or over quantity !");
            }
        } else {
            Long[] lArr = m.get(str);
            lArr[1] = Long.valueOf(j2);
            m.put(str, lArr);
        }
    }
}
