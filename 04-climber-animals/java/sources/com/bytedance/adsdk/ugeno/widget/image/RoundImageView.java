package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.ah;
import com.bytedance.adsdk.ugeno.ah.ka;
import com.bytedance.adsdk.ugeno.ms.c;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class RoundImageView extends ImageView implements ka, com.bytedance.adsdk.ugeno.ms.ka {
    static final /* synthetic */ boolean xr = true;
    private ColorStateList ab;
    private float ah;
    private int ao;
    private Drawable c;
    private boolean ch;
    private ImageView.ScaleType h;
    private Drawable hi;
    private final float[] ka;
    private c nw;
    private ColorFilter ny;
    private Shader.TileMode qv;
    private boolean sl;
    private ah t;
    private boolean u;
    private int ub;
    private float x;
    private Shader.TileMode y;
    private boolean zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final Shader.TileMode f407ms = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] d = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    public RoundImageView(Context context) {
        super(context);
        this.ka = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.ab = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.x = 0.0f;
        this.ny = null;
        this.ch = false;
        this.sl = false;
        this.zb = false;
        this.u = false;
        Shader.TileMode tileMode = f407ms;
        this.qv = tileMode;
        this.y = tileMode;
        this.nw = new c(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.h;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!xr && scaleType == null) {
            throw new AssertionError();
        }
        if (this.h != scaleType) {
            this.h = scaleType;
            int i = AnonymousClass1.f408ms[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            ah();
            ms(false);
            invalidate();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.image.RoundImageView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f408ms;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f408ms = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f408ms[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f408ms[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f408ms[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f408ms[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f408ms[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f408ms[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.ub = 0;
        this.hi = ms.ms(drawable);
        ah();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ub = 0;
        this.hi = ms.ms(bitmap);
        ah();
        super.setImageDrawable(this.hi);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.ub != i) {
            this.ub = i;
            this.hi = ms();
            ah();
            super.setImageDrawable(this.hi);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable ms() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.ub;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                sl.xr("RoundedImageView", "Unable to find resource: " + this.ub, e);
                this.ub = 0;
            }
        }
        return ms.ms(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.ao != i) {
            this.ao = i;
            Drawable drawableXr = xr();
            this.c = drawableXr;
            setBackgroundDrawable(drawableXr);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.c = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    private Drawable xr() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.ao;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                sl.xr("RoundedImageView", "Unable to find resource: " + this.ao, e);
                this.ao = 0;
            }
        }
        return ms.ms(drawable);
    }

    private void ah() {
        ms(this.hi, this.h);
    }

    private void ms(boolean z) {
        if (this.u) {
            if (z) {
                this.c = ms.ms(this.c);
            }
            ms(this.c, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.ny != colorFilter) {
            this.ny = colorFilter;
            this.sl = true;
            this.ch = true;
            d();
            invalidate();
        }
    }

    private void d() {
        Drawable drawable = this.hi;
        if (drawable == null || !this.ch) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.hi = drawableMutate;
        if (this.sl) {
            drawableMutate.setColorFilter(this.ny);
        }
    }

    private void ms(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof ms) {
            ms msVar = (ms) drawable;
            msVar.ms(scaleType).ms(this.x).ms(this.ab).ms(this.zb).ms(this.qv).xr(this.y);
            float[] fArr = this.ka;
            if (fArr != null) {
                msVar.ms(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            d();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                ms(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.c = drawable;
        ms(true);
        super.setBackgroundDrawable(this.c);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.ka) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        ms(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadius(float f) {
        ms(f, f, f, f);
    }

    public void ms(float f, float f2, float f3, float f4) {
        float[] fArr = this.ka;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        ah();
        ms(false);
        invalidate();
    }

    public float getBorderWidth() {
        return this.x;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.x == f) {
            return;
        }
        this.x = f;
        ah();
        ms(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.ab.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.ab;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.ab.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.ab = colorStateList;
        ah();
        ms(false);
        if (this.x > 0.0f) {
            invalidate();
        }
    }

    public void setOval(boolean z) {
        this.zb = z;
        ah();
        ms(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.qv;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.qv == tileMode) {
            return;
        }
        this.qv = tileMode;
        ah();
        ms(false);
        invalidate();
    }

    public Shader.TileMode getTileModeY() {
        return this.y;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.y == tileMode) {
            return;
        }
        this.y = tileMode;
        ah();
        ms(false);
        invalidate();
    }

    public void ms(ah ahVar) {
        this.t = ahVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar = this.t;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            super.onMeasure(iArrMs[0], iArrMs[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ah ahVar = this.t;
        if (ahVar != null) {
            ahVar.ms(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ah ahVar = this.t;
        if (ahVar != null) {
            ahVar.ms(canvas, this);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ah ahVar = this.t;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i3);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.t;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.t;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ka, com.bytedance.adsdk.ugeno.ms.ka
    public float getRipple() {
        return this.ah;
    }

    public void setShine(float f) {
        c cVar = this.nw;
        if (cVar != null) {
            cVar.ah(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getShine() {
        return this.nw.getShine();
    }

    public void setStretch(float f) {
        c cVar = this.nw;
        if (cVar != null) {
            cVar.d(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getStretch() {
        return this.nw.getStretch();
    }

    public void setRubIn(float f) {
        c cVar = this.nw;
        if (cVar != null) {
            cVar.ka(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getRubIn() {
        return this.nw.getRubIn();
    }

    public void setRipple(float f) {
        this.ah = f;
        c cVar = this.nw;
        if (cVar != null) {
            cVar.xr(f);
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.t;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }

    public void setBorderRadius(float f) {
        c cVar = this.nw;
        if (cVar != null) {
            cVar.ms(f);
        }
    }

    public float getBorderRadius() {
        return this.nw.ms();
    }
}
