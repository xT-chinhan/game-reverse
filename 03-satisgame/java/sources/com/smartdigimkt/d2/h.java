package com.smartdigimkt.d2;

import android.widget.TextView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.smartdigimkt.o3.b {
    public final /* synthetic */ CountDownSkipIncentiveTaskView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView, long j) {
        super(j);
        this.f = countDownSkipIncentiveTaskView;
    }

    @Override // com.smartdigimkt.o3.b
    public final void a(long j) {
        CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView = this.f;
        TextView textView = countDownSkipIncentiveTaskView.h;
        if (textView != null) {
            textView.setText(countDownSkipIncentiveTaskView.a(j));
        }
    }

    @Override // com.smartdigimkt.o3.b
    public final void a() {
        if (this.f.i()) {
            this.f.showTaskCompletedManualClaimUi();
            return;
        }
        CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView = this.f;
        if (!countDownSkipIncentiveTaskView.k) {
            countDownSkipIncentiveTaskView.k = true;
        } else {
            countDownSkipIncentiveTaskView.showTaskCompletedManualClaimUi();
        }
    }
}
