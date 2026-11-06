package com.byazt.hl;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.byazt.ch.c;
import com.byazt.iza.fw;
import com.byazt.iza.zo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 1693})
public class RoundImageView extends ImageView implements c, fw {
    public static final /* synthetic */ boolean hw = true;
    public static final Shader.TileMode pr = Shader.TileMode.CLAMP;
    public static final ImageView.ScaleType[] x = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public com.byazt.llk.c a;
    public ColorFilter aj;
    public float b;
    public final float[] c;
    public zo cz;
    public float fo;
    public ColorStateList fw;
    public boolean g;
    public Bitmap gz;
    public float hn;
    public int ho;
    public float iu;
    public boolean k;
    public Shader.TileMode lb;
    public boolean m;
    public final RectF nl;
    public int nt;
    public boolean ny;
    public Shader.TileMode qa;
    public Path rc;
    public Drawable uc;
    public Canvas ve;
    public boolean vk;
    public Drawable w;
    public ImageView.ScaleType yb;
    public Paint z;
    public float zo;

    public RoundImageView(Context context) {
        super(context);
        this.c = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.fw = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.zo = 0.0f;
        this.aj = null;
        this.vk = false;
        this.k = false;
        this.m = false;
        this.g = false;
        Shader.TileMode tileMode = pr;
        this.lb = tileMode;
        this.qa = tileMode;
        this.ny = false;
        this.fo = 50.0f;
        this.nl = new RectF();
        this.cz = new zo(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.yb;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!hw && scaleType == null) {
            throw new AssertionError();
        }
        if (this.yb != scaleType) {
            this.yb = scaleType;
            switch (AnonymousClass1.pr[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    super.setScaleType(scaleType);
                    break;
                default:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
            }
            hn();
            pr(false);
            invalidate();
        }
    }

    /* JADX INFO: renamed from: com.byazt.hl.RoundImageView$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, AVMDLDataLoader.KeyIsIsChecksumLevel})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            pr = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.ho = 0;
        this.w = pr.pr(drawable);
        hn();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ho = 0;
        this.w = pr.pr(bitmap);
        hn();
        super.setImageDrawable(this.w);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.ho != i) {
            this.ho = i;
            this.w = pr();
            hn();
            super.setImageDrawable(this.w);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable pr() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.ho;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                this.ho = 0;
            }
        }
        return pr.pr(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.nt != i) {
            this.nt = i;
            Drawable drawableHw = hw();
            this.uc = drawableHw;
            setBackgroundDrawable(drawableHw);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.uc = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    private Drawable hw() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.nt;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                this.nt = 0;
            }
        }
        return pr.pr(drawable);
    }

    private void hn() {
        pr(this.w, this.yb);
    }

    private void pr(boolean z) {
        if (this.g) {
            if (z) {
                this.uc = pr.pr(this.uc);
            }
            pr(this.uc, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.aj != colorFilter) {
            this.aj = colorFilter;
            this.k = true;
            this.vk = true;
            x();
            invalidate();
        }
    }

    private void x() {
        Drawable drawable = this.w;
        if (drawable != null && this.vk) {
            Drawable drawableMutate = drawable.mutate();
            this.w = drawableMutate;
            if (this.k) {
                drawableMutate.setColorFilter(this.aj);
            }
        }
    }

    private void pr(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof pr) {
            pr prVar = (pr) drawable;
            prVar.pr(scaleType).pr(this.zo).pr(this.fw).pr(this.m).pr(this.lb).hw(this.qa);
            float[] fArr = this.c;
            if (fArr != null) {
                prVar.pr(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            x();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                pr(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.uc = drawable;
        pr(true);
        super.setBackgroundDrawable(this.uc);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.c) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        pr(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadius(float f) {
        pr(f, f, f, f);
    }

    public void pr(float f, float f2, float f3, float f4) {
        float[] fArr = this.c;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        hn();
        pr(false);
        invalidate();
    }

    public float getBorderWidth() {
        return this.zo;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.zo == f) {
            return;
        }
        this.zo = f;
        hn();
        pr(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.fw.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.fw;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.fw.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.fw = colorStateList;
        hn();
        pr(false);
        if (this.zo > 0.0f) {
            invalidate();
        }
    }

    public void setOval(boolean z) {
        this.m = z;
        hn();
        pr(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.lb;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.lb == tileMode) {
            return;
        }
        this.lb = tileMode;
        hn();
        pr(false);
        invalidate();
    }

    public Shader.TileMode getTileModeY() {
        return this.qa;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.qa == tileMode) {
            return;
        }
        this.qa = tileMode;
        hn();
        pr(false);
        invalidate();
    }

    public void pr(com.byazt.llk.c cVar) {
        this.a = cVar;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        com.byazt.llk.c cVar = this.a;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            super.onMeasure(iArrPr[0], iArrPr[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.byazt.llk.c cVar = this.a;
        if (cVar != null) {
            cVar.pr(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (this.ny && (canvas2 = this.ve) != null && this.gz != null) {
            super.onDraw(canvas2);
            this.ve.drawPath(this.rc, this.z);
            canvas.drawBitmap(this.gz, 0.0f, 0.0f, (Paint) null);
        } else {
            super.onDraw(canvas);
        }
        com.byazt.llk.c cVar = this.a;
        if (cVar != null) {
            cVar.pr(canvas, this);
            this.a.pr(canvas);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        com.byazt.llk.c cVar = this.a;
        if (cVar != null) {
            cVar.hw(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.llk.c cVar = this.a;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i3);
        }
        if (i > 0 && i2 > 0 && this.ny) {
            this.gz = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.ve = new Canvas(this.gz);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.llk.c cVar = this.a;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.byazt.llk.c cVar = this.a;
        if (cVar != null) {
            cVar.uc();
        }
        Canvas canvas = this.ve;
        if (canvas != null) {
            canvas.setBitmap(null);
        }
        Bitmap bitmap = this.gz;
        if (bitmap != null) {
            bitmap.recycle();
            this.ve = null;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iWidth;
        if (this.ny) {
            this.a.c();
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.rc.moveTo(x2, y);
                    this.b = x2;
                    this.iu = y;
                    HashMap map = new HashMap();
                    map.put("state", 1);
                    this.a.pr("eraseState", map);
                    break;
                case 1:
                    this.rc.computeBounds(this.nl, true);
                    try {
                        iWidth = (int) (((this.nl.width() * this.nl.height()) / (getWidth() * getHeight())) * 100.0f);
                    } catch (Exception e) {
                        iWidth = 0;
                    }
                    HashMap map2 = new HashMap();
                    map2.put("state", 2);
                    map2.put("percent", Integer.valueOf(iWidth));
                    this.a.pr("eraseState", map2);
                    break;
                case 2:
                    if (x2 > 0.0f && x2 < getWidth() && y > 0.0f && y < getHeight()) {
                        float f = this.b;
                        float f2 = this.iu;
                        this.rc.quadTo(f, f2, (f + x2) / 2.0f, (f2 + y) / 2.0f);
                        this.b = x2;
                        this.iu = y;
                    }
                    break;
            }
            postInvalidate();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.byazt.ch.c, com.byazt.iza.fw
    public float getRipple() {
        return this.hn;
    }

    public void setShine(float f) {
        zo zoVar = this.cz;
        if (zoVar != null) {
            zoVar.hn(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getShine() {
        return this.cz.getShine();
    }

    public void setStretch(float f) {
        zo zoVar = this.cz;
        if (zoVar != null) {
            zoVar.x(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getStretch() {
        return this.cz.getStretch();
    }

    public void setRubIn(float f) {
        zo zoVar = this.cz;
        if (zoVar != null) {
            zoVar.c(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getRubIn() {
        return this.cz.getRubIn();
    }

    public void setRipple(float f) {
        this.hn = f;
        zo zoVar = this.cz;
        if (zoVar != null) {
            zoVar.hw(f);
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.llk.c cVar = this.a;
        if (cVar != null) {
            cVar.pr(z);
        }
    }

    public void setBorderRadius(float f) {
        zo zoVar = this.cz;
        if (zoVar != null) {
            zoVar.pr(f);
        }
    }

    public float getBorderRadius() {
        return this.cz.pr();
    }

    public void setEraseEnabled(boolean z) {
        if (z) {
            this.rc = new Path();
            Paint paint = new Paint();
            this.z = paint;
            paint.setAntiAlias(true);
            this.z.setDither(true);
            this.z.setStyle(Paint.Style.STROKE);
            this.z.setStrokeWidth(this.fo * 2.0f);
            this.z.setStrokeCap(Paint.Cap.ROUND);
            this.z.setStrokeJoin(Paint.Join.ROUND);
            this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.z.setColor(0);
            this.ny = true;
        } else {
            this.ny = false;
        }
        postInvalidate();
    }

    public void setEraseRadius(float f) {
        this.fo = f;
        Paint paint = this.z;
        if (paint != null) {
            paint.setStrokeWidth(f * 2.0f);
        }
    }
}
