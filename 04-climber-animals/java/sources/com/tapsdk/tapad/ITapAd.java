package com.tapsdk.tapad;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface ITapAd {
    void init(Context context, TapAdConfig tapAdConfig);

    void updateAdConfig(TapAdConfig tapAdConfig);
}
