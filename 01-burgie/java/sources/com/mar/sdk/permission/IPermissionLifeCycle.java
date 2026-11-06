package com.mar.sdk.permission;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public interface IPermissionLifeCycle {
    void onActivityResult(Activity activity, int i, int i2, Intent intent);

    void onCreate(Activity activity);

    void onDestroy(Activity activity);

    void onNewIntent(Activity activity, Intent intent);

    void onPause(Activity activity);

    void onRestart(Activity activity);

    void onResume(Activity activity);

    void onStart(Activity activity);

    void onStop(Activity activity);
}
