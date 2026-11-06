package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements com.bytedance.sdk.openadsdk.res.layout.ms {
    protected RelativeLayout ms(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        if (i != 0) {
            relativeLayout.setId(i);
        }
        return relativeLayout;
    }

    protected View xr(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387917);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ul.ah(context, 66.0f), ul.ah(context, 66.0f));
        layoutParams.addRule(14);
        if (i != 0) {
            layoutParams.setMargins(0, ul.ah(context, i), 0, 0);
        }
        relativeLayout.setLayoutParams(layoutParams);
        t.ms(context, "tt_live_avatar_bg", relativeLayout);
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387837);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ul.ah(context, 65.0f), ul.ah(context, 65.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(10);
        roundImageView.setLayoutParams(layoutParams2);
        relativeLayout.addView(roundImageView);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387614);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ul.ah(context, 42.0f), ul.ah(context, 18.0f));
        layoutParams3.addRule(13);
        layoutParams3.addRule(12);
        imageView.setLayoutParams(layoutParams3);
        t.ms(context, "tt_live_ad_status_icon", (View) imageView);
        relativeLayout.addView(imageView);
        return relativeLayout;
    }

    protected View ms(Context context, int i, int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387699);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ul.ah(context, 44.0f));
        layoutParams.addRule(12);
        layoutParams.setMargins(ul.ah(context, 40.0f), 0, ul.ah(context, 40.0f), ul.ah(context, i));
        relativeLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(ul.ah(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387882);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ul.ah(context, 14.0f), ul.ah(context, 16.0f));
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, ul.ah(context, i2), 0);
        imageView.setLayoutParams(layoutParams2);
        t.ms(context, "tt_live_ad_loading_btn_status", (View) imageView);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387758);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387882);
        layoutParams3.addRule(17, 2114387882);
        layoutParams3.addRule(15);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText(t.ms(context, "tt_live_loading_btn"));
        textView.setTextColor(-1);
        relativeLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ul.ah(context, 14.0f), ul.ah(context, 16.0f));
        layoutParams4.addRule(1, 2114387758);
        layoutParams4.addRule(13);
        layoutParams4.setMargins(0, 0, ul.ah(context, 6.0f), 0);
        imageView2.setLayoutParams(layoutParams4);
        t.ms(context, "tt_splash_click_bar_go", (View) imageView2);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
