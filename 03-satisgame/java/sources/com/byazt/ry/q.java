package com.byazt.ry;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface q extends IInterface {
    void n(String str, int i, String str2) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static abstract class n extends Binder implements q {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.bytedance.pangle.IPluginInstallListener");
        }

        public static q n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof q)) {
                return (q) iInterfaceQueryLocalInterface;
            }
            return new C0327n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.IPluginInstallListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.IPluginInstallListener");
            n(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.ry.q$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FRAMES_DROP})
        private static class C0327n implements q {
            public static q n;
            public IBinder qg;

            public C0327n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.ry.q
            public void n(String str, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPluginInstallListener");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, i, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static q n() {
            return C0327n.n;
        }
    }
}
