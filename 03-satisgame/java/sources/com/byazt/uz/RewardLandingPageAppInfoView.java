package com.byazt.uz;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.cp.n;
import com.byazt.gct.pk;
import com.byazt.gct.w;
import com.byazt.okk.s;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 748, 2435})
public class RewardLandingPageAppInfoView extends LinearLayout {
    public DownloadItemView n;

    public RewardLandingPageAppInfoView(Context context) {
        super(context);
    }

    public void n(pk pkVar, String str) {
        if (pkVar == null) {
            return;
        }
        setBackgroundColor(-1);
        setOrientation(1);
        Context context = getContext();
        n(pkVar);
        w wVarCd = pkVar.cd();
        if (wVarCd == null) {
            return;
        }
        int iS = s.s(context, 12.0f);
        View viewN = n(context, wVarCd);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = iS;
        addView(viewN, layoutParams);
        View viewN2 = n(context, pkVar, wVarCd, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = iS;
        addView(viewN2, layoutParams2);
        int iS2 = s.s(context, 16.0f);
        setPadding(iS2, iS, iS2, iS);
    }

    private void n(pk pkVar) {
        DownloadItemView downloadItemView = new DownloadItemView(getContext());
        this.n = downloadItemView;
        downloadItemView.n(pkVar);
        addView(this.n);
    }

    private View n(Context context, w wVar) {
        TextView textView = new TextView(context);
        textView.setText(wVar.x());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        return textView;
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        DownloadItemView downloadItemView = this.n;
        if (downloadItemView == null || onClickListener == null) {
            return;
        }
        downloadItemView.setOnClickListener(onClickListener);
    }

    private View n(final Context context, final pk pkVar, w wVar, final String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText(String.format("版本号：%s", wVar.l()));
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
        if (!TextUtils.isEmpty(wVar.cp())) {
            View viewN = n(context, relativeLayout);
            id = n(context, relativeLayout, viewN.getId()).getId();
            viewN.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.uz.RewardLandingPageAppInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.byazt.okk.n.n(pkVar, context, str);
                }
            });
        }
        View viewQg = qg(context, relativeLayout, id);
        viewQg.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.uz.RewardLandingPageAppInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.byazt.okk.n.qg(pkVar, context, str);
            }
        });
        View viewQ = q(context, relativeLayout, n(context, relativeLayout, viewQg.getId()).getId());
        viewQ.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.uz.RewardLandingPageAppInfoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.byazt.okk.n.s(pkVar, context, str);
            }
        });
        s(context, relativeLayout, n(context, relativeLayout, viewQ.getId()).getId()).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.uz.RewardLandingPageAppInfoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.byazt.okk.n.n(context, pkVar, str);
            }
        });
        return relativeLayout;
    }

    private View n(Context context, RelativeLayout relativeLayout, int i) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#22000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(s.s(context, 1.5f), s.s(context, 8.0f));
        layoutParams.rightMargin = s.s(context, 6.0f);
        view.setId(View.generateViewId());
        layoutParams.addRule(0, i);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    private View n(Context context, RelativeLayout relativeLayout) {
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
        int iS = s.s(context, 6.0f);
        s.n(textView, iS, iS, 0, 0);
        return textView;
    }

    private View qg(Context context, RelativeLayout relativeLayout, int i) {
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
            layoutParams.rightMargin = s.s(context, 6.0f);
        }
        relativeLayout.addView(textView, layoutParams);
        int iS = s.s(context, 6.0f);
        s.n(textView, iS, iS, 0, 0);
        return textView;
    }

    private View s(Context context, RelativeLayout relativeLayout, int i) {
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
        layoutParams.rightMargin = s.s(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iS = s.s(context, 6.0f);
        s.n(textView, iS, iS, 0, 0);
        return textView;
    }

    private View q(Context context, RelativeLayout relativeLayout, int i) {
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
        layoutParams.rightMargin = s.s(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iS = s.s(context, 6.0f);
        s.n(textView, iS, iS, 0, 0);
        return textView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }
}
