package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
class p implements com.tapsdk.tapad.f.b {
    private final Context a;
    private boolean b = true;

    class a implements com.tapsdk.tapad.f.f.a {
        a() {
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            com.tapsdk.tapad.f.g.f fVarA = com.tapsdk.tapad.f.g.f.b.a(iBinder);
            if (fVarA != null) {
                return fVarA.a();
            }
            throw new com.tapsdk.tapad.f.c("IdsSupplier is null");
        }
    }

    public p(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.a.getPackageManager().getPackageInfo("com.qiku.id", 0) != null) {
                return;
            }
            this.b = false;
            if (new com.tapsdk.tapad.f.j.a().f()) {
            } else {
                throw new com.tapsdk.tapad.f.c("QikuIdManager().isSupported() is false");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        if (this.b) {
            Intent intent = new Intent("qiku.service.action.id");
            intent.setPackage("com.qiku.id");
            com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new a());
            return;
        }
        try {
            String strB = new com.tapsdk.tapad.f.j.a().b();
            if (strB == null || strB.length() == 0) {
                throw new com.tapsdk.tapad.f.c("OAID/AAID acquire failed");
            }
            aVar.a(strB);
        } catch (Throwable th) {
            aVar.a(new com.tapsdk.tapad.f.c(th));
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Qiku";
    }
}
