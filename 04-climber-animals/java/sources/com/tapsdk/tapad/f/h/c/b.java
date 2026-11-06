package com.tapsdk.tapad.f.h.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.anythink.odopt.a.a.j;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.tapsdk.tapad.f.h.c.b$a$a, reason: collision with other inner class name */
        public static class C0599a implements b {
            static final /* synthetic */ boolean b = true;
            public IBinder a;

            public C0599a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.tapsdk.tapad.f.h.c.b
            public void a(com.tapsdk.tapad.f.h.c.a aVar) throws Throwable {
                Parcel parcelObtain;
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken(j.a);
                        parcelObtain.writeStrongBinder((IBinder) aVar);
                        this.a.transact(3, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        if (!b && parcelObtain == null) {
                            throw new AssertionError();
                        }
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        if (!b && parcelObtain == null) {
                            throw new AssertionError();
                        }
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

            @Override // com.tapsdk.tapad.f.h.c.b
            public void b(com.tapsdk.tapad.f.h.c.a aVar) throws Throwable {
                Parcel parcelObtain;
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken(j.a);
                        parcelObtain.writeStrongBinder((IBinder) aVar);
                        this.a.transact(2, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        if (!b && parcelObtain == null) {
                            throw new AssertionError();
                        }
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        if (!b && parcelObtain == null) {
                            throw new AssertionError();
                        }
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

    void a(com.tapsdk.tapad.f.h.c.a aVar) throws Throwable;

    void b(com.tapsdk.tapad.f.h.c.a aVar) throws Throwable;
}
