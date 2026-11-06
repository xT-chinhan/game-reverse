package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceidInterface.java */
/* JADX INFO: loaded from: classes4.dex */
public interface eu extends IInterface {

    /* JADX INFO: compiled from: IDeviceidInterface.java */
    public static class a implements eu {
        @Override // com.umeng.analytics.pro.eu
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    String a() throws RemoteException;

    /* JADX INFO: compiled from: IDeviceidInterface.java */
    public static abstract class b extends Binder implements eu {
        static final int a = 1;
        private static final String b = "com.zui.deviceidservice.IDeviceidInterface";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public b() {
            attachInterface(this, b);
        }

        public static eu a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof eu)) {
                return (eu) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(b);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(b);
            String strA = a();
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }

        /* JADX INFO: compiled from: IDeviceidInterface.java */
        private static class a implements eu {
            public static eu a;
            private IBinder b;

            public String b() {
                return b.b;
            }

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.umeng.analytics.pro.eu
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.b);
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && b.b() != null) {
                        return b.b().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean a(eu euVar) {
            if (a.a != null || euVar == null) {
                return false;
            }
            a.a = euVar;
            return true;
        }

        public static eu b() {
            return a.a;
        }
    }
}
