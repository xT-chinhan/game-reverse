package com.byazt.bq;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.anythink.china.b.c;
import com.anythink.core.common.f.e;
import com.byazt.vf.k;
import com.byazt.vf.wo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, 8})
public class s {
    public static volatile boolean a;
    public static volatile TelephonyManager bb;
    public static volatile boolean cd;
    public static volatile String cp;
    public static volatile boolean cy;
    public static volatile String d;
    public static volatile String h;
    public static volatile boolean hd;
    public static volatile boolean hu;
    public static volatile WifiInfo lh;
    public static volatile WifiManager ln;
    public static volatile boolean m;
    public static String n;
    public static volatile String oa;
    public static volatile boolean ou;
    public static volatile boolean py;
    public static volatile String q;
    public static volatile String qg;
    public static volatile String rv;
    public static volatile String s;
    public static volatile String sz;
    public static volatile long t;
    public static volatile String tj;
    public static volatile boolean um;
    public static volatile boolean ur;
    public static volatile String w;
    public static volatile boolean wm;
    public static AtomicBoolean l = new AtomicBoolean(false);
    public static volatile String x = "";
    public static volatile boolean fs = true;
    public static volatile String k = null;

    public static TelephonyManager n(Context context) {
        if (bb != null) {
            return bb;
        }
        synchronized (s.class) {
            if (bb != null) {
                return bb;
            }
            bb = (TelephonyManager) context.getSystemService("phone");
            return bb;
        }
    }

    private static WifiManager q(Context context) {
        if (ln != null) {
            return ln;
        }
        synchronized (s.class) {
            if (ln != null) {
                return ln;
            }
            ln = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            return ln;
        }
    }

    public static WifiInfo n(com.byazt.vf.n nVar, Context context) {
        com.byazt.tbi.n nVarCp = nVar.cp();
        if (nVarCp != null && (!nVarCp.w() || !nVarCp.n())) {
            return lh;
        }
        if (lh != null) {
            return lh;
        }
        synchronized (s.class) {
            if (lh != null) {
                return lh;
            }
            WifiManager wifiManagerQ = q(context);
            if (wifiManagerQ == null) {
                return lh;
            }
            lh = wifiManagerQ.getConnectionInfo();
            return lh;
        }
    }

    public static String n(Boolean bool, com.byazt.vf.n nVar, Context context) {
        if (!TextUtils.isEmpty(qg)) {
            return qg;
        }
        com.byazt.tbi.n nVarCp = nVar.cp();
        if (bool == null) {
            boolean z = false;
            if (nVarCp != null && nVarCp.n(0)) {
                z = true;
            }
            return n(nVarCp, z, context);
        }
        if (cy) {
            return qg;
        }
        return n(nVarCp, bool.booleanValue(), context);
    }

    private static String n(com.byazt.tbi.n nVar, boolean z, Context context) {
        if (nVar != null && !z) {
            String strL = nVar.l();
            qg = strL;
            return strL;
        }
        if (cy) {
            return qg;
        }
        l(context);
        return qg;
    }

    private static void l(Context context) {
        synchronized (s.class) {
            if (cy) {
                return;
            }
            if (hd) {
                return;
            }
            if (q.n(context, c.a) == 0) {
                hd = true;
                TelephonyManager telephonyManagerN = n(context);
                if (telephonyManagerN == null) {
                    return;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        qg = telephonyManagerN.getImei();
                    } else {
                        qg = telephonyManagerN.getDeviceId();
                    }
                } catch (Throwable unused) {
                }
                cy = true;
            }
        }
    }

    public static String qg(Boolean bool, com.byazt.vf.n nVar, Context context) {
        if (!TextUtils.isEmpty(w)) {
            return w;
        }
        if (bool == null) {
            com.byazt.tbi.n nVarCp = nVar.cp();
            if (nVarCp != null && !nVarCp.n(1)) {
                return null;
            }
        } else {
            if (a || hd) {
                return w;
            }
            if (!bool.booleanValue()) {
                return null;
            }
        }
        return w(context);
    }

    private static String w(Context context) {
        if (a) {
            return w;
        }
        synchronized (s.class) {
            if (a) {
                return w;
            }
            if (hd) {
                return qg;
            }
            TelephonyManager telephonyManagerN = n(context);
            if (telephonyManagerN == null) {
                return w;
            }
            try {
                w = telephonyManagerN.getSubscriberId();
            } catch (Throwable unused) {
            }
            a = true;
            return w;
        }
    }

    public static String s(Boolean bool, com.byazt.vf.n nVar, Context context) {
        if (!TextUtils.isEmpty(s)) {
            return s;
        }
        if (bool == null) {
            com.byazt.tbi.n nVarCp = nVar.cp();
            if (nVarCp != null && (!nVarCp.w() || !nVarCp.n())) {
                return null;
            }
        } else {
            if (cd) {
                return s;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return tj(nVar, context);
    }

    private static String tj(com.byazt.vf.n nVar, Context context) {
        if (cd) {
            return s;
        }
        synchronized (s.class) {
            if (cd) {
                return s;
            }
            try {
                WifiInfo wifiInfoN = n(nVar, context);
                if (wifiInfoN == null) {
                    return s;
                }
                s = wifiInfoN.getSSID();
                cd = true;
                return s;
            } catch (Throwable unused) {
            }
        }
    }

    public static String q(Boolean bool, com.byazt.vf.n nVar, Context context) {
        if (!TextUtils.isEmpty(q)) {
            return q;
        }
        if (bool == null) {
            com.byazt.tbi.n nVarCp = nVar.cp();
            if (nVarCp != null && (!nVarCp.w() || !nVarCp.n())) {
                return null;
            }
        } else {
            if (um) {
                return q;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return cp(nVar, context);
    }

    public static String qg(final com.byazt.vf.n nVar, final Context context) {
        if (!TextUtils.isEmpty(q) || um) {
            return q;
        }
        if (l.get()) {
            return null;
        }
        l.set(true);
        ((wo) com.byazt.qp.q.n("thread_service")).qg().execute(new com.byazt.qit.x("") { // from class: com.byazt.bq.s.1
            @Override // java.lang.Runnable
            public void run() {
                s.q(null, nVar, context);
                s.l.set(false);
            }
        });
        return null;
    }

    private static String cp(com.byazt.vf.n nVar, Context context) {
        if (um) {
            return q;
        }
        synchronized (s.class) {
            if (um) {
                return q;
            }
            q = s(nVar, context);
            um = true;
            return q;
        }
    }

    public static String n(com.byazt.vf.n nVar) {
        com.byazt.tbi.n nVarCp = nVar.cp();
        if (nVarCp != null && !nVarCp.n(3)) {
            return null;
        }
        if (!TextUtils.isEmpty(sz)) {
            return sz;
        }
        if (m) {
            return sz;
        }
        synchronized (s.class) {
            if (m) {
                return sz;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    sz = Build.getSerial();
                } catch (Throwable unused) {
                }
            } else {
                sz = Build.SERIAL;
            }
            m = true;
            return sz;
        }
    }

    public static String s(com.byazt.vf.n nVar, Context context) {
        try {
            WifiInfo wifiInfoN = n(nVar, context);
            if (wifiInfoN == null) {
                return "02:00:00:00:00:00";
            }
            String bssid = wifiInfoN.getBSSID();
            return TextUtils.isEmpty(bssid) ? "02:00:00:00:00:00" : bssid;
        } catch (Throwable unused) {
            return "02:00:00:00:00:00";
        }
    }

    public static String q(com.byazt.vf.n nVar, Context context) {
        com.byazt.tbi.n nVarCp = nVar.cp();
        if (nVarCp != null && !nVarCp.q()) {
            return "";
        }
        if (!TextUtils.isEmpty(x)) {
            return x;
        }
        if (py) {
            return x;
        }
        synchronized (s.class) {
            if (py) {
                return x;
            }
            TelephonyManager telephonyManagerN = n(context);
            if (telephonyManagerN == null) {
                return x;
            }
            try {
                x = telephonyManagerN.getSimOperator();
            } catch (Throwable unused) {
            }
            py = true;
            return x;
        }
    }

    public static boolean qg(Context context) {
        if (ou) {
            return fs;
        }
        synchronized (s.class) {
            if (ou) {
                return fs;
            }
            try {
                int simState = n(context).getSimState();
                if (1 == simState) {
                    fs = false;
                }
                if (simState == 0) {
                    fs = false;
                }
                ou = true;
            } catch (Throwable unused) {
            }
            return fs;
        }
    }

    public static String l(com.byazt.vf.n nVar, Context context) {
        try {
            d(nVar, context);
            if (!TextUtils.isEmpty(rv)) {
                return rv;
            }
            if (!n(t, 60000L)) {
                return h;
            }
            if (!qg(context)) {
                return null;
            }
            int i = context.getResources().getConfiguration().mcc;
            String strValueOf = i != 0 ? String.valueOf(i) : rv;
            h = strValueOf;
            t = System.currentTimeMillis();
            return strValueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String w(com.byazt.vf.n nVar, Context context) {
        d(nVar, context);
        return tj;
    }

    public static String x(com.byazt.vf.n nVar, Context context) {
        d(nVar, context);
        return cp;
    }

    public static String fs(com.byazt.vf.n nVar, Context context) {
        d(nVar, context);
        return d;
    }

    public static String rv(com.byazt.vf.n nVar, Context context) {
        d(nVar, context);
        return oa;
    }

    private static void d(com.byazt.vf.n nVar, Context context) {
        String strQ;
        String simOperatorName;
        String strSubstring;
        if (wm) {
            return;
        }
        synchronized (s.class) {
            if (wm) {
                return;
            }
            TelephonyManager telephonyManagerN = n(context);
            String strSubstring2 = null;
            try {
                strQ = telephonyManagerN.getNetworkOperator();
            } catch (Throwable unused) {
                strQ = null;
            }
            if (TextUtils.isEmpty(strQ) || strQ.length() < 5) {
                strQ = q(nVar, context);
            }
            try {
                simOperatorName = telephonyManagerN.getSimOperatorName();
            } catch (Throwable unused2) {
                simOperatorName = null;
            }
            if (TextUtils.isEmpty(strQ) || strQ.length() <= 4) {
                strSubstring = null;
            } else {
                strSubstring2 = strQ.substring(0, 3);
                strSubstring = strQ.substring(3);
            }
            if (!TextUtils.isEmpty(strSubstring2)) {
                rv = strSubstring2;
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                cp = strSubstring;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                oa = simOperatorName;
            }
            try {
                x(context);
            } catch (Throwable unused3) {
            }
            wm = true;
        }
    }

    private static synchronized void x(Context context) {
        String strValueOf;
        String strValueOf2;
        if (ur) {
            return;
        }
        synchronized (s.class) {
            ur = true;
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
                        rv = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        cp = strValueOf2;
                    }
                } else {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        tj = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        d = strValueOf2;
                    }
                }
            }
        }
    }

    public static synchronized String s(Context context) {
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(string) || string.length() < 13) {
            string = "";
        }
        return string;
    }

    private static void n(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        String strN = qg.n(nVar, z, sVar);
        if (TextUtils.isEmpty(strN)) {
            strN = "DU:MM:YA:DD:RE:SS";
        }
        fs.s("mac_address", strN, nVar);
        fs.s("new_mac_address", ((k) com.byazt.qp.q.n("encrypt_service")).s(strN), nVar);
        k = strN;
    }

    public static String n(Boolean bool, com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        com.byazt.tbi.n nVarCp = nVar.cp();
        if (bool == null) {
            if (nVarCp != null && !nVarCp.n(2)) {
                return nVarCp.x();
            }
        } else {
            if (hu) {
                return k;
            }
            if (nVarCp != null && !bool.booleanValue()) {
                return nVarCp.x();
            }
        }
        return qg(nVar, z, sVar);
    }

    private static String qg(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        if (hu) {
            return k;
        }
        synchronized (s.class) {
            if (hu) {
                return k;
            }
            k = s(nVar, z, sVar);
            hu = true;
            return k;
        }
    }

    private static String s(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        try {
            String strQg = fs.qg("new_mac_address", "", nVar);
            if (!TextUtils.isEmpty(strQg)) {
                JSONObject jSONObject = new JSONObject(strQg);
                long j = jSONObject.getLong("time");
                String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(jSONObject.getString(e.a.d));
                if (System.currentTimeMillis() - j <= 864000000 && !TextUtils.isEmpty(strQ)) {
                    return strQ;
                }
            }
        } catch (Exception unused) {
        }
        n(nVar, z, sVar);
        return k;
    }

    private static boolean n(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static String n(Context context, com.byazt.vf.n nVar) {
        TelephonyManager telephonyManagerN;
        try {
            com.byazt.tbi.n nVarCp = nVar.cp();
            if ((nVarCp == null || nVarCp.q()) && (telephonyManagerN = n(context)) != null) {
                return telephonyManagerN.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSimOperator();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
