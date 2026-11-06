package com.ss.android.downloadlib.ab;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class sl {

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static sl f4340ms = new sl();
    }

    public static sl ms() {
        return ms.f4340ms;
    }

    private sl() {
    }

    public void ms(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.api.ab.xr("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }

    public void xr(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.api.ab.ka("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }
}
