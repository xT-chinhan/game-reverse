package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements ServiceConnection {
    public final /* synthetic */ s a;

    public r(s sVar) {
        this.a = sVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.c = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        p nVar;
        try {
            s sVar = this.a;
            int i = o.a;
            if (iBinder == null) {
                nVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.anythink.odopt.a.a.j.a);
                if (iInterfaceQueryLocalInterface instanceof p) {
                    nVar = (p) iInterfaceQueryLocalInterface;
                } else {
                    nVar = new n(iBinder);
                }
            }
            sVar.c = nVar;
            p pVar = this.a.c;
            if (pVar != null) {
                ((n) pVar).a(new q(this.a));
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
                com.smartdigimkt.q.a aVar = this.a.d;
                if (aVar != null) {
                    aVar.a("onServiceConnected() >>> failed: " + th.getMessage());
                }
            } finally {
                s.a(this.a);
            }
        }
    }
}
