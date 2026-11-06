package com.byazt.d;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 113, 19})
public class n {
    public static final String n;

    static {
        StringBuilder sb = new StringBuilder("AppDownloader");
        boolean z = !TextUtils.isEmpty(Build.VERSION.RELEASE);
        boolean z2 = !TextUtils.isEmpty(Build.ID);
        boolean z3 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        if (z) {
            sb.append("/").append(Build.VERSION.RELEASE);
        }
        sb.append(" (Linux; U; Android");
        if (z) {
            sb.append(" ").append(Build.VERSION.RELEASE);
        }
        if (z3 || z2) {
            sb.append(";");
            if (z3) {
                sb.append(" ").append(Build.MODEL);
            }
            if (z2) {
                sb.append(" Build/").append(Build.ID);
            }
        }
        sb.append(")");
        n = sb.toString();
    }
}
