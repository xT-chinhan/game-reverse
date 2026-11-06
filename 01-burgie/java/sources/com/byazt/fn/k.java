package com.byazt.fn;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.auw.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public interface k extends IInterface {
    boolean hw(DownloadInfo downloadInfo) throws RemoteException;

    void pr(DownloadInfo downloadInfo) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 157, 785})
    public static abstract class pr extends Binder implements k {
        public pr() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
        }

        public static k pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof k)) {
                return (k) iInterfaceQueryLocalInterface;
            }
            return new C0061pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            DownloadInfo downloadInfoCreateFromParcel = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (parcel.readInt() != 0) {
                        downloadInfoCreateFromParcel = DownloadInfo.CREATOR.createFromParcel(parcel);
                    }
                    pr(downloadInfoCreateFromParcel);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (parcel.readInt() != 0) {
                        downloadInfoCreateFromParcel = DownloadInfo.CREATOR.createFromParcel(parcel);
                    }
                    boolean zHw = hw(downloadInfoCreateFromParcel);
                    parcel2.writeNoException();
                    parcel2.writeInt(zHw ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.fn.k$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 157, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION})
        private static class C0061pr implements k {
            public static k pr;
            public IBinder hw;

            public C0061pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.fn.k
            public void pr(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        pr.pr().pr(downloadInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fn.k
            public boolean hw(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().hw(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static k pr() {
            return C0061pr.pr;
        }
    }
}
