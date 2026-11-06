package com.anythink.core.common.m;

import android.content.Context;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.aq;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class v extends a {
    public static final int A = 21;
    public static final int B = 22;
    public static final int C = 23;
    public static final int D = 24;
    public static final int E = 25;
    public static final int F = 26;
    public static final int G = 27;
    public static final int H = 28;
    private static final String J = "v";
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
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
    private String L = com.anythink.core.common.d.t.b().p();
    private String M = com.anythink.core.common.d.t.b().q();

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final int l() {
        return 6;
    }

    @Override // com.anythink.core.common.m.a
    protected final boolean p() {
        return true;
    }

    public v(Context context, int i2, List<com.anythink.core.common.h.o> list) {
        this.K = context;
        this.P = i2;
        this.N = list;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        com.anythink.core.common.h.o oVar = this.O;
        if (oVar == null) {
            com.anythink.core.common.i.a();
            return com.anythink.core.common.i.h();
        }
        return oVar.b.aP;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", Constants.CP_GZIP);
        map.put("Content-Type", "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        return b(g());
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
        List<com.anythink.core.common.h.o> list = this.N;
        com.anythink.core.common.u.e.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), b(), (String) null, String.valueOf(list != null ? list.size() : 1), "0", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        return this.L;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return this.K;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return this.M;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() throws JSONException {
        JSONObject jSONObjectE = super.e();
        JSONObject jSONObjectF = super.f();
        try {
            jSONObjectE.put("app_id", this.L);
            jSONObjectE.put(e.S, this.P);
            Iterator<String> itKeys = jSONObjectF.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectE.put(next, jSONObjectF.opt(next));
            }
            Map<String, Object> mapM = com.anythink.core.common.d.t.b().m();
            if (mapM != null && mapM.size() > 0 && mapM != null) {
                JSONObject jSONObject = new JSONObject();
                for (String str : mapM.keySet()) {
                    Object obj = mapM.get(str);
                    if (obj != null) {
                        jSONObject.put(str, obj.toString());
                    }
                }
                jSONObjectE.put("custom", jSONObject);
            }
        } catch (Throwable unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final String g() {
        JSONObject jSONObject = new JSONObject();
        String strA = com.anythink.core.common.v.k.a(e().toString());
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
        String strA2 = com.anythink.core.common.v.k.a(jSONArray.toString());
        String strC = com.anythink.core.common.v.o.c(this.M + "api_ver=1.0&common=" + strA + "&data=" + strA2);
        try {
            jSONObject.put(e.Y, strA);
            jSONObject.put("data", strA2);
            jSONObject.put(e.P, "1.0");
            jSONObject.put(e.X, strC);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void a(JSONObject jSONObject) {
        if (!this.I || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(e.T, 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> mapC = c();
        if (mapC != null) {
            try {
                for (String str : mapC.keySet()) {
                    jSONObject.put(str, mapC.get(str));
                }
            } catch (Exception unused) {
            }
        }
        String string = jSONObject.toString();
        this.I = true;
        String strG = g();
        this.I = false;
        com.anythink.core.common.t.a().a(1, b(), string, strG, aq.a(1000));
    }
}
