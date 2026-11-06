package com.mcto.sspsdk.internal;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class d5 {
    public final String a;
    public final long[] b;
    public boolean c;
    public c5 d;
    public final /* synthetic */ f5 e;

    public d5(f5 f5Var, String str) {
        this.e = f5Var;
        this.a = str;
        this.b = new long[f5Var.g];
    }

    public final File a(int i) {
        return new File(this.e.a, this.a + "." + i);
    }

    public final File b(int i) {
        return new File(this.e.a, this.a + "." + i + ".tmp");
    }
}
