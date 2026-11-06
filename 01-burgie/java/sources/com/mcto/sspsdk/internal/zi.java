package com.mcto.sspsdk.internal;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.interaction.QyTwistView;

/* JADX INFO: loaded from: classes2.dex */
public final class zi extends bj {
    public zi(Context context) {
        super(context, 0);
    }

    @Override // com.mcto.sspsdk.internal.bj
    public final void a(int i) {
        QyTwistView qyTwistView = new QyTwistView(getContext());
        this.g = qyTwistView;
        qyTwistView.setId(R.id.qy_splash_action_icon);
        this.g.a(i);
        Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(hk.a(getContext(), 27.0f), 0);
        layoutParams.dimensionRatio = "1:1";
        layoutParams.leftToLeft = 0;
        layoutParams.rightToLeft = R.id.qy_splash_action_title;
        layoutParams.topToTop = 0;
        layoutParams.bottomToTop = R.id.qy_splash_action_sub_title;
        layoutParams.horizontalChainStyle = 2;
        layoutParams.verticalChainStyle = 2;
        addView(this.g, layoutParams);
        TextView textView = new TextView(getContext());
        this.b = textView;
        textView.setId(R.id.qy_splash_action_title);
        this.b.setSingleLine(true);
        this.b.setGravity(16);
        this.b.setTextSize(1, 12.0f);
        this.b.setTextColor(-1);
        this.b.setTypeface(null, 1);
        Constraints.LayoutParams layoutParams2 = new Constraints.LayoutParams(-2, 0);
        ((ConstraintLayout.LayoutParams) layoutParams2).leftMargin = hk.a(getContext(), 6.0f);
        int i2 = R.id.qy_splash_action_icon;
        layoutParams2.leftToRight = i2;
        layoutParams2.rightToRight = 0;
        layoutParams2.topToTop = i2;
        layoutParams2.bottomToBottom = i2;
        layoutParams2.horizontalChainStyle = 2;
        addView(this.b, layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.c = textView2;
        textView2.setId(R.id.qy_splash_action_sub_title);
        this.c.setSingleLine(true);
        this.c.setGravity(17);
        this.c.setTextSize(1, 12.0f);
        this.c.setTextColor(ContextCompat.getColor(getContext(), R.color.qy_text_color_white_60alpha));
        this.c.setTypeface(null, 1);
        this.c.setVisibility(8);
        Constraints.LayoutParams layoutParams3 = new Constraints.LayoutParams(-1, -2);
        layoutParams3.topToBottom = R.id.qy_splash_action_icon;
        layoutParams3.bottomToBottom = 0;
        layoutParams3.verticalChainStyle = 2;
        ((ConstraintLayout.LayoutParams) layoutParams3).topMargin = hk.a(getContext(), 4.0f);
        addView(this.c, layoutParams3);
    }

    @Override // com.mcto.sspsdk.internal.hi
    public final void a(String str) {
        this.c.setText(str);
        this.c.setVisibility(0);
    }
}
