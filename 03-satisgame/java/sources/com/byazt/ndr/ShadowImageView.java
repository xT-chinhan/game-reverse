package com.byazt.ndr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 2337})
public class ShadowImageView extends ImageView {
    public Paint n;
    public RectF qg;

    public ShadowImageView(Context context) {
        super(context);
        n();
    }

    private void n() {
        Paint paint = new Paint();
        this.n = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.n.setColor(Color.parseColor("#99333333"));
        this.n.setAntiAlias(true);
        this.n.setStrokeWidth(0.0f);
        this.qg = new RectF();
    }

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
