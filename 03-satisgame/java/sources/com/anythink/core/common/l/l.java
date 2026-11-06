package com.anythink.core.common.l;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l extends b {
    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.j();
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        return t().getBytes();
    }

    private static String t() {
        try {
            JSONObject jSONObject = new JSONObject();
            String strP = com.anythink.core.common.d.s.b().p();
            String strB = com.anythink.core.common.g.c.a().b();
            String strC = com.anythink.core.common.g.c.a().c();
            if (TextUtils.isEmpty(strP) || TextUtils.isEmpty(strB) || TextUtils.isEmpty(strC)) {
                com.anythink.core.common.t.f.b("cdn error 2", strP + "--" + strB + "--" + strC, com.anythink.core.common.d.s.b().r());
            }
            jSONObject.put("app_id", strP);
            jSONObject.put(com.anythink.core.e.b.a.G, strB);
            jSONObject.put(com.anythink.core.e.b.a.H, strC);
            Context contextG = com.anythink.core.common.d.s.b().g();
            jSONObject.put("domain_tcp", com.anythink.core.common.g.c.a().c(contextG));
            jSONObject.put("domain_tcp_bck", com.anythink.core.common.g.c.a().d(contextG));
            com.anythink.core.common.d.s.b();
            jSONObject.put("t_type", 100);
            jSONObject.put("sdk_ver", "UA_6.6.40");
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return com.anythink.core.common.d.s.b().p();
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        return com.anythink.core.common.l.c.d.a(com.anythink.core.common.l.c.g.f);
    }
}
