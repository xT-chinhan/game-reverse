package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.exoplayer.i.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpView2 extends SlideUpView {
    private ImageView ah;
    private AnimatorSet c;
    private ImageView d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TextView f920ms;
    private ImageView xr;

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void ms(Context context) {
    }

    public ClickSlideUpView2(Context context) {
        super(context);
        this.c = new AnimatorSet();
        xr(context);
    }

    private void xr(Context context) {
        addView(com.bytedance.sdk.component.adexpress.ah.ms.xr(context));
        this.xr = (ImageView) findViewById(2097610751);
        this.ah = (ImageView) findViewById(2097610750);
        this.d = (ImageView) findViewById(2097610749);
        this.f920ms = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.f920ms == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f920ms.setText(str);
    }

    private void d() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(a.f);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    public float getAlphaColor() {
        return this.ka;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.d.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.ah.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.xr.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void ms() {
        d();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void xr() {
        this.c.cancel();
    }
}
