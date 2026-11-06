package com.tapsdk.tapad.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.IDeviceIdManager;

/* JADX INFO: loaded from: classes3.dex */
class CoolpadImpl implements IOAID {
    private final Context context;

    public CoolpadImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.CoolpadImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return this.f$0.m395lambda$doGet$0$comtapsdktapadoaidimplCoolpadImpl(iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Coolpad";
    }

    /* JADX INFO: renamed from: lambda$doGet$0$com-tapsdk-tapad-oaid-impl-CoolpadImpl, reason: not valid java name */
    /* synthetic */ String m395lambda$doGet$0$comtapsdktapadoaidimplCoolpadImpl(IBinder iBinder) {
        IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
        if (iDeviceIdManagerAsInterface != null) {
            return iDeviceIdManagerAsInterface.getOAID(this.context.getPackageName());
        }
        throw new OAIDException("IDeviceIdManager is null");
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null) {
            } else {
                throw new OAIDException("找不到 com.coolpad.deviceidsupport 包");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
