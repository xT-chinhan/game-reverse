package com.anythink.core.c.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.l.f;
import com.anythink.core.common.o;
import com.anythink.core.common.u.j;
import com.anythink.core.e.d;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.gopherhole.androidvibrate.BuildConfig;
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
public class a extends com.anythink.core.common.l.b {
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
    private int Z;
    private ATAdRequest aa;
    private long ab;
    private long ac;
    String l;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    int t;
    int u;
    int v;
    String w;
    String x;
    String y;
    String z;
    private final String M = l.a.j;
    private final String N = "request_id";
    private final String O = "ch_info";
    private final String P = f.bq;
    private final String Q = "np";
    private final String R = "hb_size";
    private final String S = "last_wf";
    private final String T = "co";
    private final String U = l.a.S;
    private final String V = BuildConfig.BUILD_TYPE;
    private final String W = f.bj;
    private final String X = "last_win";
    private final String Y = "last_m_data";
    private boolean ad = false;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final int n() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT;
    }

    public a(String str, String str2, String str3, List<JSONObject> list, int i, l lVar) {
        this.Z = 0;
        this.l = str3;
        this.o = str;
        this.p = str2;
        this.L = i;
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        this.m = j.a(jSONArray.toString().getBytes());
        if (lVar != null) {
            this.t = lVar.ah();
            this.u = lVar.ax();
            this.Z = lVar.aT();
        }
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.a != null) {
            this.n = j.a(bVar.a.getBytes());
        }
        this.v = bVar.f;
        if (!TextUtils.isEmpty(bVar.b) && !TextUtils.equals("[]", bVar.b)) {
            this.q = j.a(bVar.b.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.c) && !TextUtils.equals("[]", bVar.c)) {
            this.r = j.a(bVar.c.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.d) && !TextUtils.equals("[]", bVar.d)) {
            this.w = j.a(bVar.d.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.e) && !TextUtils.equals("[]", bVar.e)) {
            this.x = j.a(bVar.e.getBytes());
        }
        this.y = "";
        if (!TextUtils.isEmpty(bVar.g)) {
            this.y = j.a(bVar.g.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.h)) {
            this.s = j.a(bVar.h.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.i) && !TextUtils.equals("{}", bVar.i)) {
            this.z = j.a(bVar.i.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.j) && !TextUtils.equals("[]", bVar.j)) {
            this.A = j.a(bVar.j.getBytes());
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

    private void b(int i) {
        this.v = i;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        return this.o;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(int i, Object obj) {
        super.a(i, obj);
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        if (this.L == 0) {
            map.put("Accept-Encoding", "gzip");
        }
        map.put(com.anythink.core.common.l.b.g, "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        return k().getBytes();
    }

    public final String t() {
        try {
            return k();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectA;
        l lVarB;
        JSONObject jSONObjectAN;
        JSONObject jSONObjectI = super.i();
        try {
            jSONObjectI.put("app_id", s.b().p());
            jSONObjectI.put(f.bn, this.p);
            jSONObjectI.put(f.bo, s.b().g(this.p));
            jSONObjectI.put("t_g_id", this.t);
            jSONObjectI.put("gro_id", this.u);
            String strD = s.b().D();
            if (!TextUtils.isEmpty(strD)) {
                jSONObjectI.put("sy_id", strD);
            }
            String strE = s.b().E();
            if (!TextUtils.isEmpty(strE)) {
                jSONObjectI.put("bk_id", strE);
            } else {
                s.b().k(s.b().C());
                jSONObjectI.put("bk_id", s.b().C());
            }
            jSONObjectI.put("deny", com.anythink.core.common.u.l.m(s.b().g()));
            if (this.L == 0) {
                jSONObjectI.put("misk_spt", o.a().c());
                o.a();
                jSONObjectI.put("misk_pt_det", o.b());
            }
            JSONObject jSONObjectA2 = f.a(this.p);
            if (jSONObjectA2 != null) {
                jSONObjectI.put("customs", jSONObjectA2);
            }
            f.a(jSONObjectI);
            n nVarA = n.a(s.b().g());
            String str = this.p;
            if (jSONObjectI != null && !TextUtils.isEmpty(str)) {
                try {
                    if (!TextUtils.isEmpty(str) && (lVarB = nVarA.b(str)) != null && (jSONObjectAN = lVarB.aN()) != null) {
                        jSONObjectI.put(l.a.aa, jSONObjectAN);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.Z > 0 && (jSONObjectA = com.anythink.core.d.b.a().a(this.p, this.Z)) != null) {
                jSONObjectI.put(f.as, jSONObjectA);
            }
            if (ATAdxSetting.getInstance().isAdxNetworkMode(this.p)) {
                jSONObjectI.put(f.bh, 1);
                jSONObjectI.put("adap_c", this.B);
            }
            boolean zB = com.anythink.core.common.u.o.b();
            com.anythink.core.e.b bVarB = d.a(s.b().g()).b(s.b().p());
            jSONObjectI.put(GlobalSetting.COPPA, (bVarB.t() == 2 && zB) ? 1 : 2);
            jSONObjectI.put(GlobalSetting.CCPA, bVarB.s() == 3 ? 1 : 2);
            jSONObjectI.put("bid_ver", 1);
            r rVarC = s.b().c();
            if (rVarC != null) {
                rVarC.fillRequestDataForDl(jSONObjectI);
            }
            long j = this.C;
            if (j > 0) {
                jSONObjectI.put("l_t_bstart", j);
            }
            long j2 = this.D;
            if (j2 > 0) {
                jSONObjectI.put("l_t_breq", j2);
            }
            long j3 = this.E;
            if (j3 > 0) {
                jSONObjectI.put("h_s_t", j3);
            }
            long j4 = this.F;
            if (j4 > 0) {
                jSONObjectI.put("h_b_to", j4);
            }
            long j5 = this.G;
            if (j5 > 0) {
                jSONObjectI.put(l.a.B, j5);
            }
            long j6 = this.H;
            if (j6 > 0) {
                jSONObjectI.put("sp_to", j6);
            }
            Pair<Integer, List<String>> pairI = s.b().I();
            if (pairI != null && pairI.first != null) {
                jSONObjectI.put(f.bC, ((Integer) pairI.first).intValue());
            }
            String strE2 = bVarB.e();
            if (!TextUtils.isEmpty(strE2)) {
                jSONObjectI.put(f.bD, strE2);
            }
            ATAdRequest aTAdRequest = this.aa;
            if (aTAdRequest != null) {
                jSONObjectI.put(f.bB, aTAdRequest.getChannelSource());
            } else {
                jSONObjectI.put(f.bB, s.b().F());
            }
        } catch (Exception unused2) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.b
    protected final JSONObject j() {
        JSONObject jSONObjectJ = super.j();
        try {
            jSONObjectJ.put("p_ls", this.I);
            jSONObjectJ.put("p_lt_f_i", this.J);
        } catch (Throwable unused) {
        }
        return jSONObjectJ;
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        String string = i().toString();
        String string2 = j().toString();
        HashMap map = new HashMap();
        String strA = j.a(string);
        String strA2 = j.a(string2);
        map.put(f.W, strA);
        map.put(f.X, strA2);
        map.put(l.a.j, this.m);
        map.put("request_id", this.l);
        int i = this.v;
        if (i > 0) {
            map.put("hb_size", Integer.valueOf(i));
        }
        if (this.L == 0) {
            if (!TextUtils.isEmpty(this.n)) {
                map.put("ch_info", this.n);
            }
            if (!TextUtils.isEmpty(this.q)) {
                map.put(f.bq, this.q);
            }
            if (!TextUtils.isEmpty(this.r)) {
                map.put("np", this.r);
            }
            if (!TextUtils.isEmpty(this.w)) {
                map.put("last_wf", this.w);
            }
            if (!TextUtils.isEmpty(this.x)) {
                map.put("co", this.x);
            }
            map.put(l.a.S, this.y);
            if (s.b().l() != null) {
                map.put(c, j.a(s.b().l().toString()));
            }
            if (s.b().G() && s.b().z()) {
                map.put(BuildConfig.BUILD_TYPE, 1);
            }
            if (!TextUtils.isEmpty(this.s)) {
                map.put(f.bj, this.s);
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

    @Override // com.anythink.core.common.l.b
    public final void a(int i, com.anythink.core.common.l.s sVar) {
        this.ab = System.currentTimeMillis();
        this.ac = SystemClock.elapsedRealtime();
        super.a(i, sVar);
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        try {
            com.anythink.core.common.t.f.a("bid", this.p, this.ab, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.ac, this.aa);
            return new JSONObject(obj.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.l.b
    protected final List<String> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.ac.a);
        return arrayList;
    }

    public final a u() {
        this.ad = true;
        return this;
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        com.anythink.core.common.l.c.d dVarA = com.anythink.core.common.l.c.d.a("bid");
        dVarA.a(this.ad);
        return dVarA;
    }
}
