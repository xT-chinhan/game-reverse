package com.smartdigimkt.e;

import com.smartdigimkt.china.formatbusiness.ui.BubbleVibrationFallLayer;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ BubbleVibrationFallLayer a;

    public e(BubbleVibrationFallLayer bubbleVibrationFallLayer) {
        this.a = bubbleVibrationFallLayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BubbleVibrationFallLayer bubbleVibrationFallLayer = this.a;
        if (bubbleVibrationFallLayer.f) {
            return;
        }
        bubbleVibrationFallLayer.b();
    }
}
