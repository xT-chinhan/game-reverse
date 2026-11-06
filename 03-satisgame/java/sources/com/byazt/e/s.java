package com.byazt.e;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.anythink.china.a.c;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.h;
import com.byazt.q.AdBaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.sk.DownloadStatus;
import com.byazt.tk.k;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.z.cp;
import com.byazt.z.tj;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.varbto.utils.api.UtilConst;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 8})
public class s {
    public static int n;
    public static NotificationChannel qg;

    private static String n(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d) + " " + str;
        }
        return new DecimalFormat("#").format(d) + " " + str;
    }

    public static String n(long j) {
        return n(j, true);
    }

    public static String n(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, c.k, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", UtilConst.CRASH_CAT_B};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return n(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    public static int n(final Context context, final int i, final boolean z) {
        cp cpVarFs = q.cp().fs();
        if (cpVarFs == null) {
            return q(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        n = 1;
        cpVarFs.n(downloadInfo, new tj() { // from class: com.byazt.e.s.1
            @Override // com.byazt.z.tj
            public void n() {
                int unused = s.n = s.q(context, i, z);
            }
        });
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(Context context, int i, boolean z) {
        if (com.byazt.f.n.n(i).qg("notification_opt_2") == 1) {
            com.byazt.av.qg.n().w(i);
        }
        n((Activity) x.n().qg());
        if (com.byazt.f.n.n(i).n("install_queue_enable", 0) == 1) {
            return x.n().n(context, i, z);
        }
        return qg(context, i, z);
    }

    public static int qg(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.byazt.xv.s.qg(new Runnable() { // from class: com.byazt.e.s.2
                    @Override // java.lang.Runnable
                    public void run() {
                        q.cp().d();
                        int iN = s.n(context, i, z, downloadInfo, file);
                        if (iN == 1 && q.cp().hd() != null) {
                            q.cp().hd().n(downloadInfo, null);
                        }
                        s.qg(downloadInfo, z, iN);
                    }
                });
                return 1;
            }
        }
        qg(downloadInfo, z, 2);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception unused) {
        }
        com.byazt.xv.s.wo().n(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0058  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0083 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0084  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00df  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:64:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static int n(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfoN;
        int[] iArr;
        Intent intentN;
        Process processExec;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                processExec = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    processExec.waitFor();
                    if (processExec != null) {
                        processExec.destroy();
                    }
                } catch (Throwable unused) {
                    if (processExec != null) {
                    }
                    packageInfoN = n(downloadInfo, file);
                    if (packageInfoN != null) {
                        try {
                            downloadInfo.setFilePackageName(packageInfoN.packageName);
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                    th = null;
                    if (q.cp().q() != null) {
                        if (packageInfoN == null) {
                            BaseException baseException = new BaseException(2001, th);
                            q.cp().q().n(downloadInfo, baseException, baseException.getErrorCode());
                        } else {
                            q.cp().q().n(downloadInfo, null, 11);
                        }
                    }
                    if (n(context, downloadInfo, packageInfoN)) {
                        return 2;
                    }
                    if (packageInfoN != null) {
                        downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfoN.packageName);
                        downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfoN.versionCode));
                    }
                    iArr = new int[1];
                    if (qg(context, downloadInfo, packageInfoN)) {
                        intentN = context.getPackageManager().getLaunchIntentForPackage(packageInfoN.packageName);
                    } else {
                        if (z) {
                        }
                        intentN = n(context, downloadInfo, file, z, iArr);
                    }
                    if (intentN == null) {
                        if (iArr[0] == 1) {
                            return 2;
                        }
                        return 0;
                    }
                    intentN.addFlags(C.ENCODING_PCM_MU_LAW);
                    if (downloadInfo.getLinkMode() > 0) {
                        intentN.putExtra("android.intent.extra.RETURN_RESULT", true);
                    }
                    if (iArr[0] == 0) {
                    }
                    return n(context, intentN);
                }
            } catch (Throwable unused2) {
                processExec = null;
            }
        }
        try {
            packageInfoN = n(downloadInfo, file);
            if (packageInfoN != null) {
                downloadInfo.setFilePackageName(packageInfoN.packageName);
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
            packageInfoN = null;
        }
        if (q.cp().q() != null) {
            if (packageInfoN == null) {
                BaseException baseException2 = new BaseException(2001, th);
                q.cp().q().n(downloadInfo, baseException2, baseException2.getErrorCode());
            } else {
                q.cp().q().n(downloadInfo, null, 11);
            }
        }
        if (n(context, downloadInfo, packageInfoN)) {
            return 2;
        }
        if (packageInfoN != null && com.byazt.f.n.n(downloadInfo.getId()).n("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfoN.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfoN.versionCode));
        }
        iArr = new int[1];
        if (qg(context, downloadInfo, packageInfoN)) {
            intentN = context.getPackageManager().getLaunchIntentForPackage(packageInfoN.packageName);
        } else {
            if (z && n(context, i, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            intentN = n(context, downloadInfo, file, z, iArr);
        }
        if (intentN == null) {
            if (iArr[0] == 1) {
                return 2;
            }
            return 0;
        }
        intentN.addFlags(C.ENCODING_PCM_MU_LAW);
        if (downloadInfo.getLinkMode() > 0 && com.byazt.f.n.n(downloadInfo.getId()).n("app_install_return_result", 0) == 1) {
            intentN.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 || !qg.n(context, downloadInfo, intentN, z)) {
            return n(context, intentN);
        }
        return 1;
    }

    public static int n(Context context, Intent intent) {
        try {
            if (q.cp().cy() != null && q.cp().cy().n(intent)) {
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

    public static boolean n(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.byazt.z.l lVarS = q.cp().s();
        if (lVarS != null) {
            lVarS.n(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (lVarS.n()) {
                return true;
            }
        }
        h downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.n(8, downloadInfo, packageInfo.packageName, "");
        com.byazt.z.q qVarQg = q.cp().qg();
        return (qVarQg instanceof com.byazt.z.n) && ((com.byazt.z.n) qVarQg).qg();
    }

    public static boolean n(Context context, int i, File file) {
        if (com.byazt.f.n.n(i).n("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.byazt.bk.l.oa() || com.byazt.bk.l.sz()) && com.byazt.ta.tj.n(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
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
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static int n() {
        return q.cp().x() ? 16384 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:11:0x0021, B:13:0x0027, B:14:0x002c), top: B:19:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x002c A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:11:0x0021, B:13:0x0027, B:14:0x002c), top: B:19:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Uri n(int i, IDownloadFileUriProvider iDownloadFileUriProvider, Context context, String str, File file) {
        Uri uriFromFile;
        try {
            if (iDownloadFileUriProvider != null) {
                uriFromFile = iDownloadFileUriProvider.getUriForFile(str, file.getAbsolutePath());
            } else {
                com.byazt.z.x xVarW = q.cp().w();
                if (xVarW != null) {
                    uriFromFile = xVarW.n(i, str, file.getAbsolutePath());
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
                    } catch (Throwable unused) {
                    }
                }
                return uriFromFile;
            }
        } catch (Throwable unused2) {
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
    private static Intent n(Context context, DownloadInfo downloadInfo, File file, boolean z, int[] iArr) {
        Uri uriN = n(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, q.cp().l(), file);
        if (uriN == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriN, AdBaseConstants.MIME_APK);
        com.byazt.z.l lVarS = q.cp().s();
        boolean zN = lVarS != null ? lVarS.n(downloadInfo.getId(), z) : false;
        h downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        ?? N = zN;
        if (downloadNotificationEventListener != null) {
            N = downloadNotificationEventListener.n(z);
        }
        iArr[0] = N;
        if (N != 0) {
            return null;
        }
        return intent;
    }

    public static boolean n(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && n(com.byazt.xv.s.u(), downloadInfo, str);
        }
        return true;
    }

    public static boolean n(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                k.qg("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo packageInfoN = n(downloadInfo, file);
                if (packageInfoN == null || !packageInfoN.packageName.equals(str)) {
                    return false;
                }
                int i = packageInfoN.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, n());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.byazt.f.n.n(downloadInfo.getId()).n("install_callback_error")) {
                    return false;
                }
                String strN = com.byazt.ta.w.n(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int iN = com.byazt.ta.w.n(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (strN == null || TextUtils.isEmpty(strN) || !strN.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, n());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || iN != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused3) {
            return false;
        }
    }

    public static boolean qg(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return n(context, downloadInfo, packageInfo, false);
    }

    public static boolean n(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
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
            packageInfo2 = context.getPackageManager().getPackageInfo(str, n());
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
        if (downloadInfo == null || com.byazt.f.n.n(downloadInfo.getId()).n("install_with_same_version_code", 0) != 1) {
            return i <= i2;
        }
        return i < i2;
    }

    public static boolean n(Context context, DownloadInfo downloadInfo) {
        return n(context, downloadInfo, true);
    }

    public static boolean n(Context context, DownloadInfo downloadInfo, boolean z) {
        PackageInfo packageInfo;
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode > 0 || !z) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, n());
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            if (com.byazt.f.n.n(downloadInfo.getId()).n("install_with_same_version_code", 0) == 1) {
                return appVersionCode < packageInfo.versionCode;
            }
            return appVersionCode <= packageInfo.versionCode;
        }
        return s(context, downloadInfo);
    }

    public static int qg(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo packageInfoN = n(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (packageInfoN != null) {
                    int i = packageInfoN.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static boolean s(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return qg(context, downloadInfo, n(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static PackageInfo n(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        k.qg("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return n(downloadInfo, file);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    public static String n(String str, String str2, String str3, boolean z) {
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
        return (!s(str3) || str2.endsWith(".apk")) ? str2 : str2 + ".apk";
    }

    public static String qg() {
        return com.byazt.ta.w.l();
    }

    public static String n(String str, com.byazt.f.n nVar) {
        JSONObject jSONObjectQ;
        String str2;
        if (nVar == null || (jSONObjectQ = nVar.q("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectQ.optString("dir_name");
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

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean("bind_app", false);
        } catch (JSONException unused) {
        }
    }

    public static boolean qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.optBoolean("bind_app", false) || !jSONObject.optBoolean("auto_install_with_notification", true);
        } catch (JSONException unused) {
        }
    }

    public static int n(int i) {
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

    public static boolean s(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static String n(Context context) {
        try {
            if (qg == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                qg = notificationChannel;
                notificationChannel.setSound(null, null);
                qg.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(qg);
            }
        } catch (Throwable unused) {
        }
        return "111111";
    }

    public static List<String> s() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static void n(DownloadInfo downloadInfo, boolean z, boolean z2) {
        q.cp().n(new l(com.byazt.xv.s.u(), downloadInfo.getUrl()).n(downloadInfo.getTitle()).qg(downloadInfo.getName()).s(downloadInfo.getSavePath()).n(downloadInfo.isShowNotification()).qg(downloadInfo.isAutoInstallWithoutNotification()).s(downloadInfo.isOnlyWifi() || z2).l(downloadInfo.getExtra()).w(downloadInfo.getMimeType()).n(downloadInfo.getExtraHeaders()).l(true).qg(downloadInfo.getRetryCount()).s(downloadInfo.getBackUpUrlRetryCount()).qg(downloadInfo.getBackUpUrls()).q(downloadInfo.getMinProgressTimeMsInterval()).l(downloadInfo.getMaxProgressCount()).w(z).q(downloadInfo.isNeedHttpsToHttpRetry()).x(downloadInfo.getPackageName()).fs(downloadInfo.getMd5()).n(downloadInfo.getExpectFileLength()).rv(downloadInfo.isNeedDefaultHttpServiceBackUp()).tj(downloadInfo.isNeedReuseFirstConnection()).d(downloadInfo.isNeedIndependentProcess()).n(downloadInfo.getEnqueueType()).sz(downloadInfo.isForce()).oa(downloadInfo.isHeadConnectionAvailable()).x(downloadInfo.isNeedRetryDelay()).rv(downloadInfo.getRetryDelayTimeArray()).n(q(downloadInfo.getDownloadSettingString())).cp(downloadInfo.getIconUrl()).w(downloadInfo.getExecutorGroup()).cy(downloadInfo.isAutoInstall()));
    }

    private static JSONObject q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void n(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception unused) {
            }
        }
    }

    public static PackageInfo n(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.byazt.k.l.n(com.byazt.xv.s.u(), file, n());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfoN = com.byazt.k.l.n(com.byazt.xv.s.u(), file, n());
        downloadInfo.setPackageInfo(packageInfoN);
        return packageInfoN;
    }

    public static int n(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
