package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.ao;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m extends b {
    private static final String a = "m";
    private final ao b;

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
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean m() {
        return true;
    }

    public m(ao aoVar) {
        this.b = aoVar;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.i();
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Accept-Encoding", "gzip");
        map.put(b.g, "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        try {
            return k().getBytes("utf-8");
        } catch (Exception unused) {
            return k().getBytes();
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        ao aoVar = this.b;
        return aoVar != null ? aoVar.b() : "";
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        ao aoVar = this.b;
        if (aoVar != null) {
            return aoVar.a();
        }
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        ao aoVar = this.b;
        return aoVar != null ? aoVar.c() : "";
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectI = super.i();
        try {
            ao aoVar = this.b;
            if (aoVar != null) {
                jSONObjectI.put("app_id", aoVar.b());
                jSONObjectI.put(f.bn, this.b.f());
                jSONObjectI.put("t_g_id", this.b.g());
                jSONObjectI.put("gro_id", this.b.h());
            }
        } catch (Throwable unused) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        String string = i().toString();
        String string2 = j().toString();
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.u.j.a(string);
        String strA2 = com.anythink.core.common.u.j.a(string2);
        map.put(f.W, strA);
        map.put(f.X, strA2);
        ao aoVar = this.b;
        if (aoVar != null) {
            JSONArray jSONArrayD = aoVar.d();
            if (jSONArrayD != null) {
                map.put(f.bq, com.anythink.core.common.u.j.a(jSONArrayD.toString()));
            }
            map.put(com.anythink.core.common.f.a.C0017a.o, this.b.e());
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
