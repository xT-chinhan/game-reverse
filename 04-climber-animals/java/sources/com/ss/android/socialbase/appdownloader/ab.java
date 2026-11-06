package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public final class ab {
    public static int ms(String str) {
        if (ah(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.ah.k().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return -1;
        }
    }

    public static ms xr(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.ah.k().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return ms(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    private static ms ms(PackageManager packageManager, PackageInfo packageInfo) {
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
        return new ms(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static class ms {
        private boolean ab;
        private Drawable ah;
        private int c;
        private String d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f4555ms;
        private String xr;

        public Drawable ms() {
            return this.ah;
        }

        public void ms(Drawable drawable) {
            this.ah = drawable;
        }

        public boolean xr() {
            return this.ab;
        }

        public void ms(boolean z) {
            this.ab = z;
        }

        public String ah() {
            return this.f4555ms;
        }

        public void ms(String str) {
            this.f4555ms = str;
        }

        public String d() {
            return this.xr;
        }

        public void xr(String str) {
            this.xr = str;
        }

        public String ka() {
            return this.d;
        }

        public void ah(String str) {
            this.d = str;
        }

        public int c() {
            return this.c;
        }

        public void ms(int i) {
            this.c = i;
        }

        public String ab() {
            return this.ka;
        }

        public void d(String str) {
            this.ka = str;
        }

        public ms(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            xr(str2);
            ms(drawable);
            ms(str);
            ah(str3);
            d(str4);
            ms(i);
            ms(z);
        }

        public String toString() {
            return "{\n  pkg name: " + ah() + "\n  app icon: " + ms() + "\n  app name: " + d() + "\n  app path: " + ka() + "\n  app v name: " + ab() + "\n  app v code: " + c() + "\n  is system: " + xr() + "}";
        }
    }

    private static boolean ah(String str) {
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
