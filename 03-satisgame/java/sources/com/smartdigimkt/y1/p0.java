package com.smartdigimkt.y1;

import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PicVerifyG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements Runnable {
    public final /* synthetic */ q0 a;

    public p0(q0 q0Var) {
        this.a = q0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((RelativeLayout.LayoutParams) this.a.b.i.getLayoutParams()).setMargins(0, (this.a.a / 2) + (this.a.b.getMeasuredHeight() / 2), 0, 0);
        this.a.b.i.setVisibility(0);
        PicVerifyG2CV2View.a(this.a.b);
    }
}
