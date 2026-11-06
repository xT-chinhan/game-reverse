package com.byazt.pj;

import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.f;
import com.anythink.core.common.f.h;
import com.byazt.ej.k;
import com.byazt.ep.cp;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.dh;
import com.byazt.gct.fs;
import com.byazt.gct.nf;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.byazt.gct.ta;
import com.byazt.gct.v;
import com.byazt.gct.y;
import com.byazt.ho.BaseConstants;
import com.byazt.nf.rv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 441, 18})
public abstract class l<T> extends com.byazt.msp.qg<T> {
    @Override // com.byazt.msp.qg, com.byazt.yxf.n
    public void n(int i, com.byazt.zq.qg qgVar, pk pkVar) {
    }

    public abstract void n(T t);

    public abstract boolean n();

    public abstract boolean n(com.byazt.gct.n nVar);

    public abstract void qg(com.byazt.zq.qg qgVar, List<pk> list, T t);

    public l(com.byazt.gzx.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.msp.qg, com.byazt.yxf.n
    public boolean n(final com.byazt.zq.qg qgVar, List<pk> list) {
        pk pkVar = list.get(0);
        if (!com.byazt.msp.l.n(qgVar, pkVar, n())) {
            return false;
        }
        com.byazt.hm.n.n(pkVar, n() ? "rewarded_video" : "fullscreen_interstitial_ad", "get_preload_ad", new com.byazt.rs.n() { // from class: com.byazt.pj.l.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                if (qgVar.wm() != null) {
                    int iN = com.byazt.lpr.w.n(qgVar.wm());
                    if (iN == 1) {
                        jSONObject2.put(h.b.c, 1);
                    } else if (iN == 3) {
                        jSONObject2.put(h.b.c, 3);
                    } else {
                        jSONObject2.put(h.b.c, -1);
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
        return true;
    }

    @Override // com.byazt.msp.qg, com.byazt.yxf.n
    public void n(int i, List<pk> list, com.byazt.zq.qg qgVar, com.byazt.gzx.l<T> lVar, Bundle bundle, com.byazt.gzx.x xVar) {
        boolean z = bundle.getBoolean("is_cache", false);
        boolean z2 = bundle.getBoolean("is_playAgain", false);
        long j = bundle.getLong(f.a);
        n(qgVar, list, (com.byazt.msp.qg.n) new AnonymousClass2(list, z, qgVar, list.get(0), z2, bundle.getBoolean("is_second_page_ad", false), j, lVar, xVar));
    }

    /* JADX INFO: renamed from: com.byazt.pj.l$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 441, 97})
    public class AnonymousClass2 implements com.byazt.msp.qg.n<T> {
        public final /* synthetic */ com.byazt.gzx.l fs;
        public final /* synthetic */ boolean l;
        public final /* synthetic */ List n;
        public final /* synthetic */ pk q;
        public final /* synthetic */ boolean qg;
        public final /* synthetic */ com.byazt.gzx.x rv;
        public final /* synthetic */ com.byazt.zq.qg s;
        public final /* synthetic */ boolean w;
        public final /* synthetic */ long x;

        public AnonymousClass2(List list, boolean z, com.byazt.zq.qg qgVar, pk pkVar, boolean z2, boolean z3, long j, com.byazt.gzx.l lVar, com.byazt.gzx.x xVar) {
            this.n = list;
            this.qg = z;
            this.s = qgVar;
            this.q = pkVar;
            this.l = z2;
            this.w = z3;
            this.x = j;
            this.fs = lVar;
            this.rv = xVar;
        }

        @Override // com.byazt.msp.qg.n
        public void n(final T t) {
            for (pk pkVar : this.n) {
                pkVar.kx().qg();
                pkVar.d(this.qg);
            }
            l.this.qg(this.s, this.n, t);
            com.byazt.gzx.s sVar = new com.byazt.gzx.s() { // from class: com.byazt.pj.l.2.1
                public final AtomicBoolean s = new AtomicBoolean(false);
                public final AtomicBoolean q = new AtomicBoolean(false);

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // com.byazt.gzx.s
                public void n() {
                    if (!AnonymousClass2.this.l && !AnonymousClass2.this.w) {
                        l.this.n(AnonymousClass2.this.s, (List<pk>) AnonymousClass2.this.n, t);
                    }
                    com.byazt.ag.qg.qg(new Runnable() { // from class: com.byazt.pj.l.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("is_play_again", AnonymousClass2.this.l);
                                jSONObject.put("is_second_page_ad", AnonymousClass2.this.w);
                                jSONObject.put("is_cache", AnonymousClass2.this.qg);
                                jSONObject.put("cache_type", AnonymousClass2.this.q.oa(AnonymousClass2.this.qg));
                                jSONObject.put("is_adm", !TextUtils.isEmpty(AnonymousClass2.this.s.py()));
                                jSONObject.put("src_req_id", AnonymousClass2.this.q.dr());
                                jSONObject.put("is_map", AnonymousClass2.this.q.cj());
                                jSONObject.put("load_duration", System.currentTimeMillis() - AnonymousClass2.this.x);
                                jSONObject.put("reward_full_scene_type", com.byazt.has.q.n(AnonymousClass2.this.q));
                            } catch (JSONException unused) {
                            }
                            com.byazt.eji.s.n().n(AnonymousClass2.this.q, "stats_reward_full_ad_loaded", jSONObject);
                        }
                    });
                    if (AnonymousClass2.this.fs != null) {
                        com.byazt.nj.q.n((List<pk>) AnonymousClass2.this.n);
                        AnonymousClass2.this.fs.n(t, AnonymousClass2.this.qg, AnonymousClass2.this.q);
                    }
                    l.this.n(AnonymousClass2.this.s, AnonymousClass2.this.q, this);
                    l.this.n(AnonymousClass2.this.s, AnonymousClass2.this.q, t, (com.byazt.gzx.l<Object>) AnonymousClass2.this.fs, this.q, AnonymousClass2.this.x);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.byazt.gzx.s
                public void qg() {
                    if (AnonymousClass2.this.x != 0) {
                        com.byazt.hm.n.qg(AnonymousClass2.this.q, com.byazt.vgx.w.qg(l.this.n() ? 7 : 8), AnonymousClass2.this.x);
                    }
                    if (this.q.compareAndSet(false, true)) {
                        l.this.n(t);
                        if (AnonymousClass2.this.fs != null) {
                            AnonymousClass2.this.fs.n(t);
                        }
                    }
                }

                @Override // com.byazt.gzx.s
                public void s() {
                    if (this.s.compareAndSet(false, true)) {
                        l.this.n(AnonymousClass2.this.qg, AnonymousClass2.this.s, (List<pk>) AnonymousClass2.this.n);
                    }
                }
            };
            com.byazt.gzx.x xVar = this.rv;
            if (xVar != null) {
                xVar.n(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0041 A[PHI: r0
      0x0041: PHI (r0v4 long) = (r0v3 long), (r0v9 long) binds: [B:18:0x0032, B:20:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    public void n(final com.byazt.zq.qg qgVar, final pk pkVar, final T t, final com.byazt.gzx.l<T> lVar, final AtomicBoolean atomicBoolean, final long j) {
        long j2;
        if (qgVar == null || pkVar == null || atomicBoolean == null) {
            return;
        }
        long jS = com.byazt.bh.qg.n().s(n() ? 7 : 8, qgVar.q());
        if (jS < 0) {
            return;
        }
        final long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        if (j > 0) {
            jS = (long) ((jS - jCurrentTimeMillis) * 0.9f);
            if (jS < 0) {
                j2 = 0;
            } else {
                j2 = jS;
            }
        } else {
            j2 = jS;
        }
        com.byazt.ag.qg.n(new com.byazt.qit.x("dynamic_tmax_early_cached_callback") { // from class: com.byazt.pj.l.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    if (j > 0) {
                        System.currentTimeMillis();
                    }
                    qgVar.q();
                    l.this.n(t);
                    com.byazt.gzx.l lVar2 = lVar;
                    if (lVar2 != 0) {
                        lVar2.n(t);
                    }
                }
            }
        }, j2);
    }

    @Override // com.byazt.msp.qg, com.byazt.yxf.n
    public void n(com.byazt.zq.qg qgVar, int i, String str, com.byazt.gct.qg qgVar2) {
        if (qgVar != null) {
            n(qgVar.q(), i, str, qgVar2);
        }
    }

    @Override // com.byazt.msp.qg, com.byazt.yxf.n
    public void n(int i, com.byazt.gct.n nVar, com.byazt.gct.qg qgVar, y yVar, com.byazt.zq.qg qgVar2, com.byazt.gzx.l lVar, com.byazt.gzx.x xVar) {
        if (nVar.qg() == null || nVar.qg().isEmpty()) {
            com.byazt.gzx.x xVar2 = xVar;
            if (xVar2 != null) {
                xVar2.n(-3);
                return;
            }
            return;
        }
        Bundle bundle = yVar == null ? null : yVar.cy;
        boolean z = bundle != null && bundle.getBoolean("is_preload", false);
        boolean z2 = bundle != null && bundle.getBoolean("is_playAgain", false);
        long j = bundle != null ? bundle.getLong(f.a, 0L) : 0L;
        boolean z3 = bundle != null && bundle.getBoolean("is_second_page_ad", false);
        nVar.qg().size();
        final pk pkVar = nVar.qg().get(0);
        if (n(qgVar2.q(), pkVar)) {
            return;
        }
        if (!pkVar.os()) {
            if (xVar != null) {
                xVar.n(-4);
                return;
            }
            return;
        }
        if (n(nVar)) {
            if (xVar != null) {
                xVar.n(-3);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (nVar.qg().size() > 1) {
            if (fs.n(i).n("mix_ad", new fs.qg.n().n(qgVar2).n(pkVar).n())) {
                com.byazt.vgx.qg.n(nVar.qg());
                arrayList.add(pkVar);
            } else {
                arrayList.addAll(nVar.qg());
            }
        } else {
            arrayList.addAll(nVar.qg());
        }
        for (pk pkVar2 : arrayList) {
            pkVar2.y(z ? 103 : 102);
            if (yVar != null && !TextUtils.isEmpty(yVar.um)) {
                pkVar2.n(yVar.um);
            }
        }
        com.byazt.uq.qg.n(arrayList, yVar != null ? yVar.um : null);
        if (z) {
            if (this.n != null) {
                this.n.qg().n(qgVar2, pkVar);
            }
            com.byazt.ag.qg.qg(new Runnable() { // from class: com.byazt.pj.l.4
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("src_req_id", pkVar.dr());
                        jSONObject.put("is_map", pkVar.cj());
                        jSONObject.put("reward_full_scene_type", com.byazt.has.q.n(pkVar));
                    } catch (Exception unused) {
                    }
                    com.byazt.eji.s.n().n(pkVar, "stats_reward_full_preload", jSONObject);
                }
            });
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putLong(f.a, j);
            bundle2.putBoolean("is_playAgain", z2);
            bundle2.putBoolean("is_cache", false);
            bundle2.putBoolean("is_second_page_ad", z3);
            n(i, arrayList, qgVar2, lVar, bundle2, xVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, int i, String str2, com.byazt.gct.qg qgVar) {
        qgVar.n(i);
        qgVar.qg(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", com.byazt.vyf.s.cy().ou());
            jSONObject.put("rit", str);
        } catch (Exception unused) {
        }
        qgVar.n(jSONObject);
        com.byazt.gct.qg.n(qgVar);
    }

    public void n(pk pkVar, com.byazt.zq.qg qgVar) {
        qgVar.q();
        try {
            v vVarXu = pkVar.xu();
            if (vVarXu != null && !TextUtils.isEmpty(vVarXu.n())) {
                com.byazt.imu.s.n(vVarXu).n(new com.byazt.eji.qg(qgVar.q(), com.byazt.vgx.w.a(pkVar), pkVar.q(), pkVar.F_(), 8));
            }
        } catch (Throwable unused) {
        }
        if (nf.cp(pkVar) && nf.x(pkVar) != null) {
            cp.n(nf.x(pkVar).rv(), nf.x(pkVar).tj(), (com.byazt.ep.s) null);
        }
        if (n()) {
            for (ry ryVar : cx.a(pkVar)) {
                cp.n(ryVar.q(), ryVar.l(), (com.byazt.ep.s) null);
            }
            for (ry ryVar2 : dh.l(pkVar)) {
                cp.n(ryVar2.q(), ryVar2.l(), (com.byazt.ep.s) null);
            }
        }
        if (TextUtils.isEmpty(pe.cp(pkVar))) {
            return;
        }
        cp.n(pe.cp(pkVar), pe.d(pkVar), (com.byazt.ep.s) null);
    }

    private void qg(com.byazt.zq.qg qgVar, final pk pkVar, final com.byazt.gzx.s sVar) {
        if (ta.k(pkVar) == null) {
            return;
        }
        com.byazt.zsl.l lVarN = ta.n(1, pkVar);
        lVarN.n("material_meta", pkVar);
        lVarN.n("ad_slot", qgVar);
        com.byazt.gks.s.n(lVarN, new com.byazt.pzg.n() { // from class: com.byazt.pj.l.5
            @Override // com.byazt.ej.tj.n
            public void qg(k kVar, int i) {
                com.byazt.gzx.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.qg();
                }
            }

            @Override // com.byazt.ej.tj.n
            public void n(k kVar, int i, String str) {
                com.byazt.gzx.s sVar2;
                if (ta.oa(pkVar) && (sVar2 = sVar) != null) {
                    sVar2.qg();
                }
            }
        });
        com.byazt.gks.s.n(pkVar, lVarN);
    }

    @Override // com.byazt.msp.qg
    public void n(com.byazt.zq.qg qgVar, List<pk> list, T t) {
        pk pkVar = list.get(0);
        if (this.n != null) {
            this.n.qg().n(qgVar, pkVar, t, pkVar.wn());
        }
    }

    @Override // com.byazt.yxf.n
    public void n(final com.byazt.zq.qg qgVar, final pk pkVar, com.byazt.gzx.s sVar) {
        com.byazt.ag.qg.l(new Runnable() { // from class: com.byazt.pj.l.6
            @Override // java.lang.Runnable
            public void run() {
                l.this.n(pkVar, qgVar);
            }
        });
        if (com.byazt.gks.n.n(pkVar)) {
            com.byazt.gks.n.qg(pkVar);
            sVar.qg();
            return;
        }
        if (!cx.s(pkVar, true)) {
            sVar.qg();
            return;
        }
        if (com.byazt.qq.qg.s(pkVar)) {
            if (cd.n(pkVar) && com.byazt.ql.s.n(pkVar)) {
                qg(qgVar, pkVar, sVar);
                return;
            } else {
                sVar.qg();
                return;
            }
        }
        if (pk.s(pkVar) || com.byazt.ql.s.n(pkVar)) {
            qg(qgVar, pkVar, sVar);
        } else {
            sVar.qg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(String str, pk pkVar) {
        if (!rv.qg().qg(str) || pkVar == null) {
            return false;
        }
        int i = n() ? 7 : 8;
        pk pkVarQg = com.byazt.tf.n.n().qg(n(), str);
        if (pkVarQg == null) {
            return false;
        }
        if (pkVarQg.ju() + pkVarQg.kc() < System.currentTimeMillis()) {
            com.byazt.ci.l.n(i).n(str);
            return true;
        }
        if (!TextUtils.equals(pkVarQg.ha(), pkVar.ha())) {
            if (com.byazt.vgx.qg.n(pkVar, n() ? 7 : 8) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(pkVar.su());
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.get(next);
                pkVarQg.A_().put(next, jSONObject.get(next));
            }
            pkVarQg.t(pkVarQg.A_().toString());
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.byazt.yxf.n
    public void n(final com.byazt.zq.qg qgVar) {
        if (rv.qg().qg(qgVar.q())) {
            y yVar = new y();
            yVar.n = 2;
            if (rv.qg().rv(qgVar.q()) || qgVar.fs() > 0.0f) {
                yVar.x = 2;
            }
            rv.n().qg(qgVar, yVar, n() ? 7 : 8, new com.byazt.mw.n.qg() { // from class: com.byazt.pj.l.7
                @Override // com.byazt.mw.n.qg
                public void n(int i, String str, com.byazt.gct.qg qgVar2) {
                    qgVar2.n(i);
                    qgVar2.qg(str);
                    com.byazt.gct.qg.n(qgVar2);
                }

                @Override // com.byazt.mw.n.qg
                public void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar2) {
                    if (nVar.qg() == null || nVar.qg().isEmpty()) {
                        l.this.n(qgVar.q(), -3, com.byazt.bxg.n.n(-3), qgVar2);
                        return;
                    }
                    pk pkVar = nVar.qg().get(0);
                    if (l.this.n(qgVar.q(), pkVar)) {
                        return;
                    }
                    if (!pkVar.os() || l.this.n(nVar)) {
                        l.this.n(qgVar.q(), -4, com.byazt.bxg.n.n(-4), qgVar2);
                        return;
                    }
                    if (nVar.qg().size() > 1) {
                        if (fs.n(l.this.n() ? 7 : 8).n("mix_ad", new fs.qg.n().n(qgVar).n(pkVar).n())) {
                            com.byazt.vgx.qg.n(nVar.qg());
                        }
                    }
                    if (l.this.n != null) {
                        l.this.n.qg().n(qgVar, pkVar);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("src_req_id", pkVar.dr());
                        jSONObject.put("is_map", pkVar.cj());
                    } catch (Exception unused) {
                    }
                    com.byazt.eji.s.n().n(pkVar, "stats_reward_full_preload", jSONObject);
                }
            });
        }
    }
}
