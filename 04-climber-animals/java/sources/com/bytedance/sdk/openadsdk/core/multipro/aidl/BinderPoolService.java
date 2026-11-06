package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class BinderPoolService extends Service {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Binder f2884ms = new ms.BinderC0295ms();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2884ms;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
