package com.byazt.u;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface s extends IInterface {
    DownloadInfo fs(int i) throws RemoteException;

    DownloadInfo l(int i, long j) throws RemoteException;

    boolean l() throws RemoteException;

    boolean l(int i) throws RemoteException;

    DownloadInfo n(int i, int i2) throws RemoteException;

    DownloadInfo n(int i, long j) throws RemoteException;

    DownloadInfo n(int i, long j, String str, String str2) throws RemoteException;

    List<DownloadInfo> n(String str) throws RemoteException;

    void n() throws RemoteException;

    void n(int i, int i2, int i3, int i4) throws RemoteException;

    void n(int i, int i2, int i3, long j) throws RemoteException;

    void n(int i, int i2, long j) throws RemoteException;

    void n(int i, List<com.byazt.wm.qg> list) throws RemoteException;

    void n(qg qgVar) throws RemoteException;

    void n(com.byazt.wm.qg qgVar) throws RemoteException;

    boolean n(int i) throws RemoteException;

    boolean n(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo q(int i, long j) throws RemoteException;

    List<DownloadInfo> q(String str) throws RemoteException;

    void q(int i) throws RemoteException;

    boolean q() throws RemoteException;

    DownloadInfo qg(int i) throws RemoteException;

    DownloadInfo qg(int i, long j) throws RemoteException;

    List<DownloadInfo> qg() throws RemoteException;

    List<DownloadInfo> qg(String str) throws RemoteException;

    void qg(int i, List<com.byazt.wm.qg> list) throws RemoteException;

    void qg(DownloadInfo downloadInfo) throws RemoteException;

    void qg(com.byazt.wm.qg qgVar) throws RemoteException;

    DownloadInfo rv(int i) throws RemoteException;

    DownloadInfo s(int i, long j) throws RemoteException;

    List<com.byazt.wm.qg> s(int i) throws RemoteException;

    List<DownloadInfo> s(String str) throws RemoteException;

    void s() throws RemoteException;

    DownloadInfo tj(int i) throws RemoteException;

    boolean w(int i) throws RemoteException;

    DownloadInfo x(int i) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 745, 546})
    public static abstract class n extends Binder implements s {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static s n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof s)) {
                return (s) iInterfaceQueryLocalInterface;
            }
            return new C0361n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    n();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zN = n(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zN ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoQg = qg(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoQg != null) {
                        parcel2.writeInt(1);
                        downloadInfoQg.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listN = n(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listN);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listQg = qg(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listQg);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listS = s(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listS);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listQ = q(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listQ);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listQg2 = qg();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listQg2);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.byazt.wm.qg> listS2 = s(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listS2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    q(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    n(parcel.readInt() != 0 ? com.byazt.wm.qg.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    qg(parcel.readInt() != 0 ? com.byazt.wm.qg.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    n(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    n(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    n(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoN = n(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoN != null) {
                        parcel2.writeInt(1);
                        downloadInfoN.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zN2 = n(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zN2 ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zL = l(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zL ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zW = w(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zW ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    s();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoX = x(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoX != null) {
                        parcel2.writeInt(1);
                        downloadInfoX.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoN2 = n(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoN2 != null) {
                        parcel2.writeInt(1);
                        downloadInfoN2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoN3 = n(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoN3 != null) {
                        parcel2.writeInt(1);
                        downloadInfoN3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoQg2 = qg(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoQg2 != null) {
                        parcel2.writeInt(1);
                        downloadInfoQg2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoFs = fs(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoFs != null) {
                        parcel2.writeInt(1);
                        downloadInfoFs.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoS = s(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoS != null) {
                        parcel2.writeInt(1);
                        downloadInfoS.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoQ = q(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoQ != null) {
                        parcel2.writeInt(1);
                        downloadInfoQ.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoL = l(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoL != null) {
                        parcel2.writeInt(1);
                        downloadInfoL.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoRv = rv(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoRv != null) {
                        parcel2.writeInt(1);
                        downloadInfoRv.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoTj = tj(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoTj != null) {
                        parcel2.writeInt(1);
                        downloadInfoTj.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zQ = q();
                    parcel2.writeNoException();
                    parcel2.writeInt(zQ ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zL2 = l();
                    parcel2.writeNoException();
                    parcel2.writeInt(zL2 ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    qg(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    n(parcel.readInt(), parcel.createTypedArrayList(com.byazt.wm.qg.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    qg(parcel.readInt(), parcel.createTypedArrayList(com.byazt.wm.qg.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    n(qg.n.n(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.u.s$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 745, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT})
        private static class C0361n implements s {
            public static s n;
            public IBinder qg;

            public C0361n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.u.s
            public void n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().n();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s
            public boolean n(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().n(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo qg(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(3, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().qg(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public List<DownloadInfo> n(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(4, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().n(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public List<DownloadInfo> qg(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(5, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().qg(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public List<DownloadInfo> s(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(6, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().s(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public List<DownloadInfo> q(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(7, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().q(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public List<DownloadInfo> qg() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.qg.transact(8, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().qg();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public List<com.byazt.wm.qg> s(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(9, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().s(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.byazt.wm.qg.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void q(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(10, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().q(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void n(com.byazt.wm.qg qgVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (qgVar != null) {
                        parcelObtain.writeInt(1);
                        qgVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.qg.transact(11, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().n(qgVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void qg(com.byazt.wm.qg qgVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (qgVar != null) {
                        parcelObtain.writeInt(1);
                        qgVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.qg.transact(12, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().qg(qgVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void n(int i, int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.qg.transact(13, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().n(i, i2, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void n(int i, int i2, int i3, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j);
                    if (!this.qg.transact(14, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().n(i, i2, i3, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void n(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (!this.qg.transact(15, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().n(i, i2, i3, i4);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo n(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.qg.transact(16, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().n(i, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public boolean n(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.qg.transact(17, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().n(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public boolean l(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(18, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().l(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public boolean w(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(19, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().w(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void s() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.qg.transact(20, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().s();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo x(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(21, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().x(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo n(int i, long j, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.qg.transact(22, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().n(i, j, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo n(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.qg.transact(23, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().n(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo qg(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.qg.transact(24, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().qg(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo fs(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(25, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().fs(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo s(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.qg.transact(26, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().s(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo q(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.qg.transact(27, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().q(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s
            public DownloadInfo l(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.qg.transact(28, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().l(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo rv(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(29, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().rv(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public DownloadInfo tj(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(30, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().tj(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public boolean q() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.qg.transact(31, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().q();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public boolean l() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.qg.transact(32, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        return n.w().l();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void qg(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.qg.transact(33, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().qg(downloadInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void n(int i, List<com.byazt.wm.qg> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.qg.transact(34, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().n(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s, com.byazt.xv.tj
            public void qg(int i, List<com.byazt.wm.qg> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.qg.transact(35, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().qg(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.u.s
            public void n(qg qgVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeStrongBinder(qgVar != null ? qgVar.asBinder() : null);
                    if (!this.qg.transact(36, parcelObtain, parcelObtain2, 0) && n.w() != null) {
                        n.w().n(qgVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static s w() {
            return C0361n.n;
        }
    }
}
