package com.smartdigimkt.d2;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ CountDownSkipIncentiveTaskView a;

    public i(CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView) {
        this.a = countDownSkipIncentiveTaskView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.f();
    }
}
