package com.anythink.core.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.m.b.g;
import com.anythink.core.common.m.e;
import com.anythink.core.common.o;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.p;
import com.anythink.core.d.d;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.Constants;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.anythink.core.common.m.a {
    private static final String K = "a";
    public static final int a = 0;
    public static final int b = 1;
    public static final String c = "ex_pkg";
    String A;
    JSONObject B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public int I;
    public long J;
    private int L;
    private final String M = l.a.j;
    private final String N = "request_id";
    private final String O = "ch_info";
    private final String P = e.bn;
    private final String Q = "np";
    private final String R = "hb_size";
    private final String S = "last_wf";
    private final String T = "co";
    private final String U = l.a.S;
    private final String V = "debug";
    private final String W = e.bg;
    private final String X = "last_win";
    private final String Y = "last_m_data";
    private int Z;
    private ATAdRequest aa;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    int u;
    int v;
    String w;
    String x;
    String y;
    String z;

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 1;
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
        return MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT;
    }

    public a(String str, String str2, String str3, List<JSONObject> list, int i, l lVar) {
        this.Z = 0;
        this.d = str3;
        this.g = str;
        this.h = str2;
        this.L = i;
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        this.e = k.a(jSONArray.toString().getBytes());
        if (lVar != null) {
            this.l = lVar.ai();
            this.u = lVar.ay();
            this.Z = lVar.aW();
        }
    }

    public final void a(b bVar) {
        if (bVar.a != null) {
            this.f = k.a(bVar.a.getBytes());
        }
        this.v = bVar.f;
        if (!TextUtils.isEmpty(bVar.b) && !TextUtils.equals("[]", bVar.b)) {
            this.i = k.a(bVar.b.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.c) && !TextUtils.equals("[]", bVar.c)) {
            this.j = k.a(bVar.c.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.d) && !TextUtils.equals("[]", bVar.d)) {
            this.w = k.a(bVar.d.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.e) && !TextUtils.equals("[]", bVar.e)) {
            this.x = k.a(bVar.e.getBytes());
        }
        this.y = "";
        if (!TextUtils.isEmpty(bVar.g)) {
            this.y = k.a(bVar.g.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.h)) {
            this.k = k.a(bVar.h.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.i) && !TextUtils.equals("{}", bVar.i)) {
            this.z = k.a(bVar.i.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.j) && !TextUtils.equals("[]", bVar.j)) {
            this.A = k.a(bVar.j.getBytes());
        }
        this.B = bVar.k;
        this.C = bVar.l;
        this.D = bVar.m;
        this.E = bVar.n;
        this.F = bVar.o;
        this.G = bVar.p;
        this.H = bVar.q;
        this.I = bVar.r;
        this.J = bVar.s;
        this.aa = bVar.t;
    }

    private void d(int i) {
        this.v = i;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        return this.g;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(int i, Object obj) {
        super.a(i, obj);
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        if (this.L == 0) {
            map.put("Accept-Encoding", Constants.CP_GZIP);
        }
        map.put("Content-Type", "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        return g().getBytes();
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject e() {
        JSONObject jSONObjectA;
        l lVarB;
        JSONObject jSONObjectAQ;
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", t.b().p());
            jSONObjectE.put(e.bk, this.h);
            jSONObjectE.put("session_id", t.b().g(this.h));
            jSONObjectE.put("t_g_id", this.l);
            jSONObjectE.put("gro_id", this.u);
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
            if (this.L == 0) {
                jSONObjectE.put("misk_spt", o.a().c());
                o.a();
                jSONObjectE.put("misk_pt_det", o.b());
            }
            JSONObject jSONObjectA2 = e.a(this.h);
            if (jSONObjectA2 != null) {
                jSONObjectE.put("customs", jSONObjectA2);
            }
            e.a(jSONObjectE);
            n nVarA = n.a(t.b().g());
            String str = this.h;
            if (jSONObjectE != null && !TextUtils.isEmpty(str)) {
                try {
                    if (!TextUtils.isEmpty(str) && (lVarB = nVarA.b(str)) != null && (jSONObjectAQ = lVarB.aQ()) != null) {
                        jSONObjectE.put(l.a.aa, jSONObjectAQ);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.Z > 0 && (jSONObjectA = com.anythink.core.c.b.a().a(this.h, this.Z)) != null) {
                jSONObjectE.put(e.ar, jSONObjectA);
            }
            if (ATAdxSetting.getInstance().isAdxNetworkMode(this.h)) {
                jSONObjectE.put(e.be, 1);
                jSONObjectE.put("adap_c", this.B);
            }
            boolean zB = p.b();
            com.anythink.core.d.b bVarB = d.a(t.b().g()).b(t.b().p());
            jSONObjectE.put(GlobalSetting.COPPA, (bVarB.B() == 2 && zB) ? 1 : 2);
            jSONObjectE.put(GlobalSetting.CCPA, bVarB.A() == 3 ? 1 : 2);
            jSONObjectE.put("bid_ver", 1);
            s sVarC = t.b().c();
            if (sVarC != null) {
                sVarC.fillRequestDataForDl(jSONObjectE);
            }
            long j = this.C;
            if (j > 0) {
                jSONObjectE.put("l_t_bstart", j);
            }
            long j2 = this.D;
            if (j2 > 0) {
                jSONObjectE.put("l_t_breq", j2);
            }
            long j3 = this.E;
            if (j3 > 0) {
                jSONObjectE.put("h_s_t", j3);
            }
            long j4 = this.F;
            if (j4 > 0) {
                jSONObjectE.put("h_b_to", j4);
            }
            long j5 = this.G;
            if (j5 > 0) {
                jSONObjectE.put(l.a.B, j5);
            }
            long j6 = this.H;
            if (j6 > 0) {
                jSONObjectE.put("sp_to", j6);
            }
            Pair<Integer, List<String>> pairI = t.b().I();
            if (pairI != null && pairI.first != null) {
                jSONObjectE.put(e.bq, ((Integer) pairI.first).intValue());
            }
            String strF = bVarB.f();
            if (!TextUtils.isEmpty(strF)) {
                jSONObjectE.put(e.br, strF);
            }
            ATAdRequest aTAdRequest = this.aa;
            if (aTAdRequest != null) {
                jSONObjectE.put(e.bp, aTAdRequest.getChannelSource());
            } else {
                jSONObjectE.put(e.bp, t.b().E());
            }
        } catch (Exception unused2) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.a
    protected final JSONObject f() {
        JSONObject jSONObjectF = super.f();
        try {
            jSONObjectF.put("p_ls", this.I);
            jSONObjectF.put("p_lt_f_i", this.J);
        } catch (Throwable unused) {
        }
        return jSONObjectF;
    }

    @Override // com.anythink.core.common.m.a
    protected final String g() {
        String string = e().toString();
        String string2 = f().toString();
        Object[] objArr = new Object[2];
        HashMap map = new HashMap();
        String strA = k.a(string);
        String strA2 = k.a(string2);
        map.put("p", strA);
        map.put(e.W, strA2);
        map.put(l.a.j, this.e);
        map.put("request_id", this.d);
        int i = this.v;
        if (i > 0) {
            map.put("hb_size", Integer.valueOf(i));
        }
        if (this.L == 0) {
            if (!TextUtils.isEmpty(this.f)) {
                map.put("ch_info", this.f);
            }
            if (!TextUtils.isEmpty(this.i)) {
                map.put(e.bn, this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                map.put("np", this.j);
            }
            if (!TextUtils.isEmpty(this.w)) {
                map.put("last_wf", this.w);
            }
            if (!TextUtils.isEmpty(this.x)) {
                map.put("co", this.x);
            }
            map.put(l.a.S, this.y);
            if (t.b().l() != null) {
                map.put(c, k.a(t.b().l().toString()));
            }
            if (t.b().F() && t.b().y()) {
                map.put("debug", 1);
            }
            if (!TextUtils.isEmpty(this.k)) {
                map.put(e.bg, this.k);
            }
            if (!TextUtils.isEmpty(this.z)) {
                map.put("last_win", this.z);
            }
            if (!TextUtils.isEmpty(this.A)) {
                map.put("last_m_data", this.A);
            }
        }
        Set<String> setKeySet = map.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : setKeySet) {
                jSONObject.put(str, map.get(str));
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            System.gc();
            return null;
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        try {
            return new JSONObject(obj.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.m.a
    protected final List<String> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(j.aa.a);
        return arrayList;
    }

    @Override // com.anythink.core.common.m.a
    protected final com.anythink.core.common.m.b.d m() {
        return com.anythink.core.common.m.b.d.a(g.i);
    }
}
