package com.smartdigimkt.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements ServiceConnection {
    public final /* synthetic */ u a;

    public k(u uVar) {
        this.a = uVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.a.m = (com.smartdigimkt.o.b) iBinder;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.m = null;
    }
}
