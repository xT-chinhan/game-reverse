package com.tapsdk.tapad.lottie.model.animatable;

import android.graphics.PointF;
import com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.tapsdk.tapad.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
    private final AnimatableFloatValue animatableXDimension;
    private final AnimatableFloatValue animatableYDimension;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.animatableXDimension = animatableFloatValue;
        this.animatableYDimension = animatableFloatValue2;
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new SplitDimensionPathKeyframeAnimation(this.animatableXDimension.createAnimation(), this.animatableYDimension.createAnimation());
    }
}
