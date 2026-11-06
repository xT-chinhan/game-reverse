package com.byazt.fp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.fi.BaseConstants;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 2313})
public class DeviceInfoUtils {
    public static volatile BroadcastReceiver fw;
    public static volatile long k;
    public static volatile BroadcastReceiver uc;
    public static volatile long w;
    public static volatile long yb;
    public static volatile ContentObserver zo;
    public static volatile int pr = -1;
    public static volatile boolean hw = false;
    public static volatile boolean hn = false;
    public static volatile boolean x = false;
    public static volatile boolean c = true;
    public static volatile String aj = null;
    public static volatile String vk = null;
    public static AtomicInteger m = new AtomicInteger(-1);
    public static AtomicBoolean g = new AtomicBoolean(false);
    public static volatile long ho = System.currentTimeMillis();
    public static volatile float nt = -2.0f;
    public static long lb = 0;

    public static int pr() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 1511})
    public static class pr implements com.byazt.apo.hn {
        public com.byazt.vlp.x pr;

        public pr(com.byazt.vlp.x xVar) {
            this.pr = xVar;
        }

        @Override // com.byazt.apo.hn
        public void pr(Context context, Intent intent, boolean z, int i) {
            if (DeviceInfoUtils.m.get() == i) {
                return;
            }
            com.byazt.fg.pr.mIsNeedUpdateIp.set(true);
            DeviceInfoUtils.m.set(i);
            hw.pr.set(true);
            DeviceInfoUtils.g.set(true);
            ((com.byazt.vkw.fw) com.byazt.zs.uc.pr("armor_service")).pr(i);
        }
    }

    public static int pr(Context context, boolean z, com.byazt.vkw.pr prVar) {
        if (pr != -1) {
            return pr;
        }
        if (z) {
            String strPr = zo.pr("dev06", 2592000000L, prVar);
            try {
                if (!TextUtils.isEmpty(strPr)) {
                    pr = Integer.parseInt(strPr);
                }
            } catch (Exception e) {
            }
            if (pr != -1) {
                return pr;
            }
        }
        if (hw(context)) {
            pr = 3;
        } else if (pr(context)) {
            pr = 2;
        } else {
            pr = 1;
        }
        if (z) {
            zo.hn("dev06", String.valueOf(pr), prVar);
        }
        return pr;
    }

    public static boolean pr(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean hw(Context context) {
        try {
            if ((context.getResources().getConfiguration().uiMode & 15) != 4) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void pr(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (!hw) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    c = powerManager.isScreenOn();
                }
            } catch (Throwable th) {
            }
            try {
                uc = broadcastReceiver;
                context.getApplicationContext().registerReceiver(uc, intentFilter);
                hw = true;
            } catch (Throwable th2) {
            }
        }
    }

    public static void hn(Context context) {
        try {
            if (hw && uc != null) {
                context.getApplicationContext().unregisterReceiver(uc);
            }
        } catch (Throwable th) {
        }
    }

    public static void x(Context context) {
        try {
            if (hn && fw != null) {
                context.getApplicationContext().unregisterReceiver(fw);
            }
        } catch (Throwable th) {
        }
    }

    public static void c(Context context) {
        if (x && zo != null) {
            context.getContentResolver().unregisterContentObserver(zo);
        }
    }

    public static boolean pr(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE})
    public static class ScreenStatusReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.fp.DeviceInfoUtils.ScreenStatusReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    ScreenStatusReceiver.this.pr(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(final Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = DeviceInfoUtils.c = true;
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = DeviceInfoUtils.c = false;
                ((qi) com.byazt.zs.uc.pr("thread_service")).hw().execute(new com.byazt.xlm.fw("updateScreenStatus") { // from class: com.byazt.fp.DeviceInfoUtils.ScreenStatusReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((com.byazt.vkw.fw) com.byazt.zs.uc.pr("armor_service")).hw(intent.getAction());
                    }
                });
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                long unused3 = DeviceInfoUtils.ho = System.currentTimeMillis();
            }
        }
    }

    public static long hw() {
        return ho;
    }

    public static boolean uc(Context context) {
        if (!c && SystemClock.elapsedRealtime() - lb >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            lb = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    c = powerManager.isInteractive();
                }
            } catch (Throwable th) {
            }
        }
        return c;
    }

    public static float fw(Context context) {
        if (nt != -2.0f && !pr(yb, 30000L)) {
            return nt;
        }
        int i = -1;
        if (context != null) {
            try {
                i = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            } catch (Throwable th) {
                ho.hw("DeviceInfoUtils", th.getMessage());
            }
        }
        if (i < 0) {
            nt = -1.0f;
        } else {
            nt = Math.round((i / 255.0f) * 10.0f) / 10.0f;
        }
        yb = System.currentTimeMillis();
        return nt;
    }

    public static String pr(int i, com.byazt.vkw.pr prVar, Context context) {
        if (i == 0 && !TextUtils.isEmpty(aj) && !pr(w, 60000L)) {
            return aj;
        }
        if (i == 1 && !TextUtils.isEmpty(vk) && !pr(k, 60000L)) {
            return vk;
        }
        String strHw = hw(i, prVar, context);
        if (i == 0) {
            aj = strHw;
            w = System.currentTimeMillis();
        } else if (i == 1) {
            vk = strHw;
            k = System.currentTimeMillis();
        }
        return strHw;
    }

    private static String hw(int i, com.byazt.vkw.pr prVar, Context context) {
        int dbm;
        List<CellInfo> allCellInfo;
        WifiInfo wifiInfoPr;
        int iHn = yb.hn(context);
        com.byazt.vlp.hw hwVarW = prVar.w();
        if (hwVarW == null) {
            return "unknown";
        }
        if (iHn == 4) {
            if (i == 0) {
                try {
                    if (!hwVarW.uc() || (wifiInfoPr = hn.pr(prVar, context)) == null) {
                        return "unknown";
                    }
                    return wifiInfoPr.getRssi() + "dBm";
                } catch (Throwable th) {
                    return "unknown";
                }
            }
            return "unknown";
        }
        if (hwVarW.x() && hwVarW.pr() && i == 1) {
            try {
                if (hn.hw(context)) {
                    TelephonyManager telephonyManagerPr = hn.pr(context);
                    if (Build.VERSION.SDK_INT < 17) {
                        dbm = Integer.MIN_VALUE;
                    } else {
                        if (telephonyManagerPr == null || (allCellInfo = telephonyManagerPr.getAllCellInfo()) == null) {
                            return "unknown";
                        }
                        CellInfo cellInfo = allCellInfo.get(0);
                        if (cellInfo instanceof CellInfoGsm) {
                            dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                        } else if (cellInfo instanceof CellInfoCdma) {
                            dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                        } else if (cellInfo instanceof CellInfoLte) {
                            dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                        } else if (Build.VERSION.SDK_INT >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                            dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                        } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                            dbm = ((CellInfoNr) cellInfo).getCellSignalStrength().getDbm();
                        } else {
                            if (Build.VERSION.SDK_INT < 29 || !(cellInfo instanceof CellInfoTdscdma)) {
                                return "unknown";
                            }
                            dbm = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getDbm();
                        }
                    }
                    if (Integer.MIN_VALUE == dbm) {
                        return "unknown";
                    }
                    return dbm + "dBm";
                }
            } catch (Throwable th2) {
                return "unknown";
            }
        }
        return "unknown";
    }
}
