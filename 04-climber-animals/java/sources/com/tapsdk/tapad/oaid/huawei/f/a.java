package com.tapsdk.tapad.oaid.huawei.f;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.tapsdk.tapad.oaid.huawei.f.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0647a {
        private static final String a = "com.uodis.opendevice.aidl.IOAIDService";
        static final int b = 1;
        static final int c = 2;

        /* JADX INFO: renamed from: com.tapsdk.tapad.oaid.huawei.f.a$a$a, reason: collision with other inner class name */
        private static class C0648a implements a {
            private IBinder a;

            C0648a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.tapsdk.tapad.oaid.huawei.f.a
            public String i() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(p());
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.oaid.huawei.f.a
            public boolean m() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(p());
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String p() {
                return AbstractC0647a.a;
            }
        }

        public static a a(IBinder iBinder) {
            return new C0648a(iBinder);
        }
    }

    String i() throws RemoteException;

    boolean m() throws RemoteException;
}
