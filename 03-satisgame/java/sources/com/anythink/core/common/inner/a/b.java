package com.anythink.core.common.inner.a;

import com.anythink.core.common.d.s;
import com.anythink.core.common.res.d;
import com.anythink.core.common.u.n;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String a = "b";
    private static volatile b b;

    private b() {
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public static String a(String str) {
        return d.a(s.b().g()).b(2, n.a(str));
    }
}
