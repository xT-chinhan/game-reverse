package com.byazt.je;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface j extends IInterface {
    long n(int i, int i2) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 88, 2118})
    public static abstract class n extends Binder implements j {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static j n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof j)) {
                return (j) iInterfaceQueryLocalInterface;
            }
            return new C0213n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long jN = n(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(jN);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.je.j$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 88, 2436})
        private static class C0213n implements j {
            public static j n;
            public IBinder qg;

            public C0213n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.je.j
            public long n(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        return n.n().n(i, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static j n() {
            return C0213n.n;
        }
    }
}
