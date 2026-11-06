package com.anythink.core.common.m;

import android.content.Context;
import com.anythink.core.api.AdError;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k extends a {
    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final boolean b(int i) {
        return false;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.n();
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        return s().getBytes();
    }

    private static String s() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", com.anythink.core.common.d.t.b().p());
            jSONObject.put("domain", com.anythink.core.common.g.c.a().b());
            com.anythink.core.common.d.t.b();
            jSONObject.put("t_type", 0);
            jSONObject.put("sdk_ver", "UA_6.5.10");
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        return com.anythink.core.common.d.t.b().p();
    }

    @Override // com.anythink.core.common.m.a
    protected final com.anythink.core.common.m.b.d m() {
        return com.anythink.core.common.m.b.d.a(com.anythink.core.common.m.b.g.f);
    }
}
