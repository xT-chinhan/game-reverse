package com.smartdigimkt.y1;

import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FullOrientationG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ FullOrientationG2CV2View a;
    public final /* synthetic */ e0 b;

    public b0(e0 e0Var, FullOrientationG2CV2View fullOrientationG2CV2View) {
        this.b = e0Var;
        this.a = fullOrientationG2CV2View;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e0 e0Var = this.b;
        if (e0Var.d != null) {
            int iA = com.smartdigimkt.r4.k.a(e0Var.a, 120.0f);
            int iMin = Math.min(this.b.d.getMeasuredWidth(), this.b.d.getMeasuredHeight());
            if (iMin < iA) {
                this.a.updateSize(iMin);
                this.b.e.setVisibility(0);
            }
        }
    }
}
