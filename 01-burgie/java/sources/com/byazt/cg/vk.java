package com.byazt.cg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.byazt.ynb.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 50})
public class vk extends hn {
    public final com.byazt.ova.x fw;
    public final x zo;

    public vk(com.byazt.dx.zo zoVar, zo zoVar2, x xVar, com.byazt.dx.uc ucVar) {
        super(zoVar, zoVar2);
        this.zo = xVar;
        com.byazt.ova.x xVar2 = new com.byazt.ova.x(zoVar, this, new nt("__container", zoVar2.g(), false), ucVar);
        this.fw = xVar2;
        xVar2.pr(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        super.hw(canvas, matrix, i);
        this.fw.pr(canvas, matrix, i);
    }

    @Override // com.byazt.cg.hn, com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        super.pr(rectF, matrix, z);
        this.fw.pr(rectF, this.pr, z);
    }

    @Override // com.byazt.cg.hn
    public com.byazt.ynb.pr k() {
        com.byazt.ynb.pr prVarK = super.k();
        if (prVarK != null) {
            return prVarK;
        }
        return this.zo.k();
    }

    @Override // com.byazt.cg.hn
    public com.byazt.tx.vk m() {
        com.byazt.tx.vk vkVarM = super.m();
        if (vkVarM != null) {
            return vkVarM;
        }
        return this.zo.m();
    }
}
