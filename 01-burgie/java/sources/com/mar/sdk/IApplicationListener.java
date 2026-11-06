package com.mar.sdk;

import android.content.Context;
import android.content.res.Configuration;

/* JADX INFO: loaded from: classes2.dex */
public interface IApplicationListener {
    void onProxyAttachBaseContext(Context context);

    void onProxyConfigurationChanged(Configuration configuration);

    @Deprecated
    void onProxyCreate();

    void onProxyTerminate();
}
