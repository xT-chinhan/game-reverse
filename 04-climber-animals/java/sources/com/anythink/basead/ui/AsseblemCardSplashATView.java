package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.ui.f.d;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class AsseblemCardSplashATView extends BaseNewStyleSDKSplashATView {
    protected TextView a;
    private SplashShakeTextHintView ad;
    private ImageView ae;
    protected TextView b;
    protected TextView c;
    protected RoundImageView d;

    public AsseblemCardSplashATView(Context context) {
        super(context);
    }

    public AsseblemCardSplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        View viewInflate;
        if (this.A > this.B) {
            viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_ad_layout_asseblem_card_horizontal", "layout"), this);
        } else {
            viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_ad_layout_asseblem_card_vertical", "layout"), this);
        }
        w();
        if (this.T != null) {
            this.T.a(d.c).a(new com.anythink.basead.ui.d.a() { // from class: com.anythink.basead.ui.AsseblemCardSplashATView.1
                @Override // com.anythink.basead.ui.d.a
                public final void a(int i, int i2) {
                    AsseblemCardSplashATView.this.a(i, i2);
                }
            }).a(getContext(), viewInflate);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void b() {
        this.a = (TextView) findViewById(q.a(getContext(), "myoffer_splash_ad_title", "id"));
        this.b = (TextView) findViewById(q.a(getContext(), "myoffer_splash_desc", "id"));
        this.c = (TextView) findViewById(q.a(getContext(), "myoffer_splash_cta_text", "id"));
        this.d = (RoundImageView) findViewById(q.a(getContext(), "myoffer_splash_icon", "id"));
        this.q = findViewById(q.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        this.ad = (SplashShakeTextHintView) findViewById(q.a(getContext(), "myoffer_splash_cta_shake", "id"));
        this.ae = (ImageView) findViewById(q.a(getContext(), "myoffer_splash_ambience_bg", "id"));
        if (!TextUtils.isEmpty(this.g.z())) {
            this.d.setVisibility(0);
            this.d.setNeedRadiu(true);
            this.d.setRadiusInDip(12);
            int i = this.d.getLayoutParams().width;
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.z()), i, i, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.AsseblemCardSplashATView.2
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(str, AsseblemCardSplashATView.this.g.z())) {
                        AsseblemCardSplashATView.this.d.setImageBitmap(bitmap);
                    }
                }
            });
        } else {
            am.a(this.d, 0, 0);
        }
        if (!TextUtils.isEmpty(this.g.x())) {
            this.a.setText(this.g.x());
            this.a.setVisibility(0);
        } else {
            am.a(this.a, 0, 0);
        }
        if (this.b != null) {
            if (!TextUtils.isEmpty(this.g.y())) {
                this.b.setText(this.g.y());
            } else {
                this.b.setVisibility(8);
            }
        }
        if (this.q != null) {
            this.n.add(this.q);
        }
        if (n()) {
            TextView textView = this.c;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (this.ad != null) {
                if (this.A > this.B) {
                    this.ad.setTextSize(17);
                }
                this.ad.setVisibility(0);
                this.ad.setShakeSetting(this.f.o, this.g.K());
                this.ad.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.AsseblemCardSplashATView.3
                    @Override // com.anythink.basead.ui.BaseShakeView.a
                    public final boolean a() {
                        if (!AsseblemCardSplashATView.this.C()) {
                            return false;
                        }
                        AsseblemCardSplashATView.this.a(4, 5);
                        return true;
                    }
                }, this.f.o);
            }
        } else {
            if (this.c != null && this.A > this.B) {
                if (!TextUtils.isEmpty(this.g.D())) {
                    this.c.setText(this.g.D());
                } else {
                    this.c.setText(com.anythink.basead.b.e.a(getContext(), this.g));
                }
            }
            SplashShakeTextHintView splashShakeTextHintView = this.ad;
            if (splashShakeTextHintView != null) {
                splashShakeTextHintView.setVisibility(8);
            }
        }
        if (this.ae != null) {
            String strA = g.a().a(com.anythink.core.common.a.b.d.j);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.AsseblemCardSplashATView.4
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (AsseblemCardSplashATView.this.ae != null) {
                        AsseblemCardSplashATView.this.ae.setImageBitmap(bitmap);
                    }
                }
            });
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
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.B()), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.AsseblemCardSplashATView.5
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(str, AsseblemCardSplashATView.this.g.B())) {
                    frameLayout.post(new Runnable() { // from class: com.anythink.basead.ui.AsseblemCardSplashATView.5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            wrapRoundImageView.setBitmapAndResize(bitmap, frameLayout.getWidth(), frameLayout.getHeight());
                            wrapRoundImageView.setVisibility(0);
                        }
                    });
                    h.a(AsseblemCardSplashATView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.AsseblemCardSplashATView.5.2
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
    protected final void d() {
        super.a(this.f.o.Z() < 0 ? 100 : this.f.o.Z(), new Runnable() { // from class: com.anythink.basead.ui.AsseblemCardSplashATView.6
            @Override // java.lang.Runnable
            public final void run() {
                if (AsseblemCardSplashATView.this.O == null) {
                    return;
                }
                AsseblemCardSplashATView.this.j();
            }
        });
    }
}
