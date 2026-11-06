package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ms implements ka {
    protected final String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final Context f4590ms;
    protected final com.ss.android.socialbase.downloader.ab.ms xr;

    public ms(Context context, com.ss.android.socialbase.downloader.ab.ms msVar, String str) {
        this.f4590ms = context;
        this.xr = msVar;
        this.ah = str;
    }

    public boolean ms() {
        if (this.f4590ms == null) {
            return false;
        }
        try {
            return xr().resolveActivity(this.f4590ms.getPackageManager()) != null;
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.bytedance.sdk.openadsdk.api.ab.ka("AbsDevicePlan", "check is valid failed!", th);
            }
        }
    }
}
