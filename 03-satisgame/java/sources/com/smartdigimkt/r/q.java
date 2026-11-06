package com.smartdigimkt.r;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends Binder implements IInterface {
    public final /* synthetic */ s a;

    public q(s sVar) {
        this.a = sVar;
        attachInterface(this, com.anythink.odopt.a.a.i.a);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface(com.anythink.odopt.a.a.i.a);
            parcel.readInt();
            parcel.readLong();
            parcel.readInt();
            parcel.readFloat();
            parcel.readDouble();
            parcel.readString();
            parcel2.writeNoException();
            return true;
        }
        if (i != 2) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(com.anythink.odopt.a.a.i.a);
            return true;
        }
        parcel.enforceInterface(com.anythink.odopt.a.a.i.a);
        int i3 = parcel.readInt();
        Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
        if (i3 == 0 && bundle != null) {
            String string = bundle.getString("oa_id_flag");
            if (this.a.d != null) {
                if (TextUtils.isEmpty(string)) {
                    this.a.d.a("oaid is empty.");
                } else {
                    this.a.d.a(string, false);
                }
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
