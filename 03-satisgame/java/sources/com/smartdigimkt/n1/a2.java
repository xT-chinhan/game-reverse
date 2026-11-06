package com.smartdigimkt.n1;

import android.view.animation.Interpolator;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;

/* JADX INFO: loaded from: classes3.dex */
public final class a2 implements Interpolator {
    public final /* synthetic */ BaseShakeView a;

    public a2(BaseShakeView baseShakeView) {
        this.a = baseShakeView;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (this.a.c % 3 == 2) {
            return 0.0f;
        }
        return f;
    }
}
