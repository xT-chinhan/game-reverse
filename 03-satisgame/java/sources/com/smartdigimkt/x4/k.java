package com.smartdigimkt.x4;

import android.os.Bundle;
import android.text.TextUtils;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.core.bridge.entity.AppInfoEntity;
import com.smartdigimkt.sdk.core.bridge.entity.LoadInfoEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.smartdigimkt.v4.c {
    public static boolean a(com.smartdigimkt.v4.a aVar, JSONObject jSONObject, com.smartdigimkt.d3.c cVar, String str, com.smartdigimkt.p4.e eVar) {
        if (eVar == null) {
            aVar.a(com.smartdigimkt.z3.b.a("10006", "S2S placeStrategy is null for placementId: " + aVar.e));
            return false;
        }
        if (eVar.j != 1) {
            aVar.a(com.smartdigimkt.z3.b.a("10006", "Placement Ads switch is close."));
            return false;
        }
        if (aVar.c != eVar.m) {
            aVar.a(com.smartdigimkt.z3.b.a("10006", "S2S load format mismatch placement strategy."));
            return false;
        }
        com.smartdigimkt.p4.g gVarA = eVar.a();
        if (gVarA == null) {
            aVar.a(com.smartdigimkt.z3.b.a("10010", "S2S adxUnitGroupInfo is null"));
            return false;
        }
        String str2 = gVarA.r;
        if (TextUtils.isEmpty(str2) || !TextUtils.equals(str2, jSONObject.optString("unit_id")) || !TextUtils.equals(str2, jSONObject.optString("ad_source_id"))) {
            aVar.a(com.smartdigimkt.z3.b.a("10010", "S2S adm unit_id/ad_source_id mismatch placement adx unit"));
            return false;
        }
        gVarA.a = cVar;
        gVarA.a(cVar, 0, cVar.a ? 1 : 0);
        com.smartdigimkt.a3.a aVarA = com.smartdigimkt.a3.a.a(str, eVar, gVarA);
        aVar.a(2);
        aVar.g = str;
        aVar.n = eVar;
        aVar.o = gVarA;
        aVar.p = aVarA;
        aVarA.z = aVar.x;
        aVar.r = cVar;
        aVar.v = com.smartdigimkt.r4.b0.a(aVar);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:68:0x0169  */
    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        LoadInfoEntity loadInfoEntity;
        com.smartdigimkt.p4.e eVarB;
        AppInfoEntity appInfoEntity;
        Object obj;
        SDMAdRequest sDMAdRequest = aVar.b;
        com.smartdigimkt.p4.g gVarA = null;
        gVarA = null;
        gVarA = null;
        gVarA = null;
        gVarA = null;
        gVarA = null;
        Map<String, Object> extraMap = sDMAdRequest != null ? sDMAdRequest.getExtraMap() : null;
        if (extraMap != null && !extraMap.isEmpty() && (obj = extraMap.get("s2s_bid_adm")) != null) {
            aVar.a(2);
            try {
                JSONObject jSONObject = new JSONObject(com.smartdigimkt.r4.e.d(String.valueOf(obj)));
                String strOptString = jSONObject.optString("request_id", "");
                if (strOptString.isEmpty()) {
                    aVar.a(com.smartdigimkt.z3.b.a("10010", "S2S adm missing required field: request_id"));
                    return false;
                }
                com.smartdigimkt.d3.c cVarA = com.smartdigimkt.d3.b.a(jSONObject);
                if (cVarA == null) {
                    aVar.a(com.smartdigimkt.z3.b.a("10010", "S2S adm BiddingResult parse failed"));
                    return false;
                }
                cVarA.F = strOptString;
                if (TextUtils.isEmpty(cVarA.e) || TextUtils.isEmpty(cVarA.t)) {
                    aVar.a(com.smartdigimkt.z3.b.a("10010", "S2S adm must provide bid_id and req_url"));
                    return false;
                }
                String str = aVar.e;
                com.smartdigimkt.p4.e eVarB2 = com.smartdigimkt.o4.o.a().b(str);
                if (eVarB2 != null) {
                    return a(aVar, jSONObject, cVarA, strOptString, eVarB2);
                }
                com.smartdigimkt.y3.a aVar2 = new com.smartdigimkt.y3.a(str);
                aVar2.b = null;
                aVar2.d = aVar.x;
                aVar2.c = new i(this, aVar, jSONObject, cVarA, strOptString);
                com.smartdigimkt.q3.f.a().c(new j(new com.smartdigimkt.y3.b(aVar2)));
                return false;
            } catch (Throwable th) {
                aVar.a(com.smartdigimkt.z3.b.a("10010", "S2S adm parse failed: " + th.getMessage()));
                return false;
            }
        }
        if (extraMap == null || extraMap.isEmpty()) {
            loadInfoEntity = null;
        } else {
            Object obj2 = extraMap.get(com.anythink.core.bridge.a.C0010a.c);
            if (obj2 instanceof Bundle) {
                loadInfoEntity = (LoadInfoEntity) com.smartdigimkt.r2.b.a((Bundle) obj2, LoadInfoEntity.class);
            } else {
                loadInfoEntity = null;
            }
        }
        if (loadInfoEntity == null) {
            return true;
        }
        aVar.a(1);
        if (!loadInfoEntity.isValid()) {
            aVar.a(com.smartdigimkt.z3.b.a("10009", "It's request from mediation sdk, the loadInfoEntity is not valid, fail message:" + loadInfoEntity.getValidCheckMessage() + com.anythink.core.common.d.i.E));
            return false;
        }
        com.smartdigimkt.a3.a aVarConvertToBaseAdRequestInfo = loadInfoEntity.getRequestInfoEntity() != null ? loadInfoEntity.getRequestInfoEntity().convertToBaseAdRequestInfo() : null;
        if (aVarConvertToBaseAdRequestInfo == null) {
            aVar.a(com.smartdigimkt.z3.b.a("10009", "It's request from mediation sdk, the baseAdRequestInfo is not valid."));
            return false;
        }
        com.smartdigimkt.d3.c cVarConverToBiddingResult = loadInfoEntity.getBiddingResultInfoEntity() != null ? loadInfoEntity.getBiddingResultInfoEntity().converToBiddingResult() : null;
        if (cVarConverToBiddingResult == null) {
            aVar.a(com.smartdigimkt.z3.b.a("10009", "It's request from mediation sdk, the biddingResult is not valid."));
            return false;
        }
        String str2 = aVar.e;
        if (extraMap == null || extraMap.isEmpty()) {
            eVarB = null;
        } else {
            Object obj3 = extraMap.get(com.anythink.core.bridge.a.C0010a.d);
            if (obj3 instanceof JSONObject) {
                eVarB = com.smartdigimkt.p4.e.a(str2, (JSONObject) obj3);
            } else {
                eVarB = null;
            }
        }
        if (eVarB == null) {
            eVarB = com.smartdigimkt.o4.o.a().b(str2);
        }
        if (eVarB == null) {
            eVarB = null;
        } else {
            com.smartdigimkt.o4.o.a().a(str2, eVarB, null);
        }
        if (eVarB == null) {
            aVar.a(com.smartdigimkt.z3.b.a("10009", "It's request from mediation sdk, the placeStrategy is not valid."));
            return false;
        }
        int i = aVarConvertToBaseAdRequestInfo.k;
        if (i == 35) {
            String str3 = aVarConvertToBaseAdRequestInfo.f;
            if (!TextUtils.isEmpty(str3)) {
                List list = eVarB.H;
                if (!list.isEmpty()) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (TextUtils.equals(str3, ((com.smartdigimkt.p4.g) list.get(i2)).r)) {
                            gVarA = (com.smartdigimkt.p4.g) list.get(i2);
                            break;
                        }
                    }
                }
            }
        } else if (i != 67) {
            gVarA = eVarB.a();
        } else {
            String str4 = aVarConvertToBaseAdRequestInfo.f;
            if (!TextUtils.isEmpty(str4)) {
                ArrayList arrayListA = com.smartdigimkt.q4.a.a(eVarB, eVarB.r, 7, 8);
                if (!arrayListA.isEmpty()) {
                    for (int i3 = 0; i3 < arrayListA.size(); i3++) {
                        if (TextUtils.equals(str4, ((com.smartdigimkt.p4.g) arrayListA.get(i3)).r)) {
                            gVarA = (com.smartdigimkt.p4.g) arrayListA.get(i3);
                            break;
                        }
                    }
                }
            }
        }
        if (gVarA == null) {
            aVar.a(com.smartdigimkt.z3.b.a("10009", "It's request from mediation sdk, the unitGroupInfo is not valid."));
            return false;
        }
        gVarA.a = cVarConverToBiddingResult;
        gVarA.a(cVarConverToBiddingResult, 0, cVarConverToBiddingResult.a ? 1 : 0);
        aVar.g = aVarConvertToBaseAdRequestInfo.g;
        aVar.n = eVarB;
        aVar.o = gVarA;
        aVar.p = aVarConvertToBaseAdRequestInfo;
        aVarConvertToBaseAdRequestInfo.z = aVar.x;
        aVar.r = cVarConverToBiddingResult;
        com.smartdigimkt.f3.a aVarA = com.smartdigimkt.r4.b0.a(aVar);
        aVar.v = aVarA;
        if (extraMap != null) {
            Object obj4 = extraMap.get(com.anythink.core.bridge.a.C0010a.b);
            if ((obj4 instanceof Bundle) && (appInfoEntity = (AppInfoEntity) com.smartdigimkt.r2.b.a((Bundle) obj4, AppInfoEntity.class)) != null && !TextUtils.isEmpty(appInfoEntity.getMediationVersion())) {
                String mediationVersion = appInfoEntity.getMediationVersion();
                aVarA.w = mediationVersion != null ? mediationVersion : "";
            }
        }
        return true;
    }
}
