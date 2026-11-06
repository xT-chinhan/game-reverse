package com.anythink.basead.ui.guidetoclickv2.picverify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class TextSeekbar extends SeekBar {
    String a;
    RectF b;
    float c;
    Paint.FontMetrics d;
    private Paint e;
    private Paint f;

    public TextSeekbar(Context context) {
        super(context);
    }

    public TextSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextSeekbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.e = paint;
        paint.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(q.a(context, 12.0f));
        this.e.setAntiAlias(true);
        this.e.setColor(Color.parseColor("#FFFFFF"));
        this.a = getContext().getString(q.a(t.b().g(), "myoffer_g2c_seek_to_click", "string"));
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setColor(Color.parseColor("#80000000"));
        this.c = q.a(getContext(), 12.0f);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.b == null) {
            this.b = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        Paint paint = this.f;
        if (paint != null) {
            RectF rectF = this.b;
            float f = this.c;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        Paint paint2 = this.e;
        if (paint2 != null) {
            if (this.d == null) {
                this.d = paint2.getFontMetrics();
            }
            canvas.drawText(this.a, getWidth() / 2, (int) (((getHeight() / 2) - (this.d.top / 2.0f)) - (this.d.bottom / 2.0f)), this.e);
        }
        super.onDraw(canvas);
    }

    public void hideAll() {
        this.f = null;
        this.e = null;
        invalidate();
    }
}
