package com.smartdigimkt.r;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public static final /* synthetic */ int e = 0;
    public Context a;
    public r b;
    public p c;
    public com.smartdigimkt.q.a d;

    public s(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        com.smartdigimkt.q.a aVar;
        try {
            if (this.a != null) {
                String str = (String) Class.forName(com.smartdigimkt.r4.a0.a("frp1klkrqru1dgv1lghqwlilhu1DgyhuwlvlqjLgFolhqw'Lqir")).getDeclaredField("id").get(Class.forName(com.smartdigimkt.r4.a0.a("frp1klkrqru1dgv1lghqwlilhu1DgyhuwlvlqjLgFolhqw")).getMethod(com.smartdigimkt.r4.a0.a("jhwDgyhuwlvlqjLgLqir"), Context.class).invoke(null, this.a.getApplicationContext()));
                if (!TextUtils.isEmpty(str)) {
                    bVar.a(str, false);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        this.d = bVar;
        if (this.a == null) {
            return;
        }
        this.b = new r(this);
        try {
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (this.a.bindService(intent, this.b, 1) || (aVar = this.d) == null) {
                return;
            }
            aVar.a("Service binding failed.");
        } catch (Throwable th) {
            com.smartdigimkt.q.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a(th.getMessage());
            }
        }
    }

    public static void a(s sVar) {
        r rVar;
        Context context = sVar.a;
        if (context == null || (rVar = sVar.b) == null) {
            return;
        }
        try {
            context.unbindService(rVar);
        } catch (Throwable unused) {
        }
        sVar.c = null;
        sVar.a = null;
        sVar.d = null;
    }
}
