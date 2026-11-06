package com.tapsdk.tapad.f.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends IInterface {

    public static class a implements e {
        @Override // com.tapsdk.tapad.f.g.e
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.e
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.e
        public String c() throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.e
        public String d() throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.e
        public boolean g() throws RemoteException {
            return false;
        }
    }

    public static abstract class b extends Binder implements e {
        private static final String a = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;

        private static class a implements e {
            public static e b;
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.tapsdk.tapad.f.g.e
            public String a() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (this.a.transact(3, parcelObtain, parcelObtain2, 0) || b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.p().a();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.tapsdk.tapad.f.g.e
            public String b() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (this.a.transact(4, parcelObtain, parcelObtain2, 0) || b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.p().b();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.e
            public String c() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (this.a.transact(2, parcelObtain, parcelObtain2, 0) || b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.p().c();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.e
            public String d() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (this.a.transact(5, parcelObtain, parcelObtain2, 0) || b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.p().d();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.e
            public boolean g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0) && b.p() != null) {
                        return b.p().g();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String p() {
                return b.a;
            }
        }

        public b() {
            attachInterface(this, a);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }

        public static boolean a(e eVar) {
            if (a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (eVar == null) {
                return false;
            }
            a.b = eVar;
            return true;
        }

        public static e p() {
            return a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(a);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(a);
                boolean zG = g();
                parcel2.writeNoException();
                parcel2.writeInt(zG ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a);
                String strC = c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(a);
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(a);
            String strD = d();
            parcel2.writeNoException();
            parcel2.writeString(strD);
            return true;
        }
    }

    String a() throws RemoteException;

    String b() throws RemoteException;

    String c() throws RemoteException;

    String d() throws RemoteException;

    boolean g() throws RemoteException;
}
