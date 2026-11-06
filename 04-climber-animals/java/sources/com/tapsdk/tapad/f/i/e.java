package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
class e implements com.tapsdk.tapad.f.b {
    private final Context a;

    class a implements com.tapsdk.tapad.f.f.a {
        a() {
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            com.tapsdk.tapad.f.g.a aVarA = com.tapsdk.tapad.f.g.a.b.a(iBinder);
            if (!aVarA.a(true)) {
                return aVarA.f();
            }
            com.tapsdk.tapad.f.d.a("User has disabled advertising identifier");
            throw new com.tapsdk.tapad.f.c("AAID acquire failed");
        }
    }

    public e(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.a.getPackageManager().getPackageInfo(com.anythink.core.common.v.p.a.a, 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("com.android.vending pacakge not found");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new a());
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Gms";
    }
}
