package com.byazt.np;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public abstract class tj extends qg {
    public boolean cd;
    public boolean hd;

    public interface n {
        void n();
    }

    public boolean py() {
        return false;
    }

    public tj(Context context) {
        super(context);
        this.hd = false;
        this.cd = false;
    }

    public boolean hu() {
        return this.hd;
    }

    public void n(boolean z) {
        this.hd = z;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001f A[PHI: r2
      0x001f: PHI (r2v5 boolean) = (r2v2 boolean), (r2v0 boolean) binds: [B:31:0x0070, B:7:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    public void n(com.byazt.zb.qg qgVar) {
        boolean z;
        boolean z2 = true;
        if (this.q.ct() == 10 || this.q.ct() == 8 || this.q.ct() == 7) {
            z2 = (this.w == null || !(this.w.um() == 10 || this.w.um() == 8) || this.x == null || this.x.cy() == 0) ? (this.q.rm() && this.q.jw() && com.byazt.qa.q.n().s(this.l, this.w.l())) ? false : true : true;
            if (this.q.he() == 4) {
                z = false;
            } else {
                z = z2;
            }
        } else {
            z = z2;
        }
        if (this.q.vo() && com.byazt.ra.n.n().q(this.l, this.q.el(), this.w.l())) {
            com.byazt.ra.n.n().n(this.q.el(), this.w, qgVar != null ? qgVar.v() : null, z, qgVar != null ? qgVar.j() : null, (com.byazt.ws.rv) null, this.fs.get());
        }
    }

    public void h() {
        if (this.w.nf() || this.q == null || this.q.he() == 4) {
            return;
        }
        com.byazt.qa.q.n().n(this.fs.get(), this.l, this.w.l());
    }

    public void s(final com.byazt.sg.s sVar) {
        if (this.w.nf()) {
            return;
        }
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.tj.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.sg.s sVar2 = sVar;
                if (sVar2 == null || !sVar2.rm() || !sVar.jw() || (tj.this.q instanceof com.byazt.cn.qg)) {
                    return;
                }
                com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.qg(tj.this.l, sVar.el()) + "在show时触发了预加载【" + sVar.lq() + "】, loadSort: " + sVar.la() + ", showSort: " + sVar.il());
                tj.this.cd = true;
                com.byazt.qa.q.n().qg(tj.this.fs.get(), tj.this.l, tj.this.w.l());
            }
        });
    }

    @Override // com.byazt.np.qg
    public void s() {
        super.s();
    }

    public void n(Activity activity, Object obj, String str, n nVar) {
        List<com.byazt.ws.tj> listQg = null;
        if (!py()) {
            com.byazt.gp.s.n(this.w);
            if (this.d) {
                com.byazt.gp.s.n((List<com.byazt.sg.s>) null, this.w, 0);
                if (nVar != null) {
                    nVar.n();
                    return;
                }
                return;
            }
        }
        int iQg = qg(this.l);
        if (iQg != 0) {
            com.byazt.gp.s.n((List<com.byazt.sg.s>) null, this.w, iQg);
            if (nVar != null) {
                nVar.n();
                return;
            }
            return;
        }
        boolean zOa = oa();
        List<com.byazt.sg.s> listN = this.s.n(true);
        this.s.n(listN);
        try {
            listQg = qg();
        } catch (Throwable unused) {
        }
        List<com.byazt.ws.tj> list = listQg;
        if (list == null || list.size() <= 0 || !n(list, listN, zOa, activity, obj, str)) {
            if (listN != null && listN.size() > 0) {
                for (com.byazt.sg.s sVar : listN) {
                    if (sVar != null && (!zOa || sVar.jw())) {
                        if (qg(sVar, activity, obj, str)) {
                            return;
                        }
                    }
                }
                if (zOa && this.q == null) {
                    for (com.byazt.sg.s sVar2 : listN) {
                        if (sVar2 != null && qg(sVar2, activity, obj, str)) {
                            return;
                        }
                    }
                }
            }
            com.byazt.gp.s.n(listN, this.w, 0);
            if (nVar != null) {
                nVar.n();
            }
        }
    }

    private boolean q(com.byazt.sg.s sVar) {
        return !sVar.rg() || sVar.m() == 1;
    }

    private boolean qg(com.byazt.sg.s sVar, Activity activity, Object obj, String str) {
        if (!sVar.ae(this.l) || sVar.nf()) {
            return false;
        }
        if (py()) {
            if (q(sVar) && !com.byazt.fh.n.n(sVar.lq(), sVar.ct(), sVar.dg())) {
                com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.qg(this.l, sVar.el()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.sg.n.n(sVar.he()) + ",isReady()：" + sVar.ae(this.l));
                n(sVar, activity, obj, str);
                return true;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "--==--- 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.qg(this.l, sVar.el()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.sg.n.n(sVar.he()) + ",isReady()：" + sVar.ae(this.l));
        n(sVar, activity, obj, str);
        return true;
    }

    private boolean s(com.byazt.sg.s sVar, Activity activity, Object obj, String str) {
        if (!sVar.ae(this.l) || sVar.nf()) {
            return false;
        }
        if (py()) {
            if (q(sVar) && !com.byazt.fh.n.n(sVar.lq(), sVar.ct(), sVar.dg())) {
                com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.qg(this.l, sVar.el()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.sg.n.n(sVar.he()) + ",isReady()：" + sVar.ae(this.l));
                qg(sVar);
                n(sVar, activity, obj, str);
                return true;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "--==--- cache 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.qg(this.l, sVar.el()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.sg.n.n(sVar.he()) + ",isReady()：" + sVar.ae(this.l));
        qg(sVar);
        n(sVar, activity, obj, str);
        return true;
    }

    public void n(com.byazt.sg.s sVar, final Activity activity, final Object obj, final String str) {
        this.q = sVar;
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.np.tj.2
            @Override // java.lang.Runnable
            public void run() {
                if (tj.this.q != null) {
                    if (tj.this.oa != null) {
                        tj.this.q.n(tj.this.oa);
                    }
                    if (tj.this.sz != null) {
                        tj.this.q.n(tj.this.sz);
                    }
                    tj.this.s.q(tj.this.q);
                    tj.this.q.l(true);
                    tj.this.q.n(tj.this.rv);
                    if (tj.this.q.vo() && com.byazt.ra.n.n().q(tj.this.l, tj.this.q.el(), tj.this.cd())) {
                        com.byazt.yc.w.n(tj.this.q, tj.this.l, tj.this.q.el());
                    }
                    List<com.byazt.sg.s> listN = tj.this.s.n(true);
                    com.byazt.ra.n.n().n(listN, tj.this.l, tj.this.w, tj.this.w.l(), tj.this.q);
                    com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(tj.this.l, "show") + "展示的广告类型：" + com.byazt.sg.n.n(tj.this.q.he()) + ",slotId：" + tj.this.q.el() + ",slotType:" + tj.this.q.bz() + ",isReady()：" + tj.this.q.ae(tj.this.l) + "，是否为缓存广告:" + tj.this.q.jw());
                    tj.this.q.n(activity, obj, str);
                    com.byazt.bf.oa.n().qg(tj.this.l);
                    com.byazt.bf.d.n().qg(tj.this.l, tj.this.q.el());
                    tj.this.d = true;
                    if (tj.this.q != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(tj.this.q);
                        if (tj.this.w.um() == 7 || tj.this.w.um() == 10) {
                            com.byazt.em.n.n().n(tj.this.w, com.byazt.em.n.n(tj.this.w, arrayList, listN));
                        }
                        tj.this.n(arrayList);
                    }
                    com.byazt.gp.s.n(tj.this.q, tj.this.w, false, tj.this.py() ? 1 : 0);
                }
            }
        });
    }

    private boolean n(List<com.byazt.ws.tj> list, List<com.byazt.sg.s> list2, boolean z, Activity activity, Object obj, String str) {
        List<com.byazt.qa.x> listN;
        com.byazt.sg.s sVar;
        List<com.byazt.qa.x> listN2;
        com.byazt.sg.s sVar2;
        HashMap<String, com.byazt.sg.s> mapQg = qg(list2);
        for (com.byazt.ws.tj tjVar : list) {
            if (tjVar != null) {
                String strCd = tjVar.cd();
                com.byazt.sg.s sVar3 = mapQg.get(strCd);
                if (sVar3 != null) {
                    if (z) {
                        if (sVar3.jw() && qg(sVar3, activity, obj, str)) {
                            return true;
                        }
                    } else if (qg(sVar3, activity, obj, str)) {
                        return true;
                    }
                }
                if (tjVar.a() && com.byazt.ra.n.n().q(this.l, strCd, this.w.l()) && com.byazt.ra.n.n().n(strCd, this.w, false) == 3 && (listN2 = com.byazt.ra.n.n().n(strCd, this.w, this.w.l())) != null && listN2.size() > 0 && (sVar2 = listN2.get(0).n) != null) {
                    if (z) {
                        if (sVar2.jw() && s(sVar2, activity, obj, str)) {
                            return true;
                        }
                    } else if (s(sVar2, activity, obj, str)) {
                        return true;
                    }
                }
            }
        }
        if (z && this.q == null) {
            for (com.byazt.ws.tj tjVar2 : list) {
                if (tjVar2 != null) {
                    String strCd2 = tjVar2.cd();
                    com.byazt.sg.s sVar4 = mapQg.get(strCd2);
                    if (sVar4 != null && qg(sVar4, activity, obj, str)) {
                        return true;
                    }
                    if (tjVar2.a() && com.byazt.ra.n.n().q(this.l, strCd2, this.w.l()) && com.byazt.ra.n.n().n(strCd2, this.w, false) == 3 && (listN = com.byazt.ra.n.n().n(strCd2, this.w, this.w.l())) != null && listN.size() > 0 && (sVar = listN.get(0).n) != null && s(sVar, activity, obj, str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean t() {
        List<com.byazt.ws.tj> listQg;
        try {
            listQg = qg();
        } catch (Throwable unused) {
            listQg = null;
        }
        return com.byazt.vy.x.n(this.s.cp(), this.s.sz(), this.s.d(), this.w, this.d, this.l, this.w.l(), listQg);
    }
}
