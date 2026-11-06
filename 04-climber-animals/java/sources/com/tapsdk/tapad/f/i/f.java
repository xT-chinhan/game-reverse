package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
class f implements com.tapsdk.tapad.f.b {
    private final Context a;
    private final Handler b = new Handler(Looper.getMainLooper());

    class a implements com.tapsdk.tapad.f.f.a {
        a() {
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws Throwable {
            com.tapsdk.tapad.f.h.c.b.a.C0599a c0599a = new com.tapsdk.tapad.f.h.c.b.a.C0599a(iBinder);
            com.tapsdk.tapad.f.h.b bVar = new com.tapsdk.tapad.f.h.b();
            bVar.a = new com.tapsdk.tapad.f.h.a.C0596a();
            c0599a.a(bVar.d);
            c0599a.b(bVar.c);
            return bVar.a.a;
        }
    }

    public f(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            this.a.getPackageManager().getPackageInfo("com.hihonor.id", 0);
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        Intent intent = new Intent("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        com.tapsdk.tapad.f.f.a(this.a, intent, aVar, new a());
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Honor";
    }
}
