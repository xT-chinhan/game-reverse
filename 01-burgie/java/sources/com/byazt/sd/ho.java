package com.byazt.sd;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ho extends IInterface {
    Bundle pr(int i) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 23, 1255})
    public static abstract class pr extends Binder implements ho {
        public pr() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
        }

        public static ho pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ho)) {
                return (ho) iInterfaceQueryLocalInterface;
            }
            return new C0184pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                    Bundle bundlePr = pr(parcel.readInt());
                    parcel2.writeNoException();
                    if (bundlePr != null) {
                        parcel2.writeInt(1);
                        bundlePr.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.sd.ho$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 23, 978})
        private static class C0184pr implements ho {
            public static ho pr;
            public IBinder hw;

            public C0184pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.sd.ho
            public Bundle pr(int i) throws RemoteException {
                Bundle bundle;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdCustomPlayAgainListener");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().pr(i);
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ho pr() {
            return C0184pr.pr;
        }
    }
}
