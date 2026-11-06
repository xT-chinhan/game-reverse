package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.n1.a0;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class ShakeBorderThumbView extends BaseShakeView {
    public TextView n;
    public boolean o;

    public ShakeBorderThumbView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void a() {
        setOrientation(0);
        setGravity(17);
        setClipToPadding(false);
        setBackgroundResource(k.a(SDKContext.getInstance().d(), "myoffer_bg_shake_border_thumb", "drawable"));
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        int iA = k.a(getContext(), 10.0f);
        int iA2 = k.a(getContext(), 10.0f);
        int iA3 = k.a(getContext(), 6.0f);
        setPadding(iA, iA3, iA2, iA3);
        this.a = (ImageView) findViewById(k.a(SDKContext.getInstance().d(), "myoffer_splash_shake_border_img", "id"));
        this.n = (TextView) findViewById(k.a(SDKContext.getInstance().d(), "myoffer_splash_shake_hint_text", "id"));
    }

    public void applyBannerForegroundProfile(a0 a0Var) {
        if (a0Var == null || this.a == null || this.n == null) {
            return;
        }
        this.o = true;
        setClickable(false);
        setLongClickable(false);
        setFocusable(false);
        setClipChildren(false);
        setGravity(17);
        float f = 10;
        int iA = k.a(getContext(), f);
        setPadding(iA, 0, iA, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{0, Integer.MIN_VALUE});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setCornerRadius(k.a(getContext(), a0Var.b == 1 ? 4 : 5));
        setBackground(gradientDrawable);
        int iA2 = k.a(getContext(), "banner_interaction_shake_icon", "drawable");
        if (iA2 != 0) {
            this.a.setImageResource(iA2);
        }
        this.a.setColorFilter((ColorFilter) null);
        this.a.setContentDescription(null);
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(0, 0);
        }
        int iA3 = k.a(getContext(), a0Var.b == 1 ? 16 : 18);
        layoutParams.width = iA3;
        layoutParams.height = iA3;
        this.a.setLayoutParams(layoutParams);
        this.n.setText(k.a(getContext(), "banner_interaction_shake_hint", "string"));
        this.n.setTextColor(-1);
        this.n.setTextSize(2, f);
        this.n.setIncludeFontPadding(false);
        this.n.setSingleLine(true);
        this.n.setMaxLines(1);
        this.n.setEllipsize(null);
        this.n.setGravity(19);
        this.n.setContentDescription(null);
        this.n.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams2 = this.n.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams.leftMargin = k.a(getContext(), 4);
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
            this.n.setLayoutParams(marginLayoutParams);
        }
        ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
        if (layoutParams3 == null) {
            layoutParams3 = new ViewGroup.LayoutParams(0, 0);
        }
        layoutParams3.width = k.a(getContext(), a0Var.d);
        layoutParams3.height = k.a(getContext(), a0Var.e);
        setLayoutParams(layoutParams3);
    }

    public int getLayoutId() {
        return k.a(getContext(), "myoffer_shake_border_thumb", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void setShakeSetting(e eVar, int i) {
        ImageView imageView;
        if (this.o) {
            if (eVar != null) {
                this.e = eVar.r0;
                this.f = null;
                this.g = eVar.t0;
                this.h = eVar.u0;
                this.i = eVar.v0;
            }
            int iA = k.a(getContext(), "banner_interaction_shake_icon", "drawable");
            if (iA != 0 && (imageView = this.a) != null) {
                imageView.setImageResource(iA);
            }
        } else {
            super.setShakeSetting(eVar, i);
        }
        if (this.n != null) {
            if (this.o) {
                this.n.setText(k.a(getContext(), "banner_interaction_shake_hint", "string"));
            } else if (TextUtils.isEmpty(this.i)) {
                this.n.setText(c0.a(getContext(), i));
            } else {
                this.n.setText(this.i);
            }
        }
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
