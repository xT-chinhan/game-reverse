package com.byazt.qq;

import com.byazt.gct.cd;
import com.byazt.gct.lq;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, 26})
public class qg {
    public static String n(pk pkVar) {
        if (pkVar == null) {
            return "";
        }
        int iFs = fs(pkVar);
        if (iFs != 3) {
            return iFs != 4 ? "" : lq.l(pkVar);
        }
        return cd.fs(pkVar);
    }

    public static boolean qg(pk pkVar) {
        return (pkVar == null || fs(pkVar) == 0) ? false : true;
    }

    private static int fs(pk pkVar) {
        if (cd.n(pkVar)) {
            return 3;
        }
        return lq.n(pkVar) ? 4 : 0;
    }

    public static boolean s(pk pkVar) {
        if (pkVar == null || pe.n(pkVar) || fs(pkVar) != 3) {
            return false;
        }
        return cd.n(pkVar);
    }

    public static boolean q(pk pkVar) {
        return pkVar != null && fs(pkVar) == 4;
    }

    public static int l(pk pkVar) {
        if (pkVar != null && fs(pkVar) == 3) {
            return cd.cp(pkVar);
        }
        return 0;
    }

    public static int w(pk pkVar) {
        if (pkVar == null) {
            return -1;
        }
        if (fs(pkVar) != 3) {
            return 0;
        }
        return cd.d(pkVar);
    }

    public static boolean x(pk pkVar) {
        return fs(pkVar) == 3;
    }
}
