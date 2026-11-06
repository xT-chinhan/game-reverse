package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.br;
import com.anythink.core.common.h.bu;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bw;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.ak;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a a;
    private final String b = getClass().getSimpleName();
    private ConcurrentHashMap<String, List<com.anythink.core.common.h.c>> c = new ConcurrentHashMap<>(2);
    private ConcurrentHashMap<String, bw> d = new ConcurrentHashMap<>(2);

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private a() {
    }

    private static com.anythink.core.common.h.c a(ATBaseAdAdapter aTBaseAdAdapter, long j) {
        com.anythink.core.common.h.c cVar = new com.anythink.core.common.h.c();
        cVar.a(aTBaseAdAdapter);
        cVar.c(System.currentTimeMillis());
        cVar.b(j);
        cVar.a(aTBaseAdAdapter.getUnitGroupInfo().G());
        return cVar;
    }

    private static boolean a(String str, int i, ATBaseAdAdapter aTBaseAdAdapter) {
        List<com.anythink.core.common.h.c> listA;
        int size;
        if (i == -1 || (listA = a().a(str)) == null || listA.isEmpty() || (size = listA.size()) < i) {
            return true;
        }
        if (!(com.anythink.core.common.v.l.a(aTBaseAdAdapter.getUnitGroupInfo(), listA.get(size - 1).o()) == -1)) {
            return false;
        }
        int i2 = i - 2;
        Math.max(i2, -1);
        a().a(str, Math.max(i2, -1), false, 11);
        return true;
    }

    private List<com.anythink.core.common.h.c> a(String str, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list, long j) {
        bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        String strA = a(str, aTBaseAdAdapter.getUnitGroupInfo().z());
        bw bwVar = this.d.get(strA);
        if (bwVar == null) {
            bwVar = new bw(str, unitGroupInfo.z());
            this.d.put(strA, bwVar);
        }
        bwVar.a(unitGroupInfo.ay());
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (BaseAd baseAd : list) {
                baseAd.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().af());
                com.anythink.core.common.h.c cVarA = a(aTBaseAdAdapter, j);
                cVarA.a(baseAd);
                arrayList.add(cVarA);
            }
            bwVar.a(trackingInfo.aJ(), new br(trackingInfo.aJ(), arrayList));
        } else {
            arrayList.add(a(aTBaseAdAdapter, j));
            bwVar.a(trackingInfo.aJ(), new br(trackingInfo.aJ(), arrayList));
        }
        if (arrayList.size() == 0) {
            return arrayList;
        }
        a(str, arrayList);
        return arrayList;
    }

    private void a(String str, List<com.anythink.core.common.h.c> list) {
        synchronized (u.a().a(str)) {
            List<com.anythink.core.common.h.c> listSynchronizedList = this.c.get(str);
            if (listSynchronizedList == null) {
                listSynchronizedList = Collections.synchronizedList(new ArrayList());
                this.c.put(str, listSynchronizedList);
            }
            if (listSynchronizedList.size() == 0) {
                listSynchronizedList.addAll(list);
            } else {
                bv unitGroupInfo = list.get(0).e().getUnitGroupInfo();
                for (int i = 0; i < listSynchronizedList.size(); i++) {
                    bv unitGroupInfo2 = listSynchronizedList.get(i).e().getUnitGroupInfo();
                    int iB = com.anythink.core.common.v.l.b(unitGroupInfo, unitGroupInfo2);
                    if (iB < 0) {
                        listSynchronizedList.addAll(i, list);
                        break;
                    }
                    if (iB == 0 && unitGroupInfo.aw() < unitGroupInfo2.aw()) {
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
        List<com.anythink.core.common.h.c> list = this.c.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        Object objA = u.a().a(str);
        ArrayList arrayList = new ArrayList();
        synchronized (objA) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public final void b(String str) {
        synchronized (u.a().a(str)) {
            List<com.anythink.core.common.h.c> list = this.c.get(str);
            if (list != null) {
                Collections.sort(list);
            }
        }
    }

    public final com.anythink.core.common.h.c a(Context context, String str) {
        synchronized (u.a().a(str)) {
            List<com.anythink.core.common.h.c> listA = a(context, str, false, false, false, (ae) null);
            if (listA == null || listA.size() <= 0) {
                return null;
            }
            return listA.get(0);
        }
    }

    public final com.anythink.core.common.h.c a(Context context, String str, boolean z, boolean z2, ae aeVar) {
        synchronized (u.a().a(str)) {
            List<com.anythink.core.common.h.c> listA = a(context, str, z, z2, false, aeVar);
            if (listA == null || listA.size() <= 0) {
                return null;
            }
            return listA.get(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:205:0x0535  */
    /* JADX WARN: Code duplicated, block: B:247:0x0606 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:248:0x0608 A[Catch: all -> 0x0715, TryCatch #8 {all -> 0x0715, blocks: (B:227:0x05af, B:230:0x05d4, B:233:0x05e6, B:248:0x0608, B:249:0x061c, B:241:0x05f9, B:237:0x05f2), top: B:332:0x05af, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:253:0x063a A[Catch: all -> 0x070e, TryCatch #7 {all -> 0x070e, blocks: (B:251:0x0630, B:253:0x063a, B:254:0x063e), top: B:330:0x0630 }] */
    /* JADX WARN: Code duplicated, block: B:258:0x065c A[Catch: all -> 0x0697, TRY_LEAVE, TryCatch #10 {all -> 0x0697, blocks: (B:256:0x0644, B:258:0x065c), top: B:336:0x0644 }] */
    /* JADX WARN: Code duplicated, block: B:261:0x0686  */
    /* JADX WARN: Code duplicated, block: B:269:0x06b4 A[Catch: all -> 0x072b, TryCatch #6 {all -> 0x072b, blocks: (B:267:0x06b0, B:269:0x06b4, B:271:0x06bd, B:275:0x06fb, B:272:0x06e6), top: B:328:0x06b0 }] */
    /* JADX WARN: Code duplicated, block: B:271:0x06bd A[Catch: all -> 0x072b, TryCatch #6 {all -> 0x072b, blocks: (B:267:0x06b0, B:269:0x06b4, B:271:0x06bd, B:275:0x06fb, B:272:0x06e6), top: B:328:0x06b0 }] */
    /* JADX WARN: Code duplicated, block: B:272:0x06e6 A[Catch: all -> 0x072b, TryCatch #6 {all -> 0x072b, blocks: (B:267:0x06b0, B:269:0x06b4, B:271:0x06bd, B:275:0x06fb, B:272:0x06e6), top: B:328:0x06b0 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:275:0x06fb A[Catch: all -> 0x072b, TRY_LEAVE, TryCatch #6 {all -> 0x072b, blocks: (B:267:0x06b0, B:269:0x06b4, B:271:0x06bd, B:275:0x06fb, B:272:0x06e6), top: B:328:0x06b0 }] */
    /* JADX WARN: Code duplicated, block: B:278:0x0702  */
    /* JADX WARN: Code duplicated, block: B:280:0x070c A[Catch: all -> 0x07a1, DONT_GENERATE, TRY_ENTER, TryCatch #0 {all -> 0x07a1, blocks: (B:289:0x0730, B:292:0x0738, B:297:0x0769, B:302:0x078e, B:303:0x079f, B:280:0x070c), top: B:318:0x04b6 }] */
    /* JADX WARN: Code duplicated, block: B:283:0x0715 A[PHI: r14
      0x0715: PHI (r14v6 int) = (r14v5 int), (r14v7 int) binds: [B:316:0x0715, B:246:0x0604] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:284:0x071e  */
    /* JADX WARN: Code duplicated, block: B:328:0x06b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:336:0x0644 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.anythink.core.api.BaseAd, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.anythink.core.d.l] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.anythink.core.d.l] */
    /* JADX WARN: Type inference failed for: r34v2, types: [com.anythink.core.d.l] */
    /* JADX WARN: Type inference failed for: r34v4, types: [com.anythink.core.d.l] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List<com.anythink.core.common.h.c>] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.List<com.anythink.core.common.h.c>] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.anythink.core.d.l] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.ArrayList, java.util.List, java.util.List<com.anythink.core.common.h.c>] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final List<com.anythink.core.common.h.c> a(Context context, String str, boolean z, boolean z2, boolean z3, ae aeVar) {
        Map<String, Object> mapA;
        Throwable th;
        com.anythink.core.common.h.c cVar;
        List<String> list;
        List<String> list2;
        com.anythink.core.common.h.c cVar2;
        boolean z4;
        int i;
        String str2;
        ATAdInfo aTAdInfo;
        ?? r10;
        boolean zG;
        bv next;
        bv bvVar;
        ATBaseAdAdapter aTBaseAdAdapter;
        int i2;
        ArrayList arrayList;
        bv bvVar2;
        ?? InternalIsAdReady;
        ?? r11;
        ?? r0;
        List<? extends BaseAd> list3;
        ATAdInfo aTAdInfo2;
        String str3;
        int i3;
        ?? r9;
        List<com.anythink.core.common.h.c> listA;
        int i4;
        ATAdInfo aTAdInfo3;
        com.anythink.core.common.h.c cVar3;
        com.anythink.core.common.h.n nVarI;
        BaseAd baseAdObject;
        boolean z5;
        com.anythink.core.common.h.c cVar4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i5;
        int i6;
        int i7;
        com.anythink.core.common.h.c cVar5;
        ArrayList arrayList4;
        ArrayList arrayList5;
        String str4 = str;
        ?? arrayList6 = new ArrayList();
        try {
            Object objA = u.a().a(str4);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            synchronized (objA) {
                if (aeVar != null) {
                    try {
                        mapA = aeVar.a();
                    } catch (Throwable th2) {
                        th = th2;
                        arrayList6 = arrayList6;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                            a("checkCache failed in method. size: " + arrayList6.size(), th);
                            return arrayList6;
                        }
                    }
                } else {
                    mapA = null;
                }
                com.anythink.core.common.h.d dVarB = aeVar != null ? aeVar.b() : null;
                ATAdInfo aTAdInfoC = aeVar != null ? aeVar.c() : null;
                arrayList6 = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(str4);
                if (arrayList6 == 0) {
                    return null;
                }
                List<String> listO = com.anythink.core.common.d.t.b().o(str4);
                List<String> listP = com.anythink.core.common.d.t.b().p(str4);
                com.anythink.core.common.h.c cVarA = com.anythink.core.common.a.c.a().a(str4);
                List<com.anythink.core.common.h.c> list4 = this.c.get(str4);
                JSONArray jSONArray = new JSONArray();
                if (list4 == null || list4.isEmpty()) {
                    cVar = cVarA;
                    list = listP;
                    list2 = listO;
                    cVar2 = null;
                } else {
                    ArrayList arrayList7 = new ArrayList(list4);
                    ArrayList arrayList8 = new ArrayList();
                    cVar2 = null;
                    int i8 = 0;
                    while (i8 < arrayList7.size()) {
                        com.anythink.core.common.h.c cVar6 = (com.anythink.core.common.h.c) arrayList7.get(i8);
                        if (cVar6 == null) {
                            arrayList8.add(Integer.valueOf(i8));
                            arrayList2 = arrayList8;
                            arrayList3 = arrayList7;
                        } else {
                            bv unitGroupInfo = cVar6.e().getUnitGroupInfo();
                            int iAx = unitGroupInfo.ax();
                            bv bvVarA = arrayList6.a(unitGroupInfo.z());
                            com.anythink.core.a.d.a();
                            arrayList2 = arrayList8;
                            int iA = com.anythink.core.a.d.a(str4, bvVarA != null ? bvVarA : unitGroupInfo);
                            arrayList3 = arrayList7;
                            if (iA != -1) {
                                a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), "", false, iA);
                            } else {
                                com.anythink.core.a.a aVarA = com.anythink.core.a.a.a(com.anythink.core.common.d.t.b().g());
                                if (bvVarA == null) {
                                    bvVarA = unitGroupInfo;
                                }
                                int iA2 = aVarA.a(str4, bvVarA, arrayList6.aq());
                                if (iA2 != -1) {
                                    a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), "", false, iA2);
                                } else {
                                    if (listO == null || listO.size() <= 0) {
                                        i5 = 0;
                                    } else if (listO.contains(String.valueOf(unitGroupInfo.g()))) {
                                        i5 = 1;
                                    } else {
                                        a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), "", false, 5);
                                    }
                                    if (listP == null || listP.size() <= 0) {
                                        i6 = i5;
                                    } else if (listP.contains(String.valueOf(unitGroupInfo.g()))) {
                                        a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), "", false, 6);
                                    } else {
                                        i6 = 2;
                                    }
                                    Pair<Integer, List<String>> pairI = com.anythink.core.common.d.t.b().I();
                                    if (pairI != null) {
                                        i7 = i6;
                                        if (((Integer) pairI.first).intValue() == 1) {
                                            List list5 = (List) pairI.second;
                                            if (list5 != null && !list5.isEmpty()) {
                                                if (list5.contains(String.valueOf(unitGroupInfo.g()))) {
                                                    a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), "", false, 28);
                                                }
                                            } else {
                                                a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), "", false, 27);
                                            }
                                        }
                                        cVarA = cVarA;
                                        arrayList8 = arrayList4;
                                        arrayList7 = arrayList3;
                                        listP = listP;
                                        listO = listO;
                                        str4 = str;
                                        i8++;
                                    } else {
                                        i7 = i6;
                                    }
                                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                    boolean zG2 = cVar6.g();
                                    boolean zJ = cVar6.j();
                                    com.anythink.core.common.h.n nVarI2 = cVar6.i();
                                    if (aTAdInfoC == null || !(aTAdInfoC instanceof com.anythink.core.common.d.l)) {
                                        cVar5 = cVar2;
                                    } else if (!a((com.anythink.core.common.d.l) aTAdInfoC, cVar6)) {
                                        a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), "", false, 7);
                                    } else {
                                        nVarI2.ao();
                                        new StringBuilder("checkCache, find expect ad cache: ").append(cVar6);
                                        cVar5 = cVar6;
                                    }
                                    if (zG2 && zJ) {
                                        if (z) {
                                            arrayList5 = arrayList2;
                                            com.anythink.core.common.u.e.a(com.anythink.core.common.o.c.b, nVarI2, nVarI2.aJ(), str, nVarI2.M(), nVarI2.Y(), arrayList6.aq(), SystemClock.elapsedRealtime() - jElapsedRealtime2);
                                        } else {
                                            arrayList5 = arrayList2;
                                        }
                                        a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), cVar6.e().getInternalNetworkSDKVersion(), true, -1);
                                        nVarI2.w(jSONArray.toString());
                                        nVarI2.y(iAx);
                                        nVarI2.V(i7);
                                        if (!z3) {
                                            if (cVarA != 0 && com.anythink.core.common.v.l.a(cVarA.e().getUnitGroupInfo(), cVar6.e().getUnitGroupInfo()) < 0 && a(cVarA, jSONArray, listO, listP, cVar5, aTAdInfoC)) {
                                                arrayList6.add(cVarA);
                                            } else {
                                                arrayList6.add(cVar6);
                                            }
                                            if (z) {
                                                com.anythink.core.common.u.e.a(nVarI2.aJ(), str, true, -1, (com.anythink.core.d.l) arrayList6, arrayList6.size() > 0 ? (com.anythink.core.common.h.c) arrayList6.get(0) : null, jSONArray.toString(), "", mapA, dVarB, SystemClock.elapsedRealtime() - jElapsedRealtime, aeVar);
                                            }
                                            return arrayList6;
                                        }
                                        arrayList6.add(cVar6);
                                        arrayList4 = arrayList5;
                                    } else {
                                        i8 = i8;
                                        cVarA = cVarA;
                                        listP = listP;
                                        listO = listO;
                                        arrayList3 = arrayList3;
                                        if (z) {
                                            com.anythink.core.common.u.e.a(com.anythink.core.common.o.c.c, nVarI2, nVarI2.aJ(), str, nVarI2.M(), nVarI2.Y(), arrayList6.aq(), SystemClock.elapsedRealtime() - jElapsedRealtime2);
                                        }
                                        int iC = cVar6.c();
                                        cVar6.h();
                                        if (iC <= 0) {
                                            com.anythink.core.b.d.c.a(cVar6);
                                        }
                                        if (cVar6.e() != null) {
                                            com.anythink.core.common.v.d.a().d(cVar6.e());
                                        }
                                        a(cVar6);
                                        if (iC == 0) {
                                            a(jSONArray, iAx, unitGroupInfo.z(), unitGroupInfo.g(), "", false, !zG2 ? 0 : 1);
                                        }
                                        arrayList4 = arrayList2;
                                        arrayList4.add(Integer.valueOf(i8));
                                    }
                                    cVar2 = cVar5;
                                    cVarA = cVarA;
                                    arrayList8 = arrayList4;
                                    arrayList7 = arrayList3;
                                    listP = listP;
                                    listO = listO;
                                    str4 = str;
                                    i8++;
                                }
                            }
                        }
                        i8 = i8;
                        cVarA = cVarA;
                        listP = listP;
                        listO = listO;
                        arrayList4 = arrayList2;
                        arrayList3 = arrayList3;
                        cVarA = cVarA;
                        arrayList8 = arrayList4;
                        arrayList7 = arrayList3;
                        listP = listP;
                        listO = listO;
                        str4 = str;
                        i8++;
                    }
                    ArrayList arrayList9 = arrayList8;
                    cVar = cVarA;
                    list = listP;
                    list2 = listO;
                    if (!arrayList9.isEmpty()) {
                        for (int i9 = 0; i9 < arrayList9.size(); i9++) {
                            try {
                                int iIntValue = ((Integer) arrayList9.get(i9)).intValue();
                                if (list4.size() > iIntValue && (cVar4 = list4.get(iIntValue)) != null) {
                                    list4.remove(cVar4);
                                }
                            } catch (Throwable th4) {
                                a("checkCache failed in remove operate", th4);
                            }
                        }
                    }
                }
                if (z3) {
                    if (cVar != null) {
                        if (arrayList6.size() != 0) {
                            com.anythink.core.common.h.c cVar7 = (com.anythink.core.common.h.c) arrayList6.get(0);
                            if (cVar7 != null) {
                                boolean z6 = com.anythink.core.common.v.l.a(cVar.e().getUnitGroupInfo(), cVar7.e().getUnitGroupInfo()) < 0;
                                z5 = z6;
                            } else {
                                z5 = false;
                            }
                        } else {
                            z5 = z6;
                        }
                        if (z5 && a(cVar, jSONArray, list2, list, cVar2, aTAdInfoC)) {
                            arrayList6.add(cVar);
                        }
                    }
                    return arrayList6;
                }
                if (cVar != null && a(cVar, jSONArray, list2, list, (com.anythink.core.common.h.c) null, aTAdInfoC)) {
                    arrayList6.add(cVar);
                    if (z) {
                        com.anythink.core.common.u.e.a(cVar.e().getTrackingInfo().aJ(), str, true, -1, (com.anythink.core.d.l) arrayList6, cVar, jSONArray.toString(), "", mapA, dVarB, SystemClock.elapsedRealtime() - jElapsedRealtime, aeVar);
                    }
                    return arrayList6;
                }
                int i10 = 1;
                if (arrayList6.ak() == 1) {
                    z4 = true;
                } else {
                    z4 = arrayList6.ak() == 2 ? z2 : false;
                }
                List<bv> listX = arrayList6.x();
                f fVarA = u.a().a(str, new StringBuilder().append(arrayList6.aq()).toString());
                String strH = (fVarA == null || fVarA.h() == null) ? "" : fVarA.h();
                try {
                    if (listX == null || listX.size() <= 0 || !z4) {
                        i = 0;
                        ATAdInfo aTAdInfo4 = aTAdInfoC;
                        str2 = str;
                        aTAdInfo = aTAdInfo4;
                    } else {
                        String strA = r.a().a(context, str);
                        if (TextUtils.isEmpty(strA)) {
                            next = null;
                            break;
                        }
                        Iterator<bv> it = listX.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (next.k() != null && next.k().contains(strA)) {
                                break;
                            }
                        }
                        if (next == null) {
                            bvVar = next;
                        } else {
                            if (!com.anythink.core.common.v.p.a(list2, "35")) {
                                a(jSONArray, -1, next.z(), next.g(), "", false, 5);
                            } else if (com.anythink.core.common.v.p.b(list, "35")) {
                                a(jSONArray, -1, next.z(), next.g(), "", false, 6);
                            } else {
                                bvVar = next;
                            }
                            bvVar = null;
                        }
                        if (bvVar != null) {
                            Map<String, Object> mapA2 = arrayList6.a(str, strH, bvVar, aeVar != null ? aeVar.d() : null);
                            mapA2.put(r.b, Boolean.TRUE);
                            try {
                                com.anythink.core.common.h.p pVarA = com.anythink.core.common.v.u.a(bvVar);
                                ATBaseAdAdapter aTBaseAdAdapter2 = pVarA != null ? pVarA.a : null;
                                boolean zInternalInitNetworkObjectByPlacementId = aTBaseAdAdapter2.internalInitNetworkObjectByPlacementId(context, mapA2, u.a().b(str));
                                if (zInternalInitNetworkObjectByPlacementId) {
                                    Map<String, Object> mapB = u.a().b(str);
                                    int[] iArr = {0};
                                    if (mapB.containsKey(bu.S)) {
                                        try {
                                            iArr[0] = ((Integer) mapB.get(bu.S)).intValue();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    ATBaseAdAdapter aTBaseAdAdapter3 = aTBaseAdAdapter2;
                                    bv bvVar3 = bvVar;
                                    try {
                                        com.anythink.core.common.h.n nVarA = aj.a(strH, str, arrayList6, 0, iArr[0], mapA, null, 0, aeVar != null ? aeVar.d() : null);
                                        bvVar2 = bvVar3;
                                        i2 = 0;
                                        try {
                                            aj.a(nVarA, bvVar2, 0, true);
                                            aTBaseAdAdapter = aTBaseAdAdapter3;
                                            aj.a(aTBaseAdAdapter, nVarA, bvVar2);
                                            nVarA.t = 3;
                                            arrayList = null;
                                            nVarA.m(ak.a(bvVar2, (ATBaseAdAdapter) null));
                                            aTBaseAdAdapter.setRefresh(false);
                                        } catch (Throwable unused2) {
                                        }
                                    } catch (Throwable unused3) {
                                        i = 0;
                                    }
                                } else {
                                    aTBaseAdAdapter = aTBaseAdAdapter2;
                                    i2 = 0;
                                    arrayList = null;
                                    bvVar2 = bvVar;
                                }
                                if (TextUtils.equals(String.valueOf(arrayList6.aq()), "0")) {
                                    if (zInternalInitNetworkObjectByPlacementId) {
                                        baseAdObject = aTBaseAdAdapter.getBaseAdObject(context);
                                        if (baseAdObject != null) {
                                            r11 = 1;
                                        }
                                        if (r11 != 0) {
                                            if (r0 != 0) {
                                                ArrayList arrayList10 = new ArrayList();
                                                r0.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().af());
                                                arrayList10.add(r0);
                                                arrayList = arrayList10;
                                            }
                                            strH = strH;
                                            arrayList6 = arrayList6;
                                            ATBaseAdAdapter aTBaseAdAdapter4 = aTBaseAdAdapter;
                                            aTAdInfo2 = aTAdInfoC;
                                            ArrayList arrayList11 = arrayList;
                                            str3 = str;
                                            i3 = 1;
                                            r9 = arrayList6;
                                            try {
                                                listA = a(str, aTBaseAdAdapter4, arrayList11, bvVar2.u());
                                                if (listA.size() > 0) {
                                                    r9 = r9;
                                                    for (com.anythink.core.common.h.c cVar8 : listA) {
                                                        try {
                                                            nVarI = cVar8.i();
                                                            nVarI.C = i3;
                                                            nVarI.y(i2);
                                                            nVarI.w(jSONArray.toString());
                                                            if (z) {
                                                                String strAJ = nVarI.aJ();
                                                                i10 = i3;
                                                                arrayList6 = r9;
                                                                str2 = str3;
                                                                aTAdInfo3 = aTAdInfo2;
                                                                i = i2;
                                                                try {
                                                                    com.anythink.core.common.u.e.a(strAJ, str, true, -1, (com.anythink.core.d.l) arrayList6, cVar8, jSONArray.toString(), bvVar2.k(), mapA, dVarB, aeVar);
                                                                } catch (Throwable unused4) {
                                                                    aTAdInfo = aTAdInfo3;
                                                                }
                                                            } else {
                                                                i10 = i3;
                                                                arrayList6 = r9;
                                                                str2 = str3;
                                                                aTAdInfo3 = aTAdInfo2;
                                                                i = i2;
                                                            }
                                                            i2 = i;
                                                            r9 = arrayList6;
                                                            str3 = str2;
                                                            bvVar2 = bvVar2;
                                                            i3 = i10;
                                                            aTAdInfo2 = aTAdInfo3;
                                                        } catch (Throwable unused5) {
                                                            i10 = i3;
                                                            arrayList6 = r9;
                                                            str2 = str3;
                                                            i = i2;
                                                            aTAdInfo = aTAdInfo2;
                                                        }
                                                    }
                                                    i10 = i3;
                                                    arrayList6 = r9;
                                                    str2 = str3;
                                                    aTAdInfo3 = aTAdInfo2;
                                                    i = i2;
                                                    cVar3 = listA.get(i);
                                                    aTAdInfo = aTAdInfo3;
                                                    if (aTAdInfo != null) {
                                                        try {
                                                            if (!(aTAdInfo instanceof com.anythink.core.common.d.l)) {
                                                                i4 = i10;
                                                            } else if (!a((com.anythink.core.common.d.l) aTAdInfo, cVar3)) {
                                                                a(jSONArray, -1, cVar3.i().M(), cVar3.i().Y(), "", false, 7);
                                                                new StringBuilder("canUseDefaultMyoffer, not expect ad cache: ").append(cVar3);
                                                                i4 = i;
                                                            } else {
                                                                cVar3.i().ao();
                                                                new StringBuilder("canUseDefaultMyoffer, find expect ad cache: ").append(cVar3);
                                                                i4 = i10;
                                                            }
                                                            if (i4 != 0) {
                                                                arrayList6.add(cVar3);
                                                            }
                                                        } catch (Throwable unused6) {
                                                        }
                                                    } else {
                                                        i4 = i10;
                                                        if (i4 != 0) {
                                                            arrayList6.add(cVar3);
                                                        }
                                                    }
                                                    return arrayList6;
                                                }
                                                i10 = 1;
                                                arrayList6 = r9;
                                                str2 = str3;
                                                aTAdInfo = aTAdInfo2;
                                                i = i2;
                                                i4 = 1;
                                                if (i4 != 0) {
                                                    return arrayList6;
                                                }
                                            } catch (Throwable unused7) {
                                                i10 = i3;
                                                arrayList6 = r9;
                                                str2 = str3;
                                                aTAdInfo = aTAdInfo2;
                                                i = i2;
                                            }
                                        } else {
                                            list3 = baseAdObject;
                                            r0 = baseAdObject;
                                            i = i2;
                                            ATAdInfo aTAdInfo5 = aTAdInfoC;
                                            str2 = str;
                                            aTAdInfo = aTAdInfo5;
                                        }
                                    } else {
                                        list3 = arrayList;
                                    }
                                    list3 = baseAdObject;
                                    r11 = i2;
                                    r0 = list3;
                                    if (r11 != 0) {
                                        if (r0 != 0) {
                                            ArrayList arrayList12 = new ArrayList();
                                            r0.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().af());
                                            arrayList12.add(r0);
                                            arrayList = arrayList12;
                                        }
                                        strH = strH;
                                        arrayList6 = arrayList6;
                                        ATBaseAdAdapter aTBaseAdAdapter5 = aTBaseAdAdapter;
                                        aTAdInfo2 = aTAdInfoC;
                                        ArrayList arrayList13 = arrayList;
                                        str3 = str;
                                        i3 = 1;
                                        r9 = arrayList6;
                                        listA = a(str, aTBaseAdAdapter5, arrayList13, bvVar2.u());
                                        if (listA.size() > 0) {
                                            r9 = r9;
                                            while (r1.hasNext()) {
                                                nVarI = cVar8.i();
                                                nVarI.C = i3;
                                                nVarI.y(i2);
                                                nVarI.w(jSONArray.toString());
                                                if (z) {
                                                    String strAJ2 = nVarI.aJ();
                                                    i10 = i3;
                                                    arrayList6 = r9;
                                                    str2 = str3;
                                                    aTAdInfo3 = aTAdInfo2;
                                                    i = i2;
                                                    com.anythink.core.common.u.e.a(strAJ2, str, true, -1, (com.anythink.core.d.l) arrayList6, cVar8, jSONArray.toString(), bvVar2.k(), mapA, dVarB, aeVar);
                                                } else {
                                                    i10 = i3;
                                                    arrayList6 = r9;
                                                    str2 = str3;
                                                    aTAdInfo3 = aTAdInfo2;
                                                    i = i2;
                                                }
                                                i2 = i;
                                                r9 = arrayList6;
                                                str3 = str2;
                                                bvVar2 = bvVar2;
                                                i3 = i10;
                                                aTAdInfo2 = aTAdInfo3;
                                            }
                                            i10 = i3;
                                            arrayList6 = r9;
                                            str2 = str3;
                                            aTAdInfo3 = aTAdInfo2;
                                            i = i2;
                                            cVar3 = listA.get(i);
                                            aTAdInfo = aTAdInfo3;
                                            if (aTAdInfo != null) {
                                                if (!(aTAdInfo instanceof com.anythink.core.common.d.l)) {
                                                    i4 = i10;
                                                } else if (!a((com.anythink.core.common.d.l) aTAdInfo, cVar3)) {
                                                    a(jSONArray, -1, cVar3.i().M(), cVar3.i().Y(), "", false, 7);
                                                    new StringBuilder("canUseDefaultMyoffer, not expect ad cache: ").append(cVar3);
                                                    i4 = i;
                                                } else {
                                                    cVar3.i().ao();
                                                    new StringBuilder("canUseDefaultMyoffer, find expect ad cache: ").append(cVar3);
                                                    i4 = i10;
                                                }
                                                if (i4 != 0) {
                                                    arrayList6.add(cVar3);
                                                }
                                            } else {
                                                i4 = i10;
                                                if (i4 != 0) {
                                                    arrayList6.add(cVar3);
                                                }
                                            }
                                            return arrayList6;
                                        }
                                        i10 = 1;
                                        arrayList6 = r9;
                                        str2 = str3;
                                        aTAdInfo = aTAdInfo2;
                                        i = i2;
                                        i4 = 1;
                                        if (i4 != 0) {
                                            return arrayList6;
                                        }
                                    } else {
                                        list3 = baseAdObject;
                                        r0 = baseAdObject;
                                        i = i2;
                                        ATAdInfo aTAdInfo6 = aTAdInfoC;
                                        str2 = str;
                                        aTAdInfo = aTAdInfo6;
                                    }
                                } else {
                                    if (zInternalInitNetworkObjectByPlacementId) {
                                        try {
                                            InternalIsAdReady = aTBaseAdAdapter.internalIsAdReady();
                                        } catch (Throwable th5) {
                                            a("checkCache failed in network is ready", th5);
                                            list3 = arrayList;
                                            list3 = baseAdObject;
                                            r11 = i2;
                                            r0 = list3;
                                        }
                                    } else {
                                        InternalIsAdReady = i2;
                                    }
                                    r11 = InternalIsAdReady;
                                    r0 = arrayList;
                                    if (r11 != 0) {
                                        if (r0 != 0) {
                                            ArrayList arrayList14 = new ArrayList();
                                            r0.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().af());
                                            arrayList14.add(r0);
                                            arrayList = arrayList14;
                                        }
                                        strH = strH;
                                        arrayList6 = arrayList6;
                                        ATBaseAdAdapter aTBaseAdAdapter6 = aTBaseAdAdapter;
                                        aTAdInfo2 = aTAdInfoC;
                                        ArrayList arrayList15 = arrayList;
                                        str3 = str;
                                        i3 = 1;
                                        r9 = arrayList6;
                                        listA = a(str, aTBaseAdAdapter6, arrayList15, bvVar2.u());
                                        if (listA.size() > 0) {
                                            r9 = r9;
                                            while (r1.hasNext()) {
                                                nVarI = cVar8.i();
                                                nVarI.C = i3;
                                                nVarI.y(i2);
                                                nVarI.w(jSONArray.toString());
                                                if (z) {
                                                    String strAJ3 = nVarI.aJ();
                                                    i10 = i3;
                                                    arrayList6 = r9;
                                                    str2 = str3;
                                                    aTAdInfo3 = aTAdInfo2;
                                                    i = i2;
                                                    com.anythink.core.common.u.e.a(strAJ3, str, true, -1, (com.anythink.core.d.l) arrayList6, cVar8, jSONArray.toString(), bvVar2.k(), mapA, dVarB, aeVar);
                                                } else {
                                                    i10 = i3;
                                                    arrayList6 = r9;
                                                    str2 = str3;
                                                    aTAdInfo3 = aTAdInfo2;
                                                    i = i2;
                                                }
                                                i2 = i;
                                                r9 = arrayList6;
                                                str3 = str2;
                                                bvVar2 = bvVar2;
                                                i3 = i10;
                                                aTAdInfo2 = aTAdInfo3;
                                            }
                                            i10 = i3;
                                            arrayList6 = r9;
                                            str2 = str3;
                                            aTAdInfo3 = aTAdInfo2;
                                            i = i2;
                                            cVar3 = listA.get(i);
                                            aTAdInfo = aTAdInfo3;
                                            if (aTAdInfo != null) {
                                                if (!(aTAdInfo instanceof com.anythink.core.common.d.l)) {
                                                    i4 = i10;
                                                } else if (!a((com.anythink.core.common.d.l) aTAdInfo, cVar3)) {
                                                    a(jSONArray, -1, cVar3.i().M(), cVar3.i().Y(), "", false, 7);
                                                    new StringBuilder("canUseDefaultMyoffer, not expect ad cache: ").append(cVar3);
                                                    i4 = i;
                                                } else {
                                                    cVar3.i().ao();
                                                    new StringBuilder("canUseDefaultMyoffer, find expect ad cache: ").append(cVar3);
                                                    i4 = i10;
                                                }
                                                if (i4 != 0) {
                                                    arrayList6.add(cVar3);
                                                }
                                            } else {
                                                i4 = i10;
                                                if (i4 != 0) {
                                                    arrayList6.add(cVar3);
                                                }
                                            }
                                            return arrayList6;
                                        }
                                        i10 = 1;
                                        arrayList6 = r9;
                                        str2 = str3;
                                        aTAdInfo = aTAdInfo2;
                                        i = i2;
                                        i4 = 1;
                                        if (i4 != 0) {
                                            return arrayList6;
                                        }
                                    } else {
                                        list3 = baseAdObject;
                                        r0 = baseAdObject;
                                        i = i2;
                                        ATAdInfo aTAdInfo7 = aTAdInfoC;
                                        str2 = str;
                                        aTAdInfo = aTAdInfo7;
                                    }
                                }
                            } catch (Throwable unused8) {
                                i = 0;
                            }
                        } else {
                            i = 0;
                            ATAdInfo aTAdInfo8 = aTAdInfoC;
                            str2 = str;
                            aTAdInfo = aTAdInfo8;
                        }
                    }
                    if (z) {
                        if (fVarA != null) {
                            zG = fVarA.g();
                        } else {
                            r10 = i;
                        }
                        if (fVarA == null) {
                            r10 = zG;
                            com.anythink.core.common.u.e.b("AdManage is null--isReady", "Id:" + str2 + "--format:" + arrayList6.aq(), com.anythink.core.common.d.t.b().r());
                        }
                        r10 = zG;
                        com.anythink.core.common.u.e.a(strH, str, false, r10 != 0 ? 5 : i10, (com.anythink.core.d.l) arrayList6, (com.anythink.core.common.h.c) null, jSONArray.toString(), "", mapA, dVarB, SystemClock.elapsedRealtime() - jElapsedRealtime, aeVar);
                    }
                    if (z2) {
                        com.anythink.core.common.u.e.a(strH, str, (com.anythink.core.d.l) arrayList6, aTAdInfo != null ? 5 : i10, jSONArray.toString(), mapA, aeVar);
                    }
                    return arrayList6;
                } catch (Throwable th6) {
                    th = th6;
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            arrayList6 = arrayList6;
        }
    }

    private static boolean a(JSONArray jSONArray, ATAdInfo aTAdInfo, com.anythink.core.common.h.c cVar) {
        if (aTAdInfo != null && (aTAdInfo instanceof com.anythink.core.common.d.l)) {
            if (!a((com.anythink.core.common.d.l) aTAdInfo, cVar)) {
                a(jSONArray, -1, cVar.i().M(), cVar.i().Y(), "", false, 7);
                new StringBuilder("canUseDefaultMyoffer, not expect ad cache: ").append(cVar);
                return false;
            }
            cVar.i().ao();
            new StringBuilder("canUseDefaultMyoffer, find expect ad cache: ").append(cVar);
        }
        return true;
    }

    private static boolean a(com.anythink.core.common.h.c cVar, JSONArray jSONArray, List<String> list, List<String> list2, com.anythink.core.common.h.c cVar2, ATAdInfo aTAdInfo) {
        com.anythink.core.common.h.n nVarI = cVar.i();
        if (!com.anythink.core.common.v.p.a(list, "66")) {
            a(jSONArray, -1, nVarI.M(), nVarI.Y(), "", false, 5);
            return false;
        }
        if (com.anythink.core.common.v.p.b(list2, "66")) {
            a(jSONArray, -1, nVarI.M(), nVarI.Y(), "", false, 6);
            return false;
        }
        if (cVar2 != null) {
            if (TextUtils.equals(cVar2.i().aJ(), nVarI.aJ()) && TextUtils.equals(cVar2.i().M(), nVarI.M())) {
                nVarI.ao();
                new StringBuilder("canUseDefaultAdxCache, find expect ad cache: ").append(cVar);
                return true;
            }
            a(jSONArray, -1, nVarI.M(), nVarI.Y(), "", false, 7);
            new StringBuilder("canUseDefaultAdxCache, not expect ad cache: ").append(cVar).append("\n expectShowAdCacheInfo").append(cVar2);
            return false;
        }
        if (cVar2 != null || aTAdInfo == null || !(aTAdInfo instanceof com.anythink.core.common.d.l)) {
            return true;
        }
        if (a((com.anythink.core.common.d.l) aTAdInfo, cVar)) {
            nVarI.ao();
            new StringBuilder("canUseDefaultAdxCache, find expect ad info: ").append(aTAdInfo);
            return true;
        }
        a(jSONArray, -1, nVarI.M(), nVarI.Y(), "", false, 7);
        new StringBuilder("canUseDefaultAdxCache, not expect ad cache: ").append(cVar).append("\n expectAdInfo").append(aTAdInfo);
        return false;
    }

    private static boolean a(com.anythink.core.common.d.l lVar, com.anythink.core.common.h.c cVar) {
        if (lVar != null && cVar != null) {
            String requestId = lVar.getRequestId();
            String adsourceId = lVar.getAdsourceId();
            com.anythink.core.common.h.n nVarI = cVar.i();
            if (TextUtils.equals(requestId, nVarI.aJ()) && TextUtils.equals(adsourceId, nVarI.M())) {
                return true;
            }
        }
        return false;
    }

    private static void a(ATBaseAdAdapter aTBaseAdAdapter, String str, String str2, com.anythink.core.d.l lVar, bv bvVar, Map<String, Object> map, ae aeVar) {
        Map<String, Object> mapB = u.a().b(str2);
        int[] iArr = {0};
        if (mapB.containsKey(bu.S)) {
            try {
                iArr[0] = ((Integer) mapB.get(bu.S)).intValue();
            } catch (Throwable unused) {
            }
        }
        com.anythink.core.common.h.n nVarA = aj.a(str, str2, lVar, 0, iArr[0], map, null, 0, aeVar != null ? aeVar.d() : null);
        aj.a(nVarA, bvVar, 0, true);
        aj.a(aTBaseAdAdapter, nVarA, bvVar);
        nVarA.t = 3;
        nVarA.m(ak.a(bvVar, (ATBaseAdAdapter) null));
        aTBaseAdAdapter.setRefresh(false);
    }

    private static void a(JSONArray jSONArray, int i, String str, int i2, String str2, boolean z, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("priority", i);
            jSONObject.put("unit_id", str);
            jSONObject.put("nw_firm_id", i2);
            jSONObject.put("nw_ver", str2);
            jSONObject.put("result", z ? 1 : 0);
            if (i3 != -1) {
                jSONObject.put(MediationConstant.KEY_REASON, i3);
            }
        } catch (Throwable th) {
            a("checkCache failed in addCheckObjectInfo.", th);
        }
        jSONArray.put(jSONObject);
    }

    public final void a(com.anythink.core.common.h.c cVar) {
        if (cVar == null) {
            return;
        }
        com.anythink.core.common.h.n nVarI = cVar.i();
        b(nVarI.aI(), cVar.e().getUnitGroupInfo());
        bw bwVar = this.d.get(a(nVarI.aI(), nVarI.M()));
        if (bwVar == null) {
            return;
        }
        bwVar.a(cVar);
    }

    public final void b(com.anythink.core.common.h.c cVar) {
        if (cVar == null) {
            return;
        }
        String strAI = cVar.i().aI();
        synchronized (u.a().a(strAI)) {
            List<com.anythink.core.common.h.c> list = this.c.get(strAI);
            if (list != null) {
                list.remove(cVar);
            }
        }
    }

    public final void a(String str, bv bvVar, String str2) {
        synchronized (u.a().a(str)) {
            List<com.anythink.core.common.h.c> list = this.c.get(str);
            if (list != null) {
                for (com.anythink.core.common.h.c cVar : list) {
                    if (TextUtils.equals(cVar.i().M(), bvVar.z()) && TextUtils.equals(cVar.i().aJ(), str2)) {
                        a(cVar);
                        b(cVar);
                        cVar.m();
                        return;
                    }
                }
            }
        }
    }

    private void a(String str, int i) {
        a(str, i, true, 7);
    }

    public final void a(String str, List<ATAdInfo> list, boolean z, int i) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return;
        }
        new StringBuilder("clearCacheByDeveloper, placementId=").append(str).append(", adInfoList=").append(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String sharedPlacementId = null;
        for (ATAdInfo aTAdInfo : list) {
            if (aTAdInfo != null) {
                if (aTAdInfo.getPlacementType() == 2) {
                    if (sharedPlacementId == null) {
                        sharedPlacementId = aTAdInfo.getSharedPlacementId();
                    }
                    if (z) {
                        arrayList.add(aTAdInfo);
                    }
                } else {
                    arrayList2.add(aTAdInfo);
                }
            }
        }
        if (arrayList2.size() > 0) {
            a(str, arrayList2, i);
        }
        if (arrayList.size() > 0) {
            a(sharedPlacementId, arrayList, i);
        }
    }

    private void a(String str, List<ATAdInfo> list, int i) {
        synchronized (u.a().a(str)) {
            List<com.anythink.core.common.h.c> list2 = this.c.get(str);
            if (list2 == null) {
                return;
            }
            com.anythink.core.common.h.n nVar = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                ATAdInfo aTAdInfo = list.get(size);
                if (aTAdInfo instanceof com.anythink.core.common.d.l) {
                    com.anythink.core.common.d.l lVar = (com.anythink.core.common.d.l) aTAdInfo;
                    String requestId = lVar.getRequestId();
                    String adsourceId = lVar.getAdsourceId();
                    if (TextUtils.isEmpty(requestId) || TextUtils.isEmpty(adsourceId)) {
                        new StringBuilder("internalClearCacheByDeveloper, skip because requestId or adSourceId is empty, requestId: ").append(requestId).append(", adSourceId: ");
                    } else {
                        new StringBuilder("internalClearCacheByDeveloper, need remove requestId: ").append(requestId).append(", need remove adSourceId: ");
                        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                            com.anythink.core.common.h.c cVar = list2.get(size2);
                            com.anythink.core.common.h.n nVarI = cVar.i();
                            if (nVar == null) {
                                nVar = nVarI;
                            }
                            if (TextUtils.equals(adsourceId, nVarI.M()) && TextUtils.equals(requestId, nVarI.aJ())) {
                                new StringBuilder("internalClearCacheByDeveloper, find need remove adCache: ").append(cVar);
                                list2.remove(size2);
                                com.anythink.core.b.d.c.a(cVar, i);
                                a(cVar);
                                cVar.m();
                                break;
                            }
                        }
                    }
                }
            }
            com.anythink.core.common.u.e.a(nVar, i);
        }
    }

    public final void a(final Context context, final com.anythink.core.common.h.c cVar) {
        final ATBaseAdAdapter aTBaseAdAdapterE = cVar.e();
        final com.anythink.core.common.h.n nVarI = cVar.i();
        bv unitGroupInfo = aTBaseAdAdapterE != null ? aTBaseAdAdapterE.getUnitGroupInfo() : null;
        if (nVarI != null) {
            String strAI = nVarI.aI();
            String strAJ = nVarI.aJ();
            f fVarA = u.a().a(strAI, nVarI.aK());
            if (fVarA != null) {
                fVarA.a(strAJ, unitGroupInfo != null ? com.anythink.core.common.v.p.a(unitGroupInfo) : 0.0d, unitGroupInfo);
            } else {
                com.anythink.core.common.u.e.b("AdManage is null--Show", "Id:" + strAI + "--format:" + nVarI.aK() + "--adsource:" + nVarI.M(), com.anythink.core.common.d.t.b().r());
            }
            u.a().a(strAI, strAJ, a(strAI));
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.a.a.a(context);
                    com.anythink.core.common.h.n nVar = nVarI;
                    com.anythink.core.a.a.a(nVar, nVar.aK(), nVarI.aI(), nVarI.M());
                    com.anythink.core.a.d.a();
                    nVarI.aI();
                    com.anythink.core.a.d.a();
                    nVarI.aI();
                    nVarI.M();
                    a.this.a(cVar);
                    a.this.b(cVar);
                    MediationBidManager mediationBidManagerB = com.anythink.core.b.f.a().b();
                    if (mediationBidManagerB != null) {
                        mediationBidManagerB.notifyWinnerDisplay(nVarI.aI(), aTBaseAdAdapterE.getUnitGroupInfo());
                    }
                }
            }, 2);
        }
    }

    public final bw a(String str, bv bvVar) {
        return this.d.get(a(str, bvVar.z()));
    }

    private static void b(String str, bv bvVar) {
        if (bvVar == null) {
            return;
        }
        bvVar.z();
        bvVar.q();
        bvVar.g();
        int iQ = bvVar.q();
        if (iQ != 3) {
            if (iQ == 4) {
                com.anythink.core.basead.b.a();
                Context contextG = com.anythink.core.common.d.t.b().g();
                com.anythink.core.basead.b.a();
                com.anythink.core.basead.b.b(contextG, com.anythink.core.basead.b.a(str, bvVar.z(), bvVar.g()));
                return;
            }
            if (iQ != 7) {
                return;
            }
        }
        ad adVarR = bvVar.R();
        com.anythink.core.common.a.c.a().a(str, bvVar.z());
        if (adVarR == null || TextUtils.isEmpty(adVarR.token)) {
            return;
        }
        com.anythink.core.common.a.a.a().b(com.anythink.core.common.d.t.b().g(), adVarR.token);
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
        com.anythink.core.common.u.e.b(str, sb.toString(), com.anythink.core.common.d.t.b().r());
    }

    public final void c(String str) {
        a(str, -1, true, 2);
    }

    public final void a(String str, int i, boolean z, int i2) {
        List<ATAdInfo> listA;
        if (TextUtils.isEmpty(str) || com.anythink.core.common.d.t.b().g() == null) {
            return;
        }
        com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(str);
        String strValueOf = lVarA != null ? String.valueOf(lVarA.aq()) : null;
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        synchronized (u.a().a(str)) {
            if (this.c.get(str) == null) {
                return;
            }
            f fVarA = f.a(com.anythink.core.common.d.t.b().g(), str, strValueOf);
            if (fVarA != null) {
                if (z) {
                    listA = fVarA.a(com.anythink.core.common.d.t.b().g());
                } else {
                    listA = fVarA.a(com.anythink.core.common.d.t.b().g(), (ae) null);
                }
                if (listA != null && listA.size() != 0) {
                    if (i >= listA.size() - 1) {
                        return;
                    }
                    List<ATAdInfo> arrayList = new ArrayList<>();
                    if (i >= 0) {
                        while (true) {
                            i++;
                            if (i >= listA.size()) {
                                break;
                            } else {
                                arrayList.add(listA.get(i));
                            }
                        }
                    } else {
                        arrayList.addAll(listA);
                    }
                    a(str, arrayList, z, i2);
                }
            }
        }
    }

    public final List<com.anythink.core.common.h.c> a(String str, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list, long j, int i) {
        List<com.anythink.core.common.h.c> listA;
        int size;
        boolean z = true;
        if (i != -1 && (listA = a().a(str)) != null && !listA.isEmpty() && (size = listA.size()) >= i) {
            if (com.anythink.core.common.v.l.a(aTBaseAdAdapter.getUnitGroupInfo(), listA.get(size - 1).o()) == -1) {
                int i2 = i - 2;
                Math.max(i2, -1);
                a().a(str, Math.max(i2, -1), false, 11);
            } else {
                z = false;
            }
        }
        if (!z) {
            com.anythink.core.common.h.c cVarA = a(aTBaseAdAdapter, j);
            cVarA.m();
            com.anythink.core.b.d.c.a(cVarA, 11);
            com.anythink.core.common.u.e.b(cVarA.i(), "2");
            return new ArrayList();
        }
        return a(str, aTBaseAdAdapter, list, j);
    }
}
