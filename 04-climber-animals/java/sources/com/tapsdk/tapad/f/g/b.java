package com.tapsdk.tapad.f.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // com.tapsdk.tapad.f.g.b
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.b
        public String b(String str) throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.b
        public String c(String str) throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.b
        public String d(String str) throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.b
        public String f(String str) throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.b
        public boolean j() throws RemoteException {
            return false;
        }

        @Override // com.tapsdk.tapad.f.g.b
        public String o() throws RemoteException {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.f.g.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0594b extends Binder implements b {
        private static final String a = "com.coolpad.deviceidsupport.IDeviceIdManager";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;
        static final int g = 6;
        static final int h = 7;

        /* JADX INFO: renamed from: com.tapsdk.tapad.f.g.b$b$a */
        private static class a implements b {
            public static b b;
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.tapsdk.tapad.f.g.b
            public String a(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0594b.a);
                    parcelObtain.writeString(str);
                    if (this.a.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC0594b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0594b.p().a(str);
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

            @Override // com.tapsdk.tapad.f.g.b
            public String b(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0594b.a);
                    parcelObtain.writeString(str);
                    if (this.a.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC0594b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0594b.p().b(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.b
            public String c(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0594b.a);
                    parcelObtain.writeString(str);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0594b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0594b.p().c(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.b
            public String d(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0594b.a);
                    parcelObtain.writeString(str);
                    if (this.a.transact(5, parcelObtain, parcelObtain2, 0) || AbstractBinderC0594b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0594b.p().d(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.b
            public String f(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0594b.a);
                    parcelObtain.writeString(str);
                    if (this.a.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC0594b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0594b.p().f(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.b
            public boolean j() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0594b.a);
                    if (!this.a.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0594b.p() != null) {
                        return AbstractBinderC0594b.p().j();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.b
            public String o() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0594b.a);
                    if (this.a.transact(7, parcelObtain, parcelObtain2, 0) || AbstractBinderC0594b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0594b.p().o();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String p() {
                return AbstractBinderC0594b.a;
            }
        }

        public AbstractBinderC0594b() {
            attachInterface(this, a);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static boolean a(b bVar) {
            if (a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.b = bVar;
            return true;
        }

        public static b p() {
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
                    String strC = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strC);
                    return true;
                case 2:
                    parcel.enforceInterface(a);
                    String strF = f(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strF);
                    return true;
                case 3:
                    parcel.enforceInterface(a);
                    String strB = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 4:
                    parcel.enforceInterface(a);
                    String strA = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 5:
                    parcel.enforceInterface(a);
                    String strD = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strD);
                    return true;
                case 6:
                    parcel.enforceInterface(a);
                    boolean zJ = j();
                    parcel2.writeNoException();
                    parcel2.writeInt(zJ ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(a);
                    String strO = o();
                    parcel2.writeNoException();
                    parcel2.writeString(strO);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    String d(String str) throws RemoteException;

    String f(String str) throws RemoteException;

    boolean j() throws RemoteException;

    String o() throws RemoteException;
}
