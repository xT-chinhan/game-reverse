package com.ss.android.socialbase.downloader.depend;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ab extends IInterface {
    Uri ms(String str, String str2) throws RemoteException;

    public static abstract class ms extends Binder implements ab {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static ab ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ab)) {
                return (ab) iInterfaceQueryLocalInterface;
            }
            return new C0549ms(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri uriMs = ms(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (uriMs != null) {
                parcel2.writeInt(1);
                uriMs.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.ab$ms$ms, reason: collision with other inner class name */
        private static class C0549ms implements ab {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static ab f4635ms;
            private IBinder xr;

            C0549ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ab
            public Uri ms(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.ms() != null) {
                        return ms.ms().ms(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ab ms() {
            return C0549ms.f4635ms;
        }
    }
}
