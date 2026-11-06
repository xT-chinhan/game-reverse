package com.anythink.basead.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.basead.b.e;
import com.anythink.basead.d.f;
import com.anythink.basead.d.j;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.ba;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.q;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSdkSplashATView extends BaseSplashATView {
    public static final int TYPE_ASSEBLEM = 1;
    public static final int TYPE_SINGLE_PICTURE = 0;
    protected RoundImageView C;
    protected MuteImageView D;
    ImageView E;
    ImageView F;
    protected final View.OnClickListener G;
    protected boolean H;
    private SplashEndCardView a;
    private ValueAnimator b;

    protected abstract void b();

    protected abstract void d();

    public BaseSdkSplashATView(Context context) {
        super(context);
        this.G = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashATView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BaseSdkSplashATView.this.f.o == null || BaseSdkSplashATView.this.f.o.H() != 0) {
                    return;
                }
                BaseSdkSplashATView.this.a(1, 3);
            }
        };
        this.H = false;
    }

    public BaseSdkSplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
        this.G = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashATView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BaseSdkSplashATView.this.f.o == null || BaseSdkSplashATView.this.f.o.H() != 0) {
                    return;
                }
                BaseSdkSplashATView.this.a(1, 3);
            }
        };
        this.H = false;
        d();
        x();
        a((b) this.J, false);
    }

    protected void w() {
        b();
        this.C = (RoundImageView) findViewById(q.a(getContext(), "myoffer_ad_logo", "id"));
        this.E = (ImageView) findViewById(q.a(getContext(), "myoffer_player_view_cover_img_id", "id"));
        this.F = (ImageView) findViewById(q.a(getContext(), "myoffer_player_view_cover_icon_id", "id"));
        this.K = (ViewGroup) findViewById(q.a(getContext(), "myoffer_feedback_ll_id", "id"));
        if (e.a(this.g, this.f)) {
            if (this.E != null && !TextUtils.isEmpty(this.g.B())) {
                ImageView imageView = this.F;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ImageView imageView2 = this.E;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.g.B()), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new AnonymousClass8());
            }
        } else {
            ImageView imageView3 = this.F;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.E;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        if (!e.a(this.g, this.f)) {
            c();
            return;
        }
        this.r = new com.anythink.basead.ui.component.a(this, this.f, this.g);
        this.r.a(r());
        if (this.s != null) {
            this.r.a(this.s);
        }
        this.H = this.r.l() == null;
        this.r.o();
        this.r.a(new AnonymousClass5());
        this.r.a(new AnonymousClass6());
        if (t()) {
            this.r.c(0);
            this.r.a(true, (List<Bitmap>) null, this.z);
        }
        MuteImageView muteImageView = (MuteImageView) findViewById(q.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.D = muteImageView;
        if (muteImageView != null) {
            muteImageView.setMute(true);
            this.D.setVisibility(0);
            this.D.setOnClickListener(new AnonymousClass7());
            if (this.g.b() == 4) {
                try {
                    if (ATSDKGlobalSetting.getDirectlySplashMuteIconVisible() != null) {
                        this.D.setVisibility(ATSDKGlobalSetting.getDirectlySplashMuteIconVisible().booleanValue() ? 0 : 8);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void i() {
        super.i();
        if (this.r != null) {
            this.r.a(this.s);
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    protected void x() {
        super.x();
        setOnClickListener(this.G);
    }

    public static boolean isSinglePicture(w wVar, y yVar) {
        if ((wVar instanceof ay) && (yVar instanceof ba)) {
            return 2 == ((ba) yVar).a();
        }
        return (wVar instanceof bj) && 1 == ((bj) wVar).aI();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    @Override // com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.r != null) {
            int i = this.U;
            int i2 = 2;
            if (i != 1) {
                if (i == 2) {
                    i2 = 1;
                } else if (i != 6) {
                    if (i != 7) {
                        i2 = 4;
                    } else {
                        i2 = 1;
                    }
                }
            }
            this.r.f(i2);
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    public void onSplashEndCardCountDownTick(long j) {
        super.onSplashEndCardCountDownTick(j);
        if (this.a == null) {
            beforeSplashEndCardShow();
            SplashEndCardView splashEndCardView = new SplashEndCardView(getContext(), this.g, this.f);
            this.a = splashEndCardView;
            splashEndCardView.init(new BaseEndCardView.b() { // from class: com.anythink.basead.ui.BaseSdkSplashATView.2
                @Override // com.anythink.basead.ui.BaseEndCardView.a
                public final void a() {
                }

                @Override // com.anythink.basead.ui.BaseEndCardView.b
                public final void b() {
                    BaseSdkSplashATView.this.a(true, 1);
                }

                @Override // com.anythink.basead.ui.BaseEndCardView.a
                public final void a(int i) {
                    BaseSdkSplashATView.this.a(i != 9 ? 1 : 4, i);
                }
            }, this.w);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.a.setAlpha(0.2f);
            addView(this.a, layoutParams);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.2f, 1.0f);
            this.b = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.b.setRepeatCount(0);
            final View viewFindViewById = findViewById(q.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
            this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.BaseSdkSplashATView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (BaseSdkSplashATView.this.a != null) {
                        BaseSdkSplashATView.this.a.setAlpha(fFloatValue);
                    }
                    View view = viewFindViewById;
                    if (view != null) {
                        view.setAlpha((float) (1.0d - ((((double) fFloatValue) - 0.2d) * 1.25d)));
                    }
                }
            });
            this.b.addListener(new AnimatorListenerAdapter() { // from class: com.anythink.basead.ui.BaseSdkSplashATView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    View view = viewFindViewById;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
            });
            this.b.start();
        }
        this.a.onCountDownTick(j);
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    public void beforeSplashEndCardShow() {
        super.beforeSplashEndCardShow();
        if (this.I != null) {
            this.I.setVisibility(8);
        }
        if (this.q != null) {
            this.q.setVisibility(8);
        }
        View viewFindViewById = findViewById(q.a(getContext(), "myoffer_fl_invalid_btn", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (this.r != null) {
            this.r.d(5);
        }
    }

    protected void c() {
        this.H = true;
    }

    private void D() {
        this.r = new com.anythink.basead.ui.component.a(this, this.f, this.g);
        this.r.a(r());
        if (this.s != null) {
            this.r.a(this.s);
        }
        int i = 0;
        this.H = this.r.l() == null;
        this.r.o();
        this.r.a(new AnonymousClass5());
        this.r.a(new AnonymousClass6());
        if (t()) {
            this.r.c(0);
            this.r.a(true, (List<Bitmap>) null, this.z);
        }
        MuteImageView muteImageView = (MuteImageView) findViewById(q.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.D = muteImageView;
        if (muteImageView != null) {
            muteImageView.setMute(true);
            this.D.setVisibility(0);
            this.D.setOnClickListener(new AnonymousClass7());
            if (this.g.b() == 4) {
                try {
                    if (ATSDKGlobalSetting.getDirectlySplashMuteIconVisible() != null) {
                        MuteImageView muteImageView2 = this.D;
                        if (!ATSDKGlobalSetting.getDirectlySplashMuteIconVisible().booleanValue()) {
                            i = 8;
                        }
                        muteImageView2.setVisibility(i);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseSdkSplashATView$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.basead.ui.component.a.InterfaceC0058a {
        AnonymousClass5() {
        }

        @Override // com.anythink.basead.ui.component.a.InterfaceC0058a
        public final j a() {
            return BaseSdkSplashATView.this.l();
        }

        @Override // com.anythink.basead.ui.component.a.InterfaceC0058a
        public final com.anythink.basead.d.a b() {
            return BaseSdkSplashATView.this.m();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseSdkSplashATView$6, reason: invalid class name */
    final class AnonymousClass6 implements BasePlayerView.a {
        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void a(int i) {
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void a(long j) {
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void b(long j) {
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void d() {
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void e() {
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void f() {
        }

        AnonymousClass6() {
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void a() {
            if (BaseSdkSplashATView.this.F != null) {
                BaseSdkSplashATView.this.F.setVisibility(8);
            }
            if (BaseSdkSplashATView.this.E != null) {
                BaseSdkSplashATView.this.E.setVisibility(8);
            }
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void c() {
            BaseSdkSplashATView.b(BaseSdkSplashATView.this);
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void a(f fVar) {
            BaseSdkSplashATView.b(BaseSdkSplashATView.this);
            com.anythink.core.common.u.e.a(BaseSdkSplashATView.this.f, BaseSdkSplashATView.this.g, 2, fVar.c());
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void b(int i) {
            if (BaseSdkSplashATView.this.f.o.H() != 1) {
                BaseSdkSplashATView.this.a(i, 3);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseSdkSplashATView$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (BaseSdkSplashATView.this.r == null || BaseSdkSplashATView.this.D == null) {
                return;
            }
            if (!BaseSdkSplashATView.this.r.f()) {
                BaseSdkSplashATView.this.D.setMute(true);
                BaseSdkSplashATView.this.r.c(true);
            } else {
                BaseSdkSplashATView.this.D.setMute(false);
                BaseSdkSplashATView.this.r.c(false);
            }
        }
    }

    private void E() {
        if (e.a(this.g, this.f)) {
            if (this.E == null || TextUtils.isEmpty(this.g.B())) {
                return;
            }
            ImageView imageView = this.F;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.E;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.g.B()), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new AnonymousClass8());
            return;
        }
        ImageView imageView3 = this.F;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        ImageView imageView4 = this.E;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseSdkSplashATView$8, reason: invalid class name */
    final class AnonymousClass8 implements com.anythink.core.common.res.b.a {
        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass8() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, BaseSdkSplashATView.this.g.B())) {
                if (BaseSdkSplashATView.this.F != null) {
                    BaseSdkSplashATView.this.F.setVisibility(8);
                }
                BaseSdkSplashATView.this.E.setImageBitmap(bitmap);
            }
        }
    }

    private void F() {
        this.H = true;
        G();
        if (this.ab) {
            a(true, 7);
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView
    protected void a(int i) {
        super.a(i);
        if (i == 110) {
            z();
        } else {
            if (i != 111) {
                return;
            }
            G();
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    protected final boolean y() {
        return !this.H && this.f.o.aH() == 1;
    }

    protected final void z() {
        if (this.r != null) {
            if ((this.R == null || !this.R.a()) && !this.H) {
                if (!this.ab || this.f.o.aH() == 1) {
                    this.r.d();
                }
            }
        }
    }

    private void G() {
        if (this.r != null) {
            this.r.d(2);
        }
    }

    static /* synthetic */ void b(BaseSdkSplashATView baseSdkSplashATView) {
        baseSdkSplashATView.H = true;
        baseSdkSplashATView.G();
        if (baseSdkSplashATView.ab) {
            baseSdkSplashATView.a(true, 7);
        }
    }
}
