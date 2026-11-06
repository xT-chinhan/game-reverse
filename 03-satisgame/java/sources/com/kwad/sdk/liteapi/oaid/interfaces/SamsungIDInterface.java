package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: classes3.dex */
public interface SamsungIDInterface extends IInterface {
    String getID();

    public static class Proxy implements SamsungIDInterface {
        private IBinder mIBinder;

        public Proxy(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.SamsungIDInterface
        public String getID() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.mIBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                return string;
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
    }

    public static abstract class Stub extends Binder implements SamsungIDInterface {
        public Stub() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public SamsungIDInterface a(IBinder iBinder) {
            if (iBinder == null || iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService") == null) {
                return null;
            }
            return new Proxy(iBinder);
        }
    }
}
