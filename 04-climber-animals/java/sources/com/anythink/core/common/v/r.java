package com.anythink.core.common.v;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATCustomContentInfo;
import com.anythink.core.api.ATCustomContentResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r {
    private static final String a = "r";

    public static ATCustomContentInfo a(List<ATCustomContentInfo> list) {
        try {
            ATCustomContentResult aTCustomContentResultC = c(list);
            if (aTCustomContentResultC != null) {
                return aTCustomContentResultC.getCustomContentInfoList().get(0);
            }
        } catch (Throwable unused) {
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public static ATCustomContentResult b(List<ATCustomContentInfo> list) {
        try {
            return c(list);
        } catch (Throwable unused) {
            return new ATCustomContentResult(list);
        }
    }

    private static ATCustomContentResult c(List<ATCustomContentInfo> list) {
        String strValueOf;
        com.anythink.core.common.h.c cVarB;
        com.anythink.core.common.h.c cVar;
        int i;
        new StringBuilder("comparePriceWithOuter, ").append(list);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (list == null || list.size() == 0) {
            Log.e(a, "List<ATCustomContentInfo> can not be empty");
            return null;
        }
        ArrayList<ATCustomContentInfo> arrayList = new ArrayList(list);
        if (!com.anythink.core.common.d.t.b().V()) {
            return d(arrayList);
        }
        LinkedList linkedList = new LinkedList();
        for (ATCustomContentInfo aTCustomContentInfo : arrayList) {
            if (aTCustomContentInfo != null) {
                try {
                    String customContentString = aTCustomContentInfo.getCustomContentString();
                    double customContentDouble = aTCustomContentInfo.getCustomContentDouble();
                    double D = 0.0d;
                    if (customContentDouble > 0.0d) {
                        D = customContentDouble;
                        i = 2;
                        cVar = null;
                    } else {
                        if (TextUtils.isEmpty(customContentString)) {
                            cVarB = null;
                        } else {
                            try {
                                com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(customContentString);
                                if (lVarA == null) {
                                    throw new RuntimeException("placementId: " + customContentString + ", place strategy is null");
                                }
                                com.anythink.core.common.f fVarA = com.anythink.core.common.u.a().a(customContentString, String.valueOf(lVarA.aq()));
                                if (fVarA == null) {
                                    throw new RuntimeException("The \" + placementId + \" object has not been created yet!");
                                }
                                cVarB = fVarA.b(com.anythink.core.common.d.t.b().g(), false, false, new com.anythink.core.common.h.ae());
                                if (cVarB == null) {
                                    throw new RuntimeException("no cache, placementId: ".concat(String.valueOf(customContentString)));
                                }
                                try {
                                    new StringBuilder("placementId: ").append(customContentString).append(", ").append(cVarB);
                                    cVar = cVarB;
                                    D = cVarB.e().getUnitGroupInfo().D();
                                    i = 1;
                                } catch (Throwable th) {
                                    th = th;
                                    th.getMessage();
                                    cVar = cVarB;
                                    i = 0;
                                }
                                th = th;
                                th.getMessage();
                            } catch (Throwable th2) {
                                th = th2;
                                cVarB = null;
                            }
                        }
                        cVar = cVarB;
                        i = 0;
                    }
                    linkedList.add(new a(i, aTCustomContentInfo, D, cVar));
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
        if (linkedList.size() == 0) {
            return new ATCustomContentResult(arrayList);
        }
        Collections.sort(linkedList);
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedList.iterator();
        String str = "";
        String customContentString2 = "";
        double d = -1.0d;
        ATCustomContentInfo aTCustomContentInfo2 = null;
        int i2 = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                ATCustomContentInfo aTCustomContentInfo3 = aVar.b;
                Iterator it2 = it;
                double d2 = aVar.c;
                com.anythink.core.common.h.c cVar2 = aVar.d;
                if (aTCustomContentInfo2 == null) {
                    i2 = aVar.a;
                    aTCustomContentInfo2 = aTCustomContentInfo3;
                    customContentString2 = aTCustomContentInfo3.getCustomContentString();
                    d = d2;
                }
                String str2 = str;
                int i3 = i2;
                double d3 = d;
                new StringBuilder("adComparePriceItem, type: ").append(i2).append(", price: ").append(aVar.c).append(", placementId: ").append(aTCustomContentInfo3.getCustomContentString()).append(", custom obj: ").append(aTCustomContentInfo3.getCustomContentObject());
                if (cVar2 != null) {
                    aTCustomContentInfo3.setATAdInfo(cVar2.p());
                }
                arrayList2.add(aTCustomContentInfo3);
                JSONObject jSONObject = new JSONObject();
                try {
                    if (aTCustomContentInfo3.getCustomContentObject() instanceof String) {
                        jSONObject.put("custom_string", aTCustomContentInfo3.getCustomContentObject());
                    }
                    jSONObject.put("price", String.valueOf(d2));
                    if (aVar.a != 2) {
                        jSONObject.put(com.anythink.core.common.m.e.bk, aTCustomContentInfo3.getCustomContentString());
                        com.anythink.core.common.h.n nVarI = cVar2 != null ? cVar2.i() : null;
                        jSONObject.put("req_id", nVarI != null ? nVarI.aJ() : str2);
                        jSONObject.put("network_firm_id", nVarI != null ? nVarI.Y() : 0);
                        jSONObject.put("adsource_id", nVarI != null ? nVarI.M() : str2);
                        jSONObject.put("adsource_isheaderbidding", (nVarI == null || !nVarI.K()) ? 0 : 1);
                        jSONObject.put("network_placement_id", nVarI != null ? nVarI.y() : str2);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
                i2 = i3;
                it = it2;
                str = str2;
                d = d3;
            }
        }
        if (i2 == 2) {
            strValueOf = String.valueOf(d);
        } else {
            strValueOf = i2 == 1 ? customContentString2 : null;
        }
        com.anythink.core.common.h.e eVar = new com.anythink.core.common.h.e(jSONArray, i2, strValueOf, SystemClock.elapsedRealtime() - jElapsedRealtime);
        com.anythink.core.common.h.n nVar = new com.anythink.core.common.h.n();
        nVar.a(eVar);
        com.anythink.core.common.u.c.a(com.anythink.core.common.d.t.b().g()).a(26, nVar);
        return new ATCustomContentResult(arrayList2);
    }

    private static ATCustomContentResult d(List<ATCustomContentInfo> list) {
        new StringBuilder("onlyCompareOuter, ").append(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ATCustomContentInfo aTCustomContentInfo : list) {
            if (aTCustomContentInfo != null) {
                if (TextUtils.isEmpty(aTCustomContentInfo.getCustomContentString())) {
                    arrayList.add(aTCustomContentInfo);
                } else {
                    arrayList2.add(aTCustomContentInfo);
                }
            }
        }
        if (arrayList.size() != 0) {
            Collections.sort(arrayList, new Comparator<ATCustomContentInfo>() { // from class: com.anythink.core.common.v.r.1
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ATCustomContentInfo aTCustomContentInfo2, ATCustomContentInfo aTCustomContentInfo3) {
                    ATCustomContentInfo aTCustomContentInfo4 = aTCustomContentInfo2;
                    ATCustomContentInfo aTCustomContentInfo5 = aTCustomContentInfo3;
                    if (aTCustomContentInfo4.getCustomContentDouble() > aTCustomContentInfo5.getCustomContentDouble()) {
                        return -1;
                    }
                    return aTCustomContentInfo4.getCustomContentDouble() < aTCustomContentInfo5.getCustomContentDouble() ? 1 : 0;
                }

                private static int a(ATCustomContentInfo aTCustomContentInfo2, ATCustomContentInfo aTCustomContentInfo3) {
                    if (aTCustomContentInfo2.getCustomContentDouble() > aTCustomContentInfo3.getCustomContentDouble()) {
                        return -1;
                    }
                    return aTCustomContentInfo2.getCustomContentDouble() < aTCustomContentInfo3.getCustomContentDouble() ? 1 : 0;
                }
            });
        }
        arrayList.addAll(arrayList2);
        return new ATCustomContentResult(arrayList);
    }

    public static class a implements Comparable<a> {
        int a;
        ATCustomContentInfo b;
        double c;
        com.anythink.core.common.h.c d;

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
            double d = this.c;
            double d2 = aVar.c;
            if (d > d2) {
                return -1;
            }
            return d < d2 ? 1 : 0;
        }

        public a(int i, ATCustomContentInfo aTCustomContentInfo, double d, com.anythink.core.common.h.c cVar) {
            this.a = i;
            this.b = aTCustomContentInfo;
            this.c = d;
            this.d = cVar;
        }

        private int a(a aVar) {
            double d = this.c;
            double d2 = aVar.c;
            if (d > d2) {
                return -1;
            }
            return d < d2 ? 1 : 0;
        }
    }

    public static void a(ATCustomContentResult aTCustomContentResult, com.anythink.core.common.h.n nVar) {
        List<ATCustomContentInfo> customContentInfoList;
        ATAdInfo adInfo;
        if (aTCustomContentResult == null || nVar == null || (customContentInfoList = aTCustomContentResult.getCustomContentInfoList()) == null || customContentInfoList.size() == 0) {
            return;
        }
        nVar.a(aTCustomContentResult);
        String strAJ = nVar.aJ();
        String strM = nVar.M();
        new StringBuilder("checkToReplacePrice, ").append(customContentInfoList);
        for (ATCustomContentInfo aTCustomContentInfo : customContentInfoList) {
            if (aTCustomContentInfo != null && (adInfo = aTCustomContentInfo.getAdInfo()) != null) {
                String requestId = adInfo.getRequestId();
                String adsourceId = adInfo.getAdsourceId();
                if (TextUtils.equals(strAJ, requestId) && TextUtils.equals(strM, adsourceId)) {
                    double dP = nVar.p();
                    double dQ = nVar.q();
                    new StringBuilder("checkToReplacePrice: find target atCustomContentInfo: ").append(aTCustomContentInfo);
                    if (adInfo instanceof com.anythink.core.common.d.l) {
                        com.anythink.core.common.d.l lVar = (com.anythink.core.common.d.l) adInfo;
                        lVar.a(dP);
                        lVar.b(dQ);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
