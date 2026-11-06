package com.byazt.sd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 48})
public class lb {
    public static volatile Handler uc;
    public static volatile boolean pr = false;
    public static AtomicBoolean hw = new AtomicBoolean(false);
    public static AtomicBoolean hn = new AtomicBoolean(false);
    public static AtomicBoolean x = new AtomicBoolean(false);
    public static final long c = SystemClock.elapsedRealtime();

    public static void pr() {
        Context context;
        if (x.get() || !a.hw().vj() || (context = a.getContext()) == null) {
            return;
        }
        try {
            com.byazt.pk.uc.pr().hw().pr(context, true, new com.byazt.pk.c(context));
        } catch (Exception e) {
        }
        x.set(true);
    }

    public static void hw() {
        a.hw().pr(1);
        if (!x.get()) {
            pr();
        }
        Context context = a.getContext();
        if (context == null) {
            return;
        }
        try {
            com.byazt.pk.uc.pr().hw().pr(context, com.byazt.iy.hw.pr());
        } catch (Exception e) {
        }
    }

    public static void hn() {
        com.byazt.zq.hn hnVarPr = hw.pr();
        long jHw = hnVarPr.hw("sdk_first_init_timestamp", 0L);
        if (jHw == 0) {
            jHw = System.currentTimeMillis();
            hnVarPr.pr("sdk_first_init_timestamp", jHw);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strHw = ls.hw(jHw, jCurrentTimeMillis);
        long jHw2 = hnVarPr.hw("sdk_init_timestamp", 0L);
        com.byazt.xk.hw.pr().pr(strHw, new StringBuilder().append(jHw2 != 0 ? (jCurrentTimeMillis - jHw2) / 1000 : 0L).toString());
        hnVarPr.pr("sdk_init_timestamp", System.currentTimeMillis());
    }

    private static void fw() {
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
        } catch (Throwable th) {
        }
    }

    public static void pr(Context context) {
        hw.set(true);
        hn.set(true);
        fw();
        er.hw(context);
        zo();
        String strPr = com.byazt.wt.nt.pr();
        if (!TextUtils.isEmpty(strPr)) {
            com.byazt.lg.pr.pr(zo.nt().ny()).pr(strPr);
        }
        if (com.byazt.qv.pr.pr() != null) {
            com.byazt.qv.pr.pr().pr(strPr);
        }
        com.byazt.ce.hw.pr();
        new com.byazt.iq.hw(256).pr(new Runnable() { // from class: com.byazt.sd.lb.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.z.hw.hw();
            }
        });
    }

    public static void x() {
        com.byazt.bg.pr.pr().pr(new com.byazt.bg.hn() { // from class: com.byazt.sd.lb.2
            @Override // com.byazt.bg.hn
            public int pr() {
                if (a.hw() == null) {
                    return 0;
                }
                return a.hw().tn();
            }

            @Override // com.byazt.bg.hn
            public Context getContext() {
                return a.getContext();
            }

            @Override // com.byazt.bg.hn
            public Handler hw() {
                return lb.uc();
            }

            @Override // com.byazt.bg.hn
            public com.byazt.hfm.pr hn() {
                return a.pr().pr(1);
            }

            @Override // com.byazt.bg.hn
            public String x() {
                return zo.nt().ny();
            }

            @Override // com.byazt.bg.hn
            public int c() {
                return 0;
            }

            @Override // com.byazt.bg.hn
            public int uc() {
                return a.hw().tz();
            }

            @Override // com.byazt.bg.hn
            public int fw() {
                return a.hw().jg();
            }

            @Override // com.byazt.bg.hn
            public int zo() {
                return zo.nt().nw();
            }

            @Override // com.byazt.bg.hn
            public int aj() {
                return a.hw().rr();
            }

            @Override // com.byazt.bg.hn
            public boolean vk() {
                return com.byazt.iy.hw.pr();
            }

            @Override // com.byazt.bg.hn
            public ExecutorService w() {
                return null;
            }

            @Override // com.byazt.bg.hn
            public ExecutorService k() {
                return null;
            }

            @Override // com.byazt.bg.hn
            public int m() {
                return er.c(a.getContext());
            }
        });
        com.byazt.ca.g.pr(new com.byazt.ca.g.pr() { // from class: com.byazt.sd.lb.3
            @Override // com.byazt.ca.g.pr
            public String pr() {
                return com.byazt.hb.hn.pr("");
            }

            @Override // com.byazt.ca.g.pr
            public String hw() {
                return com.byazt.hb.c.pr().x();
            }
        });
    }

    public static void c() {
        com.byazt.bg.pr.pr().pr(new com.byazt.bg.hw() { // from class: com.byazt.sd.lb.4
            @Override // com.byazt.bg.hw
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.byazt.ad.pr.update(a.getContext(), str, contentValues, str2, strArr);
            }

            @Override // com.byazt.bg.hw
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.byazt.ad.pr.query(a.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.byazt.bg.hw
            public int delete(String str, String str2, String[] strArr) {
                return com.byazt.ad.pr.delete(a.getContext(), str, str2, strArr);
            }

            @Override // com.byazt.bg.hw
            public void insert(String str, ContentValues contentValues) {
                com.byazt.ad.pr.insert(a.getContext(), str, contentValues);
            }
        });
        com.byazt.bg.pr.pr().pr(new com.byazt.bg.x() { // from class: com.byazt.sd.lb.5
            @Override // com.byazt.bg.x
            public void pr(int i) {
                com.byazt.xk.hw.pr().pr("express_ad_render", i, fw.pr(i), (com.byazt.ttf.pr) null);
            }
        });
        com.byazt.bg.pr.pr().pr(new pr());
        com.byazt.bg.pr.pr().pr(new com.byazt.bg.c() { // from class: com.byazt.sd.lb.6
            @Override // com.byazt.bg.c
            public void delete(String str, String str2) {
                com.byazt.mp.hw.pr().pr(str, str2);
            }

            @Override // com.byazt.bg.c
            public void update(String str, com.byazt.hfm.hn hnVar) {
                com.byazt.mp.hw.pr().pr(str, hnVar);
            }
        });
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 855})
    private static final class pr implements com.byazt.ld.ny {
        private pr() {
        }

        @Override // com.byazt.ld.ny
        public com.byazt.ld.g pr(String str) {
            return com.byazt.ub.hw.hw().pr(str);
        }

        @Override // com.byazt.ld.ny
        public void pr(double d) {
            com.byazt.ub.hw.hw().pr(d);
        }

        @Override // com.byazt.ld.ny
        public void hw(double d) {
            com.byazt.ub.hw.hw().hw(d);
        }

        @Override // com.byazt.ld.ny
        public void hn(double d) {
            com.byazt.ub.hw.hw().hn(d);
        }

        @Override // com.byazt.ld.ny
        public void pr() {
            com.byazt.ub.hw.hw().pr();
        }

        @Override // com.byazt.ld.ny
        public InputStream pr(String str, String str2) {
            return com.byazt.ub.hw.hw().pr(str, str2);
        }

        @Override // com.byazt.ld.ny
        public InputStream pr(String str, String str2, String str3) {
            return com.byazt.ub.hw.hw().pr(str, str2, str3);
        }

        @Override // com.byazt.ld.ny
        public boolean hw(String str, String str2, String str3) {
            return com.byazt.ub.hw.hw().hw(str, str2, str3);
        }
    }

    private static void zo() {
        com.byazt.mp.x.pr().hw(UUID.randomUUID().toString());
    }

    public static Handler uc() {
        if (uc == null) {
            synchronized (lb.class) {
                if (uc == null) {
                    uc = new Handler(Looper.getMainLooper());
                }
            }
        }
        return uc;
    }
}
