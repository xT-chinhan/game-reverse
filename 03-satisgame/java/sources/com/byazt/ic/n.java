package com.byazt.ic;

import android.text.TextUtils;
import com.byazt.rb.q;
import com.byazt.sg.s;
import com.byazt.ws.qg;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2228, 19})
public class n {
    public static void n(qg qgVar, com.byazt.zb.qg qgVar2, List<tj> list) {
        boolean z;
        if (qgVar == null || qgVar2 == null || list == null || list.size() == 0) {
            return;
        }
        for (s sVar : qgVar2.d()) {
            Iterator<tj> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                tj next = it.next();
                if (sVar != null && next != null && sVar.el().equals(next.cd())) {
                    z = false;
                    break;
                }
            }
            if (z) {
                com.byazt.rb.qg.q(MediationConstant.TAG, q.n(qgVar) + "已经响应的广告: " + sVar.el() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                qgVar2.d().remove(sVar);
                qgVar2.oa().add(sVar);
            }
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, q.n(qgVar) + "已经响应的广告被serverBidding过滤完还剩: " + qgVar2.d().size());
    }

    public static boolean n(com.byazt.zb.n nVar, List<tj> list, String str) {
        if (list == null || nVar == null || TextUtils.isEmpty(str) || nVar.qg() != 1) {
            return false;
        }
        Iterator<tj> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().cd())) {
                return false;
            }
        }
        return true;
    }
}
