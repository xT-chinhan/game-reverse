package com.tapsdk.tapad.oaid.huawei.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    public static abstract class Stub {
        private static final String DESCRIPTOR = "com.uodis.opendevice.aidl.IOAIDService";
        static final int TRANSACTION_GETOAID = 1;
        static final int TRANSACTION_ISOAIDTRACKLIMITED = 2;

        public static class Proxy implements OpenDeviceIdentifierService {
            private final IBinder mBinderRemote;

            public Proxy(IBinder iBinder) {
                this.mBinderRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mBinderRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tapsdk.tapad.oaid.huawei.aidl.OpenDeviceIdentifierService
            public String getOaid() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(getInterfaceDescriptor());
                    this.mBinderRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.oaid.huawei.aidl.OpenDeviceIdentifierService
            public boolean isOaidTrackLimited() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(getInterfaceDescriptor());
                    this.mBinderRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static OpenDeviceIdentifierService asInterface(IBinder iBinder) {
            return new Proxy(iBinder);
        }
    }

    String getOaid();

    boolean isOaidTrackLimited();
}
