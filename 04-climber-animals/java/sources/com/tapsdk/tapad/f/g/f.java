package com.tapsdk.tapad.f.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface f extends IInterface {

    public static class a implements f {
        @Override // com.tapsdk.tapad.f.g.f
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.f
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.f
        public String c() throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.f
        public String d() throws RemoteException {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.f
        public boolean e() throws RemoteException {
            return false;
        }

        @Override // com.tapsdk.tapad.f.g.f
        public void h() throws RemoteException {
        }

        @Override // com.tapsdk.tapad.f.g.f
        public boolean k() throws RemoteException {
            return false;
        }

        @Override // com.tapsdk.tapad.f.g.f
        public void n() throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements f {
        private static final String a = "com.qiku.id.IOAIDInterface";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;
        static final int g = 6;
        static final int h = 7;
        static final int i = 8;

        private static class a implements f {
            public static f b;
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.tapsdk.tapad.f.g.f
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

            @Override // com.tapsdk.tapad.f.g.f
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

            @Override // com.tapsdk.tapad.f.g.f
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

            @Override // com.tapsdk.tapad.f.g.f
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

            @Override // com.tapsdk.tapad.f.g.f
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

            @Override // com.tapsdk.tapad.f.g.f
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

            @Override // com.tapsdk.tapad.f.g.f
            public boolean k() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(8, parcelObtain, parcelObtain2, 0) && b.p() != null) {
                        return b.p().k();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tapsdk.tapad.f.g.f
            public void n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (this.a.transact(7, parcelObtain, parcelObtain2, 0) || b.p() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.p().n();
                    }
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

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof f)) ? new a(iBinder) : (f) iInterfaceQueryLocalInterface;
        }

        public static boolean a(f fVar) {
            if (a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (fVar == null) {
                return false;
            }
            a.b = fVar;
            return true;
        }

        public static f p() {
            return a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(a);
                    boolean zE = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(a);
                    String strC = c();
                    parcel2.writeNoException();
                    parcel2.writeString(strC);
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
                case 7:
                    parcel.enforceInterface(a);
                    n();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(a);
                    boolean zK = k();
                    parcel2.writeNoException();
                    parcel2.writeInt(zK ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    String a() throws RemoteException;

    String b() throws RemoteException;

    String c() throws RemoteException;

    String d() throws RemoteException;

    boolean e() throws RemoteException;

    void h() throws RemoteException;

    boolean k() throws RemoteException;

    void n() throws RemoteException;
}
