package com.byazt.ynb;

import android.graphics.Path;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements hn {
    public final com.byazt.eqw.hw aj;
    public final com.byazt.eqw.uc c;
    public final String fw;
    public final com.byazt.eqw.hn hn;
    public final Path.FillType hw;
    public final fw pr;
    public final com.byazt.eqw.uc uc;
    public final boolean vk;
    public final com.byazt.eqw.x x;
    public final com.byazt.eqw.hw zo;

    public c(String str, fw fwVar, Path.FillType fillType, com.byazt.eqw.hn hnVar, com.byazt.eqw.x xVar, com.byazt.eqw.uc ucVar, com.byazt.eqw.uc ucVar2, com.byazt.eqw.hw hwVar, com.byazt.eqw.hw hwVar2, boolean z) {
        this.pr = fwVar;
        this.hw = fillType;
        this.hn = hnVar;
        this.x = xVar;
        this.c = ucVar;
        this.uc = ucVar2;
        this.fw = str;
        this.zo = hwVar;
        this.aj = hwVar2;
        this.vk = z;
    }

    public String pr() {
        return this.fw;
    }

    public fw hw() {
        return this.pr;
    }

    public Path.FillType hn() {
        return this.hw;
    }

    public com.byazt.eqw.hn x() {
        return this.hn;
    }

    public com.byazt.eqw.x c() {
        return this.x;
    }

    public com.byazt.eqw.uc uc() {
        return this.c;
    }

    public com.byazt.eqw.uc fw() {
        return this.uc;
    }

    public boolean zo() {
        return this.vk;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new com.byazt.ova.zo(zoVar, ucVar, hnVar, this);
    }
}
