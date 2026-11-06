package com.mcto.sspsdk.remote;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.mcto.sspsdk.internal.rh;

/* JADX INFO: loaded from: classes2.dex */
public class SimulatorDetectService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new rh();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
