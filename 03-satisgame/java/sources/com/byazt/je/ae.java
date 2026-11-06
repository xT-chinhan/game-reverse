package com.byazt.je;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ae extends IInterface {
    void n(int i, int i2) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 88, 1551})
    public static abstract class n extends Binder implements ae {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static ae n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ae)) {
                return (ae) iInterfaceQueryLocalInterface;
            }
            return new C0208n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            n(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.je.ae$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 88, 1888})
        private static class C0208n implements ae {
            public static ae n;
            public IBinder qg;

            public C0208n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.je.ae
            public void n(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(i, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ae n() {
            return C0208n.n;
        }
    }
}
