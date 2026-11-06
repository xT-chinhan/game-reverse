package com.byazt.vgo;

import com.byazt.fvm.rv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 25, 19})
public class n extends com.byazt.msp.n<com.byazt.ap.qg, List<rv>> {
    public static final n qg = new n();

    @Override // com.byazt.msp.n
    public int n() {
        return 9;
    }

    private n() {
    }

    public static n q() {
        return qg;
    }

    @Override // com.byazt.msp.n
    public void n(com.byazt.ap.qg qgVar, List<rv> list) {
        if (qgVar != null) {
            qgVar.n(list);
        }
    }

    @Override // com.byazt.msp.n
    public void n(com.byazt.ap.qg qgVar, int i, String str) {
        if (qgVar != null) {
            qgVar.n(i, str);
        }
    }

    @Override // com.byazt.msp.n
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public List<String> n(List<rv> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<rv> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().hu());
        }
        return arrayList;
    }

    @Override // com.byazt.msp.n
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public String qg(List<rv> list) {
        Map<String, Object> mapOu;
        if (list == null || list.isEmpty() || (mapOu = list.get(0).ou()) == null || mapOu.get("request_id") == null) {
            return null;
        }
        return (String) mapOu.get("request_id");
    }
}
