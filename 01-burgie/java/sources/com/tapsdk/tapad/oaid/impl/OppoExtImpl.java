package com.tapsdk.tapad.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.IStdID;

/* JADX INFO: loaded from: classes3.dex */
class OppoExtImpl extends OppoImpl {
    private static final String ACTION = "action.com.oplus.stdid.ID_SERVICE";
    private static final String CLASS_NAME = "com.oplus.stdid.IdentifyService";
    private static final String PACKAGE_NAME = "com.coloros.mcs";
    private final Context context;

    public OppoExtImpl(Context context) {
        super(context);
        this.context = context;
    }

    @Override // com.tapsdk.tapad.oaid.impl.OppoImpl, com.tapsdk.tapad.oaid.IOAID
    public void doGet(final IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(ACTION);
        intent.setComponent(new ComponentName(PACKAGE_NAME, CLASS_NAME));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.OppoExtImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return this.f$0.m403lambda$doGet$0$comtapsdktapadoaidimplOppoExtImpl(iGetter, iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.impl.OppoImpl, com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "OppoExt";
    }

    @Override // com.tapsdk.tapad.oaid.impl.OppoImpl
    public String getSerId(IBinder iBinder, String str, String str2) {
        IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
        if (iStdIDAsInterface != null) {
            return iStdIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IStdID is null");
    }

    /* JADX INFO: renamed from: lambda$doGet$0$com-tapsdk-tapad-oaid-impl-OppoExtImpl, reason: not valid java name */
    /* synthetic */ String m403lambda$doGet$0$comtapsdktapadoaidimplOppoExtImpl(IGetter iGetter, IBinder iBinder) {
        try {
            return realGetOUID(iBinder);
        } catch (Throwable th) {
            iGetter.onOAIDGetError(new OAIDException(th));
            return "";
        }
    }

    @Override // com.tapsdk.tapad.oaid.impl.OppoImpl, com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0) != null) {
            } else {
                throw new OAIDException("com.coloros.mcs package not found");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
