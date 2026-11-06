package com.byazt.nf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface s extends IInterface {
    void n() throws RemoteException;

    void n(String str) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, 546})
    public static abstract class n extends Binder implements s {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
        }

        public static s n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof s)) {
                return (s) iInterfaceQueryLocalInterface;
            }
            return new C0263n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                n();
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            n(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.nf.s$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT})
        private static class C0263n implements s {
            public static s n;
            public IBinder qg;

            public C0263n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.nf.s
            public void n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.qg() != null) {
                        n.qg().n();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.s
            public void n(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    parcelObtain.writeString(str);
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && n.qg() != null) {
                        n.qg().n(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static s qg() {
            return C0263n.n;
        }
    }
}
