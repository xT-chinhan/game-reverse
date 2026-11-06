package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    v a;
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.odopt.a.a.w.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.this.a = new v.a(iBinder);
        }
    };
    private Context c;

    public w(Context context) {
        this.c = context;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
        v vVar;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.c.bindService(intent, this.b, 1) && (vVar = this.a) != null) {
                aVar.a(vVar.a(), false);
            } else {
                aVar.a("Service unbind");
            }
        } catch (Throwable th) {
            aVar.a(th.getMessage());
        }
    }
}
