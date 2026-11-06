package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.IDeviceidInterface;

/* JADX INFO: loaded from: classes3.dex */
class LenovoImpl implements IOAID {
    private final Context context;

    public LenovoImpl(Context context) {
        this.context = context;
    }

    static /* synthetic */ String lambda$doGet$0(IBinder iBinder) {
        IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
        if (iDeviceidInterfaceAsInterface == null) {
            throw new OAIDException("IDeviceidInterface is null");
        }
        if (iDeviceidInterfaceAsInterface.isSupport()) {
            return iDeviceidInterfaceAsInterface.getOAID();
        }
        throw new OAIDException("IDeviceidInterface#isSupport return false");
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.LenovoImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return LenovoImpl.lambda$doGet$0(iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Lenovo";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null) {
            } else {
                throw new OAIDException("com.zui.deviceidservice package not fund");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
