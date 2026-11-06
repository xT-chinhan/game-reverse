package com.byazt.vry;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MDAT_POS, 1812})
public class AnimationButton extends TextView implements hw {
    public float c;
    public float hn;
    public float hw;
    public pr pr;
    public float x;

    @Override // com.byazt.vry.hw
    public float getShineValue() {
        return this.hn;
    }

    public void setShineValue(float f) {
        this.hn = f;
        postInvalidate();
    }

    @Override // com.byazt.vry.hw
    public float getRippleValue() {
        return this.hw;
    }

    public void setRippleValue(float f) {
        this.hw = f;
        postInvalidate();
    }

    @Override // com.byazt.vry.hw
    public float getMarqueeValue() {
        return this.x;
    }

    public void setMarqueeValue(float f) {
        this.x = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.c;
    }

    public void setStretchValue(float f) {
        this.c = f;
        this.pr.pr(this, f);
    }

    public AnimationButton(Context context) {
        super(context);
        this.pr = new pr();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.pr.pr(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pr.pr(this, i, i2);
    }
}
