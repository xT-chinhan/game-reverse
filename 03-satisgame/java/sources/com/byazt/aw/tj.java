package com.byazt.aw;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements s {
    public final boolean cp;
    public final com.byazt.ccr.qg fs;
    public final com.byazt.ccr.qg l;
    public final String n;
    public final com.byazt.ccr.oa<PointF, PointF> q;
    public final n qg;
    public final com.byazt.ccr.qg rv;
    public final com.byazt.ccr.qg s;
    public final boolean tj;
    public final com.byazt.ccr.qg w;
    public final com.byazt.ccr.qg x;

    public enum n {
        STAR(1),
        POLYGON(2);

        public final int s;

        n(int i) {
            this.s = i;
        }

        public static n n(int i) {
            for (n nVar : values()) {
                if (nVar.s == i) {
                    return nVar;
                }
            }
            return null;
        }
    }

    public tj(String str, n nVar, com.byazt.ccr.qg qgVar, com.byazt.ccr.oa<PointF, PointF> oaVar, com.byazt.ccr.qg qgVar2, com.byazt.ccr.qg qgVar3, com.byazt.ccr.qg qgVar4, com.byazt.ccr.qg qgVar5, com.byazt.ccr.qg qgVar6, boolean z, boolean z2) {
        this.n = str;
        this.qg = nVar;
        this.s = qgVar;
        this.q = oaVar;
        this.l = qgVar2;
        this.w = qgVar3;
        this.x = qgVar4;
        this.fs = qgVar5;
        this.rv = qgVar6;
        this.tj = z;
        this.cp = z2;
    }

    public String n() {
        return this.n;
    }

    public n getType() {
        return this.qg;
    }

    public com.byazt.ccr.qg qg() {
        return this.s;
    }

    public com.byazt.ccr.oa<PointF, PointF> s() {
        return this.q;
    }

    public com.byazt.ccr.qg q() {
        return this.l;
    }

    public com.byazt.ccr.qg l() {
        return this.w;
    }

    public com.byazt.ccr.qg w() {
        return this.x;
    }

    public com.byazt.ccr.qg x() {
        return this.fs;
    }

    public com.byazt.ccr.qg fs() {
        return this.rv;
    }

    public boolean rv() {
        return this.tj;
    }

    public boolean tj() {
        return this.cp;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.sz(fsVar, sVar, this);
    }
}
