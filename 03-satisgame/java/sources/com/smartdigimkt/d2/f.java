package com.smartdigimkt.d2;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ CountDownSkipIncentiveTaskView a;

    public f(CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView) {
        this.a = countDownSkipIncentiveTaskView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c cVar = this.a.b;
        if (cVar != null) {
            ((com.smartdigimkt.b2.n) cVar).a();
        }
    }
}
