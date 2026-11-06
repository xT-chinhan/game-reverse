package com.byazt.stl;

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
import com.byazt.cq.qg;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.si.sz;
import com.byazt.si.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1271})
public class ImageFlipSlide extends View {
    public final boolean fs;
    public Path l;
    public Paint n;
    public List<String> q;
    public float qg;
    public Bitmap s;
    public final Rect w;
    public final Rect x;

    public ImageFlipSlide(Context context, boolean z) {
        super(context);
        this.qg = 0.1f;
        this.w = new Rect();
        this.x = new Rect();
        this.fs = z;
    }

    public void n(String str, String str2, List<String> list) {
        final sz szVarQg = com.byazt.gkj.n.n().l().n(str).qg(str2);
        this.q = list;
        szVarQg.n(Bitmap.Config.ARGB_4444).s(2);
        if (getBlurPx() != 0) {
            szVarQg.n(new tj() { // from class: com.byazt.stl.ImageFlipSlide.1
                @Override // com.byazt.si.tj
                public Bitmap n(Bitmap bitmap) {
                    try {
                        return qg.n(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception unused) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.byazt.stl.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                szVarQg.n(new m<Bitmap>() { // from class: com.byazt.stl.ImageFlipSlide.2.1
                    @Override // com.byazt.si.m
                    public void n(int i, String str3, Throwable th) {
                    }

                    @Override // com.byazt.si.m
                    public void n(cy<Bitmap> cyVar) {
                        try {
                            ImageFlipSlide.this.s = ImageFlipSlide.this.n(cyVar.s(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception unused) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setDither(true);
        if (this.fs) {
            this.n.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.q;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        for (int i = 0; i < this.q.size(); i++) {
            n(colorMatrix, this.q.get(i));
        }
        this.n.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private void n(ColorMatrix colorMatrix, String str) {
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
        if (this.q == null) {
            return 0;
        }
        for (int i = 0; i < this.q.size(); i++) {
            if (this.q.get(i).contains("blur")) {
                return Integer.parseInt(this.q.get(i).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    public void n(float f) {
        this.qg = f;
        invalidate();
    }

    public void n(Path path) {
        this.l = path;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.s;
        if (bitmap == null) {
            return;
        }
        if (this.fs) {
            this.w.left = (int) (bitmap.getWidth() * (1.0f - this.qg));
            this.w.right = this.s.getWidth();
            this.w.top = 0;
            this.w.bottom = this.s.getHeight();
            this.x.left = (int) (getWidth() * (1.0f - this.qg));
            this.x.right = getWidth();
            this.x.top = 0;
            this.x.bottom = getHeight();
            canvas.drawBitmap(this.s, this.w, this.x, this.n);
            return;
        }
        canvas.clipPath(this.l);
        canvas.drawBitmap(this.s, 0.0f, 0.0f, this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap n(Bitmap bitmap, int i, int i2) {
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
