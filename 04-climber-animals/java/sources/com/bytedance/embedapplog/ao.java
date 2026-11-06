package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface ao extends IInterface {
    String ms(String str, String str2, String str3);

    public static abstract class ms extends Binder implements ao {
        public static ao ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ao)) {
                return (ao) iInterfaceQueryLocalInterface;
            }
            return new C0205ms(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.heytap.openid.IOpenID");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String strMs = ms(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strMs);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.ao$ms$ms, reason: collision with other inner class name */
        static class C0205ms implements ao {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            private IBinder f477ms;

            C0205ms(IBinder iBinder) {
                this.f477ms = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f477ms;
            }

            @Override // com.bytedance.embedapplog.ao
            public String ms(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f477ms.transact(1, parcelObtain, parcelObtain2, 0);
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
