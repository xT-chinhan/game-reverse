package com.byazt.njk;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Choreographer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, 37})
public final class pr extends Drawable {
    public Choreographer c;
    public final Paint hn;
    public final hw.x[] hw;
    public final c pr;
    public boolean uc;
    public final Path x = new Path();
    public final Choreographer.FrameCallback fw = new Choreographer.FrameCallback() { // from class: com.byazt.njk.pr.1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (pr.this.uc) {
                pr.this.invalidateSelf();
                if (pr.this.uc && pr.this.c != null) {
                    pr.this.c.postFrameCallback(this);
                }
            }
        }
    };

    public pr(c cVar) {
        this.pr = cVar;
        this.hw = cVar.hn();
        Paint paint = new Paint(1);
        this.hn = paint;
        paint.setStyle(Paint.Style.FILL);
        if (cVar.hw().pr().uc == 1) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        }
    }

    public void pr() {
        if (this.uc) {
            return;
        }
        this.uc = true;
        try {
            Choreographer choreographer = Choreographer.getInstance();
            this.c = choreographer;
            choreographer.postFrameCallback(this.fw);
        } catch (Throwable th) {
            this.uc = false;
        }
    }

    public void hw() {
        this.uc = false;
        Choreographer choreographer = this.c;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this.fw);
            this.c = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.pr.pr(rect.width(), rect.height());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        uc ucVarPr;
        int i;
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0 || (i = (ucVarPr = this.pr.pr()).pr) <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        try {
            pr(canvas, ucVarPr, i);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    private void pr(Canvas canvas, uc ucVar, int i) {
        int i2;
        int i3 = i;
        int[] iArrPr = pr(ucVar, i3);
        float[] fArr = ucVar.hn;
        float[] fArr2 = ucVar.x;
        float[] fArr3 = ucVar.c;
        float[] fArr4 = ucVar.uc;
        int[] iArr = ucVar.zo;
        hw.x[] xVarArr = this.hw;
        int i4 = 0;
        while (i4 < i3) {
            int i5 = iArrPr[i4];
            int i6 = iArr[i5];
            if (i6 < 0 || i6 >= xVarArr.length) {
                i2 = i4;
            } else {
                hw.pr prVar = xVarArr[i6].k;
                if (prVar == null) {
                    i2 = i4;
                } else {
                    float f = fArr3[i5];
                    float f2 = prVar.hn * f;
                    float f3 = prVar.x * f;
                    if (f2 <= 0.0f || f3 <= 0.0f) {
                        i2 = i4;
                    } else {
                        int i7 = (int) ((fArr4[i5] * 255.0f) + 0.5f);
                        if (i7 <= 0) {
                            i2 = i4;
                        } else {
                            i2 = i4;
                            if (i7 > 255) {
                                i7 = 255;
                            }
                            this.hn.setColor(prVar.c);
                            this.hn.setAlpha(i7);
                            float f4 = fArr[i5];
                            float f5 = fArr2[i5];
                            switch (prVar.hw) {
                                case 1:
                                    float f6 = f2 / 2.0f;
                                    float f7 = f3 / 2.0f;
                                    canvas.drawRect(f4 - f6, f5 - f7, f6 + f4, f7 + f5, this.hn);
                                    break;
                                case 2:
                                    pr(canvas, f4, f5, Math.min(f2, f3) / 2.0f);
                                    break;
                                default:
                                    canvas.drawCircle(f4, f5, Math.min(f2, f3) / 2.0f, this.hn);
                                    break;
                            }
                        }
                    }
                }
            }
            i4 = i2 + 1;
            i3 = i;
        }
    }

    private int[] pr(uc ucVar, int i) {
        int[] iArr = ucVar.aj;
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        int i3 = ucVar.hw;
        if (i3 == 0 || i3 == 1 || i <= 1) {
            return iArr;
        }
        pr(iArr, ucVar.fw, i, i3 == 4);
        return iArr;
    }

    private static void pr(int[] iArr, float[] fArr, int i, boolean z) {
        for (int i2 = 1; i2 < i; i2++) {
            int i3 = iArr[i2];
            float f = fArr[i3];
            int i4 = i2 - 1;
            if (z) {
                while (i4 >= 0) {
                    int i5 = iArr[i4];
                    if (fArr[i5] <= f) {
                        break;
                    }
                    iArr[i4 + 1] = i5;
                    i4--;
                }
            } else {
                while (i4 >= 0) {
                    int i6 = iArr[i4];
                    if (fArr[i6] >= f) {
                        break;
                    }
                    iArr[i4 + 1] = i6;
                    i4--;
                }
            }
            iArr[i4 + 1] = i3;
        }
    }

    private void pr(Canvas canvas, float f, float f2, float f3) {
        float f4 = 0.5f * f3;
        Path path = this.x;
        path.rewind();
        float f5 = -1.5707964f;
        for (int i = 0; i < 10; i++) {
            float f6 = i % 2 == 0 ? f3 : f4;
            double d = f5;
            float fCos = (((float) Math.cos(d)) * f6) + f;
            float fSin = (((float) Math.sin(d)) * f6) + f2;
            if (i == 0) {
                path.moveTo(fCos, fSin);
            } else {
                path.lineTo(fCos, fSin);
            }
            f5 += 0.62831855f;
        }
        path.close();
        canvas.drawPath(path, this.hn);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.hn.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
