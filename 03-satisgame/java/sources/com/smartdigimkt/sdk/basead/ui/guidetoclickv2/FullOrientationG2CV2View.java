package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.g0;
import com.smartdigimkt.y1.l;
import com.smartdigimkt.y1.m;

/* JADX INFO: loaded from: classes3.dex */
public class FullOrientationG2CV2View extends BaseG2CV2View {
    public static final int DEFAULT_SIZE = 120;
    public ValueAnimator h;
    public int i;
    public ViewGroup j;
    public ImageView k;
    public float l;
    public float m;
    public float n;
    public float o;
    public int p;
    public g0 q;
    public RelativeLayout.LayoutParams r;
    public final int s;

    public FullOrientationG2CV2View(Context context) {
        super(context);
        this.i = 0;
        this.s = k.a(getContext(), 120.0f);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_full_orientation", "layout"), this);
        this.p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        ViewGroup viewGroup = (ViewGroup) findViewById(k.a(getContext(), "myoffer_g2c_fullori_container", "id"));
        this.j = viewGroup;
        RelativeLayout.LayoutParams layoutParams = this.r;
        if (layoutParams != null) {
            viewGroup.setLayoutParams(layoutParams);
        }
        this.k = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_fullori_finger", "id"));
        if (this.h == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, k.a(getContext(), 12.0f), 0.0f);
            this.h = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.h.setRepeatCount(-1);
            this.h.addUpdateListener(new com.smartdigimkt.y1.k(this));
            this.h.addListener(new l(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        g0 g0Var;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            if (parent.getParent() == null) {
                g0Var = null;
                break;
            } else {
                if (parent instanceof g0) {
                    g0Var = (g0) parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        this.q = g0Var;
        if (g0Var != null) {
            g0Var.setCallback(new m(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g0 g0Var = this.q;
        if (g0Var != null) {
            g0Var.setCallback(null);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void pauseAnim() {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void resumeAnim() {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void setViewMode(int i) {
        int i2 = this.s;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        this.r = layoutParams;
        if (i == 502 || i == 504 || i == 505) {
            layoutParams.addRule(13);
            return;
        }
        layoutParams.addRule(12);
        this.r.addRule(14);
        this.r.addRule(14);
        this.r.setMargins(0, 0, 0, k.a(getContext(), 140.0f));
    }

    public void updateSize(int i) {
        int i2 = (int) (i * 0.72f);
        RelativeLayout.LayoutParams layoutParams = this.r;
        layoutParams.width = -2;
        layoutParams.height = i2;
        this.j.setBackgroundColor(0);
        View viewFindViewById = findViewById(k.a(getContext(), "myoffer_g2c_fullori_bg", "id"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams2.width = i2;
        layoutParams2.height = i2;
        layoutParams2.topMargin = 0;
        layoutParams2.addRule(15);
        viewFindViewById.setLayoutParams(layoutParams2);
        this.k = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_fullori_finger", "id"));
        float f = i2;
        float f2 = f * 0.5f;
        int i3 = (int) f2;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams3.topMargin = 0;
        layoutParams3.leftMargin = (int) ((f - f2) * 0.5f);
        layoutParams3.addRule(15);
        this.k.setLayoutParams(layoutParams3);
        TextView textView = (TextView) findViewById(k.a(getContext(), "myoffer_g2c_fullori_text", "id"));
        textView.setTextSize(2, 10.0f);
        textView.setText(k.a(getContext(), "myoffer_g2c_fuu_ori_hint_small", "string"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.width = -2;
        layoutParams4.topMargin = 0;
        layoutParams4.leftMargin = k.a(getContext(), 10.0f);
        layoutParams4.addRule(15);
        layoutParams4.addRule(1, viewFindViewById.getId());
        textView.setLayoutParams(layoutParams4);
        this.j.setLayoutParams(this.r);
    }
}
