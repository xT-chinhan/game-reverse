package com.byazt.jm;

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
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.byazt.kg.fs;
import com.byazt.kg.x;
import com.byazt.vh.l;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 918, 1851})
public class RoundImageView extends ImageView implements x, l {
    public static final Shader.TileMode n = Shader.TileMode.CLAMP;
    public static final ImageView.ScaleType[] q = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public static final /* synthetic */ boolean qg = true;
    public com.byazt.gu.l a;
    public Bitmap bb;
    public Shader.TileMode cd;
    public Drawable cp;
    public int cy;
    public boolean d;
    public float fs;
    public float h;
    public ImageView.ScaleType hd;
    public Paint hu;
    public int k;
    public final float[] l;
    public final RectF ln;
    public Path m;
    public boolean oa;
    public boolean ou;
    public fs py;
    public ColorFilter rv;
    public float s;
    public boolean sz;
    public float t;
    public boolean tj;
    public Shader.TileMode um;
    public Canvas ur;
    public Drawable w;
    public float wm;
    public ColorStateList x;

    public RoundImageView(Context context) {
        super(context);
        this.l = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.x = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.fs = 0.0f;
        this.rv = null;
        this.tj = false;
        this.d = false;
        this.oa = false;
        this.sz = false;
        Shader.TileMode tileMode = n;
        this.cd = tileMode;
        this.um = tileMode;
        this.ou = false;
        this.wm = 50.0f;
        this.ln = new RectF();
        this.py = new fs(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.hd;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!qg && scaleType == null) {
            throw new AssertionError();
        }
        if (this.hd != scaleType) {
            this.hd = scaleType;
            int i = AnonymousClass1.n[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            s();
            n(false);
            invalidate();
        }
    }

    /* JADX INFO: renamed from: com.byazt.jm.RoundImageView$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 918, 1643})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            n = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.k = 0;
        this.cp = qg.n(drawable);
        s();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.k = 0;
        this.cp = qg.n(bitmap);
        s();
        super.setImageDrawable(this.cp);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.k != i) {
            this.k = i;
            this.cp = n();
            s();
            super.setImageDrawable(this.cp);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable n() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.k;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception unused) {
                this.k = 0;
            }
        }
        return qg.n(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.cy != i) {
            this.cy = i;
            Drawable drawableQg = qg();
            this.w = drawableQg;
            setBackgroundDrawable(drawableQg);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.w = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    private Drawable qg() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.cy;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception unused) {
                this.cy = 0;
            }
        }
        return qg.n(drawable);
    }

    private void s() {
        n(this.cp, this.hd);
    }

    private void n(boolean z) {
        if (this.sz) {
            if (z) {
                this.w = qg.n(this.w);
            }
            n(this.w, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.rv != colorFilter) {
            this.rv = colorFilter;
            this.d = true;
            this.tj = true;
            q();
            invalidate();
        }
    }

    private void q() {
        Drawable drawable = this.cp;
        if (drawable == null || !this.tj) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.cp = drawableMutate;
        if (this.d) {
            drawableMutate.setColorFilter(this.rv);
        }
    }

    private void n(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof qg) {
            qg qgVar = (qg) drawable;
            qgVar.n(scaleType).n(this.fs).n(this.x).n(this.oa).n(this.cd).qg(this.um);
            float[] fArr = this.l;
            if (fArr != null) {
                qgVar.n(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            q();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                n(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.w = drawable;
        n(true);
        super.setBackgroundDrawable(this.w);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.l) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        n(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadius(float f) {
        n(f, f, f, f);
    }

    public void n(float f, float f2, float f3, float f4) {
        float[] fArr = this.l;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        s();
        n(false);
        invalidate();
    }

    public float getBorderWidth() {
        return this.fs;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.fs == f) {
            return;
        }
        this.fs = f;
        s();
        n(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.x.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.x;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.x.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.x = colorStateList;
        s();
        n(false);
        if (this.fs > 0.0f) {
            invalidate();
        }
    }

    public void setOval(boolean z) {
        this.oa = z;
        s();
        n(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.cd;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.cd == tileMode) {
            return;
        }
        this.cd = tileMode;
        s();
        n(false);
        invalidate();
    }

    public Shader.TileMode getTileModeY() {
        return this.um;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.um == tileMode) {
            return;
        }
        this.um = tileMode;
        s();
        n(false);
        invalidate();
    }

    public void n(com.byazt.gu.l lVar) {
        this.a = lVar;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        com.byazt.gu.l lVar = this.a;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            super.onMeasure(iArrN[0], iArrN[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.byazt.gu.l lVar = this.a;
        if (lVar != null) {
            lVar.n(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (this.ou && (canvas2 = this.ur) != null && this.bb != null) {
            super.onDraw(canvas2);
            this.ur.drawPath(this.m, this.hu);
            canvas.drawBitmap(this.bb, 0.0f, 0.0f, (Paint) null);
        } else {
            super.onDraw(canvas);
        }
        com.byazt.gu.l lVar = this.a;
        if (lVar != null) {
            lVar.n(canvas, this);
            this.a.n(canvas);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        com.byazt.gu.l lVar = this.a;
        if (lVar != null) {
            lVar.qg(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.gu.l lVar = this.a;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i3);
        }
        if (i <= 0 || i2 <= 0 || !this.ou) {
            return;
        }
        this.bb = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.ur = new Canvas(this.bb);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.gu.l lVar = this.a;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.byazt.gu.l lVar = this.a;
        if (lVar != null) {
            lVar.w();
        }
        Canvas canvas = this.ur;
        if (canvas != null) {
            canvas.setBitmap(null);
        }
        Bitmap bitmap = this.bb;
        if (bitmap != null) {
            bitmap.recycle();
            this.ur = null;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iWidth;
        if (this.ou) {
            this.a.l();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.m.moveTo(x, y);
                this.h = x;
                this.t = y;
                HashMap map = new HashMap();
                map.put(WebLoginFragment.QUERY_KEY_ID, 1);
                this.a.n("eraseState", map);
            } else if (action == 1) {
                this.m.computeBounds(this.ln, true);
                try {
                    iWidth = (int) (((this.ln.width() * this.ln.height()) / (getWidth() * getHeight())) * 100.0f);
                } catch (Exception unused) {
                    iWidth = 0;
                }
                HashMap map2 = new HashMap();
                map2.put(WebLoginFragment.QUERY_KEY_ID, 2);
                map2.put("percent", Integer.valueOf(iWidth));
                this.a.n("eraseState", map2);
            } else if (action == 2 && x > 0.0f && x < getWidth() && y > 0.0f && y < getHeight()) {
                float f = this.h;
                float f2 = this.t;
                this.m.quadTo(f, f2, (f + x) / 2.0f, (f2 + y) / 2.0f);
                this.h = x;
                this.t = y;
            }
            postInvalidate();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.byazt.kg.x
    public float getRipple() {
        return this.s;
    }

    public void setShine(float f) {
        fs fsVar = this.py;
        if (fsVar != null) {
            fsVar.s(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getShine() {
        return this.py.getShine();
    }

    public void setStretch(float f) {
        fs fsVar = this.py;
        if (fsVar != null) {
            fsVar.q(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getStretch() {
        return this.py.getStretch();
    }

    public void setRubIn(float f) {
        fs fsVar = this.py;
        if (fsVar != null) {
            fsVar.l(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getRubIn() {
        return this.py.getRubIn();
    }

    public void setRipple(float f) {
        this.s = f;
        fs fsVar = this.py;
        if (fsVar != null) {
            fsVar.qg(f);
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.gu.l lVar = this.a;
        if (lVar != null) {
            lVar.n(z);
        }
    }

    public void setBorderRadius(float f) {
        fs fsVar = this.py;
        if (fsVar != null) {
            fsVar.n(f);
        }
    }

    public float getBorderRadius() {
        return this.py.n();
    }

    public void setEraseEnabled(boolean z) {
        if (z) {
            this.m = new Path();
            Paint paint = new Paint();
            this.hu = paint;
            paint.setAntiAlias(true);
            this.hu.setDither(true);
            this.hu.setStyle(Paint.Style.STROKE);
            this.hu.setStrokeWidth(this.wm * 2.0f);
            this.hu.setStrokeCap(Paint.Cap.ROUND);
            this.hu.setStrokeJoin(Paint.Join.ROUND);
            this.hu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.hu.setColor(0);
            this.ou = true;
        } else {
            this.ou = false;
        }
        postInvalidate();
    }

    public void setEraseRadius(float f) {
        this.wm = f;
        Paint paint = this.hu;
        if (paint != null) {
            paint.setStrokeWidth(f * 2.0f);
        }
    }
}
