package com.anythink.core.common.l.e;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e extends i {
    @Override // com.anythink.core.common.l.e.i
    public final int a() {
        return 6;
    }

    @Override // com.anythink.core.common.l.e.i
    public final int b() {
        return 3;
    }

    @Override // com.anythink.core.common.l.e.i
    public final boolean d() {
        return false;
    }

    @Override // com.anythink.core.common.l.e.i
    public final byte[] c() {
        return a(m());
    }

    @Override // com.anythink.core.common.l.e.i
    public final com.anythink.core.common.l.c.h a_() {
        try {
            com.anythink.core.common.i.a();
            return new com.anythink.core.common.l.c.h(com.anythink.core.common.i.k(), com.anythink.core.common.i.l());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String m() {
        try {
            JSONObject jSONObject = new JSONObject();
            String strP = s.b().p();
            String strB = com.anythink.core.common.g.c.a().b();
            String strC = com.anythink.core.common.g.c.a().c();
            if (TextUtils.isEmpty(strP) || TextUtils.isEmpty(strB) || TextUtils.isEmpty(strC)) {
                com.anythink.core.common.t.f.b("cdn error 1", strP + "--" + strB + "--" + strC, s.b().r());
            }
            jSONObject.put("app_id", strP);
            jSONObject.put(com.anythink.core.e.b.a.G, strB);
            jSONObject.put(com.anythink.core.e.b.a.H, strC);
            Context contextG = s.b().g();
            jSONObject.put("domain_tcp", com.anythink.core.common.g.c.a().c(contextG));
            jSONObject.put("domain_tcp_bck", com.anythink.core.common.g.c.a().d(contextG));
            s.b();
            jSONObject.put("t_type", 100);
            jSONObject.put("sdk_ver", "UA_6.6.40");
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void a(final com.anythink.core.common.l.s sVar) {
        a(new i.a() { // from class: com.anythink.core.common.l.e.e.1
            @Override // com.anythink.core.common.l.e.i.a
            public final void a(Object obj) {
                com.anythink.core.common.l.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.onLoadFinish(0, obj);
                }
            }

            @Override // com.anythink.core.common.l.e.i.a
            public final void a(Throwable th) {
                com.anythink.core.common.l.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.onLoadError(0, th != null ? th.getMessage() : "", null);
                }
            }
        });
    }
}
