package com.byazt.pi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 118, 1747})
public class ShadowTextView extends TextView {
    public int hn;
    public RectF hw;
    public Paint pr;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hn = 0;
        pr();
    }

    private void pr() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.pr = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.pr.setColor(Color.parseColor("#99333333"));
        this.pr.setAntiAlias(true);
        this.pr.setStrokeWidth(0.0f);
        this.hw = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.hw.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        int iMeasureText = (int) getPaint().measureText("00");
        this.hn = iMeasureText;
        if (measuredWidth < iMeasureText) {
            measuredWidth = iMeasureText;
        }
        int i3 = measuredWidth + ((measuredHeight / 2) * 2);
        setMeasuredDimension(i3, measuredHeight);
        this.hw.set(0.0f, 0.0f, i3, measuredHeight);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.hw;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.hw.bottom / 2.0f, this.pr);
        canvas.translate((this.hw.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
