package com.smartdigimkt.r;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements p {
    public final IBinder a;

    public n(IBinder iBinder) {
        this.a = iBinder;
    }

    public final void a(q qVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(com.anythink.odopt.a.a.j.a);
            parcelObtain.writeStrongBinder(qVar);
            this.a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
