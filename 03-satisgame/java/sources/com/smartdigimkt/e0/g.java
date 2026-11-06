package com.smartdigimkt.e0;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.smartdigimkt.i2.j;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final CTAButtonLayout a;
    public final ImageView b;
    public final View c;
    public final View d;
    public ValueAnimator e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;

    public g(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(k.a(context, "myoffer_letter_top_layout", "layout"), (ViewGroup) null);
        this.c = viewInflate;
        View view = new View(context);
        this.d = view;
        view.setBackgroundResource(k.a(context, "myoffer_letter_bottom", "drawable"));
        this.a = (CTAButtonLayout) viewInflate.findViewById(k.a(context, "myoffer_panel_cta_layout", "id"));
        this.b = (ImageView) viewInflate.findViewById(k.a(context, "myoffer_letter_icon", "id"));
        String strB = com.smartdigimkt.m1.d.a().b(com.anythink.core.common.a.b.d.c);
        String strB2 = com.smartdigimkt.m1.d.a().b(com.anythink.core.common.a.b.d.d);
        if (!TextUtils.isEmpty(strB)) {
            d0.a().a(new o(3, strB), -1, -1, new a(this, context));
        }
        if (TextUtils.isEmpty(strB2)) {
            return;
        }
        d0.a().a(new o(3, strB2), -1, -1, new b(this, context));
    }

    public final void a(RelativeLayout relativeLayout, int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(8, i);
        this.c.setLayoutParams(layoutParams);
        relativeLayout.addView(this.c, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(8, this.c.getId());
        layoutParams2.addRule(5, this.c.getId());
        layoutParams2.addRule(7, this.c.getId());
        relativeLayout.addView(this.d, 0, layoutParams2);
    }

    public final void a(int i) {
        this.h = (i * 111) / TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = this.h;
        this.c.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = (layoutParams.height * 200) / 111;
        this.d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams3.height = (layoutParams.height * 48) / 126;
        layoutParams3.bottomMargin = (this.h / 129) * 35;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        int i2 = this.h;
        layoutParams4.bottomMargin = (i2 / 129) * 35;
        this.i = i2 / 3;
    }

    public final void a() {
        this.g = true;
        try {
            ValueAnimator valueAnimator = this.e;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.e.cancel();
        } catch (Throwable unused) {
        }
    }

    public final void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.i2.k kVar) {
        if (!TextUtils.isEmpty(cVar.l)) {
            this.a.initSetting(cVar, aVar, false, new c(kVar));
            this.a.setOnClickListener(new d(kVar));
            this.b.setVisibility(8);
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
        }
        new j(cVar, aVar).a(this.c);
    }
}
