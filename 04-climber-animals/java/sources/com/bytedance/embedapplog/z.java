package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface z extends IInterface {
    void ms(int i, long j, boolean z, float f, double d, String str);

    void ms(int i, Bundle bundle);

    public static abstract class ms extends Binder implements z {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public ms() {
            attachInterface(this, com.anythink.odopt.a.a.i.a);
        }

        public static z ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.anythink.odopt.a.a.i.a);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof z)) {
                return (z) iInterfaceQueryLocalInterface;
            }
            return new C0213ms(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(com.anythink.odopt.a.a.i.a);
                ms(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(com.anythink.odopt.a.a.i.a);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(com.anythink.odopt.a.a.i.a);
            ms(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.z$ms$ms, reason: collision with other inner class name */
        static class C0213ms implements z {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public static z f540ms;
            private IBinder xr;

            C0213ms(IBinder iBinder) {
                this.xr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.xr;
            }

            @Override // com.bytedance.embedapplog.z
            public void ms(int i, long j, boolean z, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.anythink.odopt.a.a.i.a);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.xr.transact(1, parcelObtain, parcelObtain2, 0) && ms.ms() != null) {
                            ms.ms().ms(i, j, z, f, d, str);
                        } else {
                            parcelObtain2.readException();
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.bytedance.embedapplog.z
            public void ms(int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.anythink.odopt.a.a.i.a);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.xr.transact(2, parcelObtain, parcelObtain2, 0) && ms.ms() != null) {
                        ms.ms().ms(i, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static z ms() {
            return C0213ms.f540ms;
        }
    }
}
