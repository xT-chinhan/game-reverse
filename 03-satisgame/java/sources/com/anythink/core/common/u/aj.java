package com.anythink.core.common.u;

import android.text.TextUtils;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.h.cc;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class aj {
    public static boolean a(List<by> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                by byVar = list.get(i);
                if (byVar != null && byVar.av()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(by byVar) {
        return byVar.n() == 15 && !byVar.w();
    }

    public static boolean b(by byVar) {
        return byVar.n() == 66;
    }

    public static long c(by byVar) {
        if (byVar == null) {
            return 0L;
        }
        if (byVar.n() == 39 && byVar.bk()) {
            return byVar.bm();
        }
        return byVar.C();
    }

    public static String a(by byVar, ATBaseAdAdapter aTBaseAdAdapter) {
        String internalNetworkPlacementId;
        if (aTBaseAdAdapter != null) {
            try {
                internalNetworkPlacementId = aTBaseAdAdapter.getInternalNetworkPlacementId();
            } catch (Throwable unused) {
            }
        } else {
            internalNetworkPlacementId = "";
        }
        if (!TextUtils.isEmpty(internalNetworkPlacementId)) {
            return internalNetworkPlacementId;
        }
        String strAf = byVar != null ? byVar.af() : "";
        return !TextUtils.isEmpty(strAf) ? strAf : "";
    }

    public static List<cc.a> a(String str, by byVar, com.anythink.core.common.h.a aVar) {
        com.anythink.core.c.f fVarF;
        com.anythink.core.common.h.ad adVarA;
        if (byVar == null) {
            return null;
        }
        bz bzVarA = (aVar == null || aVar.J == null || aVar.J.e() == null) ? null : aVar.J.e().a(str, byVar);
        if (bzVarA == null) {
            return null;
        }
        List<cc.a> listF = bzVarA.a((com.anythink.core.common.h.ad) null).f();
        if (aVar.J != null && (fVarF = aVar.J.f()) != null && (adVarA = fVarF.a(str, byVar)) != null && !adVarA.a()) {
            if (listF == null) {
                listF = new ArrayList();
            }
            listF.add(new cc.a(byVar, adVarA));
        }
        return listF;
    }
}
