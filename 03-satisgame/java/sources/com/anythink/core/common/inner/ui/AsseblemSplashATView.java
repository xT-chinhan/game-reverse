package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.ui.e.c;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.u.g;
import com.anythink.core.common.u.p;
import com.anythink.core.common.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes.dex */
public class AsseblemSplashATView extends BaseSdkSplashATView {
    protected TextView a;
    protected TextView b;
    protected RoundImageView c;
    protected View d;

    public AsseblemSplashATView(Context context) {
        super(context);
    }

    public AsseblemSplashATView(Context context, x xVar, w wVar, com.anythink.core.common.inner.e.a aVar) {
        super(context, xVar, wVar, aVar);
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a() {
        if (this.f.t.l() == 2) {
            LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_land", "layout"), this);
        } else {
            LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_port", "layout"), this);
        }
        f();
    }

    @Override // com.anythink.core.common.inner.ui.BaseSdkSplashATView
    protected final void b() {
        this.d = findViewById(p.a(getContext(), "myoffer_splash_ad_bottom_container", "id"));
        this.a = (TextView) findViewById(p.a(getContext(), "myoffer_splash_ad_title", "id"));
        this.b = (TextView) findViewById(p.a(getContext(), "myoffer_splash_desc", "id"));
        this.c = (RoundImageView) findViewById(p.a(getContext(), "myoffer_splash_icon", "id"));
        this.k = (ScanningAnimButton) findViewById(p.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        if (!TextUtils.isEmpty(this.g.l())) {
            this.c.setVisibility(0);
            this.c.setNeedRadiu(true);
            this.c.setRadiusInDip(12);
            int i = this.c.getLayoutParams().width;
            b.a(getContext()).a(new e(1, this.g.l()), i, i, new b.a() { // from class: com.anythink.core.common.inner.ui.AsseblemSplashATView.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(str, AsseblemSplashATView.this.g.l())) {
                        AsseblemSplashATView.this.c.setImageBitmap(bitmap);
                    }
                }
            });
        } else {
            RoundImageView roundImageView = this.c;
            ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
            layoutParams.width = 0;
            roundImageView.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = 0;
                this.c.setLayoutParams(layoutParams2);
            }
            if (this.f.t.l() != 2) {
                TextView textView = this.a;
                if (textView != null) {
                    textView.setGravity(17);
                }
                TextView textView2 = this.b;
                if (textView2 != null) {
                    textView2.setGravity(17);
                }
            }
        }
        if (this.f.t.q() != 1) {
            this.j.add(this.c);
        }
        if (!TextUtils.isEmpty(this.g.j())) {
            this.a.setText(this.g.j());
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(4);
        }
        if (this.f.t.q() != 1) {
            this.j.add(this.a);
        }
        if (this.k != null) {
            if (!TextUtils.isEmpty(this.g.o())) {
                this.k.setText(this.g.o());
            } else {
                this.k.setText(c.a(getContext(), this.g));
            }
            this.k.startAnimation(this.f.t.D());
            this.j.add(this.k);
        }
        if (this.b != null) {
            if (!TextUtils.isEmpty(this.g.k())) {
                this.b.setText(this.g.k());
            } else {
                this.b.setVisibility(8);
            }
            if (this.f.t.q() != 1) {
                this.j.add(this.b);
            }
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseSdkSplashATView
    protected final void c() {
        super.c();
        final FrameLayout frameLayout = (FrameLayout) findViewById(p.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        final RoundImageView roundImageView = (RoundImageView) findViewById(p.a(getContext(), "myoffer_splash_bg", "id"));
        frameLayout.removeAllViews();
        final WrapRoundImageView wrapRoundImageView = new WrapRoundImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        wrapRoundImageView.setLayoutParams(layoutParams);
        wrapRoundImageView.setNeedRadiu(false);
        wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        wrapRoundImageView.setVisibility(4);
        frameLayout.addView(wrapRoundImageView, layoutParams);
        frameLayout.setVisibility(0);
        roundImageView.setNeedRadiu(false);
        roundImageView.setVisibility(0);
        if (TextUtils.isEmpty(this.g.m())) {
            roundImageView.setBackgroundColor(Color.parseColor("#EFEFEF"));
            return;
        }
        b.a(getContext()).a(new e(1, this.g.m()), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new b.a() { // from class: com.anythink.core.common.inner.ui.AsseblemSplashATView.2
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(str, AsseblemSplashATView.this.g.m())) {
                    frameLayout.post(new Runnable() { // from class: com.anythink.core.common.inner.ui.AsseblemSplashATView.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            wrapRoundImageView.setBitmapAndResize(bitmap, frameLayout.getWidth(), frameLayout.getHeight());
                            wrapRoundImageView.setVisibility(0);
                        }
                    });
                    g.a(AsseblemSplashATView.this.getContext(), bitmap, new g.a() { // from class: com.anythink.core.common.inner.ui.AsseblemSplashATView.2.2
                        @Override // com.anythink.core.common.u.g.a
                        public final void a() {
                        }

                        @Override // com.anythink.core.common.u.g.a
                        public final void a(Bitmap bitmap2) {
                            roundImageView.setImageBitmap(bitmap2);
                        }
                    });
                }
            }
        });
        if (this.f.t.q() != 1) {
            this.j.add(wrapRoundImageView);
        }
    }
}
