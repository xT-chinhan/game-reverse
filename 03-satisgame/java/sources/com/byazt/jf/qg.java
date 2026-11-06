package com.byazt.jf;

import android.text.TextUtils;
import com.byazt.vy.py;
import com.byazt.ws.tj;
import com.byazt.yc.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1388, 26})
public class qg implements n {
    @Override // com.byazt.jf.n
    public boolean n(com.byazt.zb.qg qgVar, com.byazt.sg.s sVar, List<tj> list) {
        if (sVar == null || qgVar == null) {
            return false;
        }
        if (qgVar.hd().w(x.n(qgVar.cy(), sVar)) == 0) {
            return true;
        }
        return n(sVar, list);
    }

    public boolean n(com.byazt.sg.s sVar, List<tj> list) {
        if (sVar == null || TextUtils.isEmpty(sVar.el()) || !sVar.ze() || py.n(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !py.qg(arrayList) && sVar.el().equals(((tj) arrayList.get(0)).cd());
    }
}
