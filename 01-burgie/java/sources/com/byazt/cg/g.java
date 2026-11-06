package com.byazt.cg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.byazt.dx.ny;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g extends fw {
    public int aj;
    public int vk;
    public Path zo;

    public g(com.byazt.dx.zo zoVar, zo zoVar2, Context context) {
        super(zoVar, zoVar2);
        this.zo = null;
        this.aj = -1;
        this.vk = -1;
        if (this.fw != null) {
            float fPr = com.byazt.ptr.vk.pr();
            this.aj = (int) (this.fw.pr() * fPr);
            this.vk = (int) (this.fw.hw() * fPr);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.aj, this.vk);
            Path path = new Path();
            this.zo = path;
            float f = fPr * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    @Override // com.byazt.cg.fw, com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        ny nyVarPr = this.hw.pr();
        View viewPr = nyVarPr != null ? nyVarPr.pr("videoview:", null) : null;
        if (this.aj > 0 && viewPr != null) {
            canvas.save();
            canvas.concat(matrix);
            pr(i);
            float fZo = zo();
            pr(viewPr, this.aj, this.vk);
            viewPr.setAlpha(fZo);
            canvas.clipPath(this.zo);
            viewPr.draw(canvas);
            canvas.restore();
        }
    }

    private static void pr(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
