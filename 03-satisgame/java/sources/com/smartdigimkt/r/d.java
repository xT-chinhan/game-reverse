package com.smartdigimkt.r;

import android.app.KeyguardManager;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final Context a;
    public KeyguardManager b;

    public d(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        Context context = this.a;
        if (context != null) {
            if (this.b == null) {
                this.b = (KeyguardManager) context.getSystemService("keyguard");
            }
            KeyguardManager keyguardManager = this.b;
            if (keyguardManager == null) {
                bVar.a("KeyguardManager not found");
                return;
            }
            try {
                Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.b, null);
                if (objInvoke != null) {
                    bVar.a(objInvoke.toString(), false);
                } else {
                    bVar.a("CoolSea OAID obtain failed.");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
