package com.smartdigimkt.e;

import com.smartdigimkt.china.formatbusiness.ui.BubbleVibrationFallLayer;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.c2.g {
    public final /* synthetic */ BubbleVibrationFallLayer a;

    public b(BubbleVibrationFallLayer bubbleVibrationFallLayer) {
        this.a = bubbleVibrationFallLayer;
    }

    @Override // com.smartdigimkt.c2.g
    public final void a() {
        Runnable runnable = this.a.h;
        if (runnable != null) {
            runnable.run();
        }
    }
}
