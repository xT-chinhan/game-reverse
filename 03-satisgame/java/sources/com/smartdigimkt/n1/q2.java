package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.EndCardView;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;

/* JADX INFO: loaded from: classes3.dex */
public final class q2 implements View.OnClickListener {
    public final /* synthetic */ EndCardView a;

    public q2(EndCardView endCardView) {
        this.a = endCardView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p0 p0Var;
        EndCardView endCardView = this.a;
        com.smartdigimkt.b3.e eVar = endCardView.c;
        if (eVar != null) {
            if (eVar.e == 0) {
                int i = view != endCardView.i ? 7 : 6;
                p0 p0Var2 = endCardView.mListener;
                if (p0Var2 != null) {
                    p0Var2.a(i);
                    return;
                }
                return;
            }
            ScanningAnimButton scanningAnimButton = endCardView.i;
            if (scanningAnimButton == null || view != scanningAnimButton || scanningAnimButton.getVisibility() != 0 || (p0Var = this.a.mListener) == null) {
                return;
            }
            p0Var.a(6);
        }
    }
}
