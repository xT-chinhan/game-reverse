package com.kwad.sdk.core.e.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.anythink.odopt.a.a.j;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static class a extends Binder implements b {
        private IBinder aGc;

        public a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }

        public final void a(c cVar) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(j.a);
                parcelObtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aGc.transact(2, parcelObtain, parcelObtain2, 0);
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "gets + " + this.aGc);
                parcelObtain2.readException();
            } catch (Throwable th) {
                try {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", th);
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
        }

        public final void b(c cVar) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(j.a);
                parcelObtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aGc.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } catch (Throwable th) {
                try {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", th);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
