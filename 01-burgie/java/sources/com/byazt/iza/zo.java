package com.byazt.iza;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 124, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements fw {
    public float c;
    public float hn;
    public float hw;
    public View pr;
    public float uc;
    public float x;

    public zo(View view) {
        this.pr = view;
    }

    public void pr(float f) {
        View view = this.pr;
        if (view == null) {
            return;
        }
        this.hw = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float pr() {
        return this.hw;
    }

    public void hw(float f) {
        View view = this.pr;
        if (view == null) {
            return;
        }
        this.hn = f;
        view.postInvalidate();
    }

    @Override // com.byazt.iza.fw
    public float getRipple() {
        return this.hn;
    }

    public void hn(float f) {
        View view = this.pr;
        if (view == null) {
            return;
        }
        this.x = f;
        view.postInvalidate();
    }

    @Override // com.byazt.iza.fw
    public float getShine() {
        return this.x;
    }

    public void x(float f) {
        this.c = f;
        this.pr.postInvalidate();
    }

    @Override // com.byazt.iza.fw
    public float getStretch() {
        return this.c;
    }

    public void c(float f) {
        this.uc = f;
        this.pr.postInvalidate();
    }

    @Override // com.byazt.iza.fw
    public float getRubIn() {
        return this.uc;
    }

    public void pr(int i) {
        View view = this.pr;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
