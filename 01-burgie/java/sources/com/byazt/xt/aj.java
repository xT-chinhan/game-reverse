package com.byazt.xt;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.tc.DoubleColorBallAnimationView;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 61})
public class aj extends hw {
    public LinearLayout g;
    public ImageView ho;
    public DoubleColorBallAnimationView nt;

    public aj(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, z);
    }

    @Override // com.byazt.xt.hw
    public void pr() {
        super.pr();
        this.ho = new ImageView(this.hw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ho.setAdjustViewBounds(true);
        this.ho.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ho.setLayoutParams(layoutParams);
        this.fw.addView(this.ho);
        View view = new View(this.hw);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fw.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.hw);
        this.g = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.hw);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText("\"奖励发放中\"");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.nt = new DoubleColorBallAnimationView(this.hw);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(er.hn(this.hw, 60.0f), er.hn(this.hw, 60.0f));
        layoutParams3.gravity = 17;
        this.nt.setLayoutParams(layoutParams3);
        this.g.addView(this.nt);
        this.g.addView(textView);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.g.setLayoutParams(layoutParams4);
        this.fw.addView(this.g);
        this.g.setVisibility(8);
        String strHw = qv.hw(this.hn);
        if (!TextUtils.isEmpty(strHw)) {
            com.byazt.ub.hw.pr(strHw).pr(this.fw.getWidth()).hw(this.fw.getHeight()).pr(this.ho);
        }
    }

    public void hw() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.nt;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.hw();
            this.g.setVisibility(0);
        }
    }

    public void hn() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.nt;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.hn();
            this.g.setVisibility(8);
        }
    }
}
