package com.byazt.mdu;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 5})
public final class uc {
    public static int pr(String str) {
        if (hn(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.byazt.lj.hn.of().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.byazt.p000do.pr.c("AppUtils", "getAppVersionCode:" + e.getMessage());
            return -1;
        }
    }

    public static pr hw(String str) {
        try {
            PackageManager packageManager = com.byazt.lj.hn.of().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return pr(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            com.byazt.p000do.pr.c("AppUtils", "getAppInfo:" + e.getMessage());
            return null;
        }
    }

    private static pr pr(PackageManager packageManager, PackageInfo packageInfo) {
        String string;
        Drawable drawableLoadIcon;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        if (applicationInfo != null && applicationInfo.loadLabel(packageManager) != null) {
            string = applicationInfo.loadLabel(packageManager).toString();
        } else {
            string = "";
        }
        try {
            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        } catch (Exception e) {
            drawableLoadIcon = null;
        }
        return new pr(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 129})
    public static class pr {
        public String c;
        public boolean fw;
        public Drawable hn;
        public String hw;
        public String pr;
        public int uc;
        public String x;

        public Drawable pr() {
            return this.hn;
        }

        public void pr(Drawable drawable) {
            this.hn = drawable;
        }

        public boolean hw() {
            return this.fw;
        }

        public void pr(boolean z) {
            this.fw = z;
        }

        public String hn() {
            return this.pr;
        }

        public void pr(String str) {
            this.pr = str;
        }

        public String x() {
            return this.hw;
        }

        public void hw(String str) {
            this.hw = str;
        }

        public String c() {
            return this.x;
        }

        public void hn(String str) {
            this.x = str;
        }

        public int uc() {
            return this.uc;
        }

        public void pr(int i) {
            this.uc = i;
        }

        public String fw() {
            return this.c;
        }

        public void x(String str) {
            this.c = str;
        }

        public pr(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            hw(str2);
            pr(drawable);
            pr(str);
            hn(str3);
            x(str4);
            pr(i);
            pr(z);
        }

        public String toString() {
            return "{\n  pkg name: " + hn() + "\n  app icon: " + pr() + "\n  app name: " + x() + "\n  app path: " + c() + "\n  app v name: " + fw() + "\n  app v code: " + uc() + "\n  is system: " + hw() + "}";
        }
    }

    private static boolean hn(String str) {
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
