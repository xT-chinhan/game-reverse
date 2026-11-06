package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.b.e;
import com.anythink.basead.d.g;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.basead.ui.f.d;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SinglePictureSplashATView extends BaseSdkSplashATView {
    public SinglePictureSplashATView(Context context) {
        super(context);
    }

    public SinglePictureSplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        View viewInflate;
        if (this.f.o.A() == 2) {
            viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_ad_layout_single_land", "layout"), this);
        } else {
            viewInflate = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_splash_ad_layout_single_port", "layout"), this);
        }
        w();
        if (this.T != null) {
            this.T.a(d.c).a(new com.anythink.basead.ui.d.a() { // from class: com.anythink.basead.ui.SinglePictureSplashATView.1
                @Override // com.anythink.basead.ui.d.a
                public final void a(int i, int i2) {
                    SinglePictureSplashATView.this.a(i, i2);
                }
            }).a(getContext(), viewInflate);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void b() {
        this.q = findViewById(q.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        if (this.g.b() == 4) {
            try {
                View directlySplashCTAButton = ATSDKGlobalSetting.getDirectlySplashCTAButton();
                if (directlySplashCTAButton != null) {
                    try {
                        int iIndexOfChild = indexOfChild(this.q);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                        this.q.setVisibility(8);
                        this.q = directlySplashCTAButton;
                        if (directlySplashCTAButton.getLayoutParams() != null && (directlySplashCTAButton.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                            layoutParams = (RelativeLayout.LayoutParams) directlySplashCTAButton.getLayoutParams();
                        }
                        am.a(directlySplashCTAButton);
                        addView(directlySplashCTAButton, iIndexOfChild, layoutParams);
                        if (t.b().F()) {
                            Log.d(this.e, "DIRECTLY Splash View replace cta success");
                        }
                    } catch (Throwable unused) {
                        Log.w(this.e, "DIRECTLY Splash View replace cta fail");
                        this.q = findViewById(q.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (this.f.o == null || this.q == null) {
            return;
        }
        if (this.q instanceof CTAButtonLayout) {
            ((CTAButtonLayout) this.q).initSetting(this.g, this.f, false, null);
        } else if (this.q instanceof TextView) {
            if (!TextUtils.isEmpty(this.g.D())) {
                ((TextView) this.q).setText(this.g.D());
            } else {
                ((TextView) this.q).setText(e.a(getContext(), this.g));
            }
        }
        if (this.f.o.H() != 0 && !n()) {
            this.n.add(this.q);
        } else {
            this.q.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void c() {
        super.c();
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.g.B()), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.SinglePictureSplashATView.2
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(str, SinglePictureSplashATView.this.g.B())) {
                    SinglePictureSplashATView singlePictureSplashATView = SinglePictureSplashATView.this;
                    final WrapRoundImageView wrapRoundImageView = (WrapRoundImageView) singlePictureSplashATView.findViewById(q.a(singlePictureSplashATView.getContext(), "myoffer_splash_ad_content_image_area", "id"));
                    SinglePictureSplashATView singlePictureSplashATView2 = SinglePictureSplashATView.this;
                    final RoundImageView roundImageView = (RoundImageView) singlePictureSplashATView2.findViewById(q.a(singlePictureSplashATView2.getContext(), "myoffer_splash_bg", "id"));
                    wrapRoundImageView.setVisibility(0);
                    if (SinglePictureSplashATView.this.f.o.t() == 2) {
                        wrapRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        wrapRoundImageView.setImageBitmap(bitmap);
                    } else {
                        wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        wrapRoundImageView.post(new Runnable() { // from class: com.anythink.basead.ui.SinglePictureSplashATView.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                wrapRoundImageView.setBitmapAndResize(bitmap, SinglePictureSplashATView.this.getWidth(), SinglePictureSplashATView.this.getHeight());
                            }
                        });
                    }
                    if (roundImageView != null) {
                        h.a(SinglePictureSplashATView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.SinglePictureSplashATView.2.2
                            @Override // com.anythink.core.common.v.h.a
                            public final void a() {
                            }

                            @Override // com.anythink.core.common.v.h.a
                            public final void a(Bitmap bitmap2) {
                                roundImageView.setVisibility(0);
                                roundImageView.setImageBitmap(bitmap2);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void d() {
        super.a(this.f.o.Z() < 0 ? 100 : this.f.o.Z(), new Runnable() { // from class: com.anythink.basead.ui.SinglePictureSplashATView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (SinglePictureSplashATView.this.O == null) {
                    return;
                }
                int width = SinglePictureSplashATView.this.getWidth();
                int height = SinglePictureSplashATView.this.getHeight();
                int i = (int) (((double) SinglePictureSplashATView.this.getResources().getDisplayMetrics().widthPixels) * 0.5d);
                int i2 = (int) (((double) SinglePictureSplashATView.this.getResources().getDisplayMetrics().heightPixels) * 0.5d);
                if (width < i) {
                    SinglePictureSplashATView.this.a(g.a(g.k, "Splash display width is less than 50% of screen width!"));
                    Log.e("anythink", "Splash display width is less than 50% of screen width!");
                } else if (height >= i2) {
                    SinglePictureSplashATView.super.j();
                } else {
                    SinglePictureSplashATView.this.a(g.a(g.k, "Splash display height is less than 50% of screen height!"));
                    Log.e("anythink", "Splash display height is less than 50% of screen height!");
                }
            }
        });
    }
}
