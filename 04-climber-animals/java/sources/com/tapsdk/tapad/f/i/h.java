package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
class h implements com.tapsdk.tapad.f.b {
    private final Context a;

    class a implements com.tapsdk.tapad.f.f.a {
        a() {
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            com.tapsdk.tapad.f.g.d dVarA = com.tapsdk.tapad.f.g.d.b.a(iBinder);
            if (dVarA == null) {
                throw new com.tapsdk.tapad.f.c("IDeviceidInterface is null");
            }
            if (dVarA.g()) {
                return dVarA.a();
            }
            throw new com.tapsdk.tapad.f.c("IDeviceidInterface#isSupport return false");
        }
    }

    public h(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.a.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("com.zui.deviceidservice package not fund");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new a());
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Lenovo";
    }
}
