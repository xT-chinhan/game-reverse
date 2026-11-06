package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.FullScreenHeaderPanelView;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;

/* JADX INFO: loaded from: classes3.dex */
public final class b3 implements View.OnClickListener {
    public final /* synthetic */ FullScreenHeaderPanelView a;

    public b3(FullScreenHeaderPanelView fullScreenHeaderPanelView) {
        this.a = fullScreenHeaderPanelView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        d3 d3Var;
        FullScreenHeaderPanelView fullScreenHeaderPanelView = this.a;
        com.smartdigimkt.b3.e eVar = fullScreenHeaderPanelView.h;
        if (eVar != null) {
            if (eVar.e != 1) {
                d3 d3Var2 = fullScreenHeaderPanelView.i;
                if (d3Var2 != null) {
                    ((a3) d3Var2).a.a(1, 23);
                    return;
                }
                return;
            }
            ScanningAnimButton scanningAnimButton = fullScreenHeaderPanelView.d;
            if (scanningAnimButton == null || view != scanningAnimButton || (d3Var = fullScreenHeaderPanelView.i) == null) {
                return;
            }
            ((a3) d3Var).a.a(1, 23);
        }
    }
}
