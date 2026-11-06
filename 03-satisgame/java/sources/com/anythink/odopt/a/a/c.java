package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ServiceConnection {
    private Context a;
    private com.anythink.odopt.a.a b;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }

    public c(Context context) {
        this.a = context;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
        if (this.a == null) {
            return;
        }
        try {
            this.b = aVar;
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            if (this.a.bindService(intent, this, 1)) {
                return;
            }
            aVar.a("Service binding failed.");
        } catch (Throwable th) {
            com.anythink.odopt.a.a aVar2 = this.b;
            if (aVar2 != null) {
                aVar2.a(th.getMessage());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            l lVarA = l.b.a(iBinder);
            if (lVarA != null) {
                this.b.a(lVarA.a(this.a.getPackageName()), false);
            } else {
                this.b.a("CoolpadIdsSupplier == null");
            }
            try {
                this.a.unbindService(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            try {
                com.anythink.odopt.a.a aVar = this.b;
                if (aVar != null) {
                    aVar.a(th2.getMessage());
                }
            } finally {
                try {
                    this.a.unbindService(this);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }
}
