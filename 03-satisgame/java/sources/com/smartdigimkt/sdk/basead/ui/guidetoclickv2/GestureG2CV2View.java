package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.g0;
import com.smartdigimkt.y1.w;
import com.smartdigimkt.y1.x;

/* JADX INFO: loaded from: classes3.dex */
public class GestureG2CV2View extends BaseG2CV2View {
    public ImageView h;
    public ImageView i;
    public TextView j;
    public TranslateAnimation k;
    public int l;
    public boolean m;
    public RelativeLayout n;
    public float o;
    public float p;
    public int q;
    public g0 r;

    public GestureG2CV2View(Context context) {
        super(context);
        this.m = false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_gesture", "layout"), this);
        this.q = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.h = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_slide_finger", "id"));
        this.i = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_white_line", "id"));
        this.j = (TextView) findViewById(k.a(getContext(), "myoffer_g2c_slide_hint", "id"));
        this.n = (RelativeLayout) findViewById(k.a(getContext(), "myoffer_g2c_item_container", "id"));
        this.l = k.a(getContext(), 36.0f);
        if (i == 1 || i == 3) {
            this.n.setBackgroundResource(k.a(getContext(), "myoffer_g2c_gesture_bg", "drawable"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(k.a(getContext(), 270.0f), k.a(getContext(), 100.0f));
            layoutParams.addRule(13);
            this.n.setLayoutParams(layoutParams);
            this.i.setVisibility(0);
        } else if (i == 2) {
            this.n.setBackgroundColor(Color.parseColor("#80000000"));
            this.i.setVisibility(0);
            if (this.m) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams2.width = k.a(getContext(), 240.0f);
                this.i.setLayoutParams(layoutParams2);
            }
        } else {
            ViewGroup.LayoutParams layoutParams3 = this.h.getLayoutParams();
            layoutParams3.height = k.a(getContext(), 24.0f);
            layoutParams3.width = k.a(getContext(), 24.0f);
            this.l = k.a(getContext(), 24.0f);
            this.h.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams4.width = k.a(getContext(), 150.0f);
            layoutParams4.height = k.a(getContext(), 4.0f);
            layoutParams4.setMargins(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.rightMargin, k.a(getContext(), 8.0f));
            this.i.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams5.setMargins(k.a(getContext(), 8.0f), layoutParams5.topMargin, layoutParams5.rightMargin, layoutParams5.bottomMargin);
            this.j.setTextSize(1, 10.0f);
            setBackgroundColor(Color.parseColor("#80000000"));
            post(new w(this));
        }
        if (this.k == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -this.l, 0.0f, 0.0f);
            this.k = translateAnimation;
            translateAnimation.setDuration(1000L);
            this.k.setRepeatCount(-1);
            this.k.setRepeatMode(2);
            this.h.startAnimation(this.k);
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
        this.r = g0Var;
        if (g0Var != null) {
            g0Var.setCallback(new x(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g0 g0Var = this.r;
        if (g0Var != null) {
            g0Var.setCallback(null);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void pauseAnim() {
        TranslateAnimation translateAnimation = this.k;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        TranslateAnimation translateAnimation = this.k;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void resumeAnim() {
        TranslateAnimation translateAnimation = this.k;
        if (translateAnimation != null) {
            translateAnimation.start();
        }
    }

    public void setVerticalLandscape(boolean z) {
        this.m = z;
    }
}
