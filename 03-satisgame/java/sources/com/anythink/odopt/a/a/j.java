package com.anythink.odopt.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface j extends IInterface {
    public static final String a = "com.hihonor.cloudservice.oaid.IOAIDService";

    void a(int i, long j, boolean z, float f, double d, String str);

    void a(i iVar);

    void b(i iVar);

    public static abstract class a extends Binder implements j {
        public a() {
            attachInterface(this, j.a);
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(j.a);
            if (iInterfaceQueryLocalInterface instanceof j) {
                return (j) iInterfaceQueryLocalInterface;
            }
            return new C0079a(iBinder);
        }

        @Override // android.os.Binder
        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(j.a);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(j.a);
                a(i.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(j.a);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(j.a);
            b(i.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.anythink.odopt.a.a.j$a$a, reason: collision with other inner class name */
        private static class C0079a implements j {
            private IBinder b;

            public C0079a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.anythink.odopt.a.a.j
            public final void a(int i, long j, boolean z, float f, double d, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(j.a);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    this.b.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.j
            public final void a(i iVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(j.a);
                    parcelObtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.b.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.anythink.odopt.a.a.j
            public final void b(i iVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(j.a);
                    parcelObtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.b.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }
        }
    }
}
