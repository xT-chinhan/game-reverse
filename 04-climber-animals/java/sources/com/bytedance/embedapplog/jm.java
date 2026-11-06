package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.analytics.pro.bv;

/* JADX INFO: loaded from: classes2.dex */
public class jm {
    public static String ms(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context, "applog_net_cache.dat", 0);
        if (System.currentTimeMillis() - sharedPreferencesXr.getLong("start_mills", 0L) < 900000) {
            String string = sharedPreferencesXr.getString(bv.Q, null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strXr = xr(context);
        SharedPreferences.Editor editorEdit = sharedPreferencesXr.edit();
        if (!TextUtils.isEmpty(strXr)) {
            editorEdit.putString(bv.Q, strXr);
        }
        editorEdit.putLong("start_mills", System.currentTimeMillis());
        editorEdit.apply();
        return strXr;
    }

    private static String xr(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            oh.xr(e);
            activeNetworkInfo = null;
        } catch (Throwable unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return NetworkUtil.NETWORK_TYPE_WIFI;
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
                return NetworkUtil.NETWORK_CLASS_2G;
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
                return NetworkUtil.NETWORK_CLASS_3G;
            case 13:
            case 18:
            case 19:
                return NetworkUtil.NETWORK_CLASS_4G;
            default:
                return "mobile";
        }
    }
}
