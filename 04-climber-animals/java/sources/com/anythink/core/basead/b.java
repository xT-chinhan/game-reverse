package com.anythink.core.basead;

import android.content.Context;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.af;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static void a(Context context, String str, String str2) {
        af.b(context, u.b.e, str, str2);
    }

    public static String a(Context context, String str) {
        return af.c(context, u.b.e, str, "");
    }

    public static void b(Context context, String str) {
        af.a(context, u.b.e, str);
    }

    public static String a(x xVar) {
        return xVar == null ? "" : a(xVar.b, xVar.c, xVar.f);
    }

    public static String a(String str, String str2, int i) {
        return str + "_" + str2 + "_" + i;
    }
}
