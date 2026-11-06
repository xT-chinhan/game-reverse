package com.byazt.ae;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface hn extends IInterface {
    int hw(String str) throws RemoteException;

    void pr(int i) throws RemoteException;

    void pr(int i, x xVar) throws RemoteException;

    boolean pr(String str) throws RemoteException;

    boolean pr(String str, String str2) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 592, 116})
    public static abstract class pr extends Binder implements hn {
        public pr() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static hn pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof hn)) {
                return (hn) iInterfaceQueryLocalInterface;
            }
            return new C0009pr(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                    boolean zPr = pr(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPr ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                    int iHw = hw(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iHw);
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                    boolean zPr2 = pr(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPr2 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                    pr(parcel.readInt(), x.pr.pr(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                    pr(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.ae.hn$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 592, 1248})
        private static class C0009pr implements hn {
            public static hn pr;
            public IBinder hw;

            public C0009pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.ae.hn
            public boolean pr(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().pr(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ae.hn
            public int hw(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().hw(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ae.hn
            public boolean pr(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.hw.transact(3, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        return pr.pr().pr(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ae.hn
            public void pr(int i, x xVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(xVar != null ? xVar.asBinder() : null);
                    if (!this.hw.transact(4, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        pr.pr().pr(i, xVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.ae.hn
            public void pr(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i);
                    if (!this.hw.transact(5, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        pr.pr().pr(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static hn pr() {
            return C0009pr.pr;
        }
    }
}
