package com.tapsdk.tapad.lottie.animation.keyframe;

import com.tapsdk.tapad.lottie.value.Keyframe;
import com.tapsdk.tapad.lottie.value.LottieFrameInfo;
import com.tapsdk.tapad.lottie.value.LottieValueCallback;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    private final LottieFrameInfo<A> frameInfo;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        super(Collections.EMPTY_LIST);
        this.frameInfo = new LottieFrameInfo<>();
        setValueCallback(lottieValueCallback);
    }

    @Override // com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation
    public float getEndProgress() {
        return 1.0f;
    }

    @Override // com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue() {
        return this.valueCallback.getValueInternal(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation
    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    @Override // com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue(Keyframe<K> keyframe, float f) {
        return getValue();
    }
}
