package com.byazt.uz;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.byazt.cp.n;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.xk.SlideUpLoadMoreArrow;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 748, 1361})
public class RewardLpBottomView extends LinearLayout {
    public boolean n;
    public SlideUpLoadMoreArrow qg;
    public RewardLandingPageAppInfoView s;

    public RewardLpBottomView(Context context) {
        super(context);
        this.n = false;
    }

    public void n(pk pkVar, String str) {
        if (pkVar == null) {
            return;
        }
        this.n = n(pkVar);
        s();
        if (!cd.s(pkVar)) {
            qg(pkVar, str);
        }
        setOrientation(1);
        setVisibility(8);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -2013265920}));
    }

    private void s() {
        this.qg = new SlideUpLoadMoreArrow(getContext(), this.n ? 12 : 48, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.qg, layoutParams);
    }

    private boolean n(pk pkVar) {
        return pkVar.rv() == 4;
    }

    public void n() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.qg;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.n();
        }
        q();
    }

    public void qg() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow;
        if (getVisibility() == 0 && (slideUpLoadMoreArrow = this.qg) != null) {
            slideUpLoadMoreArrow.qg();
            this.qg.setVisibility(8);
        }
    }

    private void qg(pk pkVar, String str) {
        if (this.n) {
            RewardLandingPageAppInfoView rewardLandingPageAppInfoView = new RewardLandingPageAppInfoView(getContext());
            this.s = rewardLandingPageAppInfoView;
            rewardLandingPageAppInfoView.n(pkVar, str);
            addView(this.s, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void q() {
        if (this.s == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.uz.RewardLpBottomView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RewardLpBottomView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RewardLpBottomView.this.s == null) {
                    return;
                }
                int measuredHeight = RewardLpBottomView.this.s.getMeasuredHeight();
                View viewFindViewById = RewardLpBottomView.this.getRootView().findViewById(2114387658);
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
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = this.s;
        if (rewardLandingPageAppInfoView == null || onClickListener == null) {
            return;
        }
        rewardLandingPageAppInfoView.setDownLoadClickListener(onClickListener);
    }
}
