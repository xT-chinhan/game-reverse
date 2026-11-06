package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements ServiceConnection {
    public final /* synthetic */ m a;

    public l(m mVar) {
        this.a = mVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        k iVar;
        m mVar = this.a;
        int i = j.a;
        if (iBinder == null) {
            iVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            iVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k)) ? new i(iBinder) : (k) iInterfaceQueryLocalInterface;
        }
        mVar.c = iVar;
        m mVar2 = this.a;
        k kVar = mVar2.c;
        try {
            if (kVar != null) {
                try {
                    com.smartdigimkt.q.a aVar = mVar2.d;
                    if (aVar != null) {
                        aVar.a(((i) kVar).a(), ((i) this.a.c).b());
                    }
                } catch (RemoteException e) {
                    com.smartdigimkt.q.a aVar2 = this.a.d;
                    if (aVar2 != null) {
                        aVar2.a(e.getMessage());
                    }
                } catch (Exception e2) {
                    com.smartdigimkt.q.a aVar3 = this.a.d;
                    if (aVar3 != null) {
                        aVar3.a(e2.getMessage());
                    }
                }
            }
        } finally {
            m.a(this.a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.c = null;
    }
}
