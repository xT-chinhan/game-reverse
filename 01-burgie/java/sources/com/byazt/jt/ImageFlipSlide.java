package com.byazt.jt;

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
import com.byazt.js.hw;
import com.byazt.ld.g;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.ld.vk;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1158})
public class ImageFlipSlide extends View {
    public Path c;
    public final Rect fw;
    public Bitmap hn;
    public float hw;
    public Paint pr;
    public final Rect uc;
    public List<String> x;
    public final boolean zo;

    public ImageFlipSlide(Context context, boolean z) {
        super(context);
        this.hw = 0.1f;
        this.uc = new Rect();
        this.fw = new Rect();
        this.zo = z;
    }

    public void pr(String str, String str2, List<String> list) {
        final g gVarHw = com.byazt.bg.pr.pr().c().pr(str).hw(str2);
        this.x = list;
        gVarHw.pr(Bitmap.Config.ARGB_4444).hn(2);
        if (getBlurPx() != 0) {
            gVarHw.pr(new vk() { // from class: com.byazt.jt.ImageFlipSlide.1
                @Override // com.byazt.ld.vk
                public Bitmap pr(Bitmap bitmap) {
                    try {
                        return hw.pr(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception e) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.byazt.jt.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                gVarHw.pr(new rc<Bitmap>() { // from class: com.byazt.jt.ImageFlipSlide.2.1
                    @Override // com.byazt.ld.rc
                    public void pr(nt<Bitmap> ntVar) {
                        try {
                            ImageFlipSlide.this.hn = ImageFlipSlide.this.pr(ntVar.hn(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception e) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }

                    @Override // com.byazt.ld.rc
                    public void pr(int i, String str3, Throwable th) {
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.pr = paint;
        paint.setAntiAlias(true);
        this.pr.setDither(true);
        if (this.zo) {
            this.pr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.x;
        if (list2 != null && list2.size() > 0) {
            ColorMatrix colorMatrix = new ColorMatrix();
            for (int i = 0; i < this.x.size(); i++) {
                pr(colorMatrix, this.x.get(i));
            }
            this.pr.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        }
    }

    private void pr(ColorMatrix colorMatrix, String str) {
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
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurPx() {
        if (this.x == null) {
            return 0;
        }
        for (int i = 0; i < this.x.size(); i++) {
            if (this.x.get(i).contains("blur")) {
                return Integer.parseInt(this.x.get(i).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    public void pr(float f) {
        this.hw = f;
        invalidate();
    }

    public void pr(Path path) {
        this.c = path;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.hn;
        if (bitmap == null) {
            return;
        }
        if (this.zo) {
            this.uc.left = (int) (bitmap.getWidth() * (1.0f - this.hw));
            this.uc.right = this.hn.getWidth();
            this.uc.top = 0;
            this.uc.bottom = this.hn.getHeight();
            this.fw.left = (int) (getWidth() * (1.0f - this.hw));
            this.fw.right = getWidth();
            this.fw.top = 0;
            this.fw.bottom = getHeight();
            canvas.drawBitmap(this.hn, this.uc, this.fw, this.pr);
            return;
        }
        canvas.clipPath(this.c);
        canvas.drawBitmap(this.hn, 0.0f, 0.0f, this.pr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap pr(Bitmap bitmap, int i, int i2) {
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
