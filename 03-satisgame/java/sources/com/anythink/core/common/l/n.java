package com.anythink.core.common.l;

import android.content.Context;
import android.os.SystemClock;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.au;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class n extends b {
    List<au> a;
    long b;
    long c;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return "";
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    public n(List<au> list) {
        this.a = list;
    }

    @Override // com.anythink.core.common.l.b
    public final void a(int i, s sVar) {
        this.b = System.currentTimeMillis();
        this.c = SystemClock.elapsedRealtime();
        super.a(i, sVar);
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.n();
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
        return t().getBytes();
    }

    private String t() {
        try {
            JSONObject jSONObject = new JSONObject();
            f.a(com.anythink.core.common.d.s.b().g(), jSONObject);
            List<au> list = this.a;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (au auVar : this.a) {
                    if (auVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        auVar.b(jSONObject2);
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("t_items", jSONArray);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return com.anythink.core.common.d.s.b().p();
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        String platformCode = adError.getPlatformCode();
        String platformMSG = adError.getPlatformMSG();
        com.anythink.core.common.i.a();
        com.anythink.core.common.t.f.a("ht_bt", platformCode, platformMSG, com.anythink.core.common.i.n(), "", "", "", (ATAdRequest) null);
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        com.anythink.core.common.t.f.a("ht_bt", "", this.b, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.c, (ATAdRequest) null);
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        return com.anythink.core.common.l.c.d.a(com.anythink.core.common.l.c.g.n);
    }
}
