package com.anythink.core.common.m;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.an;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l extends a {
    private static final String a = "l";
    private final an b;

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
    protected final boolean d_() {
        return true;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    public l(an anVar) {
        this.b = anVar;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.m();
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Accept-Encoding", Constants.CP_GZIP);
        map.put("Content-Type", "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        try {
            return g().getBytes("utf-8");
        } catch (Exception unused) {
            return g().getBytes();
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        an anVar = this.b;
        return anVar != null ? anVar.b() : "";
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        an anVar = this.b;
        if (anVar != null) {
            return anVar.a();
        }
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        an anVar = this.b;
        return anVar != null ? anVar.c() : "";
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            an anVar = this.b;
            if (anVar != null) {
                jSONObjectE.put("app_id", anVar.b());
                jSONObjectE.put(e.bk, this.b.c());
                jSONObjectE.put("t_g_id", this.b.f());
                jSONObjectE.put("gro_id", this.b.g());
            }
        } catch (Throwable unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final String g() {
        String string = e().toString();
        String string2 = f().toString();
        Object[] objArr = new Object[2];
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.v.k.a(string);
        String strA2 = com.anythink.core.common.v.k.a(string2);
        map.put("p", strA);
        map.put(e.W, strA2);
        an anVar = this.b;
        if (anVar != null) {
            JSONArray jSONArrayD = anVar.d();
            if (jSONArrayD != null) {
                map.put(e.bn, com.anythink.core.common.v.k.a(jSONArrayD.toString()));
            }
            map.put(com.anythink.core.common.e.a.C0080a.o, this.b.e());
        }
        Set<String> setKeySet = map.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : setKeySet) {
                jSONObject.put(str, map.get(str));
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            System.gc();
            return null;
        }
    }
}
