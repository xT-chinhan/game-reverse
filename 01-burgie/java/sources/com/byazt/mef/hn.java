package com.byazt.mef;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.auw.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface hn extends IInterface {
    DownloadInfo aj(int i) throws RemoteException;

    DownloadInfo c(int i, long j) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(int i) throws RemoteException;

    DownloadInfo fw(int i) throws RemoteException;

    DownloadInfo hn(int i, long j) throws RemoteException;

    List<com.byazt.auw.hw> hn(int i) throws RemoteException;

    List<DownloadInfo> hn(String str) throws RemoteException;

    void hn() throws RemoteException;

    DownloadInfo hw(int i) throws RemoteException;

    DownloadInfo hw(int i, long j) throws RemoteException;

    List<DownloadInfo> hw() throws RemoteException;

    List<DownloadInfo> hw(String str) throws RemoteException;

    void hw(int i, List<com.byazt.auw.hw> list) throws RemoteException;

    void hw(DownloadInfo downloadInfo) throws RemoteException;

    void hw(com.byazt.auw.hw hwVar) throws RemoteException;

    DownloadInfo pr(int i, int i2) throws RemoteException;

    DownloadInfo pr(int i, long j) throws RemoteException;

    DownloadInfo pr(int i, long j, String str, String str2) throws RemoteException;

    List<DownloadInfo> pr(String str) throws RemoteException;

    void pr() throws RemoteException;

    void pr(int i, int i2, int i3, int i4) throws RemoteException;

    void pr(int i, int i2, int i3, long j) throws RemoteException;

    void pr(int i, int i2, long j) throws RemoteException;

    void pr(int i, List<com.byazt.auw.hw> list) throws RemoteException;

    void pr(com.byazt.auw.hw hwVar) throws RemoteException;

    void pr(hw hwVar) throws RemoteException;

    boolean pr(int i) throws RemoteException;

    boolean pr(DownloadInfo downloadInfo) throws RemoteException;

    boolean uc(int i) throws RemoteException;

    DownloadInfo vk(int i) throws RemoteException;

    DownloadInfo x(int i, long j) throws RemoteException;

    List<DownloadInfo> x(String str) throws RemoteException;

    void x(int i) throws RemoteException;

    boolean x() throws RemoteException;

    DownloadInfo zo(int i) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 798, 116})
    public static abstract class pr extends Binder implements hn {
        public pr() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static hn pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof hn)) {
                return (hn) iInterfaceQueryLocalInterface;
            }
            return new C0133pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            com.byazt.auw.hw hwVarCreateFromParcel = null;
            DownloadInfo downloadInfoCreateFromParcel = null;
            DownloadInfo downloadInfoCreateFromParcel2 = null;
            com.byazt.auw.hw hwVarCreateFromParcel2 = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    pr();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zPr = pr(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPr ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoHw = hw(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoHw != null) {
                        parcel2.writeInt(1);
                        downloadInfoHw.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listPr = pr(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listPr);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listHw = hw(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listHw);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listHn = hn(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listHn);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listX = x(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listX);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listHw2 = hw();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listHw2);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.byazt.auw.hw> listHn2 = hn(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listHn2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    x(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (parcel.readInt() != 0) {
                        hwVarCreateFromParcel = com.byazt.auw.hw.CREATOR.createFromParcel(parcel);
                    }
                    pr(hwVarCreateFromParcel);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (parcel.readInt() != 0) {
                        hwVarCreateFromParcel2 = com.byazt.auw.hw.CREATOR.createFromParcel(parcel);
                    }
                    hw(hwVarCreateFromParcel2);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    pr(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    pr(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    pr(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoPr = pr(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoPr != null) {
                        parcel2.writeInt(1);
                        downloadInfoPr.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (parcel.readInt() != 0) {
                        downloadInfoCreateFromParcel2 = DownloadInfo.CREATOR.createFromParcel(parcel);
                    }
                    boolean zPr2 = pr(downloadInfoCreateFromParcel2);
                    parcel2.writeNoException();
                    parcel2.writeInt(zPr2 ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zC = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zUc = uc(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zUc ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    hn();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoFw = fw(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoFw != null) {
                        parcel2.writeInt(1);
                        downloadInfoFw.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoPr2 = pr(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoPr2 != null) {
                        parcel2.writeInt(1);
                        downloadInfoPr2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoPr3 = pr(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoPr3 != null) {
                        parcel2.writeInt(1);
                        downloadInfoPr3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoHw2 = hw(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoHw2 != null) {
                        parcel2.writeInt(1);
                        downloadInfoHw2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoZo = zo(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoZo != null) {
                        parcel2.writeInt(1);
                        downloadInfoZo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoHn = hn(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoHn != null) {
                        parcel2.writeInt(1);
                        downloadInfoHn.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoX = x(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoX != null) {
                        parcel2.writeInt(1);
                        downloadInfoX.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoC = c(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoC != null) {
                        parcel2.writeInt(1);
                        downloadInfoC.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoAj = aj(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoAj != null) {
                        parcel2.writeInt(1);
                        downloadInfoAj.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoVk = vk(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoVk != null) {
                        parcel2.writeInt(1);
                        downloadInfoVk.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zX = x();
                    parcel2.writeNoException();
                    parcel2.writeInt(zX ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zC2 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(zC2 ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (parcel.readInt() != 0) {
                        downloadInfoCreateFromParcel = DownloadInfo.CREATOR.createFromParcel(parcel);
                    }
                    hw(downloadInfoCreateFromParcel);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    pr(parcel.readInt(), parcel.createTypedArrayList(com.byazt.auw.hw.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    hw(parcel.readInt(), parcel.createTypedArrayList(com.byazt.auw.hw.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    pr(hw.pr.pr(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.mef.hn$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 798, 1248})
        private static class C0133pr implements hn {
            public static hn pr;
            public IBinder hw;

            public C0133pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.mef.hn
            public void pr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().pr();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn
            public boolean pr(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().pr(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo hw(int i) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(3, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().hw(i);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public List<DownloadInfo> pr(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(4, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().pr(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public List<DownloadInfo> hw(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(5, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().hw(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public List<DownloadInfo> hn(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(6, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().hn(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public List<DownloadInfo> x(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(7, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().x(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public List<DownloadInfo> hw() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hw.transact(8, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().hw();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public List<com.byazt.auw.hw> hn(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(9, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().hn(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.byazt.auw.hw.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void x(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(10, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().x(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void pr(com.byazt.auw.hw hwVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (hwVar != null) {
                        parcelObtain.writeInt(1);
                        hwVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.hw.transact(11, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().pr(hwVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void hw(com.byazt.auw.hw hwVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (hwVar != null) {
                        parcelObtain.writeInt(1);
                        hwVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.hw.transact(12, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().hw(hwVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void pr(int i, int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.hw.transact(13, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().pr(i, i2, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void pr(int i, int i2, int i3, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j);
                    if (!this.hw.transact(14, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().pr(i, i2, i3, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void pr(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (!this.hw.transact(15, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().pr(i, i2, i3, i4);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo pr(int i, int i2) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.hw.transact(16, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().pr(i, i2);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public boolean pr(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.hw.transact(17, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().pr(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public boolean c(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(18, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().c(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public boolean uc(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(19, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().uc(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void hn() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hw.transact(20, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().hn();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo fw(int i) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(21, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().fw(i);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo pr(int i, long j, String str, String str2) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.hw.transact(22, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().pr(i, j, str, str2);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo pr(int i, long j) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.hw.transact(23, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().pr(i, j);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo hw(int i, long j) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.hw.transact(24, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().hw(i, j);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo zo(int i) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(25, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().zo(i);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo hn(int i, long j) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.hw.transact(26, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().hn(i, j);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo x(int i, long j) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.hw.transact(27, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().x(i, j);
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

            @Override // com.byazt.mef.hn
            public DownloadInfo c(int i, long j) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.hw.transact(28, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().c(i, j);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo aj(int i) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(29, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().aj(i);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public DownloadInfo vk(int i) throws RemoteException {
                DownloadInfo downloadInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(30, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().vk(i);
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

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public boolean x() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hw.transact(31, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().x();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.hw.transact(32, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        return pr.uc().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void hw(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.hw.transact(33, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().hw(downloadInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void pr(int i, List<com.byazt.auw.hw> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.hw.transact(34, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().pr(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn, com.byazt.lj.vk
            public void hw(int i, List<com.byazt.auw.hw> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.hw.transact(35, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().hw(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.mef.hn
            public void pr(hw hwVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeStrongBinder(hwVar != null ? hwVar.asBinder() : null);
                    if (!this.hw.transact(36, parcelObtain, parcelObtain2, 0) && pr.uc() != null) {
                        pr.uc().pr(hwVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static hn uc() {
            return C0133pr.pr;
        }
    }
}
