package com.smartdigimkt.g;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.anythink.core.common.l.f;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.q2.g;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.bridge.entity.DeviceInfoEntity;
import com.smartdigimkt.v2.p;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static String g = null;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static String k = "";
    public static String l = "";

    public static synchronized String a(Context context) {
        String str = g;
        if (str != null) {
            return str;
        }
        try {
            g = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (g == null) {
            g = "";
        }
        return g;
    }

    public static synchronized String b(Context context) {
        if (SDKContext.getInstance().a("imei")) {
            return "";
        }
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (!g.e && !SDKContext.getInstance().l) {
            return "";
        }
        DeviceInfoEntity deviceInfoEntity = h.W;
        if (deviceInfoEntity != null) {
            String imei = deviceInfoEntity.getImei();
            b = imei;
            if (!TextUtils.isEmpty(imei)) {
                return b;
            }
        }
        if (!h && TextUtils.isEmpty(b)) {
            try {
                if (ActivityCompat.checkSelfPermission(context, com.anythink.china.b.c.a) == 0) {
                    b = c.a(context);
                    h = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return b;
    }

    public static void c(Context context) {
        String str;
        a = c();
        b = b(context);
        c = h.t();
        String[] strArrA = b.a(h.g(context));
        if (strArrA != null && strArrA.length == 2) {
            d = strArrA[0];
            e = strArrA[1];
        }
        try {
            File file = new File("/data/data");
            if (file.exists()) {
                str = (file.lastModified() / 1000) + ".000000000";
            } else {
                str = "";
            }
        } catch (Throwable unused) {
        }
        f = str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.smartdigimkt.v2.a(com.smartdigimkt.q2.a.f, "vivo_ver"));
        if (Build.VERSION.SDK_INT >= 29) {
            arrayList.add(new com.smartdigimkt.v2.a(com.smartdigimkt.q2.a.d, "oppo_ver"));
        } else {
            arrayList.add(new com.smartdigimkt.v2.a(com.smartdigimkt.q2.a.e, "oppo_ver"));
        }
        arrayList.add(new com.smartdigimkt.v2.a(com.smartdigimkt.q2.a.c, "xiaomi_ver"));
        arrayList.add(new com.smartdigimkt.v2.a(com.smartdigimkt.q2.a.a, "honor_ver"));
        arrayList.add(new com.smartdigimkt.v2.a(com.smartdigimkt.q2.a.g, "honor_v2_ver"));
        p pVarC = p.c();
        pVarC.getClass();
        if (!SDKContext.getInstance().a(f.bG) && arrayList.size() > 0) {
            com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.v2.h(pVarC, arrayList), Math.max(0L, g.h), 2);
        }
    }

    public static synchronized String d() {
        if (SDKContext.getInstance().a("wifi_name")) {
            return "";
        }
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        DeviceInfoEntity deviceInfoEntity = h.W;
        if (deviceInfoEntity != null) {
            String ssid = deviceInfoEntity.getSsid();
            k = ssid;
            if (!TextUtils.isEmpty(ssid)) {
                return k;
            }
        }
        if (!g.e && !SDKContext.getInstance().l) {
            return "";
        }
        if (!i && TextUtils.isEmpty(k)) {
            k = b.b(SDKContext.getInstance().d());
            i = true;
        }
        return k;
    }

    public static String a() {
        String strS = h.s();
        String str = Build.MANUFACTURER;
        String lowerCase = str != null ? str.toLowerCase() : "";
        if (!strS.contains(MediationConstant.ADN_XIAOMI) && !strS.contains("redmi") && !lowerCase.contains(MediationConstant.ADN_XIAOMI) && !lowerCase.contains("redmi")) {
            if (!strS.contains("huawei") && !lowerCase.contains("huawei")) {
                if (!strS.contains("oppo") && !lowerCase.contains("oppo")) {
                    if (strS.contains("vivo") || lowerCase.contains("vivo")) {
                        return com.smartdigimkt.q2.a.f;
                    }
                    return (strS.contains("honor") || lowerCase.contains("honor") || strS.contains("hihonor") || lowerCase.contains("hihonor")) ? com.smartdigimkt.q2.a.g : "";
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    return com.smartdigimkt.q2.a.d;
                }
                return com.smartdigimkt.q2.a.e;
            }
            return com.smartdigimkt.q2.a.a;
        }
        return com.smartdigimkt.q2.a.c;
    }

    public static String b() {
        String subscriberId;
        if (SDKContext.getInstance().a("imsi")) {
            return "";
        }
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        DeviceInfoEntity deviceInfoEntity = h.W;
        if (deviceInfoEntity != null) {
            String imsi = deviceInfoEntity.getImsi();
            l = imsi;
            if (!TextUtils.isEmpty(imsi)) {
                return l;
            }
        }
        if (!g.e && !SDKContext.getInstance().l) {
            return "";
        }
        if (!j && TextUtils.isEmpty(l)) {
            try {
                if (ActivityCompat.checkSelfPermission(SDKContext.getInstance().d(), com.anythink.china.b.c.a) == 0) {
                    synchronized (b.class) {
                        if (!j) {
                            try {
                                TelephonyManager telephonyManager = (TelephonyManager) SDKContext.getInstance().d().getSystemService("phone");
                                if (telephonyManager == null || (subscriberId = telephonyManager.getSubscriberId()) == null) {
                                    subscriberId = "";
                                }
                            } catch (Throwable unused) {
                            }
                            l = subscriberId;
                            j = true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return l;
        subscriberId = "";
        l = subscriberId;
        j = true;
        return l;
    }

    public static synchronized String c() {
        if (SDKContext.getInstance().a("mac")) {
            return "";
        }
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        DeviceInfoEntity deviceInfoEntity = h.W;
        if (deviceInfoEntity != null) {
            String mac = deviceInfoEntity.getMac();
            a = mac;
            if (!TextUtils.isEmpty(mac)) {
                return a;
            }
        }
        return "";
    }
}
