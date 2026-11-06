package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class lc implements w3 {
    public final /* synthetic */ pc a;

    public lc(pc pcVar) {
        this.a = pcVar;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.o();
            return;
        }
        this.a.k0.set(true);
        pc pcVar = this.a;
        if (pcVar.M.get() && pcVar.k0.get() && pcVar.l0.compareAndSet(false, true)) {
            pcVar.f0.a(-999, 0);
        }
    }
}
