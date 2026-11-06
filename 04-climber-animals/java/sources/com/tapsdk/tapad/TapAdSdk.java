package com.tapsdk.tapad;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class TapAdSdk {
    private static ITapAd tapAd = new TapAdImpl();

    public static void init(Context context, TapAdConfig tapAdConfig) {
        tapAd.init(context, tapAdConfig);
    }

    public static void updateAdConfig(TapAdConfig tapAdConfig) {
        tapAd.updateAdConfig(tapAdConfig);
    }
}
