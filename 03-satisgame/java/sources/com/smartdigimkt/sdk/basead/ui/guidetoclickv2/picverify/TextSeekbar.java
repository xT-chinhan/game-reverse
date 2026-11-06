package com.smartdigimkt.sdk.basead.ui.guidetoclickv2.picverify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public class TextSeekbar extends SeekBar {
    public Paint a;
    public final String b;
    public Paint c;
    public RectF d;
    public final float e;
    public Paint.FontMetrics f;

    public TextSeekbar(Context context) {
        super(context);
    }

    public void hideAll() {
        this.c = null;
        this.a = null;
        invalidate();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.d == null) {
            this.d = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        Paint paint = this.c;
        if (paint != null) {
            RectF rectF = this.d;
            float f = this.e;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        Paint paint2 = this.a;
        if (paint2 != null) {
            if (this.f == null) {
                this.f = paint2.getFontMetrics();
            }
            Paint.FontMetrics fontMetrics = this.f;
            canvas.drawText(this.b, getWidth() / 2, (int) (((getHeight() / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.a);
        }
        super.onDraw(canvas);
    }

    public TextSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextSeekbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.a = paint;
        paint.setTextAlign(Paint.Align.CENTER);
        this.a.setTextSize(k.a(context, 12.0f));
        this.a.setAntiAlias(true);
        this.a.setColor(Color.parseColor("#FFFFFF"));
        this.b = getContext().getString(k.a(SDKContext.getInstance().d(), "myoffer_g2c_seek_to_click", "string"));
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setColor(Color.parseColor("#80000000"));
        this.e = k.a(getContext(), 12.0f);
    }
}
