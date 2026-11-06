package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface t extends IInterface {
    void ms(List<String> list) throws RemoteException;

    boolean ms() throws RemoteException;

    public static abstract class ms extends Binder implements t {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        public static t ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof t)) {
                return (t) iInterfaceQueryLocalInterface;
            }
            return new C0560ms(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                ms(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean zMs = ms();
            parcel2.writeNoException();
            parcel2.writeInt(zMs ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.t$ms$ms, reason: collision with other inner class name */
        private static class C0560ms implements t {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static t f4647ms;
            private IBinder xr;

            C0560ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public void ms(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    parcelObtain.writeStringList(list);
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.xr() != null) {
                        ms.xr().ms(list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public boolean ms() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    if (!this.xr.transact(2, parcelObtain, parcelObtain2, 0) && ms.xr() != null) {
                        return ms.xr().ms();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static t xr() {
            return C0560ms.f4647ms;
        }
    }
}
