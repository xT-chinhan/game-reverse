package com.byazt.ar;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.pg.SlideUpLoadMoreArrow;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_PATH_INFO, 1228})
public class RewardLpBottomView extends LinearLayout {
    public RewardLandingPageAppInfoView hn;
    public SlideUpLoadMoreArrow hw;
    public boolean pr;

    public RewardLpBottomView(Context context) {
        super(context);
        this.pr = false;
    }

    public void pr(of ofVar, String str) {
        if (ofVar == null) {
            return;
        }
        this.pr = pr(ofVar);
        hn();
        if (!lb.hn(ofVar)) {
            hw(ofVar, str);
        }
        setOrientation(1);
        setVisibility(8);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -2013265920}));
    }

    private void hn() {
        this.hw = new SlideUpLoadMoreArrow(getContext(), this.pr ? 12 : 48, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.hw, layoutParams);
    }

    private boolean pr(of ofVar) {
        return ofVar.aj() == 4;
    }

    public void pr() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.hw;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.pr();
        }
        x();
    }

    public void hw() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow;
        if (getVisibility() == 0 && (slideUpLoadMoreArrow = this.hw) != null) {
            slideUpLoadMoreArrow.hw();
            this.hw.setVisibility(8);
        }
    }

    private void hw(of ofVar, String str) {
        if (!this.pr) {
            return;
        }
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = new RewardLandingPageAppInfoView(getContext());
        this.hn = rewardLandingPageAppInfoView;
        rewardLandingPageAppInfoView.pr(ofVar, str);
        addView(this.hn, new LinearLayout.LayoutParams(-2, -2));
    }

    private void x() {
        if (this.hn == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.ar.RewardLpBottomView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RewardLpBottomView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RewardLpBottomView.this.hn != null) {
                    int measuredHeight = RewardLpBottomView.this.hn.getMeasuredHeight();
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
            }
        });
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = this.hn;
        if (rewardLandingPageAppInfoView != null && onClickListener != null) {
            rewardLandingPageAppInfoView.setDownLoadClickListener(onClickListener);
        }
    }
}
