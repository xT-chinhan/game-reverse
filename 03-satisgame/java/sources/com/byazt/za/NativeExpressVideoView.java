package com.byazt.za;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.ia.NativeVideoTsView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 1587})
public class NativeExpressVideoView extends NativeExpressView implements com.byazt.iag.s.q, com.byazt.iag.s.InterfaceC0200s, d {
    public com.byazt.udb.q h;
    public long hu;
    public boolean l;
    public long m;
    public int n;
    public int q;
    public boolean qg;
    public boolean s;
    public HashSet<String> t;
    public com.byazt.cs.n wm;

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void fs() {
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(float f) {
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(int i, int i2) {
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void q(int i) {
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void s(int i) {
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void tj() {
    }

    public NativeExpressVideoView(Context context, pk pkVar, com.byazt.zq.qg qgVar, String str) {
        super(context, pkVar, qgVar, str, true);
        this.n = 1;
        this.qg = false;
        this.s = true;
        this.l = true;
        this.a = this.rv.kj() == 1;
        cp();
    }

    public NativeExpressVideoView(boolean z, Context context, pk pkVar, com.byazt.zq.qg qgVar, String str) {
        super(z, context, pkVar, qgVar, str, true);
        this.n = 1;
        this.qg = false;
        this.s = true;
        this.l = true;
        this.a = this.rv.kj() == 1;
        cp();
    }

    public void cp() {
        this.sz = new FrameLayout(this.w);
        this.q = com.byazt.vgx.w.cy(this.rv);
        this.t = new HashSet<>();
        l(this.q);
        wm();
    }

    public ExpressVideoView n(Context context, pk pkVar, String str) {
        return new ExpressVideoView(context, pkVar, str, false);
    }

    private void wm() {
        ExpressVideoView expressVideoView;
        try {
            this.wm = new com.byazt.cs.n();
            this.cp = n(this.w, this.rv, this.x);
            this.cp.setNativeExpressVideoView(this);
            this.cp.setAdCreativeClickListener(new NativeVideoTsView.n() { // from class: com.byazt.za.NativeExpressVideoView.1
                @Override // com.byazt.ia.NativeVideoTsView.n
                public void n(View view, int i) {
                    n expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.n(view, i);
                }
            });
            boolean z = false;
            this.cp.setShouldCheckNetChange(false);
            this.cp.setControllerStatusCallBack(new NativeVideoTsView.q() { // from class: com.byazt.za.NativeExpressVideoView.2
                @Override // com.byazt.ia.NativeVideoTsView.q
                public void n(boolean z2, long j, long j2, long j3, boolean z3, boolean z4) {
                    NativeExpressVideoView.this.wm.n = z2;
                    NativeExpressVideoView.this.wm.l = j;
                    NativeExpressVideoView.this.wm.w = j2;
                    NativeExpressVideoView.this.wm.x = j3;
                    NativeExpressVideoView.this.wm.q = z3;
                    NativeExpressVideoView.this.wm.fs = z4;
                }
            });
            this.cp.setVideoAdLoadListener(this);
            this.cp.setVideoAdInteractionListener(this);
            if (com.byazt.wg.qg.AD_TAG_FEED.equals(this.x)) {
                this.cp.setIsAutoPlay(this.qg ? this.fs.l() : this.s);
            } else if ("splash_ad".equals(this.x)) {
                this.cp.setIsAutoPlay(true);
            } else {
                this.cp.setIsAutoPlay(this.s);
            }
            if ("splash_ad".equals(this.x)) {
                expressVideoView = this.cp;
            } else {
                expressVideoView = this.cp;
                if (this.rv.kj() == 1) {
                }
                expressVideoView.setIsQuiet(z);
                this.cp.s();
            }
            z = true;
            expressVideoView.setIsQuiet(z);
            this.cp.s();
        } catch (Exception e) {
            this.cp = null;
            com.byazt.tk.k.qg("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    public void l(int i) {
        int iL = com.byazt.nf.rv.qg().l(i);
        if (3 == iL) {
            this.qg = false;
            this.s = false;
        } else if (1 == iL) {
            this.qg = false;
            this.s = com.byazt.tk.hd.q(this.w);
        } else if (2 == iL) {
            if (com.byazt.tk.hd.l(this.w) || com.byazt.tk.hd.q(this.w) || com.byazt.tk.hd.w(this.w)) {
                this.qg = false;
                this.s = true;
            }
        } else if (5 == iL) {
            if (com.byazt.tk.hd.q(this.w) || com.byazt.tk.hd.w(this.w)) {
                this.qg = false;
                this.s = true;
            }
        } else if (4 == iL) {
            this.qg = true;
        }
        if (this.s) {
            return;
        }
        this.n = 3;
    }

    public com.byazt.cs.n getVideoModel() {
        return this.wm;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        if (this.cp != null) {
            this.cp.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        if (this.cp != null) {
            this.cp.setShowAdInteractionView(z);
        }
    }

    @Override // com.byazt.za.NativeExpressView
    public void qg(com.byazt.udb.q<? extends View> qVar, com.byazt.udb.sz szVar) {
        this.h = qVar;
        if ((qVar instanceof cy) && ((cy) qVar).x_() != null) {
            ((cy) this.h).x_().n((d) this);
        }
        if (szVar != null && szVar.s()) {
            if ((szVar.qg() == 2 || szVar.qg() == 7) && this.cp != null) {
                this.cp.n(this.w, 25, ta.qg(this.rv));
            }
            n(szVar);
        }
        com.byazt.udb.q qVar2 = this.h;
        if (qVar2 != null && (qVar2 instanceof com.byazt.iv.n)) {
            ((com.byazt.iv.n) qVar2).qg(this.rv.kj() == 1);
        }
        super.qg(qVar, szVar);
    }

    private void n(final com.byazt.udb.sz szVar) {
        if (szVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(szVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.za.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.qg(szVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.udb.sz szVar) {
        if (szVar == null) {
            return;
        }
        double dW = szVar.w();
        double dX = szVar.x();
        double dFs = szVar.fs();
        double dRv = szVar.rv();
        int iS = com.byazt.okk.s.s(this.w, (float) dW);
        int iS2 = com.byazt.okk.s.s(this.w, (float) dX);
        int iS3 = com.byazt.okk.s.s(this.w, (float) dFs);
        int iS4 = com.byazt.okk.s.s(this.w, (float) dRv);
        float fS = szVar.d() > 0.0f ? com.byazt.okk.s.s(this.w, szVar.d()) : 0.0f;
        float fS2 = szVar.oa() > 0.0f ? com.byazt.okk.s.s(this.w, szVar.oa()) : 0.0f;
        float fS3 = szVar.sz() > 0.0f ? com.byazt.okk.s.s(this.w, szVar.sz()) : 0.0f;
        float fS4 = szVar.k() > 0.0f ? com.byazt.okk.s.s(this.w, szVar.k()) : 0.0f;
        if (fS2 < fS) {
            fS = fS2;
        }
        if (fS3 >= fS) {
            fS3 = fS;
        }
        if (fS4 >= fS3) {
            fS4 = fS3;
        }
        if (szVar.qg() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.sz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iS3, iS4);
            }
            layoutParams.width = iS3;
            layoutParams.height = iS4;
            layoutParams.topMargin = iS2;
            layoutParams.leftMargin = iS;
            this.sz.setLayoutParams(layoutParams);
        }
        com.byazt.okk.s.qg(this.sz, fS4);
        this.sz.removeAllViews();
        if (this.cp != null) {
            this.sz.addView(this.cp);
            this.cp.n(0L, true, false);
            l(this.q);
            if (!com.byazt.tk.hd.q(this.w) && !this.s && this.l) {
                this.cp.l();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.sz.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.sz);
        }
        if (szVar instanceof com.byazt.gn.q) {
            FrameLayout frameLayoutCy = ((com.byazt.gn.q) szVar).cy();
            if (frameLayoutCy != null) {
                if (this.cp != null) {
                    this.cp.setClickable(false);
                }
                frameLayoutCy.addView(this.sz, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (szVar.qg() == 2) {
            View viewN = szVar.n();
            if (viewN instanceof ViewGroup) {
                if (this.cp != null) {
                    this.cp.setClickable(false);
                }
                ((ViewGroup) viewN).addView(this.sz);
                return;
            }
            return;
        }
        this.py.addView(this.sz);
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(boolean z) {
        super.n(z);
        this.a = z;
        this.cp.n(z, true);
        if (this.cp != null && this.cp.getNativeVideoController() != null) {
            this.cp.getNativeVideoController().qg(z);
        }
        com.byazt.udb.q qVar = this.h;
        if (qVar == null || !(qVar instanceof com.byazt.iv.n)) {
            return;
        }
        ((com.byazt.iv.n) qVar).qg(z);
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void w() {
        super.w();
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void x() {
        super.x();
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(int i) {
        if (this.cp == null) {
            com.byazt.tk.k.qg("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            this.cp.n(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            this.cp.setVideoPlayStatus(i);
            this.cp.setCanInterruptVideoPlay(true);
            this.cp.performClick();
        } else if (i == 4) {
            this.cp.getNativeVideoController().tj();
        } else {
            if (i != 5) {
                return;
            }
            this.cp.n(0L, true, false);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.udb.fs
    public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
        if (i == -1 || sVar == null) {
            return;
        }
        if (i == 4) {
            m();
        } else if (i == 5) {
            n(!this.a);
        } else {
            super.n(view, i, sVar, i2);
        }
    }

    private void m() {
        com.byazt.udb.q qVar = this.h;
        if (((qVar instanceof com.byazt.iv.n) || (qVar instanceof com.byazt.gn.w)) && this.cp != null) {
            this.cp.qg(true);
            if (this.cp.x()) {
                this.cp.setPauseIcon(true);
                this.cp.setVideoPlayStatus(2);
            } else {
                this.cp.setVideoPlayStatus(3);
                this.cp.setPauseIcon(false);
            }
            this.cp.performClick();
            this.cp.w();
        }
    }

    @Override // com.byazt.za.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        com.byazt.udb.q qVar = this.h;
        if ((!(qVar instanceof com.byazt.iv.n) && !(qVar instanceof com.byazt.gn.w)) || this.cp == null || (i = this.n) == 2 || i == 5) {
            return;
        }
        this.cp.setNeedNativeVideoPlayBtnVisible(true);
        this.cp.l();
        this.cp.q_();
    }

    @Override // com.byazt.za.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.udb.q qVar = this.h;
        if (((qVar instanceof com.byazt.iv.n) || (qVar instanceof com.byazt.gn.w)) && this.cp != null && z && this.cp.qg != null && this.cp.qg.getVisibility() == 0) {
            this.cp.qg.setVisibility(8);
        }
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.udb.fs
    public void qg(View view, int i, com.byazt.twc.s sVar, int i2) {
        if (i == -1 || sVar == null) {
            return;
        }
        if (i != 4) {
            if (i != 5) {
                super.qg(view, i, sVar, i2);
                return;
            }
        } else if (this.x == "draw_ad") {
            if (this.cp != null) {
                this.cp.performClick();
                return;
            }
            return;
        }
        n(!this.a);
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public long n() {
        return this.m;
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public int qg() {
        if (this.n == 3 && this.cp != null) {
            this.cp.s();
        }
        if (this.cp == null || !this.cp.getNativeVideoController().ou()) {
            return this.n;
        }
        return 1;
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void rv() {
        super.rv();
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void s_() {
        this.l = false;
        if (this.oa != null) {
            this.oa.s_();
        }
        this.n = 2;
        com.byazt.udb.q qVar = this.h;
        if (qVar instanceof com.byazt.gn.w) {
            ((com.byazt.gn.w) qVar).cd();
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void t_() {
        this.l = false;
        if (this.oa != null) {
            this.oa.t_();
        }
        this.k = true;
        this.n = 3;
        com.byazt.udb.q qVar = this.h;
        if (qVar instanceof com.byazt.gn.w) {
            ((com.byazt.gn.w) qVar).cy();
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void u_() {
        this.l = false;
        if (this.oa != null) {
            this.oa.u_();
        }
        this.k = false;
        this.n = 2;
        com.byazt.udb.q qVar = this.h;
        if (qVar instanceof com.byazt.gn.w) {
            ((com.byazt.gn.w) qVar).hd();
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void n(long j, long j2) {
        this.l = false;
        if (this.oa != null) {
            this.oa.n(j, j2);
        }
        if (n(j)) {
            this.n = 2;
        }
        this.m = j;
        this.hu = j2;
        if (!this.t.isEmpty()) {
            com.byazt.iag.s videoController = this.cp.getVideoController();
            if (videoController instanceof com.byazt.ia.q) {
                ((com.byazt.ia.q) videoController).s(50);
            }
        }
        com.byazt.cs.n nVar = this.wm;
        if (nVar != null) {
            nVar.x = j;
        }
        com.byazt.udb.q qVar = this.h;
        if (qVar instanceof com.byazt.gn.w) {
            ((com.byazt.gn.w) qVar).n(j, j2);
        }
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void v_() {
        this.l = false;
        com.byazt.udb.q qVar = this.h;
        if (qVar != null) {
            if (qVar instanceof com.byazt.iv.n) {
                ((com.byazt.iv.n) qVar).s();
            }
            com.byazt.udb.q qVar2 = this.h;
            if (qVar2 instanceof com.byazt.gn.w) {
                ((com.byazt.gn.w) qVar2).oa();
                ((com.byazt.gn.w) this.h).k();
            }
        }
        if (this.oa != null) {
            this.oa.v_();
        }
        this.n = 5;
        com.byazt.cs.n nVar = this.wm;
        if (nVar != null) {
            nVar.n = true;
        }
    }

    @Override // com.byazt.iag.s.q
    public void w_() {
        if (this.d != null) {
            this.d.w_();
        }
        com.byazt.udb.q qVar = this.h;
        if (qVar != null) {
            if (qVar instanceof com.byazt.iv.n) {
                ((com.byazt.iv.n) qVar).q();
            }
            com.byazt.udb.q qVar2 = this.h;
            if (qVar2 instanceof com.byazt.gn.w) {
                ((com.byazt.gn.w) qVar2).sz();
            }
        }
    }

    @Override // com.byazt.iag.s.q
    public void a_(int i, int i2) {
        if (this.d != null) {
            this.d.a_(i, i2);
        }
        this.m = this.hu;
        this.n = 4;
    }

    @Override // com.byazt.za.NativeExpressView, com.byazt.za.d
    public void n(final int i, final String str) {
        super.n(i, str);
        com.byazt.iag.s videoController = this.cp.getVideoController();
        if (videoController instanceof com.byazt.ia.q) {
            com.byazt.ia.q qVar = (com.byazt.ia.q) videoController;
            qVar.s(50);
            qVar.n(new com.byazt.du.n.InterfaceC0157n() { // from class: com.byazt.za.NativeExpressVideoView.4
                @Override // com.byazt.du.n.InterfaceC0157n
                public void n(long j, long j2) {
                    int iAbs = (int) Math.abs(((long) i) - j);
                    int i2 = i;
                    if (i2 < 0 || iAbs > 50 || i2 > j2 || iAbs >= 50 || NativeExpressVideoView.this.t.contains(str)) {
                        return;
                    }
                    if (i > j) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.byazt.za.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.cp.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.cp.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.cp.performClick();
                                NativeExpressVideoView.this.qg(i, str);
                            }
                        }, iAbs);
                    } else {
                        NativeExpressVideoView.this.cp.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.cp.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.cp.performClick();
                        NativeExpressVideoView.this.qg(i, str);
                    }
                    NativeExpressVideoView.this.t.add(str);
                }
            });
        }
    }

    private boolean n(long j) {
        int i = this.n;
        if (i == 5 || i == 3 || j <= this.m) {
            return this.cp != null && this.cp.x();
        }
        return true;
    }

    @Override // com.byazt.za.NativeExpressView
    public com.byazt.iag.s getVideoController() {
        if (this.cp != null) {
            return this.cp.getVideoController();
        }
        return null;
    }

    public void d() {
        this.cp.cp();
    }

    @Override // com.byazt.za.NativeExpressView
    public void oa() {
        super.oa();
        if (this.cp != null) {
            this.cp.ou();
        }
    }
}
