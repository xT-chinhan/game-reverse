package com.byazt.bgo;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.anythink.odopt.a.a.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public interface n extends IInterface {
    void n(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void n(int i, Bundle bundle) throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.bgo.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 111, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static abstract class AbstractBinderC0135n extends Binder implements n {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0135n() {
            attachInterface(this, i.a);
        }

        public static n n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(i.a);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof n)) {
                return (n) iInterfaceQueryLocalInterface;
            }
            return new C0136n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(i.a);
                n(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(i.a);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(i.a);
            n(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.bgo.n$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 111, 512})
        private static class C0136n implements n {
            public static n n;
            public IBinder qg;

            public C0136n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.bgo.n
            public void n(int i, long j, boolean z, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(i.a);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0135n.qg() != null) {
                            AbstractBinderC0135n.qg().n(i, j, z, f, d, str);
                        } else {
                            parcelObtain2.readException();
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.byazt.bgo.n
            public void n(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(i.a);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0135n.qg() != null) {
                        AbstractBinderC0135n.qg().n(i, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static n qg() {
            return C0136n.n;
        }
    }
}
