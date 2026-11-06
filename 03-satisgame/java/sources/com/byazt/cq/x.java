package com.byazt.cq;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, 21})
public class x {
    public static boolean n(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean qg(String str) {
        return com.byazt.twc.q.n() && n(str);
    }
}
