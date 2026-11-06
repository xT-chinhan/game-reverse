package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IOAIDService.java */
/* JADX INFO: loaded from: classes4.dex */
public interface d extends IInterface {

    /* JADX INFO: compiled from: IOAIDService.java */
    public static class a implements d {
        @Override // com.umeng.analytics.pro.d
        public void a(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }

        @Override // com.umeng.analytics.pro.d
        public void a(c cVar) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.d
        public void b(c cVar) throws RemoteException {
        }
    }

    void a(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void a(c cVar) throws RemoteException;

    void b(c cVar) throws RemoteException;

    /* JADX INFO: compiled from: IOAIDService.java */
    public static abstract class b extends Binder implements d {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        private static final String d = "com.hihonor.cloudservice.oaid.IOAIDService";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public b() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDService");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof d)) {
                return (d) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                a(c.b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            b(c.b.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: compiled from: IOAIDService.java */
        private static class a implements d {
            public static d a;
            private IBinder b;

            public String a() {
                return "com.hihonor.cloudservice.oaid.IOAIDService";
            }

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.umeng.analytics.pro.d
            public void a(int i, long j, boolean z, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && b.a() != null) {
                            b.a().a(i, j, z, f, d, str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.umeng.analytics.pro.d
            public void a(c cVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && b.a() != null) {
                        b.a().a(cVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.d
            public void b(c cVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (!this.b.transact(3, parcelObtain, parcelObtain2, 0) && b.a() != null) {
                        b.a().b(cVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean a(d dVar) {
            if (a.a != null || dVar == null) {
                return false;
            }
            a.a = dVar;
            return true;
        }

        public static d a() {
            return a.a;
        }
    }
}
