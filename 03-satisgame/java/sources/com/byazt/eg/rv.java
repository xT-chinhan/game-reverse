package com.byazt.eg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends s {
    public rv(com.byazt.pp.fs fsVar, fs fsVar2) {
        super(fsVar, fsVar2);
    }

    @Override // com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        super.qg(canvas, matrix, i);
    }

    @Override // com.byazt.eg.s, com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        super.n(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
