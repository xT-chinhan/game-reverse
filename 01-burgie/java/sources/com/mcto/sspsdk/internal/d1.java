package com.mcto.sspsdk.internal;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 {
    public final r1 a;

    public d1(Context context, u0 u0Var, y0 y0Var) {
        this.a = null;
        r1 r1Var = new r1(context);
        this.a = r1Var;
        r1Var.n = u0Var;
        String strA = u0Var.a();
        r1Var.a = strA;
        r1Var.l = y0Var;
        r1Var.d.getClass();
        u0 u0VarB = v0.b(strA);
        if (u0VarB == null) {
            r1Var.n.a = 0;
            return;
        }
        if (r1Var.c == null) {
            r1Var.n.a = 0;
            return;
        }
        File file = new File(r1Var.c, u0VarB.b());
        r1Var.j = file;
        if (!file.exists()) {
            String str = r1Var.a;
            r1Var.d.getClass();
            v0.a(str);
            r1Var.n.a = 0;
            return;
        }
        long length = r1Var.j.length();
        r1Var.g = length;
        long j = u0VarB.b;
        r1Var.i = j;
        if (u0VarB.a == 5) {
            r1Var.e = 5;
        }
        if (r1Var.l != null && r1Var.n != null) {
            kh.a.a(new o1(r1Var, j, length));
        }
        u0 u0Var2 = r1Var.n;
        u0Var2.d = u0VarB.d;
        u0Var2.a = u0VarB.a;
        u0Var2.c = u0VarB.b();
        u0 u0Var3 = r1Var.n;
        u0Var3.b = u0VarB.b;
        u0Var3.l = u0VarB.l;
        r1Var.d.getClass();
        v0.b(u0Var3);
        r1Var.k = true;
    }

    public final void a() {
        r1 r1Var = this.a;
        File file = r1Var.c;
        if (file == null) {
            r1Var.b("code:0;msg:dir_null");
        } else if (!file.exists() && !r1Var.c.mkdirs()) {
            r1Var.b("code:1;msg:dir_fail");
        } else {
            r1Var.f = 1;
            zg.a.a(new k1(r1Var));
        }
    }
}
