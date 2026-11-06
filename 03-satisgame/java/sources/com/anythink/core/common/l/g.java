package com.anythink.core.common.l;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends b {
    public static final String a = "custom";
    private static final String b = "g";
    private String c;
    private String l;
    private String m;
    private Context n;
    private long o;
    private long p;
    private Map<String, Object> q;
    private Map<String, String> r;
    private String s;
    private String t;
    private boolean u;
    private String v;
    private String w;
    private com.anythink.core.common.h.v x;
    private boolean y = false;

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

    @Override // com.anythink.core.common.l.b
    protected int n() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT;
    }

    public g(Context context, com.anythink.core.common.h.v vVar) {
        if (vVar == null) {
            return;
        }
        this.x = vVar;
        this.q = com.anythink.core.common.d.s.b().m();
        this.c = vVar.a();
        this.l = vVar.b();
        this.n = context;
        this.r = vVar.d();
        this.m = vVar.c();
        this.t = vVar.f();
        this.v = vVar.g();
    }

    @Override // com.anythink.core.common.l.b
    public final void a(int i, s sVar) {
        this.o = System.currentTimeMillis();
        this.p = SystemClock.elapsedRealtime();
        super.a(i, sVar);
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        String strA;
        if (!TextUtils.isEmpty(this.s)) {
            strA = this.s;
        } else {
            com.anythink.core.common.i.a();
            strA = com.anythink.core.common.i.a(true);
        }
        if (!TextUtils.isEmpty(strA)) {
            this.w = com.anythink.core.common.u.p.e(strA);
        }
        return strA;
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

    public final String t() {
        try {
            return k();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return this.c;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.n;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return this.l;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectI = super.i();
        try {
            jSONObjectI.put("app_id", this.c);
            jSONObjectI.put("nw_ver", com.anythink.core.common.u.l.h());
            String strD = com.anythink.core.common.d.s.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectI.put("sy_id", strD);
            }
            String strE = com.anythink.core.common.d.s.b().E();
            if (!TextUtils.isEmpty(strE)) {
                jSONObjectI.put("bk_id", strE);
            } else {
                com.anythink.core.common.d.s.b().k(com.anythink.core.common.d.s.b().C());
                jSONObjectI.put("bk_id", com.anythink.core.common.d.s.b().C());
            }
            JSONObject jSONObjectA = f.a();
            if (jSONObjectA != null) {
                jSONObjectI.put("custom", jSONObjectA);
            }
            jSONObjectI.put("deny", com.anythink.core.common.u.l.m(com.anythink.core.common.d.s.b().g()));
            if (com.anythink.core.common.d.s.b().A()) {
                jSONObjectI.put("is_test", 1);
            }
            Map<String, String> map = this.r;
            if (map != null && map.size() != 0) {
                try {
                    jSONObjectI.put("cached", new JSONObject(this.r));
                } catch (Throwable unused) {
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                com.anythink.core.common.i.a.a().a(jSONObject);
                if (jSONObject.length() > 0) {
                    jSONObjectI.put(f.bj, jSONObject.toString());
                }
            } catch (Throwable unused2) {
            }
            jSONObjectI.putOpt(f.bk, 1);
            if (!TextUtils.isEmpty(this.m)) {
                jSONObjectI.put(f.bp, this.m);
            }
            jSONObjectI.put(f.bB, com.anythink.core.common.d.s.b().F());
            Pair<Integer, List<String>> pairI = com.anythink.core.common.d.s.b().I();
            if (pairI != null && pairI.first != null) {
                jSONObjectI.put(f.bC, ((Integer) pairI.first).intValue());
            }
            com.anythink.core.common.d.s.b();
            JSONObject jSONObject2 = new JSONObject();
            com.anythink.core.common.d.s.b();
            jSONObject2.put("t_type", 100);
            jSONObject2.put(com.anythink.core.e.b.a.G, com.anythink.core.common.g.c.a().b());
            jSONObject2.put(com.anythink.core.e.b.a.H, com.anythink.core.common.g.c.a().c());
            jSONObjectI.put("open_ns", jSONObject2);
            if (!TextUtils.isEmpty(this.v)) {
                if (this.u) {
                    this.v += "_cdn";
                }
                jSONObjectI.put(f.bT, this.v);
            }
            com.anythink.core.common.h.v vVar = this.x;
            if (vVar != null && !TextUtils.isEmpty(vVar.f())) {
                jSONObjectI.put(f.bS, this.x.f());
            }
            if (!TextUtils.isEmpty(this.w)) {
                jSONObjectI.put(f.bU, this.w);
            }
        } catch (JSONException unused3) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject j() {
        return super.j();
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (this.q != null) {
                    jSONObject.put("custom", new JSONObject(this.q));
                }
            }
        } catch (Exception unused) {
        }
        com.anythink.core.common.t.f.a(com.anythink.core.common.f.a.C0017a.c, (String) null, this.o, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.p, (ATAdRequest) null, this.t);
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        com.anythink.core.common.t.f.a(com.anythink.core.common.f.a.C0017a.c, adError.getPlatformCode(), adError.getPlatformMSG(), b(), "", "", "", (ATAdRequest) null, this.t, 0);
    }

    @Override // com.anythink.core.common.l.b
    protected final List<String> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.i.ac.a);
        arrayList.add("http_type");
        return arrayList;
    }

    public final g a(boolean z) {
        this.y = z;
        return this;
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        com.anythink.core.common.l.c.d dVarA = com.anythink.core.common.l.c.d.a("app_strategy", this.c);
        dVarA.a(this.y);
        return dVarA;
    }

    public final g b(String str) {
        this.s = str;
        return this;
    }

    private g c(String str) {
        this.t = str;
        return this;
    }

    public final g b(boolean z) {
        this.u = z;
        return this;
    }
}
