package com.taptap.sdk.kit.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.kit.internal.TapLogger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceUtils {
    private static String TAG = "DeviceUtils";
    public static String cpuAbi = null;

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getCurLanguageDisplayName() {
        Locale locale = CommonUtils.getCurrentLocale();
        return locale.toLanguageTag();
    }

    public static long getDeviceTotalRam(Context context) {
        try {
            ActivityManager manager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
            if (manager == null) {
                return 0L;
            }
            manager.getMemoryInfo(info);
            return info.totalMem;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getDeviceTotalRom(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                long total = statFs.getBlockCountLong() * statFs.getBlockSizeLong();
                return total;
            }
            long total2 = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            return total2;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getRemainingRamSize(Context context) {
        try {
            ActivityManager manager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
            manager.getMemoryInfo(info);
            long result = info.availMem;
            return result;
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
            return 0L;
        }
    }

    public static long getRemainingRomSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long availableCounts = statFs.getAvailableBlocksLong();
            long size = statFs.getBlockSizeLong();
            long result = availableCounts * size;
            return result;
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
            return 0L;
        }
    }

    public static String getPlatform() {
        return "Android";
    }

    public static String getCpuInfo() {
        return Build.CPU_ABI;
    }

    public static String getCpuABIS() {
        String[] abis = Build.SUPPORTED_ABIS;
        if (abis == null || abis.length == 0) {
            return "";
        }
        return Arrays.toString(abis);
    }

    public static int getPackageVersionCode(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getPackageVersion(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            String version = packageInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isRunInSandbox() {
        Object sandbox = System.getProperties().get("flag_running_in_sandbox");
        return sandbox != null;
    }

    public static boolean isRunInCloud() {
        if (TextUtils.isEmpty(Build.MODEL)) {
            return false;
        }
        return Build.MODEL.contains("haima_cloudplay") || Build.MODEL.toLowerCase().contains("taptap");
    }

    public static String getCPUHardware() {
        String hardware = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                FileReader reader = new FileReader("/proc/cpuinfo");
                bufferedReader = new BufferedReader(reader);
                while (true) {
                    String data = bufferedReader.readLine();
                    if (data == null) {
                        break;
                    }
                    if (data.contains("Hardware")) {
                        hardware = data.split(":")[1];
                        break;
                    }
                }
                bufferedReader.close();
            } catch (Throwable e) {
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Throwable th) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        if (hardware == null || hardware.trim().isEmpty()) {
            return Build.HARDWARE;
        }
        return hardware;
    }

    public static String getDeviceBrand() {
        return !TextUtils.isEmpty(Build.BRAND) ? Build.BRAND : "";
    }

    public static String getDeviceModel() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    public static int[] getDeviceSize(Context context) {
        int[] size = new int[2];
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        if (height > width) {
            width = height;
            height = width;
        }
        size[0] = width;
        size[1] = height;
        return size;
    }

    public static String getOS() {
        return Build.VERSION.RELEASE == null ? "UNKNOWN" : Build.VERSION.RELEASE;
    }

    public static String getOSType() {
        return Build.SUPPORTED_64_BIT_ABIS.length > 0 ? "64" : "32";
    }

    public static String getCPUAbi() {
        if (TextUtils.isEmpty(cpuAbi)) {
            try {
                String abi = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine();
                if (abi.contains("x86")) {
                    cpuAbi = "x86";
                } else if (abi.contains("armeabi-v7a")) {
                    cpuAbi = "armeabi-v7a";
                } else if (abi.contains("arm64-v8a")) {
                    cpuAbi = "arm64-v8a";
                } else {
                    cpuAbi = "armeabi";
                }
            } catch (Exception e) {
                cpuAbi = "armeabi";
            }
        }
        return cpuAbi;
    }

    public static String getCarrier(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || TextUtils.isEmpty(telephonyManager.getNetworkOperatorName())) {
                return "unknown";
            }
            String provider = telephonyManager.getNetworkOperatorName();
            return provider;
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
            return null;
        }
    }
}
