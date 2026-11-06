package com.smartdigimkt.n1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;
import com.smartdigimkt.sdk.basead.ui.FullScreenHeaderPanelView;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseScreenATView a;

    public z0(BaseScreenATView baseScreenATView) {
        this.a = baseScreenATView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        FullScreenHeaderPanelView fullScreenHeaderPanelView = this.a.o0;
        if (fullScreenHeaderPanelView != null) {
            fullScreenHeaderPanelView.setAlpha(fFloatValue);
        }
    }
}
