package com.byazt.ly;

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
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.kfh.TTProgressBar;
import com.byazt.ndr.TTRatingBar;
import com.byazt.ndr.TTRoundRectImageView;
import com.byazt.prf.RecyclerView;
import com.byazt.tk.sz;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.xk.FullRewardExpressView;
import com.byazt.za.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 119, 18})
public class l extends RecyclerView.m implements wo.n {
    public FrameLayout a;
    public final t ae;
    public com.byazt.has.s.n an;
    public boolean bb;
    public ViewGroup cd;
    public int df;
    public LinearLayout f;
    public final AnimatorSet fi;
    public final AtomicBoolean h;
    public FullRewardExpressView hd;
    public q hu;
    public int j;
    public com.byazt.ly.qg lh;
    public boolean ln;
    public TTProgressBar m;
    public FrameLayout ou;
    public FrameLayout py;
    public final AtomicBoolean t;
    public FrameLayout um;
    public boolean ur;
    public boolean v;
    public FrameLayout wm;

    public l(View view) {
        super(view);
        this.ae = new t(Looper.getMainLooper(), this);
        this.fi = new AnimatorSet();
        this.h = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.df = Integer.MAX_VALUE;
        this.cd = (ViewGroup) view.findViewById(2114387892);
        this.um = (FrameLayout) view.findViewById(2114387778);
        this.a = (FrameLayout) view.findViewById(2114387812);
        this.py = (FrameLayout) view.findViewById(2114387670);
        this.ou = (FrameLayout) view.findViewById(2114387821);
        this.wm = (FrameLayout) view.findViewById(2114387679);
        this.m = (TTProgressBar) view.findViewById(2114387767);
        n(view.getContext());
    }

    public void n(final com.byazt.ly.qg qgVar, float f, float f2) {
        this.lh = qgVar;
        this.m.setVisibility(0);
        df();
        this.hd = qgVar.qg(f, f2);
        if (qgVar.l) {
            if (this.hd.py()) {
                this.ou.setVisibility(8);
                this.wm.addView(n(this.n.getContext(), qgVar));
                this.wm.setVisibility(0);
            } else {
                this.hd.n((ViewGroup) this.um, false);
            }
            this.j = this.hd.getDynamicShowType();
            this.ln = true;
            ln();
            this.m.setVisibility(8);
        } else {
            this.hd.setExpressInteractionListener(new com.byazt.za.n() { // from class: com.byazt.ly.l.1
                @Override // com.byazt.za.n
                public void n(View view, float f3, float f4) {
                    if (l.this.hd.py()) {
                        l.this.ou.setVisibility(8);
                        l.this.wm.addView(l.this.n(view.getContext(), qgVar));
                        l.this.wm.setVisibility(0);
                    } else {
                        l.this.hd.n((ViewGroup) l.this.um, false);
                    }
                    l lVar = l.this;
                    lVar.j = lVar.hd.getDynamicShowType();
                    l.this.ln = true;
                    l.this.ln();
                    l.this.m.setVisibility(8);
                }
            });
        }
        this.hd.setExpressVideoListenerProxy(new d() { // from class: com.byazt.ly.l.2
            @Override // com.byazt.za.d
            public void fs() {
            }

            @Override // com.byazt.za.d
            public void l() {
            }

            @Override // com.byazt.za.d
            public void n(float f3) {
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
            public void n(boolean z) {
            }

            @Override // com.byazt.za.d
            public void q(int i) {
            }

            @Override // com.byazt.za.d
            public void rv() {
            }

            @Override // com.byazt.za.d
            public void s(int i) {
            }

            @Override // com.byazt.za.d
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.byazt.za.d
            public void tj() {
            }

            @Override // com.byazt.za.d
            public void w() {
            }

            @Override // com.byazt.za.d
            public void x() {
            }

            @Override // com.byazt.za.d
            public void n(int i) {
                if (l.this.hu == null) {
                    return;
                }
                if (i == 2) {
                    l.this.hu.x(true);
                    if (l.this.bb) {
                        l.this.an.n();
                        l.this.v();
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
                l.this.t.set(false);
                l.this.hu.x(false);
                if (l.this.bb) {
                    l.this.an.qg();
                    l.this.j();
                }
            }

            @Override // com.byazt.za.d
            public long n() {
                return l.this.hu.cp();
            }

            @Override // com.byazt.za.d
            public int qg() {
                if (l.this.h.get()) {
                    return 4;
                }
                if (l.this.hu == null || !l.this.v) {
                    return 2;
                }
                if (l.this.hu.b()) {
                    return 5;
                }
                if (l.this.hu.ou()) {
                    return 1;
                }
                if (l.this.hu.ri()) {
                    return 2;
                }
                l.this.hu.hu();
                return 3;
            }

            @Override // com.byazt.za.d
            public int s() {
                if (l.this.hu == null) {
                    return 0;
                }
                return (int) (l.this.hu.cp() / 1000);
            }

            @Override // com.byazt.za.d
            public void n(float f3, float f4, float f5, float f6, int i) {
                l.this.n(f3, f4, f5, f6, i);
            }

            @Override // com.byazt.za.d
            public void q() {
                l.this.t.set(true);
                if (l.this.bb) {
                    l.this.an.n();
                    l.this.lh.qg(false);
                }
            }

            @Override // com.byazt.za.d
            public void qg(int i) {
                l.this.an.n(i);
            }
        });
        this.hd.setOnVideoSizeChangeListener(new FullRewardExpressView.n() { // from class: com.byazt.ly.l.3
            @Override // com.byazt.xk.FullRewardExpressView.n
            public void n(int i) {
                l.this.df = i;
            }
        });
        this.ou.addView(this.hd);
        q qVar = new q(this.cd.getContext(), this.a, qgVar.n());
        this.hu = qVar;
        this.hd.setVideoController(qVar);
        qgVar.n(this.a, this.py, this.hd);
        this.hu.n(new qg(qgVar.l(), pe.s(this.lh.n()), new qg.n() { // from class: com.byazt.ly.l.4
            @Override // com.byazt.ly.l.qg.n
            public void n(boolean z) {
                l.this.q(z);
            }

            @Override // com.byazt.ly.l.qg.n
            public void n() {
                l.this.an.q();
            }

            @Override // com.byazt.ly.l.qg.n
            public void n(long j, long j2) {
                l.this.an.n(j, j2);
            }
        }, this.ae));
        this.hu.qg(this.lh.cp());
        this.hd.hd();
    }

    public View n(Context context, com.byazt.ly.qg qgVar) {
        String strJb;
        View viewSz = com.byazt.cb.qg.sz(context);
        RelativeLayout relativeLayout = (RelativeLayout) viewSz.findViewById(2114387649);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) viewSz.findViewById(2114387793);
        TextView textView = (TextView) viewSz.findViewById(2114387875);
        TextView textView2 = (TextView) viewSz.findViewById(2114387630);
        TextView textView3 = (TextView) viewSz.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) viewSz.findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(com.byazt.okk.s.s(context, 15.0f));
            tTRatingBar.setStarImageHeight(com.byazt.okk.s.s(context, 14.0f));
            tTRatingBar.setStarImagePadding(com.byazt.okk.s.s(context, 4.0f));
            tTRatingBar.n();
        }
        if (tTRoundRectImageView != null) {
            v vVarXu = qgVar.n().xu();
            if (vVarXu != null && !TextUtils.isEmpty(vVarXu.n())) {
                com.byazt.imu.s.n(vVarXu).n(tTRoundRectImageView);
            } else {
                sz.n(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
        if (textView != null) {
            if (qgVar.n().k() != null && !TextUtils.isEmpty(qgVar.n().k().s())) {
                textView.setText(qgVar.n().k().s());
            } else {
                textView.setText(qgVar.n().E_());
            }
        }
        if (textView2 != null) {
            int iW = qgVar.n().k() != null ? qgVar.n().k().w() : 6870;
            textView2.setText(String.format("%1$s个评分", iW > 10000 ? (iW / 10000) + "万" : String.valueOf(iW)));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(qgVar.n().jb())) {
                strJb = qgVar.n().rv() != 4 ? "查看详情" : "立即下载";
            } else {
                strJb = qgVar.n().jb();
            }
            textView3.setText(strJb);
        }
        com.byazt.okk.s.n((View) relativeLayout, (View.OnClickListener) qgVar.s(), "reward_draw_listener");
        return viewSz;
    }

    private void df() {
        FullRewardExpressView fullRewardExpressView = this.hd;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.oa();
        }
        this.df = Integer.MAX_VALUE;
        this.ln = false;
        this.bb = false;
        this.v = false;
        this.a.removeAllViews();
        this.py.removeAllViews();
        this.ou.removeAllViews();
        this.wm.removeAllViews();
        this.h.set(false);
        this.t.set(false);
        this.um.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        q qVar = this.hu;
        if (qVar != null) {
            qVar.tj();
        }
    }

    public void qg(boolean z) {
        if (this.bb == z) {
            return;
        }
        this.bb = z;
        if (z) {
            ln();
            return;
        }
        v();
        com.byazt.okk.s.n((View) this.f, 8);
        this.fi.cancel();
    }

    public void t() {
        if (this.fi.isStarted() && this.fi.isRunning()) {
            this.fi.pause();
        }
    }

    public void ur() {
        if (this.fi.isStarted() && this.fi.isPaused()) {
            this.fi.resume();
        }
    }

    public void bb() {
        if (this.fi.isStarted() && this.fi.isRunning()) {
            this.fi.cancel();
        }
    }

    public void ln() {
        if (this.hu != null && this.bb && this.ln) {
            this.lh.rv();
            this.hd.k();
            if (this.v && this.hu.hu()) {
                s(this.lh.w());
                j();
            } else {
                this.v = true;
                this.ae.sendEmptyMessageDelayed(101, 5000L);
                this.lh.n(this.hd);
                this.hu.n(this.lh.tj());
            }
        }
    }

    public long lh() {
        com.byazt.ly.qg qgVar = this.lh;
        if (qgVar == null) {
            return -1L;
        }
        return qgVar.cp();
    }

    public void v() {
        q qVar = this.hu;
        if (qVar != null) {
            qVar.w();
        }
    }

    public void j() {
        q qVar = this.hu;
        if (qVar != null) {
            qVar.fs();
        }
    }

    public void an() {
        FullRewardExpressView fullRewardExpressView = this.hd;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.oa();
        }
        q qVar = this.hu;
        if (qVar != null) {
            qVar.rv();
        }
    }

    public void s(boolean z) {
        q qVar = this.hu;
        if (qVar != null) {
            qVar.qg(z);
        }
    }

    public com.byazt.iag.s ae() {
        return this.hu;
    }

    public boolean f() {
        q qVar = this.hu;
        if (qVar == null) {
            return false;
        }
        return qVar.h();
    }

    public boolean fi() {
        return this.t.get();
    }

    private void n(Context context) {
        if (this.ur) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f.setGravity(1);
            this.f.setOrientation(1);
            ImageView imageView = new ImageView(context);
            sz.n(context, "tt_ic_back_light", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            this.f.addView(imageView, -1, -2);
            ImageView imageView2 = new ImageView(context);
            sz.n(context, "tt_ic_back_light", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            imageView2.setAlpha(0.7f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.byazt.okk.s.s(context, -8.0f);
            this.f.addView(imageView2, layoutParams);
            TextView textView = new TextView(context);
            textView.setGravity(1);
            textView.setTextColor(-1);
            textView.setText("上滑浏览更多内容");
            this.f.addView(textView);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = com.byazt.okk.s.s(context, 156.0f);
            this.cd.addView(this.f, layoutParams2);
            this.cd.setClipChildren(false);
            this.f.setVisibility(8);
            n(imageView, imageView2);
        }
    }

    private void n(View view, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new n());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, com.byazt.okk.s.s(this.cd.getContext(), -5.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new n());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "translationY", com.byazt.okk.s.s(this.cd.getContext(), -6.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        this.fi.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat2, objectAnimatorOfFloat4);
    }

    public void n(View view) {
        com.byazt.ly.qg qgVar = this.lh;
        if (qgVar == null || qgVar.s() == null) {
            return;
        }
        this.lh.s().onClick(view);
    }

    @com.byazt.cp.n(n = {0, 1, 119, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }

        private n() {
        }
    }

    public void n(float f, float f2, float f3, float f4, int i) {
        FullRewardExpressView fullRewardExpressView = this.hd;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.hd.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.hd.getVideoFrameLayout().getMeasuredHeight();
        if (this.hu.dh()) {
            this.hd.getVideoFrameLayout().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i);
            this.hd.getVideoFrameLayout().startAnimation(scaleAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z) {
        if (this.bb) {
            if (this.df > com.byazt.okk.s.w(this.n.getContext()) * 0.7f) {
                com.byazt.okk.s.n((View) this.f, 0);
                this.fi.start();
            }
            if (!z || this.h.get()) {
                return;
            }
            this.h.set(true);
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what != 101) {
            return;
        }
        q(true);
        com.byazt.ly.qg qgVar = this.lh;
        if (qgVar != null) {
            qgVar.x();
        }
    }

    public void n(com.byazt.has.s.n nVar) {
        q qVar;
        this.an = nVar;
        if (nVar == null || (qVar = this.hu) == null) {
            return;
        }
        qVar.qg(nVar.s());
    }

    @com.byazt.cp.n(n = {0, 1, 119, 120})
    private static class qg implements com.byazt.zx.n.InterfaceC0421n {
        public final t l;
        public final com.byazt.zx.n.InterfaceC0421n n;
        public final int q;
        public final n qg;
        public boolean s = false;

        interface n {
            void n();

            void n(long j, long j2);

            void n(boolean z);
        }

        public qg(com.byazt.zx.n.InterfaceC0421n interfaceC0421n, int i, n nVar, t tVar) {
            this.n = interfaceC0421n;
            this.qg = nVar;
            this.q = i;
            this.l = tVar;
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void n() {
            this.s = false;
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.n();
            }
            n nVar = this.qg;
            if (nVar != null) {
                nVar.n();
            }
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void n(int i, String str) {
            n(true);
            this.s = false;
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.n(i, str);
            }
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void qg() {
            n(true);
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.qg();
            }
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void n(long j, long j2) {
            this.l.removeMessages(101);
            if (j2 > 20000 && j > Math.min(((long) this.q) * 1000, j2) * 0.75f) {
                n(false);
                this.s = true;
            }
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.n(j, j2);
            }
            n nVar = this.qg;
            if (nVar != null) {
                nVar.n(j, j2);
            }
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void s() {
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.s();
            }
        }

        private void n(boolean z) {
            n nVar;
            if (this.s || (nVar = this.qg) == null) {
                return;
            }
            nVar.n(z);
        }
    }
}
