package com.tapsdk.tapad.lottie.value;

import android.view.animation.Interpolator;
import com.tapsdk.tapad.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: classes3.dex */
public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    public LottieInterpolatedIntegerValue(Integer num, Integer num2) {
        super(num, num2);
    }

    @Override // com.tapsdk.tapad.lottie.value.LottieInterpolatedValue, com.tapsdk.tapad.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    public LottieInterpolatedIntegerValue(Integer num, Integer num2, Interpolator interpolator) {
        super(num, num2, interpolator);
    }

    @Override // com.tapsdk.tapad.lottie.value.LottieInterpolatedValue
    public Integer interpolateValue(Integer num, Integer num2, float f) {
        return Integer.valueOf(MiscUtils.lerp(num.intValue(), num2.intValue(), f));
    }
}
