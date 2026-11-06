package com.tapsdk.tapad.f.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
class n extends o {
    private static final String d = "action.com.oplus.stdid.ID_SERVICE";
    private static final String e = "com.coloros.mcs";
    private static final String f = "com.oplus.stdid.IdentifyService";
    private final Context c;

    class a implements com.tapsdk.tapad.f.f.a {
        final /* synthetic */ com.tapsdk.tapad.f.a a;

        a(com.tapsdk.tapad.f.a aVar) {
            this.a = aVar;
        }

        @Override // com.tapsdk.tapad.f.f.a
        public String a(IBinder iBinder) throws RemoteException, com.tapsdk.tapad.f.c {
            try {
                return n.this.a(iBinder);
            } catch (Throwable th) {
                this.a.a(new com.tapsdk.tapad.f.c(th));
                return "";
            }
        }
    }

    public n(Context context) {
        super(context);
        this.c = context;
    }

    @Override // com.tapsdk.tapad.f.i.o
    protected String a(IBinder iBinder, String str, String str2) throws RemoteException, com.tapsdk.tapad.f.c {
        com.tapsdk.tapad.f.g.h hVarB = com.tapsdk.tapad.f.g.h.a.b(iBinder);
        if (hVarB != null) {
            return hVarB.a(str, str2, "OUID");
        }
        throw new com.tapsdk.tapad.f.c("IStdID is null");
    }

    @Override // com.tapsdk.tapad.f.i.o, com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.c.getPackageManager().getPackageInfo(e, 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("com.coloros.mcs package not found");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.i.o, com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        if (this.c == null || aVar == null) {
            return;
        }
        Intent intent = new Intent(d);
        intent.setComponent(new ComponentName(e, f));
        com.tapsdk.tapad.f.f.a(this.c, intent, aVar, new a(aVar));
    }

    @Override // com.tapsdk.tapad.f.i.o, com.tapsdk.tapad.f.b
    public String l() {
        return "OppoExt";
    }
}
