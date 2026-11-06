package com.tapsdk.tapad.internal.ui.views.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class TrainProgressBar extends View {
    private Paint a;
    private Paint b;
    private int c;

    public TrainProgressBar(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new Paint();
        this.c = 10;
        a();
    }

    public TrainProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = new Paint();
        this.c = 10;
        a();
    }

    public TrainProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = new Paint();
        this.c = 10;
        a();
    }

    public TrainProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = new Paint();
        this.b = new Paint();
        this.c = 10;
        a();
    }

    private void a() {
        this.b.setColor(1711276032);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setAntiAlias(true);
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int iMin = Math.min(width, height);
        canvas.drawArc(width - iMin, height - iMin, width + iMin, height + iMin, 0.0f, (int) (((100 - this.c) / 100.0f) * 360.0f), true, this.b);
    }

    public void setProgress(int i) {
        this.c = Math.max(5, i);
        invalidate();
    }
}
