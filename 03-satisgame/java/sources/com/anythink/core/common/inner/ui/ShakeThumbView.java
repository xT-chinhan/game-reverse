package com.anythink.core.common.inner.ui;

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
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.y;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public class ShakeThumbView extends BaseShakeView {
    private FrameLayout l;
    private TextView m;

    public ShakeThumbView(Context context) {
        super(context);
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

    @Override // com.anythink.core.common.inner.ui.BaseShakeView
    final void a() {
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(p.a(getContext(), 80.0f), p.a(getContext(), 80.0f));
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        int iA = p.a(getContext(), 88.0f);
        int color = Color.parseColor("#99262626");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(iA);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(p.a(getContext(), 48.0f), p.a(getContext(), 48.0f));
        layoutParams2.gravity = 49;
        layoutParams2.topMargin = p.a(getContext(), 16.0f);
        this.a.setLayoutParams(layoutParams2);
        this.m = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.m.setGravity(1);
        this.m.setMaxWidth(p.a(getContext(), 124.0f));
        this.m.setMaxLines(2);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        layoutParams3.gravity = 49;
        layoutParams3.topMargin = p.a(getContext(), 86.0f);
        this.m.setLayoutParams(layoutParams3);
        this.m.setText(p.a(s.b().g(), "myoffer_shake_full_title", "string"));
        this.m.setTextSize(1, 12.0f);
        this.m.setTextColor(-1);
        this.m.setBackgroundResource(p.a(s.b().g(), "myoffer_bg_shake_thumb_hint", "drawable"));
        int iA2 = p.a(getContext(), 6.0f);
        int iA3 = p.a(getContext(), 12.0f);
        this.m.setPadding(iA3, iA2, iA3, iA2);
        this.l = new FrameLayout(getContext());
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.l.addView(imageView);
        this.l.addView(this.a);
        this.l.addView(this.m);
        addView(this.l);
    }

    private void a(View view) {
        int iA = p.a(getContext(), 88.0f);
        int color = Color.parseColor("#99262626");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(iA);
        view.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.anythink.core.common.inner.ui.BaseShakeView
    public void setShakeSetting(y yVar, int i) {
        int iA;
        super.setShakeSetting(yVar, i);
        if (this.m != null) {
            if (!TextUtils.isEmpty(this.g)) {
                this.m.setText(this.g);
                return;
            }
            TextView textView = this.m;
            Context context = getContext();
            if (i == 1 || i == 4) {
                iA = p.a(context, "myoffer_shake_full_title_download_type", "string");
            } else {
                iA = p.a(context, "myoffer_shake_full_title", "string");
            }
            textView.setText(iA);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        try {
            FrameLayout frameLayout = this.l;
            if (frameLayout != null) {
                frameLayout.setOnClickListener(onClickListener);
            }
        } catch (Throwable unused) {
        }
    }
}
