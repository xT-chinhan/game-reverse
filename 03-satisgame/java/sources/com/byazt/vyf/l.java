package com.byazt.vyf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.si.ou;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 18})
public class l {
    public static volatile boolean n = false;
    public static volatile Handler w;
    public static AtomicBoolean qg = new AtomicBoolean(false);
    public static AtomicBoolean s = new AtomicBoolean(false);
    public static AtomicBoolean q = new AtomicBoolean(false);
    public static final long l = SystemClock.elapsedRealtime();

    public static void n() {
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        long jQg = sVarN.qg("sdk_first_init_timestamp", 0L);
        if (jQg == 0) {
            jQg = System.currentTimeMillis();
            sVarN.n("sdk_first_init_timestamp", jQg);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strQg = com.byazt.vgx.w.qg(jQg, jCurrentTimeMillis);
        long jQg2 = sVarN.qg("sdk_init_timestamp", 0L);
        com.byazt.eji.s.n().n(strQg, new StringBuilder().append(jQg2 != 0 ? (jCurrentTimeMillis - jQg2) / 1000 : 0L).toString());
        sVarN.n("sdk_init_timestamp", System.currentTimeMillis());
    }

    private static void l() {
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

    public static void n(Context context) {
        qg.set(true);
        s.set(true);
        l();
        com.byazt.okk.s.qg(context);
        w();
        String strN = com.byazt.ehw.l.n();
        if (!TextUtils.isEmpty(strN)) {
            com.byazt.cw.n.n(s.cy().ou()).n(strN);
        }
        if (com.byazt.orb.n.n() != null) {
            com.byazt.orb.n.n().n(strN);
        }
        com.byazt.mzw.qg.n();
        new com.byazt.gv.qg(256).n(new Runnable() { // from class: com.byazt.vyf.l.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.na.qg.qg();
            }
        });
    }

    public static void qg() {
        com.byazt.gkj.n.n().n(new com.byazt.gkj.s() { // from class: com.byazt.vyf.l.2
            @Override // com.byazt.gkj.s
            public ExecutorService cp() {
                return null;
            }

            @Override // com.byazt.gkj.s
            public ExecutorService d() {
                return null;
            }

            @Override // com.byazt.gkj.s
            public int l() {
                return 0;
            }

            @Override // com.byazt.gkj.s
            public int n() {
                if (rv.qg() == null) {
                    return 0;
                }
                return rv.qg().xu();
            }

            @Override // com.byazt.gkj.s
            public Context getContext() {
                return rv.getContext();
            }

            @Override // com.byazt.gkj.s
            public Handler qg() {
                return l.q();
            }

            @Override // com.byazt.gkj.s
            public com.byazt.px.n s() {
                return rv.n().n(1);
            }

            @Override // com.byazt.gkj.s
            public String q() {
                return s.cy().ou();
            }

            @Override // com.byazt.gkj.s
            public int w() {
                return rv.qg().xs();
            }

            @Override // com.byazt.gkj.s
            public int x() {
                return rv.qg().ds();
            }

            @Override // com.byazt.gkj.s
            public int fs() {
                return s.cy().dh();
            }

            @Override // com.byazt.gkj.s
            public int rv() {
                return rv.qg().yr();
            }

            @Override // com.byazt.gkj.s
            public boolean tj() {
                return com.byazt.byp.qg.n();
            }

            @Override // com.byazt.gkj.s
            public int oa() {
                return com.byazt.okk.s.l(rv.getContext());
            }
        });
        sz.n(new sz.n() { // from class: com.byazt.vyf.l.3
            @Override // com.byazt.tk.sz.n
            public String n() {
                return com.byazt.iu.n.n("");
            }

            @Override // com.byazt.tk.sz.n
            public String qg() {
                return com.byazt.iu.s.n().q();
            }
        });
    }

    public static void s() {
        com.byazt.gkj.n.n().n(new com.byazt.gkj.qg() { // from class: com.byazt.vyf.l.4
            @Override // com.byazt.gkj.qg
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.byazt.xp.n.update(rv.getContext(), str, contentValues, str2, strArr);
            }

            @Override // com.byazt.gkj.qg
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.byazt.xp.n.query(rv.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.byazt.gkj.qg
            public int delete(String str, String str2, String[] strArr) {
                return com.byazt.xp.n.delete(rv.getContext(), str, str2, strArr);
            }

            @Override // com.byazt.gkj.qg
            public void insert(String str, ContentValues contentValues) {
                com.byazt.xp.n.insert(rv.getContext(), str, contentValues);
            }
        });
        com.byazt.gkj.n.n().n(new com.byazt.gkj.q() { // from class: com.byazt.vyf.l.5
            @Override // com.byazt.gkj.q
            public void n(int i) {
                com.byazt.eji.s.n().n("express_ad_render", i, com.byazt.bxg.n.n(i), (com.byazt.rs.n) null);
            }
        });
        com.byazt.gkj.n.n().n(new n());
        com.byazt.gkj.n.n().n(new com.byazt.gkj.l() { // from class: com.byazt.vyf.l.6
            @Override // com.byazt.gkj.l
            public void delete(String str, String str2) {
                com.byazt.ed.n.n().n(str, str2);
            }

            @Override // com.byazt.gkj.l
            public void update(String str, com.byazt.px.s sVar) {
                com.byazt.ed.n.n().n(str, sVar);
            }
        });
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static final class n implements ou {
        private n() {
        }

        @Override // com.byazt.si.ou
        public com.byazt.si.sz n(String str) {
            return com.byazt.imu.s.qg().n(str);
        }

        @Override // com.byazt.si.ou
        public void n(double d) {
            com.byazt.imu.s.qg().n(d);
        }

        @Override // com.byazt.si.ou
        public void qg(double d) {
            com.byazt.imu.s.qg().qg(d);
        }

        @Override // com.byazt.si.ou
        public void s(double d) {
            com.byazt.imu.s.qg().s(d);
        }

        @Override // com.byazt.si.ou
        public void n() {
            com.byazt.imu.s.qg().n();
        }

        @Override // com.byazt.si.ou
        public InputStream n(String str, String str2) {
            return com.byazt.imu.s.qg().n(str, str2);
        }

        @Override // com.byazt.si.ou
        public InputStream n(String str, String str2, String str3) {
            return com.byazt.imu.s.qg().n(str, str2, str3);
        }

        @Override // com.byazt.si.ou
        public boolean qg(String str, String str2, String str3) {
            return com.byazt.imu.s.qg().qg(str, str2, str3);
        }
    }

    private static void w() {
        com.byazt.ed.s.n().qg(UUID.randomUUID().toString());
    }

    public static Handler q() {
        if (w == null) {
            synchronized (l.class) {
                if (w == null) {
                    w = new Handler(Looper.getMainLooper());
                }
            }
        }
        return w;
    }
}
