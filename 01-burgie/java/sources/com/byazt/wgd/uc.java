package com.byazt.wgd;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 5})
public class uc extends pr {
    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        byte[] bArrPr;
        String strUc = hnVar.uc();
        com.byazt.ld.hw hwVarNy = hnVar.ny();
        if (hnVar.fo() || hwVarNy.uc()) {
            bArrPr = pr(hnVar, strUc);
        } else {
            bArrPr = hw(hnVar, strUc);
        }
        if (bArrPr == null) {
            hnVar.pr(new w());
            return;
        }
        hnVar.pr(new hw(bArrPr, null));
        if (hwVarNy.fw()) {
            hnVar.cz().hw(hwVarNy).pr(strUc, bArrPr);
        }
    }

    private byte[] pr(com.byazt.sl.hn hnVar, String str) {
        hnVar.cz().hn(hnVar.ny());
        Collection<com.byazt.ld.x> collectionHn = hnVar.cz().hn();
        if (collectionHn == null) {
            return null;
        }
        Iterator<com.byazt.ld.x> it = collectionHn.iterator();
        while (it.hasNext()) {
            byte[] bArrPr = it.next().pr(str);
            if (bArrPr != null) {
                return bArrPr;
            }
        }
        return null;
    }

    private byte[] hw(com.byazt.sl.hn hnVar, String str) {
        com.byazt.ld.x xVarHn = hnVar.cz().hn(hnVar.ny());
        if (xVarHn == null) {
            return null;
        }
        return xVarHn.pr(str);
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "disk_cache";
    }
}
