package com.tapsdk.tapad.f.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
class a implements com.tapsdk.tapad.f.b {
    private final Context a;

    /* JADX INFO: renamed from: com.tapsdk.tapad.f.i.a$a, reason: collision with other inner class name */
    class C0600a implements com.tapsdk.tapad.f.f.a {
        C0600a() {
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            com.tapsdk.tapad.f.g.e eVarA = com.tapsdk.tapad.f.g.e.b.a(iBinder);
            if (eVarA == null) {
                throw new com.tapsdk.tapad.f.c("IDidAidlInterface is null");
            }
            if (eVarA.g()) {
                return eVarA.a();
            }
            throw new com.tapsdk.tapad.f.c("IDidAidlInterface#isSupport return false");
        }
    }

    public a(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("找不到 com.asus.msa.SupplementaryDID 包");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new C0600a());
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Asus";
    }
}
