package com.anythink.odopt.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // com.anythink.odopt.a.a.a.b
        public final boolean a() {
            return false;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.anythink.odopt.a.a.a.b
        public final boolean b() {
            return false;
        }

        @Override // com.anythink.odopt.a.a.a.b
        public final String c() {
            return null;
        }

        @Override // com.anythink.odopt.a.a.a.b
        public final String d() {
            return null;
        }

        @Override // com.anythink.odopt.a.a.a.b
        public final String e() {
            return null;
        }

        @Override // com.anythink.odopt.a.a.a.b
        public final void f() {
        }
    }

    boolean a();

    boolean b();

    String c();

    String d();

    String e();

    void f();

    /* JADX INFO: renamed from: com.anythink.odopt.a.a.a.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0076b extends Binder implements b {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        private static final String g = "com.bun.lib.MsaIdInterface";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0076b() {
            attachInterface(this, g);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(g);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof b)) {
                return (b) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(g);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(g);
                    boolean zA = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(g);
                    boolean zB = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(g);
                    String strC = c();
                    parcel2.writeNoException();
                    parcel2.writeString(strC);
                    return true;
                case 4:
                    parcel.enforceInterface(g);
                    String strD = d();
                    parcel2.writeNoException();
                    parcel2.writeString(strD);
                    return true;
                case 5:
                    parcel.enforceInterface(g);
                    String strE = e();
                    parcel2.writeNoException();
                    parcel2.writeString(strE);
                    return true;
                case 6:
                    parcel.enforceInterface(g);
                    f();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.anythink.odopt.a.a.a.b$b$a */
        private static class a implements b {
            public static b a;
            private IBinder b;

            private static String g() {
                return AbstractBinderC0076b.g;
            }

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }

            @Override // com.anythink.odopt.a.a.a.b
            public final boolean a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0076b.g);
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0076b.g() != null) {
                        return AbstractBinderC0076b.g().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.a.b
            public final boolean b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0076b.g);
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0076b.g() != null) {
                        return AbstractBinderC0076b.g().b();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.a.b
            public final String c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0076b.g);
                    if (!this.b.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0076b.g() != null) {
                        return AbstractBinderC0076b.g().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.a.b
            public final String d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0076b.g);
                    if (!this.b.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0076b.g() != null) {
                        return AbstractBinderC0076b.g().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.a.b
            public final String e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0076b.g);
                    if (!this.b.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0076b.g() != null) {
                        return AbstractBinderC0076b.g().e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.a.b
            public final void f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0076b.g);
                    if (!this.b.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0076b.g() != null) {
                        AbstractBinderC0076b.g().f();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        private static boolean a(b bVar) {
            if (a.a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.a = bVar;
            return true;
        }

        public static b g() {
            return a.a;
        }
    }
}
