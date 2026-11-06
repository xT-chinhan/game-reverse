package com.byazt.xv;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 1831})
public class SqlDownloadCacheService extends Service {
    public static final String n = "SqlDownloadCacheService";

    public static void n(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        s.n(getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a aVarW;
        tj tjVarHu = s.hu();
        if (tjVarHu instanceof com.byazt.i.q) {
            aVarW = ((com.byazt.i.q) tjVarHu).w();
        } else {
            aVarW = tjVarHu instanceof a ? (a) tjVarHu : null;
        }
        if (aVarW instanceof IBinder) {
            return (IBinder) aVarW;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (s.tj()) {
            return 2;
        }
        return iOnStartCommand;
    }
}
