package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.af;
import com.anythink.core.common.h.bt;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.aj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final String a = getClass().getSimpleName();
    private final ConcurrentHashMap<String, List<com.anythink.core.common.h.c>> b = new ConcurrentHashMap<>(2);
    private final ConcurrentHashMap<String, bz> c = new ConcurrentHashMap<>(2);
    private final f d;

    public a(f fVar) {
        this.d = fVar;
    }

    private static com.anythink.core.common.h.c a(ATBaseAdAdapter aTBaseAdAdapter, long j) {
        com.anythink.core.common.h.c cVar = new com.anythink.core.common.h.c();
        cVar.a(aTBaseAdAdapter);
        cVar.c(System.currentTimeMillis());
        cVar.b(j);
        cVar.a(aTBaseAdAdapter.getUnitGroupInfo().N());
        return cVar;
    }

    private boolean a(String str, int i, ATBaseAdAdapter aTBaseAdAdapter) {
        List<com.anythink.core.common.h.c> listA;
        int size;
        f fVar;
        List<ATAdInfo> listA2;
        if (i == -1 || (listA = a(str)) == null || listA.isEmpty() || (size = listA.size()) < i) {
            return true;
        }
        if (!(com.anythink.core.common.u.k.a(aTBaseAdAdapter.getUnitGroupInfo(), listA.get(size - 1).o()) == -1)) {
            return false;
        }
        int iMax = Math.max(i - 2, -1);
        if (!TextUtils.isEmpty(str) && com.anythink.core.common.d.s.b().g() != null && (fVar = this.d) != null && (listA2 = fVar.a(str, iMax, false)) != null && !listA2.isEmpty()) {
            a(str, listA2, 3);
        }
        return true;
    }

    private List<com.anythink.core.common.h.c> a(String str, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list, long j) {
        by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        String strG = aTBaseAdAdapter.getUnitGroupInfo().G();
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (BaseAd baseAd : list) {
                baseAd.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().ah());
                com.anythink.core.common.h.c cVarA = a(aTBaseAdAdapter, j);
                cVarA.a(baseAd);
                arrayList.add(cVarA);
            }
        } else {
            arrayList.add(a(aTBaseAdAdapter, j));
        }
        if (arrayList.size() == 0) {
            return arrayList;
        }
        a(str, arrayList, trackingInfo, unitGroupInfo, strG);
        return arrayList;
    }

    private void a(String str, List<com.anythink.core.common.h.c> list, com.anythink.core.common.h.n nVar, by byVar, String str2) {
        synchronized (this.d.q()) {
            String strA = a(str, str2);
            bz bzVar = this.c.get(strA);
            if (bzVar == null) {
                bzVar = new bz(str, byVar.G());
                this.c.put(strA, bzVar);
            }
            bzVar.a(byVar.aG());
            bzVar.a(nVar.aR(), new bt(nVar.aR(), list));
            List<com.anythink.core.common.h.c> listSynchronizedList = this.b.get(str);
            if (listSynchronizedList == null) {
                listSynchronizedList = Collections.synchronizedList(new ArrayList());
                this.b.put(str, listSynchronizedList);
            }
            if (listSynchronizedList.size() == 0) {
                listSynchronizedList.addAll(list);
            } else {
                by unitGroupInfo = list.get(0).e().getUnitGroupInfo();
                for (int i = 0; i < listSynchronizedList.size(); i++) {
                    by unitGroupInfo2 = listSynchronizedList.get(i).e().getUnitGroupInfo();
                    int iB = com.anythink.core.common.u.k.b(unitGroupInfo, unitGroupInfo2);
                    if (iB < 0) {
                        listSynchronizedList.addAll(i, list);
                        break;
                    }
                    if (iB == 0 && unitGroupInfo.aE() < unitGroupInfo2.aE()) {
                        listSynchronizedList.addAll(i, list);
                        break;
                    } else {
                        if (i == listSynchronizedList.size() - 1) {
                            listSynchronizedList.addAll(list);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final List<com.anythink.core.common.h.c> a(String str) {
        List<com.anythink.core.common.h.c> list = this.b.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object objQ = this.d.q();
        ArrayList arrayList = new ArrayList();
        synchronized (objQ) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public final void b(String str) {
        synchronized (this.d.q()) {
            List<com.anythink.core.common.h.c> list = this.b.get(str);
            if (list != null) {
                Collections.sort(list);
            }
        }
    }

    public final com.anythink.core.common.h.c a(Context context, String str) {
        List<com.anythink.core.common.h.c> listA = a(context, str, false, false, false, (ae) null);
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        return listA.get(0);
    }

    private com.anythink.core.common.h.c a(Context context, String str, boolean z, boolean z2, ae aeVar) {
        List<com.anythink.core.common.h.c> listA = a(context, str, z, z2, false, aeVar);
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        return listA.get(0);
    }

    /* JADX WARN: Code duplicated, block: B:227:0x0523  */
    /* JADX WARN: Code duplicated, block: B:280:0x0622 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:281:0x0624 A[Catch: all -> 0x070d, TryCatch #9 {all -> 0x070d, blocks: (B:256:0x05ad, B:262:0x05ef, B:265:0x0601, B:281:0x0624, B:282:0x0638, B:274:0x0616, B:270:0x060f), top: B:374:0x05ad, inners: #11 }] */
    /* JADX WARN: Code duplicated, block: B:286:0x0655 A[Catch: all -> 0x0704, TryCatch #3 {all -> 0x0704, blocks: (B:284:0x064b, B:286:0x0655, B:287:0x0659, B:289:0x065f, B:291:0x0674), top: B:364:0x064b }] */
    /* JADX WARN: Code duplicated, block: B:289:0x065f A[Catch: all -> 0x0704, TryCatch #3 {all -> 0x0704, blocks: (B:284:0x064b, B:286:0x0655, B:287:0x0659, B:289:0x065f, B:291:0x0674), top: B:364:0x064b }] */
    /* JADX WARN: Code duplicated, block: B:291:0x0674 A[Catch: all -> 0x0704, TRY_LEAVE, TryCatch #3 {all -> 0x0704, blocks: (B:284:0x064b, B:286:0x0655, B:287:0x0659, B:289:0x065f, B:291:0x0674), top: B:364:0x064b }] */
    /* JADX WARN: Code duplicated, block: B:294:0x0699  */
    /* JADX WARN: Code duplicated, block: B:298:0x06b8 A[Catch: all -> 0x070a, TryCatch #8 {all -> 0x070a, blocks: (B:293:0x0695, B:296:0x06aa, B:298:0x06b8, B:300:0x06bc, B:302:0x06c5, B:303:0x06e4), top: B:373:0x0695 }] */
    /* JADX WARN: Code duplicated, block: B:304:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:306:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:309:0x06f4  */
    /* JADX WARN: Code duplicated, block: B:310:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:312:0x0702 A[Catch: all -> 0x0798, DONT_GENERATE, TRY_ENTER, TryCatch #14 {all -> 0x0798, blocks: (B:323:0x072e, B:325:0x0734, B:330:0x0765, B:335:0x0787, B:336:0x0796, B:312:0x0702), top: B:384:0x04a4 }] */
    /* JADX WARN: Code duplicated, block: B:316:0x070d A[PHI: r9 r35 r36
      0x070d: PHI (r9v12 boolean) = (r9v13 boolean), (r9v14 boolean) binds: [B:357:0x070d, B:279:0x0620] A[DONT_GENERATE, DONT_INLINE]
      0x070d: PHI (r35v10 com.anythink.core.e.l) = (r35v11 com.anythink.core.e.l), (r35v12 com.anythink.core.e.l) binds: [B:357:0x070d, B:279:0x0620] A[DONT_GENERATE, DONT_INLINE]
      0x070d: PHI (r36v10 java.lang.String) = (r36v11 java.lang.String), (r36v12 java.lang.String) binds: [B:357:0x070d, B:279:0x0620] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:318:0x071e  */
    /* JADX WARN: Code duplicated, block: B:322:0x072c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:323:0x072e A[Catch: all -> 0x0798, TryCatch #14 {all -> 0x0798, blocks: (B:323:0x072e, B:325:0x0734, B:330:0x0765, B:335:0x0787, B:336:0x0796, B:312:0x0702), top: B:384:0x04a4 }] */
    /* JADX WARN: Code duplicated, block: B:325:0x0734 A[Catch: all -> 0x0798, TryCatch #14 {all -> 0x0798, blocks: (B:323:0x072e, B:325:0x0734, B:330:0x0765, B:335:0x0787, B:336:0x0796, B:312:0x0702), top: B:384:0x04a4 }] */
    /* JADX WARN: Code duplicated, block: B:328:0x0761  */
    /* JADX WARN: Code duplicated, block: B:329:0x0764  */
    /* JADX WARN: Code duplicated, block: B:332:0x0781 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:333:0x0783  */
    /* JADX WARN: Code duplicated, block: B:334:0x0786  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32, types: [com.anythink.core.api.BaseAd, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.util.List<com.anythink.core.common.h.c>] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.anythink.core.common.h.c>] */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.util.ArrayList] */
    public final List<com.anythink.core.common.h.c> a(Context context, String str, boolean z, boolean z2, boolean z3, ae aeVar) {
        ArrayList arrayList;
        com.anythink.core.common.h.c cVarA;
        af afVar;
        com.anythink.core.common.h.c cVar;
        com.anythink.core.common.h.c cVar2;
        boolean z4;
        String str2;
        com.anythink.core.e.l lVar;
        boolean zL;
        int i;
        String str3;
        int i2;
        int i3;
        by next;
        by byVar;
        by byVar2;
        boolean z5;
        ATBaseAdAdapter aTBaseAdAdapter;
        ArrayList arrayList2;
        boolean zInternalIsAdReady;
        boolean z6;
        ?? r0;
        af afVar2;
        int i4;
        ATAdInfo aTAdInfo;
        String str4;
        List<com.anythink.core.common.h.c> listA;
        int i5;
        com.anythink.core.common.h.c cVar3;
        com.anythink.core.common.h.n nVarI;
        BaseAd baseAdObject;
        boolean z7;
        ArrayList arrayList3;
        ArrayList arrayList4;
        int i6;
        af afVar3;
        int i7;
        af afVar4;
        com.anythink.core.common.h.c cVar4;
        String strG;
        int iN;
        String str5;
        int i8;
        String strG2;
        int iN2;
        String str6;
        int i9;
        String strG3;
        int iN3;
        String str7;
        Iterator<com.anythink.core.common.h.c> it;
        ?? r1 = context;
        String str8 = str;
        ArrayList arrayList5 = new ArrayList();
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Map<String, Object> mapA = aeVar != null ? aeVar.a() : null;
            com.anythink.core.common.h.d dVarB = aeVar != null ? aeVar.b() : null;
            ATAdInfo aTAdInfoC = aeVar != null ? aeVar.c() : null;
            Object objQ = this.d.q();
            SystemClock.elapsedRealtime();
            synchronized (objQ) {
                try {
                    SystemClock.elapsedRealtime();
                    arrayList = new ArrayList();
                    List<com.anythink.core.common.h.c> list = this.b.get(str8);
                    if (list != null && (it = list.iterator()) != null) {
                        while (it.hasNext()) {
                            com.anythink.core.common.h.c next2 = it.next();
                            if (next2 == null) {
                                try {
                                    it.remove();
                                } catch (Throwable th) {
                                    a("checkCache failed in iterator remove operate", th);
                                }
                            } else {
                                arrayList.add(next2);
                            }
                        }
                    }
                    f fVar = this.d;
                    cVarA = (fVar == null || fVar.d() == null) ? null : this.d.d().a(str8);
                } catch (Throwable th2) {
                    th = th2;
                    a("checkCache failed in method. size: " + r1.size(), th);
                }
            }
            com.anythink.core.e.l lVarC = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).c(str8);
            if (lVarC == null) {
                return null;
            }
            List<String> listO = com.anythink.core.common.d.s.b().o(str8);
            List<String> listP = com.anythink.core.common.d.s.b().p(str8);
            af afVar5 = new af();
            ArrayList<com.anythink.core.common.h.c> arrayList6 = new ArrayList();
            if (arrayList.isEmpty()) {
                afVar = afVar5;
                listP = listP;
                listO = listO;
                lVarC = lVarC;
                cVar = cVarA;
                cVar2 = null;
            } else {
                int i10 = 0;
                cVar2 = null;
                while (true) {
                    if (i10 >= arrayList.size()) {
                        afVar = afVar5;
                        listP = listP;
                        listO = listO;
                        lVarC = lVarC;
                        cVarA = cVarA;
                        arrayList3 = null;
                        break;
                    }
                    com.anythink.core.common.h.c cVar5 = (com.anythink.core.common.h.c) arrayList.get(i10);
                    if (cVar5 != null) {
                        by unitGroupInfo = cVar5.e().getUnitGroupInfo();
                        int iAF = unitGroupInfo.aF();
                        by byVarA = lVarC.a(unitGroupInfo.G());
                        com.anythink.core.a.d.a();
                        arrayList4 = arrayList;
                        int iA = com.anythink.core.a.d.a(byVarA != null ? byVarA : unitGroupInfo);
                        i6 = i10;
                        if (iA != -1) {
                            strG3 = unitGroupInfo.G();
                            iN3 = unitGroupInfo.n();
                            str7 = "";
                        } else {
                            com.anythink.core.a.a.a(com.anythink.core.common.d.s.b().g());
                            if (byVarA == null) {
                                byVarA = unitGroupInfo;
                            }
                            iA = com.anythink.core.a.a.a(byVarA, lVarC.ap());
                            if (iA != -1) {
                                strG3 = unitGroupInfo.G();
                                iN3 = unitGroupInfo.n();
                                str7 = "";
                            } else {
                                if (listO == null || listO.size() <= 0) {
                                    i7 = 0;
                                } else {
                                    if (listO.contains(String.valueOf(unitGroupInfo.n()))) {
                                        i7 = 1;
                                    } else {
                                        strG = unitGroupInfo.G();
                                        iN = unitGroupInfo.n();
                                        str5 = "";
                                        afVar3 = afVar5;
                                        listP = listP;
                                        listO = listO;
                                        lVarC = lVarC;
                                        cVarA = cVarA;
                                        i8 = 5;
                                    }
                                    a(afVar3, iAF, strG, iN, str5, false, i8);
                                }
                                if (listP != null && listP.size() > 0) {
                                    if (listP.contains(String.valueOf(unitGroupInfo.n()))) {
                                        strG = unitGroupInfo.G();
                                        iN = unitGroupInfo.n();
                                        str5 = "";
                                        i8 = 6;
                                        afVar3 = afVar5;
                                        listP = listP;
                                        listO = listO;
                                        lVarC = lVarC;
                                        cVarA = cVarA;
                                        a(afVar3, iAF, strG, iN, str5, false, i8);
                                    } else {
                                        i7 = 2;
                                    }
                                }
                                Pair<Integer, List<String>> pairI = com.anythink.core.common.d.s.b().I();
                                if (pairI != null) {
                                    afVar4 = afVar5;
                                    if (((Integer) pairI.first).intValue() == 1) {
                                        List list2 = (List) pairI.second;
                                        if (list2 != null && !list2.isEmpty()) {
                                            if (list2.contains(String.valueOf(unitGroupInfo.n()))) {
                                                strG2 = unitGroupInfo.G();
                                                iN2 = unitGroupInfo.n();
                                                str6 = "";
                                                i9 = 28;
                                            }
                                        } else {
                                            strG2 = unitGroupInfo.G();
                                            iN2 = unitGroupInfo.n();
                                            str6 = "";
                                            i9 = 27;
                                        }
                                        strG = strG2;
                                        iN = iN2;
                                        str5 = str6;
                                        i8 = i9;
                                        listP = listP;
                                        listO = listO;
                                        lVarC = lVarC;
                                        cVarA = cVarA;
                                        afVar3 = afVar4;
                                        a(afVar3, iAF, strG, iN, str5, false, i8);
                                    }
                                } else {
                                    afVar4 = afVar5;
                                }
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                boolean zG = cVar5.g();
                                boolean zJ = cVar5.j();
                                com.anythink.core.common.h.n nVarI2 = cVar5.i();
                                if (aTAdInfoC == null || !(aTAdInfoC instanceof com.anythink.core.common.d.k)) {
                                    cVar4 = cVar2;
                                } else if (!a((com.anythink.core.common.d.k) aTAdInfoC, cVar5)) {
                                    strG = unitGroupInfo.G();
                                    iN = unitGroupInfo.n();
                                    str5 = "";
                                    i8 = 7;
                                    listP = listP;
                                    listO = listO;
                                    lVarC = lVarC;
                                    cVarA = cVarA;
                                    afVar3 = afVar4;
                                    a(afVar3, iAF, strG, iN, str5, false, i8);
                                } else {
                                    nVarI2.as();
                                    cVar4 = cVar5;
                                }
                                if (zG && zJ) {
                                    if (z) {
                                        com.anythink.core.common.t.f.a(com.anythink.core.common.n.c.b, nVarI2, nVarI2.aR(), str, nVarI2.N(), nVarI2.Z(), lVarC.ap(), SystemClock.elapsedRealtime() - jElapsedRealtime2);
                                    }
                                    a(afVar4, iAF, unitGroupInfo.G(), unitGroupInfo.n(), cVar5.e().getInternalNetworkSDKVersion(), true, -1);
                                    af afVar6 = afVar4;
                                    nVarI2.a(afVar6);
                                    nVarI2.y(iAF);
                                    nVarI2.W(i7);
                                    if (!z3) {
                                        if (cVarA != 0 && com.anythink.core.common.u.k.a(cVarA.e().getUnitGroupInfo(), cVar5.e().getUnitGroupInfo()) < 0 && a(cVarA, afVar6, listO, listP, cVar4, aTAdInfoC)) {
                                            arrayList5.add(cVarA);
                                        } else {
                                            arrayList5.add(cVar5);
                                        }
                                        if (z) {
                                            com.anythink.core.common.t.f.a(nVarI2.aR(), str, true, -1, lVarC, arrayList5.size() > 0 ? (com.anythink.core.common.h.c) arrayList5.get(0) : null, afVar6, "", mapA, dVarB, SystemClock.elapsedRealtime() - jElapsedRealtime, aeVar);
                                        }
                                        afVar = afVar6;
                                        arrayList3 = arrayList5;
                                        cVar2 = cVar4;
                                        break;
                                    }
                                    arrayList5.add(cVar5);
                                    afVar3 = afVar6;
                                } else {
                                    listP = listP;
                                    listO = listO;
                                    lVarC = lVarC;
                                    cVarA = cVarA;
                                    afVar3 = afVar4;
                                    if (z) {
                                        com.anythink.core.common.t.f.a(com.anythink.core.common.n.c.c, nVarI2, nVarI2.aR(), str, nVarI2.N(), nVarI2.Z(), lVarC.ap(), SystemClock.elapsedRealtime() - jElapsedRealtime2);
                                    }
                                    int iC = cVar5.c();
                                    cVar5.h();
                                    if (iC <= 0 && !cVar5.q()) {
                                        com.anythink.core.c.d.c.a(cVar5);
                                    }
                                    if (cVar5.e() != null) {
                                        com.anythink.core.common.u.d.a().d(cVar5.e());
                                    }
                                    arrayList6.add(cVar5);
                                    if (iC == 0) {
                                        strG = unitGroupInfo.G();
                                        iN = unitGroupInfo.n();
                                        str5 = "";
                                        cVar2 = cVar4;
                                        i8 = !zG ? 0 : 1;
                                        a(afVar3, iAF, strG, iN, str5, false, i8);
                                    }
                                }
                                cVar2 = cVar4;
                            }
                        }
                        i8 = iA;
                        strG = strG3;
                        iN = iN3;
                        str5 = str7;
                        afVar3 = afVar5;
                        listP = listP;
                        listO = listO;
                        lVarC = lVarC;
                        cVarA = cVarA;
                        a(afVar3, iAF, strG, iN, str5, false, i8);
                    } else {
                        arrayList4 = arrayList;
                        i6 = i10;
                        afVar3 = afVar5;
                        listP = listP;
                        listO = listO;
                        lVarC = lVarC;
                        cVarA = cVarA;
                    }
                    i10 = i6 + 1;
                    afVar5 = afVar3;
                    cVarA = cVarA;
                    arrayList = arrayList4;
                    listP = listP;
                    listO = listO;
                    lVarC = lVarC;
                }
                synchronized (objQ) {
                    cVar = cVarA;
                    str8 = str;
                    List<com.anythink.core.common.h.c> list3 = this.b.get(str8);
                    if (list3 != null) {
                        try {
                            for (com.anythink.core.common.h.c cVar6 : arrayList6) {
                                a(cVar6, 4);
                                list3.remove(cVar6);
                            }
                        } catch (Throwable th3) {
                            a("checkCache failed in remove operate", th3);
                        }
                    }
                }
                if (arrayList3 != null) {
                    return arrayList3;
                }
            }
            synchronized (objQ) {
                try {
                    if (z3) {
                        if (cVar != null) {
                            if (arrayList5.size() != 0) {
                                com.anythink.core.common.h.c cVar7 = (com.anythink.core.common.h.c) arrayList5.get(0);
                                if (cVar7 != null) {
                                    boolean z8 = com.anythink.core.common.u.k.a(cVar.e().getUnitGroupInfo(), cVar7.e().getUnitGroupInfo()) < 0;
                                    z7 = z8;
                                } else {
                                    z7 = false;
                                }
                            } else {
                                z7 = z8;
                            }
                            if (z7 && a(cVar, afVar, listO, listP, cVar2, aTAdInfoC)) {
                                arrayList5.add(cVar);
                            }
                        }
                        return arrayList5;
                    }
                    if (cVar != null && a(cVar, afVar, listO, listP, (com.anythink.core.common.h.c) null, aTAdInfoC)) {
                        arrayList5.add(cVar);
                        if (z) {
                            com.anythink.core.common.t.f.a(cVar.e().getTrackingInfo().aR(), str, true, -1, lVarC, cVar, afVar, "", mapA, dVarB, SystemClock.elapsedRealtime() - jElapsedRealtime, aeVar);
                        }
                        return arrayList5;
                    }
                    if (lVarC.aj() == 1) {
                        z4 = true;
                    } else {
                        z4 = lVarC.aj() == 2 ? z2 : false;
                    }
                    List<by> listY = lVarC.y();
                    f fVar2 = this.d;
                    String strM = fVar2.m() != null ? fVar2.m() : "";
                    try {
                        if (listY == null || listY.size() <= 0 || !z4) {
                            str2 = strM;
                            lVar = lVarC;
                            zL = false;
                            r1 = arrayList5;
                            i = 1;
                            str3 = str8;
                        } else {
                            String strA = r.a().a(context, str8);
                            if (TextUtils.isEmpty(strA)) {
                                next = null;
                                break;
                            }
                            Iterator<by> it2 = listY.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it2.next();
                                if (next.r() != null && next.r().contains(strA)) {
                                    break;
                                }
                            }
                            if (next == null) {
                                byVar = next;
                            } else {
                                if (!com.anythink.core.common.u.o.a(listO, "35")) {
                                    a(afVar, -1, next.G(), next.n(), "", false, 5);
                                } else if (com.anythink.core.common.u.o.b(listP, "35")) {
                                    a(afVar, -1, next.G(), next.n(), "", false, 6);
                                } else {
                                    byVar = next;
                                }
                                byVar = null;
                            }
                            if (byVar != null) {
                                Map<String, Object> mapA2 = lVarC.a(str8, strM, byVar, aeVar != null ? aeVar.d() : null);
                                mapA2.put(r.b, Boolean.TRUE);
                                try {
                                    com.anythink.core.common.h.p pVarA = com.anythink.core.common.u.t.a(byVar);
                                    ATBaseAdAdapter aTBaseAdAdapter2 = pVarA != null ? pVarA.a : null;
                                    boolean zInternalInitNetworkObjectByPlacementId = aTBaseAdAdapter2.internalInitNetworkObjectByPlacementId(context, mapA2, this.d.r());
                                    if (zInternalInitNetworkObjectByPlacementId) {
                                        try {
                                            Map<String, Object> mapR = this.d.r();
                                            int[] iArr = new int[1];
                                            try {
                                                iArr[0] = 0;
                                                if (mapR.containsKey(bx.X)) {
                                                    try {
                                                        iArr[0] = ((Integer) mapR.get(bx.X)).intValue();
                                                    } catch (Throwable unused) {
                                                    }
                                                }
                                                try {
                                                    ATBaseAdAdapter aTBaseAdAdapter3 = aTBaseAdAdapter2;
                                                    lVar = lVarC;
                                                    by byVar3 = byVar;
                                                    str2 = strM;
                                                    try {
                                                        com.anythink.core.common.h.n nVarA = ai.a(strM, str, lVarC, 0, iArr[0], mapA, null, 0, aeVar != null ? aeVar.d() : null, this.d);
                                                        byVar2 = byVar3;
                                                        z5 = false;
                                                        z5 = false;
                                                        try {
                                                            ai.a(nVarA, byVar2, 0, true);
                                                            aTBaseAdAdapter = aTBaseAdAdapter3;
                                                            ai.a(aTBaseAdAdapter, nVarA, byVar2);
                                                            nVarA.t = 3;
                                                            arrayList2 = null;
                                                            nVarA.m(aj.a(byVar2, null));
                                                            aTBaseAdAdapter.setRefresh(false);
                                                        } catch (Throwable unused2) {
                                                        }
                                                    } catch (Throwable unused3) {
                                                        zL = false;
                                                        r1 = arrayList5;
                                                    }
                                                } catch (Throwable unused4) {
                                                    lVar = lVarC;
                                                    str2 = strM;
                                                    afVar = afVar;
                                                    fVar2 = fVar2;
                                                    r1 = arrayList5;
                                                    zL = false;
                                                }
                                            } catch (Throwable unused5) {
                                                lVar = lVarC;
                                                str2 = strM;
                                                afVar = afVar;
                                                fVar2 = fVar2;
                                                r1 = arrayList5;
                                                zL = false;
                                            }
                                        } catch (Throwable unused6) {
                                            lVar = lVarC;
                                            str2 = strM;
                                        }
                                    } else {
                                        aTBaseAdAdapter = aTBaseAdAdapter2;
                                        lVar = lVarC;
                                        str2 = strM;
                                        z5 = false;
                                        arrayList2 = null;
                                        byVar2 = byVar;
                                    }
                                    if (TextUtils.equals(String.valueOf(lVar.ap()), "0")) {
                                        if (zInternalInitNetworkObjectByPlacementId) {
                                            baseAdObject = aTBaseAdAdapter.getBaseAdObject(context);
                                            z6 = baseAdObject != null ? true : z5 ? 1 : 0;
                                        }
                                        if (z6) {
                                            if (r0 != 0) {
                                                ArrayList arrayList7 = new ArrayList();
                                                r0.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().ah());
                                                arrayList7.add(r0);
                                                arrayList2 = arrayList7;
                                            }
                                            afVar2 = afVar;
                                            fVar2 = fVar2;
                                            i4 = 1;
                                            ATBaseAdAdapter aTBaseAdAdapter4 = aTBaseAdAdapter;
                                            aTAdInfo = aTAdInfoC;
                                            ArrayList arrayList8 = arrayList2;
                                            str4 = str8;
                                            try {
                                                listA = a(str, aTBaseAdAdapter4, arrayList8, aj.c(byVar2));
                                                if (listA.size() > 0) {
                                                    for (com.anythink.core.common.h.c cVar8 : listA) {
                                                        nVarI = cVar8.i();
                                                        nVarI.E = i4;
                                                        nVarI.y(z5 ? 1 : 0);
                                                        nVarI.a(afVar2);
                                                        if (z) {
                                                            String strAR = nVarI.aR();
                                                            String strR = byVar2.r();
                                                            i = i4;
                                                            zL = z5 ? 1 : 0;
                                                            str3 = str4;
                                                            aTAdInfoC = aTAdInfo;
                                                            afVar = afVar2;
                                                            try {
                                                                com.anythink.core.common.t.f.a(strAR, str, true, -1, lVar, cVar8, afVar2, strR, mapA, dVarB, aeVar);
                                                            } catch (Throwable unused7) {
                                                                r1 = arrayList5;
                                                                if (z) {
                                                                    if (fVar2 != null) {
                                                                        zL = fVar2.l();
                                                                    }
                                                                    if (fVar2 == null) {
                                                                        com.anythink.core.common.t.f.b("AdManage is null--isReady", "Id:" + str3 + "--format:" + lVar.ap(), com.anythink.core.common.d.s.b().r());
                                                                    }
                                                                    if (zL) {
                                                                        i3 = 5;
                                                                    } else {
                                                                        i3 = i;
                                                                    }
                                                                    com.anythink.core.common.t.f.a(str2, str, false, i3, lVar, (com.anythink.core.common.h.c) null, afVar, "", mapA, dVarB, SystemClock.elapsedRealtime() - jElapsedRealtime, aeVar);
                                                                }
                                                                if (z2) {
                                                                    if (aTAdInfoC != null) {
                                                                        i2 = 5;
                                                                    } else {
                                                                        i2 = i;
                                                                    }
                                                                    com.anythink.core.common.t.f.a(str2, str, lVar, i2, afVar, mapA, aeVar);
                                                                }
                                                                return r1;
                                                            }
                                                        } else {
                                                            i = i4;
                                                            zL = z5 ? 1 : 0;
                                                            aTAdInfoC = aTAdInfo;
                                                            str3 = str4;
                                                            afVar = afVar2;
                                                        }
                                                        z5 = zL;
                                                        str4 = str3;
                                                        aTAdInfo = aTAdInfoC;
                                                        i4 = i;
                                                        byVar2 = byVar2;
                                                        afVar2 = afVar;
                                                    }
                                                    i = i4;
                                                    zL = z5 ? 1 : 0;
                                                    aTAdInfoC = aTAdInfo;
                                                    str3 = str4;
                                                    afVar = afVar2;
                                                    cVar3 = listA.get(zL ? 1 : 0);
                                                    if (aTAdInfoC != null || !(aTAdInfoC instanceof com.anythink.core.common.d.k)) {
                                                        i5 = i;
                                                    } else if (!a((com.anythink.core.common.d.k) aTAdInfoC, cVar3)) {
                                                        a(afVar, -1, cVar3.i().N(), cVar3.i().Z(), "", false, 7);
                                                        i5 = zL ? 1 : 0;
                                                    } else {
                                                        cVar3.i().as();
                                                        i5 = i;
                                                    }
                                                    if (i5 != 0) {
                                                        r1 = arrayList5;
                                                        try {
                                                            r1.add(cVar3);
                                                            r1 = r1;
                                                        } catch (Throwable unused8) {
                                                        }
                                                    } else {
                                                        r1 = arrayList5;
                                                    }
                                                } else {
                                                    i = 1;
                                                    zL = z5 ? 1 : 0;
                                                    aTAdInfoC = aTAdInfo;
                                                    str3 = str4;
                                                    afVar = afVar2;
                                                    r1 = arrayList5;
                                                    i5 = 1;
                                                }
                                                if (i5 != 0) {
                                                    return r1;
                                                }
                                            } catch (Throwable unused9) {
                                                i = i4;
                                                zL = z5;
                                                aTAdInfoC = aTAdInfo;
                                                str3 = str4;
                                                afVar = afVar2;
                                            }
                                        } else {
                                            r0 = baseAdObject;
                                            r0 = baseAdObject;
                                            afVar = afVar;
                                            fVar2 = fVar2;
                                            r1 = arrayList5;
                                            zL = z5;
                                            i = 1;
                                            str3 = str8;
                                        }
                                    } else {
                                        if (zInternalInitNetworkObjectByPlacementId) {
                                            try {
                                                zInternalIsAdReady = aTBaseAdAdapter.internalIsAdReady();
                                            } catch (Throwable th4) {
                                                a("checkCache failed in network is ready", th4);
                                                z6 = z5 ? 1 : 0;
                                            }
                                        } else {
                                            zInternalIsAdReady = z5 ? 1 : 0;
                                        }
                                        z6 = zInternalIsAdReady;
                                        r0 = arrayList2;
                                        if (z6) {
                                            if (r0 != 0) {
                                                ArrayList arrayList9 = new ArrayList();
                                                r0.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().ah());
                                                arrayList9.add(r0);
                                                arrayList2 = arrayList9;
                                            }
                                            afVar2 = afVar;
                                            fVar2 = fVar2;
                                            i4 = 1;
                                            ATBaseAdAdapter aTBaseAdAdapter5 = aTBaseAdAdapter;
                                            aTAdInfo = aTAdInfoC;
                                            ArrayList arrayList10 = arrayList2;
                                            str4 = str8;
                                            listA = a(str, aTBaseAdAdapter5, arrayList10, aj.c(byVar2));
                                            if (listA.size() > 0) {
                                                while (r1.hasNext()) {
                                                    nVarI = cVar8.i();
                                                    nVarI.E = i4;
                                                    nVarI.y(z5 ? 1 : 0);
                                                    nVarI.a(afVar2);
                                                    if (z) {
                                                        String strAR2 = nVarI.aR();
                                                        String strR2 = byVar2.r();
                                                        i = i4;
                                                        zL = z5 ? 1 : 0;
                                                        str3 = str4;
                                                        aTAdInfoC = aTAdInfo;
                                                        afVar = afVar2;
                                                        com.anythink.core.common.t.f.a(strAR2, str, true, -1, lVar, cVar8, afVar2, strR2, mapA, dVarB, aeVar);
                                                    } else {
                                                        i = i4;
                                                        zL = z5 ? 1 : 0;
                                                        aTAdInfoC = aTAdInfo;
                                                        str3 = str4;
                                                        afVar = afVar2;
                                                    }
                                                    z5 = zL;
                                                    str4 = str3;
                                                    aTAdInfo = aTAdInfoC;
                                                    i4 = i;
                                                    byVar2 = byVar2;
                                                    afVar2 = afVar;
                                                }
                                                i = i4;
                                                zL = z5 ? 1 : 0;
                                                aTAdInfoC = aTAdInfo;
                                                str3 = str4;
                                                afVar = afVar2;
                                                cVar3 = listA.get(zL ? 1 : 0);
                                                if (aTAdInfoC != null) {
                                                    i5 = i;
                                                } else {
                                                    i5 = i;
                                                }
                                                if (i5 != 0) {
                                                    r1 = arrayList5;
                                                    r1.add(cVar3);
                                                    r1 = r1;
                                                } else {
                                                    r1 = arrayList5;
                                                }
                                            } else {
                                                i = 1;
                                                zL = z5 ? 1 : 0;
                                                aTAdInfoC = aTAdInfo;
                                                str3 = str4;
                                                afVar = afVar2;
                                                r1 = arrayList5;
                                                i5 = 1;
                                            }
                                            if (i5 != 0) {
                                                return r1;
                                            }
                                        } else {
                                            r0 = baseAdObject;
                                            r0 = baseAdObject;
                                            afVar = afVar;
                                            fVar2 = fVar2;
                                            r1 = arrayList5;
                                            zL = z5;
                                            i = 1;
                                            str3 = str8;
                                        }
                                    }
                                    z6 = z5 ? 1 : 0;
                                    r0 = arrayList2;
                                    if (z6) {
                                        if (r0 != 0) {
                                            ArrayList arrayList11 = new ArrayList();
                                            r0.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().ah());
                                            arrayList11.add(r0);
                                            arrayList2 = arrayList11;
                                        }
                                        afVar2 = afVar;
                                        fVar2 = fVar2;
                                        i4 = 1;
                                        ATBaseAdAdapter aTBaseAdAdapter6 = aTBaseAdAdapter;
                                        aTAdInfo = aTAdInfoC;
                                        ArrayList arrayList12 = arrayList2;
                                        str4 = str8;
                                        listA = a(str, aTBaseAdAdapter6, arrayList12, aj.c(byVar2));
                                        if (listA.size() > 0) {
                                            while (r1.hasNext()) {
                                                nVarI = cVar8.i();
                                                nVarI.E = i4;
                                                nVarI.y(z5 ? 1 : 0);
                                                nVarI.a(afVar2);
                                                if (z) {
                                                    String strAR3 = nVarI.aR();
                                                    String strR3 = byVar2.r();
                                                    i = i4;
                                                    zL = z5 ? 1 : 0;
                                                    str3 = str4;
                                                    aTAdInfoC = aTAdInfo;
                                                    afVar = afVar2;
                                                    com.anythink.core.common.t.f.a(strAR3, str, true, -1, lVar, cVar8, afVar2, strR3, mapA, dVarB, aeVar);
                                                } else {
                                                    i = i4;
                                                    zL = z5 ? 1 : 0;
                                                    aTAdInfoC = aTAdInfo;
                                                    str3 = str4;
                                                    afVar = afVar2;
                                                }
                                                z5 = zL;
                                                str4 = str3;
                                                aTAdInfo = aTAdInfoC;
                                                i4 = i;
                                                byVar2 = byVar2;
                                                afVar2 = afVar;
                                            }
                                            i = i4;
                                            zL = z5 ? 1 : 0;
                                            aTAdInfoC = aTAdInfo;
                                            str3 = str4;
                                            afVar = afVar2;
                                            cVar3 = listA.get(zL ? 1 : 0);
                                            if (aTAdInfoC != null) {
                                                i5 = i;
                                            } else {
                                                i5 = i;
                                            }
                                            if (i5 != 0) {
                                                r1 = arrayList5;
                                                r1.add(cVar3);
                                                r1 = r1;
                                            } else {
                                                r1 = arrayList5;
                                            }
                                        } else {
                                            i = 1;
                                            zL = z5 ? 1 : 0;
                                            aTAdInfoC = aTAdInfo;
                                            str3 = str4;
                                            afVar = afVar2;
                                            r1 = arrayList5;
                                            i5 = 1;
                                        }
                                        if (i5 != 0) {
                                            return r1;
                                        }
                                    } else {
                                        r0 = baseAdObject;
                                        r0 = baseAdObject;
                                        afVar = afVar;
                                        fVar2 = fVar2;
                                        r1 = arrayList5;
                                        zL = z5;
                                        i = 1;
                                        str3 = str8;
                                    }
                                } catch (Throwable unused10) {
                                    lVar = lVarC;
                                    str2 = strM;
                                }
                            } else {
                                str2 = strM;
                                lVar = lVarC;
                            }
                            zL = false;
                            r1 = arrayList5;
                            i = 1;
                            str3 = str8;
                        }
                        if (z) {
                            if (fVar2 != null) {
                                zL = fVar2.l();
                            }
                            if (fVar2 == null) {
                                com.anythink.core.common.t.f.b("AdManage is null--isReady", "Id:" + str3 + "--format:" + lVar.ap(), com.anythink.core.common.d.s.b().r());
                            }
                            if (zL) {
                                i3 = 5;
                            } else {
                                i3 = i;
                            }
                            com.anythink.core.common.t.f.a(str2, str, false, i3, lVar, (com.anythink.core.common.h.c) null, afVar, "", mapA, dVarB, SystemClock.elapsedRealtime() - jElapsedRealtime, aeVar);
                        }
                        if (z2) {
                            if (aTAdInfoC != null) {
                                i2 = 5;
                            } else {
                                i2 = i;
                            }
                            com.anythink.core.common.t.f.a(str2, str, lVar, i2, afVar, mapA, aeVar);
                        }
                        return r1;
                    } catch (Throwable th5) {
                        th = th5;
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            r1 = arrayList5;
        }
        a("checkCache failed in method. size: " + r1.size(), th);
        return r1;
    }

    private static boolean a(af afVar, ATAdInfo aTAdInfo, com.anythink.core.common.h.c cVar) {
        if (aTAdInfo != null && (aTAdInfo instanceof com.anythink.core.common.d.k)) {
            if (!a((com.anythink.core.common.d.k) aTAdInfo, cVar)) {
                a(afVar, -1, cVar.i().N(), cVar.i().Z(), "", false, 7);
                return false;
            }
            cVar.i().as();
        }
        return true;
    }

    private static boolean a(com.anythink.core.common.h.c cVar, af afVar, List<String> list, List<String> list2, com.anythink.core.common.h.c cVar2, ATAdInfo aTAdInfo) {
        com.anythink.core.common.h.n nVarI = cVar.i();
        if (!com.anythink.core.common.u.o.a(list, "66")) {
            a(afVar, -1, nVarI.N(), nVarI.Z(), "", false, 5);
            return false;
        }
        if (com.anythink.core.common.u.o.b(list2, "66")) {
            a(afVar, -1, nVarI.N(), nVarI.Z(), "", false, 6);
            return false;
        }
        if (cVar2 != null) {
            if (TextUtils.equals(cVar2.i().aR(), nVarI.aR()) && TextUtils.equals(cVar2.i().N(), nVarI.N())) {
                nVarI.as();
                return true;
            }
            a(afVar, -1, nVarI.N(), nVarI.Z(), "", false, 7);
            return false;
        }
        if (cVar2 != null || aTAdInfo == null || !(aTAdInfo instanceof com.anythink.core.common.d.k)) {
            return true;
        }
        if (a((com.anythink.core.common.d.k) aTAdInfo, cVar)) {
            nVarI.as();
            return true;
        }
        a(afVar, -1, nVarI.N(), nVarI.Z(), "", false, 7);
        return false;
    }

    private static boolean a(com.anythink.core.common.d.k kVar, com.anythink.core.common.h.c cVar) {
        if (kVar != null && cVar != null) {
            String requestId = kVar.getRequestId();
            String adsourceId = kVar.getAdsourceId();
            com.anythink.core.common.h.n nVarI = cVar.i();
            if (TextUtils.equals(requestId, nVarI.aR()) && TextUtils.equals(adsourceId, nVarI.N())) {
                return true;
            }
        }
        return false;
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, String str, String str2, com.anythink.core.e.l lVar, by byVar, Map<String, Object> map, ae aeVar) {
        Map<String, Object> mapR = this.d.r();
        int[] iArr = {0};
        if (mapR.containsKey(bx.X)) {
            try {
                iArr[0] = ((Integer) mapR.get(bx.X)).intValue();
            } catch (Throwable unused) {
            }
        }
        com.anythink.core.common.h.n nVarA = ai.a(str, str2, lVar, 0, iArr[0], map, null, 0, aeVar != null ? aeVar.d() : null, this.d);
        ai.a(nVarA, byVar, 0, true);
        ai.a(aTBaseAdAdapter, nVarA, byVar);
        nVarA.t = 3;
        nVarA.m(aj.a(byVar, null));
        aTBaseAdAdapter.setRefresh(false);
    }

    private static void a(af afVar, int i, String str, int i2, String str2, boolean z, int i3) {
        afVar.a(i, str, i2, str2, z, i3);
    }

    public final void a(com.anythink.core.common.h.c cVar, int i) {
        if (cVar == null) {
            return;
        }
        com.anythink.core.common.h.n nVarI = cVar.i();
        if (i != 6) {
            b(nVarI.aQ(), cVar.e().getUnitGroupInfo());
        }
        bz bzVar = this.c.get(a(nVarI.aQ(), nVarI.N()));
        if (bzVar == null) {
            return;
        }
        bzVar.a(cVar);
        com.anythink.core.common.h.n nVarI2 = cVar.i();
        if (nVarI2 == null || i == 5) {
            return;
        }
        com.anythink.core.common.t.f.a(nVarI2, i);
    }

    private void a(com.anythink.core.common.h.c cVar) {
        if (cVar == null) {
            return;
        }
        String strAQ = cVar.i().aQ();
        synchronized (this.d.q()) {
            List<com.anythink.core.common.h.c> list = this.b.get(strAQ);
            if (list != null) {
                list.remove(cVar);
            }
        }
    }

    public final void a(String str, by byVar, String str2) {
        synchronized (this.d.q()) {
            List<com.anythink.core.common.h.c> list = this.b.get(str);
            if (list != null) {
                for (com.anythink.core.common.h.c cVar : list) {
                    if (TextUtils.equals(cVar.i().N(), byVar.G()) && TextUtils.equals(cVar.i().aR(), str2)) {
                        a(cVar, 1);
                        a(cVar);
                        cVar.m();
                        return;
                    }
                }
            }
        }
    }

    public final void a(String str, List<ATAdInfo> list, int i) {
        synchronized (this.d.q()) {
            List<com.anythink.core.common.h.c> list2 = this.b.get(str);
            if (list2 == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                ATAdInfo aTAdInfo = list.get(size);
                if (aTAdInfo instanceof com.anythink.core.common.d.k) {
                    com.anythink.core.common.d.k kVar = (com.anythink.core.common.d.k) aTAdInfo;
                    String requestId = kVar.getRequestId();
                    String adsourceId = kVar.getAdsourceId();
                    if (!TextUtils.isEmpty(requestId) && !TextUtils.isEmpty(adsourceId)) {
                        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                            com.anythink.core.common.h.c cVar = list2.get(size2);
                            com.anythink.core.common.h.n nVarI = cVar.i();
                            if (TextUtils.equals(adsourceId, nVarI.N()) && TextUtils.equals(requestId, nVarI.aR())) {
                                list2.remove(size2);
                                com.anythink.core.c.d.c.a(cVar, i);
                                a(cVar, i);
                                cVar.m();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(Context context, com.anythink.core.common.h.c cVar) {
        ATBaseAdAdapter aTBaseAdAdapterE = cVar.e();
        com.anythink.core.common.h.n nVarI = cVar.i();
        by unitGroupInfo = aTBaseAdAdapterE != null ? aTBaseAdAdapterE.getUnitGroupInfo() : null;
        if (nVarI != null) {
            String strAQ = nVarI.aQ();
            String strAR = nVarI.aR();
            f fVar = this.d;
            if (fVar != null) {
                fVar.a(strAR, unitGroupInfo != null ? com.anythink.core.common.u.o.a(unitGroupInfo) : 0.0d, unitGroupInfo);
            } else {
                com.anythink.core.common.t.f.b("AdManage is null--Show", "Id:" + strAQ + "--format:" + nVarI.aS() + "--adsource:" + nVarI.N(), com.anythink.core.common.d.s.b().r());
            }
            if (fVar != null) {
                fVar.a(strAR, a(strAQ));
            }
            com.anythink.core.a.a.a(context);
            com.anythink.core.a.a.a(nVarI, nVarI.aS(), nVarI.aQ(), nVarI.N());
            a(cVar, 5);
            a(cVar);
        }
    }

    public final bz a(String str, by byVar) {
        return this.c.get(a(str, byVar.G()));
    }

    private void b(String str, by byVar) {
        if (byVar == null) {
            return;
        }
        int iY = byVar.y();
        if (iY == 3 || iY == 7) {
            ad adVarY = byVar.Y();
            f fVar = this.d;
            if (fVar != null && fVar.d() != null) {
                this.d.d().a(str, byVar.G());
            }
            if (adVarY == null || TextUtils.isEmpty(adVarY.token)) {
                return;
            }
            com.anythink.core.common.a.a.a().a(com.anythink.core.common.d.s.b().g(), adVarY.token);
        }
    }

    private static String a(String str, String str2) {
        return str + str2;
    }

    private static void a(String str, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(th.getMessage());
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString() + "\n");
            }
        }
        com.anythink.core.common.t.f.b(str, sb.toString(), com.anythink.core.common.d.s.b().r());
    }

    private void a(String str, int i) {
        f fVar;
        List<ATAdInfo> listA;
        if (TextUtils.isEmpty(str) || com.anythink.core.common.d.s.b().g() == null || (fVar = this.d) == null || (listA = fVar.a(str, i, false)) == null || listA.isEmpty()) {
            return;
        }
        a(str, listA, 3);
    }

    public final List<com.anythink.core.common.h.c> a(String str, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list, long j, int i) {
        List<com.anythink.core.common.h.c> listA;
        int size;
        f fVar;
        List<ATAdInfo> listA2;
        boolean z = true;
        if (i != -1 && (listA = a(str)) != null && !listA.isEmpty() && (size = listA.size()) >= i) {
            if (com.anythink.core.common.u.k.a(aTBaseAdAdapter.getUnitGroupInfo(), listA.get(size - 1).o()) == -1) {
                int iMax = Math.max(i - 2, -1);
                if (!TextUtils.isEmpty(str) && com.anythink.core.common.d.s.b().g() != null && (fVar = this.d) != null && (listA2 = fVar.a(str, iMax, false)) != null && !listA2.isEmpty()) {
                    a(str, listA2, 3);
                }
            } else {
                z = false;
            }
        }
        if (!z) {
            com.anythink.core.common.h.c cVarA = a(aTBaseAdAdapter, j);
            cVarA.m();
            com.anythink.core.c.d.c.a(cVarA, 3);
            com.anythink.core.common.t.f.b(cVarA.i(), "2");
            return new ArrayList();
        }
        return a(str, aTBaseAdAdapter, list, j);
    }
}
