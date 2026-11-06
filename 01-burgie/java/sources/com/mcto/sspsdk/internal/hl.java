package com.mcto.sspsdk.internal;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class hl implements Callable {
    public final /* synthetic */ cl a;
    public final /* synthetic */ jl b;

    public hl(jl jlVar, cl clVar) {
        this.b = jlVar;
        this.a = clVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        try {
            cl clVar = this.a;
            String str2 = clVar.f;
            return jl.a(this.b, clVar);
        } catch (Exception e) {
            r9.a("ssp_water_fs", "replenish submit:", e);
            return null;
        } finally {
            str = this.a.f;
        }
    }
}
