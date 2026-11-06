package com.byazt.vh;

import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ea.w;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.hs;
import com.byazt.hg.i;
import com.byazt.hg.ie;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.byazt.hg.qv;
import com.byazt.hg.y;
import com.byazt.ihe.m;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.wt.ls;
import com.byazt.wt.ny;
import com.byazt.zp.k;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1093, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public abstract class c<T> extends com.byazt.ra.hw<T> {
    public abstract void hw(com.byazt.qe.hw hwVar, List<of> list, T t);

    public abstract void pr(T t);

    public abstract boolean pr();

    public abstract boolean pr(com.byazt.hg.pr prVar);

    public c(com.byazt.pe.hw hwVar) {
        super(hwVar);
    }

    @Override // com.byazt.ra.hw, com.byazt.ci.pr
    public boolean pr(final com.byazt.qe.hw hwVar, List<of> list) {
        of ofVar = list.get(0);
        if (!com.byazt.ra.c.pr(hwVar, ofVar, pr())) {
            return false;
        }
        com.byazt.pj.pr.pr(ofVar, pr() ? "rewarded_video" : "fullscreen_interstitial_ad", "get_preload_ad", new com.byazt.ttf.pr() { // from class: com.byazt.vh.c.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                if (hwVar.fo() != null) {
                    switch (com.byazt.nq.x.pr(hwVar.fo())) {
                        case 1:
                            jSONObject2.put("req_type", 1);
                            break;
                        case 2:
                        default:
                            jSONObject2.put("req_type", -1);
                            break;
                        case 3:
                            jSONObject2.put("req_type", 3);
                            break;
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
        return true;
    }

    @Override // com.byazt.ra.hw, com.byazt.ci.pr
    public void pr(int i, List<of> list, com.byazt.qe.hw hwVar, com.byazt.pe.c<T> cVar, Bundle bundle, com.byazt.pe.fw fwVar) {
        boolean z = bundle.getBoolean("is_cache", false);
        boolean z2 = bundle.getBoolean("is_playAgain", false);
        long j = bundle.getLong(d.p);
        pr(hwVar, list, (com.byazt.ra.hw.pr) new AnonymousClass2(list, z, hwVar, list.get(0), z2, bundle.getBoolean("is_second_page_ad", false), j, cVar, fwVar));
    }

    /* JADX INFO: renamed from: com.byazt.vh.c$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1093, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS})
    public class AnonymousClass2 implements com.byazt.ra.hw.pr<T> {
        public final /* synthetic */ com.byazt.pe.fw aj;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ long fw;
        public final /* synthetic */ com.byazt.qe.hw hn;
        public final /* synthetic */ boolean hw;
        public final /* synthetic */ List pr;
        public final /* synthetic */ boolean uc;
        public final /* synthetic */ of x;
        public final /* synthetic */ com.byazt.pe.c zo;

        public AnonymousClass2(List list, boolean z, com.byazt.qe.hw hwVar, of ofVar, boolean z2, boolean z3, long j, com.byazt.pe.c cVar, com.byazt.pe.fw fwVar) {
            this.pr = list;
            this.hw = z;
            this.hn = hwVar;
            this.x = ofVar;
            this.c = z2;
            this.uc = z3;
            this.fw = j;
            this.zo = cVar;
            this.aj = fwVar;
        }

        @Override // com.byazt.ra.hw.pr
        public void pr(final T t) {
            for (of ofVar : this.pr) {
                ofVar.xh().hw();
                ofVar.vk(this.hw);
            }
            c.this.hw(this.hn, this.pr, t);
            com.byazt.pe.hn hnVar = new com.byazt.pe.hn() { // from class: com.byazt.vh.c.2.1
                public final AtomicBoolean hn = new AtomicBoolean(false);

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
                @Override // com.byazt.pe.hn
                public void pr() {
                    if (!AnonymousClass2.this.c && !AnonymousClass2.this.uc) {
                        c.this.pr(AnonymousClass2.this.hn, (List<of>) AnonymousClass2.this.pr, t);
                    }
                    zo.hw(new Runnable() { // from class: com.byazt.vh.c.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("is_play_again", AnonymousClass2.this.c);
                                jSONObject.put("is_second_page_ad", AnonymousClass2.this.uc);
                                jSONObject.put("is_cache", AnonymousClass2.this.hw);
                                jSONObject.put("cache_type", AnonymousClass2.this.x.w(AnonymousClass2.this.hw));
                                jSONObject.put("is_adm", !TextUtils.isEmpty(AnonymousClass2.this.hn.cz()));
                                jSONObject.put("src_req_id", AnonymousClass2.this.x.nb());
                                jSONObject.put("is_map", AnonymousClass2.this.x.gd());
                                jSONObject.put("load_duration", System.currentTimeMillis() - AnonymousClass2.this.fw);
                                jSONObject.put("reward_full_scene_type", com.byazt.lu.x.pr(AnonymousClass2.this.x));
                            } catch (JSONException e) {
                            }
                            com.byazt.xk.hw.pr().pr(AnonymousClass2.this.x, "stats_reward_full_ad_loaded", jSONObject);
                        }
                    });
                    if (AnonymousClass2.this.zo != null) {
                        AnonymousClass2.this.zo.pr(t, AnonymousClass2.this.hw, AnonymousClass2.this.x);
                    }
                    c.this.pr(AnonymousClass2.this.hn, AnonymousClass2.this.x, this);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.byazt.pe.hn
                public void hw() {
                    if (AnonymousClass2.this.fw != 0) {
                        com.byazt.pj.pr.hw(AnonymousClass2.this.x, ls.hw(c.this.pr() ? 7 : 8), AnonymousClass2.this.fw);
                    }
                    c.this.pr(t);
                    if (AnonymousClass2.this.zo != null) {
                        AnonymousClass2.this.zo.pr(t);
                    }
                }

                @Override // com.byazt.pe.hn
                public void hn() {
                    if (this.hn.compareAndSet(false, true)) {
                        c.this.pr(AnonymousClass2.this.hw, AnonymousClass2.this.hn, (List<of>) AnonymousClass2.this.pr);
                    }
                }
            };
            com.byazt.pe.fw fwVar = this.aj;
            if (fwVar != null) {
                fwVar.pr(hnVar);
            }
        }
    }

    @Override // com.byazt.ra.hw, com.byazt.ci.pr
    public void pr(com.byazt.qe.hw hwVar, int i, String str, com.byazt.hg.hw hwVar2) {
        if (hwVar != null) {
            pr(hwVar.x(), i, str, hwVar2);
        }
    }

    @Override // com.byazt.ra.hw, com.byazt.ci.pr
    public void pr(int i, com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar, i iVar, com.byazt.qe.hw hwVar2, com.byazt.pe.c cVar, com.byazt.pe.fw fwVar) {
        if (prVar.hw() == null || prVar.hw().isEmpty()) {
            if (fwVar != null) {
                fwVar.pr(-3);
                return;
            }
            return;
        }
        Bundle bundle = iVar == null ? null : iVar.nt;
        boolean z = bundle != null && bundle.getBoolean("is_preload", false);
        boolean z2 = bundle != null && bundle.getBoolean("is_playAgain", false);
        long j = bundle != null ? bundle.getLong(d.p, 0L) : 0L;
        boolean z3 = bundle != null && bundle.getBoolean("is_second_page_ad", false);
        prVar.hw().size();
        final of ofVar = prVar.hw().get(0);
        if (pr(hwVar2.x(), ofVar)) {
            return;
        }
        if (ofVar.rq()) {
            if (pr(prVar)) {
                if (fwVar != null) {
                    fwVar.pr(-3);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (prVar.hw().size() > 1) {
                if (com.byazt.hg.zo.pr(i).pr("mix_ad", new com.byazt.hg.zo.hw.pr().pr(hwVar2).pr(ofVar).pr())) {
                    com.byazt.sd.pr.pr(prVar.hw());
                    arrayList.add(ofVar);
                } else {
                    arrayList.addAll(prVar.hw());
                }
            } else {
                arrayList.addAll(prVar.hw());
            }
            Iterator<of> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().i(z ? 103 : 102);
            }
            if (z) {
                if (this.pr != null) {
                    this.pr.hw().pr(hwVar2, ofVar);
                }
                zo.hw(new Runnable() { // from class: com.byazt.vh.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("src_req_id", ofVar.nb());
                            jSONObject.put("is_map", ofVar.gd());
                            jSONObject.put("reward_full_scene_type", com.byazt.lu.x.pr(ofVar));
                        } catch (Exception e) {
                        }
                        com.byazt.xk.hw.pr().pr(ofVar, "stats_reward_full_preload", jSONObject);
                    }
                });
                return;
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putLong(d.p, j);
                bundle2.putBoolean("is_playAgain", z2);
                bundle2.putBoolean("is_cache", false);
                bundle2.putBoolean("is_second_page_ad", z3);
                pr(i, arrayList, hwVar2, cVar, bundle2, fwVar);
                return;
            }
        }
        if (fwVar != null) {
            fwVar.pr(-4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, int i, String str2, com.byazt.hg.hw hwVar) {
        hwVar.pr(i);
        hwVar.hw(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, com.byazt.sd.zo.nt().ny());
            jSONObject.put("rit", str);
        } catch (Exception e) {
        }
        hwVar.pr(jSONObject);
        com.byazt.hg.hw.pr(hwVar);
    }

    public void pr(of ofVar, com.byazt.qe.hw hwVar) {
        hwVar.x();
        try {
            y yVarMo = ofVar.mo();
            if (yVarMo != null && !TextUtils.isEmpty(yVarMo.pr())) {
                com.byazt.ub.hw.pr(yVarMo).pr(new com.byazt.pk.x(hwVar.x(), ls.yb(ofVar), ofVar.x(), ofVar.B_(), 8));
            }
        } catch (Throwable th) {
        }
        if (ie.w(ofVar) && ie.fw(ofVar) != null) {
            w.pr(ie.fw(ofVar).aj(), ie.fw(ofVar).vk(), (com.byazt.ea.hn) null);
        }
        if (pr()) {
            for (pj pjVar : jn.a(ofVar)) {
                w.pr(pjVar.x(), pjVar.c(), (com.byazt.ea.hn) null);
            }
            for (pj pjVar2 : hs.c(ofVar)) {
                w.pr(pjVar2.x(), pjVar2.c(), (com.byazt.ea.hn) null);
            }
        }
        if (!TextUtils.isEmpty(o.w(ofVar))) {
            w.pr(o.w(ofVar), o.k(ofVar), (com.byazt.ea.hn) null);
        }
    }

    private void hw(com.byazt.qe.hw hwVar, final of ofVar, final com.byazt.pe.hn hnVar) {
        if (qv.ho(ofVar) == null) {
            return;
        }
        com.byazt.n.uc ucVarPr = qv.pr(1, ofVar);
        ucVarPr.pr("material_meta", ofVar);
        ucVarPr.pr("ad_slot", hwVar);
        com.byazt.it.hn.pr(ucVarPr, new com.byazt.e.pr() { // from class: com.byazt.vh.c.4
            @Override // com.byazt.ihe.vk.pr
            public void hw(m mVar, int i) {
                com.byazt.pe.hn hnVar2 = hnVar;
                if (hnVar2 != null) {
                    hnVar2.hw();
                }
            }

            @Override // com.byazt.ihe.vk.pr
            public void pr(m mVar, int i, String str) {
                com.byazt.pe.hn hnVar2;
                if (qv.m(ofVar) && (hnVar2 = hnVar) != null) {
                    hnVar2.hw();
                }
            }
        });
    }

    @Override // com.byazt.ra.hw
    public void pr(com.byazt.qe.hw hwVar, List<of> list, T t) {
        of ofVar = list.get(0);
        if (this.pr != null) {
            this.pr.hw().pr(hwVar, ofVar, t, ofVar.ji());
        }
    }

    @Override // com.byazt.ra.hw, com.byazt.ci.pr
    public void pr(int i, com.byazt.qe.hw hwVar, of ofVar) {
    }

    @Override // com.byazt.ci.pr
    public void pr(final com.byazt.qe.hw hwVar, final of ofVar, com.byazt.pe.hn hnVar) {
        zo.c(new Runnable() { // from class: com.byazt.vh.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.pr(ofVar, hwVar);
            }
        });
        if (com.byazt.lpk.pr.pr(ofVar)) {
            com.byazt.lpk.pr.hw(ofVar);
            hnVar.hw();
            return;
        }
        if (!jn.hn(ofVar, true)) {
            hnVar.hw();
            return;
        }
        if (ny.hn(ofVar)) {
            if (lb.pr(ofVar) && k.pr(ofVar)) {
                hw(hwVar, ofVar, hnVar);
                return;
            } else {
                hnVar.hw();
                return;
            }
        }
        if (of.hn(ofVar) || k.pr(ofVar)) {
            hw(hwVar, ofVar, hnVar);
        } else {
            hnVar.hw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(String str, of ofVar) {
        if (!a.hw().hw(str) || ofVar == null) {
            return false;
        }
        int i = pr() ? 7 : 8;
        of ofVarHw = com.byazt.bv.pr.pr().hw(pr(), str);
        if (ofVarHw == null) {
            return false;
        }
        if (ofVarHw.iy() + ofVarHw.l() < System.currentTimeMillis()) {
            com.byazt.py.c.pr(i).pr(str);
            return true;
        }
        if (!TextUtils.equals(ofVarHw.jw(), ofVar.jw())) {
            if (com.byazt.sd.pr.pr(ofVar, pr() ? 7 : 8) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(ofVar.pq());
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.get(next);
                ofVarHw.v_().put(next, jSONObject.get(next));
            }
            ofVarHw.z(ofVarHw.v_().toString());
        } catch (Exception e) {
        }
        return false;
    }

    @Override // com.byazt.ci.pr
    public void pr(final com.byazt.qe.hw hwVar) {
        if (a.hw().hw(hwVar.x())) {
            i iVar = new i();
            iVar.pr = 2;
            if (a.hw().aj(hwVar.x()) || hwVar.zo() > 0.0f) {
                iVar.fw = 2;
            }
            a.pr().hw(hwVar, iVar, pr() ? 7 : 8, new fo.hw() { // from class: com.byazt.vh.c.6
                @Override // com.byazt.sd.fo.hw
                public void pr(int i, String str, com.byazt.hg.hw hwVar2) {
                    hwVar2.pr(i);
                    hwVar2.hw(str);
                    com.byazt.hg.hw.pr(hwVar2);
                }

                @Override // com.byazt.sd.fo.hw
                public void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar2) {
                    if (prVar.hw() == null || prVar.hw().isEmpty()) {
                        c.this.pr(hwVar.x(), -3, com.byazt.sd.fw.pr(-3), hwVar2);
                        return;
                    }
                    of ofVar = prVar.hw().get(0);
                    if (c.this.pr(hwVar.x(), ofVar)) {
                        return;
                    }
                    if (!ofVar.rq() || c.this.pr(prVar)) {
                        c.this.pr(hwVar.x(), -4, com.byazt.sd.fw.pr(-4), hwVar2);
                        return;
                    }
                    if (prVar.hw().size() > 1) {
                        if (com.byazt.hg.zo.pr(c.this.pr() ? 7 : 8).pr("mix_ad", new com.byazt.hg.zo.hw.pr().pr(hwVar).pr(ofVar).pr())) {
                            com.byazt.sd.pr.pr(prVar.hw());
                        }
                    }
                    if (c.this.pr != null) {
                        c.this.pr.hw().pr(hwVar, ofVar);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("src_req_id", ofVar.nb());
                        jSONObject.put("is_map", ofVar.gd());
                    } catch (Exception e) {
                    }
                    com.byazt.xk.hw.pr().pr(ofVar, "stats_reward_full_preload", jSONObject);
                }
            });
        }
    }
}
