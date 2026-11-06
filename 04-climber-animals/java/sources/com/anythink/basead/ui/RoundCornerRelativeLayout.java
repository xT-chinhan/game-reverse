package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class RoundCornerRelativeLayout extends RelativeLayout {
    private Path a;
    private Paint b;
    private RectF c;
    private float[] d;

    public RoundCornerRelativeLayout(Context context) {
        super(context);
        this.d = new float[8];
        a();
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new float[8];
        a();
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new float[8];
        a();
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = new float[8];
        a();
    }

    private void a() {
        float fA = q.a(getContext(), 12.0f);
        setRadius(fA, fA, fA, fA);
        this.a = new Path();
        this.b = new Paint(1);
        this.c = new RectF();
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void setRadius(int i) {
        float fA = q.a(getContext(), i);
        setRadius(fA, fA, fA, fA);
    }

    public void setRadius(float f, float f2, float f3, float f4) {
        float[] fArr = this.d;
        fArr[1] = f;
        fArr[0] = f;
        fArr[3] = f2;
        fArr[2] = f2;
        fArr[5] = f3;
        fArr[4] = f3;
        fArr[7] = f4;
        fArr[6] = f4;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        this.a.reset();
        this.a.addRoundRect(this.c, this.d, Path.Direction.CW);
        canvas.clipPath(this.a);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private Path b() {
        this.a.reset();
        this.a.addRoundRect(this.c, this.d, Path.Direction.CW);
        return this.a;
    }
}
