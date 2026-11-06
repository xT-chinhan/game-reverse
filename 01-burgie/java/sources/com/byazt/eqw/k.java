package com.byazt.eqw;

import android.graphics.PointF;
import com.byazt.al.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 250})
public class k implements com.byazt.ynb.hn {
    public final hw aj;
    public final x c;
    public final hw fw;
    public final fw hn;
    public final m<PointF, PointF> hw;
    public final c pr;
    public final hw uc;
    public final hw x;
    public final hw zo;

    public k() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public k(c cVar, m<PointF, PointF> mVar, fw fwVar, hw hwVar, x xVar, hw hwVar2, hw hwVar3, hw hwVar4, hw hwVar5) {
        this.pr = cVar;
        this.hw = mVar;
        this.hn = fwVar;
        this.x = hwVar;
        this.c = xVar;
        this.zo = hwVar2;
        this.aj = hwVar3;
        this.uc = hwVar4;
        this.fw = hwVar5;
    }

    public c pr() {
        return this.pr;
    }

    public m<PointF, PointF> hw() {
        return this.hw;
    }

    public fw hn() {
        return this.hn;
    }

    public hw x() {
        return this.x;
    }

    public x c() {
        return this.c;
    }

    public hw uc() {
        return this.zo;
    }

    public hw fw() {
        return this.aj;
    }

    public hw zo() {
        return this.uc;
    }

    public hw aj() {
        return this.fw;
    }

    public nt vk() {
        return new nt(this);
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return null;
    }
}
