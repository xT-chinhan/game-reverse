package com.mcto.sspsdk.internal;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.taptap.sdk.db.constant.Common;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w4 {
    public static String a() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces != null) {
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                String name = networkInterfaceNextElement.getName();
                if (name != null && name.equals("wlan0")) {
                    byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                    if (hardwareAddress == null || hardwareAddress.length == 0) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        }
        return "";
    }

    public static String b(Context context) {
        String deviceId = null;
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    deviceId = telephonyManager.getImei();
                    if (TextUtils.isEmpty(deviceId)) {
                        deviceId = telephonyManager.getMeid();
                    }
                } else {
                    deviceId = telephonyManager.getDeviceId();
                }
            }
        } catch (Exception e) {
        }
        return TextUtils.isEmpty(deviceId) ? "" : deviceId;
    }

    public static String c(Context context) {
        String strD;
        try {
            strD = Build.VERSION.SDK_INT < 23 ? d(context) : a();
        } catch (Exception e) {
            strD = null;
        }
        return TextUtils.isEmpty(strD) ? "" : strD;
    }

    public static String d(Context context) {
        WifiInfo connectionInfo;
        try {
            if (ClassLoader.getSystemClassLoader().loadClass("android.net.wifi.WifiInfo") == null) {
                r9.a("ssp_sdk", "cat not get net info class.", null);
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                return connectionInfo.getMacAddress();
            }
            return "";
        } catch (Exception e) {
            r9.a("ssp_sdk", "get ma error", null);
        }
    }

    public static String a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), Common.Predefined.SUB_ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }
}
