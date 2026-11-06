package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ServiceConnection {
    public final Context a;
    public com.smartdigimkt.q.a b;

    public c(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        if (this.a == null) {
            return;
        }
        try {
            this.b = bVar;
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            if (this.a.bindService(intent, this, 1)) {
                return;
            }
            bVar.a("Service binding failed.");
        } catch (Throwable th) {
            com.smartdigimkt.q.a aVar = this.b;
            if (aVar != null) {
                aVar.a(th.getMessage());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        v tVar;
        try {
            int i = u.a;
            if (iBinder == null) {
                tVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                tVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof v)) ? new t(iBinder) : (v) iInterfaceQueryLocalInterface;
            }
            if (tVar != null) {
                com.smartdigimkt.q.a aVar = this.b;
                String packageName = this.a.getPackageName();
                t tVar2 = (t) tVar;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(packageName);
                    tVar2.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    String string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    aVar.a(string, false);
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            } else {
                this.b.a("CoolpadIdsSupplier == null");
            }
            try {
                this.a.unbindService(this);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            try {
                com.smartdigimkt.q.a aVar2 = this.b;
                if (aVar2 != null) {
                    aVar2.a(th3.getMessage());
                }
            } finally {
                try {
                    this.a.unbindService(this);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
