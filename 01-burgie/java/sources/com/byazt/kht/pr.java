package com.byazt.kht;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1298, 37})
public class pr extends Drawable {
    public final Path hn;
    public final Path hw;
    public final Paint pr;
    public final Path x;
    public float c = 1.0f;
    public float uc = 1.0f;

    public pr() {
        Paint paint = new Paint(1);
        this.pr = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        Path path = new Path();
        this.hw = path;
        Path path2 = new Path();
        this.hn = path2;
        Path path3 = new Path();
        this.x = path3;
        path.addRoundRect(new RectF(3.334f, 12.0f, 12.6673f, 13.3333f), 0.6667f, 0.6667f, Path.Direction.CW);
        path2.setFillType(Path.FillType.EVEN_ODD);
        path2.moveTo(3.534f, 6.1994f);
        path2.cubicTo(3.2673f, 6.4652f, 3.2673f, 6.8962f, 3.534f, 7.1621f);
        path2.lineTo(7.4893f, 11.1046f);
        path2.cubicTo(7.4982f, 11.1147f, 7.5075f, 11.1245f, 7.5171f, 11.1341f);
        path2.cubicTo(7.7838f, 11.3999f, 8.2162f, 11.3999f, 8.4829f, 11.1341f);
        path2.lineTo(12.4676f, 7.1622f);
        path2.cubicTo(12.7343f, 6.8964f, 12.7343f, 6.4654f, 12.4676f, 6.1995f);
        path2.cubicTo(12.2009f, 5.9337f, 11.7685f, 5.9337f, 11.5018f, 6.1995f);
        path2.lineTo(8.0009f, 9.6892f);
        path2.lineTo(4.4998f, 6.1994f);
        path2.cubicTo(4.2331f, 5.9335f, 3.8007f, 5.9335f, 3.534f, 6.1994f);
        path2.close();
        path3.addRoundRect(new RectF(7.334f, 2.0f, 8.6673f, 10.6667f), 0.6667f, 0.6667f, Path.Direction.CW);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect != null) {
            this.c = rect.width() / 16.0f;
            this.uc = rect.height() / 16.0f;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.scale(this.c, this.uc);
        canvas.drawPath(this.hw, this.pr);
        canvas.drawPath(this.hn, this.pr);
        canvas.drawPath(this.x, this.pr);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pr.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pr.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
