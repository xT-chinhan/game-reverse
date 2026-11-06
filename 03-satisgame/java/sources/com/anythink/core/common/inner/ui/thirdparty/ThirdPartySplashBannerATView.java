package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartySplashBannerATView extends RelativeLayout implements com.anythink.core.common.k.b.a.c {
    private Context a;
    private a b;

    public ThirdPartySplashBannerATView(Context context) {
        this(context, null);
    }

    public ThirdPartySplashBannerATView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThirdPartySplashBannerATView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int iA = p.a(this.a, 5.0f);
        layoutParams.leftMargin = iA;
        layoutParams.topMargin = iA;
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        textView.setBackgroundResource(p.a(this.a, "myoffer_splash_ad_label_bg", "drawable"));
        int iA2 = p.a(this.a, 2.0f);
        textView.setPadding(iA, iA2, iA, iA2);
        textView.setText(p.a(this.a, "basead_ad_text", "string"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setTextSize(2, 11.0f);
        textView.setGravity(17);
        addView(textView, layoutParams);
    }

    public void addCountDownView(int i, a.InterfaceC0027a interfaceC0027a) {
        a aVar = new a(this.a, this, ((long) i) * 1000, interfaceC0027a);
        this.b = aVar;
        View viewA = aVar.a();
        if (viewA == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.setMargins(0, p.a(this.a, 32.0f), p.a(this.a, 18.0f), 0);
        addView(viewA, layoutParams);
        this.b.b();
    }

    public void addBannerView(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        addView(view, layoutParams);
    }

    private void b() {
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int iA = p.a(this.a, 5.0f);
        layoutParams.leftMargin = iA;
        layoutParams.topMargin = iA;
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        textView.setBackgroundResource(p.a(this.a, "myoffer_splash_ad_label_bg", "drawable"));
        int iA2 = p.a(this.a, 2.0f);
        textView.setPadding(iA, iA2, iA, iA2);
        textView.setText(p.a(this.a, "basead_ad_text", "string"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setTextSize(2, 11.0f);
        textView.setGravity(17);
        addView(textView, layoutParams);
    }

    private void a() {
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int iA = p.a(this.a, 5.0f);
        layoutParams.leftMargin = iA;
        layoutParams.topMargin = iA;
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        textView.setBackgroundResource(p.a(this.a, "myoffer_splash_ad_label_bg", "drawable"));
        int iA2 = p.a(this.a, 2.0f);
        textView.setPadding(iA, iA2, iA, iA2);
        textView.setText(p.a(this.a, "basead_ad_text", "string"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setTextSize(2, 11.0f);
        textView.setGravity(17);
        addView(textView, layoutParams);
    }
}
