package com.byazt.qx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 1159})
public class NativeExpressVideoView extends NativeExpressView implements com.byazt.w.hn.InterfaceC0220hn, com.byazt.w.hn.x, w {
    public com.byazt.mq.x b;
    public boolean c;
    public com.byazt.mm.pr fo;
    public boolean hn;
    public boolean hw;
    public HashSet<String> iu;
    public int pr;
    public long rc;
    public int x;
    public long z;

    public NativeExpressVideoView(Context context, of ofVar, com.byazt.qe.hw hwVar, String str) {
        super(context, ofVar, hwVar, str, true);
        this.pr = 1;
        this.hw = false;
        this.hn = true;
        this.c = true;
        this.a = this.aj.ax() == 1;
        m();
    }

    public NativeExpressVideoView(boolean z, Context context, of ofVar, com.byazt.qe.hw hwVar, String str) {
        super(z, context, ofVar, hwVar, str, true);
        this.pr = 1;
        this.hw = false;
        this.hn = true;
        this.c = true;
        this.a = this.aj.ax() == 1;
        m();
    }

    public void m() {
        this.g = new FrameLayout(this.uc);
        this.x = ls.m(this.aj);
        this.iu = new HashSet<>();
        c(this.x);
        fo();
    }

    public ExpressVideoView pr(Context context, of ofVar, String str) {
        return new ExpressVideoView(context, ofVar, str, false);
    }

    private void fo() {
        ExpressVideoView expressVideoView;
        try {
            this.fo = new com.byazt.mm.pr();
            this.w = pr(this.uc, this.aj, this.fw);
            this.w.setNativeExpressVideoView(this);
            this.w.setAdCreativeClickListener(new NativeVideoTsView.pr() { // from class: com.byazt.qx.NativeExpressVideoView.1
                @Override // com.byazt.gz.NativeVideoTsView.pr
                public void pr(View view, int i) {
                    pr expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.pr(view, i);
                }
            });
            boolean z = false;
            this.w.setShouldCheckNetChange(false);
            this.w.setControllerStatusCallBack(new NativeVideoTsView.x() { // from class: com.byazt.qx.NativeExpressVideoView.2
                @Override // com.byazt.gz.NativeVideoTsView.x
                public void pr(boolean z2, long j, long j2, long j3, boolean z3, boolean z4) {
                    NativeExpressVideoView.this.fo.pr = z2;
                    NativeExpressVideoView.this.fo.c = j;
                    NativeExpressVideoView.this.fo.uc = j2;
                    NativeExpressVideoView.this.fo.fw = j3;
                    NativeExpressVideoView.this.fo.x = z3;
                    NativeExpressVideoView.this.fo.zo = z4;
                }
            });
            this.w.setVideoAdLoadListener(this);
            this.w.setVideoAdInteractionListener(this);
            if (com.byazt.pfl.hw.AD_TAG_FEED.equals(this.fw)) {
                this.w.setIsAutoPlay(this.hw ? this.zo.c() : this.hn);
            } else if ("splash_ad".equals(this.fw)) {
                this.w.setIsAutoPlay(true);
            } else {
                this.w.setIsAutoPlay(this.hn);
            }
            if ("splash_ad".equals(this.fw)) {
                expressVideoView = this.w;
                z = true;
            } else {
                expressVideoView = this.w;
                if (this.aj.ax() == 1) {
                    z = true;
                }
            }
            expressVideoView.setIsQuiet(z);
            this.w.hn();
        } catch (Exception e) {
            this.w = null;
            com.byazt.ca.ho.hw("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    public void c(int i) {
        int iUc = com.byazt.sd.a.hw().uc(i);
        if (3 == iUc) {
            this.hw = false;
            this.hn = false;
        } else if (1 == iUc) {
            this.hw = false;
            this.hn = com.byazt.ca.yb.x(this.uc);
        } else if (2 == iUc) {
            if (com.byazt.ca.yb.c(this.uc) || com.byazt.ca.yb.x(this.uc) || com.byazt.ca.yb.uc(this.uc)) {
                this.hw = false;
                this.hn = true;
            }
        } else if (5 == iUc) {
            if (com.byazt.ca.yb.x(this.uc) || com.byazt.ca.yb.uc(this.uc)) {
                this.hw = false;
                this.hn = true;
            }
        } else if (4 == iUc) {
            this.hw = true;
        }
        if (!this.hn) {
            this.pr = 3;
        }
    }

    public com.byazt.mm.pr getVideoModel() {
        return this.fo;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        if (this.w != null) {
            this.w.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        if (this.w != null) {
            this.w.setShowAdInteractionView(z);
        }
    }

    @Override // com.byazt.qx.NativeExpressView
    public void hw(com.byazt.mq.x<? extends View> xVar, com.byazt.mq.g gVar) {
        this.b = xVar;
        if ((xVar instanceof ho) && ((ho) xVar).P_() != null) {
            ((ho) this.b).P_().pr((w) this);
        }
        if (gVar != null && gVar.hn()) {
            if ((gVar.hw() == 2 || gVar.hw() == 7) && this.w != null) {
                this.w.pr(this.uc, 25, qv.hw(this.aj));
            }
            pr(gVar);
        }
        com.byazt.mq.x xVar2 = this.b;
        if (xVar2 != null && (xVar2 instanceof com.byazt.qq.pr)) {
            ((com.byazt.qq.pr) xVar2).hw(this.aj.ax() == 1);
        }
        super.hw(xVar, gVar);
    }

    private void pr(final com.byazt.mq.g gVar) {
        if (gVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hw(gVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.qx.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.hw(gVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.mq.g gVar) {
        float fHn;
        float fHn2;
        float fHn3;
        if (gVar == null) {
            return;
        }
        double dUc = gVar.uc();
        double dFw = gVar.fw();
        double dZo = gVar.zo();
        double dAj = gVar.aj();
        int iHn = er.hn(this.uc, (float) dUc);
        int iHn2 = er.hn(this.uc, (float) dFw);
        int iHn3 = er.hn(this.uc, (float) dZo);
        int iHn4 = er.hn(this.uc, (float) dAj);
        if (gVar.k() <= 0.0f) {
            fHn = 0.0f;
        } else {
            fHn = er.hn(this.uc, gVar.k());
        }
        if (gVar.m() <= 0.0f) {
            fHn2 = 0.0f;
        } else {
            fHn2 = er.hn(this.uc, gVar.m());
        }
        if (gVar.g() <= 0.0f) {
            fHn3 = 0.0f;
        } else {
            fHn3 = er.hn(this.uc, gVar.g());
        }
        float fHn4 = gVar.ho() > 0.0f ? er.hn(this.uc, gVar.ho()) : 0.0f;
        if (fHn2 < fHn) {
            fHn = fHn2;
        }
        if (fHn3 >= fHn) {
            fHn3 = fHn;
        }
        if (fHn4 >= fHn3) {
            fHn4 = fHn3;
        }
        if (gVar.hw() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iHn3, iHn4);
            }
            layoutParams.width = iHn3;
            layoutParams.height = iHn4;
            layoutParams.topMargin = iHn2;
            layoutParams.leftMargin = iHn;
            this.g.setLayoutParams(layoutParams);
        }
        er.hw(this.g, fHn4);
        this.g.removeAllViews();
        if (this.w != null) {
            this.g.addView(this.w);
            this.w.pr(0L, true, false);
            c(this.x);
            if (!com.byazt.ca.yb.x(this.uc) && !this.hn && this.c) {
                this.w.K_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.g.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.g);
        }
        if (gVar instanceof com.byazt.gu.hn) {
            FrameLayout frameLayoutNt = ((com.byazt.gu.hn) gVar).nt();
            if (frameLayoutNt != null) {
                if (this.w != null) {
                    this.w.setClickable(false);
                }
                frameLayoutNt.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (gVar.hw() == 2) {
            View viewPr = gVar.pr();
            if (viewPr instanceof ViewGroup) {
                if (this.w != null) {
                    this.w.setClickable(false);
                }
                ((ViewGroup) viewPr).addView(this.g);
                return;
            }
            return;
        }
        this.cz.addView(this.g);
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(boolean z) {
        super.pr(z);
        this.a = z;
        this.w.hw(z, true);
        if (this.w != null && this.w.getNativeVideoController() != null) {
            this.w.getNativeVideoController().hw(z);
        }
        com.byazt.mq.x xVar = this.b;
        if (xVar != null && (xVar instanceof com.byazt.qq.pr)) {
            ((com.byazt.qq.pr) xVar).hw(z);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void uc() {
        super.uc();
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void fw() {
        super.fw();
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(int i) {
        if (this.w == null) {
            com.byazt.ca.ho.hw("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
        }
        switch (i) {
            case 1:
                this.w.pr(0L, true, false);
                break;
            case 2:
            case 3:
                this.w.setVideoPlayStatus(i);
                this.w.setCanInterruptVideoPlay(true);
                this.w.performClick();
                break;
            case 4:
                this.w.getNativeVideoController().vk();
                break;
            case 5:
                this.w.pr(0L, true, false);
                break;
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.mq.zo
    public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
        if (i == -1 || hnVar == null) {
            return;
        }
        switch (i) {
            case 4:
                rc();
                break;
            case 5:
                pr(!this.a);
                break;
            default:
                super.pr(view, i, hnVar, i2);
                break;
        }
    }

    private void rc() {
        com.byazt.mq.x xVar = this.b;
        if ((!(xVar instanceof com.byazt.qq.pr) && !(xVar instanceof com.byazt.gu.c)) || this.w == null) {
            return;
        }
        this.w.hw(true);
        if (this.w.L_()) {
            this.w.setPauseIcon(true);
            this.w.setVideoPlayStatus(2);
        } else {
            this.w.setVideoPlayStatus(3);
            this.w.setPauseIcon(false);
        }
        this.w.performClick();
        this.w.uc();
    }

    @Override // com.byazt.qx.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        com.byazt.mq.x xVar = this.b;
        if (((xVar instanceof com.byazt.qq.pr) || (xVar instanceof com.byazt.gu.c)) && this.w != null && (i = this.pr) != 2 && i != 5) {
            this.w.setNeedNativeVideoPlayBtnVisible(true);
            this.w.K_();
            this.w.J_();
        }
    }

    @Override // com.byazt.qx.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.mq.x xVar = this.b;
        if (((xVar instanceof com.byazt.qq.pr) || (xVar instanceof com.byazt.gu.c)) && this.w != null && z && this.w.hw != null && this.w.hw.getVisibility() == 0) {
            this.w.hw.setVisibility(8);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.mq.zo
    public void hw(View view, int i, com.byazt.dj.hn hnVar, int i2) {
        if (i == -1 || hnVar == null) {
            return;
        }
        switch (i) {
            case 4:
                if (this.fw == "draw_ad") {
                    if (this.w != null) {
                        this.w.performClick();
                        return;
                    }
                    return;
                }
                break;
            case 5:
                break;
            default:
                super.hw(view, i, hnVar, i2);
                return;
        }
        pr(!this.a);
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public long pr() {
        return this.rc;
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public int hw() {
        if (this.pr == 3 && this.w != null) {
            this.w.hn();
        }
        if (this.w != null && this.w.getNativeVideoController().ny()) {
            return 1;
        }
        return this.pr;
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void aj() {
        super.aj();
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void zo() {
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void vk() {
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void x(int i) {
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void m_() {
        this.c = false;
        if (this.m != null) {
            this.m.m_();
        }
        this.pr = 2;
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void n_() {
        this.c = false;
        if (this.m != null) {
            this.m.n_();
        }
        this.ho = true;
        this.pr = 3;
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void o_() {
        this.c = false;
        if (this.m != null) {
            this.m.o_();
        }
        this.ho = false;
        this.pr = 2;
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void pr(long j, long j2) {
        this.c = false;
        if (this.m != null) {
            this.m.pr(j, j2);
        }
        if (pr(j)) {
            this.pr = 2;
        }
        this.rc = j;
        this.z = j2;
        if (!this.iu.isEmpty()) {
            com.byazt.w.hn videoController = this.w.getVideoController();
            if (videoController instanceof com.byazt.gz.x) {
                ((com.byazt.gz.x) videoController).hn(50);
            }
        }
        com.byazt.mm.pr prVar = this.fo;
        if (prVar != null) {
            prVar.fw = j;
        }
        com.byazt.mq.x xVar = this.b;
        if (xVar instanceof com.byazt.gu.c) {
            ((com.byazt.gu.c) xVar).pr(j, j2);
        }
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void p_() {
        this.c = false;
        com.byazt.mq.x xVar = this.b;
        if (xVar != null) {
            if (xVar instanceof com.byazt.qq.pr) {
                ((com.byazt.qq.pr) xVar).hn();
            }
            com.byazt.mq.x xVar2 = this.b;
            if (xVar2 instanceof com.byazt.gu.c) {
                ((com.byazt.gu.c) xVar2).k();
            }
        }
        if (this.m != null) {
            this.m.p_();
        }
        this.pr = 5;
        com.byazt.mm.pr prVar = this.fo;
        if (prVar != null) {
            prVar.pr = true;
        }
    }

    @Override // com.byazt.w.hn.x
    public void O_() {
        if (this.k != null) {
            this.k.O_();
        }
        com.byazt.mq.x xVar = this.b;
        if (xVar != null) {
            if (xVar instanceof com.byazt.qq.pr) {
                ((com.byazt.qq.pr) xVar).x();
            }
            com.byazt.mq.x xVar2 = this.b;
            if (xVar2 instanceof com.byazt.gu.c) {
                ((com.byazt.gu.c) xVar2).m();
            }
        }
    }

    @Override // com.byazt.w.hn.x
    public void a_(int i, int i2) {
        if (this.k != null) {
            this.k.a_(i, i2);
        }
        this.rc = this.z;
        this.pr = 4;
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(final int i, final String str) {
        super.pr(i, str);
        com.byazt.w.hn videoController = this.w.getVideoController();
        if (videoController instanceof com.byazt.gz.x) {
            com.byazt.gz.x xVar = (com.byazt.gz.x) videoController;
            xVar.hn(50);
            xVar.pr(new com.byazt.vr.pr.InterfaceC0217pr() { // from class: com.byazt.qx.NativeExpressVideoView.4
                @Override // com.byazt.vr.pr.InterfaceC0217pr
                public void pr(long j, long j2) {
                    int iAbs = (int) Math.abs(((long) i) - j);
                    int i2 = i;
                    if (i2 >= 0 && iAbs <= 50 && i2 <= j2 && iAbs < 50 && !NativeExpressVideoView.this.iu.contains(str)) {
                        if (i > j) {
                            NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.byazt.qx.NativeExpressVideoView.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NativeExpressVideoView.this.w.setVideoPlayStatus(2);
                                    NativeExpressVideoView.this.w.setCanInterruptVideoPlay(true);
                                    NativeExpressVideoView.this.w.performClick();
                                    NativeExpressVideoView.this.hw(i, str);
                                }
                            }, iAbs);
                        } else {
                            NativeExpressVideoView.this.w.setVideoPlayStatus(2);
                            NativeExpressVideoView.this.w.setCanInterruptVideoPlay(true);
                            NativeExpressVideoView.this.w.performClick();
                            NativeExpressVideoView.this.hw(i, str);
                        }
                        NativeExpressVideoView.this.iu.add(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(float f) {
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(int i, int i2) {
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void hn(int i) {
    }

    private boolean pr(long j) {
        int i = this.pr;
        if (i == 5 || i == 3 || j <= this.rc) {
            return this.w != null && this.w.L_();
        }
        return true;
    }

    @Override // com.byazt.qx.NativeExpressView
    public com.byazt.w.hn getVideoController() {
        if (this.w != null) {
            return this.w.getVideoController();
        }
        return null;
    }

    public void g() {
        this.w.w();
    }

    @Override // com.byazt.qx.NativeExpressView
    public void k() {
        super.k();
        if (this.w != null) {
            this.w.a();
        }
    }
}
