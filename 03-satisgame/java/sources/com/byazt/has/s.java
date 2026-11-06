package com.byazt.has;

import android.text.TextUtils;
import android.view.View;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.tk.k;
import com.byazt.udb.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, 8})
public class s extends com.byazt.has.n {
    public int ae;
    public int an;
    public final AtomicBoolean df;
    public final AtomicBoolean dg;
    public int f;
    public final AtomicBoolean fi;
    public int j;
    public int lh;
    public final List<com.byazt.ly.qg> ln;
    public final AtomicBoolean oj;
    public com.byazt.ly.l pk;
    public com.byazt.ve.n sh;
    public final AtomicBoolean u;
    public int v;
    public com.byazt.zc.n wo;

    public interface n {
        void n();

        void n(int i);

        void n(long j, long j2);

        void q();

        void qg();

        Map<String, Object> s();
    }

    public static int qg(pk pkVar) {
        return 8;
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        return true;
    }

    @Override // com.byazt.has.n
    public boolean w() {
        return false;
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return false;
    }

    public s(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
        this.ln = new ArrayList();
        this.lh = 0;
        this.v = 0;
        this.j = 0;
        this.an = 0;
        this.ae = 0;
        this.f = 0;
        this.fi = new AtomicBoolean(false);
        this.df = new AtomicBoolean(false);
        this.oj = new AtomicBoolean(true);
        this.dg = new AtomicBoolean(false);
        this.u = new AtomicBoolean(true);
    }

    public static boolean n(pk pkVar) {
        return (pkVar == null || !pe.n(pkVar) || TextUtils.isEmpty(pkVar.hj())) ? false : true;
    }

    @Override // com.byazt.has.n
    public com.byazt.tkz.qg n(boolean z) {
        com.byazt.tkz.q qVar = new com.byazt.tkz.q(this.n, this.qg, z);
        float f = this.w;
        float[] fArrPy = {this.l, f};
        if (fArrPy[0] < 10.0f || f < 10.0f) {
            fArrPy = py();
        }
        qVar.n(fArrPy);
        this.rv = qVar;
        return this.rv;
    }

    @Override // com.byazt.has.n
    public View rv() {
        return com.byazt.cb.qg.tj(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.tkz.q i() {
        if (this.rv instanceof com.byazt.tkz.q) {
            return (com.byazt.tkz.q) this.rv;
        }
        return null;
    }

    @Override // com.byazt.has.n
    public void m() {
        if (this.a.an()) {
            return;
        }
        try {
            com.byazt.ly.l lVar = (com.byazt.ly.l) i().qg().s(this.ae);
            if (lVar != null) {
                lVar.ur();
            }
        } catch (Exception e) {
            k.n("cubic  resume exception:" + e.getMessage());
        }
    }

    @Override // com.byazt.has.n
    public void oa() {
        com.byazt.ve.n nVar = this.sh;
        if (nVar != null) {
            nVar.n();
        }
    }

    @Override // com.byazt.has.qg
    public boolean cx() {
        return this.qg.yj() == 2 || this.qg.yj() == 3 || this.qg.yj() == 7;
    }

    @Override // com.byazt.has.qg
    public void dn() {
        this.cd.n(true);
        this.cd.qg(this.qg.yv());
        this.cd.s(true);
        this.cd.l(true);
        if (!TextUtils.isEmpty(pe.cp(this.qg))) {
            this.cd.n(false);
            com.byazt.zc.n nVar = new com.byazt.zc.n(this.qg);
            this.wo = nVar;
            nVar.n(new AnonymousClass1());
            this.wo.n(new com.byazt.udb.fs() { // from class: com.byazt.has.s.2
                @Override // com.byazt.udb.fs
                public void qg(View view, int i, com.byazt.twc.s sVar, int i2) {
                }

                @Override // com.byazt.udb.fs
                public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
                    if (i == 3) {
                        s.this.y().rv();
                    } else if (i == 5) {
                        s.this.y().n(!s.this.oa);
                    } else {
                        if (i != 6) {
                            return;
                        }
                        s.this.y().w();
                    }
                }
            });
            this.wo.n(new com.byazt.tn.qg() { // from class: com.byazt.has.s.3
                @Override // com.byazt.tn.qg
                public void n() {
                    s.this.ri();
                }
            });
            this.wo.n(pe.cp(this.qg), pe.d(this.qg), this.l, 0, pe.oa(this.qg));
        }
        z();
    }

    /* JADX INFO: renamed from: com.byazt.has.s$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 236, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK})
    public class AnonymousClass1 implements com.byazt.udb.x {
        public boolean n = false;

        public AnonymousClass1() {
        }

        @Override // com.byazt.udb.x
        public void n(final View view, final sz szVar) {
            if (this.n) {
                return;
            }
            s.this.n.an().post(new Runnable() { // from class: com.byazt.has.s.1.1
                @Override // java.lang.Runnable
                public void run() {
                    s.this.n.an().getTopFrameContainer().removeAllViews();
                    s.this.n.an().getTopFrameContainer().addView(view);
                    s.this.cd.n(true);
                    sz szVar2 = szVar;
                    if (szVar2 instanceof com.byazt.gn.q) {
                        s.this.sh = ((com.byazt.gn.q) szVar2).um();
                        s.this.sh.n(new com.byazt.ve.n.InterfaceC0369n() { // from class: com.byazt.has.s.1.1.1
                            @Override // com.byazt.ve.n.InterfaceC0369n
                            public boolean n() {
                                return s.this.n.pe();
                            }
                        });
                        s.this.sh.n((int) (s.this.bb.n() / 1000), s.this.bb.l(), s.this.bb.qg(), s.this.w(false));
                        s.this.z();
                    }
                }
            });
        }

        @Override // com.byazt.udb.x
        public void n(int i, String str) {
            this.n = true;
            s.this.cd.n(true);
        }
    }

    @Override // com.byazt.has.n
    public void fs() {
        super.fs();
        this.ln.add(new com.byazt.ly.qg(this.n, this.qg, this.d, cx(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.qg.hj());
            for (int i = 0; i < jSONArray.length(); i++) {
                this.ln.add(new com.byazt.ly.qg(this.n, com.byazt.vgx.qg.n(jSONArray.getJSONObject(i)), this.d, cx(), false));
            }
        } catch (JSONException unused) {
        }
        Iterator<com.byazt.ly.qg> it = this.ln.iterator();
        while (it.hasNext()) {
            it.next().n(this.oa);
        }
        this.dg.set(pe.sz(this.qg));
    }

    @Override // com.byazt.has.n, com.byazt.has.qg
    public void s() {
        this.rv.s(true);
        if (i() != null) {
            i().s().n(this.ln);
            i().q().n(new com.byazt.ly.s.n() { // from class: com.byazt.has.s.4
                @Override // com.byazt.ly.s.n
                public void n() {
                    s.this.cy = true;
                    s.this.an = 0;
                    n((com.byazt.ly.l) s.this.i().qg().s(0));
                    s.this.g();
                    s.this.ry();
                    s.this.n.s(false, true);
                }

                @Override // com.byazt.ly.s.n
                public void n(boolean z, int i, boolean z2) {
                    int i2 = s.this.ae;
                    if (s.this.pk != null) {
                        s.this.n.ri().n(z, i2 + 1, s.this.pk.lh());
                    }
                    s.this.ae = i;
                    s sVar = s.this;
                    sVar.f = Math.max(sVar.f, i + 1);
                    s sVar2 = s.this;
                    sVar2.an = i % sVar2.ln.size();
                    n((com.byazt.ly.l) s.this.i().qg().s(i));
                    s.this.i().w();
                    s.this.df.set(true);
                    s.this.dg.set(pe.sz(s.this.qg) && s.this.an + 1 < s.this.ln.size());
                    s.this.z();
                    s.this.ry();
                    s.this.cd.n(((com.byazt.ly.qg) s.this.ln.get(s.this.an)).n());
                }

                @Override // com.byazt.ly.s.n
                public void n(boolean z, int i) {
                    com.byazt.ly.l lVar = (com.byazt.ly.l) s.this.i().qg().s(i);
                    if (lVar != null) {
                        lVar.qg(false);
                    }
                }

                private void n(com.byazt.ly.l lVar) {
                    if (lVar != null) {
                        s.this.pk = lVar;
                        s.this.pk.qg(true);
                        s.this.pk.n(new n() { // from class: com.byazt.has.s.4.1
                            @Override // com.byazt.has.s.n
                            public void n() {
                                s.this.cy = true;
                                s.this.i().n(false);
                            }

                            @Override // com.byazt.has.s.n
                            public void qg() {
                                s.this.cy = false;
                                s.this.i().n(true);
                            }

                            @Override // com.byazt.has.s.n
                            public void n(int i) {
                                s.this.lh += i;
                                s.this.v += i;
                                s.this.n.d(i);
                            }

                            @Override // com.byazt.has.s.n
                            public Map<String, Object> s() {
                                return s.this.n.fs();
                            }

                            @Override // com.byazt.has.s.n
                            public void q() {
                                if (s.this.an + 1 >= s.this.ln.size() || !s.this.oj.get()) {
                                    s.this.n.w(1);
                                } else if (s.this.fl()) {
                                    s.this.tj(false);
                                }
                            }

                            @Override // com.byazt.has.s.n
                            public void n(long j, long j2) {
                                s.this.cy = false;
                            }
                        });
                        s.this.cy = lVar.f();
                        s.this.i().n(!lVar.fi());
                    } else {
                        s.this.cy = false;
                    }
                    s.this.g();
                }
            });
        }
    }

    @Override // com.byazt.has.n
    public void h() {
        super.h();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible", false);
        } catch (JSONException unused) {
        }
        this.a.n(jSONObject);
        if (!nf()) {
            wm();
        }
        this.oj.set(false);
        this.cd.n((String) null, (String) null, false);
        com.byazt.ve.n nVar = this.sh;
        if (nVar != null) {
            nVar.n(0, true, 0, 0, false, false, false);
            this.sh.n((int) (this.bb.n() / 1000), this.bb.l(), this.bb.qg(), w(false));
        }
    }

    @Override // com.byazt.has.n
    public int fs(boolean z) {
        return pe.s(this.qg) - this.v;
    }

    @Override // com.byazt.has.n
    public int x(boolean z) {
        if (z) {
            return fs(z);
        }
        return pe.x(this.qg) - this.v;
    }

    @Override // com.byazt.has.n
    public int u() {
        return this.v;
    }

    @Override // com.byazt.has.qg
    public void z() {
        su();
        dw();
        ha();
    }

    private void dw() {
        com.byazt.ly.l lVar = this.pk;
        if (lVar == null || !lVar.f()) {
            int iQ = this.ln.get(this.an).q();
            if (iQ > 0) {
                this.lh += iQ;
            }
            if ((pe.s(this.qg) <= this.v) && !this.fi.get()) {
                this.n.q(0);
                this.n.oa();
                this.fi.set(true);
            }
            int i = this.v;
            if (i < this.lh) {
                this.v = i + 1;
            }
        }
    }

    private void su() {
        String str;
        boolean z;
        boolean z2 = Math.max(0, this.bb.s() - t()) == 0;
        int iQ = pe.q(this.qg);
        int iL = pe.l(this.qg);
        int iW = w(false);
        if (pe.fs(this.qg)) {
            String str2 = iW > 0 ? iW + com.anythink.core.common.s.a : "奖励已领取";
            z = false;
            str = str2;
        } else {
            if (iQ == 0) {
                str = iW > 0 ? iW + "s后可领取奖励" : "领取成功";
                z = true;
            } else {
                str = iW > 0 ? iW + com.anythink.core.common.s.a : "领取成功";
                z = false;
            }
        }
        qg(w(true));
        this.cd.n(z, str, (z2 && iL == 1) ? "跳过" : null, z2 && iL == 0, z2);
        com.byazt.ve.n nVar = this.sh;
        if (nVar != null) {
            nVar.n((int) (this.bb.n() / 1000), this.bb.l(), this.bb.qg(), w(false));
        }
    }

    private void ha() {
        String str;
        if (pe.fs(this.qg)) {
            int iMin = this.an + 1;
            int size = this.ln.size();
            boolean z = this.an + 1 >= this.ln.size();
            boolean z2 = this.an == 0;
            int iVb = vb();
            boolean z3 = this.bb.l() - this.j < pe.k(this.qg);
            if (this.oj.get()) {
                if (!z3) {
                    iMin = Math.min(iMin + 1, size);
                }
                int i = iMin;
                String str2 = i + "/" + size;
                if (z3) {
                    str = (z2 ? "可看" + size + "个视频,当前 " : "正在播放 ") + str2;
                } else {
                    str = (!z ? iVb + "秒后播放 " : "") + str2;
                }
                this.cd.n(str, this.dg.get() ? "取消" : null, this.dg.get());
                com.byazt.ve.n nVar = this.sh;
                if (nVar != null) {
                    nVar.n(iVb, z, i, size, true, z3, this.dg.get());
                }
            } else {
                this.cd.n((String) null, (String) null, false);
                com.byazt.ve.n nVar2 = this.sh;
                if (nVar2 != null) {
                    nVar2.n(0, z, 0, 0, false, false, false);
                }
                if (iVb == 0 && !fl()) {
                    tj(false);
                }
            }
            if (iVb == 0) {
                tj(false);
            }
        }
        if (this.bb.l() <= pe.rv(this.qg) || this.df.get() || i() == null) {
            return;
        }
        i().l();
    }

    @Override // com.byazt.has.n
    public void l(boolean z) {
        super.l(z);
        com.byazt.ly.l lVar = this.pk;
        if (lVar != null) {
            lVar.s(z);
        }
        Iterator<com.byazt.ly.qg> it = this.ln.iterator();
        while (it.hasNext()) {
            it.next().n(z);
        }
    }

    @Override // com.byazt.has.n
    public com.byazt.aqe.qg.n n(pk pkVar, final com.byazt.aqe.tj tjVar) {
        this.n.dg();
        com.byazt.aqe.n sVar = pe.fs(pkVar) ? new com.byazt.aqe.s(this.n, pkVar, false) : new com.byazt.aqe.l(this.n, pkVar);
        sVar.n(dg());
        return sVar.qg(new com.byazt.aqe.tj() { // from class: com.byazt.has.s.5
            @Override // com.byazt.aqe.tj
            public void n() {
                super.n();
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n();
                }
                s.this.n.u();
            }

            @Override // com.byazt.aqe.tj
            public void qg() {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.qg();
                }
            }

            @Override // com.byazt.aqe.tj
            public void s() {
                super.s();
                s.this.n.u();
                s.this.tj(true);
                s.this.n.ri().n("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.byazt.has.n
    public void hd() {
        super.hd();
        List<com.byazt.ly.qg> list = this.ln;
        if (list != null) {
            Iterator<com.byazt.ly.qg> it = list.iterator();
            while (it.hasNext()) {
                it.next().fs();
            }
        }
        if (i() != null) {
            i().s().q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.byazt.zsl.l lVarTj;
        com.byazt.ly.l lVar = this.pk;
        pk pkVarN = null;
        com.byazt.iag.s sVarAe = lVar != null ? lVar.ae() : null;
        com.byazt.ly.qg qgVar = this.ln.get(this.an);
        if (qgVar != null) {
            pkVarN = qgVar.n();
            lVarTj = qgVar.tj();
        } else {
            lVarTj = null;
        }
        this.um.n(pkVarN, sVarAe, lVarTj);
        this.um.qg(this.n.fs());
    }

    @Override // com.byazt.has.n
    public int v() {
        return qg(this.qg);
    }

    @Override // com.byazt.has.n
    public void n(Map<String, Object> map) {
        super.n(map);
        map.put("group_pos", Integer.valueOf(this.ae + 1));
        com.byazt.ly.l lVar = this.pk;
        if (lVar != null) {
            map.put(MediationConstant.EXTRA_DURATION, Long.valueOf(lVar.lh()));
        }
    }

    @Override // com.byazt.has.n
    public void n(JSONObject jSONObject) {
        super.n(jSONObject);
        try {
            jSONObject.put("group_pos", this.an + 1);
            jSONObject.put(MediationConstant.EXTRA_DURATION, this.pk.lh());
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.has.n
    public void n(View view) {
        super.n(view);
        this.pk.n(view);
    }

    @Override // com.byazt.has.n
    public void wm() {
        try {
            com.byazt.ly.l lVar = (com.byazt.ly.l) i().qg().s(this.ae);
            if (lVar != null) {
                lVar.t();
            }
        } catch (Exception e) {
            k.n("cubic pause exception:" + e.getMessage());
        }
    }

    @Override // com.byazt.has.n
    public void ri() {
        this.oj.set(false);
        this.u.set(false);
        z();
    }

    public int vb() {
        pk pkVarN = this.ln.get(this.an).n();
        return Math.max(0, ((((int) Math.min(Math.round(ta.x(pkVarN)), pe.qg(pkVarN))) + (fl() ? 1 : 0)) + this.j) - this.bb.l());
    }

    public boolean fl() {
        pk pkVarN = this.ln.get(this.an).n();
        return Math.round(ta.x(pkVarN)) <= ((long) pe.qg(pkVarN));
    }

    public void tj(boolean z) {
        if (!this.a.an() && this.an + 1 < this.ln.size()) {
            this.j = this.bb.l();
            if (!(z || this.u.get() || pe.w(this.qg)) || i() == null) {
                return;
            }
            i().qg().qg(this.ae + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry() {
        if (this.an < this.ln.size() - 1) {
            this.ln.get(this.an + 1).d();
            this.ln.get(this.an + 1).n(this.l, this.w);
        }
    }

    @Override // com.byazt.has.qg
    public boolean el() {
        if (pe.cy(this.qg)) {
            return this.cy;
        }
        return false;
    }

    @Override // com.byazt.has.n, com.byazt.has.qg
    public boolean nf() {
        return pe.fs(this.qg);
    }
}
