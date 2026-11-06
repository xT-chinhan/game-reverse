package com.byazt.jwj;

import com.byazt.hh.uc;
import com.byazt.vkw.k;
import com.byazt.vkw.ny;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LATENCYTIME, 37})
public class pr implements uc {
    public int hw;
    public int pr;

    @Override // com.byazt.hh.uc
    public int hw() {
        return this.pr;
    }

    @Override // com.byazt.hh.uc
    public int pr() {
        return this.hw;
    }

    public pr(int i, int i2) {
        i = i <= 0 ? 10 : i;
        i2 = i2 <= 0 ? 100 : i2;
        i2 = i > i2 ? i : i2;
        this.pr = i;
        this.hw = i2;
    }

    public static pr pr(com.byazt.vkw.pr prVar) {
        int iHn;
        ny nyVar = (ny) com.byazt.zs.uc.pr("mediation_settings", prVar);
        if (nyVar == null) {
            iHn = 100;
        } else {
            iHn = nyVar.hn();
        }
        return new pr(iHn, iHn);
    }

    public static pr hw(com.byazt.vkw.pr prVar) {
        k kVar = (k) com.byazt.zs.uc.pr("csj_settings", prVar);
        int iW = kVar.w();
        int iK = kVar.k();
        if (iW > iK) {
            iK = iW;
        }
        return new pr(iW, iK);
    }

    public static pr hn(com.byazt.vkw.pr prVar) {
        int iK = ((k) com.byazt.zs.uc.pr("csj_settings", prVar)).k();
        if (iK <= 1) {
            iK = 10;
        }
        return new pr(1, iK);
    }

    public static pr x(com.byazt.vkw.pr prVar) {
        int iK = ((k) com.byazt.zs.uc.pr("csj_settings", prVar)).k();
        if (iK <= 1) {
            iK = 10;
        }
        return new pr(1, iK);
    }

    public static pr hn() {
        return new pr(1, 100);
    }
}
