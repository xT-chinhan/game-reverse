package com.byazt.wgd;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 62})
public class fw extends pr {
    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        List<com.byazt.sl.hn> linkedList;
        String strZ = hnVar.z();
        Map<String, List<com.byazt.sl.hn>> mapFw = hnVar.cz().fw();
        synchronized (mapFw) {
            linkedList = mapFw.get(strZ);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(hnVar);
            mapFw.put(strZ, linkedList);
            if (linkedList.size() <= 1) {
                hnVar.pr(new x());
            }
        }
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "check_duplicate";
    }
}
