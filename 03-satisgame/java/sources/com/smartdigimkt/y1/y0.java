package com.smartdigimkt.y1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PuzzleV2G2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PuzzleV2G2CV2View a;

    public y0(PuzzleV2G2CV2View puzzleV2G2CV2View) {
        this.a = puzzleV2G2CV2View;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        PuzzleV2G2CV2View puzzleV2G2CV2View = this.a;
        if (puzzleV2G2CV2View.s != iIntValue) {
            puzzleV2G2CV2View.s = iIntValue;
            puzzleV2G2CV2View.n.setProgress(iIntValue);
        }
    }
}
