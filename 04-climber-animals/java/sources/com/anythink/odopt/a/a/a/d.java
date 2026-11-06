package com.anythink.odopt.a.a.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
class d implements ServiceConnection {
    private final Context a;
    private final com.anythink.odopt.a.a b;
    private final a c;
    private String d = "d";

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder);
    }

    public static void a(Context context, Intent intent, com.anythink.odopt.a.a aVar, a aVar2) {
        d dVar = new d(context, aVar, aVar2);
        try {
            if (!dVar.a.bindService(intent, dVar, 1)) {
                throw new RuntimeException("Service binding failed");
            }
            new StringBuilder("Service has been bound: ").append(intent);
        } catch (Exception e) {
            dVar.b.a(e.getMessage());
        }
    }

    private d(Context context, com.anythink.odopt.a.a aVar, a aVar2) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
        this.b = aVar;
        this.c = aVar2;
    }

    private void a(Intent intent) {
        try {
            if (!this.a.bindService(intent, this, 1)) {
                throw new RuntimeException("Service binding failed");
            }
            new StringBuilder("Service has been bound: ").append(intent);
        } catch (Exception e) {
            this.b.a(e.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        componentName.getClassName();
        try {
            try {
                String strA = this.c.a(iBinder);
                if (strA == null || strA.isEmpty()) {
                    throw new RuntimeException("OAID acquire failed");
                }
                if ("oaid".equalsIgnoreCase(strA)) {
                    throw new RuntimeException("Invalid OAID");
                }
                this.b.a(strA, false);
                try {
                    this.a.unbindService(this);
                    componentName.getClassName();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                this.b.a(e2.getMessage());
                try {
                    this.a.unbindService(this);
                    componentName.getClassName();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th) {
            try {
                this.a.unbindService(this);
                componentName.getClassName();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
