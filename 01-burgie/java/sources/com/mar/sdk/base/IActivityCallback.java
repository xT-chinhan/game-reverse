package com.mar.sdk.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

/* JADX INFO: loaded from: classes2.dex */
public interface IActivityCallback {
    void attachBaseContext(Context context);

    void onActivityResult(int i, int i2, Intent intent);

    void onBackPressed();

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onNewIntent(Intent intent);

    void onPause();

    void onRequestPermissionResult(int i, String[] strArr, int[] iArr);

    void onRestart();

    void onResume();

    void onStart();

    void onStop();
}
