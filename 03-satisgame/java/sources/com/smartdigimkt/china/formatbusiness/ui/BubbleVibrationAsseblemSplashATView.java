package com.smartdigimkt.china.formatbusiness.ui;

import android.content.Context;
import android.view.View;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.e.q;
import com.smartdigimkt.sdk.R;
import com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class BubbleVibrationAsseblemSplashATView extends AsseblemSplashATView {
    public static final /* synthetic */ int r0 = 0;
    public Runnable q0;

    public BubbleVibrationAsseblemSplashATView(Context context, a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public final void a(int i, boolean z) {
        a aVar = this.b;
        if (aVar != null && c0.b(aVar)) {
            q.b(this);
        }
        super.a(i, z);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        v();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        q.a(this, this.q0);
        q.a(getContext());
        BubbleVibrationFallLayer bubbleVibrationFallLayer = null;
        this.q0 = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt instanceof BubbleVibrationFallLayer) {
                bubbleVibrationFallLayer = (BubbleVibrationFallLayer) childAt;
                break;
            }
        }
        if (bubbleVibrationFallLayer != null) {
            bubbleVibrationFallLayer.release();
            removeView(bubbleVibrationFallLayer);
        }
        super.onDetachedFromWindow();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            v();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            v();
            return;
        }
        a aVar = this.b;
        if (aVar != null && c0.b(aVar)) {
            q.b(this);
        }
        q.a(getContext());
    }

    @Override // com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void s() {
        super.s();
    }

    public final void v() {
        BubbleVibrationFallLayer bubbleVibrationFallLayer;
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                bubbleVibrationFallLayer = null;
                break;
            }
            View childAt = getChildAt(childCount);
            if (childAt instanceof BubbleVibrationFallLayer) {
                bubbleVibrationFallLayer = (BubbleVibrationFallLayer) childAt;
                break;
            }
        }
        if (bubbleVibrationFallLayer == null || !bubbleVibrationFallLayer.hasEffectiveBubbleDisplay()) {
            if (bubbleVibrationFallLayer != null && !bubbleVibrationFallLayer.isBubbleStartStillPending()) {
                bubbleVibrationFallLayer.release();
                removeView(bubbleVibrationFallLayer);
                q.a(this, this.q0);
                this.q0 = null;
            }
            if (this.q0 == null || getTag(R.id.sdm_bubble_delay_runnable_tag) != this.q0) {
                q.a(this, this.q0);
                this.q0 = null;
                this.q0 = q.a(this, this.b, new com.smartdigimkt.e.a(this));
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(int i, int i2) {
        a aVar = this.b;
        if (aVar != null && c0.b(aVar)) {
            q.b(this);
        }
        super.a(i, i2);
    }
}
