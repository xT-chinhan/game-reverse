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
import com.tapsdk.tapad.oaid.aidl.IOpenID;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
class OppoImpl implements IOAID {
    private final Context context;
    private String sign;

    public OppoImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(final IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.OppoImpl$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return this.f$0.m404lambda$doGet$0$comtapsdktapadoaidimplOppoImpl(iGetter, iBinder);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "OppoImp";
    }

    public String getSerId(IBinder iBinder, String str, String str2) {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    /* JADX INFO: renamed from: lambda$doGet$0$com-tapsdk-tapad-oaid-impl-OppoImpl, reason: not valid java name */
    /* synthetic */ String m404lambda$doGet$0$comtapsdktapadoaidimplOppoImpl(IGetter iGetter, IBinder iBinder) {
        try {
            return realGetOUID(iBinder);
        } catch (Throwable th) {
            iGetter.onOAIDGetError(new OAIDException(th));
            return "";
        }
    }

    public String realGetOUID(IBinder iBinder) {
        String packageName = this.context.getPackageName();
        try {
            Intent intent = new Intent();
            intent.setAction("oplus.intent.action.settings.OAID_MAIN");
            this.context.startActivity(intent);
        } catch (Exception e) {
        }
        String str = this.sign;
        if (str != null) {
            return getSerId(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.sign = string;
        return getSerId(iBinder, packageName, string);
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        Context context = this.context;
        if (context == null) {
            throw new OAIDException("can't found application context");
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null) {
            } else {
                throw new OAIDException("com.heytap.openid package not found");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
