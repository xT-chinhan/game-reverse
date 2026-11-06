package com.byazt.ry;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface s extends IInterface {
    void n(int i) throws RemoteException;

    void n(int i, q qVar) throws RemoteException;

    boolean n(String str) throws RemoteException;

    boolean n(String str, String str2) throws RemoteException;

    int qg(String str) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, 546})
    public static abstract class n extends Binder implements s {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static s n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof s)) {
                return (s) iInterfaceQueryLocalInterface;
            }
            return new C0328n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean zN = n(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zN ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int iQg = qg(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iQg);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean zN2 = n(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zN2 ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                n(parcel.readInt(), q.n.n(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            n(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.ry.s$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT})
        private static class C0328n implements s {
            public static s n;
            public IBinder qg;

            public C0328n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.ry.s
            public boolean n(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        return n.n().n(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ry.s
            public int qg(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        return n.n().qg(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ry.s
            public boolean n(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.qg.transact(3, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        return n.n().n(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ry.s
            public void n(int i, q qVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    if (!this.qg.transact(4, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(i, qVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ry.s
            public void n(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(5, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static s n() {
            return C0328n.n;
        }
    }
}
