package com.mcto.sspsdk.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.mcto.sspsdk.jni.SimulatorDetectorJni;

/* JADX INFO: loaded from: classes2.dex */
public final class rh extends Binder implements r7 {
    public static final /* synthetic */ int a = 0;

    public rh() {
        attachInterface(this, "com.mcto.sspsdk.remote.ISimulatorDetectorInterface");
    }

    @Override // com.mcto.sspsdk.internal.r7
    public final boolean a() {
        try {
            return SimulatorDetectorJni.isSimulator();
        } catch (Exception | UnsatisfiedLinkError e) {
            return true;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("com.mcto.sspsdk.remote.ISimulatorDetectorInterface");
        }
        if (i == 1598968902) {
            parcel2.writeString("com.mcto.sspsdk.remote.ISimulatorDetectorInterface");
            return true;
        }
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        boolean zA = a();
        parcel2.writeNoException();
        parcel2.writeInt(zA ? 1 : 0);
        return true;
    }
}
