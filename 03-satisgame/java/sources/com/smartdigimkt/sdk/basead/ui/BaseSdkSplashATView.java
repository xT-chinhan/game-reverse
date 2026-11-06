package com.smartdigimkt.sdk.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.c1.g;
import com.smartdigimkt.e3.a;
import com.smartdigimkt.e3.b;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.e0;
import com.smartdigimkt.n1.j3;
import com.smartdigimkt.n1.k1;
import com.smartdigimkt.n1.l1;
import com.smartdigimkt.n1.l2;
import com.smartdigimkt.n1.m1;
import com.smartdigimkt.n1.n1;
import com.smartdigimkt.n1.o1;
import com.smartdigimkt.n1.p1;
import com.smartdigimkt.n1.q1;
import com.smartdigimkt.n1.r1;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewSplashATView;
import com.smartdigimkt.u1.d;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSdkSplashATView extends BaseSplashATView {
    public static final int TYPE_ASSEBLEM = 1;
    public static final int TYPE_SINGLE_PICTURE = 0;
    public MuteImageView f0;
    public ImageView g0;
    public ImageView h0;
    public final k1 i0;
    public SplashEndCardView j0;
    public ValueAnimator k0;
    public boolean l0;

    public BaseSdkSplashATView(Context context) {
        super(context);
        this.i0 = new k1(this);
        this.l0 = false;
    }

    public static boolean isSinglePicture(c cVar, e eVar) {
        if ((cVar instanceof a) && (eVar instanceof b)) {
            return 2 == ((b) eVar).X1;
        }
        return (cVar instanceof l) && 1 == ((l) cVar).U;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public void a(int i) {
        d dVar;
        super.a(i);
        if (i == 110) {
            u();
        } else if (i == 111 && (dVar = this.n) != null) {
            dVar.b(2);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public void beforeSplashEndCardShow() {
        super.beforeSplashEndCardShow();
        TextView textView = this.E;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.m;
        if (view != null) {
            view.setVisibility(8);
        }
        View viewFindViewById = findViewById(k.a(getContext(), "myoffer_fl_invalid_btn", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        d dVar = this.n;
        if (dVar != null) {
            dVar.b(5);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void e() {
        super.e();
        d dVar = this.n;
        if (dVar != null) {
            dVar.g = this.o;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.k0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        d dVar = this.n;
        if (dVar != null) {
            int i = this.V;
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
            BasePlayerView basePlayerView = dVar.h;
            if (basePlayerView != null) {
                basePlayerView.release(i2);
            }
            dVar.c();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public void onSplashEndCardCountDownTick(long j) {
        super.onSplashEndCardCountDownTick(j);
        if (this.j0 == null) {
            beforeSplashEndCardShow();
            SplashEndCardView splashEndCardView = new SplashEndCardView(getContext(), this.c, this.b);
            this.j0 = splashEndCardView;
            splashEndCardView.init(new l1(this), this.w);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.j0.setAlpha(0.2f);
            addView(this.j0, layoutParams);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.2f, 1.0f);
            this.k0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.k0.setRepeatCount(0);
            View viewFindViewById = findViewById(k.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
            this.k0.addUpdateListener(new m1(this, viewFindViewById));
            this.k0.addListener(new n1(viewFindViewById));
            this.k0.start();
        }
        this.j0.onCountDownTick(j);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public final boolean p() {
        return !this.l0 && this.b.s.E0 == 1;
    }

    public void q() {
        this.l0 = true;
    }

    public void r() {
        s();
        this.g0 = (ImageView) findViewById(k.a(getContext(), "myoffer_player_view_cover_img_id", "id"));
        this.h0 = (ImageView) findViewById(k.a(getContext(), "myoffer_player_view_cover_icon_id", "id"));
        this.G = (ViewGroup) findViewById(k.a(getContext(), "myoffer_feedback_ll_id", "id"));
        if (!c0.h(this.c, this.b)) {
            ImageView imageView = this.h0;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.g0;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        } else if (this.g0 != null && !TextUtils.isEmpty(this.c.f)) {
            ImageView imageView3 = this.h0;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = this.g0;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            m.a(getContext()).a(new o(1, this.c.f), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new r1(this));
        }
        if (!c0.h(this.c, this.b)) {
            q();
            return;
        }
        d dVar = new d(this, this.b, this.c, h.y(getContext()));
        this.n = dVar;
        int aTViewType = getATViewType();
        BasePlayerView basePlayerView = dVar.h;
        if (basePlayerView != null) {
            basePlayerView.setViewType(aTViewType);
        }
        e0 e0Var = this.o;
        if (e0Var != null) {
            this.n.g = e0Var;
        }
        BasePlayerView basePlayerView2 = this.n.h;
        this.l0 = basePlayerView2 == null;
        if (basePlayerView2 != null) {
            basePlayerView2.setNeedInterruptRelease(true);
        }
        d dVar2 = this.n;
        dVar2.j = new o1(this);
        dVar2.i = new p1(this);
        if (!(this instanceof WTWebViewSplashATView)) {
            BasePlayerView basePlayerView3 = dVar2.h;
            if (basePlayerView3 != null) {
                basePlayerView3.setVisibility(0);
            }
            this.n.a(true, null);
        }
        MuteImageView muteImageView = (MuteImageView) findViewById(k.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.f0 = muteImageView;
        if (muteImageView != null) {
            muteImageView.setMute(true);
            this.f0.setVisibility(0);
            this.f0.setOnClickListener(new q1(this));
            if (this.c.e() == 4) {
                try {
                    if (SDMSDK.getInstance().getDirectlyOfferSetting().getDirectlySplashMuteIconVisible() != null) {
                        this.f0.setVisibility(SDMSDK.getInstance().getDirectlyOfferSetting().getDirectlySplashMuteIconVisible().booleanValue() ? 0 : 8);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public abstract void s();

    public abstract void t();

    public final void u() {
        g gVar;
        if (this.n != null) {
            com.smartdigimkt.x.l lVar = this.R;
            if ((lVar == null || (gVar = lVar.a) == null || !gVar.isShowing()) && !this.l0) {
                if (!this.c0 || this.b.s.E0 == 1) {
                    this.n.d();
                }
            }
        }
    }

    public BaseSdkSplashATView(Context context, com.smartdigimkt.a3.a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
        this.i0 = new k1(this);
        this.l0 = false;
        t();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.j.get(i);
            if (view != null) {
                view.setOnClickListener(this.S);
            }
        }
        ViewGroup viewGroup = this.G;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new l2(this));
        }
        setOnClickListener(this.i0);
        a((j3) this.F, false);
    }
}
