package com.anythink.core.common.v;

import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bz;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static int a(bv bvVar, bv bvVar2) {
        if (bvVar2 == null) {
            return -1;
        }
        if (bvVar == null) {
            return 1;
        }
        return a(bvVar.R(), p.a(bvVar), bvVar2.R(), p.a(bvVar2));
    }

    public static int b(bv bvVar, bv bvVar2) {
        if (bvVar2 == null) {
            return -1;
        }
        if (bvVar == null) {
            return 1;
        }
        return a(bvVar.R(), p.c(bvVar), bvVar2.R(), p.c(bvVar2));
    }

    public static int a(com.anythink.core.common.h.ad adVar, com.anythink.core.common.h.ad adVar2) {
        if (adVar2 == null) {
            return -1;
        }
        return a(adVar, adVar.getSortPrice(), adVar2, adVar2.getSortPrice());
    }

    public static int a(bz.a aVar, bz.a aVar2) {
        if (aVar2 == null) {
            return -1;
        }
        if (aVar == null) {
            return 1;
        }
        return a(aVar.j, aVar.d, aVar2.j, aVar2.d);
    }

    private static int a(com.anythink.core.common.h.ad adVar, double d, com.anythink.core.common.h.ad adVar2, double d2) {
        int iW;
        int iT;
        int iW2;
        int iT2;
        if (adVar == null || !adVar.s()) {
            iW = 0;
            iT = 0;
        } else {
            iT = adVar.t();
            iW = adVar.w();
        }
        if (adVar2 == null || !adVar2.s()) {
            iW2 = 0;
            iT2 = 0;
        } else {
            iT2 = adVar2.t();
            iW2 = adVar2.w();
        }
        if (iT == 0 || iT2 == 0) {
            if (iT > 0) {
                return -1;
            }
            if (iT2 > 0) {
                return 1;
            }
            if (d > d2) {
                return -1;
            }
            return d == d2 ? 0 : 1;
        }
        if (iT != iT2) {
            return -(iT - iT2);
        }
        if (iT == 3) {
            return iW - iW2;
        }
        if (d > d2) {
            return -1;
        }
        return d == d2 ? 0 : 1;
    }
}
