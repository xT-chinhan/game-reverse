package com.tapsdk.tapad.internal.ui.views.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class TrainProgressBarBackground extends View {
    public TrainProgressBarBackground(Context context) {
        super(context);
    }

    public TrainProgressBarBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TrainProgressBarBackground(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TrainProgressBarBackground(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int iMin = Math.min(((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2, ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        Path path = new Path();
        path.addCircle(width, height, iMin, Path.Direction.CW);
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        Paint paint = new Paint();
        paint.setColor(1711276032);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), paint);
    }
}
