package com.mcto.sspsdk.internal;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class a6 {
    public final String a;
    public final File b;
    public String c;
    public String d = null;
    public long e = -1;
    public final int f;

    public a6(z5 z5Var) {
        this.a = z5Var.a;
        this.f = z5Var.b;
        this.c = z5Var.c;
        this.b = z5Var.d;
    }

    public final String a() {
        if (this.e < 0) {
            return null;
        }
        String str = this.d;
        if (str != null) {
            return str;
        }
        String str2 = this.b + File.separator + this.c;
        this.d = str2;
        return str2;
    }
}
