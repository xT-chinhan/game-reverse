package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.live.view.DoubleColorBallAnimationView;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends xr {
    private ImageView u;
    private DoubleColorBallAnimationView ub;
    LinearLayout zb;

    public ny(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms() {
        super.ms();
        this.u = new ImageView(this.xr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.u.setAdjustViewBounds(true);
        this.u.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.u.setLayoutParams(layoutParams);
        this.ab.addView(this.u);
        View view = new View(this.xr);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ab.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.xr);
        this.zb = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.xr);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText(t.ms(this.xr, "tt_reward_live_grant"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.ub = new DoubleColorBallAnimationView(this.xr);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ul.ah(this.xr, 60.0f), ul.ah(this.xr, 60.0f));
        layoutParams3.gravity = 17;
        this.ub.setLayoutParams(layoutParams3);
        this.zb.addView(this.ub);
        this.zb.addView(textView);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.zb.setLayoutParams(layoutParams4);
        this.ab.addView(this.zb);
        this.zb.setVisibility(8);
        String strXr = qr.xr(this.ah);
        if (TextUtils.isEmpty(strXr)) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.xr.ms(strXr).ms(this.ab.getWidth()).xr(this.ab.getHeight()).ms(this.u);
    }

    public void xr() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.ub;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.xr();
            this.zb.setVisibility(0);
        }
    }

    public void ah() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.ub;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.ah();
            this.zb.setVisibility(8);
        }
    }
}
