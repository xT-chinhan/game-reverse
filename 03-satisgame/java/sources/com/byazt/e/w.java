package com.byazt.e;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 13})
public final class w {
    public static int n(String str) {
        if (s(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.byazt.xv.s.u().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.byazt.fe.n.l("AppUtils", "getAppVersionCode:" + e.getMessage());
            return -1;
        }
    }

    public static n qg(String str) {
        try {
            PackageManager packageManager = com.byazt.xv.s.u().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return n(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            com.byazt.fe.n.l("AppUtils", "getAppInfo:" + e.getMessage());
            return null;
        }
    }

    private static n n(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawableLoadIcon = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String string = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new n(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 108})
    public static class n {
        public String l;
        public String n;
        public String q;
        public String qg;
        public Drawable s;
        public int w;
        public boolean x;

        public Drawable n() {
            return this.s;
        }

        public void n(Drawable drawable) {
            this.s = drawable;
        }

        public boolean qg() {
            return this.x;
        }

        public void n(boolean z) {
            this.x = z;
        }

        public String s() {
            return this.n;
        }

        public void n(String str) {
            this.n = str;
        }

        public String q() {
            return this.qg;
        }

        public void qg(String str) {
            this.qg = str;
        }

        public String l() {
            return this.q;
        }

        public void s(String str) {
            this.q = str;
        }

        public int w() {
            return this.w;
        }

        public void n(int i) {
            this.w = i;
        }

        public String x() {
            return this.l;
        }

        public void q(String str) {
            this.l = str;
        }

        public n(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            qg(str2);
            n(drawable);
            n(str);
            s(str3);
            q(str4);
            n(i);
            n(z);
        }

        public String toString() {
            return "{\n  pkg name: " + s() + "\n  app icon: " + n() + "\n  app name: " + q() + "\n  app path: " + l() + "\n  app v name: " + x() + "\n  app v code: " + w() + "\n  is system: " + qg() + "}";
        }
    }

    private static boolean s(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
