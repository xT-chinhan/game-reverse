package com.anythink.core.common.m.d;

import com.anythink.core.common.d.t;
import com.anythink.core.common.i;
import com.anythink.core.common.m.b.h;
import com.anythink.core.common.m.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {
    @Override // com.anythink.core.common.m.d.d
    public final int c() {
        return 6;
    }

    @Override // com.anythink.core.common.m.d.d
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.m.d.d
    public final boolean f() {
        return false;
    }

    @Override // com.anythink.core.common.m.d.d
    public final byte[] e() {
        return a(b());
    }

    @Override // com.anythink.core.common.m.d.d
    public final h e_() {
        try {
            i.a();
            return new h(i.o(), i.p());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", t.b().p());
            jSONObject.put("domain", com.anythink.core.common.g.c.a().b());
            t.b();
            jSONObject.put("t_type", 0);
            jSONObject.put("sdk_ver", "UA_6.5.10");
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void a(final q qVar) {
        a(new d.a() { // from class: com.anythink.core.common.m.d.b.1
            @Override // com.anythink.core.common.m.d.d.a
            public final void a(Object obj) {
                q qVar2 = qVar;
                if (qVar2 != null) {
                    qVar2.onLoadFinish(0, obj);
                }
            }

            @Override // com.anythink.core.common.m.d.d.a
            public final void a(Throwable th) {
                q qVar2 = qVar;
                if (qVar2 != null) {
                    qVar2.onLoadError(0, th.getMessage(), null);
                }
            }
        });
    }
}
