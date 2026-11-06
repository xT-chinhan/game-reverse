package com.byazt.war;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 13})
public class w extends n {
    @Override // com.byazt.war.rv
    public String n() {
        return "disk_cache";
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        byte[] bArrN;
        String strW = sVar.w();
        com.byazt.si.qg qgVarOu = sVar.ou();
        if (sVar.wm() || qgVarOu.w()) {
            bArrN = n(sVar, strW);
        } else {
            bArrN = qg(sVar, strW);
        }
        if (bArrN == null) {
            sVar.n(new cp());
            return;
        }
        sVar.n(new qg(bArrN, null));
        if (qgVarOu.x()) {
            sVar.py().qg(qgVarOu).n(strW, bArrN);
        }
    }

    private byte[] n(com.byazt.gxb.s sVar, String str) {
        sVar.py().s(sVar.ou());
        Collection<com.byazt.si.q> collectionS = sVar.py().s();
        if (collectionS == null) {
            return null;
        }
        Iterator<com.byazt.si.q> it = collectionS.iterator();
        while (it.hasNext()) {
            byte[] bArrN = it.next().n(str);
            if (bArrN != null) {
                return bArrN;
            }
        }
        return null;
    }

    private byte[] qg(com.byazt.gxb.s sVar, String str) {
        com.byazt.si.q qVarS = sVar.py().s(sVar.ou());
        if (qVarS == null) {
            return null;
        }
        return qVarS.n(str);
    }
}
