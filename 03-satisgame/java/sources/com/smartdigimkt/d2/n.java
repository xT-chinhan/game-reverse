package com.smartdigimkt.d2;

import android.view.View;
import android.widget.Toast;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.QAIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ QAIncentiveTaskView a;

    public n(QAIncentiveTaskView qAIncentiveTaskView) {
        this.a = qAIncentiveTaskView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Toast.makeText(this.a.getContext().getApplicationContext(), com.smartdigimkt.r4.k.a(this.a.getContext(), "myoffer_inctask_qa_toast_wrong", "string"), 1).show();
        c cVar = this.a.b;
        if (cVar != null) {
            com.smartdigimkt.b2.n nVar = (com.smartdigimkt.b2.n) cVar;
            nVar.a.o = 2;
            nVar.a();
        }
    }
}
