package com.smartdigimkt.d2;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.QAIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ QAIncentiveTaskView a;

    public o(QAIncentiveTaskView qAIncentiveTaskView) {
        this.a = qAIncentiveTaskView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c cVar = this.a.b;
        if (cVar != null) {
            ((com.smartdigimkt.b2.n) cVar).a();
        }
    }
}
