package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.api.loader.KsDexEncryptHelper;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i2.l;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.t;
import com.smartdigimkt.n1.u;
import com.smartdigimkt.n1.v;
import com.smartdigimkt.n1.y;
import com.smartdigimkt.n1.z;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public class AsseblemSplashATView extends BaseSdkSplashATView {
    public TextView m0;
    public TextView n0;
    public RoundImageView o0;
    public View p0;

    public AsseblemSplashATView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public void beforeSplashEndCardShow() {
        super.beforeSplashEndCardShow();
        TextView textView = (TextView) findViewById(k.a(getContext(), "myoffer_splash_ad_title", "id"));
        View viewFindViewById = findViewById(k.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        TextView textView2 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_desc", "id"));
        RoundImageView roundImageView = (RoundImageView) findViewById(k.a(getContext(), "myoffer_splash_icon", "id"));
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

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void f() {
        View viewInflate = this.b.s.m == 2 ? LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_land", "layout"), this) : LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_port", "layout"), this);
        r();
        r rVar = this.T;
        if (rVar != null) {
            rVar.c = KsDexEncryptHelper.DECRYPT_ERROR_IO;
            rVar.l = new t(this);
            rVar.a(getContext(), viewInflate);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public View getAutoClickPanelView() {
        View view = this.p0;
        return view != null ? view : super.getAutoClickPanelView();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void q() {
        this.l0 = true;
        FrameLayout frameLayout = (FrameLayout) findViewById(k.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        RoundImageView roundImageView = (RoundImageView) findViewById(k.a(getContext(), "myoffer_splash_bg", "id"));
        frameLayout.removeAllViews();
        WrapRoundImageView wrapRoundImageView = new WrapRoundImageView(getContext());
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
        if (TextUtils.isEmpty(this.c.f)) {
            roundImageView.setBackgroundColor(Color.parseColor("#EFEFEF"));
            return;
        }
        m.a(getContext()).a(new o(1, this.c.f), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new y(this, frameLayout, wrapRoundImageView, roundImageView));
        if (this.b.s.e != 1) {
            this.j.add(wrapRoundImageView);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public void s() {
        this.p0 = findViewById(k.a(getContext(), "myoffer_splash_ad_bottom_container", "id"));
        this.m0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_ad_title", "id"));
        this.n0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_desc", "id"));
        this.o0 = (RoundImageView) findViewById(k.a(getContext(), "myoffer_splash_icon", "id"));
        this.m = findViewById(k.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        if (TextUtils.isEmpty(this.c.e)) {
            l.a(this.o0, false);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.rightMargin = 0;
                this.o0.setLayoutParams(layoutParams);
            }
            if (this.b.s.m != 2) {
                TextView textView = this.m0;
                if (textView != null) {
                    textView.setGravity(17);
                }
                TextView textView2 = this.n0;
                if (textView2 != null) {
                    textView2.setGravity(17);
                }
            }
        } else {
            this.o0.setVisibility(0);
            this.o0.setNeedRadiu(true);
            this.o0.setRadiusInDip(12);
            int i = this.o0.getLayoutParams().width;
            m.a(getContext()).a(new o(1, this.c.e), i, i, new u(this));
        }
        if (this.b.s.e != 1) {
            this.j.add(this.o0);
        }
        if (TextUtils.isEmpty(this.c.c)) {
            this.m0.setVisibility(4);
        } else {
            this.m0.setText(this.c.c);
            this.m0.setVisibility(0);
        }
        if (this.b.s.e != 1) {
            this.j.add(this.m0);
        }
        View view = this.m;
        if (view != null) {
            if (view instanceof CTAButtonLayout) {
                ((CTAButtonLayout) view).initSetting(this.c, this.b, false, new v(this));
                ((CTAButtonLayout) this.m).changeMinorButtonStyle();
            }
            this.j.add(this.m);
        }
        if (this.n0 != null) {
            if (TextUtils.isEmpty(this.c.d)) {
                this.n0.setVisibility(8);
            } else {
                this.n0.setText(this.c.d);
            }
            if (this.b.s.e != 1) {
                this.j.add(this.n0);
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void t() {
        int i = this.b.s.R;
        this.A = new z(this);
        c();
    }

    public AsseblemSplashATView(Context context, a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }
}
