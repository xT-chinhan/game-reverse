package com.anythink.core.d;

import com.anythink.core.common.h.as;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;
import com.anythink.core.d.a.d;
import com.anythink.core.d.b.c;
import com.anythink.core.e.g;
import com.anythink.core.e.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b a;
    private final c b = new c();

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

    public final void a(String str, String str2, int i, as asVar, by byVar) {
        this.b.a(str, str2, i, asVar != null ? asVar.b() : null, byVar);
    }

    public final void a(bx bxVar, by byVar) {
        this.b.a(bxVar, byVar);
    }

    public final JSONObject a(String str) {
        return this.b.a(str, 0);
    }

    public final JSONObject a(String str, int i) {
        return this.b.a(str, 4, i);
    }

    public final void b(String str) {
        this.b.b(str);
    }

    public final d a(String str, l lVar, g gVar) {
        return this.b.a(str, lVar.ax(), gVar);
    }
}
