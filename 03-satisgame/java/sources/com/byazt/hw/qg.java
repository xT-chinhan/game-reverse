package com.byazt.hw;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.gct.el;
import com.byazt.gct.fl;
import com.byazt.gct.g;
import com.byazt.gct.h;
import com.byazt.gct.nf;
import com.byazt.gct.oa;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.tj;
import com.byazt.gct.wm;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.iag.s;
import com.byazt.jr.q;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.se.rv;
import com.byazt.sj.l;
import com.byazt.tk.k;
import com.byazt.za.ExpressVideoView;
import com.byazt.za.NativeExpressVideoView;
import com.byazt.za.NativeExpressView;
import com.byazt.za.SplashExpressBackupView;
import com.byazt.za.bb;
import com.byazt.za.w;
import com.byazt.za.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 203, 26})
public class qg extends n implements s.q, s.InterfaceC0200s, com.byazt.cs.n.InterfaceC0149n, n.qg {
    public SlideInterceptView b;
    public Context dg;
    public l.qg dh;
    public volatile w nf;
    public NativeExpressView oj;
    public String pk;
    public com.byazt.tx.n rf;
    public volatile x ri;
    public com.byazt.zq.qg u;
    public int wo;
    public WeakReference<ViewGroup> y;
    public final AtomicBoolean sh = new AtomicBoolean(false);
    public final SlideInterceptView.n pe = new SlideInterceptView.n() { // from class: com.byazt.hw.qg.1
        @Override // com.byazt.hw.SlideInterceptView.n
        public void n(View view, tj tjVar) {
            if (qg.this.l != null) {
                qg.this.l.n(view, tjVar);
            }
            qg.this.cy();
        }

        @Override // com.byazt.hw.SlideInterceptView.n
        public w n() {
            return qg.this.nf;
        }
    };

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void n(long j, long j2) {
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void s_() {
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void t_() {
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void u_() {
    }

    @Override // com.byazt.cs.n.InterfaceC0149n
    public boolean ur() {
        return false;
    }

    @Override // com.byazt.iag.s.q
    public void w_() {
    }

    public qg(Context context, com.byazt.zq.qg qgVar, String str, int i, com.byazt.se.s sVar, q<rv, com.byazt.se.x> qVar, com.byazt.mz.n nVar) {
        if (sVar != null) {
            this.qg = sVar.qg();
            com.byazt.de.qg.n(sVar.qg(), sVar.x(), com.byazt.vgx.w.d(sVar.qg()), qg());
        }
        this.dg = context;
        this.u = qgVar;
        this.pk = str;
        this.wo = i;
        this.x = this;
        n(sVar, qVar, nVar);
        qg(qVar);
    }

    private void qg(final q<rv, com.byazt.se.x> qVar) {
        try {
            com.byazt.hi.l.n(new Runnable() { // from class: com.byazt.hw.qg.3
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    qg.this.n(qVar);
                    qg.this.bb();
                    System.currentTimeMillis();
                }
            });
        } catch (Throwable th) {
            k.qg("splrender", th.getMessage());
        }
    }

    public void n(com.byazt.se.s sVar, q<rv, com.byazt.se.x> qVar) {
        this.oa = 3;
        s(qVar);
        hd();
    }

    public void qg(int i) {
        this.wo = i;
    }

    private void a() {
        if (this.qg.ys() == 2) {
            this.oj = new NativeExpressView(true, this.dg, this.qg, this.u, this.pk, true);
        } else {
            this.oj = new NativeExpressView(false, this.dg, this.qg, this.u, this.pk, true);
        }
    }

    private void py() {
        if (this.qg.ys() == 2) {
            this.oj = new NativeExpressVideoView(true, this.dg, this.qg, this.u, this.pk);
        } else {
            this.oj = new NativeExpressVideoView(false, this.dg, this.qg, this.u, this.pk);
        }
        if (this.oj.getVideoController() instanceof com.byazt.ia.q) {
            this.lh = (com.byazt.ia.q) this.oj.getVideoController();
        }
        ExpressVideoView expressVideoView = this.oj.getExpressVideoView();
        if (expressVideoView != null && this.qg != null) {
            com.byazt.ikv.qg.qg(this.qg.ih(), expressVideoView, NativeVideoTsView.class);
        }
        if (this.df != null) {
            this.oj.setEasyPlayableSender(this.df.qg());
        }
        this.oj.setVideoAdListener(this);
        this.oj.setVideoAdInteractionListener(this);
    }

    private void s(final q<rv, com.byazt.se.x> qVar) {
        if (qVar == null || this.qg == null) {
            return;
        }
        if (this.bb) {
            this.py = true;
            py();
        } else {
            this.py = false;
            a();
        }
        if (this.hu != null) {
            this.hu.n(this);
        }
        NativeExpressView nativeExpressView = this.oj;
        if (nativeExpressView == null) {
            this.hu.qg(3);
            this.hu.n("no render express");
            qVar.n(this.hu);
        } else {
            nativeExpressView.setBackupListener(new com.byazt.udb.s() { // from class: com.byazt.hw.qg.4
                @Override // com.byazt.udb.s
                public boolean n(ViewGroup viewGroup, int i) {
                    try {
                        SplashExpressBackupView splashExpressBackupView = new SplashExpressBackupView(qg.this.dg);
                        splashExpressBackupView.n(qg.this.ur, qg.this.qg, (NativeExpressView) viewGroup);
                        if (splashExpressBackupView.getVideoController() instanceof com.byazt.ia.q) {
                            qg.this.lh = (com.byazt.ia.q) splashExpressBackupView.getVideoController();
                        }
                        splashExpressBackupView.setVideoAdListener(qg.this);
                        qg.this.oa();
                        if (qg.this.n == null) {
                            return true;
                        }
                        qg.this.n.n();
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            this.oa = 3;
            this.oj.setExpressInteractionListener(new com.byazt.za.n() { // from class: com.byazt.hw.qg.5
                @Override // com.byazt.za.n
                public void n(View view, int i) {
                    com.byazt.de.qg.s(qg.this.qg());
                    com.byazt.hm.n.qg(qg.this.cy, qg.this.qg);
                    if (qg.this.fs != null) {
                        qg.this.fs.qg(qg.this);
                    }
                    qg.this.d();
                    qg.this.cy();
                }

                @Override // com.byazt.za.n
                public void n(View view, final String str, int i) {
                    final Runnable runnable = new Runnable() { // from class: com.byazt.hw.qg.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                k.qg(MediationConstant.RIT_TYPE_SPLASH, "onRenderFail:" + str);
                                qg.this.hu.qg(3);
                                qg.this.hu.n("render splash express fail");
                                qVar.n(qg.this.hu);
                            } catch (Throwable unused) {
                            }
                        }
                    };
                    com.byazt.hi.l.n(new Runnable() { // from class: com.byazt.hw.qg.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.ag.qg.n(runnable);
                        }
                    });
                }

                @Override // com.byazt.za.n
                public void n(final View view, final float f, final float f2) {
                    com.byazt.eo.n.n("Splash_FullLink", "CSJSplashExpressRender- onRenderSuccess");
                    final Runnable runnable = new Runnable() { // from class: com.byazt.hw.qg.5.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.byazt.eo.n.n("Splash_FullLink", "CSJSplashExpressRender- runOnUiThread - onRenderSuccess");
                                if (view != null && f > 0.0f && f2 > 0.0f) {
                                    rv rvVar = new rv(qg.this.v.get(), qg.this);
                                    boolean zPy = qg.this.oj.py();
                                    if (qg.this.oj != null && !zPy) {
                                        qg.this.n.setComplianceBarVisibility(8);
                                    }
                                    rvVar.n(zPy);
                                    qg.this.f.set(zPy ? 1 : 2);
                                    qg.this.h.set(true);
                                    qg.this.n.setExpressView(qg.this.oj);
                                    qg.this.sh.set(true);
                                    if (qg.this.t.get()) {
                                        qg.this.n((WeakReference<ViewGroup>) qg.this.y);
                                        qg.this.t.set(false);
                                    }
                                    if (!qg.this.rv.get() && !zPy && fl.n(qg.this.qg)) {
                                        qg.this.m();
                                    }
                                    qVar.qg(rvVar);
                                    qg.this.oj.setEasyPlayableSender(qg.this.df.qg());
                                    qg.this.df.n(qg.this.n.getEasyPlayableLayout(), qg.this.oj.getVideoContainer());
                                    qg.this.hu();
                                    qg.this.ou();
                                    return;
                                }
                                qg.this.hu.qg(3);
                                qg.this.hu.n("render splash view error");
                                qVar.n(qg.this.hu);
                            } catch (Throwable th) {
                                k.qg(MediationConstant.RIT_TYPE_SPLASH, "onRenderFail:" + th.getMessage());
                            }
                        }
                    };
                    com.byazt.hi.l.n(new Runnable() { // from class: com.byazt.hw.qg.5.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.ag.qg.n(runnable);
                        }
                    });
                }
            });
        }
    }

    @Override // com.byazt.hw.n, com.byazt.fvm.qg
    public void n(ViewGroup viewGroup) {
        com.byazt.de.qg.qg(qg());
        if (viewGroup == null) {
            k.qg(MediationConstant.RIT_TYPE_SPLASH, "展示开屏的容器不能为空");
            return;
        }
        wm();
        WeakReference<ViewGroup> weakReference = new WeakReference<>(viewGroup);
        this.y = weakReference;
        if (this.h.get() && this.n != null) {
            n(weakReference);
        } else {
            this.t.set(true);
        }
    }

    private void n(JSONArray jSONArray, View view) {
        if (view == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TapEventParamConstants.PARAM_NAME, view.getClass().getSimpleName());
            jSONObject.put("id", view.getId());
            if (view instanceof ViewGroup) {
                JSONArray jSONArray2 = new JSONArray();
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    n(jSONArray2, viewGroup.getChildAt(i));
                }
                jSONObject.put("children", jSONArray2);
            }
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(WeakReference<ViewGroup> weakReference) {
        ViewGroup viewGroup;
        if (weakReference == null || (viewGroup = weakReference.get()) == null) {
            return;
        }
        if (this.n.getParent() != null) {
            ((ViewGroup) this.n.getParent()).removeView(this.n);
        }
        try {
            viewGroup.addView(this.n);
        } catch (Exception e) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                n(jSONArray, this.n);
                jSONObject.put("root", jSONArray);
                k.qg(MediationConstant.RIT_TYPE_SPLASH, "showTsView.addView:" + e.getMessage());
                com.byazt.eji.s.n().n("splash_add_view_error", jSONObject, e);
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ou() {
        final el elVarBr = this.qg.br();
        if (elVarBr == null || this.n == null) {
            return;
        }
        if ((this.f.get() != 1 || elVarBr.hd() == 1) && elVarBr.cy() > 0.0f) {
            this.n.postDelayed(new Runnable() { // from class: com.byazt.hw.qg.6
                @Override // java.lang.Runnable
                public void run() {
                    int iHu;
                    View rootView = qg.this.n.getRootView();
                    if (rootView instanceof FrameLayout) {
                        ViewGroup viewGroup = (ViewGroup) rootView;
                        int height = qg.this.n.getHeight();
                        int iRv = com.byazt.okk.s.rv(qg.this.dg);
                        if (elVarBr.cy() >= 1.0f) {
                            float f = iRv;
                            if (height <= elVarBr.cy() * f && !qg.this.cp) {
                                if (elVarBr.a() == 1) {
                                    iHu = iRv - height;
                                } else {
                                    iHu = elVarBr.hu() > 0.0f ? (int) (f * elVarBr.hu()) : 0;
                                }
                                qg.this.b = new SlideInterceptView(qg.this.dg, elVarBr, qg.this.pe);
                                if (iHu <= 0) {
                                    iHu = -1;
                                }
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iHu);
                                layoutParams.gravity = 80;
                                viewGroup.addView(qg.this.b, layoutParams);
                            }
                        }
                    }
                }
            }, elVarBr.py());
        }
    }

    @Override // com.byazt.hw.n
    public void cy() {
        try {
            SlideInterceptView slideInterceptView = this.b;
            if (slideInterceptView == null) {
                return;
            }
            slideInterceptView.n();
            if (((ViewGroup) this.b.getParent()) == null) {
                return;
            }
            this.b.post(new Runnable() { // from class: com.byazt.hw.qg.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) qg.this.b.getParent();
                        if (viewGroup == null) {
                            return;
                        }
                        viewGroup.removeView(qg.this.b);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.hw.n, com.byazt.fvm.qg
    public View s() {
        if (this.an == -1) {
            this.an = 0;
        }
        return this.n;
    }

    public void hd() {
        NativeExpressView nativeExpressView = this.oj;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.x(this.wo);
        this.oj.cy();
    }

    @Override // com.byazt.hw.n.qg
    public void z_() {
        if (this.qg == null || this.um == null) {
            return;
        }
        if (nf.n(this.qg) == 2) {
            if (this.sh.get()) {
                NativeExpressView nativeExpressView = this.oj;
                if (nativeExpressView != null) {
                    nativeExpressView.k();
                    bb.n(this.um, this.qg, this.oj);
                }
                this.um.put("splash_show_type", 3);
            }
        } else if (!this.bb) {
            this.um.put("splash_show_type", 0);
        } else {
            if (TextUtils.isEmpty(ta.n(this.qg))) {
                this.um.put("splash_show_type", 2);
            }
            this.um.put("splash_show_type", 1);
        }
        n(this.qg);
    }

    private void n(pk pkVar) {
        if (this.oj == null || pkVar == null) {
            return;
        }
        Context context = this.dg;
        String str = this.pk;
        this.ri = new x(context, pkVar, str, com.byazt.vgx.w.q(str));
        this.ri.n(this.oj);
        ((com.byazt.zct.n) this.ri.n(com.byazt.zct.n.class)).n(this.s);
        ((com.byazt.fq.n) this.ri.n(com.byazt.fq.n.class)).n(this.tj);
        this.oj.setClickListener(this.ri);
        Context context2 = this.dg;
        String str2 = this.pk;
        this.nf = new w(context2, pkVar, str2, com.byazt.vgx.w.q(str2));
        ((com.byazt.zct.n) this.nf.n(com.byazt.zct.n.class)).n(this);
        this.nf.n(this.oj);
        ((com.byazt.zct.n) this.nf.n(com.byazt.zct.n.class)).n(this.s);
        ((com.byazt.fq.n) this.nf.n(com.byazt.fq.n.class)).n(this.tj);
        this.oj.setClickCreativeListener(this.nf);
        if (this.s != null) {
            this.s.setVideoDataListener(this);
        }
    }

    @Override // com.byazt.hw.n
    public void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter) {
        super.n(iTTInnerDownloadAdapter);
        if (this.ri != null) {
            ((com.byazt.zct.n) this.ri.n(com.byazt.zct.n.class)).n(iTTInnerDownloadAdapter);
        }
        if (this.nf != null) {
            ((com.byazt.zct.n) this.nf.n(com.byazt.zct.n.class)).n(iTTInnerDownloadAdapter);
        }
        if (this.s != null) {
            this.s.setVideoDataListener(this);
        }
    }

    @Override // com.byazt.hw.n, com.byazt.hi.TsView.n
    public void n(boolean z) {
        super.n(z);
        com.byazt.tx.n nVar = this.rf;
        if (nVar != null) {
            nVar.n(z);
        }
    }

    @Override // com.byazt.cs.n.InterfaceC0149n
    public com.byazt.cs.n t() {
        NativeExpressView nativeExpressView;
        com.byazt.cs.n nVar = new com.byazt.cs.n();
        s videoController = this.lh;
        if (videoController == null && (nativeExpressView = this.oj) != null) {
            videoController = nativeExpressView.getVideoController();
        }
        if (videoController != null) {
            nVar.x = videoController.cp();
            nVar.n = videoController.a();
            nVar.fs = videoController.um();
        }
        return nVar;
    }

    @Override // com.byazt.iag.s.q
    public void a_(int i, int i2) {
        this.wm = false;
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void v_() {
        com.byazt.de.qg.s(qg(), 1);
        this.wm = false;
        com.byazt.hm.n.qg(this.cy, this.qg);
        if (this.fs != null) {
            this.cp = true;
            this.fs.n(this, 4);
            s(false);
        }
        k();
    }

    @Override // com.byazt.hw.n, com.byazt.hi.TsView.n
    public void tj() {
        super.tj();
        NativeExpressView nativeExpressView = this.oj;
        if (nativeExpressView != null) {
            nativeExpressView.oa();
        }
        this.oj = null;
        this.x = null;
        this.w = null;
        if (this.tj != null) {
            this.tj.clear();
        }
        if (this.df != null) {
            this.df.s();
        }
        com.byazt.tx.n nVar = this.rf;
        if (nVar != null) {
            nVar.qg();
        }
        l.qg qgVar = this.dh;
        if (qgVar != null) {
            l.qg(qgVar);
            this.dh = null;
        }
        cy();
        s(false);
        k();
    }

    private void wm() {
        if (this.an > 0) {
            return;
        }
        if (this.j == 1) {
            this.an = 1;
        } else {
            this.an = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        NativeExpressView nativeExpressView = this.oj;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.qg(this.d, 0);
        this.oj.setDynamicSkipListener(new com.byazt.pi.s() { // from class: com.byazt.hw.qg.8
            @Override // com.byazt.pi.s
            public void n() {
                qg.this.cp();
            }
        });
        this.n.qg();
        this.fi = new com.byazt.pi.qg();
        this.fi.n(this.d);
        this.fi.n(new com.byazt.pi.qg.n() { // from class: com.byazt.hw.qg.9
            @Override // com.byazt.pi.qg.n
            public void n() {
                qg.this.sz();
            }

            @Override // com.byazt.pi.qg.n
            public void n(int i) {
                if (qg.this.oj != null) {
                    qg.this.oj.qg(qg.this.d, i);
                }
            }
        });
        if (this.ae.get()) {
            this.fi.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu() {
        if (this.qg == null || this.qg.tk() == null) {
            return;
        }
        com.byazt.tx.n nVar = new com.byazt.tx.n(this.qg);
        this.rf = nVar;
        if (nVar.n()) {
            l.qg qgVar = new l.qg() { // from class: com.byazt.hw.qg.10
                @Override // com.byazt.sj.l.qg
                public void n() {
                    qg.this.cd();
                }

                @Override // com.byazt.sj.l.qg
                public void qg() {
                    qg.this.um();
                }
            };
            this.dh = qgVar;
            l.n(qgVar);
            NativeExpressView nativeExpressView = this.oj;
            ViewGroup gameContainer = nativeExpressView != null ? nativeExpressView.getGameContainer() : null;
            if (gameContainer instanceof FrameLayout) {
                this.rf.n((FrameLayout) gameContainer, (View) gameContainer);
            }
        }
    }

    public void cd() {
        com.byazt.pi.q countDownView = this.n != null ? this.n.getCountDownView() : null;
        if (this.fi != null) {
            this.fi.qg();
        }
        if (countDownView != null) {
            countDownView.qg();
        }
    }

    public void um() {
        com.byazt.pi.q countDownView = this.n != null ? this.n.getCountDownView() : null;
        if (this.fi != null) {
            this.fi.s();
        }
        if (countDownView != null) {
            countDownView.s();
        }
    }

    private void h() {
        com.byazt.tx.n nVar = this.rf;
        if (nVar != null) {
            nVar.qg();
        }
    }

    @Override // com.byazt.hw.n
    public void cp() {
        h();
        super.cp();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.qg.s(qg(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        this.df = new com.byazt.tx.qg(this.qg, new com.byazt.rg.n() { // from class: com.byazt.hw.qg.2
            @Override // com.byazt.za.d
            public void l() {
            }

            @Override // com.byazt.za.d
            public long n() {
                return 0L;
            }

            @Override // com.byazt.za.d
            public void n(float f) {
            }

            @Override // com.byazt.za.d
            public void n(int i) {
            }

            @Override // com.byazt.za.d
            public void n(int i, int i2) {
            }

            @Override // com.byazt.za.d
            public void n(int i, String str) {
            }

            @Override // com.byazt.za.d
            public void n(pk pkVar) {
            }

            @Override // com.byazt.za.d
            public void q() {
            }

            @Override // com.byazt.za.d
            public int qg() {
                return 0;
            }

            @Override // com.byazt.za.d
            public void qg(int i) {
            }

            @Override // com.byazt.za.d
            public int s() {
                return 0;
            }

            @Override // com.byazt.za.d
            public void s(int i) {
            }

            @Override // com.byazt.za.d
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.byazt.rg.n
            public void n(View view) {
                com.byazt.de.qg.s(qg.this.qg());
                if (qg.this.fs != null) {
                    qg.this.fs.qg(qg.this);
                }
                com.byazt.rg.s.n(qg.this.qg, (oa) h.rv(qg.this.qg), true, (JSONObject) null);
            }

            @Override // com.byazt.rg.n
            public void n(View view, int i, com.byazt.twc.s sVar, g gVar) {
                if (qg.this.oj != null) {
                    qg.this.oj.n(view, i, sVar, -1);
                }
                com.byazt.rg.s.n(qg.this.qg, (oa) gVar, false, (JSONObject) null, sVar instanceof wm ? ((wm) sVar).n().optBoolean("isLottieInternalClick", false) : false);
                qg.this.cy();
            }

            @Override // com.byazt.rg.n
            public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
                if (qg.this.oj != null) {
                    qg.this.oj.n(view, i, sVar, i2);
                }
                qg.this.cy();
            }

            @Override // com.byazt.rg.n
            public void n(ViewGroup viewGroup) {
                if (h.tj(qg.this.qg).sz()) {
                    TextView textView = new TextView(qg.this.dg);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    textView.setTextSize(1, 20.0f);
                    int iS = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), 80.0f);
                    textView.setText("跳转至详情页或第三方应用");
                    layoutParams.bottomMargin = iS;
                    int i = iS / 3;
                    layoutParams.leftMargin = i;
                    layoutParams.rightMargin = i;
                    layoutParams.gravity = 81;
                    textView.setTextColor(-1);
                    int i2 = iS / 6;
                    textView.setPadding(0, i2, 0, i2);
                    textView.setGravity(17);
                    textView.setLayoutParams(layoutParams);
                    textView.setClickable(true);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.hw.qg.2.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (qg.this.oj != null) {
                                qg.this.oj.n(view, 2, new wm.n().n(), -1);
                            }
                        }
                    });
                    textView.bringToFront();
                    viewGroup.addView(textView);
                }
            }
        });
    }
}
