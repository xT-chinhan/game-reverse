package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.IOAIDInterface;
import com.tapsdk.tapad.oaid.qiku.QikuIdManager;

/* JADX INFO: loaded from: classes3.dex */
class QikuImpl implements IOAID {
    private final Context context;
    private boolean mUseQikuId = true;

    public QikuImpl(Context context) {
        this.context = context;
    }

    static /* synthetic */ String lambda$doGet$0(IBinder iBinder) {
        IOAIDInterface iOAIDInterfaceAsInterface = IOAIDInterface.Stub.asInterface(iBinder);
        if (iOAIDInterfaceAsInterface != null) {
            return iOAIDInterfaceAsInterface.getOAID();
        }
        throw new OAIDException("IdsSupplier is null");
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.mUseQikuId) {
            Intent intent = new Intent("qiku.service.action.id");
            intent.setPackage("com.qiku.id");
            OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.QikuImpl$$ExternalSyntheticLambda0
                @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
                public final String callRemoteInterface(IBinder iBinder) {
                    return QikuImpl.lambda$doGet$0(iBinder);
                }
            });
            return;
        }
        try {
            String oaid = new QikuIdManager().getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new OAIDException("OAID/AAID acquire failed");
            }
            iGetter.onOAIDGetComplete(oaid);
        } catch (Throwable th) {
            iGetter.onOAIDGetError(new OAIDException(th));
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Qiku";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().getPackageInfo("com.qiku.id", 0) != null) {
                return;
            }
            this.mUseQikuId = false;
            if (new QikuIdManager().isSupported()) {
            } else {
                throw new OAIDException("QikuIdManager().isSupported() is false");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
