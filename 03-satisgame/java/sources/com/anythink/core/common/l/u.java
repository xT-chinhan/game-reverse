package com.anythink.core.common.l;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.h.bo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class u extends b {
    private static final String a = "u";
    public static final String b = "sdk_custom";
    private static final String n = "YXBpdjQ=";
    private JSONObject A;
    private ATAdRequest B;
    private String C;
    private boolean D;
    private final bo E;
    private String F;
    private String G;
    private String H;
    private boolean I = false;
    Map<String, Object> c;
    long l;
    long m;
    private String o;
    private String p;
    private String q;
    private Context r;
    private String s;
    private String t;
    private String u;
    private Map<String, Object> v;
    private Map<String, String> w;
    private int x;
    private JSONObject y;
    private String z;

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
    protected final int n() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND;
    }

    public u(Context context, bo boVar) {
        this.y = null;
        this.E = boVar;
        if (boVar != null) {
            this.s = boVar.b();
            this.t = boVar.c();
            this.r = context;
            this.q = boVar.d();
            this.o = com.anythink.core.common.d.s.b().r();
            this.p = com.anythink.core.common.d.s.b().g(this.q);
            this.u = boVar.e();
            this.c = boVar.f();
            this.v = boVar.g();
            this.x = boVar.h();
            this.w = boVar.i();
            this.y = boVar.l();
            this.z = boVar.m();
            this.A = boVar.n();
            this.B = boVar.j();
            this.H = boVar.k();
            this.F = boVar.p();
        }
    }

    @Override // com.anythink.core.common.l.b
    public final void a(int i, s sVar) {
        this.l = System.currentTimeMillis();
        this.m = SystemClock.elapsedRealtime();
        super.a(i, sVar);
    }

    @Override // com.anythink.core.common.l.b
    protected String b() {
        String strB;
        if (!TextUtils.isEmpty(this.C)) {
            strB = this.C;
        } else {
            com.anythink.core.common.i.a();
            strB = com.anythink.core.common.i.b(true);
        }
        if (!TextUtils.isEmpty(strB)) {
            this.G = com.anythink.core.common.u.p.e(strB);
        }
        return strB;
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
        return this.s;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return this.r;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return this.t;
    }

    @Override // com.anythink.core.common.l.b
    protected JSONObject i() {
        Object obj;
        JSONObject jSONObjectI = super.i();
        try {
            jSONObjectI.put("app_id", this.s);
            jSONObjectI.put(f.bn, this.q);
            jSONObjectI.put(f.bo, this.p);
            jSONObjectI.put("nw_ver", com.anythink.core.common.u.l.h());
            jSONObjectI.put("exclude_myofferid", com.anythink.core.common.r.a().a(this.r));
            if (com.anythink.core.common.d.s.b().l() != null) {
                jSONObjectI.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, com.anythink.core.common.d.s.b().l());
            }
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
            JSONObject jSONObjectA = f.a(this.c);
            if (jSONObjectA != null) {
                jSONObjectI.put("custom", jSONObjectA);
            }
            jSONObjectI.put("deny", com.anythink.core.common.u.l.m(com.anythink.core.common.d.s.b().g()));
            if (com.anythink.core.common.d.s.b().A()) {
                com.anythink.core.common.d.s.b().B().fillRequestParam(jSONObjectI);
            }
            Map<String, Object> map = this.v;
            if (map != null && (obj = map.get(ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                jSONObjectI.put(f.aj, obj.toString());
            }
            Map<String, String> map2 = this.w;
            if (map2 != null && map2.size() != 0) {
                try {
                    jSONObjectI.put("cached", new JSONObject(this.w));
                } catch (Throwable unused) {
                }
            }
            jSONObjectI.put(f.ar, this.x);
            JSONObject jSONObjectA2 = com.anythink.core.d.b.a().a(this.q);
            if (jSONObjectA2 != null) {
                jSONObjectI.put(f.as, jSONObjectA2);
            }
            if (com.anythink.core.common.v.a().a(this.q)) {
                jSONObjectI.put(f.at, 2);
            } else {
                jSONObjectI.put(f.at, 1);
            }
            if (ATAdxSetting.getInstance().isAdxNetworkMode(this.q)) {
                jSONObjectI.put(f.bh, 1);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = this.y;
                if (jSONObject2 != null && jSONObject2.length() > 0) {
                    Iterator<String> itKeys = this.y.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, this.y.get(next));
                    }
                }
                if (jSONObject.length() > 0) {
                    jSONObjectI.put(f.bj, jSONObject.toString());
                }
            } catch (Throwable unused2) {
            }
            jSONObjectI.put(f.bm, new JSONArray(ATAdConst.AD_SUPPORT_SDK_DSP_ID_ARRAY));
            if (!TextUtils.isEmpty(this.z)) {
                jSONObjectI.put(f.bp, this.z);
                JSONObject jSONObject3 = this.A;
                if (jSONObject3 != null) {
                    jSONObjectI.put(f.bq, jSONObject3);
                }
            }
            ATAdRequest aTAdRequest = this.B;
            if (aTAdRequest != null) {
                jSONObjectI.put(f.bB, aTAdRequest.getChannelSource());
            } else {
                jSONObjectI.put(f.bB, com.anythink.core.common.d.s.b().F());
            }
            Pair<Integer, List<String>> pairI = com.anythink.core.common.d.s.b().I();
            if (pairI != null && pairI.first != null) {
                jSONObjectI.put(f.bC, ((Integer) pairI.first).intValue());
            }
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
            if (bVarB != null) {
                String strE2 = bVarB.e();
                if (!TextUtils.isEmpty(strE2)) {
                    jSONObjectI.put(f.bD, strE2);
                }
            }
            if (!TextUtils.isEmpty(this.F)) {
                if (this.D) {
                    this.F += "_cdn";
                }
                jSONObjectI.put(f.bT, this.F);
            }
            bo boVar = this.E;
            if (boVar != null && !TextUtils.isEmpty(boVar.k())) {
                jSONObjectI.put(f.bS, this.E.k());
            }
            if (!TextUtils.isEmpty(this.G)) {
                jSONObjectI.put(f.bU, this.G);
            }
        } catch (JSONException unused3) {
        }
        return jSONObjectI;
    }

    private void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectA = com.anythink.core.d.b.a().a(this.q);
        if (jSONObjectA != null) {
            jSONObject.put(f.as, jSONObjectA);
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject j() {
        return super.j();
    }

    @Override // com.anythink.core.common.l.b
    protected Object a(Object obj) {
        try {
            bo boVar = this.E;
            if (boVar != null) {
                boVar.b(this.D);
            }
            com.anythink.core.common.t.f.a("placement", this.q, this.l, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.m, this.B, this.H);
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (this.c != null) {
                    jSONObject.put(b, new JSONObject(this.c));
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected void a(AdError adError) {
        com.anythink.core.common.t.f.a("placement", adError.getPlatformCode(), adError.getPlatformMSG(), b(), this.q, "", "", this.B, this.H, 0);
    }

    @Override // com.anythink.core.common.l.b
    protected final List<String> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.i.ac.a);
        arrayList.add("http_type");
        return arrayList;
    }

    public final u a(boolean z) {
        this.I = z;
        return this;
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        com.anythink.core.common.l.c.d dVarA = com.anythink.core.common.l.c.d.a("placement_strategy", this.q);
        dVarA.a(this.I);
        return dVarA;
    }

    public final u b(String str) {
        this.C = str;
        return this;
    }

    public final u b(boolean z) {
        this.D = z;
        return this;
    }
}
