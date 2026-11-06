package com.anythink.core.common.v;

import com.anythink.core.common.h.bv;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String a = "f";

    public static void a(com.anythink.core.d.l lVar, Map<String, Object> map, bv bvVar, com.anythink.core.common.h.ac acVar) {
        if (acVar == null) {
            return;
        }
        double dJ = acVar.j();
        if (dJ < 0.0d) {
            return;
        }
        int iK = acVar.k();
        boolean zL = acVar.l();
        List<Integer> listM = lVar.m();
        if (listM == null) {
            return;
        }
        boolean zO = bvVar.o();
        int i = 2;
        boolean z = false;
        if (iK == 22) {
            if ((zO && listM.contains(3)) || (!zO && listM.contains(1))) {
                z = true;
            }
        } else if (!(zO && listM.contains(4)) && (zO || !listM.contains(2))) {
            i = 5;
        } else {
            i = 5;
            z = true;
        }
        if (z) {
            int iL = (int) ((dJ / lVar.L()) * 100.0d);
            int i2 = zL ? 3 : 1;
            boolean zF = acVar.f();
            new StringBuilder("fillBiddingWinnerParams, need to transfer bidding info, current unitGroupInfo: ").append(bvVar);
            listM.toString();
            map.put(com.anythink.core.common.d.j.w.u, Integer.valueOf(i));
            map.put(com.anythink.core.common.d.j.w.v, Integer.valueOf(iL));
            map.put(com.anythink.core.common.d.j.w.w, Integer.valueOf(i2));
            map.put(com.anythink.core.common.d.j.w.x, Integer.valueOf(zF ? 1 : 0));
            return;
        }
        listM.toString();
    }
}
