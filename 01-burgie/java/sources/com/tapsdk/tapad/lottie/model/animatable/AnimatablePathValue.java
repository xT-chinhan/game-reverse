package com.tapsdk.tapad.lottie.model.animatable;

import android.graphics.PointF;
import com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.tapsdk.tapad.lottie.animation.keyframe.PathKeyframeAnimation;
import com.tapsdk.tapad.lottie.animation.keyframe.PointKeyframeAnimation;
import com.tapsdk.tapad.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
    private final List<Keyframe<PointF>> keyframes;

    public AnimatablePathValue() {
        this.keyframes = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return this.keyframes.get(0).isStatic() ? new PointKeyframeAnimation(this.keyframes) : new PathKeyframeAnimation(this.keyframes);
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.keyframes = list;
    }
}
