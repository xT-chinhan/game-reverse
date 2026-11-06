package com.byazt.otj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes2.dex */
public interface pr extends IInterface {
    String c(String str) throws RemoteException;

    String hn(String str) throws RemoteException;

    String hw() throws RemoteException;

    String hw(String str) throws RemoteException;

    String pr(String str) throws RemoteException;

    boolean pr() throws RemoteException;

    String x(String str) throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.otj.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 833, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static abstract class AbstractBinderC0155pr extends Binder implements pr {
        public static pr pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof pr)) {
                return (pr) iInterfaceQueryLocalInterface;
            }
            return new C0156pr(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strPr = pr(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strPr);
                    return true;
                case 2:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strHw = hw(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strHw);
                    return true;
                case 3:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strHn = hn(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strHn);
                    return true;
                case 4:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strX = x(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strX);
                    return true;
                case 5:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strC = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strC);
                    return true;
                case 6:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    boolean zPr = pr();
                    parcel2.writeNoException();
                    parcel2.writeInt(zPr ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strHw2 = hw();
                    parcel2.writeNoException();
                    parcel2.writeString(strHw2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.otj.pr$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 833, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL})
        private static class C0156pr implements pr {
            public static pr pr;
            public IBinder hw;

            public C0156pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.otj.pr
            public String pr(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0155pr.hn() != null) {
                        return AbstractBinderC0155pr.hn().pr(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.pr
            public String hw(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0155pr.hn() != null) {
                        return AbstractBinderC0155pr.hn().hw(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.pr
            public String hn(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0155pr.hn() != null) {
                        return AbstractBinderC0155pr.hn().hn(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.pr
            public String x(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0155pr.hn() != null) {
                        return AbstractBinderC0155pr.hn().x(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.pr
            public String c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0155pr.hn() != null) {
                        return AbstractBinderC0155pr.hn().c(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.pr
            public boolean pr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.hw.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0155pr.hn() != null) {
                        return AbstractBinderC0155pr.hn().pr();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.pr
            public String hw() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.hw.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0155pr.hn() != null) {
                        return AbstractBinderC0155pr.hn().hw();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static pr hn() {
            return C0156pr.pr;
        }
    }
}
