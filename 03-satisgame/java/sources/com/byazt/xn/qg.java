package com.byazt.xn;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, 26})
public class qg extends Drawable {
    public Paint n;
    public int qg;

    public qg(int i) {
        this.qg = i;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setFilterBitmap(true);
    }

    public void n(int i) {
        this.n.setColor(i);
    }

    public void n(float f) {
        this.n.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.qg) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.qg) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fCenterX = getBounds().centerX();
        float fCenterY = getBounds().centerY();
        float f = ((this.qg / 2.0f) * 3.0f) / 4.0f;
        float f2 = fCenterX - f;
        float f3 = fCenterY - f;
        float f4 = fCenterX + f;
        float f5 = fCenterY + f;
        canvas.drawLine(f2, f3, f4, f5, this.n);
        canvas.drawLine(f4, f3, f2, f5, this.n);
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
