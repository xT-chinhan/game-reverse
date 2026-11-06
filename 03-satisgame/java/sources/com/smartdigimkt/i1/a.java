package com.smartdigimkt.i1;

import android.text.TextUtils;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    /* JADX WARN: Code duplicated, block: B:63:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:68:0x00db  */
    public static void a(com.smartdigimkt.a3.a aVar, l lVar, com.smartdigimkt.e1.e eVar) {
        boolean zIsEmpty;
        boolean z;
        if (aVar == null || lVar == null) {
            return;
        }
        com.smartdigimkt.b3.e eVar2 = lVar.w;
        int i = aVar.k;
        if (eVar2 != null && eVar != null) {
            eVar2.f = eVar.a;
            if (i != 66) {
                eVar2.g = eVar.b;
            }
            eVar2.n = eVar.d;
            eVar2.o = eVar.c;
            eVar2.m = eVar.e;
            eVar2.l = eVar.f;
            eVar2.k = eVar.g;
            eVar2.I = eVar.h;
            eVar2.J = eVar.i;
            eVar2.w = eVar.j;
            eVar2.B1 = eVar.l;
        }
        if (i == 67 && eVar != null) {
            if (eVar.k) {
                lVar.n = 1;
            } else {
                lVar.n = 2;
            }
        }
        eVar2.a = aVar.c;
        aVar.s = eVar2;
        if (!lVar.h() && aVar.c == 1) {
            com.smartdigimkt.b3.e eVar3 = aVar.s;
            eVar3.x = eVar3.h0;
            eVar3.c1 = 1;
        }
        if (!c0.h(lVar, aVar)) {
            aVar.s.Q = 2;
        }
        if (aVar.s != null && TextUtils.isEmpty(lVar.l) && TextUtils.isEmpty(lVar.k)) {
            int i2 = lVar.o;
            if (i2 == 1 || i2 == 4) {
                zIsEmpty = TextUtils.isEmpty(lVar.N);
            } else if (i2 == 6) {
                if (TextUtils.isEmpty(lVar.A) || TextUtils.isEmpty(h.x())) {
                    z = false;
                } else {
                    com.smartdigimkt.a3.d dVarW = h.w();
                    boolean z2 = dVarW.b == 1;
                    boolean z3 = dVarW.a == 1;
                    if (z2 && z3) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                zIsEmpty = !z;
            } else if (i2 != 7) {
                com.smartdigimkt.b3.e eVar4 = aVar.s;
                eVar4.b = 0;
                eVar4.d = 0;
                eVar4.K = 2;
                eVar4.Q = 2;
                eVar4.getClass();
                com.smartdigimkt.b3.e eVar5 = aVar.s;
                eVar5.c = -2;
                eVar5.a0 = false;
                eVar5.b0 = false;
                eVar5.c0 = false;
                eVar5.n0 = 2;
                eVar5.D0 = 0L;
                eVar5.B0 = 0L;
                eVar5.K0 = 1;
                eVar5.f1 = 1;
            } else {
                zIsEmpty = TextUtils.isEmpty(lVar.O);
            }
            if (zIsEmpty) {
                com.smartdigimkt.b3.e eVar6 = aVar.s;
                eVar6.b = 0;
                eVar6.d = 0;
                eVar6.K = 2;
                eVar6.Q = 2;
                eVar6.getClass();
                com.smartdigimkt.b3.e eVar7 = aVar.s;
                eVar7.c = -2;
                eVar7.a0 = false;
                eVar7.b0 = false;
                eVar7.c0 = false;
                eVar7.n0 = 2;
                eVar7.D0 = 0L;
                eVar7.B0 = 0L;
                eVar7.K0 = 1;
                eVar7.f1 = 1;
            }
        }
        if (aVar.c != 3 || c0.h(lVar, aVar)) {
            aVar.s.m0 = 0;
        }
        if (TextUtils.isEmpty(lVar.l)) {
            aVar.s.l0 = 1;
        }
        if (lVar.i()) {
            com.smartdigimkt.x.c.a().updateOfferInfoWithDataInfo(lVar);
        }
        com.smartdigimkt.b3.e eVar8 = aVar.s;
        if (eVar8.B0 > 0) {
            eVar8.E0 = 2;
        }
        if (eVar8.c1 == 2) {
            eVar8.c = 0;
            eVar8.d = -1;
            if (TextUtils.isEmpty(lVar.c)) {
                int i3 = aVar.c;
                if (i3 == 1 || i3 == 3) {
                    lVar.c = SDKContext.getInstance().d().getString(k.a(SDKContext.getInstance().d(), "myoffer_sub_close_default_title", "string"));
                }
            }
        }
    }
}
