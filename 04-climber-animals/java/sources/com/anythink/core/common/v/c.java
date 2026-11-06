package com.anythink.core.common.v;

import android.text.TextUtils;
import com.anythink.core.api.ATAdMixBidInfo;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bu;
import com.anythink.core.common.h.bv;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = "anythink_event_listener";
    private static volatile c b;

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

    public final void a(com.anythink.core.common.d.f fVar) {
        if (fVar != null) {
            a(fVar, fVar.getTrackingInfo());
        }
    }

    public final void a(com.anythink.core.common.d.f fVar, com.anythink.core.common.h.n nVar) {
        if (fVar != null) {
            a(nVar, fVar.getUnitGroupInfo(), fVar, 0);
        }
    }

    public final void b(com.anythink.core.common.d.f fVar) {
        if (fVar != null) {
            b(fVar, fVar.getTrackingInfo());
        }
    }

    public final void b(com.anythink.core.common.d.f fVar, com.anythink.core.common.h.n nVar) {
        if (fVar != null) {
            a(nVar, fVar.getUnitGroupInfo(), fVar, 1);
        }
    }

    private void a(final bu buVar, bv bvVar, final com.anythink.core.common.d.f fVar, final int i) {
        if (buVar == null || bvVar == null || bvVar.g() == 8) {
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.v.c.1
            @Override // java.lang.Runnable
            public final void run() {
                ATAdMixBidInfo.XBiddingInfo xBiddingInfo;
                ATAdMixBidInfo.BidEntity biddingInfo;
                try {
                    com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
                    if (bVarB == null || bVarB.c() == null || !bVarB.c().contains(28) || (xBiddingInfo = ATAdMixBidInfo.getInstance().getXBiddingInfo()) == null || (biddingInfo = xBiddingInfo.getBiddingInfo(com.anythink.core.common.d.l.a(fVar))) == null) {
                        return;
                    }
                    String adTittle = biddingInfo.getAdTittle();
                    String adUserName = biddingInfo.getAdUserName();
                    if (TextUtils.isEmpty(adTittle) && TextUtils.isEmpty(adUserName)) {
                        return;
                    }
                    List<com.anythink.core.common.h.c> listA = com.anythink.core.common.a.a().a(buVar.aI());
                    if (listA != null) {
                        listA.size();
                        for (com.anythink.core.common.h.c cVar : listA) {
                            if (cVar != null && cVar.c() == 0) {
                                com.anythink.core.common.h.n nVarI = cVar.i();
                                bv unitGroupInfo = cVar.e().getUnitGroupInfo();
                                if (unitGroupInfo != null && unitGroupInfo.g() == 28 && unitGroupInfo.o()) {
                                    com.anythink.core.common.h.ad adVarR = unitGroupInfo.R();
                                    new StringBuilder("handleBidLossSend:ks:bidding:").append(adVarR);
                                    if (adVarR != null) {
                                        aw awVar = new aw(8, unitGroupInfo, nVarI, p.a(unitGroupInfo));
                                        awVar.a(biddingInfo);
                                        awVar.a(i);
                                        com.anythink.core.b.d.c.a(adVarR, awVar, true, 32);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }, 2);
    }
}
