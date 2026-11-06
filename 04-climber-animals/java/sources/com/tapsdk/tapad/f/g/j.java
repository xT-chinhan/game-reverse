package com.tapsdk.tapad.f.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface j extends IInterface {

    public static class a implements j {
        @Override // com.tapsdk.tapad.f.g.j
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.j
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.j
        public String d() throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.j
        public boolean e() throws RemoteException {
            return false;
        }

        @Override // com.tapsdk.tapad.f.g.j
        public void h() throws RemoteException {
        }

        @Override // com.tapsdk.tapad.f.g.j
        public boolean l() throws RemoteException {
            return false;
        }
    }

    public static abstract class b extends Binder implements j {
        private static final String a = "com.bun.lib.MsaIdInterface";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;
        static final int g = 6;

        private static class a implements j {
            public static j b;
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.tapsdk.tapad.f.g.j
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

            @Override // com.tapsdk.tapad.f.g.j
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

            @Override // com.tapsdk.tapad.f.g.j
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

            @Override // com.tapsdk.tapad.f.g.j
            public boolean e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0) && b.p() != null) {
                        return b.p().e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.j
            public void h() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (this.a.transact(6, parcelObtain, parcelObtain2, 0) || b.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.p().h();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.j
            public boolean l() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0) && b.p() != null) {
                        return b.p().l();
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

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof j)) ? new a(iBinder) : (j) iInterfaceQueryLocalInterface;
        }

        public static boolean a(j jVar) {
            if (a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (jVar == null) {
                return false;
            }
            a.b = jVar;
            return true;
        }

        public static j p() {
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
            switch (i) {
                case 1:
                    parcel.enforceInterface(a);
                    boolean zE = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(a);
                    boolean zL = l();
                    parcel2.writeNoException();
                    parcel2.writeInt(zL ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(a);
                    String strA = a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 4:
                    parcel.enforceInterface(a);
                    String strB = b();
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 5:
                    parcel.enforceInterface(a);
                    String strD = d();
                    parcel2.writeNoException();
                    parcel2.writeString(strD);
                    return true;
                case 6:
                    parcel.enforceInterface(a);
                    h();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a() throws RemoteException;

    String b() throws RemoteException;

    String d() throws RemoteException;

    boolean e() throws RemoteException;

    void h() throws RemoteException;

    boolean l() throws RemoteException;
}
