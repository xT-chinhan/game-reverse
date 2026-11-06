package com.tapsdk.tapad.group.adapter;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterInitializer {
    void initialize(Context context, AdapterInitConfig adapterInitConfig, AdapterInitCallback adapterInitCallback);

    default void updateGlobalSettings(AdapterInitConfig adapterInitConfig, String str, String str2) {
    }
}
