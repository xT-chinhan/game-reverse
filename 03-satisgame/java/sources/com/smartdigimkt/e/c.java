package com.smartdigimkt.e;

import android.view.View;
import com.smartdigimkt.china.formatbusiness.ui.BubbleVibrationFallLayer;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BubbleVibrationFallLayer a;

    public c(BubbleVibrationFallLayer bubbleVibrationFallLayer) {
        this.a = bubbleVibrationFallLayer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Runnable runnable = this.a.g;
        if (runnable != null) {
            runnable.run();
        }
    }
}
