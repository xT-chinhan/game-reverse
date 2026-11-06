package com.anythink.china.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            return telephonyManager.getDeviceId();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Map c(Context context) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            String str = (String) method.invoke(null, "ril.gsm.imei", "");
            map.put("meid", (String) method.invoke(null, "ril.cdma.meid", ""));
            if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
                map.put("imei1", strArrSplit[0]);
                if (strArrSplit.length > 1) {
                    map.put("imei2", strArrSplit[1]);
                } else {
                    map.put("imei2", telephonyManager.getDeviceId(1));
                }
            } else {
                map.put("imei1", telephonyManager.getDeviceId(0));
                map.put("imei2", telephonyManager.getDeviceId(1));
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    private static Map d(Context context) {
        HashMap map = new HashMap();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String imei = telephonyManager.getImei(0);
            String imei2 = telephonyManager.getImei(1);
            if (TextUtils.isEmpty(imei) && TextUtils.isEmpty(imei2)) {
                map.put("imei1", telephonyManager.getMeid());
            } else {
                map.put("imei1", imei);
                map.put("imei2", imei2);
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static String a(Context context) {
        if (t.b().c("imei")) {
            return "";
        }
        try {
            return a(d(context));
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(Map map) {
        return map != null ? (String) map.get("imei1") : "";
    }
}
