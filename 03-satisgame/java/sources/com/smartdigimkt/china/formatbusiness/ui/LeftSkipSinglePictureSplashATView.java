package com.smartdigimkt.china.formatbusiness.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.kwad.sdk.api.loader.KsDexEncryptHelper;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.e.a0;
import com.smartdigimkt.e.b0;
import com.smartdigimkt.e.d0;
import com.smartdigimkt.e.e0;
import com.smartdigimkt.e.f0;
import com.smartdigimkt.e.g0;
import com.smartdigimkt.e.h0;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.SinglePictureSplashATView;
import com.smartdigimkt.sdk.basead.ui.SplashShakeTextHintView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class LeftSkipSinglePictureSplashATView extends SinglePictureSplashATView {
    public static final /* synthetic */ int r0 = 0;
    public TextView o0;
    public SplashShakeTextHintView p0;
    public View q0;

    public LeftSkipSinglePictureSplashATView(Context context, a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }

    public static void a(int i, LeftSkipSinglePictureSplashATView leftSkipSinglePictureSplashATView, RoundImageView roundImageView, String str) {
        Context context;
        leftSkipSinglePictureSplashATView.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i < 4) {
            long j = (((long) i) * 100) + 80;
            if (roundImageView != null) {
                roundImageView.postDelayed(new h0(leftSkipSinglePictureSplashATView, i), j);
                return;
            }
            return;
        }
        if (roundImageView == null) {
            return;
        }
        roundImageView.setImageDrawable(null);
        roundImageView.setVisibility(8);
        ViewParent parent = roundImageView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null || (context = roundImageView.getContext()) == null) {
            return;
        }
        char[] cArr = k.a;
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f);
        viewGroup.setPadding(i2, viewGroup.getPaddingTop(), i2, viewGroup.getPaddingBottom());
    }

    @Override // com.smartdigimkt.sdk.basead.ui.SinglePictureSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        View viewInflate = this.b.s.m == 2 ? LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_single_land_left_skip", "layout"), this) : LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_single_port_left_skip", "layout"), this);
        r();
        r rVar = this.T;
        if (rVar != null) {
            rVar.c = KsDexEncryptHelper.DECRYPT_ERROR_IO;
            rVar.l = new a0(this);
            rVar.a(getContext(), viewInflate);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void r() {
        super.r();
        post(new f0(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.SinglePictureSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void s() {
        View viewFindViewById = findViewById(k.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        this.m = viewFindViewById;
        if (viewFindViewById != null) {
            this.j.add(viewFindViewById);
        }
        this.o0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_cta_text", "id"));
        this.p0 = (SplashShakeTextHintView) findViewById(k.a(getContext(), "myoffer_splash_cta_shake", "id"));
        this.q0 = findViewById(k.a(getContext(), "myoffer_splash_enter_immediately_area", "id"));
        if (!c0.d(this.b) || this.p0 == null) {
            SplashShakeTextHintView splashShakeTextHintView = this.p0;
            if (splashShakeTextHintView != null) {
                splashShakeTextHintView.setVisibility(8);
            }
            TextView textView = this.o0;
            if (textView != null) {
                textView.setVisibility(0);
                if (TextUtils.isEmpty(this.c.h)) {
                    this.o0.setText(c0.a(getContext(), this.c));
                } else {
                    this.o0.setText(this.c.h);
                }
            }
            View view = this.m;
            if (view != null) {
                a aVar = this.b;
                if (aVar != null && aVar.s != null) {
                    if (view.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.m.getParent()).setClipChildren(false);
                    }
                    com.smartdigimkt.o1.a.a(this.m, this.b.s.z0).start();
                }
                this.m.setOnClickListener(new d0(this));
            }
        } else {
            TextView textView2 = this.o0;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            this.p0.setTextSize(17);
            this.p0.setVisibility(0);
            SplashShakeTextHintView splashShakeTextHintView2 = this.p0;
            e eVar = this.b.s;
            c cVar = this.c;
            splashShakeTextHintView2.setShakeSetting(eVar, cVar.o, cVar);
            this.p0.setOnShakeListener(new b0(this), this.b.s);
            View view2 = this.m;
            if (view2 != null) {
                view2.setOnClickListener(new com.smartdigimkt.e.c0(this));
            }
        }
        View view3 = this.q0;
        if (view3 != null) {
            view3.setOnClickListener(new e0(this));
        }
    }

    public static void a(LeftSkipSinglePictureSplashATView leftSkipSinglePictureSplashATView, int i) {
        Context context;
        RoundImageView roundImageView = (RoundImageView) leftSkipSinglePictureSplashATView.findViewById(k.a(leftSkipSinglePictureSplashATView.getContext(), "myoffer_splash_enter_immediately_icon", "id"));
        if (roundImageView == null) {
            return;
        }
        c cVar = leftSkipSinglePictureSplashATView.c;
        String str = cVar != null ? cVar.e : null;
        if (TextUtils.isEmpty(str)) {
            roundImageView.setVisibility(8);
            ViewParent parent = roundImageView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup == null || (context = roundImageView.getContext()) == null) {
                return;
            }
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f);
            viewGroup.setPadding(i2, viewGroup.getPaddingTop(), i2, viewGroup.getPaddingBottom());
            return;
        }
        roundImageView.setVisibility(0);
        a(roundImageView);
        roundImageView.setNeedRadiu(true);
        roundImageView.setRadiusInDip(4);
        int iMax = Math.max(k.a(leftSkipSinglePictureSplashATView.getContext(), 24.0f), k.a(leftSkipSinglePictureSplashATView.getContext(), 48.0f));
        m.a(leftSkipSinglePictureSplashATView.getContext()).a(new o(1, str), iMax, iMax, new g0(i, leftSkipSinglePictureSplashATView, roundImageView, str));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    public static void a(RoundImageView roundImageView) {
        ViewGroup viewGroup;
        Context context;
        if (roundImageView == null) {
            viewGroup = null;
        } else {
            ViewParent parent = roundImageView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
        }
        if (viewGroup == null || (context = roundImageView.getContext()) == null) {
            return;
        }
        int paddingTop = viewGroup.getPaddingTop();
        int paddingBottom = viewGroup.getPaddingBottom();
        char[] cArr = k.a;
        viewGroup.setPadding((int) ((context.getResources().getDisplayMetrics().density * 4.0f) + 0.5f), paddingTop, (int) ((context.getResources().getDisplayMetrics().density * 12.0f) + 0.5f), paddingBottom);
    }
}
