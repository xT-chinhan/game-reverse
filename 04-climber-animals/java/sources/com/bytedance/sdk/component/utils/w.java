package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Object f1368ms = new Object();
    private static final Map<ms, Object> xr = new ConcurrentHashMap();
    private static AtomicBoolean ah = new AtomicBoolean(false);
    private static volatile int d = -1;
    private static volatile long ka = 0;
    private static volatile int c = 60000;
    private static ub ab = null;
    private static final AtomicBoolean x = new AtomicBoolean(false);

    public interface ms {
        void ms(Context context, Intent intent, boolean z, int i);
    }

    public static void ms(ub ubVar) {
        ab = ubVar;
    }

    public static int ms(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (ka + j <= jElapsedRealtime) {
            return xr(context);
        }
        if (d == -1) {
            return xr(context);
        }
        if (jElapsedRealtime - ka >= c) {
            xr(context, (Intent) null, false, false);
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            d = 0;
        } else if (x.compareAndSet(false, true)) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("getNetworkType") { // from class: com.bytedance.sdk.component.utils.w.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = w.d = z2 ? 0 : w.xr(context);
                    if (z) {
                        w.xr(context, intent, w.d, z2);
                    }
                    w.x.set(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(Context context, Intent intent, int i, boolean z) {
        Map<ms, Object> map = xr;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (ms msVar : map.keySet()) {
            if (msVar != null) {
                msVar.ms(context, intent, !z, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int xr(Context context) {
        d = ah(context);
        ka = SystemClock.elapsedRealtime();
        return d;
    }

    private static int ah(Context context) {
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
                        ub ubVar = ab;
                        return (ubVar == null || !ubVar.ms(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void ms(ms msVar, Context context) {
        if (msVar == null) {
            return;
        }
        if (!ah.get()) {
            try {
                context.registerReceiver(new xr(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                ah.set(true);
            } catch (Throwable unused) {
            }
        }
        xr.put(msVar, f1368ms);
    }

    public static void ms(ms msVar) {
        if (msVar == null) {
            return;
        }
        xr.remove(msVar);
    }

    private static class xr extends BroadcastReceiver {
        private xr() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (w.xr != null && w.xr.size() > 0) {
                z = true;
            }
            w.xr(context, intent, z, booleanExtra);
        }
    }
}
