package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class f implements ServiceConnection {
    private Context a;
    private com.anythink.odopt.a.a b;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }

    public f(Context context) {
        this.a = context;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
        if (this.a == null) {
            return;
        }
        this.b = aVar;
        try {
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            if (this.a.bindService(intent, this, 1)) {
                return;
            }
            aVar.a("Service binding failed.");
        } catch (Throwable th) {
            aVar.a(th.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            e eVarA = e.b.a(iBinder);
            if (eVarA != null) {
                this.b.a(eVarA.b(), false);
            } else {
                this.b.a("FreemeIdsSupplier == null");
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
