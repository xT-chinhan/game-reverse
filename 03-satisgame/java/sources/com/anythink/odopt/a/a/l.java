package com.anythink.odopt.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface l extends IInterface {

    public static class a implements l {
        @Override // com.anythink.odopt.a.a.l
        public final String a(String str) {
            return null;
        }

        @Override // com.anythink.odopt.a.a.l
        public final boolean a() {
            return false;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.anythink.odopt.a.a.l
        public final String b() {
            return null;
        }
    }

    String a(String str);

    boolean a();

    String b();

    public static abstract class b extends Binder implements l {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        static final int g = 7;
        private static final String h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public b() {
            attachInterface(this, h);
        }

        public static l a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(h);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof l)) {
                return (l) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        private static boolean a(l lVar) {
            if (a.a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (lVar == null) {
                return false;
            }
            a.a = lVar;
            return true;
        }

        public static l c() {
            return a.a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(h);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(h);
                    parcel.readString();
                    parcel2.writeNoException();
                    parcel2.writeString("");
                    return true;
                case 2:
                    parcel.enforceInterface(h);
                    String strA = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 3:
                    parcel.enforceInterface(h);
                    parcel.readString();
                    parcel2.writeNoException();
                    parcel2.writeString("");
                    return true;
                case 4:
                    parcel.enforceInterface(h);
                    parcel.readString();
                    parcel2.writeNoException();
                    parcel2.writeString("");
                    return true;
                case 5:
                    parcel.enforceInterface(h);
                    parcel.readString();
                    parcel2.writeNoException();
                    parcel2.writeString("");
                    return true;
                case 6:
                    parcel.enforceInterface(h);
                    boolean zA = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(h);
                    String strB = b();
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class a implements l {
            public static l a;
            private IBinder b;

            private static String c() {
                return b.h;
            }

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }

            @Override // com.anythink.odopt.a.a.l
            public final String a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.h);
                    parcelObtain.writeString(str);
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && b.c() != null) {
                        return b.c().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.l
            public final boolean a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.h);
                    if (!this.b.transact(6, parcelObtain, parcelObtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.l
            public final String b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.h);
                    if (!this.b.transact(7, parcelObtain, parcelObtain2, 0) && b.c() != null) {
                        return b.c().b();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
