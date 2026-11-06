package com.byazt.cg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 62})
public class fw extends hn {
    public final Rect aj;
    public final com.byazt.dx.aj fw;
    public com.byazt.al.pr<Bitmap, Bitmap> k;
    public final Rect vk;
    public com.byazt.al.pr<ColorFilter, ColorFilter> w;
    public final Paint zo;

    public fw(com.byazt.dx.zo zoVar, zo zoVar2) {
        super(zoVar, zoVar2);
        this.zo = new com.byazt.qpa.pr(3);
        this.aj = new Rect();
        this.vk = new Rect();
        this.fw = zoVar.uc(zoVar2.fw());
    }

    @Override // com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        super.hw(canvas, matrix, i);
        Bitmap bitmapG = g();
        if (bitmapG == null || bitmapG.isRecycled() || this.fw == null) {
            return;
        }
        float fPr = com.byazt.ptr.vk.pr();
        this.zo.setAlpha(i);
        com.byazt.al.pr<ColorFilter, ColorFilter> prVar = this.w;
        if (prVar != null) {
            this.zo.setColorFilter(prVar.fw());
        }
        canvas.save();
        canvas.concat(matrix);
        this.aj.set(0, 0, bitmapG.getWidth(), bitmapG.getHeight());
        if (this.hw.uc()) {
            this.vk.set(0, 0, (int) (this.fw.pr() * fPr), (int) (this.fw.hw() * fPr));
        } else {
            this.vk.set(0, 0, (int) (bitmapG.getWidth() * fPr), (int) (bitmapG.getHeight() * fPr));
        }
        canvas.drawBitmap(bitmapG, this.aj, this.vk, this.zo);
        canvas.restore();
    }

    @Override // com.byazt.cg.hn, com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        super.pr(rectF, matrix, z);
        if (this.fw != null) {
            float fPr = com.byazt.ptr.vk.pr();
            rectF.set(0.0f, 0.0f, this.fw.pr() * fPr, this.fw.hw() * fPr);
            this.pr.mapRect(rectF);
        }
    }

    public Bitmap g() {
        Bitmap bitmapFw;
        com.byazt.al.pr<Bitmap, Bitmap> prVar = this.k;
        if (prVar != null && (bitmapFw = prVar.fw()) != null) {
            return bitmapFw;
        }
        Bitmap bitmapC = this.hw.c(this.hn.fw());
        if (bitmapC != null) {
            return bitmapC;
        }
        com.byazt.dx.aj ajVar = this.fw;
        if (ajVar != null) {
            return ajVar.ho();
        }
        return null;
    }
}
