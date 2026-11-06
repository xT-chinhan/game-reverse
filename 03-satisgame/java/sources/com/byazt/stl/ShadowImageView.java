package com.byazt.stl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2337})
public class ShadowImageView extends ImageView {
    public Paint n;
    public RectF qg;

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.qg.right == getMeasuredWidth() && this.qg.bottom == getMeasuredHeight()) {
            return;
        }
        this.qg.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.qg;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.qg.bottom / 2.0f, this.n);
        super.onDraw(canvas);
    }
}
