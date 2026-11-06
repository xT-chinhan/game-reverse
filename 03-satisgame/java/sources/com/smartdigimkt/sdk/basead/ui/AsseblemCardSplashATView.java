package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.a.b;
import com.kwad.sdk.api.loader.KsDexEncryptHelper;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.l;
import com.smartdigimkt.n1.n;
import com.smartdigimkt.n1.s;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class AsseblemCardSplashATView extends BaseNewStyleSDKSplashATView {
    public TextView o0;
    public TextView p0;
    public TextView q0;
    public RoundImageView r0;
    public SplashShakeTextHintView s0;
    public ImageView t0;

    public AsseblemCardSplashATView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        View viewInflate = this.m0 > this.n0 ? LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_asseblem_card_horizontal", "layout"), this) : LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_asseblem_card_vertical", "layout"), this);
        r();
        r rVar = this.T;
        if (rVar != null) {
            rVar.c = KsDexEncryptHelper.DECRYPT_ERROR_IO;
            rVar.l = new l(this);
            rVar.a(getContext(), viewInflate);
        }
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
        m.a(getContext()).a(new o(1, this.c.f), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.smartdigimkt.n1.r(this, frameLayout, wrapRoundImageView, roundImageView));
        if (this.b.s.e != 1) {
            this.j.add(wrapRoundImageView);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void s() {
        this.o0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_ad_title", "id"));
        this.p0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_desc", "id"));
        this.q0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_cta_text", "id"));
        this.r0 = (RoundImageView) findViewById(k.a(getContext(), "myoffer_splash_icon", "id"));
        this.m = findViewById(k.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        this.s0 = (SplashShakeTextHintView) findViewById(k.a(getContext(), "myoffer_splash_cta_shake", "id"));
        this.t0 = (ImageView) findViewById(k.a(getContext(), "myoffer_splash_ambience_bg", "id"));
        if (TextUtils.isEmpty(this.c.e)) {
            d.a(0, 0, this.r0);
        } else {
            this.r0.setVisibility(0);
            this.r0.setNeedRadiu(true);
            this.r0.setRadiusInDip(12);
            int i = this.r0.getLayoutParams().width;
            m.a(getContext()).a(new o(1, this.c.e), i, i, new com.smartdigimkt.n1.m(this));
        }
        if (TextUtils.isEmpty(this.c.c)) {
            d.a(0, 0, this.o0);
        } else {
            this.o0.setText(this.c.c);
            this.o0.setVisibility(0);
        }
        if (this.p0 != null) {
            if (TextUtils.isEmpty(this.c.d)) {
                this.p0.setVisibility(8);
            } else {
                this.p0.setText(this.c.d);
            }
        }
        View view = this.m;
        if (view != null) {
            this.j.add(view);
        }
        if (c0.d(this.b)) {
            TextView textView = this.q0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            SplashShakeTextHintView splashShakeTextHintView = this.s0;
            if (splashShakeTextHintView != null) {
                if (this.m0 > this.n0) {
                    splashShakeTextHintView.setTextSize(17);
                }
                this.s0.setVisibility(0);
                SplashShakeTextHintView splashShakeTextHintView2 = this.s0;
                e eVar = this.b.s;
                c cVar = this.c;
                splashShakeTextHintView2.setShakeSetting(eVar, cVar.o, cVar);
                this.s0.setOnShakeListener(new n(this), this.b.s);
            }
        } else {
            if (this.q0 != null && this.m0 > this.n0) {
                if (TextUtils.isEmpty(this.c.h)) {
                    this.q0.setText(c0.a(getContext(), this.c));
                } else {
                    this.q0.setText(this.c.h);
                }
            }
            SplashShakeTextHintView splashShakeTextHintView3 = this.s0;
            if (splashShakeTextHintView3 != null) {
                splashShakeTextHintView3.setVisibility(8);
            }
        }
        if (this.t0 != null) {
            String strB = com.smartdigimkt.m1.d.a().b(b.d.j);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            d0.a().a(new o(3, strB), -1, -1, new com.smartdigimkt.n1.o(this));
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void t() {
        int i = this.b.s.R;
        this.A = new s(this);
        c();
    }

    public AsseblemCardSplashATView(Context context, a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }
}
