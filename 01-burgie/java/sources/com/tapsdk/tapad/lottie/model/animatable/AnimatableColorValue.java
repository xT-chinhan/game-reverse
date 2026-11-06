package com.tapsdk.tapad.lottie.model.animatable;

import com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.tapsdk.tapad.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.tapsdk.tapad.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatableColorValue extends BaseAnimatableValue<Integer, Integer> {
    public AnimatableColorValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new ColorKeyframeAnimation(this.keyframes);
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
