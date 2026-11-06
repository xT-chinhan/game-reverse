package com.byazt.si;

import com.byazt.mr.vk;
import com.byazt.pis.hn;
import com.tapsdk.tapad.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1849, 37})
public class pr extends com.byazt.ra.pr<hn, List<vk>> {
    public static final pr hw = new pr();

    private pr() {
    }

    public static pr x() {
        return hw;
    }

    @Override // com.byazt.ra.pr
    public int pr() {
        return 6;
    }

    @Override // com.byazt.ra.pr
    public void pr(hn hnVar, List<vk> list) {
        if (hnVar != null) {
            hnVar.pr(list);
        }
    }

    @Override // com.byazt.ra.pr
    public void pr(hn hnVar, int i, String str) {
        if (hnVar != null) {
            hnVar.pr(i, str);
        }
    }

    @Override // com.byazt.ra.pr
    /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
    public List<String> pr(List<vk> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<vk> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().x());
        }
        return arrayList;
    }

    @Override // com.byazt.ra.pr
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public String hw(List<vk> list) {
        Map<String, Object> mapG;
        if (list != null && !list.isEmpty() && (mapG = list.get(0).g()) != null && mapG.get(Constants.Bidding.REQUEST_ID) != null) {
            return (String) mapG.get(Constants.Bidding.REQUEST_ID);
        }
        return null;
    }
}
