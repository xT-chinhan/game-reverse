package com.byazt.mr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 1756})
public class DislikeView extends View {
    public int fs;
    public Paint l;
    public int n;
    public Paint q;
    public int qg;
    public RectF s;
    public int w;
    public Paint x;

    public void setRadius(int i) {
        this.w = i;
    }

    public void setDislikeColor(int i) {
        this.x.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.x.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.q.setStyle(Paint.Style.STROKE);
        this.q.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.q.setStrokeWidth(i);
        this.fs = i;
    }

    public void setBgColor(int i) {
        this.l.setStyle(Paint.Style.FILL);
        this.l.setColor(i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.s;
        int i = this.w;
        canvas.drawRoundRect(rectF, i, i, this.l);
        RectF rectF2 = this.s;
        int i2 = this.w;
        canvas.drawRoundRect(rectF2, i2, i2, this.q);
        int i3 = this.n;
        int i4 = this.qg;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.x);
        int i5 = this.n;
        int i6 = this.qg;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.x);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.n = i;
        this.qg = i2;
        int i5 = this.fs;
        this.s = new RectF(i5, i5, this.n - i5, this.qg - i5);
    }
}
