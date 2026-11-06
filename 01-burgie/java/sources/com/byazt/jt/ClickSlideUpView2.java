package com.byazt.jt;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.uz.hw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1566})
public class ClickSlideUpView2 extends SlideUpView {
    public int c;
    public ImageView hn;
    public ImageView hw;
    public TextView pr;
    public AnimatorSet uc;
    public ImageView x;

    public ClickSlideUpView2(Context context) {
        super(context);
        this.uc = new AnimatorSet();
        hw(context);
    }

    @Override // com.byazt.jt.SlideUpView
    public void pr(Context context) {
    }

    private void hw(Context context) {
        addView(hw.hw(context));
        this.hw = (ImageView) findViewById(2097610751);
        this.hn = (ImageView) findViewById(2097610750);
        this.x = (ImageView) findViewById(2097610749);
        this.pr = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.pr != null && !TextUtils.isEmpty(str)) {
            this.pr.setText(str);
        }
    }

    private void x() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    public float getAlphaColor() {
        return this.c;
    }

    public void setAlphaColor(int i) {
        if (i >= 0 && i <= 60) {
            int i2 = i + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
            this.x.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
            int i3 = ((i + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
            this.hn.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
            int i4 = ((i + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
            this.hw.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // com.byazt.jt.SlideUpView
    public void pr() {
        x();
    }

    @Override // com.byazt.jt.SlideUpView
    public void hw() {
        this.uc.cancel();
    }
}
