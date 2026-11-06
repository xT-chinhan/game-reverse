package com.smartdigimkt.d2;

import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ BaseIncentiveTaskView a;

    public a(BaseIncentiveTaskView baseIncentiveTaskView) {
        this.a = baseIncentiveTaskView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.a.b;
        if (cVar != null) {
            ((com.smartdigimkt.b2.n) cVar).a();
        }
    }
}
