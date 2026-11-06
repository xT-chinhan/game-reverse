package com.smartdigimkt.t4;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.api.format.SDMWinInfo;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {
    public static final /* synthetic */ int b = 0;
    public final com.smartdigimkt.e1.d a;

    public d0(com.smartdigimkt.e1.d dVar) {
        this.a = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003f A[PHI: r4
      0x003f: PHI (r4v8 java.lang.String) = (r4v1 java.lang.String), (r4v9 java.lang.String) binds: [B:22:0x003c, B:19:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    public static void b(com.smartdigimkt.u4.a aVar) {
        String str;
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.d dVar;
        SDMLossInfo sDMLossInfo;
        SDMLossInfo sDMLossInfo2;
        if (aVar == null) {
            return;
        }
        com.smartdigimkt.e1.d dVar2 = aVar.a;
        if (dVar2 != null) {
            new d0(dVar2).a(aVar);
        }
        com.smartdigimkt.f3.a aVar2 = aVar.d;
        if (aVar2 == null) {
            com.smartdigimkt.e1.d dVar3 = aVar.a;
            aVar2 = dVar3 != null ? dVar3.l : null;
        }
        if (aVar2 == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.f3.a aVarA = aVar2.a();
        String str2 = "0";
        if (aVar.b) {
            str = aVar.j;
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
        } else {
            str = aVar.i;
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
        }
        boolean z = aVar.b;
        int i = z ? 1 : 2;
        int i2 = aVar.m;
        if (i2 <= 0) {
            i2 = 4;
            if (!z && (sDMLossInfo2 = aVar.f) != null && sDMLossInfo2.getLossReasonCode() == 4) {
                i2 = 25;
            }
        }
        aVarA.s0 = i2;
        aVarA.p0 = i;
        aVarA.q0 = str2;
        aVarA.r0 = jCurrentTimeMillis;
        if (i == 2 && (sDMLossInfo = aVar.f) != null) {
            String strValueOf = String.valueOf(sDMLossInfo.getLossReasonCode());
            if (strValueOf == null) {
                strValueOf = "";
            }
            aVarA.t0 = strValueOf;
        }
        if (dVar2 != null) {
            try {
                com.smartdigimkt.b3.b bVar = dVar2.e;
                com.smartdigimkt.a3.a aVar3 = dVar2.c;
                if (bVar != null && (eVar = bVar.w) != null && (dVar = eVar.R1) != null) {
                    long j = dVar.a;
                    if (j > 0) {
                        aVarA.a(j, bVar, aVar3);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(24, aVarA, jCurrentTimeMillis);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003f A[PHI: r4
      0x003f: PHI (r4v11 java.lang.String) = (r4v1 java.lang.String), (r4v12 java.lang.String) binds: [B:22:0x003c, B:19:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    public static void c(com.smartdigimkt.u4.a aVar) {
        String str;
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.d dVar;
        SDMLossInfo sDMLossInfo;
        SDMLossInfo sDMLossInfo2;
        SDMLossInfo.SEAT_ID seatId;
        SDMLossInfo sDMLossInfo3;
        SDMLossInfo sDMLossInfo4;
        if (aVar == null) {
            return;
        }
        com.smartdigimkt.e1.d dVar2 = aVar.a;
        if (dVar2 != null) {
            new d0(dVar2).a(aVar);
        }
        com.smartdigimkt.f3.a aVar2 = aVar.d;
        if (aVar2 == null) {
            com.smartdigimkt.e1.d dVar3 = aVar.a;
            aVar2 = dVar3 != null ? dVar3.l : null;
        }
        if (aVar2 == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.smartdigimkt.f3.a aVarA = aVar2.a();
        String str2 = "0";
        if (aVar.b) {
            str = aVar.j;
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
        } else {
            str = aVar.i;
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
        }
        boolean z = aVar.b;
        int i = z ? 1 : 2;
        int i2 = aVar.m;
        if (i2 <= 0) {
            i2 = 4;
            if (!z && (sDMLossInfo4 = aVar.f) != null && sDMLossInfo4.getLossReasonCode() == 4) {
                i2 = 25;
            }
        }
        aVarA.s0 = i2;
        aVarA.p0 = i;
        aVarA.q0 = str2;
        aVarA.r0 = jCurrentTimeMillis;
        if (i == 2 && (sDMLossInfo3 = aVar.f) != null) {
            String strValueOf = String.valueOf(sDMLossInfo3.getLossReasonCode());
            if (strValueOf == null) {
                strValueOf = "";
            }
            aVarA.t0 = strValueOf;
        }
        int i3 = 0;
        aVarA.u0 = (aVar.b || (sDMLossInfo2 = aVar.f) == null || SDMLossInfo.isInternalLossReason(sDMLossInfo2.getLossReasonCode()) || (seatId = sDMLossInfo2.getSeatId()) == null) ? 0 : seatId.getCode();
        try {
            com.smartdigimkt.b3.b bVar = dVar2.e;
            if (bVar instanceof com.smartdigimkt.b3.l) {
                String str3 = bVar.c0;
                if (!TextUtils.isEmpty(str3)) {
                    i3 = Integer.parseInt(str3.trim());
                }
            }
        } catch (Throwable unused) {
        }
        aVarA.x0 = i3;
        if (!aVar.b && (sDMLossInfo = aVar.f) != null && sDMLossInfo.getLossReason() == SDMLossInfo.LOSS_REASON.LOSS_TO_HIGHER_BID) {
            String strValueOf2 = String.valueOf(sDMLossInfo.getWinPrice());
            if (strValueOf2 == null) {
                strValueOf2 = "";
            }
            aVarA.v0 = strValueOf2;
            String strValueOf3 = String.valueOf(sDMLossInfo.getWinPrice(SDMAdConst.CURRENCY.USD));
            aVarA.w0 = strValueOf3 != null ? strValueOf3 : "";
        }
        if (dVar2 != null) {
            try {
                com.smartdigimkt.b3.b bVar2 = dVar2.e;
                com.smartdigimkt.a3.a aVar3 = dVar2.c;
                if (bVar2 != null && (eVar = bVar2.w) != null && (dVar = eVar.R1) != null) {
                    long j = dVar.a;
                    if (j > 0) {
                        aVarA.a(j, bVar2, aVar3);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(29, aVarA, jCurrentTimeMillis);
    }

    public static void d(com.smartdigimkt.u4.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.b) {
                SDMWinInfo sDMWinInfo = aVar.e;
                com.smartdigimkt.e1.d dVar = aVar.a;
                com.smartdigimkt.d3.c cVar = dVar.k;
                com.smartdigimkt.a3.a aVar2 = dVar.c;
                com.smartdigimkt.b3.b bVar = dVar.e;
                com.smartdigimkt.p4.g gVar = dVar.j;
                String strValueOf = String.valueOf(aVar2.k);
                com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar2.c), strValueOf);
                cVar2.a = "3000005";
                cVar2.a(dVar.l);
                cVar2.l = strValueOf;
                cVar2.m = aVar2.f;
                cVar2.n = aVar.j;
                cVar2.o = String.valueOf(cVar.c);
                if (sDMWinInfo != null) {
                    cVar2.p = String.valueOf(sDMWinInfo.getSecondPrice());
                    SDMAdConst.CURRENCY currency = sDMWinInfo.getCurrency();
                    if (currency != null) {
                        cVar2.q = currency.toString();
                    }
                    String strA = com.smartdigimkt.r4.k.a("bidding_name", sDMWinInfo.getExtraMap());
                    if (!TextUtils.isEmpty(strA)) {
                        cVar2.w = strA;
                    }
                } else {
                    cVar2.p = "0";
                }
                cVar2.r = String.valueOf(gVar.C == 1);
                cVar2.s = String.valueOf(cVar.B);
                cVar2.t = String.valueOf(cVar.G);
                cVar2.u = aVar.k;
                cVar2.v = aVar.l;
                cVar2.x = "1";
                if (bVar instanceof com.smartdigimkt.b3.b) {
                    cVar2.y = bVar.c0;
                }
                cVar2.z = bVar != null ? bVar.a : "";
                cVar2.A = aVar2.l;
                com.smartdigimkt.n3.k.a(cVar2);
            } else {
                SDMLossInfo sDMLossInfo = aVar.f;
                com.smartdigimkt.e1.d dVar2 = aVar.a;
                if (dVar2 == null) {
                    com.smartdigimkt.n3.k.a(aVar, sDMLossInfo);
                } else {
                    com.smartdigimkt.a3.a aVar3 = dVar2.c;
                    com.smartdigimkt.b3.b bVar2 = dVar2.e;
                    com.smartdigimkt.p4.g gVar2 = dVar2.j;
                    com.smartdigimkt.d3.c cVar3 = dVar2.k;
                    String strValueOf2 = String.valueOf(aVar3.k);
                    com.smartdigimkt.f3.c cVar4 = new com.smartdigimkt.f3.c(String.valueOf(aVar3.c), strValueOf2);
                    cVar4.a = "3000006";
                    cVar4.a(dVar2.l);
                    cVar4.l = strValueOf2;
                    cVar4.m = aVar3.f;
                    cVar4.n = aVar.i;
                    cVar4.o = String.valueOf(sDMLossInfo.getLossReasonCode());
                    cVar4.p = String.valueOf(cVar3.c);
                    cVar4.q = String.valueOf(sDMLossInfo.getWinPrice());
                    cVar4.r = String.valueOf(sDMLossInfo.getCurrency());
                    cVar4.s = String.valueOf(gVar2.D == 1);
                    cVar4.t = String.valueOf(cVar3.B);
                    cVar4.u = String.valueOf(cVar3.G);
                    cVar4.v = aVar.k;
                    cVar4.w = aVar.l;
                    String strA2 = com.smartdigimkt.r4.k.a("bidding_name", sDMLossInfo.getExtraMap());
                    if (!TextUtils.isEmpty(strA2)) {
                        cVar4.x = strA2;
                    }
                    cVar4.y = "1";
                    if (bVar2 instanceof com.smartdigimkt.b3.b) {
                        cVar4.z = bVar2.c0;
                    }
                    cVar4.A = bVar2 != null ? bVar2.a : "";
                    cVar4.B = aVar3.l;
                    com.smartdigimkt.n3.k.a(cVar4);
                }
            }
        } catch (Throwable unused) {
        }
        b(aVar);
        c(aVar);
    }

    public final void a(com.smartdigimkt.u4.a aVar) {
        try {
            if (aVar.b) {
                SDMWinInfo sDMWinInfo = aVar.e;
                if (sDMWinInfo != null) {
                    a(this.a, sDMWinInfo, aVar);
                }
            } else {
                SDMLossInfo sDMLossInfo = aVar.f;
                if (sDMLossInfo != null) {
                    b(this.a, sDMLossInfo, aVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(com.smartdigimkt.e1.d dVar) {
        com.smartdigimkt.f3.a aVar = dVar != null ? dVar.l : null;
        return aVar != null && aVar.v;
    }

    public static void a(com.smartdigimkt.d3.c cVar, SDMLossInfo sDMLossInfo, com.smartdigimkt.f3.a aVar) {
        JSONArray jSONArrayOptJSONArray;
        if (cVar == null || sDMLossInfo == null) {
            return;
        }
        sDMLossInfo.getLossReasonCode();
        com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
        Context contextD = SDKContext.getInstance().d();
        String str = cVar.e;
        eVarA.getClass();
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.c(eVarA, contextD, str));
        if (cVar.a(false, sDMLossInfo)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = cVar.R;
            if (jSONObject == null && !TextUtils.isEmpty(cVar.y)) {
                jSONObject = new JSONObject(cVar.y);
            }
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tk");
                if (jSONObjectOptJSONObject == null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.anythink.core.common.l.f.R);
                    if (jSONObjectOptJSONObject2 != null) {
                        jSONObject = jSONObjectOptJSONObject2;
                    }
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("seatbid");
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.optJSONObject(0) : null;
                    if (jSONObjectOptJSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("tk");
                    }
                }
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("lurl")) != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            arrayList.add(strOptString);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        boolean z = !TextUtils.isEmpty(cVar.h);
        if (aVar != null) {
            try {
                if (aVar.P <= 0) {
                    int i2 = cVar.p;
                    if (i2 <= 0) {
                        i2 = 66;
                    }
                    aVar.P = i2;
                }
                String str2 = aVar.Q;
                if (str2 == null || str2.length() == 0) {
                    String str3 = cVar.A;
                    aVar.Q = (str3 == null || str3.length() <= 0) ? cVar.o : cVar.A;
                }
                com.smartdigimkt.u4.a aVar2 = new com.smartdigimkt.u4.a(cVar, aVar);
                aVar2.f = sDMLossInfo;
                aVar2.m = 25;
                d(aVar2);
            } catch (Throwable unused2) {
            }
        }
        if (z || !arrayList.isEmpty()) {
            HashMap map = new HashMap();
            int lossReasonCode = sDMLossInfo.getLossReasonCode();
            map.put(com.anythink.core.c.d.c.d, String.valueOf(lossReasonCode));
            map.put(com.anythink.core.c.d.c.k, (lossReasonCode < 1 || lossReasonCode > 7) ? "900" : "203");
            map.put(com.anythink.core.c.d.c.l, String.valueOf(System.currentTimeMillis() / 1000));
            com.smartdigimkt.q3.f.a().b(new b0(z, cVar, map, arrayList));
        }
    }

    public static void b(com.smartdigimkt.e1.d dVar) {
        com.smartdigimkt.p4.g gVar;
        com.smartdigimkt.d3.c cVar;
        if (dVar == null || (gVar = dVar.j) == null || (cVar = gVar.a) == null || cVar.a(true, null)) {
            return;
        }
        if (gVar.C == 1) {
            com.smartdigimkt.q3.f.a().b(new a0(dVar));
            return;
        }
        com.smartdigimkt.u4.a aVar = new com.smartdigimkt.u4.a(dVar, true);
        aVar.e = new SDMWinInfo(0.0d);
        if (!a(dVar)) {
            aVar.m = 1;
        }
        d(aVar);
    }

    public static HashMap b(com.smartdigimkt.e1.d dVar, SDMLossInfo sDMLossInfo, com.smartdigimkt.u4.a aVar) {
        HashMap map = new HashMap();
        if (sDMLossInfo == null) {
            return map;
        }
        int lossReasonCode = sDMLossInfo.getLossReasonCode();
        map.put(com.anythink.core.c.d.c.d, String.valueOf(lossReasonCode));
        map.put(com.anythink.core.c.d.c.k, (lossReasonCode < 1 || lossReasonCode > 7) ? "900" : "203");
        map.put(com.anythink.core.c.d.c.l, String.valueOf(System.currentTimeMillis() / 1000));
        if (sDMLossInfo.getLossReason() == SDMLossInfo.LOSS_REASON.LOSS_TO_HIGHER_BID) {
            SDMLossInfo.SEAT_ID seatId = sDMLossInfo.getSeatId();
            if (seatId != null) {
                map.put(com.anythink.core.c.d.c.e, String.valueOf(seatId.getCode()));
            }
            String strA = com.smartdigimkt.r4.k.a("bidding_name", sDMLossInfo.getExtraMap());
            if (TextUtils.isEmpty(strA)) {
                strA = "";
            }
            map.put(com.anythink.core.c.d.c.i, strA);
            com.smartdigimkt.d3.c cVar = dVar != null ? dVar.k : null;
            if (cVar == null) {
                return map;
            }
            double winPrice = sDMLossInfo.getWinPrice(SDMAdConst.CURRENCY.USD);
            double d = cVar.B;
            if (d > 0.0d) {
                winPrice *= d;
            }
            String strA2 = a(cVar, winPrice);
            map.put(com.anythink.core.c.d.c.b, strA2);
            String strA3 = a(cVar, winPrice);
            try {
                strA3 = String.valueOf((int) Math.round(Double.parseDouble(strA3)));
            } catch (Throwable unused) {
            }
            map.put(com.anythink.core.c.d.c.c, strA3);
            if (aVar != null) {
                aVar.i = strA2;
            }
        }
        return map;
    }

    public final boolean a() {
        com.smartdigimkt.e1.d dVar = this.a;
        com.smartdigimkt.f3.a aVar = dVar != null ? dVar.l : null;
        return aVar != null && aVar.v;
    }

    public static void a(com.smartdigimkt.e1.d dVar, SDMWinInfo sDMWinInfo, com.smartdigimkt.u4.a aVar) {
        com.smartdigimkt.d3.c cVar = dVar.k;
        if (cVar != null && sDMWinInfo != null) {
            double secondPrice = sDMWinInfo.getSecondPrice(SDMAdConst.CURRENCY.USD);
            double d = cVar.B;
            if (d > 0.0d) {
                secondPrice *= d;
            }
            String strA = com.smartdigimkt.r4.k.a("bidding_name", sDMWinInfo.getExtraMap());
            if (TextUtils.isEmpty(strA)) {
                strA = "";
            }
            HashMap map = new HashMap();
            String strA2 = a(cVar, secondPrice);
            map.put(com.anythink.core.c.d.c.f, strA2);
            map.put(com.anythink.core.c.d.c.i, strA);
            if (aVar != null) {
                aVar.j = strA2;
                return;
            }
            return;
        }
        new HashMap();
    }

    public static com.smartdigimkt.u4.a a(boolean z, com.smartdigimkt.e1.d dVar, SDMWinInfo sDMWinInfo, SDMLossInfo sDMLossInfo) {
        String strA;
        com.smartdigimkt.d3.c cVar = dVar.k;
        com.smartdigimkt.u4.a aVar = new com.smartdigimkt.u4.a(dVar, z);
        aVar.e = sDMWinInfo;
        aVar.f = sDMLossInfo;
        if (cVar == null) {
            return aVar;
        }
        if (z) {
            strA = cVar.g;
        } else {
            String str = cVar.h;
            strA = sDMLossInfo != null ? a(str, b(dVar, sDMLossInfo, aVar)) : str;
        }
        if (z) {
            aVar.g = strA;
        } else {
            aVar.h = strA;
        }
        return aVar;
    }

    public static void a(com.smartdigimkt.e1.d dVar, SDMLossInfo sDMLossInfo) {
        com.smartdigimkt.d3.c cVar;
        com.smartdigimkt.p4.g gVar = dVar.j;
        if (gVar == null || (cVar = gVar.a) == null || cVar.a(false, sDMLossInfo)) {
            return;
        }
        SDMLossInfo.isInternalLossReason(sDMLossInfo.getLossReasonCode());
        sDMLossInfo.getLossReasonCode();
        sDMLossInfo.getLossReasonCode();
        com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
        Context contextD = SDKContext.getInstance().d();
        String str = cVar.e;
        eVarA.getClass();
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.c(eVarA, contextD, str));
        if (gVar.D == 1) {
            com.smartdigimkt.q3.f.a().b(new z(dVar, sDMLossInfo));
        } else {
            com.smartdigimkt.u4.a aVar = new com.smartdigimkt.u4.a(dVar, false);
            aVar.f = sDMLossInfo;
            a(dVar, sDMLossInfo, aVar);
            d(aVar);
        }
        dVar.a();
    }

    public static void a(com.smartdigimkt.e1.d dVar, SDMWinInfo sDMWinInfo) {
        com.smartdigimkt.p4.g gVar;
        com.smartdigimkt.d3.c cVar;
        if (dVar == null || sDMWinInfo == null || (gVar = dVar.j) == null || (cVar = gVar.a) == null || cVar.a(true, null)) {
            return;
        }
        if (gVar.C == 1) {
            com.smartdigimkt.q3.f.a().b(new y(dVar, sDMWinInfo));
            return;
        }
        com.smartdigimkt.u4.a aVar = new com.smartdigimkt.u4.a(dVar, true);
        aVar.e = sDMWinInfo;
        if (!a(dVar)) {
            aVar.m = 4;
        }
        d(aVar);
    }

    public static void a(com.smartdigimkt.e1.d dVar, SDMWinInfo sDMWinInfo, boolean z) {
        String str;
        try {
            com.smartdigimkt.u4.a aVarA = a(true, dVar, sDMWinInfo, null);
            if (z) {
                if (!a(dVar)) {
                    aVarA.m = 1;
                }
            } else if (!a(dVar)) {
                aVarA.m = 4;
            }
            if (TextUtils.isEmpty(aVarA.g)) {
                d(aVarA);
                return;
            }
            if (aVarA.b) {
                str = aVarA.g;
            } else {
                str = aVarA.h;
            }
            new com.smartdigimkt.f4.h(str).a(0, (com.smartdigimkt.a4.b) new c0(aVarA));
        } catch (Throwable unused) {
        }
    }

    public static String a(com.smartdigimkt.d3.c cVar, double d) {
        if (cVar.p == 66) {
            double d2 = cVar.G;
            if (d2 > 0.0d) {
                return String.valueOf(d / d2);
            }
        }
        return String.valueOf(d);
    }

    public static String a(String str, Map map) {
        if (!TextUtils.isEmpty(str) && map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                try {
                    Object value = entry.getValue();
                    str = str.replace(str2, value != null ? value.toString() : "");
                } catch (Throwable unused) {
                }
            }
        }
        return str;
    }

    public final void a(boolean z, SDMWinInfo sDMWinInfo, SDMLossInfo sDMLossInfo) {
        if (a()) {
            com.smartdigimkt.e1.d dVar = this.a;
            com.smartdigimkt.u4.a aVar = new com.smartdigimkt.u4.a(dVar, z);
            aVar.e = sDMWinInfo;
            aVar.f = sDMLossInfo;
            if (z) {
                if (!a(dVar)) {
                    aVar.m = 4;
                }
            } else {
                a(dVar, sDMLossInfo, aVar);
            }
            b(aVar);
            c(aVar);
        }
    }

    public static void a(com.smartdigimkt.e1.d dVar, SDMLossInfo sDMLossInfo, com.smartdigimkt.u4.a aVar) {
        if (sDMLossInfo == null) {
            return;
        }
        if (sDMLossInfo.getLossReasonCode() == 4) {
            aVar.m = 25;
        } else {
            if (a(dVar)) {
                return;
            }
            aVar.m = 28;
        }
    }
}
