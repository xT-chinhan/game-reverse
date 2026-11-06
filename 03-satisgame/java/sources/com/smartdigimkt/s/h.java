package com.smartdigimkt.s;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ServiceConnection {
    public final Context a;
    public final com.smartdigimkt.q.a b;
    public final f c;

    public h(Context context, a aVar, f fVar) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
        this.b = aVar;
        this.c = fVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        componentName.getClassName();
        try {
            try {
                this.c.getClass();
                String strA = f.a(iBinder);
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
            } catch (Throwable th) {
                try {
                    this.a.unbindService(this);
                    componentName.getClassName();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (Exception e3) {
            this.b.a(e3.getMessage());
            try {
                this.a.unbindService(this);
                componentName.getClassName();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
