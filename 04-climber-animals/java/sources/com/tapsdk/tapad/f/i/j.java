package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
class j implements com.tapsdk.tapad.f.b {
    private final Context a;

    class a implements com.tapsdk.tapad.f.f.a {
        a() {
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            com.tapsdk.tapad.f.g.j jVarA = com.tapsdk.tapad.f.g.j.b.a(iBinder);
            if (jVarA == null) {
                throw new com.tapsdk.tapad.f.c("MsaIdInterface is null");
            }
            if (jVarA.e()) {
                return jVarA.a();
            }
            throw new com.tapsdk.tapad.f.c("MsaIdInterface#isSupported return false");
        }
    }

    public j(Context context) {
        this.a = context;
    }

    private void b(com.tapsdk.tapad.f.a aVar) {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            this.a.startForegroundService(intent);
        } catch (Throwable th) {
            aVar.a(new com.tapsdk.tapad.f.c(th));
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.a.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("com.mdid.msa package not found");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        b(aVar);
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
        com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new a());
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Msa";
    }
}
