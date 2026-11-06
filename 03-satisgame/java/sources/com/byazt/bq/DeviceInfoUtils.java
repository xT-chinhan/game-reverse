package com.byazt.bq;

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
import com.byazt.ho.BaseConstants;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, 2515})
public class DeviceInfoUtils {
    public static volatile long cp = 0;
    public static volatile long d = 0;
    public static volatile ContentObserver fs = null;
    public static volatile long hd = 0;
    public static volatile boolean l = true;
    public static volatile int n = -1;
    public static volatile boolean q = false;
    public static volatile boolean qg = false;
    public static volatile String rv = null;
    public static volatile boolean s = false;
    public static volatile String tj;
    public static volatile BroadcastReceiver w;
    public static volatile BroadcastReceiver x;
    public static AtomicInteger oa = new AtomicInteger(-1);
    public static AtomicBoolean sz = new AtomicBoolean(false);
    public static volatile long k = System.currentTimeMillis();
    public static volatile float cy = -2.0f;
    public static long cd = 0;

    public static int n() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    @com.byazt.cp.n(n = {0, 1, 290, 1859})
    public static class n implements com.byazt.hsi.s {
        public com.byazt.tbi.s n;
        public final long qg = com.byazt.hsi.q.n();

        public n(com.byazt.tbi.s sVar) {
            this.n = sVar;
        }

        @Override // com.byazt.hsi.s
        public void n(Context context, Intent intent, boolean z, int i) {
            if (DeviceInfoUtils.oa.get() == i) {
                return;
            }
            com.byazt.gwg.n.mIsNeedUpdateIp.set(true);
            DeviceInfoUtils.oa.set(i);
            qg.n.set(true);
            DeviceInfoUtils.sz.set(true);
            ((com.byazt.vf.x) com.byazt.qp.q.n("armor_service")).n(i);
        }

        @Override // com.byazt.hsi.s
        public long n() {
            return this.qg;
        }
    }

    public static int n(Context context, boolean z, com.byazt.vf.n nVar) {
        if (n != -1) {
            return n;
        }
        if (z) {
            String strN = fs.n("dev06", 2592000000L, nVar);
            try {
                if (!TextUtils.isEmpty(strN)) {
                    n = Integer.parseInt(strN);
                }
            } catch (Exception unused) {
            }
            if (n != -1) {
                return n;
            }
        }
        if (qg(context)) {
            n = 3;
        } else if (n(context)) {
            n = 2;
        } else {
            n = 1;
        }
        if (z) {
            fs.s("dev06", String.valueOf(n), nVar);
        }
        return n;
    }

    public static boolean n(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean qg(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void n(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (qg) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                l = powerManager.isScreenOn();
            }
        } catch (Throwable unused) {
        }
        try {
            w = broadcastReceiver;
            context.getApplicationContext().registerReceiver(w, intentFilter);
            qg = true;
        } catch (Throwable unused2) {
        }
    }

    public static void s(Context context) {
        try {
            if (qg && w != null) {
                context.getApplicationContext().unregisterReceiver(w);
            }
        } catch (Throwable unused) {
        }
    }

    public static void q(Context context) {
        try {
            if (s && x != null) {
                context.getApplicationContext().unregisterReceiver(x);
            }
        } catch (Throwable unused) {
        }
    }

    public static void l(Context context) {
        if (!q || fs == null || context == null) {
            return;
        }
        context.getContentResolver().unregisterContentObserver(fs);
    }

    public static boolean n(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    @com.byazt.cp.n(n = {0, 1, 290, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT})
    public static class ScreenStatusReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.bq.DeviceInfoUtils.ScreenStatusReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    ScreenStatusReceiver.this.n(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(final Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = DeviceInfoUtils.l = true;
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = DeviceInfoUtils.l = false;
                ((wo) com.byazt.qp.q.n("thread_service")).qg().execute(new com.byazt.qit.x("updateScreenStatus") { // from class: com.byazt.bq.DeviceInfoUtils.ScreenStatusReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((com.byazt.vf.x) com.byazt.qp.q.n("armor_service")).qg(intent.getAction());
                    }
                });
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                long unused3 = DeviceInfoUtils.k = System.currentTimeMillis();
            }
        }
    }

    public static long qg() {
        return k;
    }

    public static boolean w(Context context) {
        if (!l && SystemClock.elapsedRealtime() - cd >= 10000) {
            cd = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    l = powerManager.isInteractive();
                }
            } catch (Throwable unused) {
            }
        }
        return l;
    }

    public static float x(Context context) {
        if (cy != -2.0f && !n(hd, 30000L)) {
            return cy;
        }
        int i = -1;
        if (context != null) {
            try {
                i = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            } catch (Throwable th) {
                k.qg("DeviceInfoUtils", th.getMessage());
            }
        }
        if (i < 0) {
            cy = -1.0f;
        } else {
            cy = Math.round((i / 255.0f) * 10.0f) / 10.0f;
        }
        hd = System.currentTimeMillis();
        return cy;
    }

    public static String n(int i, com.byazt.vf.n nVar, Context context) {
        if (i == 0 && !TextUtils.isEmpty(rv) && !n(cp, 60000L)) {
            return rv;
        }
        if (i == 1 && !TextUtils.isEmpty(tj) && !n(d, 60000L)) {
            return tj;
        }
        String strQg = qg(i, nVar, context);
        if (i == 0) {
            rv = strQg;
            cp = System.currentTimeMillis();
        } else if (i == 1) {
            tj = strQg;
            d = System.currentTimeMillis();
        }
        return strQg;
    }

    private static String qg(int i, com.byazt.vf.n nVar, Context context) {
        TelephonyManager telephonyManagerN;
        List<CellInfo> allCellInfo;
        int dbm;
        WifiInfo wifiInfoN;
        int iS = hd.s(context);
        com.byazt.tbi.n nVarCp = nVar.cp();
        if (nVarCp == null) {
            return "unknown";
        }
        if (iS == 4) {
            if (i == 0) {
                try {
                    return (nVarCp.w() && (wifiInfoN = s.n(nVar, context)) != null) ? wifiInfoN.getRssi() + "dBm" : "unknown";
                } catch (Throwable unused) {
                }
            }
            return "unknown";
        }
        if (nVarCp.q() && nVarCp.n() && i == 1) {
            try {
                if (!s.qg(context) || (telephonyManagerN = s.n(context)) == null || (allCellInfo = telephonyManagerN.getAllCellInfo()) == null) {
                    return "unknown";
                }
                CellInfo cellInfo = allCellInfo.get(0);
                if (cellInfo instanceof CellInfoGsm) {
                    dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoCdma) {
                    dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoLte) {
                    dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoWcdma) {
                    dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                    dbm = ((CellInfoNr) cellInfo).getCellSignalStrength().getDbm();
                } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                    dbm = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getDbm();
                }
                return Integer.MIN_VALUE == dbm ? "unknown" : dbm + "dBm";
            } catch (Throwable unused2) {
            }
        }
        return "unknown";
    }
}
