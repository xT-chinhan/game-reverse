package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y extends b {
    private static final String a = "y";
    private Context b;
    private String c = com.anythink.core.common.d.s.b().p();
    private String l = com.anythink.core.common.d.s.b().q();
    private List<com.anythink.core.common.t.a.b.a.a.c> m;
    private com.anythink.core.common.t.a.b.a.a.c n;
    private int o;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final int n() {
        return 6;
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean p() {
        return true;
    }

    public y(Context context, int i, List<com.anythink.core.common.t.a.b.a.a.c> list) {
        this.b = context;
        this.o = i;
        this.m = list;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.d();
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(b.g, "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        return a(k());
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        List<com.anythink.core.common.t.a.b.a.a.c> list = this.m;
        int size = list != null ? list.size() : 1;
        String platformCode = adError.getPlatformCode();
        String platformMSG = adError.getPlatformMSG();
        com.anythink.core.common.i.a();
        com.anythink.core.common.t.f.a("tk", platformCode, platformMSG, com.anythink.core.common.i.d(), (String) null, String.valueOf(size), "0", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return this.c;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.b;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return this.l;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectI = super.i();
        JSONObject jSONObjectJ = super.j();
        try {
            jSONObjectI.put("app_id", this.c);
            jSONObjectI.put(f.S, this.o);
            Iterator<String> itKeys = jSONObjectJ.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectI.put(next, jSONObjectJ.opt(next));
            }
            Map<String, Object> mapM = com.anythink.core.common.d.s.b().m();
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
                        jSONObjectI.put("custom", jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            f.b(jSONObjectI);
        } catch (JSONException unused2) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        JSONObject jSONObjectA;
        JSONObject jSONObject = new JSONObject();
        String strA = com.anythink.core.common.u.j.a(i().toString());
        JSONArray jSONArray = new JSONArray();
        List<com.anythink.core.common.t.a.b.a.a.c> list = this.m;
        if (list != null) {
            for (com.anythink.core.common.t.a.b.a.a.c cVar : list) {
                JSONObject jSONObjectA2 = cVar.a();
                if (jSONObjectA2 != null) {
                    a(jSONObjectA2, cVar.b());
                    jSONArray.put(jSONObjectA2);
                }
            }
        } else {
            com.anythink.core.common.t.a.b.a.a.c cVar2 = this.n;
            if (cVar2 != null && (jSONObjectA = cVar2.a()) != null) {
                a(jSONObjectA, this.n.b());
                jSONArray.put(jSONObjectA);
            }
        }
        String strA2 = com.anythink.core.common.u.j.a(jSONArray.toString());
        String strC = com.anythink.core.common.u.n.c(this.l + "api_ver=1.0&common=" + strA + "&data=" + strA2);
        try {
            jSONObject.put(f.Z, strA);
            jSONObject.put(f.R, strA2);
            jSONObject.put(f.P, "1.0");
            jSONObject.put(f.Y, strC);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static void a(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            try {
                jSONObject.put(f.T, i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
