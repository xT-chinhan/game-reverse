package com.byazt.stl;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.xta.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1701})
public class ClickSlideUpView2 extends SlideUpView {
    public int l;
    public TextView n;
    public ImageView q;
    public ImageView qg;
    public ImageView s;
    public AnimatorSet w;

    @Override // com.byazt.stl.SlideUpView
    public void n(Context context) {
    }

    public ClickSlideUpView2(Context context) {
        super(context);
        this.w = new AnimatorSet();
        qg(context);
    }

    private void qg(Context context) {
        addView(qg.qg(context));
        this.qg = (ImageView) findViewById(2097610751);
        this.s = (ImageView) findViewById(2097610750);
        this.q = (ImageView) findViewById(2097610749);
        this.n = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.n == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.n.setText(str);
    }

    private void q() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    public float getAlphaColor() {
        return this.l;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.q.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.s.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.qg.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.byazt.stl.SlideUpView
    public void n() {
        q();
    }

    @Override // com.byazt.stl.SlideUpView
    public void qg() {
        this.w.cancel();
    }
}
