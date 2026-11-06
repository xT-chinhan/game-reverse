package com.anythink.core.a;

import android.content.Context;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.bq;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.e.l;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a c;
    Context a;
    private final String b = getClass().getSimpleName();

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    private a(Context context) {
        this.a = context;
    }

    public static int a(l lVar, String str) {
        if (lVar == null) {
            return b.n;
        }
        return b.a(s.b().g()).a(str, String.valueOf(lVar.ap()), lVar.au(), lVar.av());
    }

    public static int a(by byVar, int i) {
        if (byVar == null) {
            return b.n;
        }
        b bVarA = b.a(s.b().g());
        String strValueOf = String.valueOf(byVar.n());
        String strG = byVar.G();
        String strValueOf2 = String.valueOf(i);
        long jP = byVar.p();
        long jQ = byVar.q();
        byVar.F();
        return bVarA.a(strValueOf, strG, strValueOf2, jP, jQ);
    }

    public static bq a(String str, int i) {
        b bVarA = b.a(s.b().g());
        bq bqVar = new bq();
        bqVar.b = str;
        bqVar.a = i;
        bqVar.c = (int) bVarA.b(str);
        bqVar.d = (int) bVarA.c(str);
        return bqVar;
    }

    public static bq.a a(String str) {
        b bVarA = b.a(s.b().g());
        bq.a aVar = new bq.a();
        aVar.a = str;
        aVar.d = (int) bVarA.d(str);
        aVar.e = (int) bVarA.e(str);
        return aVar;
    }

    public static int[] a(int i) {
        b bVarA = b.a(s.b().g());
        String strValueOf = String.valueOf(i);
        return new int[]{(int) bVarA.f(strValueOf), (int) bVarA.g(strValueOf)};
    }

    public static void a(n nVar, String str, String str2, String str3) {
        b.a(s.b().g()).a(nVar.Z(), str, str2, str3);
    }
}
