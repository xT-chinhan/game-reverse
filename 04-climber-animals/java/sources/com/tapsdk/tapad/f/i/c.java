package com.tapsdk.tapad.f.i;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class c implements com.tapsdk.tapad.f.b {
    private final Context a;
    private KeyguardManager b;

    public c(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) this.a.getSystemService("keyguard");
            this.b = keyguardManager;
            if (((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]))).booleanValue()) {
            } else {
                throw new com.tapsdk.tapad.f.c("keyguard service is not supported");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            aVar.a(new com.tapsdk.tapad.f.c("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke == null) {
                throw new com.tapsdk.tapad.f.c("OAID obtain failed");
            }
            aVar.a(objInvoke.toString());
        } catch (Throwable th) {
            aVar.a(new com.tapsdk.tapad.f.c(th));
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Coosea";
    }
}
