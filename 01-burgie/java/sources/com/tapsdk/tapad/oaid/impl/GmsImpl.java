package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDLog;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.IAdvertisingIdService;

/* JADX INFO: loaded from: classes3.dex */
public class GmsImpl implements IOAID {
    private final Context context;

    public GmsImpl(Context context) {
        this.context = context;
    }

    static /* synthetic */ String lambda$doGet$0(IBinder iBinder) {
        IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
        if (!iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
            return iAdvertisingIdServiceAsInterface.getId();
        }
        OAIDLog.print("User has disabled advertising identifier");
        throw new OAIDException("AAID acquire failed");
    }

    private static void requireCollectionAllowed() {
        if (!OAIDFactory.isGaidCollectionAllowed()) {
            throw new OAIDException("GAID collection is not allowed");
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(final IGetter iGetter) {
        if (!OAIDFactory.isGaidCollectionAllowed()) {
            iGetter.onOAIDGetError(new OAIDException("GAID collection is not allowed"));
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        OAIDService.bind(this.context, intent, new IGetter() { // from class: com.tapsdk.tapad.oaid.impl.GmsImpl.1
            @Override // com.tapsdk.tapad.oaid.IGetter
            public void onOAIDGetComplete(String str) {
                if (OAIDFactory.isGaidCollectionAllowed()) {
                    iGetter.onOAIDGetComplete(str);
                } else {
                    iGetter.onOAIDGetError(new OAIDException("GAID collection was revoked"));
                }
            }

            @Override // com.tapsdk.tapad.oaid.IGetter
            public void onOAIDGetError(Exception exc) {
                iGetter.onOAIDGetError(exc);
            }
        }, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.GmsImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return GmsImpl.lambda$doGet$0(iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Gms";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        requireCollectionAllowed();
        try {
            if (this.context.getPackageManager().getPackageInfo("com.google.android.gms", 0) != null) {
            } else {
                throw new OAIDException("com.google.android.gms package not found");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
