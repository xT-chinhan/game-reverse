package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends Drawable {
    private int ab;
    private int[] ah;
    private int c;
    private RectF ch;
    private float[] d;
    private Paint hi;
    private LinearGradient ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3738ms;
    private int ny;
    private int x;
    private int xr;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public sl(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.f3738ms = i;
        this.ah = iArr;
        this.d = fArr;
        this.xr = i2;
        this.ka = linearGradient;
        this.c = i3;
        this.ab = i4;
        this.x = i5;
        this.ny = i6;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.ch == null) {
            Rect bounds = getBounds();
            this.ch = new RectF((bounds.left + this.ab) - this.x, (bounds.top + this.ab) - this.ny, (bounds.right - this.ab) - this.x, (bounds.bottom - this.ab) - this.ny);
        }
        if (this.hi == null) {
            ms();
        }
        RectF rectF = this.ch;
        int i = this.c;
        canvas.drawRoundRect(rectF, i, i, this.hi);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.hi;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.hi;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    private void ms() {
        int[] iArr;
        Paint paint = new Paint();
        this.hi = paint;
        paint.setAntiAlias(true);
        this.hi.setShadowLayer(this.ab, this.x, this.ny, this.xr);
        if (this.ch != null && (iArr = this.ah) != null && iArr.length > 1) {
            float[] fArr = this.d;
            boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
            Paint paint2 = this.hi;
            LinearGradient linearGradient = this.ka;
            if (linearGradient == null) {
                linearGradient = new LinearGradient(this.ch.left, 0.0f, this.ch.right, 0.0f, this.ah, z ? this.d : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.hi.setColor(this.f3738ms);
    }

    public static void ms(View view, ms msVar) {
        if (view == null || msVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(msVar.ms());
    }

    public static class ms {
        private int[] ah;
        private float[] d;
        private LinearGradient ka;
        private int ny;
        private int x;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f3739ms = t.ny(re.getContext(), "tt_ssxinmian8");
        private int xr = t.ny(re.getContext(), "tt_ssxinxian3");
        private int c = 10;
        private int ab = 16;

        public ms() {
            this.x = 0;
            this.ny = 0;
            this.x = 0;
            this.ny = 0;
        }

        public ms ms(int i) {
            this.f3739ms = i;
            return this;
        }

        public ms xr(int i) {
            this.xr = i;
            return this;
        }

        public ms ms(int[] iArr) {
            this.ah = iArr;
            return this;
        }

        public ms ah(int i) {
            this.c = i;
            return this;
        }

        public ms d(int i) {
            this.x = i;
            return this;
        }

        public ms ka(int i) {
            this.ny = i;
            return this;
        }

        public sl ms() {
            return new sl(this.f3739ms, this.ah, this.d, this.xr, this.ka, this.c, this.ab, this.x, this.ny);
        }
    }
}
