package com.tapsdk.tapad.f.i;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
class b implements com.tapsdk.tapad.f.b {
    private final Context a;

    class a implements com.tapsdk.tapad.f.f.a {
        a() {
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            com.tapsdk.tapad.f.g.b bVarA = com.tapsdk.tapad.f.g.b.AbstractBinderC0594b.a(iBinder);
            if (bVarA != null) {
                return bVarA.f(b.this.a.getPackageName());
            }
            throw new com.tapsdk.tapad.f.c("IDeviceIdManager is null");
        }
    }

    public b(Context context) {
        this.a = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.a.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("找不到 com.coolpad.deviceidsupport 包");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new a());
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Coolpad";
    }
}
