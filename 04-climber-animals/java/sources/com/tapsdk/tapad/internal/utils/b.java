package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static int a(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            com.tapsdk.tapad.e.g.d().a(str);
            TapADLogger.d("package install success");
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            TapADLogger.d("package install fail");
            return false;
        }
    }

    public static boolean a(String str) {
        return com.tapsdk.tapad.e.g.d().b().contains(str);
    }

    public static boolean b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            a.a(context).startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
