package com.mar.sdk;

import android.content.Context;
import android.content.res.Configuration;

/* JADX INFO: loaded from: classes2.dex */
public class UMProxyApplication implements IApplicationListener {
    @Override // com.mar.sdk.IApplicationListener
    public void onProxyCreate() {
        UMAnalyticsSDK.getInstance().initSDKInApplication(MARSDK.getInstance().getSDKParams());
    }

    @Override // com.mar.sdk.IApplicationListener
    public void onProxyAttachBaseContext(Context base) {
    }

    @Override // com.mar.sdk.IApplicationListener
    public void onProxyConfigurationChanged(Configuration config) {
    }

    @Override // com.mar.sdk.IApplicationListener
    public void onProxyTerminate() {
    }
}
