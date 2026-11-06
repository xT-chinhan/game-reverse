package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SamsungDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
public class aj implements aa {
    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (!context.bindService(intent, aVar, 1)) {
            return null;
        }
        try {
            return b.a.a(aVar.a()).a();
        } catch (Exception e) {
            return null;
        } finally {
            context.unbindService(aVar);
        }
    }

    /* JADX INFO: compiled from: SamsungDeviceIdSupplier.java */
    private static final class a implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        public IBinder a() throws InterruptedException {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        private a() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>();
        }
    }
}
