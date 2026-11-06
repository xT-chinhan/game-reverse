package com.anythink.core.common.l.e;

import com.anythink.core.common.d.s;
import com.anythink.core.common.u.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends i {
    List<String> a;
    int b;
    long c;
    private final String q = getClass().getSimpleName();

    @Override // com.anythink.core.common.l.e.i
    public final int a() {
        return 10;
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
    public final void e() {
    }

    @Override // com.anythink.core.common.l.e.i
    protected final int f() {
        return 4;
    }

    public a(List<String> list, long j) {
        this.a = list;
        this.b = list.size();
        this.c = j;
    }

    private int m() {
        return this.b;
    }

    @Override // com.anythink.core.common.l.e.i
    public final byte[] c() {
        return a(n());
    }

    private String n() {
        JSONObject jSONObjectK = super.k();
        JSONObject jSONObjectL = super.l();
        if (jSONObjectK != null) {
            try {
                jSONObjectK.put("app_id", s.b().p());
                jSONObjectK.put("nw_ver", com.anythink.core.common.u.l.h().toString());
                Iterator<String> itKeys = jSONObjectL.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectK.put(next, jSONObjectL.opt(next));
                }
                Map<String, Object> mapM = s.b().m();
                if (mapM != null) {
                    try {
                        if (mapM.size() > 0 && mapM != null) {
                            JSONObject jSONObject = new JSONObject();
                            for (String str : mapM.keySet()) {
                                Object obj = mapM.get(str);
                                if (obj != null) {
                                    jSONObject.put(str, obj.toString());
                                }
                            }
                            jSONObjectK.put("custom", jSONObject);
                        }
                    } catch (Throwable unused) {
                    }
                }
                jSONObjectK.put(com.anythink.core.common.l.f.S, this.o);
                jSONObjectK.put(com.anythink.core.common.l.f.U, this.p);
                jSONObjectK.put(com.anythink.core.common.l.f.V, this.p);
            } catch (Exception unused2) {
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        String strA = com.anythink.core.common.u.j.a(jSONObjectK.toString());
        try {
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.a;
            if (list != null && !list.isEmpty()) {
                for (String str2 : this.a) {
                    JSONObject jSONObject3 = new JSONObject();
                    System.currentTimeMillis();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(com.anythink.core.common.l.f.bx, com.anythink.core.common.u.l.r());
                    jSONObject4.put(com.anythink.core.common.l.f.by, com.anythink.core.common.n.e.a().g());
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(com.anythink.core.common.l.f.bz, com.anythink.core.common.n.e.a().f());
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(com.anythink.core.common.l.f.bw, str2);
                    jSONObject3.put(com.anythink.core.common.l.f.br, this.c);
                    jSONObject3.put(com.anythink.core.common.l.f.bs, s.b().ag());
                    jSONObject3.put(com.anythink.core.common.l.f.bt, jSONObject4.toString());
                    jSONObject3.put(com.anythink.core.common.l.f.bu, jSONObject5.toString());
                    jSONObject3.put(com.anythink.core.common.l.f.bv, jSONObject6.toString());
                    jSONArray.put(jSONObject3);
                }
            }
            String strA2 = com.anythink.core.common.u.j.a(jSONArray.toString());
            String strC = n.c(s.b().q() + "api_ver=1.0&common=" + strA + "&data=" + strA2);
            jSONObject2.put(com.anythink.core.common.l.f.Z, strA);
            jSONObject2.put(com.anythink.core.common.l.f.R, strA2);
            jSONObject2.put(com.anythink.core.common.l.f.P, "1.0");
            jSONObject2.put(com.anythink.core.common.l.f.Y, strC);
        } catch (Exception unused3) {
        }
        return jSONObject2.toString();
    }
}
