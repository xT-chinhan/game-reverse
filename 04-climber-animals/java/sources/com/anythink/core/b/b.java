package com.anythink.core.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.a;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.al;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bw;
import com.anythink.core.common.h.n;
import com.anythink.core.common.j;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.ak;
import com.anythink.core.common.v.l;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.anythink.core.common.v.b implements j.b {
    public static final String a = "b";
    protected com.anythink.core.common.h d;
    protected long e;
    private String g;
    private j.a h;
    private String i;
    private long j;
    private boolean k;
    private com.anythink.core.common.h.a l;
    private Map<Integer, d> m;
    private long n;
    private List<bv> o;
    private com.anythink.core.common.t.b q;
    Map<String, n> b = new ConcurrentHashMap(3);
    com.anythink.core.common.t.b c = new com.anythink.core.common.t.b() { // from class: com.anythink.core.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.b.b.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c();
                }
            });
        }
    };
    private boolean p = false;
    com.anythink.core.common.h.b f = new com.anythink.core.common.h.b() { // from class: com.anythink.core.b.b.3
        @Override // com.anythink.core.common.h.b
        public final void a(d dVar, int i) {
            b.a(b.this, dVar, i);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        try {
            j.a aVar = this.h;
            if (aVar != null) {
                aVar.a(this.i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        try {
            if (this.p) {
                this.p = false;
                List<bv> list = this.o;
                if (list != null && list.size() != 0) {
                    new StringBuilder("callbackWaitingList, ").append(this.o);
                    ArrayList arrayList = new ArrayList(this.o);
                    this.o.clear();
                    j.a aVar = this.h;
                    if (aVar != null) {
                        aVar.a(this.i, arrayList, new ArrayList(1), false);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public b(com.anythink.core.common.h.a aVar) {
        this.l = aVar;
        this.g = aVar.e;
        this.i = aVar.d;
        this.j = aVar.g;
        this.d = aVar.F;
        List<bv> list = aVar.j;
        int size = list.size();
        List<bv> listA = aVar.y.a();
        if (listA.size() > 0) {
            this.l.z = listA.size() + size;
        } else {
            this.l.z = size;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        for (int i = 0; i < size; i++) {
            bv bvVar = list.get(i);
            if (bvVar.q() == 1 || bvVar.q() == 3) {
                if (this.l.E == 1 && bvVar.q() == 3) {
                    arrayList3 = arrayList3 == null ? new ArrayList() : arrayList3;
                    arrayList3.add(bvVar);
                } else {
                    arrayList.add(bvVar);
                }
            } else if (bvVar.q() == 2) {
                arrayList4 = arrayList4 == null ? new ArrayList(size) : arrayList4;
                arrayList4.add(bvVar);
            } else if (bvVar.q() == 5) {
                arrayList5 = arrayList5 == null ? new ArrayList(size) : arrayList5;
                arrayList5.add(bvVar);
            } else if (bvVar.q() == 6) {
                arrayList6 = arrayList6 == null ? new ArrayList(size) : arrayList6;
                arrayList6.add(bvVar);
            } else if (bvVar.q() == 7) {
                arrayList2.add(bvVar);
            }
        }
        this.m = new HashMap(5);
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.m.put(1, new c(aVar.a(arrayList, arrayList2), list));
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            this.m.put(3, new c(aVar.a(arrayList3, null), list));
        }
        if (arrayList4 != null && arrayList4.size() > 0) {
            this.m.put(2, new a(aVar.a(arrayList4)));
        }
        if (arrayList5 != null && arrayList5.size() > 0) {
            this.m.put(5, new h(aVar.b(arrayList5)));
        }
        if (arrayList6 == null || arrayList6.size() <= 0) {
            return;
        }
        this.m.put(6, new g(aVar.c(arrayList6)));
    }

    @Override // com.anythink.core.common.j.b
    public final void a(boolean z) {
        this.k = z;
    }

    @Override // com.anythink.core.common.j.b
    public final void a(j.a aVar) {
        this.h = aVar;
        com.anythink.core.common.h hVar = this.d;
        long jC = hVar == null ? 0L : hVar.c();
        super.a(this.j + jC);
        this.e = this.l.i;
        if (this.l.c.j) {
            int i = this.l.c.h;
            int iBw = this.l.n.a().bw();
            if (iBw > 0 && i > iBw) {
                this.e = i - iBw;
            }
        }
        if (this.e <= 0) {
            this.e = com.anythink.basead.exoplayer.i.a.f;
        }
        this.e += jC;
        com.anythink.core.common.t.d.a().a(this.c, this.e, false);
        this.p = this.l.D > 0;
        int i2 = this.l.D;
        if (this.p) {
            this.o = Collections.synchronizedList(new ArrayList());
            this.q = new AnonymousClass5();
            com.anythink.core.common.t.d.a().a(this.q, this.l.D, false);
        }
        this.n = System.currentTimeMillis();
        HashMap map = new HashMap(this.m);
        com.anythink.core.common.h hVar2 = this.d;
        if (hVar2 != null) {
            hVar2.a(this.f);
        }
        for (Map.Entry entry : map.entrySet()) {
            final Integer num = (Integer) entry.getKey();
            final d dVar = (d) entry.getValue();
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.b.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a(b.this.e);
                        dVar.a(b.this.k);
                        if (b.this.d != null) {
                            com.anythink.core.common.h hVar3 = b.this.d;
                            d dVar3 = dVar;
                            int iIntValue = num.intValue();
                            if (dVar3 != null) {
                                hVar3.new a(dVar3, iIntValue);
                                return;
                            }
                            return;
                        }
                        b.a(b.this, dVar, num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.b.b$4, reason: invalid class name */
    final class AnonymousClass4 implements com.anythink.core.b.b.b {
        final /* synthetic */ int a;

        AnonymousClass4(int i) {
            this.a = i;
        }

        @Override // com.anythink.core.b.b.b
        public final void a(bv bvVar, ATBaseAdAdapter aTBaseAdAdapter) {
            b.a(b.this, bvVar, aTBaseAdAdapter);
        }

        @Override // com.anythink.core.b.b.b
        public final void a(List<bv> list, List<bv> list2) {
            b.this.b(Integer.valueOf(this.a), list, list2);
            if (b.this.d != null) {
                b.this.d.b();
            }
        }
    }

    private void a(d dVar, int i) {
        dVar.a(new AnonymousClass4(i));
    }

    private void b(long j) {
        this.e = this.l.i;
        if (this.l.c.j) {
            int i = this.l.c.h;
            int iBw = this.l.n.a().bw();
            if (iBw > 0 && i > iBw) {
                this.e = i - iBw;
            }
        }
        if (this.e <= 0) {
            this.e = com.anythink.basead.exoplayer.i.a.f;
        }
        this.e += j;
        com.anythink.core.common.t.d.a().a(this.c, this.e, false);
    }

    private void e() {
        this.p = this.l.D > 0;
        int i = this.l.D;
        if (this.p) {
            this.o = Collections.synchronizedList(new ArrayList());
            this.q = new AnonymousClass5();
            com.anythink.core.common.t.d.a().a(this.q, this.l.D, false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.b.b$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.core.common.t.b {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.b.b.5.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.d();
                }
            });
        }
    }

    private boolean a(Integer num) {
        d dVar = this.m.get(num);
        if (dVar != null && dVar.c()) {
            this.m.remove(num);
        }
        if (this.m.size() != 0) {
            return false;
        }
        a();
        com.anythink.core.common.t.d.a().b(this.c);
        this.p = false;
        if (this.q != null) {
            com.anythink.core.common.t.d.a().b(this.q);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(Integer num, List<bv> list, List<bv> list2) {
        a(num, list, list2);
    }

    @Override // com.anythink.core.common.v.b
    protected final void b() {
        HashMap map;
        synchronized (this) {
            map = new HashMap(this.m);
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            d dVar = (d) ((Map.Entry) it.next()).getValue();
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    private void a(String str, bv bvVar, boolean z) {
        int iD;
        if (bvVar.r() == 2) {
            bw bwVarA = com.anythink.core.common.a.a().a(str, bvVar);
            ad adVarR = bvVar.R();
            com.anythink.core.common.h.c cVarB = null;
            if (bwVarA != null) {
                com.anythink.core.common.h.j jVarA = bwVarA.a((ad) null);
                cVarB = jVarA.b();
                iD = jVarA.d();
            } else {
                iD = 0;
            }
            if (cVarB != null) {
                bvVar.ay();
            }
            bvVar.toString();
            if (cVarB == null || iD < bvVar.ay()) {
                return;
            }
            try {
                double dA = p.a(cVarB.e().getUnitGroupInfo());
                if (l.a(bvVar, cVarB.e().getUnitGroupInfo()) < 0) {
                    bvVar.a(bvVar, 2, bvVar.t(), 1);
                    return;
                }
                try {
                    bv unitGroupInfo = cVarB.e().getUnitGroupInfo();
                    String str2 = unitGroupInfo.R() != null ? unitGroupInfo.R().token : "";
                    if (adVarR != null && !TextUtils.equals(adVarR.token, str2)) {
                        com.anythink.core.b.d.c.a(adVarR, new aw(2, bvVar, this.l.s, dA), true, 26);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                bvVar.a(cVarB.e().getUnitGroupInfo(), 1, bvVar.t(), z ? 1 : 0);
            } catch (Exception unused) {
            }
        }
    }

    private void a(bv bvVar, ATBaseAdAdapter aTBaseAdAdapter) {
        n nVarAf;
        try {
            nVarAf = this.l.s.af();
            try {
                aj.a(nVarAf, bvVar, 0, false);
                nVarAf.m(ak.a(bvVar, (ATBaseAdAdapter) null));
                this.b.put(bvVar.z(), nVarAf);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            nVarAf = null;
        }
        if (bvVar.q() != 7 && aTBaseAdAdapter != null) {
            try {
                if (this.l.c.d != null) {
                    aj.a(nVarAf);
                    this.l.c.d.onAdSourceBiddingAttempt(nVarAf);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        a(nVarAf, (AdError) null, com.anythink.core.common.w.a.a.b.a, bvVar);
        com.anythink.core.common.v.d.a().a(nVarAf, bvVar, 1);
    }

    private void a(bv bvVar) {
        n nVar = this.b.get(bvVar.z());
        if (nVar != null) {
            com.anythink.core.common.v.b.b.a().a(new AnonymousClass7(bvVar, nVar));
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.b.b$7, reason: invalid class name */
    final class AnonymousClass7 implements Runnable {
        final /* synthetic */ bv a;
        final /* synthetic */ n b;

        AnonymousClass7(bv bvVar, n nVar) {
            this.a = bvVar;
            this.b = nVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adSourceBidError, "", this.a.F());
            if (b.this.l.c.d != null) {
                if (this.b != null) {
                    b.this.l.c.d.onAdSourceBiddingFail(this.b, errorCode);
                }
                b.this.b.remove(this.a.z());
            }
            b.this.a(this.b, errorCode, com.anythink.core.common.w.a.a.b.c, this.a);
        }
    }

    private void b(bv bvVar) {
        n nVar = this.b.get(bvVar.z());
        if (nVar != null) {
            com.anythink.core.common.v.b.b.a().a(new AnonymousClass8(nVar, bvVar));
        }
        com.anythink.core.common.v.d.a().a(nVar, bvVar, 2);
    }

    /* JADX INFO: renamed from: com.anythink.core.b.b$8, reason: invalid class name */
    final class AnonymousClass8 implements Runnable {
        final /* synthetic */ n a;
        final /* synthetic */ bv b;

        AnonymousClass8(n nVar, bv bvVar) {
            this.a = nVar;
            this.b = bvVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.l.c.d != null) {
                n nVar = this.a;
                if (nVar != null) {
                    aj.a(nVar, this.b, 0, false);
                    b.this.l.c.d.onAdSourceBiddingFilled(this.a);
                }
                b.this.b.remove(this.b.z());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, AdError adError, int i, bv bvVar) {
        String platformCode;
        String platformMSG;
        if (nVar == null) {
            return;
        }
        com.anythink.core.common.w.a.b.d dVar = (com.anythink.core.common.w.a.b.d) com.anythink.core.common.w.a.a.d.a(nVar.aI(), com.anythink.core.common.w.a.b.d.class);
        if (dVar != null) {
            if (adError != null) {
                platformCode = adError.getPlatformCode();
                platformMSG = adError.getPlatformMSG();
            } else {
                platformCode = "";
                platformMSG = "";
            }
            al alVarA = al.a(nVar, platformCode, platformMSG, i);
            alVarA.a(adError != null);
            dVar.a(alVarA);
        }
        Object[] objArr = new Object[1];
        bvVar.z();
        com.anythink.core.common.h.a aVar = this.l;
        Context contextG = aVar != null ? aVar.b : t.b().g();
        com.anythink.core.a.c.a();
        if (i == com.anythink.core.common.w.a.a.b.a) {
            com.anythink.core.a.c.a(contextG, bvVar, nVar.aI());
        } else if (i == com.anythink.core.common.w.a.a.b.c) {
            com.anythink.core.a.c.b(contextG, bvVar, nVar.aI());
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0101 A[Catch: all -> 0x01a4, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0011, B:8:0x0016, B:10:0x0020, B:12:0x0032, B:16:0x0040, B:19:0x0048, B:23:0x0052, B:27:0x0066, B:29:0x0085, B:30:0x0091, B:31:0x009c, B:35:0x00a4, B:48:0x0121, B:39:0x00e4, B:41:0x00f3, B:43:0x00fd, B:45:0x0104, B:47:0x0115, B:44:0x0101, B:49:0x0125, B:50:0x0128, B:52:0x0141, B:54:0x0147, B:56:0x014b, B:57:0x014e, B:58:0x015b, B:60:0x0161, B:65:0x016b, B:67:0x016f, B:69:0x0175, B:70:0x017f, B:72:0x0183, B:73:0x0186, B:75:0x018c, B:76:0x0194, B:78:0x0198, B:80:0x019f), top: B:89:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0115 A[Catch: all -> 0x01a4, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0011, B:8:0x0016, B:10:0x0020, B:12:0x0032, B:16:0x0040, B:19:0x0048, B:23:0x0052, B:27:0x0066, B:29:0x0085, B:30:0x0091, B:31:0x009c, B:35:0x00a4, B:48:0x0121, B:39:0x00e4, B:41:0x00f3, B:43:0x00fd, B:45:0x0104, B:47:0x0115, B:44:0x0101, B:49:0x0125, B:50:0x0128, B:52:0x0141, B:54:0x0147, B:56:0x014b, B:57:0x014e, B:58:0x015b, B:60:0x0161, B:65:0x016b, B:67:0x016f, B:69:0x0175, B:70:0x017f, B:72:0x0183, B:73:0x0186, B:75:0x018c, B:76:0x0194, B:78:0x0198, B:80:0x019f), top: B:89:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0121 A[SYNTHETIC] */
    private synchronized void a(Integer num, List<bv> list, List<bv> list2) {
        boolean z;
        n nVar;
        d dVar = this.m.get(num);
        if (dVar != null && dVar.c()) {
            this.m.remove(num);
        }
        if (this.m.size() == 0) {
            a();
            com.anythink.core.common.t.d.a().b(this.c);
            this.p = false;
            if (this.q != null) {
                com.anythink.core.common.t.d.a().b(this.q);
            }
            z = true;
        } else {
            z = false;
        }
        int size = list != null ? list.size() : 0;
        int size2 = list2 != null ? list2.size() : 0;
        if (size > 0 || size2 > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    bv bvVar = list.get(i);
                    a(this.g, bvVar, true);
                    arrayList.add(bvVar);
                    arrayList3.add(bvVar);
                    n nVar2 = this.b.get(bvVar.z());
                    if (nVar2 != null) {
                        com.anythink.core.common.v.b.b.a().a(new AnonymousClass8(nVar2, bvVar));
                    }
                    com.anythink.core.common.v.d.a().a(nVar2, bvVar, 2);
                }
                list.clear();
            }
            if (size2 > 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    bv bvVar2 = list2.get(i2);
                    if (bvVar2 == null) {
                        try {
                            com.anythink.core.common.u.e.b("Bid Fail AdSource Object is null, currentSize:" + list2.size() + "\n" + q.a(new Throwable().getStackTrace()), "Bidding inner error", t.b().r());
                        } catch (Throwable unused) {
                            a(this.g, bvVar2, false);
                            if (p.a(bvVar2) <= 0.0d) {
                                arrayList2.add(bvVar2);
                            } else {
                                arrayList2.add(bvVar2);
                            }
                            arrayList3.add(bvVar2);
                            nVar = this.b.get(bvVar2.z());
                            if (nVar != null) {
                                com.anythink.core.common.v.b.b.a().a(new AnonymousClass7(bvVar2, nVar));
                            }
                        }
                    } else {
                        a(this.g, bvVar2, false);
                        if (p.a(bvVar2) <= 0.0d && !TextUtils.isEmpty(bvVar2.E())) {
                            arrayList.add(bvVar2);
                        } else {
                            arrayList2.add(bvVar2);
                        }
                        arrayList3.add(bvVar2);
                        nVar = this.b.get(bvVar2.z());
                        if (nVar != null) {
                            com.anythink.core.common.v.b.b.a().a(new AnonymousClass7(bvVar2, nVar));
                        }
                    }
                }
                list2.clear();
            }
            com.anythink.core.b.d.c.a(this.l.s.af(), arrayList3, this.n, this.l.t, this.l.f);
            if (this.p) {
                if (arrayList.size() > 0) {
                    List<bv> list3 = this.o;
                    if (list3 != null) {
                        list3.addAll(arrayList);
                    }
                    new StringBuilder("need wait request, ").append(arrayList);
                    arrayList.clear();
                }
                if (arrayList.size() == 0 && arrayList2.size() == 0) {
                    return;
                }
            }
            if (z) {
                List<bv> list4 = this.o;
                if (list4 != null && list4.size() > 0) {
                    arrayList.addAll(0, this.o);
                    this.o.clear();
                }
                com.anythink.core.common.h hVar = this.d;
                if (hVar != null) {
                    hVar.a();
                }
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, new Comparator<bv>() { // from class: com.anythink.core.b.b.6
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(bv bvVar3, bv bvVar4) {
                        return l.a(bvVar3, bvVar4);
                    }

                    private static int a(bv bvVar3, bv bvVar4) {
                        return l.a(bvVar3, bvVar4);
                    }
                });
            }
            j.a aVar = this.h;
            if (aVar != null) {
                aVar.a(this.i, arrayList, arrayList2, z);
            }
            if (z) {
                this.h = null;
            }
        }
    }

    static /* synthetic */ void a(b bVar, d dVar, int i) {
        dVar.a(bVar.new AnonymousClass4(i));
    }

    static /* synthetic */ void a(b bVar, bv bvVar, ATBaseAdAdapter aTBaseAdAdapter) {
        n nVarAf;
        try {
            nVarAf = bVar.l.s.af();
            try {
                aj.a(nVarAf, bvVar, 0, false);
                nVarAf.m(ak.a(bvVar, (ATBaseAdAdapter) null));
                bVar.b.put(bvVar.z(), nVarAf);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            nVarAf = null;
        }
        if (bvVar.q() != 7 && aTBaseAdAdapter != null) {
            try {
                if (bVar.l.c.d != null) {
                    aj.a(nVarAf);
                    bVar.l.c.d.onAdSourceBiddingAttempt(nVarAf);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        bVar.a(nVarAf, (AdError) null, com.anythink.core.common.w.a.a.b.a, bvVar);
        com.anythink.core.common.v.d.a().a(nVarAf, bvVar, 1);
    }
}
