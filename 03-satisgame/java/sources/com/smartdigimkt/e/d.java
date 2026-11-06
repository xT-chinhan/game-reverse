package com.smartdigimkt.e;

import com.smartdigimkt.china.formatbusiness.ui.BubbleVibrationFallLayer;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ BubbleVibrationFallLayer a;

    public d(BubbleVibrationFallLayer bubbleVibrationFallLayer) {
        this.a = bubbleVibrationFallLayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BubbleVibrationFallLayer bubbleVibrationFallLayer = this.a;
        String[] strArr = BubbleVibrationFallLayer.m;
        bubbleVibrationFallLayer.b();
    }
}
