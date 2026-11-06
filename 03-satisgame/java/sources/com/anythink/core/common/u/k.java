package com.anythink.core.common.u;

import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cc;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static int a(by byVar, by byVar2) {
        if (byVar2 == null) {
            return -1;
        }
        if (byVar == null) {
            return 1;
        }
        return a(byVar.Y(), o.a(byVar), byVar2.Y(), o.a(byVar2));
    }

    public static int b(by byVar, by byVar2) {
        if (byVar2 == null) {
            return -1;
        }
        if (byVar == null) {
            return 1;
        }
        return a(byVar.Y(), o.c(byVar), byVar2.Y(), o.c(byVar2));
    }

    public static int a(com.anythink.core.common.h.ad adVar, com.anythink.core.common.h.ad adVar2) {
        if (adVar2 == null) {
            return -1;
        }
        return a(adVar, adVar.getSortPrice(), adVar2, adVar2.getSortPrice());
    }

    public static int a(cc.a aVar, cc.a aVar2) {
        if (aVar2 == null) {
            return -1;
        }
        if (aVar == null) {
            return 1;
        }
        return a(aVar.j, aVar.d, aVar2.j, aVar2.d);
    }

    private static int a(com.anythink.core.common.h.ad adVar, double d, com.anythink.core.common.h.ad adVar2, double d2) {
        int iV;
        int iS;
        int iV2;
        int iS2;
        if (adVar == null || !adVar.r()) {
            iV = 0;
            iS = 0;
        } else {
            iS = adVar.s();
            iV = adVar.v();
        }
        if (adVar2 == null || !adVar2.r()) {
            iV2 = 0;
            iS2 = 0;
        } else {
            iS2 = adVar2.s();
            iV2 = adVar2.v();
        }
        if (iS == 0 || iS2 == 0) {
            if (iS > 0) {
                return -1;
            }
            if (iS2 > 0) {
                return 1;
            }
            if (d > d2) {
                return -1;
            }
            return d == d2 ? 0 : 1;
        }
        if (iS != iS2) {
            return -(iS - iS2);
        }
        if (iS == 3) {
            return iV - iV2;
        }
        if (d > d2) {
            return -1;
        }
        return d == d2 ? 0 : 1;
    }
}
