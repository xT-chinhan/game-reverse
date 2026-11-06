package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import java.io.File;

/* JADX INFO: compiled from: Root.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static boolean a() {
        return b() || c() || d() || e();
    }

    private static boolean b() {
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return true;
        }
        return false;
    }

    private static boolean c() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (Exception e) {
        }
        try {
            if (new File("/system/app/Kinguser.apk").exists()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private static boolean d() {
        if (new e().a(e.a.check_su_binary) != null) {
            return true;
        }
        return false;
    }

    private static boolean e() {
        for (String str : new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}) {
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }
}
