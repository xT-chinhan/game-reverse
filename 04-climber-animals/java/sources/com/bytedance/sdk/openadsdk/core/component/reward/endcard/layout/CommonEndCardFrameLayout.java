package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.xr.xr;
import com.bytedance.sdk.openadsdk.res.ka;

/* JADX INFO: loaded from: classes2.dex */
public class CommonEndCardFrameLayout extends AbstractEndCardFrameLayout {
    private SSWebView ah;
    private RewardLpBottomView c;
    private SSWebView d;
    private FrameLayout ka;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(xr xrVar) {
    }

    public CommonEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    void ms() {
        setId(2114387548);
        if (!TextUtils.isEmpty(qr.x(this.xr))) {
            SSWebView sSWebView = new SSWebView(this.f2171ms);
            sSWebView.setMaterialMeta(pc.ms(this.xr));
            sSWebView.setId(2114387703);
            sSWebView.setLayerType(2, null);
            sSWebView.setVisibility(4);
            this.ah = sSWebView;
            addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        }
        LinearLayout linearLayout = new LinearLayout(this.f2171ms);
        linearLayout.setId(2114387547);
        linearLayout.setOrientation(1);
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.f2171ms);
        playableEndcardFrameLayout.setId(2114387681);
        SSWebView sSWebView2 = new SSWebView(this.f2171ms);
        sSWebView2.setMaterialMeta(pc.ms(this.xr));
        sSWebView2.setId(2114387865);
        sSWebView2.setLayerType(2, null);
        sSWebView2.setVisibility(4);
        this.d = sSWebView2;
        playableEndcardFrameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this.f2171ms);
        frameLayout.setId(2114387925);
        frameLayout.setVisibility(8);
        playableEndcardFrameLayout.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayoutXr = ka.xr(this.f2171ms);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2236963, -1});
        gradientDrawable.setShape(0);
        linearLayoutXr.setBackground(gradientDrawable);
        playableEndcardFrameLayout.addView(linearLayoutXr, new FrameLayout.LayoutParams(-1, -1));
        RewardLpBottomView rewardLpBottomView = new RewardLpBottomView(this.f2171ms);
        rewardLpBottomView.setId(2114387830);
        rewardLpBottomView.setVisibility(8);
        this.c = rewardLpBottomView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        playableEndcardFrameLayout.addView(rewardLpBottomView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(playableEndcardFrameLayout, layoutParams2);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.f2171ms);
        frameLayout2.setId(2114387804);
        frameLayout2.setBackgroundColor(0);
        frameLayout2.setVisibility(8);
        addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.ka = frameLayout2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void xr() {
        super.xr();
        RewardLpBottomView rewardLpBottomView = this.c;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.xr();
        }
    }
}
