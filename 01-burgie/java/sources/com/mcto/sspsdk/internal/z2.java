package com.mcto.sspsdk.internal;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z2 {
    public final int a;
    public final Context b = jd.a;

    public z2(int i) {
        this.a = i;
    }

    public abstract boolean a(g7 g7Var);

    public boolean a(u0 u0Var) {
        g7 g7VarB = b(u0Var);
        if (!g7VarB.a) {
            return false;
        }
        int i = this.a;
        u0Var.l = i;
        v0 v0VarA = v0.a();
        String str = u0Var.i;
        v0VarA.getClass();
        u0 u0VarB = v0.b(str);
        HashMap map = new HashMap();
        map.put(v5.KEY_DOWNLOAD_TYPE, Integer.valueOf(i));
        if (u0VarB == null) {
            v0.a().getClass();
            v0.a(u0Var);
            l lVarA = l.a();
            String strA = u0Var.a();
            String str2 = u0Var.f;
            lVarA.getClass();
            l.a(strA, str2, 33, map);
        } else {
            int i2 = u0VarB.m;
            if (i2 == 0 || i2 == 5) {
                u0VarB.m = 9;
                v0.a().getClass();
                v0.b(u0VarB);
                l lVarA2 = l.a();
                String strA2 = u0Var.a();
                String str3 = u0Var.f;
                lVarA2.getClass();
                l.a(strA2, str3, 33, map);
            } else {
                int i3 = u0VarB.l;
                int i4 = u0Var.l;
                if (i3 != i4) {
                    u0VarB.l = i4;
                    v0.a().getClass();
                    v0.b(u0VarB);
                }
            }
        }
        boolean zA = a(g7VarB);
        u0Var.c();
        return zA;
    }

    public abstract g7 b(u0 u0Var);
}
