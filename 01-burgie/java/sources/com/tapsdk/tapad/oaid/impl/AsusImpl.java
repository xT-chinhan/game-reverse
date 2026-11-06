package com.tapsdk.tapad.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.IDidAidlInterface;

/* JADX INFO: loaded from: classes3.dex */
class AsusImpl implements IOAID {
    private final Context context;

    public AsusImpl(Context context) {
        this.context = context;
    }

    static /* synthetic */ String lambda$doGet$0(IBinder iBinder) {
        IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
        if (iDidAidlInterfaceAsInterface == null) {
            throw new OAIDException("IDidAidlInterface is null");
        }
        if (iDidAidlInterfaceAsInterface.isSupport()) {
            return iDidAidlInterfaceAsInterface.getOAID();
        }
        throw new OAIDException("IDidAidlInterface#isSupport return false");
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.AsusImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return AsusImpl.lambda$doGet$0(iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Asus";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null) {
            } else {
                throw new OAIDException("找不到 com.asus.msa.SupplementaryDID 包");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
