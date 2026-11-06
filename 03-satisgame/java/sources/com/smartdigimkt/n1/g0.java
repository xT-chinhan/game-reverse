package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.basead.ui.BaseATView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements com.smartdigimkt.z.z {
    public final /* synthetic */ com.smartdigimkt.j1.w a;
    public final /* synthetic */ BaseATView b;

    public g0(BaseATView baseATView, com.smartdigimkt.j1.w wVar) {
        this.b = baseATView;
        this.a = wVar;
    }

    @Override // com.smartdigimkt.z.z
    public final void a() {
        com.smartdigimkt.b3.e eVar;
        if (this.b.f) {
            return;
        }
        com.smartdigimkt.b3.c cVar = this.b.c;
        if ((cVar instanceof com.smartdigimkt.b3.l) && ((com.smartdigimkt.b3.l) cVar).j()) {
            BaseATView baseATView = this.b;
            com.smartdigimkt.b3.c cVar2 = baseATView.c;
            if (cVar2 == null || (eVar = cVar2.w) == null || eVar.C1 != 2) {
                com.smartdigimkt.n3.k.b(1, baseATView.b, cVar2);
                return;
            }
            com.smartdigimkt.n3.k.b(2, baseATView.b, cVar2);
        }
        BaseATView baseATView2 = this.b;
        com.smartdigimkt.j1.w wVar = this.a;
        if (wVar != null) {
            e0 e0Var = baseATView2.o;
            if (e0Var != null) {
                com.smartdigimkt.b2.p pVarA = e0Var.a();
                if (pVarA != null) {
                    BaseIncentiveTaskView baseIncentiveTaskView = pVarA.j;
                    if (baseIncentiveTaskView instanceof CountDownSkipIncentiveTaskView) {
                        ((CountDownSkipIncentiveTaskView) baseIncentiveTaskView).isShowingTaskCompletedManualClaimUi();
                    }
                }
                wVar.h = null;
            }
        } else {
            baseATView2.getClass();
        }
        this.b.a(this.a);
        BaseATView baseATView3 = this.b;
        if (baseATView3.B) {
            return;
        }
        baseATView3.B = true;
        com.smartdigimkt.b3.c cVar3 = baseATView3.c;
        if ((cVar3 instanceof com.smartdigimkt.b3.l) && baseATView3.b.k == 67) {
            if (((com.smartdigimkt.b3.l) cVar3).a(true, false)) {
                com.smartdigimkt.u2.c.a(baseATView3.getContext()).a(baseATView3.c.a, 1, 0);
            }
            if (((com.smartdigimkt.b3.l) baseATView3.c).a(false, false)) {
                com.smartdigimkt.u2.b.a(baseATView3.getContext()).a(baseATView3.c.b, 1, 0);
            }
        }
    }

    @Override // com.smartdigimkt.z.z
    public final void b() {
        this.b.l();
    }

    @Override // com.smartdigimkt.z.z
    public final void c() {
        this.b.k();
    }

    @Override // com.smartdigimkt.z.z
    public final void a(boolean z) {
        com.smartdigimkt.b3.c cVar;
        com.smartdigimkt.b3.e eVar;
        if (this.b.f) {
            return;
        }
        com.smartdigimkt.b3.c cVar2 = this.b.c;
        if (!(cVar2 instanceof com.smartdigimkt.b3.l) || !((com.smartdigimkt.b3.l) cVar2).j() || (cVar = this.b.c) == null || (eVar = cVar.w) == null || eVar.C1 == 2) {
            this.b.a(z);
        }
    }

    @Override // com.smartdigimkt.z.z
    public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        return this.b.a(str, iOfferClickHandler);
    }
}
