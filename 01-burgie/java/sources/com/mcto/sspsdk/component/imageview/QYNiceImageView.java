package com.mcto.sspsdk.component.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.mcto.sspsdk.internal.a8;
import com.mcto.sspsdk.internal.ac;
import com.mcto.sspsdk.internal.bc;
import com.mcto.sspsdk.internal.cc;
import com.mcto.sspsdk.internal.dc;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.lj;
import com.mcto.sspsdk.internal.pk;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.v7;
import com.mcto.sspsdk.internal.w3;
import com.mcto.sspsdk.internal.zg;

/* JADX INFO: loaded from: classes2.dex */
public class QYNiceImageView extends AppCompatImageView {
    private final Handler a;
    private final RectF b;
    private final RectF c;
    private final Path d;
    private final Path e;
    private final Paint f;
    private w3 g;
    private boolean h;
    private boolean i;
    private float j;
    private final a k;
    private float l;
    private int m;
    private int n;

    public QYNiceImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Handler(Looper.getMainLooper());
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Path();
        this.e = new Path();
        Paint paint = new Paint(1);
        this.f = paint;
        this.h = false;
        this.i = false;
        this.j = 0.0f;
        this.k = new a(this);
        this.l = 0.0f;
        this.m = 0;
        this.n = 0;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0);
    }

    public final void b() {
        this.i = true;
    }

    public final void c() {
        this.h = true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (this.l <= 0.0f || this.e.isEmpty()) {
            super.onDraw(canvas);
        } else {
            canvas.save();
            canvas.clipPath(this.e);
            super.onDraw(canvas);
            canvas.restore();
        }
        if (this.m <= 0 || this.d.isEmpty()) {
            return;
        }
        canvas.drawPath(this.d, this.f);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a(i, i2);
    }

    public final void a(String str) {
        if (lj.b(str)) {
            if (this.g != null) {
                this.a.post(new b(this, 0));
            }
        } else {
            a8 a8VarA = a8.a(getContext());
            a aVar = this.k;
            a8VarA.getClass();
            zg.a.a(new v7(a8VarA, str, aVar, 0, 0));
        }
    }

    static void a(QYNiceImageView qYNiceImageView, Bitmap bitmap) {
        Bitmap bitmapA;
        if (qYNiceImageView.h) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float width2 = (width * 1.0f) / bitmap.getWidth();
            float height2 = (height * 1.0f) / bitmap.getHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            int i = height > width ? width >> 1 : height >> 1;
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint(1);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            Matrix matrix = new Matrix();
            matrix.setScale(width2, height2);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            canvas.drawCircle(width >> 1, height >> 1, i, paint);
            qYNiceImageView.j = bitmapCreateBitmap.getWidth() / bitmapCreateBitmap.getHeight();
            qYNiceImageView.a.post(new ac(qYNiceImageView, bitmapCreateBitmap));
            return;
        }
        if (qYNiceImageView.i) {
            if (Build.VERSION.SDK_INT >= 31) {
                qYNiceImageView.j = bitmap.getWidth() / bitmap.getHeight();
                qYNiceImageView.a.post(new bc(qYNiceImageView, bitmap));
                return;
            }
            try {
                bitmapA = pk.a(qYNiceImageView.getContext(), bitmap);
            } catch (Throwable th) {
                r9.a("ssp_ImageLoad", "blur", th);
                bitmapA = null;
            }
            if (bitmapA != null) {
                qYNiceImageView.j = bitmapA.getWidth() / bitmapA.getHeight();
                qYNiceImageView.a.post(new cc(qYNiceImageView, bitmapA));
                return;
            }
            return;
        }
        qYNiceImageView.j = bitmap.getWidth() / bitmap.getHeight();
        qYNiceImageView.a.post(new dc(qYNiceImageView, bitmap));
    }

    public final void a(w3 w3Var) {
        this.g = w3Var;
    }

    public final void a(int i, int i2, int i3) {
        this.l = hk.a(getContext(), i);
        int iA = hk.a(getContext(), i2);
        this.m = iA;
        this.n = i3;
        this.f.setStrokeWidth(iA);
        if (this.m > 0) {
            this.f.setColor(this.n);
        } else {
            this.f.setColor(0);
        }
        a(getWidth(), getHeight());
        invalidate();
    }

    private void a(int i, int i2) {
        this.e.reset();
        this.d.reset();
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.l > 0.0f || this.m > 0) {
            float f = this.m;
            float f2 = i;
            float f3 = i2;
            this.c.set(f, f, f2 - f, f3 - f);
            float fMax = Math.max(0.0f, this.l - this.m);
            if (fMax <= 0.0f && this.m <= 0) {
                this.e.addRect(0.0f, 0.0f, f2, f3, Path.Direction.CW);
            } else {
                this.e.addRoundRect(this.c, fMax, fMax, Path.Direction.CW);
            }
            int i3 = this.m;
            if (i3 > 0) {
                float f4 = i3 / 2.0f;
                this.b.set(f4, f4, f2 - f4, f3 - f4);
                float fMax2 = Math.max(0.0f, this.l - f4);
                this.d.addRoundRect(this.b, fMax2, fMax2, Path.Direction.CW);
            }
        }
    }

    static void a(QYNiceImageView qYNiceImageView, int i) {
        if (qYNiceImageView.g != null) {
            qYNiceImageView.a.post(new b(qYNiceImageView, i));
        }
    }

    public final float a() {
        return this.j;
    }

    public QYNiceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Handler(Looper.getMainLooper());
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Path();
        this.e = new Path();
        Paint paint = new Paint(1);
        this.f = paint;
        this.h = false;
        this.i = false;
        this.j = 0.0f;
        this.k = new a(this);
        this.l = 0.0f;
        this.m = 0;
        this.n = 0;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0);
    }

    public QYNiceImageView(Context context) {
        super(context);
        this.a = new Handler(Looper.getMainLooper());
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Path();
        this.e = new Path();
        Paint paint = new Paint(1);
        this.f = paint;
        this.h = false;
        this.i = false;
        this.j = 0.0f;
        this.k = new a(this);
        this.l = 0.0f;
        this.m = 0;
        this.n = 0;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0);
    }
}
