package com.byazt.war;

import android.graphics.Bitmap;
import com.byazt.si.lh;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends n {
    @Override // com.byazt.war.rv
    public String n() {
        return "memory_cache";
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        Bitmap bitmapQg;
        int iOa = sVar.oa();
        if (iOa != 2 && iOa != 1) {
            bitmapQg = null;
        } else if (sVar.wm() || sVar.ou().w()) {
            bitmapQg = qg(sVar);
        } else {
            bitmapQg = s(sVar);
        }
        if (bitmapQg == null) {
            com.byazt.si.qg qgVarOu = sVar.ou();
            if (sVar.hd()) {
                if (qgVarOu.x()) {
                    sVar.n(new d());
                    return;
                } else {
                    sVar.n(new oa());
                    return;
                }
            }
            if (qgVarOu.x()) {
                sVar.n(new d());
                return;
            } else {
                sVar.n(new w());
                return;
            }
        }
        sVar.n(new sz(bitmapQg, null, null, false));
    }

    private Bitmap qg(com.byazt.gxb.s sVar) {
        Collection<lh> collectionN = sVar.py().n();
        Bitmap bitmapN = null;
        if (collectionN == null) {
            return null;
        }
        Iterator<lh> it = collectionN.iterator();
        while (it.hasNext() && (bitmapN = it.next().n(sVar.x())) == null) {
        }
        return bitmapN;
    }

    private Bitmap s(com.byazt.gxb.s sVar) {
        return sVar.py().n(sVar.ou()).n(sVar.x());
    }
}
