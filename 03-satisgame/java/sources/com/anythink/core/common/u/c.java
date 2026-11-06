package com.anythink.core.common.u;

import android.text.TextUtils;
import com.anythink.core.api.ATAdMixBidInfo;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = "anythink_event_listener";
    private static volatile c b;
    private final com.anythink.core.common.t.b c = new com.anythink.core.common.t.b();

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private c() {
    }

    public final com.anythink.core.common.t.b b() {
        return this.c;
    }

    public static void a(com.anythink.core.common.h.c cVar) {
        if (cVar != null) {
            try {
                ATBaseAdAdapter aTBaseAdAdapterE = cVar.e();
                if (aTBaseAdAdapterE != null) {
                    com.anythink.core.bridge.a.a.a();
                    com.anythink.core.bridge.a.a.a(aTBaseAdAdapterE, com.anythink.core.bridge.a.a.a, aTBaseAdAdapterE.getTrackingInfo().aS());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            a(aTBaseAdAdapter, aTBaseAdAdapter.getTrackingInfo(), true);
        }
    }

    public final void a(ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.h.n nVar, boolean z) {
        this.c.a((bx) nVar);
        if (aTBaseAdAdapter != null && z) {
            a(nVar, aTBaseAdAdapter.getUnitGroupInfo(), aTBaseAdAdapter, 0);
        }
        try {
            if (ATSDK.isCnSDK()) {
                com.anythink.core.bridge.a.a.a();
                com.anythink.core.bridge.a.a.a(aTBaseAdAdapter, com.anythink.core.bridge.a.a.b, nVar.aS());
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            b(aTBaseAdAdapter, aTBaseAdAdapter.getTrackingInfo(), true);
        }
    }

    public final void b(ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.h.n nVar, boolean z) {
        this.c.e(nVar);
        if (aTBaseAdAdapter != null && z) {
            a(nVar, aTBaseAdAdapter.getUnitGroupInfo(), aTBaseAdAdapter, 1);
        }
        try {
            if (ATSDK.isCnSDK()) {
                com.anythink.core.bridge.a.a.a();
                com.anythink.core.bridge.a.a.a(aTBaseAdAdapter, com.anythink.core.bridge.a.a.c, nVar.aS());
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(com.anythink.core.common.h.n nVar) {
        this.c.c(nVar);
    }

    public final void c(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            a(aTBaseAdAdapter.getTrackingInfo());
        }
    }

    private void a(final com.anythink.core.common.h.n nVar, by byVar, final ATBaseAdAdapter aTBaseAdAdapter, final int i) {
        if (nVar == null || byVar == null || byVar.n() == 8) {
            return;
        }
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.i, new Runnable() { // from class: com.anythink.core.common.u.c.1
            @Override // java.lang.Runnable
            public final void run() {
                ATAdMixBidInfo.XBiddingInfo xBiddingInfo;
                ATAdMixBidInfo.BidEntity biddingInfo;
                List<com.anythink.core.common.h.c> listA;
                com.anythink.core.common.h.ad adVarY;
                try {
                    com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
                    if (bVarB == null || bVarB.c() == null || !bVarB.c().contains(28) || (xBiddingInfo = ATAdMixBidInfo.getInstance().getXBiddingInfo()) == null || (biddingInfo = xBiddingInfo.getBiddingInfo(com.anythink.core.common.d.k.a(aTBaseAdAdapter))) == null) {
                        return;
                    }
                    String adTittle = biddingInfo.getAdTittle();
                    String adUserName = biddingInfo.getAdUserName();
                    if (TextUtils.isEmpty(adTittle) && TextUtils.isEmpty(adUserName)) {
                        return;
                    }
                    String strAQ = nVar.aQ();
                    com.anythink.core.common.f fVarA = nVar.a();
                    if (fVarA == null || fVarA.e() == null || (listA = fVarA.e().a(strAQ)) == null) {
                        return;
                    }
                    for (com.anythink.core.common.h.c cVar : listA) {
                        if (cVar != null && cVar.c() == 0) {
                            com.anythink.core.common.h.n nVarI = cVar.i();
                            by unitGroupInfo = cVar.e().getUnitGroupInfo();
                            if (unitGroupInfo != null && unitGroupInfo.n() == 28 && unitGroupInfo.w() && (adVarY = unitGroupInfo.Y()) != null) {
                                ay ayVar = new ay(8, unitGroupInfo, nVarI, o.a(unitGroupInfo));
                                ayVar.a(biddingInfo);
                                ayVar.b(i);
                                com.anythink.core.c.d.c.a(adVarY, ayVar, true, 32);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }));
    }
}
