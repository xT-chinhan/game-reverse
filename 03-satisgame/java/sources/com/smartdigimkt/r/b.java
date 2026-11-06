package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final Context a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
    public final a c = new a(this);

    public b(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        String string;
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (!this.a.bindService(intent, this.c, 1)) {
                bVar.a("Empty");
                return;
            }
            try {
                try {
                    IBinder iBinder = (IBinder) this.b.take();
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        iBinder.transact(3, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        th.printStackTrace();
                        string = null;
                    }
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    bVar.a(string, false);
                } catch (Throwable th2) {
                    bVar.a(th2.getMessage());
                }
            } catch (Exception e) {
                bVar.a(e.getMessage());
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }
}
