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
public class x extends b {
    public static final int A = 21;
    public static final int B = 22;
    public static final int C = 23;
    public static final int D = 24;
    public static final int E = 25;
    public static final int F = 26;
    public static final int G = 27;
    public static final int H = 28;
    private static final String J = "x";
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int l = 4;
    public static final int m = 5;
    public static final int n = 6;
    public static final int o = 7;
    public static final int p = 8;
    public static final int q = 9;
    public static final int r = 10;
    public static final int s = 11;
    public static final int t = 12;
    public static final int u = 13;
    public static final int v = 15;
    public static final int w = 16;
    public static final int x = 18;
    public static final int y = 19;
    public static final int z = 20;
    private Context K;
    private List<com.anythink.core.common.h.o> N;
    private com.anythink.core.common.h.o O;
    private int P;
    boolean I = false;
    private String L = com.anythink.core.common.d.s.b().p();
    private String M = com.anythink.core.common.d.s.b().q();

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        return obj;
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

    private x(Context context, int i, List<com.anythink.core.common.h.o> list) {
        this.K = context;
        this.P = i;
        this.N = list;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.h.o oVar = this.O;
        if (oVar == null) {
            com.anythink.core.common.i.a();
            return com.anythink.core.common.i.d();
        }
        return oVar.b.bb;
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
        List<com.anythink.core.common.h.o> list = this.N;
        com.anythink.core.common.t.f.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), b(), (String) null, String.valueOf(list != null ? list.size() : 1), "0", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return this.L;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.K;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return this.M;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        JSONObject jSONObjectJ = super.j();
        try {
            jSONObjectI.put("app_id", this.L);
            jSONObjectI.put(f.S, this.P);
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
        String strA = com.anythink.core.common.u.j.a(i().toString());
        JSONArray jSONArray = new JSONArray();
        List<com.anythink.core.common.h.o> list = this.N;
        if (list != null) {
            Iterator<com.anythink.core.common.h.o> it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectA = it.next().a();
                a(jSONObjectA);
                jSONArray.put(jSONObjectA);
            }
        } else {
            com.anythink.core.common.h.o oVar = this.O;
            if (oVar != null) {
                JSONObject jSONObjectA2 = oVar.a();
                a(jSONObjectA2);
                jSONArray.put(jSONObjectA2);
            }
        }
        String strA2 = com.anythink.core.common.u.j.a(jSONArray.toString());
        String strC = com.anythink.core.common.u.n.c(this.M + "api_ver=1.0&common=" + strA + "&data=" + strA2);
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

    private void a(JSONObject jSONObject) {
        if (!this.I || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(f.T, 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
