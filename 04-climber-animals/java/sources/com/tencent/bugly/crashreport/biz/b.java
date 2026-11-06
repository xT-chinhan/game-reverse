package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.a.AnonymousClass2;
import com.tencent.bugly.crashreport.biz.a.RunnableC0659a;
import com.tencent.bugly.crashreport.biz.a.c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static a a = null;
    private static boolean b = false;
    private static int c = 10;
    private static long d = 300000;
    private static long e = 30000;
    private static long f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static Application.ActivityLifecycleCallbacks k = null;
    private static Class<?> l = null;
    private static boolean m = true;

    static /* synthetic */ String a(String str, String str2) {
        return z.a() + "  " + str + "  " + str2 + "\n";
    }

    static /* synthetic */ int g() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean zIsEnableUserInfo;
        boolean zRecordUserInfoOnceADay;
        boolean z;
        if (buglyStrategy != null) {
            zRecordUserInfoOnceADay = buglyStrategy.recordUserInfoOnceADay();
            zIsEnableUserInfo = buglyStrategy.isEnableUserInfo();
        } else {
            zIsEnableUserInfo = true;
            zRecordUserInfoOnceADay = false;
        }
        if (zRecordUserInfoOnceADay) {
            com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
            List<UserInfoBean> listA = a.a(aVarA.d);
            if (listA == null) {
                z = true;
                break;
            }
            int i2 = 0;
            while (true) {
                if (i2 < listA.size()) {
                    UserInfoBean userInfoBean = listA.get(i2);
                    if (userInfoBean.n.equals(aVarA.j) && userInfoBean.b == 1) {
                        long jB = z.b();
                        if (jB > 0) {
                            if (userInfoBean.e >= jB) {
                                if (userInfoBean.f <= 0) {
                                    a aVar = a;
                                    w wVarA = w.a();
                                    if (wVarA != null) {
                                        wVarA.a(aVar.new AnonymousClass2());
                                    }
                                }
                                z = false;
                                break;
                            }
                        }
                    }
                    i2++;
                }
                z = true;
                break;
            }
            if (!z) {
                return;
            } else {
                zIsEnableUserInfo = false;
            }
        }
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        if (aVarB != null) {
            boolean z2 = false;
            String className = null;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getMethodName().equals("onCreate")) {
                    className = stackTraceElement.getClassName();
                }
                if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                    z2 = true;
                }
            }
            if (className == null) {
                className = "unknown";
            } else if (z2) {
                aVarB.a(true);
            } else {
                className = "background";
            }
            aVarB.p = className;
        }
        if (zIsEnableUserInfo) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (k == null) {
                        k = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.bugly.crashreport.biz.b.2
                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityStarted(Activity activity) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityStopped(Activity activity) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityResumed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onResumed <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a aVarB2 = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (aVarB2 == null) {
                                        return;
                                    }
                                    aVarB2.C.add(b.a(name, "onResumed"));
                                    aVarB2.a(true);
                                    aVarB2.p = name;
                                    aVarB2.q = System.currentTimeMillis();
                                    aVarB2.t = aVarB2.q - b.i;
                                    long j2 = aVarB2.q - b.h;
                                    if (j2 > (b.f > 0 ? b.f : b.e)) {
                                        aVarB2.d();
                                        b.g();
                                        x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(b.e / 1000));
                                        if (b.g % b.c == 0) {
                                            b.a.a(4, b.m, 0L);
                                            return;
                                        }
                                        b.a.a(4, false, 0L);
                                        long jCurrentTimeMillis = System.currentTimeMillis();
                                        if (jCurrentTimeMillis - b.j > b.d) {
                                            long unused = b.j = jCurrentTimeMillis;
                                            x.a("add a timer to upload hot start user info", new Object[0]);
                                            if (b.m) {
                                                w.a().a(b.a.new RunnableC0659a(null, true), b.d);
                                            }
                                        }
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityPaused(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onPaused <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a aVarB2 = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (aVarB2 == null) {
                                        return;
                                    }
                                    aVarB2.C.add(b.a(name, "onPaused"));
                                    aVarB2.a(false);
                                    aVarB2.r = System.currentTimeMillis();
                                    aVarB2.s = aVarB2.r - aVarB2.q;
                                    long unused = b.h = aVarB2.r;
                                    if (aVarB2.s < 0) {
                                        aVarB2.s = 0L;
                                    }
                                    if (activity != null) {
                                        aVarB2.p = "background";
                                    } else {
                                        aVarB2.p = "unknown";
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityDestroyed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onDestroyed <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a aVarB2 = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (aVarB2 != null) {
                                        aVarB2.C.add(b.a(name, "onDestroyed"));
                                    }
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public final void onActivityCreated(Activity activity, Bundle bundle) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (b.l == null || b.l.getName().equals(name)) {
                                    x.c(">>> %s onCreated <<<", name);
                                    com.tencent.bugly.crashreport.common.info.a aVarB2 = com.tencent.bugly.crashreport.common.info.a.b();
                                    if (aVarB2 != null) {
                                        aVarB2.C.add(b.a(name, "onCreated"));
                                    }
                                }
                            }
                        };
                    }
                    application.registerActivityLifecycleCallbacks(k);
                } catch (Exception e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (m) {
            i = System.currentTimeMillis();
            a.a(1, false, 0L);
            x.a("[session] launch app, new start", new Object[0]);
            a.a();
            w.a().a(a.new c(21600000L), 21600000L);
        }
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long appReportDelay;
        if (b) {
            return;
        }
        m = com.tencent.bugly.crashreport.common.info.a.a(context).e;
        a = new a(context, m);
        b = true;
        if (buglyStrategy != null) {
            l = buglyStrategy.getUserInfoActivity();
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        if (appReportDelay <= 0) {
            c(context, buglyStrategy);
        } else {
            w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(context, buglyStrategy);
                }
            }, appReportDelay);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().q;
        }
        f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        w wVarA;
        a aVar = a;
        if (aVar != null && !z && (wVarA = w.a()) != null) {
            wVarA.a(aVar.new AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.q > 0) {
            e = strategyBean.q;
        }
        if (strategyBean.w > 0) {
            c = strategyBean.w;
        }
        if (strategyBean.x > 0) {
            d = strategyBean.x;
        }
    }

    public static void a() {
        a aVar = a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!b || context == null) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application != null) {
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = k;
                if (activityLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            } catch (Exception e2) {
                if (!x.a(e2)) {
                    e2.printStackTrace();
                }
            }
        }
        b = false;
    }
}
