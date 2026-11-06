package com.anythink.core.common.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    public final class a {
        private final String b;
        private final boolean c;

        a(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        public final String a() {
            return this.b;
        }

        private boolean b() {
            return this.c;
        }
    }

    public final a a(Context context) throws IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        b bVar = new b(this, (byte) 0);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0 && context.bindService(intent, bVar, 1)) {
            try {
                c cVar = new c(bVar.a());
                a aVar = new a(cVar.a(), cVar.b());
                try {
                    context.unbindService(bVar);
                } catch (Throwable unused) {
                }
                return aVar;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        context.unbindService(bVar);
                    } catch (Throwable unused2) {
                    }
                    throw th2;
                }
            }
        }
        throw new IOException("Google Play connection failed");
    }

    private final class b implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> c;

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
            this.a = false;
            this.c = new LinkedBlockingQueue<>(1);
        }

        /* synthetic */ b(e eVar, byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final IBinder a() {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.c.take();
        }
    }

    private final class c implements IInterface {
        private IBinder b;

        public c(IBinder iBinder) {
            this.b = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.b;
        }

        public final String a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.b.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public final boolean b() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.b.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
