package com.byazt.xev;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface fo extends IInterface {
    boolean hw() throws RemoteException;

    String pr() throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 75, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
    public static abstract class pr extends Binder implements fo {
        public static fo pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof fo)) {
                return (fo) iInterfaceQueryLocalInterface;
            }
            return new C0230pr(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    String strPr = pr();
                    parcel2.writeNoException();
                    parcel2.writeString(strPr);
                    return true;
                case 2:
                    parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean zHw = hw();
                    parcel2.writeNoException();
                    parcel2.writeInt(zHw ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.xev.fo$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 75, 749})
        private static class C0230pr implements fo {
            public final IBinder pr;

            public C0230pr(IBinder iBinder) {
                this.pr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.pr;
            }

            @Override // com.byazt.xev.fo
            public String pr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.pr.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.xev.fo
            public boolean hw() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.pr.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
