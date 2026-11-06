package com.byazt.fp;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.byazt.vkw.nt;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 20})
public class hn {
    public static volatile boolean a;
    public static volatile String aj;
    public static volatile String b;
    public static volatile boolean cz;
    public static volatile boolean fo;
    public static volatile String g;
    public static volatile TelephonyManager gz;
    public static volatile String hn;
    public static volatile String hw;
    public static volatile long iu;
    public static volatile String k;
    public static volatile boolean lb;
    public static volatile String m;
    public static volatile WifiManager nl;
    public static volatile boolean nt;
    public static volatile boolean ny;
    public static volatile boolean qa;
    public static volatile boolean rc;
    public static volatile String uc;
    public static volatile boolean ve;
    public static volatile String vk;
    public static volatile String w;
    public static volatile String x;
    public static volatile WifiInfo y;
    public static volatile boolean yb;
    public static volatile boolean z;
    public static String pr = null;
    public static AtomicBoolean c = new AtomicBoolean(false);
    public static volatile String fw = "";
    public static volatile boolean zo = true;
    public static volatile String ho = null;

    public static TelephonyManager pr(Context context) {
        if (gz != null) {
            return gz;
        }
        synchronized (hn.class) {
            if (gz != null) {
                return gz;
            }
            gz = (TelephonyManager) context.getSystemService("phone");
            return gz;
        }
    }

    private static WifiManager x(Context context) {
        if (nl != null) {
            return nl;
        }
        synchronized (hn.class) {
            if (nl != null) {
                return nl;
            }
            nl = (WifiManager) context.getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
            return nl;
        }
    }

    public static WifiInfo pr(com.byazt.vkw.pr prVar, Context context) {
        com.byazt.vlp.hw hwVarW = prVar.w();
        if (hwVarW != null && (!hwVarW.uc() || !hwVarW.pr())) {
            return y;
        }
        if (y != null) {
            return y;
        }
        synchronized (hn.class) {
            if (y != null) {
                return y;
            }
            WifiManager wifiManagerX = x(context);
            if (wifiManagerX == null) {
                return y;
            }
            y = wifiManagerX.getConnectionInfo();
            return y;
        }
    }

    public static String pr(Boolean bool, com.byazt.vkw.pr prVar, Context context) {
        if (!TextUtils.isEmpty(hw)) {
            return hw;
        }
        com.byazt.vlp.hw hwVarW = prVar.w();
        if (bool == null) {
            boolean z2 = false;
            if (hwVarW != null && hwVarW.pr(0)) {
                z2 = true;
            }
            return pr(hwVarW, z2, context);
        }
        if (nt) {
            return hw;
        }
        return pr(hwVarW, bool.booleanValue(), context);
    }

    private static String pr(com.byazt.vlp.hw hwVar, boolean z2, Context context) {
        if (hwVar != null && !z2) {
            String strC = hwVar.c();
            hw = strC;
            return strC;
        }
        if (nt) {
            return hw;
        }
        c(context);
        return hw;
    }

    private static void c(Context context) {
        synchronized (hn.class) {
            if (nt) {
                return;
            }
            if (yb) {
                return;
            }
            if (x.pr(context, "android.permission.READ_PHONE_STATE") == 0) {
                yb = true;
                TelephonyManager telephonyManagerPr = pr(context);
                if (telephonyManagerPr == null) {
                    return;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        hw = telephonyManagerPr.getImei();
                    } else {
                        hw = telephonyManagerPr.getDeviceId();
                    }
                } catch (Throwable th) {
                }
                nt = true;
            }
        }
    }

    public static String hw(Boolean bool, com.byazt.vkw.pr prVar, Context context) {
        if (!TextUtils.isEmpty(uc)) {
            return uc;
        }
        if (bool == null) {
            com.byazt.vlp.hw hwVarW = prVar.w();
            if (hwVarW != null && !hwVarW.pr(1)) {
                return null;
            }
        } else {
            if (a || yb) {
                return uc;
            }
            if (!bool.booleanValue()) {
                return null;
            }
        }
        return uc(context);
    }

    private static String uc(Context context) {
        if (a) {
            return uc;
        }
        synchronized (hn.class) {
            if (a) {
                return uc;
            }
            if (yb) {
                return hw;
            }
            TelephonyManager telephonyManagerPr = pr(context);
            if (telephonyManagerPr == null) {
                return uc;
            }
            try {
                uc = telephonyManagerPr.getSubscriberId();
            } catch (Throwable th) {
            }
            a = true;
            return uc;
        }
    }

    public static String hn(Boolean bool, com.byazt.vkw.pr prVar, Context context) {
        if (!TextUtils.isEmpty(hn)) {
            return hn;
        }
        if (bool == null) {
            com.byazt.vlp.hw hwVarW = prVar.w();
            if (hwVarW != null && (!hwVarW.uc() || !hwVarW.pr())) {
                return null;
            }
        } else {
            if (lb) {
                return hn;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return vk(prVar, context);
    }

    private static String vk(com.byazt.vkw.pr prVar, Context context) {
        if (lb) {
            return hn;
        }
        synchronized (hn.class) {
            if (lb) {
                return hn;
            }
            try {
                WifiInfo wifiInfoPr = pr(prVar, context);
                if (wifiInfoPr == null) {
                    return hn;
                }
                hn = wifiInfoPr.getSSID();
                lb = true;
                return hn;
            } catch (Throwable th) {
            }
        }
    }

    public static String x(Boolean bool, com.byazt.vkw.pr prVar, Context context) {
        if (!TextUtils.isEmpty(x)) {
            return x;
        }
        if (bool == null) {
            com.byazt.vlp.hw hwVarW = prVar.w();
            if (hwVarW != null && (!hwVarW.uc() || !hwVarW.pr())) {
                return null;
            }
        } else {
            if (qa) {
                return x;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return w(prVar, context);
    }

    public static String hw(final com.byazt.vkw.pr prVar, final Context context) {
        if (!TextUtils.isEmpty(x) || qa) {
            return x;
        }
        if (!c.get()) {
            c.set(true);
            ((qi) com.byazt.zs.uc.pr("thread_service")).hw().execute(new com.byazt.xlm.fw("") { // from class: com.byazt.fp.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    hn.x(null, prVar, context);
                    hn.c.set(false);
                }
            });
            return null;
        }
        return null;
    }

    private static String w(com.byazt.vkw.pr prVar, Context context) {
        if (qa) {
            return x;
        }
        synchronized (hn.class) {
            if (qa) {
                return x;
            }
            x = hn(prVar, context);
            qa = true;
            return x;
        }
    }

    public static String pr(com.byazt.vkw.pr prVar) {
        com.byazt.vlp.hw hwVarW = prVar.w();
        if (hwVarW != null && !hwVarW.pr(3)) {
            return null;
        }
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (rc) {
            return g;
        }
        synchronized (hn.class) {
            if (rc) {
                return g;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    g = Build.getSerial();
                } catch (Throwable th) {
                }
            } else {
                g = Build.SERIAL;
            }
            rc = true;
            return g;
        }
    }

    public static String hn(com.byazt.vkw.pr prVar, Context context) {
        try {
            WifiInfo wifiInfoPr = pr(prVar, context);
            if (wifiInfoPr == null) {
                return "02:00:00:00:00:00";
            }
            String bssid = wifiInfoPr.getBSSID();
            if (TextUtils.isEmpty(bssid)) {
                return "02:00:00:00:00:00";
            }
            return bssid;
        } catch (Throwable th) {
            return "02:00:00:00:00:00";
        }
    }

    public static String x(com.byazt.vkw.pr prVar, Context context) {
        com.byazt.vlp.hw hwVarW = prVar.w();
        if (hwVarW != null && !hwVarW.x()) {
            return "";
        }
        if (!TextUtils.isEmpty(fw)) {
            return fw;
        }
        if (cz) {
            return fw;
        }
        synchronized (hn.class) {
            if (cz) {
                return fw;
            }
            TelephonyManager telephonyManagerPr = pr(context);
            if (telephonyManagerPr == null) {
                return fw;
            }
            try {
                fw = telephonyManagerPr.getSimOperator();
            } catch (Throwable th) {
            }
            cz = true;
            return fw;
        }
    }

    public static boolean hw(Context context) {
        if (ny) {
            return zo;
        }
        synchronized (hn.class) {
            if (ny) {
                return zo;
            }
            try {
                int simState = pr(context).getSimState();
                if (1 == simState) {
                    zo = false;
                }
                if (simState == 0) {
                    zo = false;
                }
                ny = true;
            } catch (Throwable th) {
            }
            return zo;
        }
    }

    public static String c(com.byazt.vkw.pr prVar, Context context) {
        try {
            k(prVar, context);
            if (!TextUtils.isEmpty(aj)) {
                return aj;
            }
            if (!pr(iu, 60000L)) {
                return b;
            }
            if (!hw(context)) {
                return null;
            }
            int i = context.getResources().getConfiguration().mcc;
            String strValueOf = i != 0 ? String.valueOf(i) : aj;
            b = strValueOf;
            iu = System.currentTimeMillis();
            return strValueOf;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String uc(com.byazt.vkw.pr prVar, Context context) {
        k(prVar, context);
        return vk;
    }

    public static String fw(com.byazt.vkw.pr prVar, Context context) {
        k(prVar, context);
        return w;
    }

    public static String zo(com.byazt.vkw.pr prVar, Context context) {
        k(prVar, context);
        return k;
    }

    public static String aj(com.byazt.vkw.pr prVar, Context context) {
        k(prVar, context);
        return m;
    }

    private static void k(com.byazt.vkw.pr prVar, Context context) {
        String strX;
        String simOperatorName;
        String strSubstring;
        if (fo) {
            return;
        }
        synchronized (hn.class) {
            if (fo) {
                return;
            }
            TelephonyManager telephonyManagerPr = pr(context);
            String strSubstring2 = null;
            try {
                strX = telephonyManagerPr.getNetworkOperator();
            } catch (Throwable th) {
                strX = null;
            }
            if (TextUtils.isEmpty(strX) || strX.length() < 5) {
                strX = x(prVar, context);
            }
            try {
                simOperatorName = telephonyManagerPr.getSimOperatorName();
            } catch (Throwable th2) {
                simOperatorName = null;
            }
            if (!TextUtils.isEmpty(strX) && strX.length() > 4) {
                strSubstring2 = strX.substring(0, 3);
                strSubstring = strX.substring(3);
            } else {
                strSubstring = null;
            }
            if (!TextUtils.isEmpty(strSubstring2)) {
                aj = strSubstring2;
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                w = strSubstring;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                m = simOperatorName;
            }
            try {
                fw(context);
            } catch (Throwable th3) {
            }
            fo = true;
        }
    }

    private static synchronized void fw(Context context) {
        String strValueOf;
        String strValueOf2;
        if (ve) {
            return;
        }
        if (Build.VERSION.SDK_INT < 22) {
            return;
        }
        synchronized (hn.class) {
            ve = true;
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            if (subscriptionManager.getActiveSubscriptionInfoCount() < 2) {
                return;
            }
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList.size() < 2) {
                return;
            }
            for (int i = 0; i < 2; i++) {
                SubscriptionInfo subscriptionInfo = activeSubscriptionInfoList.get(i);
                if (Build.VERSION.SDK_INT >= 29) {
                    strValueOf = subscriptionInfo.getMccString();
                    strValueOf2 = subscriptionInfo.getMncString();
                } else {
                    strValueOf = String.valueOf(subscriptionInfo.getMcc());
                    strValueOf2 = String.valueOf(subscriptionInfo.getMnc());
                }
                if (i == 0) {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        aj = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        w = strValueOf2;
                    }
                } else {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        vk = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        k = strValueOf2;
                    }
                }
            }
        }
    }

    public static synchronized String hn(Context context) {
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), Common.Predefined.SUB_ANDROID_ID);
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(string) || string.length() < 13) {
            string = "";
        }
        return string;
    }

    private static void pr(com.byazt.vkw.pr prVar, boolean z2, com.byazt.vlp.x xVar) {
        String strPr = hw.pr(prVar, z2, xVar);
        if (TextUtils.isEmpty(strPr)) {
            strPr = "DU:MM:YA:DD:RE:SS";
        }
        zo.hn("mac_address", strPr, prVar);
        zo.hn("new_mac_address", ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(strPr), prVar);
        ho = strPr;
    }

    public static String pr(Boolean bool, com.byazt.vkw.pr prVar, boolean z2, com.byazt.vlp.x xVar) {
        if (!TextUtils.isEmpty(ho)) {
            return ho;
        }
        com.byazt.vlp.hw hwVarW = prVar.w();
        if (bool == null) {
            if (hwVarW != null && !hwVarW.pr(2)) {
                return hwVarW.fw();
            }
        } else {
            if (z) {
                return ho;
            }
            if (hwVarW != null && !bool.booleanValue()) {
                return hwVarW.fw();
            }
        }
        return hw(prVar, z2, xVar);
    }

    private static String hw(com.byazt.vkw.pr prVar, boolean z2, com.byazt.vlp.x xVar) {
        if (z) {
            return ho;
        }
        synchronized (hn.class) {
            if (z) {
                return ho;
            }
            ho = hn(prVar, z2, xVar);
            z = true;
            return ho;
        }
    }

    private static String hn(com.byazt.vkw.pr prVar, boolean z2, com.byazt.vlp.x xVar) {
        try {
            String strHw = zo.hw("new_mac_address", "", prVar);
            if (!TextUtils.isEmpty(strHw)) {
                JSONObject jSONObject = new JSONObject(strHw);
                long j = jSONObject.getLong("time");
                String strX = ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(jSONObject.getString(Constants.VALUE_FIELD));
                if (System.currentTimeMillis() - j <= 864000000 && !TextUtils.isEmpty(strX)) {
                    return strX;
                }
            }
        } catch (Exception e) {
        }
        pr(prVar, z2, xVar);
        return ho;
    }

    private static boolean pr(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static String pr(Context context, com.byazt.vkw.pr prVar) {
        TelephonyManager telephonyManagerPr;
        try {
            com.byazt.vlp.hw hwVarW = prVar.w();
            if ((hwVarW == null || hwVarW.x()) && (telephonyManagerPr = pr(context)) != null && Build.VERSION.SDK_INT >= 22) {
                return telephonyManagerPr.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSimOperator();
            }
        } catch (Exception e) {
        }
        return null;
    }
}
