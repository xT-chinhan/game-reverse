package com.anythink.core.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.p;
import com.anythink.core.common.h.z;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ac;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.t;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {
    public static final String a = "a";
    private List<by> b;
    private com.anythink.core.c.b.b c;
    private long d;
    private List<ATBaseAdAdapter> e;
    private l k;

    public a(com.anythink.core.common.h.a aVar) {
        super(aVar);
        this.b = Collections.synchronizedList(new ArrayList(this.f.j));
        this.e = Collections.synchronizedList(new ArrayList());
    }

    @Override // com.anythink.core.c.d
    protected final void a(final com.anythink.core.c.b.b bVar) {
        this.c = bVar;
        List<by> list = this.f.j;
        this.d = SystemClock.elapsedRealtime();
        for (int i = 0; i < list.size(); i++) {
            final by byVar = list.get(i);
            if (byVar != null) {
                long jBy = byVar.by();
                if (jBy > 0) {
                    com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.V, new Runnable() { // from class: com.anythink.core.c.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.h.get()) {
                                return;
                            }
                            a.this.a(byVar, bVar);
                        }
                    }), jBy);
                } else {
                    a(byVar, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final by byVar, final com.anythink.core.c.b.b bVar) {
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.W, new Runnable() { // from class: com.anythink.core.c.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.b(a.this, byVar, bVar);
            }
        }));
    }

    private void b(by byVar, com.anythink.core.c.b.b bVar) {
        p pVarA = t.a(byVar);
        ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
        if (aTBaseAdAdapter == null) {
            String strB = byVar.u() + " not exist!";
            if (pVarA != null) {
                strB = pVarA.b(strB);
            }
            a(false, ATBiddingResult.fail(strB), byVar, -9, (com.anythink.core.c.c.c) null, (com.anythink.core.c.c.b) null);
            return;
        }
        this.e.add(aTBaseAdAdapter);
        try {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(aTBaseAdAdapter, byVar);
            this.k = n.a(this.f.b).a(this.f.e);
            Map<String, Object> mapA = this.k.a(this.f.e, this.f.d, byVar, this.f.c != null ? this.f.c.b() : null);
            try {
                double dA = com.anythink.core.c.d.b.a(this.f, byVar);
                if (dA > 0.0d) {
                    mapA.put("bid_floor", Double.valueOf(dA * a(byVar)));
                }
            } catch (Throwable th) {
                Log.w(aa.a, "C2S startBidRequest with exception:" + th.getMessage());
            }
            com.anythink.core.common.h.n nVarAh = this.f.s.ah();
            ai.a(nVarAh, byVar, 0, false);
            o.a(mapA, nVarAh);
            if (byVar.n() == 22) {
                com.anythink.core.common.u.f.a(this.k, mapA, byVar, nVarAh, this.f.x);
            }
            Context contextA = this.f.c != null ? this.f.c.a() : null;
            if (contextA == null) {
                contextA = this.f.b;
            }
            boolean zInternalStartBiddingRequest = aTBaseAdAdapter.internalStartBiddingRequest(contextA, mapA, this.f.q, new com.anythink.core.c.b.a(this.f.s, byVar.G(), mapA, anonymousClass3));
            if (bVar != null) {
                bVar.a(byVar, aTBaseAdAdapter);
            }
            if (zInternalStartBiddingRequest) {
                return;
            }
            a(ATBiddingResult.fail("This network don't support head bidding in current TopOn's version."), byVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
            a(ATBiddingResult.fail(th2.getMessage()), byVar);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.c.a$3, reason: invalid class name */
    final class AnonymousClass3 extends com.anythink.core.c.b.c {
        final /* synthetic */ by a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ATBaseAdAdapter aTBaseAdAdapter, by byVar) {
            super(aTBaseAdAdapter);
            this.a = byVar;
        }

        @Override // com.anythink.core.api.ATBiddingListener
        public final void onC2SBidResult(ATBiddingResult aTBiddingResult) {
            String internalNetworkSDKVersion = "";
            if (this.c != null) {
                try {
                    internalNetworkSDKVersion = this.c.getInternalNetworkSDKVersion();
                } catch (Throwable unused) {
                }
                a.this.e.remove(this.c);
                this.c.releaseLoadResource();
            }
            a(aTBiddingResult, null, new com.anythink.core.c.c.b(internalNetworkSDKVersion));
        }

        @Override // com.anythink.core.api.ATBiddingListener
        public final void onC2SBiddingResultWithCache(ATBiddingResult aTBiddingResult, BaseAd baseAd) {
            String internalNetworkSDKVersion = "";
            if (this.c != null) {
                try {
                    internalNetworkSDKVersion = this.c.getInternalNetworkSDKVersion();
                } catch (Throwable unused) {
                }
                a.this.e.remove(this.c);
                this.c.releaseLoadResource();
            }
            a(aTBiddingResult, new com.anythink.core.c.c.c(this.c, baseAd), new com.anythink.core.c.c.b(internalNetworkSDKVersion));
        }

        private void a(final ATBiddingResult aTBiddingResult, final com.anythink.core.c.c.c cVar, final com.anythink.core.c.c.b bVar) {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.U, new Runnable() { // from class: com.anythink.core.c.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a(aTBiddingResult.isSuccessWithUseType(), aTBiddingResult, AnonymousClass3.this.a, a.a(aTBiddingResult), cVar, bVar);
                }
            }));
        }
    }

    private boolean a(by byVar, z zVar, long j, int i, com.anythink.core.c.c.c cVar, com.anythink.core.c.c.b bVar) {
        int i2;
        final ATBaseAdAdapter aTBaseAdAdapterA;
        boolean zIsSuccessWithUseType = zVar.isSuccessWithUseType();
        ad adVarA = a(byVar, zVar, j, cVar, bVar);
        double price = zIsSuccessWithUseType ? adVarA.getPrice() : 0.0d;
        boolean zA = a(zIsSuccessWithUseType, byVar, adVarA);
        double dAX = byVar.aX();
        boolean z = dAX <= 0.0d || price <= dAX;
        AdError adErrorA = zIsSuccessWithUseType ? ac.a(0, this.f.s, byVar, adVarA) : null;
        boolean z2 = adErrorA != null;
        if (zIsSuccessWithUseType && !zA && z && !z2) {
            a(byVar, adVarA);
            aa.a(i.s.m, this.f.e, o.f(String.valueOf(this.f.f)), byVar);
            return true;
        }
        if (zA) {
            a(byVar, ATBidRequestInfo.LESS_THAN_BID_FLOOR_TYPE, j, -11);
            byVar.b(price);
            byVar.e(adVarA.getSortPrice());
            byVar.a(adVarA);
        } else if (z2) {
            a(byVar, adErrorA.getPlatformMSG(), j, -13);
            byVar.b(price);
            byVar.e(adVarA.getSortPrice());
            byVar.a(adVarA);
        } else {
            if (z || byVar.n() != 72) {
                i2 = i;
            } else {
                zVar.errorMsg = ATBidRequestInfo.JAD_PRICE_EXCEPTION_TYPE;
                i2 = -12;
            }
            a(byVar, zVar.errorMsg, j, i2);
            adVarA.errorMsg = zVar.getErrorMsg();
            byVar.a(adVarA);
        }
        if (cVar != null && (aTBaseAdAdapterA = cVar.a()) != null) {
            s.b();
            s.b(new Runnable() { // from class: com.anythink.core.c.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ATBaseAdAdapter aTBaseAdAdapter = aTBaseAdAdapterA;
                        if (aTBaseAdAdapter != null) {
                            aTBaseAdAdapter.internalDestroy();
                        }
                    } catch (Throwable th) {
                        Log.e("anythink", "destroy error:" + aTBaseAdAdapterA, th);
                    }
                }
            });
        }
        aa.a(i.s.n, this.f.e, o.f(String.valueOf(this.f.f)), byVar);
        return false;
    }

    private static void a(by byVar, z zVar) {
        Object extra;
        if (byVar.n() != 75 || (extra = zVar.getExtra()) == null) {
            return;
        }
        String str = (String) extra;
        JSONObject jSONObjectAZ = byVar.aZ();
        if (jSONObjectAZ == null || TextUtils.isEmpty(str)) {
            return;
        }
        double dOptDouble = jSONObjectAZ.optDouble(str, 0.0d);
        if (dOptDouble > 0.0d) {
            zVar.setSortPrice(dOptDouble);
            zVar.setPrice(dOptDouble);
        }
    }

    private ad a(by byVar, z zVar, long j, com.anythink.core.c.c.c cVar, com.anythink.core.c.c.b bVar) {
        double dA;
        Double dValueOf;
        double dA2;
        Double dValueOf2;
        a(byVar, zVar);
        byVar.e(j);
        byVar.a(zVar.currency);
        double dA3 = a(zVar.getSortPrice(), byVar);
        boolean zIsSamePrice = zVar.isSamePrice();
        double dA4 = zIsSamePrice ? dA3 : a(zVar.getPrice(), byVar);
        if (dA3 <= 0.0d) {
            Log.w(aa.a, "NetworkName:" + byVar.o() + ",AdSourceId:" + byVar.G() + " c2s sort price return 0,please check network placement c2s config");
            dValueOf = Double.valueOf(dA3);
            dA = o.a(byVar);
        } else {
            dA = dA3;
            dValueOf = null;
        }
        if (dA4 <= 0.0d) {
            Log.w(aa.a, "NetworkName:" + byVar.o() + ",AdSourceId:" + byVar.G() + " c2s real price return 0,please check network placement c2s config");
            dValueOf2 = Double.valueOf(dA4);
            dA2 = o.a(byVar);
        } else {
            dA2 = dA4;
            dValueOf2 = null;
        }
        if (dValueOf != null || dValueOf2 != null) {
            com.anythink.core.common.t.f.a(this.f.d, this.f.e, byVar, dValueOf, dValueOf2, bVar);
        }
        ad adVar = new ad(zVar.isSuccessWithUseType(), dA, dA2, zVar.token, zVar.winNoticeUrl, zVar.loseNoticeUrl, zVar.displayNoticeUrl, "");
        adVar.l = a(byVar);
        ATAdConst.CURRENCY currency = zVar.currency;
        if (currency != null) {
            adVar.b = currency.toString();
        }
        adVar.setExtra(zVar.getExtra());
        adVar.setBiddingNotice(zVar.biddingNotice);
        adVar.f = byVar.A() + System.currentTimeMillis();
        adVar.e = byVar.A();
        adVar.k = byVar.G();
        adVar.d = byVar.n();
        adVar.s = cVar;
        adVar.t = cVar != null;
        double dA5 = zVar.originPrice;
        int i = AnonymousClass5.a[zVar.currency.ordinal()];
        if (i == 1) {
            dA5 = zVar.originPrice;
        } else if (i == 2) {
            dA5 = zVar.originPrice / 100.0d;
        } else if (i == 3) {
            dA5 = zVar.originPrice * com.anythink.core.common.u.s.a();
        }
        adVar.rmbPrice = dA5;
        a(byVar.n(), adVar, 0.0d, zIsSamePrice);
        a((z) adVar, byVar);
        adVar.commonAdManager = this.f != null ? this.f.J : null;
        return adVar;
    }

    /* JADX INFO: renamed from: com.anythink.core.c.a$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ATAdConst.CURRENCY.values().length];
            a = iArr;
            try {
                iArr[ATAdConst.CURRENCY.RMB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ATAdConst.CURRENCY.RMB_CENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ATAdConst.CURRENCY.USD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.anythink.core.c.d
    protected final void a(by byVar, z zVar, long j) {
        a(byVar, zVar, j, -1, (com.anythink.core.c.c.c) null, (com.anythink.core.c.c.b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    public synchronized void a(boolean z, ATBiddingResult aTBiddingResult, by byVar, int i, com.anythink.core.c.c.c cVar, com.anythink.core.c.c.b bVar) {
        aq aqVarBe;
        aq aqVarBe2;
        boolean z2;
        f fVarC = c();
        if (z) {
            if (fVarC != null) {
                z2 = fVarC.b == null || fVarC.b.get(new StringBuilder().append(byVar.G()).append("_c2sfirstStatus").toString()) == null;
            }
            com.anythink.core.common.t.f.a(this.f.e, byVar, z2, SystemClock.elapsedRealtime() - this.d, this.f);
        }
        if (fVarC != null) {
            String strG = byVar.G();
            if (fVarC.b == null) {
                fVarC.b = new ConcurrentHashMap<>();
            }
            fVarC.b.put(strG + "_c2sfirstStatus", 1);
        }
        if (!this.h.get()) {
            boolean zA = a(byVar, aTBiddingResult, SystemClock.elapsedRealtime() - this.d, i, cVar, bVar);
            List<by> listSynchronizedList = Collections.synchronizedList(new ArrayList(1));
            listSynchronizedList.add(byVar);
            this.b.remove(byVar);
            if (this.b.size() == 0) {
                this.h.set(true);
            }
            if (this.c != null) {
                if (!zA) {
                    zA = a(byVar, aTBiddingResult.errorMsg, -1);
                }
                if (zA) {
                    l lVar = this.k;
                    if (lVar != null && byVar != null && (aqVarBe = byVar.be()) != null && (aqVarBe2 = lVar.be()) != null) {
                        String strC = aqVarBe2.c();
                        aqVarBe.c(strC);
                        if (!TextUtils.isEmpty(strC)) {
                            String strG2 = byVar.G();
                            aqVarBe.b(com.anythink.core.common.p.a.b(strC, strG2 + "_" + byVar.K() + "_" + this.f.d).a());
                            aqVarBe.d(com.anythink.core.common.p.a.b(strC, strG2 + "_" + byVar.j() + "_" + this.f.d).a());
                        }
                    }
                    this.c.a(listSynchronizedList, (List<by>) null);
                    return;
                }
                this.c.a((List<by>) null, listSynchronizedList);
            }
            return;
        }
        ad adVarA = a(byVar, aTBiddingResult, SystemClock.elapsedRealtime() - this.d, cVar, bVar);
        com.anythink.core.c.d.c.a(adVarA, new ay(4, byVar, this.f.s, adVarA.getPrice()), true, 29);
    }

    private synchronized void a(ATBiddingResult aTBiddingResult, by byVar) {
        a(false, aTBiddingResult, byVar, -1, (com.anythink.core.c.c.c) null, (com.anythink.core.c.c.b) null);
    }

    private static ATBiddingResult a(String str) {
        return ATBiddingResult.fail(str);
    }

    @Override // com.anythink.core.c.d
    public final synchronized void a() {
        if (!this.h.get()) {
            this.h.set(true);
            ArrayList arrayList = new ArrayList(3);
            ArrayList arrayList2 = new ArrayList(3);
            for (by byVar : this.b) {
                if (a(byVar, "bid timeout", -3)) {
                    arrayList.add(byVar);
                } else {
                    a(byVar, ATBiddingResult.fail("bid timeout!"), SystemClock.elapsedRealtime() - this.d, -3, (com.anythink.core.c.c.c) null, (com.anythink.core.c.c.b) null);
                    arrayList2.add(byVar);
                }
            }
            this.b.clear();
            com.anythink.core.c.b.b bVar = this.c;
            if (bVar != null) {
                bVar.a(arrayList, arrayList2);
            }
            this.c = null;
        }
    }

    private static int b(ATBiddingResult aTBiddingResult) {
        if (aTBiddingResult.isSuccessWithUseType()) {
            return 0;
        }
        return TextUtils.equals(aTBiddingResult.errorMsg, ATBidRequestInfo.BID_TYPE_ERROR_TYPE) ? -10 : -1;
    }

    private static void a(z zVar, by byVar) {
        double dAY = byVar.aY();
        if (dAY > 0.0d) {
            double d = zVar.originPrice * (1.0d - dAY);
            zVar.setPrice(d);
            zVar.setSortPrice(d);
        }
    }

    private static boolean b(double d, by byVar) {
        double dAX = byVar.aX();
        return dAX <= 0.0d || d <= dAX;
    }

    private void a(l lVar, by byVar) {
        aq aqVarBe;
        aq aqVarBe2;
        if (lVar == null || byVar == null || (aqVarBe = byVar.be()) == null || (aqVarBe2 = lVar.be()) == null) {
            return;
        }
        String strC = aqVarBe2.c();
        aqVarBe.c(strC);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        String strG = byVar.G();
        aqVarBe.b(com.anythink.core.common.p.a.b(strC, strG + "_" + byVar.K() + "_" + this.f.d).a());
        aqVarBe.d(com.anythink.core.common.p.a.b(strC, strG + "_" + byVar.j() + "_" + this.f.d).a());
    }

    static /* synthetic */ void b(a aVar, by byVar, com.anythink.core.c.b.b bVar) {
        p pVarA = t.a(byVar);
        ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
        if (aTBaseAdAdapter == null) {
            String strB = byVar.u() + " not exist!";
            if (pVarA != null) {
                strB = pVarA.b(strB);
            }
            aVar.a(false, ATBiddingResult.fail(strB), byVar, -9, (com.anythink.core.c.c.c) null, (com.anythink.core.c.c.b) null);
            return;
        }
        aVar.e.add(aTBaseAdAdapter);
        try {
            AnonymousClass3 anonymousClass3 = aVar.new AnonymousClass3(aTBaseAdAdapter, byVar);
            aVar.k = n.a(aVar.f.b).a(aVar.f.e);
            Map<String, Object> mapA = aVar.k.a(aVar.f.e, aVar.f.d, byVar, aVar.f.c != null ? aVar.f.c.b() : null);
            try {
                double dA = com.anythink.core.c.d.b.a(aVar.f, byVar);
                if (dA > 0.0d) {
                    mapA.put("bid_floor", Double.valueOf(dA * aVar.a(byVar)));
                }
            } catch (Throwable th) {
                Log.w(aa.a, "C2S startBidRequest with exception:" + th.getMessage());
            }
            com.anythink.core.common.h.n nVarAh = aVar.f.s.ah();
            ai.a(nVarAh, byVar, 0, false);
            o.a(mapA, nVarAh);
            if (byVar.n() == 22) {
                com.anythink.core.common.u.f.a(aVar.k, mapA, byVar, nVarAh, aVar.f.x);
            }
            Context contextA = aVar.f.c != null ? aVar.f.c.a() : null;
            if (contextA == null) {
                contextA = aVar.f.b;
            }
            boolean zInternalStartBiddingRequest = aTBaseAdAdapter.internalStartBiddingRequest(contextA, mapA, aVar.f.q, new com.anythink.core.c.b.a(aVar.f.s, byVar.G(), mapA, anonymousClass3));
            if (bVar != null) {
                bVar.a(byVar, aTBaseAdAdapter);
            }
            if (zInternalStartBiddingRequest) {
                return;
            }
            aVar.a(ATBiddingResult.fail("This network don't support head bidding in current TopOn's version."), byVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
            aVar.a(ATBiddingResult.fail(th2.getMessage()), byVar);
        }
    }

    static /* synthetic */ int a(ATBiddingResult aTBiddingResult) {
        if (aTBiddingResult.isSuccessWithUseType()) {
            return 0;
        }
        return TextUtils.equals(aTBiddingResult.errorMsg, ATBidRequestInfo.BID_TYPE_ERROR_TYPE) ? -10 : -1;
    }
}
