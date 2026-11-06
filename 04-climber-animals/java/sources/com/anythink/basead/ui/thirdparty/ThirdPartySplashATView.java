package com.anythink.basead.ui.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.ui.AsseblemSplashATView;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.l.e.a.f;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.q;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartySplashATView extends AsseblemSplashATView implements f {
    BaseAd A;
    private View B;

    @Override // com.anythink.basead.ui.BaseATView
    protected final float a(com.anythink.basead.ui.b bVar, boolean z) {
        return 1.0f;
    }

    @Override // com.anythink.basead.ui.AsseblemSplashATView, com.anythink.basead.ui.BaseSdkSplashATView
    protected final void d() {
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final boolean n() {
        return false;
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView, com.anythink.basead.ui.BaseSplashATView
    protected final void x() {
    }

    public ThirdPartySplashATView(Context context) {
        super(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThirdPartySplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar, String str, BaseAd baseAd, com.anythink.core.common.l.a aVar2) {
        BaseAd baseAd2;
        BaseAd baseAd3;
        BaseAd baseAd4;
        super(context, xVar, wVar, aVar);
        this.A = baseAd;
        FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_splash_ad_lable_area", "id"));
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.n.add(frameLayout);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(q.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        if (frameLayout2 != null && (baseAd4 = this.A) != null && baseAd4.getAdMediaView(new Object[0]) != null) {
            View adMediaView = this.A.getAdMediaView(new Object[0]);
            this.B = adMediaView;
            if (adMediaView.getParent() != null) {
                ((ViewGroup) this.B.getParent()).removeView(this.B);
            }
            frameLayout2.addView(this.B, new FrameLayout.LayoutParams(-1, -1));
        }
        RoundImageView roundImageView = (RoundImageView) findViewById(q.a(getContext(), "myoffer_splash_icon", "id"));
        if (roundImageView != null && (baseAd3 = this.A) != null && baseAd3.getAdIconView() != null && roundImageView.getParent() != null && (roundImageView.getParent() instanceof ViewGroup)) {
            TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_splash_ad_title", "id"));
            if (textView != null) {
                textView.setGravity(3);
            }
            TextView textView2 = (TextView) findViewById(q.a(getContext(), "myoffer_splash_desc", "id"));
            if (textView2 != null) {
                textView2.setGravity(3);
            }
            roundImageView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
            layoutParams.width = layoutParams.height;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                if (this.f.o.A() == 2) {
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = q.a(getContext(), 18.0f);
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = q.a(getContext(), 12.0f);
                }
            }
            roundImageView.setLayoutParams(layoutParams);
            ((ViewGroup) roundImageView.getParent()).addView(this.A.getAdIconView(), roundImageView.getLayoutParams());
        }
        if (this.C != null && (baseAd2 = this.A) != null && baseAd2.getAdLogoView() != null && this.C.getParent() != null && (this.C.getParent() instanceof ViewGroup)) {
            this.C.setVisibility(4);
            ((ViewGroup) this.C.getParent()).addView(this.A.getAdLogoView(), this.C.getLayoutParams());
        }
        if (aVar2 instanceof View) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            addView((View) aVar2, layoutParams2);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void w() {
        super.w();
        if (this.K != null) {
            this.K.setVisibility(8);
        }
    }

    private void D() {
        BaseAd baseAd;
        BaseAd baseAd2;
        BaseAd baseAd3;
        FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_splash_ad_lable_area", "id"));
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.n.add(frameLayout);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(q.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        if (frameLayout2 != null && (baseAd3 = this.A) != null && baseAd3.getAdMediaView(new Object[0]) != null) {
            View adMediaView = this.A.getAdMediaView(new Object[0]);
            this.B = adMediaView;
            if (adMediaView.getParent() != null) {
                ((ViewGroup) this.B.getParent()).removeView(this.B);
            }
            frameLayout2.addView(this.B, new FrameLayout.LayoutParams(-1, -1));
        }
        RoundImageView roundImageView = (RoundImageView) findViewById(q.a(getContext(), "myoffer_splash_icon", "id"));
        if (roundImageView != null && (baseAd2 = this.A) != null && baseAd2.getAdIconView() != null && roundImageView.getParent() != null && (roundImageView.getParent() instanceof ViewGroup)) {
            TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_splash_ad_title", "id"));
            if (textView != null) {
                textView.setGravity(3);
            }
            TextView textView2 = (TextView) findViewById(q.a(getContext(), "myoffer_splash_desc", "id"));
            if (textView2 != null) {
                textView2.setGravity(3);
            }
            roundImageView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
            layoutParams.width = layoutParams.height;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                if (this.f.o.A() == 2) {
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = q.a(getContext(), 18.0f);
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = q.a(getContext(), 12.0f);
                }
            }
            roundImageView.setLayoutParams(layoutParams);
            ((ViewGroup) roundImageView.getParent()).addView(this.A.getAdIconView(), roundImageView.getLayoutParams());
        }
        if (this.C == null || (baseAd = this.A) == null || baseAd.getAdLogoView() == null || this.C.getParent() == null || !(this.C.getParent() instanceof ViewGroup)) {
            return;
        }
        this.C.setVisibility(4);
        ((ViewGroup) this.C.getParent()).addView(this.A.getAdLogoView(), this.C.getLayoutParams());
    }

    private void b(View view) {
        boolean z = false;
        FrameLayout.LayoutParams layoutParamsA = com.anythink.basead.mixad.f.a.a(this.f.f, 0, 0);
        if (this.A != null) {
            com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
            if (this.V != null) {
                this.V.a(this.A, bVar, true);
            }
            bVar.a(this.a);
            if (this.q instanceof CTAButtonLayout) {
                bVar.e(((CTAButtonLayout) this.q).getMajorCTAButtonView());
            } else {
                bVar.e(this.q);
            }
            bVar.d(this.b);
            bVar.b(getIconView());
            if (this.f.o.H() == 0) {
                this.n.add(this);
                this.A.registerListener(view, this.n, layoutParamsA, bVar);
                return;
            }
            if (this.f.o.H() == 2) {
                c(this.B);
                ArrayList arrayList = new ArrayList();
                if (this.d != null) {
                    arrayList.add(this.d);
                }
                this.A.registerListener(view, arrayList, layoutParamsA, bVar);
                return;
            }
            if (this.f != null && this.f.f == 59) {
                z = true;
            }
            if (z) {
                c.c(this.A.getAdIconView());
            }
            c(this.B);
            ArrayList arrayList2 = new ArrayList();
            if (this.q instanceof CTAButtonLayout) {
                arrayList2.add(((CTAButtonLayout) this.q).getMajorCTAButtonView());
            } else {
                arrayList2.add(this.q);
            }
            this.A.registerListener(view, arrayList2, layoutParamsA, bVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView, com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t.b().a(new Runnable() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartySplashATView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ThirdPartySplashATView.this.A != null) {
                    ThirdPartySplashATView.this.A.destroy();
                    ThirdPartySplashATView.this.A = null;
                }
            }
        }, 1000L);
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    protected final void a(boolean z, int i) {
        B();
        if (z && !this.N) {
            this.N = true;
            this.U = i;
            a(115);
            if (this.O != null) {
                this.O.onAdClosed();
            }
        }
    }

    public View getIconView() {
        BaseAd baseAd = this.A;
        if (baseAd == null) {
            return null;
        }
        if (!TextUtils.isEmpty(baseAd.getIconImageUrl())) {
            return this.c;
        }
        View adIconView = this.A.getAdIconView();
        if (adIconView != null) {
            return adIconView;
        }
        return null;
    }

    private boolean E() {
        return this.f != null && this.f.f == 39;
    }

    private boolean F() {
        return this.f != null && this.f.f == 59;
    }

    private boolean G() {
        return this.f != null && this.f.f == 2;
    }

    private boolean H() {
        return (this.f == null || this.f.o == null || this.f.o.H() == 0) ? false : true;
    }

    private boolean I() {
        BaseAd baseAd = this.A;
        return (baseAd == null || !TextUtils.equals(baseAd.getAdType(), "1") || this.B == null) ? false : true;
    }

    private boolean J() {
        int i = this.f != null ? this.f.f : 0;
        return i == 2 || i == 39 || i == 47 || i == 50 || i == 59;
    }

    private void c(View view) {
        if (view != null && H()) {
            if (J()) {
                c.c(view);
            }
            if (!E() || I()) {
                return;
            }
            c.b(view);
        }
    }

    @Override // com.anythink.core.common.l.e.a.f
    public void handleFullScreenClick(View view) {
        if (view != null && E() && H()) {
            c.c(view);
        }
    }

    public void disableHWVideoViewClickable() {
        if (H() && E()) {
            c.a(this.B);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.anythink.core.common.l.a aVar) {
        if (aVar instanceof View) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView((View) aVar, layoutParams);
        }
    }

    @Override // com.anythink.core.common.l.e.a.f
    public void registerNativeAdContainer(View view) {
        boolean z = false;
        FrameLayout.LayoutParams layoutParamsA = com.anythink.basead.mixad.f.a.a(this.f.f, 0, 0);
        if (this.A != null) {
            com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
            if (this.V != null) {
                this.V.a(this.A, bVar, true);
            }
            bVar.a(this.a);
            if (this.q instanceof CTAButtonLayout) {
                bVar.e(((CTAButtonLayout) this.q).getMajorCTAButtonView());
            } else {
                bVar.e(this.q);
            }
            bVar.d(this.b);
            bVar.b(getIconView());
            if (this.f.o.H() == 0) {
                this.n.add(this);
                this.A.registerListener(view, this.n, layoutParamsA, bVar);
                return;
            }
            if (this.f.o.H() == 2) {
                c(this.B);
                ArrayList arrayList = new ArrayList();
                if (this.d != null) {
                    arrayList.add(this.d);
                }
                this.A.registerListener(view, arrayList, layoutParamsA, bVar);
                return;
            }
            if (this.f != null && this.f.f == 59) {
                z = true;
            }
            if (z) {
                c.c(this.A.getAdIconView());
            }
            c(this.B);
            ArrayList arrayList2 = new ArrayList();
            if (this.q instanceof CTAButtonLayout) {
                arrayList2.add(((CTAButtonLayout) this.q).getMajorCTAButtonView());
            } else {
                arrayList2.add(this.q);
            }
            this.A.registerListener(view, arrayList2, layoutParamsA, bVar);
        }
    }
}
