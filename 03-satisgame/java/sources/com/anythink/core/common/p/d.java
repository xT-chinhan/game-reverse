package com.anythink.core.common.p;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.n;
import com.anythink.core.common.l.f;
import com.anythink.core.common.u.j;
import com.anythink.core.e.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.anythink.core.common.l.b {
    private Context b;
    private int c;
    private String n;
    private n o;
    private l p;
    private String q;
    private String r;
    boolean a = false;
    private String l = s.b().p();
    private String m = s.b().q();

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
    protected final String q() {
        return i.e.b;
    }

    public d(Context context, int i, String str, n nVar, l lVar, String str2, String str3) {
        this.b = context;
        this.c = i;
        this.o = nVar;
        this.p = lVar;
        this.q = str2;
        this.r = str3;
        this.n = str;
    }

    @Override // com.anythink.core.common.l.b
    protected final List<String> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.ac.a);
        return arrayList;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.c();
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
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
        return this.b;
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
            Map<String, Object> mapM = s.b().m();
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
        String strA = j.a(i().toString());
        String strC = com.anythink.core.common.u.n.c(this.m + "api_ver=2.0&common=" + strA + "&data=" + this.n + "&ss_a=" + this.c);
        try {
            jSONObject.put(f.Z, strA);
            jSONObject.put("ss_a", this.c);
            jSONObject.put(f.R, this.n);
            jSONObject.put(f.P, i.e.b);
            jSONObject.put(f.Y, strC);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        try {
            if (!ErrorCode.httpStatuException.equals(adError.getCode())) {
                if (this.a) {
                    com.anythink.core.common.t.f.a("1004658", this.q, this.r, this.o, this.p, adError.getPlatformCode(), adError.getPlatformMSG());
                    return;
                } else {
                    this.a = true;
                    com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cB, new Runnable() { // from class: com.anythink.core.common.p.d$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.t();
                        }
                    }), 5000L);
                    return;
                }
            }
            com.anythink.core.common.t.f.a("1004658", this.q, this.r, this.o, this.p, adError.getPlatformCode(), adError.getPlatformMSG());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        com.anythink.core.common.u.b.c.a().c(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cC, new Runnable() { // from class: com.anythink.core.common.p.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.u();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        a(0, this.i);
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        return com.anythink.core.common.l.c.d.a("s2s_reward");
    }
}
