package com.byazt.xn;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, 19})
public class n extends Drawable {
    public Paint n;
    public int qg;

    public n(int i) {
        this.qg = i;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.qg) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.qg) * 1.3d);
    }

    public void n(int i) {
        this.n.setColor(i);
    }

    public void n(float f) {
        this.n.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), this.qg / 2.0f, this.n);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.n.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.n.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.n.getAlpha();
    }
}
