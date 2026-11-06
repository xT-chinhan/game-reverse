package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: classes3.dex */
public interface OppoIDInterface extends IInterface {
    String getSerID(String str, String str2, String str3);

    public static final class OppoId implements OppoIDInterface {
        private IBinder iBinder;

        public OppoId(IBinder iBinder) {
            this.iBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.OppoIDInterface
        public String getSerID(String str, String str2, String str3) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                this.iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Exception e) {
                LiteApiLogger.printStackTrace(e);
                return null;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}
