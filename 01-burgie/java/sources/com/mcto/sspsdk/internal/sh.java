package com.mcto.sspsdk.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes2.dex */
public final class sh implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        r7 q7Var;
        int i = rh.a;
        if (iBinder == null) {
            q7Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.mcto.sspsdk.remote.ISimulatorDetectorInterface");
            q7Var = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof r7)) ? new q7(iBinder) : (r7) iInterfaceQueryLocalInterface;
        }
        try {
            th.c.b = q7Var.a();
        } catch (Exception e) {
            th.c.b = false;
            e.printStackTrace();
        } finally {
            nh.a(jd.a).a("iad_dev", "isim", String.valueOf(th.c.b));
            nh.a(jd.a).a("iad_dev", "simlt", System.currentTimeMillis() + "");
            jd.a.unbindService(th.c.a);
            boolean z = th.c.b;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
