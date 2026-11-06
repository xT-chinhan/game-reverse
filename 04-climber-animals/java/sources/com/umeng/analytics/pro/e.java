package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceIdService.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e extends IInterface {

    /* JADX INFO: compiled from: IDeviceIdService.java */
    public static class a implements e {
        @Override // com.umeng.analytics.pro.e
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.e
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.e
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* JADX INFO: compiled from: IDeviceIdService.java */
    public static abstract class b extends Binder implements e {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        private static final String d = "com.samsung.android.deviceidservice.IDeviceIdService";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public b() {
            attachInterface(this, d);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(d);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof e)) {
                return (e) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(d);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(d);
                String strA2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA2);
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(d);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(d);
            String strB = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }

        /* JADX INFO: compiled from: IDeviceIdService.java */
        private static class a implements e {
            public static e a;
            private IBinder b;

            public String b() {
                return b.d;
            }

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.umeng.analytics.pro.e
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.d);
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

            @Override // com.umeng.analytics.pro.e
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.d);
                    parcelObtain.writeString(str);
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && b.b() != null) {
                        return b.b().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.e
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.d);
                    parcelObtain.writeString(str);
                    if (!this.b.transact(3, parcelObtain, parcelObtain2, 0) && b.b() != null) {
                        return b.b().b(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean a(e eVar) {
            if (a.a != null || eVar == null) {
                return false;
            }
            a.a = eVar;
            return true;
        }

        public static e b() {
            return a.a;
        }
    }
}
