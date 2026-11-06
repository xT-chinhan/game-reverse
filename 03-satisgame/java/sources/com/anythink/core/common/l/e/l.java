package com.anythink.core.common.l.e;

import com.anythink.core.common.d.s;
import com.anythink.core.common.u.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l extends i {
    List<com.anythink.core.common.t.a.b.a.a.c> a;
    boolean b;
    private final String c = getClass().getSimpleName();
    private int q;

    @Override // com.anythink.core.common.l.e.i
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.e.i
    public final int b() {
        return 3;
    }

    @Override // com.anythink.core.common.l.e.i
    public final void e() {
    }

    @Override // com.anythink.core.common.l.e.i
    protected final int f() {
        return 6;
    }

    public l(List<com.anythink.core.common.t.a.b.a.a.c> list) {
        this.a = list;
    }

    @Override // com.anythink.core.common.l.e.i
    public final byte[] c() {
        List<com.anythink.core.common.t.a.b.a.a.c> list = this.a;
        return (list == null || list.size() <= 0) ? new byte[0] : a(m());
    }

    @Override // com.anythink.core.common.l.e.i
    public final boolean d() {
        return this.b;
    }

    private String m() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectK = super.k();
        JSONObject jSONObjectL = super.l();
        try {
            jSONObjectK.put("app_id", s.b().p());
            jSONObjectK.put(com.anythink.core.common.l.f.S, this.o);
            jSONObjectK.put(com.anythink.core.common.l.f.U, this.p);
            Iterator<String> itKeys = jSONObjectL.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectK.put(next, jSONObjectL.opt(next));
            }
            Map<String, Object> mapM = s.b().m();
            if (mapM != null) {
                try {
                    if (mapM.size() > 0 && mapM != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (String str : mapM.keySet()) {
                            Object obj = mapM.get(str);
                            if (obj != null) {
                                jSONObject2.put(str, obj.toString());
                            }
                        }
                        jSONObjectK.put("custom", jSONObject2);
                    }
                } catch (Throwable unused) {
                }
            }
            com.anythink.core.common.l.f.b(jSONObjectK);
        } catch (JSONException unused2) {
        }
        String strA = com.anythink.core.common.u.j.a(jSONObjectK.toString());
        JSONArray jSONArray = new JSONArray();
        List<com.anythink.core.common.t.a.b.a.a.c> list = this.a;
        if (list != null) {
            for (com.anythink.core.common.t.a.b.a.a.c cVar : list) {
                JSONObject jSONObjectA = cVar.a();
                if (jSONObjectA != null) {
                    if (jSONObjectA != null) {
                        try {
                            jSONObjectA.put(com.anythink.core.common.l.f.T, cVar.b());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    jSONArray.put(jSONObjectA);
                }
            }
        }
        String strA2 = com.anythink.core.common.u.j.a(jSONArray.toString());
        String strC = n.c(s.b().q() + "api_ver=1.0&common=" + strA + "&data=" + strA2);
        try {
            jSONObject.put(com.anythink.core.common.l.f.Z, strA);
            jSONObject.put(com.anythink.core.common.l.f.R, strA2);
            jSONObject.put(com.anythink.core.common.l.f.P, "1.0");
            jSONObject.put(com.anythink.core.common.l.f.Y, strC);
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }
}
