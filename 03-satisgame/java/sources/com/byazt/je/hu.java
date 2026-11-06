package com.byazt.je;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface hu extends IInterface {
    String n() throws RemoteException;

    void n(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException;

    boolean n(boolean z) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 88, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES})
    public static abstract class n extends Binder implements hu {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        public static hu n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof hu)) {
                return (hu) iInterfaceQueryLocalInterface;
            }
            return new C0212n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                n(parcel.readInt(), parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                boolean zN = n(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zN ? 1 : 0);
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            String strN = n();
            parcel2.writeNoException();
            parcel2.writeString(strN);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.je.hu$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 88, 708})
        private static class C0212n implements hu {
            public static hu n;
            public IBinder qg;

            public C0212n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.je.hu
            public void n(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    parcelObtain.writeInt(i);
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.qg() != null) {
                        n.qg().n(i, downloadInfo, str, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.je.hu
            public boolean n(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && n.qg() != null) {
                        return n.qg().n(z);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.je.hu
            public String n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    if (!this.qg.transact(3, parcelObtain, parcelObtain2, 0) && n.qg() != null) {
                        return n.qg().n();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static hu qg() {
            return C0212n.n;
        }
    }
}
