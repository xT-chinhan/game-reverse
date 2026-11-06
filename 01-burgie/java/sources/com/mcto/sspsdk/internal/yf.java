package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class yf extends ag {
    public yf(String str, String str2) {
        super(2, str, str2);
    }

    @Override // com.mcto.sspsdk.internal.ag
    public final boolean a() {
        if (e1.c(this.b)) {
            return false;
        }
        c1 c1VarA = c1.a();
        String str = this.b;
        synchronized (c1VarA) {
            d1 d1Var = (d1) c1VarA.i.get(str);
            if (d1Var == null || d1Var.a.e != 5) {
                return false;
            }
            d1Var.a();
            return true;
        }
    }
}
