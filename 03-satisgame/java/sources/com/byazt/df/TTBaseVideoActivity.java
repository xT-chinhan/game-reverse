package com.byazt.df;

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
import com.byazt.cp.n;
import com.byazt.ep.cp;
import com.byazt.gct.an;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.dh;
import com.byazt.gct.g;
import com.byazt.gct.h;
import com.byazt.gct.j;
import com.byazt.gct.nf;
import com.byazt.gct.oa;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.tj;
import com.byazt.gct.ur;
import com.byazt.gct.wm;
import com.byazt.has.fs;
import com.byazt.has.x;
import com.byazt.kfh.TTProgressBar;
import com.byazt.pt.BaseThemeActivity;
import com.byazt.re.l;
import com.byazt.re.q;
import com.byazt.re.qg;
import com.byazt.re.s;
import com.byazt.rkq.SaasAuthRewardDialog;
import com.byazt.tk.k;
import com.byazt.tk.t;
import com.byazt.tkz.RewardAuthToastLayout;
import com.byazt.tkz.RewardFullBaseLayout;
import com.byazt.vf.wo;
import com.byazt.vs.df;
import com.byazt.ys.w;
import com.byazt.yyw.AbstractEndCardFrameLayout;
import com.byazt.za.bb;
import com.byazt.za.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@n(n = {0, 1, 34, 35})
public abstract class TTBaseVideoActivity extends BaseThemeActivity implements wo.n, com.byazt.rv.n {
    public final AtomicBoolean a;
    public qg an;
    public w b;
    public RewardFullBaseLayout bb;
    public final AtomicBoolean cd;
    public final com.byazt.dt.n ci;
    public final AtomicBoolean cp;
    public com.byazt.zx.n.InterfaceC0421n cx;
    public final AtomicBoolean cy;
    public final AtomicBoolean d;
    public q df;
    public com.byazt.has.n dg;
    public int dh;
    public final com.byazt.cs.n.InterfaceC0149n dm;
    public boolean dn;
    public com.byazt.re.n.qg dw;
    public final AtomicBoolean e;
    public com.byazt.sf.n ei;
    public long el;
    public com.byazt.re.n f;
    public com.byazt.re.w fi;
    public com.byazt.zct.n.InterfaceC0409n fl;
    public final AtomicBoolean fs;
    public int g;
    public long h;
    public float ha;
    public final AtomicBoolean hd;
    public int he;
    public final com.byazt.mkl.n hf;
    public boolean hu;
    public com.byazt.ys.qg i;
    public final com.byazt.aq.n ic;
    public l j;
    public int ju;
    public final AtomicBoolean k;
    public final AtomicBoolean kc;
    public final ConcurrentHashMap<Integer, Boolean> l;
    public com.byazt.tkz.l lh;
    public com.byazt.tkz.qg ln;
    public com.byazt.rg.n lq;
    public boolean m;
    public com.byazt.ce.q mz;
    public final String n;
    public com.byazt.nsm.qg nf;
    public boolean np;
    public AtomicBoolean o;
    public final AtomicBoolean oa;
    public s oj;
    public final AtomicBoolean ou;
    public com.byazt.pnj.n pe;
    public com.byazt.ce.s pk;
    public final AtomicBoolean py;
    public final ConcurrentHashMap<Integer, Boolean> q;
    public final t qg;
    public long r;
    public com.byazt.wg.qg rf;
    public com.byazt.tx.qg ri;
    public final AtomicBoolean rv;
    public int ry;
    public final AtomicBoolean s;
    public String sh;
    public com.byazt.ql.n sq;
    public com.byazt.re.n.InterfaceC0322n su;
    public final AtomicBoolean sz;
    public boolean t;
    public Double ta;
    public final AtomicBoolean tj;
    public TTBaseVideoActivity u;
    public final AtomicBoolean um;
    public int ur;
    public AbstractEndCardFrameLayout v;
    public long vb;
    public final com.byazt.mkl.qg vo;
    public final AtomicBoolean w;
    public boolean wm;
    public int wo;
    public com.byazt.aqe.qg.n wv;
    public final AtomicBoolean x;
    public long xi;
    public String y;
    public final AtomicBoolean yw;
    public com.byazt.nj.l z;

    public boolean bb() {
        return false;
    }

    public void fs(int i) {
    }

    public String j() {
        return "";
    }

    public String lh() {
        return "";
    }

    public int ln() {
        return 0;
    }

    public String n() {
        return null;
    }

    public abstract void n(String str, Bundle bundle);

    public void q(int i) {
    }

    public void s(int i) {
    }

    public abstract void s(boolean z);

    public void sh() {
    }

    public abstract boolean t();

    public abstract void ur();

    public String v() {
        return "";
    }

    public TTBaseVideoActivity() {
        this.n = t() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.qg = new t(Looper.getMainLooper(), this);
        this.s = new AtomicBoolean(false);
        this.q = new ConcurrentHashMap<>();
        this.l = new ConcurrentHashMap<>();
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.fs = new AtomicBoolean(false);
        this.kc = new AtomicBoolean(false);
        this.rv = new AtomicBoolean(false);
        this.tj = new AtomicBoolean(false);
        this.cp = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.oa = new AtomicBoolean(false);
        this.sz = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.cy = new AtomicBoolean(false);
        this.hd = new AtomicBoolean(false);
        this.cd = new AtomicBoolean(false);
        this.um = new AtomicBoolean(false);
        this.a = new AtomicBoolean(false);
        this.py = new AtomicBoolean(false);
        this.ou = new AtomicBoolean(false);
        this.ur = -1;
        this.el = 0L;
        this.vb = 0L;
        this.g = 1;
        this.ta = null;
        this.xi = 0L;
        this.np = false;
        this.e = new AtomicBoolean();
        this.yw = new AtomicBoolean();
        this.cx = new com.byazt.zx.n.InterfaceC0421n() { // from class: com.byazt.df.TTBaseVideoActivity.1
            @Override // com.byazt.zx.n.InterfaceC0421n
            public void n() {
                TTBaseVideoActivity.this.qg.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                TTBaseVideoActivity.this.hd();
                if (!TTBaseVideoActivity.this.fi.d()) {
                    TTBaseVideoActivity.this.fi.qg(TTBaseVideoActivity.this.fi.bb() + 1000);
                }
                if (TTBaseVideoActivity.this.dg.w() && !TTBaseVideoActivity.this.fi.d()) {
                    TTBaseVideoActivity.this.lh.qg(true);
                }
                TTBaseVideoActivity.this.lq();
            }

            @Override // com.byazt.zx.n.InterfaceC0421n
            public void n(int i, String str) {
                if (TTBaseVideoActivity.this.m) {
                    TTBaseVideoActivity.this.qg.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                    TTBaseVideoActivity.this.sz();
                    TTBaseVideoActivity.this.fi.n(5);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.qg(tTBaseVideoActivity.fi.qg());
                }
            }

            @Override // com.byazt.zx.n.InterfaceC0421n
            public void qg() {
                TTBaseVideoActivity.this.qg.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                TTBaseVideoActivity.this.hd();
                TTBaseVideoActivity.this.n(false, false);
                TTBaseVideoActivity.this.fi.n(6);
                TTBaseVideoActivity.this.fi.rv();
            }

            @Override // com.byazt.zx.n.InterfaceC0421n
            public void n(long j, long j2) {
                if (!TTBaseVideoActivity.this.m && TTBaseVideoActivity.this.fi.qg()) {
                    TTBaseVideoActivity.this.fi.n((Map<String, Object>) null);
                }
                boolean z = true;
                if (TTBaseVideoActivity.this.an.an()) {
                    TTBaseVideoActivity.this.fi.s(true);
                    return;
                }
                TTBaseVideoActivity.this.qg.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                if (j != TTBaseVideoActivity.this.fi.bb()) {
                    TTBaseVideoActivity.this.hd();
                }
                if (TTBaseVideoActivity.this.fi.qg() || j2 == j) {
                    TTBaseVideoActivity.this.fi.qg(j);
                    if (TTBaseVideoActivity.this.xi()) {
                        com.byazt.tkz.l lVar = TTBaseVideoActivity.this.lh;
                        String strValueOf = String.valueOf(TTBaseVideoActivity.this.fi.ur());
                        int iBb = (int) (TTBaseVideoActivity.this.fi.bb() / 1000);
                        if (j != j2 && !TTBaseVideoActivity.this.fi.lh()) {
                            z = false;
                        }
                        lVar.n(strValueOf, iBb, 0, z);
                    }
                    TTBaseVideoActivity.this.s(0);
                    TTBaseVideoActivity.this.sh();
                    TTBaseVideoActivity.this.dg.ou();
                    if (TTBaseVideoActivity.this.lh != null) {
                        TTBaseVideoActivity.this.lh.n(j, j2);
                    }
                }
            }

            @Override // com.byazt.zx.n.InterfaceC0421n
            public void s() {
                if (TTBaseVideoActivity.this.ri != null && TTBaseVideoActivity.this.ri.qg() != null) {
                    TTBaseVideoActivity.this.ri.qg().n();
                }
                TTBaseVideoActivity.this.q("started");
            }
        };
        this.lq = new com.byazt.rg.n() { // from class: com.byazt.df.TTBaseVideoActivity.12
            @Override // com.byazt.rg.n
            public void n(ViewGroup viewGroup) {
            }

            @Override // com.byazt.za.d
            public void n(int i) {
                TTBaseVideoActivity.this.dg.y().n(i);
            }

            @Override // com.byazt.za.d
            public long n() {
                return TTBaseVideoActivity.this.dg.y().n();
            }

            @Override // com.byazt.za.d
            public int qg() {
                return TTBaseVideoActivity.this.dg.y().qg();
            }

            @Override // com.byazt.za.d
            public int s() {
                return TTBaseVideoActivity.this.dg.y().s();
            }

            @Override // com.byazt.za.d
            public void q() {
                TTBaseVideoActivity.this.dg.y().q();
            }

            @Override // com.byazt.za.d
            public void qg(int i) {
                TTBaseVideoActivity.this.dg.y().qg(i);
            }

            @Override // com.byazt.za.d
            public void l() {
                TTBaseVideoActivity.this.dg.y().l();
            }

            @Override // com.byazt.za.d
            public void n(int i, String str) {
                TTBaseVideoActivity.this.dg.y().n(i, str);
            }

            @Override // com.byazt.za.d
            public void setPauseFromExpressView(boolean z) {
                TTBaseVideoActivity.this.dg.y().setPauseFromExpressView(z);
            }

            @Override // com.byazt.za.d
            public void n(float f) {
                TTBaseVideoActivity.this.dg.y().n(f);
            }

            @Override // com.byazt.za.d
            public void n(int i, int i2) {
                TTBaseVideoActivity.this.dg.y().n(i, i2);
            }

            @Override // com.byazt.rg.n
            public void n(View view) {
                TTBaseVideoActivity.this.n(2);
                com.byazt.rg.s.n(TTBaseVideoActivity.this.ae, (oa) h.rv(TTBaseVideoActivity.this.ae), true, (JSONObject) null);
            }

            @Override // com.byazt.za.d
            public void s(int i) {
                TTBaseVideoActivity.this.s(i);
            }

            @Override // com.byazt.za.d
            public void n(pk pkVar) {
                TTBaseVideoActivity.this.dg.y().n(pkVar);
            }

            @Override // com.byazt.rg.n
            public void n(View view, int i, com.byazt.twc.s sVar, g gVar) {
                boolean zOptBoolean;
                tj tjVar;
                if (TTBaseVideoActivity.this.b != null) {
                    if (sVar instanceof wm) {
                        wm wmVar = (wm) sVar;
                        tjVar = new tj();
                        tjVar.n(wmVar.n);
                        tjVar.qg(wmVar.qg);
                        tjVar.s(wmVar.s);
                        tjVar.q(wmVar.q);
                        tjVar.n(wmVar.l);
                        tjVar.qg(wmVar.w);
                        tjVar.qg(wmVar.k);
                        zOptBoolean = wmVar.n().optBoolean("isLottieInternalClick", false);
                    } else {
                        tjVar = null;
                        zOptBoolean = false;
                    }
                    TTBaseVideoActivity.this.b.n(view, tjVar);
                } else {
                    zOptBoolean = false;
                }
                com.byazt.rg.s.n(TTBaseVideoActivity.this.ae, (oa) gVar, false, (JSONObject) null, zOptBoolean);
            }

            @Override // com.byazt.rg.n
            public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
                tj tjVar;
                if ((i == 1 || i == 2) && (sVar instanceof wm)) {
                    wm wmVar = (wm) sVar;
                    tjVar = new tj();
                    tjVar.n(wmVar.n);
                    tjVar.qg(wmVar.qg);
                    tjVar.s(wmVar.s);
                    tjVar.q(wmVar.q);
                    tjVar.n(wmVar.l);
                    tjVar.qg(wmVar.w);
                    tjVar.qg(wmVar.k);
                } else {
                    tjVar = null;
                }
                if (i == 2) {
                    TTBaseVideoActivity.this.b.n(view, tjVar);
                }
                if (i == 1) {
                    TTBaseVideoActivity.this.b.n(view, tjVar);
                }
            }
        };
        this.dm = new com.byazt.cs.n.InterfaceC0149n() { // from class: com.byazt.df.TTBaseVideoActivity.20
            @Override // com.byazt.cs.n.InterfaceC0149n
            public boolean ur() {
                return false;
            }

            @Override // com.byazt.cs.n.InterfaceC0149n
            public com.byazt.cs.n t() {
                com.byazt.cs.n nVar = new com.byazt.cs.n();
                if (TTBaseVideoActivity.this.fi != null) {
                    nVar.x = TTBaseVideoActivity.this.fi.cy();
                    nVar.n = TTBaseVideoActivity.this.fi.n();
                    nVar.fs = TTBaseVideoActivity.this.wm;
                }
                return nVar;
            }
        };
        this.ic = new com.byazt.aq.qg(new com.byazt.aq.n.InterfaceC0124n() { // from class: com.byazt.df.TTBaseVideoActivity.21
            @Override // com.byazt.aq.n.InterfaceC0124n
            public TTBaseVideoActivity getActivity() {
                return TTBaseVideoActivity.this.u;
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public RewardFullBaseLayout n() {
                return TTBaseVideoActivity.this.bb;
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public boolean qg() {
                return TTBaseVideoActivity.this.t();
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public pk s() {
                return TTBaseVideoActivity.this.ae;
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public boolean q() {
                return TTBaseVideoActivity.this.dn;
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public int l() {
                return TTBaseVideoActivity.this.dg.bb();
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public int w() {
                return TTBaseVideoActivity.this.dg.w(true);
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public boolean x() {
                return TTBaseVideoActivity.this.um.get();
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public boolean fs() {
                return TTBaseVideoActivity.this.pe();
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public boolean rv() {
                return TTBaseVideoActivity.this.dg.b();
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public void n(int i, int i2) {
                if (i == 3) {
                    TTBaseVideoActivity.this.sz(2);
                }
                TTBaseVideoActivity.this.qg(i, i2);
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public void n(int i) {
                if (i == 3) {
                    TTBaseVideoActivity.this.k(2);
                }
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public void tj() {
                if (TTBaseVideoActivity.this.dg instanceof com.byazt.has.tj) {
                    ((com.byazt.has.tj) TTBaseVideoActivity.this.dg).vb();
                }
            }

            @Override // com.byazt.aq.n.InterfaceC0124n
            public void cp() {
                if (TTBaseVideoActivity.this.dg instanceof com.byazt.has.tj) {
                    ((com.byazt.has.tj) TTBaseVideoActivity.this.dg).fl();
                }
            }
        });
        this.ci = new com.byazt.dt.qg(new com.byazt.dt.n.InterfaceC0156n() { // from class: com.byazt.df.TTBaseVideoActivity.22
            @Override // com.byazt.dt.n.InterfaceC0156n
            public Activity getActivity() {
                return TTBaseVideoActivity.this.u;
            }

            @Override // com.byazt.dt.n.InterfaceC0156n
            public pk n() {
                return TTBaseVideoActivity.this.ae;
            }

            @Override // com.byazt.dt.n.InterfaceC0156n
            public String qg() {
                return TTBaseVideoActivity.this.sh;
            }

            @Override // com.byazt.dt.n.InterfaceC0156n
            public void s() {
                TTBaseVideoActivity.this.finish();
            }

            @Override // com.byazt.dt.n.InterfaceC0156n
            public void n(int i, TTProgressBar tTProgressBar) {
                try {
                    TTBaseVideoActivity.this.bb.n(i, tTProgressBar);
                } catch (Exception unused) {
                }
            }

            @Override // com.byazt.dt.n.InterfaceC0156n
            public void n(boolean z, String str, String str2) {
                if (com.byazt.qq.qg.s(TTBaseVideoActivity.this.ae)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible", z);
                    jSONObject.put("entrance_text", dh.n(TTBaseVideoActivity.this.ae, str, str2));
                } catch (JSONException unused) {
                }
                TTBaseVideoActivity.this.lh.n("showPlayAgainEntrance", jSONObject);
                TTBaseVideoActivity.this.an.n(jSONObject);
                if (TTBaseVideoActivity.this.an.an()) {
                    return;
                }
                TTBaseVideoActivity.this.j.x(z);
                TTBaseVideoActivity.this.j.n(dh.n(TTBaseVideoActivity.this.ae, str, str2));
            }

            @Override // com.byazt.dt.n.InterfaceC0156n
            public void q() {
                TTBaseVideoActivity.this.dg();
            }

            @Override // com.byazt.dt.n.InterfaceC0156n
            public void l() {
                if (TTBaseVideoActivity.this.fi != null) {
                    TTBaseVideoActivity.this.fi.x();
                }
            }
        });
        this.vo = new com.byazt.mkl.qg();
        this.hf = new com.byazt.mkl.n() { // from class: com.byazt.df.TTBaseVideoActivity.23
            @Override // com.byazt.mkl.n
            public void n(boolean z, JSONObject jSONObject) {
                boolean zX;
                boolean zFs;
                if (z) {
                    boolean zT = TTBaseVideoActivity.this.t();
                    if (zT) {
                        zX = an.l();
                    } else {
                        zX = an.x();
                    }
                    if (zT) {
                        zFs = an.w();
                    } else {
                        zFs = an.fs();
                    }
                    boolean z2 = TTBaseVideoActivity.this.an != null && TTBaseVideoActivity.this.an.an();
                    boolean zQg = nf.qg(TTBaseVideoActivity.this.ae);
                    boolean z3 = TTBaseVideoActivity.this.l(4) == 2;
                    boolean z4 = TTBaseVideoActivity.this.py.get();
                    TTBaseVideoActivity.this.vo.qg(z2);
                    TTBaseVideoActivity.this.vo.s(z4 ? 1 : 0);
                    TTBaseVideoActivity.this.vo.l(TTBaseVideoActivity.this.l(4));
                    if (z2 || TTBaseVideoActivity.this.py.get()) {
                        return;
                    }
                    if (zQg && zFs) {
                        if (TTBaseVideoActivity.this.lh != null) {
                            TTBaseVideoActivity.this.vo.qg(2);
                            rv.qg(TTBaseVideoActivity.this.lh.d());
                            return;
                        }
                        return;
                    }
                    if (zX) {
                        if (!cx.hd(TTBaseVideoActivity.this.ae) && zT) {
                            TTBaseVideoActivity.this.vo.q(1);
                        } else if (z3) {
                            TTBaseVideoActivity.this.vo.qg(1);
                            TTBaseVideoActivity.this.l();
                        }
                    }
                }
            }
        };
        this.o = new AtomicBoolean(true);
    }

    @Override // com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.byazt.cb.s.qg(this);
        super.onCreate(bundle);
        this.u = this;
        dn();
        n(getIntent());
        qg(bundle);
        qg(getIntent());
        if (!n(bundle)) {
            this.ou.set(true);
            return;
        }
        fl();
        he();
        su();
        rv();
        this.dg.n(this.ry, this.ju);
        setContentView(this.bb);
        q();
        this.dg.qg();
        com.byazt.tkz.l lVar = this.lh;
        if (lVar != null) {
            lVar.n(this.dm);
        }
        if (z()) {
            this.mz = new com.byazt.ce.q();
        }
        SaasAuthRewardDialog saasAuthRewardDialog = (SaasAuthRewardDialog) findViewById(2114387968);
        if (saasAuthRewardDialog != null) {
            saasAuthRewardDialog.n(this.ae, this.n, t() ? 7 : 5);
        }
        if (j.qg(t(), this.ae, true)) {
            an().getSceneFrameContainer().post(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.24
                @Override // java.lang.Runnable
                public void run() {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, TTBaseVideoActivity.this.an().getSceneFrameContainer().getHeight(), 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setFillAfter(true);
                    TTBaseVideoActivity.this.an().getSceneFrameContainer().startAnimation(translateAnimation);
                }
            });
        }
        if (this.lh == null || !com.byazt.vhv.q.x().s()) {
            return;
        }
        this.vo.n(this.ae);
        this.vo.n(t() ? an.qg() : an.s());
        this.vo.n(nf.qg(this.ae));
        this.lh.n(this.hf);
    }

    private boolean z() {
        if (this.ae != null && com.byazt.wq.qg.n().qg(this.ae)) {
            String strCy = this.ae.cy();
            if (TextUtils.isEmpty(strCy)) {
                return false;
            }
            try {
                if (new JSONObject(strCy).optInt("saas_play_time_type") == 1) {
                    return true;
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    private void dn() {
        this.bb = new RewardFullBaseLayout(this.u);
        this.j = new l(this.u);
        this.an = new qg(this.u);
        this.f = new com.byazt.re.n(this.u);
        this.fi = new com.byazt.re.w(this.u);
        this.df = new q(this.u);
        this.oj = new s(this.u);
    }

    public void qg() {
        finish();
    }

    public void s() {
        this.fi.ae();
        this.fi.n(2);
        this.fi.rv();
        k();
        w(2);
    }

    public void onSkipBorderClick(View view) {
        this.dg.n(view);
    }

    public boolean n(Bundle bundle) {
        this.f.n(this.ae, this.n, this.sh);
        if (bundle != null) {
            this.f.n();
        }
        com.byazt.vyf.qg.n().s(this.ae);
        if (this.ae != null) {
            return true;
        }
        k.qg("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
        qg();
        return false;
    }

    private void he() {
        com.byazt.has.n nVarN = com.byazt.has.q.n(this.u, this.ae);
        this.dg = nVarN;
        if (nVarN == null) {
            k.qg("TTBaseVideoActivity", "initAdType failed , finish activity");
            finish();
            return;
        }
        nVarN.getClass().getSimpleName();
        if (!j.qg(t(), this.ae, true)) {
            this.wm = this.ae.kj() == 1;
        }
        this.dg.n(this.j, this.fi, this.an, this.df, this.f);
        com.byazt.ce.s sVar = new com.byazt.ce.s(t(), this.ae, this.fi, this.dg);
        this.pk = sVar;
        sVar.qg(this.he);
        this.dg.n(this.n, this.wm, t(), this.pk);
        this.dg.fs();
    }

    private void el() {
        if (this.ae == null || this.bb == null) {
            return;
        }
        String strCy = this.ae.cy();
        if (TextUtils.isEmpty(strCy)) {
            return;
        }
        try {
            int iOptInt = new JSONObject(strCy).optInt("auth_reward_gold");
            if (iOptInt > 0) {
                this.bb.addView(new RewardAuthToastLayout(this.u, iOptInt));
            }
        } catch (JSONException unused) {
        }
    }

    private void vb() {
        this.ei = new com.byazt.sf.n() { // from class: com.byazt.df.TTBaseVideoActivity.25
            @Override // com.byazt.sf.n
            public void n(String str, String str2) {
                if (TTBaseVideoActivity.this.ae != null) {
                    String strOu = TTBaseVideoActivity.this.ae.ou();
                    if (TextUtils.equals("show", str) && TextUtils.equals(str2, strOu)) {
                        TTBaseVideoActivity.this.e.set(true);
                    }
                    if (TextUtils.equals("click", str) && TextUtils.equals(str2, strOu)) {
                        TTBaseVideoActivity.this.yw.set(true);
                    }
                }
            }
        };
        com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).n(this.ei);
    }

    public void q() {
        vb();
        this.bb.n(this.dg);
        el();
        this.ln = this.dg.n(t());
        this.lh = this.dg.d();
        this.v = this.dg.sz();
        this.ln.n();
        this.ri = new com.byazt.tx.qg(this.ae, this.lq);
        x();
        this.ln.n(this.b, this.i);
        this.ln.n(this.f.x());
        this.j.n(this.ae, this.an, t(), this.b);
        this.j.q(this.wm);
        if (this.f.s()) {
            ((com.byazt.zct.n) this.b.n(com.byazt.zct.n.class)).n(this.f.qg());
            this.f.n(this.su);
        }
        this.f.n(this.dw);
        this.f.n(this.dm);
        this.an.n(this.j, this.f, t(), this.n, this.ry, this.ju);
        this.an.n(this.ae, this.b, this.dm.t(), this.v);
        this.df.n(this.an, this.ae, this.n, this.j);
        this.oj.n(this.ae, this.n, this.ln.oa());
        this.fi.n(this.ae);
        this.sq = new com.byazt.ql.n();
        this.nf = new com.byazt.nsm.qg(this.n);
        this.pe = new com.byazt.pnj.n(this.ae, this.u);
    }

    public void l() {
        qg qgVar;
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.has.n nVar = this.dg;
            if (nVar != null) {
                jSONObject.put("reward_full_scene_type", nVar.v());
            }
        } catch (Exception unused) {
        }
        com.byazt.eji.s.n().n(this.ae, "stats_reward_full_show_endcard", jSONObject);
        if (isDestroyed() || isFinishing() || (qgVar = this.an) == null || qgVar.an()) {
            return;
        }
        if (!cd.q(this.ae)) {
            this.an.q(true);
        }
        if (cx.hd(this.ae)) {
            this.l.remove(1);
            u();
        }
        this.dg.h();
        if (this.dg instanceof com.byazt.has.tj) {
            this.ic.qg(true);
            this.ic.w();
        }
        if (!(this.dg instanceof x) || !this.an.a() || (this.dg instanceof fs)) {
            this.an.ou();
        }
        this.j.n(true);
        this.df.n(this.wm);
        this.an.d();
        if ((this.dg instanceof x) && this.an.bb()) {
            this.an.rv();
            return;
        }
        this.j.n(2);
        com.byazt.wg.qg qgVar2 = this.rf;
        if (qgVar2 != null) {
            qgVar2.qg();
        }
        com.byazt.aqe.qg.n nVar2 = this.wv;
        if (nVar2 != null) {
            nVar2.l();
        }
        com.byazt.tkz.qg qgVar3 = this.ln;
        if (qgVar3 != null) {
            qgVar3.l(8);
        }
        this.an.s(false);
        if (this.an.hd()) {
            if (!ta.cp(this.ae) && !com.byazt.qq.qg.qg(this.ae)) {
                this.an.n(true, 0, (String) null);
            }
            this.an.sz();
            this.qg.sendEmptyMessageDelayed(500, 100L);
            return;
        }
        if (!ta.cp(this.ae)) {
            this.an.n(false, TTAdConstant.INTERACTION_TYPE_CODE, "end_card_timeout");
        }
        this.an.l(true);
        this.fi.fs();
    }

    public void w() {
        if (!this.dg.lq()) {
            if (com.byazt.qq.qg.x(this.ae)) {
                return;
            }
            qg(true, true);
        } else {
            if (qg(this.fi.w(), false)) {
                return;
            }
            n(true, true);
        }
    }

    public boolean n(long j, boolean z) {
        if (!this.fi.ou()) {
            return false;
        }
        if (!z || !this.fi.wm()) {
            ha();
        }
        boolean zN = this.fi.n(j, this.wm, this.dg.hu());
        if (zN && !z) {
            if (com.byazt.qq.qg.x(this.ae)) {
                return true;
            }
            qg(true, true);
        }
        return zN;
    }

    public void x() {
        this.b = new w(this.u, this.ae, this.n, t() ? 7 : 5) { // from class: com.byazt.df.TTBaseVideoActivity.26
            @Override // com.byazt.ys.w, com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view, tj tjVar) {
                if (TTBaseVideoActivity.this.ae != null && TTBaseVideoActivity.this.ae.ys() == 1 && TTBaseVideoActivity.this.lh != null) {
                    if (tjVar == null) {
                        tjVar = new tj();
                    }
                    tjVar.qg(TTBaseVideoActivity.this.lh.l() ? TTBaseVideoActivity.this.lh.rv() : (byte) 0);
                }
                super.n(view, tjVar);
                com.byazt.dj.qg qgVar = (com.byazt.dj.qg) this.fs.n(com.byazt.dj.qg.class);
                if (qgVar == null || !qgVar.qg(view)) {
                    return;
                }
                TTBaseVideoActivity.this.n(view, tjVar);
            }
        };
        this.fl = new com.byazt.zct.n.InterfaceC0409n() { // from class: com.byazt.df.TTBaseVideoActivity.2
            @Override // com.byazt.zct.n.InterfaceC0409n
            public void n(View view, int i) {
                TTBaseVideoActivity.this.n(view, new tj());
            }
        };
        com.byazt.ikv.qg.qg(this.ae.ih(), this.fl, com.byazt.zct.n.InterfaceC0409n.class);
        if (this.ha != 100.0f) {
            ((com.byazt.zct.n) this.b.n(com.byazt.zct.n.class)).n(this.dm);
        }
        n((com.byazt.fq.s) this.b.n(com.byazt.fq.s.class));
        this.b.n(this.ln.oa());
        ((com.byazt.fq.n) this.b.n(com.byazt.fq.n.class)).n(pk());
        com.byazt.ys.qg qgVar = new com.byazt.ys.qg(this.u, this.ae, this.n, t() ? 7 : 5) { // from class: com.byazt.df.TTBaseVideoActivity.3
            @Override // com.byazt.ys.qg, com.byazt.ys.l
            public void n(View view, tj tjVar) {
                TTBaseVideoActivity.this.oj.n(view, tjVar);
            }
        };
        this.i = qgVar;
        n((com.byazt.fq.s) qgVar.n(com.byazt.fq.s.class));
        this.su = new com.byazt.re.n.InterfaceC0322n() { // from class: com.byazt.df.TTBaseVideoActivity.4
            @Override // com.byazt.re.n.InterfaceC0322n
            public void n(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.oj.n(str, jSONObject);
            }

            @Override // com.byazt.re.n.InterfaceC0322n
            public void n(View view, tj tjVar) {
                TTBaseVideoActivity.this.oj.n(view, tjVar);
            }
        };
        this.dw = new com.byazt.re.n.qg() { // from class: com.byazt.df.TTBaseVideoActivity.5
            @Override // com.byazt.re.n.qg
            public void n(boolean z) {
                if (z) {
                    TTBaseVideoActivity.this.an.n(1, 0);
                    TTBaseVideoActivity.this.lh.n(1, 0L);
                    TTBaseVideoActivity.this.ri.qg().n(1, 0L);
                }
                TTBaseVideoActivity.this.n("点击开始下载");
            }

            @Override // com.byazt.re.n.qg
            public void n(boolean z, long j, long j2, String str, String str2) {
                if (j > 0) {
                    int i = (int) ((100 * j2) / j);
                    if (z) {
                        TTBaseVideoActivity.this.an.n(j2, j, 3);
                        long j3 = i;
                        TTBaseVideoActivity.this.lh.n(3, j3);
                        TTBaseVideoActivity.this.ri.qg().n(3, j3);
                    }
                    TTBaseVideoActivity.this.n("已下载" + i + "%");
                }
            }

            @Override // com.byazt.re.n.qg
            public void qg(boolean z, long j, long j2, String str, String str2) {
                if (j > 0) {
                    int i = (int) ((100 * j2) / j);
                    if (z) {
                        TTBaseVideoActivity.this.an.n(j2, j, 2);
                        long j3 = i;
                        TTBaseVideoActivity.this.lh.n(2, j3);
                        TTBaseVideoActivity.this.ri.qg().n(2, j3);
                    }
                }
                TTBaseVideoActivity.this.n("下载暂停");
            }

            @Override // com.byazt.re.n.qg
            public void s(boolean z, long j, long j2, String str, String str2) {
                if (j > 0) {
                    int i = (int) ((100 * j2) / j);
                    if (z) {
                        TTBaseVideoActivity.this.an.n(j2, j, 4);
                        long j3 = i;
                        TTBaseVideoActivity.this.lh.n(4, j3);
                        TTBaseVideoActivity.this.ri.qg().n(4, j3);
                    }
                }
                TTBaseVideoActivity.this.n("下载失败");
            }

            @Override // com.byazt.re.n.qg
            public void n(boolean z, long j, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.an.n(5, 100);
                    TTBaseVideoActivity.this.lh.n(5, 100L);
                    TTBaseVideoActivity.this.ri.qg().n(5, 100L);
                }
                TTBaseVideoActivity.this.n("点击安装");
            }

            @Override // com.byazt.re.n.qg
            public void n(boolean z, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.an.n(6, 100);
                    TTBaseVideoActivity.this.lh.n(6, 100L);
                    TTBaseVideoActivity.this.ri.qg().n(6, 100L);
                }
                TTBaseVideoActivity.this.n("点击打开");
            }
        };
        this.dg.n(this.b);
    }

    public void n(final com.byazt.fq.s sVar) {
        sVar.n(new com.byazt.fq.s.n() { // from class: com.byazt.df.TTBaseVideoActivity.6
            @Override // com.byazt.fq.s.n
            public boolean n() {
                sVar.n(TTBaseVideoActivity.this.fs());
                sVar.n(TTBaseVideoActivity.this.n);
                sVar.n(TTBaseVideoActivity.this.ta);
                return TTBaseVideoActivity.this.kc.get();
            }
        });
    }

    public Map<String, Object> fs() {
        Map<String, Object> mapPk = pk();
        if (this.h > 0) {
            mapPk.put("object_media_holder_time", Long.valueOf((System.currentTimeMillis() - this.h) / 1000));
        }
        com.byazt.has.n nVar = this.dg;
        if (nVar != null && nVar.w() && this.lh != null) {
            bb.n(mapPk, this.ae, this.lh.d());
        }
        return mapPk;
    }

    public void n(String str) {
        this.an.n(str);
    }

    private void fl() {
        com.byazt.hm.n.n(this.ae, getClass().getName());
        this.wo = com.byazt.vgx.w.cy(this.ae);
        this.ha = this.ae.sl();
        this.g = this.ae.ys();
        cx.n(this.ae, false);
        cx.qg(this.ae, false);
        com.byazt.rv.s.s = false;
        com.byazt.rv.s.qg = 0;
        com.byazt.rv.s.n = 0;
        com.byazt.rv.s.q = false;
    }

    public void rv() {
        float[] fArrN = com.byazt.ce.qg.n(this.u.getApplicationContext(), this.ha, this.g);
        float f = fArrN[0];
        float f2 = fArrN[1];
        if (this.ha == 100.0f) {
            this.ry = (int) f;
            this.ju = (int) f2;
            return;
        }
        int[] iArrN = com.byazt.ce.qg.n(this.u.getApplicationContext(), this.ha, this.ae.zb(), this.g);
        int i = iArrN[0];
        int i2 = iArrN[1];
        int i3 = iArrN[2];
        int i4 = iArrN[3];
        float f3 = i;
        float f4 = i3;
        this.ry = (int) ((f - f3) - f4);
        float f5 = i2;
        float f6 = i4;
        this.ju = (int) ((f2 - f5) - f6);
        if (!ur.n(this.ae) || com.byazt.wd.x.n(String.valueOf(this.wo))) {
            try {
                this.bb.n(com.byazt.okk.s.s(this.u, f3), com.byazt.okk.s.s(this.u, f5), com.byazt.okk.s.s(this.u, f4), com.byazt.okk.s.s(this.u, f6));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (t() && this.ci.qg()) {
            qg();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ou.get()) {
            return;
        }
        this.an.oa();
        com.byazt.ql.n nVar = this.sq;
        if (nVar != null) {
            nVar.n();
        }
        com.byazt.fr.s.n().n(this, this.ae, this.wm);
    }

    @Override // android.app.Activity
    public void onResume() {
        Bundle bundleN;
        super.onResume();
        if (this.ou.get()) {
            return;
        }
        this.el = System.currentTimeMillis();
        if (this.ic.l()) {
            qg();
            return;
        }
        com.byazt.pnj.n nVar = this.pe;
        if (nVar != null && nVar.q() && (bundleN = com.byazt.pnj.qg.n().n(this.wo)) != null) {
            n(Math.round((bundleN.getLong("foreground_time", 0L) / 1000) * cx.h(this.ae)), true);
            com.byazt.pnj.qg.n().qg(this.wo);
            this.pe.qg(false);
        }
        com.byazt.ce.q qVar = this.mz;
        if (qVar != null) {
            qVar.w();
            int iN = (int) this.mz.n(TimeUnit.SECONDS);
            n(iN, false);
            this.mz.x();
            if (this.lh != null && !cx.hd(this.ae)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", iN);
                } catch (JSONException unused) {
                }
                this.lh.n("reduceTime", jSONObject);
            }
        }
        this.m = true;
        this.an.s();
        this.f.q();
        com.byazt.has.n nVar2 = this.dg;
        if (nVar2 != null) {
            nVar2.qg(this.q.containsKey(0));
            u();
            this.df.n();
            g();
        }
        com.byazt.aq.q qVar2 = new com.byazt.aq.q();
        qVar2.n = j.n(t()) > 0;
        qVar2.qg = j.n(t());
        n(1, qVar2);
        this.qg.sendEmptyMessageDelayed(1300, this.pk.rv());
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.ou.get()) {
            return;
        }
        if (this.el > 0) {
            this.vb += System.currentTimeMillis() - this.el;
            this.el = 0L;
        }
        com.byazt.pnj.n nVar = this.pe;
        if (nVar != null && nVar.s()) {
            Bundle bundle = new Bundle();
            bundle.putLong("foreground_time", this.vb);
            com.byazt.pnj.qg.n().n(this.wo, bundle);
        }
        dg();
        this.m = false;
        com.byazt.has.n nVar2 = this.dg;
        if (nVar2 != null) {
            nVar2.k();
        }
        this.f.l();
        this.an.l();
        com.byazt.ce.q qVar = this.mz;
        if (qVar != null) {
            qVar.l();
        }
        this.qg.removeMessages(1300);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ou.get()) {
            return;
        }
        com.byazt.has.n nVar = this.dg;
        if (nVar != null) {
            nVar.s(this.w.get());
        }
        this.an.w();
        com.byazt.ql.n nVar2 = this.sq;
        if (nVar2 != null) {
            nVar2.qg();
        }
        com.byazt.fr.s.n().qg((Context) this, this.ae, false);
    }

    @Override // com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        com.byazt.nj.l lVar = this.z;
        if (lVar != null) {
            lVar.n();
        }
        super.onDestroy();
        if (this.ou.get()) {
            return;
        }
        com.byazt.has.n nVar = this.dg;
        if (nVar != null) {
            nVar.hd();
        }
        if (!i()) {
            this.oj.l().n(16);
        }
        com.byazt.wg.qg qgVar = this.rf;
        if (qgVar != null) {
            qgVar.qg();
        }
        dw();
        com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).qg(this.ei);
        com.byazt.ce.q qVar = this.mz;
        if (qVar != null) {
            qVar.fs();
        }
    }

    private boolean i() {
        com.byazt.has.n nVar = this.dg;
        if (nVar instanceof com.byazt.has.tj) {
            return true;
        }
        return nVar instanceof com.byazt.has.s;
    }

    private void dw() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.has.n nVar = this.dg;
            if (nVar != null) {
                jSONObject.put("reward_full_scene_type", nVar.v());
            }
        } catch (Exception unused) {
        }
        com.byazt.eji.s.n().n(this.ae, "stats_reward_full_destroy", jSONObject);
        com.byazt.rv.s.s = false;
        com.byazt.rv.s.qg = 0;
        com.byazt.rv.s.n = 0;
        com.byazt.rv.s.q = false;
        this.qg.removeCallbacksAndMessages(null);
        this.fi.m();
        this.f.w();
        this.an.x();
        com.byazt.tx.qg qgVar = this.ri;
        if (qgVar != null) {
            qgVar.s();
        }
        s(true);
        ur();
        n("recycleRes", (Bundle) null);
        if (this.ae != null) {
            com.byazt.uad.n.n(this.ae.py());
            com.byazt.ikv.qg.n(this.ae.py());
            com.byazt.ikv.qg.n(this.ae.ih());
            com.byazt.cd.s.qg(this.ae.v());
            try {
                com.byazt.sx.q.n().n(this.ae.py());
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("multi_process_key", this.sh);
            bundle.putBoolean("is_preload", this.hu);
            bundle.putLong("object_create_ts", this.h);
            bundle.putBoolean("is_adm", this.t);
            bundle.putInt("key_video_cache_callback", this.ur);
            bundle.putLong("video_current", this.fi.cy());
            bundle.putBoolean("is_mute", this.wm);
            bundle.putString("rit_scene", this.y);
            Double d = this.ta;
            bundle.putString("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.byazt.nsm.qg qgVar = this.nf;
        if (qgVar != null) {
            qgVar.n(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ae == null) {
            return;
        }
        if (pk.q(this.ae) || this.ae.ts() == 1 || (this.dg instanceof fs)) {
            this.an.cy();
        }
        com.byazt.nsm.qg qgVar = this.nf;
        if ((qgVar == null || !qgVar.qg(this.u, this.ae)) && cd.oa(this.ae)) {
            tj();
        }
    }

    public void tj() {
        if (this.an.k()) {
            this.an.cy();
            return;
        }
        if (!this.an.h() && !cp.l(this.ae) && !cp.q(this.ae)) {
            qg();
            return;
        }
        com.byazt.aqe.tj tjVar = new com.byazt.aqe.tj() { // from class: com.byazt.df.TTBaseVideoActivity.7
            @Override // com.byazt.aqe.tj
            public void n() {
                if (cd.oa(TTBaseVideoActivity.this.ae)) {
                    com.byazt.hm.n.n(TTBaseVideoActivity.this.ae, "rewarded_video", "popup_play", (com.byazt.rs.n) null);
                    if (cp.l(TTBaseVideoActivity.this.ae) || cp.q(TTBaseVideoActivity.this.ae)) {
                        return;
                    }
                    TTBaseVideoActivity.this.qg("onClickModalCallback");
                }
            }

            @Override // com.byazt.aqe.tj
            public void qg() {
                if (cd.oa(TTBaseVideoActivity.this.ae)) {
                    com.byazt.hm.n.n(TTBaseVideoActivity.this.ae, "rewarded_video", "popup_cancel", (com.byazt.rs.n) null);
                    TTBaseVideoActivity.this.k();
                    TTBaseVideoActivity.this.qg();
                }
            }
        };
        if (cp.l(this.ae) || cp.q(this.ae)) {
            n(tjVar);
        } else {
            qg(tjVar);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (i()) {
            return;
        }
        this.oj.l().n(1.0f, z ? 12 : 13);
    }

    private void n(com.byazt.aqe.tj tjVar) {
        int iOj = this.dg.oj();
        TTBaseVideoActivity tTBaseVideoActivity = this.u;
        if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
            this.u.getIntent().putExtra("remainTime", iOj);
        }
        if (iOj > 0) {
            if (n(this.ae, tjVar)) {
                return;
            }
            tjVar.qg();
            return;
        }
        qg();
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [com.byazt.df.TTBaseVideoActivity$9] */
    private void qg(final com.byazt.aqe.tj tjVar) {
        final boolean[] zArr = {false};
        df.n(new df.n() { // from class: com.byazt.df.TTBaseVideoActivity.8
            @Override // com.byazt.vs.df.n
            public void n() {
                zArr[0] = true;
                tjVar.qg();
            }

            @Override // com.byazt.vs.df.n
            public void n(int i) {
                zArr[0] = true;
                if (TTBaseVideoActivity.this.u != null && TTBaseVideoActivity.this.u.getIntent() != null) {
                    TTBaseVideoActivity.this.u.getIntent().putExtra("remainTime", i);
                }
                if (i > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    if (tTBaseVideoActivity.n(tTBaseVideoActivity.ae, tjVar)) {
                        return;
                    }
                }
                tjVar.qg();
            }
        });
        qg("onClickBrowseClose");
        new CountDownTimer(1000L, 1000L) { // from class: com.byazt.df.TTBaseVideoActivity.9
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (zArr[0]) {
                    return;
                }
                TTBaseVideoActivity.this.qg();
            }
        }.start();
    }

    public void qg(String str) {
        com.byazt.gcl.s sVarT = this.an.t();
        if (sVarT == null || isFinishing()) {
            qg();
            return;
        }
        try {
            sVarT.s(str, null);
        } catch (Exception unused) {
            qg();
        }
    }

    public boolean n(pk pkVar, com.byazt.aqe.tj tjVar) {
        return n(pkVar, tjVar, false);
    }

    public boolean qg(pk pkVar, com.byazt.aqe.tj tjVar) {
        return n(pkVar, tjVar, true);
    }

    private boolean n(pk pkVar, final com.byazt.aqe.tj tjVar, boolean z) {
        if (!t() || !this.ae.vg() || this.q.containsKey(0) || isFinishing()) {
            return false;
        }
        if (System.currentTimeMillis() - this.xi < 1000) {
            return true;
        }
        this.xi = System.currentTimeMillis();
        com.byazt.aqe.tj tjVar2 = new com.byazt.aqe.tj() { // from class: com.byazt.df.TTBaseVideoActivity.10
            @Override // com.byazt.aqe.tj
            public void s() {
            }

            @Override // com.byazt.aqe.tj
            public void n() {
                com.byazt.aqe.tj tjVar3 = tjVar;
                if (tjVar3 != null) {
                    tjVar3.n();
                }
                TTBaseVideoActivity.this.oj.n("reward_retain_dialog_cancel", TTBaseVideoActivity.this.wv.n(), TTBaseVideoActivity.this.wv.qg());
            }

            @Override // com.byazt.aqe.tj
            public void qg() {
                TTBaseVideoActivity.this.oa.set(true);
                com.byazt.aqe.tj tjVar3 = tjVar;
                if (tjVar3 != null) {
                    tjVar3.qg();
                }
                TTBaseVideoActivity.this.oj.n("reward_retain_dialog_skip", TTBaseVideoActivity.this.wv.n(), TTBaseVideoActivity.this.wv.qg());
            }

            @Override // com.byazt.aqe.tj
            public void n(int i) {
                TTBaseVideoActivity.this.n(i, true);
                TTBaseVideoActivity.this.j.qg("恭喜您，可提前" + i + "s获得奖励～");
            }
        };
        if (z) {
            this.wv = this.dg.n(pkVar, tjVar2, true);
        } else {
            this.wv = this.dg.n(pkVar, tjVar2);
        }
        this.oj.n("reward_retain_dialog_show", this.wv.n(), this.wv.qg());
        return this.wv.s();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.okk.s.qg((Activity) this.u);
        try {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.byazt.df.TTBaseVideoActivity.11
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        if (TTBaseVideoActivity.this.nf != null) {
                            TTBaseVideoActivity.this.nf.n();
                        }
                        try {
                            if (TTBaseVideoActivity.this.isFinishing()) {
                                return;
                            }
                            if (TTBaseVideoActivity.this.g == 2) {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.byazt.okk.s.n((Activity) TTBaseVideoActivity.this.u);
                                    }
                                }, 2500L);
                            } else {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.byazt.okk.s.qg((Activity) TTBaseVideoActivity.this.u);
                                    }
                                }, 500L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.pt.BaseThemeActivity
    public boolean cp() {
        return this.ae.lh() && com.byazt.qq.qg.s(this.ae);
    }

    private void su() {
        final View decorView;
        if (this.ae == null || !cp()) {
            final int iDr = com.byazt.nf.rv.qg().dr();
            try {
                requestWindowFeature(1);
                getWindow().addFlags(16777216);
                getWindow().addFlags(128);
                com.byazt.nf.rv.n(this.u);
                if (!this.dg.sh()) {
                    getWindow().addFlags(1024);
                    if (iDr == 1) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            getWindow().setDecorFitsSystemWindows(true);
                        }
                        getWindow().getDecorView().setFitsSystemWindows(true);
                    }
                }
            } catch (Throwable unused) {
            }
            if (iDr == 1) {
                return;
            }
            try {
                decorView = getWindow().getDecorView();
            } catch (Throwable unused2) {
                decorView = null;
            }
            if (decorView == null) {
                return;
            }
            decorView.post(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (com.byazt.okk.s.qg() && TTBaseVideoActivity.this.g == 1 && TTBaseVideoActivity.this.u.getResources().getConfiguration().orientation == 1) {
                            int height = TTBaseVideoActivity.this.getWindow().getDecorView().getHeight();
                            if (iDr == 1) {
                                Rect rect = new Rect();
                                TTBaseVideoActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                                height = rect.bottom - rect.top;
                            }
                            if (Math.abs(com.byazt.okk.s.rv((Context) TTBaseVideoActivity.this.u) - height) == 0 && decorView.isAttachedToWindow()) {
                                View view = decorView;
                                view.setPadding(view.getPaddingLeft(), (int) (decorView.getPaddingTop() + com.byazt.okk.s.cp((Context) TTBaseVideoActivity.this.u)), decorView.getPaddingRight(), decorView.getPaddingBottom());
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            });
        }
    }

    @Override // com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void finish() {
        com.byazt.has.n nVar = this.dg;
        if (nVar != null) {
            nVar.cy();
        }
        Map<String, Object> mapPk = pk();
        qg qgVar = this.an;
        if (qgVar != null) {
            qgVar.n(mapPk);
            this.an.l();
        }
        com.byazt.has.n nVar2 = this.dg;
        if (nVar2 != null) {
            nVar2.qg(mapPk);
        }
        com.byazt.hm.n.w(this.ae, this.n, "click_close", mapPk);
        ur();
        super.finish();
    }

    public void d() {
        if (this.dg.lq()) {
            this.fi.n(3);
            this.fi.um();
            this.fi.s(true);
            n(false, false);
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        int i = message.what;
        int i2 = message.what;
        if (i2 == 300) {
            d();
            return;
        }
        if (i2 == 400) {
            this.fi.rv();
            if (this.dg.w()) {
                this.lh.n(true);
            }
            n(false, true);
            return;
        }
        if (i2 == 500) {
            this.an.fs();
            this.fi.fs();
            this.ln.s(false);
            this.lh.q(false);
            this.lh.s(false);
            return;
        }
        if (i2 == 600) {
            this.j.n(false, null, null, true, true);
            return;
        }
        if (i2 == 700) {
            this.an.v();
            return;
        }
        if (i2 == 1200) {
            if (cx.hd(this.ae)) {
                return;
            }
            if (this.an.ln()) {
                n(1, false);
                this.df.n(df(), this.dg.oj());
                s(0);
            }
            this.qg.sendEmptyMessageDelayed(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, 1000L);
            return;
        }
        if (i2 != 1300) {
            return;
        }
        this.qg.sendEmptyMessageDelayed(1300, this.pk.rv());
        if (hu()) {
            return;
        }
        this.pk.fs();
        if (!e()) {
            this.pk.x();
            if (nf().rv(true)) {
                this.fi.qg(((long) this.pk.l()) * 1000);
                this.lh.n(String.valueOf(Math.max(0, (int) (this.fi.t() - ((double) this.pk.l())))), this.pk.l(), 0, false);
            }
        }
        com.byazt.aq.q qVar = new com.byazt.aq.q();
        if (j.qg(t()) > 0) {
            int iL = j.l(this.ae) / 1000;
            int iQg = j.qg(t());
            if (iL < iQg) {
                iQg = iL;
            }
            if (iL - iQg <= this.dg.bb()) {
                qVar.n = true;
                qVar.qg = iQg;
            }
        }
        n(2, qVar);
        com.byazt.aq.q qVar2 = new com.byazt.aq.q();
        qVar2.n = true;
        n(3, qVar2);
        this.ic.x();
        this.dg.pe();
    }

    public void qg(int i) {
        if (i <= 0) {
            this.j.n(false, null, null, true, true);
        } else {
            this.qg.sendEmptyMessageDelayed(600, i);
        }
    }

    public void oa() {
        com.byazt.eji.s.n().n(this.ae, "stats_reward_full_completed", this.oj.n(new JSONObject()));
        if (this.tj.getAndSet(true)) {
            return;
        }
        n("onVideoComplete", (Bundle) null);
    }

    public void sz() {
        if (this.rv.getAndSet(true)) {
            return;
        }
        n("onVideoError", (Bundle) null);
    }

    public void k() {
        if (this.tj.get() || this.fs.getAndSet(true)) {
            return;
        }
        n("onSkippedVideo", (Bundle) null);
    }

    public void cy() {
        this.qg.removeMessages(700);
        this.qg.removeMessages(600);
    }

    public void n(long j) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 700;
        this.qg.sendMessageDelayed(messageObtain, j);
    }

    @Override // com.byazt.rv.n
    public void n(boolean z) {
        if (z) {
            if (this.lh.l()) {
                return;
            }
            this.dg.q(true);
            return;
        }
        if (this.lh.l() && this.fi.v() != null) {
            this.fi.v().n(8);
        }
        this.dg.q(false);
        if (this.lh.l() || this.g == 2 || !com.byazt.gks.n.n(this.ae)) {
            return;
        }
        this.ln.w(8);
    }

    public void qg(boolean z) {
        Message message = new Message();
        message.what = MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL;
        this.qg.sendMessageDelayed(message, z ? 2000L : 0L);
    }

    public void hd() {
        this.qg.removeMessages(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL);
    }

    private void ha() {
        if (this.an.an() || !this.m || e() || !this.dg.lq() || this.fi.f()) {
            return;
        }
        com.byazt.has.n nVar = this.dg;
        if ((nVar instanceof com.byazt.has.s) || (nVar instanceof com.byazt.has.tj)) {
            return;
        }
        this.qg.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
        this.qg.sendEmptyMessageDelayed(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, 5000L);
    }

    public int l(int i) {
        boolean z = i == 2;
        int iYj = this.ae.yj();
        if (iYj == 1) {
            return 1;
        }
        if (iYj != 3) {
            if (iYj == 4 || iYj == 5) {
                return z ? 1 : 3;
            }
            if (iYj == 6) {
                return z ? 1 : 4;
            }
            if (iYj == 7 && z && this.oa.get()) {
                return 1;
            }
        } else if (z) {
            return 1;
        }
        return 2;
    }

    public void w(int i) {
        int iL = l(i);
        if (i != 2) {
            if (this.df.q()) {
                return;
            }
            if (this.fi.d() && i == 1) {
                this.fi.tj();
                return;
            }
            if (cx.hd(this.ae)) {
                if (this.cp.get() && !this.d.get()) {
                    if (iL == 1 && !this.q.containsKey(0) && t()) {
                        this.j.qg((this.ae.rv() == 3 && cx.cd(this.ae)) ? "奖励就快来了\n去详情页看看也累计时长哦～" : "奖励还在路上狂奔\n再等一下下哦～");
                    }
                    this.fi.fi();
                }
                if (!this.cp.get() && this.d.get()) {
                    return;
                }
                if (iL == 1 && (!this.cp.get() || !this.d.get())) {
                    return;
                }
            }
        }
        if (iL == 1) {
            qg();
            return;
        }
        if (iL == 2) {
            if (this.x.get()) {
                this.an.ou();
            }
            l();
        } else if (iL == 3) {
            this.fi.fi();
        } else if (iL == 4 && i != 3) {
            cd();
        }
    }

    public void cd() {
        this.fi.tj();
    }

    public void n(boolean z, boolean z2) {
        this.fi.qg(z2);
        sz();
        if (z) {
            this.sz.set(true);
            if (cx.hd(this.ae)) {
                this.dg.lh();
            }
            this.j.n(false, null, null, true, true);
            l();
            return;
        }
        if (cx.py(this.ae)) {
            this.an.fi();
        } else {
            this.j.n(false, null, null, true, true);
            q(0);
        }
        if (this.fi.f()) {
            return;
        }
        if (cx.hd(this.ae)) {
            this.dg.lh();
        }
        l();
    }

    public void um() {
        l();
    }

    public byte a() {
        com.byazt.tkz.l lVar = this.lh;
        if (lVar != null) {
            return lVar.rv();
        }
        return (byte) 0;
    }

    public void py() {
        com.byazt.tkz.l lVar;
        if (this.ri == null || (lVar = this.lh) == null || lVar.d() == null) {
            return;
        }
        this.lh.d().setEasyPlayableSender(this.ri.qg());
        this.ri.n(an().getEasyPlayableContainer(), (View) null);
        this.lh.n(this.pk);
    }

    public void x(int i) {
        this.bb.n(i);
    }

    public boolean ou() {
        com.byazt.wg.qg qgVar = this.rf;
        if (qgVar != null) {
            return qgVar.s();
        }
        return false;
    }

    public void s(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.rf == null) {
            this.rf = new com.byazt.wg.qg(this.u, this.ae.pt(), this.n, true, com.byazt.imu.s.n());
            com.byazt.yo.s.n(this.u, this.ae, this.rf);
            this.rf.n(new com.byazt.wg.qg.n() { // from class: com.byazt.df.TTBaseVideoActivity.14
                @Override // com.byazt.wg.qg.n
                public void n() {
                    TTBaseVideoActivity.this.dg();
                }

                @Override // com.byazt.wg.qg.n
                public void n(int i, String str2, boolean z) {
                    TTBaseVideoActivity.this.qg.post(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TTBaseVideoActivity.this.u();
                        }
                    });
                }

                @Override // com.byazt.wg.qg.n
                public void qg() {
                    TTBaseVideoActivity.this.u();
                }
            });
        }
        this.rf.n(str);
        this.rf.n();
    }

    public void wm() {
        this.j.n(1);
        if (!cx.hd(this.ae)) {
            this.j.n(false, null, null, true, true);
        }
        this.j.n(true);
        this.j.l(true);
        this.j.w(false);
        this.j.qg(this.ae.yv());
        this.df.n(this.wm, this.q.containsKey(0));
        this.qg.sendEmptyMessage(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebLoginFragment.QUERY_KEY_ID, 1);
            this.lh.n("playableStateChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void m() {
        this.df.s();
        this.an.ae();
        this.j.n(1);
        this.qg.removeMessages(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebLoginFragment.QUERY_KEY_ID, 0);
            if (t()) {
                jSONObject.put("reduce_duration", this.dg.rf());
            }
            this.lh.n("playableStateChange", jSONObject);
        } catch (Exception unused) {
        }
        if (!this.ic.n(1)) {
            this.k.set(true);
        }
        n(1, (com.byazt.aq.q) null);
    }

    public boolean hu() {
        return ju() || ou() || this.dg.j() || this.np;
    }

    public void rv(int i) {
        if (this.pe == null) {
            return;
        }
        com.byazt.zq.qg qgVarN = com.byazt.tf.n.n().n(this.ae, com.byazt.vgx.w.n(this.ae, ""));
        this.pe.qg(true);
        this.pe.n(i, qgVarN);
    }

    public void n(int i, com.byazt.aq.q qVar) {
        if (com.byazt.qq.qg.s(this.ae) || this.oa.get() || this.rv.get()) {
            return;
        }
        int iTj = 0;
        if (i == 1) {
            if (!this.k.get()) {
                return;
            }
            if (qVar == null || !qVar.n) {
                this.k.set(false);
            }
        }
        int iN = this.ic.n(i, qVar != null && qVar.q);
        if (iN == 0) {
            return;
        }
        if (iN == 3 && qVar != null && qVar.s) {
            iTj = j.tj();
        }
        this.ic.n(new com.byazt.aq.s.n().n(this.sh).n(this.dg.oj()).qg(iTj).n(this.tj.get()).n(this.q.keySet()).qg(this.wm).n(this.ci).s(iN).q(this.dg.bb()).s(this.ic.q() ? this.dn : pk.s(this.ae)).n(), iN, qVar);
    }

    public boolean h() {
        if (hu() || this.fi.f()) {
            return false;
        }
        com.byazt.has.n nVar = this.dg;
        if ((nVar != null && !nVar.lq()) || this.df.q() || this.an.an()) {
            return false;
        }
        if (this.fi.ou()) {
            if ((!this.fi.s() && !this.fi.qg()) || this.fi.qg()) {
                return false;
            }
            this.fi.s();
        }
        return true;
    }

    private void g() {
        final View decorView;
        try {
            decorView = getWindow().getDecorView();
        } catch (Throwable unused) {
            decorView = null;
        }
        if (decorView == null) {
            return;
        }
        decorView.post(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        });
        decorView.postDelayed(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, tj tjVar) {
        n(2);
        this.f.n(view, this.su, tjVar);
    }

    @Override // com.byazt.rv.n
    public void n(int i) {
        this.um.set(true);
        if (System.currentTimeMillis() - this.r > 50) {
            this.r = System.currentTimeMillis();
            n("onAdVideoBarClick", (Bundle) null);
        }
        if (!isFinishing()) {
            rv.n(this.lh.d());
        }
        if (!this.w.get()) {
            this.w.set(true);
        }
        if (!this.ic.n(1)) {
            this.k.set(true);
        }
        s(0);
        tj(i);
    }

    public void tj(int i) {
        com.byazt.zx.qg qgVarF;
        com.byazt.tkz.l lVar;
        com.byazt.has.n nVar = this.dg;
        if ((nVar instanceof fs) && (qgVarF = nVar.f()) != null && qgVarF.cp() == 1 && i == 1) {
            if (this.o.getAndSet(false)) {
                int iA = ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).a();
                float fX = com.byazt.okk.s.x(com.byazt.nf.rv.getContext());
                float fFs = com.byazt.okk.s.fs(com.byazt.nf.rv.getContext());
                Map<String, Object> mapPk = pk();
                mapPk.putAll(qgVarF.x());
                com.byazt.gct.rv.n nVarQg = new com.byazt.gct.rv.n().w(-1.0f).l(-1.0f).q(-1.0f).s(-1.0f).qg(-1L).n(-1L).q(-1).l(-1).w(-1024).s(com.byazt.vyf.s.cy().qg() ? 1 : 2).qg(iA).n(fX).qg(fFs);
                if (this.ae != null && this.ae.ys() == 1 && (lVar = this.lh) != null) {
                    nVarQg.n(lVar.l() ? this.lh.rv() : (byte) 0);
                }
                nVarQg.n(com.byazt.oh.l.qg(this.ae));
                com.byazt.hm.n.n("click", this.ae, nVarQg.n(), this.n, true, mapPk, -1, false, false);
            }
        }
    }

    public void qg(boolean z, boolean z2) {
        ry().n(z, z2);
    }

    public void s(boolean z, boolean z2) {
        ry().qg(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, boolean z2) {
        if (z) {
            Map<String, Object> mapFs = fs();
            this.kc.set(true);
            mapFs.put("is_adm", Boolean.valueOf(this.t));
            mapFs.put("is_play_again", Boolean.valueOf(bb()));
            mapFs.put("if_cache_callback", Integer.valueOf(this.ur == 1 ? 1 : 0));
            mapFs.put("src_req_id", this.ae.dr());
            mapFs.put("is_map", Boolean.valueOf(this.ae.cj()));
            mapFs.put("is_repeat", Boolean.valueOf(this.cd.getAndSet(true)));
            com.byazt.hm.n.n(this.ae, this.n, mapFs, this.ta);
            this.oj.l().n(1.0f, 11);
            com.byazt.hnb.qg.n().q();
            com.byazt.cd.s.n(this.ae.v());
        }
        if (z2) {
            if (!j.qg(t(), this.ae, true)) {
                boolean zIt = com.byazt.nf.rv.qg().it();
                if (!this.hd.getAndSet(true) || zIt) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("has_show_event", this.kc.get());
                    n("onAdShow", bundle);
                } else {
                    com.byazt.eji.s.n().q(this.ae, "stats_callback_repeat");
                }
            }
            if (this.dg.w()) {
                this.lh.w();
            }
            com.byazt.tx.qg qgVar = this.ri;
            if (qgVar != null && qgVar.qg() != null) {
                this.ri.qg().q();
            }
            if (this.ae.ur() && this.ae.sz() != null) {
                com.byazt.rl.n.n().n(getApplicationContext(), this.ae.sz().qg());
            }
        }
        s(false);
    }

    private com.byazt.nj.l ry() {
        if (this.z == null) {
            this.z = new com.byazt.nj.l(new com.byazt.nj.l.n() { // from class: com.byazt.df.TTBaseVideoActivity.17
                @Override // com.byazt.nj.l.n
                public Context getContext() {
                    return TTBaseVideoActivity.this;
                }

                @Override // com.byazt.nj.l.n
                public ViewGroup n() {
                    return TTBaseVideoActivity.this.bb;
                }

                @Override // com.byazt.nj.l.n
                public pk qg() {
                    return TTBaseVideoActivity.this.ae;
                }

                @Override // com.byazt.nj.l.n
                public String s() {
                    return TTBaseVideoActivity.this.n;
                }

                @Override // com.byazt.nj.l.n
                public boolean q() {
                    return TTBaseVideoActivity.this.t();
                }

                @Override // com.byazt.nj.l.n
                public boolean l() {
                    return TTBaseVideoActivity.this.isFinishing();
                }

                @Override // com.byazt.nj.l.n
                public void n(boolean z, boolean z2) {
                    TTBaseVideoActivity.this.q(z, z2);
                }
            });
        }
        return this.z;
    }

    private boolean ju() {
        com.byazt.aqe.qg.n nVar = this.wv;
        return nVar != null && nVar.q();
    }

    public boolean qg(long j, boolean z) {
        this.fi.n(this.b);
        this.fi.n(this.dg.a(), t());
        if (this.fl != null) {
            com.byazt.ikv.qg.qg(this.ae.ih(), this.fl, com.byazt.zct.n.InterfaceC0409n.class);
        }
        this.fi.qg(fs());
        if (this.dg.w()) {
            this.lh.n(this.fi.an());
        }
        this.fi.n(this.cx);
        boolean zN = n(j, z);
        if (zN && !z) {
            this.dh = (int) (System.currentTimeMillis() / 1000);
        }
        return zN;
    }

    public RewardFullBaseLayout an() {
        return this.bb;
    }

    public void n(Intent intent) {
        if (intent != null) {
            this.y = intent.getStringExtra("rit_scene");
            this.hu = intent.getBooleanExtra("is_preload", false);
            this.h = intent.getLongExtra("object_create_ts", 0L);
            this.t = intent.getBooleanExtra("is_adm", false);
            this.sh = intent.getStringExtra("multi_process_key");
            this.ur = intent.getIntExtra("key_video_cache_callback", -1);
            String stringExtra = intent.getStringExtra("_client_bidding_aution_price");
            this.ta = TextUtils.isEmpty(stringExtra) ? null : Double.valueOf(Double.parseDouble(stringExtra));
            com.byazt.pnj.n nVar = this.pe;
            if (nVar != null) {
                nVar.n(intent.getBooleanExtra("is_second_page", false));
            }
        }
    }

    public void qg(Bundle bundle) {
        if (bundle != null) {
            this.sh = bundle.getString("multi_process_key");
            this.hu = bundle.getBoolean("is_preload");
            this.h = bundle.getLong("object_create_ts");
            this.t = bundle.getBoolean("is_adm");
            this.ur = bundle.getInt("key_video_cache_callback", -1);
            this.y = bundle.getString("rit_scene");
            String string = bundle.getString("_client_bidding_aution_price");
            this.ta = TextUtils.isEmpty(string) ? null : Double.valueOf(Double.parseDouble(string));
            this.wm = bundle.getBoolean("is_mute");
            long j = bundle.getLong("video_current");
            if (j > 0) {
                this.fi.n(j);
            }
        }
    }

    public void qg(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getStringExtra("insert_ad_bundle"))) {
            return;
        }
        com.byazt.aq.s sVar = new com.byazt.aq.s(intent.getStringExtra("insert_ad_bundle"));
        this.sh = sVar.n();
        if (j.n(this.ae) == 1) {
            this.he = sVar.tj();
        }
        this.dn = sVar.cp();
        this.tj.set(sVar.q());
        this.q.putAll(sVar.fs());
        this.ic.n(sVar);
        this.wm = sVar.l();
        this.ci.s(sVar.w());
    }

    public void ae() {
        boolean z = !this.wm;
        this.wm = z;
        this.dg.l(z);
    }

    public void f() {
        this.df.qg();
    }

    public t fi() {
        return this.qg;
    }

    public void n(int i, boolean z) {
        d(i);
        if (z) {
            cp(i);
        }
    }

    public void cp(int i) {
        if (this.lh != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", i);
            } catch (JSONException unused) {
            }
            this.lh.n("reduceTime", jSONObject);
        }
    }

    public void d(int i) {
        this.dg.s(i);
        s(0);
    }

    public int df() {
        return Math.max(this.dg.dh() - (((int) (this.fi.bb() / 1000)) + this.dg.rf()), 0);
    }

    public void oa(int i) {
        this.ln.l(i);
    }

    public void oj() {
        this.qg.removeMessages(600);
    }

    public void n(float f, float f2, float f3, float f4, int i) {
        com.byazt.tkz.l lVar = this.lh;
        if (lVar == null || lVar.n() == null) {
            return;
        }
        int measuredWidth = this.lh.n().getMeasuredWidth();
        int measuredHeight = this.lh.n().getMeasuredHeight();
        if (this.fi.an() instanceof com.byazt.zx.n ? ((com.byazt.zx.n) this.fi.an()).dh() : false) {
            this.lh.n().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(i);
        this.lh.n().startAnimation(scaleAnimation);
    }

    public void sz(int i) {
        com.byazt.has.n nVar;
        com.byazt.tkz.l lVar;
        if (this.fi.qg()) {
            HashMap map = new HashMap();
            map.put("pause_from", Integer.valueOf(i));
            this.fi.n(map);
            q("paused");
        }
        this.qg.removeMessages(TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
        this.qg.removeMessages(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        cy(i);
        if ((e() && cx.hd(this.ae) && this.df.q()) || (nVar = this.dg) == null) {
            return;
        }
        nVar.wm();
        this.an.qg(e());
        if (i == 1 || (lVar = this.lh) == null) {
            return;
        }
        lVar.l(hu());
    }

    public void dg() {
        sz(0);
    }

    public void u() {
        k(0);
    }

    public void k(int i) {
        com.byazt.tkz.l lVar;
        hd(i);
        if (this.dg instanceof fs) {
            this.qg.postDelayed(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.18
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.ta();
                }
            }, 500L);
        } else {
            ta();
        }
        if (!hu()) {
            if (this.an.ln()) {
                this.qg.sendEmptyMessageDelayed(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, 1000L);
            }
            if (!e() || this.an.an() || this.an.ln()) {
                this.dg.m();
            }
            this.an.q();
        }
        if (i == 1 || (lVar = this.lh) == null) {
            return;
        }
        lVar.l(hu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta() {
        if (h()) {
            ha();
            this.fi.n(false, this);
            q("playing");
        }
    }

    public Map<String, Object> pk() {
        return n(this.ae);
    }

    public Map<String, Object> n(pk pkVar) {
        HashMap map = new HashMap();
        String str = this.y;
        if (str != null) {
            map.put("rit_scene", str);
        }
        map.put("insert_ad_control", Integer.valueOf(j.n(pkVar)));
        map.put("carousel_pos", Integer.valueOf(j.q(pkVar)));
        map.put("refresh_ad_control", Integer.valueOf(j.qg(pkVar)));
        if (this.ic.qg() != 0) {
            map.put("carousel_type", Integer.valueOf(this.ic.qg()));
        } else if (pe.fs(pkVar)) {
            map.put("carousel_type", 4);
        }
        s sVar = this.oj;
        if (sVar != null) {
            sVar.n(map);
        }
        return map;
    }

    public Double wo() {
        return this.ta;
    }

    public void n(pk pkVar, com.byazt.ys.qg qgVar) {
        this.an.n(pkVar, qgVar);
        this.df.n(pkVar);
    }

    public void y() {
        if (this.cp.getAndSet(true)) {
            return;
        }
        w(1);
    }

    public void rf() {
        if (this.d.getAndSet(true)) {
            return;
        }
        w(3);
    }

    public boolean dh() {
        return this.df.q() || this.an.an() || !cx.s(this.ae, this.dg.x());
    }

    public com.byazt.re.w b() {
        return this.fi;
    }

    public s ri() {
        return this.oj;
    }

    public com.byazt.has.n nf() {
        return this.dg;
    }

    public boolean pe() {
        return this.q.containsKey(0);
    }

    public boolean e() {
        com.byazt.has.n nVar = this.dg;
        return (nVar != null && nVar.el()) || !this.l.isEmpty();
    }

    public void cy(int i) {
        if (i == 0) {
            return;
        }
        this.l.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public void hd(int i) {
        if (i == 0) {
            return;
        }
        this.l.remove(Integer.valueOf(i));
    }

    public void yw() {
        this.j.w();
    }

    public void cx() {
        this.um.set(true);
    }

    public void n(final int i, final int i2) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.df.TTBaseVideoActivity.19
            @Override // java.lang.Runnable
            public void run() {
                if (i == 0) {
                    TTBaseVideoActivity.this.ic.s();
                }
                if (i == 1) {
                    int i3 = i2;
                    if (i3 == 1) {
                        TTBaseVideoActivity.this.oa();
                    } else if (i3 == 2) {
                        TTBaseVideoActivity.this.w(1);
                    }
                }
                if (i == 2) {
                    int i4 = i2;
                    if (i4 == 1 || i4 == 2) {
                        TTBaseVideoActivity.this.py.set(false);
                    } else {
                        TTBaseVideoActivity.this.py.set(true);
                    }
                }
            }
        });
    }

    public void lq() {
        q("finished");
        if (!this.fi.lh() && !this.fi.d()) {
            wv();
        }
        w(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str) {
        com.byazt.tkz.l lVar = this.lh;
        if (lVar != null) {
            lVar.n(str);
        }
    }

    private void wv() {
        if (cd.q(this.ae)) {
            this.fi.fi();
            return;
        }
        oa();
        if (!cx.hd(this.ae) && !this.dg.rv(false)) {
            s(0);
            this.j.n(false, null, null, true, true);
        } else {
            y();
        }
        if (cx.x(this.ae) && this.fi.a() >= cx.tj(this.ae)) {
            s(2);
        }
        this.dg.ae();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xi() {
        return (this.ae.ge() == 180 && cx.hd(this.ae) && com.byazt.ql.s.n(this.ae) && this.lh.fs() == 7) ? false : true;
    }

    public void qg(int i, int i2) {
        this.ic.n(i, i2, 0);
    }

    public void n(int i, int i2, int i3) {
        this.ic.n(i, i2, i3);
    }

    public void ic() {
        this.ic.qg(false);
    }

    public void ci() {
        this.dg.ri();
    }

    public void hf() {
        this.ic.n(this.bb);
    }

    public boolean kc() {
        return this.tj.get();
    }

    public void q(boolean z) {
        this.np = z;
    }
}
