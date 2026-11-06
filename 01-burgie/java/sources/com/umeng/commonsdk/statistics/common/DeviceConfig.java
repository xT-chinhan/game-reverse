package com.umeng.commonsdk.statistics.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.fi.BaseConstants;
import com.byazt.ol.TTDownloadField;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.y;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    protected static final String LOG_TAG = DeviceConfig.class.getName();
    private static DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.DEFAULT;
    private static volatile String sWifiMac = "";
    private static volatile String sImei = "";
    private static volatile String sMeid = "";
    private static volatile String sImsi = "";
    private static volatile String sSerialNo = "";
    private static volatile String sAndroidID = "";
    private static volatile String sIDFA = "";
    private static volatile String sOAID = "";
    private static volatile String sSecondImei = "";
    private static volatile String sSimSerialNumber = "";
    private static volatile boolean hasReadImeiOrMeid = false;
    private static volatile boolean hasReadSimSerialNumber = false;
    private static volatile boolean hasReadIMEI2 = false;
    private static volatile boolean hasReadSerialNo = false;
    private static volatile boolean hasReadAndroidID = false;
    private static volatile boolean hasReadMac = false;
    private static volatile boolean hasReadImsi = false;
    private static volatile boolean hasReadOAID = false;
    private static volatile boolean hasReadIDFA = false;
    private static volatile String sAppName = "";
    private static volatile String sAppPkgName = "";
    private static volatile boolean hasReadOperator = false;
    private static volatile String sOperator = "";
    private static volatile boolean hasReadOperatorName = false;
    private static volatile String sOperatorName = "";

    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String deviceId = null;
        if (hasReadImeiOrMeid) {
            return null;
        }
        try {
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.g) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                    deviceId = telephonyManager.getDeviceId();
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w("No IMEI.", th);
                }
            }
            hasReadImeiOrMeid = true;
            sImei = deviceId;
            return deviceId;
        } catch (Throwable th2) {
            hasReadImeiOrMeid = true;
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0061 A[PHI: r1
      0x0061: PHI (r1v1 java.lang.String) = 
      (r1v0 java.lang.String)
      (r1v0 java.lang.String)
      (r1v0 java.lang.String)
      (r1v0 java.lang.String)
      (r1v2 java.lang.String)
     binds: [B:11:0x0019, B:12:0x001b, B:14:0x0025, B:16:0x002d, B:24:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    public static String getImeiNew(Context context) {
        String deviceId;
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        if (hasReadImeiOrMeid) {
            return null;
        }
        try {
            try {
                if (!FieldManager.allow(com.umeng.commonsdk.utils.d.g) || context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || !checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                    deviceId = str;
                } else if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                        method.setAccessible(true);
                        str = (String) method.invoke(telephonyManager, new Object[0]);
                    } catch (Throwable th) {
                    }
                    if (TextUtils.isEmpty(str)) {
                        deviceId = telephonyManager.getDeviceId();
                    } else {
                        deviceId = str;
                    }
                } else {
                    deviceId = telephonyManager.getDeviceId();
                }
                hasReadImeiOrMeid = true;
            } catch (Throwable th2) {
                hasReadImeiOrMeid = true;
                throw th2;
            }
        } catch (Throwable th3) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.w("No IMEI.", th3);
            }
            hasReadImeiOrMeid = true;
            deviceId = null;
        }
        sImei = deviceId;
        return deviceId;
    }

    public static String getAndroidId(Context context) {
        if (!TextUtils.isEmpty(sAndroidID)) {
            return sAndroidID;
        }
        if (hasReadAndroidID) {
            return null;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.i) && context != null) {
            try {
                try {
                    sAndroidID = Settings.Secure.getString(context.getContentResolver(), Common.Predefined.SUB_ANDROID_ID);
                } catch (Throwable th) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.w("can't read android id");
                    }
                }
            } finally {
                hasReadAndroidID = true;
            }
        }
        return sAndroidID;
    }

    public static String getSerial() {
        return getSerialNo();
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static String[] getGPU(GL10 gl10) throws Throwable {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    private static String getMacByJavaAPI() {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac) {
            return "";
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    if ("wlan0".equals(networkInterfaceNextElement.getName()) || "eth0".equals(networkInterfaceNextElement.getName())) {
                        byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                        if (hardwareAddress == null || hardwareAddress.length == 0) {
                            sWifiMac = "";
                        }
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        sWifiMac = sb.toString().toLowerCase(Locale.getDefault());
                    }
                }
            }
        } catch (Throwable th) {
            hasReadMac = true;
            throw th;
        }
        hasReadMac = true;
        return sWifiMac;
    }

    private static String getMacShell() {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac) {
            return "";
        }
        try {
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                    for (String str : new String[]{"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"}) {
                        try {
                            String strReaMac = reaMac(str);
                            if (strReaMac != null) {
                                sWifiMac = strReaMac;
                            }
                        } catch (Throwable th) {
                            if (AnalyticsConstants.UM_DEBUG) {
                                MLog.e(LOG_TAG, "open file  Failed", th);
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
            }
            return sWifiMac;
        } finally {
            hasReadMac = true;
        }
    }

    private static String reaMac(String str) {
        BufferedReader bufferedReader;
        try {
            FileReader fileReader = new FileReader(str);
            if (fileReader == null) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(fileReader, 1024);
                try {
                    String line = bufferedReader.readLine();
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                        }
                    }
                    return line;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th4) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (Throwable th5) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
        } catch (Throwable th7) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    /* JADX WARN: Code duplicated, block: B:20:0x004d A[RETURN] */
    public static String getCPU() throws Throwable {
        String str = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            if (fileReader != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                    String line = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                        fileReader.close();
                        str = line;
                    } catch (FileNotFoundException e) {
                        e = e;
                        str = line;
                        MLog.e(LOG_TAG, "Could not open file /proc/cpuinfo", e);
                        if (str != null) {
                            return str.substring(str.indexOf(58) + 1).trim();
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        str = line;
                        MLog.e(LOG_TAG, "Could not read from file /proc/cpuinfo", th);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
        if (str != null) {
            return str.substring(str.indexOf(58) + 1).trim();
        }
        return "";
    }

    public static String getDeviceId(Context context) {
        if (AnalyticsConstants.getDeviceType() == 2) {
            return getDeviceIdForBox(context);
        }
        return getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getMCCMNC(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (getImsi(context) == null) {
                return null;
            }
            int i = context.getResources().getConfiguration().mcc;
            int i2 = context.getResources().getConfiguration().mnc;
            if (i != 0) {
                String strValueOf = String.valueOf(i2);
                if (i2 < 10) {
                    strValueOf = String.format("%02d", Integer.valueOf(i2));
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(String.valueOf(i));
                stringBuffer.append(strValueOf);
                return stringBuffer.toString();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String getImsi(Context context) {
        if (!TextUtils.isEmpty(sImsi)) {
            return sImsi;
        }
        String subscriberId = null;
        if (hasReadImsi || context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.aj)) {
            try {
                if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                    subscriberId = telephonyManager.getSubscriberId();
                }
            } catch (Throwable th) {
                hasReadImsi = true;
                throw th;
            }
            hasReadImsi = true;
        }
        sImsi = subscriberId;
        return sImsi;
    }

    public static String getMeid(Context context) {
        TelephonyManager telephonyManager;
        String strMeid;
        String imei;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || !FieldManager.allow(com.umeng.commonsdk.utils.d.ak)) {
            return null;
        }
        try {
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 26) {
                imei = getIMEI(context);
            } else {
                try {
                    strMeid = meid(context);
                    try {
                        if (TextUtils.isEmpty(strMeid)) {
                            imei = getIMEI(context);
                        } else {
                            imei = strMeid;
                        }
                    } catch (Throwable th) {
                        return strMeid;
                    }
                } catch (Throwable th2) {
                    strMeid = null;
                }
            }
            return imei;
        } catch (Throwable th3) {
            return null;
        }
    }

    private static String meid(Context context) {
        if (!TextUtils.isEmpty(sMeid)) {
            return sMeid;
        }
        String str = null;
        if (hasReadImeiOrMeid || context == null) {
            return null;
        }
        try {
            try {
                Object objInvoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);
                if (objInvoke != null && (objInvoke instanceof String)) {
                    str = (String) objInvoke;
                }
            } catch (Throwable th) {
                if (th != null) {
                    ULog.e("meid:" + th.getMessage());
                }
                hasReadImeiOrMeid = true;
                sMeid = str;
                return sMeid;
            }
            hasReadImeiOrMeid = true;
            sMeid = str;
            return sMeid;
        } catch (Throwable th2) {
            hasReadImeiOrMeid = true;
            throw th2;
        }
    }

    public static String getSimICCID(Context context) {
        if (!TextUtils.isEmpty(sSimSerialNumber)) {
            return sSimSerialNumber;
        }
        if (hasReadSimSerialNumber) {
            return null;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.an)) {
            if (context != null) {
                try {
                    if (UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            sSimSerialNumber = telephonyManager.getSimSerialNumber();
                        } else {
                            hasReadSimSerialNumber = true;
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    hasReadSimSerialNumber = true;
                    throw th;
                }
            }
            hasReadSimSerialNumber = true;
        }
        return sSimSerialNumber;
    }

    public static String getSecondSimIMEi(Context context) {
        return null;
    }

    public static String getRegisteredOperator(Context context) {
        if (!TextUtils.isEmpty(sOperator)) {
            return sOperator;
        }
        if (hasReadOperator || context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                sOperator = telephonyManager.getNetworkOperator();
            }
        } catch (Throwable th) {
            hasReadOperator = true;
            throw th;
        }
        hasReadOperator = true;
        return sOperator;
    }

    public static String getNetworkOperatorName(Context context) {
        if (!TextUtils.isEmpty(sOperatorName)) {
            return sOperatorName;
        }
        if (hasReadOperatorName || context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                sOperatorName = telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable th) {
        }
        hasReadOperatorName = true;
        return sOperatorName;
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i);
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "Wi-Fi";
                return strArr;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "2G/3G";
                strArr[1] = networkInfo2.getSubtypeName();
                return strArr;
            }
            return strArr;
        } catch (Throwable th) {
        }
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception e) {
            return -100;
        }
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static int getTimeZone(Context context) throws Throwable {
        if (context == null) {
            return 8;
        }
        try {
            Calendar calendar = Calendar.getInstance(getLocale(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / BaseConstants.Time.HOUR;
            }
        } catch (Throwable th) {
            MLog.i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
    }

    public static boolean isChineseAera(Context context) {
        if (context == null) {
            return false;
        }
        try {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, an.O, "");
            if (!TextUtils.isEmpty(strImprintProperty)) {
                return strImprintProperty.equals("cn");
            }
            if (getImsi(context) == null) {
                String str = getLocaleInfo(context)[0];
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("cn")) {
                    return true;
                }
            } else {
                int i = context.getResources().getConfiguration().mcc;
                if (i != 460 && i != 461) {
                    if (i == 0) {
                        String str2 = getLocaleInfo(context)[0];
                        if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("cn")) {
                            return true;
                        }
                    }
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
        }
    }

    public static String[] getLocaleInfo(Context context) throws Throwable {
        String[] strArr = {"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    private static Locale getLocale(Context context) throws Throwable {
        if (context == null) {
            return Locale.getDefault();
        }
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "fail to read user config locale");
        }
        if (locale == null) {
            return Locale.getDefault();
        }
        return locale;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static String getMac(Context context) {
        String macBySystemInterface;
        String str;
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.h) || context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                macBySystemInterface = getMacBySystemInterface(context);
            } else {
                ?? r1 = Build.VERSION.SDK_INT;
                try {
                    if (r1 == 23) {
                        String macByJavaAPI = getMacByJavaAPI();
                        boolean zIsEmpty = TextUtils.isEmpty(macByJavaAPI);
                        str = macByJavaAPI;
                        if (zIsEmpty) {
                            if (AnalyticsConstants.CHECK_DEVICE) {
                                macBySystemInterface = getMacShell();
                                r1 = macByJavaAPI;
                            } else {
                                macBySystemInterface = getMacBySystemInterface(context);
                                r1 = macByJavaAPI;
                            }
                        }
                        return str;
                    }
                    String macByJavaAPI2 = getMacByJavaAPI();
                    boolean zIsEmpty2 = TextUtils.isEmpty(macByJavaAPI2);
                    str = macByJavaAPI2;
                    if (zIsEmpty2) {
                        macBySystemInterface = getMacBySystemInterface(context);
                        r1 = macByJavaAPI2;
                    }
                    return str;
                } catch (Throwable th) {
                    return r1;
                }
            }
            return macBySystemInterface;
        } catch (Throwable th2) {
            return "";
        }
    }

    private static String getMacBySystemInterface(Context context) {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac || context == null) {
            return "";
        }
        try {
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
                    if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                        if (wifiManager != null) {
                            sWifiMac = wifiManager.getConnectionInfo().getMacAddress();
                        } else {
                            sWifiMac = "";
                        }
                    } else {
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                        }
                        sWifiMac = "";
                    }
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "Could not get mac address." + th.toString());
                }
            }
            return sWifiMac;
        } finally {
            hasReadMac = true;
        }
    }

    public static int[] getResolutionArray(Context context) {
        int iReflectMetrics;
        int iReflectMetrics2;
        Method method;
        if (context == null) {
            return null;
        }
        int[] iArr = new int[2];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                try {
                    Class<?> cls = Class.forName("android.view.Display");
                    if (cls != null && (method = cls.getMethod("getRealMetrics", DisplayMetrics.class)) != null) {
                        method.invoke(defaultDisplay, displayMetrics);
                        int i = displayMetrics.widthPixels;
                        int i2 = displayMetrics.heightPixels;
                        if (i > i2) {
                            iArr[0] = i2;
                            iArr[1] = i;
                        } else {
                            iArr[0] = i;
                            iArr[1] = i2;
                        }
                        iArr[0] = displayMetrics.widthPixels;
                        iArr[1] = displayMetrics.heightPixels;
                        return iArr;
                    }
                } catch (Throwable th) {
                    return null;
                }
            } else {
                try {
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics2);
                    if ((context.getApplicationInfo().flags & 8192) == 0) {
                        iReflectMetrics = reflectMetrics(displayMetrics2, "noncompatWidthPixels");
                        iReflectMetrics2 = reflectMetrics(displayMetrics2, "noncompatHeightPixels");
                    } else {
                        iReflectMetrics = -1;
                        iReflectMetrics2 = -1;
                    }
                    if (iReflectMetrics == -1 || iReflectMetrics2 == -1) {
                        iReflectMetrics = displayMetrics2.widthPixels;
                        iReflectMetrics2 = displayMetrics2.heightPixels;
                    }
                    if (iReflectMetrics > iReflectMetrics2) {
                        iArr[0] = iReflectMetrics2;
                        iArr[1] = iReflectMetrics;
                    } else {
                        iArr[0] = iReflectMetrics;
                        iArr[1] = iReflectMetrics2;
                    }
                    return iArr;
                } catch (Throwable th2) {
                }
            }
        }
        return null;
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable th) {
            return -1;
        }
    }

    public static String getPackageName(Context context) {
        if (!TextUtils.isEmpty(sAppPkgName)) {
            return sAppPkgName;
        }
        if (context == null) {
            return null;
        }
        sAppPkgName = context.getPackageName();
        return sAppPkgName;
    }

    public static String getAppSHA1Key(Context context) {
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (packageInfoA == null) {
                return null;
            }
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(packageInfoA.signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception e) {
            return null;
        }
    }

    public static String getAppHashKey(Context context) {
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (packageInfoA != null) {
                Signature[] signatureArr = packageInfoA.signatures;
                if (signatureArr.length > 0) {
                    Signature signature = signatureArr[0];
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                    messageDigest.update(signature.toByteArray());
                    return Base64.encodeToString(messageDigest.digest(), 0).trim();
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (packageInfoA == null) {
                return null;
            }
            return byte2HexFormatted(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(packageInfoA.signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable th) {
            return null;
        }
    }

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(AbstractJsonLexerKt.COLON);
            }
        }
        return sb.toString();
    }

    public static String getApplicationLable(Context context) {
        if (context == null) {
            return "";
        }
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static String getAppName(Context context) throws Throwable {
        if (!TextUtils.isEmpty(sAppName)) {
            return sAppName;
        }
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfoA = com.umeng.commonsdk.utils.b.a().a(context, context.getPackageName(), 64);
            if (packageInfoA != null) {
                sAppName = packageInfoA.applicationInfo.loadLabel(context.getPackageManager()).toString();
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i(LOG_TAG, th);
            }
        }
        return sAppName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.String] */
    public static String getDeviceIdForGeneral(Context context) {
        String imei;
        String serialNo;
        String macBySystemInterface;
        if (context == 0) {
            return "";
        }
        try {
            ?? r1 = Build.VERSION.SDK_INT;
            try {
                try {
                    if (r1 < 23) {
                        imei = getIMEI(context);
                        deviceTypeEnum = DeviceTypeEnum.IMEI;
                        if (TextUtils.isEmpty(imei)) {
                            if (AnalyticsConstants.UM_DEBUG) {
                                MLog.w(LOG_TAG, "No IMEI.");
                            }
                            String macBySystemInterface2 = getMacBySystemInterface(context);
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            if (TextUtils.isEmpty(macBySystemInterface2)) {
                                if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                                    String androidId = getAndroidId(context);
                                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + androidId);
                                    }
                                    macBySystemInterface2 = androidId;
                                }
                                if (TextUtils.isEmpty(macBySystemInterface2)) {
                                    serialNo = getSerialNo();
                                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                                    return serialNo;
                                }
                                return macBySystemInterface2;
                            }
                            return macBySystemInterface2;
                        }
                        return imei;
                    }
                    if (Build.VERSION.SDK_INT == 23) {
                        imei = getIMEI(context);
                        deviceTypeEnum = DeviceTypeEnum.IMEI;
                        if (TextUtils.isEmpty(imei)) {
                            String macByJavaAPI = getMacByJavaAPI();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            if (TextUtils.isEmpty(macByJavaAPI)) {
                                if (AnalyticsConstants.CHECK_DEVICE) {
                                    macBySystemInterface = getMacShell();
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                } else {
                                    macBySystemInterface = getMacBySystemInterface(context);
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                }
                                macByJavaAPI = macBySystemInterface;
                            }
                            if (AnalyticsConstants.UM_DEBUG) {
                                MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
                            }
                            if (TextUtils.isEmpty(macByJavaAPI)) {
                                if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                                    String androidId2 = getAndroidId(context);
                                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + androidId2);
                                    }
                                    macByJavaAPI = androidId2;
                                }
                                if (TextUtils.isEmpty(macByJavaAPI)) {
                                    serialNo = getSerialNo();
                                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                                    return serialNo;
                                }
                                return macByJavaAPI;
                            }
                            return macByJavaAPI;
                        }
                    } else if (Build.VERSION.SDK_INT >= 29) {
                        imei = getOaid(context);
                        deviceTypeEnum = DeviceTypeEnum.OAID;
                        if (TextUtils.isEmpty(imei)) {
                            String idfa = getIdfa(context);
                            deviceTypeEnum = DeviceTypeEnum.IDFA;
                            if (TextUtils.isEmpty(idfa)) {
                                imei = getAndroidId(context);
                                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                                if (TextUtils.isEmpty(imei)) {
                                    String serialNo2 = getSerialNo();
                                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                                    if (TextUtils.isEmpty(serialNo2)) {
                                        imei = getMacByJavaAPI();
                                        deviceTypeEnum = DeviceTypeEnum.MAC;
                                        if (TextUtils.isEmpty(imei)) {
                                            String macBySystemInterface3 = getMacBySystemInterface(context);
                                            deviceTypeEnum = DeviceTypeEnum.MAC;
                                            return macBySystemInterface3;
                                        }
                                    } else {
                                        return serialNo2;
                                    }
                                }
                            } else {
                                return idfa;
                            }
                        }
                    } else {
                        imei = getIMEI(context);
                        deviceTypeEnum = DeviceTypeEnum.IMEI;
                        if (TextUtils.isEmpty(imei)) {
                            String serialNo3 = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            if (TextUtils.isEmpty(serialNo3)) {
                                if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                                    String androidId3 = getAndroidId(context);
                                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + androidId3);
                                    }
                                    serialNo3 = androidId3;
                                }
                                if (TextUtils.isEmpty(serialNo3)) {
                                    imei = getMacByJavaAPI();
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                    if (TextUtils.isEmpty(imei)) {
                                        String macBySystemInterface4 = getMacBySystemInterface(context);
                                        deviceTypeEnum = DeviceTypeEnum.MAC;
                                        if (AnalyticsConstants.UM_DEBUG) {
                                            MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface4);
                                            return macBySystemInterface4;
                                        }
                                        return macBySystemInterface4;
                                    }
                                } else {
                                    return serialNo3;
                                }
                            } else {
                                return serialNo3;
                            }
                        }
                    }
                    return imei;
                } catch (Throwable th) {
                    return r1;
                }
            } catch (Throwable th2) {
                return context;
            }
        } catch (Throwable th3) {
            return "";
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.String] */
    public static String getDeviceIdForBox(Context context) {
        String serialNo;
        String macBySystemInterface;
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            ?? r1 = Build.VERSION.SDK_INT;
            try {
                if (r1 < 23) {
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                        String androidId = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + androidId);
                        }
                        str = androidId;
                    }
                    if (TextUtils.isEmpty(str)) {
                        serialNo = getMacBySystemInterface(context);
                        deviceTypeEnum = DeviceTypeEnum.MAC;
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.i(LOG_TAG, "getDeviceId, MAC: " + serialNo);
                        }
                        if (TextUtils.isEmpty(serialNo)) {
                            String serialNo2 = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            if (TextUtils.isEmpty(serialNo2)) {
                                String imei = getIMEI(context);
                                try {
                                    deviceTypeEnum = DeviceTypeEnum.IMEI;
                                    return imei;
                                } catch (Throwable th) {
                                    return imei;
                                }
                            }
                            return serialNo2;
                        }
                    } else {
                        return str;
                    }
                } else if (Build.VERSION.SDK_INT == 23) {
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                        String androidId2 = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + androidId2);
                        }
                        str = androidId2;
                    }
                    if (TextUtils.isEmpty(str)) {
                        String macByJavaAPI = getMacByJavaAPI();
                        deviceTypeEnum = DeviceTypeEnum.MAC;
                        if (TextUtils.isEmpty(macByJavaAPI)) {
                            if (AnalyticsConstants.CHECK_DEVICE) {
                                macBySystemInterface = getMacShell();
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                            } else {
                                macBySystemInterface = getMacBySystemInterface(context);
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                            }
                        } else {
                            macBySystemInterface = macByJavaAPI;
                        }
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface);
                        }
                        if (TextUtils.isEmpty(macBySystemInterface)) {
                            serialNo = getSerialNo();
                            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                            if (TextUtils.isEmpty(serialNo)) {
                                String imei2 = getIMEI(context);
                                deviceTypeEnum = DeviceTypeEnum.IMEI;
                                return imei2;
                            }
                        } else {
                            return macBySystemInterface;
                        }
                    } else {
                        return str;
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    serialNo = getOaid(context);
                    deviceTypeEnum = DeviceTypeEnum.OAID;
                    if (TextUtils.isEmpty(serialNo)) {
                        String idfa = getIdfa(context);
                        deviceTypeEnum = DeviceTypeEnum.IDFA;
                        if (TextUtils.isEmpty(idfa)) {
                            serialNo = getAndroidId(context);
                            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                            if (TextUtils.isEmpty(serialNo)) {
                                String serialNo3 = getSerialNo();
                                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                                if (TextUtils.isEmpty(serialNo3)) {
                                    serialNo = getMacByJavaAPI();
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                    if (TextUtils.isEmpty(serialNo)) {
                                        String macBySystemInterface2 = getMacBySystemInterface(context);
                                        deviceTypeEnum = DeviceTypeEnum.MAC;
                                        return macBySystemInterface2;
                                    }
                                } else {
                                    return serialNo3;
                                }
                            }
                        } else {
                            return idfa;
                        }
                    }
                } else {
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                        String androidId3 = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.i(LOG_TAG, "getDeviceId: ANDROID_ID: " + androidId3);
                        }
                        str = androidId3;
                    }
                    if (TextUtils.isEmpty(str)) {
                        serialNo = getSerialNo();
                        deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                        if (TextUtils.isEmpty(serialNo)) {
                            String imei3 = getIMEI(context);
                            deviceTypeEnum = DeviceTypeEnum.IMEI;
                            if (TextUtils.isEmpty(imei3)) {
                                serialNo = getMacByJavaAPI();
                                deviceTypeEnum = DeviceTypeEnum.MAC;
                                if (TextUtils.isEmpty(serialNo)) {
                                    String macBySystemInterface3 = getMacBySystemInterface(context);
                                    deviceTypeEnum = DeviceTypeEnum.MAC;
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface3);
                                        return macBySystemInterface3;
                                    }
                                    return macBySystemInterface3;
                                }
                            } else {
                                return imei3;
                            }
                        }
                    } else {
                        return str;
                    }
                }
                return serialNo;
            } catch (Throwable th2) {
                return r1;
            }
        } catch (Throwable th3) {
            return "";
        }
    }

    public static String getOaid(Context context) {
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (hasReadOAID) {
            return "";
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                if (sharedPreferences != null) {
                    sOAID = sharedPreferences.getString(h.b, "");
                }
            } catch (Throwable th) {
            } finally {
                hasReadOAID = true;
            }
        }
        return sOAID;
    }

    public static String getIdfa(Context context) {
        if (!TextUtils.isEmpty(sIDFA)) {
            return sIDFA;
        }
        if (hasReadIDFA) {
            return "";
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
                sIDFA = a.a(context);
            }
        } catch (Throwable th) {
        }
        hasReadIDFA = true;
        return sIDFA;
    }

    private static String getIMEI(Context context) {
        Throwable th;
        String deviceId;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        if (hasReadImeiOrMeid) {
            return "";
        }
        String str = "";
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
            if (context == null) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    try {
                        if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                            deviceId = telephonyManager.getDeviceId();
                            try {
                                if (AnalyticsConstants.UM_DEBUG) {
                                    MLog.i(LOG_TAG, "getDeviceId, IMEI: " + deviceId);
                                }
                                str = deviceId;
                            } catch (Throwable th2) {
                                th = th2;
                                if (AnalyticsConstants.UM_DEBUG) {
                                    MLog.w(LOG_TAG, "No IMEI.", th);
                                }
                                hasReadImeiOrMeid = true;
                                str = deviceId;
                            }
                        }
                        hasReadImeiOrMeid = true;
                    } catch (Throwable th3) {
                        th = th3;
                        deviceId = "";
                    }
                } catch (Throwable th4) {
                    hasReadImeiOrMeid = true;
                    throw th4;
                }
            }
        }
        sImei = str;
        return sImei;
    }

    private static String getSerialNo() throws Throwable {
        if (!TextUtils.isEmpty(sSerialNo)) {
            return sSerialNo;
        }
        if (hasReadSerialNo) {
            return "";
        }
        String str = "";
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.j)) {
            try {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        try {
                            Class<?> cls = Class.forName("android.os.Build");
                            Method method = cls.getMethod("getSerial", new Class[0]);
                            if (checkPermission(UMGlobalContext.getAppContext(), "android.permission.READ_PHONE_STATE")) {
                                str = (String) method.invoke(cls, new Object[0]);
                            }
                        } catch (Throwable th) {
                        }
                    } else {
                        str = Build.SERIAL;
                    }
                    sSerialNo = str;
                } catch (Throwable th2) {
                    hasReadSerialNo = true;
                    throw th2;
                }
            } catch (Throwable th3) {
            }
            hasReadSerialNo = true;
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.i(LOG_TAG, "getDeviceId, serial no: " + str);
        }
        return sSerialNo;
    }

    public static String getSubOSName(Context context) throws Throwable {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (TextUtils.isEmpty(property)) {
                if (isFlyMe()) {
                    return "Flyme";
                }
                if (isEmui(buildProp)) {
                    return "Emui";
                }
                if (!TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                    return "YunOS";
                }
                return property;
            }
            return "MIUI";
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) throws Throwable {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (TextUtils.isEmpty(property)) {
                if (isFlyMe()) {
                    try {
                        return getFlymeVersion(buildProp);
                    } catch (Throwable th) {
                    }
                } else if (isEmui(buildProp)) {
                    try {
                        return getEmuiVersion(buildProp);
                    } catch (Throwable th2) {
                    }
                } else {
                    try {
                        return getYunOSVersion(buildProp);
                    } catch (Throwable th3) {
                    }
                }
            }
            return property;
        } catch (Throwable th4) {
            return null;
        }
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Properties getBuildProp() throws Throwable {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    properties.load(fileInputStream2);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                } catch (Throwable th) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return properties;
                }
            } catch (Throwable th2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return properties;
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean isEmui(Properties properties) {
        try {
            if (properties.getProperty(KEY_EMUI_VERSION_CODE, null) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getDeviceType(Context context) {
        String str;
        if (context == null) {
            return "Phone";
        }
        try {
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                str = "Tablet";
            } else {
                str = "Phone";
            }
            return str;
        } catch (Throwable th) {
            return "Phone";
        }
    }

    public static String getDBencryptID(Context context) {
        return UMUtils.genId();
    }

    public static Activity getGlobleActivity(Context context) {
        Activity activity = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    activity = (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable th) {
        }
        return activity;
    }

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony");
        } catch (Throwable th) {
            return false;
        }
    }

    public static String getSid(Context context) {
        return y.a().d(context);
    }
}
