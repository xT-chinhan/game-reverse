package com.smartdigimkt.r;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements h0 {
    public final IBinder a;

    public f0(IBinder iBinder) {
        this.a = iBinder;
    }

    public final String a(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.oplus.stdid.IStdID");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString("OUID");
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
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
