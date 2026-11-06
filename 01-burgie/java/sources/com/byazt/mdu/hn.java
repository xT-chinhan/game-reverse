package com.byazt.mdu;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.ca.ho;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.b;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.mrs.DownloadStatus;
import com.byazt.zkm.vk;
import com.byazt.zkm.w;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 20})
public class hn {
    public static NotificationChannel hw = null;
    public static int pr;

    private static String pr(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        return (z || "GB".equals(str) || "TB".equals(str)) ? new DecimalFormat("#.##").format(d) + " " + str : new DecimalFormat("#").format(d) + " " + str;
    }

    public static String pr(long j) {
        return pr(j, true);
    }

    public static String pr(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return pr(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    public static int pr(final Context context, final int i, final boolean z) {
        w wVarZo = x.w().zo();
        if (wVarZo == null) {
            return x(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        pr = 1;
        wVarZo.pr(downloadInfo, new vk() { // from class: com.byazt.mdu.hn.1
            @Override // com.byazt.zkm.vk
            public void pr() {
                int unused = hn.pr = hn.x(context, i, z);
            }
        });
        return pr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x(Context context, int i, boolean z) {
        if (com.byazt.ew.pr.pr(i).hw("notification_opt_2") == 1) {
            com.byazt.lxs.hw.pr().uc(i);
        }
        pr((Activity) fw.pr().hw());
        if (com.byazt.ew.pr.pr(i).pr("install_queue_enable", 0) == 1) {
            return fw.pr().pr(context, i, z);
        }
        return hw(context, i, z);
    }

    public static int hw(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.byazt.lj.hn.hw(new Runnable() { // from class: com.byazt.mdu.hn.2
                    @Override // java.lang.Runnable
                    public void run() {
                        x.w().k();
                        int iPr = hn.pr(context, i, z, downloadInfo, file);
                        if (iPr == 1 && x.w().yb() != null) {
                            x.w().yb().pr(downloadInfo, null);
                        }
                        hn.hw(downloadInfo, z, iPr);
                    }
                });
                return 1;
            }
        }
        hw(downloadInfo, z, 2);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e) {
        }
        com.byazt.lj.hn.i().pr(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003b A[PHI: r0
      0x003b: PHI (r0v5 java.lang.Process) = (r0v4 java.lang.Process), (r0v9 java.lang.Process) binds: [B:12:0x0039, B:6:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    public static int pr(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        Process processExec;
        PackageInfo packageInfoPr;
        Intent intentPr;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                processExec = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    processExec.waitFor();
                    if (processExec != null) {
                        processExec.destroy();
                    }
                } catch (Throwable th) {
                    if (processExec != null) {
                        processExec.destroy();
                    }
                }
            } catch (Throwable th2) {
                processExec = null;
            }
        }
        try {
            packageInfoPr = pr(downloadInfo, file);
            if (packageInfoPr != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfoPr.packageName);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            th = null;
        } catch (Throwable th4) {
            th = th4;
            packageInfoPr = null;
        }
        if (x.w().x() != null) {
            if (packageInfoPr == null) {
                BaseException baseException = new BaseException(2001, th);
                x.w().x().pr(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                x.w().x().pr(downloadInfo, null, 11);
            }
        }
        if (pr(context, downloadInfo, packageInfoPr)) {
            return 2;
        }
        if (packageInfoPr != null && com.byazt.ew.pr.pr(downloadInfo.getId()).pr("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfoPr.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfoPr.versionCode));
        }
        int[] iArr = new int[1];
        if (hw(context, downloadInfo, packageInfoPr)) {
            intentPr = context.getPackageManager().getLaunchIntentForPackage(packageInfoPr.packageName);
        } else {
            if (!z && pr(context, i, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            intentPr = pr(context, downloadInfo, file, z, iArr);
        }
        if (intentPr == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        intentPr.addFlags(C.ENCODING_PCM_MU_LAW);
        if (downloadInfo.getLinkMode() > 0 && com.byazt.ew.pr.pr(downloadInfo.getId()).pr("app_install_return_result", 0) == 1) {
            intentPr.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && hw.pr(context, downloadInfo, intentPr, z)) {
            return 1;
        }
        return pr(context, intentPr);
    }

    public static int pr(Context context, Intent intent) {
        try {
            if (x.w().nt() != null && x.w().nt().pr(intent)) {
                return 1;
            }
        } catch (Throwable th) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable th2) {
            return 0;
        }
    }

    public static boolean pr(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo != null && !packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            com.byazt.zkm.c cVarHn = x.w().hn();
            if (cVarHn != null) {
                cVarHn.pr(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
                if (cVarHn.pr()) {
                    return true;
                }
            }
            b downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
            if (downloadNotificationEventListener != null) {
                downloadNotificationEventListener.pr(8, downloadInfo, packageInfo.packageName, "");
                com.byazt.zkm.x xVarHw = x.w().hw();
                if ((xVarHw instanceof com.byazt.zkm.pr) && ((com.byazt.zkm.pr) xVarHw).hw()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean pr(Context context, int i, File file) {
        if (com.byazt.ew.pr.pr(i).pr("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((!com.byazt.now.c.m() && !com.byazt.now.c.g()) || !com.byazt.tuy.vk.pr(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            return false;
        }
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
            return false;
        }
    }

    public static int pr() {
        return x.w().fw() ? 16384 : 0;
    }

    public static Uri pr(int i, IDownloadFileUriProvider iDownloadFileUriProvider, Context context, String str, File file) {
        Uri uriForFile;
        if (iDownloadFileUriProvider != null) {
            try {
                uriForFile = iDownloadFileUriProvider.getUriForFile(str, file.getAbsolutePath());
            } catch (Throwable th) {
                uriForFile = null;
            }
        } else {
            com.byazt.zkm.fw fwVarUc = x.w().uc();
            if (fwVarUc != null) {
                try {
                    uriForFile = fwVarUc.pr(i, str, file.getAbsolutePath());
                } catch (Throwable th2) {
                    uriForFile = null;
                }
            } else {
                uriForFile = null;
            }
        }
        if (uriForFile == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
                    uriForFile = FileProvider.getUriForFile(context, str, file);
                } else {
                    uriForFile = Uri.fromFile(file);
                }
            } catch (Throwable th3) {
            }
        }
        return uriForFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static Intent pr(Context context, DownloadInfo downloadInfo, File file, boolean z, int[] iArr) {
        boolean zPr;
        Uri uriPr = pr(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, x.w().c(), file);
        if (uriPr == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uriPr, AdBaseConstants.MIME_APK);
        com.byazt.zkm.c cVarHn = x.w().hn();
        if (cVarHn == null) {
            zPr = false;
        } else {
            zPr = cVarHn.pr(downloadInfo.getId(), z);
        }
        b downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        ?? Pr = zPr;
        if (downloadNotificationEventListener != null) {
            Pr = downloadNotificationEventListener.pr(z);
        }
        iArr[0] = Pr;
        if (Pr != 0) {
            return null;
        }
        return intent;
    }

    public static boolean pr(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && pr(com.byazt.lj.hn.of(), downloadInfo, str);
        }
        return true;
    }

    public static boolean pr(Context context, DownloadInfo downloadInfo, String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                ho.hw("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo packageInfoPr = pr(downloadInfo, file);
                if (packageInfoPr == null || !packageInfoPr.packageName.equals(str)) {
                    return false;
                }
                int i = packageInfoPr.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, pr());
                } catch (PackageManager.NameNotFoundException e) {
                }
                if (packageInfo == null) {
                    return false;
                }
                if (i == packageInfo.versionCode) {
                    z = true;
                }
                return z;
            }
            if (!com.byazt.ew.pr.pr(downloadInfo.getId()).pr("install_callback_error")) {
                return false;
            }
            String strPr = com.byazt.tuy.uc.pr(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
            int iPr = com.byazt.tuy.uc.pr(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
            if (strPr == null || TextUtils.isEmpty(strPr) || !strPr.equals(str)) {
                return false;
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, pr());
            } catch (PackageManager.NameNotFoundException e2) {
            }
            return packageInfo != null && iPr == packageInfo.versionCode;
        } catch (Exception e3) {
            return false;
        }
    }

    public static boolean hw(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return pr(context, downloadInfo, packageInfo, false);
    }

    public static boolean pr(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
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
            packageInfo2 = context.getPackageManager().getPackageInfo(str, pr());
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        if (z) {
            if (i >= i2) {
                return false;
            }
            return true;
        }
        if (downloadInfo != null && com.byazt.ew.pr.pr(downloadInfo.getId()).pr("install_with_same_version_code", 0) == 1) {
            if (i >= i2) {
                return false;
            }
            return true;
        }
        if (i > i2) {
            return false;
        }
        return true;
    }

    public static boolean pr(Context context, DownloadInfo downloadInfo) {
        return pr(context, downloadInfo, true);
    }

    public static boolean pr(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode > 0 || !z) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, pr());
            } catch (PackageManager.NameNotFoundException e) {
            }
            if (packageInfo == null) {
                return false;
            }
            if (com.byazt.ew.pr.pr(downloadInfo.getId()).pr("install_with_same_version_code", 0) == 1) {
                return appVersionCode < packageInfo.versionCode;
            }
            return appVersionCode <= packageInfo.versionCode;
        }
        return hn(context, downloadInfo);
    }

    public static int hw(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return 0;
        }
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode > 0) {
            return appVersionCode;
        }
        try {
            PackageInfo packageInfoPr = pr(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
            if (packageInfoPr != null) {
                int i = packageInfoPr.versionCode;
                downloadInfo.setAppVersionCode(i);
                return i;
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    public static boolean hn(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return hw(context, downloadInfo, pr(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static PackageInfo pr(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        ho.hw("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return pr(downloadInfo, file);
    }

    public static String pr(String str, String str2, String str3, boolean z) {
        String lastPathSegment = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri uri = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                str2 = (TextUtils.isEmpty(uri.getLastPathSegment()) || uri.getLastPathSegment().contains("..")) ? "default.apk" : uri.getLastPathSegment();
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
        if (hn(str3) && !str2.endsWith(".apk")) {
            return str2 + ".apk";
        }
        return str2;
    }

    public static String hw() {
        return com.byazt.tuy.uc.c();
    }

    public static String pr(String str, com.byazt.ew.pr prVar) {
        JSONObject jSONObjectX;
        if (prVar != null && (jSONObjectX = prVar.x("download_dir")) != null) {
            String strOptString = jSONObjectX.optString("dir_name");
            if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
                strOptString = strOptString.substring(1);
            }
            if (TextUtils.isEmpty(strOptString)) {
                return strOptString;
            }
            if (!strOptString.contains("%s")) {
                strOptString = strOptString + str;
            } else {
                try {
                    strOptString = String.format(strOptString, str);
                } catch (Throwable th) {
                }
            }
            return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
        }
        return "";
    }

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean("bind_app", false);
        } catch (JSONException e) {
        }
    }

    public static boolean hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.optBoolean("bind_app", false) || !jSONObject.optBoolean("auto_install_with_notification", true);
        } catch (JSONException e) {
        }
    }

    public static int pr(int i) {
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
        if (!DownloadStatus.isDownloadOver(i)) {
            return 0;
        }
        return 3;
    }

    public static boolean hn(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static String pr(Context context) {
        try {
            if (hw == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                hw = notificationChannel;
                notificationChannel.setSound(null, null);
                hw.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(hw);
            }
        } catch (Throwable th) {
        }
        return "111111";
    }

    public static List<String> hn() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static void pr(DownloadInfo downloadInfo, boolean z, boolean z2) {
        x.w().pr(new c(com.byazt.lj.hn.of(), downloadInfo.getUrl()).pr(downloadInfo.getTitle()).hw(downloadInfo.getName()).hn(downloadInfo.getSavePath()).pr(downloadInfo.isShowNotification()).hw(downloadInfo.isAutoInstallWithoutNotification()).hn(downloadInfo.isOnlyWifi() || z2).c(downloadInfo.getExtra()).uc(downloadInfo.getMimeType()).pr(downloadInfo.getExtraHeaders()).c(true).hw(downloadInfo.getRetryCount()).hn(downloadInfo.getBackUpUrlRetryCount()).hw(downloadInfo.getBackUpUrls()).x(downloadInfo.getMinProgressTimeMsInterval()).c(downloadInfo.getMaxProgressCount()).uc(z).x(downloadInfo.isNeedHttpsToHttpRetry()).fw(downloadInfo.getPackageName()).zo(downloadInfo.getMd5()).pr(downloadInfo.getExpectFileLength()).aj(downloadInfo.isNeedDefaultHttpServiceBackUp()).vk(downloadInfo.isNeedReuseFirstConnection()).k(downloadInfo.isNeedIndependentProcess()).pr(downloadInfo.getEnqueueType()).g(downloadInfo.isForce()).m(downloadInfo.isHeadConnectionAvailable()).fw(downloadInfo.isNeedRetryDelay()).aj(downloadInfo.getRetryDelayTimeArray()).pr(x(downloadInfo.getDownloadSettingString())).w(downloadInfo.getIconUrl()).uc(downloadInfo.getExecutorGroup()).nt(downloadInfo.isAutoInstall()));
    }

    private static JSONObject x(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public static void pr(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        } catch (Exception e) {
        }
    }

    public static PackageInfo pr(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.byazt.pwu.c.pr(com.byazt.lj.hn.of(), file, pr());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo == null) {
            PackageInfo packageInfoPr = com.byazt.pwu.c.pr(com.byazt.lj.hn.of(), file, pr());
            downloadInfo.setPackageInfo(packageInfoPr);
            return packageInfoPr;
        }
        return packageInfo;
    }

    public static int pr(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
