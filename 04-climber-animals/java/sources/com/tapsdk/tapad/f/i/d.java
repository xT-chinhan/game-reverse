package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
class d implements com.tapsdk.tapad.f.b {
    private final Context a;

    class a implements com.tapsdk.tapad.f.f.a {
        a() {
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            com.tapsdk.tapad.f.g.i iVarA = com.tapsdk.tapad.f.g.i.b.a(iBinder);
            if (iVarA != null) {
                return iVarA.a();
            }
            throw new com.tapsdk.tapad.f.c("IdsSupplier is null");
        }
    }

    public d(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.a.getPackageManager().getPackageInfo("com.android.creator", 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("com.android.creator package not fund");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new a());
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Freeme";
    }
}
