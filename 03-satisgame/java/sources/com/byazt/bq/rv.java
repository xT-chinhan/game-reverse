package com.byazt.bq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static volatile long n = 0;
    public static volatile int qg = -1;
    public static volatile int s = 60000;
    public static final AtomicBoolean q = new AtomicBoolean(false);
    public static final Map<Long, com.byazt.hsi.s> l = new ConcurrentHashMap();
    public static AtomicBoolean w = new AtomicBoolean(false);
    public static com.byazt.hsi.w x = null;

    public static void n(com.byazt.hsi.w wVar) {
        x = wVar;
    }

    public static void n(com.byazt.hsi.s sVar, Context context) {
        if (sVar == null) {
            return;
        }
        if (!w.get()) {
            try {
                context.registerReceiver(new n(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                w.set(true);
            } catch (Throwable unused) {
            }
        }
        Long lQg = qg(sVar);
        if (lQg == null) {
            return;
        }
        l.put(lQg, sVar);
    }

    public static void n(com.byazt.hsi.s sVar) {
        Long lQg;
        if (sVar == null || (lQg = qg(sVar)) == null) {
            return;
        }
        l.remove(lQg);
    }

    private static Long qg(com.byazt.hsi.s sVar) {
        try {
            return Long.valueOf(sVar.n());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int n(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (n + j <= jElapsedRealtime) {
            return qg(context);
        }
        if (qg == -1) {
            return qg(context);
        }
        if (jElapsedRealtime - n >= s) {
            qg(context, (Intent) null, false, false);
        }
        return qg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int qg(Context context) {
        qg = s(context);
        n = SystemClock.elapsedRealtime();
        return qg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            qg = 0;
        } else if (q.compareAndSet(false, true)) {
            ((wo) com.byazt.qp.q.n("thread_service")).n(new Runnable() { // from class: com.byazt.bq.rv.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = rv.qg = z2 ? 0 : rv.qg(context);
                    if (z) {
                        rv.qg(context, intent, rv.qg, z2);
                    }
                    rv.q.set(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Context context, Intent intent, int i, boolean z) {
        Map<Long, com.byazt.hsi.s> map = l;
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<Long, com.byazt.hsi.s> entry : map.entrySet()) {
            com.byazt.hsi.s value = entry.getValue();
            if (value != null) {
                value.n(context, intent, !z, i);
            } else {
                l.remove(entry.getKey());
            }
        }
    }

    private static int s(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        com.byazt.hsi.w wVar = x;
                        return (wVar == null || !wVar.n(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 290, 160})
    private static class n extends BroadcastReceiver {
        private n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            rv.qg(context, intent, !rv.l.isEmpty(), intent.getBooleanExtra("noConnectivity", false));
        }
    }
}
