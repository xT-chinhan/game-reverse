package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.b3;
import com.smartdigimkt.n1.c3;
import com.smartdigimkt.n1.d3;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class FullScreenHeaderPanelView extends RelativeLayout {
    public View a;
    public TextView b;
    public TextView c;
    public ScanningAnimButton d;
    public RoundImageView e;
    public c f;
    public a g;
    public e h;
    public d3 i;
    public final b3 j;

    public FullScreenHeaderPanelView(Context context) {
        super(context);
        this.j = new b3(this);
        a();
    }

    public final void a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_full_screen_top_panel", "layout"), (ViewGroup) this, true);
        this.a = viewInflate;
        this.e = (RoundImageView) viewInflate.findViewById(k.a(getContext(), "myoffer_full_screen_top_banner_icon", "id"));
        this.d = (ScanningAnimButton) this.a.findViewById(k.a(getContext(), "myoffer_full_screen_top_banner_cta", "id"));
        this.b = (TextView) this.a.findViewById(k.a(getContext(), "myoffer_full_screen_top_banner_title", "id"));
        this.c = (TextView) this.a.findViewById(k.a(getContext(), "myoffer_full_screen_top_banner_desc", "id"));
        RoundImageView roundImageView = this.e;
        if (roundImageView != null) {
            roundImageView.setNeedRadiu(true);
            this.e.setRadiusInDip(12);
        }
        ScanningAnimButton scanningAnimButton = this.d;
        if (scanningAnimButton != null) {
            scanningAnimButton.setOnClickListener(this.j);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(k.a(getContext(), 12.0f));
        setBackground(gradientDrawable);
        setOnClickListener(this.j);
    }

    public void initSetting(c cVar, a aVar, d3 d3Var) {
        this.f = cVar;
        this.g = aVar;
        this.h = aVar.s;
        this.i = d3Var;
        String str = cVar.e;
        if (TextUtils.isEmpty(str)) {
            str = this.f.f;
        }
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
            int iA = k.a(getContext(), 42.0f);
            m.a(getContext()).a(new o(1, str), iA, iA, new c3(this, str));
        }
        if (this.d != null) {
            if (TextUtils.isEmpty(this.f.h)) {
                this.d.setText(c0.a(getContext(), this.f));
            } else {
                this.d.setText(this.f.h);
            }
            this.d.startAnimation(this.g.s.z0);
        }
        if (TextUtils.isEmpty(this.f.c)) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.b.setText(this.f.c);
        }
        if (TextUtils.isEmpty(this.f.d)) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.c.setText(this.f.d);
        }
    }

    public FullScreenHeaderPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new b3(this);
        a();
    }

    public FullScreenHeaderPanelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new b3(this);
        a();
    }
}
