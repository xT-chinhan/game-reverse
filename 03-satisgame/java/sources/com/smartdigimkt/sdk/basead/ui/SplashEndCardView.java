package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.n1.a6;
import com.smartdigimkt.n1.b6;
import com.smartdigimkt.n1.c6;
import com.smartdigimkt.n1.d6;
import com.smartdigimkt.n1.e6;
import com.smartdigimkt.n1.p0;
import com.smartdigimkt.n1.z5;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class SplashEndCardView extends BaseEndCardView {
    public final String e;
    public final RoundImageView f;
    public final TextView g;
    public final TextView h;
    public final CTAButtonLayout i;
    public final TextView j;
    public final BaseShakeView k;
    public final ImageView l;
    public final z5 m;

    public SplashEndCardView(Context context, c cVar, a aVar) {
        View viewFindViewById;
        super(context, cVar, aVar);
        this.e = "Skip";
        z5 z5Var = new z5(this);
        this.m = z5Var;
        this.e = getResources().getString(k.a(getContext(), "myoffer_splash_skip_text", "string"));
        View viewInflate = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_endcard", "layout"), (ViewGroup) this, true);
        RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(k.a(getContext(), "myoffer_splash_endcard_icon", "id"));
        this.f = roundImageView;
        CTAButtonLayout cTAButtonLayout = (CTAButtonLayout) viewInflate.findViewById(k.a(getContext(), "myoffer_splash_endcard_cta", "id"));
        this.i = cTAButtonLayout;
        this.g = (TextView) viewInflate.findViewById(k.a(getContext(), "myoffer_splash_endcard_title", "id"));
        this.h = (TextView) viewInflate.findViewById(k.a(getContext(), "myoffer_splash_endcard_desc", "id"));
        TextView textView = (TextView) viewInflate.findViewById(k.a(getContext(), "myoffer_splash_endcard_count_down_text", "id"));
        this.j = textView;
        this.k = (BaseShakeView) viewInflate.findViewById(k.a(getContext(), "myoffer_splash_endcard_shake_hint_text", "id"));
        this.l = (ImageView) viewInflate.findViewById(k.a(getContext(), "myoffer_splash_endcard_top_bg", "id"));
        this.a.getClass();
        setOnClickListener(z5Var);
        if (roundImageView != null) {
            roundImageView.setNeedRadiu(true);
            roundImageView.setRadiusInDip(12);
        }
        if (cTAButtonLayout != null) {
            this.a.getClass();
            cTAButtonLayout.setOnClickListener(z5Var);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(k.a(getContext(), 12.0f));
        setBackground(gradientDrawable);
        if (textView != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(Integer.MIN_VALUE);
            gradientDrawable2.setCornerRadius(k.a(getContext(), 12.0f));
            textView.setBackground(gradientDrawable2);
            textView.setOnClickListener(new a6(this));
        }
        if (TextUtils.isEmpty(this.a.c) && TextUtils.isEmpty(this.a.d) && (viewFindViewById = viewInflate.findViewById(k.a(getContext(), "myoffer_splash_endcard_header_container", "id"))) != null) {
            viewFindViewById.getLayoutParams().height = k.a(getContext(), 240.0f);
        }
        String strB = d.a().b(b.d.e);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        d0.a().a(new o(3, strB), -1, -1, new b6(this));
    }

    public void init(p0 p0Var, long j) {
        this.mListener = p0Var;
        String str = this.a.e;
        if (TextUtils.isEmpty(str)) {
            str = this.a.f;
        }
        int iA = k.a(getContext(), 60.0f);
        m.a(getContext()).a(new o(1, str), iA, iA, new c6(this, str));
        CTAButtonLayout cTAButtonLayout = this.i;
        if (cTAButtonLayout != null) {
            cTAButtonLayout.initSetting(this.a, this.b, true, new d6(this));
        }
        if (TextUtils.isEmpty(this.a.c)) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            this.g.setText(this.a.c);
        }
        if (TextUtils.isEmpty(this.a.d)) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.h.setText(this.a.d);
        }
        if (!c0.d(this.b)) {
            this.k.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        this.k.setShakeSetting(this.b.s, this.a.o);
        if (this.c.e != 1) {
            this.a.getClass();
            this.k.setOnClickListener(this.m);
        }
        this.k.setOnShakeListener(new e6(this), this.c);
    }

    public void onCountDownTick(long j) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setText((j / 1000) + "s | " + this.e);
        }
    }
}
