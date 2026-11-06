package com.byazt.pg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.gu.c;
import com.byazt.hg.jn;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.jw.FullSwiperItemView;
import com.byazt.mq.g;
import com.byazt.mq.hn;
import com.byazt.mq.x;
import com.byazt.qx.FullRewardExpressBackupView;
import com.byazt.qx.NativeExpressView;
import com.byazt.qx.b;
import com.byazt.qx.ho;
import com.byazt.qx.w;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 90, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL})
public class FullRewardExpressView extends NativeExpressView implements w {
    public View b;
    public g c;
    public ImageView fo;
    public com.byazt.bk.pr gz;
    public com.byazt.ga.pr hn;
    public FullRewardExpressBackupView hw;
    public com.byazt.vr.pr.InterfaceC0217pr iu;
    public com.byazt.cy.pr nl;
    public w pr;
    public HashSet<String> rc;
    public FullSwiperItemView.pr ve;
    public x x;
    public pr z;

    public interface pr {
        void pr(int i);
    }

    public FullRewardExpressView(Context context, of ofVar, com.byazt.qe.hw hwVar, String str, boolean z, String str2) {
        super(context, ofVar, hwVar, str, z, str2);
        this.rc = new HashSet<>();
    }

    @Override // com.byazt.qx.NativeExpressView
    public void w() {
        this.nt = true;
        this.g = new FrameLayout(this.uc);
        super.w();
        g();
        if (getJsObject() != null) {
            getJsObject().k(this.a);
        }
    }

    public void setEasyPlayableContainer(View view) {
        this.b = view;
    }

    public void setInteractListener(FullSwiperItemView.pr prVar) {
        this.ve = prVar;
    }

    private void g() {
        setBackupListener(new hn() { // from class: com.byazt.pg.FullRewardExpressView.1
            @Override // com.byazt.mq.hn
            public boolean pr(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).qa();
                    FullRewardExpressView.this.hw = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView.this.hw.pr(FullRewardExpressView.this.aj, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

    public void setExpressVideoListenerProxy(w wVar) {
        this.pr = wVar;
    }

    @Override // com.byazt.qx.NativeExpressView
    public void hw(x<? extends View> xVar, g gVar) {
        FrameLayout frameLayoutYb;
        View view;
        this.x = xVar;
        com.byazt.cy.pr prVar = this.nl;
        if (prVar != null) {
            pr(prVar);
            this.nl = null;
        }
        if (xVar instanceof ho) {
            ho hoVar = (ho) xVar;
            if (hoVar.P_() != null) {
                hoVar.P_().pr((w) this);
            }
            if (hoVar.P_() != null) {
                hoVar.P_().hn(this.vk);
            }
        }
        if (xVar instanceof com.byazt.gu.pr) {
            ((com.byazt.gu.pr) xVar).pr(this);
        }
        if (gVar != null && gVar.hn()) {
            this.c = gVar;
            boolean z = false;
            if (gVar.hw() == 2) {
                View viewPr = gVar.pr();
                if (viewPr instanceof ViewGroup) {
                    ((ViewGroup) viewPr).addView(getVideoContainer());
                    z = true;
                }
            }
            if (!z) {
                pr((ViewGroup) this.g, true);
            }
            if (gVar.hw() == 10 && (gVar instanceof com.byazt.gu.hn)) {
                this.gz = ((com.byazt.gu.hn) gVar).lb();
            }
            if (gVar.hw() == 10 && (gVar instanceof com.byazt.gu.hn) && (frameLayoutYb = ((com.byazt.gu.hn) gVar).yb()) != null && (view = this.b) != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.b);
                }
                frameLayoutYb.addView(this.b);
            }
        }
        super.hw(xVar, gVar);
        uc(getVisibility());
    }

    public void pr(final ViewGroup viewGroup, final boolean z) {
        if (this.c == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hw(viewGroup, z);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.pg.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.hw(viewGroup, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:50:0x0106  */
    public void hw(ViewGroup viewGroup, boolean z) {
        float fHn;
        float fHn2;
        float fHn3;
        g gVar = this.c;
        if (gVar == null) {
            return;
        }
        double dUc = gVar.uc();
        double dFw = this.c.fw();
        double dZo = this.c.zo();
        double dAj = this.c.aj();
        int iHn = er.hn(this.uc, (float) dUc);
        int iHn2 = er.hn(this.uc, (float) dFw);
        int iHn3 = er.hn(this.uc, (float) dZo);
        int iHn4 = er.hn(this.uc, (float) dAj);
        if (this.c.k() <= 0.0f) {
            fHn = 0.0f;
        } else {
            fHn = er.hn(this.uc, this.c.k());
        }
        if (this.c.m() <= 0.0f) {
            fHn2 = 0.0f;
        } else {
            fHn2 = er.hn(this.uc, this.c.m());
        }
        if (this.c.g() <= 0.0f) {
            fHn3 = 0.0f;
        } else {
            fHn3 = er.hn(this.uc, this.c.g());
        }
        float fHn4 = this.c.ho() > 0.0f ? er.hn(this.uc, this.c.ho()) : 0.0f;
        if (fHn2 < fHn) {
            fHn = fHn2;
        }
        if (fHn3 >= fHn) {
            fHn3 = fHn;
        }
        if (fHn4 >= fHn3) {
            fHn4 = fHn3;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iHn3, iHn4);
        }
        layoutParams.width = iHn3;
        layoutParams.height = iHn4;
        layoutParams.topMargin = iHn2;
        layoutParams.leftMargin = iHn;
        viewGroup.setLayoutParams(layoutParams);
        er.hw(viewGroup, fHn4);
        if (!z) {
            return;
        }
        viewGroup.removeAllViews();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(viewGroup);
        }
        if (this.x.hw() == 7 || this.x.hw() == 10) {
            g gVar2 = this.c;
            if (gVar2 instanceof com.byazt.gu.hn) {
                FrameLayout frameLayoutNt = ((com.byazt.gu.hn) gVar2).nt();
                if (frameLayoutNt != null) {
                    frameLayoutNt.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
                }
            } else {
                this.cz.addView(viewGroup);
            }
        } else {
            this.cz.addView(viewGroup);
        }
        pr prVar = this.z;
        if (prVar != null && iHn4 != 0) {
            prVar.pr(iHn4);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(boolean z) {
        super.pr(z);
        this.a = z;
        w wVar = this.pr;
        if (wVar != null) {
            wVar.pr(z);
        }
        x xVar = this.x;
        if (xVar != null && (xVar instanceof com.byazt.qq.pr)) {
            ((com.byazt.qq.pr) xVar).hw(z);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void uc() {
        super.uc();
        w wVar = this.pr;
        if (wVar != null) {
            wVar.uc();
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void fw() {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.fw();
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(int i) {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.pr(i);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public long pr() {
        w wVar = this.pr;
        if (wVar != null) {
            return wVar.pr();
        }
        return 0L;
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public int hw() {
        w wVar = this.pr;
        if (wVar != null) {
            return wVar.hw();
        }
        return 0;
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public int hn() {
        w wVar = this.pr;
        if (wVar != null) {
            return wVar.hn();
        }
        return 0;
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void zo() {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.zo();
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void aj() {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.aj();
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void vk() {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.vk();
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void x(int i) {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.x(i);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(float f, float f2, float f3, float f4, int i) {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.pr(f, f2, f3, f4, i);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void hw(int i) {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.hw(i);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void x() {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.x();
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void c() {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.c();
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(of ofVar) {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.pr(ofVar);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(final int i, final String str) {
        this.iu = new com.byazt.vr.pr.InterfaceC0217pr() { // from class: com.byazt.pg.FullRewardExpressView.3
            @Override // com.byazt.vr.pr.InterfaceC0217pr
            public void pr(long j, long j2) {
                int i2;
                int iAbs = (int) Math.abs(((long) i) - j);
                if (!(FullRewardExpressView.this.hn instanceof com.byazt.dr.x)) {
                    i2 = 50;
                } else {
                    i2 = 200;
                }
                int i3 = i;
                if (i3 >= 0 && iAbs <= i2 && i3 <= j2 && iAbs < i2 && !FullRewardExpressView.this.rc.contains(str)) {
                    if (i > j) {
                        FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.byazt.pg.FullRewardExpressView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FullRewardExpressView.this.hn.uc();
                                FullRewardExpressView.this.hw(i, str);
                                if (jn.yb(FullRewardExpressView.this.aj) || o.pr(FullRewardExpressView.this.aj)) {
                                    FullRewardExpressView.this.pr.pr(2);
                                }
                                if (FullRewardExpressView.this.pr != null) {
                                    FullRewardExpressView.this.pr.setPauseFromExpressView(true);
                                }
                            }
                        }, iAbs);
                    } else {
                        FullRewardExpressView.this.hn.uc();
                        FullRewardExpressView.this.hw(i, str);
                        if (jn.yb(FullRewardExpressView.this.aj) || o.pr(FullRewardExpressView.this.aj)) {
                            FullRewardExpressView.this.pr.pr(2);
                        }
                        if (FullRewardExpressView.this.pr != null) {
                            FullRewardExpressView.this.pr.setPauseFromExpressView(true);
                        }
                    }
                    FullRewardExpressView.this.rc.add(str);
                }
            }
        };
        com.byazt.ga.pr prVar = this.hn;
        if (prVar != null) {
            prVar.hn(50);
            this.hn.pr(this.iu);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(float f) {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.pr(f);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void pr(int i, int i2) {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.pr(i, i2);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.qx.w
    public void hn(int i) {
        w wVar = this.pr;
        if (wVar != null) {
            wVar.hn(i);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.mq.zo
    public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
        FullSwiperItemView.pr prVar = this.ve;
        if (prVar != null) {
            prVar.pr();
        }
        if (i != -1 && hnVar != null && i == 3) {
            aj();
            return;
        }
        if (i == 5) {
            pr(!this.a);
        } else if (i == 4) {
            fo();
        } else {
            super.pr(view, i, hnVar, i2);
        }
    }

    private void fo() {
        com.byazt.ga.pr prVar;
        if (!(this.x instanceof com.byazt.qq.pr) || (prVar = this.hn) == null) {
            return;
        }
        if (prVar.r()) {
            this.hn.uc();
            hw(true);
        } else {
            this.hn.zo();
            hw(false);
        }
    }

    @Override // com.byazt.qx.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c(z);
    }

    @Override // com.byazt.qx.NativeExpressView, com.byazt.mq.zo
    public void hw(View view, int i, com.byazt.dj.hn hnVar, int i2) {
        FullSwiperItemView.pr prVar = this.ve;
        if (prVar != null) {
            prVar.pr();
        }
        if (i != -1 && hnVar != null && i == 3) {
            aj();
        } else {
            super.hw(view, i, hnVar, i2);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (cz()) {
            return this.hw.getVideoContainer();
        }
        return this.g;
    }

    public void setVideoController(com.byazt.w.hn hnVar) {
        if (hnVar instanceof com.byazt.ga.pr) {
            com.byazt.ga.pr prVar = (com.byazt.ga.pr) hnVar;
            this.hn = prVar;
            prVar.hn(50);
            this.hn.pr(this.iu);
        }
    }

    @Override // com.byazt.qx.NativeExpressView
    public com.byazt.w.hn getVideoController() {
        return this.hn;
    }

    public void hw(boolean z) {
        if (this.fo == null) {
            this.fo = new ImageView(getContext());
            if (zo.nt().qi() != null) {
                this.fo.setImageBitmap(zo.nt().qi());
            } else {
                com.byazt.ca.g.pr(a.getContext(), "tt_new_play_video", this.fo, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            this.fo.setScaleType(ImageView.ScaleType.FIT_XY);
            int iHn = er.hn(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iHn, iHn);
            layoutParams.gravity = 17;
            this.g.addView(this.fo, layoutParams);
        }
        if (z) {
            this.fo.setVisibility(0);
        } else {
            this.fo.setVisibility(8);
        }
    }

    private void c(boolean z) {
        com.byazt.ga.pr prVar;
        if ((this.x instanceof com.byazt.qq.pr) && z) {
            ImageView imageView = this.fo;
            if (imageView != null && imageView.getVisibility() == 0 && (prVar = this.hn) != null) {
                prVar.uc();
            } else {
                pr(this.a);
            }
        }
    }

    public void setOnVideoSizeChangeListener(pr prVar) {
        this.z = prVar;
    }

    @Override // com.byazt.qx.NativeExpressView
    public void k() {
        super.k();
        this.rc.clear();
    }

    public boolean m() {
        g gVar = this.c;
        if (gVar == null) {
            return true;
        }
        if (gVar instanceof com.byazt.gu.hn) {
            return ((com.byazt.gu.hn) gVar).nt() != null;
        }
        return (gVar.zo() == 0.0d || this.c.aj() == 0.0d) ? false : true;
    }

    @Override // com.byazt.qx.NativeExpressView
    public void pr(com.byazt.cy.pr prVar) {
        x xVar = this.x;
        if (xVar == null) {
            this.nl = prVar;
        } else if (xVar instanceof c) {
            ((c) xVar).pr(prVar);
        } else if (xVar instanceof b) {
            ((b) xVar).pr(prVar);
        }
    }

    public g getRenderResult() {
        return this.c;
    }

    public void pr(int i, int i2, int i3, int i4) {
        com.byazt.bk.pr prVar = this.gz;
        if (prVar != null) {
            prVar.pr(i, i2, i3, i4);
        }
    }
}
