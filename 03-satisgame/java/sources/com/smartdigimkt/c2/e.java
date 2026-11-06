package com.smartdigimkt.c2;

import com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BubbleDropAnimView;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ BubbleDropAnimView a;

    public e(BubbleDropAnimView bubbleDropAnimView) {
        this.a = bubbleDropAnimView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BubbleDropAnimView bubbleDropAnimView = this.a;
        bubbleDropAnimView.e = bubbleDropAnimView.b.getMeasuredHeight();
        this.a.a();
    }
}
