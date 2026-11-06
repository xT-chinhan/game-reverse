package com.byazt.cg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 109})
public class w extends hn {
    public final float[] aj;
    public final RectF fw;
    public com.byazt.al.pr<ColorFilter, ColorFilter> k;
    public final Path vk;
    public final zo w;
    public final Paint zo;

    public w(com.byazt.dx.zo zoVar, zo zoVar2) {
        super(zoVar, zoVar2);
        this.fw = new RectF();
        com.byazt.qpa.pr prVar = new com.byazt.qpa.pr();
        this.zo = prVar;
        this.aj = new float[8];
        this.vk = new Path();
        this.w = zoVar2;
        prVar.setAlpha(0);
        prVar.setStyle(Paint.Style.FILL);
        prVar.setColor(zoVar2.nt());
    }

    @Override // com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        super.hw(canvas, matrix, i);
        int iAlpha = Color.alpha(this.w.nt());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.x.pr() == null ? 100 : this.x.pr().fw().intValue())) / 100.0f) * 255.0f);
        this.zo.setAlpha(iIntValue);
        com.byazt.al.pr<ColorFilter, ColorFilter> prVar = this.k;
        if (prVar != null) {
            this.zo.setColorFilter(prVar.fw());
        }
        if (iIntValue > 0) {
            float[] fArr = this.aj;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.w.lb();
            float[] fArr2 = this.aj;
            fArr2[3] = 0.0f;
            fArr2[4] = this.w.lb();
            this.aj[5] = this.w.yb();
            float[] fArr3 = this.aj;
            fArr3[6] = 0.0f;
            fArr3[7] = this.w.yb();
            matrix.mapPoints(this.aj);
            this.vk.reset();
            Path path = this.vk;
            float[] fArr4 = this.aj;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.vk;
            float[] fArr5 = this.aj;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.vk;
            float[] fArr6 = this.aj;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.vk;
            float[] fArr7 = this.aj;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.vk;
            float[] fArr8 = this.aj;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.vk.close();
            canvas.drawPath(this.vk, this.zo);
        }
    }

    @Override // com.byazt.cg.hn, com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        super.pr(rectF, matrix, z);
        this.fw.set(0.0f, 0.0f, this.w.lb(), this.w.yb());
        this.pr.mapRect(this.fw);
        rectF.set(this.fw);
    }
}
