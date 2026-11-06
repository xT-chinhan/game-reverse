package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface ASUSIDInterface extends IInterface {
    String getID();

    public static final class ASUSID implements ASUSIDInterface {
        private final IBinder iBinder;

        public ASUSID(IBinder iBinder) {
            this.iBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.ASUSIDInterface
        public String getID() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.iBinder.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Exception unused) {
                return null;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}
