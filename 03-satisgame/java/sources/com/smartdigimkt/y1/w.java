package com.smartdigimkt.y1;

import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.GestureG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ GestureG2CV2View a;

    public w(GestureG2CV2View gestureG2CV2View) {
        this.a = gestureG2CV2View;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.getMeasuredWidth() < com.smartdigimkt.r4.k.a(this.a.getContext(), 182.0f)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.i.getLayoutParams();
            layoutParams.width = -1;
            this.a.i.setLayoutParams(layoutParams);
        }
        this.a.i.setVisibility(0);
    }
}
