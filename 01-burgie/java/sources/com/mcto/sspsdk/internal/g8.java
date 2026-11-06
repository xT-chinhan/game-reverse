package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class g8 implements w3 {
    public final /* synthetic */ h8 a;

    public g8(h8 h8Var) {
        this.a = h8Var;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            this.a.a();
            return;
        }
        h8 h8Var = this.a;
        if (h8Var.b.compareAndSet(true, false)) {
            try {
                jd.a.unregisterReceiver(h8Var);
            } catch (Exception e) {
                r9.a("ssp_server", "register install re ex:", e);
            }
        }
    }
}
