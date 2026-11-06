package com.anythink.core.basead;

import android.content.Context;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.x;
import com.anythink.core.common.u.ad;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b a;

    private b() {
    }

    private static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private static void a(Context context, String str, String str2) {
        ad.b(context, t.b.e, str, str2);
    }

    private static String a(Context context, String str) {
        return ad.c(context, t.b.e, str, "");
    }

    private static void b(Context context, String str) {
        ad.a(context, t.b.e, str);
    }

    private static String a(x xVar) {
        if (xVar == null) {
            return "";
        }
        return xVar.a + "_" + xVar.e + "_" + xVar.j;
    }

    private static String a(String str, String str2, int i) {
        return str + "_" + str2 + "_" + i;
    }
}
