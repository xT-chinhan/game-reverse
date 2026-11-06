package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.byazt.eyv.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.QySdkInnerApi;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e1 {
    public static boolean a(boolean z, Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            return a(context, str2);
        }
        try {
            Uri uri = Uri.parse(str);
            if (z && uri.getScheme() != null && uri.getScheme().contains("qiyi")) {
                z = false;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (z) {
                intent.setFlags(805339136);
            } else {
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            r9.a("ssp_apk", "deepLink: ", e);
            return false;
        }
    }

    public static void b(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            File file = new File(str);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(1);
                String fileProviderAuthority = QySdkInnerApi.getFileProviderAuthority();
                if (TextUtils.isEmpty(fileProviderAuthority)) {
                    fileProviderAuthority = jd.a.getPackageName() + ".qy.fileprovider";
                }
                intent.setDataAndType(FileProvider.getUriForFile(jd.a, fileProviderAuthority, file), AdBaseConstants.MIME_APK);
            } else {
                intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
            }
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            jd.a.startActivity(intent);
        } catch (Exception e) {
            r9.a("ssp_apk", "install apk ex:", e);
        }
    }

    public static boolean c(String str) {
        if (lj.b(str)) {
            return false;
        }
        try {
            return jd.a.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            r9.a("ssp_apk", "deepLink: ", e);
            return false;
        }
    }

    public static PackageInfo a(String str) {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Context context = jd.a;
            if (context != null && (packageManager = context.getPackageManager()) != null) {
                return packageManager.getPackageInfo(str, 0);
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (Exception e2) {
        }
        return null;
    }
}
