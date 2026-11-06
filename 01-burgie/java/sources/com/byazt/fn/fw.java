package com.byazt.fn;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface fw extends IInterface {
    Uri pr(String str, String str2) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 157, 766})
    public static abstract class pr extends Binder implements fw {
        public pr() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static fw pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof fw)) {
                return (fw) iInterfaceQueryLocalInterface;
            }
            return new C0059pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    Uri uriPr = pr(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (uriPr != null) {
                        parcel2.writeInt(1);
                        uriPr.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.fn.fw$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 157, 1703})
        private static class C0059pr implements fw {
            public static fw pr;
            public IBinder hw;

            public C0059pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.fn.fw
            public Uri pr(String str, String str2) throws RemoteException {
                Uri uri;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().pr(str, str2);
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcelObtain2);
                    } else {
                        uri = null;
                    }
                    return uri;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static fw pr() {
            return C0059pr.pr;
        }
    }
}
