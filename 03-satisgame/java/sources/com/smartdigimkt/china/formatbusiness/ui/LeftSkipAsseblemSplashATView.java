package com.smartdigimkt.china.formatbusiness.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.api.loader.KsDexEncryptHelper;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.e.s;
import com.smartdigimkt.e.t;
import com.smartdigimkt.e.u;
import com.smartdigimkt.e.v;
import com.smartdigimkt.e.w;
import com.smartdigimkt.e.x;
import com.smartdigimkt.e.y;
import com.smartdigimkt.e.z;
import com.smartdigimkt.i2.l;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView;
import com.smartdigimkt.sdk.basead.ui.SplashShakeTextHintView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class LeftSkipAsseblemSplashATView extends AsseblemSplashATView {
    public static final /* synthetic */ int t0 = 0;
    public TextView q0;
    public SplashShakeTextHintView r0;
    public View s0;

    public LeftSkipAsseblemSplashATView(Context context, a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }

    public static void a(int i, LeftSkipAsseblemSplashATView leftSkipAsseblemSplashATView, RoundImageView roundImageView, String str) {
        Context context;
        leftSkipAsseblemSplashATView.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i < 4) {
            long j = (((long) i) * 100) + 80;
            if (roundImageView != null) {
                roundImageView.postDelayed(new z(leftSkipAsseblemSplashATView, i), j);
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

    @Override // com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public void beforeSplashEndCardShow() {
        super.beforeSplashEndCardShow();
        View view = this.s0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        View viewInflate = this.b.s.m == 2 ? LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_land_left_skip", "layout"), this) : LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_port_left_skip", "layout"), this);
        r();
        r rVar = this.T;
        if (rVar != null) {
            rVar.c = KsDexEncryptHelper.DECRYPT_ERROR_IO;
            rVar.l = new com.smartdigimkt.e.r(this);
            rVar.a(getContext(), viewInflate);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void r() {
        super.r();
        post(new x(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void s() {
        View viewFindViewById = findViewById(k.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        this.m = viewFindViewById;
        if (viewFindViewById != null) {
            this.j.add(viewFindViewById);
        }
        this.q0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_cta_text", "id"));
        this.r0 = (SplashShakeTextHintView) findViewById(k.a(getContext(), "myoffer_splash_cta_shake", "id"));
        this.s0 = findViewById(k.a(getContext(), "myoffer_splash_enter_immediately_area", "id"));
        if (!c0.d(this.b) || this.r0 == null) {
            SplashShakeTextHintView splashShakeTextHintView = this.r0;
            if (splashShakeTextHintView != null) {
                splashShakeTextHintView.setVisibility(8);
            }
            TextView textView = this.q0;
            if (textView != null) {
                textView.setVisibility(0);
                if (TextUtils.isEmpty(this.c.h)) {
                    this.q0.setText(c0.a(getContext(), this.c));
                } else {
                    this.q0.setText(this.c.h);
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
                this.m.setOnClickListener(new u(this));
            }
        } else {
            TextView textView2 = this.q0;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            this.r0.setTextSize(17);
            this.r0.setVisibility(0);
            SplashShakeTextHintView splashShakeTextHintView2 = this.r0;
            e eVar = this.b.s;
            c cVar = this.c;
            splashShakeTextHintView2.setShakeSetting(eVar, cVar.o, cVar);
            this.r0.setOnShakeListener(new s(this), this.b.s);
            View view2 = this.m;
            if (view2 != null) {
                view2.setOnClickListener(new t(this));
            }
        }
        View view3 = this.s0;
        if (view3 != null) {
            view3.setOnClickListener(new v(this));
        }
        this.p0 = findViewById(k.a(getContext(), "myoffer_splash_ad_bottom_container", "id"));
        this.m0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_ad_title", "id"));
        this.n0 = (TextView) findViewById(k.a(getContext(), "myoffer_splash_desc", "id"));
        this.o0 = (RoundImageView) findViewById(k.a(getContext(), "myoffer_splash_icon", "id"));
        if (TextUtils.isEmpty(this.c.e)) {
            l.a(this.o0, false);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.rightMargin = 0;
                this.o0.setLayoutParams(layoutParams);
            }
            if (this.b.s.m != 2) {
                TextView textView3 = this.m0;
                if (textView3 != null) {
                    textView3.setGravity(17);
                }
                TextView textView4 = this.n0;
                if (textView4 != null) {
                    textView4.setGravity(17);
                }
            }
        } else {
            this.o0.setVisibility(0);
            this.o0.setNeedRadiu(true);
            this.o0.setRadiusInDip(12);
            int i = this.o0.getLayoutParams().width;
            m.a(getContext()).a(new o(1, this.c.e), i, i, new w(this));
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

    public static void a(LeftSkipAsseblemSplashATView leftSkipAsseblemSplashATView, int i) {
        Context context;
        RoundImageView roundImageView = (RoundImageView) leftSkipAsseblemSplashATView.findViewById(k.a(leftSkipAsseblemSplashATView.getContext(), "myoffer_splash_enter_immediately_icon", "id"));
        if (roundImageView == null) {
            return;
        }
        c cVar = leftSkipAsseblemSplashATView.c;
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
        int iMax = Math.max(k.a(leftSkipAsseblemSplashATView.getContext(), 24.0f), k.a(leftSkipAsseblemSplashATView.getContext(), 48.0f));
        m.a(leftSkipAsseblemSplashATView.getContext()).a(new o(1, str), iMax, iMax, new y(i, leftSkipAsseblemSplashATView, roundImageView, str));
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
