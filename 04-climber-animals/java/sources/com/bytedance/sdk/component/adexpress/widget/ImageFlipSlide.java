package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.adexpress.d.xr;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.ch;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.c.x;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImageFlipSlide extends View {
    private final Rect ab;
    private Bitmap ah;
    private final Rect c;
    private List<String> d;
    private Path ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Paint f946ms;
    private final boolean x;
    private float xr;

    public ImageFlipSlide(Context context, boolean z) {
        super(context);
        this.xr = 0.1f;
        this.c = new Rect();
        this.ab = new Rect();
        this.x = z;
    }

    public void ms(String str, String str2, List<String> list) {
        final ch chVarXr = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ka().ms(str).xr(str2);
        this.d = list;
        chVarXr.ms(Bitmap.Config.ARGB_4444).ah(2);
        if (getBlurPx() != 0) {
            chVarXr.ms(new x() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.1
                @Override // com.bytedance.sdk.component.c.x
                @ATSMethod(1)
                public Bitmap ms(Bitmap bitmap) {
                    try {
                        return xr.ms(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception unused) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                chVarXr.ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2.1
                    @Override // com.bytedance.sdk.component.c.ao
                    @ATSMethod(2)
                    public void ms(int i, String str3, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.c.ao
                    @ATSMethod(1)
                    public void ms(hi<Bitmap> hiVar) {
                        try {
                            ImageFlipSlide.this.ah = ImageFlipSlide.this.ms(hiVar.ah(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception unused) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.f946ms = paint;
        paint.setAntiAlias(true);
        this.f946ms.setDither(true);
        if (this.x) {
            this.f946ms.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.d;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        for (int i = 0; i < this.d.size(); i++) {
            ms(colorMatrix, this.d.get(i));
        }
        this.f946ms.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private void ms(ColorMatrix colorMatrix, String str) {
        try {
            ColorMatrix colorMatrix2 = new ColorMatrix();
            if (str.startsWith("hue-rotate")) {
                colorMatrix2.setRotate(0, Integer.parseInt(str.split("\\(")[1].split("deg")[0]));
            } else if (str.startsWith("grayscale") || str.startsWith("contrast")) {
                colorMatrix2.setSaturation(Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f);
            } else if (str.startsWith("invert")) {
                float f = (Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f) * 255.0f;
                colorMatrix2.set(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, -1.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, -1.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            } else if (str.startsWith("sepia")) {
                float f2 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                colorMatrix2.setScale(f2, f2, 1.0f, 1.0f);
            } else if (str.startsWith("brightness")) {
                float f3 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                colorMatrix2.setScale(f3, f3, f3, 1.0f);
            }
            colorMatrix.postConcat(colorMatrix2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurPx() {
        if (this.d == null) {
            return 0;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).contains("blur")) {
                return Integer.parseInt(this.d.get(i).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    public void ms(float f) {
        this.xr = f;
        invalidate();
    }

    public void ms(Path path) {
        this.ka = path;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.ah;
        if (bitmap == null) {
            return;
        }
        if (this.x) {
            this.c.left = (int) (bitmap.getWidth() * (1.0f - this.xr));
            this.c.right = this.ah.getWidth();
            this.c.top = 0;
            this.c.bottom = this.ah.getHeight();
            this.ab.left = (int) (getWidth() * (1.0f - this.xr));
            this.ab.right = getWidth();
            this.ab.top = 0;
            this.ab.bottom = getHeight();
            canvas.drawBitmap(this.ah, this.c, this.ab, this.f946ms);
            return;
        }
        canvas.clipPath(this.ka);
        canvas.drawBitmap(this.ah, 0.0f, 0.0f, this.f946ms);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap ms(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i;
        float f2 = (width * 1.0f) / f;
        float f3 = i2;
        float f4 = (height * 1.0f) / f3;
        Matrix matrix = new Matrix();
        int i6 = 0;
        if (f4 > f2) {
            int i7 = (int) (f3 * f2);
            float f5 = 1.0f / f2;
            matrix.setScale(f5, f5);
            i4 = i7;
            i3 = width;
            i5 = (height / 2) - (i7 / 2);
        } else {
            int i8 = (int) (f * f4);
            float f6 = 1.0f / f4;
            matrix.setScale(f6, f6);
            i3 = i8;
            i4 = height;
            i5 = 0;
            i6 = (width / 2) - (i8 / 2);
        }
        return Bitmap.createBitmap(bitmap, i6, i5, i3, i4, matrix, false);
    }
}
