package com.byazt.jx;

import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 37})
public class pr {
    public static final LruCache<String, com.byazt.hg.x> pr = new LruCache<>(10);

    public static void pr(String str, com.byazt.hg.x xVar) {
        if (TextUtils.isEmpty(str) || xVar == null || !xVar.fw()) {
            return;
        }
        pr.put(str, xVar);
    }

    public static com.byazt.hg.x pr(of ofVar) {
        String strHw = null;
        if (ofVar == null) {
            return null;
        }
        String strTz = ofVar.tz();
        String strIu = ls.iu(ofVar);
        com.byazt.hg.c cVarHo = ofVar.ho();
        if (cVarHo != null) {
            strHw = cVarHo.hw();
        }
        return pr(strTz + "_" + strIu + "_" + strHw);
    }

    public static com.byazt.hg.x pr(String str) {
        com.byazt.hg.x xVar = pr.get(str);
        if (xVar != null && xVar.fw()) {
            return xVar;
        }
        return null;
    }

    public static void pr(com.byazt.hg.pr prVar) {
        List<of> listHw;
        if (prVar == null || (listHw = prVar.hw()) == null || listHw.isEmpty()) {
            return;
        }
        Iterator<of> it = listHw.iterator();
        while (it.hasNext()) {
            hw(it.next());
        }
    }

    public static void hw(final of ofVar) {
        if (!hn(ofVar)) {
            return;
        }
        boolean zC = com.byazt.ri.c.c(ofVar);
        boolean zC2 = c(ofVar);
        if (!zC && !zC2) {
            return;
        }
        final String strHw = ofVar.ho() != null ? ofVar.ho().hw() : "";
        com.byazt.zp.zo.pr(new com.byazt.xlm.fw("preloadAppInfo") { // from class: com.byazt.jx.pr.1
            @Override // java.lang.Runnable
            public void run() {
                a.pr().pr(ofVar, strHw);
            }
        });
    }

    public static boolean hn(of ofVar) {
        return x(ofVar) && com.byazt.ri.c.pr(ofVar) == 2;
    }

    private static boolean c(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        int iHn = ie.hn(ofVar);
        return iHn == 7 || iHn == 10 || ie.pr(ofVar) == 1;
    }

    public static boolean x(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(ofVar.ho() != null ? ofVar.ho().hw() : "") && ofVar.aj() == 4 && TextUtils.isEmpty(ofVar.rc())) {
            return (ofVar.z_() == null || ofVar.z_().hw() == 0) && !ls.hw(ls.iu(ofVar));
        }
        return false;
    }
}
