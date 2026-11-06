package com.ss.android.socialbase.downloader.xr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ah extends IInterface {
    DownloadInfo ab(int i) throws RemoteException;

    DownloadInfo ah(int i, long j) throws RemoteException;

    List<com.ss.android.socialbase.downloader.model.xr> ah(int i) throws RemoteException;

    List<DownloadInfo> ah(String str) throws RemoteException;

    void ah() throws RemoteException;

    boolean c(int i) throws RemoteException;

    DownloadInfo ch(int i) throws RemoteException;

    DownloadInfo d(int i, long j) throws RemoteException;

    List<DownloadInfo> d(String str) throws RemoteException;

    void d(int i) throws RemoteException;

    boolean d() throws RemoteException;

    DownloadInfo ka(int i, long j) throws RemoteException;

    boolean ka() throws RemoteException;

    boolean ka(int i) throws RemoteException;

    DownloadInfo ms(int i, int i2) throws RemoteException;

    DownloadInfo ms(int i, long j) throws RemoteException;

    DownloadInfo ms(int i, long j, String str, String str2) throws RemoteException;

    List<DownloadInfo> ms(String str) throws RemoteException;

    void ms() throws RemoteException;

    void ms(int i, int i2, int i3, int i4) throws RemoteException;

    void ms(int i, int i2, int i3, long j) throws RemoteException;

    void ms(int i, int i2, long j) throws RemoteException;

    void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException;

    void ms(com.ss.android.socialbase.downloader.model.xr xrVar) throws RemoteException;

    void ms(xr xrVar) throws RemoteException;

    boolean ms(int i) throws RemoteException;

    boolean ms(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo ny(int i) throws RemoteException;

    DownloadInfo x(int i) throws RemoteException;

    DownloadInfo xr(int i) throws RemoteException;

    DownloadInfo xr(int i, long j) throws RemoteException;

    List<DownloadInfo> xr() throws RemoteException;

    List<DownloadInfo> xr(String str) throws RemoteException;

    void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException;

    void xr(DownloadInfo downloadInfo) throws RemoteException;

    void xr(com.ss.android.socialbase.downloader.model.xr xrVar) throws RemoteException;

    public static abstract class ms extends Binder implements ah {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static ah ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ah)) {
                return (ah) iInterfaceQueryLocalInterface;
            }
            return new C0575ms(iBinder);
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
                    ms();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zMs = ms(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zMs ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoXr = xr(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoXr != null) {
                        parcel2.writeInt(1);
                        downloadInfoXr.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listMs = ms(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listMs);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listXr = xr(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listXr);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listAh = ah(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listAh);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listD = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listD);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listXr2 = xr();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listXr2);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.model.xr> listAh2 = ah(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listAh2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    d(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ms(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.xr.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xr(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.xr.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ms(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ms(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ms(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoMs = ms(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoMs != null) {
                        parcel2.writeInt(1);
                        downloadInfoMs.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zMs2 = ms(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zMs2 ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zKa = ka(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zKa ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zC = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ah();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoAb = ab(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoAb != null) {
                        parcel2.writeInt(1);
                        downloadInfoAb.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoMs2 = ms(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoMs2 != null) {
                        parcel2.writeInt(1);
                        downloadInfoMs2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoMs3 = ms(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoMs3 != null) {
                        parcel2.writeInt(1);
                        downloadInfoMs3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoXr2 = xr(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoXr2 != null) {
                        parcel2.writeInt(1);
                        downloadInfoXr2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 25:
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
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoAh = ah(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoAh != null) {
                        parcel2.writeInt(1);
                        downloadInfoAh.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoD = d(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoD != null) {
                        parcel2.writeInt(1);
                        downloadInfoD.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoKa = ka(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoKa != null) {
                        parcel2.writeInt(1);
                        downloadInfoKa.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoNy = ny(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoNy != null) {
                        parcel2.writeInt(1);
                        downloadInfoNy.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoCh = ch(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoCh != null) {
                        parcel2.writeInt(1);
                        downloadInfoCh.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zD = d();
                    parcel2.writeNoException();
                    parcel2.writeInt(zD ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zKa2 = ka();
                    parcel2.writeNoException();
                    parcel2.writeInt(zKa2 ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xr(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ms(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.xr.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    xr(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.xr.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ms(xr.ms.ms(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.xr.ah$ms$ms, reason: collision with other inner class name */
        private static class C0575ms implements ah {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static ah f4805ms;
            private IBinder xr;

            C0575ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void ms() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().ms();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public boolean ms(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(2, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ms(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo xr(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(3, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().xr(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public List<DownloadInfo> ms(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(4, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ms(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public List<DownloadInfo> xr(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(5, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().xr(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public List<DownloadInfo> ah(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(6, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ah(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public List<DownloadInfo> d(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(7, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().d(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public List<DownloadInfo> xr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xr.transact(8, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().xr();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public List<com.ss.android.socialbase.downloader.model.xr> ah(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(9, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ah(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.xr.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void d(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(10, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().d(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void ms(com.ss.android.socialbase.downloader.model.xr xrVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (xrVar != null) {
                        parcelObtain.writeInt(1);
                        xrVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.xr.transact(11, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().ms(xrVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void xr(com.ss.android.socialbase.downloader.model.xr xrVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (xrVar != null) {
                        parcelObtain.writeInt(1);
                        xrVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.xr.transact(12, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().xr(xrVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void ms(int i, int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(13, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().ms(i, i2, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void ms(int i, int i2, int i3, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(14, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().ms(i, i2, i3, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void ms(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (!this.xr.transact(15, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().ms(i, i2, i3, i4);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo ms(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.xr.transact(16, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ms(i, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public boolean ms(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.xr.transact(17, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ms(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public boolean ka(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(18, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ka(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public boolean c(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(19, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().c(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void ah() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xr.transact(20, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().ah();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo ab(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(21, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ab(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo ms(int i, long j, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.xr.transact(22, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ms(i, j, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo ms(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(23, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ms(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo xr(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(24, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().xr(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo x(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(25, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().x(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo ah(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(26, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ah(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo d(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(27, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().d(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo ka(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(28, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ka(i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo ny(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(29, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ny(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public DownloadInfo ch(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(30, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ch(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public boolean d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xr.transact(31, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public boolean ka() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.xr.transact(32, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        return ms.c().ka();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void xr(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.xr.transact(33, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().xr(downloadInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.xr.transact(34, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().ms(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.xr.transact(35, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().xr(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.xr.ah
            public void ms(xr xrVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeStrongBinder(xrVar != null ? xrVar.asBinder() : null);
                    if (!this.xr.transact(36, parcelObtain, parcelObtain2, 0) && ms.c() != null) {
                        ms.c().ms(xrVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ah c() {
            return C0575ms.f4805ms;
        }
    }
}
