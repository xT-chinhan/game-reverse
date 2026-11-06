package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.IdsSupplier;

/* JADX INFO: loaded from: classes3.dex */
class FreemeImpl implements IOAID {
    private final Context context;

    public FreemeImpl(Context context) {
        this.context = context;
    }

    static /* synthetic */ String lambda$doGet$0(IBinder iBinder) {
        IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
        if (idsSupplierAsInterface != null) {
            return idsSupplierAsInterface.getOAID();
        }
        throw new OAIDException("IdsSupplier is null");
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.FreemeImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return FreemeImpl.lambda$doGet$0(iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Freeme";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().getPackageInfo("com.android.creator", 0) != null) {
            } else {
                throw new OAIDException("com.android.creator package not fund");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
