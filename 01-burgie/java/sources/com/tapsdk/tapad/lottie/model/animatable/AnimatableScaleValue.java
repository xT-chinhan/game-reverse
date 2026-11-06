package com.tapsdk.tapad.lottie.model.animatable;

import com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.tapsdk.tapad.lottie.animation.keyframe.ScaleKeyframeAnimation;
import com.tapsdk.tapad.lottie.value.Keyframe;
import com.tapsdk.tapad.lottie.value.ScaleXY;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {
    public AnimatableScaleValue() {
        this(new ScaleXY(1.0f, 1.0f));
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> createAnimation() {
        return new ScaleKeyframeAnimation(this.keyframes);
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableScaleValue(ScaleXY scaleXY) {
        super(scaleXY);
    }

    public AnimatableScaleValue(List<Keyframe<ScaleXY>> list) {
        super((List) list);
    }
}
