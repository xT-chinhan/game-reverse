package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ny extends IInterface {
    boolean ab(int i) throws RemoteException;

    List<DownloadInfo> ah(String str) throws RemoteException;

    void ah(int i) throws RemoteException;

    void ah(int i, boolean z) throws RemoteException;

    boolean ah() throws RemoteException;

    boolean ao(int i) throws RemoteException;

    int c(int i) throws RemoteException;

    boolean c() throws RemoteException;

    void ch(int i) throws RemoteException;

    List<DownloadInfo> d(String str) throws RemoteException;

    void d(int i) throws RemoteException;

    void d(int i, boolean z) throws RemoteException;

    boolean d() throws RemoteException;

    w h(int i) throws RemoteException;

    boolean hi(int i) throws RemoteException;

    long ka(int i) throws RemoteException;

    List<DownloadInfo> ka(String str) throws RemoteException;

    void ka() throws RemoteException;

    int ms(String str, String str2) throws RemoteException;

    List<DownloadInfo> ms(String str) throws RemoteException;

    void ms() throws RemoteException;

    void ms(int i) throws RemoteException;

    void ms(int i, int i2) throws RemoteException;

    void ms(int i, int i2, int i3, int i4) throws RemoteException;

    void ms(int i, int i2, int i3, long j) throws RemoteException;

    void ms(int i, int i2, long j) throws RemoteException;

    void ms(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z) throws RemoteException;

    void ms(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z, boolean z2) throws RemoteException;

    void ms(int i, long j) throws RemoteException;

    void ms(int i, Notification notification) throws RemoteException;

    void ms(int i, w wVar) throws RemoteException;

    void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException;

    void ms(int i, boolean z) throws RemoteException;

    void ms(f fVar) throws RemoteException;

    void ms(com.ss.android.socialbase.downloader.model.ms msVar) throws RemoteException;

    void ms(com.ss.android.socialbase.downloader.model.xr xrVar) throws RemoteException;

    void ms(List<String> list) throws RemoteException;

    void ms(boolean z) throws RemoteException;

    boolean ms(DownloadInfo downloadInfo) throws RemoteException;

    List<com.ss.android.socialbase.downloader.model.xr> ny(int i) throws RemoteException;

    g qv(int i) throws RemoteException;

    void sl(int i) throws RemoteException;

    boolean u(int i) throws RemoteException;

    void ub(int i) throws RemoteException;

    DownloadInfo x(int i) throws RemoteException;

    DownloadInfo xr(String str, String str2) throws RemoteException;

    List<DownloadInfo> xr() throws RemoteException;

    List<DownloadInfo> xr(String str) throws RemoteException;

    void xr(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z) throws RemoteException;

    void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException;

    void xr(int i, boolean z) throws RemoteException;

    void xr(List<String> list) throws RemoteException;

    boolean xr(int i) throws RemoteException;

    boolean xr(DownloadInfo downloadInfo) throws RemoteException;

    com.ss.android.socialbase.downloader.depend.ab y(int i) throws RemoteException;

    int zb(int i) throws RemoteException;

    public static abstract class ms extends Binder implements ny {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static ny ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ny)) {
                return (ny) iInterfaceQueryLocalInterface;
            }
            return new C0565ms(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(com.ss.android.socialbase.downloader.model.ms.AbstractBinderC0568ms.ms(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zXr = xr(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zXr ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ah(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    d(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    long jKa = ka(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jKa);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int iC = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iC);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zAb = ab(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zAb ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    DownloadInfo downloadInfoX = x(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoX != null) {
                        parcel2.writeInt(1);
                        downloadInfoX.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listMs = ms(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listMs);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.model.xr> listNy = ny(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listNy);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int iMs = ms(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iMs);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    DownloadInfo downloadInfoXr = xr(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoXr != null) {
                        parcel2.writeInt(1);
                        downloadInfoXr.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listXr = xr(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listXr);
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listAh = ah(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listAh);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listD = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listD);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listXr2 = xr();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listXr2);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    xr(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    xr(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ah(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ch(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readInt(), com.ss.android.socialbase.downloader.depend.ny.ms.ms(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    xr(parcel.readInt(), parcel.readInt(), com.ss.android.socialbase.downloader.depend.ny.ms.ms(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readInt(), com.ss.android.socialbase.downloader.depend.ny.ms.ms(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zMs = ms(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zMs ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt() != 0);
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zAh = ah();
                    parcel2.writeNoException();
                    parcel2.writeInt(zAh ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listKa = ka(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listKa);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zHi = hi(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zHi ? 1 : 0);
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    sl(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zD = d();
                    parcel2.writeNoException();
                    parcel2.writeInt(zD ? 1 : 0);
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    d(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int iZb = zb(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iZb);
                    return true;
                case 38:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.xr.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zXr2 = xr(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zXr2 ? 1 : 0);
                    return true;
                case 40:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zU = u(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zU ? 1 : 0);
                    return true;
                case 41:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ub(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zAo = ao(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zAo ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ka();
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.xr.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    xr(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.xr.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(f.ms.ms(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    w wVarH = h(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(wVarH != null ? wVarH.asBinder() : null);
                    return true;
                case 52:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    g gVarQv = qv(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(gVarQv != null ? gVarQv.asBinder() : null);
                    return true;
                case 53:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), w.ms.ms(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    com.ss.android.socialbase.downloader.depend.ab abVarY = y(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(abVarY != null ? abVarY.asBinder() : null);
                    return true;
                case 55:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zC = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 56:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ms(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.ny$ms$ms, reason: collision with other inner class name */
        private static class C0565ms implements ny {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static ny f4668ms;
            private IBinder xr;

            C0565ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(com.ss.android.socialbase.downloader.model.ms msVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStrongBinder(msVar != null ? msVar.asBinder() : null);
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(msVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(2, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.xr.transact(3, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean xr(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(4, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().xr(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ah(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(5, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ah(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void d(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(6, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().d(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xr.transact(7, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public long ka(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(8, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ka(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public int c(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(9, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().c(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean ab(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(10, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ab(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public DownloadInfo x(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(11, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().x(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public List<DownloadInfo> ms(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(12, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ms(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public List<com.ss.android.socialbase.downloader.model.xr> ny(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(13, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ny(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.xr.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public int ms(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.xr.transact(14, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ms(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public DownloadInfo xr(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.xr.transact(15, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().xr(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public List<DownloadInfo> xr(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(16, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().xr(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public List<DownloadInfo> ah(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(17, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ah(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public List<DownloadInfo> d(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(18, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().d(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public List<DownloadInfo> xr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xr.transact(19, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().xr();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStringList(list);
                    if (!this.xr.transact(20, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void xr(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStringList(list);
                    if (!this.xr.transact(21, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().xr(list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void xr(int i, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.xr.transact(22, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().xr(i, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ah(int i, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.xr.transact(23, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ah(i, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ch(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(24, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ch(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(nyVar != null ? nyVar.asBinder() : null);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.xr.transact(25, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, i2, nyVar, i3, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void xr(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(nyVar != null ? nyVar.asBinder() : null);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.xr.transact(26, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().xr(i, i2, nyVar, i3, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, int i2, com.ss.android.socialbase.downloader.depend.ny nyVar, int i3, boolean z, boolean z2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(nyVar != null ? nyVar.asBinder() : null);
                    parcelObtain.writeInt(i3);
                    int i4 = 1;
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i4 = 0;
                    }
                    parcelObtain.writeInt(i4);
                    try {
                        if (!this.xr.transact(27, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                            ms.ab().ms(i, i2, nyVar, i3, z, z2);
                        } else {
                            parcelObtain2.readException();
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean ms(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.xr.transact(28, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ms(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.xr.transact(29, parcelObtain, null, 1) || ms.ab() == null) {
                        return;
                    }
                    ms.ab().ms(i, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.xr.transact(30, parcelObtain, null, 1) || ms.ab() == null) {
                        return;
                    }
                    ms.ab().ms(z);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean ah() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xr.transact(31, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ah();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public List<DownloadInfo> ka(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.xr.transact(32, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ka(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean hi(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(33, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().hi(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void sl(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(34, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().sl(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xr.transact(35, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void d(int i, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.xr.transact(36, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().d(i, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public int zb(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(37, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().zb(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(com.ss.android.socialbase.downloader.model.xr xrVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (xrVar != null) {
                        parcelObtain.writeInt(1);
                        xrVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.xr.transact(38, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(xrVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean xr(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.xr.transact(39, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().xr(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean u(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(40, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().u(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ub(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(41, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ub(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(42, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, i2, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, int i2, int i3, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(43, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, i2, i3, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (!this.xr.transact(44, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, i2, i3, i4);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean ao(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(45, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().ao(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ka() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xr.transact(46, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ka();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.xr.transact(47, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedList(list);
                    if (!this.xr.transact(48, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().xr(i, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(f fVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    if (!this.xr.transact(49, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(fVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.xr.transact(50, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public w h(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(51, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().h(i);
                    }
                    parcelObtain2.readException();
                    return w.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public g qv(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(52, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().qv(i);
                    }
                    parcelObtain2.readException();
                    return g.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, w wVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(wVar != null ? wVar.asBinder() : null);
                    if (!this.xr.transact(53, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, wVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public com.ss.android.socialbase.downloader.depend.ab y(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(54, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().y(i);
                    }
                    parcelObtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.ab.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.xr.transact(55, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        return ms.ab().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.ny
            public void ms(int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.xr.transact(56, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms(i, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ny ab() {
            return C0565ms.f4668ms;
        }
    }
}
