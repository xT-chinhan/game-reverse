package com.smartdigimkt.x4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends com.smartdigimkt.v4.c {
    public static void f(com.smartdigimkt.v4.a aVar) {
        com.smartdigimkt.h3.b bVar = aVar.x;
        if (bVar == null || bVar.a("offer")) {
            return;
        }
        bVar.a("resource");
    }

    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        String str;
        com.smartdigimkt.k1.d lVar;
        com.smartdigimkt.h3.b bVar = aVar.x;
        if (bVar != null) {
            bVar.d("offer");
        }
        SDMAdRequest sDMAdRequest = aVar.b;
        int i = aVar.c;
        com.smartdigimkt.a3.a aVar2 = aVar.p;
        if (aVar.n == null) {
            str = "place strategy is null";
        } else if (aVar.o == null) {
            str = "unit group info is null";
        } else {
            str = aVar2 == null ? "ad request info is null" : "";
        }
        if (!TextUtils.isEmpty(str)) {
            aVar.a(com.smartdigimkt.z3.b.a("10010", "load fail:".concat(str)));
            f(aVar);
            return false;
        }
        aVar2.s = aVar.n.E;
        Map<String, Object> extraMap = sDMAdRequest.getExtraMap();
        String str2 = (String) com.smartdigimkt.r4.k.a(extraMap, "my_oid", "");
        boolean zBooleanValue = ((Boolean) com.smartdigimkt.r4.k.a(extraMap, com.anythink.core.common.r.b, Boolean.FALSE)).booleanValue();
        if (TextUtils.isEmpty(str2)) {
            aVar.a(com.smartdigimkt.z3.b.a("10010", "load fail: offerId is null"));
            f(aVar);
            return false;
        }
        if (i == 0) {
            lVar = new com.smartdigimkt.k1.l(aVar.a, aVar2, str2, zBooleanValue);
        } else if (i == 1) {
            lVar = new com.smartdigimkt.k1.n(aVar.a, aVar2, str2, zBooleanValue);
        } else if (i == 2) {
            lVar = new com.smartdigimkt.k1.a(aVar.a, aVar2, str2, zBooleanValue);
        } else if (i != 3) {
            lVar = i != 4 ? null : new com.smartdigimkt.k1.p(aVar.a, aVar2, str2, zBooleanValue);
        } else {
            lVar = new com.smartdigimkt.k1.f(aVar.a, aVar2, str2, zBooleanValue);
        }
        if (lVar != null) {
            com.smartdigimkt.r4.b0.a(aVar.v, aVar);
            lVar.f = aVar.v;
            Map<String, Object> customEventMap = sDMAdRequest.getCustomEventMap();
            if (customEventMap == null) {
                customEventMap = new HashMap<>();
            }
            lVar.h = customEventMap;
            l lVar2 = new l(this, bVar, aVar, lVar);
            try {
                com.smartdigimkt.h0.g gVarB = lVar.b();
                if (gVarB != null) {
                    lVar2.a(gVarB);
                } else {
                    Map map = lVar.h;
                    if (map == null || map.isEmpty() || ((Integer) com.smartdigimkt.r4.k.a(lVar.h, SDMAdConst.EXTRA_PARAMS.E_L_PARAMS, (Object) 0)).intValue() != 1) {
                        com.smartdigimkt.l1.b bVarA = com.smartdigimkt.l1.b.a(lVar.a);
                        com.smartdigimkt.a3.a aVar3 = lVar.b;
                        bVarA.a(aVar3.b, lVar.e, aVar3, new com.smartdigimkt.k1.b(lVar, lVar2));
                    } else {
                        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.k1.c(lVar, lVar2));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                m mVar = lVar2.d;
                com.smartdigimkt.v4.a aVar4 = lVar2.b;
                mVar.getClass();
                f(aVar4);
                lVar2.b.a(com.smartdigimkt.z3.b.a("10010", "code[ -9999 ],desc[ " + message + " ]"));
                lVar2.d.d(lVar2.b);
            }
        } else {
            aVar.a(com.smartdigimkt.z3.b.a("10010", "not support format:" + aVar2.c));
            f(aVar);
        }
        return false;
    }
}
