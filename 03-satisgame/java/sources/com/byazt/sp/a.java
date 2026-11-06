package com.byazt.sp;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a extends n {
    public com.byazt.bd.n<ColorFilter, ColorFilter> fs;
    public final String l;
    public final com.byazt.eg.s q;
    public final boolean w;
    public final com.byazt.bd.n<Integer, Integer> x;

    public a(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.cd cdVar) {
        super(fsVar, sVar, cdVar.x().n(), cdVar.fs().n(), cdVar.rv(), cdVar.s(), cdVar.q(), cdVar.l(), cdVar.w());
        this.q = sVar;
        this.l = cdVar.n();
        this.w = cdVar.tj();
        com.byazt.bd.n<Integer, Integer> nVarN = cdVar.qg().n();
        this.x = nVarN;
        nVarN.n(this);
        sVar.n(nVarN);
    }

    @Override // com.byazt.sp.n, com.byazt.sp.l
    public void n(Canvas canvas, Matrix matrix, int i) {
        if (this.w) {
            return;
        }
        this.qg.setColor(((com.byazt.bd.qg) this.x).rv());
        if (this.fs != null) {
            this.qg.setColorFilter(this.fs.x());
        }
        super.n(canvas, matrix, i);
    }
}
