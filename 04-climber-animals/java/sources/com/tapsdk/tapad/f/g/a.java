package com.tapsdk.tapad.f.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.tapsdk.tapad.f.g.a$a, reason: collision with other inner class name */
    public static class C0592a implements a {
        @Override // com.tapsdk.tapad.f.g.a
        public boolean a(boolean z) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tapsdk.tapad.f.g.a
        public String f() throws RemoteException {
            return null;
        }
    }

    public static abstract class b extends Binder implements a {
        private static final String a = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        static final int b = 1;
        static final int c = 2;

        /* JADX INFO: renamed from: com.tapsdk.tapad.f.g.a$b$a, reason: collision with other inner class name */
        private static class C0593a implements a {
            public static a b;
            private IBinder a;

            C0593a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.tapsdk.tapad.f.g.a
            public boolean a(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0) && b.p() != null) {
                        return b.p().a(z);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.tapsdk.tapad.f.g.a
            public String f() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || b.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.p().f();
                    }
                    return string;
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

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0593a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0593a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0593a.b = aVar;
            return true;
        }

        public static a p() {
            return C0593a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                String strF = f();
                parcel2.writeNoException();
                parcel2.writeString(strF);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a);
                return true;
            }
            parcel.enforceInterface(a);
            boolean zA = a(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(zA ? 1 : 0);
            return true;
        }
    }

    boolean a(boolean z) throws RemoteException;

    String f() throws RemoteException;
}
