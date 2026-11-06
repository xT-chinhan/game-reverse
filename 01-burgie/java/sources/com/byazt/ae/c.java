package com.byazt.ae;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {
    boolean bindService(Intent intent, zo zoVar, int i, String str) throws RemoteException;

    ComponentName startService(Intent intent, String str) throws RemoteException;

    boolean stopService(Intent intent, String str) throws RemoteException;

    void unbindService(zo zoVar) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 592, 169})
    public static abstract class pr extends Binder implements c {
        public pr() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static c pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof c)) {
                return (c) iInterfaceQueryLocalInterface;
            }
            return new C0008pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Intent intent = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    }
                    ComponentName componentNameStartService = startService(intent, parcel.readString());
                    parcel2.writeNoException();
                    if (componentNameStartService != null) {
                        parcel2.writeInt(1);
                        componentNameStartService.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    }
                    boolean zStopService = stopService(intent, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zStopService ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    }
                    boolean zBindService = bindService(intent, zo.pr.pr(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zBindService ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    unbindService(zo.pr.pr(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.bytedance.pangle.IServiceManager");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.ae.c$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 592, 935})
        private static class C0008pr implements c {
            public static c pr;
            public IBinder hw;

            public C0008pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.ae.c
            public ComponentName startService(Intent intent, String str) throws RemoteException {
                ComponentName componentName;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().startService(intent, str);
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        componentName = (ComponentName) ComponentName.CREATOR.createFromParcel(parcelObtain2);
                    } else {
                        componentName = null;
                    }
                    return componentName;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ae.c
            public boolean stopService(Intent intent, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().stopService(intent, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ae.c
            public boolean bindService(Intent intent, zo zoVar, int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zoVar != null ? zoVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(3, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().bindService(intent, zoVar, i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ae.c
            public void unbindService(zo zoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    parcelObtain.writeStrongBinder(zoVar != null ? zoVar.asBinder() : null);
                    if (!this.hw.transact(4, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        pr.pr().unbindService(zoVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static c pr() {
            return C0008pr.pr;
        }
    }
}
