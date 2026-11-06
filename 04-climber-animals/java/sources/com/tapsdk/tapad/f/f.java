package com.tapsdk.tapad.f;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class f implements ServiceConnection {
    private final Context a;
    private final com.tapsdk.tapad.f.a b;
    private final a c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws RemoteException, c;
    }

    private f(Context context, com.tapsdk.tapad.f.a aVar, a aVar2) {
        this.a = context instanceof Application ? context : context.getApplicationContext();
        this.b = aVar;
        this.c = aVar2;
    }

    public static void a(Context context, Intent intent, com.tapsdk.tapad.f.a aVar, a aVar2) {
        new f(context, aVar, aVar2).a(intent);
    }

    private void a(Intent intent) {
        try {
            if (!this.a.bindService(intent, this, 1)) {
                throw new c("Service binding failed");
            }
            d.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.c.a(iBinder);
                    if (TextUtils.isEmpty(strA)) {
                        throw new c("OAID/AAID acquire failed");
                    }
                    this.b.a(strA);
                    this.a.unbindService(this);
                    d.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    this.b.a(e);
                    this.a.unbindService(this);
                    d.a("Service has been unbound: " + componentName.getClassName());
                }
            } catch (Exception e2) {
                d.a(e2);
            }
        } catch (Throwable th) {
            try {
                this.a.unbindService(this);
                d.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e3) {
                d.a(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        d.a("Service has been disconnected: " + componentName.getClassName());
    }
}
