package com.byazt.cu;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.byazt.ax.uc;
import com.byazt.ax.x;
import com.byazt.az.c;
import com.byazt.ca.ho;
import com.byazt.ca.iu;
import com.byazt.ea.w;
import com.byazt.fj.TTProgressBar;
import com.byazt.hb.hw;
import com.byazt.hf.hn;
import com.byazt.hg.aj;
import com.byazt.hg.b;
import com.byazt.hg.bh;
import com.byazt.hg.fo;
import com.byazt.hg.hs;
import com.byazt.hg.ie;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.m;
import com.byazt.hg.n;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.ve;
import com.byazt.hg.vk;
import com.byazt.hg.ww;
import com.byazt.ky.SaasAuthRewardDialog;
import com.byazt.lu.fw;
import com.byazt.qx.zo;
import com.byazt.rg.BaseThemeActivity;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.sd.nl;
import com.byazt.vkw.g;
import com.byazt.vkw.qi;
import com.byazt.vzx.pr;
import com.byazt.wt.e;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.ny;
import com.byazt.xt.RewardAuthToastLayout;
import com.byazt.xt.RewardFullBaseLayout;
import com.byazt.xz.AbstractEndCardFrameLayout;
import com.byazt.zp.k;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, 44, 45})
public abstract class TTBaseVideoActivity extends BaseThemeActivity implements qi.pr, hw {
    public final AtomicBoolean a;
    public com.byazt.az.hw aa;
    public final com.byazt.mm.pr.InterfaceC0136pr ag;
    public final AtomicBoolean aj;
    public boolean b;
    public int bh;
    public com.byazt.tt.pr bm;
    public final ConcurrentHashMap<Integer, Boolean> c;
    public com.byazt.ax.pr.InterfaceC0021pr cr;
    public final AtomicBoolean cz;
    public boolean d;
    public com.byazt.ax.pr e;
    public long eh;
    public x er;
    public Double ey;
    public com.byazt.on.hw f;
    public AtomicBoolean fe;
    public boolean fo;
    public final AtomicBoolean fw;
    public final AtomicBoolean g;
    public final AtomicBoolean gu;
    public com.byazt.xt.hw gz;
    public final AtomicBoolean hn;
    public final AtomicBoolean ho;
    public com.byazt.pfl.hw hs;
    public final iu hw;
    public String i;
    public c ie;
    public int ii;
    public int iu;
    public com.byazt.ax.pr.hw iy;
    public float j;
    public final AtomicBoolean jn;
    public long jw;
    public final AtomicBoolean k;
    public final AtomicBoolean l;
    public final AtomicBoolean lb;
    public uc ls;
    public com.byazt.ga.pr.InterfaceC0074pr lv;
    public final AtomicBoolean m;
    public com.byazt.fu.pr mr;
    public final com.byazt.db.pr mw;
    public com.byazt.ax.hw n;
    public com.byazt.hf.x na;
    public com.byazt.xt.c nl;
    public boolean np;
    public final AtomicBoolean nt;
    public int nw;
    public boolean ny;
    public com.byazt.uq.c o;
    public com.byazt.uq.pr od;
    public hn of;
    public int pj;
    public int pq;
    public final String pr;
    public final AtomicBoolean qa;
    public com.byazt.lu.pr qi;
    public TTBaseVideoActivity qn;
    public int qo;
    public com.byazt.wv.hw.pr qv;
    public final com.byazt.cy.hw qx;
    public String r;
    public boolean rc;
    public com.byazt.zp.pr rk;
    public final com.byazt.cy.pr sv;
    public long u;
    public final AtomicBoolean uc;
    public com.byazt.ax.hn v;
    public RewardFullBaseLayout ve;
    public final com.byazt.ei.pr vj;
    public final AtomicBoolean vk;
    public final AtomicBoolean w;
    public long wt;
    public com.byazt.ax.c ww;
    public final ConcurrentHashMap<Integer, Boolean> x;
    public AbstractEndCardFrameLayout y;
    public final AtomicBoolean yb;
    public long z;
    public final AtomicBoolean zo;

    public abstract void hn(boolean z);

    public abstract boolean iu();

    public abstract void pr(String str, Bundle bundle);

    public abstract void ve();

    public TTBaseVideoActivity() {
        this.pr = iu() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.hw = new iu(Looper.getMainLooper(), this);
        this.hn = new AtomicBoolean(false);
        this.x = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.uc = new AtomicBoolean(false);
        this.fw = new AtomicBoolean(false);
        this.zo = new AtomicBoolean(false);
        this.gu = new AtomicBoolean(false);
        this.aj = new AtomicBoolean(false);
        this.vk = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.m = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.ho = new AtomicBoolean(false);
        this.nt = new AtomicBoolean(false);
        this.yb = new AtomicBoolean(false);
        this.lb = new AtomicBoolean(false);
        this.qa = new AtomicBoolean(false);
        this.a = new AtomicBoolean(false);
        this.cz = new AtomicBoolean(false);
        this.iu = -1;
        this.jw = 0L;
        this.wt = 0L;
        this.qo = 1;
        this.ey = null;
        this.u = 0L;
        this.np = false;
        this.jn = new AtomicBoolean();
        this.l = new AtomicBoolean();
        this.lv = new com.byazt.ga.pr.InterfaceC0074pr() { // from class: com.byazt.cu.TTBaseVideoActivity.1
            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr() {
                TTBaseVideoActivity.this.hw.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                TTBaseVideoActivity.this.yb();
                if (!TTBaseVideoActivity.this.ls.k()) {
                    TTBaseVideoActivity.this.ls.hw(TTBaseVideoActivity.this.ls.gz() + 1000);
                }
                if (TTBaseVideoActivity.this.qi.uc() && !TTBaseVideoActivity.this.ls.k()) {
                    TTBaseVideoActivity.this.nl.hw(true);
                }
                TTBaseVideoActivity.this.vj();
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr(int i, String str) {
                if (!TTBaseVideoActivity.this.fo) {
                    return;
                }
                TTBaseVideoActivity.this.hw.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                TTBaseVideoActivity.this.g();
                TTBaseVideoActivity.this.ls.pr(5);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.hw(tTBaseVideoActivity.ls.hw());
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void hw() {
                TTBaseVideoActivity.this.hw.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                TTBaseVideoActivity.this.yb();
                TTBaseVideoActivity.this.pr(false, false);
                TTBaseVideoActivity.this.ls.pr(6);
                TTBaseVideoActivity.this.ls.aj();
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr(long j, long j2) {
                if (!TTBaseVideoActivity.this.fo && TTBaseVideoActivity.this.ls.hw()) {
                    TTBaseVideoActivity.this.ls.pr((Map<String, Object>) null);
                }
                boolean z = true;
                if (TTBaseVideoActivity.this.n.e()) {
                    TTBaseVideoActivity.this.ls.hn(true);
                    return;
                }
                TTBaseVideoActivity.this.hw.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                if (j != TTBaseVideoActivity.this.ls.gz()) {
                    TTBaseVideoActivity.this.yb();
                }
                if (!TTBaseVideoActivity.this.ls.hw() && j2 != j) {
                    return;
                }
                TTBaseVideoActivity.this.ls.hw(j);
                if (TTBaseVideoActivity.this.eh()) {
                    com.byazt.xt.c cVar = TTBaseVideoActivity.this.nl;
                    String strValueOf = String.valueOf(TTBaseVideoActivity.this.ls.ve());
                    int iGz = (int) (TTBaseVideoActivity.this.ls.gz() / 1000);
                    if (j != j2 && !TTBaseVideoActivity.this.ls.y()) {
                        z = false;
                    }
                    cVar.pr(strValueOf, iGz, 0, z);
                }
                TTBaseVideoActivity.this.hn(0);
                TTBaseVideoActivity.this.r();
                TTBaseVideoActivity.this.qi.cz();
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void hn() {
                if (TTBaseVideoActivity.this.o != null && TTBaseVideoActivity.this.o.pr() != null) {
                    TTBaseVideoActivity.this.o.pr().pr();
                }
            }
        };
        this.od = new com.byazt.uq.pr() { // from class: com.byazt.cu.TTBaseVideoActivity.12
            @Override // com.byazt.qx.w
            public void pr(int i) {
                TTBaseVideoActivity.this.qi.r().pr(i);
            }

            @Override // com.byazt.qx.w
            public long pr() {
                return TTBaseVideoActivity.this.qi.r().pr();
            }

            @Override // com.byazt.qx.w
            public int hw() {
                return TTBaseVideoActivity.this.qi.r().hw();
            }

            @Override // com.byazt.qx.w
            public int hn() {
                return TTBaseVideoActivity.this.qi.r().hn();
            }

            @Override // com.byazt.qx.w
            public void x() {
                TTBaseVideoActivity.this.qi.r().x();
            }

            @Override // com.byazt.qx.w
            public void hw(int i) {
                TTBaseVideoActivity.this.qi.r().hw(i);
            }

            @Override // com.byazt.qx.w
            public void c() {
                TTBaseVideoActivity.this.qi.r().c();
            }

            @Override // com.byazt.qx.w
            public void pr(int i, String str) {
                TTBaseVideoActivity.this.qi.r().pr(i, str);
            }

            @Override // com.byazt.qx.w
            public void setPauseFromExpressView(boolean z) {
                TTBaseVideoActivity.this.qi.r().setPauseFromExpressView(z);
            }

            @Override // com.byazt.qx.w
            public void pr(float f) {
                TTBaseVideoActivity.this.qi.r().pr(f);
            }

            @Override // com.byazt.qx.w
            public void pr(int i, int i2) {
                TTBaseVideoActivity.this.qi.r().pr(i, i2);
            }

            @Override // com.byazt.uq.pr
            public void pr(View view) {
                TTBaseVideoActivity.this.pr(2);
                com.byazt.uq.hn.hw(TTBaseVideoActivity.this.s, b.zo(TTBaseVideoActivity.this.s), true, null);
            }

            @Override // com.byazt.qx.w
            public void hn(int i) {
                TTBaseVideoActivity.this.hn(i);
            }

            @Override // com.byazt.qx.w
            public void pr(of ofVar) {
                TTBaseVideoActivity.this.qi.r().pr(ofVar);
            }

            @Override // com.byazt.uq.pr
            public void pr(View view, int i, com.byazt.dj.hn hnVar, bh bhVar) {
                boolean zOptBoolean;
                vk vkVar;
                if (TTBaseVideoActivity.this.ie == null) {
                    zOptBoolean = false;
                } else {
                    if (!(hnVar instanceof fo)) {
                        vkVar = null;
                        zOptBoolean = false;
                    } else {
                        fo foVar = (fo) hnVar;
                        vkVar = new vk();
                        vkVar.pr(foVar.pr);
                        vkVar.hw(foVar.hw);
                        vkVar.hn(foVar.hn);
                        vkVar.x(foVar.x);
                        vkVar.pr(foVar.c);
                        vkVar.hw(foVar.uc);
                        vkVar.hw(foVar.ho);
                        zOptBoolean = foVar.pr().optBoolean("isLottieInternalClick", false);
                    }
                    TTBaseVideoActivity.this.ie.pr(view, vkVar);
                }
                com.byazt.uq.hn.pr(TTBaseVideoActivity.this.s, (m) bhVar, false, (JSONObject) null, zOptBoolean);
            }

            @Override // com.byazt.uq.pr
            public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
                vk vkVar;
                if ((i == 1 || i == 2) && (hnVar instanceof fo)) {
                    fo foVar = (fo) hnVar;
                    vkVar = new vk();
                    vkVar.pr(foVar.pr);
                    vkVar.hw(foVar.hw);
                    vkVar.hn(foVar.hn);
                    vkVar.x(foVar.x);
                    vkVar.pr(foVar.c);
                    vkVar.hw(foVar.uc);
                    vkVar.hw(foVar.ho);
                } else {
                    vkVar = null;
                }
                if (i == 2) {
                    TTBaseVideoActivity.this.ie.pr(view, vkVar);
                }
                if (i == 1) {
                    TTBaseVideoActivity.this.ie.pr(view, vkVar);
                }
            }

            @Override // com.byazt.uq.pr
            public void pr(ViewGroup viewGroup) {
            }
        };
        this.ag = new com.byazt.mm.pr.InterfaceC0136pr() { // from class: com.byazt.cu.TTBaseVideoActivity.18
            @Override // com.byazt.mm.pr.InterfaceC0136pr
            public com.byazt.mm.pr q_() {
                com.byazt.mm.pr prVar = new com.byazt.mm.pr();
                if (TTBaseVideoActivity.this.ls != null) {
                    prVar.fw = TTBaseVideoActivity.this.ls.nt();
                    prVar.pr = TTBaseVideoActivity.this.ls.pr();
                    prVar.zo = TTBaseVideoActivity.this.ny;
                }
                return prVar;
            }

            @Override // com.byazt.mm.pr.InterfaceC0136pr
            public boolean l_() {
                return false;
            }
        };
        this.vj = new com.byazt.ei.hw(new com.byazt.ei.pr.InterfaceC0053pr() { // from class: com.byazt.cu.TTBaseVideoActivity.19
            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public TTBaseVideoActivity getActivity() {
                return TTBaseVideoActivity.this.qn;
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public RewardFullBaseLayout pr() {
                return TTBaseVideoActivity.this.ve;
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public boolean hw() {
                return TTBaseVideoActivity.this.iu();
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public of hn() {
                return TTBaseVideoActivity.this.s;
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public boolean x() {
                return TTBaseVideoActivity.this.d;
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public int c() {
                return TTBaseVideoActivity.this.qi.ve();
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public int uc() {
                return TTBaseVideoActivity.this.qi.uc(true);
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public boolean fw() {
                return TTBaseVideoActivity.this.qa.get();
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public boolean zo() {
                return TTBaseVideoActivity.this.jn();
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public boolean aj() {
                return TTBaseVideoActivity.this.qi.ie();
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public void pr(int i, int i2) {
                if (i == 3) {
                    TTBaseVideoActivity.this.g(2);
                }
                TTBaseVideoActivity.this.hw(i, i2);
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public void pr(int i) {
                if (i == 3) {
                    TTBaseVideoActivity.this.ho(2);
                }
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public void vk() {
                if (TTBaseVideoActivity.this.qi instanceof com.byazt.lu.vk) {
                    ((com.byazt.lu.vk) TTBaseVideoActivity.this.qi).aa();
                }
            }

            @Override // com.byazt.ei.pr.InterfaceC0053pr
            public void w() {
                if (TTBaseVideoActivity.this.qi instanceof com.byazt.lu.vk) {
                    ((com.byazt.lu.vk) TTBaseVideoActivity.this.qi).iy();
                }
            }
        });
        this.mw = new com.byazt.db.hw(new com.byazt.db.pr.InterfaceC0038pr() { // from class: com.byazt.cu.TTBaseVideoActivity.20
            @Override // com.byazt.db.pr.InterfaceC0038pr
            public Activity getActivity() {
                return TTBaseVideoActivity.this.qn;
            }

            @Override // com.byazt.db.pr.InterfaceC0038pr
            public of pr() {
                return TTBaseVideoActivity.this.s;
            }

            @Override // com.byazt.db.pr.InterfaceC0038pr
            public String hw() {
                return TTBaseVideoActivity.this.i;
            }

            @Override // com.byazt.db.pr.InterfaceC0038pr
            public void hn() {
                TTBaseVideoActivity.this.finish();
            }

            @Override // com.byazt.db.pr.InterfaceC0038pr
            public void pr(int i, TTProgressBar tTProgressBar) {
                try {
                    TTBaseVideoActivity.this.ve.pr(i, tTProgressBar);
                } catch (Exception e) {
                }
            }

            @Override // com.byazt.db.pr.InterfaceC0038pr
            public void pr(boolean z, String str, String str2) {
                if (ny.hn(TTBaseVideoActivity.this.s)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible", z);
                    jSONObject.put("entrance_text", hs.pr(TTBaseVideoActivity.this.s, str, str2));
                } catch (JSONException e) {
                }
                TTBaseVideoActivity.this.nl.pr("showPlayAgainEntrance", jSONObject);
                TTBaseVideoActivity.this.n.pr(jSONObject);
                if (!TTBaseVideoActivity.this.n.e()) {
                    TTBaseVideoActivity.this.ww.fw(z);
                    TTBaseVideoActivity.this.ww.pr(hs.pr(TTBaseVideoActivity.this.s, str, str2));
                }
            }

            @Override // com.byazt.db.pr.InterfaceC0038pr
            public void x() {
                TTBaseVideoActivity.this.qn();
            }

            @Override // com.byazt.db.pr.InterfaceC0038pr
            public void c() {
                if (TTBaseVideoActivity.this.ls != null) {
                    TTBaseVideoActivity.this.ls.fw();
                }
            }
        });
        this.qx = new com.byazt.cy.hw();
        this.sv = new com.byazt.cy.pr() { // from class: com.byazt.cu.TTBaseVideoActivity.21
            @Override // com.byazt.cy.pr
            public void pr(boolean z, JSONObject jSONObject) {
                boolean zFw;
                boolean zZo;
                if (!z) {
                    return;
                }
                boolean zIu = TTBaseVideoActivity.this.iu();
                if (zIu) {
                    zFw = n.c();
                } else {
                    zFw = n.fw();
                }
                if (zIu) {
                    zZo = n.uc();
                } else {
                    zZo = n.zo();
                }
                boolean z2 = TTBaseVideoActivity.this.n != null && TTBaseVideoActivity.this.n.e();
                boolean zHw = ie.hw(TTBaseVideoActivity.this.s);
                boolean z3 = TTBaseVideoActivity.this.c(4) == 2;
                boolean z4 = TTBaseVideoActivity.this.cz.get();
                TTBaseVideoActivity.this.qx.hw(z2);
                TTBaseVideoActivity.this.qx.hn(z4 ? 1 : 0);
                TTBaseVideoActivity.this.qx.c(TTBaseVideoActivity.this.c(4));
                if (z2 || TTBaseVideoActivity.this.cz.get()) {
                    return;
                }
                if (zHw && zZo) {
                    if (TTBaseVideoActivity.this.nl != null) {
                        TTBaseVideoActivity.this.qx.hw(2);
                        zo.hw(TTBaseVideoActivity.this.nl.k());
                        return;
                    }
                    return;
                }
                if (zFw) {
                    if (!jn.yb(TTBaseVideoActivity.this.s) && zIu) {
                        TTBaseVideoActivity.this.qx.x(1);
                    } else if (z3) {
                        TTBaseVideoActivity.this.qx.hw(1);
                        TTBaseVideoActivity.this.c();
                    }
                }
            }
        };
        this.fe = new AtomicBoolean(true);
    }

    @Override // com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.byazt.sdv.uc.hw(this);
        super.onCreate(bundle);
        this.qn = this;
        jw();
        pr(getIntent());
        hw(bundle);
        hw(getIntent());
        if (!pr(bundle)) {
            return;
        }
        cr();
        wt();
        bh();
        aj();
        this.qi.pr(this.bh, this.pj);
        setContentView(this.ve);
        x();
        this.qi.hw();
        com.byazt.xt.c cVar = this.nl;
        if (cVar != null) {
            cVar.pr(this.ag);
        }
        if (pq()) {
            this.na = new com.byazt.hf.x();
        }
        SaasAuthRewardDialog saasAuthRewardDialog = (SaasAuthRewardDialog) findViewById(2114387968);
        if (saasAuthRewardDialog != null) {
            saasAuthRewardDialog.pr(this.s, this.pr, iu() ? 7 : 5);
        }
        if (ww.hw(iu(), this.s, true)) {
            e().getSceneFrameContainer().post(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.22
                @Override // java.lang.Runnable
                public void run() {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, TTBaseVideoActivity.this.e().getSceneFrameContainer().getHeight(), 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setFillAfter(true);
                    TTBaseVideoActivity.this.e().getSceneFrameContainer().startAnimation(translateAnimation);
                }
            });
        }
        if (this.nl != null && com.byazt.ak.x.fw().hn()) {
            this.qx.pr(this.s);
            this.qx.pr(iu() ? n.hw() : n.hn());
            this.qx.pr(ie.hw(this.s));
            this.nl.pr(this.sv);
        }
    }

    public String pr() {
        return null;
    }

    private boolean pq() {
        if (this.s != null && com.byazt.eg.hw.pr().hw(this.s)) {
            String strNt = this.s.nt();
            if (TextUtils.isEmpty(strNt)) {
                return false;
            }
            try {
                return new JSONObject(strNt).optInt("saas_play_time_type") == 1;
            } catch (JSONException e) {
            }
        }
        return false;
    }

    private void jw() {
        this.ve = new RewardFullBaseLayout(this.qn);
        this.ww = new com.byazt.ax.c(this.qn);
        this.n = new com.byazt.ax.hw(this.qn);
        this.e = new com.byazt.ax.pr(this.qn);
        this.ls = new uc(this.qn);
        this.er = new x(this.qn);
        this.v = new com.byazt.ax.hn(this.qn);
    }

    public void hw() {
        finish();
    }

    public void hn() {
        this.ls.s();
        this.ls.pr(2);
        this.ls.aj();
        ho();
        uc(2);
    }

    public void onSkipBorderClick(View view) {
        this.qi.pr(view);
    }

    public boolean pr(Bundle bundle) {
        this.e.pr(this.s, this.pr, this.i);
        if (bundle != null) {
            this.e.pr();
        }
        com.byazt.sd.x.pr().hw(this.s);
        if (this.s == null) {
            ho.hw("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
            hw();
            return false;
        }
        return true;
    }

    private void wt() {
        com.byazt.lu.pr prVarPr = com.byazt.lu.x.pr(this.qn, this.s);
        this.qi = prVarPr;
        if (prVarPr == null) {
            ho.hw("TTBaseVideoActivity", "initAdType failed , finish activity");
            finish();
            return;
        }
        prVarPr.getClass().getSimpleName();
        if (!ww.hw(iu(), this.s, true)) {
            this.ny = this.s.ax() == 1;
        }
        this.qi.pr(this.ww, this.ls, this.n, this.er, this.e);
        hn hnVar = new hn(iu(), this.s, this.ls, this.qi);
        this.of = hnVar;
        hnVar.hw(this.pq);
        this.qi.pr(this.pr, this.ny, iu(), this.of);
        this.qi.zo();
    }

    private void aa() {
        if (this.s == null || this.ve == null) {
            return;
        }
        String strNt = this.s.nt();
        if (TextUtils.isEmpty(strNt)) {
            return;
        }
        try {
            int iOptInt = new JSONObject(strNt).optInt("auth_reward_gold");
            if (iOptInt > 0) {
                this.ve.addView(new RewardAuthToastLayout(this.qn, iOptInt));
            }
        } catch (JSONException e) {
        }
    }

    private void iy() {
        this.mr = new com.byazt.fu.pr() { // from class: com.byazt.cu.TTBaseVideoActivity.23
            @Override // com.byazt.fu.pr
            public void pr(String str, String str2) {
                if (TTBaseVideoActivity.this.s != null) {
                    String strNy = TTBaseVideoActivity.this.s.ny();
                    if (TextUtils.equals("show", str) && TextUtils.equals(str2, strNy)) {
                        TTBaseVideoActivity.this.jn.set(true);
                    }
                    if (TextUtils.equals("click", str) && TextUtils.equals(str2, strNy)) {
                        TTBaseVideoActivity.this.l.set(true);
                    }
                }
            }
        };
        com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny()).pr(this.mr);
    }

    public void x() {
        iy();
        this.ve.pr(this.qi);
        aa();
        this.gz = this.qi.pr(iu());
        this.nl = this.qi.k();
        this.y = this.qi.m();
        this.gz.pr();
        fw();
        this.gz.pr(this.ie, this.aa);
        this.gz.pr(this.e.fw());
        this.ww.pr(this.s, this.n, iu(), this.ie);
        this.ww.x(this.ny);
        if (this.e.hn()) {
            ((com.byazt.dl.pr) this.ie.pr(com.byazt.dl.pr.class)).pr(this.e.hw());
            this.e.pr(this.cr);
        }
        this.e.pr(this.iy);
        this.e.pr(this.ag);
        this.n.pr(this.ww, this.e, iu(), this.pr, this.bh, this.pj);
        this.n.pr(this.s, this.ie, this.ag.q_(), this.y);
        this.er.pr(this.n, this.s, this.pr, this.ww);
        this.v.pr(this.s, this.pr, this.gz.m());
        this.ls.pr(this.s);
        this.rk = new com.byazt.zp.pr();
        this.o = new com.byazt.uq.c(this.s, this.od);
        this.f = new com.byazt.on.hw(this.pr);
        this.bm = new com.byazt.tt.pr(this.s, this.qn);
    }

    public void c() {
        com.byazt.ax.hw hwVar;
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.lu.pr prVar = this.qi;
            if (prVar != null) {
                jSONObject.put("reward_full_scene_type", prVar.y());
            }
        } catch (Exception e) {
        }
        com.byazt.xk.hw.pr().pr(this.s, "stats_reward_full_show_endcard", jSONObject);
        if (isDestroyed() || isFinishing() || (hwVar = this.n) == null || hwVar.e()) {
            return;
        }
        if (!lb.x(this.s)) {
            this.n.x(true);
        }
        if (jn.yb(this.s)) {
            this.c.remove(1);
            of();
        }
        this.qi.z();
        if (this.qi instanceof com.byazt.lu.vk) {
            this.vj.hw(true);
            this.vj.uc();
        }
        if (!(this.qi instanceof fw) || !this.n.a() || (this.qi instanceof com.byazt.lu.zo)) {
            this.n.ny();
        }
        this.ww.pr(true);
        this.er.pr(this.ny);
        this.n.k();
        if ((this.qi instanceof fw) && this.n.gz()) {
            this.n.aj();
            return;
        }
        this.ww.pr(2);
        com.byazt.pfl.hw hwVar2 = this.hs;
        if (hwVar2 != null) {
            hwVar2.hw();
        }
        com.byazt.wv.hw.pr prVar2 = this.qv;
        if (prVar2 != null) {
            prVar2.c();
        }
        com.byazt.xt.hw hwVar3 = this.gz;
        if (hwVar3 != null) {
            hwVar3.c(8);
        }
        this.n.hn(false);
        if (this.n.yb()) {
            if (!qv.w(this.s) && !ny.hw(this.s)) {
                this.n.pr(true, 0, (String) null);
            }
            this.n.g();
            this.hw.sendEmptyMessageDelayed(500, 100L);
            return;
        }
        if (!qv.w(this.s)) {
            this.n.pr(false, TTAdConstant.INTERACTION_TYPE_CODE, "end_card_timeout");
        }
        this.n.c(true);
        this.ls.zo();
    }

    public void uc() {
        if (!this.qi.od()) {
            if (ny.fw(this.s)) {
                return;
            }
            hw(true, true);
        } else if (!hw(this.ls.uc(), false)) {
            pr(true, true);
        }
    }

    public boolean pr(long j, boolean z) {
        if (!this.ls.ny()) {
            return false;
        }
        if (!z || !this.ls.fo()) {
            pj();
        }
        boolean zPr = this.ls.pr(j, this.ny, this.qi.rc());
        if (zPr && !z) {
            if (ny.fw(this.s)) {
                return true;
            }
            hw(true, true);
        }
        return zPr;
    }

    public void fw() {
        c cVar = new c(this.qn, this.s, this.pr, iu() ? 7 : 5) { // from class: com.byazt.cu.TTBaseVideoActivity.24
            @Override // com.byazt.az.c, com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, vk vkVar) {
                if (TTBaseVideoActivity.this.s != null && TTBaseVideoActivity.this.s.rf() == 1 && TTBaseVideoActivity.this.nl != null) {
                    if (vkVar == null) {
                        vkVar = new vk();
                    }
                    vkVar.hw(TTBaseVideoActivity.this.nl.c() ? TTBaseVideoActivity.this.nl.aj() : (byte) 0);
                }
                super.pr(view, vkVar);
                com.byazt.ln.hw hwVar = (com.byazt.ln.hw) this.zo.pr(com.byazt.ln.hw.class);
                if (hwVar == null || !hwVar.hw(view)) {
                    return;
                }
                TTBaseVideoActivity.this.pr(2);
                TTBaseVideoActivity.this.e.pr(view, TTBaseVideoActivity.this.cr, vkVar);
            }
        };
        this.ie = cVar;
        if (this.j != 100.0f) {
            ((com.byazt.dl.pr) cVar.pr(com.byazt.dl.pr.class)).pr(this.ag);
        }
        pr((com.byazt.yx.hn) this.ie.pr(com.byazt.yx.hn.class));
        this.ie.pr(this.gz.m());
        ((com.byazt.yx.pr) this.ie.pr(com.byazt.yx.pr.class)).pr(ii());
        com.byazt.az.hw hwVar = new com.byazt.az.hw(this.qn, this.s, this.pr, iu() ? 7 : 5) { // from class: com.byazt.cu.TTBaseVideoActivity.2
            @Override // com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, vk vkVar) {
                TTBaseVideoActivity.this.v.pr(view, vkVar);
            }
        };
        this.aa = hwVar;
        pr((com.byazt.yx.hn) hwVar.pr(com.byazt.yx.hn.class));
        this.cr = new com.byazt.ax.pr.InterfaceC0021pr() { // from class: com.byazt.cu.TTBaseVideoActivity.3
            @Override // com.byazt.ax.pr.InterfaceC0021pr
            public void pr(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.v.pr(str, jSONObject);
            }

            @Override // com.byazt.ax.pr.InterfaceC0021pr
            public void pr(View view, vk vkVar) {
                TTBaseVideoActivity.this.v.pr(view, vkVar);
            }
        };
        this.iy = new com.byazt.ax.pr.hw() { // from class: com.byazt.cu.TTBaseVideoActivity.4
            @Override // com.byazt.ax.pr.hw
            public void pr(boolean z) {
                if (z) {
                    TTBaseVideoActivity.this.n.pr(1, 0);
                }
                TTBaseVideoActivity.this.pr("点击开始下载");
            }

            @Override // com.byazt.ax.pr.hw
            public void pr(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.n.pr(j2, j, 3);
                }
                if (j > 0) {
                    TTBaseVideoActivity.this.pr("已下载" + ((int) ((j2 * 100) / j)) + "%");
                }
            }

            @Override // com.byazt.ax.pr.hw
            public void hw(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.n.pr(j2, j, 2);
                }
                TTBaseVideoActivity.this.pr("下载暂停");
            }

            @Override // com.byazt.ax.pr.hw
            public void hn(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.n.pr(j2, j, 4);
                }
                TTBaseVideoActivity.this.pr("下载失败");
            }

            @Override // com.byazt.ax.pr.hw
            public void pr(boolean z, long j, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.n.pr(5, 100);
                }
                TTBaseVideoActivity.this.pr("点击安装");
            }

            @Override // com.byazt.ax.pr.hw
            public void pr(boolean z, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.n.pr(6, 100);
                }
                TTBaseVideoActivity.this.pr("点击打开");
            }
        };
        this.qi.pr(this.ie);
    }

    public void pr(final com.byazt.yx.hn hnVar) {
        hnVar.pr(new com.byazt.yx.hn.pr() { // from class: com.byazt.cu.TTBaseVideoActivity.5
            @Override // com.byazt.yx.hn.pr
            public boolean pr() {
                hnVar.pr(TTBaseVideoActivity.this.zo());
                hnVar.pr(TTBaseVideoActivity.this.pr);
                hnVar.pr(TTBaseVideoActivity.this.ey);
                return TTBaseVideoActivity.this.gu.get();
            }
        });
    }

    public Map<String, Object> zo() {
        Map<String, Object> mapIi = ii();
        if (this.z > 0) {
            mapIi.put("object_media_holder_time", Long.valueOf((System.currentTimeMillis() - this.z) / 1000));
        }
        com.byazt.lu.pr prVar = this.qi;
        if (prVar != null && prVar.uc() && this.nl != null) {
            com.byazt.qx.b.pr(mapIi, this.s, this.nl.k());
        }
        return mapIi;
    }

    public void pr(String str) {
        this.n.pr(str);
    }

    private void cr() {
        com.byazt.pj.pr.pr(this.s, getClass().getName());
        this.ii = ls.m(this.s);
        this.j = this.s.oq();
        this.qo = this.s.rf();
        jn.pr(this.s, false);
        jn.hw(this.s, false);
        com.byazt.hb.uc.hn = false;
        com.byazt.hb.uc.hw = 0;
        com.byazt.hb.uc.pr = 0;
        com.byazt.hb.uc.x = false;
    }

    public void aj() {
        float[] fArrPr = com.byazt.hf.hw.pr(this.qn.getApplicationContext(), this.j, this.qo);
        float f = fArrPr[0];
        float f2 = fArrPr[1];
        if (this.j == 100.0f) {
            this.bh = (int) f;
            this.pj = (int) f2;
            return;
        }
        int[] iArrPr = com.byazt.hf.hw.pr(this.qn.getApplicationContext(), this.j, this.s.ul(), this.qo);
        int i = iArrPr[0];
        int i2 = iArrPr[1];
        int i3 = iArrPr[2];
        int i4 = iArrPr[3];
        float f3 = i;
        float f4 = i3;
        this.bh = (int) ((f - f3) - f4);
        float f5 = i2;
        float f6 = i4;
        this.pj = (int) ((f2 - f5) - f6);
        if (ve.pr(this.s) && !com.byazt.dt.fw.pr(String.valueOf(this.ii))) {
            return;
        }
        try {
            this.ve.pr(er.hn(this.qn, f3), er.hn(this.qn, f5), er.hn(this.qn, f4), er.hn(this.qn, f6));
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (iu() && this.mw.hw()) {
            hw();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.n.m();
        com.byazt.zp.pr prVar = this.rk;
        if (prVar != null) {
            prVar.pr();
        }
        com.byazt.rd.hn.pr().pr(this, this.s, this.ny);
    }

    @Override // android.app.Activity
    public void onResume() {
        Bundle bundlePr;
        super.onResume();
        this.jw = System.currentTimeMillis();
        if (this.vj.c()) {
            hw();
            return;
        }
        com.byazt.tt.pr prVar = this.bm;
        if (prVar != null && prVar.x() && (bundlePr = com.byazt.tt.hw.pr().pr(this.ii)) != null) {
            pr(Math.round((bundlePr.getLong("foreground_time", 0L) / 1000) * jn.b(this.s)), true);
            com.byazt.tt.hw.pr().hw(this.ii);
            this.bm.hw(false);
        }
        com.byazt.hf.x xVar = this.na;
        if (xVar != null) {
            xVar.uc();
            int iPr = (int) this.na.pr(TimeUnit.SECONDS);
            pr(iPr, false);
            this.na.fw();
            if (this.nl != null && !jn.yb(this.s)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", iPr);
                } catch (JSONException e) {
                }
                this.nl.pr("reduceTime", jSONObject);
            }
        }
        this.fo = true;
        this.n.hn();
        this.e.x();
        com.byazt.lu.pr prVar2 = this.qi;
        if (prVar2 != null) {
            prVar2.hw(this.x.containsKey(0));
            of();
            this.er.pr();
            ey();
        }
        com.byazt.ei.x xVar2 = new com.byazt.ei.x();
        xVar2.pr = ww.pr(iu()) > 0;
        xVar2.hw = ww.pr(iu());
        pr(1, xVar2);
        this.hw.sendEmptyMessageDelayed(1300, this.of.aj());
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jw > 0) {
            this.wt += System.currentTimeMillis() - this.jw;
            this.jw = 0L;
        }
        com.byazt.tt.pr prVar = this.bm;
        if (prVar != null && prVar.hn()) {
            Bundle bundle = new Bundle();
            bundle.putLong("foreground_time", this.wt);
            com.byazt.tt.hw.pr().pr(this.ii, bundle);
        }
        qn();
        this.fo = false;
        com.byazt.lu.pr prVar2 = this.qi;
        if (prVar2 != null) {
            prVar2.g();
        }
        this.e.c();
        this.n.c();
        com.byazt.hf.x xVar = this.na;
        if (xVar != null) {
            xVar.c();
        }
        this.hw.removeMessages(1300);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.byazt.lu.pr prVar = this.qi;
        if (prVar != null) {
            prVar.hn(this.uc.get());
        }
        this.n.uc();
        com.byazt.zp.pr prVar2 = this.rk;
        if (prVar2 != null) {
            prVar2.hw();
        }
        com.byazt.rd.hn.pr().hw((Context) this, this.s, false);
    }

    @Override // com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.byazt.lu.pr prVar = this.qi;
        if (prVar != null) {
            prVar.nt();
        }
        if (!j()) {
            this.v.c().pr(16);
        }
        com.byazt.pfl.hw hwVar = this.hs;
        if (hwVar != null) {
            hwVar.hw();
        }
        qo();
        com.byazt.lg.pr.pr(com.byazt.sd.zo.nt().ny()).hw(this.mr);
        com.byazt.hf.x xVar = this.na;
        if (xVar != null) {
            xVar.zo();
        }
    }

    private boolean j() {
        com.byazt.lu.pr prVar = this.qi;
        if (prVar instanceof com.byazt.lu.vk) {
            return true;
        }
        return prVar instanceof com.byazt.lu.hn;
    }

    private void qo() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.lu.pr prVar = this.qi;
            if (prVar != null) {
                jSONObject.put("reward_full_scene_type", prVar.y());
            }
        } catch (Exception e) {
        }
        com.byazt.xk.hw.pr().pr(this.s, "stats_reward_full_destroy", jSONObject);
        com.byazt.hb.uc.hn = false;
        com.byazt.hb.uc.hw = 0;
        com.byazt.hb.uc.pr = 0;
        com.byazt.hb.uc.x = false;
        this.hw.removeCallbacksAndMessages(null);
        this.ls.rc();
        this.e.uc();
        this.n.fw();
        com.byazt.uq.c cVar = this.o;
        if (cVar != null) {
            cVar.hw();
        }
        hn(true);
        ve();
        pr("recycleRes", (Bundle) null);
        if (this.s != null) {
            com.byazt.son.pr.pr(this.s.cz());
            cz.pr(this.s.cz());
            cz.pr(this.s.le());
            e.hw(this.s.nl());
            try {
                com.byazt.at.x.pr().pr(this.s.cz());
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("multi_process_key", this.i);
            bundle.putBoolean("is_preload", this.rc);
            bundle.putLong("object_create_ts", this.z);
            bundle.putBoolean("is_adm", this.b);
            bundle.putInt("key_video_cache_callback", this.iu);
            bundle.putLong("video_current", this.ls.nt());
            bundle.putBoolean("is_mute", this.ny);
            bundle.putString("rit_scene", this.r);
            Double d = this.ey;
            bundle.putString("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
        } catch (Throwable th) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.byazt.on.hw hwVar = this.f;
        if (hwVar != null) {
            hwVar.pr(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.s == null) {
            return;
        }
        if (of.x(this.s) || this.s.ej() == 1 || (this.qi instanceof com.byazt.lu.zo)) {
            this.n.nt();
        }
        com.byazt.on.hw hwVar = this.f;
        if ((hwVar == null || !hwVar.hw(this.qn, this.s)) && lb.m(this.s)) {
            vk();
        }
    }

    public void vk() {
        if (this.n.ho()) {
            this.n.nt();
            return;
        }
        if (!this.n.b() && !w.c(this.s) && !w.x(this.s)) {
            hw();
            return;
        }
        com.byazt.wv.vk vkVar = new com.byazt.wv.vk() { // from class: com.byazt.cu.TTBaseVideoActivity.6
            @Override // com.byazt.wv.vk
            public void pr() {
                if (lb.m(TTBaseVideoActivity.this.s)) {
                    com.byazt.pj.pr.pr(TTBaseVideoActivity.this.s, "rewarded_video", "popup_play", (com.byazt.ttf.pr) null);
                    if (!w.c(TTBaseVideoActivity.this.s) && !w.x(TTBaseVideoActivity.this.s)) {
                        TTBaseVideoActivity.this.hw("onClickModalCallback");
                    }
                }
            }

            @Override // com.byazt.wv.vk
            public void hw() {
                if (lb.m(TTBaseVideoActivity.this.s)) {
                    com.byazt.pj.pr.pr(TTBaseVideoActivity.this.s, "rewarded_video", "popup_cancel", (com.byazt.ttf.pr) null);
                    TTBaseVideoActivity.this.ho();
                    TTBaseVideoActivity.this.hw();
                }
            }
        };
        if (w.c(this.s) || w.x(this.s)) {
            pr(vkVar);
        } else {
            hw(vkVar);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!j()) {
            this.v.c().pr(1.0f, z ? 12 : 13);
        }
    }

    private void pr(com.byazt.wv.vk vkVar) {
        int iEr = this.qi.er();
        TTBaseVideoActivity tTBaseVideoActivity = this.qn;
        if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
            this.qn.getIntent().putExtra("remainTime", iEr);
        }
        if (iEr > 0) {
            if (pr(this.s, vkVar)) {
                return;
            }
            vkVar.hw();
            return;
        }
        hw();
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [com.byazt.cu.TTBaseVideoActivity$8] */
    private void hw(final com.byazt.wv.vk vkVar) {
        final boolean[] zArr = {false};
        com.byazt.izk.hw.pr(new com.byazt.izk.hw.pr() { // from class: com.byazt.cu.TTBaseVideoActivity.7
            @Override // com.byazt.izk.hw.pr
            public void pr() {
                zArr[0] = true;
                vkVar.hw();
            }

            @Override // com.byazt.izk.hw.pr
            public void pr(int i) {
                zArr[0] = true;
                if (TTBaseVideoActivity.this.qn != null && TTBaseVideoActivity.this.qn.getIntent() != null) {
                    TTBaseVideoActivity.this.qn.getIntent().putExtra("remainTime", i);
                }
                if (i > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    if (tTBaseVideoActivity.pr(tTBaseVideoActivity.s, vkVar)) {
                        return;
                    }
                }
                vkVar.hw();
            }
        });
        hw("onClickBrowseClose");
        new CountDownTimer(1000L, 1000L) { // from class: com.byazt.cu.TTBaseVideoActivity.8
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (!zArr[0]) {
                    TTBaseVideoActivity.this.hw();
                }
            }
        }.start();
    }

    public void hw(String str) {
        nl nlVarIu = this.n.iu();
        if (nlVarIu == null || isFinishing()) {
            hw();
            return;
        }
        try {
            nlVarIu.hn(str, null);
        } catch (Exception e) {
            hw();
        }
    }

    public boolean pr(of ofVar, com.byazt.wv.vk vkVar) {
        return pr(ofVar, vkVar, false);
    }

    public boolean hw(of ofVar, com.byazt.wv.vk vkVar) {
        return pr(ofVar, vkVar, true);
    }

    private boolean pr(of ofVar, final com.byazt.wv.vk vkVar, boolean z) {
        if (!iu() || !this.s.rr() || this.x.containsKey(0) || isFinishing()) {
            return false;
        }
        if (System.currentTimeMillis() - this.u < 1000) {
            return true;
        }
        this.u = System.currentTimeMillis();
        com.byazt.wv.vk vkVar2 = new com.byazt.wv.vk() { // from class: com.byazt.cu.TTBaseVideoActivity.9
            @Override // com.byazt.wv.vk
            public void pr() {
                com.byazt.wv.vk vkVar3 = vkVar;
                if (vkVar3 != null) {
                    vkVar3.pr();
                }
                TTBaseVideoActivity.this.v.pr("reward_retain_dialog_cancel", TTBaseVideoActivity.this.qv.pr(), TTBaseVideoActivity.this.qv.hw());
            }

            @Override // com.byazt.wv.vk
            public void hw() {
                TTBaseVideoActivity.this.m.set(true);
                com.byazt.wv.vk vkVar3 = vkVar;
                if (vkVar3 != null) {
                    vkVar3.hw();
                }
                TTBaseVideoActivity.this.v.pr("reward_retain_dialog_skip", TTBaseVideoActivity.this.qv.pr(), TTBaseVideoActivity.this.qv.hw());
            }

            @Override // com.byazt.wv.vk
            public void pr(int i) {
                TTBaseVideoActivity.this.pr(i, true);
                TTBaseVideoActivity.this.ww.hw("恭喜您，可提前" + i + "s获得奖励～");
            }

            @Override // com.byazt.wv.vk
            public void hn() {
            }
        };
        if (z) {
            this.qv = this.qi.pr(ofVar, vkVar2, true);
        } else {
            this.qv = this.qi.pr(ofVar, vkVar2);
        }
        this.v.pr("reward_retain_dialog_show", this.qv.pr(), this.qv.hw());
        return this.qv.hn();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        er.hw((Activity) this.qn);
        try {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.byazt.cu.TTBaseVideoActivity.10
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        if (TTBaseVideoActivity.this.f != null) {
                            TTBaseVideoActivity.this.f.pr();
                        }
                        try {
                            if (!TTBaseVideoActivity.this.isFinishing()) {
                                if (TTBaseVideoActivity.this.qo == 2) {
                                    TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.10.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            er.pr((Activity) TTBaseVideoActivity.this.qn);
                                        }
                                    }, 2500L);
                                } else {
                                    TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.10.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            er.hw((Activity) TTBaseVideoActivity.this.qn);
                                        }
                                    }, 500L);
                                }
                            }
                        } catch (Throwable th) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.rg.BaseThemeActivity
    public boolean w() {
        return false;
    }

    private void bh() {
        if (this.s != null && w()) {
            return;
        }
        final int iVh = a.hw().vh();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(16777216);
            getWindow().addFlags(128);
            a.pr(this.qn);
            if (!this.qi.i()) {
                getWindow().addFlags(1024);
                if (iVh == 1) {
                    if (Build.VERSION.SDK_INT >= 30) {
                        getWindow().setDecorFitsSystemWindows(true);
                    }
                    getWindow().getDecorView().setFitsSystemWindows(true);
                }
            }
        } catch (Throwable th) {
        }
        if (iVh == 1) {
            return;
        }
        final View decorView = null;
        try {
            decorView = getWindow().getDecorView();
        } catch (Throwable th2) {
        }
        if (decorView == null) {
            return;
        }
        decorView.post(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (er.hw() && TTBaseVideoActivity.this.qo == 1 && TTBaseVideoActivity.this.qn.getResources().getConfiguration().orientation == 1) {
                        int height = TTBaseVideoActivity.this.getWindow().getDecorView().getHeight();
                        if (iVh == 1) {
                            Rect rect = new Rect();
                            TTBaseVideoActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            height = rect.bottom - rect.top;
                        }
                        if (Math.abs(er.aj((Context) TTBaseVideoActivity.this.qn) - height) == 0 && decorView.isAttachedToWindow()) {
                            View view = decorView;
                            view.setPadding(view.getPaddingLeft(), (int) (decorView.getPaddingTop() + er.w((Context) TTBaseVideoActivity.this.qn)), decorView.getPaddingRight(), decorView.getPaddingBottom());
                        }
                    }
                } catch (Throwable th3) {
                }
            }
        });
    }

    @Override // com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void finish() {
        com.byazt.lu.pr prVar = this.qi;
        if (prVar != null) {
            prVar.ho();
        }
        Map<String, Object> mapIi = ii();
        com.byazt.ax.hw hwVar = this.n;
        if (hwVar != null) {
            hwVar.pr(mapIi);
            this.n.c();
        }
        com.byazt.lu.pr prVar2 = this.qi;
        if (prVar2 != null) {
            prVar2.hw(mapIi);
        }
        com.byazt.pj.pr.uc(this.s, this.pr, "click_close", mapIi);
        ve();
        super.finish();
    }

    public void k() {
        if (!this.qi.od()) {
            return;
        }
        this.ls.pr(3);
        this.ls.qa();
        this.ls.hn(true);
        pr(false, false);
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        int i = message.what;
        switch (message.what) {
            case TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX /* 300 */:
                k();
                break;
            case 400:
                this.ls.aj();
                if (this.qi.uc()) {
                    this.nl.pr(true);
                }
                pr(false, true);
                break;
            case 500:
                this.n.zo();
                this.ls.zo();
                this.gz.hn(false);
                this.nl.x(false);
                this.nl.hn(false);
                break;
            case 600:
                this.ww.pr(false, null, null, true, true);
                break;
            case 700:
                this.n.ww();
                break;
            case ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR /* 1200 */:
                if (!jn.yb(this.s)) {
                    if (this.n.nl()) {
                        pr(1, false);
                        this.er.pr(v(), this.qi.er());
                        hn(0);
                    }
                    this.hw.sendEmptyMessageDelayed(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, 1000L);
                    break;
                }
                break;
            case 1300:
                this.hw.sendEmptyMessageDelayed(1300, this.of.aj());
                if (!z()) {
                    this.of.zo();
                    if (!l()) {
                        this.of.fw();
                        if (bm().zo(true)) {
                            this.ls.hw(((long) this.of.c()) * 1000);
                            this.nl.pr(String.valueOf(Math.max(0, (int) (this.ls.iu() - ((double) this.of.c())))), this.of.c(), 0, false);
                        }
                    }
                    com.byazt.ei.x xVar = new com.byazt.ei.x();
                    if (ww.hw(iu()) > 0) {
                        int iC = ww.c(this.s) / 1000;
                        int iHw = ww.hw(iu());
                        if (iC < iHw) {
                            iHw = iC;
                        }
                        if (iC - iHw <= this.qi.ve()) {
                            xVar.pr = true;
                            xVar.hw = iHw;
                        }
                    }
                    pr(2, xVar);
                    com.byazt.ei.x xVar2 = new com.byazt.ei.x();
                    xVar2.pr = true;
                    pr(3, xVar2);
                    this.vj.fw();
                    this.qi.bm();
                    break;
                }
                break;
        }
    }

    public void hw(int i) {
        if (i <= 0) {
            this.ww.pr(false, null, null, true, true);
        } else {
            this.hw.sendEmptyMessageDelayed(600, i);
        }
    }

    public void m() {
        com.byazt.xk.hw.pr().pr(this.s, "stats_reward_full_completed", this.v.pr(new JSONObject()));
        if (!this.vk.getAndSet(true)) {
            pr("onVideoComplete", (Bundle) null);
        }
    }

    public void g() {
        if (!this.aj.getAndSet(true)) {
            pr("onVideoError", (Bundle) null);
        }
    }

    public void ho() {
        if (!this.vk.get() && !this.zo.getAndSet(true)) {
            pr("onSkippedVideo", (Bundle) null);
        }
    }

    public void nt() {
        this.hw.removeMessages(700);
        this.hw.removeMessages(600);
    }

    public void pr(long j) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 700;
        this.hw.sendMessageDelayed(messageObtain, j);
    }

    public void hn(int i) {
    }

    public void x(int i) {
    }

    @Override // com.byazt.hb.hw
    public void pr(boolean z) {
        if (z) {
            if (this.nl.c()) {
                return;
            }
            this.qi.x(true);
            return;
        }
        if (this.nl.c() && this.ls.ww() != null) {
            this.ls.ww().pr(8);
        }
        this.qi.x(false);
        if (!this.nl.c() && this.qo != 2 && com.byazt.lpk.pr.pr(this.s)) {
            this.gz.uc(8);
        }
    }

    public void hw(boolean z) {
        Message message = new Message();
        message.what = 400;
        this.hw.sendMessageDelayed(message, z ? 2000L : 0L);
    }

    public void yb() {
        this.hw.removeMessages(400);
    }

    private void pj() {
        if (this.n.e() || !this.fo || l() || !this.qi.od() || this.ls.ls()) {
            return;
        }
        com.byazt.lu.pr prVar = this.qi;
        if ((prVar instanceof com.byazt.lu.hn) || (prVar instanceof com.byazt.lu.vk)) {
            return;
        }
        this.hw.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
        this.hw.sendEmptyMessageDelayed(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, 5000L);
    }

    public int c(int i) {
        boolean z = i == 2;
        switch (this.s.sq()) {
            case 1:
                return 1;
            case 2:
            default:
                return 2;
            case 3:
                return z ? 1 : 2;
            case 4:
            case 5:
                return z ? 1 : 3;
            case 6:
                return z ? 1 : 4;
            case 7:
                return (z && this.m.get()) ? 1 : 2;
        }
    }

    public void uc(int i) {
        int iC = c(i);
        if (i != 2) {
            if (this.er.x()) {
            }
            if (this.ls.k() && i == 1) {
                this.ls.vk();
                return;
            }
            if (jn.yb(this.s)) {
                if (this.w.get() && !this.k.get()) {
                    if (iC == 1 && !this.x.containsKey(0) && iu()) {
                        this.ww.hw((this.s.aj() == 3 && jn.lb(this.s)) ? "奖励就快来了\n去详情页看看也累计时长哦～" : "奖励还在路上狂奔\n再等一下下哦～");
                    }
                    this.ls.er();
                }
                if (!this.w.get() && this.k.get()) {
                    return;
                }
                if (iC == 1 && (!this.w.get() || !this.k.get())) {
                    return;
                }
            }
        }
        switch (iC) {
            case 1:
                hw();
                break;
            case 2:
                if (this.fw.get()) {
                    this.n.ny();
                }
                c();
                break;
            case 3:
                this.ls.er();
                break;
            case 4:
                if (i != 3) {
                    lb();
                }
                break;
        }
    }

    public void lb() {
        this.ls.vk();
    }

    public void pr(boolean z, boolean z2) {
        this.ls.hw(z2);
        g();
        if (z) {
            this.g.set(true);
            if (jn.yb(this.s)) {
                this.qi.nl();
            }
            this.ww.pr(false, null, null, true, true);
            c();
            return;
        }
        if (jn.cz(this.s)) {
            this.n.er();
        } else {
            this.ww.pr(false, null, null, true, true);
            x(0);
        }
        if (!this.ls.ls()) {
            if (jn.yb(this.s)) {
                this.qi.nl();
            }
            c();
        }
    }

    public void qa() {
        c();
    }

    public byte a() {
        com.byazt.xt.c cVar = this.nl;
        if (cVar != null) {
            return cVar.aj();
        }
        return (byte) 0;
    }

    public void cz() {
        com.byazt.xt.c cVar;
        if (this.o == null || (cVar = this.nl) == null || cVar.k() == null) {
            return;
        }
        this.nl.k().setEasyPlayableSender(this.o.pr());
        this.o.pr(this.nl.k().getEasyPlayableLayout(), null);
    }

    public void fw(int i) {
        this.ve.pr(i);
    }

    public boolean ny() {
        com.byazt.pfl.hw hwVar = this.hs;
        if (hwVar != null) {
            return hwVar.hn();
        }
        return false;
    }

    public void hn(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.hs == null) {
            this.hs = new com.byazt.pfl.hw(this.qn, this.s.ae(), this.pr, true, com.byazt.ub.hw.pr());
            com.byazt.pw.hn.pr(this.qn, this.s, this.hs);
            this.hs.pr(new com.byazt.pfl.hw.pr() { // from class: com.byazt.cu.TTBaseVideoActivity.13
                @Override // com.byazt.pfl.hw.pr
                public void pr() {
                    TTBaseVideoActivity.this.qn();
                }

                @Override // com.byazt.pfl.hw.pr
                public void pr(int i, String str2, boolean z) {
                    TTBaseVideoActivity.this.hw.post(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TTBaseVideoActivity.this.of();
                        }
                    });
                }

                @Override // com.byazt.pfl.hw.pr
                public void hw() {
                    TTBaseVideoActivity.this.of();
                }
            });
        }
        this.hs.pr(str);
        this.hs.pr();
    }

    public void fo() {
        this.ww.pr(1);
        if (!jn.yb(this.s)) {
            this.ww.pr(false, null, null, true, true);
        }
        this.ww.pr(true);
        this.ww.c(true);
        this.ww.uc(false);
        this.ww.hw(this.s.zz());
        this.er.pr(this.ny, this.x.containsKey(0));
        this.hw.sendEmptyMessage(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 1);
            this.nl.pr("playableStateChange", jSONObject);
        } catch (Exception e) {
        }
    }

    public void rc() {
        this.er.hn();
        this.n.s();
        this.ww.pr(1);
        this.hw.removeMessages(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 0);
            if (iu()) {
                jSONObject.put("reduce_duration", this.qi.hs());
            }
            this.nl.pr("playableStateChange", jSONObject);
        } catch (Exception e) {
        }
        if (!this.vj.pr(1)) {
            this.ho.set(true);
        }
        pr(1, (com.byazt.ei.x) null);
    }

    public boolean z() {
        return qv() || ny() || this.qi.ww() || this.np;
    }

    public void zo(int i) {
    }

    public void aj(int i) {
        if (this.bm == null) {
            return;
        }
        com.byazt.qe.hw hwVarPr = com.byazt.bv.pr.pr().pr(this.s, ls.pr(this.s, ""));
        this.bm.hw(true);
        this.bm.pr(i, hwVarPr);
    }

    public void pr(int i, com.byazt.ei.x xVar) {
        if (ny.hn(this.s) || this.m.get() || this.aj.get()) {
            return;
        }
        int iVk = 0;
        if (i == 1) {
            if (!this.ho.get()) {
                return;
            }
            if (xVar == null || !xVar.pr) {
                this.ho.set(false);
            }
        }
        int iPr = this.vj.pr(i, xVar != null && xVar.x);
        if (iPr == 0) {
            return;
        }
        if (iPr == 3 && xVar != null && xVar.hn) {
            iVk = ww.vk();
        }
        this.vj.pr(new com.byazt.ei.hn.pr().pr(this.i).pr(this.qi.er()).hw(iVk).pr(this.vk.get()).pr(this.x.keySet()).hw(this.ny).pr(this.mw).hn(iPr).x(this.qi.ve()).hn(this.vj.x() ? this.d : of.hn(this.s)).pr(), iPr, xVar);
    }

    public boolean b() {
        if (z() || this.ls.ls()) {
            return false;
        }
        com.byazt.lu.pr prVar = this.qi;
        if ((prVar != null && !prVar.od()) || this.er.x() || this.n.e()) {
            return false;
        }
        if (!this.ls.ny()) {
            return true;
        }
        if ((!this.ls.hn() && !this.ls.hw()) || this.ls.hw()) {
            return false;
        }
        this.ls.hn();
        return true;
    }

    private void ey() {
        final View decorView;
        try {
            decorView = getWindow().getDecorView();
        } catch (Throwable th) {
            decorView = null;
        }
        if (decorView == null) {
            return;
        }
        decorView.post(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception e) {
                }
            }
        });
        decorView.postDelayed(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception e) {
                }
            }
        }, 300L);
    }

    @Override // com.byazt.hb.hw
    public void pr(int i) {
        this.qa.set(true);
        if (System.currentTimeMillis() - this.eh > 50) {
            this.eh = System.currentTimeMillis();
            pr("onAdVideoBarClick", (Bundle) null);
        }
        if (!isFinishing()) {
            zo.pr(this.nl.k());
        }
        if (!this.uc.get()) {
            this.uc.set(true);
        }
        if (!this.vj.pr(1)) {
            this.ho.set(true);
        }
        hn(0);
        vk(i);
    }

    public void vk(int i) {
        com.byazt.ga.hw hwVarS;
        com.byazt.xt.c cVar;
        com.byazt.lu.pr prVar = this.qi;
        if ((prVar instanceof com.byazt.lu.zo) && (hwVarS = prVar.s()) != null && hwVarS.w() == 1 && i == 1) {
            if (this.fe.getAndSet(false)) {
                int iA = ((g) com.byazt.zs.uc.pr("device_info_new")).a();
                float fFw = er.fw(a.getContext());
                float fZo = er.zo(a.getContext());
                Map<String, Object> mapIi = ii();
                mapIi.putAll(hwVarS.fw());
                aj.pr prVarHw = new aj.pr().uc(-1.0f).c(-1.0f).x(-1.0f).hn(-1.0f).hw(-1L).pr(-1L).x(-1).c(-1).uc(-1024).hn(com.byazt.sd.zo.nt().hw() ? 1 : 2).hw(iA).pr(fFw).hw(fZo);
                if (this.s != null && this.s.rf() == 1 && (cVar = this.nl) != null) {
                    prVarHw.pr(cVar.c() ? this.nl.aj() : (byte) 0);
                }
                prVarHw.pr(com.byazt.ri.c.hw(this.s));
                com.byazt.pj.pr.pr("click", this.s, prVarHw.pr(), this.pr, true, mapIi, -1, false, false);
            }
        }
    }

    public void hw(boolean z, boolean z2) {
        if (z) {
            Map<String, Object> mapZo = zo();
            this.gu.set(true);
            mapZo.put("is_adm", Boolean.valueOf(this.b));
            mapZo.put("is_play_again", Boolean.valueOf(gz()));
            mapZo.put("if_cache_callback", Integer.valueOf(this.iu == 1 ? 1 : 0));
            mapZo.put("src_req_id", this.s.nb());
            mapZo.put("is_map", Boolean.valueOf(this.s.gd()));
            mapZo.put("is_repeat", Boolean.valueOf(this.lb.getAndSet(true)));
            com.byazt.pj.pr.pr(this.s, this.pr, mapZo, this.ey);
            this.v.c().pr(1.0f, 11);
            com.byazt.na.pr.pr().x();
            e.pr(this.s.nl());
        }
        if (z2) {
            if (!ww.hw(iu(), this.s, true)) {
                boolean zMo = a.hw().mo();
                if (!this.yb.getAndSet(true) || zMo) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("has_show_event", this.gu.get());
                    pr("onAdShow", bundle);
                } else {
                    com.byazt.xk.hw.pr().x(this.s, "stats_callback_repeat");
                }
            }
            if (this.qi.uc()) {
                this.nl.uc();
            }
            com.byazt.uq.c cVar = this.o;
            if (cVar != null && cVar.pr() != null) {
                this.o.pr().x();
            }
            if (this.s.b() && this.s.g() != null) {
                com.byazt.yq.pr.pr().pr(getApplicationContext(), this.s.g().hw());
            }
        }
        hn(false);
    }

    private boolean qv() {
        com.byazt.wv.hw.pr prVar = this.qv;
        return prVar != null && prVar.x();
    }

    public boolean hw(long j, boolean z) {
        this.ls.pr(this.ie);
        this.ls.pr(this.qi.qa(), iu());
        this.ls.hw(zo());
        if (this.qi.uc()) {
            this.nl.pr(this.ls.e());
        }
        this.ls.pr(this.lv);
        boolean zPr = pr(j, z);
        if (zPr && !z) {
            this.nw = (int) (System.currentTimeMillis() / 1000);
        }
        return zPr;
    }

    public boolean gz() {
        return false;
    }

    public int nl() {
        return 0;
    }

    public String y() {
        return "";
    }

    public String ww() {
        return "";
    }

    public String n() {
        return "";
    }

    public RewardFullBaseLayout e() {
        return this.ve;
    }

    public void pr(Intent intent) {
        if (intent != null) {
            this.r = intent.getStringExtra("rit_scene");
            this.rc = intent.getBooleanExtra("is_preload", false);
            this.z = intent.getLongExtra("object_create_ts", 0L);
            this.b = intent.getBooleanExtra("is_adm", false);
            this.i = intent.getStringExtra("multi_process_key");
            this.iu = intent.getIntExtra("key_video_cache_callback", -1);
            String stringExtra = intent.getStringExtra("_client_bidding_aution_price");
            this.ey = TextUtils.isEmpty(stringExtra) ? null : Double.valueOf(Double.parseDouble(stringExtra));
            com.byazt.tt.pr prVar = this.bm;
            if (prVar != null) {
                prVar.pr(intent.getBooleanExtra("is_second_page", false));
            }
        }
    }

    public void hw(Bundle bundle) {
        if (bundle != null) {
            this.i = bundle.getString("multi_process_key");
            this.rc = bundle.getBoolean("is_preload");
            this.z = bundle.getLong("object_create_ts");
            this.b = bundle.getBoolean("is_adm");
            this.iu = bundle.getInt("key_video_cache_callback", -1);
            this.r = bundle.getString("rit_scene");
            String string = bundle.getString("_client_bidding_aution_price");
            this.ey = TextUtils.isEmpty(string) ? null : Double.valueOf(Double.parseDouble(string));
            this.ny = bundle.getBoolean("is_mute");
            long j = bundle.getLong("video_current");
            if (j > 0) {
                this.ls.pr(j);
            }
        }
    }

    public void hw(Intent intent) {
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("insert_ad_bundle"))) {
            com.byazt.ei.hn hnVar = new com.byazt.ei.hn(intent.getStringExtra("insert_ad_bundle"));
            this.i = hnVar.pr();
            if (ww.pr(this.s) == 1) {
                this.pq = hnVar.vk();
            }
            this.d = hnVar.w();
            this.vk.set(hnVar.x());
            this.x.putAll(hnVar.zo());
            this.vj.pr(hnVar);
            this.ny = hnVar.c();
            this.mw.hn(hnVar.uc());
        }
    }

    public void s() {
        boolean z = !this.ny;
        this.ny = z;
        this.qi.c(z);
    }

    public void ls() {
        this.er.hw();
    }

    public iu er() {
        return this.hw;
    }

    public void pr(int i, boolean z) {
        k(i);
        if (z) {
            w(i);
        }
    }

    public void w(int i) {
        if (this.nl != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", i);
            } catch (JSONException e) {
            }
            this.nl.pr("reduceTime", jSONObject);
        }
    }

    public void k(int i) {
        this.qi.hn(i);
        hn(0);
    }

    public int v() {
        return Math.max(this.qi.nw() - (((int) (this.ls.gz() / 1000)) + this.qi.hs()), 0);
    }

    public void m(int i) {
        this.gz.c(i);
    }

    public void qi() {
        this.hw.removeMessages(600);
    }

    public void pr(float f, float f2, float f3, float f4, int i) {
        com.byazt.xt.c cVar = this.nl;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        int measuredWidth = this.nl.pr().getMeasuredWidth();
        int measuredHeight = this.nl.pr().getMeasuredHeight();
        boolean zIi = false;
        if (this.ls.e() instanceof com.byazt.ga.pr) {
            zIi = ((com.byazt.ga.pr) this.ls.e()).ii();
        }
        if (zIi) {
            this.nl.pr().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i);
            this.nl.pr().startAnimation(scaleAnimation);
        }
    }

    public void g(int i) {
        com.byazt.lu.pr prVar;
        com.byazt.xt.c cVar;
        if (this.ls.hw()) {
            HashMap map = new HashMap();
            map.put("pause_from", Integer.valueOf(i));
            this.ls.pr(map);
        }
        this.hw.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
        this.hw.removeMessages(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        nt(i);
        if ((l() && jn.yb(this.s) && this.er.x()) || (prVar = this.qi) == null) {
            return;
        }
        prVar.ny();
        this.n.hw(l());
        if (i != 1 && (cVar = this.nl) != null) {
            cVar.c(z());
        }
    }

    public void qn() {
        g(0);
    }

    public void of() {
        ho(0);
    }

    public void ho(int i) {
        com.byazt.xt.c cVar;
        yb(i);
        if (this.qi instanceof com.byazt.lu.zo) {
            this.hw.postDelayed(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.u();
                }
            }, 500L);
        } else {
            u();
        }
        if (!z()) {
            if (this.n.nl()) {
                this.hw.sendEmptyMessageDelayed(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, 1000L);
            }
            if (!l() || this.n.e() || this.n.nl()) {
                this.qi.fo();
            }
            this.n.x();
        }
        if (i != 1 && (cVar = this.nl) != null) {
            cVar.c(z());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (b()) {
            pj();
            this.ls.pr(false, this);
        }
    }

    public Map<String, Object> ii() {
        return pr(this.s);
    }

    public Map<String, Object> pr(of ofVar) {
        HashMap map = new HashMap();
        String str = this.r;
        if (str != null) {
            map.put("rit_scene", str);
        }
        map.put("insert_ad_control", Integer.valueOf(ww.pr(ofVar)));
        map.put("carousel_pos", Integer.valueOf(ww.x(ofVar)));
        map.put("refresh_ad_control", Integer.valueOf(ww.hw(ofVar)));
        if (this.vj.hw() != 0) {
            map.put("carousel_type", Integer.valueOf(this.vj.hw()));
        } else if (o.zo(ofVar)) {
            map.put("carousel_type", 4);
        }
        com.byazt.ax.hn hnVar = this.v;
        if (hnVar != null) {
            hnVar.pr(map);
        }
        return map;
    }

    public Double i() {
        return this.ey;
    }

    public void pr(of ofVar, com.byazt.az.hw hwVar) {
        this.n.pr(ofVar, hwVar);
        this.er.pr(ofVar);
    }

    public void r() {
    }

    public void hs() {
        if (!this.w.getAndSet(true)) {
            uc(1);
        }
    }

    public void nw() {
        if (!this.k.getAndSet(true)) {
            uc(3);
        }
    }

    public boolean ie() {
        return this.er.x() || this.n.e() || !jn.hn(this.s, this.qi.fw());
    }

    public uc o() {
        return this.ls;
    }

    public com.byazt.ax.hn f() {
        return this.v;
    }

    public com.byazt.lu.pr bm() {
        return this.qi;
    }

    public boolean jn() {
        return this.x.containsKey(0);
    }

    public boolean l() {
        com.byazt.lu.pr prVar = this.qi;
        return (prVar != null && prVar.wt()) || !this.c.isEmpty();
    }

    public void nt(int i) {
        if (i == 0) {
            return;
        }
        this.c.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public void yb(int i) {
        if (i == 0) {
            return;
        }
        this.c.remove(Integer.valueOf(i));
    }

    public void lv() {
        this.ww.uc();
    }

    public void od() {
        this.qa.set(true);
    }

    public void pr(final int i, final int i2) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.cu.TTBaseVideoActivity.17
            @Override // java.lang.Runnable
            public void run() {
                if (i == 0) {
                    TTBaseVideoActivity.this.vj.hn();
                }
                if (i == 1) {
                    switch (i2) {
                        case 1:
                            TTBaseVideoActivity.this.m();
                            break;
                        case 2:
                            TTBaseVideoActivity.this.uc(1);
                            break;
                    }
                }
                if (i == 2) {
                    switch (i2) {
                        case 1:
                        case 2:
                            TTBaseVideoActivity.this.cz.set(false);
                            break;
                        default:
                            TTBaseVideoActivity.this.cz.set(true);
                            break;
                    }
                }
            }
        });
    }

    public void vj() {
        if (!this.ls.y() && !this.ls.k()) {
            np();
        }
        uc(1);
    }

    private void np() {
        if (lb.x(this.s)) {
            this.ls.er();
            return;
        }
        m();
        if (!jn.yb(this.s) && !this.qi.zo(false)) {
            hn(0);
            this.ww.pr(false, null, null, true, true);
        } else {
            hs();
        }
        if (jn.fw(this.s) && this.ls.a() >= jn.vk(this.s)) {
            hn(2);
        }
        this.qi.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eh() {
        return (this.s.jg() == 180 && jn.yb(this.s) && k.pr(this.s) && this.nl.zo() == 7) ? false : true;
    }

    public void hw(int i, int i2) {
        this.vj.pr(i, i2, 0);
    }

    public void pr(int i, int i2, int i3) {
        this.vj.pr(i, i2, i3);
    }

    public void mw() {
        this.vj.hw(false);
    }

    public void sv() {
        this.qi.o();
    }

    public void gu() {
        this.vj.pr(this.ve);
    }

    public boolean d() {
        return this.vk.get();
    }

    public void x(boolean z) {
        this.np = z;
    }
}
