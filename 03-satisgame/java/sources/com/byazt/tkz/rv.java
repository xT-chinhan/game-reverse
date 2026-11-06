package com.byazt.tkz;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.dz.DoubleColorBallAnimationView;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends qg {
    public DoubleColorBallAnimationView cy;
    public ImageView k;
    public LinearLayout sz;

    public rv(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, z);
    }

    @Override // com.byazt.tkz.qg
    public void n() {
        super.n();
        this.k = new ImageView(this.qg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.k.setAdjustViewBounds(true);
        this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.k.setLayoutParams(layoutParams);
        this.x.addView(this.k);
        View view = new View(this.qg);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.x.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.qg);
        this.sz = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.qg);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText("\"奖励发放中\"");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.cy = new DoubleColorBallAnimationView(this.qg);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.byazt.okk.s.s(this.qg, 60.0f), com.byazt.okk.s.s(this.qg, 60.0f));
        layoutParams3.gravity = 17;
        this.cy.setLayoutParams(layoutParams3);
        this.sz.addView(this.cy);
        this.sz.addView(textView);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.sz.setLayoutParams(layoutParams4);
        this.x.addView(this.sz);
        this.sz.setVisibility(8);
        String strQg = ta.qg(this.s);
        if (TextUtils.isEmpty(strQg)) {
            return;
        }
        com.byazt.imu.s.n(strQg).n(this.x.getWidth()).qg(this.x.getHeight()).n(this.k);
    }

    public void qg() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.cy;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.qg();
            this.sz.setVisibility(0);
        }
    }

    public void s() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.cy;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.s();
            this.sz.setVisibility(8);
        }
    }
}
