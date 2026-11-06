package com.byazt.rz;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.byazt.hj.DownloadModel;
import com.byazt.ky.cy;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static Object[] qg = new Object[0];
    public static Object[] s = new Object[73];
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String q = null;

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean qg(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static long n(JSONObject jSONObject, String str) {
        return com.byazt.es.qg.n(jSONObject, str);
    }

    public static JSONObject n(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.byazt.es.qg.n(jSONObject, jSONObject2);
    }

    public static JSONObject n(JSONObject jSONObject) {
        return com.byazt.es.qg.n(jSONObject);
    }

    public static JSONObject n(JSONObject... jSONObjectArr) {
        return com.byazt.es.qg.n(jSONObjectArr);
    }

    public static boolean n(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            return (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) ? false : true;
        } catch (Exception unused) {
        }
    }

    public static String n(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        }
        if (j >= 1048576) {
            return (j / 1048576) + "M";
        }
        return decimalFormat.format(j / 1048576.0f) + "M";
    }

    public static PackageInfo n(com.byazt.h.qg qgVar) {
        DownloadInfo downloadInfo;
        if (qgVar == null || (downloadInfo = Downloader.getInstance(com.byazt.ug.d.getContext()).getDownloadInfo(qgVar.um())) == null) {
            return null;
        }
        try {
            return com.byazt.e.s.n(com.byazt.ug.d.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable n(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static int qg(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static String s(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Drawable q(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean l(Context context, String str) {
        if (context == null) {
            context = com.byazt.ug.d.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static com.byazt.vl.s n(String str, int i, String str2) {
        com.byazt.vl.s sVar = new com.byazt.vl.s();
        if (TextUtils.isEmpty(str)) {
            return sVar;
        }
        try {
            PackageInfo packageInfo = com.byazt.ug.d.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                sVar.qg(packageInfo.versionCode);
                sVar.n(com.byazt.vl.s.qg);
                cy cyVarX = com.byazt.ug.d.x();
                if (cyVarX != null && cyVarX.n() && !n(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    sVar.n(com.byazt.vl.s.s);
                }
            }
        } catch (Exception e) {
            com.byazt.fe.n.l("ToolUtils", "getInstalledAppInfo:" + e.getMessage());
        }
        return sVar;
    }

    private static boolean n(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || n(str, str2) >= 0;
    }

    public static boolean qg(com.byazt.h.qg qgVar) {
        if (qgVar == null) {
            return false;
        }
        return n(qgVar.l(), qgVar.ae(), qgVar.f()).n();
    }

    public static boolean n(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return n(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).n();
    }

    public static boolean qg(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.byazt.ug.d.getContext();
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static boolean n(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            return packageInfo != null && i == packageInfo.versionCode;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean w(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            return packageInfo != null && i <= packageInfo.versionCode;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static Intent x(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
        return launchIntentForPackage;
    }

    public static Signature[] fs(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Signature[] rv(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean n(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            Signature signature = signatureArr[i];
            if ((signature == null && signatureArr2[i] != null) || (signature != null && !signature.equals(signatureArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(String str) {
        File file;
        Context context = com.byazt.ug.d.getContext();
        if (TextUtils.isEmpty(str) || !l(context, str)) {
            return false;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        if (com.byazt.ug.d.rv().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.byazt.ug.d.rv().optInt("get_ext_dir_mode") == 1) {
                file = tj(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/".concat(String.valueOf(str)));
            }
            if (!file.exists()) {
                return false;
            }
            long jN = x.n(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null && packageInfo.lastUpdateTime < jN;
        } catch (Exception unused) {
            return true;
        }
    }

    public static File tj(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        com.byazt.fe.n.qg("ToolUtils", "getExtDir: file.toString()-->" + file.toString());
        return file;
    }

    public static int n(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String n(String str, int i) {
        if (i == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static int n(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                int i = 0;
                int i2 = 0;
                while (i < iMin) {
                    i2 = Integer.parseInt(strArrSplit[i]) - Integer.parseInt(strArrSplit2[i]);
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                }
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
                for (int i3 = i; i3 < strArrSplit.length; i3++) {
                    if (Integer.parseInt(strArrSplit[i3]) > 0) {
                        return 1;
                    }
                }
                while (i < strArrSplit2.length) {
                    if (Integer.parseInt(strArrSplit2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String n(String... strArr) {
        return com.byazt.es.qg.n(strArr);
    }

    public static <T> T n(T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("args is null");
        }
        for (T t : tArr) {
            if (t != null) {
                return t;
            }
        }
        throw new IllegalArgumentException("args is null");
    }

    public static long qg(long j) {
        try {
            return n(Environment.getExternalStorageDirectory(), j);
        } catch (Exception unused) {
            return j;
        }
    }

    public static boolean n() {
        try {
            return com.byazt.ug.d.getContext().getPackageManager().getPackageInfo(com.byazt.ug.d.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static long n(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return com.byazt.ta.w.q(file.getAbsolutePath());
        } catch (Exception unused) {
            return j;
        }
    }

    public static long n(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            return new StatFs(file.getAbsolutePath()).getTotalBytes();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static boolean qg() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void n(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException unused) {
        }
    }

    public static void s() {
        try {
            if (com.byazt.ug.d.l().n(com.byazt.ug.d.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.byazt.ug.d.getContext().getSystemService("activity");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.byazt.ug.d.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static HashMap<String, String> qg(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.optString(next));
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }
}
