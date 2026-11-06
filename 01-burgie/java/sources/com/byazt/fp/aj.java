package com.byazt.fp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 61})
public class aj {
    public static volatile long pr = 0;
    public static volatile int hw = -1;
    public static volatile int hn = BaseConstants.Time.MINUTE;
    public static final AtomicBoolean x = new AtomicBoolean(false);
    public static final Map<com.byazt.apo.hn, Object> c = new ConcurrentHashMap();
    public static AtomicBoolean uc = new AtomicBoolean(false);
    public static final Object fw = new Object();
    public static com.byazt.apo.c zo = null;

    public static void pr(com.byazt.apo.c cVar) {
        zo = cVar;
    }

    public static void pr(com.byazt.apo.hn hnVar, Context context) {
        if (hnVar == null) {
            return;
        }
        if (!uc.get()) {
            try {
                context.registerReceiver(new pr(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                uc.set(true);
            } catch (Throwable th) {
            }
        }
        c.put(hnVar, fw);
    }

    public static void pr(com.byazt.apo.hn hnVar) {
        if (hnVar == null) {
            return;
        }
        c.remove(hnVar);
    }

    public static int pr(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (pr + j <= jElapsedRealtime) {
            return hw(context);
        }
        if (hw == -1) {
            return hw(context);
        }
        if (jElapsedRealtime - pr >= hn) {
            hw(context, (Intent) null, false, false);
        }
        return hw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hw(Context context) {
        hw = hn(context);
        pr = SystemClock.elapsedRealtime();
        return hw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (z || !z2) {
            if (x.compareAndSet(false, true)) {
                ((qi) com.byazt.zs.uc.pr("thread_service")).pr(new Runnable() { // from class: com.byazt.fp.aj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int unused = aj.hw = z2 ? 0 : aj.hw(context);
                        if (z) {
                            aj.hw(context, intent, aj.hw, z2);
                        }
                        aj.x.set(false);
                    }
                });
                return;
            }
            return;
        }
        hw = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Context context, Intent intent, int i, boolean z) {
        Map<com.byazt.apo.hn, Object> map = c;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (com.byazt.apo.hn hnVar : map.keySet()) {
            if (hnVar != null) {
                hnVar.pr(context, intent, !z, i);
            }
        }
    }

    private static int hn(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
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
                                com.byazt.apo.c cVar = zo;
                                return (cVar == null || !cVar.pr(context, telephonyManager)) ? 5 : 6;
                            case 20:
                                return 6;
                            default:
                                String subtypeName = activeNetworkInfo.getSubtypeName();
                                return (TextUtils.isEmpty(subtypeName) || !("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName))) ? 1 : 3;
                        }
                    case 1:
                        return 4;
                    default:
                        return 1;
                }
            }
            return 0;
        } catch (Throwable th) {
            return 1;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    private static class pr extends BroadcastReceiver {
        private pr() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (aj.c != null && aj.c.size() > 0) {
                z = true;
            }
            aj.hw(context, intent, z, booleanExtra);
        }
    }
}
