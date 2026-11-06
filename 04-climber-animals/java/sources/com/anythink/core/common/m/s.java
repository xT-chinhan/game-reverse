package com.anythink.core.common.m;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.h.bm;
import com.anythink.core.common.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class s extends a {
    private static final String a = "s";
    public static final String b = "sdk_custom";
    private static final String f = "YXBpdjQ=";
    private JSONObject A;
    private final AtomicInteger B = new AtomicInteger(0);
    private ATAdRequest C;
    private String D;
    private boolean E;
    private final bm F;
    Map<String, Object> c;
    long d;
    long e;
    private String g;
    private String h;
    private String i;
    private Context j;
    private String k;
    private String l;
    private String u;
    private Map<String, Object> v;
    private Map<String, String> w;
    private int x;
    private JSONObject y;
    private String z;

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

    @Override // com.anythink.core.common.m.a
    protected final int l() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED;
    }

    public s(Context context, bm bmVar) {
        this.y = null;
        this.F = bmVar;
        if (bmVar != null) {
            this.k = bmVar.b();
            this.l = bmVar.c();
            this.j = context;
            this.i = bmVar.d();
            this.g = com.anythink.core.common.d.t.b().r();
            this.h = com.anythink.core.common.d.t.b().g(this.i);
            this.u = bmVar.e();
            this.c = bmVar.f();
            this.v = bmVar.g();
            this.x = bmVar.h();
            this.w = bmVar.i();
            this.y = bmVar.k();
            this.z = bmVar.l();
            this.A = bmVar.m();
            this.C = bmVar.j();
        }
    }

    @Override // com.anythink.core.common.m.a
    public final void a(int i, q qVar) {
        this.d = System.currentTimeMillis();
        this.e = SystemClock.elapsedRealtime();
        super.a(i, qVar);
    }

    @Override // com.anythink.core.common.m.a
    protected String b() {
        if (!TextUtils.isEmpty(this.D)) {
            return this.D;
        }
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.c();
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
    protected final String h() {
        return this.k;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return this.j;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return this.l;
    }

    @Override // com.anythink.core.common.m.a
    protected JSONObject e() {
        Object obj;
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", this.k);
            jSONObjectE.put(e.bk, this.i);
            jSONObjectE.put("session_id", this.h);
            jSONObjectE.put("nw_ver", com.anythink.core.common.v.m.h());
            jSONObjectE.put("exclude_myofferid", com.anythink.core.common.r.a().a(this.j));
            if (com.anythink.core.common.d.t.b().l() != null) {
                jSONObjectE.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, com.anythink.core.common.d.t.b().l());
            }
            String strC = com.anythink.core.common.d.t.b().C();
            if (!TextUtils.isEmpty(strC)) {
                jSONObjectE.put("sy_id", strC);
            }
            String strD = com.anythink.core.common.d.t.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectE.put("bk_id", strD);
            } else {
                com.anythink.core.common.d.t.b().k(com.anythink.core.common.d.t.b().B());
                jSONObjectE.put("bk_id", com.anythink.core.common.d.t.b().B());
            }
            JSONObject jSONObjectA = e.a(this.c);
            if (jSONObjectA != null) {
                jSONObjectE.put("custom", jSONObjectA);
            }
            jSONObjectE.put("deny", com.anythink.core.common.v.m.p(com.anythink.core.common.d.t.b().g()));
            if (com.anythink.core.common.d.t.b().z()) {
                com.anythink.core.common.d.t.b().A().fillRequestParam(jSONObjectE);
            }
            Map<String, Object> map = this.v;
            if (map != null && (obj = map.get(ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                jSONObjectE.put(e.ai, obj.toString());
            }
            Map<String, String> map2 = this.w;
            if (map2 != null && map2.size() != 0) {
                try {
                    jSONObjectE.put("cached", new JSONObject(this.w));
                } catch (Throwable unused) {
                }
            }
            jSONObjectE.put(e.aq, this.x);
            JSONObject jSONObjectA2 = com.anythink.core.c.b.a().a(this.i);
            if (jSONObjectA2 != null) {
                jSONObjectE.put(e.ar, jSONObjectA2);
            }
            if (w.a().a(this.i)) {
                jSONObjectE.put(e.as, 2);
            } else {
                jSONObjectE.put(e.as, 1);
            }
            if (ATAdxSetting.getInstance().isAdxNetworkMode(this.i)) {
                jSONObjectE.put(e.be, 1);
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
                    jSONObjectE.put(e.bg, jSONObject.toString());
                }
            } catch (Throwable unused2) {
            }
            jSONObjectE.put(e.bj, new JSONArray(ATAdConst.AD_SUPPORT_SDK_DSP_ID_ARRAY));
            if (!TextUtils.isEmpty(this.z)) {
                jSONObjectE.put(e.bm, this.z);
                JSONObject jSONObject3 = this.A;
                if (jSONObject3 != null) {
                    jSONObjectE.put(e.bn, jSONObject3);
                }
            }
            ATAdRequest aTAdRequest = this.C;
            if (aTAdRequest != null) {
                jSONObjectE.put(e.bp, aTAdRequest.getChannelSource());
            } else {
                jSONObjectE.put(e.bp, com.anythink.core.common.d.t.b().E());
            }
            Pair<Integer, List<String>> pairI = com.anythink.core.common.d.t.b().I();
            if (pairI != null && pairI.first != null) {
                jSONObjectE.put(e.bq, ((Integer) pairI.first).intValue());
            }
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
            if (bVarB != null) {
                String strF = bVarB.f();
                if (!TextUtils.isEmpty(strF)) {
                    jSONObjectE.put(e.br, strF);
                }
            }
        } catch (JSONException unused3) {
        }
        return jSONObjectE;
    }

    private void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectA = com.anythink.core.c.b.a().a(this.i);
        if (jSONObjectA != null) {
            jSONObject.put(e.ar, jSONObjectA);
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject f() {
        return super.f();
    }

    @Override // com.anythink.core.common.m.a
    protected Object a(Object obj) {
        try {
            bm bmVar = this.F;
            if (bmVar != null) {
                bmVar.b(this.E);
            }
            com.anythink.core.common.u.e.a("placement", this.i, this.d, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.e, this.C);
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

    @Override // com.anythink.core.common.m.a
    protected void b(AdError adError) {
        com.anythink.core.common.u.e.a("placement", adError.getPlatformCode(), adError.getPlatformMSG(), b(), this.i, "", "", this.C);
    }

    @Override // com.anythink.core.common.m.a
    protected final List<String> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.anythink.core.common.d.j.aa.a);
        return arrayList;
    }

    @Override // com.anythink.core.common.m.a
    protected final com.anythink.core.common.m.b.d m() {
        return com.anythink.core.common.m.b.d.a(com.anythink.core.common.m.b.g.a, this.i);
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(int i, int i2, String str, AdError adError) {
        if (this.r != null && !u()) {
            this.r.onLoadError(i, str, adError);
        }
        b(adError);
        a(i2);
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(int i) {
        try {
            t();
            super.a(i);
        } catch (Throwable unused) {
        }
    }

    private synchronized void t() {
        boolean z;
        try {
            String strB = b();
            if (u()) {
                z = true;
                this.B.set(1);
                try {
                    StringBuilder sb = new StringBuilder();
                    String strF = com.anythink.core.common.v.q.f(strB);
                    String[] strArrSplit = strF.split("\\.");
                    for (int i = 0; i < strArrSplit.length; i++) {
                        if (i == 0) {
                            sb.append(com.anythink.core.common.v.k.b(f));
                        } else {
                            sb.append(strArrSplit[i]);
                        }
                        if (i != strArrSplit.length - 1) {
                            sb.append(com.anythink.core.common.d.j.z);
                        }
                    }
                    this.D = strB.replace(strF, sb.toString());
                    a(0, this.r);
                } catch (Throwable th) {
                    th = th;
                    if (z) {
                        a(0, 0, String.valueOf(th), ErrorCode.getErrorCode(ErrorCode.httpStatuException, "", String.valueOf(th)));
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public final s a(String str) {
        this.D = str;
        return this;
    }

    public final s s() {
        this.E = true;
        return this;
    }

    private boolean u() {
        try {
            com.anythink.core.common.d.t.b();
            if (this.B.get() > 0) {
                return false;
            }
            com.anythink.core.d.l lVarB = com.anythink.core.d.n.a(this.j).b(this.i);
            return lVarB == null || (lVarB != null && (lVarB.aR() || lVarB.bk() || lVarB.bl()));
        } catch (Throwable unused) {
            return false;
        }
    }
}
