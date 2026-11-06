package com.anythink.core.common.m.d;

import com.anythink.core.api.ATAdRequest;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.h.o;
import com.anythink.core.common.t;
import com.anythink.core.common.v.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {
    List<o> a;
    boolean b;
    private final String c = getClass().getSimpleName();

    @Override // com.anythink.core.common.m.d.d
    public final int c() {
        return 1;
    }

    @Override // com.anythink.core.common.m.d.d
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.m.d.d
    protected final int g() {
        return 6;
    }

    public f(List<o> list) {
        this.a = list;
    }

    @Override // com.anythink.core.common.m.d.d
    public final byte[] e() {
        List<o> list = this.a;
        return (list == null || list.size() <= 0) ? new byte[0] : a(a(false));
    }

    @Override // com.anythink.core.common.m.d.d
    public final boolean f() {
        return this.b;
    }

    @Override // com.anythink.core.common.m.d.d
    public final void a(String str, String str2, String str3, int i) {
        if (this.b) {
            return;
        }
        String str4 = str3 + ":" + i;
        List<o> list = this.a;
        com.anythink.core.common.u.e.a("tk", str, str2, str4, (String) null, String.valueOf(list != null ? list.size() : 0), "1", (ATAdRequest) null);
        t.a().a(3, "", "", a(true), aq.a(1000));
    }

    private String a(boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectH = super.h();
        JSONObject jSONObjectI = super.i();
        try {
            jSONObjectH.put("app_id", com.anythink.core.common.d.t.b().p());
            jSONObjectH.put(com.anythink.core.common.m.e.S, this.j);
            jSONObjectH.put(com.anythink.core.common.m.e.U, this.k);
            Iterator<String> itKeys = jSONObjectI.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectH.put(next, jSONObjectI.opt(next));
            }
            Map<String, Object> mapM = com.anythink.core.common.d.t.b().m();
            if (mapM != null && mapM.size() > 0 && mapM != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : mapM.keySet()) {
                    Object obj = mapM.get(str);
                    if (obj != null) {
                        jSONObject2.put(str, obj.toString());
                    }
                }
                jSONObjectH.put("custom", jSONObject2);
            }
        } catch (Throwable unused) {
        }
        String strA = k.a(jSONObjectH.toString());
        JSONArray jSONArray = new JSONArray();
        List<o> list = this.a;
        if (list != null) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectA = it.next().a();
                if (z && jSONObjectA != null) {
                    try {
                        jSONObjectA.put(com.anythink.core.common.m.e.T, 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                jSONArray.put(jSONObjectA);
            }
        }
        String strA2 = k.a(jSONArray.toString());
        String strC = com.anythink.core.common.v.o.c(com.anythink.core.common.d.t.b().q() + "api_ver=1.0&common=" + strA + "&data=" + strA2);
        try {
            jSONObject.put(com.anythink.core.common.m.e.Y, strA);
            jSONObject.put("data", strA2);
            jSONObject.put(com.anythink.core.common.m.e.P, "1.0");
            jSONObject.put(com.anythink.core.common.m.e.X, strC);
        } catch (Exception unused2) {
        }
        return jSONObject.toString();
    }
}
