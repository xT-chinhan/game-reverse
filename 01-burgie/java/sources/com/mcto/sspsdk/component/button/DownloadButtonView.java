package com.mcto.sspsdk.component.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.internal.c1;
import com.mcto.sspsdk.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadButtonView extends AppCompatTextView {
    private int a;
    private int b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final Paint h;
    private final Paint i;
    private final Paint j;
    private final RectF k;
    private final RectF l;
    private CharSequence m;
    private final PorterDuffXfermode n;
    private final PorterDuffXfermode o;
    private h p;
    private int q;
    private String r;
    private String s;
    private boolean t;

    public DownloadButtonView(Context context) {
        this(context, null);
    }

    private void e(int i) {
        switch (i) {
            case 1:
                if (this.a != 0) {
                    this.m = "已下载 " + this.a + "%";
                } else {
                    this.m = "下载中";
                }
                break;
            case 2:
                this.m = "继续下载";
                break;
            case 3:
            case 4:
            default:
                this.m = this.s;
                break;
            case 5:
                this.m = "立即安装";
                break;
            case 6:
                this.m = "重新下载";
                break;
            case 7:
                this.m = "打开应用";
                break;
        }
    }

    public final void a(h hVar) {
        this.p = hVar;
    }

    public final CharSequence b() {
        return this.m;
    }

    public final int c() {
        return this.q;
    }

    public final void d(int i) {
        if (this.q != i) {
            e(i);
            this.q = i;
            postInvalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h hVar = this.p;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.p;
        if (hVar == null || hVar.c == null) {
            return;
        }
        if (hVar.b == null) {
            hVar.b = c1.a();
        }
        c1 c1Var = hVar.b;
        if (c1Var != null) {
            c1Var.b(hVar.c, hVar.d);
        }
        hVar.c = null;
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.l;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getMeasuredWidth();
        this.l.bottom = getMeasuredHeight();
        int i = this.q;
        if (i == 1) {
            a(canvas, this.l, this.a);
        } else if (i == 5 || i == 7) {
            a(canvas, this.l, 100.0f);
        } else {
            a(canvas, this.l, 0.0f);
        }
        if (this.t) {
            return;
        }
        float height = ((canvas.getHeight() - this.i.descent()) - this.i.ascent()) / 2.0f;
        if (TextUtils.isEmpty(this.m)) {
            this.m = TextUtils.isEmpty(this.s) ? "立即下载" : this.s;
        }
        float fMeasureText = this.i.measureText(this.m.toString());
        int i2 = this.q;
        if (i2 != 1 && i2 != 5 && i2 != 7) {
            this.i.setShader(null);
            this.i.setColor(this.e);
            canvas.drawText(this.m.toString(), (getMeasuredWidth() - fMeasureText) / 2.0f, height, this.i);
            return;
        }
        int i3 = i2 == 1 ? this.a : 100;
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.i, 31);
        this.i.setShader(null);
        this.i.setColor(this.e);
        canvas.drawText(this.m.toString(), (getMeasuredWidth() - fMeasureText) / 2.0f, height, this.i);
        this.i.setXfermode(this.o);
        this.i.setColor(this.f);
        float measuredWidth = (getMeasuredWidth() * i3) / 100.0f;
        RectF rectF2 = this.k;
        rectF2.left = 0.0f;
        rectF2.top = 0.0f;
        rectF2.right = measuredWidth;
        rectF2.bottom = getMeasuredHeight();
        canvas.drawRect(this.k, this.i);
        this.i.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        this.i.setColor(this.e);
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        if (this.c == null && i == this.b) {
            return;
        }
        this.c = null;
        this.b = i;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText("", bufferType);
    }

    @Override // android.widget.TextView
    public final void setTextColor(int i) {
        if (i != this.e) {
            super.setTextColor(i);
            this.e = i;
            postInvalidate();
        }
    }

    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.i.setTextSize(getTextSize());
    }

    public DownloadButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas, RectF rectF, float f) {
        canvas.save();
        int[] iArr = this.c;
        if (iArr == null || iArr.length < 2) {
            this.h.setColor(this.b);
        } else {
            Paint paint = this.h;
            double radians = Math.toRadians(0);
            float fCenterX = rectF.centerX();
            float fCenterY = rectF.centerY();
            float fWidth = rectF.width() / 2.0f;
            float fHeight = rectF.height() / 2.0f;
            float fCos = (float) (Math.cos(radians) * ((double) fWidth));
            float fSin = (float) (Math.sin(radians) * ((double) fHeight));
            paint.setShader(new LinearGradient(fCenterX - fCos, fCenterY - fSin, fCos + fCenterX, fCenterY + fSin, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
        float f2 = this.g;
        canvas.drawRoundRect(rectF, f2, f2, this.h);
        if (f != 0.0f) {
            this.h.setXfermode(this.n);
            float f3 = rectF.right * (f / 100.0f);
            this.h.setColor(this.d);
            canvas.drawRect(rectF.left, rectF.top, f3, rectF.bottom, this.h);
            this.h.setXfermode(null);
            this.h.setShader(null);
        }
        canvas.restore();
    }

    public final void b(int i) {
        if (this.g != i) {
            this.g = i;
            postInvalidate();
        }
    }

    public final void c(int i) {
        if (i < 0 || i > 100) {
            if (i < 0) {
                this.a = 0;
                return;
            } else {
                this.a = 100;
                return;
            }
        }
        this.a = i;
        int i2 = this.q;
        if (i2 == 1) {
            e(i2);
        }
        postInvalidate();
    }

    public DownloadButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = "立即下载";
        this.n = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.o = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.q = 0;
        this.s = "立即下载";
        this.t = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.qy_download_button_view);
        try {
            this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.qy_download_button_view_qy_background_color, -119723);
            this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.qy_download_button_view_qy_background_cover_color, -2611896);
            this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.qy_download_button_view_qy_text_cover_color, -1);
            this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.qy_download_button_view_qy_default_text_color, -1);
            this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.qy_download_button_view_qy_radius, (int) ((context.getResources().getDisplayMetrics().density * 40.0f) + 0.5f));
            typedArrayObtainStyledAttributes.recycle();
            this.a = 0;
            Paint paint = new Paint();
            this.h = paint;
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.i = paint2;
            paint2.setAntiAlias(true);
            paint2.setTextSize(getTextSize());
            this.k = new RectF();
            this.l = new RectF();
            Paint paint3 = new Paint();
            this.j = paint3;
            paint3.setAntiAlias(true);
            paint3.setStyle(Paint.Style.STROKE);
            if (Build.VERSION.SDK_INT >= 23) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(6000.0f);
                gradientDrawable.setColor(-1);
                setForeground(new RippleDrawable(ColorStateList.valueOf(436207616), null, gradientDrawable));
            }
            setLayerType(1, paint2);
            invalidate();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b(String str) {
        this.s = str;
        this.m = str;
        invalidate();
    }

    public final void d() {
        if (-1 != this.f) {
            this.f = -1;
            postInvalidate();
        }
    }

    public final void a(int[] iArr) {
        int[] iArr2 = this.c;
        if (iArr2 != null && iArr.length == iArr2.length) {
            for (int i = 0; i < iArr.length; i++) {
                if (iArr[i] == iArr2[i]) {
                }
            }
            return;
        }
        this.c = iArr;
        postInvalidate();
    }

    public final void a(int i) {
        if (i != this.d) {
            this.d = i;
            postInvalidate();
        }
    }

    public final String a() {
        return this.r;
    }

    public final void a(String str) {
        this.r = str;
    }

    public final void a(boolean z) {
        this.t = z;
    }
}
