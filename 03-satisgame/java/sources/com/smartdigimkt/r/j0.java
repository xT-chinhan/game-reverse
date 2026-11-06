package com.smartdigimkt.r;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    public final Context a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
    public final i0 c = new i0(this);

    public j0(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        String string;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (!this.a.bindService(intent, this.c, 1)) {
                bVar.a("Service unbind.");
                return;
            }
            try {
                IBinder iBinder = (IBinder) this.b.take();
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    th.printStackTrace();
                    string = null;
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                bVar.a(string, false);
            } catch (Throwable th2) {
                th2.printStackTrace();
                bVar.a(th2.getMessage());
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }
}
