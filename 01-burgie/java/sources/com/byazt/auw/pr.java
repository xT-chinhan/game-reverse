package com.byazt.auw;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.fn.aj;
import com.byazt.fn.cz;
import com.byazt.fn.fw;
import com.byazt.fn.k;
import com.byazt.fn.n;
import com.byazt.fn.nl;
import com.byazt.fn.nt;
import com.byazt.fn.uc;
import com.byazt.fn.vk;
import com.byazt.fn.z;
import com.byazt.fn.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes.dex */
public interface pr extends IInterface {
    nt aj() throws RemoteException;

    zo c() throws RemoteException;

    cz fw() throws RemoteException;

    k hn(int i) throws RemoteException;

    z hn() throws RemoteException;

    aj hw(int i) throws RemoteException;

    com.byazt.fn.c hw() throws RemoteException;

    int k() throws RemoteException;

    int pr(int i) throws RemoteException;

    DownloadInfo pr() throws RemoteException;

    aj pr(int i, int i2) throws RemoteException;

    uc uc() throws RemoteException;

    vk vk() throws RemoteException;

    fw w() throws RemoteException;

    nl x() throws RemoteException;

    n zo() throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.auw.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static abstract class AbstractBinderC0018pr extends Binder implements pr {
        public AbstractBinderC0018pr() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static pr pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof pr)) {
                return (pr) iInterfaceQueryLocalInterface;
            }
            return new C0019pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    DownloadInfo downloadInfoPr = pr();
                    parcel2.writeNoException();
                    if (downloadInfoPr != null) {
                        parcel2.writeInt(1);
                        downloadInfoPr.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.byazt.fn.c cVarHw = hw();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(cVarHw != null ? cVarHw.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iPr = pr(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iPr);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    aj ajVarPr = pr(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(ajVarPr != null ? ajVarPr.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    aj ajVarHw = hw(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(ajVarHw != null ? ajVarHw.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    z zVarHn = hn();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zVarHn != null ? zVarHn.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    nl nlVarX = x();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(nlVarX != null ? nlVarX.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    zo zoVarC = c();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zoVarC != null ? zoVarC.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    uc ucVarUc = uc();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(ucVarUc != null ? ucVarUc.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    cz czVarFw = fw();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(czVarFw != null ? czVarFw.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    n nVarZo = zo();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(nVarZo != null ? nVarZo.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    nt ntVarAj = aj();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(ntVarAj != null ? ntVarAj.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    vk vkVarVk = vk();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(vkVarVk != null ? vkVarVk.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    fw fwVarW = w();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(fwVarW != null ? fwVarW.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iK = k();
                    parcel2.writeNoException();
                    parcel2.writeInt(iK);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    k kVarHn = hn(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(kVarHn != null ? kVarHn.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.auw.pr$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL})
        private static class C0019pr implements pr {
            public static pr pr;
            public IBinder hw;

            public C0019pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.auw.pr
            public DownloadInfo pr() throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().pr();
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        downloadInfoCreateFromParcel = DownloadInfo.CREATOR.createFromParcel(parcelObtain2);
                    } else {
                        downloadInfoCreateFromParcel = null;
                    }
                    return downloadInfoCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public com.byazt.fn.c hw() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().hw();
                    }
                    parcelObtain2.readException();
                    return com.byazt.fn.c.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public int pr(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().pr(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public aj pr(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.hw.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().pr(i, i2);
                    }
                    parcelObtain2.readException();
                    return aj.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public aj hw(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().hw(i);
                    }
                    parcelObtain2.readException();
                    return aj.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public z hn() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().hn();
                    }
                    parcelObtain2.readException();
                    return z.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public nl x() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().x();
                    }
                    parcelObtain2.readException();
                    return nl.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public zo c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().c();
                    }
                    parcelObtain2.readException();
                    return zo.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public uc uc() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().uc();
                    }
                    parcelObtain2.readException();
                    return uc.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public cz fw() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().fw();
                    }
                    parcelObtain2.readException();
                    return cz.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public n zo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().zo();
                    }
                    parcelObtain2.readException();
                    return n.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public nt aj() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().aj();
                    }
                    parcelObtain2.readException();
                    return nt.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public vk vk() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().vk();
                    }
                    parcelObtain2.readException();
                    return vk.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public fw w() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().w();
                    }
                    parcelObtain2.readException();
                    return fw.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public int k() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hw.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().k();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.auw.pr
            public k hn(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0018pr.m() != null) {
                        return AbstractBinderC0018pr.m().hn(i);
                    }
                    parcelObtain2.readException();
                    return k.pr.pr(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static pr m() {
            return C0019pr.pr;
        }
    }
}
