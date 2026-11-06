package com.byazt.dr;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.ca.iu;
import com.byazt.fj.TTProgressBar;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.hr.RecyclerView;
import com.byazt.pg.FullRewardExpressView;
import com.byazt.pi.TTRatingBar;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.qx.w;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1091, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends RecyclerView.fo implements qi.pr {
    public FrameLayout a;
    public final AtomicBoolean b;
    public FrameLayout cz;
    public com.byazt.lu.hn.pr e;
    public final AnimatorSet er;
    public FrameLayout fo;
    public boolean gz;
    public final AtomicBoolean iu;
    public ViewGroup lb;
    public LinearLayout ls;
    public int n;
    public boolean nl;
    public FrameLayout ny;
    public FrameLayout qa;
    public TTProgressBar rc;
    public final iu s;
    public int v;
    public boolean ve;
    public boolean ww;
    public com.byazt.dr.hw y;
    public FullRewardExpressView yb;
    public x z;

    public c(View view) {
        super(view);
        this.s = new iu(Looper.getMainLooper(), this);
        this.er = new AnimatorSet();
        this.b = new AtomicBoolean(false);
        this.iu = new AtomicBoolean(false);
        this.v = Integer.MAX_VALUE;
        this.lb = (ViewGroup) view.findViewById(2114387892);
        this.qa = (FrameLayout) view.findViewById(2114387778);
        this.a = (FrameLayout) view.findViewById(2114387812);
        this.cz = (FrameLayout) view.findViewById(2114387670);
        this.ny = (FrameLayout) view.findViewById(2114387821);
        this.fo = (FrameLayout) view.findViewById(2114387679);
        this.rc = (TTProgressBar) view.findViewById(2114387767);
        pr(view.getContext());
    }

    public void pr(final com.byazt.dr.hw hwVar, float f, float f2) {
        this.y = hwVar;
        this.rc.setVisibility(0);
        v();
        this.yb = hwVar.hw(f, f2);
        if (hwVar.c) {
            if (this.yb.cz()) {
                this.ny.setVisibility(8);
                this.fo.addView(pr(this.pr.getContext(), hwVar));
                this.fo.setVisibility(0);
            } else {
                this.yb.pr((ViewGroup) this.qa, false);
            }
            this.n = this.yb.getDynamicShowType();
            this.nl = true;
            nl();
            this.rc.setVisibility(8);
        } else {
            this.yb.setExpressInteractionListener(new com.byazt.qx.pr() { // from class: com.byazt.dr.c.1
                @Override // com.byazt.qx.pr
                public void pr(View view, float f3, float f4) {
                    if (c.this.yb.cz()) {
                        c.this.ny.setVisibility(8);
                        c.this.fo.addView(c.this.pr(view.getContext(), hwVar));
                        c.this.fo.setVisibility(0);
                    } else {
                        c.this.yb.pr((ViewGroup) c.this.qa, false);
                    }
                    c cVar = c.this;
                    cVar.n = cVar.yb.getDynamicShowType();
                    c.this.nl = true;
                    c.this.nl();
                    c.this.rc.setVisibility(8);
                }
            });
        }
        this.yb.setExpressVideoListenerProxy(new w() { // from class: com.byazt.dr.c.2
            @Override // com.byazt.qx.w
            public void pr(boolean z) {
            }

            @Override // com.byazt.qx.w
            public void uc() {
            }

            @Override // com.byazt.qx.w
            public void fw() {
            }

            @Override // com.byazt.qx.w
            public void pr(int i) {
                if (c.this.z == null) {
                }
                switch (i) {
                    case 2:
                        c.this.z.fw(true);
                        if (c.this.gz) {
                            c.this.e.pr();
                            c.this.ww();
                        }
                        break;
                    case 3:
                        c.this.iu.set(false);
                        c.this.z.fw(false);
                        if (c.this.gz) {
                            c.this.e.hw();
                            c.this.n();
                        }
                        break;
                }
            }

            @Override // com.byazt.qx.w
            public long pr() {
                return c.this.z.w();
            }

            @Override // com.byazt.qx.w
            public int hw() {
                if (c.this.b.get()) {
                    return 4;
                }
                if (c.this.z == null || !c.this.ww) {
                    return 2;
                }
                if (c.this.z.i()) {
                    return 5;
                }
                if (c.this.z.ny()) {
                    return 1;
                }
                if (c.this.z.r()) {
                    return 2;
                }
                c.this.z.rc();
                return 3;
            }

            @Override // com.byazt.qx.w
            public void zo() {
            }

            @Override // com.byazt.qx.w
            public int hn() {
                if (c.this.z == null) {
                    return 0;
                }
                return (int) (c.this.z.w() / 1000);
            }

            @Override // com.byazt.qx.w
            public void aj() {
            }

            @Override // com.byazt.qx.w
            public void vk() {
            }

            @Override // com.byazt.qx.w
            public void x(int i) {
            }

            @Override // com.byazt.qx.w
            public void pr(float f3, float f4, float f5, float f6, int i) {
                c.this.pr(f3, f4, f5, f6, i);
            }

            @Override // com.byazt.qx.w
            public void x() {
                c.this.iu.set(true);
                if (c.this.gz) {
                    c.this.e.pr();
                    c.this.y.hw(false);
                }
            }

            @Override // com.byazt.qx.w
            public void hw(int i) {
                c.this.e.pr(i);
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
            public void pr(float f3) {
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
        });
        this.yb.setOnVideoSizeChangeListener(new FullRewardExpressView.pr() { // from class: com.byazt.dr.c.3
            @Override // com.byazt.pg.FullRewardExpressView.pr
            public void pr(int i) {
                c.this.v = i;
            }
        });
        this.ny.addView(this.yb);
        x xVar = new x(this.lb.getContext(), this.a, hwVar.pr());
        this.z = xVar;
        this.yb.setVideoController(xVar);
        hwVar.pr(this.a, this.cz, this.yb);
        this.z.pr(new hw(hwVar.c(), o.hn(this.y.pr()), new hw.pr() { // from class: com.byazt.dr.c.4
            @Override // com.byazt.dr.c.hw.pr
            public void pr(boolean z) {
                c.this.x(z);
            }

            @Override // com.byazt.dr.c.hw.pr
            public void pr() {
                c.this.e.x();
            }

            @Override // com.byazt.dr.c.hw.pr
            public void pr(long j, long j2) {
                c.this.e.pr(j, j2);
            }
        }, this.s));
        this.z.hw(this.y.w());
        this.yb.yb();
    }

    public View pr(Context context, com.byazt.dr.hw hwVar) {
        String strSe;
        View viewG = com.byazt.sdv.c.g(context);
        RelativeLayout relativeLayout = (RelativeLayout) viewG.findViewById(2114387649);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) viewG.findViewById(2114387793);
        TextView textView = (TextView) viewG.findViewById(2114387875);
        TextView textView2 = (TextView) viewG.findViewById(2114387630);
        TextView textView3 = (TextView) viewG.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) viewG.findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(er.hn(context, 15.0f));
            tTRatingBar.setStarImageHeight(er.hn(context, 14.0f));
            tTRatingBar.setStarImagePadding(er.hn(context, 4.0f));
            tTRatingBar.pr();
        }
        if (tTRoundRectImageView != null) {
            y yVarMo = hwVar.pr().mo();
            if (yVarMo != null && !TextUtils.isEmpty(yVarMo.pr())) {
                com.byazt.ub.hw.pr(yVarMo).pr(tTRoundRectImageView);
            } else {
                g.pr(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
        if (textView != null) {
            if (hwVar.pr().ho() != null && !TextUtils.isEmpty(hwVar.pr().ho().hn())) {
                textView.setText(hwVar.pr().ho().hn());
            } else {
                textView.setText(hwVar.pr().A_());
            }
        }
        if (textView2 != null) {
            int iUc = 6870;
            if (hwVar.pr().ho() != null) {
                iUc = hwVar.pr().ho().uc();
            }
            textView2.setText(String.format("%1$s个评分", iUc > 10000 ? (iUc / 10000) + "万" : String.valueOf(iUc)));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(hwVar.pr().se())) {
                if (hwVar.pr().aj() == 4) {
                    strSe = "立即下载";
                } else {
                    strSe = "查看详情";
                }
            } else {
                strSe = hwVar.pr().se();
            }
            textView3.setText(strSe);
        }
        er.pr((View) relativeLayout, (View.OnClickListener) hwVar.hn(), "reward_draw_listener");
        return viewG;
    }

    private void v() {
        FullRewardExpressView fullRewardExpressView = this.yb;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
        this.v = Integer.MAX_VALUE;
        this.nl = false;
        this.gz = false;
        this.ww = false;
        this.a.removeAllViews();
        this.cz.removeAllViews();
        this.ny.removeAllViews();
        this.fo.removeAllViews();
        this.b.set(false);
        this.iu.set(false);
        this.qa.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        x xVar = this.z;
        if (xVar != null) {
            xVar.vk();
        }
    }

    public void hw(boolean z) {
        if (this.gz == z) {
            return;
        }
        this.gz = z;
        if (z) {
            nl();
            return;
        }
        ww();
        er.pr((View) this.ls, 8);
        this.er.cancel();
    }

    public void iu() {
        if (this.er.isStarted() && this.er.isRunning()) {
            this.er.pause();
        }
    }

    public void ve() {
        if (this.er.isStarted() && this.er.isPaused()) {
            this.er.resume();
        }
    }

    public void gz() {
        if (this.er.isStarted() && this.er.isRunning()) {
            this.er.cancel();
        }
    }

    public void nl() {
        if (this.z != null && this.gz && this.nl) {
            this.y.aj();
            this.yb.ho();
            if (this.ww && this.z.rc()) {
                hn(this.y.uc());
                n();
            } else {
                this.ww = true;
                this.s.sendEmptyMessageDelayed(101, 5000L);
                this.y.pr(this.yb);
                this.z.pr(this.y.vk());
            }
        }
    }

    public long y() {
        com.byazt.dr.hw hwVar = this.y;
        if (hwVar == null) {
            return -1L;
        }
        return hwVar.w();
    }

    public void ww() {
        x xVar = this.z;
        if (xVar != null) {
            xVar.uc();
        }
    }

    public void n() {
        x xVar = this.z;
        if (xVar != null) {
            xVar.zo();
        }
    }

    public void e() {
        FullRewardExpressView fullRewardExpressView = this.yb;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
        x xVar = this.z;
        if (xVar != null) {
            xVar.aj();
        }
    }

    public void hn(boolean z) {
        x xVar = this.z;
        if (xVar != null) {
            xVar.hw(z);
        }
    }

    public com.byazt.w.hn s() {
        return this.z;
    }

    public boolean ls() {
        x xVar = this.z;
        if (xVar == null) {
            return false;
        }
        return xVar.z();
    }

    public boolean er() {
        return this.iu.get();
    }

    private void pr(Context context) {
        if (!this.ve) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.ls = linearLayout;
        linearLayout.setClipChildren(false);
        this.ls.setGravity(1);
        this.ls.setOrientation(1);
        ImageView imageView = new ImageView(context);
        g.pr(context, "tt_ic_back_light", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.ls.addView(imageView, -1, -2);
        ImageView imageView2 = new ImageView(context);
        g.pr(context, "tt_ic_back_light", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView2.setAlpha(0.7f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = er.hn(context, -8.0f);
        this.ls.addView(imageView2, layoutParams);
        TextView textView = new TextView(context);
        textView.setGravity(1);
        textView.setTextColor(-1);
        textView.setText("上滑浏览更多内容");
        this.ls.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = er.hn(context, 156.0f);
        this.lb.addView(this.ls, layoutParams2);
        this.lb.setClipChildren(false);
        this.ls.setVisibility(8);
        pr(imageView, imageView2);
    }

    private void pr(View view, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new pr());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, er.hn(this.lb.getContext(), -5.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new pr());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "translationY", er.hn(this.lb.getContext(), -6.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        this.er.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat2, objectAnimatorOfFloat4);
    }

    public void pr(View view) {
        com.byazt.dr.hw hwVar = this.y;
        if (hwVar == null || hwVar.hn() == null) {
            return;
        }
        this.y.hn().onClick(view);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1091, 169})
    private static class pr implements Interpolator {
        private pr() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.38f) {
                return f * 2.631579f;
            }
            return (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public void pr(float f, float f2, float f3, float f4, int i) {
        FullRewardExpressView fullRewardExpressView = this.yb;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.yb.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.yb.getVideoFrameLayout().getMeasuredHeight();
        if (this.z.ii()) {
            this.yb.getVideoFrameLayout().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i);
            this.yb.getVideoFrameLayout().startAnimation(scaleAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (!this.gz) {
            return;
        }
        if (this.v > er.uc(this.pr.getContext()) * 0.7f) {
            er.pr((View) this.ls, 0);
            this.er.start();
        }
        if (z && !this.b.get()) {
            this.b.set(true);
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 101:
                x(true);
                com.byazt.dr.hw hwVar = this.y;
                if (hwVar != null) {
                    hwVar.fw();
                }
                break;
        }
    }

    public void pr(com.byazt.lu.hn.pr prVar) {
        x xVar;
        this.e = prVar;
        if (prVar != null && (xVar = this.z) != null) {
            xVar.hw(prVar.hn());
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1091, 401})
    private static class hw implements com.byazt.ga.pr.InterfaceC0074pr {
        public final iu c;
        public boolean hn = false;
        public final pr hw;
        public final com.byazt.ga.pr.InterfaceC0074pr pr;
        public final int x;

        interface pr {
            void pr();

            void pr(long j, long j2);

            void pr(boolean z);
        }

        public hw(com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr, int i, pr prVar, iu iuVar) {
            this.pr = interfaceC0074pr;
            this.hw = prVar;
            this.x = i;
            this.c = iuVar;
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void pr() {
            this.hn = false;
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.pr();
            }
            pr prVar = this.hw;
            if (prVar != null) {
                prVar.pr();
            }
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void pr(int i, String str) {
            pr(true);
            this.hn = false;
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.pr(i, str);
            }
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void hw() {
            pr(true);
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.hw();
            }
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void pr(long j, long j2) {
            this.c.removeMessages(101);
            if (j2 > 20000 && j > Math.min(((long) this.x) * 1000, j2) * 0.75f) {
                pr(false);
                this.hn = true;
            }
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.pr(j, j2);
            }
            pr prVar = this.hw;
            if (prVar != null) {
                prVar.pr(j, j2);
            }
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void hn() {
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.hn();
            }
        }

        private void pr(boolean z) {
            pr prVar;
            if (!this.hn && (prVar = this.hw) != null) {
                prVar.pr(z);
            }
        }
    }
}
