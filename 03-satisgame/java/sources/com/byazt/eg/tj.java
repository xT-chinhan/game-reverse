package com.byazt.eg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.byazt.aw.cy;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends s {
    public final q fs;
    public final com.byazt.sp.q x;

    public tj(com.byazt.pp.fs fsVar, fs fsVar2, q qVar, com.byazt.pp.w wVar) {
        super(fsVar, fsVar2);
        this.fs = qVar;
        com.byazt.sp.q qVar2 = new com.byazt.sp.q(fsVar, this, new cy("__container", fsVar2.sz(), false), wVar);
        this.x = qVar2;
        qVar2.n(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        super.qg(canvas, matrix, i);
        this.x.n(canvas, matrix, i);
    }

    @Override // com.byazt.eg.s, com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        super.n(rectF, matrix, z);
        this.x.n(rectF, this.n, z);
    }

    @Override // com.byazt.eg.s
    public com.byazt.aw.n d() {
        com.byazt.aw.n nVarD = super.d();
        return nVarD != null ? nVarD : this.fs.d();
    }

    @Override // com.byazt.eg.s
    public com.byazt.ur.tj oa() {
        com.byazt.ur.tj tjVarOa = super.oa();
        return tjVarOa != null ? tjVarOa : this.fs.oa();
    }
}
