package com.anythink.core.common.l;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    private static final String b = "a";
    private Context c;
    private List<String> n;
    private int o;
    private long p;
    boolean a = false;
    private String l = com.anythink.core.common.d.s.b().p();
    private String m = com.anythink.core.common.d.s.b().q();

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

    public a(Context context, int i, List<String> list, long j) {
        this.c = context;
        this.o = i;
        this.n = list;
        this.p = j;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        String strA = com.anythink.core.common.g.c.a().a(com.anythink.core.common.i.h() ? com.anythink.core.common.d.i.e.H : com.anythink.core.common.d.i.e.l, "tracking");
        if (bVarB != null) {
            String strAU = bVarB.aU();
            if (!TextUtils.isEmpty(strAU)) {
                if (strAU.startsWith("http")) {
                    return strAU + "/v2/open/anr";
                }
                return com.anythink.core.common.u.p.a(strA, strAU);
            }
        }
        return strA;
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
    protected final String e() {
        return this.l;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.c;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return this.m;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        JSONObject jSONObjectJ = super.j();
        try {
            jSONObjectI.put("app_id", this.l);
            Iterator<String> itKeys = jSONObjectJ.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectI.put(next, jSONObjectJ.opt(next));
            }
            Map<String, Object> mapM = com.anythink.core.common.d.s.b().m();
            if (mapM != null && mapM.size() > 0 && mapM != null) {
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
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        JSONObject jSONObject = new JSONObject();
        try {
            String strA = com.anythink.core.common.u.j.a(i().toString());
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.n;
            if (list != null && !list.isEmpty()) {
                for (String str : this.n) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(f.bx, com.anythink.core.common.u.l.r());
                    jSONObject3.put(f.by, com.anythink.core.common.n.e.a().g());
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(f.bz, com.anythink.core.common.n.e.a().f());
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(f.bw, str);
                    jSONObject2.put(f.br, this.p);
                    jSONObject2.put(f.bs, com.anythink.core.common.d.s.b().ag());
                    jSONObject2.put(f.bt, jSONObject3.toString());
                    jSONObject2.put(f.bu, jSONObject4.toString());
                    jSONObject2.put(f.bv, jSONObject5.toString());
                    jSONArray.put(jSONObject2);
                }
            }
            String strA2 = com.anythink.core.common.u.j.a(jSONArray.toString());
            String strC = com.anythink.core.common.u.n.c(this.m + "api_ver=1.0&common=" + strA + "&data=" + strA2);
            jSONObject.put(f.Z, strA);
            jSONObject.put(f.R, strA2);
            jSONObject.put(f.P, "1.0");
            jSONObject.put(f.Y, strC);
        } catch (Throwable th) {
            th.printStackTrace();
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
