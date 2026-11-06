package com.byazt.be;

import com.byazt.fvm.tj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 668, 19})
public class n extends com.byazt.msp.n<com.byazt.ap.s, List<tj>> {
    public static final n qg = new n();

    @Override // com.byazt.msp.n
    public int n() {
        return 5;
    }

    private n() {
    }

    public static n q() {
        return qg;
    }

    @Override // com.byazt.msp.n
    public void n(com.byazt.ap.s sVar, List<tj> list) {
        if (sVar != null) {
            sVar.n(list);
        }
    }

    @Override // com.byazt.msp.n
    public void n(com.byazt.ap.s sVar, int i, String str) {
        if (sVar != null) {
            sVar.n(i, str);
        }
    }

    @Override // com.byazt.msp.n
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public List<String> n(List<tj> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<tj> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().hu());
        }
        return arrayList;
    }

    @Override // com.byazt.msp.n
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public String qg(List<tj> list) {
        Map<String, Object> mapOu;
        if (list == null || list.isEmpty() || (mapOu = list.get(0).ou()) == null || mapOu.get("request_id") == null) {
            return null;
        }
        return (String) mapOu.get("request_id");
    }
}
