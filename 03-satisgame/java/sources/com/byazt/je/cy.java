package com.byazt.je;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface cy extends IInterface {
    boolean n(long j, long j2, k kVar) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 88, 1086})
    public static abstract class n extends Binder implements cy {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static cy n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof cy)) {
                return (cy) iInterfaceQueryLocalInterface;
            }
            return new C0209n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean zN = n(parcel.readLong(), parcel.readLong(), k.n.n(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zN ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.je.cy$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 88, 2443})
        private static class C0209n implements cy {
            public static cy n;
            public IBinder qg;

            public C0209n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.je.cy
            public boolean n(long j, long j2, k kVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        return n.n().n(j, j2, kVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static cy n() {
            return C0209n.n;
        }
    }
}
