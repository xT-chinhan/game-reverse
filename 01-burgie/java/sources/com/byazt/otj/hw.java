package com.byazt.otj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface hw extends IInterface {
    String hw(String str) throws RemoteException;

    String pr() throws RemoteException;

    String pr(String str) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 833, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static abstract class pr extends Binder implements hw {
        public static hw pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof hw)) {
                return (hw) iInterfaceQueryLocalInterface;
            }
            return new C0154pr(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    String strPr = pr();
                    parcel2.writeNoException();
                    parcel2.writeString(strPr);
                    return true;
                case 2:
                    parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    String strPr2 = pr(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strPr2);
                    return true;
                case 3:
                    parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    String strHw = hw(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strHw);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.otj.hw$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 833, 799})
        private static class C0154pr implements hw {
            public final IBinder pr;

            public C0154pr(IBinder iBinder) {
                this.pr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.pr;
            }

            @Override // com.byazt.otj.hw
            public String pr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.pr.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.hw
            public String pr(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    parcelObtain.writeString(str);
                    this.pr.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.hw
            public String hw(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    parcelObtain.writeString(str);
                    this.pr.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
