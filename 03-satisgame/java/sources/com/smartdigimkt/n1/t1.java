package com.smartdigimkt.n1;

import android.view.animation.Interpolator;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 implements Interpolator {
    public final /* synthetic */ BaseShakeView a;

    public t1(BaseShakeView baseShakeView) {
        this.a = baseShakeView;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if ((this.a.c / 2) % 3 == 0) {
            return 0.0f;
        }
        return f;
    }
}
