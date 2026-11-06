package com.smartdigimkt.r;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 {
    public final Context a;
    public k0 b;
    public final l0 c = new l0(this);

    public m0(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        k0 k0Var;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.a.bindService(intent, this.c, 1) || (k0Var = this.b) == null) {
                bVar.a("Service unbind");
            } else {
                bVar.a(k0Var.a(), false);
            }
        } catch (Throwable th) {
            bVar.a(th.getMessage());
        }
    }
}
