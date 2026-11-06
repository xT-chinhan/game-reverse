package com.smartdigimkt.b2;

import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public final /* synthetic */ CountDownSkipIncentiveTaskView a;
    public final /* synthetic */ p b;

    public o(p pVar, CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView) {
        this.b = pVar;
        this.a = countDownSkipIncentiveTaskView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseIncentiveTaskView baseIncentiveTaskView = this.b.j;
        CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView = this.a;
        if (baseIncentiveTaskView == countDownSkipIncentiveTaskView) {
            countDownSkipIncentiveTaskView.showTaskCompletedManualClaimUi();
        }
    }
}
