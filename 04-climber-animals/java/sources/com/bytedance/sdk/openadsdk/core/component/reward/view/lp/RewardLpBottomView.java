package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;

/* JADX INFO: loaded from: classes2.dex */
public class RewardLpBottomView extends LinearLayout {
    private RewardLandingPageAppInfoView ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f2272ms;
    private SlideUpLoadMoreArrow xr;

    public RewardLpBottomView(Context context) {
        super(context);
        this.f2272ms = false;
    }

    public void ms(lm lmVar, String str) {
        if (lmVar == null) {
            return;
        }
        this.f2272ms = ms(lmVar);
        ah();
        if (!t.ah(lmVar)) {
            xr(lmVar, str);
        }
        setOrientation(1);
        setVisibility(8);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -2013265920}));
    }

    private void ah() {
        this.xr = new SlideUpLoadMoreArrow(getContext(), this.f2272ms ? 12 : 48, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.xr, layoutParams);
    }

    private boolean ms(lm lmVar) {
        return lmVar.jr() == 4;
    }

    public void ms() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.xr;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.ms();
        }
        d();
    }

    public void xr() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow;
        if (getVisibility() == 0 && (slideUpLoadMoreArrow = this.xr) != null) {
            slideUpLoadMoreArrow.xr();
            this.xr.setVisibility(8);
        }
    }

    private void xr(lm lmVar, String str) {
        if (this.f2272ms) {
            RewardLandingPageAppInfoView rewardLandingPageAppInfoView = new RewardLandingPageAppInfoView(getContext());
            this.ah = rewardLandingPageAppInfoView;
            rewardLandingPageAppInfoView.ms(lmVar, str);
            addView(this.ah, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void d() {
        if (this.ah == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RewardLpBottomView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RewardLpBottomView.this.ah == null) {
                    return;
                }
                int measuredHeight = RewardLpBottomView.this.ah.getMeasuredHeight();
                View viewFindViewById = RewardLpBottomView.this.getRootView().findViewById(2114387664);
                if (viewFindViewById == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = measuredHeight;
                    viewFindViewById.setLayoutParams(layoutParams2);
                }
            }
        });
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = this.ah;
        if (rewardLandingPageAppInfoView == null || onClickListener == null) {
            return;
        }
        rewardLandingPageAppInfoView.setDownLoadClickListener(onClickListener);
    }
}
