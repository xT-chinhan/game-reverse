package com.smartdigimkt.h1;

import com.smartdigimkt.b2.y;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;
import com.smartdigimkt.z.z;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements z {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ k c;

    public d(k kVar, int i, int i2) {
        this.c = kVar;
        this.a = i;
        this.b = i2;
    }

    @Override // com.smartdigimkt.z.z
    public final void a() {
        if (this.c.p) {
            return;
        }
        com.smartdigimkt.b3.l lVar = this.c.b;
        if (lVar != null && lVar.j()) {
            k kVar = this.c;
            com.smartdigimkt.b3.l lVar2 = kVar.b;
            com.smartdigimkt.b3.e eVar = lVar2.w;
            if (eVar == null || eVar.C1 != 2) {
                com.smartdigimkt.n3.k.b(1, kVar.c, lVar2);
                return;
            }
            com.smartdigimkt.n3.k.b(2, kVar.c, lVar2);
        }
        k kVar2 = this.c;
        if (kVar2.f || kVar2.e == null) {
            return;
        }
        w wVar = new w();
        int i = this.a;
        int i2 = this.b;
        wVar.a = i;
        wVar.b = i2;
        k kVar3 = this.c;
        wVar.e = kVar3.c.s.F0;
        i iVar = kVar3.v;
        if (iVar != null) {
            com.smartdigimkt.b2.p pVarA = iVar.a();
            if (pVarA != null) {
                BaseIncentiveTaskView baseIncentiveTaskView = pVarA.j;
                if (baseIncentiveTaskView instanceof CountDownSkipIncentiveTaskView) {
                    ((CountDownSkipIncentiveTaskView) baseIncentiveTaskView).isShowingTaskCompletedManualClaimUi();
                }
            }
            wVar.h = null;
        }
        this.c.e.onAdClick(wVar);
    }

    @Override // com.smartdigimkt.z.z
    public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        return false;
    }

    @Override // com.smartdigimkt.z.z
    public final void b() {
        this.c.d();
    }

    @Override // com.smartdigimkt.z.z
    public final void c() {
        y yVarA = y.a();
        synchronized (yVarA.b) {
            yVarA.d = true;
        }
    }

    @Override // com.smartdigimkt.z.z
    public final void a(boolean z) {
        com.smartdigimkt.b3.e eVar;
        if (this.c.p) {
            return;
        }
        com.smartdigimkt.b3.l lVar = this.c.b;
        if (lVar == null || !lVar.j() || (eVar = this.c.b.w) == null || eVar.C1 == 2) {
            k kVar = this.c;
            if (kVar.f || kVar.e == null) {
                return;
            }
            this.c.e.onDeeplinkCallback(z);
        }
    }
}
