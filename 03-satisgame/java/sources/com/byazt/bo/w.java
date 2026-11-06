package com.byazt.bo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public interface w extends IInterface {
    boolean l() throws RemoteException;

    String n() throws RemoteException;

    boolean q() throws RemoteException;

    String qg() throws RemoteException;

    String s() throws RemoteException;

    void w() throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 108})
    public static abstract class n extends Binder implements w {
        public static w n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof w)) {
                return (w) iInterfaceQueryLocalInterface;
            }
            return new C0145n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.bun.lib.MsaIdInterface");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String strN = n();
                    parcel2.writeNoException();
                    parcel2.writeString(strN);
                    return true;
                case 2:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String strQg = qg();
                    parcel2.writeNoException();
                    parcel2.writeString(strQg);
                    return true;
                case 3:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    String strS = s();
                    parcel2.writeNoException();
                    parcel2.writeString(strS);
                    return true;
                case 4:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    boolean zQ = q();
                    parcel2.writeNoException();
                    parcel2.writeInt(zQ ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    boolean zL = l();
                    parcel2.writeNoException();
                    parcel2.writeInt(zL ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                    w();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.bo.w$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 909})
        private static class C0145n implements w {
            public static w n;
            public IBinder qg;

            public C0145n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.bo.w
            public String n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.x() != null) {
                        return n.x().n();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.w
            public String qg() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && n.x() != null) {
                        return n.x().qg();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.w
            public String s() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.qg.transact(3, parcelObtain, parcelObtain2, 0) && n.x() != null) {
                        return n.x().s();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.w
            public boolean q() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.qg.transact(4, parcelObtain, parcelObtain2, 0) && n.x() != null) {
                        return n.x().q();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.w
            public boolean l() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.qg.transact(5, parcelObtain, parcelObtain2, 0) && n.x() != null) {
                        return n.x().l();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.w
            public void w() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.qg.transact(6, parcelObtain, parcelObtain2, 0) && n.x() != null) {
                        n.x().w();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static w x() {
            return C0145n.n;
        }
    }
}
