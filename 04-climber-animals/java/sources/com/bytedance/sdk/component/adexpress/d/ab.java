package com.bytedance.sdk.component.adexpress.d;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    public static boolean ms(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean xr(String str) {
        return com.bytedance.sdk.component.adexpress.d.ms() && ms(str);
    }
}
