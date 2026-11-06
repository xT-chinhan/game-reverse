package com.smartdigimkt.e;

import com.smartdigimkt.china.formatbusiness.ui.RvDoubleTaskIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements Runnable {
    public final /* synthetic */ RvDoubleTaskIncentiveTaskView a;

    public j0(RvDoubleTaskIncentiveTaskView rvDoubleTaskIncentiveTaskView) {
        this.a = rvDoubleTaskIncentiveTaskView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RvDoubleTaskIncentiveTaskView rvDoubleTaskIncentiveTaskView = this.a;
        int i = RvDoubleTaskIncentiveTaskView.q;
        rvDoubleTaskIncentiveTaskView.l();
    }
}
