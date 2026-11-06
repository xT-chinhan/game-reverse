package com.anythink.core.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ap;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.p;
import com.anythink.core.common.h.z;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.ae;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.u;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {
    public static final String a = "a";
    private List<bv> b;
    private com.anythink.core.b.b.b c;
    private long d;
    private List<ATBaseAdAdapter> e;
    private l j;

    public a(com.anythink.core.common.h.a aVar) {
        super(aVar);
        this.b = Collections.synchronizedList(new ArrayList(this.f.j));
        this.e = Collections.synchronizedList(new ArrayList());
    }

    @Override // com.anythink.core.b.d
    protected final void a(final com.anythink.core.b.b.b bVar) {
        this.c = bVar;
        List<bv> list = this.f.j;
        this.d = SystemClock.elapsedRealtime();
        for (int i = 0; i < list.size(); i++) {
            final bv bvVar = list.get(i);
            if (bvVar != null) {
                long jBq = bvVar.bq();
                if (jBq > 0) {
                    com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.b.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!a.this.h.get()) {
                                a.this.a(bvVar, bVar);
                                return;
                            }
                            String str = a.a;
                            Object[] objArr = new Object[1];
                            bvVar.z();
                        }
                    }, jBq);
                } else {
                    a(bvVar, bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final bv bvVar, com.anythink.core.b.b.b bVar) {
        p pVarA = u.a(bvVar);
        ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
        if (aTBaseAdAdapter == null) {
            String strA = bvVar.m() + " not exist!";
            if (pVarA != null) {
                strA = pVarA.a(strA);
            }
            a(false, ATBiddingResult.fail(strA), bvVar, -9, (com.anythink.core.b.c.b) null, (com.anythink.core.b.c.a) null);
            return;
        }
        this.e.add(aTBaseAdAdapter);
        try {
            com.anythink.core.b.b.c cVar = new com.anythink.core.b.b.c(aTBaseAdAdapter) { // from class: com.anythink.core.b.a.2
                @Override // com.anythink.core.api.ATBiddingListener
                public final void onC2SBidResult(ATBiddingResult aTBiddingResult) {
                    String internalNetworkSDKVersion = "";
                    if (this.c != null) {
                        try {
                            internalNetworkSDKVersion = this.c.getInternalNetworkSDKVersion();
                        } catch (Throwable unused) {
                            String str = a.a;
                        }
                        a.this.e.remove(this.c);
                        this.c.releaseLoadResource();
                    }
                    a(aTBiddingResult, null, new com.anythink.core.b.c.a(internalNetworkSDKVersion));
                }

                @Override // com.anythink.core.api.ATBiddingListener
                public final void onC2SBiddingResultWithCache(ATBiddingResult aTBiddingResult, BaseAd baseAd) {
                    String internalNetworkSDKVersion = "";
                    if (this.c != null) {
                        try {
                            internalNetworkSDKVersion = this.c.getInternalNetworkSDKVersion();
                        } catch (Throwable unused) {
                            String str = a.a;
                        }
                        a.this.e.remove(this.c);
                        this.c.releaseLoadResource();
                    }
                    a(aTBiddingResult, new com.anythink.core.b.c.b(this.c, baseAd), new com.anythink.core.b.c.a(internalNetworkSDKVersion));
                }

                private void a(final ATBiddingResult aTBiddingResult, final com.anythink.core.b.c.b bVar2, final com.anythink.core.b.c.a aVar) {
                    com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.b.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.a(aTBiddingResult.isSuccessWithUseType(), aTBiddingResult, bvVar, a.a(aTBiddingResult), bVar2, aVar);
                        }
                    });
                }
            };
            aTBaseAdAdapter.getInternalNetworkName();
            this.j = n.a(this.f.b).a(this.f.e);
            Map<String, Object> mapA = this.j.a(this.f.e, this.f.d, bvVar, this.f.c != null ? this.f.c.b() : null);
            try {
                double dA = com.anythink.core.b.d.b.a(this.f, bvVar);
                if (dA > 0.0d) {
                    mapA.put("bid_floor", Double.valueOf(dA * a(bvVar)));
                }
            } catch (Throwable th) {
                Log.w(ab.a, "C2S startBidRequest with exception:" + th.getMessage());
            }
            com.anythink.core.common.h.n nVarAf = this.f.s.af();
            aj.a(nVarAf, bvVar, 0, false);
            com.anythink.core.common.v.p.a(mapA, nVarAf);
            if (bvVar.g() == 22) {
                com.anythink.core.common.v.f.a(this.j, mapA, bvVar, this.f.x);
            }
            Context contextA = this.f.c != null ? this.f.c.a() : null;
            if (contextA == null) {
                contextA = this.f.b;
            }
            boolean zInternalStartBiddingRequest = aTBaseAdAdapter.internalStartBiddingRequest(contextA, mapA, this.f.q, new com.anythink.core.b.b.a(this.f.s, bvVar.z(), mapA, cVar));
            if (bVar != null) {
                bVar.a(bvVar, aTBaseAdAdapter);
            }
            if (zInternalStartBiddingRequest) {
                return;
            }
            a(ATBiddingResult.fail("This network don't support head bidding in current TopOn's version."), bvVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
            a(ATBiddingResult.fail(th2.getMessage()), bvVar);
        }
    }

    private boolean a(final bv bvVar, z zVar, long j, int i, com.anythink.core.b.c.b bVar, com.anythink.core.b.c.a aVar) {
        boolean z;
        int i2;
        final ATBaseAdAdapter aTBaseAdAdapterA;
        boolean zIsSuccessWithUseType = zVar.isSuccessWithUseType();
        ad adVarA = a(bvVar, zVar, j, bVar, aVar);
        double price = zIsSuccessWithUseType ? adVarA.getPrice() : 0.0d;
        boolean zA = a(zIsSuccessWithUseType, bvVar, adVarA);
        double dAP = bvVar.aP();
        Object[] objArr = new Object[2];
        Double.valueOf(dAP);
        Double.valueOf(price);
        if (dAP > 0.0d) {
            z = price <= dAP;
            Object[] objArr2 = new Object[1];
            Boolean.valueOf(z);
        } else {
            z = true;
        }
        AdError adErrorA = ae.a(0, this.f.s, bvVar, adVarA);
        boolean z2 = adErrorA != null;
        if (zIsSuccessWithUseType && !zA && z && !z2) {
            bvVar.z();
            bvVar.g();
            zVar.getPrice();
            zVar.getSortPrice();
            zVar.currency.toString();
            a(bvVar, adVarA);
            ab.a(j.r.m, this.f.e, com.anythink.core.common.v.p.f(String.valueOf(this.f.f)), bvVar);
            return true;
        }
        if (zA) {
            a(bvVar, ATBidRequestInfo.LESS_THAN_BID_FLOOR_TYPE, j, -11);
            bvVar.b(price);
            bvVar.e(adVarA.getSortPrice());
            a(adVarA, bvVar);
        } else if (z2) {
            a(bvVar, adErrorA.getPlatformMSG(), j, -13);
            bvVar.b(price);
            bvVar.e(adVarA.getSortPrice());
            b(adVarA, bvVar);
        } else {
            if (z || bvVar.g() != 72) {
                i2 = i;
            } else {
                zVar.errorMsg = ATBidRequestInfo.JAD_PRICE_EXCEPTION_TYPE;
                i2 = -12;
            }
            a(bvVar, zVar.errorMsg, j, i2);
            adVarA.errorMsg = zVar.getErrorMsg();
            bvVar.a(adVarA);
        }
        if (bVar != null && (aTBaseAdAdapterA = bVar.a()) != null) {
            t.b().b(new Runnable() { // from class: com.anythink.core.b.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        String str = a.a;
                        new StringBuilder("destroy adapter: ").append(aTBaseAdAdapterA).append("\n").append(bvVar);
                        ATBaseAdAdapter aTBaseAdAdapter = aTBaseAdAdapterA;
                        if (aTBaseAdAdapter != null) {
                            aTBaseAdAdapter.internalDestory();
                        }
                    } catch (Throwable th) {
                        Log.e("anythink", "destroy error:" + aTBaseAdAdapterA, th);
                    }
                }
            });
        }
        ab.a(j.r.n, this.f.e, com.anythink.core.common.v.p.f(String.valueOf(this.f.f)), bvVar);
        return false;
    }

    private static void a(bv bvVar, z zVar) {
        if (bvVar.g() == 75) {
            bvVar.z();
            Object extra = zVar.getExtra();
            if (extra == null) {
                bvVar.z();
                return;
            }
            String str = (String) extra;
            JSONObject jSONObjectAR = bvVar.aR();
            if (jSONObjectAR != null && !TextUtils.isEmpty(str)) {
                double dOptDouble = jSONObjectAR.optDouble(str, 0.0d);
                if (dOptDouble > 0.0d) {
                    bvVar.z();
                    zVar.setSortPrice(dOptDouble);
                    zVar.setPrice(dOptDouble);
                    return;
                }
                bvVar.z();
                return;
            }
            new StringBuilder("Amazon c2s handle error, apsPricePointJsonObject=").append(jSONObjectAR);
            bvVar.z();
        }
    }

    private ad a(bv bvVar, z zVar, long j, com.anythink.core.b.c.b bVar, com.anythink.core.b.c.a aVar) {
        double dA;
        Double dValueOf;
        double dA2;
        Double dValueOf2;
        a(bvVar, zVar);
        bvVar.c(j);
        bvVar.a(zVar.currency);
        double dA3 = a(zVar.getSortPrice(), bvVar);
        boolean zIsSamePrice = zVar.isSamePrice();
        double dA4 = zIsSamePrice ? dA3 : a(zVar.getPrice(), bvVar);
        if (dA3 <= 0.0d) {
            Log.w(ab.a, "NetworkName:" + bvVar.h() + ",AdSourceId:" + bvVar.z() + " c2s sort price return 0,please check network placement c2s config");
            dValueOf = Double.valueOf(dA3);
            dA = com.anythink.core.common.v.p.a(bvVar);
        } else {
            dA = dA3;
            dValueOf = null;
        }
        if (dA4 <= 0.0d) {
            Log.w(ab.a, "NetworkName:" + bvVar.h() + ",AdSourceId:" + bvVar.z() + " c2s real price return 0,please check network placement c2s config");
            dValueOf2 = Double.valueOf(dA4);
            dA2 = com.anythink.core.common.v.p.a(bvVar);
        } else {
            dA2 = dA4;
            dValueOf2 = null;
        }
        if (dValueOf != null || dValueOf2 != null) {
            com.anythink.core.common.u.e.a(this.f.d, this.f.e, bvVar, dValueOf, dValueOf2, aVar);
        }
        ad adVar = new ad(zVar.isSuccessWithUseType(), dA, dA2, zVar.token, zVar.winNoticeUrl, zVar.loseNoticeUrl, zVar.displayNoticeUrl, "");
        adVar.l = a(bvVar);
        ATAdConst.CURRENCY currency = zVar.currency;
        if (currency != null) {
            adVar.b = currency.toString();
        }
        adVar.setExtra(zVar.getExtra());
        adVar.setBiddingNotice(zVar.biddingNotice);
        adVar.f = bvVar.s() + System.currentTimeMillis();
        adVar.e = bvVar.s();
        adVar.k = bvVar.z();
        adVar.d = bvVar.g();
        adVar.s = bVar;
        adVar.t = bVar != null;
        double dA5 = zVar.originPrice;
        int i = AnonymousClass4.a[zVar.currency.ordinal()];
        if (i == 1) {
            dA5 = zVar.originPrice;
        } else if (i == 2) {
            dA5 = zVar.originPrice / 100.0d;
        } else if (i == 3) {
            dA5 = zVar.originPrice * com.anythink.core.common.v.t.a();
        }
        adVar.rmbPrice = dA5;
        a(bvVar.g(), adVar, 0.0d, zIsSamePrice);
        a((z) adVar, bvVar);
        return adVar;
    }

    /* JADX INFO: renamed from: com.anythink.core.b.a$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
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

    @Override // com.anythink.core.b.d
    protected final void a(bv bvVar, z zVar, long j) {
        a(bvVar, zVar, j, -1, (com.anythink.core.b.c.b) null, (com.anythink.core.b.c.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, ATBiddingResult aTBiddingResult, bv bvVar, int i, com.anythink.core.b.c.b bVar, com.anythink.core.b.c.a aVar) {
        ap apVarAW;
        ap apVarBi;
        if (z) {
            f fVarA = f.a();
            com.anythink.core.common.u.e.a(this.f.e, bvVar, fVarA.b == null || fVarA.b.get(new StringBuilder().append(bvVar.z()).append("_c2sfirstStatus").toString()) == null, SystemClock.elapsedRealtime() - this.d, this.f);
        }
        f fVarA2 = f.a();
        String strZ = bvVar.z();
        if (fVarA2.b == null) {
            fVarA2.b = new ConcurrentHashMap<>();
        }
        fVarA2.b.put(strZ + "_c2sfirstStatus", 1);
        if (!this.h.get()) {
            boolean zA = a(bvVar, aTBiddingResult, SystemClock.elapsedRealtime() - this.d, i, bVar, aVar);
            List<bv> listSynchronizedList = Collections.synchronizedList(new ArrayList(1));
            listSynchronizedList.add(bvVar);
            this.b.remove(bvVar);
            if (this.b.size() == 0) {
                this.h.set(true);
            }
            if (this.c != null) {
                if (!zA) {
                    zA = a(bvVar, aTBiddingResult.errorMsg, -1);
                }
                if (zA) {
                    l lVar = this.j;
                    if (lVar != null && bvVar != null && (apVarAW = bvVar.aW()) != null && (apVarBi = lVar.bi()) != null) {
                        String strC = apVarBi.c();
                        apVarAW.c(strC);
                        if (!TextUtils.isEmpty(strC)) {
                            String strZ2 = bvVar.z();
                            com.anythink.core.common.q.b bVarB = com.anythink.core.common.q.a.b(strC, strZ2 + "_" + bvVar.D() + "_" + this.f.d);
                            Object[] objArr = new Object[2];
                            bVarB.b();
                            apVarAW.b(bVarB.a());
                            com.anythink.core.common.q.b bVarB2 = com.anythink.core.common.q.a.b(strC, strZ2 + "_" + bvVar.c() + "_" + this.f.d);
                            Object[] objArr2 = new Object[2];
                            bVarB2.b();
                            apVarAW.d(bVarB2.a());
                        }
                    }
                    this.c.a(listSynchronizedList, (List<bv>) null);
                    return;
                }
                this.c.a((List<bv>) null, listSynchronizedList);
            }
            return;
        }
        ad adVarA = a(bvVar, aTBiddingResult, SystemClock.elapsedRealtime() - this.d, bVar, aVar);
        com.anythink.core.b.d.c.a(adVarA, new aw(4, bvVar, this.f.s, adVarA.getPrice()), true, 29);
    }

    private synchronized void a(ATBiddingResult aTBiddingResult, bv bvVar) {
        a(false, aTBiddingResult, bvVar, -1, (com.anythink.core.b.c.b) null, (com.anythink.core.b.c.a) null);
    }

    private static ATBiddingResult a(String str) {
        return ATBiddingResult.fail(str);
    }

    @Override // com.anythink.core.b.d
    public final synchronized void a() {
        if (!this.h.get()) {
            this.h.set(true);
            ArrayList arrayList = new ArrayList(3);
            ArrayList arrayList2 = new ArrayList(3);
            for (bv bvVar : this.b) {
                if (a(bvVar, "bid timeout", -3)) {
                    arrayList.add(bvVar);
                } else {
                    a(bvVar, ATBiddingResult.fail("bid timeout!"), SystemClock.elapsedRealtime() - this.d, -3, (com.anythink.core.b.c.b) null, (com.anythink.core.b.c.a) null);
                    arrayList2.add(bvVar);
                }
            }
            this.b.clear();
            com.anythink.core.b.b.b bVar = this.c;
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

    private static void a(z zVar, bv bvVar) {
        double dAQ = bvVar.aQ();
        Object[] objArr = new Object[2];
        Double.valueOf(zVar.originPrice);
        Double.valueOf(dAQ);
        if (dAQ > 0.0d) {
            double d = zVar.originPrice * (1.0d - dAQ);
            Object[] objArr2 = new Object[1];
            Double.valueOf(d);
            zVar.setPrice(d);
            zVar.setSortPrice(d);
        }
    }

    private static boolean b(double d, bv bvVar) {
        double dAP = bvVar.aP();
        Object[] objArr = new Object[2];
        Double.valueOf(dAP);
        Double.valueOf(d);
        if (dAP <= 0.0d) {
            return true;
        }
        boolean z = d <= dAP;
        Object[] objArr2 = new Object[1];
        Boolean.valueOf(z);
        return z;
    }

    private void a(l lVar, bv bvVar) {
        ap apVarAW;
        ap apVarBi;
        if (lVar == null || bvVar == null || (apVarAW = bvVar.aW()) == null || (apVarBi = lVar.bi()) == null) {
            return;
        }
        String strC = apVarBi.c();
        apVarAW.c(strC);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        String strZ = bvVar.z();
        com.anythink.core.common.q.b bVarB = com.anythink.core.common.q.a.b(strC, strZ + "_" + bvVar.D() + "_" + this.f.d);
        Object[] objArr = new Object[2];
        bVarB.b();
        apVarAW.b(bVarB.a());
        com.anythink.core.common.q.b bVarB2 = com.anythink.core.common.q.a.b(strC, strZ + "_" + bvVar.c() + "_" + this.f.d);
        Object[] objArr2 = new Object[2];
        bVarB2.b();
        apVarAW.d(bVarB2.a());
    }

    static /* synthetic */ int a(ATBiddingResult aTBiddingResult) {
        if (aTBiddingResult.isSuccessWithUseType()) {
            return 0;
        }
        return TextUtils.equals(aTBiddingResult.errorMsg, ATBidRequestInfo.BID_TYPE_ERROR_TYPE) ? -10 : -1;
    }
}
