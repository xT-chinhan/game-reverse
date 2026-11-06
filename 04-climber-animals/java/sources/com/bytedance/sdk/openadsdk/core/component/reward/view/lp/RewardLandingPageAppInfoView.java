package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.c;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class RewardLandingPageAppInfoView extends LinearLayout {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private DownloadItemView f2267ms;

    public RewardLandingPageAppInfoView(Context context) {
        super(context);
    }

    public void ms(lm lmVar, String str) {
        if (lmVar == null) {
            return;
        }
        setBackgroundColor(-1);
        setOrientation(1);
        Context context = getContext();
        ms(lmVar);
        c cVarPh = lmVar.ph();
        if (cVarPh == null) {
            return;
        }
        int iAh = ul.ah(context, 12.0f);
        View viewMs = ms(context, cVarPh);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = iAh;
        addView(viewMs, layoutParams);
        View viewMs2 = ms(context, lmVar, cVarPh, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = iAh;
        addView(viewMs2, layoutParams2);
        int iAh2 = ul.ah(context, 16.0f);
        setPadding(iAh2, iAh, iAh2, iAh);
    }

    private void ms(lm lmVar) {
        DownloadItemView downloadItemView = new DownloadItemView(getContext());
        this.f2267ms = downloadItemView;
        downloadItemView.ms(lmVar);
        addView(this.f2267ms);
    }

    private View ms(Context context, c cVar) {
        TextView textView = new TextView(context);
        textView.setText(cVar.ab());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        return textView;
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        DownloadItemView downloadItemView = this.f2267ms;
        if (downloadItemView == null || onClickListener == null) {
            return;
        }
        downloadItemView.setOnClickListener(onClickListener);
    }

    private View ms(final Context context, final lm lmVar, c cVar, final String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText(String.format("版本号：%s", cVar.ka()));
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int id = -1;
        layoutParams.addRule(9, -1);
        textView.setId(View.generateViewId());
        relativeLayout.addView(textView, layoutParams);
        if (!TextUtils.isEmpty(cVar.hi())) {
            View viewMs = ms(context, relativeLayout);
            id = ms(context, relativeLayout, viewMs.getId()).getId();
            viewMs.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.core.jw.c.ms(lmVar, context, str);
                }
            });
        }
        View viewXr = xr(context, relativeLayout, id);
        viewXr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.jw.c.xr(lmVar, context, str);
            }
        });
        View viewD = d(context, relativeLayout, ms(context, relativeLayout, viewXr.getId()).getId());
        viewD.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.jw.c.ah(lmVar, context, str);
            }
        });
        ah(context, relativeLayout, ms(context, relativeLayout, viewD.getId()).getId()).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.jw.c.ms(context, lmVar, str);
            }
        });
        return relativeLayout;
    }

    private View ms(Context context, RelativeLayout relativeLayout, int i) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#22000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ul.ah(context, 1.5f), ul.ah(context, 8.0f));
        layoutParams.rightMargin = ul.ah(context, 6.0f);
        view.setId(View.generateViewId());
        layoutParams.addRule(0, i);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    private View ms(Context context, RelativeLayout relativeLayout) {
        TextView textView = new TextView(context);
        textView.setText("备案");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        relativeLayout.addView(textView, layoutParams);
        int iAh = ul.ah(context, 6.0f);
        ul.ms(textView, iAh, iAh, 0, 0);
        return textView;
    }

    private View xr(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("隐私");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == -1) {
            layoutParams.addRule(11, -1);
        } else {
            layoutParams.addRule(0, i);
            layoutParams.rightMargin = ul.ah(context, 6.0f);
        }
        relativeLayout.addView(textView, layoutParams);
        int iAh = ul.ah(context, 6.0f);
        ul.ms(textView, iAh, iAh, 0, 0);
        return textView;
    }

    private View ah(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("功能");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i);
        layoutParams.rightMargin = ul.ah(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iAh = ul.ah(context, 6.0f);
        ul.ms(textView, iAh, iAh, 0, 0);
        return textView;
    }

    private View d(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("权限");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        textView.setId(View.generateViewId());
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i);
        layoutParams.rightMargin = ul.ah(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iAh = ul.ah(context, 6.0f);
        ul.ms(textView, iAh, iAh, 0, 0);
        return textView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }
}
