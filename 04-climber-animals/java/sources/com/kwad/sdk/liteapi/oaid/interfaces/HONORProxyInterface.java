package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.anythink.odopt.a.a.i;

/* JADX INFO: loaded from: classes3.dex */
public interface HONORProxyInterface extends IInterface {
    void a(int i, long j, boolean z, float f, double d, String str);

    void a(int i, Bundle bundle);

    public static abstract class a extends Binder implements HONORProxyInterface {
        public abstract void a(int i, long j, boolean z, float f, double d, String str);

        public abstract void a(int i, Bundle bundle);

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, i.a);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(i.a);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(i.a);
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(i.a);
            return true;
        }
    }
}
