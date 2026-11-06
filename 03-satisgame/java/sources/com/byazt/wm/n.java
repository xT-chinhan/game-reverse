package com.byazt.wm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.je.cy;
import com.byazt.je.d;
import com.byazt.je.fs;
import com.byazt.je.hu;
import com.byazt.je.j;
import com.byazt.je.ln;
import com.byazt.je.py;
import com.byazt.je.rv;
import com.byazt.je.tj;
import com.byazt.je.w;
import com.byazt.je.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface n extends IInterface {
    x cp() throws RemoteException;

    int d() throws RemoteException;

    j fs() throws RemoteException;

    fs l() throws RemoteException;

    int n(int i) throws RemoteException;

    rv n(int i, int i2) throws RemoteException;

    DownloadInfo n() throws RemoteException;

    ln q() throws RemoteException;

    com.byazt.je.l qg() throws RemoteException;

    rv qg(int i) throws RemoteException;

    cy rv() throws RemoteException;

    d s(int i) throws RemoteException;

    hu s() throws RemoteException;

    tj tj() throws RemoteException;

    w w() throws RemoteException;

    py x() throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.wm.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static abstract class AbstractBinderC0387n extends Binder implements n {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0387n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static n n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof n)) {
                return (n) iInterfaceQueryLocalInterface;
            }
            return new C0388n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    DownloadInfo downloadInfoN = n();
                    parcel2.writeNoException();
                    if (downloadInfoN != null) {
                        parcel2.writeInt(1);
                        downloadInfoN.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.byazt.je.l lVarQg = qg();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(lVarQg != null ? lVarQg.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iN = n(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iN);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    rv rvVarN = n(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(rvVarN != null ? rvVarN.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    rv rvVarQg = qg(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(rvVarQg != null ? rvVarQg.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    hu huVarS = s();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(huVarS != null ? huVarS.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    ln lnVarQ = q();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(lnVarQ != null ? lnVarQ.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    fs fsVarL = l();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(fsVarL != null ? fsVarL.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    w wVarW = w();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(wVarW != null ? wVarW.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    py pyVarX = x();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(pyVarX != null ? pyVarX.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    j jVarFs = fs();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(jVarFs != null ? jVarFs.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    cy cyVarRv = rv();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(cyVarRv != null ? cyVarRv.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    tj tjVarTj = tj();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(tjVarTj != null ? tjVarTj.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    x xVarCp = cp();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(xVarCp != null ? xVarCp.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iD = d();
                    parcel2.writeNoException();
                    parcel2.writeInt(iD);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    d dVarS = s(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(dVarS != null ? dVarS.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.wm.n$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 512})
        private static class C0388n implements n {
            public static n n;
            public IBinder qg;

            public C0388n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.wm.n
            public DownloadInfo n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().n();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public com.byazt.je.l qg() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().qg();
                    }
                    parcelObtain2.readException();
                    return com.byazt.je.l.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public int n(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().n(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public rv n(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.qg.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().n(i, i2);
                    }
                    parcelObtain2.readException();
                    return rv.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public rv qg(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().qg(i);
                    }
                    parcelObtain2.readException();
                    return rv.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public hu s() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().s();
                    }
                    parcelObtain2.readException();
                    return hu.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public ln q() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().q();
                    }
                    parcelObtain2.readException();
                    return ln.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public fs l() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().l();
                    }
                    parcelObtain2.readException();
                    return fs.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public w w() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().w();
                    }
                    parcelObtain2.readException();
                    return w.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public py x() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().x();
                    }
                    parcelObtain2.readException();
                    return py.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public j fs() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().fs();
                    }
                    parcelObtain2.readException();
                    return j.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public cy rv() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().rv();
                    }
                    parcelObtain2.readException();
                    return cy.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public tj tj() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().tj();
                    }
                    parcelObtain2.readException();
                    return tj.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public x cp() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().cp();
                    }
                    parcelObtain2.readException();
                    return x.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public int d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.qg.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.wm.n
            public d s(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0387n.oa() != null) {
                        return AbstractBinderC0387n.oa().s(i);
                    }
                    parcelObtain2.readException();
                    return d.n.n(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static n oa() {
            return C0388n.n;
        }
    }
}
