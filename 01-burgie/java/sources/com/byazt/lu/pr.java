package com.byazt.lu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.ie;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.ny;
import com.byazt.wt.ve;
import com.byazt.xz.AbstractEndCardFrameLayout;
import com.byazt.xz.CommonEndCardFrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.analytics.pro.an;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 37})
public abstract class pr extends hw {
    public com.byazt.ax.hw a;
    public com.byazt.xt.hw aj;
    public int c;
    public com.byazt.ax.x cz;
    public com.byazt.qx.c fo;
    public boolean g;
    public com.byazt.hf.hn gz;
    public int hn;
    public boolean ho;
    public of hw;
    public String k;
    public com.byazt.ax.c lb;
    public boolean m;
    public boolean nt;
    public com.byazt.qx.uc ny;
    public final TTBaseVideoActivity pr;
    public com.byazt.ax.uc qa;
    public com.byazt.ax.pr rc;
    public int uc;
    public com.byazt.xt.c vk;
    public AbstractEndCardFrameLayout w;
    public float x;
    public boolean yb;
    public com.byazt.az.c zo;
    public int fw = -1;
    public int z = -5;
    public boolean b = false;
    public boolean iu = false;
    public int ve = Integer.MIN_VALUE;
    public final com.byazt.qx.w nl = new com.byazt.qx.w() { // from class: com.byazt.lu.pr.1
        @Override // com.byazt.qx.w
        public void pr(boolean z) {
            if (pr.this.m != z) {
                pr.this.m = z;
                pr.this.lb.hw();
            }
        }

        @Override // com.byazt.qx.w
        public void uc() {
            com.byazt.xk.hw.pr().x(pr.this.hw, "stats_reward_full_click_express_close");
            pr.this.lb.pr();
        }

        @Override // com.byazt.qx.w
        public void fw() {
            com.byazt.xk.hw.pr().x(pr.this.hw, "stats_reward_full_click_express_close");
            pr.this.pr.finish();
        }

        @Override // com.byazt.qx.w
        public void pr(int i) {
            switch (i) {
                case 1:
                case 5:
                    if (!pr.this.qa.hw() && !pr.this.qa.hn() && !pr.this.qa.ls()) {
                        pr.this.pr.hw(0L, false);
                        break;
                    }
                    break;
                case 2:
                    pr.this.qa.z();
                    break;
                case 3:
                    pr.this.qa.b();
                    break;
                case 4:
                    pr.this.qa.fw();
                    break;
            }
        }

        @Override // com.byazt.qx.w
        public long pr() {
            if (pr.this.zo(true)) {
                hashCode();
                return ((long) pr.this.b()) * 1000;
            }
            pr prVar = pr.this;
            prVar.hw(prVar.uc(true));
            return pr.this.gz.pr();
        }

        @Override // com.byazt.qx.w
        public void pr(int i, String str) {
        }

        @Override // com.byazt.qx.w
        public void setPauseFromExpressView(boolean z) {
            pr.this.pr.nt(1);
        }

        @Override // com.byazt.qx.w
        public int hw() {
            if (pr.this.zo(true)) {
                int i = pr.this.pr.l() ? 3 : 2;
                if (pr.this.pr.d()) {
                    return 5;
                }
                return i;
            }
            if (pr.this.vk.hw()) {
                return 4;
            }
            if (pr.this.vk.hn()) {
                return 5;
            }
            if (pr.this.qa.x()) {
                return 1;
            }
            if (pr.this.qa.hw()) {
                return 2;
            }
            pr.this.qa.hn();
            return 3;
        }

        @Override // com.byazt.qx.w
        public int hn() {
            return pr.this.b();
        }

        @Override // com.byazt.qx.w
        public void aj() {
            pr.this.lb.hn();
        }

        @Override // com.byazt.qx.w
        public void vk() {
            pr.this.pr.zo(3);
        }

        @Override // com.byazt.qx.w
        public void x(int i) {
            pr.this.pr.aj(i);
        }

        @Override // com.byazt.qx.w
        public void pr(float f, float f2, float f3, float f4, int i) {
            pr.this.pr.pr(f, f2, f3, f4, i);
        }

        @Override // com.byazt.qx.w
        public void x() {
            pr.this.b = true;
        }

        @Override // com.byazt.qx.w
        public void hw(int i) {
            if (jn.c(pr.this.hw)) {
                pr.this.pr.x(1);
            } else {
                pr.this.pr.pr(i, false);
            }
        }

        @Override // com.byazt.qx.w
        public void c() {
            pr.this.b = false;
        }

        @Override // com.byazt.qx.w
        public void pr(float f) {
            if (pr.this.gz != null) {
                pr.this.gz.hn((int) (1000.0f / f));
            }
            pr.this.pr.o().pr(f);
        }

        @Override // com.byazt.qx.w
        public void pr(int i, int i2) {
            if (i == 0 && i2 == 0) {
                pr.this.iu = true;
            }
            pr.this.pr.pr(i, i2);
        }

        @Override // com.byazt.qx.w
        public void hn(int i) {
            pr.this.pr.hn(i);
        }

        @Override // com.byazt.qx.w
        public void pr(of ofVar) {
            if (pr.this.a != null && pr.this.pr != null) {
                com.byazt.az.pr prVar = new com.byazt.az.pr(pr.this.pr, ofVar, pr.this.k, 7);
                pr.this.a.pr(ofVar, prVar);
                ((com.byazt.yx.pr) prVar.pr(com.byazt.yx.pr.class)).pr(pr.this.pr.pr(ofVar));
            }
        }

        @Override // com.byazt.qx.w
        public void zo() {
            pr.this.pr.od();
        }
    };

    public pr(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        this.pr = tTBaseVideoActivity;
        this.hw = ofVar;
        this.hn = ofVar.rf();
        this.x = ofVar.oq();
    }

    public void pr(com.byazt.ax.c cVar, com.byazt.ax.uc ucVar, com.byazt.ax.hw hwVar, com.byazt.ax.x xVar, com.byazt.ax.pr prVar) {
        this.lb = cVar;
        this.qa = ucVar;
        this.a = hwVar;
        this.cz = xVar;
        this.rc = prVar;
    }

    public void pr(String str, boolean z, boolean z2, com.byazt.hf.hn hnVar) {
        this.k = str;
        this.m = z;
        this.g = z2;
        this.gz = hnVar;
    }

    public com.byazt.ax.c pr() {
        return this.lb;
    }

    public final void pr(com.byazt.az.c cVar) {
        this.zo = cVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.pr;
        of ofVar = this.hw;
        String str = this.k;
        this.ny = new com.byazt.qx.uc(tTBaseVideoActivity, ofVar, str, ls.x(str)) { // from class: com.byazt.lu.pr.2
            @Override // com.byazt.qx.uc, com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, com.byazt.hg.vk vkVar) {
                if (of.uc(this.pr)) {
                    return;
                }
                super.pr(view, vkVar);
                pr.this.pr.pr(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.pr;
        of ofVar2 = this.hw;
        String str2 = this.k;
        this.fo = new com.byazt.qx.c(tTBaseVideoActivity2, ofVar2, str2, ls.x(str2)) { // from class: com.byazt.lu.pr.3
            @Override // com.byazt.qx.c, com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, com.byazt.hg.vk vkVar) {
                if (of.uc(this.pr)) {
                    return;
                }
                super.pr(view, vkVar);
                com.byazt.ln.hw hwVar = (com.byazt.ln.hw) this.zo.pr(com.byazt.ln.hw.class);
                if (hwVar == null || !hwVar.hw(view)) {
                    return;
                }
                pr.this.pr.pr(2);
            }
        };
        this.w.setClickListener(this.zo);
    }

    private void aa() {
        this.lb.pr(false);
        this.aj.uc(8);
        this.aj.c(8);
        this.aj.hn(8);
        pq();
    }

    public void hw() {
        jw();
        if (sv()) {
            jn.pr(this.hw, true);
        }
        aa();
        if (l()) {
            this.a.hw();
        }
        if (uc()) {
            c();
        } else {
            this.pr.cz();
            hn();
        }
    }

    @Override // com.byazt.lu.hw
    public void hn() {
        x();
    }

    public void x() {
        boolean zC = this.vk.c();
        if (!this.a.e() && !zC) {
            yb();
        }
        this.a.pr(this.vk.w());
        if (zC) {
            this.vk.pr().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.aj.hn(!zC);
        this.vk.x(zC);
        this.lb.pr(vj() || !zC);
        this.pr.uc();
    }

    public void c() {
        this.pr.fw(0);
        this.lb.pr(vj());
        float f = this.c;
        float f2 = this.uc;
        float[] fArrA = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArrA = a();
        }
        this.vk.pr(this.hw, ve.pr(this.pr.iu() ? 7 : 8, String.valueOf(ls.m(this.hw)), fArrA[0], fArrA[1], this.hw), this.k, this.m, this.pr.pr());
        this.aj.hn(false);
        this.vk.x(true);
        this.vk.pr(this.nl);
        this.vk.pr(new com.byazt.qx.pr() { // from class: com.byazt.lu.pr.4
            @Override // com.byazt.qx.pr
            public void pr(View view, int i) {
            }

            @Override // com.byazt.qx.pr
            public void hw(View view, int i) {
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, String str, int i) {
                if (pr.this.a.e()) {
                    return;
                }
                pr.this.a.hw();
                pr.this.pr.cz();
                pr.this.pr.fw(8);
                pr.this.lb.pr(true);
                com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.lu.pr.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.pr.qa();
                    }
                });
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, float f3, float f4) {
                if (pr.this.a.e()) {
                    return;
                }
                pr.this.a.hw();
                pr.this.pr.cz();
                pr.this.pr.fw(8);
                pr prVar = pr.this;
                prVar.fw = prVar.vk.zo();
                if (pr.this.fw == 0) {
                    jn.hw(pr.this.hw, true);
                }
                pr.this.hn();
            }
        });
        ((com.byazt.yx.pr) this.ny.pr(com.byazt.yx.pr.class)).pr(this.pr.ii());
        ((com.byazt.yx.pr) this.fo.pr(com.byazt.yx.pr.class)).pr(this.pr.ii());
        this.pr.pr((com.byazt.yx.hn) this.ny.pr(com.byazt.yx.hn.class));
        this.pr.pr((com.byazt.yx.hn) this.fo.pr(com.byazt.yx.hn.class));
        this.vk.pr(this.ny, this.fo);
        this.vk.fw();
    }

    public boolean uc() {
        return ie.pr(this.hw) == 2;
    }

    public boolean fw() {
        com.byazt.xt.c cVar;
        return uc() && (cVar = this.vk) != null && cVar.c();
    }

    public void zo() {
        boolean z = true;
        if (this.g) {
            z = false;
        } else {
            boolean z2 = this instanceof vk;
            if (jn.fo(this.hw)) {
                z2 = true;
            }
            if (this.x == 100.0f) {
                z = z2;
            }
        }
        if (z) {
            ii();
        } else {
            this.pr.e().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (!(this instanceof vk) && this.x != 100.0f) {
            try {
                final View decorView = this.pr.getWindow().getDecorView();
                decorView.post(new Runnable() { // from class: com.byazt.lu.pr.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int iW = (int) (er.w((Context) pr.this.pr) / 2.0f);
                        int paddingLeft = decorView.getPaddingLeft();
                        int paddingRight = decorView.getPaddingRight();
                        int paddingTop = decorView.getPaddingTop();
                        int paddingBottom = decorView.getPaddingBottom();
                        if (pr.this.hn == 1 && !er.hw()) {
                            paddingTop += iW;
                            paddingBottom += iW;
                        }
                        if (pr.this.hn == 2 && !er.hw()) {
                            paddingLeft += iW;
                            paddingRight += iW;
                        }
                        decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                });
            } catch (Throwable th) {
            }
        }
    }

    public View aj() {
        if (this.x != 100.0f) {
            return jn();
        }
        switch (this.hw.xb()) {
            case 1:
                return com.byazt.sdv.c.hn(this.pr);
            case 2:
            default:
                return com.byazt.sdv.c.pr(this.pr);
            case 3:
                return com.byazt.sdv.c.x(this.pr);
        }
    }

    public View vk() {
        if (this.w == null) {
            this.w = new CommonEndCardFrameLayout(this.pr, this.hw);
        }
        return this.w;
    }

    public View w() {
        return com.byazt.sdv.c.c(this.pr);
    }

    public com.byazt.xt.hw pr(boolean z) {
        if (this.x != 100.0f) {
            this.aj = new com.byazt.xt.fw(this.pr, this.hw, z);
        } else {
            this.aj = new com.byazt.xt.hn(this.pr, this.hw, z);
        }
        return this.aj;
    }

    public com.byazt.xt.c k() {
        com.byazt.xt.c cVar = new com.byazt.xt.c(this.pr);
        this.vk = cVar;
        return cVar;
    }

    public AbstractEndCardFrameLayout m() {
        return this.w;
    }

    public void pr(int i, int i2) {
        this.c = i;
        this.uc = i2;
    }

    public void hw(boolean z) {
        com.byazt.xt.c cVar = this.vk;
        if (cVar != null) {
            cVar.x();
        }
    }

    public void g() {
    }

    private boolean pr(of ofVar) {
        return (ofVar.aj() == 4) && !TextUtils.isEmpty(ofVar.rc());
    }

    public void hn(boolean z) {
        if (this.hw.oq() != 100.0f) {
            if (!a.hw().vk(ls.m(this.hw)) && !this.g) {
                return;
            }
            if (com.byazt.wr.uc.hn && com.byazt.wr.uc.hw && pr(this.hw)) {
                com.byazt.wr.uc.hw = false;
                com.byazt.wr.uc.hn = false;
                this.pr.finish();
            } else if (z && !com.byazt.wr.uc.hn) {
                this.pr.finish();
            } else if (this.a.y() && !com.byazt.wr.uc.hn) {
                this.pr.finish();
            }
        }
    }

    public void ho() {
        com.byazt.xt.c cVar = this.vk;
        if (cVar != null) {
            cVar.g();
        }
    }

    public void nt() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.w;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.hw();
        }
        com.byazt.xt.c cVar = this.vk;
        if (cVar != null) {
            cVar.hn(true);
        }
        if (!lv() && !this.a.e()) {
            this.a.fo();
        }
    }

    public void pr(View view) {
    }

    public void yb() {
        this.aj.nt();
        this.lb.hw(this.hw.zz());
        this.lb.c(od());
        this.aj.uc(0);
        this.aj.c(0);
    }

    public void pr(int i, int i2, Intent intent) {
    }

    public void pr(int i) {
    }

    public boolean lb() {
        return false;
    }

    public FrameLayout qa() {
        com.byazt.xt.c cVar;
        if (lb.x(this.hw)) {
            return this.w.getVideoArea();
        }
        if (uc() && (cVar = this.vk) != null && cVar.c()) {
            return this.vk.pr();
        }
        return this.aj.k();
    }

    public void x(boolean z) {
        float f = this.x;
        if (f == 100.0f) {
            if (z) {
                if (this.hn == 1) {
                    this.aj.x(0);
                }
                if (com.byazt.lpk.pr.pr(this.hw)) {
                    this.aj.uc(0);
                    return;
                }
                return;
            }
            if (this.hn != 1) {
                return;
            }
        } else {
            int i = (int) (f * 1000.0f);
            if (this.hn == 1) {
                switch (i) {
                    case TTAdConstant.STYLE_SIZE_RADIO_2_3 /* 666 */:
                    case 1000:
                    case TTAdConstant.STYLE_SIZE_RADIO_3_2 /* 1500 */:
                    case TTAdConstant.STYLE_SIZE_RADIO_16_9 /* 1777 */:
                        this.aj.x(8);
                        break;
                    default:
                        this.aj.x(z ? 0 : 8);
                        break;
                }
                return;
            }
        }
        this.aj.x(8);
    }

    public float[] a() {
        TTBaseVideoActivity tTBaseVideoActivity = this.pr;
        int iX = er.x(tTBaseVideoActivity, er.w((Context) tTBaseVideoActivity));
        float f = this.uc;
        float f2 = this.c;
        int i = this.hn;
        if ((i == 1) != (f > f2)) {
            float f3 = f + f2;
            f2 = f3 - f2;
            f = f3 - f2;
        }
        if (i == 1) {
            f -= iX;
        } else {
            f2 -= iX;
        }
        return new float[]{f2, f};
    }

    public void cz() {
        com.byazt.xt.c cVar = this.vk;
        if (cVar != null) {
            cVar.pr(this.gz);
        }
        if (this.g) {
            this.aj.hw((int) (this.qa.gz() / 1000));
        }
    }

    public void ny() {
    }

    public void fo() {
    }

    public void c(boolean z) {
        this.m = z;
        this.qa.hn(z);
    }

    public final int rc() {
        return this.fw;
    }

    public com.byazt.wv.hw.pr pr(of ofVar, com.byazt.wv.vk vkVar) {
        return pr(ofVar, vkVar, false);
    }

    public final com.byazt.wv.hw.pr pr(of ofVar, final com.byazt.wv.vk vkVar, boolean z) {
        com.byazt.wv.hn hnVar = new com.byazt.wv.hn(this.pr, ofVar, z);
        hnVar.pr(qi());
        hnVar.hw(ls());
        hnVar.hn(this.pr.ww());
        hnVar.x(this.pr.n());
        hnVar.hn(this.b);
        hnVar.x(jn.iu(ofVar) && !this.pr.uc.get());
        this.pr.qn();
        return hnVar.hw(new com.byazt.wv.vk() { // from class: com.byazt.lu.pr.6
            @Override // com.byazt.wv.vk
            public void pr() {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.pr();
                }
                pr.this.pr.of();
            }

            @Override // com.byazt.wv.vk
            public void hw() {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.hw();
                }
            }

            @Override // com.byazt.wv.vk
            public void pr(int i) {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.pr(i);
                }
            }

            @Override // com.byazt.wv.vk
            public void hn() {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.hn();
                }
            }
        });
    }

    public void z() {
        f();
    }

    public int b() {
        return this.gz.c() + this.gz.hw();
    }

    public int iu() {
        return this.gz.c();
    }

    public int ve() {
        return this.gz.uc();
    }

    public void gz() {
        if (this.z < 0) {
            this.z = this.a.qi();
        }
        int i = this.z;
        if (i > 0) {
            this.z = i - 1;
            this.lb.pr(false, this.z + an.aB, null, true, true);
        } else if (i == 0) {
            this.pr.x(0);
            this.lb.pr(false, "奖励已领取", null, true, true);
        }
    }

    public void nl() {
        this.ho = true;
    }

    public int y() {
        return 0;
    }

    public boolean ww() {
        return false;
    }

    public boolean n() {
        return true;
    }

    public void pr(JSONObject jSONObject) {
    }

    public void pr(Map<String, Object> map) {
    }

    public void hw(Map<String, Object> map) {
    }

    public void e() {
    }

    public com.byazt.ga.hw s() {
        return null;
    }

    public int ls() {
        if (gu()) {
            return b();
        }
        return qn() + hs();
    }

    public int uc(boolean z) {
        if (mw() && this.a.v()) {
            return this.z;
        }
        if (gu()) {
            if (!zo(false)) {
                return Math.max(of() - b(), 0);
            }
            return aj(z);
        }
        return fw(z);
    }

    private int aj(boolean z) {
        float fBt = this.hw.bt() / 100.0f;
        if (!z) {
            return (int) Math.max(qv.fw(this.hw) - ((double) b()), 0.0d);
        }
        return (int) Math.max(Math.min(qv.fw(this.hw) * ((double) fBt), jn.pr() / 1000) - ((double) b()), 0.0d);
    }

    public int er() {
        int i;
        if (mw() && this.a.v() && (i = this.z) >= 0) {
            return i;
        }
        if (gu()) {
            float fBt = this.hw.bt() / 100.0f;
            if (zo(false)) {
                return aj(true);
            }
            return (int) Math.max((of() * fBt) - b(), 0.0f);
        }
        return v();
    }

    public int fw(boolean z) {
        if (z) {
            return vk(false);
        }
        return iy();
    }

    public int v() {
        return vk(true);
    }

    private int vk(boolean z) {
        long jGz = this.qa.gz();
        if (!z) {
            long jMin = Math.min(jn.pr(), (long) (this.qa.iu() * 1000.0d));
            long jHs = ((long) hs()) * 1000;
            long jIu = (long) ((this.qa.iu() % 1.0d) * 1000.0d);
            if (jIu > 0) {
                jGz -= 1000 - jIu;
            }
            return Math.round((jMin - (jGz + jHs)) / 1000.0f);
        }
        long jMax = Math.max(Math.min(jn.pr(), (long) ((this.qa.iu() * 1000.0d) * ((double) (this.hw.bt() / 100.0f)))) - (jGz + (((long) hs()) * 1000)), 0L);
        return (int) Math.max(((long) ((int) (jMax / 1000))) + (((int) (jMax % 1000)) > 500 ? 1L : 0L), 0L);
    }

    private int iy() {
        long jMax = Math.max(((long) (this.qa.iu() * 1000.0d)) - this.qa.gz(), 0L);
        return Math.max((((int) (jMax / 1000)) + (((int) (jMax % 1000)) > 500 ? 1 : 0)) - hs(), 0);
    }

    public void hw(int i) {
        this.ve = i;
    }

    public int qi() {
        int i = this.ve;
        if (i == Integer.MIN_VALUE) {
            return uc(true);
        }
        return i;
    }

    public int qn() {
        return (int) (this.qa.gz() / 1000);
    }

    public int of() {
        if (ny.hn(this.hw)) {
            return ny.c(this.hw);
        }
        return jn.ho(this.hw);
    }

    public void ii() {
        if (!this.yb && Build.VERSION.SDK_INT != 26) {
            Window window = this.pr.getWindow();
            if (window != null) {
                this.pr.requestWindowFeature(1);
                window.setBackgroundDrawable(new ColorDrawable(-2013265920));
                window.setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
                window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
            }
            er.fw((Activity) this.pr);
            this.yb = true;
        }
    }

    public boolean i() {
        return !this.g && this.hn == 1 && jn.fo(this.hw) && this.hw.oq() != 100.0f;
    }

    public com.byazt.qx.w r() {
        return this.nl;
    }

    public void hn(int i) {
        this.gz.pr(i);
    }

    public int hs() {
        return this.gz.hw();
    }

    public int nw() {
        return this.gz.hn();
    }

    public boolean ie() {
        return this.iu;
    }

    public void o() {
    }

    @Override // com.byazt.lu.hw
    public boolean f() {
        return jn.yb(this.hw) || this.a.v();
    }

    public void bm() {
        com.byazt.xt.c cVar = this.vk;
        if (cVar != null) {
            cVar.pr(this.gz);
        }
        if (mw() && this.a.v()) {
            gz();
        } else {
            d();
        }
    }

    public View jn() {
        int i = (int) (this.x * 1000.0f);
        if (this.hn == 1) {
            switch (i) {
                case TTAdConstant.STYLE_SIZE_RADIO_2_3 /* 666 */:
                    return com.byazt.sdv.c.rc(this.pr);
                case 1000:
                    return com.byazt.sdv.c.b(this.pr);
                case TTAdConstant.STYLE_SIZE_RADIO_3_2 /* 1500 */:
                    return com.byazt.sdv.c.z(this.pr);
                case TTAdConstant.STYLE_SIZE_RADIO_16_9 /* 1777 */:
                    return com.byazt.sdv.c.iu(this.pr);
                default:
                    return com.byazt.sdv.c.ve(this.pr);
            }
        }
        switch (i) {
            case 562:
                return com.byazt.sdv.c.y(this.pr);
            case TTAdConstant.STYLE_SIZE_RADIO_2_3 /* 666 */:
                return com.byazt.sdv.c.gz(this.pr);
            case 1000:
                return com.byazt.sdv.c.b(this.pr);
            case TTAdConstant.STYLE_SIZE_RADIO_3_2 /* 1500 */:
                return com.byazt.sdv.c.nl(this.pr);
            default:
                return com.byazt.sdv.c.ww(this.pr);
        }
    }
}
