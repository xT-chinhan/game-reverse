package com.byazt.js;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, 62})
public class fw {
    public static boolean pr(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean hw(String str) {
        return com.byazt.dj.x.pr() && pr(str);
    }
}
