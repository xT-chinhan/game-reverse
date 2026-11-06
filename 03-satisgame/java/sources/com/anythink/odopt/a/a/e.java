package com.anythink.odopt.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {

    public static class a implements e {
        @Override // com.anythink.odopt.a.a.e
        public final boolean a() {
            return false;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.anythink.odopt.a.a.e
        public final String b() {
            return null;
        }
    }

    boolean a();

    String b();

    public static abstract class b extends Binder implements e {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        private static final String f = "com.android.creator.FreemeIdsSupplier";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public b() {
            attachInterface(this, f);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof e)) {
                return (e) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        private static boolean a(e eVar) {
            if (a.a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (eVar == null) {
                return false;
            }
            a.a = eVar;
            return true;
        }

        public static e c() {
            return a.a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(f);
                boolean zA = a();
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(f);
                parcel.readString();
                parcel2.writeNoException();
                parcel2.writeString("");
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(f);
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(f);
                parcel2.writeNoException();
                parcel2.writeString("");
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString(f);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(f);
            parcel.readString();
            parcel2.writeNoException();
            parcel2.writeString("");
            return true;
        }

        private static class a implements e {
            public static e a;
            private IBinder b;

            private static String c() {
                return b.f;
            }

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }

            @Override // com.anythink.odopt.a.a.e
            public final boolean a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f);
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.e
            public final String b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f);
                    if (!this.b.transact(3, parcelObtain, parcelObtain2, 0) && b.c() != null) {
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
