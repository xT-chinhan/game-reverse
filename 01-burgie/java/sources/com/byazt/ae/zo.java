package com.byazt.ae;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface zo extends IInterface {
    int pr() throws RemoteException;

    void pr(ComponentName componentName, IBinder iBinder) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 592, 673})
    public static abstract class pr extends Binder implements zo {
        public pr() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static zo pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof zo)) {
                return (zo) iInterfaceQueryLocalInterface;
            }
            return new C0011pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ComponentName componentName;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                    if (parcel.readInt() != 0) {
                        componentName = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
                    } else {
                        componentName = null;
                    }
                    pr(componentName, parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                    int iPr = pr();
                    parcel2.writeNoException();
                    parcel2.writeInt(iPr);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.ae.zo$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 592, 1429})
        private static class C0011pr implements zo {
            public static zo pr;
            public IBinder hw;

            public C0011pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.ae.zo
            public void pr(ComponentName componentName, IBinder iBinder) throws RemoteException {
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
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.hw() != null) {
                        pr.hw().pr(componentName, iBinder);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ae.zo
            public int pr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && pr.hw() != null) {
                        return pr.hw().pr();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zo hw() {
            return C0011pr.pr;
        }
    }
}
