package com.byazt.om;

import com.byazt.mr.m;
import com.byazt.pis.c;
import com.tapsdk.tapad.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1325, 37})
public class pr extends com.byazt.ra.pr<c, List<m>> {
    public static final pr hw = new pr();

    private pr() {
    }

    public static pr x() {
        return hw;
    }

    @Override // com.byazt.ra.pr
    public int pr() {
        return 1;
    }

    @Override // com.byazt.ra.pr
    public void pr(c cVar, List<m> list) {
        if (cVar != null) {
            cVar.pr(list);
        }
    }

    @Override // com.byazt.ra.pr
    public void pr(c cVar, int i, String str) {
        if (cVar != null) {
            cVar.pr(i, str);
        }
    }

    @Override // com.byazt.ra.pr
    /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
    public List<String> pr(List<m> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<m> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().x());
        }
        return arrayList;
    }

    @Override // com.byazt.ra.pr
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public String hw(List<m> list) {
        Map<String, Object> mapG;
        if (list != null && !list.isEmpty() && (mapG = list.get(0).g()) != null && mapG.get(Constants.Bidding.REQUEST_ID) != null) {
            return (String) mapG.get(Constants.Bidding.REQUEST_ID);
        }
        return null;
    }
}
