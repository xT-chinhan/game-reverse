package com.anythink.core.b;

import android.os.SystemClock;
import android.util.Log;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.p;
import com.anythink.core.common.h.z;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h extends d {
    private String a;
    private long b;
    private com.anythink.core.b.b.b c;

    @Override // com.anythink.core.b.d
    protected final void a(bv bvVar, z zVar, long j) {
    }

    public h(com.anythink.core.common.h.a aVar) {
        super(aVar);
        this.a = "IH Bidding";
    }

    @Override // com.anythink.core.b.d
    protected final void a(final com.anythink.core.b.b.b bVar) {
        this.c = bVar;
        this.b = SystemClock.elapsedRealtime();
        List<bv> list = this.f.j;
        if (ATSDK.isNetworkLogDebug()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("Start IH Bidding List", a(list));
            } catch (Exception unused) {
            }
            ab.a(ab.a, jSONObject.toString(), false);
        }
        if (f.a().b() == null) {
            Iterator<bv> it = list.iterator();
            while (it.hasNext()) {
                p pVarA = u.a(it.next());
                ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
                if (aTBaseAdAdapter != null) {
                    MediationBidManager bidManager = aTBaseAdAdapter.getBidManager();
                    if (bidManager == null) {
                        break;
                    }
                    f.a().a(bidManager);
                    break;
                }
            }
        }
        MediationBidManager mediationBidManagerB = f.a().b();
        if (mediationBidManagerB == null) {
            Log.i(ab.a, "No BidManager.");
            a((List<bv>) null, -9);
        } else {
            mediationBidManagerB.setBidRequestUrl(this.f.o);
            mediationBidManagerB.startBid(this.f, new MediationBidManager.BidListener() { // from class: com.anythink.core.b.h.1
                @Override // com.anythink.core.api.MediationBidManager.BidListener
                public final void onBidFail(String str) {
                }

                @Override // com.anythink.core.api.MediationBidManager.BidListener
                public final void onBidStart(bv bvVar, ATBaseAdAdapter aTBaseAdAdapter2) {
                    com.anythink.core.b.b.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(bvVar, aTBaseAdAdapter2);
                    }
                }

                @Override // com.anythink.core.api.MediationBidManager.BidListener
                public final void onBidSuccess(List<bv> list2) {
                    h.this.a(list2, -1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<bv> list, int i) {
        if (this.h.get()) {
            return;
        }
        this.h.set(true);
        List<bv> arrayList = list == null ? new ArrayList<>() : list;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator<bv> it = this.f.j.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            bv next = it.next();
            for (bv bvVar : arrayList) {
                if (next.z().equals(bvVar.z())) {
                    bvVar.c(jElapsedRealtime);
                    bvVar.g(0);
                    ad adVar = new ad(true, bvVar.D(), bvVar.E(), "", "", "", "");
                    adVar.f = bvVar.s() + System.currentTimeMillis();
                    adVar.e = bvVar.s();
                    a(bvVar, adVar);
                    z = true;
                    break;
                }
            }
            if (!z) {
                if (MediationBidManager.NO_BID_TOKEN_ERROR.equals(next.F())) {
                    b(next, "No Bid Info.", 0L, -2);
                } else {
                    b(next, "No Bid Info.", jElapsedRealtime, i);
                }
                if (a(next, "No Bid Info.", i)) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
        }
        if (ATSDK.isNetworkLogDebug()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("IH Bidding Success List", a(arrayList));
                jSONObject.put("IH Bidding Fail List", a(arrayList2));
            } catch (Exception unused) {
            }
            ab.a(this.a, jSONObject.toString(), false);
        }
        this.h.set(true);
        com.anythink.core.b.b.b bVar = this.c;
        if (bVar != null) {
            bVar.a(arrayList, arrayList2);
        }
    }

    @Override // com.anythink.core.b.d
    protected final void a() {
        a((List<bv>) null, -3);
    }

    private static void b(bv bvVar, String str, long j, int i) {
        a(bvVar, str, j, i);
    }

    private void b(bv bvVar) {
        ad adVar = new ad(true, bvVar.D(), bvVar.E(), "", "", "", "");
        adVar.f = bvVar.s() + System.currentTimeMillis();
        adVar.e = bvVar.s();
        a(bvVar, adVar);
    }
}
