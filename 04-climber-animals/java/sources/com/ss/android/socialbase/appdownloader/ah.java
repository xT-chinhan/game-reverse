package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.anythink.dlopt.common.a.a;
import com.bykv.vk.component.ttvideo.player.C;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.ah.ch;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f4556ms;
    private static NotificationChannel xr;

    private static String ms(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d) + " " + str;
        }
        return new DecimalFormat("#").format(d) + " " + str;
    }

    public static String ms(long j) {
        return ms(j, true);
    }

    public static String ms(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, BaseConstants.MB_VALUE, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return ms(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    private static String ms(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d) + str;
        }
        return new DecimalFormat("#.##").format(d) + str;
    }

    public static String xr(long j) {
        long[] jArr = {1099511627776L, 1073741824, BaseConstants.MB_VALUE, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return ms(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static int ms(final Context context, final int i, final boolean z) {
        ch chVarAb = d.ch().ab();
        if (chVarAb == null) {
            return d(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        f4556ms = 1;
        chVarAb.ms(downloadInfo, new com.ss.android.socialbase.appdownloader.ah.ny() { // from class: com.ss.android.socialbase.appdownloader.ah.1
            @Override // com.ss.android.socialbase.appdownloader.ah.ny
            public void ms() {
                int unused = ah.f4556ms = ah.d(context, i, z);
            }
        });
        return f4556ms;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(Context context, int i, boolean z) {
        if (com.ss.android.socialbase.downloader.ab.ms.ms(i).xr("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.xr.ms().c(i);
        }
        ms((Activity) x.ms().xr());
        if (com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("install_queue_enable", 0) == 1) {
            return x.ms().ms(context, i, z);
        }
        return xr(context, i, z);
    }

    public static int xr(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.ah.xr(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ah.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.ch().hi();
                        int iMs = ah.ms(context, i, z, downloadInfo, file);
                        if (iMs == 1 && d.ch().h() != null) {
                            d.ch().h().ms(downloadInfo, null);
                        }
                        ah.xr(downloadInfo, z, iMs);
                    }
                });
                return 1;
            }
        }
        xr(downloadInfo, z, 2);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.socialbase.downloader.downloader.ah.fm().ms(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0064 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x007d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0092  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:69:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static int ms(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfoMs;
        int[] iArr;
        Intent intentMs;
        Process processExec;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                processExec = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    processExec.waitFor();
                    if (processExec != null) {
                        processExec.destroy();
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                        if (processExec != null) {
                        }
                        packageInfoMs = ms(downloadInfo, file);
                        if (packageInfoMs != null) {
                            try {
                                downloadInfo.setFilePackageName(packageInfoMs.packageName);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        th = null;
                        if (d.ch().ah() != null) {
                            if (packageInfoMs == null) {
                                BaseException baseException = new BaseException(2001, th);
                                d.ch().ah().ms(downloadInfo, baseException, baseException.getErrorCode());
                            } else {
                                d.ch().ah().ms(downloadInfo, null, 11);
                            }
                        }
                        if (ms(context, downloadInfo, packageInfoMs)) {
                            return 2;
                        }
                        if (packageInfoMs != null) {
                            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfoMs.packageName);
                            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfoMs.versionCode));
                        }
                        iArr = new int[1];
                        if (xr(context, downloadInfo, packageInfoMs)) {
                            intentMs = context.getPackageManager().getLaunchIntentForPackage(packageInfoMs.packageName);
                        } else {
                            if (z) {
                            }
                            intentMs = ms(context, downloadInfo, file, z, iArr);
                        }
                        if (intentMs == null) {
                            if (iArr[0] == 1) {
                                return 2;
                            }
                            return 0;
                        }
                        intentMs.addFlags(C.ENCODING_PCM_MU_LAW);
                        if (downloadInfo.getLinkMode() > 0) {
                            intentMs.putExtra("android.intent.extra.RETURN_RESULT", true);
                        }
                        if (iArr[0] == 0) {
                        }
                        return ms(context, intentMs);
                    } catch (Throwable th3) {
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                processExec = null;
            }
        }
        try {
            packageInfoMs = ms(downloadInfo, file);
            if (packageInfoMs != null) {
                downloadInfo.setFilePackageName(packageInfoMs.packageName);
            }
            th = null;
        } catch (Throwable th5) {
            th = th5;
            packageInfoMs = null;
        }
        if (d.ch().ah() != null) {
            if (packageInfoMs == null) {
                BaseException baseException2 = new BaseException(2001, th);
                d.ch().ah().ms(downloadInfo, baseException2, baseException2.getErrorCode());
            } else {
                d.ch().ah().ms(downloadInfo, null, 11);
            }
        }
        if (ms(context, downloadInfo, packageInfoMs)) {
            return 2;
        }
        if (packageInfoMs != null && com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfoMs.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfoMs.versionCode));
        }
        iArr = new int[1];
        if (xr(context, downloadInfo, packageInfoMs)) {
            intentMs = context.getPackageManager().getLaunchIntentForPackage(packageInfoMs.packageName);
        } else {
            if (z && ms(context, i, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            intentMs = ms(context, downloadInfo, file, z, iArr);
        }
        if (intentMs == null) {
            if (iArr[0] == 1) {
                return 2;
            }
            return 0;
        }
        intentMs.addFlags(C.ENCODING_PCM_MU_LAW);
        if (downloadInfo.getLinkMode() > 0 && com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("app_install_return_result", 0) == 1) {
            intentMs.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 || !xr.ms(context, downloadInfo, intentMs, z)) {
            return ms(context, intentMs);
        }
        return 1;
    }

    public static int ms(Context context, Intent intent) {
        try {
            if (d.ch().ao() != null && d.ch().ao().ms(intent)) {
                return 1;
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean ms(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.ah.d dVarXr = d.ch().xr();
        if (dVarXr != null) {
            dVarXr.ms(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (dVarXr.ms()) {
                return true;
            }
        }
        yu downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.ms(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.ah.ah ahVarMs = d.ch().ms();
        return (ahVarMs instanceof com.ss.android.socialbase.appdownloader.ah.ms) && ((com.ss.android.socialbase.appdownloader.ah.ms) ahVarMs).xr();
    }

    public static boolean ms(Context context, int i, File file) {
        if (com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.c.ka.zb() || com.ss.android.socialbase.appdownloader.c.ka.u()) && com.ss.android.socialbase.downloader.ny.ch.ms(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
        return false;
    }

    public static int ms() {
        return d.ch().c() ? 16384 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x0021, B:13:0x0027, B:14:0x002c), top: B:21:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x002c A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x0021, B:13:0x0027, B:14:0x002c), top: B:21:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Uri ms(int i, IDownloadFileUriProvider iDownloadFileUriProvider, Context context, String str, File file) {
        Uri uriFromFile;
        try {
            if (iDownloadFileUriProvider != null) {
                uriFromFile = iDownloadFileUriProvider.getUriForFile(str, file.getAbsolutePath());
            } else {
                com.ss.android.socialbase.appdownloader.ah.c cVarKa = d.ch().ka();
                if (cVarKa != null) {
                    uriFromFile = cVarKa.ms(i, str, file.getAbsolutePath());
                } else {
                    uriFromFile = null;
                }
                if (uriFromFile == null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            uriFromFile = FileProvider.getUriForFile(context, str, file);
                        } else {
                            uriFromFile = Uri.fromFile(file);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                }
                return uriFromFile;
            }
        } catch (Throwable unused) {
        }
        if (uriFromFile == null) {
            if (!TextUtils.isEmpty(str)) {
                uriFromFile = FileProvider.getUriForFile(context, str, file);
            } else {
                uriFromFile = Uri.fromFile(file);
            }
        }
        return uriFromFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static Intent ms(Context context, DownloadInfo downloadInfo, File file, boolean z, int[] iArr) {
        Uri uriMs = ms(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, d.ch().d(), file);
        if (uriMs == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriMs, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.ah.d dVarXr = d.ch().xr();
        boolean zMs = dVarXr != null ? dVarXr.ms(downloadInfo.getId(), z) : false;
        yu downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        ?? Ms = zMs;
        if (downloadNotificationEventListener != null) {
            Ms = downloadNotificationEventListener.ms(z);
        }
        iArr[0] = Ms;
        if (Ms != 0) {
            return null;
        }
        return intent;
    }

    public static boolean ms(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && ms(com.ss.android.socialbase.downloader.downloader.ah.k(), downloadInfo, str);
        }
        return true;
    }

    public static boolean ms(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                com.bytedance.sdk.openadsdk.api.ab.ka("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo packageInfoMs = ms(downloadInfo, file);
                if (packageInfoMs == null || !packageInfoMs.packageName.equals(str)) {
                    return false;
                }
                int i = packageInfoMs.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, ms());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("install_callback_error")) {
                    return false;
                }
                String strMs = com.ss.android.socialbase.downloader.ny.c.ms(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int iMs = com.ss.android.socialbase.downloader.ny.c.ms(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (strMs == null || TextUtils.isEmpty(strMs) || !strMs.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, ms());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || iMs != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    public static boolean xr(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return ms(context, downloadInfo, packageInfo, false);
    }

    public static boolean ms(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, ms());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        if (z) {
            return i < i2;
        }
        if (downloadInfo == null || com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("install_with_same_version_code", 0) != 1) {
            return i <= i2;
        }
        return i < i2;
    }

    public static boolean ms(Context context, DownloadInfo downloadInfo) {
        return ms(context, downloadInfo, true);
    }

    public static boolean ms(Context context, DownloadInfo downloadInfo, boolean z) {
        PackageInfo packageInfo;
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode > 0 || !z) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, ms());
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("install_with_same_version_code", 0) == 1) {
                return appVersionCode < packageInfo.versionCode;
            }
            return appVersionCode <= packageInfo.versionCode;
        }
        return ah(context, downloadInfo);
    }

    public static int xr(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo packageInfoMs = ms(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (packageInfoMs != null) {
                    int i = packageInfoMs.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static boolean ah(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return xr(context, downloadInfo, ms(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static PackageInfo ms(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        com.bytedance.sdk.openadsdk.api.ab.ka("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return ms(downloadInfo, file);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    public static String ms(String str, String str2, String str3, boolean z) {
        String lastPathSegment = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri uri = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(uri.getLastPathSegment()) || uri.getLastPathSegment().contains("..")) {
                    str2 = "default.apk";
                } else {
                    str2 = uri.getLastPathSegment();
                }
            }
        } else {
            if (!TextUtils.isEmpty(uri.getLastPathSegment()) && !uri.getLastPathSegment().contains("..")) {
                lastPathSegment = uri.getLastPathSegment();
            }
            if (!TextUtils.isEmpty(lastPathSegment)) {
                str2 = lastPathSegment;
            } else if (TextUtils.isEmpty(str2)) {
                str2 = "default.apk";
            }
        }
        return (!ah(str3) || str2.endsWith(a.h)) ? str2 : str2 + a.h;
    }

    public static String xr() {
        return com.ss.android.socialbase.downloader.ny.c.ka();
    }

    public static String ms(String str, com.ss.android.socialbase.downloader.ab.ms msVar) {
        JSONObject jSONObjectD;
        String str2;
        if (msVar == null || (jSONObjectD = msVar.d("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectD.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean("bind_app", false);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    public static boolean xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.optBoolean("bind_app", false) || !jSONObject.optBoolean("auto_install_with_notification", true);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    public static int ms(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    public static boolean ah(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0036 A[EXC_TOP_SPLITTER, PHI: r5
      0x0036: PHI (r5v3 android.content.res.TypedArray) = (r5v2 android.content.res.TypedArray), (r5v4 android.content.res.TypedArray) binds: [B:15:0x003b, B:11:0x0034] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static boolean ms(Context context) {
        TypedArray typedArrayObtainStyledAttributes;
        if (context == null) {
            return false;
        }
        try {
            int color = context.getResources().getColor(ka.xr());
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(ka.ka(), new int[]{ka.ah(), ka.d()});
            try {
                if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                    if (typedArrayObtainStyledAttributes != null) {
                        try {
                            typedArrayObtainStyledAttributes.recycle();
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
                if (typedArrayObtainStyledAttributes != null) {
                    try {
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Throwable unused2) {
                    }
                }
                return false;
            } catch (Throwable unused3) {
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        } catch (Throwable unused4) {
            typedArrayObtainStyledAttributes = null;
        }
    }

    public static String xr(Context context) {
        try {
            if (xr == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                xr = notificationChannel;
                notificationChannel.setSound(null, null);
                xr.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(xr);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        return "111111";
    }

    public static List<String> ah() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static void ms(DownloadInfo downloadInfo, boolean z, boolean z2) {
        d.ch().ms(new c(com.ss.android.socialbase.downloader.downloader.ah.k(), downloadInfo.getUrl()).ms(downloadInfo.getTitle()).xr(downloadInfo.getName()).ah(downloadInfo.getSavePath()).ms(downloadInfo.isShowNotification()).xr(downloadInfo.isAutoInstallWithoutNotification()).ah(downloadInfo.isOnlyWifi() || z2).ka(downloadInfo.getExtra()).c(downloadInfo.getMimeType()).ms(downloadInfo.getExtraHeaders()).ka(true).xr(downloadInfo.getRetryCount()).ah(downloadInfo.getBackUpUrlRetryCount()).xr(downloadInfo.getBackUpUrls()).d(downloadInfo.getMinProgressTimeMsInterval()).ka(downloadInfo.getMaxProgressCount()).c(z).d(downloadInfo.isNeedHttpsToHttpRetry()).ab(downloadInfo.getPackageName()).x(downloadInfo.getMd5()).ms(downloadInfo.getExpectFileLength()).ny(downloadInfo.isNeedDefaultHttpServiceBackUp()).ch(downloadInfo.isNeedReuseFirstConnection()).sl(downloadInfo.isNeedIndependentProcess()).ms(downloadInfo.getEnqueueType()).u(downloadInfo.isForce()).zb(downloadInfo.isHeadConnectionAvailable()).ab(downloadInfo.isNeedRetryDelay()).ny(downloadInfo.getRetryDelayTimeArray()).ms(d(downloadInfo.getDownloadSettingString())).hi(downloadInfo.getIconUrl()).c(downloadInfo.getExecutorGroup()).ao(downloadInfo.isAutoInstall()));
    }

    private static JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ms(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
    }

    public static PackageInfo ms(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.c.ms.ka.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), file, ms());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfoMs = com.ss.android.socialbase.appdownloader.c.ms.ka.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), file, ms());
        downloadInfo.setPackageInfo(packageInfoMs);
        return packageInfoMs;
    }

    public static int ms(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
