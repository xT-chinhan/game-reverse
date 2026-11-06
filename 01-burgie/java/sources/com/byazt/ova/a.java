package com.byazt.ova;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a extends pr {
    public final String c;
    public final com.byazt.al.pr<Integer, Integer> fw;
    public final boolean uc;
    public final com.byazt.cg.hn x;
    public com.byazt.al.pr<ColorFilter, ColorFilter> zo;

    public a(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.lb lbVar) {
        super(zoVar, hnVar, lbVar.fw().pr(), lbVar.zo().pr(), lbVar.aj(), lbVar.hn(), lbVar.x(), lbVar.c(), lbVar.uc());
        this.x = hnVar;
        this.c = lbVar.pr();
        this.uc = lbVar.vk();
        com.byazt.al.pr<Integer, Integer> prVarPr = lbVar.hw().pr();
        this.fw = prVarPr;
        prVarPr.pr(this);
        hnVar.pr(prVarPr);
    }

    @Override // com.byazt.ova.pr, com.byazt.ova.c
    public void pr(Canvas canvas, Matrix matrix, int i) {
        if (this.uc) {
            return;
        }
        this.hw.setColor(((com.byazt.al.hw) this.fw).aj());
        if (this.zo != null) {
            this.hw.setColorFilter(this.zo.fw());
        }
        super.pr(canvas, matrix, i);
    }
}
