package com.byazt.jm;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 918, 26})
public class qg extends Drawable {
    public ImageView.ScaleType a;
    public float cd;
    public final RectF cp;
    public final boolean[] cy;
    public Shader.TileMode d;
    public final RectF fs;
    public boolean hd;
    public float k;
    public final Paint l;
    public Shader.TileMode oa;
    public final Bitmap q;
    public final Paint rv;
    public final RectF s;
    public boolean sz;
    public final Matrix tj;
    public ColorStateList um;
    public final int w;
    public final int x;
    public final RectF n = new RectF();
    public final RectF qg = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public qg(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.s = rectF;
        this.fs = new RectF();
        this.tj = new Matrix();
        this.cp = new RectF();
        this.d = Shader.TileMode.CLAMP;
        this.oa = Shader.TileMode.CLAMP;
        this.sz = true;
        this.k = 0.0f;
        this.cy = new boolean[]{true, true, true, true};
        this.hd = false;
        this.cd = 0.0f;
        this.um = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.a = ImageView.ScaleType.FIT_CENTER;
        this.q = bitmap;
        int width = bitmap.getWidth();
        this.w = width;
        int height = bitmap.getHeight();
        this.x = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.l = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.rv = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.um.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.cd);
    }

    public static qg n(Bitmap bitmap) {
        if (bitmap != null) {
            return new qg(bitmap);
        }
        return null;
    }

    public static Drawable n(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof qg) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), n(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapQg = qg(drawable);
        return bitmapQg != null ? new qg(bitmapQg) : drawable;
    }

    public static Bitmap qg(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.um.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.um.getColorForState(iArr, 0);
        if (this.rv.getColor() != colorForState) {
            this.rv.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* JADX INFO: renamed from: com.byazt.jm.qg$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 918, 51})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            n = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void n() {
        float fWidth;
        float fHeight;
        int i = AnonymousClass1.n[this.a.ordinal()];
        if (i == 1) {
            this.fs.set(this.n);
            RectF rectF = this.fs;
            float f = this.cd;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.tj.reset();
            this.tj.setTranslate((int) (((this.fs.width() - this.w) * 0.5f) + 0.5f), (int) (((this.fs.height() - this.x) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.fs.set(this.n);
            RectF rectF2 = this.fs;
            float f2 = this.cd;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.tj.reset();
            float fWidth2 = 0.0f;
            if (this.w * this.fs.height() > this.fs.width() * this.x) {
                fWidth = this.fs.height() / this.x;
                fHeight = 0.0f;
                fWidth2 = (this.fs.width() - (this.w * fWidth)) * 0.5f;
            } else {
                fWidth = this.fs.width() / this.w;
                fHeight = (this.fs.height() - (this.x * fWidth)) * 0.5f;
            }
            this.tj.setScale(fWidth, fWidth);
            Matrix matrix = this.tj;
            float f3 = this.cd;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.tj.reset();
            float fMin = (((float) this.w) > this.n.width() || ((float) this.x) > this.n.height()) ? Math.min(this.n.width() / this.w, this.n.height() / this.x) : 1.0f;
            float fWidth3 = (int) (((this.n.width() - (this.w * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.n.height() - (this.x * fMin)) * 0.5f) + 0.5f);
            this.tj.setScale(fMin, fMin);
            this.tj.postTranslate(fWidth3, fHeight2);
            this.fs.set(this.s);
            this.tj.mapRect(this.fs);
            RectF rectF3 = this.fs;
            float f4 = this.cd;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.tj.setRectToRect(this.s, this.fs, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.fs.set(this.s);
            this.tj.setRectToRect(this.s, this.n, Matrix.ScaleToFit.END);
            this.tj.mapRect(this.fs);
            RectF rectF4 = this.fs;
            float f5 = this.cd;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.tj.setRectToRect(this.s, this.fs, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.fs.set(this.s);
            this.tj.setRectToRect(this.s, this.n, Matrix.ScaleToFit.START);
            this.tj.mapRect(this.fs);
            RectF rectF5 = this.fs;
            float f6 = this.cd;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.tj.setRectToRect(this.s, this.fs, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.fs.set(this.s);
            this.tj.setRectToRect(this.s, this.n, Matrix.ScaleToFit.CENTER);
            this.tj.mapRect(this.fs);
            RectF rectF6 = this.fs;
            float f7 = this.cd;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.tj.setRectToRect(this.s, this.fs, Matrix.ScaleToFit.FILL);
        } else {
            this.fs.set(this.n);
            RectF rectF7 = this.fs;
            float f8 = this.cd;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.tj.reset();
            this.tj.setRectToRect(this.s, this.fs, Matrix.ScaleToFit.FILL);
        }
        this.qg.set(this.fs);
        this.sz = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n.set(rect);
        n();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.sz) {
            BitmapShader bitmapShader = new BitmapShader(this.q, this.d, this.oa);
            if (this.d == Shader.TileMode.CLAMP && this.oa == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.tj);
            }
            this.l.setShader(bitmapShader);
            this.sz = false;
        }
        if (this.hd) {
            if (this.cd > 0.0f) {
                canvas.drawOval(this.qg, this.l);
                canvas.drawOval(this.fs, this.rv);
                return;
            } else {
                canvas.drawOval(this.qg, this.l);
                return;
            }
        }
        if (n(this.cy)) {
            float f = this.k;
            if (this.cd > 0.0f) {
                canvas.drawRoundRect(this.qg, f, f, this.l);
                canvas.drawRoundRect(this.fs, f, f, this.rv);
                n(canvas);
                qg(canvas);
                return;
            }
            canvas.drawRoundRect(this.qg, f, f, this.l);
            n(canvas);
            return;
        }
        canvas.drawRect(this.qg, this.l);
        if (this.cd > 0.0f) {
            canvas.drawRect(this.fs, this.rv);
        }
    }

    private void n(Canvas canvas) {
        if (qg(this.cy) || this.k == 0.0f) {
            return;
        }
        float f = this.qg.left;
        float f2 = this.qg.top;
        float fWidth = this.qg.width() + f;
        float fHeight = this.qg.height() + f2;
        float f3 = this.k;
        if (!this.cy[0]) {
            this.cp.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.cp, this.l);
        }
        if (!this.cy[1]) {
            this.cp.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.cp, this.l);
        }
        if (!this.cy[2]) {
            this.cp.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.cp, this.l);
        }
        if (this.cy[3]) {
            return;
        }
        this.cp.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.cp, this.l);
    }

    private void qg(Canvas canvas) {
        if (qg(this.cy) || this.k == 0.0f) {
            return;
        }
        float f = this.qg.left;
        float f2 = this.qg.top;
        float fWidth = f + this.qg.width();
        float fHeight = f2 + this.qg.height();
        float f3 = this.k;
        float f4 = this.cd / 2.0f;
        if (!this.cy[0]) {
            canvas.drawLine(f - f4, f2, f + f3, f2, this.rv);
            canvas.drawLine(f, f2 - f4, f, f2 + f3, this.rv);
        }
        if (!this.cy[1]) {
            canvas.drawLine((fWidth - f3) - f4, f2, fWidth, f2, this.rv);
            canvas.drawLine(fWidth, f2 - f4, fWidth, f2 + f3, this.rv);
        }
        if (!this.cy[2]) {
            canvas.drawLine((fWidth - f3) - f4, fHeight, fWidth + f4, fHeight, this.rv);
            canvas.drawLine(fWidth, fHeight - f3, fWidth, fHeight, this.rv);
        }
        if (this.cy[3]) {
            return;
        }
        canvas.drawLine(f - f4, fHeight, f + f3, fHeight, this.rv);
        canvas.drawLine(f, fHeight - f3, f, fHeight, this.rv);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.l.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.l.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.l.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.l.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.l.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.l.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.w;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.x;
    }

    public qg n(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (!hashSet.isEmpty()) {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(fFloatValue)));
            }
            this.k = fFloatValue;
        } else {
            this.k = 0.0f;
        }
        boolean[] zArr = this.cy;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public qg n(float f) {
        this.cd = f;
        this.rv.setStrokeWidth(f);
        return this;
    }

    public qg n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.um = colorStateList;
        this.rv.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public qg n(boolean z) {
        this.hd = z;
        return this;
    }

    public qg n(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.a != scaleType) {
            this.a = scaleType;
            n();
        }
        return this;
    }

    public qg n(Shader.TileMode tileMode) {
        if (this.d != tileMode) {
            this.d = tileMode;
            this.sz = true;
            invalidateSelf();
        }
        return this;
    }

    public qg qg(Shader.TileMode tileMode) {
        if (this.oa != tileMode) {
            this.oa = tileMode;
            this.sz = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean n(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean qg(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
