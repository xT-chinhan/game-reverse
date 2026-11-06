package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ao;
import com.ss.android.socialbase.downloader.depend.c;
import com.ss.android.socialbase.downloader.depend.ch;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.nw;
import com.ss.android.socialbase.downloader.depend.ny;
import com.ss.android.socialbase.downloader.depend.pc;
import com.ss.android.socialbase.downloader.depend.sl;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;

/* JADX INFO: loaded from: classes3.dex */
public interface ms extends IInterface {
    nw ab() throws RemoteException;

    sl ah(int i) throws RemoteException;

    w ah() throws RemoteException;

    c c() throws RemoteException;

    ch ch() throws RemoteException;

    g d() throws RemoteException;

    ab hi() throws RemoteException;

    x ka() throws RemoteException;

    int ms(int i) throws RemoteException;

    ny ms(int i, int i2) throws RemoteException;

    DownloadInfo ms() throws RemoteException;

    ao ny() throws RemoteException;

    int sl() throws RemoteException;

    pc x() throws RemoteException;

    com.ss.android.socialbase.downloader.depend.ka xr() throws RemoteException;

    ny xr(int i) throws RemoteException;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.ms$ms, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0568ms extends Binder implements ms {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0568ms() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static ms ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ms)) {
                return (ms) iInterfaceQueryLocalInterface;
            }
            return new C0569ms(iBinder);
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
                    DownloadInfo downloadInfoMs = ms();
                    parcel2.writeNoException();
                    if (downloadInfoMs != null) {
                        parcel2.writeInt(1);
                        downloadInfoMs.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.depend.ka kaVarXr = xr();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(kaVarXr != null ? kaVarXr.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iMs = ms(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iMs);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    ny nyVarMs = ms(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(nyVarMs != null ? nyVarMs.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    ny nyVarXr = xr(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(nyVarXr != null ? nyVarXr.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    w wVarAh = ah();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(wVarAh != null ? wVarAh.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    g gVarD = d();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(gVarD != null ? gVarD.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    x xVarKa = ka();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(xVarKa != null ? xVarKa.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    c cVarC = c();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(cVarC != null ? cVarC.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    nw nwVarAb = ab();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(nwVarAb != null ? nwVarAb.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    pc pcVarX = x();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(pcVarX != null ? pcVarX.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    ao aoVarNy = ny();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(aoVarNy != null ? aoVarNy.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    ch chVarCh = ch();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(chVarCh != null ? chVarCh.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    ab abVarHi = hi();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(abVarHi != null ? abVarHi.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iSl = sl();
                    parcel2.writeNoException();
                    parcel2.writeInt(iSl);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    sl slVarAh = ah(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(slVarAh != null ? slVarAh.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.ms$ms$ms, reason: collision with other inner class name */
        private static class C0569ms implements ms {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static ms f4714ms;
            private IBinder xr;

            C0569ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public DownloadInfo ms() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ms();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public com.ss.android.socialbase.downloader.depend.ka xr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().xr();
                    }
                    parcelObtain2.readException();
                    return com.ss.android.socialbase.downloader.depend.ka.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public int ms(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ms(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public ny ms(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.xr.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ms(i, i2);
                    }
                    parcelObtain2.readException();
                    return ny.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public ny xr(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().xr(i);
                    }
                    parcelObtain2.readException();
                    return ny.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public w ah() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ah();
                    }
                    parcelObtain2.readException();
                    return w.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public g d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().d();
                    }
                    parcelObtain2.readException();
                    return g.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public x ka() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ka();
                    }
                    parcelObtain2.readException();
                    return x.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public c c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().c();
                    }
                    parcelObtain2.readException();
                    return c.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public nw ab() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ab();
                    }
                    parcelObtain2.readException();
                    return nw.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public pc x() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().x();
                    }
                    parcelObtain2.readException();
                    return pc.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public ao ny() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ny();
                    }
                    parcelObtain2.readException();
                    return ao.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public ch ch() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ch();
                    }
                    parcelObtain2.readException();
                    return ch.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public ab hi() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().hi();
                    }
                    parcelObtain2.readException();
                    return ab.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public int sl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.xr.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().sl();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ms
            public sl ah(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.xr.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0568ms.zb() != null) {
                        return AbstractBinderC0568ms.zb().ah(i);
                    }
                    parcelObtain2.readException();
                    return sl.ms.ms(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ms zb() {
            return C0569ms.f4714ms;
        }
    }
}
