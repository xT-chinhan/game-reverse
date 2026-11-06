package com.tapsdk.tapad.f.i;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
class o implements com.tapsdk.tapad.f.b {
    private final Context a;
    private String b;

    class a implements com.tapsdk.tapad.f.f.a {
        final /* synthetic */ com.tapsdk.tapad.f.a a;

        a(com.tapsdk.tapad.f.a aVar) {
            this.a = aVar;
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            try {
                return o.this.a(iBinder);
            } catch (Throwable th) {
                this.a.a(new com.tapsdk.tapad.f.c(th));
                return "";
            }
        }
    }

    public o(Context context) {
        this.a = context instanceof Application ? context : context.getApplicationContext();
    }

    protected String a(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, com.tapsdk.tapad.f.c {
        String packageName = this.a.getPackageName();
        try {
            Intent intent = new Intent();
            intent.setAction("oplus.intent.action.settings.OAID_MAIN");
            this.a.startActivity(intent);
        } catch (Exception unused) {
        }
        String str = this.b;
        if (str != null) {
            return a(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance(com.tapsdk.tapad.internal.utils.i.b).digest(this.a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.b = string;
        return a(iBinder, packageName, string);
    }

    protected String a(IBinder iBinder, String str, String str2) throws RemoteException, com.tapsdk.tapad.f.c {
        com.tapsdk.tapad.f.g.g gVarA = com.tapsdk.tapad.f.g.g.b.a(iBinder);
        if (gVarA != null) {
            return gVarA.a(str, str2, "OUID");
        }
        throw new com.tapsdk.tapad.f.c("IOpenID is null");
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        Context context = this.a;
        if (context == null) {
            throw new com.tapsdk.tapad.f.c("can't found application context");
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("com.heytap.openid package not found");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        if (this.a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new a(aVar));
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "OppoImp";
    }
}
