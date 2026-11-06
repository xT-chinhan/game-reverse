package com.mar.sdk;

import android.content.Context;
import android.content.res.Configuration;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class GameProxyApplication extends MARApplication {
    @Override // com.mar.sdk.MARApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // com.mar.sdk.MARApplication, android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.mar.sdk.MARApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        Log.e("MARSDK", "this is a test application");
    }

    @Override // com.mar.sdk.MARApplication, android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }
}
