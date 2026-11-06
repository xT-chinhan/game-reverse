package com.mcto.sspsdk.internal;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public final class q7 implements r7 {
    public final IBinder a;

    public q7(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // com.mcto.sspsdk.internal.r7
    public final boolean a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.mcto.sspsdk.remote.ISimulatorDetectorInterface");
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
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
