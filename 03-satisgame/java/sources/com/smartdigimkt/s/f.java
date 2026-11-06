package com.smartdigimkt.s;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static String a(IBinder iBinder) {
        e cVar;
        int i = d.a;
        if (iBinder == null) {
            cVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            cVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new c(iBinder) : (e) iInterfaceQueryLocalInterface;
        }
        if (cVar == null) {
            throw new RuntimeException("MsaIdInterface is null");
        }
        c cVar2 = (c) cVar;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            cVar2.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            boolean z = parcelObtain2.readInt() != 0;
            parcelObtain2.recycle();
            parcelObtain.recycle();
            if (!z) {
                throw new RuntimeException("MsaIdInterface#isSupported return false");
            }
            Parcel parcelObtain3 = Parcel.obtain();
            Parcel parcelObtain4 = Parcel.obtain();
            try {
                parcelObtain3.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                cVar2.a.transact(3, parcelObtain3, parcelObtain4, 0);
                parcelObtain4.readException();
                return parcelObtain4.readString();
            } finally {
                parcelObtain4.recycle();
                parcelObtain3.recycle();
            }
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }
}
