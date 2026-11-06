package com.byazt.jt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1489})
public class CircleRippleView extends View {
    public List<Integer> aj;
    public float c;
    public boolean fw;
    public int g;
    public float hn;
    public int hw;
    public float k;
    public float m;
    public int pr;
    public int uc;
    public Paint vk;
    public Paint w;
    public int x;
    public List<Integer> zo;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pr = -1;
        this.hw = SupportMenu.CATEGORY_MASK;
        this.hn = 18.0f;
        this.x = 3;
        this.c = 50.0f;
        this.uc = 2;
        this.fw = false;
        this.zo = new ArrayList();
        this.aj = new ArrayList();
        this.g = 24;
        hn();
    }

    private void hn() {
        Paint paint = new Paint();
        this.vk = paint;
        paint.setAntiAlias(true);
        this.vk.setStrokeWidth(this.g);
        this.zo.add(255);
        this.aj.add(0);
        Paint paint2 = new Paint();
        this.w = paint2;
        paint2.setAntiAlias(true);
        this.w.setColor(Color.parseColor("#0FFFFFFF"));
        this.w.setStyle(Paint.Style.FILL);
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
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.k = f;
        this.m = i2 / 2.0f;
        float f2 = f - (this.g / 2.0f);
        this.c = f2;
        this.hn = f2 / 4.0f;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.vk.setShader(new LinearGradient(this.k, 0.0f, this.m, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.zo.size()) {
                break;
            }
            Integer num = this.zo.get(i);
            this.vk.setAlpha(num.intValue());
            Integer num2 = this.aj.get(i);
            if (this.hn + num2.intValue() < this.c) {
                canvas.drawCircle(this.k, this.m, this.hn + num2.intValue(), this.vk);
            }
            if (num.intValue() > 0 && num2.intValue() < this.c) {
                this.zo.set(i, Integer.valueOf(num.intValue() - this.uc > 0 ? num.intValue() - (this.uc * 3) : 1));
                this.aj.set(i, Integer.valueOf(num2.intValue() + this.uc));
            }
            i++;
        }
        List<Integer> list = this.aj;
        if (list.get(list.size() - 1).intValue() >= this.c / this.x) {
            this.zo.add(255);
            this.aj.add(0);
        }
        if (this.aj.size() >= 3) {
            this.aj.remove(0);
            this.zo.remove(0);
        }
        this.vk.setAlpha(255);
        this.vk.setColor(this.hw);
        canvas.drawCircle(this.k, this.m, this.hn, this.w);
        if (this.fw) {
            invalidate();
        }
    }

    public void pr() {
        this.fw = true;
        invalidate();
    }

    public void hw() {
        this.fw = false;
        this.aj.clear();
        this.zo.clear();
        this.zo.add(255);
        this.aj.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.pr = i;
    }

    public void setCoreColor(int i) {
        this.hw = i;
    }

    public void setCoreRadius(int i) {
        this.hn = i;
    }

    public void setDiffuseWidth(int i) {
        this.x = i;
    }

    public void setMaxWidth(int i) {
        this.c = i;
    }

    public void setDiffuseSpeed(int i) {
        this.uc = i;
    }
}
