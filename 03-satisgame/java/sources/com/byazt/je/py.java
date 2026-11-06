package com.byazt.je;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface py extends IInterface {
    boolean n(a aVar) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 88, 1863})
    public static abstract class n extends Binder implements py {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static py n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof py)) {
                return (py) iInterfaceQueryLocalInterface;
            }
            return new C0217n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean zN = n(a.n.n(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zN ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.je.py$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 88, 1289})
        private static class C0217n implements py {
            public static py n;
            public IBinder qg;

            public C0217n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.je.py
            public boolean n(a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        return n.n().n(aVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static py n() {
            return C0217n.n;
        }
    }
}
