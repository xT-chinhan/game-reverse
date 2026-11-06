package com.byazt.fn;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public interface vk extends IInterface {
    int[] hw() throws RemoteException;

    String pr() throws RemoteException;

    void pr(String str) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 157, 590})
    public static abstract class pr extends Binder implements vk {
        public pr() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static vk pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof vk)) {
                return (vk) iInterfaceQueryLocalInterface;
            }
            return new C0067pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    pr(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    String strPr = pr();
                    parcel2.writeNoException();
                    parcel2.writeString(strPr);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    int[] iArrHw = hw();
                    parcel2.writeNoException();
                    parcel2.writeIntArray(iArrHw);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.fn.vk$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 157, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_SPILT_VOICE_WRITE})
        private static class C0067pr implements vk {
            public static vk pr;
            public IBinder hw;

            public C0067pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.fn.vk
            public void pr(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.hn() != null) {
                        pr.hn().pr(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fn.vk
            public String pr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && pr.hn() != null) {
                        return pr.hn().pr();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fn.vk
            public int[] hw() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.hw.transact(3, parcelObtain, parcelObtain2, 0) && pr.hn() != null) {
                        return pr.hn().hw();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createIntArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static vk hn() {
            return C0067pr.pr;
        }
    }
}
