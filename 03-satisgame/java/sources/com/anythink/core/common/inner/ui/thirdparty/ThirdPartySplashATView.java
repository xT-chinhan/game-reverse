package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.ui.AsseblemSplashATView;
import com.anythink.core.common.inner.ui.CloseShadeView;
import com.anythink.core.common.k.e.a.f;
import com.anythink.core.common.u.p;
import com.anythink.core.common.ui.component.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartySplashATView extends AsseblemSplashATView implements f {
    BaseAd E;
    private View F;

    public ThirdPartySplashATView(Context context) {
        super(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThirdPartySplashATView(Context context, x xVar, w wVar, com.anythink.core.common.inner.e.a aVar, String str, BaseAd baseAd, com.anythink.core.common.k.a aVar2) {
        BaseAd baseAd2;
        BaseAd baseAd3;
        BaseAd baseAd4;
        super(context, xVar, wVar, aVar);
        this.E = baseAd;
        FrameLayout frameLayout = (FrameLayout) findViewById(p.a(getContext(), "myoffer_splash_ad_lable_area", "id"));
        boolean z = false;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.j.add(frameLayout);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(p.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        if (frameLayout2 != null && (baseAd4 = this.E) != null && baseAd4.getAdMediaView(new Object[0]) != null) {
            View adMediaView = this.E.getAdMediaView(new Object[0]);
            this.F = adMediaView;
            if (adMediaView.getParent() != null) {
                ((ViewGroup) this.F.getParent()).removeView(this.F);
            }
            frameLayout2.addView(this.F, new FrameLayout.LayoutParams(-1, -1));
        }
        RoundImageView roundImageView = (RoundImageView) findViewById(p.a(getContext(), "myoffer_splash_icon", "id"));
        if (roundImageView != null && (baseAd3 = this.E) != null && baseAd3.getAdIconView() != null && roundImageView.getParent() != null && (roundImageView.getParent() instanceof ViewGroup)) {
            TextView textView = (TextView) findViewById(p.a(getContext(), "myoffer_splash_ad_title", "id"));
            if (textView != null) {
                textView.setGravity(3);
            }
            TextView textView2 = (TextView) findViewById(p.a(getContext(), "myoffer_splash_desc", "id"));
            if (textView2 != null) {
                textView2.setGravity(3);
            }
            roundImageView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
            layoutParams.width = layoutParams.height;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                if (this.f.t.l() == 2) {
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = p.a(getContext(), 18.0f);
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = p.a(getContext(), 12.0f);
                }
            }
            roundImageView.setLayoutParams(layoutParams);
            ((ViewGroup) roundImageView.getParent()).addView(this.E.getAdIconView(), roundImageView.getLayoutParams());
        }
        if (this.l != null && (baseAd2 = this.E) != null && baseAd2.getAdLogoView() != null && this.l.getParent() != null && (this.l.getParent() instanceof ViewGroup)) {
            this.l.setVisibility(4);
            ((ViewGroup) this.l.getParent()).addView(this.E.getAdLogoView(), this.l.getLayoutParams());
        }
        if (aVar2 instanceof View) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            addView((View) aVar2, layoutParams2);
        }
        BaseAd baseAd5 = this.E;
        if (baseAd5 != null && baseAd5.isNativeExpress()) {
            z = true;
        }
        if (z) {
            this.z = -1;
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseSdkSplashATView
    protected final void f() {
        super.f();
    }

    private void i() {
        BaseAd baseAd;
        BaseAd baseAd2;
        BaseAd baseAd3;
        FrameLayout frameLayout = (FrameLayout) findViewById(p.a(getContext(), "myoffer_splash_ad_lable_area", "id"));
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.j.add(frameLayout);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(p.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        if (frameLayout2 != null && (baseAd3 = this.E) != null && baseAd3.getAdMediaView(new Object[0]) != null) {
            View adMediaView = this.E.getAdMediaView(new Object[0]);
            this.F = adMediaView;
            if (adMediaView.getParent() != null) {
                ((ViewGroup) this.F.getParent()).removeView(this.F);
            }
            frameLayout2.addView(this.F, new FrameLayout.LayoutParams(-1, -1));
        }
        RoundImageView roundImageView = (RoundImageView) findViewById(p.a(getContext(), "myoffer_splash_icon", "id"));
        if (roundImageView != null && (baseAd2 = this.E) != null && baseAd2.getAdIconView() != null && roundImageView.getParent() != null && (roundImageView.getParent() instanceof ViewGroup)) {
            TextView textView = (TextView) findViewById(p.a(getContext(), "myoffer_splash_ad_title", "id"));
            if (textView != null) {
                textView.setGravity(3);
            }
            TextView textView2 = (TextView) findViewById(p.a(getContext(), "myoffer_splash_desc", "id"));
            if (textView2 != null) {
                textView2.setGravity(3);
            }
            roundImageView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
            layoutParams.width = layoutParams.height;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                if (this.f.t.l() == 2) {
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = p.a(getContext(), 18.0f);
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).rightMargin = p.a(getContext(), 12.0f);
                }
            }
            roundImageView.setLayoutParams(layoutParams);
            ((ViewGroup) roundImageView.getParent()).addView(this.E.getAdIconView(), roundImageView.getLayoutParams());
        }
        if (this.l == null || (baseAd = this.E) == null || baseAd.getAdLogoView() == null || this.l.getParent() == null || !(this.l.getParent() instanceof ViewGroup)) {
            return;
        }
        this.l.setVisibility(4);
        ((ViewGroup) this.l.getParent()).addView(this.E.getAdLogoView(), this.l.getLayoutParams());
    }

    private void a(View view) {
        List<View> arrayList;
        boolean z = false;
        FrameLayout.LayoutParams layoutParamsA = com.anythink.core.common.inner.mixad.f.a.a(this.f.j, 0, 0);
        if (this.E != null) {
            com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
            if (this.y != null) {
                this.y.a(this.E, bVar, true);
            }
            bVar.a(this.a);
            bVar.e(this.k);
            bVar.d(this.b);
            bVar.b(getIconView());
            if (this.f.t.q() == 0) {
                this.j.add(this);
                arrayList = this.j;
            } else if (this.f.t.q() == 2) {
                arrayList = new ArrayList<>();
                if (this.d != null) {
                    arrayList.add(this.d);
                }
            } else {
                if (this.f != null && this.f.j == 59) {
                    z = true;
                }
                if (z) {
                    c.a(this.E.getAdIconView());
                }
                arrayList = new ArrayList<>();
                arrayList.add(this.k);
            }
            if (arrayList != null) {
                if (this.z >= this.ranDom) {
                    arrayList.add(this.s);
                } else if (this.s != null) {
                    this.s.setVisibility(8);
                }
            }
            this.E.registerListener(view, arrayList, layoutParamsA, bVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s.b();
        s.a(new Runnable() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartySplashATView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ThirdPartySplashATView.this.E != null) {
                    ThirdPartySplashATView.this.E.destroy();
                    ThirdPartySplashATView.this.E = null;
                }
            }
        }, 1000L);
    }

    @Override // com.anythink.core.common.inner.ui.BaseSplashATView
    protected final void g() {
        h();
        if (this.v) {
            return;
        }
        this.v = true;
        if (this.w != null) {
            this.w.b();
        }
    }

    public View getIconView() {
        BaseAd baseAd = this.E;
        if (baseAd == null) {
            return null;
        }
        if (!TextUtils.isEmpty(baseAd.getIconImageUrl())) {
            return this.c;
        }
        View adIconView = this.E.getAdIconView();
        if (adIconView != null) {
            return adIconView;
        }
        return null;
    }

    private boolean j() {
        return this.f != null && this.f.j == 59;
    }

    private boolean k() {
        return this.f != null && this.f.j == 39;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.anythink.core.common.k.a aVar) {
        if (aVar instanceof View) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView((View) aVar, layoutParams);
        }
    }

    public CloseShadeView getCloseShadeView() {
        if (this.s != null) {
            return this.s;
        }
        return null;
    }

    private boolean l() {
        return (this.f == null || this.f.t == null || this.f.t.q() == 0) ? false : true;
    }

    private boolean m() {
        BaseAd baseAd = this.E;
        return baseAd != null && baseAd.isNativeExpress();
    }

    @Override // com.anythink.core.common.k.e.a.f
    public void registerNativeAdContainer(View view) {
        List<View> arrayList;
        boolean z = false;
        FrameLayout.LayoutParams layoutParamsA = com.anythink.core.common.inner.mixad.f.a.a(this.f.j, 0, 0);
        if (this.E != null) {
            com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
            if (this.y != null) {
                this.y.a(this.E, bVar, true);
            }
            bVar.a(this.a);
            bVar.e(this.k);
            bVar.d(this.b);
            bVar.b(getIconView());
            if (this.f.t.q() == 0) {
                this.j.add(this);
                arrayList = this.j;
            } else if (this.f.t.q() == 2) {
                arrayList = new ArrayList<>();
                if (this.d != null) {
                    arrayList.add(this.d);
                }
            } else {
                if (this.f != null && this.f.j == 59) {
                    z = true;
                }
                if (z) {
                    c.a(this.E.getAdIconView());
                }
                arrayList = new ArrayList<>();
                arrayList.add(this.k);
            }
            if (arrayList != null) {
                if (this.z >= this.ranDom) {
                    arrayList.add(this.s);
                } else if (this.s != null) {
                    this.s.setVisibility(8);
                }
            }
            this.E.registerListener(view, arrayList, layoutParamsA, bVar);
        }
    }

    @Override // com.anythink.core.common.k.e.a.f
    public void handleFullScreenClick(View view) {
        if (view == null) {
            return;
        }
        if (this.f != null && this.f.j == 39) {
            if ((this.f == null || this.f.t == null || this.f.t.q() == 0) ? false : true) {
                c.a(view);
            }
        }
    }
}
