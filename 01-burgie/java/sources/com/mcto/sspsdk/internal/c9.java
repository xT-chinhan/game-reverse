package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class c9 implements w3 {
    public final /* synthetic */ d9 a;

    public c9(d9 d9Var) {
        this.a = d9Var;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        Integer num = (Integer) obj;
        if (num == null || num.intValue() != 1) {
            return;
        }
        this.a.p.countDown();
    }
}
