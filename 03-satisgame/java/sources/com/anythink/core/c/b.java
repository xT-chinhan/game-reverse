package com.anythink.core.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.anythink.core.api.ATAdRealTimeFilter;
import com.anythink.core.api.ATCustomRange;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.a;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.am;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.h.n;
import com.anythink.core.common.j;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.u.k;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.anythink.core.common.u.b implements j.b {
    public static final String a = "b";
    public static final String b = "ATAnchorWF";
    protected com.anythink.core.common.h e;
    protected long f;
    private String h;
    private j.a i;
    private String j;
    private long k;
    private boolean l;
    private final com.anythink.core.common.h.a m;
    private Map<Integer, d> n;
    private long o;
    private long p;
    private List<by> q;
    private com.anythink.core.common.u.b.d s;
    private final com.anythink.core.e.f t;
    private volatile boolean u;
    private List<by> w;
    Map<String, n> c = new ConcurrentHashMap(3);
    com.anythink.core.common.u.b.d d = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.de, new Runnable() { // from class: com.anythink.core.c.b.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.af, new Runnable() { // from class: com.anythink.core.c.b.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.h();
                }
            }));
        }
    });
    private boolean r = false;
    private final List<by> v = new CopyOnWriteArrayList();
    com.anythink.core.common.h.b g = new com.anythink.core.common.h.b() { // from class: com.anythink.core.c.b.4
        @Override // com.anythink.core.common.h.b
        public final void a(d dVar, int i) {
            b.a(b.this, dVar, i);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        try {
            j.a aVar = this.i;
            if (aVar != null) {
                aVar.a(this.j);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        try {
            if (this.r) {
                this.r = false;
                List<by> list = this.q;
                if (list != null && list.size() != 0) {
                    ArrayList arrayList = new ArrayList(this.q);
                    this.q.clear();
                    j.a aVar = this.i;
                    if (aVar != null) {
                        aVar.a(this.j, arrayList, new ArrayList(1), false);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public b(com.anythink.core.common.h.a aVar) {
        this.m = aVar;
        this.h = aVar.e;
        this.j = aVar.d;
        this.k = aVar.g;
        this.e = aVar.F;
        this.t = aVar.K;
        List<by> list = aVar.j;
        int size = list.size();
        List<by> listA = aVar.y.a();
        if (listA.size() > 0) {
            aVar.z = listA.size() + size;
        } else {
            aVar.z = size;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        for (int i = 0; i < size; i++) {
            by byVar = list.get(i);
            if (byVar.y() == 1 || byVar.y() == 3) {
                if (this.m.E == 1 && byVar.y() == 3) {
                    arrayList3 = arrayList3 == null ? new ArrayList() : arrayList3;
                    arrayList3.add(byVar);
                } else {
                    arrayList.add(byVar);
                }
            } else if (byVar.y() == 2) {
                arrayList4 = arrayList4 == null ? new ArrayList(size) : arrayList4;
                arrayList4.add(byVar);
            } else if (byVar.y() == 6) {
                arrayList5 = arrayList5 == null ? new ArrayList(size) : arrayList5;
                arrayList5.add(byVar);
            } else if (byVar.y() == 7) {
                arrayList2.add(byVar);
            }
        }
        this.n = new HashMap(5);
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.n.put(1, new c(aVar.a(arrayList, arrayList2), list));
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            this.n.put(3, new c(aVar.a(arrayList3, null), list));
        }
        if (arrayList4 != null && arrayList4.size() > 0) {
            this.n.put(2, new a(aVar.a(arrayList4)));
        }
        if (arrayList5 == null || arrayList5.size() <= 0) {
            return;
        }
        this.n.put(6, new g(aVar.b(arrayList5)));
    }

    @Override // com.anythink.core.common.j.b
    public final void a(boolean z) {
        this.l = z;
    }

    @Override // com.anythink.core.common.u.b
    protected final void e() {
        b(true);
        j();
        com.anythink.core.common.h hVar = this.e;
        if (hVar != null) {
            hVar.b();
        }
    }

    @Override // com.anythink.core.common.u.b
    protected final void f() {
        j();
    }

    private synchronized void j() {
        j.a aVar;
        try {
            if (this.u) {
                this.u = true;
                super.g();
                return;
            }
            if (this.t == null) {
                this.u = true;
                this.u = true;
                super.g();
                return;
            }
            ArrayList arrayList = new ArrayList();
            List<Integer> listA = this.t.a();
            by byVarA = null;
            if (!this.v.isEmpty()) {
                for (by byVar : this.v) {
                    if (byVar != null) {
                        int iN = byVar.n();
                        double dAB = byVar.aB();
                        if (dAB > 0.0d) {
                            if (((listA == null || listA.isEmpty()) ? false : listA.contains(-1) ? true : listA.contains(Integer.valueOf(iN))) && (byVarA == null || dAB > byVarA.aB())) {
                                byVarA = byVar;
                            }
                        }
                    }
                }
            } else if (this.t.e() == 2 && this.m.x != null) {
                byVarA = this.m.x.a();
            }
            double dAB2 = byVarA != null ? byVarA.aB() * ((double) this.t.d()) : 0.0d;
            if (dAB2 > 0.0d && !this.v.isEmpty()) {
                for (by byVar2 : this.v) {
                    if (byVar2 != null && byVar2.aB() < dAB2) {
                        arrayList.add(byVar2);
                    }
                }
            }
            if (dAB2 > 0.0d && (aVar = this.i) != null) {
                aVar.a(Double.valueOf(dAB2));
            }
            this.u = true;
            super.g();
        } catch (Throwable unused) {
            this.u = true;
            super.g();
        }
    }

    private void b(boolean z) {
        ArrayList arrayList;
        j.a aVar;
        try {
            ArrayList arrayList2 = new ArrayList();
            List<by> list = this.w;
            if (list == null || list.isEmpty()) {
                arrayList = null;
            } else {
                synchronized (this) {
                    arrayList = new ArrayList(this.w);
                    this.w.clear();
                }
                if (arrayList.size() > 1) {
                    Collections.sort(arrayList, new Comparator<by>() { // from class: com.anythink.core.c.b.2
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(by byVar, by byVar2) {
                            return k.a(byVar, byVar2);
                        }

                        private static int a(by byVar, by byVar2) {
                            return k.a(byVar, byVar2);
                        }
                    });
                }
            }
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            ATAdRealTimeFilter.RLFilterListener rLFilterListener = ATAdRealTimeFilter.getInstance().getRLFilterListener();
            if (rLFilterListener != null) {
                if (z2) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        by byVar = (by) arrayList.get(i);
                        n nVarAh = this.m.s.ah();
                        ai.a(nVarAh, byVar, 0, false);
                        arrayList2.add(com.anythink.core.common.d.k.a(nVarAh, (ATBaseAdAdapter) null, 1));
                    }
                }
                s.b().b(this.m.e, rLFilterListener.filterAdByBiddingResult(arrayList2, z));
            }
            if (!z2 || (aVar = this.i) == null) {
                return;
            }
            aVar.a(this.j, arrayList, new ArrayList(1), false);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.j.b
    public final void a(j.a aVar) {
        int iB;
        this.i = aVar;
        com.anythink.core.common.h hVar = this.e;
        long jC = hVar == null ? 0L : hVar.c();
        super.a(this.k + jC);
        if (this.m.H > 0) {
            super.b(this.m.H);
        }
        com.anythink.core.e.f fVar = this.t;
        if (fVar != null && (iB = fVar.b()) > 0) {
            super.c(iB);
        }
        this.f = this.m.i;
        if (this.m.c.j) {
            int i = this.m.c.h;
            int iBw = this.m.n.a().bw();
            if (iBw > 0 && i > iBw) {
                this.f = i - iBw;
            }
        }
        if (this.f <= 0) {
            this.f = 2000L;
        }
        this.f += jC;
        com.anythink.core.common.s.c.a().a(this.d, this.f);
        boolean z = this.m.D > 0;
        this.r = z;
        if (z) {
            this.q = Collections.synchronizedList(new ArrayList());
            this.s = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.df, new AnonymousClass7());
            com.anythink.core.common.s.c.a().a(this.s, this.m.D);
        }
        this.o = System.currentTimeMillis();
        this.p = SystemClock.elapsedRealtime();
        HashMap map = new HashMap(this.n);
        com.anythink.core.common.h hVar2 = this.e;
        if (hVar2 != null) {
            hVar2.a(this.g);
        }
        for (Map.Entry entry : map.entrySet()) {
            final Integer num = (Integer) entry.getKey();
            final d dVar = (d) entry.getValue();
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ad, new Runnable() { // from class: com.anythink.core.c.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a(b.this.f);
                        dVar.a(b.this.l);
                        if (b.this.e != null) {
                            com.anythink.core.common.h hVar3 = b.this.e;
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
            }));
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.c.b$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.core.c.b.b {
        final /* synthetic */ int a;

        AnonymousClass5(int i) {
            this.a = i;
        }

        @Override // com.anythink.core.c.b.b
        public final void a(by byVar, ATBaseAdAdapter aTBaseAdAdapter) {
            b.a(b.this, byVar, aTBaseAdAdapter);
        }

        @Override // com.anythink.core.c.b.b
        public final void a(List<by> list, List<by> list2) {
            b.this.b(Integer.valueOf(this.a), list, list2);
        }
    }

    private void a(d dVar, int i) {
        dVar.a(new AnonymousClass5(i));
    }

    private void a(List<by> list) {
        Pair<ATCustomRange.CustomContentListener, List<ATCustomRange.RangeObject>> adCustomContentInfo;
        try {
            if (list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                by byVar = list.get(i);
                if (byVar != null && byVar.n() == 2) {
                    arrayList.add(byVar);
                }
            }
            if (arrayList.isEmpty() || (adCustomContentInfo = ATCustomRange.getInstance().getAdCustomContentInfo(this.m.e)) == null) {
                return;
            }
            ATCustomRange.CustomContentListener customContentListener = (ATCustomRange.CustomContentListener) adCustomContentInfo.first;
            List list2 = (List) adCustomContentInfo.second;
            if (customContentListener == null || list2 == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                by byVar2 = (by) arrayList.get(i2);
                double dA = o.a(byVar2);
                String strG = byVar2.G();
                ATCustomRange.RangeObject rangeObject = new ATCustomRange.RangeObject(dA);
                rangeObject.setAdSourceId(strG);
                rangeObject.setTag(new Object());
                arrayList2.add(rangeObject);
            }
            for (int i3 = 0; i3 < list2.size(); i3++) {
                ATCustomRange.RangeObject rangeObject2 = (ATCustomRange.RangeObject) list2.get(i3);
                if (rangeObject2 != null) {
                    rangeObject2.setTag(null);
                }
            }
            arrayList2.addAll(list2);
            Collections.sort(arrayList2, new Comparator<ATCustomRange.RangeObject>() { // from class: com.anythink.core.c.b.6
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ATCustomRange.RangeObject rangeObject3, ATCustomRange.RangeObject rangeObject4) {
                    return Double.compare(rangeObject4.getCustomMsg(), rangeObject3.getCustomMsg());
                }

                private static int a(ATCustomRange.RangeObject rangeObject3, ATCustomRange.RangeObject rangeObject4) {
                    return Double.compare(rangeObject4.getCustomMsg(), rangeObject3.getCustomMsg());
                }
            });
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                ATCustomRange.RangeObject rangeObject3 = (ATCustomRange.RangeObject) arrayList2.get(i4);
                if (rangeObject3.getTag() != null) {
                    rangeObject3.setTag(null);
                    rangeObject3.setCustomMsg(0.0d);
                }
            }
            customContentListener.callBackResult(arrayList2);
        } catch (Throwable th) {
            if (ATSDK.isNetworkLogDebug()) {
                Log.e("anythink", "handleCustomContent: error", th);
            }
        }
    }

    private void d(long j) {
        this.f = this.m.i;
        if (this.m.c.j) {
            int i = this.m.c.h;
            int iBw = this.m.n.a().bw();
            if (iBw > 0 && i > iBw) {
                this.f = i - iBw;
            }
        }
        if (this.f <= 0) {
            this.f = 2000L;
        }
        this.f += j;
        com.anythink.core.common.s.c.a().a(this.d, this.f);
    }

    private void k() {
        boolean z = this.m.D > 0;
        this.r = z;
        if (z) {
            this.q = Collections.synchronizedList(new ArrayList());
            this.s = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.df, new AnonymousClass7());
            com.anythink.core.common.s.c.a().a(this.s, this.m.D);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.c.b$7, reason: invalid class name */
    final class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ag, new Runnable() { // from class: com.anythink.core.c.b.7.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.i();
                }
            }));
        }
    }

    private boolean a(Integer num) {
        d dVar = this.n.get(num);
        if (dVar != null && dVar.d()) {
            this.n.remove(num);
        }
        if (this.n.size() != 0) {
            return false;
        }
        a();
        com.anythink.core.common.s.c.a().a(this.d);
        this.r = false;
        if (this.s != null) {
            com.anythink.core.common.s.c.a().a(this.s);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(Integer num, List<by> list, List<by> list2) {
        a(num, list, list2);
    }

    @Override // com.anythink.core.common.u.b
    protected final void d() {
        HashMap map;
        synchronized (this) {
            map = new HashMap(this.n);
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            d dVar = (d) ((Map.Entry) it.next()).getValue();
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    private void a(String str, by byVar, boolean z) {
        int iD;
        if (byVar.z() == 2) {
            com.anythink.core.common.h.a aVar = this.m;
            com.anythink.core.common.h.c cVarB = null;
            bz bzVarA = (aVar == null || aVar.J == null || this.m.J.e() == null) ? null : this.m.J.e().a(str, byVar);
            ad adVarY = byVar.Y();
            if (bzVarA != null) {
                com.anythink.core.common.h.j jVarA = bzVarA.a((ad) null);
                cVarB = jVarA.b();
                iD = jVarA.d();
            } else {
                iD = 0;
            }
            if (cVarB == null || iD < byVar.aG()) {
                return;
            }
            try {
                double dA = o.a(cVarB.e().getUnitGroupInfo());
                if (k.a(byVar, cVarB.e().getUnitGroupInfo()) < 0) {
                    byVar.a(byVar, 2, byVar.B(), 1);
                    return;
                }
                try {
                    by unitGroupInfo = cVarB.e().getUnitGroupInfo();
                    String str2 = unitGroupInfo.Y() != null ? unitGroupInfo.Y().token : "";
                    if (adVarY != null && !TextUtils.equals(adVarY.token, str2)) {
                        com.anythink.core.c.d.c.a(adVarY, new ay(2, byVar, this.m.s, dA), true, 26);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                byVar.a(cVarB.e().getUnitGroupInfo(), 1, byVar.B(), z ? 1 : 0);
            } catch (Exception unused) {
            }
        }
    }

    private void a(by byVar, ATBaseAdAdapter aTBaseAdAdapter) {
        n nVarAh;
        String internalNetworkSDKVersion;
        String strValueOf;
        try {
            nVarAh = this.m.s.ah();
            try {
                ai.a(nVarAh, byVar, 0, false);
                nVarAh.m(aj.a(byVar, null));
                String str = "";
                if (aTBaseAdAdapter != null) {
                    try {
                        internalNetworkSDKVersion = aTBaseAdAdapter.getInternalNetworkSDKVersion();
                        try {
                            strValueOf = String.valueOf(aTBaseAdAdapter.internalBaseOnAdapterBridgeVersion());
                            str = internalNetworkSDKVersion;
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        internalNetworkSDKVersion = "";
                    }
                } else {
                    strValueOf = "";
                }
                String str2 = strValueOf;
                internalNetworkSDKVersion = str;
                str = str2;
                byVar.B = internalNetworkSDKVersion;
                byVar.C = str;
                this.c.put(byVar.G(), nVarAh);
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            nVarAh = null;
        }
        if (byVar.y() != 7 && aTBaseAdAdapter != null) {
            try {
                if (this.m.c.d != null) {
                    ai.a(nVarAh);
                    this.m.c.d.onAdSourceBiddingAttempt(nVarAh);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        a(nVarAh, (AdError) null, com.anythink.core.common.v.a.a.b.a, byVar);
        com.anythink.core.common.u.d.a().a(nVarAh, byVar, 1);
    }

    private void a(by byVar) {
        n nVar = this.c.get(byVar.G());
        if (nVar != null) {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adSourceBidError, "", byVar.M());
            if (this.m.c.d != null) {
                if (nVar != null) {
                    this.m.c.d.onAdSourceBiddingFail(nVar, errorCode);
                }
                this.c.remove(byVar.G());
            }
            a(nVar, errorCode, com.anythink.core.common.v.a.a.b.c, byVar);
        }
    }

    private void b(by byVar) {
        n nVar = this.c.get(byVar.G());
        if (nVar != null) {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ae, new AnonymousClass9(nVar, byVar)));
        }
        com.anythink.core.common.u.d.a().a(nVar, byVar, 2);
    }

    /* JADX INFO: renamed from: com.anythink.core.c.b$9, reason: invalid class name */
    final class AnonymousClass9 implements Runnable {
        final /* synthetic */ n a;
        final /* synthetic */ by b;

        AnonymousClass9(n nVar, by byVar) {
            this.a = nVar;
            this.b = byVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.m.c.d != null) {
                n nVar = this.a;
                if (nVar != null) {
                    ai.a(nVar, this.b, 0, false);
                    b.this.m.c.d.onAdSourceBiddingFilled(this.a);
                }
                b.this.c.remove(this.b.G());
            }
        }
    }

    private void a(n nVar, AdError adError, int i, by byVar) {
        String platformCode;
        String platformMSG;
        if (nVar == null) {
            return;
        }
        com.anythink.core.common.v.a.b.d dVar = (com.anythink.core.common.v.a.b.d) com.anythink.core.common.v.a.a.d.a(nVar.aQ(), com.anythink.core.common.v.a.b.d.class);
        if (dVar != null) {
            if (adError != null) {
                platformCode = adError.getPlatformCode();
                platformMSG = adError.getPlatformMSG();
            } else {
                platformCode = "";
                platformMSG = "";
            }
            am amVarA = am.a(nVar, platformCode, platformMSG, i);
            amVarA.a(adError != null);
            dVar.a(amVarA);
        }
        com.anythink.core.common.h.a aVar = this.m;
        Context contextG = aVar != null ? aVar.b : s.b().g();
        com.anythink.core.a.c.a();
        if (i == com.anythink.core.common.v.a.a.b.a) {
            com.anythink.core.a.c.a(contextG, byVar, nVar.aQ());
        } else if (i == com.anythink.core.common.v.a.a.b.c) {
            com.anythink.core.a.c.b(contextG, byVar, nVar.aQ());
        }
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0113 A[Catch: all -> 0x0230, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0013, B:8:0x0019, B:9:0x001e, B:11:0x0028, B:13:0x003a, B:17:0x0048, B:20:0x0050, B:24:0x005a, B:28:0x006e, B:30:0x008d, B:31:0x00a0, B:32:0x00ad, B:36:0x00b5, B:54:0x0154, B:40:0x00f5, B:42:0x0105, B:44:0x010f, B:46:0x0116, B:48:0x0127, B:51:0x013d, B:52:0x0146, B:53:0x014f, B:45:0x0113, B:55:0x0158, B:56:0x015b, B:58:0x017a, B:60:0x0187, B:62:0x018f, B:63:0x0192, B:65:0x0199, B:67:0x019f, B:69:0x01a3, B:70:0x01a6, B:71:0x01a9, B:73:0x01af, B:77:0x01b7, B:79:0x01c1, B:81:0x01c5, B:83:0x01ce, B:85:0x01d8, B:90:0x01e2, B:92:0x01e6, B:94:0x01ec, B:95:0x01f7, B:97:0x01fb, B:100:0x0203, B:101:0x020a, B:103:0x0211, B:104:0x0219, B:106:0x021d, B:108:0x0224, B:110:0x0228, B:111:0x022b), top: B:118:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0127 A[Catch: all -> 0x0230, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0013, B:8:0x0019, B:9:0x001e, B:11:0x0028, B:13:0x003a, B:17:0x0048, B:20:0x0050, B:24:0x005a, B:28:0x006e, B:30:0x008d, B:31:0x00a0, B:32:0x00ad, B:36:0x00b5, B:54:0x0154, B:40:0x00f5, B:42:0x0105, B:44:0x010f, B:46:0x0116, B:48:0x0127, B:51:0x013d, B:52:0x0146, B:53:0x014f, B:45:0x0113, B:55:0x0158, B:56:0x015b, B:58:0x017a, B:60:0x0187, B:62:0x018f, B:63:0x0192, B:65:0x0199, B:67:0x019f, B:69:0x01a3, B:70:0x01a6, B:71:0x01a9, B:73:0x01af, B:77:0x01b7, B:79:0x01c1, B:81:0x01c5, B:83:0x01ce, B:85:0x01d8, B:90:0x01e2, B:92:0x01e6, B:94:0x01ec, B:95:0x01f7, B:97:0x01fb, B:100:0x0203, B:101:0x020a, B:103:0x0211, B:104:0x0219, B:106:0x021d, B:108:0x0224, B:110:0x0228, B:111:0x022b), top: B:118:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x013d A[Catch: all -> 0x0230, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0013, B:8:0x0019, B:9:0x001e, B:11:0x0028, B:13:0x003a, B:17:0x0048, B:20:0x0050, B:24:0x005a, B:28:0x006e, B:30:0x008d, B:31:0x00a0, B:32:0x00ad, B:36:0x00b5, B:54:0x0154, B:40:0x00f5, B:42:0x0105, B:44:0x010f, B:46:0x0116, B:48:0x0127, B:51:0x013d, B:52:0x0146, B:53:0x014f, B:45:0x0113, B:55:0x0158, B:56:0x015b, B:58:0x017a, B:60:0x0187, B:62:0x018f, B:63:0x0192, B:65:0x0199, B:67:0x019f, B:69:0x01a3, B:70:0x01a6, B:71:0x01a9, B:73:0x01af, B:77:0x01b7, B:79:0x01c1, B:81:0x01c5, B:83:0x01ce, B:85:0x01d8, B:90:0x01e2, B:92:0x01e6, B:94:0x01ec, B:95:0x01f7, B:97:0x01fb, B:100:0x0203, B:101:0x020a, B:103:0x0211, B:104:0x0219, B:106:0x021d, B:108:0x0224, B:110:0x0228, B:111:0x022b), top: B:118:0x0009 }] */
    private synchronized void a(Integer num, List<by> list, List<by> list2) {
        boolean z;
        n nVar;
        AdError errorCode;
        d dVar = this.n.get(num);
        if (dVar != null && dVar.d()) {
            this.n.remove(num);
        }
        boolean z2 = true;
        if (this.n.size() == 0) {
            a();
            com.anythink.core.common.s.c.a().a(this.d);
            this.r = false;
            if (this.s != null) {
                com.anythink.core.common.s.c.a().a(this.s);
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
                int i = 0;
                while (i < size) {
                    by byVar = list.get(i);
                    a(this.h, byVar, z2);
                    arrayList.add(byVar);
                    arrayList3.add(byVar);
                    n nVar2 = this.c.get(byVar.G());
                    if (nVar2 != null) {
                        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ae, new AnonymousClass9(nVar2, byVar)));
                    }
                    com.anythink.core.common.u.d.a().a(nVar2, byVar, 2);
                    i++;
                    z2 = true;
                }
                list.clear();
            }
            if (size2 > 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    by byVar2 = list2.get(i2);
                    if (byVar2 == null) {
                        try {
                            com.anythink.core.common.t.f.b("Bid Fail AdSource Object is null, currentSize:" + list2.size() + "\n" + p.a(new Throwable().getStackTrace()), "Bidding inner error", s.b().r());
                        } catch (Throwable unused) {
                            a(this.h, byVar2, false);
                            if (o.a(byVar2) <= 0.0d) {
                                arrayList2.add(byVar2);
                            } else {
                                arrayList2.add(byVar2);
                            }
                            arrayList3.add(byVar2);
                            nVar = this.c.get(byVar2.G());
                            if (nVar != null) {
                                errorCode = ErrorCode.getErrorCode(ErrorCode.adSourceBidError, "", byVar2.M());
                                if (this.m.c.d != null) {
                                    if (nVar != null) {
                                        this.m.c.d.onAdSourceBiddingFail(nVar, errorCode);
                                    }
                                    this.c.remove(byVar2.G());
                                }
                                a(nVar, errorCode, com.anythink.core.common.v.a.a.b.c, byVar2);
                            }
                        }
                    } else {
                        a(this.h, byVar2, false);
                        if (o.a(byVar2) <= 0.0d && !TextUtils.isEmpty(byVar2.L())) {
                            arrayList.add(byVar2);
                        } else {
                            arrayList2.add(byVar2);
                        }
                        arrayList3.add(byVar2);
                        nVar = this.c.get(byVar2.G());
                        if (nVar != null) {
                            errorCode = ErrorCode.getErrorCode(ErrorCode.adSourceBidError, "", byVar2.M());
                            if (this.m.c.d != null) {
                                if (nVar != null) {
                                    this.m.c.d.onAdSourceBiddingFail(nVar, errorCode);
                                }
                                this.c.remove(byVar2.G());
                            }
                            a(nVar, errorCode, com.anythink.core.common.v.a.a.b.c, byVar2);
                        }
                    }
                }
                list2.clear();
            }
            com.anythink.core.c.d.c.a(this.m.s.ah(), arrayList3, this.o, this.p, this.m.t, this.m.f);
            if (this.t != null) {
                this.v.addAll(arrayList);
                int iC = this.t.c();
                if (z || this.v.size() >= iC) {
                    j();
                }
            }
            a(arrayList);
            if (this.r) {
                if (arrayList.size() > 0) {
                    List<by> list3 = this.q;
                    if (list3 != null) {
                        list3.addAll(arrayList);
                    }
                    arrayList.clear();
                }
                if (arrayList.size() == 0 && arrayList2.size() == 0) {
                    return;
                }
            }
            boolean zC = c();
            if (this.m.G) {
                if (this.w == null) {
                    this.w = new ArrayList();
                }
                if (!zC) {
                    this.w.addAll(arrayList);
                    arrayList.clear();
                }
                if (!z && arrayList2.isEmpty()) {
                    return;
                }
            }
            if (z) {
                List<by> list4 = this.q;
                if (list4 != null && !list4.isEmpty()) {
                    arrayList.addAll(0, this.q);
                    this.q.clear();
                }
                List<by> list5 = this.w;
                if (list5 != null && !list5.isEmpty() && !zC) {
                    super.b();
                    b(false);
                }
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, new Comparator<by>() { // from class: com.anythink.core.c.b.8
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(by byVar3, by byVar4) {
                        return k.a(byVar3, byVar4);
                    }

                    private static int a(by byVar3, by byVar4) {
                        return k.a(byVar3, byVar4);
                    }
                });
            }
            j.a aVar = this.i;
            if (aVar != null) {
                aVar.a(this.j, arrayList, arrayList2, z);
            }
            if (z) {
                com.anythink.core.common.h hVar = this.e;
                if (hVar != null) {
                    hVar.b();
                }
                this.i = null;
            }
        }
    }

    static /* synthetic */ void a(b bVar, d dVar, int i) {
        dVar.a(bVar.new AnonymousClass5(i));
    }

    static /* synthetic */ void a(b bVar, by byVar, ATBaseAdAdapter aTBaseAdAdapter) {
        n nVarAh;
        String internalNetworkSDKVersion;
        String strValueOf;
        try {
            nVarAh = bVar.m.s.ah();
            try {
                ai.a(nVarAh, byVar, 0, false);
                nVarAh.m(aj.a(byVar, null));
                String str = "";
                if (aTBaseAdAdapter != null) {
                    try {
                        internalNetworkSDKVersion = aTBaseAdAdapter.getInternalNetworkSDKVersion();
                        try {
                            strValueOf = String.valueOf(aTBaseAdAdapter.internalBaseOnAdapterBridgeVersion());
                            str = internalNetworkSDKVersion;
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        internalNetworkSDKVersion = "";
                    }
                } else {
                    strValueOf = "";
                }
                String str2 = strValueOf;
                internalNetworkSDKVersion = str;
                str = str2;
                byVar.B = internalNetworkSDKVersion;
                byVar.C = str;
                bVar.c.put(byVar.G(), nVarAh);
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            nVarAh = null;
        }
        if (byVar.y() != 7 && aTBaseAdAdapter != null) {
            try {
                if (bVar.m.c.d != null) {
                    ai.a(nVarAh);
                    bVar.m.c.d.onAdSourceBiddingAttempt(nVarAh);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        bVar.a(nVarAh, (AdError) null, com.anythink.core.common.v.a.a.b.a, byVar);
        com.anythink.core.common.u.d.a().a(nVarAh, byVar, 1);
    }
}
