package com.byazt.ju;

import com.byazt.mr.aj;
import com.tapsdk.tapad.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1108, 37})
public class pr extends com.byazt.ra.pr<com.byazt.pis.hw, List<aj>> {
    public static final pr hw = new pr();

    private pr() {
    }

    public static pr x() {
        return hw;
    }

    @Override // com.byazt.ra.pr
    public int pr() {
        return 9;
    }

    @Override // com.byazt.ra.pr
    public void pr(com.byazt.pis.hw hwVar, List<aj> list) {
        if (hwVar != null) {
            hwVar.pr(list);
        }
    }

    @Override // com.byazt.ra.pr
    public void pr(com.byazt.pis.hw hwVar, int i, String str) {
        if (hwVar != null) {
            hwVar.pr(i, str);
        }
    }

    @Override // com.byazt.ra.pr
    /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
    public List<String> pr(List<aj> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<aj> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().x());
        }
        return arrayList;
    }

    @Override // com.byazt.ra.pr
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public String hw(List<aj> list) {
        Map<String, Object> mapG;
        if (list != null && !list.isEmpty() && (mapG = list.get(0).g()) != null && mapG.get(Constants.Bidding.REQUEST_ID) != null) {
            return (String) mapG.get(Constants.Bidding.REQUEST_ID);
        }
        return null;
    }
}
