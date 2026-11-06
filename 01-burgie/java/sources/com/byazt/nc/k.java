package com.byazt.nc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 250})
public class k extends Drawable {
    public int aj;
    public LinearGradient c;
    public int fw;
    public int[] hn;
    public int hw;
    public int pr;
    public int uc;
    public RectF vk;
    public Paint w;
    public float[] x;
    public int zo;

    public k(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.pr = i;
        this.hn = iArr;
        this.x = fArr;
        this.hw = i2;
        this.c = linearGradient;
        this.uc = i3;
        this.fw = i4;
        this.zo = i5;
        this.aj = i6;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.vk == null) {
            Rect bounds = getBounds();
            this.vk = new RectF((bounds.left + this.fw) - this.zo, (bounds.top + this.fw) - this.aj, (bounds.right - this.fw) - this.zo, (bounds.bottom - this.fw) - this.aj);
        }
        if (this.w == null) {
            pr();
        }
        RectF rectF = this.vk;
        int i = this.uc;
        canvas.drawRoundRect(rectF, i, i, this.w);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.w;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.w;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void pr() {
        int[] iArr;
        Paint paint = new Paint();
        this.w = paint;
        paint.setAntiAlias(true);
        this.w.setShadowLayer(this.fw, this.zo, this.aj, this.hw);
        if (this.vk != null && (iArr = this.hn) != null && iArr.length > 1) {
            float[] fArr = this.x;
            boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
            Paint paint2 = this.w;
            LinearGradient linearGradient = this.c;
            if (linearGradient == null) {
                linearGradient = new LinearGradient(this.vk.left, 0.0f, this.vk.right, 0.0f, this.hn, z ? this.x : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.w.setColor(this.pr);
    }

    public static void pr(View view, pr prVar) {
        if (view == null || prVar == null) {
            return;
        }
        view.setLayerType(1, null);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(prVar.pr());
        } else {
            view.setBackgroundDrawable(prVar.pr());
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 52, 785})
    public static class pr {
        public int aj;
        public LinearGradient c;
        public int[] hn;
        public float[] x;
        public int zo;
        public int pr = 2789591;
        public int hw = 2789591;
        public int uc = 10;
        public int fw = 16;

        public pr() {
            this.zo = 0;
            this.aj = 0;
            this.zo = 0;
            this.aj = 0;
        }

        public pr pr(int i) {
            this.pr = i;
            return this;
        }

        public pr hw(int i) {
            this.hw = i;
            return this;
        }

        public pr pr(int[] iArr) {
            this.hn = iArr;
            return this;
        }

        public pr hn(int i) {
            this.uc = i;
            return this;
        }

        public pr x(int i) {
            this.zo = i;
            return this;
        }

        public pr c(int i) {
            this.aj = i;
            return this;
        }

        public k pr() {
            return new k(this.pr, this.hn, this.x, this.hw, this.c, this.uc, this.fw, this.zo, this.aj);
        }
    }
}
