package com.byazt.war;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 21})
public class x extends n {
    @Override // com.byazt.war.rv
    public String n() {
        return "check_duplicate";
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        List<com.byazt.gxb.s> linkedList;
        String strHu = sVar.hu();
        Map<String, List<com.byazt.gxb.s>> mapX = sVar.py().x();
        synchronized (mapX) {
            linkedList = mapX.get(strHu);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(sVar);
            mapX.put(strHu, linkedList);
            if (linkedList.size() <= 1) {
                sVar.n(new q());
            }
        }
    }
}
