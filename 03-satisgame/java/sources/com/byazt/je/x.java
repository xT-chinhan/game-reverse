package com.byazt.je;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface x extends IInterface {
    Uri n(String str, String str2) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 88, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    public static abstract class n extends Binder implements x {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static x n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof x)) {
                return (x) iInterfaceQueryLocalInterface;
            }
            return new C0221n(iBinder);
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
            Uri uriN = n(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (uriN != null) {
                parcel2.writeInt(1);
                uriN.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.je.x$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 88, 1471})
        private static class C0221n implements x {
            public static x n;
            public IBinder qg;

            public C0221n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.je.x
            public Uri n(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        return n.n().n(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static x n() {
            return C0221n.n;
        }
    }
}
