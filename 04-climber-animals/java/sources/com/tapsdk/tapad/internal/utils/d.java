package com.tapsdk.tapad.internal.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.internal.Callback;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static LocationManager a = null;
    private static String b = null;
    private static boolean c = false;
    private static String d = "";
    private static final LocationListener e = new a();
    private static WeakReference<Callback<Location>> f;

    static class a implements LocationListener {
        a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (d.f != null && d.f.get() != null) {
                ((Callback) d.f.get()).onSuccess(location);
            }
            if (d.a != null) {
                d.a.removeUpdates(d.e);
            }
            WeakReference unused = d.f = null;
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            if (d.f != null && d.f.get() != null) {
                ((Callback) d.f.get()).onFail(new RuntimeException(str + " disable"));
            }
            if (d.a != null) {
                d.a.removeUpdates(d.e);
            }
            WeakReference unused = d.f = null;
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            TapADLogger.d("location provider enable");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public static String a(Context context, TapAdConfig tapAdConfig) {
        TapAdCustomController tapAdCustomController;
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (tapAdConfig == null || (tapAdCustomController = tapAdConfig.mCustomController) == null || !tapAdCustomController.isCanUseAndroidId()) {
            return "";
        }
        try {
            b = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            b = "00000000";
            TapADLogger.d("get androidId fail error = " + e2.getMessage());
        }
        return b;
    }

    public static List<ResolveInfo> a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        return context.getPackageManager().queryIntentActivities(intent, 0);
    }

    public static void a(Context context, Callback<Location> callback) {
        boolean z;
        if (context == null) {
            callback.onFail(new RuntimeException("invalid params"));
            return;
        }
        try {
            if (a == null) {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                a = locationManager;
                if (locationManager == null) {
                    callback.onFail(new RuntimeException("request location service fail"));
                    return;
                }
            }
            f = new WeakReference<>(callback);
            boolean z2 = true;
            if (m.a(context, com.kuaishou.weapon.p0.g.g) && a.isProviderEnabled("gps")) {
                a.requestLocationUpdates("gps", 0L, 0.0f, e);
                z = true;
            } else {
                z = false;
            }
            if (g(context) && m.a(context, com.kuaishou.weapon.p0.g.h) && a.isProviderEnabled("network")) {
                a.requestLocationUpdates("network", 0L, 0.0f, e);
            } else {
                z2 = z;
            }
            if (z2) {
                return;
            }
            callback.onFail(new RuntimeException("no valid provider"));
        } catch (Exception e2) {
            TapADLogger.e("get location fail error : " + e2.getMessage());
            callback.onFail(e2);
        }
    }

    public static int[] b(Context context) {
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

    public static synchronized String c(Context context) {
        if (c) {
            return d;
        }
        String imei = "";
        try {
            if (!m.a(context)) {
                d = "";
                c = true;
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                if (Build.VERSION.SDK_INT <= 28 || telephonyManager.hasCarrierPrivileges()) {
                    imei = telephonyManager.getImei();
                } else {
                    TapADLogger.d("Can not get IMEI info.");
                }
            }
            d = imei;
            c = true;
            return imei;
        } catch (Exception e2) {
            TapADLogger.d(" get imei fail error = " + e2.getMessage());
        }
    }

    public static String d() {
        return Locale.getDefault().getCountry();
    }

    public static List<PackageInfo> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getInstalledPackages(5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String e() {
        String str = Build.MANUFACTURER;
        if (str == null || str.length() == 0) {
            return "";
        }
        return str.length() <= 40 ? str : str.substring(0, 40);
    }

    public static synchronized String e(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
    }

    public static String f() {
        String str = Build.MODEL;
        if (str == null || str.length() == 0) {
            return "";
        }
        return str.length() <= 40 ? str : str.substring(0, 40);
    }

    public static synchronized String f(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    public static String g() {
        try {
            return BluetoothAdapter.getDefaultAdapter().getName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean g(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }

    public static boolean h(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d;
    }

    public static long[] h() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSizeLong = statFs.getBlockSizeLong();
        return new long[]{statFs.getAvailableBlocksLong() * blockSizeLong, blockSizeLong * statFs.getBlockCountLong()};
    }

    public static String i() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "unknown" : str;
    }

    public static String j() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0044: MOVE (r4 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:25:0x0044 */
    public static long k() throws Throwable {
        RandomAccessFile randomAccessFile;
        IOException e2;
        RandomAccessFile randomAccessFile2;
        double d2;
        RandomAccessFile randomAccessFile3 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile("/proc/meminfo", com.kuaishou.weapon.p0.t.k);
                try {
                    Matcher matcher = Pattern.compile("(\\d+)").matcher(randomAccessFile.readLine());
                    String strGroup = "";
                    while (matcher.find()) {
                        strGroup = matcher.group(1);
                    }
                    randomAccessFile.close();
                    d2 = Double.parseDouble(strGroup);
                } catch (IOException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    d2 = 0.0d;
                    if (randomAccessFile != null) {
                    }
                    return (long) d2;
                }
            } catch (Throwable th) {
                th = th;
                randomAccessFile3 = randomAccessFile2;
                if (randomAccessFile3 != null) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            randomAccessFile = null;
            e2 = e4;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile3 != null) {
                randomAccessFile3.close();
            }
            throw th;
        }
        try {
            randomAccessFile.close();
        } catch (IOException unused2) {
        }
        return (long) d2;
    }

    public static boolean l() {
        return MediationConstant.ADN_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean m() {
        return System.getProperties().get("flag_running_in_sandbox") != null;
    }
}
