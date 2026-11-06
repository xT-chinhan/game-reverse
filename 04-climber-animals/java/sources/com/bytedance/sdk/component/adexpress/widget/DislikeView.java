package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class DislikeView extends View {
    private Paint ab;
    private final RectF ah;
    private int c;
    private Paint d;
    private Paint ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f921ms;
    private int x;
    private int xr;

    public DislikeView(Context context) {
        super(context);
        this.ah = new RectF();
        ms();
    }

    private void ms() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.ab = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.ka = paint3;
        paint3.setAntiAlias(true);
    }

    public void setRadius(int i) {
        this.c = i;
    }

    public void setDislikeColor(int i) {
        this.ab.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.ab.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.d.setStrokeWidth(i);
        this.x = i;
    }

    public void setBgColor(int i) {
        this.ka.setStyle(Paint.Style.FILL);
        this.ka.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.ah;
        int i = this.c;
        canvas.drawRoundRect(rectF, i, i, this.ka);
        RectF rectF2 = this.ah;
        int i2 = this.c;
        canvas.drawRoundRect(rectF2, i2, i2, this.d);
        int i3 = this.f921ms;
        int i4 = this.xr;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.ab);
        int i5 = this.f921ms;
        int i6 = this.xr;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.ab);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f921ms = i;
        this.xr = i2;
        RectF rectF = this.ah;
        int i5 = this.x;
        rectF.set(i5, i5, i - i5, i2 - i5);
    }
}
