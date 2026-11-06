package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    private static volatile String ab = null;
    private static volatile String ah = null;
    private static volatile String ao = null;
    private static volatile WifiInfo az = null;
    private static volatile boolean b = false;
    private static volatile String c = null;
    private static volatile boolean cv = false;
    private static volatile String d = null;
    private static volatile TelephonyManager f = null;
    private static volatile boolean g = false;
    private static volatile String h = null;
    private static volatile boolean i = false;
    private static volatile boolean jw = false;
    private static volatile String ka = null;
    private static volatile boolean le = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f3309ms = null;
    private static volatile boolean nw = false;
    private static volatile String ny = null;
    private static volatile boolean of = false;
    private static volatile boolean op = false;
    private static volatile String p = null;
    private static volatile long pc = 0;
    private static volatile String qv = null;
    private static volatile boolean re = false;
    private static volatile String u = null;
    private static volatile String ub = null;
    private static volatile WifiManager ul = null;
    private static volatile boolean w = false;
    private static volatile String xr = "";
    private static volatile String y;
    private static volatile boolean yu;
    private static volatile String zb;
    private static AtomicBoolean x = new AtomicBoolean(false);
    private static volatile String ch = "";
    private static volatile String hi = "";
    private static volatile boolean sl = true;
    private static volatile String t = null;

    public static TelephonyManager ms() {
        if (f != null) {
            return f;
        }
        synchronized (t.class) {
            if (f != null) {
                return f;
            }
            f = (TelephonyManager) re.getContext().getSystemService("phone");
            return f;
        }
    }

    private static WifiManager w() {
        if (ul != null) {
            return ul;
        }
        synchronized (t.class) {
            if (ul != null) {
                return ul;
            }
            ul = (WifiManager) re.getContext().getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
            return ul;
        }
    }

    public static WifiInfo xr() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo != null && (!kaVarAo.d() || !kaVarAo.ms())) {
            return az;
        }
        if (az != null) {
            return az;
        }
        synchronized (t.class) {
            if (az != null) {
                return az;
            }
            WifiManager wifiManagerW = w();
            if (wifiManagerW == null) {
                return az;
            }
            az = wifiManagerW.getConnectionInfo();
            return az;
        }
    }

    public static void ms(String str) {
        if (com.bytedance.sdk.openadsdk.ms.ms.ms.ms() != null) {
            com.bytedance.sdk.openadsdk.ms.ms.ms.ms().ms(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(ah)) {
            return;
        }
        xr.ms().ms("did", str);
        ah = str;
    }

    public static String ah() {
        if (!TextUtils.isEmpty(ah)) {
            return ah;
        }
        String strXr = xr.ms().xr("did", f3309ms);
        ah = strXr;
        return strXr;
    }

    public static String d() {
        if (!TextUtils.isEmpty(qv)) {
            return qv;
        }
        String strValueOf = String.valueOf(Build.TIME);
        qv = strValueOf;
        return strValueOf;
    }

    public static boolean ka() {
        return nw;
    }

    public static String c() {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo != null && g.xr >= 4600 && !kaVarAo.c()) {
            if (g.xr >= 4900) {
                return kaVarAo.sl();
            }
            return null;
        }
        if (nw) {
            return d;
        }
        synchronized (t.class) {
            if (nw) {
                return d;
            }
            d = of();
            com.bytedance.sdk.openadsdk.tools.xr.xr(9, d);
            return d;
        }
    }

    public static String ab() {
        if (!TextUtils.isEmpty(ka)) {
            return ka;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        return ms(kaVarAo, kaVarAo != null && kaVarAo.ah());
    }

    public static String ms(com.bytedance.sdk.openadsdk.core.i.ms msVar) {
        if (!TextUtils.isEmpty(ka) || b) {
            return ka;
        }
        return ms(ch.ub().ao(), msVar.ms());
    }

    private static String ms(com.bytedance.sdk.openadsdk.core.f.ka kaVar, boolean z) {
        if (kaVar != null && !z) {
            String strNy = kaVar.ny();
            ka = strNy;
            com.bytedance.sdk.openadsdk.tools.xr.xr(6, strNy);
            return strNy;
        }
        if (b) {
            return ka;
        }
        synchronized (t.class) {
            if (b) {
                return ka;
            }
            if (re) {
                return ka;
            }
            if (com.bytedance.sdk.openadsdk.core.i.xr.ms(re.getContext(), "android.permission.READ_PHONE_STATE") == 0) {
                re = true;
                TelephonyManager telephonyManagerMs = ms();
                if (telephonyManagerMs == null) {
                    return ka;
                }
                try {
                    ka = telephonyManagerMs.getImei();
                } catch (Throwable unused) {
                }
                b = true;
                com.bytedance.sdk.openadsdk.tools.xr.xr(6, ka);
                return ka;
            }
            return ka;
        }
    }

    public static String x() {
        if (!TextUtils.isEmpty(ny)) {
            return ny;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo == null || kaVarAo.ah()) {
            return yu();
        }
        return null;
    }

    public static String xr(com.bytedance.sdk.openadsdk.core.i.ms msVar) {
        if (!TextUtils.isEmpty(ny) || yu || re) {
            return ny;
        }
        if (msVar.ms()) {
            return yu();
        }
        return null;
    }

    private static String yu() {
        if (yu) {
            return ny;
        }
        synchronized (t.class) {
            if (yu) {
                return ny;
            }
            if (re) {
                return ka;
            }
            TelephonyManager telephonyManagerMs = ms();
            if (telephonyManagerMs == null) {
                return ny;
            }
            try {
                ny = telephonyManagerMs.getSubscriberId();
            } catch (Throwable unused) {
            }
            yu = true;
            return ny;
        }
    }

    public static String ny() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo == null || (kaVarAo.d() && kaVarAo.ms())) {
            return op();
        }
        return null;
    }

    public static String ah(com.bytedance.sdk.openadsdk.core.i.ms msVar) {
        if (!TextUtils.isEmpty(c) || i) {
            return c;
        }
        if (msVar.xr() && msVar.ah()) {
            return op();
        }
        return null;
    }

    private static String op() {
        if (i) {
            return c;
        }
        synchronized (t.class) {
            if (i) {
                return c;
            }
            try {
                WifiInfo wifiInfoXr = xr();
                if (wifiInfoXr == null) {
                    return c;
                }
                c = wifiInfoXr.getSSID();
                i = true;
                return c;
            } catch (Throwable unused) {
            }
        }
    }

    public static String ch() {
        if (!TextUtils.isEmpty(ab)) {
            return ab;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo == null || (kaVarAo.d() && kaVarAo.ms())) {
            return le();
        }
        return null;
    }

    public static String d(com.bytedance.sdk.openadsdk.core.i.ms msVar) {
        if (!TextUtils.isEmpty(ab) || w) {
            return ab;
        }
        if (msVar.xr() && msVar.ah()) {
            return le();
        }
        return null;
    }

    public static String hi() {
        if (!TextUtils.isEmpty(ab) || w) {
            return ab;
        }
        if (x.get()) {
            return null;
        }
        x.set(true);
        com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("") { // from class: com.bytedance.sdk.openadsdk.core.t.1
            @Override // java.lang.Runnable
            public void run() {
                t.ch();
                t.x.set(false);
            }
        });
        return null;
    }

    private static String le() {
        if (w) {
            return ab;
        }
        synchronized (t.class) {
            if (w) {
                return ab;
            }
            ab = zb();
            w = true;
            return ab;
        }
    }

    public static String sl() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo != null && !kaVarAo.ah()) {
            return null;
        }
        if (!TextUtils.isEmpty(y)) {
            return y;
        }
        if (g) {
            return y;
        }
        synchronized (t.class) {
            if (g) {
                return y;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    y = Build.getSerial();
                } catch (Throwable unused) {
                }
            } else {
                y = Build.SERIAL;
            }
            g = true;
            return y;
        }
    }

    public static String zb() {
        try {
            WifiInfo wifiInfoXr = xr();
            if (wifiInfoXr == null) {
                return "02:00:00:00:00:00";
            }
            String bssid = wifiInfoXr.getBSSID();
            return TextUtils.isEmpty(bssid) ? "02:00:00:00:00:00" : bssid;
        } catch (Exception unused) {
            return "02:00:00:00:00:00";
        }
    }

    public static void u() {
        TelephonyManager telephonyManagerMs;
        if (re) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if ((kaVarAo == null || kaVarAo.ah()) && com.bytedance.sdk.openadsdk.core.i.xr.ms(re.getContext(), "android.permission.READ_PHONE_STATE") == 0 && (telephonyManagerMs = ms()) != null) {
            synchronized (t.class) {
                re = true;
                if (TextUtils.isEmpty(ka)) {
                    try {
                        ka = telephonyManagerMs.getImei();
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.tools.xr.xr(6, ka);
                }
                if (TextUtils.isEmpty(ny)) {
                    try {
                        ny = telephonyManagerMs.getSubscriberId();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public static String ub() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo != null && !kaVarAo.ah()) {
            return "";
        }
        if (!TextUtils.isEmpty(ch)) {
            return ch;
        }
        if (op) {
            return ch;
        }
        synchronized (t.class) {
            if (op) {
                return ch;
            }
            TelephonyManager telephonyManagerMs = ms();
            if (telephonyManagerMs == null) {
                return ch;
            }
            try {
                ch = telephonyManagerMs.getSimOperator();
            } catch (Throwable unused) {
            }
            op = true;
            return ch;
        }
    }

    public static boolean ao() {
        if (le) {
            return sl;
        }
        synchronized (t.class) {
            if (le) {
                return sl;
            }
            try {
                int simState = ms().getSimState();
                if (1 == simState) {
                    sl = false;
                }
                if (simState == 0) {
                    sl = false;
                }
                le = true;
            } catch (Throwable unused) {
            }
            return sl;
        }
    }

    public static String h() {
        try {
            cv();
            if (!TextUtils.isEmpty(zb)) {
                return zb;
            }
            if (!ms(pc, 60000L)) {
                return p;
            }
            if (!ao()) {
                return null;
            }
            int i2 = re.getContext().getResources().getConfiguration().mcc;
            String strValueOf = i2 != 0 ? String.valueOf(i2) : zb;
            p = strValueOf;
            pc = System.currentTimeMillis();
            return strValueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String qv() {
        cv();
        return u;
    }

    public static String y() {
        cv();
        return ub;
    }

    public static String t() {
        cv();
        return ao;
    }

    public static String nw() {
        cv();
        return h;
    }

    private static void cv() {
        String strUb;
        String simOperatorName;
        String strSubstring;
        if (cv) {
            return;
        }
        synchronized (t.class) {
            if (cv) {
                return;
            }
            TelephonyManager telephonyManagerMs = ms();
            String strSubstring2 = null;
            try {
                strUb = telephonyManagerMs.getNetworkOperator();
            } catch (Throwable unused) {
                strUb = null;
            }
            if (TextUtils.isEmpty(strUb) || strUb.length() < 5) {
                strUb = ub();
            }
            try {
                simOperatorName = telephonyManagerMs.getSimOperatorName();
            } catch (Throwable unused2) {
                simOperatorName = null;
            }
            if (TextUtils.isEmpty(strUb) || strUb.length() <= 4) {
                strSubstring = null;
            } else {
                strSubstring2 = strUb.substring(0, 3);
                strSubstring = strUb.substring(3);
            }
            if (!TextUtils.isEmpty(strSubstring2)) {
                zb = strSubstring2;
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                ub = strSubstring;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                h = simOperatorName;
            }
            g();
            cv = true;
        }
    }

    private static synchronized void g() {
        String strValueOf;
        String strValueOf2;
        if (jw) {
            return;
        }
        synchronized (t.class) {
            jw = true;
            SubscriptionManager subscriptionManager = (SubscriptionManager) re.getContext().getSystemService("telephony_subscription_service");
            if (subscriptionManager.getActiveSubscriptionInfoCount() < 2) {
                return;
            }
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList.size() < 2) {
                return;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                SubscriptionInfo subscriptionInfo = activeSubscriptionInfoList.get(i2);
                if (Build.VERSION.SDK_INT >= 29) {
                    strValueOf = subscriptionInfo.getMccString();
                    strValueOf2 = subscriptionInfo.getMncString();
                } else {
                    strValueOf = String.valueOf(subscriptionInfo.getMcc());
                    strValueOf2 = String.valueOf(subscriptionInfo.getMnc());
                }
                if (i2 == 0) {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        zb = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        ub = strValueOf2;
                    }
                } else {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        u = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        ao = strValueOf2;
                    }
                }
            }
        }
    }

    private static synchronized String of() {
        Context context = re.getContext();
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            nw = true;
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(string) || string.length() < 13) {
            string = "";
        }
        return string;
    }

    private static String p() {
        String strAh = com.bytedance.sdk.component.utils.ms.ah(com.bytedance.sdk.openadsdk.core.ah.d.ms().d("new_mac_address", 864000000L));
        if (!TextUtils.isEmpty(strAh)) {
            return strAh;
        }
        String strXr = xr("wlan0");
        if (TextUtils.isEmpty(strXr)) {
            strXr = xr("eth0");
        }
        if (TextUtils.isEmpty(strXr)) {
            strXr = "DU:MM:YA:DD:RE:SS";
        }
        com.bytedance.sdk.openadsdk.core.ah.d.ms().d("mac_address", strXr);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().d("new_mac_address", com.bytedance.sdk.component.utils.ms.xr(strXr));
        return strXr;
    }

    public static String b() {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo != null && !kaVarAo.d()) {
            return kaVarAo.ch();
        }
        return pc();
    }

    public static String ka(com.bytedance.sdk.openadsdk.core.i.ms msVar) {
        if (!TextUtils.isEmpty(t) || of) {
            return t;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
        if (kaVarAo != null && !msVar.xr()) {
            return kaVarAo.ch();
        }
        return pc();
    }

    private static String pc() {
        if (of) {
            return t;
        }
        synchronized (t.class) {
            if (of) {
                return t;
            }
            t = p();
            of = true;
            return t;
        }
    }

    private static String xr(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String re() {
        if (!TextUtils.isEmpty(xr)) {
            return xr;
        }
        String strMs = com.bytedance.sdk.component.utils.i.ms();
        xr = strMs;
        return strMs;
    }

    private static boolean ms(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }
}
