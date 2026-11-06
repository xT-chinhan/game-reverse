package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.k;
import com.anythink.core.e.l;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c b;
    final String a = "c";

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public static int a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return b.n;
        }
        int iA = b.a(context).a(str);
        return iA != b.n ? iA : b.n;
    }

    public static int a(Context context, String str, l lVar) {
        if (context == null || lVar == null || TextUtils.isEmpty(str)) {
            return b.n;
        }
        return b.a(context).a(lVar.aD(), lVar.aE(), str);
    }

    public static void b(Context context, String str, l lVar) {
        if (context == null || lVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(context).a(lVar.aD(), lVar.aE(), str, lVar.ap());
    }

    public static int a(Context context, by byVar, String str, int i) {
        if (context == null || byVar == null || TextUtils.isEmpty(str)) {
            return b.n;
        }
        return b.a(context).a(byVar.bv(), byVar.bw(), byVar.n(), byVar.G(), String.valueOf(i));
    }

    public static void a(Context context, by byVar, String str) {
        if (context == null || byVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (context != null && byVar != null && !TextUtils.isEmpty(str)) {
            b.a(context).d(byVar);
        }
        int iBv = byVar.bv();
        long jBw = byVar.bw();
        String strG = byVar.G();
        b.a(context).b(iBv, jBw, byVar.n(), strG, String.valueOf(byVar.bn()));
    }

    public static void b(Context context, by byVar, String str) {
        if (context == null || byVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(context).a(byVar);
    }

    public static k a(Context context, by byVar) {
        if (context == null || byVar == null) {
            return null;
        }
        return b.a(context).b(byVar);
    }

    public static void b(Context context, by byVar) {
        if (context == null || byVar == null) {
            return;
        }
        b.a(context).c(byVar);
    }

    private static void c(Context context, by byVar, String str) {
        if (context == null || byVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(context).d(byVar);
    }
}
