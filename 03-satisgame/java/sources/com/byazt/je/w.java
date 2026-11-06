package com.byazt.je;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface w extends IInterface {
    void n(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 88, 108})
    public static abstract class n extends Binder implements w {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        public static w n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof w)) {
                return (w) iInterfaceQueryLocalInterface;
            }
            return new C0220n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            n(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.je.w$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 88, 909})
        private static class C0220n implements w {
            public static w n;
            public IBinder qg;

            public C0220n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.je.w
            public void n(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (baseException != null) {
                        parcelObtain.writeInt(1);
                        baseException.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(downloadInfo, baseException, i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static w n() {
            return C0220n.n;
        }
    }
}
