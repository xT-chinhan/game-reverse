package com.anythink.odopt.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.af;
import com.anythink.core.common.v.b.b;
import com.anythink.core.common.v.m;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static volatile long a = 0;
    private static String c = "";
    private static boolean d = false;
    private static boolean e = false;
    private static final long f = 5000;
    private static final int g = 10;
    private static AtomicInteger h = new AtomicInteger(0);
    private static AtomicLong i = new AtomicLong(0);
    private static Object j = new Object();
    public static volatile boolean b = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, String str, boolean z) {
        c = str;
        m.e(str);
        if (!TextUtils.isEmpty(str)) {
            h.set(11);
        }
        if (z) {
            af.b(context, u.b.a, "oaid", str);
        }
    }

    public static void a(final Context context) {
        String strC = af.c(context, u.b.a, "oaid", "");
        a(context, strC, false);
        i.set(System.currentTimeMillis());
        if (!TextUtils.isEmpty(strC) || t.b().c("oaid")) {
            return;
        }
        b.a().a(new Runnable() { // from class: com.anythink.odopt.b.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.c(context);
            }
        });
    }

    public static String b(Context context) {
        String strC = c(context);
        return !TextUtils.isEmpty(strC) ? strC : "";
    }

    public static String c(final Context context) {
        if (!t.b().c("oaid")) {
            if (!TextUtils.isEmpty(c)) {
                return c;
            }
            synchronized (j) {
                if (!e) {
                    e = true;
                    c = af.c(context, u.b.a, "oaid", "");
                }
                if (!TextUtils.isEmpty(c)) {
                    return c;
                }
                if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
                    t.b();
                    if (!t.c(t.b().g())) {
                        a(ATSDKGlobalSetting.isDenyApi_getRunningAppProcesses() ? 2 : 3, "");
                        return "";
                    }
                }
                if (d) {
                    return c;
                }
                d = true;
                a = System.currentTimeMillis();
                final Object obj = new Object();
                final boolean[] zArr = {false};
                c();
                com.anythink.odopt.a.b.a(context, new com.anythink.odopt.a.a() { // from class: com.anythink.odopt.b.a.2
                    @Override // com.anythink.odopt.a.a
                    public final void a(String str, boolean z) {
                        if (!a.a(str)) {
                            a.a(context, str, true);
                        }
                        try {
                            t.b().h(str);
                            synchronized (obj) {
                                obj.notifyAll();
                            }
                        } catch (Throwable unused) {
                        }
                        zArr[0] = true;
                    }

                    @Override // com.anythink.odopt.a.a
                    public final void a(String str) {
                        zArr[0] = true;
                        try {
                            synchronized (obj) {
                                obj.notifyAll();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                if (!zArr[0]) {
                    try {
                        synchronized (obj) {
                            obj.wait(1500L);
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zArr[0] && TextUtils.isEmpty(c)) {
                    a(4, "");
                }
                String str = c;
                if (str == null) {
                    str = "";
                }
                return str;
            }
        }
        a(1, "");
        return "";
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return Pattern.matches("^[0-]+$", str);
    }

    public static String a() {
        if (t.b().c("oaid")) {
            return "";
        }
        if (TextUtils.isEmpty(c) && System.currentTimeMillis() - i.get() > 5000 && h.get() < 10 && t.b().W()) {
            c();
            t.b();
            t.c(new Runnable() { // from class: com.anythink.odopt.b.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    final Context contextG = t.b().g();
                    if (contextG != null) {
                        com.anythink.odopt.a.b.a(contextG, new com.anythink.odopt.a.a() { // from class: com.anythink.odopt.b.a.3.1
                            @Override // com.anythink.odopt.a.a
                            public final void a(String str, boolean z) {
                                if (!a.a(str)) {
                                    a.a(contextG, str, true);
                                }
                                try {
                                    t.b().h(str);
                                } catch (Throwable unused) {
                                }
                            }

                            @Override // com.anythink.odopt.a.a
                            public final void a(String str) {
                                if (a.h.get() == 10) {
                                    a.a(6, str);
                                }
                            }
                        });
                    }
                }
            });
        }
        return c;
    }

    public static void a(final int i2, final String str) {
        if (!b || i2 == 6) {
            b = true;
            final long jCurrentTimeMillis = a > 0 ? System.currentTimeMillis() - a : 0L;
            b.a().a(new Runnable() { // from class: com.anythink.odopt.b.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (t.b().g() == null) {
                        return;
                    }
                    int iB = af.b(t.b().g(), u.b.a, "oaid_fail_count", 0);
                    if (i2 != 6) {
                        if (iB >= 3) {
                            return;
                        }
                        iB++;
                        af.a(t.b().g(), u.b.a, "oaid_fail_count", iB);
                    }
                    e.a(iB, i2, str, jCurrentTimeMillis);
                }
            });
        }
    }

    private static void c() {
        h.incrementAndGet();
        i.set(System.currentTimeMillis());
    }

    static /* synthetic */ boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return Pattern.matches("^[0-]+$", str);
    }
}
