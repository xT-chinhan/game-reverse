package com.byazt.qr;

import android.content.Intent;
import android.os.IBinder;
import com.bytedance.pangle.plugin.Plugin;

/* JADX INFO: loaded from: classes2.dex */
public interface n {
    void attach(Plugin plugin);

    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent intent, int i, int i2);

    boolean onUnbind(Intent intent);
}
