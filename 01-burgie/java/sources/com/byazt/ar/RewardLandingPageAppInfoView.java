package com.byazt.ar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.hg.of;
import com.byazt.hg.uc;
import com.byazt.vzx.pr;
import com.byazt.wt.c;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_PATH_INFO, 2249})
public class RewardLandingPageAppInfoView extends LinearLayout {
    public DownloadItemView pr;

    public RewardLandingPageAppInfoView(Context context) {
        super(context);
    }

    public void pr(of ofVar, String str) {
        if (ofVar == null) {
            return;
        }
        setBackgroundColor(-1);
        setOrientation(1);
        Context context = getContext();
        pr(ofVar);
        uc ucVarLb = ofVar.lb();
        if (ucVarLb == null) {
            return;
        }
        int iHn = er.hn(context, 12.0f);
        View viewPr = pr(context, ucVarLb);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = iHn;
        addView(viewPr, layoutParams);
        View viewPr2 = pr(context, ofVar, ucVarLb, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = iHn;
        addView(viewPr2, layoutParams2);
        int iHn2 = er.hn(context, 16.0f);
        setPadding(iHn2, iHn, iHn2, iHn);
    }

    private void pr(of ofVar) {
        DownloadItemView downloadItemView = new DownloadItemView(getContext());
        this.pr = downloadItemView;
        downloadItemView.pr(ofVar);
        addView(this.pr);
    }

    private View pr(Context context, uc ucVar) {
        TextView textView = new TextView(context);
        textView.setText(ucVar.fw());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        return textView;
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        DownloadItemView downloadItemView = this.pr;
        if (downloadItemView != null && onClickListener != null) {
            downloadItemView.setOnClickListener(onClickListener);
        }
    }

    private View pr(final Context context, final of ofVar, uc ucVar, final String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText(String.format("版本号：%s", ucVar.c()));
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
        if (!TextUtils.isEmpty(ucVar.w())) {
            View viewPr = pr(context, relativeLayout);
            id = pr(context, relativeLayout, viewPr.getId()).getId();
            viewPr.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ar.RewardLandingPageAppInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.pr(ofVar, context, str);
                }
            });
        }
        View viewHw = hw(context, relativeLayout, id);
        viewHw.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ar.RewardLandingPageAppInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.hw(ofVar, context, str);
            }
        });
        View viewX = x(context, relativeLayout, pr(context, relativeLayout, viewHw.getId()).getId());
        viewX.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ar.RewardLandingPageAppInfoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.hn(ofVar, context, str);
            }
        });
        hn(context, relativeLayout, pr(context, relativeLayout, viewX.getId()).getId()).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ar.RewardLandingPageAppInfoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.pr(context, ofVar, str);
            }
        });
        return relativeLayout;
    }

    private View pr(Context context, RelativeLayout relativeLayout, int i) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#22000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(er.hn(context, 1.5f), er.hn(context, 8.0f));
        layoutParams.rightMargin = er.hn(context, 6.0f);
        view.setId(View.generateViewId());
        layoutParams.addRule(0, i);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    private View pr(Context context, RelativeLayout relativeLayout) {
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
        int iHn = er.hn(context, 6.0f);
        er.pr(textView, iHn, iHn, 0, 0);
        return textView;
    }

    private View hw(Context context, RelativeLayout relativeLayout, int i) {
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
            layoutParams.rightMargin = er.hn(context, 6.0f);
        }
        relativeLayout.addView(textView, layoutParams);
        int iHn = er.hn(context, 6.0f);
        er.pr(textView, iHn, iHn, 0, 0);
        return textView;
    }

    private View hn(Context context, RelativeLayout relativeLayout, int i) {
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
        layoutParams.rightMargin = er.hn(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iHn = er.hn(context, 6.0f);
        er.pr(textView, iHn, iHn, 0, 0);
        return textView;
    }

    private View x(Context context, RelativeLayout relativeLayout, int i) {
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
        layoutParams.rightMargin = er.hn(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iHn = er.hn(context, 6.0f);
        er.pr(textView, iHn, iHn, 0, 0);
        return textView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }
}
