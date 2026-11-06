package com.mar.sdk.taptap;

import android.content.Context;
import android.content.res.Configuration;
import com.mar.sdk.IApplicationListener;
import com.mar.sdk.MARSDK;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletAdProxyApplication implements IApplicationListener {
    @Override // com.mar.sdk.IApplicationListener
    public void onProxyCreate() {
        DirichletAdCtrl.Inst().parseParams(MARSDK.getInstance().getSDKParams());
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
