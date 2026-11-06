package com.byazt.bgo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.anythink.odopt.a.a.j;

/* JADX INFO: loaded from: classes.dex */
public interface qg extends IInterface {
    void n(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void n(com.byazt.bgo.n nVar) throws RemoteException;

    void qg(com.byazt.bgo.n nVar) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 111, 48})
    public static abstract class n extends Binder implements qg {
        public static qg n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(j.a);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof qg)) {
                return (qg) iInterfaceQueryLocalInterface;
            }
            return new C0137n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(j.a);
                n(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(j.a);
                n(com.byazt.bgo.n.AbstractBinderC0135n.n(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(j.a);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(j.a);
            qg(com.byazt.bgo.n.AbstractBinderC0135n.n(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.bgo.qg$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 111, 112})
        private static class C0137n implements qg {
            public static qg n;
            public IBinder qg;

            public C0137n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.bgo.qg
            public void n(int i, long j, boolean z, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(j.a);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                            n.n().n(i, j, z, f, d, str);
                        } else {
                            parcelObtain2.readException();
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
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

            @Override // com.byazt.bgo.qg
            public void n(com.byazt.bgo.n nVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(j.a);
                    parcelObtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(nVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bgo.qg
            public void qg(com.byazt.bgo.n nVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(j.a);
                    parcelObtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    if (!this.qg.transact(3, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().qg(nVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static qg n() {
            return C0137n.n;
        }
    }
}
