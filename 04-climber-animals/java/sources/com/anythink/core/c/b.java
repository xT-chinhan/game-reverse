package com.anythink.core.c;

import com.anythink.core.c.a.d;
import com.anythink.core.c.b.c;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.bu;
import com.anythink.core.common.h.bv;
import com.anythink.core.d.f;
import com.anythink.core.d.l;
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

    public final void a(String str, String str2, int i, ar arVar, bv bvVar) {
        this.b.a(str, str2, i, arVar != null ? arVar.b() : null, bvVar);
    }

    public final void a(bu buVar, bv bvVar) {
        this.b.a(buVar, bvVar);
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

    public final d a(String str, l lVar, f fVar) {
        return this.b.a(str, lVar.ay(), fVar);
    }
}
