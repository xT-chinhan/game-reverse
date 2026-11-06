package com.anythink.basead.i;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.t;
import com.anythink.core.common.e.o;
import com.anythink.core.common.h.x;
import com.anythink.core.common.i;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.m;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends com.anythink.core.common.m.a {
    String a;
    String b;
    String c;
    int d;
    int e;
    String f;
    String g;

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
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final int l() {
        return 34;
    }

    public a(x xVar) {
        this.a = xVar.a;
        this.b = xVar.d;
        this.c = xVar.b;
        this.d = xVar.h;
        this.e = xVar.i;
        this.f = xVar.l;
        this.g = xVar.m;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        i.a();
        return i.d();
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
        try {
            return g().getBytes("utf-8");
        } catch (Exception unused) {
            return g().getBytes();
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", t.b().p());
            jSONObjectE.put(com.anythink.core.common.m.e.bk, this.c);
            jSONObjectE.put("session_id", t.b().g(this.c));
            jSONObjectE.put("t_g_id", this.d);
            jSONObjectE.put("gro_id", this.e);
            String strC = t.b().C();
            if (!TextUtils.isEmpty(strC)) {
                jSONObjectE.put("sy_id", strC);
            }
            String strD = t.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectE.put("bk_id", strD);
            } else {
                t.b().k(t.b().B());
                jSONObjectE.put("bk_id", t.b().B());
            }
            jSONObjectE.put("deny", m.p(t.b().g()));
            JSONObject jSONObjectA = com.anythink.core.common.m.e.a(this.c);
            if (jSONObjectA != null) {
                jSONObjectE.put("customs", jSONObjectA);
            }
        } catch (Exception unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject f() {
        return super.f();
    }

    @Override // com.anythink.core.common.m.a
    protected final String g() {
        HashMap map = new HashMap();
        String strA = k.a(e().toString());
        String strA2 = k.a(f().toString());
        map.put("p", strA);
        map.put(com.anythink.core.common.m.e.W, strA2);
        map.put("request_id", this.b);
        map.put(o.a.c, this.a);
        return new JSONObject(map).toString();
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(int i, Object obj) {
        if (obj == null) {
            a(i, com.anythink.core.common.m.o.m, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", ""));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(obj.toString());
            if (TextUtils.isEmpty(jSONObject.optString("data"))) {
                a(i, com.anythink.core.common.m.o.n, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", obj.toString()));
            } else {
                super.a(i, jSONObject);
            }
        } catch (Throwable unused) {
            a(i, com.anythink.core.common.m.o.o, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", obj != null ? obj.toString() : "Adx Service Error."));
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final com.anythink.core.common.m.b.d m() {
        return com.anythink.core.common.m.b.d.a("request");
    }
}
