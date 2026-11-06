package com.byazt.rw;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.ca.ho;
import com.byazt.hg.bh;
import com.byazt.hg.fo;
import com.byazt.hg.ie;
import com.byazt.hg.m;
import com.byazt.hg.of;
import com.byazt.hg.pq;
import com.byazt.hg.qv;
import com.byazt.hg.vk;
import com.byazt.hg.wt;
import com.byazt.qx.NativeExpressVideoView;
import com.byazt.qx.NativeExpressView;
import com.byazt.qx.SplashExpressBackupView;
import com.byazt.qx.b;
import com.byazt.qx.uc;
import com.byazt.sd.a;
import com.byazt.uq.c;
import com.byazt.vx.x;
import com.byazt.w.hn;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zn.aj;
import com.byazt.zn.fw;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.db.constant.Common;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET, 13})
public class hw extends pr implements hn.InterfaceC0220hn, hn.x, pr.hw, com.byazt.mm.pr.InterfaceC0136pr {
    public c hs;
    public volatile uc ie;
    public int ii;
    public SlideInterceptView nw;
    public volatile com.byazt.qx.c o;
    public String of;
    public Context qi;
    public com.byazt.qe.hw qn;
    public WeakReference<ViewGroup> r;
    public NativeExpressView v;
    public final AtomicBoolean i = new AtomicBoolean(false);
    public final SlideInterceptView.pr f = new SlideInterceptView.pr() { // from class: com.byazt.rw.hw.1
        @Override // com.byazt.rw.SlideInterceptView.pr
        public void pr(View view, vk vkVar) {
            if (hw.this.c != null) {
                hw.this.c.pr(view, vkVar);
            }
            hw.this.ny();
        }

        @Override // com.byazt.rw.SlideInterceptView.pr
        public com.byazt.qx.c pr() {
            return hw.this.o;
        }
    };

    public hw(Context context, com.byazt.qe.hw hwVar, String str, int i, com.byazt.zn.hn hnVar, x<aj, fw> xVar, com.byazt.ks.pr prVar) {
        if (hnVar != null) {
            this.hw = hnVar.hw();
            com.byazt.qd.hw.pr(hnVar.hw(), hnVar.fw(), ls.k(hnVar.hw()), fo());
        }
        this.qi = context;
        this.qn = hwVar;
        this.of = str;
        this.ii = i;
        this.fw = this;
        pr(hnVar, xVar, prVar);
        hw(xVar);
    }

    private void hw(final x<aj, fw> xVar) {
        try {
            com.byazt.jm.c.pr(new Runnable() { // from class: com.byazt.rw.hw.2
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    hw.this.pr(xVar);
                    hw.this.nl();
                    System.currentTimeMillis();
                }
            });
        } catch (Throwable th) {
            ho.hw("splrender", th.getMessage());
        }
    }

    public void pr(com.byazt.zn.hn hnVar, x<aj, fw> xVar) {
        this.m = 3;
        hn(xVar);
        rc();
    }

    public void hw(int i) {
        this.ii = i;
    }

    private void z() {
        if (this.hw.rf() == 2) {
            this.v = new NativeExpressView(true, this.qi, this.hw, this.qn, this.of, true);
        } else {
            this.v = new NativeExpressView(false, this.qi, this.hw, this.qn, this.of, true);
        }
    }

    private void b() {
        if (this.hw.rf() == 2) {
            this.v = new NativeExpressVideoView(true, this.qi, this.hw, this.qn, this.of);
        } else {
            this.v = new NativeExpressVideoView(false, this.qi, this.hw, this.qn, this.of);
        }
        if (this.v.getVideoController() instanceof com.byazt.gz.x) {
            this.y = (com.byazt.gz.x) this.v.getVideoController();
        }
        this.v.setVideoAdListener(this);
        this.v.setVideoAdInteractionListener(this);
    }

    private void hn(final x<aj, fw> xVar) {
        if (xVar == null || this.hw == null) {
            return;
        }
        if (this.gz) {
            this.cz = true;
            b();
        } else {
            this.cz = false;
            z();
        }
        if (this.z != null) {
            this.z.pr(this);
        }
        NativeExpressView nativeExpressView = this.v;
        if (nativeExpressView == null) {
            this.z.hw(3);
            this.z.pr("no render express");
            xVar.pr(this.z);
        } else {
            nativeExpressView.setBackupListener(new com.byazt.mq.hn() { // from class: com.byazt.rw.hw.3
                @Override // com.byazt.mq.hn
                public boolean pr(ViewGroup viewGroup, int i) {
                    try {
                        SplashExpressBackupView splashExpressBackupView = new SplashExpressBackupView(hw.this.qi);
                        splashExpressBackupView.pr(hw.this.ve, hw.this.hw, (NativeExpressView) viewGroup);
                        if (splashExpressBackupView.getVideoController() instanceof com.byazt.gz.x) {
                            hw.this.y = (com.byazt.gz.x) splashExpressBackupView.getVideoController();
                        }
                        splashExpressBackupView.setVideoAdListener(hw.this);
                        hw.this.k();
                        if (hw.this.pr != null) {
                            hw.this.pr.pr();
                            return true;
                        }
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            });
            this.m = 3;
            this.v.setExpressInteractionListener(new com.byazt.qx.pr() { // from class: com.byazt.rw.hw.4
                @Override // com.byazt.qx.pr
                public void pr(View view, int i) {
                    com.byazt.qd.hw.hn(hw.this.fo());
                    com.byazt.pj.pr.hw(hw.this.nt, hw.this.hw);
                    if (hw.this.zo != null) {
                        hw.this.zo.hw(hw.this);
                    }
                    hw.this.w();
                    hw.this.ny();
                }

                @Override // com.byazt.qx.pr
                public void pr(View view, final String str, int i) {
                    final Runnable runnable = new Runnable() { // from class: com.byazt.rw.hw.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ho.hw(MediationConstant.RIT_TYPE_SPLASH, "onRenderFail:" + str);
                                hw.this.z.hw(3);
                                hw.this.z.pr("render splash express fail");
                                xVar.pr(hw.this.z);
                            } catch (Throwable th) {
                            }
                        }
                    };
                    com.byazt.jm.c.pr(new Runnable() { // from class: com.byazt.rw.hw.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            zo.pr(runnable);
                        }
                    });
                }

                @Override // com.byazt.qx.pr
                public void pr(final View view, final float f, final float f2) {
                    com.byazt.nz.pr.pr("Splash_FullLink", "CSJSplashExpressRender- onRenderSuccess");
                    final Runnable runnable = new Runnable() { // from class: com.byazt.rw.hw.4.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.byazt.nz.pr.pr("Splash_FullLink", "CSJSplashExpressRender- runOnUiThread - onRenderSuccess");
                                if (view != null && f > 0.0f && f2 > 0.0f) {
                                    aj ajVar = new aj(hw.this.ww.get(), hw.this);
                                    boolean zCz = hw.this.v.cz();
                                    if (hw.this.v != null && !zCz) {
                                        hw.this.pr.setComplianceBarVisibility(8);
                                    }
                                    ajVar.pr(zCz);
                                    hw.this.ls.set(zCz ? 1 : 2);
                                    hw.this.b.set(true);
                                    hw.this.pr.setExpressView(hw.this.v);
                                    hw.this.i.set(true);
                                    if (hw.this.iu.get()) {
                                        hw.this.pr((WeakReference<ViewGroup>) hw.this.r);
                                        hw.this.iu.set(false);
                                    }
                                    if (!hw.this.aj.get() && !zCz && wt.pr(hw.this.hw)) {
                                        hw.this.gz();
                                    }
                                    xVar.hw(ajVar);
                                    hw.this.hs.pr(hw.this.pr.getEasyPlayableLayout(), hw.this.v.getVideoContainer());
                                    hw.this.iu();
                                    return;
                                }
                                hw.this.z.hw(3);
                                hw.this.z.pr("render splash view error");
                                xVar.pr(hw.this.z);
                            } catch (Throwable th) {
                                ho.hw(MediationConstant.RIT_TYPE_SPLASH, "onRenderFail:" + th.getMessage());
                            }
                        }
                    };
                    com.byazt.jm.c.pr(new Runnable() { // from class: com.byazt.rw.hw.4.4
                        @Override // java.lang.Runnable
                        public void run() {
                            zo.pr(runnable);
                        }
                    });
                }
            });
        }
    }

    @Override // com.byazt.rw.pr, com.byazt.mr.hw
    public void pr(ViewGroup viewGroup) {
        com.byazt.qd.hw.hw(fo());
        if (viewGroup == null) {
            ho.hw(MediationConstant.RIT_TYPE_SPLASH, "展示开屏的容器不能为空");
            return;
        }
        if (this.hw != null) {
            com.byazt.ua.hw.pr(this.hw.pr());
        }
        ve();
        WeakReference<ViewGroup> weakReference = new WeakReference<>(viewGroup);
        this.r = weakReference;
        if (this.b.get() && this.pr != null) {
            pr(weakReference);
        } else {
            this.iu.set(true);
        }
    }

    private void pr(JSONArray jSONArray, View view) {
        if (view == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Common.System.NAME, view.getClass().getSimpleName());
            jSONObject.put("id", view.getId());
            if (view instanceof ViewGroup) {
                JSONArray jSONArray2 = new JSONArray();
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    pr(jSONArray2, viewGroup.getChildAt(i));
                }
                jSONObject.put("children", jSONArray2);
            }
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(WeakReference<ViewGroup> weakReference) {
        ViewGroup viewGroup;
        if (weakReference == null || (viewGroup = weakReference.get()) == null) {
            return;
        }
        if (this.pr.getParent() != null) {
            ((ViewGroup) this.pr.getParent()).removeView(this.pr);
        }
        try {
            viewGroup.addView(this.pr);
        } catch (Exception e) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                pr(jSONArray, this.pr);
                jSONObject.put("root", jSONArray);
                ho.hw(MediationConstant.RIT_TYPE_SPLASH, "showTsView.addView:" + e.getMessage());
                com.byazt.xk.hw.pr().pr("splash_add_view_error", jSONObject, e);
            } catch (JSONException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu() {
        final pq pqVarJl = this.hw.jl();
        if (pqVarJl == null || this.pr == null) {
            return;
        }
        if ((this.ls.get() == 1 && pqVarJl.yb() != 1) || pqVarJl.nt() <= 0.0f) {
            return;
        }
        this.pr.postDelayed(new Runnable() { // from class: com.byazt.rw.hw.5
            @Override // java.lang.Runnable
            public void run() {
                View rootView = hw.this.pr.getRootView();
                if (!(rootView instanceof FrameLayout)) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) rootView;
                int height = hw.this.pr.getHeight();
                int iAj = er.aj(hw.this.qi);
                if (pqVarJl.nt() < 1.0f) {
                    return;
                }
                float f = iAj;
                if (height > pqVarJl.nt() * f || hw.this.w) {
                    return;
                }
                int iZ = 0;
                if (pqVarJl.a() == 1) {
                    iZ = iAj - height;
                } else if (pqVarJl.z() > 0.0f) {
                    iZ = (int) (f * pqVarJl.z());
                }
                hw.this.nw = new SlideInterceptView(hw.this.qi, pqVarJl, hw.this.f);
                if (iZ <= 0) {
                    iZ = -1;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iZ);
                layoutParams.gravity = 80;
                viewGroup.addView(hw.this.nw, layoutParams);
            }
        }, pqVarJl.cz());
    }

    @Override // com.byazt.rw.pr
    public void ny() {
        try {
            SlideInterceptView slideInterceptView = this.nw;
            if (slideInterceptView == null) {
                return;
            }
            slideInterceptView.pr();
            if (((ViewGroup) this.nw.getParent()) == null) {
                return;
            }
            this.nw.post(new Runnable() { // from class: com.byazt.rw.hw.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) hw.this.nw.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(hw.this.nw);
                        }
                    } catch (Exception e) {
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.rw.pr, com.byazt.mr.hw
    public View nt() {
        if (this.e == -1) {
            this.e = 0;
        }
        if (this.hw != null) {
            com.byazt.ua.hw.pr(this.hw.pr());
        }
        return this.pr;
    }

    public void rc() {
        NativeExpressView nativeExpressView = this.v;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.fw(this.ii);
        this.v.nt();
    }

    @Override // com.byazt.rw.pr.hw
    public void u_() {
        if (this.hw == null || this.qa == null) {
            return;
        }
        if (ie.pr(this.hw) == 2) {
            if (this.i.get()) {
                NativeExpressView nativeExpressView = this.v;
                if (nativeExpressView != null) {
                    nativeExpressView.ho();
                    b.pr(this.qa, this.hw, this.v);
                }
                this.qa.put("splash_show_type", 3);
            }
        } else if (!this.gz) {
            this.qa.put("splash_show_type", 0);
        } else {
            if (TextUtils.isEmpty(qv.pr(this.hw))) {
                this.qa.put("splash_show_type", 2);
            }
            this.qa.put("splash_show_type", 1);
        }
        pr(this.hw);
    }

    private void pr(of ofVar) {
        if (this.v == null || ofVar == null) {
            return;
        }
        Context context = this.qi;
        String str = this.of;
        this.ie = new uc(context, ofVar, str, ls.x(str));
        this.ie.pr(this.v);
        ((com.byazt.dl.pr) this.ie.pr(com.byazt.dl.pr.class)).pr(this.hn);
        ((com.byazt.yx.pr) this.ie.pr(com.byazt.yx.pr.class)).pr(this.vk);
        this.v.setClickListener(this.ie);
        Context context2 = this.qi;
        String str2 = this.of;
        this.o = new com.byazt.qx.c(context2, ofVar, str2, ls.x(str2));
        ((com.byazt.dl.pr) this.o.pr(com.byazt.dl.pr.class)).pr(this);
        this.o.pr(this.v);
        ((com.byazt.dl.pr) this.o.pr(com.byazt.dl.pr.class)).pr(this.hn);
        ((com.byazt.yx.pr) this.o.pr(com.byazt.yx.pr.class)).pr(this.vk);
        this.v.setClickCreativeListener(this.o);
        if (this.hn != null) {
            this.hn.pr(this);
        }
    }

    @Override // com.byazt.rw.pr
    public void pr(com.byazt.nv.hn hnVar) {
        super.pr(hnVar);
        if (this.ie != null) {
            ((com.byazt.dl.pr) this.ie.pr(com.byazt.dl.pr.class)).pr(hnVar);
        }
        if (this.o != null) {
            ((com.byazt.dl.pr) this.o.pr(com.byazt.dl.pr.class)).pr(hnVar);
        }
        if (this.hn != null) {
            this.hn.pr(this);
        }
    }

    @Override // com.byazt.mm.pr.InterfaceC0136pr
    public com.byazt.mm.pr q_() {
        NativeExpressView nativeExpressView;
        com.byazt.mm.pr prVar = new com.byazt.mm.pr();
        hn videoController = this.y;
        if (videoController == null && (nativeExpressView = this.v) != null) {
            videoController = nativeExpressView.getVideoController();
        }
        if (videoController != null) {
            prVar.fw = videoController.w();
            prVar.pr = videoController.a();
            prVar.zo = videoController.qa();
        }
        return prVar;
    }

    @Override // com.byazt.mm.pr.InterfaceC0136pr
    public boolean l_() {
        return false;
    }

    @Override // com.byazt.w.hn.x
    public void O_() {
    }

    @Override // com.byazt.w.hn.x
    public void a_(int i, int i2) {
        this.fo = false;
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void m_() {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void n_() {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void o_() {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void pr(long j, long j2) {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void p_() {
        com.byazt.qd.hw.hn(fo(), 1);
        this.fo = false;
        com.byazt.pj.pr.hw(this.nt, this.hw);
        if (this.zo != null) {
            this.w = true;
            this.zo.pr(this, 4);
            hn(false);
        }
        g();
    }

    @Override // com.byazt.rw.pr, com.byazt.jm.TsView.pr
    public void fw() {
        super.fw();
        NativeExpressView nativeExpressView = this.v;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
        this.v = null;
        this.fw = null;
        this.uc = null;
        if (this.vk != null) {
            this.vk.clear();
        }
        c cVar = this.hs;
        if (cVar != null) {
            cVar.hw();
        }
        ny();
        hn(false);
        g();
    }

    private void ve() {
        if (this.e > 0) {
            return;
        }
        if (this.n == 1) {
            this.e = 1;
        } else {
            this.e = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz() {
        NativeExpressView nativeExpressView = this.v;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.hw(this.k, 0);
        this.v.setDynamicSkipListener(new com.byazt.ck.hn() { // from class: com.byazt.rw.hw.7
            @Override // com.byazt.ck.hn
            public void pr() {
                hw.this.vk();
            }
        });
        this.pr.hw();
        this.er = new com.byazt.ck.hw();
        this.er.pr(this.k);
        this.er.pr(new com.byazt.ck.hw.pr() { // from class: com.byazt.rw.hw.8
            @Override // com.byazt.ck.hw.pr
            public void pr() {
                hw.this.m();
            }

            @Override // com.byazt.ck.hw.pr
            public void pr(int i) {
                if (hw.this.v != null) {
                    hw.this.v.hw(hw.this.k, i);
                }
            }
        });
        if (this.s.get()) {
            this.er.hw();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.hw.hn(fo(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl() {
        this.hs = new c(this.hw, new com.byazt.uq.pr() { // from class: com.byazt.rw.hw.9
            @Override // com.byazt.qx.w
            public void pr(int i) {
            }

            @Override // com.byazt.qx.w
            public long pr() {
                return 0L;
            }

            @Override // com.byazt.qx.w
            public int hw() {
                return 0;
            }

            @Override // com.byazt.qx.w
            public int hn() {
                return 0;
            }

            @Override // com.byazt.qx.w
            public void x() {
            }

            @Override // com.byazt.qx.w
            public void hw(int i) {
            }

            @Override // com.byazt.qx.w
            public void c() {
            }

            @Override // com.byazt.qx.w
            public void pr(int i, String str) {
            }

            @Override // com.byazt.qx.w
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.byazt.qx.w
            public void pr(float f) {
            }

            @Override // com.byazt.qx.w
            public void pr(int i, int i2) {
            }

            @Override // com.byazt.qx.w
            public void hn(int i) {
            }

            @Override // com.byazt.qx.w
            public void pr(of ofVar) {
            }

            @Override // com.byazt.uq.pr
            public void pr(View view) {
                com.byazt.qd.hw.hn(hw.this.fo());
                if (hw.this.zo != null) {
                    hw.this.zo.hw(hw.this);
                }
                com.byazt.uq.hn.hw(hw.this.hw, com.byazt.hg.b.zo(hw.this.hw), true, null);
            }

            @Override // com.byazt.uq.pr
            public void pr(View view, int i, com.byazt.dj.hn hnVar, bh bhVar) {
                boolean zOptBoolean;
                if (hw.this.v != null) {
                    hw.this.v.pr(view, i, hnVar, -1);
                }
                if (!(hnVar instanceof fo)) {
                    zOptBoolean = false;
                } else {
                    zOptBoolean = ((fo) hnVar).pr().optBoolean("isLottieInternalClick", false);
                }
                com.byazt.uq.hn.pr(hw.this.hw, (m) bhVar, false, (JSONObject) null, zOptBoolean);
                hw.this.ny();
            }

            @Override // com.byazt.uq.pr
            public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
                if (hw.this.v != null) {
                    hw.this.v.pr(view, i, hnVar, i2);
                }
                hw.this.ny();
            }

            @Override // com.byazt.uq.pr
            public void pr(ViewGroup viewGroup) {
                if (!com.byazt.hg.b.aj(hw.this.hw).w()) {
                    return;
                }
                TextView textView = new TextView(hw.this.qi);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                textView.setTextSize(1, 20.0f);
                int iHn = er.hn(a.getContext(), 80.0f);
                textView.setText("跳转至详情页或第三方应用");
                layoutParams.bottomMargin = iHn;
                int i = iHn / 3;
                layoutParams.leftMargin = i;
                layoutParams.rightMargin = i;
                layoutParams.gravity = 81;
                textView.setTextColor(-1);
                int i2 = iHn / 6;
                textView.setPadding(0, i2, 0, i2);
                textView.setGravity(17);
                textView.setLayoutParams(layoutParams);
                textView.setClickable(true);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.rw.hw.9.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (hw.this.v != null) {
                            hw.this.v.pr(view, 2, new fo.pr().pr(), -1);
                        }
                    }
                });
                textView.bringToFront();
                viewGroup.addView(textView);
            }
        });
    }
}
