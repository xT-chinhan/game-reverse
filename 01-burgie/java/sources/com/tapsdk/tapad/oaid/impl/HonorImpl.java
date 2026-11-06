package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.honor.AdvertisingIdClient;
import com.tapsdk.tapad.oaid.honor.HonorA;
import com.tapsdk.tapad.oaid.honor.oaidl.IB;

/* JADX INFO: loaded from: classes3.dex */
class HonorImpl implements IOAID {
    private final Context context;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    public HonorImpl(Context context) {
        this.context = context;
    }

    static /* synthetic */ String lambda$doGet$0(IBinder iBinder) throws Throwable {
        IB.BBinder.BBABinder bBABinder = new IB.BBinder.BBABinder(iBinder);
        HonorA honorA = new HonorA();
        honorA.info = new AdvertisingIdClient.Info();
        bBABinder.a(honorA.c);
        bBABinder.b(honorA.d);
        return honorA.info.id;
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Intent intent = new Intent("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.HonorImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return HonorImpl.lambda$doGet$0(iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Honor";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            this.context.getPackageManager().getPackageInfo("com.hihonor.id", 0);
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
