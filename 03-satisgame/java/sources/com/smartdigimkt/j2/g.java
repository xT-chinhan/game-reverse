package com.smartdigimkt.j2;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WebLandPageActivity a;

    public g(WebLandPageActivity webLandPageActivity) {
        this.a = webLandPageActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        WebLandPageActivity webLandPageActivity = this.a;
        if (webLandPageActivity.b == null || iIntValue % webLandPageActivity.j != 0) {
            return;
        }
        webLandPageActivity.j = webLandPageActivity.i.nextInt(12) + 3;
        this.a.b.setProgress(iIntValue);
    }
}
