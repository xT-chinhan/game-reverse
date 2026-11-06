package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ServiceConnection {
    public final Context a;
    public com.smartdigimkt.q.a b;

    public h(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        if (this.a == null) {
            return;
        }
        this.b = bVar;
        try {
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            if (this.a.bindService(intent, this, 1)) {
                return;
            }
            bVar.a("Service binding failed.");
        } catch (Throwable th) {
            bVar.a(th.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        g eVar;
        try {
            int i = f.a;
            if (iBinder == null) {
                eVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.FreemeIdsSupplier");
                eVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new e(iBinder) : (g) iInterfaceQueryLocalInterface;
            }
            if (eVar != null) {
                com.smartdigimkt.q.a aVar = this.b;
                e eVar2 = (e) eVar;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.FreemeIdsSupplier");
                    eVar2.a.transact(3, parcelObtain, parcelObtain2, 0);
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
                this.b.a("FreemeIdsSupplier == null");
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
