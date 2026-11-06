package com.byazt.ry;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface fs extends IInterface {
    int n() throws RemoteException;

    void n(ComponentName componentName, IBinder iBinder) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    public static abstract class n extends Binder implements fs {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static fs n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof fs)) {
                return (fs) iInterfaceQueryLocalInterface;
            }
            return new C0325n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                n(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
            int iN = n();
            parcel2.writeNoException();
            parcel2.writeInt(iN);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.ry.fs$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, 856})
        private static class C0325n implements fs {
            public static fs n;
            public IBinder qg;

            public C0325n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.ry.fs
            public void n(ComponentName componentName, IBinder iBinder) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        parcelObtain.writeInt(1);
                        componentName.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBinder);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.qg() != null) {
                        n.qg().n(componentName, iBinder);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ry.fs
            public int n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && n.qg() != null) {
                        return n.qg().n();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static fs qg() {
            return C0325n.n;
        }
    }
}
