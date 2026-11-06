package com.byazt.ndr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 1899})
public class ShadowTextView extends TextView {
    public Paint n;
    public RectF qg;
    public int s;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = 0;
        n();
    }

    private void n() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.n = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.n.setColor(Color.parseColor("#99333333"));
        this.n.setAntiAlias(true);
        this.n.setStrokeWidth(0.0f);
        this.qg = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int iMeasureText = (int) getPaint().measureText("00");
            this.s = iMeasureText;
            if (measuredWidth < iMeasureText) {
                measuredWidth = iMeasureText;
            }
            int i3 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i3, measuredHeight);
            this.qg.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.qg.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.qg;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.qg.bottom / 2.0f, this.n);
        canvas.translate((this.qg.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
