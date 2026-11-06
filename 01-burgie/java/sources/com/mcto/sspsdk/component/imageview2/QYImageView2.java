package com.mcto.sspsdk.component.imageview2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mcto.sspsdk.internal.a8;
import com.mcto.sspsdk.internal.ej;
import com.mcto.sspsdk.internal.gb;
import com.mcto.sspsdk.internal.gj;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.lj;
import com.mcto.sspsdk.internal.q3;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.u7;
import com.mcto.sspsdk.internal.wg;
import com.mcto.sspsdk.internal.z7;
import com.mcto.sspsdk.internal.zg;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class QYImageView2 extends AppCompatImageView {
    private final Handler a;
    private final RectF b;
    private final RectF c;
    private final Path d;
    private boolean e;
    private h f;
    private float g;
    private int h;
    private final Paint i;
    private boolean j;
    private final int k;
    private ej l;
    private String m;
    private Movie n;
    private long o;
    private int p;
    private final Matrix q;
    private float r;

    public QYImageView2(Context context) {
        super(context);
        this.a = new Handler(Looper.getMainLooper());
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Path();
        this.e = false;
        this.g = 0.0f;
        this.h = 0;
        Paint paint = new Paint(1);
        this.i = paint;
        this.j = false;
        this.k = 60;
        this.o = 0L;
        this.p = 0;
        this.q = new Matrix();
        this.r = 0.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0);
        if (getScaleType() == null) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bf  */
    @Override // android.widget.ImageView, android.view.View
    protected final void onDraw(Canvas canvas) {
        int iSave;
        float fMin;
        float f;
        float f2;
        float f3;
        float f4;
        if (!(this.g > 0.0f) || this.e || this.d.isEmpty()) {
            iSave = -1;
        } else {
            iSave = canvas.save();
            canvas.clipPath(this.d);
        }
        Movie movie = this.n;
        if (movie != null) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (this.o == 0) {
                this.o = jUptimeMillis;
            }
            movie.setTime((int) ((jUptimeMillis - this.o) % ((long) this.p)));
            int width = getWidth();
            int height = getHeight();
            int iWidth = movie.width();
            int iHeight = movie.height();
            if (iWidth <= 0 || iHeight <= 0 || width <= 0 || height <= 0) {
                movie.draw(canvas, 0.0f, 0.0f);
                postInvalidateOnAnimation();
            } else {
                ImageView.ScaleType scaleType = getScaleType();
                if (scaleType == null) {
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                Matrix matrix = this.q;
                matrix.reset();
                if (width > 0 && height > 0 && iWidth > 0 && iHeight > 0) {
                    float f5 = width;
                    float f6 = iWidth;
                    float f7 = f5 / f6;
                    float f8 = height;
                    float f9 = iHeight;
                    float f10 = f8 / f9;
                    switch (wg.a[scaleType.ordinal()]) {
                        case 1:
                            matrix.setScale(f7, f10);
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            fMin = Math.min(f7, f10);
                            f = f5 - (f6 * fMin);
                            f2 = f * 0.5f;
                            f3 = f8 - (f9 * fMin);
                            f4 = f3 * 0.5f;
                            matrix.setScale(fMin, fMin);
                            if (scaleType == ImageView.ScaleType.FIT_START) {
                                f3 = 0.0f;
                                f2 = 0.0f;
                            } else if (scaleType == ImageView.ScaleType.FIT_END) {
                                f2 = f;
                            } else if (scaleType == ImageView.ScaleType.CENTER) {
                                matrix.reset();
                                f3 = (height - iHeight) * 0.5f;
                                f2 = (width - iWidth) * 0.5f;
                            } else {
                                f3 = f4;
                            }
                            matrix.postTranslate(f2, f3);
                            break;
                        default:
                            fMin = Math.max(f7, f10);
                            f = f5 - (f6 * fMin);
                            f2 = f * 0.5f;
                            f3 = f8 - (f9 * fMin);
                            f4 = f3 * 0.5f;
                            matrix.setScale(fMin, fMin);
                            if (scaleType == ImageView.ScaleType.FIT_START) {
                                f3 = 0.0f;
                                f2 = 0.0f;
                            } else if (scaleType == ImageView.ScaleType.FIT_END) {
                                f2 = f;
                            } else if (scaleType == ImageView.ScaleType.CENTER) {
                                matrix.reset();
                                f3 = (height - iHeight) * 0.5f;
                                f2 = (width - iWidth) * 0.5f;
                            } else {
                                f3 = f4;
                            }
                            matrix.postTranslate(f2, f3);
                            break;
                    }
                }
                int iSave2 = canvas.save();
                canvas.concat(this.q);
                movie.draw(canvas, 0.0f, 0.0f);
                canvas.restoreToCount(iSave2);
                postInvalidateOnAnimation();
            }
        } else {
            super.onDraw(canvas);
        }
        if (iSave != -1) {
            canvas.restoreToCount(iSave);
        }
        int i = this.h;
        if (i > 0) {
            float f11 = i / 2.0f;
            int width2 = getWidth();
            int height2 = getHeight();
            if (width2 <= 0 || height2 <= 0) {
                return;
            }
            this.b.set(f11, f11, width2 - f11, height2 - f11);
            float fMax = Math.max(0.0f, this.g - f11);
            if (fMax > 0.0f) {
                canvas.drawRoundRect(this.b, fMax, fMax, this.i);
            } else {
                canvas.drawRect(this.b, this.i);
            }
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a(i, i2);
    }

    public final void b(String str) {
        this.m = str;
        b();
        if (lj.b(str)) {
            a(0);
            return;
        }
        try {
            SystemClock.uptimeMillis();
            Bitmap bitmap = (Bitmap) u7.a(getContext()).a.get(gj.d(str));
            if (bitmap != null) {
                if (r9.a == 0) {
                    bitmap.getByteCount();
                    SystemClock.uptimeMillis();
                }
                a(bitmap);
                return;
            }
        } catch (Throwable th) {
        }
        Context context = getContext();
        if (z7.d == null) {
            synchronized (z7.class) {
                if (z7.d == null) {
                    z7.d = new z7(context.getApplicationContext());
                }
            }
        }
        z7 z7Var = z7.d;
        gb gbVar = new gb(this, str);
        z7Var.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        String strD = gj.d(str);
        Bitmap bitmap2 = (Bitmap) z7Var.a.a.get(strD);
        if (bitmap2 == null) {
            zg.a.a(new a(z7Var, strD, gbVar, str, jUptimeMillis));
            return;
        }
        SystemClock.uptimeMillis();
        bitmap2.getByteCount();
        if (str.equals(this.m)) {
            a(bitmap2);
        }
    }

    public final float c() {
        return this.r;
    }

    public final void d() {
        this.j = true;
        a();
        invalidate();
    }

    public final void e() {
        this.g = hk.a(getContext(), 10);
        int iA = hk.a(getContext(), 0);
        this.h = iA;
        this.i.setStrokeWidth(iA);
        this.i.setColor(0);
        a(getWidth(), getHeight());
        invalidate();
    }

    static void a(QYImageView2 qYImageView2, byte[] bArr, String str) {
        byte b;
        qYImageView2.getClass();
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                qYImageView2.a.post(new e(qYImageView2, ImageDecoder.decodeDrawable(ImageDecoder.createSource(ByteBuffer.wrap(bArr)))));
                return;
            } catch (Throwable th) {
                r9.a("ssp_ImageView2", "decode animated drawable failed, fallback to Movie", th);
            }
        }
        if (bArr != null && bArr.length >= 6 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (((b = bArr[4]) == 55 || b == 57) && bArr[5] == 97)) {
            try {
                Movie movieDecodeByteArray = Movie.decodeByteArray(bArr, 0, bArr.length);
                if (movieDecodeByteArray == null) {
                    qYImageView2.a(0);
                    return;
                } else {
                    qYImageView2.a.post(new f(movieDecodeByteArray, qYImageView2, str));
                    return;
                }
            } catch (Throwable th2) {
                r9.a("ssp_ImageView2", "Movie.decodeByteArray failed", th2);
                qYImageView2.a(0);
                return;
            }
        }
        try {
            Bitmap bitmapA = a8.a(bArr, null, 0, 0);
            if (bitmapA == null) {
                qYImageView2.a(0);
            } else {
                qYImageView2.a(bitmapA);
            }
        } catch (Throwable th3) {
            r9.a("ssp_ImageView2", "decode bitmap failed: " + str, th3);
            qYImageView2.a(0);
        }
    }

    public QYImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Handler(Looper.getMainLooper());
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Path();
        this.e = false;
        this.g = 0.0f;
        this.h = 0;
        Paint paint = new Paint(1);
        this.i = paint;
        this.j = false;
        this.k = 60;
        this.o = 0L;
        this.p = 0;
        this.q = new Matrix();
        this.r = 0.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0);
        if (getScaleType() == null) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    static void b(QYImageView2 qYImageView2, int i) {
        qYImageView2.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.n = null;
        this.o = 0L;
        this.p = 0;
        Drawable drawable = getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        try {
            ((AnimatedImageDrawable) drawable).stop();
        } catch (Throwable th) {
        }
    }

    public final void a(ej ejVar) {
        this.l = ejVar;
    }

    public final void a(String str) {
        File file = new File(str);
        String str2 = "file:" + str + ":" + file.lastModified() + ":" + file.length();
        this.m = str2;
        b();
        if (!lj.b(str) && file.exists() && file.isFile() && file.length() > 0) {
            zg.a.a(new c(this, str2, file, str));
        } else {
            a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        b();
        if (this.j && Build.VERSION.SDK_INT < 31) {
            float f = 25.0f;
            float fMin = Math.min(25.0f, Math.max(1.0f, this.k));
            if (fMin < 0.0f) {
                f = 0.0f;
            } else if (fMin <= 25.0f) {
                f = fMin;
            }
            bitmap = q3.a(getContext(), bitmap, f);
        }
        this.r = bitmap.getWidth() / bitmap.getHeight();
        this.a.post(new d(this, bitmap));
    }

    static void a(Movie movie, QYImageView2 qYImageView2, String str) {
        qYImageView2.a.post(new f(movie, qYImageView2, str));
    }

    private void a(int i) {
        if (this.l == null) {
            return;
        }
        this.a.post(new g(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            RenderEffect renderEffectCreateBlurEffect = null;
            if (this.j && this.k > 0) {
                float fA = hk.a(getContext(), this.k);
                if (i >= 31 && fA > 0.0f) {
                    renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(fA, fA, Shader.TileMode.CLAMP);
                }
                setRenderEffect(renderEffectCreateBlurEffect);
                return;
            }
            setRenderEffect(null);
        }
    }

    public QYImageView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Handler(Looper.getMainLooper());
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Path();
        this.e = false;
        this.g = 0.0f;
        this.h = 0;
        Paint paint = new Paint(1);
        this.i = paint;
        this.j = false;
        this.k = 60;
        this.o = 0L;
        this.p = 0;
        this.q = new Matrix();
        this.r = 0.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0);
        if (getScaleType() == null) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    private void a(int i, int i2) {
        this.d.reset();
        if (i <= 0 || i2 <= 0) {
            setClipToOutline(false);
            this.e = false;
            return;
        }
        if (this.g > 0.0f) {
            this.e = true;
            if (this.f == null) {
                h hVar = new h(this);
                this.f = hVar;
                setOutlineProvider(hVar);
            }
            setClipToOutline(true);
            invalidateOutline();
            return;
        }
        setClipToOutline(false);
        this.e = false;
        if (this.g <= 0.0f) {
            return;
        }
        this.c.set(0.0f, 0.0f, i - 0.0f, i2 - 0.0f);
        Path path = this.d;
        RectF rectF = this.c;
        float f = this.g;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }
}
