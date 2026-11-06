package com.byazt.kl;

import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.mq.m;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 37})
public abstract class pr implements hw {
    public abstract String pr(of ofVar, int i, int i2);

    @Override // com.byazt.kl.hw
    public String pr(of ofVar) {
        int iC = c(ofVar);
        int iX = x(ofVar);
        if (iC > 0 && iC <= 9 && iX != -1) {
            return pr(ofVar, iC, iX);
        }
        return null;
    }

    private int x(of ofVar) {
        if (ofVar == null) {
            return -1;
        }
        return ofVar.jg();
    }

    private static int c(of ofVar) {
        int iK;
        int iA = -1;
        if (ofVar == null) {
            return -1;
        }
        com.byazt.qe.hw hwVarP = ofVar.p();
        if (hwVarP != null) {
            iA = hwVarP.a();
        }
        if ((iA <= 0 || iA >= 10) && (iK = ls.k(ofVar)) > 0 && iK < 10) {
            return iK;
        }
        return iA;
    }

    public static hw pr(of ofVar, m mVar) {
        if (ofVar == null || c(ofVar) != 5) {
            return null;
        }
        if ((mVar instanceof com.byazt.gu.hw) && ((com.byazt.gu.hw) mVar).e()) {
            return new com.byazt.bf.pr();
        }
        return new com.byazt.hz.pr();
    }

    public static boolean hw(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        return (ie.x(ofVar) == 2) && hn(ofVar);
    }

    public static boolean hn(of ofVar) {
        if (c(ofVar) == 5) {
            return true;
        }
        return false;
    }
}
