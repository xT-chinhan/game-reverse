package com.bytedance.sdk.openadsdk.res.layout.video;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    @Override // com.bytedance.sdk.openadsdk.res.layout.ms
    public View xr(Context context) {
        RelativeLayout relativeLayoutMs = ms(context, 2114387953);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        relativeLayout.setLayoutParams(layoutParams);
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387958);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ul.ah(context, 72.0f), ul.ah(context, 72.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, ul.ah(context, 30.0f), 0, 0);
        roundImageView.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        textView.setId(2114387932);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, 2114387958);
        layoutParams3.setMargins(0, ul.ah(context, 8.0f), 0, 0);
        textView.setLayoutParams(layoutParams3);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 14.0f);
        textView.setText("直播结束");
        TextView textView2 = new TextView(context);
        textView2.setId(2114387883);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, 2114387932);
        layoutParams4.setMargins(0, ul.ah(context, 24.0f), 0, 0);
        textView2.setLayoutParams(layoutParams4);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 20.0f);
        textView2.setText("直播已结束");
        relativeLayout.addView(roundImageView);
        relativeLayout.addView(textView);
        relativeLayout.addView(textView2);
        relativeLayoutMs.addView(relativeLayout);
        return relativeLayoutMs;
    }
}
