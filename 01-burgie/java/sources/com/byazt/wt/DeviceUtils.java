package com.byazt.wt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.view.accessibility.AccessibilityManager;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.db.constant.Common;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 2278})
public class DeviceUtils {
    public static volatile long c;
    public static volatile BroadcastReceiver vk;
    public static volatile com.byazt.en.pr w;
    public static volatile int hn = -1;
    public static volatile int x = -1;
    public static volatile long uc = -1;
    public static final AtomicLong pr = new AtomicLong();
    public static volatile int fw = -1;
    public static volatile boolean zo = false;
    public static volatile boolean aj = false;
    public static String k = "";
    public static String m = "";
    public static int hw = -1;
    public static long g = 0;
    public static long ho = 0;

    public static boolean pr() {
        return ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).ve();
    }

    public static String hw() {
        String strPr = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).pr();
        String str = k;
        if (str == null || !str.equals(strPr)) {
            k = strPr;
            com.byazt.hs.hn.hw(9, strPr);
        }
        return strPr;
    }

    public static String pr(Boolean bool) {
        String strHw = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(bool);
        String str = m;
        if (str == null || !str.equals(strHw)) {
            m = strHw;
            com.byazt.hs.hn.hw(6, strHw);
        }
        return strHw;
    }

    public static void hn() {
        x();
        c();
        uc();
        pr(0);
        pr(1);
        ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hn(false);
        a.hw((String) null);
    }

    public static int x() {
        int iHw = com.byazt.ca.yb.hw(com.byazt.sd.a.getContext());
        hn = iHw;
        return iHw;
    }

    public static void pr(JSONObject jSONObject) throws JSONException {
        if (k.hw()) {
            jSONObject.putOpt("os_new", "harmony");
            jSONObject.putOpt("harmonyos_api", k.c());
            jSONObject.putOpt("harmonyos_version", k.uc());
            jSONObject.putOpt("harmonyos_release_type", k.fw());
            jSONObject.putOpt("harmonyos_build_version", k.zo());
            jSONObject.putOpt("pure_mode", Integer.valueOf(k.pr(com.byazt.sd.a.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", "android");
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static float c() {
        return ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).gz();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 2103})
    public static class pr {
        public static int pr = -1;
        public static float hw = 0.0f;

        public static int pr(Context context) {
            com.byazt.z.hw.pr(context);
            return pr;
        }

        public static float hw(Context context) {
            com.byazt.z.hw.hw(context);
            return hw;
        }
    }

    public static boolean pr(Context context) {
        try {
            if (Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") != 1) {
                return false;
            }
            return true;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 2227})
    public static class DeviceStatusBroadCastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.byazt.ca.aj.hn().post(new Runnable() { // from class: com.byazt.wt.DeviceUtils.DeviceStatusBroadCastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    DeviceStatusBroadCastReceiver.this.pr(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(Intent intent) {
            int intExtra = -1;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("present", false);
                if (booleanExtra) {
                    int intExtra2 = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                    if (intExtra2 == -1) {
                        pr.pr = intExtra2;
                    } else if (intExtra2 == 2) {
                        pr.pr = 1;
                    } else {
                        pr.pr = 0;
                    }
                } else {
                    pr.pr = 2;
                }
                pr.hw = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
                if (!com.byazt.sd.zo.nt().y()) {
                    com.byazt.z.hw.pr(booleanExtra);
                }
            }
            try {
                intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            } catch (Exception e) {
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intExtra == 3) {
                com.byazt.ca.aj.pr().post(new com.byazt.xlm.fw("tt_vol") { // from class: com.byazt.wt.DeviceUtils.DeviceStatusBroadCastReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        try {
                            AudioManager audioManager = (AudioManager) com.byazt.sd.a.getContext().getSystemService(MediaFormat.KEY_AUDIO);
                            if (audioManager == null) {
                                return;
                            }
                            int streamVolume = audioManager.getStreamVolume(3);
                            if (streamVolume != DeviceUtils.fw) {
                                com.byazt.rd.hn.pr().pr(streamVolume);
                            }
                            if (DeviceUtils.fw != -1) {
                                if (streamVolume != 0) {
                                    if (streamVolume - DeviceUtils.fw > 0) {
                                        i = 2;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    i = 0;
                                }
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (jCurrentTimeMillis - DeviceUtils.ho > 1000) {
                                    com.byazt.xk.hw.pr(i, -1);
                                }
                                long unused = DeviceUtils.ho = jCurrentTimeMillis;
                            }
                            int unused2 = DeviceUtils.fw = streamVolume;
                        } catch (Exception e2) {
                        }
                    }
                });
            }
        }
    }

    public static int uc() {
        if (x != -1 && !pr(c, 60000L)) {
            return x;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.byazt.sd.a.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        x = accessibilityManager.isEnabled() ? 1 : 0;
        c = System.currentTimeMillis();
        return x;
    }

    public static void fw() {
        if (com.byazt.sd.a.getContext() != null) {
            int iM = ls.m();
            com.byazt.mp.x.pr().pr("cpu_cnt", iM);
            ls.pr = iM;
            int iHn = ls.hn(ls.m());
            com.byazt.mp.x.pr().pr("cpu_max_freq", iHn);
            ls.hw = iHn;
            int iX = ls.x(ls.m());
            com.byazt.mp.x.pr().pr("cpu_min_freq", iX);
            ls.hn = iX;
            String strFw = ls.fw("MemTotal");
            if (strFw != null) {
                com.byazt.mp.x.pr().pr("total_memory", strFw);
                ls.x = strFw;
            }
            long jLb = ls.lb();
            com.byazt.mp.x.pr().pr("internal_storage", jLb);
            ls.c = jLb;
            long jPr = com.byazt.ca.nt.pr();
            com.byazt.mp.x.pr().pr("free_storage", jPr);
            ls.uc = jPr;
            long jCz = ls.cz();
            com.byazt.mp.x.pr().pr("sdcard_storage", jCz);
            ls.fw = jCz;
            boolean zFo = ls.fo();
            com.byazt.mp.x.pr().pr("is_root", zFo ? 1 : 0);
            ls.zo = zFo ? 1 : 0;
        }
    }

    public static void hw(Context context) {
        if (!zo) {
            try {
                vk = new DeviceStatusBroadCastReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                context.getApplicationContext().registerReceiver(vk, intentFilter);
                zo = true;
            } catch (Throwable th) {
            }
        }
        if (!aj) {
            com.byazt.en.pr prVar = new com.byazt.en.pr(com.byazt.sd.a.getContext(), com.byazt.ca.aj.hw(), new com.byazt.en.pr.InterfaceC0054pr() { // from class: com.byazt.wt.DeviceUtils.1
                @Override // com.byazt.en.pr.InterfaceC0054pr
                public void pr(int i) {
                    boolean zPr = DeviceUtils.pr(com.byazt.sd.a.getContext());
                    if (DeviceUtils.hw == -1) {
                        DeviceUtils.hw = i;
                        return;
                    }
                    int i2 = DeviceUtils.hw - i;
                    DeviceUtils.hw = i;
                    int i3 = 2;
                    if (zPr) {
                        if (Math.abs(i2) > 20) {
                            if (i2 > 0) {
                                i3 = 1;
                            }
                            com.byazt.rd.hn.pr().pr(true);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (jCurrentTimeMillis - DeviceUtils.g > 1000) {
                                com.byazt.xk.hw.pr(-1, i3);
                            }
                            long unused = DeviceUtils.g = jCurrentTimeMillis;
                            return;
                        }
                        return;
                    }
                    if (DeviceUtils.hw != -1) {
                        if (i2 > 0) {
                            i3 = 1;
                        }
                        com.byazt.xk.hw.pr(-1, i3);
                    }
                    com.byazt.rd.hn.pr().pr(true);
                }
            });
            w = prVar;
            prVar.pr();
            aj = true;
        }
    }

    public static String pr(int i) {
        return ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).pr(i);
    }

    public static boolean pr(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static int zo() {
        return (int) (com.byazt.sd.a.getContext().getResources().getConfiguration().fontScale * 16.0f);
    }

    public static JSONObject pr(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ACTD.APPID_KEY, com.byazt.sd.zo.nt().ny());
            jSONObject.put(Common.System.NAME, com.byazt.sd.zo.nt().fo());
            hw(jSONObject);
            com.byazt.igw.hw.hw(jSONObject);
            jSONObject.put("is_paid_app", com.byazt.sd.zo.nt().rc());
            if (!com.byazt.mp.x.pr().fw(i)) {
                jSONObject.put("network_speed", com.byazt.pk.hw.pr());
            }
            jSONObject.put("apk_sign", com.byazt.hb.pr.w());
            jSONObject.put("useful_open_sdk", com.byazt.md.x.hn().hw());
            jSONObject.put("real_app_name", com.byazt.hb.pr.vk());
            jSONObject.put("app_cold_startup_time", com.byazt.mk.hn.fw().c());
            jSONObject.put("sdk_init_timestamp", com.byazt.mk.hn.fw().uc());
            if (z) {
                jSONObject.put("session_ad_index", pr.addAndGet(1L));
                if (com.byazt.sd.a.hw().tt()) {
                    long jHn = com.byazt.mk.pr.hn();
                    jSONObject.put("app_total_7_duration", com.byazt.mk.pr.x() + jHn);
                    jSONObject.put("app_use_7_duration", jHn);
                    jSONObject.put("start_session", com.byazt.mk.pr.c());
                }
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private static void hw(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", ls.zo());
            jSONObject.put("version_code", ls.aj());
            jSONObject.put("version", ls.vk());
        } catch (Exception e) {
        }
    }

    public static void pr(long j) {
        if (j == -1 || uc == j) {
            return;
        }
        uc = j;
        com.byazt.mp.x.pr().pr("dev19", j);
    }

    public static long aj() {
        if (uc != -1) {
            return uc;
        }
        return com.byazt.mp.x.pr().hw("dev19", -1L);
    }

    public static int vk() {
        if (fw >= 0) {
            return fw;
        }
        try {
            AudioManager audioManager = (AudioManager) com.byazt.sd.a.getContext().getSystemService(MediaFormat.KEY_AUDIO);
            if (audioManager == null) {
                return 0;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            com.byazt.rd.hn.pr().hw(streamVolume);
            fw = streamVolume;
            return fw;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void w() {
        try {
            if (zo && vk != null) {
                com.byazt.sd.a.getContext().getApplicationContext().unregisterReceiver(vk);
            }
        } catch (Throwable th) {
        }
    }

    public static void k() {
        if (aj && w != null) {
            w.hw();
        }
    }
}
