package com.byazt.lu;

import android.text.TextUtils;
import android.view.View;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.mq.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 20})
public class hn extends com.byazt.lu.pr {
    public int e;
    public final AtomicBoolean er;
    public com.byazt.ro.pr i;
    public com.byazt.dr.c ii;
    public int ls;
    public int n;
    public final List<com.byazt.dr.hw> nl;
    public final AtomicBoolean of;
    public final AtomicBoolean qi;
    public final AtomicBoolean qn;
    public com.byazt.bk.pr r;
    public int s;
    public final AtomicBoolean v;
    public int ww;
    public int y;

    public interface pr {
        Map<String, Object> hn();

        void hw();

        void pr();

        void pr(int i);

        void pr(long j, long j2);

        void x();
    }

    public hn(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
        this.nl = new ArrayList();
        this.y = 0;
        this.ww = 0;
        this.n = 0;
        this.e = 0;
        this.s = 0;
        this.ls = 0;
        this.er = new AtomicBoolean(false);
        this.v = new AtomicBoolean(false);
        this.qi = new AtomicBoolean(true);
        this.qn = new AtomicBoolean(false);
        this.of = new AtomicBoolean(true);
    }

    public static boolean pr(of ofVar) {
        return (ofVar == null || !o.pr(ofVar) || TextUtils.isEmpty(ofVar.kq())) ? false : true;
    }

    @Override // com.byazt.lu.pr
    public com.byazt.xt.hw pr(boolean z) {
        com.byazt.xt.x xVar = new com.byazt.xt.x(this.pr, this.hw, z);
        float f = this.uc;
        float[] fArrA = {this.c, f};
        if (fArrA[0] < 10.0f || f < 10.0f) {
            fArrA = a();
        }
        xVar.pr(fArrA);
        this.aj = xVar;
        return this.aj;
    }

    @Override // com.byazt.lu.pr
    public View aj() {
        return com.byazt.sdv.c.vk(this.pr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.xt.x cr() {
        if (this.aj instanceof com.byazt.xt.x) {
            return (com.byazt.xt.x) this.aj;
        }
        return null;
    }

    @Override // com.byazt.lu.pr
    public void fo() {
        if (this.a.e()) {
            return;
        }
        try {
            com.byazt.dr.c cVar = (com.byazt.dr.c) cr().hw().hn(this.s);
            if (cVar != null) {
                cVar.ve();
            }
        } catch (Exception e) {
            ho.pr("cubic  resume exception:" + e.getMessage());
        }
    }

    @Override // com.byazt.lu.hw
    public boolean l() {
        return false;
    }

    @Override // com.byazt.lu.pr
    public boolean uc() {
        return false;
    }

    @Override // com.byazt.lu.hw
    public boolean lv() {
        return this.hw.sq() == 2 || this.hw.sq() == 3 || this.hw.sq() == 7;
    }

    @Override // com.byazt.lu.hw
    public boolean od() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public void pq() {
        this.lb.pr(true);
        this.lb.hw(this.hw.zz());
        this.lb.hn(true);
        this.lb.c(true);
        if (!TextUtils.isEmpty(o.w(this.hw))) {
            this.lb.pr(false);
            com.byazt.ro.pr prVar = new com.byazt.ro.pr(this.hw);
            this.i = prVar;
            prVar.pr(new com.byazt.mq.fw() { // from class: com.byazt.lu.hn.1
                public boolean pr = false;

                @Override // com.byazt.mq.fw
                public void pr(final View view, final g gVar) {
                    if (this.pr) {
                        return;
                    }
                    hn.this.pr.e().post(new Runnable() { // from class: com.byazt.lu.hn.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hn.this.pr.e().getTopFrameContainer().removeAllViews();
                            hn.this.pr.e().getTopFrameContainer().addView(view);
                            hn.this.lb.pr(true);
                            g gVar2 = gVar;
                            if (gVar2 instanceof com.byazt.gu.hn) {
                                hn.this.r = ((com.byazt.gu.hn) gVar2).lb();
                                hn.this.r.pr((int) (hn.this.gz.pr() / 1000), hn.this.gz.c(), hn.this.gz.hw(), hn.this.uc(false));
                                hn.this.d();
                            }
                        }
                    });
                }

                @Override // com.byazt.mq.fw
                public void pr(int i, String str) {
                    this.pr = true;
                    hn.this.lb.pr(true);
                }
            });
            this.i.pr(new com.byazt.mq.zo() { // from class: com.byazt.lu.hn.2
                @Override // com.byazt.mq.zo
                public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
                    switch (i) {
                        case 3:
                            hn.this.r().aj();
                            break;
                        case 5:
                            hn.this.r().pr(!hn.this.m);
                            break;
                        case 6:
                            hn.this.r().uc();
                            break;
                    }
                }

                @Override // com.byazt.mq.zo
                public void hw(View view, int i, com.byazt.dj.hn hnVar, int i2) {
                }
            });
            this.i.pr(new com.byazt.so.hw() { // from class: com.byazt.lu.hn.3
                @Override // com.byazt.so.hw
                public void pr() {
                    hn.this.o();
                }
            });
            this.i.pr(o.w(this.hw), o.k(this.hw), this.c, 0, o.m(this.hw));
        }
        d();
    }

    @Override // com.byazt.lu.pr
    public void zo() {
        super.zo();
        this.nl.add(new com.byazt.dr.hw(this.pr, this.hw, this.k, lv(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.hw.kq());
            for (int i = 0; i < jSONArray.length(); i++) {
                this.nl.add(new com.byazt.dr.hw(this.pr, com.byazt.sd.pr.pr(jSONArray.getJSONObject(i)), this.k, lv(), false));
            }
        } catch (JSONException e) {
        }
        Iterator<com.byazt.dr.hw> it = this.nl.iterator();
        while (it.hasNext()) {
            it.next().pr(this.m);
        }
        this.qn.set(o.g(this.hw));
    }

    @Override // com.byazt.lu.pr, com.byazt.lu.hw
    public void hn() {
        this.aj.hn(true);
        if (cr() != null) {
            cr().hn().pr(this.nl);
            cr().x().pr(new com.byazt.dr.hn.pr() { // from class: com.byazt.lu.hn.4
                @Override // com.byazt.dr.hn.pr
                public void pr() {
                    hn.this.nt = true;
                    hn.this.e = 0;
                    pr((com.byazt.dr.c) hn.this.cr().hw().hn(0));
                    hn.this.pj();
                    hn.this.ey();
                    hn.this.pr.hw(false, true);
                }

                @Override // com.byazt.dr.hn.pr
                public void pr(boolean z, int i, boolean z2) {
                    int i2 = hn.this.s;
                    if (hn.this.ii != null) {
                        hn.this.pr.f().pr(z, i2 + 1, hn.this.ii.y());
                    }
                    hn.this.s = i;
                    hn hnVar = hn.this;
                    hnVar.ls = Math.max(hnVar.ls, i + 1);
                    hn hnVar2 = hn.this;
                    hnVar2.e = i % hnVar2.nl.size();
                    pr((com.byazt.dr.c) hn.this.cr().hw().hn(i));
                    hn.this.cr().uc();
                    hn.this.v.set(true);
                    hn.this.qn.set(o.g(hn.this.hw) && hn.this.e + 1 < hn.this.nl.size());
                    hn.this.d();
                    hn.this.ey();
                    hn.this.lb.pr(((com.byazt.dr.hw) hn.this.nl.get(hn.this.e)).pr());
                }

                @Override // com.byazt.dr.hn.pr
                public void pr(boolean z, int i) {
                    com.byazt.dr.c cVar = (com.byazt.dr.c) hn.this.cr().hw().hn(i);
                    if (cVar != null) {
                        cVar.hw(false);
                    }
                }

                private void pr(com.byazt.dr.c cVar) {
                    if (cVar != null) {
                        hn.this.ii = cVar;
                        hn.this.ii.hw(true);
                        hn.this.ii.pr(new pr() { // from class: com.byazt.lu.hn.4.1
                            @Override // com.byazt.lu.hn.pr
                            public void pr() {
                                hn.this.nt = true;
                                hn.this.cr().pr(false);
                            }

                            @Override // com.byazt.lu.hn.pr
                            public void hw() {
                                hn.this.nt = false;
                                hn.this.cr().pr(true);
                            }

                            @Override // com.byazt.lu.hn.pr
                            public void pr(int i) {
                                hn.this.y += i;
                                hn.this.ww += i;
                                hn.this.pr.k(i);
                            }

                            @Override // com.byazt.lu.hn.pr
                            public Map<String, Object> hn() {
                                return hn.this.pr.zo();
                            }

                            @Override // com.byazt.lu.hn.pr
                            public void x() {
                                if (hn.this.e + 1 >= hn.this.nl.size() || !hn.this.qi.get()) {
                                    hn.this.pr.uc(1);
                                } else if (hn.this.iy()) {
                                    hn.this.aj(false);
                                }
                            }

                            @Override // com.byazt.lu.hn.pr
                            public void pr(long j, long j2) {
                                hn.this.nt = false;
                            }
                        });
                        hn.this.nt = cVar.ls();
                        hn.this.cr().pr(!cVar.er());
                    } else {
                        hn.this.nt = false;
                    }
                    hn.this.pj();
                }
            });
        }
    }

    @Override // com.byazt.lu.pr
    public void z() {
        super.z();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible", false);
        } catch (JSONException e) {
        }
        this.a.pr(jSONObject);
        if (!f()) {
            ny();
        }
        this.qi.set(false);
        this.lb.pr((String) null, (String) null, false);
        com.byazt.bk.pr prVar = this.r;
        if (prVar != null) {
            prVar.pr(0, true, 0, 0, false, false, false);
            this.r.pr((int) (this.gz.pr() / 1000), this.gz.c(), this.gz.hw(), uc(false));
        }
    }

    @Override // com.byazt.lu.pr
    public int v() {
        return o.hn(this.hw) - this.ww;
    }

    @Override // com.byazt.lu.pr
    public int fw(boolean z) {
        if (z) {
            return v();
        }
        return o.fw(this.hw) - this.ww;
    }

    @Override // com.byazt.lu.pr
    public int qn() {
        return this.ww;
    }

    @Override // com.byazt.lu.hw
    public void d() {
        qo();
        j();
        bh();
    }

    private void j() {
        com.byazt.dr.c cVar = this.ii;
        if (cVar != null && cVar.ls()) {
            return;
        }
        int iX = this.nl.get(this.e).x();
        if (iX > 0) {
            this.y += iX;
        }
        if ((o.hn(this.hw) <= this.ww) && !this.er.get()) {
            this.pr.x(0);
            this.pr.m();
            this.er.set(true);
        }
        int i = this.ww;
        if (i < this.y) {
            this.ww = i + 1;
        }
    }

    private void qo() {
        String str;
        boolean z;
        boolean z2 = Math.max(0, this.gz.hn() - b()) == 0;
        int iX = o.x(this.hw);
        int iC = o.c(this.hw);
        int iUc = uc(false);
        if (o.zo(this.hw)) {
            String str2 = iUc > 0 ? iUc + an.aB : "奖励已领取";
            z = false;
            str = str2;
        } else {
            if (iX == 0) {
                str = iUc > 0 ? iUc + "s后可领取奖励" : "领取成功";
                z = true;
            } else {
                str = iUc > 0 ? iUc + an.aB : "领取成功";
                z = false;
            }
        }
        hw(uc(true));
        this.lb.pr(z, str, (z2 && iC == 1) ? "跳过" : null, z2 && iC == 0, z2);
        com.byazt.bk.pr prVar = this.r;
        if (prVar != null) {
            prVar.pr((int) (this.gz.pr() / 1000), this.gz.c(), this.gz.hw(), uc(false));
        }
    }

    private void bh() {
        String str;
        if (o.zo(this.hw)) {
            int iMin = this.e + 1;
            int size = this.nl.size();
            boolean z = this.e + 1 >= this.nl.size();
            boolean z2 = this.e == 0;
            int iAa = aa();
            boolean z3 = this.gz.c() - this.n < o.ho(this.hw);
            if (this.qi.get()) {
                if (!z3) {
                    iMin = Math.min(iMin + 1, size);
                }
                int i = iMin;
                String str2 = i + "/" + size;
                if (z3) {
                    str = (z2 ? "可看" + size + "个视频,当前 " : "正在播放 ") + str2;
                } else {
                    str = (!z ? iAa + "秒后播放 " : "") + str2;
                }
                this.lb.pr(str, this.qn.get() ? "取消" : null, this.qn.get());
                com.byazt.bk.pr prVar = this.r;
                if (prVar != null) {
                    prVar.pr(iAa, z, i, size, true, z3, this.qn.get());
                }
            } else {
                this.lb.pr((String) null, (String) null, false);
                com.byazt.bk.pr prVar2 = this.r;
                if (prVar2 != null) {
                    prVar2.pr(0, z, 0, 0, false, false, false);
                }
            }
            if (iAa == 0 && !iy()) {
                aj(false);
            }
        }
        if (this.gz.c() > o.aj(this.hw) && !this.v.get() && cr() != null) {
            cr().c();
        }
    }

    @Override // com.byazt.lu.pr
    public void c(boolean z) {
        super.c(z);
        com.byazt.dr.c cVar = this.ii;
        if (cVar != null) {
            cVar.hn(z);
        }
        Iterator<com.byazt.dr.hw> it = this.nl.iterator();
        while (it.hasNext()) {
            it.next().pr(z);
        }
    }

    @Override // com.byazt.lu.pr
    public com.byazt.wv.hw.pr pr(of ofVar, final com.byazt.wv.vk vkVar) {
        this.pr.qn();
        com.byazt.wv.pr hnVar = o.zo(ofVar) ? new com.byazt.wv.hn(this.pr, ofVar, false) : new com.byazt.wv.c(this.pr, ofVar);
        hnVar.pr(qi());
        return hnVar.hw(new com.byazt.wv.vk() { // from class: com.byazt.lu.hn.5
            @Override // com.byazt.wv.vk
            public void pr() {
                super.pr();
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.pr();
                }
                hn.this.pr.of();
            }

            @Override // com.byazt.wv.vk
            public void hw() {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.hw();
                }
            }

            @Override // com.byazt.wv.vk
            public void hn() {
                super.hn();
                hn.this.pr.of();
                hn.this.aj(true);
                hn.this.pr.f().pr("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.byazt.lu.pr
    public void nt() {
        super.nt();
        List<com.byazt.dr.hw> list = this.nl;
        if (list != null) {
            Iterator<com.byazt.dr.hw> it = list.iterator();
            while (it.hasNext()) {
                it.next().zo();
            }
        }
        if (cr() != null) {
            cr().hn().x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pj() {
        com.byazt.w.hn hnVarS;
        com.byazt.n.uc ucVarVk;
        com.byazt.dr.c cVar = this.ii;
        of ofVarPr = null;
        if (cVar == null) {
            hnVarS = null;
        } else {
            hnVarS = cVar.s();
        }
        com.byazt.dr.hw hwVar = this.nl.get(this.e);
        if (hwVar == null) {
            ucVarVk = null;
        } else {
            ofVarPr = hwVar.pr();
            ucVarVk = hwVar.vk();
        }
        this.qa.pr(ofVarPr, hnVarS, ucVarVk);
        this.qa.hw(this.pr.zo());
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return hw(this.hw);
    }

    public static int hw(of ofVar) {
        return 8;
    }

    @Override // com.byazt.lu.pr
    public void pr(Map<String, Object> map) {
        super.pr(map);
        map.put("group_pos", Integer.valueOf(this.s + 1));
        com.byazt.dr.c cVar = this.ii;
        if (cVar != null) {
            map.put("duration", Long.valueOf(cVar.y()));
        }
    }

    @Override // com.byazt.lu.pr
    public void pr(JSONObject jSONObject) {
        super.pr(jSONObject);
        try {
            jSONObject.put("group_pos", this.e + 1);
            jSONObject.put("duration", this.ii.y());
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.lu.pr
    public void pr(View view) {
        super.pr(view);
        this.ii.pr(view);
    }

    @Override // com.byazt.lu.pr
    public void ny() {
        try {
            com.byazt.dr.c cVar = (com.byazt.dr.c) cr().hw().hn(this.s);
            if (cVar != null) {
                cVar.iu();
            }
        } catch (Exception e) {
            ho.pr("cubic pause exception:" + e.getMessage());
        }
    }

    @Override // com.byazt.lu.pr
    public void o() {
        this.qi.set(false);
        this.of.set(false);
        d();
    }

    public int aa() {
        of ofVarPr = this.nl.get(this.e).pr();
        return Math.max(0, ((((int) Math.min(Math.round(qv.fw(ofVarPr)), o.hw(ofVarPr))) + (iy() ? 1 : 0)) + this.n) - this.gz.c());
    }

    public boolean iy() {
        of ofVarPr = this.nl.get(this.e).pr();
        return Math.round(qv.fw(ofVarPr)) <= ((long) o.hw(ofVarPr));
    }

    public void aj(boolean z) {
        if (this.a.e() || this.e + 1 >= this.nl.size()) {
            return;
        }
        this.n = this.gz.c();
        boolean z2 = false;
        if (z || this.of.get() || o.uc(this.hw)) {
            z2 = true;
        }
        if (z2 && cr() != null) {
            cr().hw().hw(this.s + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey() {
        if (this.e < this.nl.size() - 1) {
            this.nl.get(this.e + 1).k();
            this.nl.get(this.e + 1).pr(this.c, this.uc);
        }
    }

    @Override // com.byazt.lu.hw
    public boolean wt() {
        if (o.nt(this.hw)) {
            return this.nt;
        }
        return false;
    }

    @Override // com.byazt.lu.pr, com.byazt.lu.hw
    public boolean f() {
        return o.zo(this.hw);
    }
}
