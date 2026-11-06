package com.tapsdk.tapad.oaid.honor.oaidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface IB extends IInterface {

    public static abstract class BBinder extends Binder implements IB {

        public static class BBABinder implements IB {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            public IBinder a;

            public BBABinder(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.tapsdk.tapad.oaid.honor.oaidl.IB
            public void a(IA ia) throws Throwable {
                Parcel parcelObtain;
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                        parcelObtain.writeStrongBinder((IBinder) ia);
                        this.a.transact(3, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
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
                    parcelObtain = null;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.tapsdk.tapad.oaid.honor.oaidl.IB
            public void b(IA ia) throws Throwable {
                Parcel parcelObtain;
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                        parcelObtain.writeStrongBinder((IBinder) ia);
                        this.a.transact(2, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
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
                    parcelObtain = null;
                }
            }
        }
    }

    void a(IA ia);

    void b(IA ia);
}
