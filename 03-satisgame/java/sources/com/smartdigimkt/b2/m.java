package com.smartdigimkt.b2;

import android.content.Context;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends CountDownSkipIncentiveTaskView {
    public final /* synthetic */ p n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(p pVar, Context context) {
        super(context);
        this.n = pVar;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final void e() {
        com.smartdigimkt.b3.e eVar;
        p pVar = this.n;
        if (pVar.c()) {
            pVar.p = true;
            pVar.m = true;
            com.smartdigimkt.a3.a aVar = pVar.c;
            if (aVar == null || (eVar = aVar.s) == null) {
                return;
            }
            com.smartdigimkt.b3.p.b(eVar.R1);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final boolean k() {
        return this.n.p;
    }
}
