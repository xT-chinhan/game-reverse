package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CircleRippleView extends View {
    private boolean ab;
    private float ah;
    private int c;
    private Paint ch;
    private int d;
    private Paint hi;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f916ms;
    private List<Integer> ny;
    private float sl;
    private int u;
    private List<Integer> x;
    private int xr;
    private float zb;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f916ms = -1;
        this.xr = SupportMenu.CATEGORY_MASK;
        this.ah = 18.0f;
        this.d = 3;
        this.ka = 50.0f;
        this.c = 2;
        this.ab = false;
        this.x = new ArrayList();
        this.ny = new ArrayList();
        this.u = 24;
        ah();
    }

    private void ah() {
        Paint paint = new Paint();
        this.ch = paint;
        paint.setAntiAlias(true);
        this.ch.setStrokeWidth(this.u);
        this.x.add(255);
        this.ny.add(0);
        Paint paint2 = new Paint();
        this.hi = paint2;
        paint2.setAntiAlias(true);
        this.hi.setColor(Color.parseColor("#0FFFFFFF"));
        this.hi.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.sl = f;
        this.zb = i2 / 2.0f;
        float f2 = f - (this.u / 2.0f);
        this.ka = f2;
        this.ah = f2 / 4.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.ch.setShader(new LinearGradient(this.sl, 0.0f, this.zb, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.x.size()) {
                break;
            }
            Integer num = this.x.get(i);
            this.ch.setAlpha(num.intValue());
            Integer num2 = this.ny.get(i);
            if (this.ah + num2.intValue() < this.ka) {
                canvas.drawCircle(this.sl, this.zb, this.ah + num2.intValue(), this.ch);
            }
            if (num.intValue() > 0 && num2.intValue() < this.ka) {
                this.x.set(i, Integer.valueOf(num.intValue() - this.c > 0 ? num.intValue() - (this.c * 3) : 1));
                this.ny.set(i, Integer.valueOf(num2.intValue() + this.c));
            }
            i++;
        }
        List<Integer> list = this.ny;
        if (list.get(list.size() - 1).intValue() >= this.ka / this.d) {
            this.x.add(255);
            this.ny.add(0);
        }
        if (this.ny.size() >= 3) {
            this.ny.remove(0);
            this.x.remove(0);
        }
        this.ch.setAlpha(255);
        this.ch.setColor(this.xr);
        canvas.drawCircle(this.sl, this.zb, this.ah, this.hi);
        if (this.ab) {
            invalidate();
        }
    }

    public void ms() {
        this.ab = true;
        invalidate();
    }

    public void xr() {
        this.ab = false;
        this.ny.clear();
        this.x.clear();
        this.x.add(255);
        this.ny.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.f916ms = i;
    }

    public void setCoreColor(int i) {
        this.xr = i;
    }

    public void setCoreRadius(int i) {
        this.ah = i;
    }

    public void setDiffuseWidth(int i) {
        this.d = i;
    }

    public void setMaxWidth(int i) {
        this.ka = i;
    }

    public void setDiffuseSpeed(int i) {
        this.c = i;
    }
}
