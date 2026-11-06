package com.anythink.core.common.q;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.n;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.o;
import com.anythink.core.d.l;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends com.anythink.core.common.m.a {
    private final Context b;
    private final String c;
    private final String f;
    private final n g;
    private final l h;
    private final String i;
    private final String j;
    boolean a = false;
    private final String d = t.b().p();
    private final String e = t.b().q();

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    public c(Context context, String str, String str2, n nVar, l lVar, String str3, String str4) {
        this.b = context;
        this.c = str;
        this.f = str2;
        this.g = nVar;
        this.h = lVar;
        this.i = str3;
        this.j = str4;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        return this.c;
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
    protected final String h() {
        return this.d;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return this.b;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return this.e;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() throws JSONException {
        JSONObject jSONObjectE = super.e();
        JSONObject jSONObjectF = super.f();
        try {
            jSONObjectE.put("app_id", this.d);
            Iterator<String> itKeys = jSONObjectF.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectE.put(next, jSONObjectF.opt(next));
            }
            Map<String, Object> mapM = t.b().m();
            if (mapM != null && !mapM.isEmpty()) {
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
        String strD = k.d(e().toString());
        String strC = o.c(this.e + "api_ver=" + o() + "&common=" + strD + "&data=" + this.f);
        try {
            jSONObject.put(com.anythink.core.common.m.e.Y, strD);
            jSONObject.put("data", this.f);
            jSONObject.put(com.anythink.core.common.m.e.P, o());
            jSONObject.put(com.anythink.core.common.m.e.X, strC);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
        try {
            if (!ErrorCode.httpStatuException.equals(adError.getCode())) {
                if (this.a) {
                    com.anythink.core.common.u.e.a("1004746", this.i, this.j, this.g, this.h, adError.getPlatformCode(), adError.getPlatformMSG());
                    return;
                } else {
                    this.a = true;
                    com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.q.c.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c cVar = c.this;
                            cVar.a(0, cVar.r);
                        }
                    }, 5000L);
                    return;
                }
            }
            com.anythink.core.common.u.e.a("1004746", this.i, this.j, this.g, this.h, adError.getPlatformCode(), adError.getPlatformMSG());
        } catch (Throwable unused) {
        }
    }
}
