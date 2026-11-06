package com.byazt.uk;

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
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadModel;
import com.byazt.lj.Downloader;
import com.byazt.ol.TTDownloadField;
import com.byazt.zv.nt;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 108})
public class m {
    public static Object[] hw = new Object[0];
    public static Object[] hn = new Object[73];
    public static final char[] pr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String x = null;

    public static boolean pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new File(str).exists();
        }
        return false;
    }

    public static boolean hw(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static long pr(JSONObject jSONObject, String str) {
        return com.byazt.snv.hw.pr(jSONObject, str);
    }

    public static JSONObject pr(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.byazt.snv.hw.pr(jSONObject, jSONObject2);
    }

    public static JSONObject pr(JSONObject jSONObject) {
        return com.byazt.snv.hw.pr(jSONObject);
    }

    public static JSONObject pr(JSONObject... jSONObjectArr) {
        return com.byazt.snv.hw.pr(jSONObjectArr);
    }

    public static boolean pr(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            return (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String pr(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        }
        if (j >= 1048576) {
            return (j / 1048576) + "M";
        }
        return decimalFormat.format(j / 1048576.0f) + "M";
    }

    public static PackageInfo pr(com.byazt.tia.hw hwVar) {
        DownloadInfo downloadInfo;
        if (hwVar == null || (downloadInfo = Downloader.getInstance(com.byazt.eld.k.getContext()).getDownloadInfo(hwVar.qa())) == null) {
            return null;
        }
        try {
            return com.byazt.mdu.hn.pr(com.byazt.eld.k.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable th) {
            return null;
        }
    }

    public static Drawable pr(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static int hw(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
                return -1;
            } catch (PackageManager.NameNotFoundException e) {
                return -1;
            }
        }
        return -1;
    }

    public static String hn(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
                return "";
            } catch (PackageManager.NameNotFoundException e) {
                return "";
            }
        }
        return "";
    }

    public static Drawable x(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return null;
    }

    public static boolean c(Context context, String str) {
        if (context == null) {
            context = com.byazt.eld.k.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static com.byazt.shh.hn pr(String str, int i, String str2) {
        com.byazt.shh.hn hnVar = new com.byazt.shh.hn();
        if (TextUtils.isEmpty(str)) {
            return hnVar;
        }
        try {
            PackageInfo packageInfo = com.byazt.eld.k.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                hnVar.hw(packageInfo.versionCode);
                hnVar.pr(com.byazt.shh.hn.hw);
                nt ntVarFw = com.byazt.eld.k.fw();
                if (ntVarFw != null && ntVarFw.pr() && !pr(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    hnVar.pr(com.byazt.shh.hn.hn);
                }
            }
        } catch (Exception e) {
            com.byazt.p000do.pr.c("ToolUtils", "getInstalledAppInfo:" + e.getMessage());
        }
        return hnVar;
    }

    private static boolean pr(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        if ((i2 > 0 && i >= i2) || pr(str, str2) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean hw(com.byazt.tia.hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        return pr(hwVar.c(), hwVar.s(), hwVar.ls()).pr();
    }

    public static boolean pr(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return pr(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).pr();
    }

    public static boolean hw(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.byazt.eld.k.getContext();
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static boolean pr(Context context, String str, String str2) {
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
            } catch (PackageManager.NameNotFoundException e) {
                packageInfo = null;
            }
            if (packageInfo == null || i != packageInfo.versionCode) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean uc(Context context, String str) {
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
            } catch (PackageManager.NameNotFoundException e) {
                packageInfo = null;
            }
            if (packageInfo == null || i > packageInfo.versionCode) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static Intent fw(Context context, String str) {
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

    public static Signature[] zo(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Signature[] aj(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean pr(Signature[] signatureArr, Signature[] signatureArr2) {
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

    public static boolean hn(String str) {
        File file;
        Context context = com.byazt.eld.k.getContext();
        if (TextUtils.isEmpty(str) || !c(context, str)) {
            return false;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        if (com.byazt.eld.k.aj().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.byazt.eld.k.aj().optInt("get_ext_dir_mode") == 1) {
                file = vk(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/".concat(String.valueOf(str)));
            }
            if (!file.exists()) {
                return false;
            }
            long jPr = fw.pr(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null && packageInfo.lastUpdateTime < jPr;
        } catch (Exception e) {
            return true;
        }
    }

    public static File vk(Context context, String str) {
        String parent = null;
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        if (parentFile != null) {
            parent = parentFile.getParent();
        }
        File file = new File(parent + File.separator + str);
        com.byazt.p000do.pr.hw("ToolUtils", "getExtDir: file.toString()-->" + file.toString());
        return file;
    }

    public static int pr(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String pr(String str, int i) {
        if (i == 0) {
            return "";
        }
        if (TextUtils.isEmpty(str) || str.length() <= i) {
            return str;
        }
        return str.substring(0, i);
    }

    public static int pr(String str, String str2) {
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
            return -2;
        } catch (Exception e) {
            return -2;
        }
    }

    public static String pr(String... strArr) {
        return com.byazt.snv.hw.pr(strArr);
    }

    public static <T> T pr(T... tArr) {
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

    public static long hw(long j) {
        try {
            return pr(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e) {
            return j;
        }
    }

    public static boolean pr() {
        try {
            return com.byazt.eld.k.getContext().getPackageManager().getPackageInfo(com.byazt.eld.k.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static long pr(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return com.byazt.tuy.uc.x(file.getAbsolutePath());
        } catch (Exception e) {
            return j;
        }
    }

    public static long pr(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT < 18) {
                return -1L;
            }
            return statFs.getTotalBytes();
        } catch (Throwable th) {
            return -1L;
        }
    }

    public static boolean hw() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void pr(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e) {
        }
    }

    public static void hn() {
        try {
            if (!com.byazt.eld.k.c().pr(com.byazt.eld.k.getContext(), "android.permission.REORDER_TASKS")) {
                return;
            }
            ActivityManager activityManager = (ActivityManager) com.byazt.eld.k.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                if (com.byazt.eld.k.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                    activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                    return;
                }
            }
        } catch (Exception e) {
        }
    }

    public static HashMap<String, String> hw(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.optString(next));
                }
                return map;
            } catch (Exception e) {
            }
        }
        return map;
    }
}
