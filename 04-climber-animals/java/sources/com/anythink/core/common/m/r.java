package com.anythink.core.common.m;

import android.content.Context;
import android.os.SystemClock;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bm;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class r extends a {
    private final Context a;
    private final bm b;
    private String c;
    private long d;
    private long e;

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final boolean d_() {
        return true;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    public r(Context context, bm bmVar) {
        this.a = context;
        this.b = bmVar;
        this.c = com.anythink.core.common.d.t.b().g(bmVar.d());
    }

    @Override // com.anythink.core.common.m.a
    public final void a(int i, q qVar) {
        this.d = System.currentTimeMillis();
        this.e = SystemClock.elapsedRealtime();
        super.a(i, qVar);
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.g.c.a().a(com.anythink.core.common.i.l() ? com.anythink.core.common.d.j.e.J : com.anythink.core.common.d.j.e.v);
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Accept-Encoding", Constants.CP_GZIP);
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
        if (this.b == null) {
            return super.e();
        }
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", this.b.b());
            jSONObjectE.put(e.bk, this.b.d());
            jSONObjectE.put("session_id", this.c);
            jSONObjectE.put(e.bm, this.b.l());
        } catch (Throwable unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        bm bmVar = this.b;
        return bmVar != null ? bmVar.b() : "";
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return this.a;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        bm bmVar = this.b;
        return bmVar != null ? bmVar.c() : "";
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
        bm bmVar = this.b;
        String strD = bmVar != null ? bmVar.d() : "";
        bm bmVar2 = this.b;
        com.anythink.core.common.u.e.a("pl_wf", adError.getPlatformCode(), adError.getPlatformMSG(), b(), strD, "", "", bmVar2 != null ? bmVar2.j() : null);
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        bm bmVar = this.b;
        String strD = bmVar != null ? bmVar.d() : "";
        bm bmVar2 = this.b;
        com.anythink.core.common.u.e.a("pl_wf", strD, this.d, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.e, bmVar2 != null ? bmVar2.j() : null);
        return obj;
    }
}
