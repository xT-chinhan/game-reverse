package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: classes3.dex */
public interface ZTEIDInterface extends IInterface {
    String getOAID();

    public static final class ZTEID implements ZTEIDInterface {
        private IBinder iBinder;

        public ZTEID(IBinder iBinder) {
            this.iBinder = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.ZTEIDInterface
        public String getOAID() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    string = null;
                }
                return string;
            } catch (Throwable th) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }
    }
}
