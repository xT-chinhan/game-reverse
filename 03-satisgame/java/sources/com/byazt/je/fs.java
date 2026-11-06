package com.byazt.je;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface fs extends IInterface {
    boolean n() throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 88, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    public static abstract class n extends Binder implements fs {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static fs n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof fs)) {
                return (fs) iInterfaceQueryLocalInterface;
            }
            return new C0211n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean zN = n();
            parcel2.writeNoException();
            parcel2.writeInt(zN ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.je.fs$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 88, 856})
        private static class C0211n implements fs {
            public static fs n;
            public IBinder qg;

            public C0211n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.je.fs
            public boolean n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.qg() != null) {
                        return n.qg().n();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static fs qg() {
            return C0211n.n;
        }
    }
}
