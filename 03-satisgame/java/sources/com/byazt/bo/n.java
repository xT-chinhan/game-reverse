package com.byazt.bo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public interface n extends IInterface {
    String l(String str) throws RemoteException;

    String n(String str) throws RemoteException;

    boolean n() throws RemoteException;

    String q(String str) throws RemoteException;

    String qg() throws RemoteException;

    String qg(String str) throws RemoteException;

    String s(String str) throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.bo.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static abstract class AbstractBinderC0140n extends Binder implements n {
        public static n n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof n)) {
                return (n) iInterfaceQueryLocalInterface;
            }
            return new C0141n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strN = n(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strN);
                    return true;
                case 2:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strQg = qg(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strQg);
                    return true;
                case 3:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strS = s(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strS);
                    return true;
                case 4:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strQ = q(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strQ);
                    return true;
                case 5:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strL = l(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strL);
                    return true;
                case 6:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    boolean zN = n();
                    parcel2.writeNoException();
                    parcel2.writeInt(zN ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strQg2 = qg();
                    parcel2.writeNoException();
                    parcel2.writeString(strQg2);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.bo.n$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 512})
        private static class C0141n implements n {
            public static n n;
            public IBinder qg;

            public C0141n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.bo.n
            public String n(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0140n.s() != null) {
                        return AbstractBinderC0140n.s().n(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.n
            public String qg(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0140n.s() != null) {
                        return AbstractBinderC0140n.s().qg(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.n
            public String s(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0140n.s() != null) {
                        return AbstractBinderC0140n.s().s(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.n
            public String q(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0140n.s() != null) {
                        return AbstractBinderC0140n.s().q(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.n
            public String l(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0140n.s() != null) {
                        return AbstractBinderC0140n.s().l(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.n
            public boolean n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.qg.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0140n.s() != null) {
                        return AbstractBinderC0140n.s().n();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.n
            public String qg() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.qg.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0140n.s() != null) {
                        return AbstractBinderC0140n.s().qg();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static n s() {
            return C0141n.n;
        }
    }
}
