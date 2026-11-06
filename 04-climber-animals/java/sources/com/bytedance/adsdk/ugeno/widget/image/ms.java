package com.bytedance.adsdk.ugeno.widget.image;

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
import com.bytedance.sdk.component.utils.sl;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends Drawable {
    private final int ab;
    private final RectF ah;
    private final boolean[] ao;
    private final int c;
    private final Matrix ch;
    private final Bitmap d;
    private boolean h;
    private final RectF hi;
    private final Paint ka;
    private final Paint ny;
    private float qv;
    private Shader.TileMode sl;
    private ImageView.ScaleType t;
    private boolean u;
    private float ub;
    private final RectF x;
    private ColorStateList y;
    private Shader.TileMode zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final RectF f409ms = new RectF();
    private final RectF xr = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ms(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.ah = rectF;
        this.x = new RectF();
        this.ch = new Matrix();
        this.hi = new RectF();
        this.sl = Shader.TileMode.CLAMP;
        this.zb = Shader.TileMode.CLAMP;
        this.u = true;
        this.ub = 0.0f;
        this.ao = new boolean[]{true, true, true, true};
        this.h = false;
        this.qv = 0.0f;
        this.y = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.t = ImageView.ScaleType.FIT_CENTER;
        this.d = bitmap;
        int width = bitmap.getWidth();
        this.c = width;
        int height = bitmap.getHeight();
        this.ab = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.ka = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.ny = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.y.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.qv);
    }

    public static ms ms(Bitmap bitmap) {
        if (bitmap != null) {
            return new ms(bitmap);
        }
        return null;
    }

    public static Drawable ms(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof ms) {
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
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), ms(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapXr = xr(drawable);
        return bitmapXr != null ? new ms(bitmapXr) : drawable;
    }

    public static Bitmap xr(Drawable drawable) {
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
        } catch (Throwable th) {
            sl.ms(th);
            sl.xr("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.y.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.y.getColorForState(iArr, 0);
        if (this.ny.getColor() != colorForState) {
            this.ny.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.image.ms$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f410ms;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f410ms = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f410ms[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f410ms[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f410ms[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f410ms[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f410ms[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f410ms[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void ms() {
        float fWidth;
        float fHeight;
        int i = AnonymousClass1.f410ms[this.t.ordinal()];
        if (i == 1) {
            this.x.set(this.f409ms);
            RectF rectF = this.x;
            float f = this.qv;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.ch.reset();
            this.ch.setTranslate((int) (((this.x.width() - this.c) * 0.5f) + 0.5f), (int) (((this.x.height() - this.ab) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.x.set(this.f409ms);
            RectF rectF2 = this.x;
            float f2 = this.qv;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.ch.reset();
            float fWidth2 = 0.0f;
            if (this.c * this.x.height() > this.x.width() * this.ab) {
                fWidth = this.x.height() / this.ab;
                fHeight = 0.0f;
                fWidth2 = (this.x.width() - (this.c * fWidth)) * 0.5f;
            } else {
                fWidth = this.x.width() / this.c;
                fHeight = (this.x.height() - (this.ab * fWidth)) * 0.5f;
            }
            this.ch.setScale(fWidth, fWidth);
            Matrix matrix = this.ch;
            float f3 = this.qv;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.ch.reset();
            float fMin = (((float) this.c) > this.f409ms.width() || ((float) this.ab) > this.f409ms.height()) ? Math.min(this.f409ms.width() / this.c, this.f409ms.height() / this.ab) : 1.0f;
            float fWidth3 = (int) (((this.f409ms.width() - (this.c * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.f409ms.height() - (this.ab * fMin)) * 0.5f) + 0.5f);
            this.ch.setScale(fMin, fMin);
            this.ch.postTranslate(fWidth3, fHeight2);
            this.x.set(this.ah);
            this.ch.mapRect(this.x);
            RectF rectF3 = this.x;
            float f4 = this.qv;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.ch.setRectToRect(this.ah, this.x, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.x.set(this.ah);
            this.ch.setRectToRect(this.ah, this.f409ms, Matrix.ScaleToFit.END);
            this.ch.mapRect(this.x);
            RectF rectF4 = this.x;
            float f5 = this.qv;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.ch.setRectToRect(this.ah, this.x, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.x.set(this.ah);
            this.ch.setRectToRect(this.ah, this.f409ms, Matrix.ScaleToFit.START);
            this.ch.mapRect(this.x);
            RectF rectF5 = this.x;
            float f6 = this.qv;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.ch.setRectToRect(this.ah, this.x, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.x.set(this.ah);
            this.ch.setRectToRect(this.ah, this.f409ms, Matrix.ScaleToFit.CENTER);
            this.ch.mapRect(this.x);
            RectF rectF6 = this.x;
            float f7 = this.qv;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.ch.setRectToRect(this.ah, this.x, Matrix.ScaleToFit.FILL);
        } else {
            this.x.set(this.f409ms);
            RectF rectF7 = this.x;
            float f8 = this.qv;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.ch.reset();
            this.ch.setRectToRect(this.ah, this.x, Matrix.ScaleToFit.FILL);
        }
        this.xr.set(this.x);
        this.u = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f409ms.set(rect);
        ms();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.u) {
            BitmapShader bitmapShader = new BitmapShader(this.d, this.sl, this.zb);
            if (this.sl == Shader.TileMode.CLAMP && this.zb == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.ch);
            }
            this.ka.setShader(bitmapShader);
            this.u = false;
        }
        if (this.h) {
            if (this.qv > 0.0f) {
                canvas.drawOval(this.xr, this.ka);
                canvas.drawOval(this.x, this.ny);
                return;
            } else {
                canvas.drawOval(this.xr, this.ka);
                return;
            }
        }
        if (ms(this.ao)) {
            float f = this.ub;
            if (this.qv > 0.0f) {
                canvas.drawRoundRect(this.xr, f, f, this.ka);
                canvas.drawRoundRect(this.x, f, f, this.ny);
                ms(canvas);
                xr(canvas);
                return;
            }
            canvas.drawRoundRect(this.xr, f, f, this.ka);
            ms(canvas);
            return;
        }
        canvas.drawRect(this.xr, this.ka);
        if (this.qv > 0.0f) {
            canvas.drawRect(this.x, this.ny);
        }
    }

    private void ms(Canvas canvas) {
        if (xr(this.ao) || this.ub == 0.0f) {
            return;
        }
        float f = this.xr.left;
        float f2 = this.xr.top;
        float fWidth = this.xr.width() + f;
        float fHeight = this.xr.height() + f2;
        float f3 = this.ub;
        if (!this.ao[0]) {
            this.hi.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.hi, this.ka);
        }
        if (!this.ao[1]) {
            this.hi.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.hi, this.ka);
        }
        if (!this.ao[2]) {
            this.hi.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.hi, this.ka);
        }
        if (this.ao[3]) {
            return;
        }
        this.hi.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.hi, this.ka);
    }

    private void xr(Canvas canvas) {
        if (xr(this.ao) || this.ub == 0.0f) {
            return;
        }
        float f = this.xr.left;
        float f2 = this.xr.top;
        float fWidth = f + this.xr.width();
        float fHeight = f2 + this.xr.height();
        float f3 = this.ub;
        float f4 = this.qv / 2.0f;
        if (!this.ao[0]) {
            canvas.drawLine(f - f4, f2, f + f3, f2, this.ny);
            canvas.drawLine(f, f2 - f4, f, f2 + f3, this.ny);
        }
        if (!this.ao[1]) {
            canvas.drawLine((fWidth - f3) - f4, f2, fWidth, f2, this.ny);
            canvas.drawLine(fWidth, f2 - f4, fWidth, f2 + f3, this.ny);
        }
        if (!this.ao[2]) {
            canvas.drawLine((fWidth - f3) - f4, fHeight, fWidth + f4, fHeight, this.ny);
            canvas.drawLine(fWidth, fHeight - f3, fWidth, fHeight, this.ny);
        }
        if (this.ao[3]) {
            return;
        }
        canvas.drawLine(f - f4, fHeight, f + f3, fHeight, this.ny);
        canvas.drawLine(f, fHeight - f3, f, fHeight, this.ny);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.ka.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.ka.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.ka.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.ka.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.ka.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.ka.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.ab;
    }

    public ms ms(float f, float f2, float f3, float f4) {
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
            this.ub = fFloatValue;
        } else {
            this.ub = 0.0f;
        }
        boolean[] zArr = this.ao;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public ms ms(float f) {
        this.qv = f;
        this.ny.setStrokeWidth(f);
        return this;
    }

    public ms ms(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.y = colorStateList;
        this.ny.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public ms ms(boolean z) {
        this.h = z;
        return this;
    }

    public ms ms(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            ms();
        }
        return this;
    }

    public ms ms(Shader.TileMode tileMode) {
        if (this.sl != tileMode) {
            this.sl = tileMode;
            this.u = true;
            invalidateSelf();
        }
        return this;
    }

    public ms xr(Shader.TileMode tileMode) {
        if (this.zb != tileMode) {
            this.zb = tileMode;
            this.u = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean ms(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean xr(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
