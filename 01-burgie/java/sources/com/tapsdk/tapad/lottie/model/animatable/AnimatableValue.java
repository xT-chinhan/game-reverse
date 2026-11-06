package com.tapsdk.tapad.lottie.model.animatable;

import com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation;

/* JADX INFO: loaded from: classes3.dex */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> createAnimation();
}
