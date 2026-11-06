package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public final Context a;
    public h0 b;
    public com.smartdigimkt.q.a c;
    public String d;
    public d0 e;

    public e0(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        this.c = bVar;
        this.e = new d0(this);
        try {
            Intent intent = new Intent("action.com.oplus.stdid.ID_SERVICE");
            intent.setComponent(new ComponentName("com.coloros.mcs", "com.oplus.stdid.IdentifyService"));
            if (this.a.bindService(intent, this.e, 1)) {
                return;
            }
            bVar.a("Service binding failed.");
        } catch (Throwable th) {
            bVar.a("Bind Service failed: " + th.getMessage());
        }
    }

    public final void a() {
        Context context = this.a;
        if (context == null) {
            return;
        }
        try {
            context.unbindService(this.e);
        } catch (Throwable unused) {
        }
        this.b = null;
    }
}
