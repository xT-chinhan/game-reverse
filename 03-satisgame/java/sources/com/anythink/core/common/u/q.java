package com.anythink.core.common.u;

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
public class q {
    private static final String a = "q";

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
        int i;
        com.anythink.core.common.h.c cVarB;
        com.anythink.core.common.h.c cVar;
        int i2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (list == null || list.size() == 0) {
            Log.e(a, "List<ATCustomContentInfo> can not be empty");
            return null;
        }
        ArrayList<ATCustomContentInfo> arrayList = new ArrayList(list);
        if (!com.anythink.core.common.d.s.b().V()) {
            return d(arrayList);
        }
        LinkedList linkedList = new LinkedList();
        for (ATCustomContentInfo aTCustomContentInfo : arrayList) {
            if (aTCustomContentInfo != null) {
                try {
                    String customContentString = aTCustomContentInfo.getCustomContentString();
                    double customContentDouble = aTCustomContentInfo.getCustomContentDouble();
                    double dK = 0.0d;
                    if (customContentDouble > 0.0d) {
                        dK = customContentDouble;
                        i2 = 2;
                        cVar = null;
                    } else if (TextUtils.isEmpty(customContentString)) {
                        cVarB = null;
                        cVar = cVarB;
                        i2 = 0;
                    } else {
                        try {
                            com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(customContentString);
                            if (lVarA == null) {
                                throw new RuntimeException("placementId: " + customContentString + ", place strategy is null");
                            }
                            com.anythink.core.common.f fVarA = com.anythink.core.common.t.a().a(customContentString, String.valueOf(lVarA.ap()));
                            if (fVarA == null) {
                                throw new RuntimeException("The \" + placementId + \" object has not been created yet!");
                            }
                            cVarB = fVarA.b(com.anythink.core.common.d.s.b().g(), false, false, new com.anythink.core.common.h.ae());
                            if (cVarB == null) {
                                throw new RuntimeException("no cache, placementId: ".concat(String.valueOf(customContentString)));
                            }
                            try {
                                cVar = cVarB;
                                dK = cVarB.e().getUnitGroupInfo().K();
                                i2 = 1;
                            } catch (Throwable unused) {
                                cVar = cVarB;
                                i2 = 0;
                            }
                            cVar = cVarB;
                            i2 = 0;
                        } catch (Throwable unused2) {
                            cVarB = null;
                        }
                    }
                    linkedList.add(new a(i2, aTCustomContentInfo, dK, cVar));
                } catch (Throwable th) {
                    th.printStackTrace();
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
        int i3 = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                ATCustomContentInfo aTCustomContentInfo3 = aVar.b;
                Iterator it2 = it;
                double d2 = aVar.c;
                com.anythink.core.common.h.c cVar2 = aVar.d;
                if (aTCustomContentInfo2 == null) {
                    i3 = aVar.a;
                    aTCustomContentInfo2 = aTCustomContentInfo3;
                    customContentString2 = aTCustomContentInfo3.getCustomContentString();
                    d = d2;
                }
                if (cVar2 != null) {
                    aTCustomContentInfo3.setATAdInfo(cVar2.p());
                }
                arrayList2.add(aTCustomContentInfo3);
                JSONObject jSONObject = new JSONObject();
                String str2 = str;
                try {
                    if (aTCustomContentInfo3.getCustomContentObject() instanceof String) {
                        i = i3;
                        try {
                            jSONObject.put("custom_string", aTCustomContentInfo3.getCustomContentObject());
                        } catch (Throwable unused3) {
                        }
                    } else {
                        i = i3;
                    }
                    jSONObject.put(com.anythink.core.d.b.e.a.h, String.valueOf(d2));
                    if (aVar.a != 2) {
                        jSONObject.put(com.anythink.core.common.l.f.bn, aTCustomContentInfo3.getCustomContentString());
                        com.anythink.core.common.h.n nVarI = cVar2 != null ? cVar2.i() : null;
                        jSONObject.put("req_id", nVarI != null ? nVarI.aR() : str2);
                        jSONObject.put("network_firm_id", nVarI != null ? nVarI.Z() : 0);
                        jSONObject.put(com.anythink.core.common.f.i.a.d, nVarI != null ? nVarI.N() : str2);
                        jSONObject.put("adsource_isheaderbidding", (nVarI == null || !nVarI.L()) ? 0 : 1);
                        jSONObject.put("network_placement_id", nVarI != null ? nVarI.z() : str2);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused4) {
                    i = i3;
                }
                it = it2;
                str = str2;
                i3 = i;
            }
        }
        if (i3 == 2) {
            strValueOf = String.valueOf(d);
        } else {
            strValueOf = i3 == 1 ? customContentString2 : null;
        }
        com.anythink.core.common.h.e eVar = new com.anythink.core.common.h.e(jSONArray, i3, strValueOf, SystemClock.elapsedRealtime() - jElapsedRealtime);
        com.anythink.core.common.h.n nVar = new com.anythink.core.common.h.n();
        nVar.a(eVar);
        com.anythink.core.common.t.e.a(com.anythink.core.common.d.s.b().g());
        com.anythink.core.common.t.e.a(26, nVar);
        return new ATCustomContentResult(arrayList2);
    }

    private static ATCustomContentResult d(List<ATCustomContentInfo> list) {
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
            Collections.sort(arrayList, new Comparator<ATCustomContentInfo>() { // from class: com.anythink.core.common.u.q.1
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
        String strAR = nVar.aR();
        String strN = nVar.N();
        for (ATCustomContentInfo aTCustomContentInfo : customContentInfoList) {
            if (aTCustomContentInfo != null && (adInfo = aTCustomContentInfo.getAdInfo()) != null) {
                String requestId = adInfo.getRequestId();
                String adsourceId = adInfo.getAdsourceId();
                if (TextUtils.equals(strAR, requestId) && TextUtils.equals(strN, adsourceId)) {
                    double dQ = nVar.q();
                    double dR = nVar.r();
                    if (adInfo instanceof com.anythink.core.common.d.k) {
                        com.anythink.core.common.d.k kVar = (com.anythink.core.common.d.k) adInfo;
                        kVar.a(dQ);
                        kVar.b(dR);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
