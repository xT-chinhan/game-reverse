package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public class SqlDownloadCacheService extends Service {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4657ms = "SqlDownloadCacheService";

    public static void ms(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.d(f4657ms, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ah.ms(getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        t tVarC;
        ch chVarW = ah.w();
        if (chVarW instanceof com.ss.android.socialbase.downloader.impls.d) {
            tVarC = ((com.ss.android.socialbase.downloader.impls.d) chVarW).c();
        } else {
            tVarC = chVarW instanceof t ? (t) chVarW : null;
        }
        if (tVarC instanceof IBinder) {
            return (IBinder) tVarC;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (ah.ch()) {
            return 2;
        }
        return iOnStartCommand;
    }
}
