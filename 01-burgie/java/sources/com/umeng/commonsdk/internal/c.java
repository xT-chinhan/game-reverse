package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.commonsdk.vchannel.Sender;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMInternalDataProtocol.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements UMLogDataProtocol {
    public static final String b = "preInitInvokedFlag";
    public static final String c = "policyGrantInvokedFlag";
    public static final String d = "policyGrantResult";
    private Context e;
    private static int f = 1;
    public static final String a = z.b().b(z.q);
    private static Class<?> g = null;
    private static Method h = null;
    private static Method i = null;
    private static Method j = null;
    private static boolean k = false;

    static {
        c();
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            if (cls != null) {
                g = cls;
                Method declaredMethod = g.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    h = declaredMethod;
                }
                Method declaredMethod2 = g.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    i = declaredMethod2;
                }
                Method declaredMethod3 = g.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    j = declaredMethod3;
                }
            }
        } catch (Throwable th) {
        }
    }

    public String a() {
        if (g == null || h == null || i == null) {
            return "";
        }
        try {
            Object objInvoke = h.invoke(g, new Object[0]);
            return objInvoke != null ? (String) i.invoke(objInvoke, this.e) : "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String b() {
        if (g == null || h == null || j == null) {
            return "";
        }
        try {
            Object objInvoke = h.invoke(g, new Object[0]);
            if (objInvoke == null) {
                return "";
            }
            return (String) j.invoke(objInvoke, new Object[0]);
        } catch (Throwable th) {
            return "";
        }
    }

    public c(Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("os"), "Android");
            JSONObject jSONObjectBuildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (jSONObjectBuildZeroEnvelopeWithExtHeader != null && jSONObjectBuildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable th) {
        }
    }

    private void b(Context context) {
        try {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, an.g, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(an.g), strImprintProperty);
            JSONObject jSONObjectBuildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (jSONObjectBuildSilentEnvelopeWithExtHeader != null && jSONObjectBuildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            }
        } catch (Throwable th) {
        }
    }

    private void d() {
        ap apVarA = ap.a(this.e);
        aq aqVarA = apVarA.a(ar.c);
        if (aqVarA != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = aqVarA.a;
                String str2 = aqVarA.b;
                JSONObject jSONObjectA = new com.umeng.commonsdk.statistics.b().a(this.e.getApplicationContext(), new JSONObject(aqVarA.c), new JSONObject(aqVarA.d), aqVarA.e, str2, aqVarA.f);
                if (jSONObjectA != null && jSONObjectA.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                }
                apVarA.a(ar.c, str);
                apVarA.b();
            } catch (Throwable th) {
            }
        }
    }

    private static void c(final Context context) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strA = ab.a(context);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(strA) && sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(h.c, (jCurrentTimeMillis2 - jCurrentTimeMillis) + "");
                        editorEdit.commit();
                    }
                    if (sharedPreferences != null) {
                        try {
                            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                            editorEdit2.putString(h.b, strA);
                            editorEdit2.commit();
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    UMConfigureImpl.removeInterruptFlag();
                } catch (Exception e) {
                }
            }
        }).start();
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String strA = ab.a(applicationContext);
                if (onGetOaidListener != null) {
                    onGetOaidListener.onGetOaid(strA);
                }
            }
        }).start();
    }

    private static void d(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                        if (sharedPreferences != null && !sharedPreferences.getString(h.b, "").equalsIgnoreCase(str)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                            editorEdit.putString(h.b, str);
                            editorEdit.commit();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    private void e() {
        if (!k) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                k = true;
                a(this.e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                    @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                    public void onGetOaid(String str) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                SharedPreferences sharedPreferences = c.this.e.getSharedPreferences(h.a, 0);
                                if (sharedPreferences != null) {
                                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                                    editorEdit.putString(h.b, str);
                                    editorEdit.commit();
                                }
                            } catch (Throwable th) {
                            }
                            UMWorkDispatch.sendEvent(c.this.e, a.w, b.a(c.this.e).a(), null);
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                    }
                });
                return;
            }
            return;
        }
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            k = false;
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            k = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.e);
            f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.e != null) {
                        UMWorkDispatch.sendEvent(c.this.e, a.x, b.a(c.this.e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            c(this.e);
        }
    }

    private void e(Context context) {
        long jLongValue;
        long jLongValue2;
        if (context == null) {
            return;
        }
        String strA = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, "debugkey");
        if (!TextUtils.isEmpty(strA)) {
            String strA2 = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME);
            String strA3 = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_PERIOD);
            if (!TextUtils.isEmpty(strA2)) {
                try {
                    jLongValue = Long.valueOf(strA2).longValue();
                } catch (Throwable th) {
                    jLongValue = 0;
                }
            } else {
                jLongValue = 0;
            }
            if (!TextUtils.isEmpty(strA3)) {
                try {
                    jLongValue2 = Long.valueOf(strA3).longValue();
                } catch (Throwable th2) {
                    jLongValue2 = 0;
                }
            } else {
                jLongValue2 = 0;
            }
            if (jLongValue == 0 || jLongValue2 == 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
                com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
                return;
            }
            if (System.currentTimeMillis() - jLongValue > jLongValue2 * 60 * 1000) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。");
                com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
                if (AnalyticsConfig.isRealTimeDebugMode()) {
                    AnalyticsConfig.turnOffRealTimeDebug();
                    return;
                }
                return;
            }
            HashMap map = new HashMap();
            map.put("debugkey", strA);
            if (!AnalyticsConfig.isRealTimeDebugMode()) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。");
                AnalyticsConfig.turnOnRealTimeDebug(map);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:96:0x028c  */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) throws Throwable {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        boolean z = true;
        boolean z2 = false;
        ULog.i("walle", "[internal] workEvent");
        if (com.umeng.commonsdk.utils.c.a()) {
            if (32802 == i2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式：进入心跳处理逻辑!");
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jB = com.umeng.commonsdk.utils.c.b(this.e);
                boolean zE = com.umeng.commonsdk.utils.c.e(this.e);
                if (com.umeng.commonsdk.utils.c.a(jB, jCurrentTimeMillis, com.umeng.commonsdk.utils.c.a(this.e))) {
                    if (!UMFrUtils.hasEnvelopeFile(this.e, UMLogDataProtocol.UMBusinessType.U_Silent)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建静默心跳信封.");
                        b(this.e);
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默心跳信封文件已存在，尝试发送之!");
                    }
                    UMEnvelopeBuild.registerNetReceiver(this.e);
                }
                if (!zE) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send REBUILD_DB msg in silent mode.");
                    UMWorkDispatch.sendEvent(this.e, o.a.p, CoreProtocol.getInstance(this.e), null, 2000L);
                }
                return;
            }
            return;
        }
        switch (i2) {
            case a.f /* 32769 */:
                try {
                    ULog.i("walle", "[internal] workEvent send envelope");
                    try {
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        String strA = ab.a(this.e);
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        if (!TextUtils.isEmpty(strA) && (sharedPreferences = this.e.getSharedPreferences(h.a, 0)) != null) {
                            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                            editorEdit2.putString(h.b, strA);
                            editorEdit2.putString(h.c, (jCurrentTimeMillis3 - jCurrentTimeMillis2) + "");
                            editorEdit2.commit();
                        }
                        break;
                    } catch (Throwable th) {
                    }
                    try {
                        Class<?> cls = Class.forName("com.umeng.commonsdk.internal.UMInternalManagerAgent");
                        if (cls != null) {
                            cls.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(cls, this.e);
                        }
                    } catch (ClassNotFoundException e) {
                        return;
                    } catch (Throwable th2) {
                        return;
                    }
                } catch (Exception e2) {
                    return;
                }
                break;
            case a.h /* 32771 */:
                if (obj != null && (obj instanceof com.umeng.commonsdk.internal.utils.b)) {
                    JSONObject jSONObject = new JSONObject();
                    com.umeng.commonsdk.internal.utils.b bVar = (com.umeng.commonsdk.internal.utils.b) obj;
                    try {
                        jSONObject.put("le", bVar.a);
                        jSONObject.put("vol", bVar.b);
                        jSONObject.put("temp", bVar.c);
                        jSONObject.put("st", bVar.d);
                        jSONObject.put("ct", bVar.e);
                        jSONObject.put("ts", bVar.f);
                        break;
                    } catch (Throwable th3) {
                    }
                    String string = jSONObject.toString();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "battery info: " + string);
                    try {
                        Class<?> cls2 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                        if (cls2 != null) {
                            cls2.getMethod("saveBattery", Context.class, String.class).invoke(cls2, this.e, string);
                        }
                    } catch (ClassNotFoundException e3) {
                        return;
                    } catch (Throwable th4) {
                        return;
                    }
                    break;
                }
                break;
            case a.l /* 32775 */:
                try {
                    Class<?> cls3 = Class.forName("com.umeng.commonsdk.internal.utils.InfoPreferenceAgent");
                    if (cls3 != null) {
                        cls3.getMethod("saveUA", Context.class, String.class).invoke(cls3, this.e, (String) obj);
                    }
                } catch (ClassNotFoundException e4) {
                    return;
                } catch (Throwable th5) {
                    return;
                }
                break;
            case a.n /* 32777 */:
                try {
                    ULog.i("walle", "[internal] workEvent send envelope");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(an.aN, a.e);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(an.au, new JSONObject());
                    JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.e, jSONObject2, jSONObject3);
                    if (jSONObjectBuildEnvelopeWithExtHeader != null && !jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                        ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                        break;
                    }
                } catch (Exception e5) {
                    return;
                }
                break;
            case a.o /* 32779 */:
                Sender.handleEvent(this.e, (com.umeng.commonsdk.vchannel.b) obj);
                break;
            case a.p /* 32781 */:
                if (!UMFrUtils.hasEnvelopeFile(this.e, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文");
                    a(this.e);
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文信封文件已存在，尝试发送之!");
                }
                break;
            case a.s /* 32784 */:
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。");
                f();
                f--;
                g();
                break;
            case a.t /* 32785 */:
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]接收到消费二级缓存数据通知.");
                if (ap.a(this.e).c()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                } else {
                    d();
                    if (!UMWorkDispatch.eventHasExist(a.t)) {
                        UMWorkDispatch.sendEvent(this.e, a.t, b.a(this.e).a(), null);
                    }
                }
                break;
            case a.u /* 32786 */:
                UMCrashManager.buildEnvelope(this.e, obj);
                break;
            case a.v /* 32787 */:
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查动作。");
                    String strA2 = com.umeng.commonsdk.stateless.d.a(this.e, false);
                    String strA3 = com.umeng.commonsdk.stateless.d.a(this.e, true);
                    if (!TextUtils.isEmpty(strA2)) {
                        File file = new File(strA2);
                        if (file.exists() && file.isDirectory()) {
                            z2 = true;
                        }
                    }
                    if (!TextUtils.isEmpty(strA3)) {
                        File file2 = new File(strA3);
                        if (!file2.exists() || !file2.isDirectory()) {
                            z = z2;
                        }
                    } else {
                        z = z2;
                    }
                    if (z) {
                        if (!com.umeng.commonsdk.stateless.b.a()) {
                            new com.umeng.commonsdk.stateless.b(this.e);
                            com.umeng.commonsdk.stateless.b.b();
                        } else {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。");
                        }
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。");
                    }
                } catch (Throwable th6) {
                    return;
                }
                break;
            case a.w /* 32788 */:
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新，触发 伪冷启动。");
                com.umeng.commonsdk.statistics.b.a();
                e();
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && !UMWorkDispatch.eventHasExist()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制");
                    UMWorkDispatch.sendEventEx(this.e, o.a.D, CoreProtocol.getInstance(this.e), null, 5000L);
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger");
                    l.a(this.e).b(this.e);
                }
                break;
            case a.x /* 32790 */:
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 成功接收到(OAID)读取结束通知。");
                f--;
                g();
                break;
            case a.y /* 32791 */:
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 正常冷启动流程，接收到云控配置加载成功通知。");
                d(this.e);
                com.umeng.commonsdk.a.a(this.e);
                f(this.e);
                break;
            case a.z /* 32792 */:
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存隐私授权结果.");
                try {
                    if (obj instanceof Integer) {
                        int iIntValue = ((Integer) obj).intValue();
                        SharedPreferences sharedPreferences2 = this.e.getApplicationContext().getSharedPreferences(a, 0);
                        if (sharedPreferences2 != null) {
                            sharedPreferences2.edit().putInt("policyGrantResult", iIntValue).commit();
                        }
                    }
                } catch (Throwable th7) {
                    return;
                }
                break;
            case a.A /* 32793 */:
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存preInit执行结果及授权API是否调用结果.");
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject4 = (JSONObject) obj;
                    if (jSONObject4.has(a.I)) {
                        try {
                            int i3 = jSONObject4.getInt(a.I);
                            int i4 = jSONObject4.getInt(a.J);
                            int i5 = jSONObject4.getInt("policyGrantResult");
                            SharedPreferences sharedPreferences3 = this.e.getApplicationContext().getSharedPreferences(a, 0);
                            if (sharedPreferences3 != null && (editorEdit = sharedPreferences3.edit()) != null) {
                                editorEdit.putInt(b, i3);
                                editorEdit.putInt(c, i4);
                                editorEdit.putInt("policyGrantResult", i5);
                                editorEdit.commit();
                            }
                            File file3 = new File(this.e.getFilesDir().getAbsolutePath() + File.separator + ar.m);
                            if (!file3.exists()) {
                                try {
                                    file3.createNewFile();
                                } catch (Throwable th8) {
                                    return;
                                }
                            }
                        } catch (Throwable th9) {
                            return;
                        }
                    }
                }
                break;
            case a.B /* 32800 */:
                File file4 = new File(this.e.getFilesDir().getAbsolutePath() + File.separator + ar.m);
                if (file4.exists()) {
                    try {
                        file4.delete();
                    } catch (Throwable th10) {
                        return;
                    }
                }
                break;
            case a.C /* 32801 */:
                try {
                    SelfChecker.doCheck(this.e);
                } catch (Throwable th11) {
                    return;
                }
                break;
            case a.E /* 32803 */:
                ConnectivityManager connectivityManager = (ConnectivityManager) this.e.getSystemService("connectivity");
                if (connectivityManager != null) {
                    try {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            if (activeNetworkInfo.isAvailable()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network state changed: Available");
                                com.umeng.commonsdk.framework.a.a(true);
                                com.umeng.commonsdk.stateless.b.a(true);
                            } else {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network state changed: unAvailable");
                                com.umeng.commonsdk.framework.a.a(false);
                                com.umeng.commonsdk.stateless.b.a(false);
                            }
                        } else {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> NetworkInfo is null!");
                            com.umeng.commonsdk.framework.a.a(false);
                            com.umeng.commonsdk.stateless.b.a(false);
                        }
                    } catch (Throwable th12) {
                        com.umeng.commonsdk.framework.a.a(false);
                        com.umeng.commonsdk.stateless.b.a(false);
                        return;
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> ConnectivityManager is null!");
                    com.umeng.commonsdk.framework.a.a(false);
                    com.umeng.commonsdk.stateless.b.a(false);
                }
                break;
            case a.F /* 32804 */:
                e(this.e);
                break;
        }
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private void f(Context context) {
        Object objInvoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> clsA = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = clsA.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 != null && (objInvoke = declaredMethod2.invoke(clsA, new Object[0])) != null && (declaredMethod = clsA.getDeclaredMethod(TrackAction.INIT, Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) != null) {
                try {
                    declaredMethod.invoke(objInvoke, applicationContext, appkey, null);
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    private void g() {
        if (f <= 0) {
            h();
            f(this.e);
        }
    }

    private static void g(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + ar.l);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable th) {
            }
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.e)) {
            g(this.e);
            com.umeng.commonsdk.a.a(this.e);
            UMWorkDispatch.sendEvent(this.e, o.a.y, CoreProtocol.getInstance(this.e), null);
            UMWorkDispatch.sendEvent(this.e, a.t, b.a(this.e).a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }
}
