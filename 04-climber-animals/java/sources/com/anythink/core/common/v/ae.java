package com.anythink.core.common.v;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdFilter;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bo;
import com.anythink.core.common.h.bp;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bw;
import com.anythink.core.common.h.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class ae {
    static Random a = new Random();
    private static final String b = "PlacementPrepareUtils";

    public static final bp a(com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar) {
        List<bv> listA;
        List<bv> listA2;
        List<bv> listC;
        List<bv> listD;
        List<bv> listE;
        if (lVar == null) {
            return null;
        }
        ATAdRequest aTAdRequestA = nVar.a();
        if (aTAdRequestA != null) {
            lVar.a(aTAdRequestA);
        }
        if (nVar.ah()) {
            nVar.aI();
            nVar.Z();
            listA = new ArrayList<>();
            listA2 = com.anythink.core.d.u.a(lVar, lVar.Y());
            listC = new ArrayList<>();
            listD = new ArrayList<>();
            listE = new ArrayList<>();
        } else {
            nVar.aI();
            nVar.Z();
            listA = a(nVar, lVar, com.anythink.core.d.u.b(lVar));
            nVar.aI();
            nVar.Z();
            listA2 = com.anythink.core.d.u.a(lVar);
            listC = com.anythink.core.d.u.c(lVar);
            com.anythink.core.c.a.a().a(nVar, listA, lVar);
            com.anythink.core.c.a.a().a(nVar, listC, lVar);
            listD = com.anythink.core.d.u.d(lVar);
            listE = com.anythink.core.d.u.e(lVar);
        }
        bp bpVar = new bp(lVar, nVar, listA.size() + listA2.size() + listC.size() + listD.size() + listE.size());
        bpVar.a(listA);
        bpVar.b(listA2);
        bpVar.e(listC);
        bpVar.c(listD);
        bpVar.d(listE);
        b(lVar, bpVar.c(), listA);
        b(lVar, bpVar.c(), listA2);
        b(lVar, bpVar.c(), listC);
        b(lVar, bpVar.c(), listD);
        b(lVar, bpVar.c(), listE);
        return bpVar;
    }

    private static List<bv> a(com.anythink.core.common.h.n nVar, com.anythink.core.d.l lVar, List<bv> list) {
        if (com.anythink.core.common.d.t.b().z()) {
            nVar.aI();
            return list;
        }
        if (nVar.U() == 9 && lVar.bg() && lVar.bh()) {
            nVar.aI();
            return list;
        }
        com.anythink.core.d.f fVarJ = lVar.j();
        if (fVarJ == null) {
            nVar.aI();
            return list;
        }
        if (list.size() <= fVarJ.f()) {
            nVar.aI();
            return list;
        }
        com.anythink.core.c.a.d dVarA = com.anythink.core.c.b.a().a(nVar.aI(), lVar, fVarJ);
        if (dVarA != null) {
            double d = dVarA.a;
            if (d > 0.0d) {
                nVar.aI();
                dVarA.toString();
                double dE = fVarJ.e() * d;
                if (p.a(list.get(0)) <= dE) {
                    nVar.aI();
                    return list;
                }
                int size = list.size() - 1;
                int size2 = list.size() - 1;
                HashMap map = new HashMap();
                for (int i = 0; i < list.size(); i++) {
                    double dA = p.a(list.get(i));
                    if (!map.containsKey(String.valueOf(dA))) {
                        map.put(String.valueOf(dA), Integer.valueOf(i));
                    }
                    if (size2 == list.size() - 1) {
                        if (dA == d) {
                            size2 = i - fVarJ.f();
                            nVar.aI();
                        } else if (dA < d) {
                            if (i > 0) {
                                size2 = ((Integer) map.get(String.valueOf(p.a(list.get(i - 1))))).intValue() - fVarJ.f();
                                nVar.aI();
                            } else {
                                size2 = i - fVarJ.f();
                                nVar.aI();
                            }
                        }
                    }
                    if (size == list.size() - 1) {
                        if (dA == dE) {
                            nVar.aI();
                            size = i;
                        } else if (dA < dE) {
                            size = i - 1;
                            nVar.aI();
                        }
                    }
                    if (size <= 0 || size2 <= 0) {
                        nVar.aI();
                        break;
                    }
                    if (size < list.size() - 1 && size2 < list.size() - 1) {
                        nVar.aI();
                        break;
                    }
                }
                int iMin = Math.min(size, size2);
                nVar.aI();
                if (iMin <= 0) {
                    nVar.aI();
                    return list;
                }
                bv bvVar = list.get(iMin);
                double dA2 = p.a(bvVar);
                String strZ = bvVar.z();
                Integer num = (Integer) map.get(String.valueOf(dA2));
                if (num != null) {
                    iMin = num.intValue();
                    strZ = list.get(iMin).z();
                }
                nVar.aI();
                nVar.aI();
                List<bv> listSubList = list.subList(iMin, list.size());
                int[] iArrG = fVarJ.g();
                if (iArrG != null && iArrG.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    List<bv> listSubList2 = list.subList(0, iMin);
                    for (int i2 = 0; i2 < listSubList2.size(); i2++) {
                        bv bvVar2 = listSubList2.get(i2);
                        if (a(iArrG, bvVar2.g())) {
                            arrayList.add(bvVar2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        listSubList.addAll(0, arrayList);
                    }
                }
                com.anythink.core.common.u.e.a(nVar, fVarJ, dVarA.b, d, strZ, dA2, fVarJ.h());
                return listSubList;
            }
        }
        nVar.aI();
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

    public static List<bv> a(final bp bpVar, List<bv> list) {
        return p.a(list, new com.anythink.core.common.k.f() { // from class: com.anythink.core.common.v.ae.1
            @Override // com.anythink.core.common.k.f
            public final void a(bv bvVar, int i, int i2) {
                bvVar.H(i);
                if (i2 >= 0) {
                    bvVar.G(i2);
                    bw bwVarA = com.anythink.core.common.a.a().a(bpVar.c().aI(), bvVar);
                    if (bwVarA != null) {
                        bwVarA.b(bvVar.aw());
                    }
                }
            }
        });
    }

    public static void b(bp bpVar, List<bv> list) {
        List<bv> listD = bpVar.d();
        List<bv> listE = bpVar.e();
        List<bv> listF = bpVar.f();
        List<bv> listG = bpVar.g();
        a(listD, listE, bpVar.c(), list);
        a(listD, listF, bpVar.c(), list);
        a(listD, listG, bpVar.c(), list);
    }

    private static void a(List<bv> list, List<bv> list2, com.anythink.core.common.h.n nVar, List<bv> list3) {
        String strAI = nVar.aI();
        if (list == null || list2 == null) {
            return;
        }
        boolean z = false;
        for (int size = list2.size() - 1; size >= 0; size--) {
            bv bvVar = list2.get(size);
            if (bvVar.an()) {
                list3.add(bvVar);
            }
            if (!a(strAI, bvVar)) {
                bw bwVarA = com.anythink.core.common.a.a().a(strAI, bvVar);
                bv bvVar2 = null;
                com.anythink.core.common.h.c cVarA = bwVarA != null ? bwVarA.a((com.anythink.core.common.h.ad) null).a() : null;
                if (cVarA != null) {
                    bvVar.a(cVarA.e().getUnitGroupInfo(), 0, 3, 1);
                    p.a(bvVar);
                    bvVar.toString();
                    bvVar2 = bvVar;
                }
                if (bvVar2 == null) {
                    try {
                        com.anythink.core.common.h.ad adVarA = com.anythink.core.b.f.a().a(strAI, bvVar);
                        if (adVarA != null && !adVarA.a()) {
                            bvVar.a(adVarA, 0, 2, 1);
                            bvVar2 = bvVar;
                        } else if (adVarA != null) {
                            com.anythink.core.b.d.c.a(adVarA, new aw(1, bvVar, nVar), true, 25);
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (bvVar2 != null) {
                    try {
                        if (bvVar.q() == 7) {
                            z = true;
                        }
                        list2.remove(size);
                        p.a(list, bvVar);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        if (z) {
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                if (list2.get(size2).q() == 7) {
                    list2.remove(size2);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:106:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:113:0x031d  */
    /* JADX WARN: Code duplicated, block: B:115:0x032b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0349  */
    /* JADX WARN: Code duplicated, block: B:117:0x034b  */
    /* JADX WARN: Code duplicated, block: B:120:0x036f  */
    /* JADX WARN: Code duplicated, block: B:122:0x037e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0396  */
    /* JADX WARN: Code duplicated, block: B:125:0x039f  */
    /* JADX WARN: Code duplicated, block: B:127:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:128:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:130:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:132:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:134:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:136:0x03da  */
    /* JADX WARN: Code duplicated, block: B:137:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:139:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:148:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00de  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:46:0x010b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0124  */
    /* JADX WARN: Code duplicated, block: B:50:0x0144  */
    /* JADX WARN: Code duplicated, block: B:55:0x0172  */
    /* JADX WARN: Code duplicated, block: B:57:0x0180  */
    /* JADX WARN: Code duplicated, block: B:59:0x0195  */
    /* JADX WARN: Code duplicated, block: B:60:0x0197  */
    /* JADX WARN: Code duplicated, block: B:61:0x019a  */
    /* JADX WARN: Code duplicated, block: B:62:0x019d  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:67:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x01cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:71:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:72:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x01df  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:77:0x0208  */
    /* JADX WARN: Code duplicated, block: B:79:0x0213  */
    /* JADX WARN: Code duplicated, block: B:84:0x0240  */
    /* JADX WARN: Code duplicated, block: B:86:0x024a  */
    /* JADX WARN: Code duplicated, block: B:89:0x0274  */
    /* JADX WARN: Code duplicated, block: B:91:0x027a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0280  */
    /* JADX WARN: Code duplicated, block: B:99:0x02b0  */
    private static void b(com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar, List<bv> list) {
        AdError adErrorA;
        int i;
        List<String> listJ;
        int iA;
        int iA2;
        List<String> listM;
        List<String> listN;
        int iA3;
        com.anythink.core.common.h.k kVarA;
        com.anythink.core.common.w.a.b.c cVar;
        boolean z;
        com.anythink.core.common.h.aj ajVarA;
        int i2;
        String str;
        String str2;
        AdError adErrorB;
        String desc;
        boolean z2;
        com.anythink.core.common.h.i iVarC;
        Boolean boolB;
        int i3;
        int i4;
        String code;
        Iterator<bv> it = list.iterator();
        while (it.hasNext()) {
            bv next = it.next();
            int iU = nVar.U();
            com.anythink.core.common.h.n nVarAf = nVar.af();
            String strAI = nVar.aI();
            byte b2 = 0;
            aj.a(nVarAf, next, 0, false);
            bo.a aVarA = com.anythink.core.a.a.a(com.anythink.core.common.d.t.b().g()).a(strAI, next.z(), lVar.aq());
            int i5 = aVarA != null ? aVarA.e : 0;
            int i6 = aVarA != null ? aVarA.d : 0;
            Context contextG = com.anythink.core.common.d.t.b().g();
            Pair<Integer, List<String>> pairI = com.anythink.core.common.d.t.b().I();
            if (pairI != null && ((Integer) pairI.first).intValue() == 1) {
                List list2 = (List) pairI.second;
                if (list2 != null && !list2.isEmpty()) {
                    if (list2.contains(String.valueOf(next.g()))) {
                        next.h("Filter ad source loading for specified channel id on risky devices.");
                        ab.a(strAI, nVar, "Filter ad source loading for specified channel id on risky devices.", next, i5, i6, list2);
                        com.anythink.core.common.u.e.a(nVarAf, 28, ErrorCode.getErrorCode(ErrorCode.adSourceLoadRiskError, "", "Filter ad source loading for specified channel id on risky devices."));
                    } else {
                        adErrorA = a(1, nVarAf, next, (com.anythink.core.common.h.z) null);
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
                            next.h(adErrorA.getPlatformMSG());
                            ab.a(strAI, nVar, adErrorA.getPlatformMSG(), next, i5, i6);
                            com.anythink.core.common.u.e.a(nVarAf, i, adErrorA);
                        } else {
                            listJ = com.anythink.core.common.d.t.b().J();
                            com.anythink.core.common.d.t.b();
                            if (com.anythink.core.common.d.t.a(listJ, String.valueOf(next.g()))) {
                                next.h("Forbid network by developer");
                                ab.a(strAI, nVar, "Forbid network by developer", next, i5, i6, listJ);
                                com.anythink.core.common.u.e.a(nVarAf, 14, ErrorCode.getErrorCode(ErrorCode.forbidNetworkByDeveloper, "", "Forbid network by developer"));
                            } else if (!ak.b(next)) {
                                iA = com.anythink.core.a.a.a(contextG).a(strAI, next, lVar.aq());
                                if (iA != -1) {
                                    next.g(-5);
                                    next.h("Out of Cap");
                                    ab.a(strAI, nVar, "Out of Cap", next, i5, i6);
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
                                    com.anythink.core.common.u.e.a(nVarAf, i4, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
                                } else {
                                    com.anythink.core.a.d.a();
                                    iA2 = com.anythink.core.a.d.a(strAI, next);
                                    if (iA2 != -1) {
                                        next.g(-6);
                                        next.h("Out of Pacing");
                                        ab.a(strAI, nVar, "Out of Pacing", next, i5, i6);
                                        if (iA2 == 12) {
                                            i3 = 23;
                                        } else if (iA2 != 13) {
                                            i3 = 3;
                                        } else {
                                            i3 = 24;
                                        }
                                        com.anythink.core.common.u.e.a(nVarAf, i3, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
                                    } else if (com.anythink.core.common.c.a().a(next)) {
                                        next.g(-6);
                                        next.h("Request fail in pacing");
                                        ab.a(strAI, nVar, "Request fail in pacing", next, i5, i6);
                                        com.anythink.core.common.u.e.a(nVarAf, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
                                    } else {
                                        listM = com.anythink.core.common.d.t.b().m(strAI);
                                        if (listM == null) {
                                            listN = com.anythink.core.common.d.t.b().n(strAI);
                                            if (listN == null) {
                                                if (next.o()) {
                                                    if (ak.b(next)) {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.ad() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
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
                                                                                next.h(str4);
                                                                                ab.a(strAI, nVar, str4, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str3, str3, str4));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr2 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str5 = str;
                                                                                String str6 = str2;
                                                                                next.h(str6);
                                                                                ab.a(strAI, nVar, str6, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str5, str5, str6));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        } else {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr3 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str7 = str;
                                                                                String str8 = str2;
                                                                                next.h(str8);
                                                                                ab.a(strAI, nVar, str8, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str7, str7, str8));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr4 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str9 = str;
                                                                                String str10 = str2;
                                                                                next.h(str10);
                                                                                ab.a(strAI, nVar, str10, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str9, str9, str10));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.ad() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr5 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11 = str;
                                                                                String str12 = str2;
                                                                                next.h(str12);
                                                                                ab.a(strAI, nVar, str12, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11, str11, str12));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr6 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str13 = str;
                                                                                String str14 = str2;
                                                                                next.h(str14);
                                                                                ab.a(strAI, nVar, str14, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str13, str13, str14));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        } else {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr7 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str15 = str;
                                                                                String str16 = str2;
                                                                                next.h(str16);
                                                                                ab.a(strAI, nVar, str16, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str15, str15, str16));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr8 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str17 = str;
                                                                                String str18 = str2;
                                                                                next.h(str18);
                                                                                ab.a(strAI, nVar, str18, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str17, str17, str18));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        }
                                                    }
                                                    z = true;
                                                } else {
                                                    if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                        next.g(-8);
                                                        next.h("Error Code Request fail in pacing");
                                                        ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                    } else if (iU == 0) {
                                                        iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                        if (iA3 != -1) {
                                                            next.h("The adSource load too many times within the specified time period.");
                                                            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                next.h(desc);
                                                                ab.a(strAI, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                if (cVar != null) {
                                                                    ajVarA = cVar.a(next);
                                                                    Object[] objArr9 = new Object[1];
                                                                    if (ajVarA != null) {
                                                                        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                            i2 = 16;
                                                                            str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                            str2 = "AD platform's error code strategy limit1";
                                                                        } else {
                                                                            i2 = 17;
                                                                            str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                            str2 = "AD platform's error code strategy limit2";
                                                                        }
                                                                        String str19 = str;
                                                                        String str110 = str2;
                                                                        next.h(str110);
                                                                        ab.a(strAI, nVar, str110, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str19, str19, str110));
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                        if (iA3 != -1) {
                                                            next.h("The adSource load too many times within the specified time period.");
                                                            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                next.h(desc);
                                                                ab.a(strAI, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                if (cVar != null) {
                                                                    ajVarA = cVar.a(next);
                                                                    Object[] objArr10 = new Object[1];
                                                                    if (ajVarA != null) {
                                                                        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                            i2 = 16;
                                                                            str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                            str2 = "AD platform's error code strategy limit1";
                                                                        } else {
                                                                            i2 = 17;
                                                                            str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                            str2 = "AD platform's error code strategy limit2";
                                                                        }
                                                                        String str111 = str;
                                                                        String str112 = str2;
                                                                        next.h(str112);
                                                                        ab.a(strAI, nVar, str112, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111, str111, str112));
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    z = true;
                                                }
                                            } else if (next.o()) {
                                                if (ak.b(next)) {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.ad() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str113 = str;
                                                                            String str114 = str2;
                                                                            next.h(str114);
                                                                            ab.a(strAI, nVar, str114, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str113, str113, str114));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr12 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str115 = str;
                                                                            String str116 = str2;
                                                                            next.h(str116);
                                                                            ab.a(strAI, nVar, str116, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str115, str115, str116));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    } else {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr13 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str117 = str;
                                                                            String str118 = str2;
                                                                            next.h(str118);
                                                                            ab.a(strAI, nVar, str118, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str117, str117, str118));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr14 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str119 = str;
                                                                            String str1110 = str2;
                                                                            next.h(str1110);
                                                                            ab.a(strAI, nVar, str1110, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str119, str119, str1110));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                } else {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.ad() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr15 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111 = str;
                                                                            String str1112 = str2;
                                                                            next.h(str1112);
                                                                            ab.a(strAI, nVar, str1112, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111, str1111, str1112));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr16 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1113 = str;
                                                                            String str1114 = str2;
                                                                            next.h(str1114);
                                                                            ab.a(strAI, nVar, str1114, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1113, str1113, str1114));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    } else {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr17 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1115 = str;
                                                                            String str1116 = str2;
                                                                            next.h(str1116);
                                                                            ab.a(strAI, nVar, str1116, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1115, str1115, str1116));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr18 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1117 = str;
                                                                            String str1118 = str2;
                                                                            next.h(str1118);
                                                                            ab.a(strAI, nVar, str1118, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1117, str1117, str1118));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                }
                                                z = true;
                                            } else {
                                                if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                    next.g(-8);
                                                    next.h("Error Code Request fail in pacing");
                                                    ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                    com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                } else if (iU == 0) {
                                                    iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                    if (iA3 != -1) {
                                                        next.h("The adSource load too many times within the specified time period.");
                                                        ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                            next.h(desc);
                                                            ab.a(strAI, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                            if (cVar != null) {
                                                                ajVarA = cVar.a(next);
                                                                Object[] objArr19 = new Object[1];
                                                                if (ajVarA != null) {
                                                                    if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                        i2 = 16;
                                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                        str2 = "AD platform's error code strategy limit1";
                                                                    } else {
                                                                        i2 = 17;
                                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                        str2 = "AD platform's error code strategy limit2";
                                                                    }
                                                                    String str1119 = str;
                                                                    String str11110 = str2;
                                                                    next.h(str11110);
                                                                    ab.a(strAI, nVar, str11110, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1119, str1119, str11110));
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            } else {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                    if (iA3 != -1) {
                                                        next.h("The adSource load too many times within the specified time period.");
                                                        ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                            next.h(desc);
                                                            ab.a(strAI, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                            if (cVar != null) {
                                                                ajVarA = cVar.a(next);
                                                                Object[] objArr110 = new Object[1];
                                                                if (ajVarA != null) {
                                                                    if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                        i2 = 16;
                                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                        str2 = "AD platform's error code strategy limit1";
                                                                    } else {
                                                                        i2 = 17;
                                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                        str2 = "AD platform's error code strategy limit2";
                                                                    }
                                                                    String str11111 = str;
                                                                    String str11112 = str2;
                                                                    next.h(str11112);
                                                                    ab.a(strAI, nVar, str11112, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111, str11111, str11112));
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            } else {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                }
                                                z = true;
                                            }
                                        } else {
                                            listN = com.anythink.core.common.d.t.b().n(strAI);
                                            if (listN == null) {
                                                if (next.o()) {
                                                    if (ak.b(next)) {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.ad() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr111 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11113 = str;
                                                                                String str11114 = str2;
                                                                                next.h(str11114);
                                                                                ab.a(strAI, nVar, str11114, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11113, str11113, str11114));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr112 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11115 = str;
                                                                                String str11116 = str2;
                                                                                next.h(str11116);
                                                                                ab.a(strAI, nVar, str11116, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11115, str11115, str11116));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        } else {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr113 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11117 = str;
                                                                                String str11118 = str2;
                                                                                next.h(str11118);
                                                                                ab.a(strAI, nVar, str11118, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11117, str11117, str11118));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr114 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11119 = str;
                                                                                String str111110 = str2;
                                                                                next.h(str111110);
                                                                                ab.a(strAI, nVar, str111110, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11119, str11119, str111110));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.ad() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr115 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str111111 = str;
                                                                                String str111112 = str2;
                                                                                next.h(str111112);
                                                                                ab.a(strAI, nVar, str111112, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111, str111111, str111112));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr116 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str111113 = str;
                                                                                String str111114 = str2;
                                                                                next.h(str111114);
                                                                                ab.a(strAI, nVar, str111114, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111113, str111113, str111114));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        } else {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr117 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str111115 = str;
                                                                                String str111116 = str2;
                                                                                next.h(str111116);
                                                                                ab.a(strAI, nVar, str111116, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111115, str111115, str111116));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr118 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str111117 = str;
                                                                                String str111118 = str2;
                                                                                next.h(str111118);
                                                                                ab.a(strAI, nVar, str111118, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111117, str111117, str111118));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        }
                                                    }
                                                    z = true;
                                                } else {
                                                    if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                        next.g(-8);
                                                        next.h("Error Code Request fail in pacing");
                                                        ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                    } else if (iU == 0) {
                                                        iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                        if (iA3 != -1) {
                                                            next.h("The adSource load too many times within the specified time period.");
                                                            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                next.h(desc);
                                                                ab.a(strAI, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                if (cVar != null) {
                                                                    ajVarA = cVar.a(next);
                                                                    Object[] objArr119 = new Object[1];
                                                                    if (ajVarA != null) {
                                                                        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                            i2 = 16;
                                                                            str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                            str2 = "AD platform's error code strategy limit1";
                                                                        } else {
                                                                            i2 = 17;
                                                                            str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                            str2 = "AD platform's error code strategy limit2";
                                                                        }
                                                                        String str111119 = str;
                                                                        String str1111110 = str2;
                                                                        next.h(str1111110);
                                                                        ab.a(strAI, nVar, str1111110, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111119, str111119, str1111110));
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                        if (iA3 != -1) {
                                                            next.h("The adSource load too many times within the specified time period.");
                                                            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                next.h(desc);
                                                                ab.a(strAI, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                if (cVar != null) {
                                                                    ajVarA = cVar.a(next);
                                                                    Object[] objArr1110 = new Object[1];
                                                                    if (ajVarA != null) {
                                                                        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                            i2 = 16;
                                                                            str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                            str2 = "AD platform's error code strategy limit1";
                                                                        } else {
                                                                            i2 = 17;
                                                                            str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                            str2 = "AD platform's error code strategy limit2";
                                                                        }
                                                                        String str1111111 = str;
                                                                        String str1111112 = str2;
                                                                        next.h(str1111112);
                                                                        ab.a(strAI, nVar, str1111112, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111, str1111111, str1111112));
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    z = true;
                                                }
                                            } else if (next.o()) {
                                                if (ak.b(next)) {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.ad() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr1111 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111113 = str;
                                                                            String str1111114 = str2;
                                                                            next.h(str1111114);
                                                                            ab.a(strAI, nVar, str1111114, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111113, str1111113, str1111114));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr1112 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111115 = str;
                                                                            String str1111116 = str2;
                                                                            next.h(str1111116);
                                                                            ab.a(strAI, nVar, str1111116, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111115, str1111115, str1111116));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    } else {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr1113 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111117 = str;
                                                                            String str1111118 = str2;
                                                                            next.h(str1111118);
                                                                            ab.a(strAI, nVar, str1111118, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111117, str1111117, str1111118));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr1114 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111119 = str;
                                                                            String str11111110 = str2;
                                                                            next.h(str11111110);
                                                                            ab.a(strAI, nVar, str11111110, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111119, str1111119, str11111110));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                } else {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.ad() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr1115 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str11111111 = str;
                                                                            String str11111112 = str2;
                                                                            next.h(str11111112);
                                                                            ab.a(strAI, nVar, str11111112, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111, str11111111, str11111112));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr1116 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str11111113 = str;
                                                                            String str11111114 = str2;
                                                                            next.h(str11111114);
                                                                            ab.a(strAI, nVar, str11111114, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111113, str11111113, str11111114));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    } else {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr1117 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str11111115 = str;
                                                                            String str11111116 = str2;
                                                                            next.h(str11111116);
                                                                            ab.a(strAI, nVar, str11111116, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111115, str11111115, str11111116));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr1118 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str11111117 = str;
                                                                            String str11111118 = str2;
                                                                            next.h(str11111118);
                                                                            ab.a(strAI, nVar, str11111118, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111117, str11111117, str11111118));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                }
                                                z = true;
                                            } else {
                                                if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                    next.g(-8);
                                                    next.h("Error Code Request fail in pacing");
                                                    ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                    com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                } else if (iU == 0) {
                                                    iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                    if (iA3 != -1) {
                                                        next.h("The adSource load too many times within the specified time period.");
                                                        ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                            next.h(desc);
                                                            ab.a(strAI, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                            if (cVar != null) {
                                                                ajVarA = cVar.a(next);
                                                                Object[] objArr1119 = new Object[1];
                                                                if (ajVarA != null) {
                                                                    if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                        i2 = 16;
                                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                        str2 = "AD platform's error code strategy limit1";
                                                                    } else {
                                                                        i2 = 17;
                                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                        str2 = "AD platform's error code strategy limit2";
                                                                    }
                                                                    String str11111119 = str;
                                                                    String str111111110 = str2;
                                                                    next.h(str111111110);
                                                                    ab.a(strAI, nVar, str111111110, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111119, str11111119, str111111110));
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            } else {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                    if (iA3 != -1) {
                                                        next.h("The adSource load too many times within the specified time period.");
                                                        ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                            next.h(desc);
                                                            ab.a(strAI, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                            if (cVar != null) {
                                                                ajVarA = cVar.a(next);
                                                                Object[] objArr11110 = new Object[1];
                                                                if (ajVarA != null) {
                                                                    if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                        i2 = 16;
                                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                        str2 = "AD platform's error code strategy limit1";
                                                                    } else {
                                                                        i2 = 17;
                                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                        str2 = "AD platform's error code strategy limit2";
                                                                    }
                                                                    String str111111111 = str;
                                                                    String str111111112 = str2;
                                                                    next.h(str111111112);
                                                                    ab.a(strAI, nVar, str111111112, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111, str111111111, str111111112));
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            } else {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                }
                                                z = true;
                                            }
                                        }
                                    }
                                }
                            } else {
                                iA = com.anythink.core.a.a.a(contextG).a(strAI, next, lVar.aq());
                                if (iA != -1) {
                                    next.g(-5);
                                    next.h("Out of Cap");
                                    ab.a(strAI, nVar, "Out of Cap", next, i5, i6);
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
                                    com.anythink.core.common.u.e.a(nVarAf, i4, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
                                } else {
                                    com.anythink.core.a.d.a();
                                    iA2 = com.anythink.core.a.d.a(strAI, next);
                                    if (iA2 != -1) {
                                        next.g(-6);
                                        next.h("Out of Pacing");
                                        ab.a(strAI, nVar, "Out of Pacing", next, i5, i6);
                                        if (iA2 == 12) {
                                            i3 = 23;
                                        } else if (iA2 != 13) {
                                            i3 = 3;
                                        } else {
                                            i3 = 24;
                                        }
                                        com.anythink.core.common.u.e.a(nVarAf, i3, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
                                    } else if (com.anythink.core.common.c.a().a(next)) {
                                        next.g(-6);
                                        next.h("Request fail in pacing");
                                        ab.a(strAI, nVar, "Request fail in pacing", next, i5, i6);
                                        com.anythink.core.common.u.e.a(nVarAf, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
                                    } else {
                                        listM = com.anythink.core.common.d.t.b().m(strAI);
                                        if (listM == null) {
                                            listN = com.anythink.core.common.d.t.b().n(strAI);
                                            if (listN == null) {
                                                if (next.o()) {
                                                    if (ak.b(next)) {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.ad() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr11111 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str111111113 = str;
                                                                                String str111111114 = str2;
                                                                                next.h(str111111114);
                                                                                ab.a(strAI, nVar, str111111114, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111113, str111111113, str111111114));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr11112 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str111111115 = str;
                                                                                String str111111116 = str2;
                                                                                next.h(str111111116);
                                                                                ab.a(strAI, nVar, str111111116, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111115, str111111115, str111111116));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        } else {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr11113 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str111111117 = str;
                                                                                String str111111118 = str2;
                                                                                next.h(str111111118);
                                                                                ab.a(strAI, nVar, str111111118, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111117, str111111117, str111111118));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr11114 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str111111119 = str;
                                                                                String str1111111110 = str2;
                                                                                next.h(str1111111110);
                                                                                ab.a(strAI, nVar, str1111111110, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111119, str111111119, str1111111110));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.ad() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr11115 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str1111111111 = str;
                                                                                String str1111111112 = str2;
                                                                                next.h(str1111111112);
                                                                                ab.a(strAI, nVar, str1111111112, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111, str1111111111, str1111111112));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr11116 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str1111111113 = str;
                                                                                String str1111111114 = str2;
                                                                                next.h(str1111111114);
                                                                                ab.a(strAI, nVar, str1111111114, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111113, str1111111113, str1111111114));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        } else {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr11117 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str1111111115 = str;
                                                                                String str1111111116 = str2;
                                                                                next.h(str1111111116);
                                                                                ab.a(strAI, nVar, str1111111116, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111115, str1111111115, str1111111116));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr11118 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str1111111117 = str;
                                                                                String str1111111118 = str2;
                                                                                next.h(str1111111118);
                                                                                ab.a(strAI, nVar, str1111111118, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111117, str1111111117, str1111111118));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        }
                                                    }
                                                    z = true;
                                                } else {
                                                    if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                        next.g(-8);
                                                        next.h("Error Code Request fail in pacing");
                                                        ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                    } else if (iU == 0) {
                                                        iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                        if (iA3 != -1) {
                                                            next.h("The adSource load too many times within the specified time period.");
                                                            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                next.h(desc);
                                                                ab.a(strAI, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                if (cVar != null) {
                                                                    ajVarA = cVar.a(next);
                                                                    Object[] objArr11119 = new Object[1];
                                                                    if (ajVarA != null) {
                                                                        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                            i2 = 16;
                                                                            str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                            str2 = "AD platform's error code strategy limit1";
                                                                        } else {
                                                                            i2 = 17;
                                                                            str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                            str2 = "AD platform's error code strategy limit2";
                                                                        }
                                                                        String str1111111119 = str;
                                                                        String str11111111110 = str2;
                                                                        next.h(str11111111110);
                                                                        ab.a(strAI, nVar, str11111111110, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111119, str1111111119, str11111111110));
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                        if (iA3 != -1) {
                                                            next.h("The adSource load too many times within the specified time period.");
                                                            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                next.h(desc);
                                                                ab.a(strAI, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                if (cVar != null) {
                                                                    ajVarA = cVar.a(next);
                                                                    Object[] objArr111110 = new Object[1];
                                                                    if (ajVarA != null) {
                                                                        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                            i2 = 16;
                                                                            str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                            str2 = "AD platform's error code strategy limit1";
                                                                        } else {
                                                                            i2 = 17;
                                                                            str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                            str2 = "AD platform's error code strategy limit2";
                                                                        }
                                                                        String str11111111111 = str;
                                                                        String str11111111112 = str2;
                                                                        next.h(str11111111112);
                                                                        ab.a(strAI, nVar, str11111111112, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111, str11111111111, str11111111112));
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    z = true;
                                                }
                                            } else if (next.o()) {
                                                if (ak.b(next)) {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.ad() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr111111 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str11111111113 = str;
                                                                            String str11111111114 = str2;
                                                                            next.h(str11111111114);
                                                                            ab.a(strAI, nVar, str11111111114, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111113, str11111111113, str11111111114));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr111112 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str11111111115 = str;
                                                                            String str11111111116 = str2;
                                                                            next.h(str11111111116);
                                                                            ab.a(strAI, nVar, str11111111116, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111115, str11111111115, str11111111116));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    } else {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr111113 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str11111111117 = str;
                                                                            String str11111111118 = str2;
                                                                            next.h(str11111111118);
                                                                            ab.a(strAI, nVar, str11111111118, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111117, str11111111117, str11111111118));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr111114 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str11111111119 = str;
                                                                            String str111111111110 = str2;
                                                                            next.h(str111111111110);
                                                                            ab.a(strAI, nVar, str111111111110, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111119, str11111111119, str111111111110));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                } else {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.ad() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr111115 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str111111111111 = str;
                                                                            String str111111111112 = str2;
                                                                            next.h(str111111111112);
                                                                            ab.a(strAI, nVar, str111111111112, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111111, str111111111111, str111111111112));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr111116 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str111111111113 = str;
                                                                            String str111111111114 = str2;
                                                                            next.h(str111111111114);
                                                                            ab.a(strAI, nVar, str111111111114, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111113, str111111111113, str111111111114));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    } else {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr111117 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str111111111115 = str;
                                                                            String str111111111116 = str2;
                                                                            next.h(str111111111116);
                                                                            ab.a(strAI, nVar, str111111111116, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111115, str111111111115, str111111111116));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr111118 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str111111111117 = str;
                                                                            String str111111111118 = str2;
                                                                            next.h(str111111111118);
                                                                            ab.a(strAI, nVar, str111111111118, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111117, str111111111117, str111111111118));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                }
                                                z = true;
                                            } else {
                                                if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                    next.g(-8);
                                                    next.h("Error Code Request fail in pacing");
                                                    ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                    com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                } else if (iU == 0) {
                                                    iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                    if (iA3 != -1) {
                                                        next.h("The adSource load too many times within the specified time period.");
                                                        ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                            next.h(desc);
                                                            ab.a(strAI, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                            if (cVar != null) {
                                                                ajVarA = cVar.a(next);
                                                                Object[] objArr111119 = new Object[1];
                                                                if (ajVarA != null) {
                                                                    if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                        i2 = 16;
                                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                        str2 = "AD platform's error code strategy limit1";
                                                                    } else {
                                                                        i2 = 17;
                                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                        str2 = "AD platform's error code strategy limit2";
                                                                    }
                                                                    String str111111111119 = str;
                                                                    String str1111111111110 = str2;
                                                                    next.h(str1111111111110);
                                                                    ab.a(strAI, nVar, str1111111111110, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111119, str111111111119, str1111111111110));
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            } else {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                    if (iA3 != -1) {
                                                        next.h("The adSource load too many times within the specified time period.");
                                                        ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                            next.h(desc);
                                                            ab.a(strAI, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                            if (cVar != null) {
                                                                ajVarA = cVar.a(next);
                                                                Object[] objArr1111110 = new Object[1];
                                                                if (ajVarA != null) {
                                                                    if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                        i2 = 16;
                                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                        str2 = "AD platform's error code strategy limit1";
                                                                    } else {
                                                                        i2 = 17;
                                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                        str2 = "AD platform's error code strategy limit2";
                                                                    }
                                                                    String str1111111111111 = str;
                                                                    String str1111111111112 = str2;
                                                                    next.h(str1111111111112);
                                                                    ab.a(strAI, nVar, str1111111111112, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111111, str1111111111111, str1111111111112));
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            } else {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                }
                                                z = true;
                                            }
                                        } else {
                                            listN = com.anythink.core.common.d.t.b().n(strAI);
                                            if (listN == null) {
                                                if (next.o()) {
                                                    if (ak.b(next)) {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.ad() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr1111111 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str1111111111113 = str;
                                                                                String str1111111111114 = str2;
                                                                                next.h(str1111111111114);
                                                                                ab.a(strAI, nVar, str1111111111114, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111113, str1111111111113, str1111111111114));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr1111112 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str1111111111115 = str;
                                                                                String str1111111111116 = str2;
                                                                                next.h(str1111111111116);
                                                                                ab.a(strAI, nVar, str1111111111116, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111115, str1111111111115, str1111111111116));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        } else {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr1111113 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str1111111111117 = str;
                                                                                String str1111111111118 = str2;
                                                                                next.h(str1111111111118);
                                                                                ab.a(strAI, nVar, str1111111111118, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111117, str1111111111117, str1111111111118));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr1111114 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str1111111111119 = str;
                                                                                String str11111111111110 = str2;
                                                                                next.h(str11111111111110);
                                                                                ab.a(strAI, nVar, str11111111111110, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111119, str1111111111119, str11111111111110));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        if (!z2) {
                                                        }
                                                        if (next.ad() == 1) {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr1111115 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11111111111111 = str;
                                                                                String str11111111111112 = str2;
                                                                                next.h(str11111111111112);
                                                                                ab.a(strAI, nVar, str11111111111112, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111111, str11111111111111, str11111111111112));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr1111116 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11111111111113 = str;
                                                                                String str11111111111114 = str2;
                                                                                next.h(str11111111111114);
                                                                                ab.a(strAI, nVar, str11111111111114, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111113, str11111111111113, str11111111111114));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        } else {
                                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                                next.g(-8);
                                                                next.h("Error Code Request fail in pacing");
                                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                            } else if (iU == 0) {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr1111117 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11111111111115 = str;
                                                                                String str11111111111116 = str2;
                                                                                next.h(str11111111111116);
                                                                                ab.a(strAI, nVar, str11111111111116, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111115, str11111111111115, str11111111111116));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                                if (iA3 != -1) {
                                                                    next.h("The adSource load too many times within the specified time period.");
                                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                        next.h(desc);
                                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                    } else {
                                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                        if (cVar != null) {
                                                                            ajVarA = cVar.a(next);
                                                                            Object[] objArr1111118 = new Object[1];
                                                                            if (ajVarA != null) {
                                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                    i2 = 16;
                                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                    str2 = "AD platform's error code strategy limit1";
                                                                                } else {
                                                                                    i2 = 17;
                                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                    str2 = "AD platform's error code strategy limit2";
                                                                                }
                                                                                String str11111111111117 = str;
                                                                                String str11111111111118 = str2;
                                                                                next.h(str11111111111118);
                                                                                ab.a(strAI, nVar, str11111111111118, next, i5, i6);
                                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111117, str11111111111117, str11111111111118));
                                                                                z = true;
                                                                            } else {
                                                                                z = false;
                                                                            }
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z = true;
                                                        }
                                                    }
                                                    z = true;
                                                } else {
                                                    if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                        next.g(-8);
                                                        next.h("Error Code Request fail in pacing");
                                                        ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                    } else if (iU == 0) {
                                                        iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                        if (iA3 != -1) {
                                                            next.h("The adSource load too many times within the specified time period.");
                                                            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                next.h(desc);
                                                                ab.a(strAI, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                if (cVar != null) {
                                                                    ajVarA = cVar.a(next);
                                                                    Object[] objArr1111119 = new Object[1];
                                                                    if (ajVarA != null) {
                                                                        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                            i2 = 16;
                                                                            str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                            str2 = "AD platform's error code strategy limit1";
                                                                        } else {
                                                                            i2 = 17;
                                                                            str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                            str2 = "AD platform's error code strategy limit2";
                                                                        }
                                                                        String str11111111111119 = str;
                                                                        String str111111111111110 = str2;
                                                                        next.h(str111111111111110);
                                                                        ab.a(strAI, nVar, str111111111111110, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111119, str11111111111119, str111111111111110));
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                        if (iA3 != -1) {
                                                            next.h("The adSource load too many times within the specified time period.");
                                                            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                next.h(desc);
                                                                ab.a(strAI, nVar, desc, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                            } else {
                                                                cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                if (cVar != null) {
                                                                    ajVarA = cVar.a(next);
                                                                    Object[] objArr11111110 = new Object[1];
                                                                    if (ajVarA != null) {
                                                                        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                            i2 = 16;
                                                                            str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                            str2 = "AD platform's error code strategy limit1";
                                                                        } else {
                                                                            i2 = 17;
                                                                            str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                            str2 = "AD platform's error code strategy limit2";
                                                                        }
                                                                        String str111111111111111 = str;
                                                                        String str111111111111112 = str2;
                                                                        next.h(str111111111111112);
                                                                        ab.a(strAI, nVar, str111111111111112, next, i5, i6);
                                                                        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111111111, str111111111111111, str111111111111112));
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    z = true;
                                                }
                                            } else if (next.o()) {
                                                if (ak.b(next)) {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.ad() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11111111 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str111111111111113 = str;
                                                                            String str111111111111114 = str2;
                                                                            next.h(str111111111111114);
                                                                            ab.a(strAI, nVar, str111111111111114, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111111113, str111111111111113, str111111111111114));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11111112 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str111111111111115 = str;
                                                                            String str111111111111116 = str2;
                                                                            next.h(str111111111111116);
                                                                            ab.a(strAI, nVar, str111111111111116, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111111115, str111111111111115, str111111111111116));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    } else {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11111113 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str111111111111117 = str;
                                                                            String str111111111111118 = str2;
                                                                            next.h(str111111111111118);
                                                                            ab.a(strAI, nVar, str111111111111118, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111111117, str111111111111117, str111111111111118));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11111114 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str111111111111119 = str;
                                                                            String str1111111111111110 = str2;
                                                                            next.h(str1111111111111110);
                                                                            ab.a(strAI, nVar, str1111111111111110, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str111111111111119, str111111111111119, str1111111111111110));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                } else {
                                                    z2 = true;
                                                    if (!z2) {
                                                    }
                                                    if (next.ad() == 1) {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11111115 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111111111111111 = str;
                                                                            String str1111111111111112 = str2;
                                                                            next.h(str1111111111111112);
                                                                            ab.a(strAI, nVar, str1111111111111112, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111111111, str1111111111111111, str1111111111111112));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11111116 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111111111111113 = str;
                                                                            String str1111111111111114 = str2;
                                                                            next.h(str1111111111111114);
                                                                            ab.a(strAI, nVar, str1111111111111114, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111111113, str1111111111111113, str1111111111111114));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    } else {
                                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                            next.g(-8);
                                                            next.h("Error Code Request fail in pacing");
                                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                        } else if (iU == 0) {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11111117 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111111111111115 = str;
                                                                            String str1111111111111116 = str2;
                                                                            next.h(str1111111111111116);
                                                                            ab.a(strAI, nVar, str1111111111111116, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111111115, str1111111111111115, str1111111111111116));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                            if (iA3 != -1) {
                                                                next.h("The adSource load too many times within the specified time period.");
                                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                                    next.h(desc);
                                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                                } else {
                                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                                    if (cVar != null) {
                                                                        ajVarA = cVar.a(next);
                                                                        Object[] objArr11111118 = new Object[1];
                                                                        if (ajVarA != null) {
                                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                                i2 = 16;
                                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                                str2 = "AD platform's error code strategy limit1";
                                                                            } else {
                                                                                i2 = 17;
                                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                                str2 = "AD platform's error code strategy limit2";
                                                                            }
                                                                            String str1111111111111117 = str;
                                                                            String str1111111111111118 = str2;
                                                                            next.h(str1111111111111118);
                                                                            ab.a(strAI, nVar, str1111111111111118, next, i5, i6);
                                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111111117, str1111111111111117, str1111111111111118));
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                }
                                                z = true;
                                            } else {
                                                if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                    next.g(-8);
                                                    next.h("Error Code Request fail in pacing");
                                                    ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                    com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                                } else if (iU == 0) {
                                                    iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                    if (iA3 != -1) {
                                                        next.h("The adSource load too many times within the specified time period.");
                                                        ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                            next.h(desc);
                                                            ab.a(strAI, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                            if (cVar != null) {
                                                                ajVarA = cVar.a(next);
                                                                Object[] objArr11111119 = new Object[1];
                                                                if (ajVarA != null) {
                                                                    if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                        i2 = 16;
                                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                        str2 = "AD platform's error code strategy limit1";
                                                                    } else {
                                                                        i2 = 17;
                                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                        str2 = "AD platform's error code strategy limit2";
                                                                    }
                                                                    String str1111111111111119 = str;
                                                                    String str11111111111111110 = str2;
                                                                    next.h(str11111111111111110);
                                                                    ab.a(strAI, nVar, str11111111111111110, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str1111111111111119, str1111111111111119, str11111111111111110));
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            } else {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                    if (iA3 != -1) {
                                                        next.h("The adSource load too many times within the specified time period.");
                                                        ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                            next.h(desc);
                                                            ab.a(strAI, nVar, desc, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                        } else {
                                                            cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                            if (cVar != null) {
                                                                ajVarA = cVar.a(next);
                                                                Object[] objArr111111110 = new Object[1];
                                                                if (ajVarA != null) {
                                                                    if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                        i2 = 16;
                                                                        str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                        str2 = "AD platform's error code strategy limit1";
                                                                    } else {
                                                                        i2 = 17;
                                                                        str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                        str2 = "AD platform's error code strategy limit2";
                                                                    }
                                                                    String str11111111111111111 = str;
                                                                    String str11111111111111112 = str2;
                                                                    next.h(str11111111111111112);
                                                                    ab.a(strAI, nVar, str11111111111111112, next, i5, i6);
                                                                    com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111111111, str11111111111111111, str11111111111111112));
                                                                    z = true;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            } else {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                }
                                                z = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    next.h("Filter ad source loading across all channels on risky devices.");
                    ab.a(strAI, nVar, "Filter ad source loading across all channels on risky devices.", next, i5, i6);
                    com.anythink.core.common.u.e.a(nVarAf, 27, ErrorCode.getErrorCode(ErrorCode.adSourceLoadRiskError, "", "Filter ad source loading across all channels on risky devices."));
                }
                z = true;
            } else {
                adErrorA = a(1, nVarAf, next, (com.anythink.core.common.h.z) null);
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
                    next.h(adErrorA.getPlatformMSG());
                    ab.a(strAI, nVar, adErrorA.getPlatformMSG(), next, i5, i6);
                    com.anythink.core.common.u.e.a(nVarAf, i, adErrorA);
                } else {
                    listJ = com.anythink.core.common.d.t.b().J();
                    com.anythink.core.common.d.t.b();
                    if (com.anythink.core.common.d.t.a(listJ, String.valueOf(next.g()))) {
                        next.h("Forbid network by developer");
                        ab.a(strAI, nVar, "Forbid network by developer", next, i5, i6, listJ);
                        com.anythink.core.common.u.e.a(nVarAf, 14, ErrorCode.getErrorCode(ErrorCode.forbidNetworkByDeveloper, "", "Forbid network by developer"));
                    } else if (!ak.b(next) && com.anythink.core.common.a.i.a(contextG).a(next.z())) {
                        next.h("Adx bid Pacing");
                        ab.a(strAI, nVar, "Adx bid Pacing", next, i5, i6);
                        com.anythink.core.common.u.e.a(nVarAf, 12, ErrorCode.getErrorCode(ErrorCode.inAdxBidInterval, "", "Adx bid Pacing"));
                    } else {
                        iA = com.anythink.core.a.a.a(contextG).a(strAI, next, lVar.aq());
                        if (iA != -1) {
                            next.g(-5);
                            next.h("Out of Cap");
                            ab.a(strAI, nVar, "Out of Cap", next, i5, i6);
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
                            com.anythink.core.common.u.e.a(nVarAf, i4, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
                        } else {
                            com.anythink.core.a.d.a();
                            iA2 = com.anythink.core.a.d.a(strAI, next);
                            if (iA2 != -1) {
                                next.g(-6);
                                next.h("Out of Pacing");
                                ab.a(strAI, nVar, "Out of Pacing", next, i5, i6);
                                if (iA2 == 12) {
                                    i3 = 23;
                                } else if (iA2 != 13) {
                                    i3 = 3;
                                } else {
                                    i3 = 24;
                                }
                                com.anythink.core.common.u.e.a(nVarAf, i3, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
                            } else if (com.anythink.core.common.c.a().a(next)) {
                                next.g(-6);
                                next.h("Request fail in pacing");
                                ab.a(strAI, nVar, "Request fail in pacing", next, i5, i6);
                                com.anythink.core.common.u.e.a(nVarAf, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
                            } else {
                                listM = com.anythink.core.common.d.t.b().m(strAI);
                                if (listM == null && listM.contains(next.z())) {
                                    next.g(-8);
                                    next.h("Request fail in filter list");
                                    ab.a(strAI, nVar, "Request fail in filter list", next, i5, i6, listM);
                                    com.anythink.core.common.u.e.a(nVarAf, 5, ErrorCode.getErrorCode(ErrorCode.filterSourceError, "", "Request fail in filter list"));
                                } else {
                                    listN = com.anythink.core.common.d.t.b().n(strAI);
                                    if (listN == null && listN.contains(String.valueOf(next.g()))) {
                                        next.g(-8);
                                        next.h("Filter by network firm id.");
                                        ab.a(strAI, nVar, "Filter by network firm id.", next, i5, i6, listN);
                                        com.anythink.core.common.u.e.a(nVarAf, 9, ErrorCode.getErrorCode(ErrorCode.networkFirmIdFilterSourceError, "", "Filter by network firm id."));
                                    } else if (next.o()) {
                                        if (ak.b(next) || (boolB = com.anythink.core.common.a.i.a(contextG).b(next.z())) == null) {
                                            z2 = true;
                                        } else if (boolB.booleanValue()) {
                                            next.h("Adx bid fail in pacing");
                                            ab.a(strAI, nVar, "Bid fail in pacing", next, i5, i6);
                                            com.anythink.core.common.u.e.a(nVarAf, 13, ErrorCode.getErrorCode(ErrorCode.inAdxBidFailedInterval, "", "Adx Bid fail in pacing"));
                                        } else {
                                            z2 = false;
                                        }
                                        if (!z2 && com.anythink.core.common.c.a().b(next)) {
                                            next.g(-7);
                                            next.h("Bid fail in pacing");
                                            ab.a(strAI, nVar, "Bid fail in pacing", next, i5, i6);
                                            com.anythink.core.common.u.e.a(nVarAf, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Bid fail in pacing"));
                                        } else if (next.ad() == 1 && next.q() == 2 && (iVarC = com.anythink.core.common.u.a().c(strAI)) != null && iVarC.a(next)) {
                                            next.g(-7);
                                            next.h("Can't Load On Showing");
                                            ab.a(strAI, nVar, "Can't Load On Showing", next, i5, i6);
                                            com.anythink.core.common.u.e.a(nVar, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                                            z = true;
                                        } else {
                                            if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                                next.g(-8);
                                                next.h("Error Code Request fail in pacing");
                                                ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                                com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                            } else if (iU == 0) {
                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                if (iA3 != -1) {
                                                    next.h("The adSource load too many times within the specified time period.");
                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                        next.h(desc);
                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                    } else {
                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                        if (cVar != null) {
                                                            ajVarA = cVar.a(next);
                                                            Object[] objArr111111111 = new Object[1];
                                                            if (ajVarA != null) {
                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                    i2 = 16;
                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                    str2 = "AD platform's error code strategy limit1";
                                                                } else {
                                                                    i2 = 17;
                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                    str2 = "AD platform's error code strategy limit2";
                                                                }
                                                                String str11111111111111113 = str;
                                                                String str11111111111111114 = str2;
                                                                next.h(str11111111111111114);
                                                                ab.a(strAI, nVar, str11111111111111114, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111111113, str11111111111111113, str11111111111111114));
                                                                z = true;
                                                            } else {
                                                                z = false;
                                                            }
                                                        } else {
                                                            z = false;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                                if (iA3 != -1) {
                                                    next.h("The adSource load too many times within the specified time period.");
                                                    ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                    com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                        next.h(desc);
                                                        ab.a(strAI, nVar, desc, next, i5, i6);
                                                        com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                    } else {
                                                        cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                        if (cVar != null) {
                                                            ajVarA = cVar.a(next);
                                                            Object[] objArr111111112 = new Object[1];
                                                            if (ajVarA != null) {
                                                                if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                    i2 = 16;
                                                                    str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                    str2 = "AD platform's error code strategy limit1";
                                                                } else {
                                                                    i2 = 17;
                                                                    str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                    str2 = "AD platform's error code strategy limit2";
                                                                }
                                                                String str11111111111111115 = str;
                                                                String str11111111111111116 = str2;
                                                                next.h(str11111111111111116);
                                                                ab.a(strAI, nVar, str11111111111111116, next, i5, i6);
                                                                com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111111115, str11111111111111115, str11111111111111116));
                                                                z = true;
                                                            } else {
                                                                z = false;
                                                            }
                                                        } else {
                                                            z = false;
                                                        }
                                                    }
                                                }
                                            }
                                            z = true;
                                        }
                                    } else {
                                        if (com.anythink.core.common.c.a().a(iU, lVar, next)) {
                                            next.g(-8);
                                            next.h("Error Code Request fail in pacing");
                                            ab.a(strAI, nVar, "Error Code Request fail in pacing", next, i5, i6);
                                            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                                        } else if (iU == 0 && next.aJ() == 1) {
                                            next.h("System splash not allow preload");
                                            ab.a(strAI, nVar, "System splash not allow preload", next, i5, i6);
                                            com.anythink.core.common.u.e.a(nVarAf, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
                                        } else {
                                            iA3 = com.anythink.core.a.c.a().a(contextG, next, strAI, lVar.aq());
                                            if (iA3 != -1) {
                                                next.h("The adSource load too many times within the specified time period.");
                                                ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", next, i5, i6);
                                                com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
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
                                                    next.h(desc);
                                                    ab.a(strAI, nVar, desc, next, i5, i6);
                                                    com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
                                                } else {
                                                    cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
                                                    if (cVar != null) {
                                                        ajVarA = cVar.a(next);
                                                        Object[] objArr111111113 = new Object[1];
                                                        if (ajVarA != null) {
                                                            if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
                                                                i2 = 16;
                                                                str = ErrorCode.filterByMNErrorCodeReqLimit;
                                                                str2 = "AD platform's error code strategy limit1";
                                                            } else {
                                                                i2 = 17;
                                                                str = ErrorCode.filterByMatchNetworkErrorCode;
                                                                str2 = "AD platform's error code strategy limit2";
                                                            }
                                                            String str11111111111111117 = str;
                                                            String str11111111111111118 = str2;
                                                            next.h(str11111111111111118);
                                                            ab.a(strAI, nVar, str11111111111111118, next, i5, i6);
                                                            com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str11111111111111117, str11111111111111117, str11111111111111118));
                                                            z = true;
                                                        } else {
                                                            z = false;
                                                        }
                                                    } else {
                                                        z = false;
                                                    }
                                                }
                                            }
                                        }
                                        z = true;
                                    }
                                }
                                z = true;
                            }
                        }
                    }
                }
                z = true;
            }
            if (z) {
                next.f();
                it.remove();
            }
        }
    }

    public static void a(com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar, List<bv> list) {
        int i;
        Iterator<bv> it = list.iterator();
        while (it.hasNext()) {
            bv next = it.next();
            com.anythink.core.common.h.n nVarAf = nVar.af();
            String strAI = nVar.aI();
            byte b2 = 0;
            aj.a(nVarAf, next, 0, false);
            bo.a aVarA = com.anythink.core.a.a.a(com.anythink.core.common.d.t.b().g()).a(strAI, next.z(), lVar.aq());
            int i2 = aVarA != null ? aVarA.e : 0;
            int i3 = aVarA != null ? aVarA.d : 0;
            AdError adErrorA = a(0, nVarAf, next, (com.anythink.core.common.h.z) null);
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
                next.h(adErrorA.getPlatformMSG());
                ab.a(strAI, nVar, adErrorA.getPlatformMSG(), next, i2, i3);
                com.anythink.core.common.u.e.a(nVarAf, i4, adErrorA);
                b2 = 1;
            }
            if (b2 != 0) {
                next.f();
                it.remove();
            }
        }
    }

    private static boolean a(com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar, bv bvVar) {
        int i;
        com.anythink.core.common.h.n nVarAf = nVar.af();
        String strAI = nVar.aI();
        byte b2 = 0;
        aj.a(nVarAf, bvVar, 0, false);
        bo.a aVarA = com.anythink.core.a.a.a(com.anythink.core.common.d.t.b().g()).a(strAI, bvVar.z(), lVar.aq());
        int i2 = aVarA != null ? aVarA.e : 0;
        int i3 = aVarA != null ? aVarA.d : 0;
        AdError adErrorA = a(0, nVarAf, bvVar, (com.anythink.core.common.h.z) null);
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
        bvVar.h(adErrorA.getPlatformMSG());
        ab.a(strAI, nVar, adErrorA.getPlatformMSG(), bvVar, i2, i3);
        com.anythink.core.common.u.e.a(nVarAf, i4, adErrorA);
        return true;
    }

    public static AdError a(int i, com.anythink.core.common.h.n nVar, bv bvVar, com.anythink.core.common.h.z zVar) {
        Map<String, ATAdFilter> mapZ;
        ATAdFilter aTAdFilter;
        if (nVar == null || bvVar == null || (mapZ = com.anythink.core.common.d.t.b().Z()) == null || mapZ.isEmpty() || (aTAdFilter = mapZ.get(nVar.aI())) == null) {
            return null;
        }
        int iE = p.e(bvVar.d());
        String strA = ak.a(bvVar, (ATBaseAdAdapter) null);
        double dA = p.a(bvVar);
        if (zVar != null) {
            dA = zVar.getSortPrice();
        }
        return aTAdFilter.doFilter(new ca(i, String.valueOf(bvVar.g()), String.valueOf(iE), dA, strA));
    }

    private static boolean a(int i, com.anythink.core.d.l lVar, com.anythink.core.common.h.n nVar, bv bvVar) {
        int i2;
        String str;
        String str2;
        boolean z;
        com.anythink.core.common.h.i iVarC;
        Boolean boolB;
        int i3;
        com.anythink.core.common.h.n nVarAf = nVar.af();
        String strAI = nVar.aI();
        byte b2 = 0;
        aj.a(nVarAf, bvVar, 0, false);
        bo.a aVarA = com.anythink.core.a.a.a(com.anythink.core.common.d.t.b().g()).a(strAI, bvVar.z(), lVar.aq());
        int i4 = aVarA != null ? aVarA.e : 0;
        int i5 = aVarA != null ? aVarA.d : 0;
        Context contextG = com.anythink.core.common.d.t.b().g();
        Pair<Integer, List<String>> pairI = com.anythink.core.common.d.t.b().I();
        if (pairI != null && ((Integer) pairI.first).intValue() == 1) {
            List list = (List) pairI.second;
            if (list != null && !list.isEmpty()) {
                if (list.contains(String.valueOf(bvVar.g()))) {
                    bvVar.h("Filter ad source loading for specified channel id on risky devices.");
                    ab.a(strAI, nVar, "Filter ad source loading for specified channel id on risky devices.", bvVar, i4, i5, list);
                    com.anythink.core.common.u.e.a(nVarAf, 28, ErrorCode.getErrorCode(ErrorCode.adSourceLoadRiskError, "", "Filter ad source loading for specified channel id on risky devices."));
                    return true;
                }
            } else {
                bvVar.h("Filter ad source loading across all channels on risky devices.");
                ab.a(strAI, nVar, "Filter ad source loading across all channels on risky devices.", bvVar, i4, i5);
                com.anythink.core.common.u.e.a(nVarAf, 27, ErrorCode.getErrorCode(ErrorCode.adSourceLoadRiskError, "", "Filter ad source loading across all channels on risky devices."));
                return true;
            }
        }
        AdError adErrorA = a(1, nVarAf, bvVar, (com.anythink.core.common.h.z) null);
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
            bvVar.h(adErrorA.getPlatformMSG());
            ab.a(strAI, nVar, adErrorA.getPlatformMSG(), bvVar, i4, i5);
            com.anythink.core.common.u.e.a(nVarAf, i6, adErrorA);
            return true;
        }
        List<String> listJ = com.anythink.core.common.d.t.b().J();
        com.anythink.core.common.d.t.b();
        if (com.anythink.core.common.d.t.a(listJ, String.valueOf(bvVar.g()))) {
            bvVar.h("Forbid network by developer");
            ab.a(strAI, nVar, "Forbid network by developer", bvVar, i4, i5, listJ);
            com.anythink.core.common.u.e.a(nVarAf, 14, ErrorCode.getErrorCode(ErrorCode.forbidNetworkByDeveloper, "", "Forbid network by developer"));
            return true;
        }
        if (ak.b(bvVar) && com.anythink.core.common.a.i.a(contextG).a(bvVar.z())) {
            bvVar.h("Adx bid Pacing");
            ab.a(strAI, nVar, "Adx bid Pacing", bvVar, i4, i5);
            com.anythink.core.common.u.e.a(nVarAf, 12, ErrorCode.getErrorCode(ErrorCode.inAdxBidInterval, "", "Adx bid Pacing"));
            return true;
        }
        int iA = com.anythink.core.a.a.a(contextG).a(strAI, bvVar, lVar.aq());
        if (iA != -1) {
            bvVar.g(-5);
            bvVar.h("Out of Cap");
            ab.a(strAI, nVar, "Out of Cap", bvVar, i4, i5);
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
            com.anythink.core.common.u.e.a(nVarAf, i3, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
            return true;
        }
        com.anythink.core.a.d.a();
        int iA2 = com.anythink.core.a.d.a(strAI, bvVar);
        if (iA2 != -1) {
            bvVar.g(-6);
            bvVar.h("Out of Pacing");
            ab.a(strAI, nVar, "Out of Pacing", bvVar, i4, i5);
            com.anythink.core.common.u.e.a(nVarAf, iA2 != 12 ? iA2 != 13 ? 3 : 24 : 23, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
            return true;
        }
        if (com.anythink.core.common.c.a().a(bvVar)) {
            bvVar.g(-6);
            bvVar.h("Request fail in pacing");
            ab.a(strAI, nVar, "Request fail in pacing", bvVar, i4, i5);
            com.anythink.core.common.u.e.a(nVarAf, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
            return true;
        }
        List<String> listM = com.anythink.core.common.d.t.b().m(strAI);
        if (listM != null && listM.contains(bvVar.z())) {
            bvVar.g(-8);
            bvVar.h("Request fail in filter list");
            ab.a(strAI, nVar, "Request fail in filter list", bvVar, i4, i5, listM);
            com.anythink.core.common.u.e.a(nVarAf, 5, ErrorCode.getErrorCode(ErrorCode.filterSourceError, "", "Request fail in filter list"));
            return true;
        }
        List<String> listN = com.anythink.core.common.d.t.b().n(strAI);
        if (listN != null && listN.contains(String.valueOf(bvVar.g()))) {
            bvVar.g(-8);
            bvVar.h("Filter by network firm id.");
            ab.a(strAI, nVar, "Filter by network firm id.", bvVar, i4, i5, listN);
            com.anythink.core.common.u.e.a(nVarAf, 9, ErrorCode.getErrorCode(ErrorCode.networkFirmIdFilterSourceError, "", "Filter by network firm id."));
            return true;
        }
        if (bvVar.o()) {
            if (!ak.b(bvVar) || (boolB = com.anythink.core.common.a.i.a(contextG).b(bvVar.z())) == null) {
                z = true;
            } else {
                if (boolB.booleanValue()) {
                    bvVar.h("Adx bid fail in pacing");
                    ab.a(strAI, nVar, "Bid fail in pacing", bvVar, i4, i5);
                    com.anythink.core.common.u.e.a(nVarAf, 13, ErrorCode.getErrorCode(ErrorCode.inAdxBidFailedInterval, "", "Adx Bid fail in pacing"));
                    return true;
                }
                z = false;
            }
            if (z && com.anythink.core.common.c.a().b(bvVar)) {
                bvVar.g(-7);
                bvVar.h("Bid fail in pacing");
                ab.a(strAI, nVar, "Bid fail in pacing", bvVar, i4, i5);
                com.anythink.core.common.u.e.a(nVarAf, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Bid fail in pacing"));
                return true;
            }
            if (bvVar.ad() != 1 && bvVar.q() == 2 && (iVarC = com.anythink.core.common.u.a().c(strAI)) != null && iVarC.a(bvVar)) {
                bvVar.g(-7);
                bvVar.h("Can't Load On Showing");
                ab.a(strAI, nVar, "Can't Load On Showing", bvVar, i4, i5);
                com.anythink.core.common.u.e.a(nVar, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                return true;
            }
        }
        if (com.anythink.core.common.c.a().a(i, lVar, bvVar)) {
            bvVar.g(-8);
            bvVar.h("Error Code Request fail in pacing");
            ab.a(strAI, nVar, "Error Code Request fail in pacing", bvVar, i4, i5);
            com.anythink.core.common.u.e.a(nVarAf, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
            return true;
        }
        if (i != 0 && bvVar.aJ() == 1) {
            bvVar.h("System splash not allow preload");
            ab.a(strAI, nVar, "System splash not allow preload", bvVar, i4, i5);
            com.anythink.core.common.u.e.a(nVarAf, 11, ErrorCode.getErrorCode(ErrorCode.filterByRefreshSystemSplash, ErrorCode.filterByRefreshSystemSplash, "System splash not allow preload"));
            return true;
        }
        int iA3 = com.anythink.core.a.c.a().a(contextG, bvVar, strAI, lVar.aq());
        if (iA3 != -1) {
            bvVar.h("The adSource load too many times within the specified time period.");
            ab.a(strAI, nVar, "The adSource load too many times within the specified time period.", bvVar, i4, i5);
            com.anythink.core.common.u.e.a(nVarAf, iA3, ErrorCode.getErrorCode(ErrorCode.adSourceLoadCappingError, "", "The adSource load too many times within the specified time period."));
            return true;
        }
        com.anythink.core.a.c.a();
        com.anythink.core.common.h.k kVarA = com.anythink.core.a.c.a(contextG, bvVar);
        if (kVarA != null) {
            AdError adErrorB = kVarA.b();
            String desc = adErrorB != null ? adErrorB.getDesc() : "";
            bvVar.h(desc);
            ab.a(strAI, nVar, desc, bvVar, i4, i5);
            com.anythink.core.common.u.e.a(nVarAf, kVarA.a(), adErrorB);
            return true;
        }
        com.anythink.core.common.w.a.b.c cVar = (com.anythink.core.common.w.a.b.c) com.anythink.core.common.w.a.a.d.a(strAI, com.anythink.core.common.w.a.b.c.class);
        if (cVar == null) {
            return false;
        }
        com.anythink.core.common.h.aj ajVarA = cVar.a(bvVar);
        Object[] objArr = new Object[1];
        if (ajVarA == null) {
            return false;
        }
        if (ajVarA.d() == com.anythink.core.common.w.a.a.C0106a.b) {
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
        bvVar.h(str4);
        ab.a(strAI, nVar, str4, bvVar, i4, i5);
        com.anythink.core.common.u.e.a(nVarAf, i2, ErrorCode.getErrorCode(str3, str3, str4));
        return true;
    }

    private static boolean a(String str, bv bvVar) {
        com.anythink.core.common.h.c cVarA;
        if (ak.b(bvVar)) {
            com.anythink.core.common.h.ad adVarA = com.anythink.core.b.f.a().a(str, bvVar);
            if (adVarA != null && !adVarA.a() && adVarA.s()) {
                return false;
            }
            bw bwVarA = com.anythink.core.common.a.a().a(str, bvVar);
            if (bwVarA != null && (cVarA = bwVarA.a((com.anythink.core.common.h.ad) null).a()) != null && cVarA.e() != null && cVarA.e().getUnitGroupInfo() != null && TextUtils.equals(cVarA.e().getUnitGroupInfo().z(), bvVar.z()) && cVarA.e().getUnitGroupInfo().br()) {
                return false;
            }
            Boolean boolA = com.anythink.core.common.a.i.a(com.anythink.core.common.d.t.b().g()).a(bvVar);
            if (boolA != null) {
                return boolA.booleanValue();
            }
        }
        return bvVar.r() == 2;
    }
}
