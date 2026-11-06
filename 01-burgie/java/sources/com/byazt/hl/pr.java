package com.byazt.hl;

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
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 37})
public class pr extends Drawable {
    public ImageView.ScaleType a;
    public final Paint aj;
    public final Paint c;
    public final int fw;
    public boolean g;
    public final RectF hn;
    public float ho;
    public Shader.TileMode k;
    public float lb;
    public Shader.TileMode m;
    public final boolean[] nt;
    public ColorStateList qa;
    public final int uc;
    public final Matrix vk;
    public final RectF w;
    public final Bitmap x;
    public boolean yb;
    public final RectF zo;
    public final RectF pr = new RectF();
    public final RectF hw = new RectF();

    public pr(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.hn = rectF;
        this.zo = new RectF();
        this.vk = new Matrix();
        this.w = new RectF();
        this.k = Shader.TileMode.CLAMP;
        this.m = Shader.TileMode.CLAMP;
        this.g = true;
        this.ho = 0.0f;
        this.nt = new boolean[]{true, true, true, true};
        this.yb = false;
        this.lb = 0.0f;
        this.qa = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.a = ImageView.ScaleType.FIT_CENTER;
        this.x = bitmap;
        int width = bitmap.getWidth();
        this.uc = width;
        int height = bitmap.getHeight();
        this.fw = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.aj = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.qa.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.lb);
    }

    public static pr pr(Bitmap bitmap) {
        if (bitmap != null) {
            return new pr(bitmap);
        }
        return null;
    }

    public static Drawable pr(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof pr) {
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
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), pr(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapHw = hw(drawable);
        if (bitmapHw != null) {
            return new pr(bitmapHw);
        }
        return drawable;
    }

    public static Bitmap hw(Drawable drawable) {
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
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.qa.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.qa.getColorForState(iArr, 0);
        if (this.aj.getColor() != colorForState) {
            this.aj.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* JADX INFO: renamed from: com.byazt.hl.pr$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 85})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            pr = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private void pr() {
        float fWidth;
        float fHeight;
        float fMin;
        switch (AnonymousClass1.pr[this.a.ordinal()]) {
            case 1:
                this.zo.set(this.pr);
                RectF rectF = this.zo;
                float f = this.lb;
                rectF.inset(f / 2.0f, f / 2.0f);
                this.vk.reset();
                this.vk.setTranslate((int) (((this.zo.width() - this.uc) * 0.5f) + 0.5f), (int) (((this.zo.height() - this.fw) * 0.5f) + 0.5f));
                break;
            case 2:
                this.zo.set(this.pr);
                RectF rectF2 = this.zo;
                float f2 = this.lb;
                rectF2.inset(f2 / 2.0f, f2 / 2.0f);
                this.vk.reset();
                float fWidth2 = 0.0f;
                if (this.uc * this.zo.height() > this.zo.width() * this.fw) {
                    fWidth = this.zo.height() / this.fw;
                    fHeight = 0.0f;
                    fWidth2 = (this.zo.width() - (this.uc * fWidth)) * 0.5f;
                } else {
                    fWidth = this.zo.width() / this.uc;
                    fHeight = (this.zo.height() - (this.fw * fWidth)) * 0.5f;
                }
                this.vk.setScale(fWidth, fWidth);
                Matrix matrix = this.vk;
                float f3 = this.lb;
                matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
                break;
            case 3:
                this.vk.reset();
                if (this.uc <= this.pr.width() && this.fw <= this.pr.height()) {
                    fMin = 1.0f;
                } else {
                    fMin = Math.min(this.pr.width() / this.uc, this.pr.height() / this.fw);
                }
                float fWidth3 = (int) (((this.pr.width() - (this.uc * fMin)) * 0.5f) + 0.5f);
                float fHeight2 = (int) (((this.pr.height() - (this.fw * fMin)) * 0.5f) + 0.5f);
                this.vk.setScale(fMin, fMin);
                this.vk.postTranslate(fWidth3, fHeight2);
                this.zo.set(this.hn);
                this.vk.mapRect(this.zo);
                RectF rectF3 = this.zo;
                float f4 = this.lb;
                rectF3.inset(f4 / 2.0f, f4 / 2.0f);
                this.vk.setRectToRect(this.hn, this.zo, Matrix.ScaleToFit.FILL);
                break;
            case 4:
            default:
                this.zo.set(this.hn);
                this.vk.setRectToRect(this.hn, this.pr, Matrix.ScaleToFit.CENTER);
                this.vk.mapRect(this.zo);
                RectF rectF4 = this.zo;
                float f5 = this.lb;
                rectF4.inset(f5 / 2.0f, f5 / 2.0f);
                this.vk.setRectToRect(this.hn, this.zo, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.zo.set(this.hn);
                this.vk.setRectToRect(this.hn, this.pr, Matrix.ScaleToFit.END);
                this.vk.mapRect(this.zo);
                RectF rectF5 = this.zo;
                float f6 = this.lb;
                rectF5.inset(f6 / 2.0f, f6 / 2.0f);
                this.vk.setRectToRect(this.hn, this.zo, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.zo.set(this.hn);
                this.vk.setRectToRect(this.hn, this.pr, Matrix.ScaleToFit.START);
                this.vk.mapRect(this.zo);
                RectF rectF6 = this.zo;
                float f7 = this.lb;
                rectF6.inset(f7 / 2.0f, f7 / 2.0f);
                this.vk.setRectToRect(this.hn, this.zo, Matrix.ScaleToFit.FILL);
                break;
            case 7:
                this.zo.set(this.pr);
                RectF rectF7 = this.zo;
                float f8 = this.lb;
                rectF7.inset(f8 / 2.0f, f8 / 2.0f);
                this.vk.reset();
                this.vk.setRectToRect(this.hn, this.zo, Matrix.ScaleToFit.FILL);
                break;
        }
        this.hw.set(this.zo);
        this.g = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.pr.set(rect);
        pr();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.g) {
            BitmapShader bitmapShader = new BitmapShader(this.x, this.k, this.m);
            if (this.k == Shader.TileMode.CLAMP && this.m == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.vk);
            }
            this.c.setShader(bitmapShader);
            this.g = false;
        }
        if (this.yb) {
            if (this.lb > 0.0f) {
                canvas.drawOval(this.hw, this.c);
                canvas.drawOval(this.zo, this.aj);
                return;
            } else {
                canvas.drawOval(this.hw, this.c);
                return;
            }
        }
        if (pr(this.nt)) {
            float f = this.ho;
            if (this.lb > 0.0f) {
                canvas.drawRoundRect(this.hw, f, f, this.c);
                canvas.drawRoundRect(this.zo, f, f, this.aj);
                pr(canvas);
                hw(canvas);
                return;
            }
            canvas.drawRoundRect(this.hw, f, f, this.c);
            pr(canvas);
            return;
        }
        canvas.drawRect(this.hw, this.c);
        if (this.lb > 0.0f) {
            canvas.drawRect(this.zo, this.aj);
        }
    }

    private void pr(Canvas canvas) {
        if (hw(this.nt) || this.ho == 0.0f) {
            return;
        }
        float f = this.hw.left;
        float f2 = this.hw.top;
        float fWidth = this.hw.width() + f;
        float fHeight = this.hw.height() + f2;
        float f3 = this.ho;
        if (!this.nt[0]) {
            this.w.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.w, this.c);
        }
        if (!this.nt[1]) {
            this.w.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.w, this.c);
        }
        if (!this.nt[2]) {
            this.w.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.w, this.c);
        }
        if (!this.nt[3]) {
            this.w.set(f, fHeight - f3, f3 + f, fHeight);
            canvas.drawRect(this.w, this.c);
        }
    }

    private void hw(Canvas canvas) {
        if (hw(this.nt) || this.ho == 0.0f) {
            return;
        }
        float f = this.hw.left;
        float f2 = this.hw.top;
        float fWidth = f + this.hw.width();
        float fHeight = f2 + this.hw.height();
        float f3 = this.ho;
        float f4 = this.lb / 2.0f;
        if (!this.nt[0]) {
            canvas.drawLine(f - f4, f2, f + f3, f2, this.aj);
            canvas.drawLine(f, f2 - f4, f, f2 + f3, this.aj);
        }
        if (!this.nt[1]) {
            canvas.drawLine((fWidth - f3) - f4, f2, fWidth, f2, this.aj);
            canvas.drawLine(fWidth, f2 - f4, fWidth, f2 + f3, this.aj);
        }
        if (!this.nt[2]) {
            canvas.drawLine((fWidth - f3) - f4, fHeight, fWidth + f4, fHeight, this.aj);
            canvas.drawLine(fWidth, fHeight - f3, fWidth, fHeight, this.aj);
        }
        if (!this.nt[3]) {
            canvas.drawLine(f - f4, fHeight, f + f3, fHeight, this.aj);
            canvas.drawLine(f, fHeight - f3, f, fHeight, this.aj);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.c.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.c.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.c.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.c.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.c.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.uc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.fw;
    }

    public pr pr(float f, float f2, float f3, float f4) {
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
            this.ho = fFloatValue;
        } else {
            this.ho = 0.0f;
        }
        boolean[] zArr = this.nt;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public pr pr(float f) {
        this.lb = f;
        this.aj.setStrokeWidth(f);
        return this;
    }

    public pr pr(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.qa = colorStateList;
        this.aj.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public pr pr(boolean z) {
        this.yb = z;
        return this;
    }

    public pr pr(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.a != scaleType) {
            this.a = scaleType;
            pr();
        }
        return this;
    }

    public pr pr(Shader.TileMode tileMode) {
        if (this.k != tileMode) {
            this.k = tileMode;
            this.g = true;
            invalidateSelf();
        }
        return this;
    }

    public pr hw(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.g = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean pr(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean hw(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
