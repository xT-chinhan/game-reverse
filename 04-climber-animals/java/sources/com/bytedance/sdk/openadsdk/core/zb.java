package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface zb extends IInterface {
    void ah() throws RemoteException;

    void ms() throws RemoteException;

    void xr() throws RemoteException;

    public static abstract class ms extends Binder implements zb {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
        }

        public static zb ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof zb)) {
                return (zb) iInterfaceQueryLocalInterface;
            }
            return new C0330ms(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                ms();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                xr();
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
            ah();
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.zb$ms$ms, reason: collision with other inner class name */
        private static class C0330ms implements zb {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static zb f3813ms;
            private IBinder xr;

            C0330ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.bytedance.sdk.openadsdk.core.zb
            public void ms() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.d() != null) {
                        ms.d().ms();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.zb
            public void xr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.xr.transact(2, parcelObtain, parcelObtain2, 0) && ms.d() != null) {
                        ms.d().xr();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.zb
            public void ah() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.xr.transact(3, parcelObtain, parcelObtain2, 0) && ms.d() != null) {
                        ms.d().ah();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zb d() {
            return C0330ms.f3813ms;
        }
    }
}
