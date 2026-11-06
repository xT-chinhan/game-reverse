package com.byazt.nf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface n extends IInterface {
    IBinder n(int i) throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.nf.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static abstract class AbstractBinderC0259n extends Binder implements n {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0259n() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IBinderPool");
        }

        public static n n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof n)) {
                return (n) iInterfaceQueryLocalInterface;
            }
            return new C0260n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            IBinder iBinderN = n(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderN);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.nf.n$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, 512})
        private static class C0260n implements n {
            public static n n;
            public IBinder qg;

            public C0260n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.nf.n
            public IBinder n(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0259n.n() != null) {
                        return AbstractBinderC0259n.n().n(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static n n() {
            return C0260n.n;
        }
    }
}
