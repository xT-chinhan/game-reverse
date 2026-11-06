package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.basead.ui.f.d;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class AsseblemSplashATView extends BaseSdkSplashATView {
    protected TextView a;
    protected TextView b;
    protected RoundImageView c;
    protected View d;

    public AsseblemSplashATView(Context context) {
        super(context);
    }

    public AsseblemSplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        View viewInflate;
        if (this.f.o.A() == 2) {
            viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_land", "layout"), this);
        } else {
            viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_port", "layout"), this);
        }
        w();
        if (this.T != null) {
            this.T.a(d.c).a(new com.anythink.basead.ui.d.a() { // from class: com.anythink.basead.ui.AsseblemSplashATView.1
                @Override // com.anythink.basead.ui.d.a
                public final void a(int i, int i2) {
                    AsseblemSplashATView.this.a(i, i2);
                }
            }).a(getContext(), viewInflate);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void b() {
        this.d = findViewById(q.a(getContext(), "myoffer_splash_ad_bottom_container", "id"));
        this.a = (TextView) findViewById(q.a(getContext(), "myoffer_splash_ad_title", "id"));
        this.b = (TextView) findViewById(q.a(getContext(), "myoffer_splash_desc", "id"));
        this.c = (RoundImageView) findViewById(q.a(getContext(), "myoffer_splash_icon", "id"));
        this.q = findViewById(q.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        if (!TextUtils.isEmpty(this.g.z())) {
            this.c.setVisibility(0);
            this.c.setNeedRadiu(true);
            this.c.setRadiusInDip(12);
            int i = this.c.getLayoutParams().width;
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.z()), i, i, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.AsseblemSplashATView.2
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(str, AsseblemSplashATView.this.g.z())) {
                        AsseblemSplashATView.this.c.setImageBitmap(bitmap);
                    }
                }
            });
        } else {
            com.anythink.basead.ui.f.b.a((View) this.c, false);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.rightMargin = 0;
                this.c.setLayoutParams(layoutParams);
            }
            if (this.f.o.A() != 2) {
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
        if (this.f.o.H() != 1) {
            this.n.add(this.c);
        }
        if (!TextUtils.isEmpty(this.g.x())) {
            this.a.setText(this.g.x());
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(4);
        }
        if (this.f.o.H() != 1) {
            this.n.add(this.a);
        }
        if (this.q != null) {
            if (this.q instanceof CTAButtonLayout) {
                ((CTAButtonLayout) this.q).initSetting(this.g, this.f, false, new com.anythink.basead.ui.f.b.a() { // from class: com.anythink.basead.ui.AsseblemSplashATView.3
                    @Override // com.anythink.basead.ui.f.b.a
                    public final void a(int i2, int i3) {
                        AsseblemSplashATView.this.a(i2, i3);
                    }
                });
                ((CTAButtonLayout) this.q).changeMinorButtonStyle();
            }
            this.n.add(this.q);
        }
        if (this.b != null) {
            if (!TextUtils.isEmpty(this.g.y())) {
                this.b.setText(this.g.y());
            } else {
                this.b.setVisibility(8);
            }
            if (this.f.o.H() != 1) {
                this.n.add(this.b);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void c() {
        super.c();
        final FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        final RoundImageView roundImageView = (RoundImageView) findViewById(q.a(getContext(), "myoffer_splash_bg", "id"));
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
        if (TextUtils.isEmpty(this.g.B())) {
            roundImageView.setBackgroundColor(Color.parseColor("#EFEFEF"));
            return;
        }
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.B()), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.AsseblemSplashATView.4
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(str, AsseblemSplashATView.this.g.B())) {
                    frameLayout.post(new Runnable() { // from class: com.anythink.basead.ui.AsseblemSplashATView.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            wrapRoundImageView.setBitmapAndResize(bitmap, frameLayout.getWidth(), frameLayout.getHeight());
                            wrapRoundImageView.setVisibility(0);
                        }
                    });
                    h.a(AsseblemSplashATView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.AsseblemSplashATView.4.2
                        @Override // com.anythink.core.common.v.h.a
                        public final void a() {
                        }

                        @Override // com.anythink.core.common.v.h.a
                        public final void a(Bitmap bitmap2) {
                            roundImageView.setImageBitmap(bitmap2);
                        }
                    });
                }
            }
        });
        if (this.f.o.H() != 1) {
            this.n.add(wrapRoundImageView);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected void d() {
        super.a(this.f.o.Z() < 0 ? 100 : this.f.o.Z(), new Runnable() { // from class: com.anythink.basead.ui.AsseblemSplashATView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (AsseblemSplashATView.this.O == null) {
                    return;
                }
                AsseblemSplashATView.this.j();
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView, com.anythink.basead.ui.BaseSplashATView
    public void beforeSplashEndCardShow() {
        super.beforeSplashEndCardShow();
        TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_splash_ad_title", "id"));
        View viewFindViewById = findViewById(q.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        TextView textView2 = (TextView) findViewById(q.a(getContext(), "myoffer_splash_desc", "id"));
        RoundImageView roundImageView = (RoundImageView) findViewById(q.a(getContext(), "myoffer_splash_icon", "id"));
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (roundImageView != null) {
            roundImageView.setVisibility(8);
        }
    }
}
