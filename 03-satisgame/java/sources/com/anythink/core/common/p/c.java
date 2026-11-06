package com.anythink.core.common.p;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.n;
import com.anythink.core.common.l.f;
import com.anythink.core.common.u.j;
import com.anythink.core.e.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends com.anythink.core.common.l.b {
    private final Context b;
    private final String c;
    private final String n;
    private final n o;
    private final l p;
    private final String q;
    private final String r;
    boolean a = false;
    private final String l = s.b().p();
    private final String m = s.b().q();

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

    public c(Context context, String str, String str2, n nVar, l lVar, String str3, String str4) {
        this.b = context;
        this.c = str;
        this.n = str2;
        this.o = nVar;
        this.p = lVar;
        this.q = str3;
        this.r = str4;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        return this.c;
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
            if (mapM != null && !mapM.isEmpty()) {
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
        String strD = j.d(i().toString());
        String strC = com.anythink.core.common.u.n.c(this.m + "api_ver=" + q() + "&common=" + strD + "&data=" + this.n);
        try {
            jSONObject.put(f.Z, strD);
            jSONObject.put(f.R, this.n);
            jSONObject.put(f.P, q());
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
                    com.anythink.core.common.t.f.a("1004746", this.q, this.r, this.o, this.p, adError.getPlatformCode(), adError.getPlatformMSG());
                    return;
                } else {
                    this.a = true;
                    com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cx, new Runnable() { // from class: com.anythink.core.common.p.c$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.t();
                        }
                    }), 5000L);
                    return;
                }
            }
            com.anythink.core.common.t.f.a("1004746", this.q, this.r, this.o, this.p, adError.getPlatformCode(), adError.getPlatformMSG());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        com.anythink.core.common.u.b.c.a().c(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cy, new Runnable() { // from class: com.anythink.core.common.p.c$$ExternalSyntheticLambda1
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
}
