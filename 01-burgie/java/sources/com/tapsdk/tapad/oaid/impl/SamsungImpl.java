package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.IDeviceIdService;

/* JADX INFO: loaded from: classes3.dex */
class SamsungImpl implements IOAID {
    private final Context context;

    public SamsungImpl(Context context) {
        this.context = context;
    }

    static /* synthetic */ String lambda$doGet$0(IBinder iBinder) {
        IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
        if (iDeviceIdServiceAsInterface != null) {
            return iDeviceIdServiceAsInterface.getOAID();
        }
        throw new OAIDException("IDeviceIdService is null");
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.SamsungImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return SamsungImpl.lambda$doGet$0(iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Samsung";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null) {
            } else {
                throw new OAIDException("com.samsung.android.deviceidservice package not found");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
