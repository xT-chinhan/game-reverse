package com.byazt.ccr;

import android.graphics.PointF;
import com.byazt.bd.cy;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, 113})
public class d implements com.byazt.aw.s {
    public final qg fs;
    public final q l;
    public final l n;
    public final qg q;
    public final oa<PointF, PointF> qg;
    public final qg rv;
    public final x s;
    public final qg w;
    public final qg x;

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return null;
    }

    public d() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public d(l lVar, oa<PointF, PointF> oaVar, x xVar, qg qgVar, q qVar, qg qgVar2, qg qgVar3, qg qgVar4, qg qgVar5) {
        this.n = lVar;
        this.qg = oaVar;
        this.s = xVar;
        this.q = qgVar;
        this.l = qVar;
        this.fs = qgVar2;
        this.rv = qgVar3;
        this.w = qgVar4;
        this.x = qgVar5;
    }

    public l n() {
        return this.n;
    }

    public oa<PointF, PointF> qg() {
        return this.qg;
    }

    public x s() {
        return this.s;
    }

    public qg q() {
        return this.q;
    }

    public q l() {
        return this.l;
    }

    public qg w() {
        return this.fs;
    }

    public qg x() {
        return this.rv;
    }

    public qg fs() {
        return this.w;
    }

    public qg rv() {
        return this.x;
    }

    public cy tj() {
        return new cy(this);
    }
}
