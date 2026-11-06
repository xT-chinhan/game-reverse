package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.tracker.experiment.d;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: compiled from: InternalGameAgent.java */
/* JADX INFO: loaded from: classes4.dex */
class b implements ISysListener {
    private static final String B = "com.umeng.analytics.MobclickAgent";
    private static boolean C = false;
    private static Method D = null;
    public static boolean a = true;
    public static final String b = "userlevel";
    private Context A;
    private a c = null;
    private final int d = 100;
    private final int e = 1;
    private final int f = 0;
    private final int g = -1;
    private final int h = 1;
    private final String i = "level";
    private final String j = "pay";
    private final String k = "buy";
    private final String l = "use";
    private final String m = "bonus";
    private final String n = "item";
    private final String o = "cash";
    private final String p = "coin";
    private final String q = "source";
    private final String r = d.q;
    private final String s = "user_level";
    private final String t = "bonus_source";
    private final String u = "level";
    private final String v = "status";
    private final String w = "duration";
    private final String x = "curtype";
    private final String y = "orderid";
    private final String z = "UMGameAgent.init(Context) should be called before any game api";

    static {
        try {
            Class<?> cls = Class.forName(B);
            if (cls != null) {
                if (cls.getDeclaredMethod("setSysListener", ISysListener.class) == null) {
                    UMLog.mutlInfo(2, c.G);
                } else {
                    C = true;
                    D = cls.getDeclaredMethod("onGKVEvent", Context.class, String.class, HashMap.class);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 游戏SDK: 检测到可用基础组件库.");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, String str, HashMap<String, Object> map) {
        if (C) {
            try {
                Method method = D;
                if (method != null) {
                    method.setAccessible(true);
                    D.invoke(null, context, str, map);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(ISysListener iSysListener) {
        if (C) {
            try {
                Method declaredMethod = Class.forName(B).getDeclaredMethod("setSysListener", ISysListener.class);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this, new Object[0]);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public b() {
        a = true;
    }

    void a(Context context) {
        if (context == null) {
            MLog.e("Context is null, can't init GameAgent");
            return;
        }
        this.A = context.getApplicationContext();
        a(this);
        this.c = new a(this.A);
    }

    void a(boolean z) {
        MLog.d(String.format("Trace sleep time : %b", Boolean.valueOf(z)));
        a = z;
    }

    void a(String str) {
        try {
            if (this.A == null) {
                MLog.e("UMGameAgent.init(Context) should be called before any game api");
                return;
            }
            this.c.b = str;
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.A);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("userlevel", str).commit();
            }
        } catch (Throwable unused) {
        }
    }

    void b(String str) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.a, 0, "\\|");
            return;
        }
        this.c.a = str;
        this.c.c(str);
        HashMap map = new HashMap();
        map.put("level", str);
        map.put("status", 0);
        if (this.c.b != null) {
            map.put("user_level", this.c.b);
        }
        a(this.A, "level", (HashMap<String, Object>) map);
    }

    private void a(String str, int i) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
            return;
        }
        a.C0660a c0660aD = this.c.d(str);
        if (c0660aD != null) {
            long jE = c0660aD.e();
            if (jE <= 0) {
                MLog.d("level duration is 0");
                return;
            }
            HashMap map = new HashMap();
            map.put("level", str);
            map.put("status", Integer.valueOf(i));
            map.put("duration", Long.valueOf(jE));
            if (this.c.b != null) {
                map.put("user_level", this.c.b);
            }
            a(this.A, "level", (HashMap<String, Object>) map);
            return;
        }
        MLog.w(String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
    }

    void c(String str) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.b, 0, "\\|");
        } else {
            a(str, 1);
        }
    }

    void d(String str) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.c, 0, "\\|");
        } else {
            a(str, -1);
        }
    }

    void a(double d, double d2, int i) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.d, 0, "\\|");
            return;
        }
        HashMap map = new HashMap();
        map.put("cash", Long.valueOf((long) (d * 100.0d)));
        map.put("coin", Long.valueOf((long) (d2 * 100.0d)));
        map.put("source", Integer.valueOf(i));
        if (this.c.b != null) {
            map.put("user_level", this.c.b);
        }
        if (this.c.a != null) {
            map.put("level", this.c.a);
        }
        a(this.A, "pay", (HashMap<String, Object>) map);
    }

    void a(double d, String str, int i, double d2, int i2) {
        if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.d, 0, "\\|");
        } else {
            a(d, d2 * ((double) i), i2);
            a(str, i, d2);
        }
    }

    void a(String str, int i, double d) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.f, 0, "\\|");
            return;
        }
        HashMap map = new HashMap();
        map.put("item", str);
        map.put(d.q, Integer.valueOf(i));
        map.put("coin", Long.valueOf((long) (((double) i) * d * 100.0d)));
        if (this.c.b != null) {
            map.put("user_level", this.c.b);
        }
        if (this.c.a != null) {
            map.put("level", this.c.a);
        }
        a(this.A, "buy", (HashMap<String, Object>) map);
    }

    void b(String str, int i, double d) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.g, 0, "\\|");
            return;
        }
        HashMap map = new HashMap();
        map.put("item", str);
        map.put(d.q, Integer.valueOf(i));
        map.put("coin", Long.valueOf((long) (((double) i) * d * 100.0d)));
        if (this.c.b != null) {
            map.put("user_level", this.c.b);
        }
        if (this.c.a != null) {
            map.put("level", this.c.a);
        }
        a(this.A, "use", (HashMap<String, Object>) map);
    }

    void a(double d, int i) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.h, 0, "\\|");
            return;
        }
        HashMap map = new HashMap();
        map.put("coin", Long.valueOf((long) (d * 100.0d)));
        map.put("bonus_source", Integer.valueOf(i));
        if (this.c.b != null) {
            map.put("user_level", this.c.b);
        }
        if (this.c.a != null) {
            map.put("level", this.c.a);
        }
        a(this.A, "bonus", (HashMap<String, Object>) map);
    }

    void a(String str, int i, double d, int i2) {
        if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.h, 0, "\\|");
        } else {
            a(((double) i) * d, i2);
            a(str, i, d);
        }
    }

    public void a() {
        MLog.d("App resume from background");
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.i, 0, "\\|");
        } else if (a) {
            this.c.b();
        }
    }

    public void b() {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.j, 0, "\\|");
        } else if (a) {
            this.c.a();
        }
    }

    void a(double d, String str, double d2, int i, String str2) {
        Context context = this.A;
        if (context == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        if (AnalyticsConfig.getVerticalType(context) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            UMLog.aq(c.e, 0, "\\|");
            return;
        }
        if (d < 0.0d || d2 < 0.0d) {
            return;
        }
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && str.length() > 0 && str.length() <= 3) {
            map.put("curtype", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                int length = str2.getBytes("UTF-8").length;
                if (length > 0 && length <= 1024) {
                    map.put("orderid", str2);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        map.put("cash", Long.valueOf((long) (d * 100.0d)));
        map.put("coin", Long.valueOf((long) (d2 * 100.0d)));
        map.put("source", Integer.valueOf(i));
        if (this.c.b != null) {
            map.put("user_level", this.c.b);
        }
        if (this.c.a != null) {
            map.put("level", this.c.a);
        }
        a(this.A, "pay", (HashMap<String, Object>) map);
    }
}
