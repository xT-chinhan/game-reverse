package com.byazt.sdv;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 13})
public class hw extends Drawable {
    public int hw;
    public Paint pr;

    public hw(int i) {
        this.hw = i;
        Paint paint = new Paint();
        this.pr = paint;
        paint.setAntiAlias(true);
        this.pr.setFilterBitmap(true);
    }

    public void pr(int i) {
        this.pr.setColor(i);
    }

    public void pr(float f) {
        this.pr.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.hw) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.hw) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fCenterX = getBounds().centerX();
        float fCenterY = getBounds().centerY();
        float f = ((this.hw / 2.0f) * 3.0f) / 4.0f;
        float f2 = fCenterX - f;
        float f3 = fCenterY - f;
        float f4 = fCenterX + f;
        float f5 = fCenterY + f;
        canvas.drawLine(f2, f3, f4, f5, this.pr);
        canvas.drawLine(f4, f3, f2, f5, this.pr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pr.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pr.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pr.getAlpha();
    }
}
