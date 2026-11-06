package com.byazt.ehw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import com.byazt.tk.cy;
import com.byazt.tk.hd;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 470, 2484})
public class DeviceUtils {
    public static volatile com.byazt.jjx.n cp = null;
    public static volatile long l = 0;
    public static volatile int q = -1;
    public static volatile int s = -1;
    public static volatile BroadcastReceiver tj = null;
    public static volatile long w = -1;
    public static final AtomicLong n = new AtomicLong();
    public static volatile int x = -1;
    public static volatile boolean fs = false;
    public static volatile boolean rv = false;
    public static String d = "";
    public static String oa = "";
    public static int qg = -1;
    public static long sz = 0;
    public static long k = 0;

    public static boolean n() {
        return ((oa) com.byazt.qp.q.n("device_info_new")).ur();
    }

    public static String qg() {
        String strN = ((oa) com.byazt.qp.q.n("device_info_new")).n();
        String str = d;
        if (str == null || !str.equals(strN)) {
            d = strN;
            com.byazt.lq.s.qg(9, strN);
        }
        return strN;
    }

    public static String n(Boolean bool) {
        String strQg = ((oa) com.byazt.qp.q.n("device_info_new")).qg(bool);
        String str = oa;
        if (str == null || !str.equals(strQg)) {
            oa = strQg;
            com.byazt.lq.s.qg(6, strQg);
        }
        return strQg;
    }

    public static void s() {
        q();
        l();
        w();
        n(0);
        n(1);
        ((oa) com.byazt.qp.q.n("device_info_new")).s(false);
        w.qg((String) null);
    }

    public static int q() {
        int iQg = hd.qg(com.byazt.nf.rv.getContext());
        s = iQg;
        return iQg;
    }

    public static void n(JSONObject jSONObject) throws JSONException {
        if (q.qg()) {
            jSONObject.putOpt("os_new", "harmony");
            jSONObject.putOpt("harmonyos_api", q.l());
            jSONObject.putOpt("harmonyos_version", q.w());
            jSONObject.putOpt("harmonyos_release_type", q.x());
            jSONObject.putOpt("harmonyos_build_version", q.fs());
            jSONObject.putOpt("pure_mode", Integer.valueOf(q.n(com.byazt.nf.rv.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", "android");
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static float l() {
        return ((oa) com.byazt.qp.q.n("device_info_new")).bb();
    }

    @com.byazt.cp.n(n = {0, 1, 470, 2163})
    public static class n {
        public static int n = -1;
        public static float qg;

        public static int n(Context context) {
            com.byazt.na.qg.n(context);
            return n;
        }

        public static float qg(Context context) {
            com.byazt.na.qg.qg(context);
            return qg;
        }
    }

    public static boolean n(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 470, 471})
    public static class DeviceStatusBroadCastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.byazt.tk.rv.s().post(new Runnable() { // from class: com.byazt.ehw.DeviceUtils.DeviceStatusBroadCastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    DeviceStatusBroadCastReceiver.this.n(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(Intent intent) {
            int intExtra = -1;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("present", false);
                if (booleanExtra) {
                    int intExtra2 = intent.getIntExtra("status", -1);
                    if (intExtra2 == -1) {
                        n.n = intExtra2;
                    } else if (intExtra2 == 2) {
                        n.n = 1;
                    } else {
                        n.n = 0;
                    }
                } else {
                    n.n = 2;
                }
                n.qg = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
                if (!com.byazt.vyf.s.cy().lh()) {
                    com.byazt.na.qg.n(booleanExtra);
                }
            }
            try {
                intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            } catch (Exception unused) {
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intExtra == 3) {
                com.byazt.tk.rv.n().post(new com.byazt.qit.x("tt_vol") { // from class: com.byazt.ehw.DeviceUtils.DeviceStatusBroadCastReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        try {
                            AudioManager audioManager = (AudioManager) com.byazt.nf.rv.getContext().getSystemService(MediaFormat.KEY_AUDIO);
                            if (audioManager == null) {
                                return;
                            }
                            int streamVolume = audioManager.getStreamVolume(3);
                            if (streamVolume != DeviceUtils.x) {
                                com.byazt.fr.s.n().n(streamVolume);
                            }
                            if (DeviceUtils.x != -1) {
                                if (streamVolume == 0) {
                                    i = 0;
                                } else {
                                    i = streamVolume - DeviceUtils.x > 0 ? 2 : 1;
                                }
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (jCurrentTimeMillis - DeviceUtils.k > 1000) {
                                    com.byazt.eji.s.n(i, -1);
                                }
                                long unused2 = DeviceUtils.k = jCurrentTimeMillis;
                            }
                            int unused3 = DeviceUtils.x = streamVolume;
                        } catch (Exception unused4) {
                        }
                    }
                });
            }
        }
    }

    public static int w() {
        if (q != -1 && !n(l, 60000L)) {
            return q;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.byazt.nf.rv.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        q = accessibilityManager.isEnabled() ? 1 : 0;
        l = System.currentTimeMillis();
        return q;
    }

    public static void x() {
        if (com.byazt.nf.rv.getContext() != null) {
            int iOa = com.byazt.vgx.w.oa();
            com.byazt.ed.s.n().n("cpu_cnt", iOa);
            com.byazt.vgx.w.n = iOa;
            int iS = com.byazt.vgx.w.s(com.byazt.vgx.w.oa());
            com.byazt.ed.s.n().n("cpu_max_freq", iS);
            com.byazt.vgx.w.qg = iS;
            int iQ = com.byazt.vgx.w.q(com.byazt.vgx.w.oa());
            com.byazt.ed.s.n().n("cpu_min_freq", iQ);
            com.byazt.vgx.w.s = iQ;
            String strX = com.byazt.vgx.w.x("MemTotal");
            if (strX != null) {
                com.byazt.ed.s.n().n("total_memory", strX);
                com.byazt.vgx.w.q = strX;
            }
            long jCd = com.byazt.vgx.w.cd();
            com.byazt.ed.s.n().n("internal_storage", jCd);
            com.byazt.vgx.w.l = jCd;
            long jN = cy.n();
            com.byazt.ed.s.n().n("free_storage", jN);
            com.byazt.vgx.w.w = jN;
            long jPy = com.byazt.vgx.w.py();
            com.byazt.ed.s.n().n("sdcard_storage", jPy);
            com.byazt.vgx.w.x = jPy;
            boolean zWm = com.byazt.vgx.w.wm();
            com.byazt.ed.s.n().n("is_root", zWm ? 1 : 0);
            com.byazt.vgx.w.fs = zWm ? 1 : 0;
        }
    }

    public static void qg(Context context) {
        if (!fs) {
            try {
                tj = new DeviceStatusBroadCastReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                context.getApplicationContext().registerReceiver(tj, intentFilter);
                fs = true;
            } catch (Throwable unused) {
            }
        }
        if (rv) {
            return;
        }
        com.byazt.jjx.n nVar = new com.byazt.jjx.n(com.byazt.nf.rv.getContext(), com.byazt.tk.rv.qg(), new com.byazt.jjx.n.InterfaceC0222n() { // from class: com.byazt.ehw.DeviceUtils.1
            @Override // com.byazt.jjx.n.InterfaceC0222n
            public void n(int i) {
                boolean zN = DeviceUtils.n(com.byazt.nf.rv.getContext());
                if (DeviceUtils.qg == -1) {
                    DeviceUtils.qg = i;
                    return;
                }
                int i2 = DeviceUtils.qg - i;
                DeviceUtils.qg = i;
                if (zN) {
                    if (Math.abs(i2) > 20) {
                        int i3 = i2 > 0 ? 1 : 2;
                        com.byazt.fr.s.n().n(true);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - DeviceUtils.sz > 1000) {
                            com.byazt.eji.s.n(-1, i3);
                        }
                        long unused2 = DeviceUtils.sz = jCurrentTimeMillis;
                        return;
                    }
                    return;
                }
                if (DeviceUtils.qg != -1) {
                    com.byazt.eji.s.n(-1, i2 > 0 ? 1 : 2);
                }
                com.byazt.fr.s.n().n(true);
            }
        });
        cp = nVar;
        nVar.n();
        rv = true;
    }

    public static String n(int i) {
        return ((oa) com.byazt.qp.q.n("device_info_new")).n(i);
    }

    public static boolean n(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static int fs() {
        return (int) (com.byazt.nf.rv.getContext().getResources().getConfiguration().fontScale * 16.0f);
    }

    public static JSONObject n(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ACTD.APPID_KEY, com.byazt.vyf.s.cy().ou());
            jSONObject.put(TapEventParamConstants.PARAM_NAME, com.byazt.vyf.s.cy().wm());
            qg(jSONObject);
            com.byazt.hnb.n.qg(jSONObject);
            jSONObject.put("is_paid_app", com.byazt.vyf.s.cy().m());
            if (!com.byazt.ed.s.n().x(i)) {
                jSONObject.put("network_speed", com.byazt.jc.s.n());
            }
            jSONObject.put("apk_sign", com.byazt.ges.qg.cp());
            jSONObject.put("useful_open_sdk", com.byazt.soz.q.s().qg());
            jSONObject.put("real_app_name", com.byazt.ges.qg.tj());
            jSONObject.put("app_cold_startup_time", com.byazt.wb.s.x().l());
            jSONObject.put("sdk_init_timestamp", com.byazt.wb.s.x().w());
            if (z) {
                jSONObject.put("session_ad_index", n.addAndGet(1L));
                if (com.byazt.nf.rv.qg().cl()) {
                    long jS = com.byazt.wb.n.s();
                    jSONObject.put("app_total_7_duration", com.byazt.wb.n.q() + jS);
                    jSONObject.put("app_use_7_duration", jS);
                    jSONObject.put("start_session", com.byazt.wb.n.l());
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void qg(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", com.byazt.vgx.w.fs());
            jSONObject.put("version_code", com.byazt.vgx.w.rv());
            jSONObject.put("version", com.byazt.vgx.w.tj());
        } catch (Exception unused) {
        }
    }

    public static void n(long j) {
        if (j == -1 || w == j) {
            return;
        }
        w = j;
        com.byazt.ed.s.n().n("dev19", j);
    }

    public static long rv() {
        if (w != -1) {
            return w;
        }
        return com.byazt.ed.s.n().qg("dev19", -1L);
    }

    public static int tj() {
        if (x >= 0) {
            return x;
        }
        try {
            AudioManager audioManager = (AudioManager) com.byazt.nf.rv.getContext().getSystemService(MediaFormat.KEY_AUDIO);
            if (audioManager == null) {
                return 0;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            com.byazt.fr.s.n().qg(streamVolume);
            x = streamVolume;
            return x;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void cp() {
        try {
            if (fs && tj != null) {
                com.byazt.nf.rv.getContext().getApplicationContext().unregisterReceiver(tj);
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        if (rv && cp != null) {
            cp.qg();
        }
    }
}
