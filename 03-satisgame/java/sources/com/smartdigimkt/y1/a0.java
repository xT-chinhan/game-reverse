package com.smartdigimkt.y1;

import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FingerG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ BaseG2CV2View a;
    public final /* synthetic */ e0 b;

    public a0(e0 e0Var, FingerG2CV2View fingerG2CV2View) {
        this.b = e0Var;
        this.a = fingerG2CV2View;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RelativeLayout relativeLayout = this.b.d;
        if (relativeLayout == null || relativeLayout.getMeasuredHeight() <= com.smartdigimkt.r4.k.a(this.b.a, 90.0f)) {
            return;
        }
        ((FingerG2CV2View) this.a).setFingerViewMode(506);
    }
}
