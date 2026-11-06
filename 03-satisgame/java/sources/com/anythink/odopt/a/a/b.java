package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final LinkedBlockingQueue<IBinder> a = new LinkedBlockingQueue<>(1);
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.odopt.a.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.a.put(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private Context c;

    public b(Context context) {
        this.c = context;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.c.bindService(intent, this.b, 1)) {
                try {
                    aVar.a(new a(this.a.take()).a(), false);
                    return;
                } catch (Exception e) {
                    aVar.a(e.getMessage());
                    return;
                } catch (Throwable th) {
                    aVar.a(th.getMessage());
                    return;
                }
            }
            aVar.a("Empty");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
