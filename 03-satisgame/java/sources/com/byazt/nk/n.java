package com.byazt.nk;

import com.byazt.ap.l;
import com.byazt.fvm.oa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1940, 19})
public class n extends com.byazt.msp.n<l, List<oa>> {
    public static final n qg = new n();

    @Override // com.byazt.msp.n
    public int n() {
        return 1;
    }

    private n() {
    }

    public static n q() {
        return qg;
    }

    @Override // com.byazt.msp.n
    public void n(l lVar, List<oa> list) {
        if (lVar != null) {
            lVar.n(list);
        }
    }

    @Override // com.byazt.msp.n
    public void n(l lVar, int i, String str) {
        if (lVar != null) {
            lVar.n(i, str);
        }
    }

    @Override // com.byazt.msp.n
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public List<String> n(List<oa> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<oa> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().hu());
        }
        return arrayList;
    }

    @Override // com.byazt.msp.n
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public String qg(List<oa> list) {
        Map<String, Object> mapOu;
        if (list == null || list.isEmpty() || (mapOu = list.get(0).ou()) == null || mapOu.get("request_id") == null) {
            return null;
        }
        return (String) mapOu.get("request_id");
    }
}
