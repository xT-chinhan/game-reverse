package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface pc extends IInterface {
    long ms(int i, int i2) throws RemoteException;

    public static abstract class ms extends Binder implements pc {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static pc ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof pc)) {
                return (pc) iInterfaceQueryLocalInterface;
            }
            return new C0558ms(iBinder);
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
            long jMs = ms(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(jMs);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.pc$ms$ms, reason: collision with other inner class name */
        private static class C0558ms implements pc {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static pc f4645ms;
            private IBinder xr;

            C0558ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.ss.android.socialbase.downloader.depend.pc
            public long ms(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.ms() != null) {
                        return ms.ms().ms(i, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static pc ms() {
            return C0558ms.f4645ms;
        }
    }
}
