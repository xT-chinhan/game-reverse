package com.mcto.sspsdk.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class j5 extends z2 {
    public j5(int i) {
        super(i);
    }

    @Override // com.mcto.sspsdk.internal.z2
    public final boolean a(g7 g7Var) {
        return e1.a(true, this.b, g7Var.e, g7Var.b);
    }

    @Override // com.mcto.sspsdk.internal.z2
    public final g7 b(u0 u0Var) {
        g7 g7Var = new g7();
        String str = u0Var.p;
        g7Var.e = str;
        g7Var.b = u0Var.o;
        g7Var.a = !TextUtils.isEmpty(str);
        return g7Var;
    }
}
