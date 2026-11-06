package com.anythink.core.common.l;

import android.content.Context;
import android.os.SystemClock;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class t extends b {
    private final Context a;
    private final bo b;
    private String c;
    private long l;
    private long m;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean m() {
        return true;
    }

    public t(Context context, bo boVar) {
        this.a = context;
        this.b = boVar;
        this.c = com.anythink.core.common.d.s.b().g(boVar.d());
    }

    @Override // com.anythink.core.common.l.b
    public final void a(int i, s sVar) {
        this.l = System.currentTimeMillis();
        this.m = SystemClock.elapsedRealtime();
        super.a(i, sVar);
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.g.c.a().a(com.anythink.core.common.i.h() ? com.anythink.core.common.d.i.e.Q : com.anythink.core.common.d.i.e.z);
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
        try {
            return k().getBytes("utf-8");
        } catch (Exception unused) {
            return k().getBytes();
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        if (this.b == null) {
            return super.i();
        }
        JSONObject jSONObjectI = super.i();
        try {
            jSONObjectI.put("app_id", this.b.b());
            jSONObjectI.put(f.bn, this.b.d());
            jSONObjectI.put(f.bo, this.c);
            jSONObjectI.put(f.bp, this.b.m());
        } catch (Throwable unused) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        bo boVar = this.b;
        return boVar != null ? boVar.b() : "";
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.a;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        bo boVar = this.b;
        return boVar != null ? boVar.c() : "";
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        bo boVar = this.b;
        String strD = boVar != null ? boVar.d() : "";
        bo boVar2 = this.b;
        com.anythink.core.common.t.f.a("pl_wf", adError.getPlatformCode(), adError.getPlatformMSG(), b(), strD, "", "", boVar2 != null ? boVar2.j() : null);
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        bo boVar = this.b;
        String strD = boVar != null ? boVar.d() : "";
        bo boVar2 = this.b;
        com.anythink.core.common.t.f.a("pl_wf", strD, this.l, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.m, boVar2 != null ? boVar2.j() : null);
        return obj;
    }
}
