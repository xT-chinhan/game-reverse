package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class q8 implements w3 {
    public final /* synthetic */ s8 a;

    public q8(s8 s8Var) {
        this.a = s8Var;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        Integer num = (Integer) obj;
        if (num == null || num.intValue() != 1) {
            return;
        }
        this.a.t.countDown();
    }
}
