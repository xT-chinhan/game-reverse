package com.tapsdk.tapad.lottie.animation.keyframe;

import com.tapsdk.tapad.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class KeyframeAnimation<T> extends BaseKeyframeAnimation<T, T> {
    public KeyframeAnimation(List<? extends Keyframe<T>> list) {
        super(list);
    }
}
