package com.taptap.sdk.kit.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.anythink.china.b.c;
import com.taptap.sdk.kit.internal.TapLogger;
import com.varbto.utils.api.UtilConst;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceUtils {
    private static String TAG = "DeviceUtils";
    public static String cpuAbi;

    public static String getPlatform() {
        return "Android";
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getCurLanguageDisplayName() {
        return CommonUtils.getCurrentLocale().toLanguageTag();
    }

    public static long getDeviceTotalRam(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager == null) {
                return 0L;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getDeviceTotalRom(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getRemainingRamSize(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
            return 0L;
        }
    }

    public static long getRemainingRomSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
            return 0L;
        }
    }

    public static String getCpuInfo() {
        return Build.CPU_ABI;
    }

    public static String getCpuABIS() {
        String[] strArr = Build.SUPPORTED_ABIS;
        return (strArr == null || strArr.length == 0) ? "" : Arrays.toString(strArr);
    }

    public static int getPackageVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getPackageVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isRunInSandbox() {
        return System.getProperties().get("flag_running_in_sandbox") != null;
    }

    public static boolean isRunInCloud() {
        if (TextUtils.isEmpty(Build.MODEL)) {
            return false;
        }
        return Build.MODEL.contains("haima_cloudplay") || Build.MODEL.toLowerCase().contains("taptap");
    }

    public static String getCPUHardware() {
        BufferedReader bufferedReader;
        Throwable th;
        String str = "";
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.contains("Hardware")) {
                            str = line.split(":")[1];
                            break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                }
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
        }
        return str;
    }

    public static String getDeviceBrand() {
        return !TextUtils.isEmpty(Build.BRAND) ? Build.BRAND : "";
    }

    public static String getDeviceModel() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    public static int[] getDeviceSize(Context context) {
        int[] iArr = new int[2];
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            i = i2;
            i2 = i;
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public static String getOS() {
        return Build.VERSION.RELEASE == null ? UtilConst.CRASH_CAT_UNKNOWN : Build.VERSION.RELEASE;
    }

    public static String getOSType() {
        return Build.SUPPORTED_64_BIT_ABIS.length > 0 ? "64" : "32";
    }

    public static String getCPUAbi() {
        if (TextUtils.isEmpty(cpuAbi)) {
            try {
                String line = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine();
                if (line.contains("x86")) {
                    cpuAbi = "x86";
                } else if (line.contains("armeabi-v7a")) {
                    cpuAbi = "armeabi-v7a";
                } else if (line.contains("arm64-v8a")) {
                    cpuAbi = "arm64-v8a";
                } else {
                    cpuAbi = "armeabi";
                }
            } catch (Exception unused) {
                cpuAbi = "armeabi";
            }
        }
        return cpuAbi;
    }

    public static String getCarrier(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (telephonyManager == null || TextUtils.isEmpty(telephonyManager.getNetworkOperatorName())) ? "unknown" : telephonyManager.getNetworkOperatorName();
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
            return null;
        }
    }

    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager;
        String deviceId;
        try {
            if (!hasReadPhoneStatePermission(context) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT > 28) {
                if (telephonyManager.hasCarrierPrivileges()) {
                    deviceId = telephonyManager.getImei();
                } else {
                    TapLogger.logd(TAG, "Can not get IMEI info.");
                    return "";
                }
            } else if (Build.VERSION.SDK_INT >= 26) {
                deviceId = telephonyManager.getImei();
            } else {
                deviceId = telephonyManager.getDeviceId();
            }
            return deviceId;
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
            return "";
        }
    }

    private static boolean hasReadPhoneStatePermission(Context context) {
        if (Build.VERSION.SDK_INT > 28) {
            if (checkHasPermission(context, "android.permission.READ_PRECISE_PHONE_STATE")) {
                return true;
            }
            TapLogger.logd(TAG, "Don't have permission android.permission.READ_PRECISE_PHONE_STATE,getDeviceID failed");
            return false;
        }
        if (checkHasPermission(context, c.a)) {
            return true;
        }
        TapLogger.logd(TAG, "Don't have permission android.permission.READ_PHONE_STATE,getDeviceID failed");
        return false;
    }

    public static boolean checkHasPermission(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Exception unused) {
        }
    }
}
