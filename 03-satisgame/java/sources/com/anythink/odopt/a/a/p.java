package com.anythink.odopt.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface p extends IInterface {

    public static abstract class a extends Binder implements p {
        public static p a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p)) ? new C0081a(iBinder) : (p) iInterfaceQueryLocalInterface;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX INFO: renamed from: com.anythink.odopt.a.a.p$a$a, reason: collision with other inner class name */
        public static class C0081a implements p {
            public IBinder a;

            public C0081a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final String a(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }
        }
    }
}
