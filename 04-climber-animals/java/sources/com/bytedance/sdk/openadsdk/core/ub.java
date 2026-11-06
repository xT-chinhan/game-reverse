package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ub extends IInterface {
    void ah() throws RemoteException;

    void c() throws RemoteException;

    void d() throws RemoteException;

    void ka() throws RemoteException;

    void ms() throws RemoteException;

    void xr() throws RemoteException;

    public static abstract class ms extends Binder implements ub {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
        }

        public static ub ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ub)) {
                return (ub) iInterfaceQueryLocalInterface;
            }
            return new C0309ms(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    ms();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    xr();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    ah();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    d();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    ka();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    c();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ub$ms$ms, reason: collision with other inner class name */
        private static class C0309ms implements ub {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static ub f3372ms;
            private IBinder xr;

            C0309ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ub
            public void ms() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ms();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ub
            public void xr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xr.transact(2, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().xr();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ub
            public void ah() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xr.transact(3, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ah();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ub
            public void d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xr.transact(4, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().d();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ub
            public void ka() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xr.transact(5, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().ka();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ub
            public void c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.xr.transact(6, parcelObtain, parcelObtain2, 0) && ms.ab() != null) {
                        ms.ab().c();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ub ab() {
            return C0309ms.f3372ms;
        }
    }
}
