package com.anythink.core.a;

import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.e.l;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d a;

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public static int a(String str, l lVar) {
        if (lVar == null) {
            return 3;
        }
        return b.a(s.b().g()).a(str, String.valueOf(lVar.ap()), lVar.aw());
    }

    public static int a(by byVar) {
        if (byVar == null) {
            return 3;
        }
        return b.a(s.b().g()).a(String.valueOf(byVar.n()), byVar.G(), String.valueOf(byVar.bn()), byVar.F());
    }
}
