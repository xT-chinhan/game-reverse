package com.anythink.china.c;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static String a(Context context) {
        WifiInfo connectionInfo;
        if (context == null) {
            return "";
        }
        try {
            connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            connectionInfo = null;
        }
        if (connectionInfo == null) {
            return null;
        }
        String macAddress = connectionInfo.getMacAddress();
        return !TextUtils.isEmpty(macAddress) ? macAddress.toUpperCase(Locale.ENGLISH) : macAddress;
    }

    public static String a() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b)));
                    }
                    if (!TextUtils.isEmpty(sb)) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String b(Context context) {
        return t.b().c("mac") ? "" : a();
    }
}
