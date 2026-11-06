package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class ShakeThumbView extends BaseShakeView {
    public FrameLayout n;
    public TextView o;

    public ShakeThumbView(Context context) {
        super(context);
    }

    private void setBgDrawable(View view) {
        int iA = k.a(getContext(), 88.0f);
        int color = Color.parseColor("#99262626");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(iA);
        view.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public final void a() {
        setOrientation(1);
        setGravity(1);
        View imageView = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k.a(getContext(), 80.0f), k.a(getContext(), 80.0f));
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        setBgDrawable(imageView);
        this.a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(k.a(getContext(), 48.0f), k.a(getContext(), 48.0f));
        layoutParams2.gravity = 49;
        layoutParams2.topMargin = k.a(getContext(), 16.0f);
        this.a.setLayoutParams(layoutParams2);
        this.o = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.o.setGravity(1);
        this.o.setMaxWidth(k.a(getContext(), 124.0f));
        this.o.setMaxLines(2);
        this.o.setEllipsize(TextUtils.TruncateAt.END);
        layoutParams3.gravity = 49;
        layoutParams3.topMargin = k.a(getContext(), 86.0f);
        this.o.setLayoutParams(layoutParams3);
        this.o.setText(k.a(SDKContext.getInstance().d(), "myoffer_shake_full_title", "string"));
        this.o.setTextSize(1, 12.0f);
        this.o.setTextColor(-1);
        this.o.setBackgroundResource(k.a(SDKContext.getInstance().d(), "myoffer_bg_shake_thumb_hint", "drawable"));
        int iA = k.a(getContext(), 6.0f);
        int iA2 = k.a(getContext(), 12.0f);
        this.o.setPadding(iA2, iA, iA2, iA);
        this.n = new FrameLayout(getContext());
        this.n.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.n.addView(imageView);
        this.n.addView(this.a);
        this.n.addView(this.o);
        addView(this.n);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        try {
            FrameLayout frameLayout = this.n;
            if (frameLayout != null) {
                frameLayout.setOnClickListener(onClickListener);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseShakeView
    public void setShakeSetting(e eVar, int i) {
        super.setShakeSetting(eVar, i);
        if (this.o != null) {
            if (TextUtils.isEmpty(this.h)) {
                this.o.setText(c0.a(getContext(), i));
            } else {
                this.o.setText(this.h);
            }
        }
    }

    public ShakeThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeThumbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ShakeThumbView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
