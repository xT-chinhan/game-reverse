package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class nw {
    private static volatile Handler c = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile boolean f3028ms = false;
    public static AtomicBoolean xr = new AtomicBoolean(false);
    public static AtomicBoolean ah = new AtomicBoolean(false);
    public static AtomicBoolean d = new AtomicBoolean(false);
    public static final long ka = SystemClock.elapsedRealtime();

    public static void ms() {
        Context context;
        if (d.get() || !re.xr().f() || (context = re.getContext()) == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ms(context, true, new com.bytedance.sdk.openadsdk.core.re.d(context));
        } catch (Exception unused) {
        }
        d.set(true);
    }

    public static void xr() {
        re.xr().ms(1);
        if (!d.get()) {
            ms();
        }
        Context context = re.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ms(context, com.bytedance.sdk.openadsdk.core.multipro.xr.ah());
        } catch (Exception unused) {
        }
    }

    public static void ah() {
        com.bytedance.sdk.component.d.ms.xr xrVarMs = xr.ms();
        long jXr = xrVarMs.xr("sdk_first_init_timestamp", 0L);
        if (jXr == 0) {
            jXr = System.currentTimeMillis();
            xrVarMs.ms("sdk_first_init_timestamp", jXr);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strXr = com.bytedance.sdk.openadsdk.core.jw.f.xr(jXr, jCurrentTimeMillis);
        long jXr2 = xrVarMs.xr("sdk_init_timestamp", 0L);
        com.bytedance.sdk.openadsdk.core.t.u.ms().ms(strXr, new StringBuilder().append(jXr2 != 0 ? (jCurrentTimeMillis - jXr2) / 1000 : 0L).toString());
        xrVarMs.ms("sdk_init_timestamp", System.currentTimeMillis());
    }

    private static void ab() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Throwable unused) {
        }
    }

    public static void ms(Context context) {
        xr.set(true);
        ah.set(true);
        ab();
        com.bytedance.sdk.openadsdk.core.jw.ul.ms(context);
        x();
        String strAh = t.ah();
        com.bytedance.sdk.component.utils.sl.ms("appLogID", strAh);
        if (!TextUtils.isEmpty(strAh)) {
            com.bytedance.sdk.openadsdk.core.t.xr.ms(strAh);
        }
        if (com.bytedance.sdk.openadsdk.ms.ms.ms.ms() != null) {
            com.bytedance.sdk.openadsdk.ms.ms.ms.ms().ms(strAh);
        }
        com.bytedance.sdk.component.adexpress.ms.xr.xr.ms();
        new com.bytedance.sdk.openadsdk.core.d.xr("playable_engine_init").xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nw.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ms.xr.xr.xr();
            }
        });
    }

    public static void d() {
        com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ms(new com.bytedance.sdk.component.adexpress.ms.ms.ah() { // from class: com.bytedance.sdk.openadsdk.core.nw.2
            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public int ab() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public ExecutorService u() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public ExecutorService zb() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public int ms() {
                if (re.xr() == null) {
                    return 0;
                }
                return re.xr().zx();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public Context getContext() {
                return re.getContext();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public Handler xr() {
                return nw.c();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public com.bytedance.sdk.component.adexpress.ms.ah.ms ah() {
                return re.ms().ms(1);
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public com.bytedance.sdk.component.ny.xr.xr d() {
                return com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().d();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public com.bytedance.sdk.component.ny.xr.ah ka() {
                return com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public String c() {
                return ch.ub().t();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public int x() {
                return re.xr().jj();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public int ny() {
                return re.xr().so();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public int ch() {
                return ch.ub().l();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public int hi() {
                return re.xr().a();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public boolean sl() {
                return com.bytedance.sdk.openadsdk.core.multipro.xr.ah();
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ah
            public int ub() {
                return com.bytedance.sdk.openadsdk.core.jw.ul.d(re.getContext());
            }
        });
    }

    public static void ka() {
        com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ms(new com.bytedance.sdk.component.adexpress.ms.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.nw.3
            @Override // com.bytedance.sdk.component.adexpress.ms.ms.xr
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.ms.ms.update(re.getContext(), str, contentValues, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.xr
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.xr
            public int delete(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.xr
            public void insert(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.core.multipro.ms.ms.insert(re.getContext(), str, contentValues);
            }
        });
        com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ms(new com.bytedance.sdk.component.adexpress.ms.ms.d() { // from class: com.bytedance.sdk.openadsdk.core.nw.4
            @Override // com.bytedance.sdk.component.adexpress.ms.ms.d
            public void ms(final int i) {
                com.bytedance.sdk.openadsdk.core.t.u.ms().ka(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.4.1
                    @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                    public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                        return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().xr(i).ab(ny.ms(i));
                    }
                });
            }
        });
        com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ms(new ms());
        com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ms(new com.bytedance.sdk.component.adexpress.ms.ms.ka() { // from class: com.bytedance.sdk.openadsdk.core.nw.5
            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ka
            public void delete(String str, String str2) {
                com.bytedance.sdk.openadsdk.core.ah.xr.ms().ms(str, str2);
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.ms.ka
            public void update(String str, com.bytedance.sdk.component.adexpress.ms.ah.ah ahVar) {
                com.bytedance.sdk.openadsdk.core.ah.xr.ms().ms(str, ahVar);
            }
        });
    }

    private static final class ms implements com.bytedance.sdk.component.c.ub {
        private ms() {
        }

        @Override // com.bytedance.sdk.component.c.ub
        @ATSMethod(1)
        public com.bytedance.sdk.component.c.ch ms(String str) {
            return com.bytedance.sdk.openadsdk.x.xr.ms().ms(str);
        }

        @Override // com.bytedance.sdk.component.c.ub
        @ATSMethod(2)
        public void ms(double d) {
            com.bytedance.sdk.openadsdk.x.xr.ms().ms(d);
        }

        @Override // com.bytedance.sdk.component.c.ub
        @ATSMethod(3)
        public void xr(double d) {
            com.bytedance.sdk.openadsdk.x.xr.ms().xr(d);
        }

        @Override // com.bytedance.sdk.component.c.ub
        @ATSMethod(4)
        public void ah(double d) {
            com.bytedance.sdk.openadsdk.x.xr.ms().ah(d);
        }

        @Override // com.bytedance.sdk.component.c.ub
        @ATSMethod(5)
        public void ms() {
            com.bytedance.sdk.openadsdk.x.xr.ms().ms();
        }

        @Override // com.bytedance.sdk.component.c.ub
        @ATSMethod(6)
        public InputStream ms(String str, String str2) {
            return com.bytedance.sdk.openadsdk.x.xr.ms().ms(str, str2);
        }

        @Override // com.bytedance.sdk.component.c.ub
        @ATSMethod(7)
        public InputStream ms(String str, String str2, String str3) {
            return com.bytedance.sdk.openadsdk.x.xr.ms().ms(str, str2, str3);
        }

        @Override // com.bytedance.sdk.component.c.ub
        @ATSMethod(8)
        public boolean xr(String str, String str2, String str3) {
            return com.bytedance.sdk.openadsdk.x.xr.ms().xr(str, str2, str3);
        }
    }

    private static void x() {
        com.bytedance.sdk.openadsdk.core.ah.d.ms().d(UUID.randomUUID().toString());
    }

    public static Handler c() {
        if (c == null) {
            synchronized (nw.class) {
                if (c == null) {
                    c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return c;
    }
}
