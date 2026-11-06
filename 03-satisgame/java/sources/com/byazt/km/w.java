package com.byazt.km;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 13})
public class w {
    public static String n(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesQg = com.byazt.qyu.qg.qg(context, "applog_net_cache.dat", 0);
        if (System.currentTimeMillis() - sharedPreferencesQg.getLong("start_mills", 0L) < 900000) {
            String string = sharedPreferencesQg.getString("access", null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strQg = qg(context);
        SharedPreferences.Editor editorEdit = sharedPreferencesQg.edit();
        if (!TextUtils.isEmpty(strQg)) {
            editorEdit.putString("access", strQg);
        }
        editorEdit.putLong("start_mills", System.currentTimeMillis());
        editorEdit.apply();
        return strQg;
    }

    private static String qg(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            cp.qg(e);
            activeNetworkInfo = null;
        } catch (Throwable unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return "wifi";
        }
        if (type != 0) {
            return null;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2g";
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
                return "3g";
            case 13:
            case 18:
            case 19:
                return "4g";
            default:
                return "mobile";
        }
    }
}
