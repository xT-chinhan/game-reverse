package com.byazt.wgd;

import android.graphics.Bitmap;
import com.byazt.ld.y;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 50})
public class vk extends pr {
    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        Bitmap bitmapHw;
        int iM = hnVar.m();
        if (iM != 2 && iM != 1) {
            bitmapHw = null;
        } else if (hnVar.fo() || hnVar.ny().uc()) {
            bitmapHw = hw(hnVar);
        } else {
            bitmapHw = hn(hnVar);
        }
        if (bitmapHw == null) {
            com.byazt.ld.hw hwVarNy = hnVar.ny();
            if (hnVar.yb()) {
                if (hwVarNy.fw()) {
                    hnVar.pr(new k());
                    return;
                } else {
                    hnVar.pr(new m());
                    return;
                }
            }
            if (hwVarNy.fw()) {
                hnVar.pr(new k());
                return;
            } else {
                hnVar.pr(new uc());
                return;
            }
        }
        hnVar.pr(new g(bitmapHw, null, null, false));
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "memory_cache";
    }

    private Bitmap hw(com.byazt.sl.hn hnVar) {
        Collection<y> collectionPr = hnVar.cz().pr();
        Bitmap bitmapPr = null;
        if (collectionPr == null) {
            return null;
        }
        Iterator<y> it = collectionPr.iterator();
        while (it.hasNext()) {
            bitmapPr = it.next().pr(hnVar.fw());
            if (bitmapPr != null) {
                return bitmapPr;
            }
        }
        return bitmapPr;
    }

    private Bitmap hn(com.byazt.sl.hn hnVar) {
        return hnVar.cz().pr(hnVar.ny()).pr(hnVar.fw());
    }
}
