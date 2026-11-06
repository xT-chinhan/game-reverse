package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.anythink.odopt.a.a.j;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: classes3.dex */
public interface HONORInterface extends IInterface {
    void getBoos(HONORProxyInterface hONORProxyInterface);

    void getIDs(HONORProxyInterface hONORProxyInterface);

    public static class HONORID extends Binder implements HONORInterface {
        private IBinder iBinder;

        public HONORID(IBinder iBinder) {
            this.iBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public void getIDs(HONORProxyInterface hONORProxyInterface) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(j.a);
                parcelObtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.AbstractBinderC0001a) hONORProxyInterface : null);
                this.iBinder.transact(2, parcelObtain, parcelObtain2, 0);
                LiteApiLogger.d("HONORDeviceIDHelper", "gets + " + this.iBinder);
                parcelObtain2.readException();
            } catch (Throwable th) {
                try {
                    LiteApiLogger.d("HONORDeviceIDHelper", th);
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public void getBoos(HONORProxyInterface hONORProxyInterface) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(j.a);
                parcelObtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.AbstractBinderC0001a) hONORProxyInterface : null);
                this.iBinder.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } catch (Throwable th) {
                try {
                    LiteApiLogger.d("HONORDeviceIDHelper", th);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
