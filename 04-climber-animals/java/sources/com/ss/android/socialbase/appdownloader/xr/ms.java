package com.ss.android.socialbase.appdownloader.xr;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final String f4610ms;

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
        f4610ms = sb.toString();
    }
}
