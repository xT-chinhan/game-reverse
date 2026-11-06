package com.anythink.core.common.v;

import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bw;
import com.anythink.core.common.h.bz;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ak {
    public static boolean a(List<bv> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                bv bvVar = list.get(i);
                if (bvVar != null && bvVar.an()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(bv bvVar) {
        return bvVar.g() == 15 && !bvVar.o();
    }

    public static List<bz.a> a(String str, bv bvVar) {
        bw bwVarA;
        if (bvVar == null || (bwVarA = com.anythink.core.common.a.a().a(str, bvVar)) == null) {
            return null;
        }
        List<bz.a> listF = bwVarA.a((com.anythink.core.common.h.ad) null).f();
        com.anythink.core.common.h.ad adVarA = com.anythink.core.b.f.a().a(str, bvVar);
        if (adVarA != null && !adVarA.a()) {
            if (listF == null) {
                listF = new ArrayList<>();
            }
            listF.add(new bz.a(bvVar, adVarA));
        }
        return listF;
    }

    public static boolean b(bv bvVar) {
        return bvVar.g() == 66;
    }

    public static long c(bv bvVar) {
        if (bvVar == null) {
            return 0L;
        }
        if (bvVar.g() == 39 && bvVar.bc()) {
            return bvVar.be();
        }
        return bvVar.v();
    }

    public static String a(bv bvVar, ATBaseAdAdapter aTBaseAdAdapter) {
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
        String strY = bvVar != null ? bvVar.Y() : "";
        return !TextUtils.isEmpty(strY) ? strY : "";
    }
}
