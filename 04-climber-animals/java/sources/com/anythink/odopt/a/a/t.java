package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class t {
    public final LinkedBlockingQueue<IBinder> a = new LinkedBlockingQueue<>(1);
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.odopt.a.a.t.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                t.this.a.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Context c;

    public t(Context context) {
        this.c = context;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (this.c.bindService(intent, this.b, 1)) {
                try {
                    aVar.a(new s.a(this.a.take()).a(), false);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    aVar.a(th.getMessage());
                    return;
                }
            }
            aVar.a("Service unbind.");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
