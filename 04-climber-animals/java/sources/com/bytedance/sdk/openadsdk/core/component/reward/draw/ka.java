package com.bytedance.sdk.openadsdk.core.component.reward.draw;

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
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.op;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hi;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends RecyclerView.re implements le.ms {
    private int az;
    public FrameLayout b;
    private boolean cv;
    private LinearLayout f;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.xr g;
    public FullRewardExpressView h;
    public TTProgressBar i;
    private final le jw;
    private boolean le;
    public FrameLayout nw;
    private boolean of;
    protected final AtomicBoolean op;
    private int p;
    private com.bytedance.sdk.openadsdk.core.component.reward.d.ah.ms pc;
    public ViewGroup qv;
    public FrameLayout re;
    public FrameLayout t;
    private final AnimatorSet ul;
    public d w;
    public FrameLayout y;
    protected final AtomicBoolean yu;

    public ka(View view) {
        super(view);
        this.jw = new le(Looper.getMainLooper(), this);
        this.ul = new AnimatorSet();
        this.yu = new AtomicBoolean(false);
        this.op = new AtomicBoolean(false);
        this.az = Integer.MAX_VALUE;
        this.qv = (ViewGroup) view.findViewById(2114387898);
        this.y = (FrameLayout) view.findViewById(2114387784);
        this.t = (FrameLayout) view.findViewById(2114387818);
        this.nw = (FrameLayout) view.findViewById(2114387676);
        this.b = (FrameLayout) view.findViewById(2114387827);
        this.re = (FrameLayout) view.findViewById(2114387685);
        this.i = (TTProgressBar) view.findViewById(2114387773);
        ms(view.getContext());
    }

    public void ms(final com.bytedance.sdk.openadsdk.core.component.reward.draw.xr xrVar, float f, float f2) {
        this.g = xrVar;
        m();
        this.i.setVisibility(0);
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.qv.getContext(), xrVar.ms(), op.ms(7, String.valueOf(f.ny(xrVar.ms())), f, f2), xrVar.xr(), false);
        this.h = fullRewardExpressView;
        fullRewardExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.ka.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, float f3, float f4) {
                if (ka.this.h.nw()) {
                    ka.this.b.setVisibility(8);
                    ka.this.re.addView(ka.this.ms(view.getContext(), xrVar));
                    ka.this.re.setVisibility(0);
                } else {
                    ka.this.h.ms((ViewGroup) ka.this.y, false);
                }
                ka kaVar = ka.this;
                kaVar.p = kaVar.h.getDynamicShowType();
                ka.this.cv = true;
                ka.this.g();
                ka.this.i.setVisibility(8);
            }
        });
        this.h.setExpressVideoListenerProxy(new hi() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.ka.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ab() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ch() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public long getActualPlayDuration() {
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void hi() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ka() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(float f3) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ny() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void x() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(int i) {
                if (ka.this.w == null) {
                    return;
                }
                if (i == 2) {
                    ka.this.w.ab(true);
                    if (ka.this.le) {
                        ka.this.p();
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
                ka.this.op.set(false);
                ka.this.w.ab(false);
                if (ka.this.le) {
                    ka.this.pc.xr();
                    ka.this.pc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public long ms() {
                return ka.this.w.hi();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public int xr() {
                if (ka.this.yu.get()) {
                    return 4;
                }
                if (ka.this.w == null || !ka.this.of) {
                    return 2;
                }
                if (ka.this.w.am()) {
                    return 5;
                }
                if (ka.this.w.b()) {
                    return 1;
                }
                if (ka.this.w.sa()) {
                    return 2;
                }
                ka.this.w.i();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public int ah() {
                if (ka.this.w == null) {
                    return 0;
                }
                return (int) (ka.this.w.hi() / 1000);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(float f3, float f4, float f5, float f6, int i) {
                ka.this.ms(f3, f4, f5, f6, i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void d() {
                ka.this.op.set(true);
                if (ka.this.le) {
                    ka.this.pc.ms();
                    ka.this.g.xr(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void xr(int i) {
                ka.this.pc.ms(i);
            }
        });
        this.h.setOnVideoSizeChangeListener(new FullRewardExpressView.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.ka.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.ms
            public void ms(int i) {
                ka.this.az = i;
            }
        });
        this.b.addView(this.h);
        d dVar = new d(this.qv.getContext(), this.t, xrVar.ms());
        this.w = dVar;
        this.h.setVideoController(dVar);
        xrVar.ms(this.t, this.nw, this.h);
        this.w.ms(new xr(xrVar.ka(), fm.ah(this.g.ms()), new xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.ka.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.ka.xr.ms
            public void ms(boolean z) {
                ka.this.d(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.ka.xr.ms
            public void ms() {
                ka.this.pc.d();
            }
        }, this.jw));
        this.w.xr(this.g.sl());
        this.h.h();
        this.h.qv();
    }

    public View ms(Context context, com.bytedance.sdk.openadsdk.core.component.reward.draw.xr xrVar) {
        String strBn;
        View viewZb = com.bytedance.sdk.openadsdk.res.ka.zb(context);
        RelativeLayout relativeLayout = (RelativeLayout) viewZb.findViewById(2114387655);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) viewZb.findViewById(2114387799);
        TextView textView = (TextView) viewZb.findViewById(2114387881);
        TextView textView2 = (TextView) viewZb.findViewById(2114387636);
        TextView textView3 = (TextView) viewZb.findViewById(2114387836);
        TTRatingBar tTRatingBar = (TTRatingBar) viewZb.findViewById(2114387615);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(ul.ah(context, 15.0f));
            tTRatingBar.setStarImageHeight(ul.ah(context, 14.0f));
            tTRatingBar.setStarImagePadding(ul.ah(context, 4.0f));
            tTRatingBar.ms();
        }
        if (tTRoundRectImageView != null) {
            g gVarQd = xrVar.ms().qd();
            if (gVarQd != null && !TextUtils.isEmpty(gVarQd.ms())) {
                com.bytedance.sdk.openadsdk.x.xr.ms(gVarQd).ms(tTRoundRectImageView);
            } else {
                t.ms(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            }
        }
        if (textView != null) {
            if (xrVar.ms().zh() != null && !TextUtils.isEmpty(xrVar.ms().zh().ah())) {
                textView.setText(xrVar.ms().zh().ah());
            } else {
                textView.setText(xrVar.ms().eh());
            }
        }
        if (textView2 != null) {
            int iC = xrVar.ms().zh() != null ? xrVar.ms().zh().c() : 6870;
            textView2.setText(String.format(t.ms(context, "tt_comment_num"), iC > 10000 ? (iC / 10000) + "万" : String.valueOf(iC)));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(xrVar.ms().bn())) {
                strBn = xrVar.ms().jr() != 4 ? "查看详情" : "立即下载";
            } else {
                strBn = xrVar.ms().bn();
            }
            textView3.setText(strBn);
        }
        ul.ms((View) relativeLayout, (View.OnClickListener) xrVar.ah(), "reward_draw_listener");
        return viewZb;
    }

    private void m() {
        FullRewardExpressView fullRewardExpressView = this.h;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.zb();
        }
        this.az = Integer.MAX_VALUE;
        this.cv = false;
        this.le = false;
        this.of = false;
        this.t.removeAllViews();
        this.nw.removeAllViews();
        this.b.removeAllViews();
        this.re.removeAllViews();
        this.yu.set(false);
        this.op.set(false);
        this.y.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        d dVar = this.w;
        if (dVar != null) {
            dVar.ch();
        }
    }

    public void xr(boolean z) {
        if (this.le == z) {
            return;
        }
        this.le = z;
        if (z) {
            g();
            return;
        }
        p();
        ul.ms((View) this.f, 8);
        this.ul.cancel();
    }

    public void op() {
        if (this.ul.isStarted() && this.ul.isRunning()) {
            this.ul.pause();
        }
    }

    public void le() {
        if (this.ul.isStarted() && this.ul.isPaused()) {
            this.ul.resume();
        }
    }

    public void cv() {
        if (this.ul.isStarted() && this.ul.isRunning()) {
            this.ul.cancel();
        }
    }

    public void g() {
        if (this.w != null && this.le && this.cv) {
            this.g.ch();
            this.h.ao();
            if (this.of && this.w.i()) {
                ah(this.g.c());
                pc();
            } else {
                this.of = true;
                this.jw.sendEmptyMessageDelayed(101, 5000L);
                this.g.ms(this.h);
                this.w.ms(this.g.hi());
            }
        }
    }

    public long of() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xr xrVar = this.g;
        if (xrVar == null) {
            return -1L;
        }
        return xrVar.sl();
    }

    public void p() {
        d dVar = this.w;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void pc() {
        d dVar = this.w;
        if (dVar != null) {
            dVar.x();
        }
    }

    public void jw() {
        FullRewardExpressView fullRewardExpressView = this.h;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.zb();
        }
        d dVar = this.w;
        if (dVar != null) {
            dVar.ny();
        }
    }

    public void ah(boolean z) {
        d dVar = this.w;
        if (dVar != null) {
            dVar.xr(z);
        }
    }

    public com.bykv.vk.openvk.component.video.api.d.ah f() {
        return this.w;
    }

    public boolean ul() {
        d dVar = this.w;
        if (dVar == null) {
            return false;
        }
        return dVar.w();
    }

    public boolean az() {
        return this.op.get();
    }

    private void ms(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f = linearLayout;
        linearLayout.setClipChildren(false);
        this.f.setGravity(1);
        this.f.setOrientation(1);
        ImageView imageView = new ImageView(context);
        t.ms(context, "tt_ic_back_light", imageView);
        this.f.addView(imageView, -1, -2);
        ImageView imageView2 = new ImageView(context);
        t.ms(context, "tt_ic_back_light", imageView2);
        imageView2.setAlpha(0.7f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ul.ah(context, -8.0f);
        this.f.addView(imageView2, layoutParams);
        TextView textView = new TextView(context);
        textView.setGravity(1);
        textView.setTextColor(-1);
        textView.setText("上滑浏览更多内容");
        this.f.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = ul.ah(context, 156.0f);
        this.qv.addView(this.f, layoutParams2);
        this.qv.setClipChildren(false);
        this.f.setVisibility(8);
        ms(imageView, imageView2);
    }

    private void ms(View view, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new ms());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, ul.ah(this.qv.getContext(), -5.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new ms());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "translationY", ul.ah(this.qv.getContext(), -6.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        this.ul.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat2, objectAnimatorOfFloat4);
    }

    public void ms(View view) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xr xrVar = this.g;
        if (xrVar == null || xrVar.ah() == null) {
            return;
        }
        this.g.ah().onClick(view);
    }

    private static class ms implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }

        private ms() {
        }
    }

    public void ms(float f, float f2, float f3, float f4, int i) {
        FullRewardExpressView fullRewardExpressView = this.h;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.h.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.h.getVideoFrameLayout().getMeasuredHeight();
        if (this.w.qf()) {
            this.h.getVideoFrameLayout().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i);
            this.h.getVideoFrameLayout().startAnimation(scaleAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (this.le) {
            if (this.az > ul.ka(this.f1391ms.getContext()) * 0.7f) {
                ul.ms((View) this.f, 0);
                this.ul.start();
            }
            if (!z || this.yu.get()) {
                return;
            }
            ul.ms(this.qv.getContext(), "视频加载错误，请上滑浏览其他内容", 0);
            this.yu.set(true);
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what != 101) {
            return;
        }
        d(true);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xr xrVar = this.g;
        if (xrVar != null) {
            xrVar.x();
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.d.ah.ms msVar) {
        d dVar;
        this.pc = msVar;
        if (msVar == null || (dVar = this.w) == null) {
            return;
        }
        dVar.xr(msVar.ah());
    }

    private static class xr implements com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms {
        private boolean ah = false;
        private final int d;
        private final le ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms f2157ms;
        private final ms xr;

        interface ms {
            void ms();

            void ms(boolean z);
        }

        xr(com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms, int i, ms msVar, le leVar) {
            this.f2157ms = interfaceC0325ms;
            this.xr = msVar;
            this.d = i;
            this.ka = leVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void ms() {
            this.ah = false;
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2157ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ms();
            }
            ms msVar = this.xr;
            if (msVar != null) {
                msVar.ms();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void ms(int i, String str) {
            ms(true);
            this.ah = false;
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2157ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ms(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void xr() {
            ms(true);
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2157ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.xr();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void ms(long j, long j2) {
            this.ka.removeMessages(101);
            if (j2 > 20000 && j > Math.min(((long) this.d) * 1000, j2) * 0.75f) {
                ms(false);
                this.ah = true;
            }
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2157ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ms(j, j2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void ah() {
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2157ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ah();
            }
        }

        private void ms(boolean z) {
            ms msVar;
            if (this.ah || (msVar = this.xr) == null) {
                return;
            }
            msVar.ms(z);
        }
    }
}
