package com.anythink.core.common.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdFilter;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bq;
import com.anythink.core.common.h.br;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.h.cd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class ac {
    static Random a = new Random();
    private static final String b = "PlacementPrepareUtils";

    public static final br a(com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar) {
        List<by> listA;
        List<by> listA2;
        List<by> listC;
        List<by> listD;
        List<by> listE;
        if (lVar == null) {
            return null;
        }
        ATAdRequest aTAdRequestB = nVar.b();
        if (aTAdRequestB != null) {
            lVar.a(aTAdRequestB);
        }
        if (nVar.al()) {
            listA = new ArrayList<>();
            listA2 = com.anythink.core.e.u.a(lVar, lVar.Z());
            listC = new ArrayList<>();
            listD = new ArrayList<>();
            listE = new ArrayList<>();
        } else {
            listA = a(nVar, lVar, com.anythink.core.e.u.b(lVar));
            listA2 = com.anythink.core.e.u.a(lVar);
            listC = com.anythink.core.e.u.c(lVar);
            com.anythink.core.d.a.a().a(nVar, listA, lVar);
            com.anythink.core.d.a.a().a(nVar, listC, lVar);
            listD = com.anythink.core.e.u.d(lVar);
            listE = com.anythink.core.e.u.e(lVar);
        }
        br brVar = new br(lVar, nVar, listA.size() + listA2.size() + listC.size() + listD.size() + listE.size());
        brVar.a(listA);
        brVar.b(listA2);
        brVar.e(listC);
        brVar.c(listD);
        brVar.d(listE);
        a(lVar, (List<by>[]) new List[]{listA, listA2, listC, listD, listE});
        b(lVar, brVar.c(), listA);
        b(lVar, brVar.c(), listA2);
        b(lVar, brVar.c(), listC);
        b(lVar, brVar.c(), listD);
        b(lVar, brVar.c(), listE);
        return brVar;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    private static List<by> a(com.anythink.core.common.h.n nVar, com.anythink.core.e.l lVar, List<by> list) {
        com.anythink.core.e.g gVarJ;
        com.anythink.core.d.a.d dVarA;
        if (com.anythink.core.common.d.s.b().A()) {
            return list;
        }
        if ((nVar.V() != 9 || !lVar.bb() || !lVar.bc()) && (gVarJ = lVar.j()) != null && list.size() > gVarJ.f() && (dVarA = com.anythink.core.d.b.a().a(nVar.aQ(), lVar, gVarJ)) != null) {
            double d = dVarA.a;
            if (d > 0.0d) {
                double dE = gVarJ.e() * d;
                if (o.a(list.get(0)) <= dE) {
                    return list;
                }
                int size = list.size() - 1;
                int size2 = list.size() - 1;
                HashMap map = new HashMap();
                for (int i = 0; i < list.size(); i++) {
                    double dA = o.a(list.get(i));
                    if (!map.containsKey(String.valueOf(dA))) {
                        map.put(String.valueOf(dA), Integer.valueOf(i));
                    }
                    if (size2 == list.size() - 1) {
                        if (dA == d) {
                            size2 = i - gVarJ.f();
                        } else if (dA < d) {
                            if (i > 0) {
                                size2 = ((Integer) map.get(String.valueOf(o.a(list.get(i - 1))))).intValue() - gVarJ.f();
                            } else {
                                size2 = i - gVarJ.f();
                            }
                        }
                    }
                    if (size == list.size() - 1) {
                        if (dA == dE) {
                            size = i;
                        } else if (dA < dE) {
                            size = i - 1;
                        }
                    }
                    if (size <= 0 || size2 <= 0 || (size < list.size() - 1 && size2 < list.size() - 1)) {
                        break;
                    }
                }
                int iMin = Math.min(size, size2);
                if (iMin <= 0) {
                    return list;
                }
                by byVar = list.get(iMin);
                double dA2 = o.a(byVar);
                String strG = byVar.G();
                Integer num = (Integer) map.get(String.valueOf(dA2));
                if (num != null) {
                    iMin = num.intValue();
                    strG = list.get(iMin).G();
                }
                List<by> listSubList = list.subList(iMin, list.size());
                int[] iArrG = gVarJ.g();
                if (iArrG != null && iArrG.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    List<by> listSubList2 = list.subList(0, iMin);
                    for (int i2 = 0; i2 < listSubList2.size(); i2++) {
                        by byVar2 = listSubList2.get(i2);
                        if (a(iArrG, byVar2.n())) {
                            arrayList.add(byVar2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        listSubList.addAll(0, arrayList);
                    }
                }
                com.anythink.core.common.t.f.a(nVar, gVarJ, dVarA.b, d, strG, dA2, gVarJ.h());
                return listSubList;
            }
        }
        return list;
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static List<by> a(final br brVar, List<by> list) {
        return o.a(list, new com.anythink.core.common.j.f() { // from class: com.anythink.core.common.u.ac.1
            @Override // com.anythink.core.common.j.f
            public final void a(by byVar, int i, int i2) {
                com.anythink.core.common.f fVarA;
                bz bzVarA;
                byVar.L(i);
                if (i2 >= 0) {
                    byVar.K(i2);
                    br brVar2 = brVar;
                    if (brVar2 == null || (fVarA = brVar2.c().a()) == null || fVarA.e() == null || (bzVarA = fVarA.e().a(brVar.c().aQ(), byVar)) == null) {
                        return;
                    }
                    bzVarA.b(byVar.aE());
                }
            }
        });
    }

    public static void b(br brVar, List<by> list) {
        List<by> listD = brVar.d();
        List<by> listE = brVar.e();
        List<by> listF = brVar.f();
        List<by> listG = brVar.g();
        a(listD, listE, brVar.c(), list);
        a(listD, listF, brVar.c(), list);
        a(listD, listG, brVar.c(), list);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0080 A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #1 {all -> 0x008a, blocks: (B:28:0x0062, B:30:0x0068, B:32:0x0072, B:34:0x0078, B:36:0x0080), top: B:59:0x0062 }] */
    private static void a(List<by> list, List<by> list2, com.anythink.core.common.h.n nVar, List<by> list3) {
        by byVar;
        String strAQ = nVar.aQ();
        if (list == null || list2 == null) {
            return;
        }
        boolean z = false;
        for (int size = list2.size() - 1; size >= 0; size--) {
            by byVar2 = list2.get(size);
            if (byVar2.av()) {
                list3.add(byVar2);
            }
            if (!a(strAQ, byVar2, nVar)) {
                com.anythink.core.common.f fVarA = nVar.a();
                com.anythink.core.common.h.ad adVarA = null;
                bz bzVarA = (fVarA == null || fVarA.e() == null) ? null : fVarA.e().a(strAQ, byVar2);
                com.anythink.core.common.h.c cVarA = bzVarA != null ? bzVarA.a((com.anythink.core.common.h.ad) null).a() : null;
                if (cVarA != null) {
                    byVar2.a(cVarA.e().getUnitGroupInfo(), 0, 3, 1);
                    byVar = byVar2;
                } else {
                    byVar = null;
                }
                if (byVar == null) {
                    if (fVarA != null) {
                        try {
                            if (fVarA.f() != null) {
                                adVarA = fVarA.f().a(strAQ, byVar2);
                            }
                            if (adVarA == null && !adVarA.a()) {
                                byVar2.a(adVarA, 0, 2, 1);
                                byVar = byVar2;
                            } else if (adVarA != null) {
                                com.anythink.core.c.d.c.a(adVarA, new ay(1, byVar2, nVar), true, 25);
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (adVarA == null) {
                        if (adVarA != null) {
                            com.anythink.core.c.d.c.a(adVarA, new ay(1, byVar2, nVar), true, 25);
                        }
                    } else if (adVarA != null) {
                        com.anythink.core.c.d.c.a(adVarA, new ay(1, byVar2, nVar), true, 25);
                    }
                }
                if (byVar != null) {
                    try {
                        if (byVar2.y() == 7) {
                            z = true;
                        }
                        list2.remove(size);
                        o.a(list, byVar2);
                        if (byVar2.av() && byVar2.at()) {
                            list3.remove(byVar2);
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        if (z) {
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                if (list2.get(size2).y() == 7) {
                    list2.remove(size2);
                }
            }
        }
    }

    @SafeVarargs
    private static void a(com.anythink.core.e.l lVar, List<by>... listArr) {
        if (lVar == null) {
            return;
        }
        com.anythink.core.a.b bVarA = com.anythink.core.a.b.a(com.anythink.core.common.d.s.b().g());
        String strValueOf = String.valueOf(lVar.ap());
        for (int i = 0; i < 5; i++) {
            List<by> list = listArr[i];
            if (list != null && !list.isEmpty()) {
                Iterator<by> it = list.iterator();
                while (it.hasNext()) {
                    bVarA.a(it.next(), strValueOf);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:110:0x0328  */
    /* JADX WARN: Code duplicated, block: B:112:0x0336  */
    /* JADX WARN: Code duplicated, block: B:113:0x0354 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0356  */
    /* JADX WARN: Code duplicated, block: B:116:0x035d  */
    /* JADX WARN: Code duplicated, block: B:117:0x037c  */
    /* JADX WARN: Code duplicated, block: B:120:0x038b  */
    /* JADX WARN: Code duplicated, block: B:121:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:123:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:125:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:126:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:128:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:130:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:146:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:19:0x00af  */
    /* JADX WARN: Code duplicated, block: B:21:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:22:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:25:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:39:0x010e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0127  */
    /* JADX WARN: Code duplicated, block: B:44:0x0148  */
    /* JADX WARN: Code duplicated, block: B:49:0x0176  */
    /* JADX WARN: Code duplicated, block: B:51:0x0183  */
    /* JADX WARN: Code duplicated, block: B:53:0x0198  */
    /* JADX WARN: Code duplicated, block: B:54:0x019a  */
    /* JADX WARN: Code duplicated, block: B:55:0x019d  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:57:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x01af  */
    /* JADX WARN: Code duplicated, block: B:61:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:65:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:66:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x020b  */
    /* JADX WARN: Code duplicated, block: B:73:0x0216  */
    /* JADX WARN: Code duplicated, block: B:78:0x0243  */
    /* JADX WARN: Code duplicated, block: B:80:0x024d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0277  */
    /* JADX WARN: Code duplicated, block: B:85:0x027d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0283  */
    /* JADX WARN: Code duplicated, block: B:93:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:95:0x02b6  */
    private static void b(com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar, List<by> list) {
        AdError adErrorA;
        int i;
        List<String> listJ;
        int iA;
        int iA2;
        List<String> listM;
        List<String> listN;
        int iA3;
        com.anythink.core.common.h.k kVarA;
        com.anythink.core.common.v.a.b.c cVar;
        boolean z;
        com.anythink.core.common.h.ak akVarA;
        int i2;
        String str;
        String str2;
        AdError adErrorB;
        String desc;
        boolean z2;
        Boolean boolB;
        int i3;
        int i4;
        String code;
        Iterator<by> it = list.iterator();
        while (it.hasNext()) {
            by next = it.next();
            int iV = nVar.V();
            com.anythink.core.common.h.n nVarAh = nVar.ah();
            String strAQ = nVar.aQ();
            byte b2 = 0;
            ai.a(nVarAh, next, 0, false);
            com.anythink.core.a.a.a(com.anythink.core.common.d.s.b().g());
            String strG = next.G();
            lVar.ap();
            bq.a aVarA = com.anythink.core.a.a.a(strG);
            int i5 = aVarA.e;
            int i6 = aVarA.d;
            Context contextG = com.anythink.core.common.d.s.b().g();
            Pair<Integer, List<String>> pairI = com.anythink.core.common.d.s.b().I();
            boolean z3 = true;
            if (pairI != null && ((Integer) pairI.first).intValue() == 1) {
                List list2 = (List) pairI.second;
                if (list2 != null && !list2.isEmpty()) {
                    if (list2.contains(String.valueOf(next.n()))) {
                        next.i("Filter ad source loading for specified channel id on risky devices.");
                        aa.a(strAQ, nVar, "Filter ad source loading for specified channel id on risky devices.", next, i5, i6, list2);
                        com.anythink.core.common.t.f.a(nVarAh, 28, ErrorCode.getErrorCode(ErrorCode.adSourceLoadRiskError, "", "Filter ad source loading for specified channel id on risky devices."));
                    } else {
                        adErrorA = a(1, nVarAh, next, (com.anythink.core.common.h.z) null);
                        i = 9;
                        if (adErrorA != null) {
                            code = adErrorA.getCode();
                            code.hashCode();
                            switch (code.hashCode()) {
                                case 1537309:
                                    if (!code.equals(ErrorCode.adSourceLoadBidTypeFilterError)) {
                                        b2 = -1;
                                    }
                                    break;
                                case 1537310:
                                    if (code.equals(ErrorCode.adSourceLoadPriceFilterError)) {
                                        b2 = -1;
                                    } else {
                                        b2 = 1;
                                    }
                                    break;
                                case 1537311:
                                    if (code.equals(ErrorCode.adSourceLoadUnitFilterError)) {
                                        b2 = -1;
                                    } else {
                                        b2 = 2;
                                    }
                                    break;
                                default:
                                    b2 = -1;
                                    break;
                            }
                            switch (b2) {
                                case 0:
                                    i = 29;
                                    break;
                                case 1:
                                    i = 30;
                                    break;
                                case 2:
                                    i = 31;
                                    break;
                            }
                            next.i(adErrorA.getPlatformMSG());
                            nVarAh.o(next.bF());
                            nVarAh.C(next.bG());
                            aa.a(strAQ, nVar, adErrorA.getPlatformMSG(), next, i5, i6);
                            com.anythink.core.common.t.f.a(nVarAh, i, adErrorA);
                        } else {
                            listJ = com.anythink.core.common.d.s.b().J();
                            com.anythink.core.common.d.s.b();
                            if (com.anythink.core.common.d.s.a(listJ, String.valueOf(next.n()))) {
                                next.i("Forbid network by developer");
                                aa.a(strAQ, nVar, "Forbid network by developer", next, i5, i6, listJ);
                                com.anythink.core.common.t.f.a(nVarAh, 14, ErrorCode.getErrorCode(ErrorCode.forbidNetworkByDeveloper, "", "Forbid network by developer"));
                            } else if (!aj.b(next)) {
                                com.anythink.core.a.a.a(contextG);
                                iA = com.anythink.core.a.a.a(next, lVar.ap());
                                if (iA != -1) {
                                    next.k(-5);
                                    next.i("Out of Cap");
                                    aa.a(strAQ, nVar, "Out of Cap", next, i5, i6);
                                    switch (iA) {
                                        case 8:
                                            i4 = 19;
                                            break;
                                        case 9:
                                            i4 = 20;
                                            break;
                                        case 10:
                                            i4 = 21;
                                            break;
                                        case 11:
                                            i4 = 22;
                                            break;
                                        default:
                                            i4 = 2;
                                            break;
                                    }
                                    com.anythink.core.common.t.f.a(nVarAh, i4, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
                                } else {
                                    com.anythink.core.a.d.a();
                                    iA2 = com.anythink.core.a.d.a(next);
                                    if (iA2 != -1) {
                                        next.k(-6);
                                        next.i("Out of Pacing");
                                        aa.a(strAQ, nVar, "Out of Pacing", next, i5, i6);
                                        if (iA2 == 12) {
                                            i3 = 23;
                                        } else if (iA2 != 13) {
                                            i3 = 3;
                                        } else {
                                            i3 = 24;
                                        }
                                        com.anythink.core.common.t.f.a(nVarAh, i3, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
                                    } else if (com.anythink.core.common.c.a().a(next)) {
                                        next.k(-6);
                                        next.i("Request fail in pacing");
                                        aa.a(strAQ, nVar, "Request fail in pacing", next, i5, i6);
                                        com.anythink.core.common.t.f.a(nVarAh, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
                                    } else {
                                        listM = com.anythink.core.common.d.s.b().m(strAQ);
                                        if (listM == null) {
                                            listN = com.anythink.core.common.d.s.b().n(strAQ);
                                            if (listN == null) {
                                                if (next.w()) {
                                                    if (aj.b(next)) {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.aj() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                                next.k(-8);
                                                                next.i("Error Code Request fail in pacing");
                                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                                z = true;
                                                            } else {
                                                                if (iV != 0) {
                                                                    z3 = true;
                                                                    if (next.aR() == 1) {
                                                                        next.i("System splash not allow preload");
                                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                    }
                                                                    z = z3;
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                                com.anythink.core.a.c.a();
                                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                                if (iA3 != -1) {
                                                                    next.i("The adSource load too many times within the specified time period.");
                                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                                } else {
                                                                    com.anythink.core.a.c.a();
                                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                    if (kVarA != null) {
                                                                        adErrorB = kVarA.b();
                                                                        if (adErrorB != null) {
                                                                            desc = adErrorB.getDesc();
                                                                        } else {
                                                                            desc = "";
                                                                        }
                                                                        next.i(desc);
                                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                        if (cVar != null) {
                                                                        }
                                                                        z = false;
                                                                    }
                                                                }
                                                                z = z3;
                                                            }
                                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.aj() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                                next.k(-8);
                                                                next.i("Error Code Request fail in pacing");
                                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                                z = true;
                                                            } else {
                                                                if (iV != 0) {
                                                                    z3 = true;
                                                                    if (next.aR() == 1) {
                                                                        next.i("System splash not allow preload");
                                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                    }
                                                                    z = z3;
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                                com.anythink.core.a.c.a();
                                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                                if (iA3 != -1) {
                                                                    next.i("The adSource load too many times within the specified time period.");
                                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                                } else {
                                                                    com.anythink.core.a.c.a();
                                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                    if (kVarA != null) {
                                                                        adErrorB = kVarA.b();
                                                                        if (adErrorB != null) {
                                                                            desc = adErrorB.getDesc();
                                                                        } else {
                                                                            desc = "";
                                                                        }
                                                                        next.i(desc);
                                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                        if (cVar != null) {
                                                                        }
                                                                        z = false;
                                                                    }
                                                                }
                                                                z = z3;
                                                            }
                                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    }
                                                    z = true;
                                                } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                    next.k(-8);
                                                    next.i("Error Code Request fail in pacing");
                                                    aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                    z = true;
                                                } else {
                                                    if (iV != 0) {
                                                        z3 = true;
                                                        if (next.aR() == 1) {
                                                            next.i("System splash not allow preload");
                                                            aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                        }
                                                        z = z3;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    com.anythink.core.a.c.a();
                                                    iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                    if (iA3 != -1) {
                                                        next.i("The adSource load too many times within the specified time period.");
                                                        aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                    } else {
                                                        com.anythink.core.a.c.a();
                                                        kVarA = com.anythink.core.a.c.a(contextG, next);
                                                        if (kVarA != null) {
                                                            adErrorB = kVarA.b();
                                                            if (adErrorB != null) {
                                                                desc = adErrorB.getDesc();
                                                            } else {
                                                                desc = "";
                                                            }
                                                            next.i(desc);
                                                            aa.a(strAQ, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                            if (cVar != null) {
                                                            }
                                                            z = false;
                                                        }
                                                    }
                                                    z = z3;
                                                }
                                            } else if (next.w()) {
                                                if (aj.b(next)) {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.aj() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                        next.k(-8);
                                                        next.i("Error Code Request fail in pacing");
                                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        z = true;
                                                    } else {
                                                        if (iV != 0) {
                                                            z3 = true;
                                                            if (next.aR() == 1) {
                                                                next.i("System splash not allow preload");
                                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                            }
                                                            z = z3;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        com.anythink.core.a.c.a();
                                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                        if (iA3 != -1) {
                                                            next.i("The adSource load too many times within the specified time period.");
                                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                        } else {
                                                            com.anythink.core.a.c.a();
                                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                                            if (kVarA != null) {
                                                                adErrorB = kVarA.b();
                                                                if (adErrorB != null) {
                                                                    desc = adErrorB.getDesc();
                                                                } else {
                                                                    desc = "";
                                                                }
                                                                next.i(desc);
                                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                if (cVar != null) {
                                                                }
                                                                z = false;
                                                            }
                                                        }
                                                        z = z3;
                                                    }
                                                } else {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.aj() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                        next.k(-8);
                                                        next.i("Error Code Request fail in pacing");
                                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        z = true;
                                                    } else {
                                                        if (iV != 0) {
                                                            z3 = true;
                                                            if (next.aR() == 1) {
                                                                next.i("System splash not allow preload");
                                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                            }
                                                            z = z3;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        com.anythink.core.a.c.a();
                                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                        if (iA3 != -1) {
                                                            next.i("The adSource load too many times within the specified time period.");
                                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                        } else {
                                                            com.anythink.core.a.c.a();
                                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                                            if (kVarA != null) {
                                                                adErrorB = kVarA.b();
                                                                if (adErrorB != null) {
                                                                    desc = adErrorB.getDesc();
                                                                } else {
                                                                    desc = "";
                                                                }
                                                                next.i(desc);
                                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                if (cVar != null) {
                                                                }
                                                                z = false;
                                                            }
                                                        }
                                                        z = z3;
                                                    }
                                                }
                                                z = true;
                                            } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                next.k(-8);
                                                next.i("Error Code Request fail in pacing");
                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                z = true;
                                            } else {
                                                if (iV != 0) {
                                                    z3 = true;
                                                    if (next.aR() == 1) {
                                                        next.i("System splash not allow preload");
                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                    }
                                                    z = z3;
                                                } else {
                                                    z3 = true;
                                                }
                                                com.anythink.core.a.c.a();
                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                if (iA3 != -1) {
                                                    next.i("The adSource load too many times within the specified time period.");
                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                } else {
                                                    com.anythink.core.a.c.a();
                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                    if (kVarA != null) {
                                                        adErrorB = kVarA.b();
                                                        if (adErrorB != null) {
                                                            desc = adErrorB.getDesc();
                                                        } else {
                                                            desc = "";
                                                        }
                                                        next.i(desc);
                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                    } else {
                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                        if (cVar != null) {
                                                        }
                                                        z = false;
                                                    }
                                                }
                                                z = z3;
                                            }
                                        } else {
                                            listN = com.anythink.core.common.d.s.b().n(strAQ);
                                            if (listN == null) {
                                                if (next.w()) {
                                                    if (aj.b(next)) {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.aj() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                                next.k(-8);
                                                                next.i("Error Code Request fail in pacing");
                                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                                z = true;
                                                            } else {
                                                                if (iV != 0) {
                                                                    z3 = true;
                                                                    if (next.aR() == 1) {
                                                                        next.i("System splash not allow preload");
                                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                    }
                                                                    z = z3;
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                                com.anythink.core.a.c.a();
                                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                                if (iA3 != -1) {
                                                                    next.i("The adSource load too many times within the specified time period.");
                                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                                } else {
                                                                    com.anythink.core.a.c.a();
                                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                    if (kVarA != null) {
                                                                        adErrorB = kVarA.b();
                                                                        if (adErrorB != null) {
                                                                            desc = adErrorB.getDesc();
                                                                        } else {
                                                                            desc = "";
                                                                        }
                                                                        next.i(desc);
                                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                        if (cVar != null) {
                                                                        }
                                                                        z = false;
                                                                    }
                                                                }
                                                                z = z3;
                                                            }
                                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.aj() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                                next.k(-8);
                                                                next.i("Error Code Request fail in pacing");
                                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                                z = true;
                                                            } else {
                                                                if (iV != 0) {
                                                                    z3 = true;
                                                                    if (next.aR() == 1) {
                                                                        next.i("System splash not allow preload");
                                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                    }
                                                                    z = z3;
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                                com.anythink.core.a.c.a();
                                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                                if (iA3 != -1) {
                                                                    next.i("The adSource load too many times within the specified time period.");
                                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                                } else {
                                                                    com.anythink.core.a.c.a();
                                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                    if (kVarA != null) {
                                                                        adErrorB = kVarA.b();
                                                                        if (adErrorB != null) {
                                                                            desc = adErrorB.getDesc();
                                                                        } else {
                                                                            desc = "";
                                                                        }
                                                                        next.i(desc);
                                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                        if (cVar != null) {
                                                                        }
                                                                        z = false;
                                                                    }
                                                                }
                                                                z = z3;
                                                            }
                                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    }
                                                    z = true;
                                                } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                    next.k(-8);
                                                    next.i("Error Code Request fail in pacing");
                                                    aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                    z = true;
                                                } else {
                                                    if (iV != 0) {
                                                        z3 = true;
                                                        if (next.aR() == 1) {
                                                            next.i("System splash not allow preload");
                                                            aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                        }
                                                        z = z3;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    com.anythink.core.a.c.a();
                                                    iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                    if (iA3 != -1) {
                                                        next.i("The adSource load too many times within the specified time period.");
                                                        aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                    } else {
                                                        com.anythink.core.a.c.a();
                                                        kVarA = com.anythink.core.a.c.a(contextG, next);
                                                        if (kVarA != null) {
                                                            adErrorB = kVarA.b();
                                                            if (adErrorB != null) {
                                                                desc = adErrorB.getDesc();
                                                            } else {
                                                                desc = "";
                                                            }
                                                            next.i(desc);
                                                            aa.a(strAQ, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                            if (cVar != null) {
                                                            }
                                                            z = false;
                                                        }
                                                    }
                                                    z = z3;
                                                }
                                            } else if (next.w()) {
                                                if (aj.b(next)) {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.aj() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                        next.k(-8);
                                                        next.i("Error Code Request fail in pacing");
                                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        z = true;
                                                    } else {
                                                        if (iV != 0) {
                                                            z3 = true;
                                                            if (next.aR() == 1) {
                                                                next.i("System splash not allow preload");
                                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                            }
                                                            z = z3;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        com.anythink.core.a.c.a();
                                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                        if (iA3 != -1) {
                                                            next.i("The adSource load too many times within the specified time period.");
                                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                        } else {
                                                            com.anythink.core.a.c.a();
                                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                                            if (kVarA != null) {
                                                                adErrorB = kVarA.b();
                                                                if (adErrorB != null) {
                                                                    desc = adErrorB.getDesc();
                                                                } else {
                                                                    desc = "";
                                                                }
                                                                next.i(desc);
                                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                if (cVar != null) {
                                                                }
                                                                z = false;
                                                            }
                                                        }
                                                        z = z3;
                                                    }
                                                } else {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.aj() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                        next.k(-8);
                                                        next.i("Error Code Request fail in pacing");
                                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        z = true;
                                                    } else {
                                                        if (iV != 0) {
                                                            z3 = true;
                                                            if (next.aR() == 1) {
                                                                next.i("System splash not allow preload");
                                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                            }
                                                            z = z3;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        com.anythink.core.a.c.a();
                                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                        if (iA3 != -1) {
                                                            next.i("The adSource load too many times within the specified time period.");
                                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                        } else {
                                                            com.anythink.core.a.c.a();
                                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                                            if (kVarA != null) {
                                                                adErrorB = kVarA.b();
                                                                if (adErrorB != null) {
                                                                    desc = adErrorB.getDesc();
                                                                } else {
                                                                    desc = "";
                                                                }
                                                                next.i(desc);
                                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                if (cVar != null) {
                                                                }
                                                                z = false;
                                                            }
                                                        }
                                                        z = z3;
                                                    }
                                                }
                                                z = true;
                                            } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                next.k(-8);
                                                next.i("Error Code Request fail in pacing");
                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                z = true;
                                            } else {
                                                if (iV != 0) {
                                                    z3 = true;
                                                    if (next.aR() == 1) {
                                                        next.i("System splash not allow preload");
                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                    }
                                                    z = z3;
                                                } else {
                                                    z3 = true;
                                                }
                                                com.anythink.core.a.c.a();
                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                if (iA3 != -1) {
                                                    next.i("The adSource load too many times within the specified time period.");
                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                } else {
                                                    com.anythink.core.a.c.a();
                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                    if (kVarA != null) {
                                                        adErrorB = kVarA.b();
                                                        if (adErrorB != null) {
                                                            desc = adErrorB.getDesc();
                                                        } else {
                                                            desc = "";
                                                        }
                                                        next.i(desc);
                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                    } else {
                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                        if (cVar != null) {
                                                        }
                                                        z = false;
                                                    }
                                                }
                                                z = z3;
                                            }
                                        }
                                    }
                                }
                            } else {
                                com.anythink.core.a.a.a(contextG);
                                iA = com.anythink.core.a.a.a(next, lVar.ap());
                                if (iA != -1) {
                                    next.k(-5);
                                    next.i("Out of Cap");
                                    aa.a(strAQ, nVar, "Out of Cap", next, i5, i6);
                                    switch (iA) {
                                        case 8:
                                            i4 = 19;
                                            break;
                                        case 9:
                                            i4 = 20;
                                            break;
                                        case 10:
                                            i4 = 21;
                                            break;
                                        case 11:
                                            i4 = 22;
                                            break;
                                        default:
                                            i4 = 2;
                                            break;
                                    }
                                    com.anythink.core.common.t.f.a(nVarAh, i4, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
                                } else {
                                    com.anythink.core.a.d.a();
                                    iA2 = com.anythink.core.a.d.a(next);
                                    if (iA2 != -1) {
                                        next.k(-6);
                                        next.i("Out of Pacing");
                                        aa.a(strAQ, nVar, "Out of Pacing", next, i5, i6);
                                        if (iA2 == 12) {
                                            i3 = 23;
                                        } else if (iA2 != 13) {
                                            i3 = 3;
                                        } else {
                                            i3 = 24;
                                        }
                                        com.anythink.core.common.t.f.a(nVarAh, i3, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
                                    } else if (com.anythink.core.common.c.a().a(next)) {
                                        next.k(-6);
                                        next.i("Request fail in pacing");
                                        aa.a(strAQ, nVar, "Request fail in pacing", next, i5, i6);
                                        com.anythink.core.common.t.f.a(nVarAh, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
                                    } else {
                                        listM = com.anythink.core.common.d.s.b().m(strAQ);
                                        if (listM == null) {
                                            listN = com.anythink.core.common.d.s.b().n(strAQ);
                                            if (listN == null) {
                                                if (next.w()) {
                                                    if (aj.b(next)) {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.aj() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                                next.k(-8);
                                                                next.i("Error Code Request fail in pacing");
                                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                                z = true;
                                                            } else {
                                                                if (iV != 0) {
                                                                    z3 = true;
                                                                    if (next.aR() == 1) {
                                                                        next.i("System splash not allow preload");
                                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                    }
                                                                    z = z3;
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                                com.anythink.core.a.c.a();
                                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                                if (iA3 != -1) {
                                                                    next.i("The adSource load too many times within the specified time period.");
                                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                                } else {
                                                                    com.anythink.core.a.c.a();
                                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                    if (kVarA != null) {
                                                                        adErrorB = kVarA.b();
                                                                        if (adErrorB != null) {
                                                                            desc = adErrorB.getDesc();
                                                                        } else {
                                                                            desc = "";
                                                                        }
                                                                        next.i(desc);
                                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                        if (cVar != null) {
                                                                        }
                                                                        z = false;
                                                                    }
                                                                }
                                                                z = z3;
                                                            }
                                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.aj() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                                next.k(-8);
                                                                next.i("Error Code Request fail in pacing");
                                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                                z = true;
                                                            } else {
                                                                if (iV != 0) {
                                                                    z3 = true;
                                                                    if (next.aR() == 1) {
                                                                        next.i("System splash not allow preload");
                                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                    }
                                                                    z = z3;
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                                com.anythink.core.a.c.a();
                                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                                if (iA3 != -1) {
                                                                    next.i("The adSource load too many times within the specified time period.");
                                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                                } else {
                                                                    com.anythink.core.a.c.a();
                                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                    if (kVarA != null) {
                                                                        adErrorB = kVarA.b();
                                                                        if (adErrorB != null) {
                                                                            desc = adErrorB.getDesc();
                                                                        } else {
                                                                            desc = "";
                                                                        }
                                                                        next.i(desc);
                                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                        if (cVar != null) {
                                                                        }
                                                                        z = false;
                                                                    }
                                                                }
                                                                z = z3;
                                                            }
                                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    }
                                                    z = true;
                                                } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                    next.k(-8);
                                                    next.i("Error Code Request fail in pacing");
                                                    aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                    z = true;
                                                } else {
                                                    if (iV != 0) {
                                                        z3 = true;
                                                        if (next.aR() == 1) {
                                                            next.i("System splash not allow preload");
                                                            aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                        }
                                                        z = z3;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    com.anythink.core.a.c.a();
                                                    iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                    if (iA3 != -1) {
                                                        next.i("The adSource load too many times within the specified time period.");
                                                        aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                    } else {
                                                        com.anythink.core.a.c.a();
                                                        kVarA = com.anythink.core.a.c.a(contextG, next);
                                                        if (kVarA != null) {
                                                            adErrorB = kVarA.b();
                                                            if (adErrorB != null) {
                                                                desc = adErrorB.getDesc();
                                                            } else {
                                                                desc = "";
                                                            }
                                                            next.i(desc);
                                                            aa.a(strAQ, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                            if (cVar != null) {
                                                            }
                                                            z = false;
                                                        }
                                                    }
                                                    z = z3;
                                                }
                                            } else if (next.w()) {
                                                if (aj.b(next)) {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.aj() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                        next.k(-8);
                                                        next.i("Error Code Request fail in pacing");
                                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        z = true;
                                                    } else {
                                                        if (iV != 0) {
                                                            z3 = true;
                                                            if (next.aR() == 1) {
                                                                next.i("System splash not allow preload");
                                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                            }
                                                            z = z3;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        com.anythink.core.a.c.a();
                                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                        if (iA3 != -1) {
                                                            next.i("The adSource load too many times within the specified time period.");
                                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                        } else {
                                                            com.anythink.core.a.c.a();
                                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                                            if (kVarA != null) {
                                                                adErrorB = kVarA.b();
                                                                if (adErrorB != null) {
                                                                    desc = adErrorB.getDesc();
                                                                } else {
                                                                    desc = "";
                                                                }
                                                                next.i(desc);
                                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                if (cVar != null) {
                                                                }
                                                                z = false;
                                                            }
                                                        }
                                                        z = z3;
                                                    }
                                                } else {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.aj() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                        next.k(-8);
                                                        next.i("Error Code Request fail in pacing");
                                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        z = true;
                                                    } else {
                                                        if (iV != 0) {
                                                            z3 = true;
                                                            if (next.aR() == 1) {
                                                                next.i("System splash not allow preload");
                                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                            }
                                                            z = z3;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        com.anythink.core.a.c.a();
                                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                        if (iA3 != -1) {
                                                            next.i("The adSource load too many times within the specified time period.");
                                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                        } else {
                                                            com.anythink.core.a.c.a();
                                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                                            if (kVarA != null) {
                                                                adErrorB = kVarA.b();
                                                                if (adErrorB != null) {
                                                                    desc = adErrorB.getDesc();
                                                                } else {
                                                                    desc = "";
                                                                }
                                                                next.i(desc);
                                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                if (cVar != null) {
                                                                }
                                                                z = false;
                                                            }
                                                        }
                                                        z = z3;
                                                    }
                                                }
                                                z = true;
                                            } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                next.k(-8);
                                                next.i("Error Code Request fail in pacing");
                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                z = true;
                                            } else {
                                                if (iV != 0) {
                                                    z3 = true;
                                                    if (next.aR() == 1) {
                                                        next.i("System splash not allow preload");
                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                    }
                                                    z = z3;
                                                } else {
                                                    z3 = true;
                                                }
                                                com.anythink.core.a.c.a();
                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                if (iA3 != -1) {
                                                    next.i("The adSource load too many times within the specified time period.");
                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                } else {
                                                    com.anythink.core.a.c.a();
                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                    if (kVarA != null) {
                                                        adErrorB = kVarA.b();
                                                        if (adErrorB != null) {
                                                            desc = adErrorB.getDesc();
                                                        } else {
                                                            desc = "";
                                                        }
                                                        next.i(desc);
                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                    } else {
                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                        if (cVar != null) {
                                                        }
                                                        z = false;
                                                    }
                                                }
                                                z = z3;
                                            }
                                        } else {
                                            listN = com.anythink.core.common.d.s.b().n(strAQ);
                                            if (listN == null) {
                                                if (next.w()) {
                                                    if (aj.b(next)) {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.aj() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                                next.k(-8);
                                                                next.i("Error Code Request fail in pacing");
                                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                                z = true;
                                                            } else {
                                                                if (iV != 0) {
                                                                    z3 = true;
                                                                    if (next.aR() == 1) {
                                                                        next.i("System splash not allow preload");
                                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                    }
                                                                    z = z3;
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                                com.anythink.core.a.c.a();
                                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                                if (iA3 != -1) {
                                                                    next.i("The adSource load too many times within the specified time period.");
                                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                                } else {
                                                                    com.anythink.core.a.c.a();
                                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                    if (kVarA != null) {
                                                                        adErrorB = kVarA.b();
                                                                        if (adErrorB != null) {
                                                                            desc = adErrorB.getDesc();
                                                                        } else {
                                                                            desc = "";
                                                                        }
                                                                        next.i(desc);
                                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                        if (cVar != null) {
                                                                        }
                                                                        z = false;
                                                                    }
                                                                }
                                                                z = z3;
                                                            }
                                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.aj() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                                next.k(-8);
                                                                next.i("Error Code Request fail in pacing");
                                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                                z = true;
                                                            } else {
                                                                if (iV != 0) {
                                                                    z3 = true;
                                                                    if (next.aR() == 1) {
                                                                        next.i("System splash not allow preload");
                                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                    }
                                                                    z = z3;
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                                com.anythink.core.a.c.a();
                                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                                if (iA3 != -1) {
                                                                    next.i("The adSource load too many times within the specified time period.");
                                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                                } else {
                                                                    com.anythink.core.a.c.a();
                                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                    if (kVarA != null) {
                                                                        adErrorB = kVarA.b();
                                                                        if (adErrorB != null) {
                                                                            desc = adErrorB.getDesc();
                                                                        } else {
                                                                            desc = "";
                                                                        }
                                                                        next.i(desc);
                                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                        if (cVar != null) {
                                                                        }
                                                                        z = false;
                                                                    }
                                                                }
                                                                z = z3;
                                                            }
                                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    }
                                                    z = true;
                                                } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                    next.k(-8);
                                                    next.i("Error Code Request fail in pacing");
                                                    aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                    z = true;
                                                } else {
                                                    if (iV != 0) {
                                                        z3 = true;
                                                        if (next.aR() == 1) {
                                                            next.i("System splash not allow preload");
                                                            aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                        }
                                                        z = z3;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    com.anythink.core.a.c.a();
                                                    iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                    if (iA3 != -1) {
                                                        next.i("The adSource load too many times within the specified time period.");
                                                        aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                    } else {
                                                        com.anythink.core.a.c.a();
                                                        kVarA = com.anythink.core.a.c.a(contextG, next);
                                                        if (kVarA != null) {
                                                            adErrorB = kVarA.b();
                                                            if (adErrorB != null) {
                                                                desc = adErrorB.getDesc();
                                                            } else {
                                                                desc = "";
                                                            }
                                                            next.i(desc);
                                                            aa.a(strAQ, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                            if (cVar != null) {
                                                            }
                                                            z = false;
                                                        }
                                                    }
                                                    z = z3;
                                                }
                                            } else if (next.w()) {
                                                if (aj.b(next)) {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.aj() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                        next.k(-8);
                                                        next.i("Error Code Request fail in pacing");
                                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        z = true;
                                                    } else {
                                                        if (iV != 0) {
                                                            z3 = true;
                                                            if (next.aR() == 1) {
                                                                next.i("System splash not allow preload");
                                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                            }
                                                            z = z3;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        com.anythink.core.a.c.a();
                                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                        if (iA3 != -1) {
                                                            next.i("The adSource load too many times within the specified time period.");
                                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                        } else {
                                                            com.anythink.core.a.c.a();
                                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                                            if (kVarA != null) {
                                                                adErrorB = kVarA.b();
                                                                if (adErrorB != null) {
                                                                    desc = adErrorB.getDesc();
                                                                } else {
                                                                    desc = "";
                                                                }
                                                                next.i(desc);
                                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                if (cVar != null) {
                                                                }
                                                                z = false;
                                                            }
                                                        }
                                                        z = z3;
                                                    }
                                                } else {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.aj() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                            next.k(-8);
                                                            next.i("Error Code Request fail in pacing");
                                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            z = true;
                                                        } else {
                                                            if (iV != 0) {
                                                                z3 = true;
                                                                if (next.aR() == 1) {
                                                                    next.i("System splash not allow preload");
                                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                                }
                                                                z = z3;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            com.anythink.core.a.c.a();
                                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                            if (iA3 != -1) {
                                                                next.i("The adSource load too many times within the specified time period.");
                                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                            } else {
                                                                com.anythink.core.a.c.a();
                                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                                if (kVarA != null) {
                                                                    adErrorB = kVarA.b();
                                                                    if (adErrorB != null) {
                                                                        desc = adErrorB.getDesc();
                                                                    } else {
                                                                        desc = "";
                                                                    }
                                                                    next.i(desc);
                                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                    if (cVar != null) {
                                                                    }
                                                                    z = false;
                                                                }
                                                            }
                                                            z = z3;
                                                        }
                                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                        next.k(-8);
                                                        next.i("Error Code Request fail in pacing");
                                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        z = true;
                                                    } else {
                                                        if (iV != 0) {
                                                            z3 = true;
                                                            if (next.aR() == 1) {
                                                                next.i("System splash not allow preload");
                                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                            }
                                                            z = z3;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        com.anythink.core.a.c.a();
                                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                        if (iA3 != -1) {
                                                            next.i("The adSource load too many times within the specified time period.");
                                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                        } else {
                                                            com.anythink.core.a.c.a();
                                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                                            if (kVarA != null) {
                                                                adErrorB = kVarA.b();
                                                                if (adErrorB != null) {
                                                                    desc = adErrorB.getDesc();
                                                                } else {
                                                                    desc = "";
                                                                }
                                                                next.i(desc);
                                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                                if (cVar != null) {
                                                                }
                                                                z = false;
                                                            }
                                                        }
                                                        z = z3;
                                                    }
                                                }
                                                z = true;
                                            } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                next.k(-8);
                                                next.i("Error Code Request fail in pacing");
                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                z = true;
                                            } else {
                                                if (iV != 0) {
                                                    z3 = true;
                                                    if (next.aR() == 1) {
                                                        next.i("System splash not allow preload");
                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                    }
                                                    z = z3;
                                                } else {
                                                    z3 = true;
                                                }
                                                com.anythink.core.a.c.a();
                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                if (iA3 != -1) {
                                                    next.i("The adSource load too many times within the specified time period.");
                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                } else {
                                                    com.anythink.core.a.c.a();
                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                    if (kVarA != null) {
                                                        adErrorB = kVarA.b();
                                                        if (adErrorB != null) {
                                                            desc = adErrorB.getDesc();
                                                        } else {
                                                            desc = "";
                                                        }
                                                        next.i(desc);
                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                    } else {
                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                        if (cVar != null) {
                                                        }
                                                        z = false;
                                                    }
                                                }
                                                z = z3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    next.i("Filter ad source loading across all channels on risky devices.");
                    aa.a(strAQ, nVar, "Filter ad source loading across all channels on risky devices.", next, i5, i6);
                    com.anythink.core.common.t.f.a(nVarAh, 27, ErrorCode.getErrorCode(ErrorCode.adSourceLoadRiskError, "", "Filter ad source loading across all channels on risky devices."));
                }
                z = z3;
            } else {
                adErrorA = a(1, nVarAh, next, (com.anythink.core.common.h.z) null);
                i = 9;
                if (adErrorA != null) {
                    code = adErrorA.getCode();
                    code.hashCode();
                    switch (code.hashCode()) {
                        case 1537309:
                            if (!code.equals(ErrorCode.adSourceLoadBidTypeFilterError)) {
                                b2 = -1;
                            }
                            break;
                        case 1537310:
                            if (code.equals(ErrorCode.adSourceLoadPriceFilterError)) {
                                b2 = 1;
                            } else {
                                b2 = -1;
                            }
                            break;
                        case 1537311:
                            if (code.equals(ErrorCode.adSourceLoadUnitFilterError)) {
                                b2 = 2;
                            } else {
                                b2 = -1;
                            }
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    switch (b2) {
                        case 0:
                            i = 29;
                            break;
                        case 1:
                            i = 30;
                            break;
                        case 2:
                            i = 31;
                            break;
                    }
                    next.i(adErrorA.getPlatformMSG());
                    nVarAh.o(next.bF());
                    nVarAh.C(next.bG());
                    aa.a(strAQ, nVar, adErrorA.getPlatformMSG(), next, i5, i6);
                    com.anythink.core.common.t.f.a(nVarAh, i, adErrorA);
                } else {
                    listJ = com.anythink.core.common.d.s.b().J();
                    com.anythink.core.common.d.s.b();
                    if (com.anythink.core.common.d.s.a(listJ, String.valueOf(next.n()))) {
                        next.i("Forbid network by developer");
                        aa.a(strAQ, nVar, "Forbid network by developer", next, i5, i6, listJ);
                        com.anythink.core.common.t.f.a(nVarAh, 14, ErrorCode.getErrorCode(ErrorCode.forbidNetworkByDeveloper, "", "Forbid network by developer"));
                    } else if (!aj.b(next) && com.anythink.core.common.a.d.a(contextG).a(next.G())) {
                        next.i("Adx bid Pacing");
                        aa.a(strAQ, nVar, "Adx bid Pacing", next, i5, i6);
                        com.anythink.core.common.t.f.a(nVarAh, 12, ErrorCode.getErrorCode(ErrorCode.inAdxBidInterval, "", "Adx bid Pacing"));
                    } else {
                        com.anythink.core.a.a.a(contextG);
                        iA = com.anythink.core.a.a.a(next, lVar.ap());
                        if (iA != -1) {
                            next.k(-5);
                            next.i("Out of Cap");
                            aa.a(strAQ, nVar, "Out of Cap", next, i5, i6);
                            switch (iA) {
                                case 8:
                                    i4 = 19;
                                    break;
                                case 9:
                                    i4 = 20;
                                    break;
                                case 10:
                                    i4 = 21;
                                    break;
                                case 11:
                                    i4 = 22;
                                    break;
                                default:
                                    i4 = 2;
                                    break;
                            }
                            com.anythink.core.common.t.f.a(nVarAh, i4, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
                        } else {
                            com.anythink.core.a.d.a();
                            iA2 = com.anythink.core.a.d.a(next);
                            if (iA2 != -1) {
                                next.k(-6);
                                next.i("Out of Pacing");
                                aa.a(strAQ, nVar, "Out of Pacing", next, i5, i6);
                                if (iA2 == 12) {
                                    i3 = 23;
                                } else if (iA2 != 13) {
                                    i3 = 3;
                                } else {
                                    i3 = 24;
                                }
                                com.anythink.core.common.t.f.a(nVarAh, i3, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
                            } else if (com.anythink.core.common.c.a().a(next)) {
                                next.k(-6);
                                next.i("Request fail in pacing");
                                aa.a(strAQ, nVar, "Request fail in pacing", next, i5, i6);
                                com.anythink.core.common.t.f.a(nVarAh, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
                            } else {
                                listM = com.anythink.core.common.d.s.b().m(strAQ);
                                if (listM == null && listM.contains(next.G())) {
                                    next.k(-8);
                                    next.i("Request fail in filter list");
                                    aa.a(strAQ, nVar, "Request fail in filter list", next, i5, i6, listM);
                                    com.anythink.core.common.t.f.a(nVarAh, 5, ErrorCode.getErrorCode(ErrorCode.filterSourceError, "", "Request fail in filter list"));
                                } else {
                                    listN = com.anythink.core.common.d.s.b().n(strAQ);
                                    if (listN == null && listN.contains(String.valueOf(next.n()))) {
                                        next.k(-8);
                                        next.i("Filter by network firm id.");
                                        aa.a(strAQ, nVar, "Filter by network firm id.", next, i5, i6, listN);
                                        com.anythink.core.common.t.f.a(nVarAh, 9, ErrorCode.getErrorCode(ErrorCode.networkFirmIdFilterSourceError, "", "Filter by network firm id."));
                                    } else if (next.w()) {
                                        if (aj.b(next) || (boolB = com.anythink.core.common.a.d.a(contextG).b(next.G())) == null) {
                                            z2 = true;
                                        } else if (boolB.booleanValue()) {
                                            next.i("Adx bid fail in pacing");
                                            aa.a(strAQ, nVar, "Bid fail in pacing", next, i5, i6);
                                            com.anythink.core.common.t.f.a(nVarAh, 13, ErrorCode.getErrorCode(ErrorCode.inAdxBidFailedInterval, "", "Adx Bid fail in pacing"));
                                        } else {
                                            z2 = false;
                                        }
                                        if (!z2 && com.anythink.core.common.c.a().b(next)) {
                                            next.k(-7);
                                            next.i("Bid fail in pacing");
                                            aa.a(strAQ, nVar, "Bid fail in pacing", next, i5, i6);
                                            com.anythink.core.common.t.f.a(nVarAh, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Bid fail in pacing"));
                                        } else if (next.aj() == 1 && next.y() == 2) {
                                            com.anythink.core.common.h.i iVarS = nVar.a() != null ? nVar.a().s() : null;
                                            if (iVarS != null && iVarS.a(next)) {
                                                next.k(-7);
                                                next.i("Can't Load On Showing");
                                                aa.a(strAQ, nVar, "Can't Load On Showing", next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVar, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                                                z = true;
                                            } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                                next.k(-8);
                                                next.i("Error Code Request fail in pacing");
                                                aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                z = true;
                                            } else {
                                                if (iV != 0) {
                                                    z3 = true;
                                                    if (next.aR() == 1) {
                                                        next.i("System splash not allow preload");
                                                        aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                    }
                                                    z = z3;
                                                } else {
                                                    z3 = true;
                                                }
                                                com.anythink.core.a.c.a();
                                                iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                                if (iA3 != -1) {
                                                    next.i("The adSource load too many times within the specified time period.");
                                                    aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                                } else {
                                                    com.anythink.core.a.c.a();
                                                    kVarA = com.anythink.core.a.c.a(contextG, next);
                                                    if (kVarA != null) {
                                                        adErrorB = kVarA.b();
                                                        if (adErrorB != null) {
                                                            desc = adErrorB.getDesc();
                                                        } else {
                                                            desc = "";
                                                        }
                                                        next.i(desc);
                                                        aa.a(strAQ, nVar, desc, next, i5, i6);
                                                        com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                    } else {
                                                        cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                        if (cVar != null) {
                                                        }
                                                        z = false;
                                                    }
                                                }
                                                z = z3;
                                            }
                                        } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                            next.k(-8);
                                            next.i("Error Code Request fail in pacing");
                                            aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                            z = true;
                                        } else {
                                            if (iV != 0) {
                                                z3 = true;
                                                if (next.aR() == 1) {
                                                    next.i("System splash not allow preload");
                                                    aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                                }
                                                z = z3;
                                            } else {
                                                z3 = true;
                                            }
                                            com.anythink.core.a.c.a();
                                            iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                            if (iA3 != -1) {
                                                next.i("The adSource load too many times within the specified time period.");
                                                aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                            } else {
                                                com.anythink.core.a.c.a();
                                                kVarA = com.anythink.core.a.c.a(contextG, next);
                                                if (kVarA != null) {
                                                    adErrorB = kVarA.b();
                                                    if (adErrorB != null) {
                                                        desc = adErrorB.getDesc();
                                                    } else {
                                                        desc = "";
                                                    }
                                                    next.i(desc);
                                                    aa.a(strAQ, nVar, desc, next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                                } else {
                                                    cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                    if (cVar != null) {
                                                    }
                                                    z = false;
                                                }
                                            }
                                            z = z3;
                                        }
                                    } else if (com.anythink.core.common.c.a().a(iV, lVar, next)) {
                                        next.k(-8);
                                        next.i("Error Code Request fail in pacing");
                                        aa.a(strAQ, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                        com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                        z = true;
                                    } else {
                                        if (iV != 0) {
                                            z3 = true;
                                            if (next.aR() == 1) {
                                                next.i("System splash not allow preload");
                                                aa.a(strAQ, nVar, "System splash not allow preload", next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                            }
                                            z = z3;
                                        } else {
                                            z3 = true;
                                        }
                                        com.anythink.core.a.c.a();
                                        iA3 = com.anythink.core.a.c.a(contextG, next, strAQ, lVar.ap());
                                        if (iA3 != -1) {
                                            next.i("The adSource load too many times within the specified time period.");
                                            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
                                        } else {
                                            com.anythink.core.a.c.a();
                                            kVarA = com.anythink.core.a.c.a(contextG, next);
                                            if (kVarA != null) {
                                                adErrorB = kVarA.b();
                                                if (adErrorB != null) {
                                                    desc = adErrorB.getDesc();
                                                } else {
                                                    desc = "";
                                                }
                                                next.i(desc);
                                                aa.a(strAQ, nVar, desc, next, i5, i6);
                                                com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
                                            } else {
                                                cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
                                                if (cVar != null || (akVarA = cVar.a(next)) == null) {
                                                    z = false;
                                                } else {
                                                    if (akVarA.d() == com.anythink.core.common.v.a.a.C0054a.b) {
                                                        i2 = 16;
                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                        str2 = "AD platform's error code strategy limit1";
                                                    } else {
                                                        i2 = 17;
                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                        str2 = "AD platform's error code strategy limit2";
                                                    }
                                                    String str3 = str;
                                                    String str4 = str2;
                                                    next.i(str4);
                                                    aa.a(strAQ, nVar, str4, next, i5, i6);
                                                    com.anythink.core.common.t.f.a(nVarAh, i2, ErrorCode.getErrorCode(str3, str3, str4));
                                                }
                                            }
                                        }
                                        z = z3;
                                    }
                                }
                                z = true;
                            }
                        }
                    }
                }
                z = z3;
            }
            if (z) {
                next.m();
                it.remove();
            }
        }
    }

    public static void a(com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar, List<by> list) {
        int i;
        Iterator<by> it = list.iterator();
        while (it.hasNext()) {
            by next = it.next();
            com.anythink.core.common.h.n nVarAh = nVar.ah();
            String strAQ = nVar.aQ();
            byte b2 = 0;
            ai.a(nVarAh, next, 0, false);
            com.anythink.core.a.a.a(com.anythink.core.common.d.s.b().g());
            String strG = next.G();
            lVar.ap();
            bq.a aVarA = com.anythink.core.a.a.a(strG);
            int i2 = aVarA.e;
            int i3 = aVarA.d;
            AdError adErrorA = a(0, nVarAh, next, (com.anythink.core.common.h.z) null);
            if (adErrorA != null) {
                String code = adErrorA.getCode();
                code.hashCode();
                switch (code.hashCode()) {
                    case 1537309:
                        if (!code.equals(ErrorCode.adSourceLoadBidTypeFilterError)) {
                            b2 = -1;
                        }
                        break;
                    case 1537310:
                        b2 = !code.equals(ErrorCode.adSourceLoadPriceFilterError) ? (byte) -1 : (byte) 1;
                        break;
                    case 1537311:
                        b2 = !code.equals(ErrorCode.adSourceLoadUnitFilterError) ? (byte) -1 : (byte) 2;
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        i = 29;
                        break;
                    case 1:
                        i = 30;
                        break;
                    case 2:
                        i = 31;
                        break;
                    default:
                        i = 9;
                        break;
                }
                int i4 = i;
                next.i(adErrorA.getPlatformMSG());
                nVarAh.o(next.bF());
                nVarAh.C(next.bG());
                aa.a(strAQ, nVar, adErrorA.getPlatformMSG(), next, i2, i3);
                com.anythink.core.common.t.f.a(nVarAh, i4, adErrorA);
                b2 = 1;
            }
            if (b2 != 0) {
                next.m();
                it.remove();
            }
        }
    }

    private static boolean a(com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar, by byVar) {
        int i;
        com.anythink.core.common.h.n nVarAh = nVar.ah();
        String strAQ = nVar.aQ();
        byte b2 = 0;
        ai.a(nVarAh, byVar, 0, false);
        com.anythink.core.a.a.a(com.anythink.core.common.d.s.b().g());
        String strG = byVar.G();
        lVar.ap();
        bq.a aVarA = com.anythink.core.a.a.a(strG);
        int i2 = aVarA.e;
        int i3 = aVarA.d;
        AdError adErrorA = a(0, nVarAh, byVar, (com.anythink.core.common.h.z) null);
        if (adErrorA == null) {
            return false;
        }
        String code = adErrorA.getCode();
        code.hashCode();
        switch (code.hashCode()) {
            case 1537309:
                if (!code.equals(ErrorCode.adSourceLoadBidTypeFilterError)) {
                    b2 = -1;
                }
                break;
            case 1537310:
                b2 = !code.equals(ErrorCode.adSourceLoadPriceFilterError) ? (byte) -1 : (byte) 1;
                break;
            case 1537311:
                b2 = !code.equals(ErrorCode.adSourceLoadUnitFilterError) ? (byte) -1 : (byte) 2;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                i = 29;
                break;
            case 1:
                i = 30;
                break;
            case 2:
                i = 31;
                break;
            default:
                i = 9;
                break;
        }
        int i4 = i;
        byVar.i(adErrorA.getPlatformMSG());
        nVarAh.o(byVar.bF());
        nVarAh.C(byVar.bG());
        aa.a(strAQ, nVar, adErrorA.getPlatformMSG(), byVar, i2, i3);
        com.anythink.core.common.t.f.a(nVarAh, i4, adErrorA);
        return true;
    }

    public static AdError a(int i, com.anythink.core.common.h.n nVar, by byVar, com.anythink.core.common.h.z zVar) {
        Map<String, ATAdFilter> mapZ;
        ATAdFilter aTAdFilter;
        if (nVar == null || byVar == null || (mapZ = com.anythink.core.common.d.s.b().Z()) == null || mapZ.isEmpty() || (aTAdFilter = mapZ.get(nVar.aQ())) == null) {
            return null;
        }
        int iE = o.e(byVar.k());
        String strA = aj.a(byVar, null);
        double dA = o.a(byVar);
        if (zVar != null) {
            dA = zVar.getSortPrice();
        }
        return aTAdFilter.doFilter(new cd(i, String.valueOf(byVar.n()), String.valueOf(iE), dA, strA, byVar));
    }

    private static boolean a(int i, com.anythink.core.e.l lVar, com.anythink.core.common.h.n nVar, by byVar) {
        com.anythink.core.common.h.ak akVarA;
        int i2;
        String str;
        String str2;
        boolean z;
        Boolean boolB;
        int i3;
        com.anythink.core.common.h.n nVarAh = nVar.ah();
        String strAQ = nVar.aQ();
        byte b2 = 0;
        ai.a(nVarAh, byVar, 0, false);
        com.anythink.core.a.a.a(com.anythink.core.common.d.s.b().g());
        String strG = byVar.G();
        lVar.ap();
        bq.a aVarA = com.anythink.core.a.a.a(strG);
        int i4 = aVarA.e;
        int i5 = aVarA.d;
        Context contextG = com.anythink.core.common.d.s.b().g();
        Pair<Integer, List<String>> pairI = com.anythink.core.common.d.s.b().I();
        if (pairI != null && ((Integer) pairI.first).intValue() == 1) {
            List list = (List) pairI.second;
            if (list != null && !list.isEmpty()) {
                if (list.contains(String.valueOf(byVar.n()))) {
                    byVar.i("Filter ad source loading for specified channel id on risky devices.");
                    aa.a(strAQ, nVar, "Filter ad source loading for specified channel id on risky devices.", byVar, i4, i5, list);
                    com.anythink.core.common.t.f.a(nVarAh, 28, ErrorCode.getErrorCode(ErrorCode.adSourceLoadRiskError, "", "Filter ad source loading for specified channel id on risky devices."));
                    return true;
                }
            } else {
                byVar.i("Filter ad source loading across all channels on risky devices.");
                aa.a(strAQ, nVar, "Filter ad source loading across all channels on risky devices.", byVar, i4, i5);
                com.anythink.core.common.t.f.a(nVarAh, 27, ErrorCode.getErrorCode(ErrorCode.adSourceLoadRiskError, "", "Filter ad source loading across all channels on risky devices."));
                return true;
            }
        }
        AdError adErrorA = a(1, nVarAh, byVar, (com.anythink.core.common.h.z) null);
        int i6 = 9;
        if (adErrorA != null) {
            String code = adErrorA.getCode();
            code.hashCode();
            switch (code.hashCode()) {
                case 1537309:
                    if (!code.equals(ErrorCode.adSourceLoadBidTypeFilterError)) {
                        b2 = -1;
                    }
                    break;
                case 1537310:
                    b2 = !code.equals(ErrorCode.adSourceLoadPriceFilterError) ? (byte) -1 : (byte) 1;
                    break;
                case 1537311:
                    b2 = !code.equals(ErrorCode.adSourceLoadUnitFilterError) ? (byte) -1 : (byte) 2;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    i6 = 29;
                    break;
                case 1:
                    i6 = 30;
                    break;
                case 2:
                    i6 = 31;
                    break;
            }
            byVar.i(adErrorA.getPlatformMSG());
            nVarAh.o(byVar.bF());
            nVarAh.C(byVar.bG());
            aa.a(strAQ, nVar, adErrorA.getPlatformMSG(), byVar, i4, i5);
            com.anythink.core.common.t.f.a(nVarAh, i6, adErrorA);
            return true;
        }
        List<String> listJ = com.anythink.core.common.d.s.b().J();
        com.anythink.core.common.d.s.b();
        if (com.anythink.core.common.d.s.a(listJ, String.valueOf(byVar.n()))) {
            byVar.i("Forbid network by developer");
            aa.a(strAQ, nVar, "Forbid network by developer", byVar, i4, i5, listJ);
            com.anythink.core.common.t.f.a(nVarAh, 14, ErrorCode.getErrorCode(ErrorCode.forbidNetworkByDeveloper, "", "Forbid network by developer"));
            return true;
        }
        if (aj.b(byVar) && com.anythink.core.common.a.d.a(contextG).a(byVar.G())) {
            byVar.i("Adx bid Pacing");
            aa.a(strAQ, nVar, "Adx bid Pacing", byVar, i4, i5);
            com.anythink.core.common.t.f.a(nVarAh, 12, ErrorCode.getErrorCode(ErrorCode.inAdxBidInterval, "", "Adx bid Pacing"));
            return true;
        }
        com.anythink.core.a.a.a(contextG);
        int iA = com.anythink.core.a.a.a(byVar, lVar.ap());
        if (iA != -1) {
            byVar.k(-5);
            byVar.i("Out of Cap");
            aa.a(strAQ, nVar, "Out of Cap", byVar, i4, i5);
            switch (iA) {
                case 8:
                    i3 = 19;
                    break;
                case 9:
                    i3 = 20;
                    break;
                case 10:
                    i3 = 21;
                    break;
                case 11:
                    i3 = 22;
                    break;
                default:
                    i3 = 2;
                    break;
            }
            com.anythink.core.common.t.f.a(nVarAh, i3, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
            return true;
        }
        com.anythink.core.a.d.a();
        int iA2 = com.anythink.core.a.d.a(byVar);
        if (iA2 != -1) {
            byVar.k(-6);
            byVar.i("Out of Pacing");
            aa.a(strAQ, nVar, "Out of Pacing", byVar, i4, i5);
            com.anythink.core.common.t.f.a(nVarAh, iA2 != 12 ? iA2 != 13 ? 3 : 24 : 23, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
            return true;
        }
        if (com.anythink.core.common.c.a().a(byVar)) {
            byVar.k(-6);
            byVar.i("Request fail in pacing");
            aa.a(strAQ, nVar, "Request fail in pacing", byVar, i4, i5);
            com.anythink.core.common.t.f.a(nVarAh, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
            return true;
        }
        List<String> listM = com.anythink.core.common.d.s.b().m(strAQ);
        if (listM != null && listM.contains(byVar.G())) {
            byVar.k(-8);
            byVar.i("Request fail in filter list");
            aa.a(strAQ, nVar, "Request fail in filter list", byVar, i4, i5, listM);
            com.anythink.core.common.t.f.a(nVarAh, 5, ErrorCode.getErrorCode(ErrorCode.filterSourceError, "", "Request fail in filter list"));
            return true;
        }
        List<String> listN = com.anythink.core.common.d.s.b().n(strAQ);
        if (listN != null && listN.contains(String.valueOf(byVar.n()))) {
            byVar.k(-8);
            byVar.i("Filter by network firm id.");
            aa.a(strAQ, nVar, "Filter by network firm id.", byVar, i4, i5, listN);
            com.anythink.core.common.t.f.a(nVarAh, 9, ErrorCode.getErrorCode(ErrorCode.networkFirmIdFilterSourceError, "", "Filter by network firm id."));
            return true;
        }
        if (byVar.w()) {
            if (!aj.b(byVar) || (boolB = com.anythink.core.common.a.d.a(contextG).b(byVar.G())) == null) {
                z = true;
            } else {
                if (boolB.booleanValue()) {
                    byVar.i("Adx bid fail in pacing");
                    aa.a(strAQ, nVar, "Bid fail in pacing", byVar, i4, i5);
                    com.anythink.core.common.t.f.a(nVarAh, 13, ErrorCode.getErrorCode(ErrorCode.inAdxBidFailedInterval, "", "Adx Bid fail in pacing"));
                    return true;
                }
                z = false;
            }
            if (z && com.anythink.core.common.c.a().b(byVar)) {
                byVar.k(-7);
                byVar.i("Bid fail in pacing");
                aa.a(strAQ, nVar, "Bid fail in pacing", byVar, i4, i5);
                com.anythink.core.common.t.f.a(nVarAh, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Bid fail in pacing"));
                return true;
            }
            if (byVar.aj() != 1 && byVar.y() == 2) {
                com.anythink.core.common.h.i iVarS = nVar.a() != null ? nVar.a().s() : null;
                if (iVarS != null && iVarS.a(byVar)) {
                    byVar.k(-7);
                    byVar.i("Can't Load On Showing");
                    aa.a(strAQ, nVar, "Can't Load On Showing", byVar, i4, i5);
                    com.anythink.core.common.t.f.a(nVar, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                    return true;
                }
            }
        }
        if (com.anythink.core.common.c.a().a(i, lVar, byVar)) {
            byVar.k(-8);
            byVar.i("Error Code Request fail in pacing");
            aa.a(strAQ, nVar, "Error Code Request fail in pacing", byVar, i4, i5);
            com.anythink.core.common.t.f.a(nVarAh, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
            return true;
        }
        if (i != 0 && byVar.aR() == 1) {
            byVar.i("System splash not allow preload");
            aa.a(strAQ, nVar, "System splash not allow preload", byVar, i4, i5);
            com.anythink.core.common.t.f.a(nVarAh, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
            return true;
        }
        com.anythink.core.a.c.a();
        int iA3 = com.anythink.core.a.c.a(contextG, byVar, strAQ, lVar.ap());
        if (iA3 != -1) {
            byVar.i("The adSource load too many times within the specified time period.");
            aa.a(strAQ, nVar, "The adSource load too many times within the specified time period.", byVar, i4, i5);
            com.anythink.core.common.t.f.a(nVarAh, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
            return true;
        }
        com.anythink.core.a.c.a();
        com.anythink.core.common.h.k kVarA = com.anythink.core.a.c.a(contextG, byVar);
        if (kVarA != null) {
            AdError adErrorB = kVarA.b();
            String desc = adErrorB != null ? adErrorB.getDesc() : "";
            byVar.i(desc);
            aa.a(strAQ, nVar, desc, byVar, i4, i5);
            com.anythink.core.common.t.f.a(nVarAh, kVarA.a(), adErrorB);
            return true;
        }
        com.anythink.core.common.v.a.b.c cVar = (com.anythink.core.common.v.a.b.c) com.anythink.core.common.v.a.a.d.a(strAQ, com.anythink.core.common.v.a.b.c.class);
        if (cVar == null || (akVarA = cVar.a(byVar)) == null) {
            return false;
        }
        if (akVarA.d() == com.anythink.core.common.v.a.a.C0054a.b) {
            i2 = 16;
            str = ErrorCode.filterByMNErrorCodeReqLimit;
            str2 = "AD platform's error code strategy limit1";
        } else {
            i2 = 17;
            str = ErrorCode.filterByMatchNetworkErrorCode;
            str2 = "AD platform's error code strategy limit2";
        }
        String str3 = str;
        String str4 = str2;
        byVar.i(str4);
        aa.a(strAQ, nVar, str4, byVar, i4, i5);
        com.anythink.core.common.t.f.a(nVarAh, i2, ErrorCode.getErrorCode(str3, str3, str4));
        return true;
    }

    private static boolean a(String str, by byVar, com.anythink.core.common.h.n nVar) {
        bz bzVarA;
        com.anythink.core.common.h.c cVarA;
        com.anythink.core.common.h.ad adVarA;
        if (aj.b(byVar)) {
            com.anythink.core.common.f fVarA = nVar.a();
            if (fVarA != null && fVarA.f() != null && (adVarA = fVarA.f().a(str, byVar)) != null && !adVarA.a() && adVarA.r()) {
                return false;
            }
            if (fVarA != null && fVarA.e() != null && (bzVarA = fVarA.e().a(str, byVar)) != null && (cVarA = bzVarA.a((com.anythink.core.common.h.ad) null).a()) != null && cVarA.e() != null && cVarA.e().getUnitGroupInfo() != null && TextUtils.equals(cVarA.e().getUnitGroupInfo().G(), byVar.G()) && cVarA.e().getUnitGroupInfo().bz()) {
                return false;
            }
            Boolean boolA = com.anythink.core.common.a.d.a(com.anythink.core.common.d.s.b().g()).a(byVar);
            if (boolA != null) {
                return boolA.booleanValue();
            }
        }
        return byVar.z() == 2;
    }
}
