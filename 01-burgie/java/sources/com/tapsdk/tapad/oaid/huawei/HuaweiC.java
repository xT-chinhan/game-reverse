package com.tapsdk.tapad.oaid.huawei;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class HuaweiC {
    public static boolean a(Context context, String str) {
        return b(context, str) != null;
    }

    public static PackageInfo b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 128);
                }
            } catch (PackageManager.NameNotFoundException e) {
            } catch (Exception e2) {
            }
        }
        return null;
    }

    public static String a(Context context) {
        if (a(context, "com.huawei.hwid")) {
            return "com.huawei.hwid";
        }
        if (a(context, "com.huawei.hms")) {
            return "com.huawei.hms";
        }
        return a(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }
}
