package com.byazt.stl;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1619})
public class CircleRippleView extends View {
    public Paint cp;
    public float d;
    public List<Integer> fs;
    public float l;
    public int n;
    public float oa;
    public int q;
    public int qg;
    public List<Integer> rv;
    public float s;
    public int sz;
    public Paint tj;
    public int w;
    public boolean x;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = -1;
        this.qg = SupportMenu.CATEGORY_MASK;
        this.s = 18.0f;
        this.q = 3;
        this.l = 50.0f;
        this.w = 2;
        this.x = false;
        this.fs = new ArrayList();
        this.rv = new ArrayList();
        this.sz = 24;
        s();
    }

    private void s() {
        Paint paint = new Paint();
        this.tj = paint;
        paint.setAntiAlias(true);
        this.tj.setStrokeWidth(this.sz);
        this.fs.add(255);
        this.rv.add(0);
        Paint paint2 = new Paint();
        this.cp = paint2;
        paint2.setAntiAlias(true);
        this.cp.setColor(Color.parseColor("#0FFFFFFF"));
        this.cp.setStyle(Paint.Style.FILL);
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
        this.d = f;
        this.oa = i2 / 2.0f;
        float f2 = f - (this.sz / 2.0f);
        this.l = f2;
        this.s = f2 / 4.0f;
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
        this.tj.setShader(new LinearGradient(this.d, 0.0f, this.oa, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.fs.size()) {
                break;
            }
            Integer num = this.fs.get(i);
            this.tj.setAlpha(num.intValue());
            Integer num2 = this.rv.get(i);
            if (this.s + num2.intValue() < this.l) {
                canvas.drawCircle(this.d, this.oa, this.s + num2.intValue(), this.tj);
            }
            if (num.intValue() > 0 && num2.intValue() < this.l) {
                this.fs.set(i, Integer.valueOf(num.intValue() - this.w > 0 ? num.intValue() - (this.w * 3) : 1));
                this.rv.set(i, Integer.valueOf(num2.intValue() + this.w));
            }
            i++;
        }
        List<Integer> list = this.rv;
        if (list.get(list.size() - 1).intValue() >= this.l / this.q) {
            this.fs.add(255);
            this.rv.add(0);
        }
        if (this.rv.size() >= 3) {
            this.rv.remove(0);
            this.fs.remove(0);
        }
        this.tj.setAlpha(255);
        this.tj.setColor(this.qg);
        canvas.drawCircle(this.d, this.oa, this.s, this.cp);
        if (this.x) {
            invalidate();
        }
    }

    public void n() {
        this.x = true;
        invalidate();
    }

    public void qg() {
        this.x = false;
        this.rv.clear();
        this.fs.clear();
        this.fs.add(255);
        this.rv.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.n = i;
    }

    public void setCoreColor(int i) {
        this.qg = i;
    }

    public void setCoreRadius(int i) {
        this.s = i;
    }

    public void setDiffuseWidth(int i) {
        this.q = i;
    }

    public void setMaxWidth(int i) {
        this.l = i;
    }

    public void setDiffuseSpeed(int i) {
        this.w = i;
    }
}
