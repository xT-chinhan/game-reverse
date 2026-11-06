package com.anythink.odopt.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface v extends IInterface {
    String a();

    String b();

    public static class a implements v {
        private IBinder a;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // com.anythink.odopt.a.a.v
        public final String a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // com.anythink.odopt.a.a.v
        public final String b() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.a.transact(4, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
