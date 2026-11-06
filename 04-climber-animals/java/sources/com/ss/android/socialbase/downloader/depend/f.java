package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface f extends IInterface {
    void ms(int i, int i2) throws RemoteException;

    public static abstract class ms extends Binder implements f {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static f ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof f)) {
                return (f) iInterfaceQueryLocalInterface;
            }
            return new C0553ms(iBinder);
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
            ms(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.f$ms$ms, reason: collision with other inner class name */
        private static class C0553ms implements f {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static f f4639ms;
            private IBinder xr;

            C0553ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.ss.android.socialbase.downloader.depend.f
            public void ms(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.ms() != null) {
                        ms.ms().ms(i, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static f ms() {
            return C0553ms.f4639ms;
        }
    }
}
