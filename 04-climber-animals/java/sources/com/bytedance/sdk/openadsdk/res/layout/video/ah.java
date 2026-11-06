package com.bytedance.sdk.openadsdk.res.layout.video;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    @Override // com.bytedance.sdk.openadsdk.res.layout.ms
    public View xr(Context context) {
        RelativeLayout relativeLayoutMs = ms(context, 2114387622);
        relativeLayoutMs.addView(xr(context, 159));
        relativeLayoutMs.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387748);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2114387917);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, ul.ah(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        relativeLayoutMs.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387813);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387748);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, ul.ah(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 12.0f);
        textView2.setText(t.ms(context, "tt_live_loading_text"));
        relativeLayoutMs.addView(textView2);
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, t.ab(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar.setId(2114387689);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ul.ah(context, 32.0f), ul.ah(context, 32.0f));
        layoutParams3.addRule(3, 2114387813);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, ul.ah(context, 32.0f), 0, 0);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(t.ah(context, "tt_live_video_loading_progress"));
        relativeLayoutMs.addView(tTProgressBar);
        relativeLayoutMs.addView(ms(context, 158, 6));
        return relativeLayoutMs;
    }
}
