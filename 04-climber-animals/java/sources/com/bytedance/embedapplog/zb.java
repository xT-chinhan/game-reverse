package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface zb extends IInterface {
    String ms();

    String ms(String str);

    String xr(String str);

    public static abstract class ms extends Binder implements zb {
        public static zb ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof zb)) {
                return (zb) iInterfaceQueryLocalInterface;
            }
            return new C0214ms(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String strMs = ms();
                parcel2.writeNoException();
                parcel2.writeString(strMs);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String strMs2 = ms(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strMs2);
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            String strXr = xr(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strXr);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.zb$ms$ms, reason: collision with other inner class name */
        static class C0214ms implements zb {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            private IBinder f541ms;

            C0214ms(IBinder iBinder) {
                this.f541ms = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f541ms;
            }

            @Override // com.bytedance.embedapplog.zb
            public String ms() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f541ms.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.zb
            public String ms(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    parcelObtain.writeString(str);
                    this.f541ms.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.zb
            public String xr(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    parcelObtain.writeString(str);
                    this.f541ms.transact(3, parcelObtain, parcelObtain2, 0);
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
